package com.growingio.android.sdk.collection;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import com.growingio.android.sdk.utils.HttpService;
import com.growingio.android.sdk.utils.HttpService.Builder;
import com.growingio.android.sdk.utils.LogUtil;
import com.growingio.android.sdk.utils.Util;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MessageUploader
{
  private AtomicInteger a = new AtomicInteger(0);
  private AtomicInteger b = new AtomicInteger(0);
  private Handler c;
  private GConfig d;
  private Map<String, String> e = new HashMap();
  
  MessageUploader(Context paramContext)
  {
    this.e.put("vst", "visit");
    this.e.put("clck", "click");
    paramContext = new HandlerThread("GIO.MessageUploader", 1);
    paramContext.start();
    this.c = new MessageUploaderHandler(paramContext.getLooper());
    this.c.post(new Runnable()
    {
      public void run()
      {
        HttpService.a = HttpsURLConnection.getDefaultSSLSocketFactory();
      }
    });
    this.d = GConfig.s();
    this.c.obtainMessage(2).sendToTarget();
  }
  
  private String a(String paramString)
  {
    String str = (String)this.e.get(paramString);
    if (str == null) {
      return paramString;
    }
    return str;
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt > this.d.n()) || (this.d.l());
  }
  
  private AppState c()
  {
    return AppState.l();
  }
  
  private void d()
  {
    this.c.removeMessages(0);
    this.c.sendEmptyMessage(0);
  }
  
  private void e()
  {
    if (!this.c.hasMessages(0)) {
      this.c.sendEmptyMessageDelayed(0, this.d.o());
    }
  }
  
  private void f()
  {
    if (!this.c.hasMessages(1)) {
      this.c.sendEmptyMessageDelayed(1, this.d.o());
    }
  }
  
  DBAdapter a()
  {
    DBAdapter localDBAdapter2 = DBAdapter.a();
    DBAdapter localDBAdapter1 = localDBAdapter2;
    if (localDBAdapter2 == null)
    {
      DBAdapter.a(c().k());
      localDBAdapter1 = DBAdapter.a();
    }
    return localDBAdapter1;
  }
  
  void a(boolean paramBoolean, int paramInt)
  {
    if ((this.d.y()) && (paramBoolean)) {
      if (a(this.a.addAndGet(paramInt)))
      {
        b();
        LogUtil.d("GIO.MessageUploader", new Object[] { "instant event saved: ", Integer.valueOf(paramInt), "/", Integer.valueOf(this.a.get()), "  flush data now" });
      }
    }
    for (;;)
    {
      if (GrowingIO.testHandler != null) {
        Util.a(GrowingIO.testHandler, 4194304, new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), Integer.valueOf(this.a.get()), Integer.valueOf(this.b.get()) });
      }
      return;
      f();
      LogUtil.d("GIO.MessageUploader", new Object[] { "instant event saved: ", Integer.valueOf(paramInt), "/", Integer.valueOf(this.a.get()), "  flush data later" });
      continue;
      if (a(this.a.get() + this.b.addAndGet(paramInt)))
      {
        d();
        LogUtil.d("GIO.MessageUploader", new Object[] { "non-instant event saved: ", Integer.valueOf(paramInt), "/", Integer.valueOf(this.a.get()), "  flush data now" });
      }
      else
      {
        e();
        LogUtil.d("GIO.MessageUploader", new Object[] { "non-instant event saved: ", Integer.valueOf(paramInt), "/", Integer.valueOf(this.a.get()), "  flush data later" });
      }
    }
  }
  
  public void b()
  {
    this.c.removeMessages(1);
    this.c.sendEmptyMessage(1);
    DiagnoseLog.a();
  }
  
  private class MessageUploaderHandler
    extends Handler
  {
    MessageUploaderHandler(Looper paramLooper)
    {
      super();
    }
    
    @TargetApi(9)
    private int a(MessageUploader.UPLOAD_TYPE paramUPLOAD_TYPE, List<String> paramList)
    {
      if (GrowingIO.testHandler != null) {
        Util.a(GrowingIO.testHandler, 4194305, new Object[] { paramUPLOAD_TYPE.name(), paramList });
      }
      Object localObject3 = new JSONArray();
      int i = 0;
      int k = 0;
      int j = 0;
      HashMap localHashMap = new HashMap();
      Object localObject1 = AppState.l().c();
      if (paramUPLOAD_TYPE != MessageUploader.UPLOAD_TYPE.a)
      {
        if (!com.growingio.android.sdk.circle.c.e().a()) {
          break label839;
        }
        localObject1 = AppState.l().d();
      }
      label320:
      label341:
      label414:
      label441:
      label833:
      label839:
      for (;;)
      {
        Object localObject4 = Locale.US;
        Object localObject5 = NetworkConfig.a().c();
        if (paramUPLOAD_TYPE == MessageUploader.UPLOAD_TYPE.b)
        {
          paramUPLOAD_TYPE = "pv";
          paramUPLOAD_TYPE = String.format((Locale)localObject4, "%s/%s/android/%s?stm=%d", new Object[] { localObject5, localObject1, paramUPLOAD_TYPE, Long.valueOf(System.currentTimeMillis()) });
        }
        for (;;)
        {
          String str;
          Integer localInteger;
          try
          {
            localObject4 = paramList.iterator();
            i = j;
            if (!((Iterator)localObject4).hasNext()) {
              break label441;
            }
            i = j;
            localObject5 = new JSONObject((String)((Iterator)localObject4).next());
            i = j;
            str = ((JSONObject)localObject5).optString("t");
            i = j;
            if (!"imp".equals(str))
            {
              i = j;
              if (!"clck".equals(str)) {
                break label833;
              }
            }
            i = j;
            k = ((JSONObject)localObject5).getJSONArray("e").length();
            j += k;
            i = j;
            str = MessageUploader.a(MessageUploader.this, str) + "u";
            i = j;
            localInteger = (Integer)localHashMap.get(str);
            if (localInteger != null) {
              break label414;
            }
            i = j;
            localHashMap.put(str, Integer.valueOf(k));
            i = j;
            ((JSONArray)localObject3).put(localObject5);
            continue;
            localJSONObject = new JSONObject();
          }
          catch (JSONException localJSONException2)
          {
            DiagnoseLog.a("jsonu");
          }
          JSONObject localJSONObject;
          localJSONObject.put("ai", localObject1);
          localJSONObject.put("u", MessageUploader.b(MessageUploader.this).m().a());
          localJSONObject.put("l", localObject3);
          localObject1 = localJSONObject.toString();
          for (;;)
          {
            if (((JSONArray)localObject3).length() == 0)
            {
              return 0;
              paramUPLOAD_TYPE = "action";
              break;
              i = j;
              localHashMap.put(str, Integer.valueOf(localInteger.intValue() + k));
              break label320;
              i = j;
              break label341;
              paramUPLOAD_TYPE = String.format(Locale.US, "%s/%s/android/events?stm=%d", new Object[] { NetworkConfig.a().d(), localObject1, Long.valueOf(System.currentTimeMillis()) });
              try
              {
                localObject1 = paramList.iterator();
                while (((Iterator)localObject1).hasNext())
                {
                  localJSONObject = new JSONObject((String)((Iterator)localObject1).next());
                  localJSONObject.put("u", MessageUploader.b(MessageUploader.this).m().a());
                  ((JSONArray)localObject3).put(localJSONObject);
                }
              }
              catch (JSONException localJSONException1)
              {
                DiagnoseLog.a("jsonu");
                localObject2 = ((JSONArray)localObject3).toString();
                i = k;
              }
            }
          }
          localObject3 = com.growingio.android.sdk.b.c.a(((String)localObject2).getBytes(Charset.forName("UTF-8")));
          if (GConfig.DEBUG) {
            LogUtil.d("GIO.MessageUploader", new Object[] { "uploading ", localObject2 });
          }
          DiagnoseLog.a("request");
          Object localObject2 = new HashMap();
          ((Map)localObject2).put("Content-Type", "text/plain");
          if (GConfig.s().k()) {
            ((Map)localObject2).put("X-GrowingIO-UID", MessageUploader.b(MessageUploader.this).m().a());
          }
          if (((Integer)new HttpService.Builder().a(paramUPLOAD_TYPE).b("POST").a((Map)localObject2).a((byte[])localObject3).a().b().first).intValue() == 200)
          {
            if (GrowingIO.testHandler != null) {
              Util.a(GrowingIO.testHandler, 4194306, new Object[] { paramList });
            }
            DiagnoseLog.a("success");
            DiagnoseLog.a("upload", i);
            if (localHashMap.size() > 0)
            {
              paramUPLOAD_TYPE = localHashMap.entrySet().iterator();
              while (paramUPLOAD_TYPE.hasNext())
              {
                paramList = (Map.Entry)paramUPLOAD_TYPE.next();
                DiagnoseLog.a((String)paramList.getKey(), ((Integer)paramList.getValue()).intValue());
              }
            }
            return localObject3.length;
          }
          return 0;
          k = 1;
        }
      }
    }
    
    private void a()
    {
      if (b()) {
        MessageUploader.d(MessageUploader.this).set(0);
      }
      if (a(MessageUploader.UPLOAD_TYPE.d)) {
        MessageUploader.e(MessageUploader.this).set(0);
      }
    }
    
    @TargetApi(11)
    private boolean a(MessageUploader.UPLOAD_TYPE paramUPLOAD_TYPE)
    {
      localObject1 = null;
      l1 = 0L;
      int i = 0;
      int k = MessageUploader.b(MessageUploader.this).p();
      localDBAdapter = MessageUploader.this.a();
      for (;;)
      {
        try
        {
          localObject4 = localDBAdapter.a(paramUPLOAD_TYPE);
          localObject1 = localObject4;
          if (localObject1 != null)
          {
            l5 = l1;
            l2 = l1;
            localObject4 = localObject1;
            l3 = l1;
            localObject7 = localObject1;
            l4 = l1;
            localObject8 = localObject1;
          }
        }
        catch (Exception localException2)
        {
          Object localObject4;
          long l5;
          long l2;
          long l3;
          long l4;
          int j;
          Object localObject5;
          Object localObject2;
          Object localObject8 = localObject3;
          continue;
        }
        catch (SQLiteCantOpenDatabaseException localSQLiteCantOpenDatabaseException2)
        {
          Object localObject7 = localObject3;
          continue;
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          Object localObject3;
          Object localObject6 = localObject3;
          continue;
        }
        catch (JSONException localJSONException2)
        {
          continue;
          continue;
        }
        try
        {
          j = a(paramUPLOAD_TYPE, (List)((Pair)localObject1).second);
          if (j <= 0) {
            continue;
          }
          l5 = l1;
          l2 = l1;
          localObject4 = localObject1;
          l3 = l1;
          localObject7 = localObject1;
          l4 = l1;
          localObject8 = localObject1;
          l1 = localDBAdapter.a(paramUPLOAD_TYPE, (String)((Pair)localObject1).first);
          if (k != 1) {
            continue;
          }
          l5 = l1;
          l2 = l1;
          localObject4 = localObject1;
          l3 = l1;
          localObject7 = localObject1;
          l4 = l1;
          localObject8 = localObject1;
          GConfig.s().a(j);
        }
        catch (JSONException localJSONException1)
        {
          l1 = l5;
          l2 = l1;
          localObject5 = localObject1;
          l3 = l1;
          localObject7 = localObject1;
          l4 = l1;
          localObject8 = localObject1;
          LogUtil.d("GIO.MessageUploader", new Object[] { "generate data string error" });
          l2 = l1;
          localObject5 = localObject1;
          l3 = l1;
          localObject7 = localObject1;
          l4 = l1;
          localObject8 = localObject1;
          localDBAdapter.a(paramUPLOAD_TYPE, (String)((Pair)localObject1).first);
          continue;
        }
        catch (OutOfMemoryError localOutOfMemoryError1)
        {
          l1 = l2;
          DiagnoseLog.a("oomr");
          localObject2 = localObject5;
          l2 = l1;
          continue;
        }
        catch (SQLiteCantOpenDatabaseException localSQLiteCantOpenDatabaseException1)
        {
          l1 = l3;
          DiagnoseLog.a("dbo");
          localObject3 = localObject7;
          l2 = l1;
          continue;
        }
        catch (Exception localException1)
        {
          l1 = l4;
          DiagnoseLog.a(localException1.getClass().getSimpleName());
          if (!GConfig.DEBUG) {
            continue;
          }
          localException1.printStackTrace();
          localObject3 = localObject8;
          l2 = l1;
          continue;
        }
        l2 = l1;
        l1 = l2;
        if (l2 > 0L) {
          break;
        }
        return false;
        j = i + 1;
        i = j;
        if (j >= 2) {
          return false;
        }
      }
      return true;
    }
    
    private boolean b()
    {
      return a(MessageUploader.UPLOAD_TYPE.b) | a(MessageUploader.UPLOAD_TYPE.a) | a(MessageUploader.UPLOAD_TYPE.c);
    }
    
    private void c()
    {
      long l = (System.currentTimeMillis() - 604800000L) / 86400000L;
      MessageUploader.this.a().a(l * 86400000L);
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
      case 1: 
      case 0: 
        do
        {
          do
          {
            return;
            MessageUploader.a(MessageUploader.this).removeMessages(1);
          } while ((MessageUploader.b(MessageUploader.this).p() < 1) || (!MessageUploader.c(MessageUploader.this).y()) || (!b()));
          MessageUploader.d(MessageUploader.this).set(0);
          return;
          MessageUploader.a(MessageUploader.this).removeMessages(0);
        } while (MessageUploader.b(MessageUploader.this).p() != 2);
        a();
        return;
      }
      c();
      MessageUploader.a(MessageUploader.this).sendEmptyMessageDelayed(2, 86400000L);
    }
  }
  
  static enum UPLOAD_TYPE
  {
    private UPLOAD_TYPE() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/growingio/android/sdk/collection/MessageUploader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */