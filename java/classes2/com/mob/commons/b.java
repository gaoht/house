package com.mob.commons;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import com.mob.MobSDK;
import com.mob.commons.authorize.DeviceAuthorizer;
import com.mob.tools.MobHandlerThread;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.network.KVPair;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.network.NetworkHelper.NetworkTimeOut;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.FileLocker;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.MobRSA;
import com.mob.tools.utils.ResHelper;
import com.mob.tools.utils.SQLiteHelper;
import com.mob.tools.utils.SQLiteHelper.SingleTableDB;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.zip.GZIPOutputStream;

public class b
  implements Handler.Callback
{
  private static b a;
  private Handler b = MobHandlerThread.newHandler("d", this);
  private SQLiteHelper.SingleTableDB c;
  private Hashon d = new Hashon();
  private Random e = new Random();
  private boolean f = true;
  
  private b()
  {
    b();
    c();
  }
  
  private int a(String[][] paramArrayOfString)
  {
    int i = 0;
    int j = i;
    Cursor localCursor;
    try
    {
      localCursor = SQLiteHelper.query(b(), new String[] { "time", "data" }, null, null, null);
      if (localCursor == null) {
        return 0;
      }
      j = i;
      if (localCursor.moveToFirst()) {
        break label71;
      }
      j = i;
      localCursor.close();
      return 0;
    }
    catch (Throwable paramArrayOfString) {}
    MobLog.getInstance().w(paramArrayOfString);
    return j;
    label71:
    j = i;
    long l3 = a.a();
    i = 0;
    try
    {
      label80:
      arrayOfString = new String[2];
      arrayOfString[0] = localCursor.getString(0);
      arrayOfString[1] = localCursor.getString(1);
      l1 = -1L;
    }
    catch (Throwable paramArrayOfString)
    {
      String[] arrayOfString;
      long l1;
      long l2;
      label128:
      j = i;
    }
    try
    {
      l2 = Long.parseLong(arrayOfString[0]);
      l1 = l2;
    }
    catch (Throwable localThrowable)
    {
      break label128;
    }
    if (l1 <= l3)
    {
      paramArrayOfString[i] = arrayOfString;
      i += 1;
    }
    for (;;)
    {
      j = i;
      if (i < paramArrayOfString.length)
      {
        j = i;
        if (localCursor.moveToNext()) {}
      }
      else
      {
        j = i;
        localCursor.close();
        return i;
        break;
      }
      break label80;
    }
  }
  
  public static b a()
  {
    try
    {
      if (a == null) {
        a = new b();
      }
      b localb = a;
      return localb;
    }
    finally {}
  }
  
  private String a(String paramString)
    throws Throwable
  {
    Object localObject1 = new ByteArrayOutputStream();
    Object localObject2 = new DataOutputStream((OutputStream)localObject1);
    ((DataOutputStream)localObject2).writeLong(this.e.nextLong());
    ((DataOutputStream)localObject2).writeLong(this.e.nextLong());
    ((DataOutputStream)localObject2).flush();
    ((DataOutputStream)localObject2).close();
    localObject1 = ((ByteArrayOutputStream)localObject1).toByteArray();
    localObject2 = new ByteArrayOutputStream();
    Object localObject3 = new BufferedOutputStream(new GZIPOutputStream((OutputStream)localObject2));
    ((BufferedOutputStream)localObject3).write(paramString.getBytes("utf-8"));
    ((BufferedOutputStream)localObject3).flush();
    ((BufferedOutputStream)localObject3).close();
    paramString = Data.AES128Encode((byte[])localObject1, ((ByteArrayOutputStream)localObject2).toByteArray());
    localObject1 = new MobRSA(1024).encode((byte[])localObject1, new BigInteger("ceeef5035212dfe7c6a0acdc0ef35ce5b118aab916477037d7381f85c6b6176fcf57b1d1c3296af0bb1c483fe5e1eb0ce9eb2953b44e494ca60777a1b033cc07", 16), new BigInteger("191737288d17e660c4b61440d5d14228a0bf9854499f9d68d8274db55d6d954489371ecf314f26bec236e58fac7fffa9b27bcf923e1229c4080d49f7758739e5bd6014383ed2a75ce1be9b0ab22f283c5c5e11216c5658ba444212b6270d629f2d615b8dfdec8545fb7d4f935b0cc10b6948ab4fc1cb1dd496a8f94b51e888dd", 16));
    localObject2 = new ByteArrayOutputStream();
    localObject3 = new DataOutputStream((OutputStream)localObject2);
    ((DataOutputStream)localObject3).writeInt(localObject1.length);
    ((DataOutputStream)localObject3).write((byte[])localObject1);
    ((DataOutputStream)localObject3).writeInt(paramString.length);
    ((DataOutputStream)localObject3).write(paramString);
    ((DataOutputStream)localObject3).flush();
    ((DataOutputStream)localObject3).close();
    return Base64.encodeToString(((ByteArrayOutputStream)localObject2).toByteArray(), 2);
  }
  
  private boolean a(String[][] paramArrayOfString, int paramInt)
  {
    boolean bool2;
    do
    {
      try
      {
        localObject1 = new HashMap();
        Object localObject3 = DeviceHelper.getInstance(MobSDK.getContext());
        ((HashMap)localObject1).put("plat", Integer.valueOf(((DeviceHelper)localObject3).getPlatformCode()));
        ((HashMap)localObject1).put("device", ((DeviceHelper)localObject3).getDeviceKey());
        ((HashMap)localObject1).put("mac", ((DeviceHelper)localObject3).getMacAddress());
        ((HashMap)localObject1).put("model", ((DeviceHelper)localObject3).getModel());
        ((HashMap)localObject1).put("duid", DeviceAuthorizer.authorize(null));
        ((HashMap)localObject1).put("imei", ((DeviceHelper)localObject3).getIMEI());
        ((HashMap)localObject1).put("serialno", ((DeviceHelper)localObject3).getSerialno());
        ((HashMap)localObject1).put("networktype", ((DeviceHelper)localObject3).getDetailNetworkTypeForStatic());
        localObject2 = new ArrayList();
        localObject3 = Data.rawMD5(((DeviceHelper)localObject3).getManufacturer());
        int i = 0;
        for (;;)
        {
          if (i < paramInt)
          {
            Object localObject4 = paramArrayOfString[i];
            try
            {
              localObject4 = new String(Data.AES128Decode((byte[])localObject3, Base64.decode(localObject4[1], 2)), "utf-8").trim();
              ((ArrayList)localObject2).add(this.d.fromJson((String)localObject4));
              i += 1;
            }
            catch (Throwable localThrowable)
            {
              for (;;)
              {
                MobLog.getInstance().w(localThrowable);
              }
            }
          }
        }
        ((HashMap)localObject1).put("datas", localObject2);
      }
      catch (Throwable paramArrayOfString)
      {
        d.e(null);
        MobLog.getInstance().w(paramArrayOfString);
        bool1 = false;
        return bool1;
      }
      paramArrayOfString = new ArrayList();
      paramArrayOfString.add(new KVPair("appkey", MobSDK.getAppkey()));
      paramArrayOfString.add(new KVPair("m", a(this.d.fromHashMap((HashMap)localObject1))));
      Object localObject1 = new ArrayList();
      ((ArrayList)localObject1).add(new KVPair("User-Identity", MobProductCollector.getUserIdentity()));
      Object localObject2 = new NetworkHelper.NetworkTimeOut();
      ((NetworkHelper.NetworkTimeOut)localObject2).readTimout = 30000;
      ((NetworkHelper.NetworkTimeOut)localObject2).connectionTimeout = 30000;
      paramArrayOfString = new NetworkHelper().httpPost(e(), paramArrayOfString, null, (ArrayList)localObject1, (NetworkHelper.NetworkTimeOut)localObject2);
      bool2 = "200".equals(String.valueOf(this.d.fromJson(paramArrayOfString).get("status")));
      boolean bool1 = bool2;
    } while (bool2);
    d.e(null);
    return bool2;
  }
  
  private SQLiteHelper.SingleTableDB b()
  {
    try
    {
      if (this.c == null)
      {
        localObject1 = ResHelper.getCacheRootFile(MobSDK.getContext(), "comm/dbs/.dh");
        if (localObject1 != null)
        {
          this.c = SQLiteHelper.getDatabase(((File)localObject1).getAbsolutePath(), "DataHeap_1");
          this.c.addField("time", "text", true);
          this.c.addField("data", "text", true);
        }
      }
      Object localObject1 = this.c;
      return (SQLiteHelper.SingleTableDB)localObject1;
    }
    finally {}
  }
  
  private void b(final long paramLong, HashMap<String, Object> paramHashMap)
  {
    NLog localNLog;
    StringBuilder localStringBuilder;
    if (!c.a(c.a("comm/locks/.dhlock"), new LockAction()
    {
      public boolean run(FileLocker paramAnonymousFileLocker)
      {
        try
        {
          paramAnonymousFileLocker = new ContentValues();
          paramAnonymousFileLocker.put("time", String.valueOf(paramLong));
          paramAnonymousFileLocker.put("data", Base64.encodeToString(Data.AES128Encode(Data.rawMD5(DeviceHelper.getInstance(MobSDK.getContext()).getManufacturer()), b.a(b.this).fromHashMap(this.b).getBytes("utf-8")), 2));
          SQLiteHelper.insert(b.b(b.this), paramAnonymousFileLocker);
          return false;
        }
        catch (Throwable paramAnonymousFileLocker)
        {
          for (;;)
          {
            MobLog.getInstance().w(paramAnonymousFileLocker);
          }
        }
      }
    }))
    {
      localNLog = MobLog.getInstance();
      localStringBuilder = new StringBuilder().append("DataHeap add log error data type = ");
      if (paramHashMap != null) {
        break label81;
      }
    }
    label81:
    for (paramHashMap = null;; paramHashMap = paramHashMap.get("type"))
    {
      localNLog.e(new Throwable(paramHashMap + ", updateTime = " + paramLong));
      return;
    }
  }
  
  private void b(String[][] paramArrayOfString, int paramInt)
  {
    int i = 0;
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      while (i < paramInt)
      {
        String[] arrayOfString = paramArrayOfString[i];
        if (localStringBuilder.length() > 0) {
          localStringBuilder.append(", ");
        }
        localStringBuilder.append('\'').append(arrayOfString[0]).append('\'');
        i += 1;
      }
      SQLiteHelper.delete(b(), "time in (" + localStringBuilder.toString() + ")", null);
      return;
    }
    catch (Throwable paramArrayOfString)
    {
      MobLog.getInstance().w(paramArrayOfString);
    }
  }
  
  private void c()
  {
    this.b.removeMessages(1);
    long l2 = a.F();
    Object localObject = DeviceHelper.getInstance(MobSDK.getContext());
    long l1 = l2;
    if (localObject != null)
    {
      localObject = ((DeviceHelper)localObject).getNetworkType();
      if (localObject != null)
      {
        l1 = l2;
        if (!"none".equals(localObject)) {}
      }
      else
      {
        l1 = 600000L;
      }
    }
    this.b.sendEmptyMessageDelayed(1, l1);
  }
  
  private boolean d()
  {
    if (a.D()) {}
    boolean bool;
    do
    {
      return true;
      Object localObject = DeviceHelper.getInstance(MobSDK.getContext());
      if (localObject == null) {
        return false;
      }
      localObject = ((DeviceHelper)localObject).getNetworkType();
      if ((localObject == null) || ("none".equals(localObject))) {
        return false;
      }
      this.f = true;
      bool = c.a(c.a("comm/locks/.dhlock"), new LockAction()
      {
        public boolean run(FileLocker paramAnonymousFileLocker)
        {
          paramAnonymousFileLocker = new String[50][];
          for (int i = b.a(b.this, paramAnonymousFileLocker);; i = b.a(b.this, paramAnonymousFileLocker))
          {
            if (i > 0)
            {
              if (b.a(b.this, paramAnonymousFileLocker, i))
              {
                b.b(b.this, paramAnonymousFileLocker, i);
                if (i >= paramAnonymousFileLocker.length) {
                  continue;
                }
              }
            }
            else {
              return false;
            }
            b.a(b.this, false);
            return false;
          }
        }
      });
    } while ((this.f) && (bool));
    return false;
  }
  
  private static String e()
  {
    Object localObject1 = null;
    try
    {
      localObject2 = d.h();
      localObject1 = localObject2;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Object localObject2;
        MobLog.getInstance().w(localThrowable);
      }
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = "http://c.data.mob.com/v3/cdata";
    }
    return (String)localObject2;
  }
  
  public void a(long paramLong, HashMap<String, Object> paramHashMap)
  {
    try
    {
      Message localMessage = new Message();
      localMessage.what = 2;
      localMessage.obj = new Object[] { Long.valueOf(paramLong), paramHashMap };
      this.b.sendMessage(localMessage);
      MobLog.getInstance().i("pushData\n>>> " + paramHashMap, new Object[0]);
      return;
    }
    finally
    {
      paramHashMap = finally;
      throw paramHashMap;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    long l;
    do
    {
      do
      {
        return false;
      } while (d());
      c();
      return false;
      paramMessage = (Object[])paramMessage.obj;
      l = ((Long)ResHelper.forceCast(paramMessage[0], Long.valueOf(-1L))).longValue();
    } while (l <= 0L);
    b(l, (HashMap)paramMessage[1]);
    c();
    return false;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mob/commons/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */