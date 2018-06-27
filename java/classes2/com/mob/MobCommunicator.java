package com.mob;

import android.text.TextUtils;
import android.util.Base64;
import com.mob.commons.MobProductCollector;
import com.mob.tools.MobLog;
import com.mob.tools.RxMob;
import com.mob.tools.RxMob.QuickSubscribe;
import com.mob.tools.RxMob.Subscribable;
import com.mob.tools.RxMob.Subscriber;
import com.mob.tools.log.NLog;
import com.mob.tools.network.HttpConnection;
import com.mob.tools.network.HttpResponseCallback;
import com.mob.tools.network.KVPair;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.network.NetworkHelper.NetworkTimeOut;
import com.mob.tools.network.StringPart;
import com.mob.tools.proguard.PublicMemberKeeper;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.MobRSA;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.zip.GZIPOutputStream;

public final class MobCommunicator
  implements PublicMemberKeeper
{
  private Random a = new Random();
  private BigInteger b;
  private BigInteger c;
  private MobRSA d;
  private Hashon e;
  private NetworkHelper f;
  private NetworkHelper.NetworkTimeOut g;
  
  public MobCommunicator(int paramInt, String paramString1, String paramString2)
  {
    this.d = new MobRSA(paramInt);
    this.b = new BigInteger(paramString1, 16);
    this.c = new BigInteger(paramString2, 16);
    this.e = new Hashon();
    this.f = new NetworkHelper();
    this.g = new NetworkHelper.NetworkTimeOut();
    this.g.readTimout = 30000;
    this.g.connectionTimeout = 5000;
  }
  
  private long a(HttpConnection paramHttpConnection)
    throws Throwable
  {
    long l2 = -1L;
    paramHttpConnection = a(paramHttpConnection, "Content-Length");
    long l1 = l2;
    if (paramHttpConnection != null)
    {
      l1 = l2;
      if (paramHttpConnection.size() > 0) {
        l1 = Long.parseLong((String)paramHttpConnection.get(0));
      }
    }
    return l1;
  }
  
  private HttpResponseCallback a(final byte[] paramArrayOfByte, final String[] paramArrayOfString)
  {
    new HttpResponseCallback()
    {
      public void onResponse(HttpConnection paramAnonymousHttpConnection)
        throws Throwable
      {
        int j = paramAnonymousHttpConnection.getResponseCode();
        if (j == 200) {}
        ByteArrayOutputStream localByteArrayOutputStream;
        for (Object localObject = paramAnonymousHttpConnection.getInputStream();; localObject = paramAnonymousHttpConnection.getErrorStream())
        {
          localByteArrayOutputStream = new ByteArrayOutputStream();
          byte[] arrayOfByte = new byte['Ѐ'];
          for (int i = ((InputStream)localObject).read(arrayOfByte); i != -1; i = ((InputStream)localObject).read(arrayOfByte)) {
            localByteArrayOutputStream.write(arrayOfByte, 0, i);
          }
        }
        ((InputStream)localObject).close();
        localByteArrayOutputStream.close();
        localObject = localByteArrayOutputStream.toByteArray();
        if (j != 200)
        {
          paramAnonymousHttpConnection = MobCommunicator.a(MobCommunicator.this).fromJson(new String((byte[])localObject, "utf-8"));
          paramAnonymousHttpConnection.put("httpStatus", Integer.valueOf(j));
          throw new MobCommunicator.NetworkError(MobCommunicator.a(MobCommunicator.this).fromHashMap(paramAnonymousHttpConnection));
        }
        long l = MobCommunicator.a(MobCommunicator.this, paramAnonymousHttpConnection);
        if ((l == -1L) || (l != localObject.length))
        {
          paramAnonymousHttpConnection = new HashMap();
          paramAnonymousHttpConnection.put("httpStatus", Integer.valueOf(j));
          paramAnonymousHttpConnection.put("status", Integer.valueOf(-2));
          paramAnonymousHttpConnection.put("error", "Illegal content length");
          throw new MobCommunicator.NetworkError(MobCommunicator.a(MobCommunicator.this).fromHashMap(paramAnonymousHttpConnection));
        }
        paramArrayOfString[0] = MobCommunicator.a(MobCommunicator.this, paramArrayOfByte, (byte[])localObject);
      }
    };
  }
  
  private Object a(String paramString)
    throws Throwable
  {
    if (paramString == null)
    {
      paramString = new HashMap();
      paramString.put("status", Integer.valueOf(-1));
      paramString.put("error", "response is empty");
      throw new NetworkError(this.e.fromHashMap(paramString));
    }
    paramString = this.e.fromJson(paramString.trim());
    if (paramString.isEmpty())
    {
      paramString = new HashMap();
      paramString.put("status", Integer.valueOf(-1));
      paramString.put("error", "response is empty");
      throw new NetworkError(this.e.fromHashMap(paramString));
    }
    return paramString.get("res");
  }
  
  private String a(byte[] paramArrayOfByte, String paramString, boolean paramBoolean)
    throws Throwable
  {
    Object localObject = paramString.getBytes("utf-8");
    paramString = (String)localObject;
    if (paramBoolean) {
      paramString = a((byte[])localObject);
    }
    localObject = new ByteArrayOutputStream();
    DataOutputStream localDataOutputStream = new DataOutputStream((OutputStream)localObject);
    byte[] arrayOfByte = this.d.encode(paramArrayOfByte, this.b, this.c);
    localDataOutputStream.writeInt(arrayOfByte.length);
    localDataOutputStream.write(arrayOfByte);
    paramArrayOfByte = Data.AES128Encode(paramArrayOfByte, paramString);
    localDataOutputStream.writeInt(paramArrayOfByte.length);
    localDataOutputStream.write(paramArrayOfByte);
    localDataOutputStream.flush();
    localDataOutputStream.close();
    return Base64.encodeToString(((ByteArrayOutputStream)localObject).toByteArray(), 2);
  }
  
  private String a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    throws Throwable
  {
    return new String(Data.AES128Decode(paramArrayOfByte1, Base64.decode(paramArrayOfByte2, 2)), "utf-8");
  }
  
  private ArrayList<KVPair<String>> a(String paramString, int paramInt)
    throws Throwable
  {
    if (TextUtils.isEmpty(MobSDK.getAppSecret())) {
      throw new SecurityException("App secret should not be null");
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new KVPair("sign", Data.MD5(paramString + MobSDK.getAppSecret())));
    localArrayList.add(new KVPair("key", MobSDK.getAppkey()));
    localArrayList.add(new KVPair("Content-Length", String.valueOf(paramInt)));
    localArrayList.add(new KVPair("User-Identity", MobProductCollector.getUserIdentity()));
    return localArrayList;
  }
  
  private List<String> a(HttpConnection paramHttpConnection, String paramString)
    throws Throwable
  {
    paramHttpConnection = paramHttpConnection.getHeaderFields();
    if ((paramHttpConnection != null) && (!paramHttpConnection.isEmpty()))
    {
      Iterator localIterator = paramHttpConnection.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if ((str != null) && (str.equals(paramString))) {
          return (List)paramHttpConnection.get(str);
        }
      }
    }
    return null;
  }
  
  private byte[] a()
    throws Throwable
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    DataOutputStream localDataOutputStream = new DataOutputStream(localByteArrayOutputStream);
    this.a.setSeed(System.currentTimeMillis());
    localDataOutputStream.writeLong(this.a.nextLong());
    localDataOutputStream.writeLong(this.a.nextLong());
    localDataOutputStream.flush();
    localDataOutputStream.close();
    return localByteArrayOutputStream.toByteArray();
  }
  
  private byte[] a(byte[] paramArrayOfByte)
    throws Throwable
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream(new GZIPOutputStream(localByteArrayOutputStream));
    localBufferedOutputStream.write(paramArrayOfByte);
    localBufferedOutputStream.flush();
    localBufferedOutputStream.close();
    return localByteArrayOutputStream.toByteArray();
  }
  
  public <T> void request(final HashMap<String, Object> paramHashMap, final String paramString, final boolean paramBoolean, final Callback<T> paramCallback)
  {
    RxMob.create(new RxMob.QuickSubscribe()
    {
      protected void doNext(RxMob.Subscriber<T> paramAnonymousSubscriber)
        throws Throwable
      {
        paramAnonymousSubscriber.onNext(MobCommunicator.this.requestSynchronized(paramHashMap, paramString, paramBoolean));
      }
    }).subscribeOnNewThreadAndObserveOnUIThread(new RxMob.Subscriber()
    {
      public void onError(Throwable paramAnonymousThrowable)
      {
        paramCallback.onResultError(paramAnonymousThrowable);
      }
      
      public void onNext(T paramAnonymousT)
      {
        paramCallback.onResultOk(paramAnonymousT);
      }
    });
  }
  
  public <T> T requestSynchronized(String paramString1, String paramString2, boolean paramBoolean)
    throws Throwable
  {
    Object localObject = a();
    String str = a((byte[])localObject, paramString1, paramBoolean);
    ArrayList localArrayList = a(paramString1, str.getBytes("utf-8").length);
    String[] arrayOfString = new String[1];
    localObject = a((byte[])localObject, arrayOfString);
    StringPart localStringPart = new StringPart();
    localStringPart.append(str);
    MobLog.getInstance().d(">>>  request: " + paramString1 + "\nurl = " + paramString2 + "\nheader = " + localArrayList.toString(), new Object[0]);
    this.f.rawPost(paramString2, localArrayList, localStringPart, -1, (HttpResponseCallback)localObject, this.g);
    if (arrayOfString[0] != null)
    {
      MobLog.getInstance().d(">>> response: " + arrayOfString[0], new Object[0]);
      return (T)a(arrayOfString[0]);
    }
    return null;
  }
  
  public <T> T requestSynchronized(HashMap<String, Object> paramHashMap, String paramString, boolean paramBoolean)
    throws Throwable
  {
    if (paramHashMap == null) {
      paramHashMap = "{}";
    }
    for (;;)
    {
      return (T)requestSynchronized(paramHashMap, paramString, paramBoolean);
      String str = this.e.fromHashMap(paramHashMap);
      paramHashMap = str;
      if (str.length() == 0) {
        paramHashMap = "{}";
      }
    }
  }
  
  public static class Callback<T>
    implements PublicMemberKeeper
  {
    public void onResultError(Throwable paramThrowable) {}
    
    public void onResultOk(T paramT) {}
  }
  
  public static class NetworkError
    extends Exception
    implements PublicMemberKeeper
  {
    private static final long serialVersionUID = -8447657431687664787L;
    
    public NetworkError(String paramString)
    {
      super();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mob/MobCommunicator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */