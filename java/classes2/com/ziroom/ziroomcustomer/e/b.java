package com.ziroom.ziroomcustomer.e;

import android.content.Context;
import android.os.Handler;
import com.ziroom.ziroomcustomer.util.aa;
import com.ziroom.ziroomcustomer.util.ad;
import com.ziroom.ziroomcustomer.util.k;
import com.ziroom.ziroomcustomer.util.q;
import com.ziroom.ziroomcustomer.util.u;
import java.io.IOException;
import java.security.PublicKey;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class b
{
  public static final ExecutorService a = Executors.newFixedThreadPool(5);
  
  public static <T> void getDesPostServiceDiver(final Context paramContext, final Handler paramHandler, final Map<String, Object> paramMap, String paramString, final int paramInt)
  {
    a.execute(new Runnable()
    {
      public void run()
      {
        Object localObject = k.decrypt(q.httpPost(this.a, paramMap));
        u.d("dec: ", "=== " + (String)localObject);
        localObject = a.parseDiverService(paramContext, (String)localObject);
        i.sendMessage(paramHandler, paramInt, localObject);
      }
    });
  }
  
  public static <T> void getDesPostServiceList(final Context paramContext, final Handler paramHandler, final Map<String, Object> paramMap, String paramString, final int paramInt, final Class<T> paramClass)
  {
    a.execute(new Runnable()
    {
      public void run()
      {
        Object localObject = k.decrypt(q.httpPost(this.a, paramMap));
        u.d("dec: ", "=== " + (String)localObject);
        localObject = a.parseServiceList(paramContext, (String)localObject, paramClass);
        i.sendMessage(paramHandler, paramInt, localObject);
      }
    });
  }
  
  public static <T> void getDesPostServiceObject(final Context paramContext, final Handler paramHandler, final Map<String, Object> paramMap, String paramString, final int paramInt, final Class<T> paramClass)
  {
    a.execute(new Runnable()
    {
      public void run()
      {
        Object localObject = k.decrypt(q.httpPost(this.a, paramMap));
        u.d("dec: ", "=== " + (String)localObject);
        localObject = a.parseServiceObject(paramContext, (String)localObject, paramClass);
        i.sendMessage(paramHandler, paramInt, localObject);
      }
    });
  }
  
  public static <T> void getDesPostSpList(final Context paramContext, final Handler paramHandler, final Map<String, Object> paramMap, String paramString1, final int paramInt, final Class<T> paramClass, final String paramString2)
  {
    a.execute(new Runnable()
    {
      public void run()
      {
        String str = k.decrypt(q.httpPost(this.a, paramMap));
        u.e("dec: ", str);
        l locall = a.parseServiceList(paramContext, str, paramClass);
        if (locall.getSuccess().booleanValue()) {
          ad.putOther(paramContext, paramString2, str);
        }
        i.sendMessage(paramHandler, paramInt, locall);
      }
    });
  }
  
  public static <T> void getGetServiceList(final Context paramContext, final Handler paramHandler, String paramString, final int paramInt, final Class<T> paramClass)
  {
    a.execute(new Runnable()
    {
      public void run()
      {
        Object localObject = q.httpGet(this.a);
        localObject = a.parseServiceList(paramContext, (String)localObject, paramClass);
        i.sendMessage(paramHandler, paramInt, localObject);
      }
    });
  }
  
  public static <T> void getGetServiceObject(final Context paramContext, final Handler paramHandler, String paramString, final int paramInt, final Class<T> paramClass)
  {
    a.execute(new Runnable()
    {
      public void run()
      {
        Object localObject = q.httpGet(this.a);
        localObject = a.parseServiceObject(paramContext, (String)localObject, paramClass);
        i.sendMessage(paramHandler, paramInt, localObject);
      }
    });
  }
  
  public static void getGetServiceString(final Context paramContext, final Handler paramHandler, String paramString, final int paramInt)
  {
    a.execute(new Runnable()
    {
      public void run()
      {
        Object localObject = q.httpGet(this.a);
        localObject = a.parseServiceString(paramContext, (String)localObject);
        i.sendMessage(paramHandler, paramInt, localObject);
      }
    });
  }
  
  public static <T> void getMHObject(final Context paramContext, final Handler paramHandler, final Map<String, Object> paramMap, String paramString, final int paramInt, final Class<T> paramClass)
  {
    a.execute(new Runnable()
    {
      public void run()
      {
        Object localObject = k.decrypt(q.httpPost(this.a, paramMap));
        u.e("dec: ", "=====  " + (String)localObject);
        localObject = a.parseMHObject(paramContext, (String)localObject, paramClass);
        i.sendMessage(paramHandler, paramInt, localObject);
      }
    });
  }
  
  public static <T> void getMHObjectDec(final Context paramContext, final Handler paramHandler, final Map<String, Object> paramMap, String paramString, final int paramInt, final Class<T> paramClass)
  {
    a.execute(new Runnable()
    {
      public void run()
      {
        Object localObject = q.httpPost(this.a, paramMap);
        u.e("rec: ", (String)localObject);
        localObject = a.parseMHObject(paramContext, (String)localObject, paramClass);
        i.sendMessage(paramHandler, paramInt, localObject);
      }
    });
  }
  
  public static void getMHStatus(final Context paramContext, final Handler paramHandler, final Map<String, Object> paramMap, String paramString, final int paramInt)
  {
    a.execute(new Runnable()
    {
      public void run()
      {
        Object localObject = k.decrypt(q.httpPost(this.a, paramMap));
        u.e("dec: ", (String)localObject);
        localObject = a.parseMHStatus(paramContext, (String)localObject);
        i.sendMessage(paramHandler, paramInt, localObject);
      }
    });
  }
  
  public static <T> void getMHZeroList(final Context paramContext, final Handler paramHandler, final Map<String, Object> paramMap, String paramString, final int paramInt, final Class<T> paramClass)
  {
    a.execute(new Runnable()
    {
      public void run()
      {
        Object localObject = k.decrypt(q.httpPost(this.a, paramMap));
        u.e("dec: ", (String)localObject);
        localObject = a.parseMHZeroList(paramContext, (String)localObject, paramClass);
        i.sendMessage(paramHandler, paramInt, localObject);
      }
    });
  }
  
  public static <T> void getMHZeroList(final Context paramContext, final Handler paramHandler, final Map<String, Object> paramMap, String paramString1, final int paramInt, final Class<T> paramClass, final String paramString2)
  {
    a.execute(new Runnable()
    {
      public void run()
      {
        String str = q.httpPost(this.a, paramMap);
        Object localObject = k.decrypt(str);
        u.e("dec: ", (String)localObject);
        localObject = a.parseMHZeroList(paramContext, (String)localObject, paramClass);
        if ((paramString2 != null) && (((l)localObject).getSuccess().booleanValue())) {
          ad.putOther(paramContext, paramString2, str);
        }
        i.sendMessage(paramHandler, paramInt, localObject);
      }
    });
  }
  
  public static void getNewCoupon(final Context paramContext, final Handler paramHandler, final Map<String, Object> paramMap, String paramString, final int paramInt)
  {
    a.execute(new Runnable()
    {
      public void run()
      {
        Object localObject = k.decrypt(q.httpPost(this.a, paramMap));
        u.e("dec: ", (String)localObject);
        localObject = a.parseNewCoupon(paramContext, (String)localObject);
        i.sendMessage(paramHandler, paramInt, localObject);
      }
    });
  }
  
  public static void getPostRepairAcceptConfirm(final Context paramContext, final Handler paramHandler, final Map<String, Object> paramMap, String paramString, final int paramInt)
  {
    a.execute(new Runnable()
    {
      public void run()
      {
        Object localObject = q.httpPost(this.a, paramMap);
        localObject = a.parseRepairAcceptConfirm(paramContext, (String)localObject);
        i.sendMessage(paramHandler, paramInt, localObject);
      }
    });
  }
  
  public static void getPostRepairCancle(final Context paramContext, final Handler paramHandler, final Map<String, Object> paramMap, String paramString, final int paramInt)
  {
    a.execute(new Runnable()
    {
      public void run()
      {
        Object localObject = q.httpPost(this.a, paramMap);
        localObject = a.parseGetRepairCancle(paramContext, (String)localObject);
        i.sendMessage(paramHandler, paramInt, localObject);
      }
    });
  }
  
  public static <T> void getPostRepairCancleTag(final Context paramContext, final Handler paramHandler, final Map<String, Object> paramMap, String paramString, final int paramInt)
  {
    a.execute(new Runnable()
    {
      public void run()
      {
        Object localObject = q.httpPost(this.a, paramMap);
        localObject = a.parseGetRepairCancleTag(paramContext, (String)localObject);
        i.sendMessage(paramHandler, paramInt, localObject);
      }
    });
  }
  
  public static void getPostRepairEvalInfo(final Context paramContext, final Handler paramHandler, final Map<String, Object> paramMap, String paramString, final int paramInt)
  {
    a.execute(new Runnable()
    {
      public void run()
      {
        Object localObject = q.httpPost(this.a, paramMap);
        localObject = a.parseGetRepairEvalDetail(paramContext, (String)localObject);
        i.sendMessage(paramHandler, paramInt, localObject);
      }
    });
  }
  
  public static void getPostRepairList(final Context paramContext, final Handler paramHandler, final Map<String, Object> paramMap, String paramString, final int paramInt)
  {
    a.execute(new Runnable()
    {
      public void run()
      {
        Object localObject = q.httpPost(this.a, paramMap);
        localObject = a.parseGetRepairList(paramContext, (String)localObject);
        i.sendMessage(paramHandler, paramInt, localObject);
      }
    });
  }
  
  public static void getPostRepairListDetail(final Context paramContext, final Handler paramHandler, final Map<String, Object> paramMap, String paramString, final int paramInt)
  {
    a.execute(new Runnable()
    {
      public void run()
      {
        u.d("url:", "=====  " + this.a);
        Object localObject = q.httpPost(this.a, paramMap);
        u.d("prarms:", "=====  " + (String)localObject);
        if (paramInt == 69958)
        {
          localObject = a.parseGetRepairListDetail(paramContext, (String)localObject);
          i.sendMessage(paramHandler, paramInt, localObject);
        }
        while (paramInt != 69959) {
          return;
        }
        localObject = a.parseGetRepairListExternalDetail(paramContext, (String)localObject);
        i.sendMessage(paramHandler, paramInt, localObject);
      }
    });
  }
  
  public static <T> void getPostServiceDivList(final Context paramContext, final Handler paramHandler, final Map<String, Object> paramMap, String paramString1, final int paramInt, final Class<T> paramClass, final String paramString2)
  {
    a.execute(new Runnable()
    {
      public void run()
      {
        Object localObject = q.httpPost(this.a, paramMap);
        localObject = a.parseDivServiceList(paramContext, (String)localObject, paramClass, paramString2);
        i.sendMessage(paramHandler, paramInt, localObject);
      }
    });
  }
  
  public static <T> void getPostServiceDiver(final Context paramContext, final Handler paramHandler, final Map<String, Object> paramMap, String paramString, final int paramInt)
  {
    a.execute(new Runnable()
    {
      public void run()
      {
        Object localObject = q.httpPost(this.a, paramMap);
        localObject = a.parseDiverService(paramContext, (String)localObject);
        i.sendMessage(paramHandler, paramInt, localObject);
      }
    });
  }
  
  public static <T> void getPostServiceList(final Context paramContext, final Handler paramHandler, final Map<String, Object> paramMap, String paramString, final int paramInt, final Class<T> paramClass)
  {
    a.execute(new Runnable()
    {
      public void run()
      {
        Object localObject = q.httpPost(this.a, paramMap);
        localObject = a.parseServiceList(paramContext, (String)localObject, paramClass);
        i.sendMessage(paramHandler, paramInt, localObject);
      }
    });
  }
  
  public static <T> void getPostServiceObject(final Context paramContext, final Handler paramHandler, final Map<String, Object> paramMap, String paramString, final int paramInt, final Class<T> paramClass)
  {
    a.execute(new Runnable()
    {
      public void run()
      {
        Object localObject = q.httpPost(this.a, paramMap);
        localObject = a.parseServiceObject(paramContext, (String)localObject, paramClass);
        i.sendMessage(paramHandler, paramInt, localObject);
      }
    });
  }
  
  public static <T> void getPostTestService(Context paramContext, final Handler paramHandler, final Map<String, Object> paramMap, final String paramString, final int paramInt)
  {
    a.execute(new Runnable()
    {
      public void run()
      {
        Object localObject = null;
        try
        {
          String str = com.ziroom.ziroomcustomer.newchat.chatcenter.g.sendHttpPost(this.a, paramString, paramMap);
          localObject = str;
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            localIOException.printStackTrace();
          }
        }
        localObject = a.parseTestService(this.a, (String)localObject);
        i.sendMessage(paramHandler, paramInt, localObject);
      }
    });
  }
  
  public static <T> void getPostTestServiceList(Context paramContext, final Handler paramHandler, final Map<String, Object> paramMap, final String paramString, final int paramInt, final Class<T> paramClass)
  {
    a.execute(new Runnable()
    {
      public void run()
      {
        Object localObject = null;
        try
        {
          String str = com.ziroom.ziroomcustomer.newchat.chatcenter.g.sendHttpPost(this.a, paramString, paramMap);
          localObject = str;
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            localIOException.printStackTrace();
          }
        }
        localObject = a.parseTestServiceList(this.a, (String)localObject, paramClass);
        i.sendMessage(paramHandler, paramInt, localObject);
      }
    });
  }
  
  public static <T> void getPostTestServiceObject(Context paramContext, final Handler paramHandler, final Map<String, Object> paramMap, final String paramString, final int paramInt, final Class<T> paramClass)
  {
    a.execute(new Runnable()
    {
      public void run()
      {
        Object localObject = null;
        try
        {
          String str = com.ziroom.ziroomcustomer.newchat.chatcenter.g.sendHttpPost(this.a, paramString, paramMap);
          localObject = str;
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            localIOException.printStackTrace();
          }
        }
        u.e("sdjsg", (String)localObject);
        localObject = a.parseTestServiceObject(this.a, (String)localObject, paramClass);
        i.sendMessage(paramHandler, paramInt, localObject);
      }
    });
  }
  
  public static <T> void getPutTestService(Context paramContext, final Handler paramHandler, final Map<String, Object> paramMap, final String paramString, final int paramInt, Class<T> paramClass)
  {
    a.execute(new Runnable()
    {
      public void run()
      {
        Object localObject = null;
        try
        {
          String str = com.ziroom.ziroomcustomer.newchat.chatcenter.g.sendHttpPut(this.a, paramString, paramMap);
          localObject = str;
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            localIOException.printStackTrace();
          }
        }
        localObject = a.parseTestService(this.a, (String)localObject);
        i.sendMessage(paramHandler, paramInt, localObject);
      }
    });
  }
  
  public static <T> void getRasGetService(final Context paramContext, final Handler paramHandler, String paramString, final int paramInt1, final Class<T> paramClass, final int paramInt2)
  {
    a.execute(new Runnable()
    {
      public void run()
      {
        try
        {
          Object localObject = q.httpRasGet(this.a);
          PublicKey localPublicKey = aa.loadPublicKey(aa.a);
          localObject = new String(aa.decrypt(com.ziroom.ziroomcustomer.util.g.decode((String)localObject), localPublicKey));
          u.e("Rasjiemi", (String)localObject);
          localObject = a.parseService(paramContext, (String)localObject, paramClass, paramInt2);
          i.sendMessage(paramHandler, paramInt1, localObject);
          return;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    });
  }
  
  public static <T> void getRasPostService(final Context paramContext, final Handler paramHandler, final Map<String, Object> paramMap, String paramString, final int paramInt1, final Class<T> paramClass, final int paramInt2)
  {
    a.execute(new Runnable()
    {
      public void run()
      {
        try
        {
          Object localObject = q.httpRsaPost(this.a, paramMap);
          PublicKey localPublicKey = aa.loadPublicKey(aa.a);
          localObject = new String(aa.decrypt(com.ziroom.ziroomcustomer.util.g.decode((String)localObject), localPublicKey));
          u.e("Rasjiemi", (String)localObject);
          localObject = a.parseService(paramContext, (String)localObject, paramClass, paramInt2);
          i.sendMessage(paramHandler, paramInt1, localObject);
          return;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    });
  }
  
  public static void getRepairCapacity(final Context paramContext, final Handler paramHandler, final Map<String, Object> paramMap, String paramString, final int paramInt)
  {
    a.execute(new Runnable()
    {
      public void run()
      {
        Object localObject = q.httpPost(this.a, paramMap);
        localObject = a.parseGetRepairCapacity(paramContext, (String)localObject);
        i.sendMessage(paramHandler, paramInt, localObject);
      }
    });
  }
  
  public static <T> void getRepairScoreItem(final Context paramContext, final Handler paramHandler, String paramString, final int paramInt, Class<T> paramClass)
  {
    a.execute(new Runnable()
    {
      public void run()
      {
        Object localObject = q.httpGet(this.a);
        localObject = a.parseGetRepairScoreItem(paramContext, (String)localObject);
        i.sendMessage(paramHandler, paramInt, localObject);
      }
    });
  }
  
  public static void getRepairTime(final Context paramContext, final Handler paramHandler, final Map<String, Object> paramMap, String paramString, final int paramInt)
  {
    a.execute(new Runnable()
    {
      public void run()
      {
        Object localObject = q.httpPost(this.a, paramMap);
        localObject = a.parseGetRepairTime(paramContext, (String)localObject);
        i.sendMessage(paramHandler, paramInt, localObject);
      }
    });
  }
  
  public static void getlockRepairCapacity(final Context paramContext, final Handler paramHandler, final Map<String, Object> paramMap, String paramString, final int paramInt)
  {
    a.execute(new Runnable()
    {
      public void run()
      {
        Object localObject = q.httpPost(this.a, paramMap);
        localObject = a.parseLockRepairCapacity(paramContext, (String)localObject);
        i.sendMessage(paramHandler, paramInt, localObject);
      }
    });
  }
  
  public static void savePostRepairEvalInfo(final Context paramContext, final Handler paramHandler, final Map<String, Object> paramMap, String paramString, final int paramInt)
  {
    a.execute(new Runnable()
    {
      public void run()
      {
        Object localObject = q.httpPost(this.a, paramMap);
        localObject = a.parseSaveRepairEvalDetail(paramContext, (String)localObject);
        i.sendMessage(paramHandler, paramInt, localObject);
      }
    });
  }
  
  public static <T> void uploadImage(final Context paramContext, final Handler paramHandler, final String paramString1, final byte[] paramArrayOfByte, String paramString2, final int paramInt, final Class<T> paramClass)
  {
    a.execute(new Runnable()
    {
      public void run()
      {
        try
        {
          Object localObject = k.decrypt(q.httpUploadTo(this.a, paramArrayOfByte, paramString1));
          u.e("dec: ", (String)localObject);
          localObject = a.parseServiceList(paramContext, (String)localObject, paramClass);
          i.sendMessage(paramHandler, paramInt, localObject);
          return;
        }
        catch (Exception localException) {}
      }
    });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/e/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */