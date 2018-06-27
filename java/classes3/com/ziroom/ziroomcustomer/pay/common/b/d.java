package com.ziroom.ziroomcustomer.pay.common.b;

import android.app.Activity;
import android.content.Context;
import com.freelxl.baselibrary.d.f.e;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.e.k;
import com.freelxl.baselibrary.f.f;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.e.g;
import com.ziroom.ziroomcustomer.e.q;
import com.ziroom.ziroomcustomer.util.u;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class d
{
  private static Map<String, String> a(Map<String, Object> paramMap)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramMap.entrySet().iterator();
    if (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if ((localEntry.getValue() instanceof String)) {
        localHashMap.put(localEntry.getKey(), (String)localEntry.getValue());
      }
      for (;;)
      {
        com.freelxl.baselibrary.f.d.e("yangxj---ObjMap2String", (String)localEntry.getKey() + ":" + String.valueOf(localEntry.getValue()));
        break;
        if ((localEntry.getValue() instanceof Integer))
        {
          localHashMap.put(localEntry.getKey(), String.valueOf(localEntry.getValue()));
        }
        else
        {
          if (localEntry.getValue() != null) {
            break label191;
          }
          localHashMap.put(localEntry.getKey(), "");
          com.freelxl.baselibrary.f.d.e("yangxj", "ObjMap2String=== null");
        }
      }
      label191:
      localHashMap.put(localEntry.getKey(), String.valueOf(localEntry.getValue()));
      if ("ObjMap2String===" + localEntry.getValue() + "======" + localEntry.getValue() == null) {}
      for (paramMap = "null";; paramMap = localEntry.getValue().getClass())
      {
        com.freelxl.baselibrary.f.d.e("yangxj", paramMap);
        break;
      }
    }
    return localHashMap;
  }
  
  public static void dismissProgress(Context paramContext)
  {
    ((Activity)paramContext).runOnUiThread(new Runnable()
    {
      public void run()
      {
        if ((com.freelxl.baselibrary.widget.a.getDialog() != null) && (com.freelxl.baselibrary.widget.a.isShowing())) {
          com.freelxl.baselibrary.widget.a.dismiss();
        }
      }
    });
  }
  
  public static String getToken()
  {
    return com.ziroom.commonlibrary.login.a.getToken(ApplicationEx.c);
  }
  
  public static String getUid()
  {
    return com.ziroom.commonlibrary.login.a.getUid(ApplicationEx.c);
  }
  
  public static void request(Activity paramActivity, String paramString, Map<String, Object> paramMap, final Class paramClass, final i.a parama)
  {
    c.appendCommenParams(paramMap);
    u.e("yangxj---url", com.ziroom.ziroomcustomer.pay.common.a.a.a + paramString);
    paramMap = a(paramMap);
    paramString = com.freelxl.baselibrary.d.a.post(com.ziroom.ziroomcustomer.pay.common.a.a.a + paramString).params(paramMap).tag(paramActivity);
    if (paramClass == null) {}
    for (paramActivity = new e();; paramActivity = new b(paramClass))
    {
      paramString.enqueue(new com.freelxl.baselibrary.d.c.a(paramActivity)
      {
        public void onFailure(Throwable paramAnonymousThrowable)
        {
          k localk = new k();
          localk.setSuccess(Boolean.valueOf(false));
          if (f.isNull(paramAnonymousThrowable.getMessage())) {
            localk.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
          }
          while (paramClass == null)
          {
            parama.onParse("", localk);
            return;
            localk.setMessage(paramAnonymousThrowable.getMessage());
          }
          parama.onSuccess(localk);
        }
        
        public void onSuccess(int paramAnonymousInt, Object paramAnonymousObject)
        {
          k localk = new k();
          localk.setObject(paramAnonymousObject);
          localk.setSuccess(Boolean.valueOf(true));
          if (paramClass == null)
          {
            parama.onParse(paramAnonymousObject.toString(), localk);
            return;
          }
          parama.onSuccess(localk);
        }
      });
      return;
    }
  }
  
  public static void requestNoDES(final Activity paramActivity, String paramString1, String paramString2, Map<String, Object> paramMap, final boolean paramBoolean, final Class paramClass, final i.a parama)
  {
    if (paramBoolean) {
      showProgress("", paramActivity);
    }
    g.appendCommenParams(paramMap);
    paramMap = a(paramMap);
    paramString2 = com.freelxl.baselibrary.d.a.post(paramString1 + paramString2).params(paramMap).tag(paramActivity);
    if (paramClass == null) {}
    for (paramString1 = new e();; paramString1 = new b(paramClass))
    {
      paramString2.enqueue(new com.freelxl.baselibrary.d.c.a(paramString1)
      {
        public void onFailure(Throwable paramAnonymousThrowable)
        {
          if (paramBoolean) {
            d.dismissProgress(paramActivity);
          }
          k localk = new k();
          localk.setSuccess(Boolean.valueOf(false));
          if (f.isNull(paramAnonymousThrowable.getMessage())) {
            localk.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
          }
          while (paramClass == null)
          {
            parama.onParse("", localk);
            return;
            localk.setMessage(paramAnonymousThrowable.getMessage());
          }
          parama.onSuccess(localk);
        }
        
        public void onSuccess(int paramAnonymousInt, Object paramAnonymousObject)
        {
          if (paramBoolean) {
            d.dismissProgress(paramActivity);
          }
          k localk = new k();
          localk.setObject(paramAnonymousObject);
          localk.setSuccess(Boolean.valueOf(true));
          if (paramClass == null)
          {
            parama.onParse(paramAnonymousObject.toString(), localk);
            return;
          }
          parama.onSuccess(localk);
        }
      });
      return;
    }
  }
  
  public static void requestNoDES(Activity paramActivity, String paramString, Map<String, Object> paramMap, boolean paramBoolean, Class paramClass, i.a parama)
  {
    requestNoDES(paramActivity, q.s, paramString, paramMap, paramBoolean, paramClass, parama);
  }
  
  public static void showProgress(final String paramString, Context paramContext)
  {
    ((Activity)paramContext).runOnUiThread(new Runnable()
    {
      public void run()
      {
        if ((com.freelxl.baselibrary.widget.a.getDialog() != null) && (com.freelxl.baselibrary.widget.a.isShowing()) && ((this.a instanceof Activity))) {
          return;
        }
        com.freelxl.baselibrary.widget.a.show(this.a, paramString, false, true);
      }
    });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/pay/common/b/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */