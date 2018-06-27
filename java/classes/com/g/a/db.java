package com.g.a;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tendcloud.appcpa.b;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class db
  implements p
{
  public static boolean a = d.a;
  public static String b = "CoreLog";
  public static String c = "2.3.8";
  static Context d;
  public static boolean e = false;
  static boolean f = false;
  public static AtomicBoolean g = new AtomicBoolean(false);
  static boolean h = false;
  static boolean i = false;
  public static volatile boolean j;
  public static volatile boolean k;
  static boolean l;
  public static boolean m;
  public static bv n;
  public static final HandlerThread o;
  private static volatile db p = null;
  private static Handler q = new cg(o.getLooper());
  
  static
  {
    j = false;
    k = false;
    l = false;
    m = false;
    q = null;
    o = new HandlerThread("ProcessingThread");
    o.start();
  }
  
  public db()
  {
    p = this;
  }
  
  public static Context a()
  {
    return d;
  }
  
  /* Error */
  static db b()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 66	com/g/a/db:p	Lcom/g/a/db;
    //   6: ifnonnull +25 -> 31
    //   9: ldc 2
    //   11: monitorenter
    //   12: getstatic 66	com/g/a/db:p	Lcom/g/a/db;
    //   15: ifnonnull +13 -> 28
    //   18: new 2	com/g/a/db
    //   21: dup
    //   22: invokespecial 105	com/g/a/db:<init>	()V
    //   25: putstatic 66	com/g/a/db:p	Lcom/g/a/db;
    //   28: ldc 2
    //   30: monitorexit
    //   31: getstatic 66	com/g/a/db:p	Lcom/g/a/db;
    //   34: astore_0
    //   35: ldc 2
    //   37: monitorexit
    //   38: aload_0
    //   39: areturn
    //   40: astore_0
    //   41: ldc 2
    //   43: monitorexit
    //   44: aload_0
    //   45: athrow
    //   46: astore_0
    //   47: ldc 2
    //   49: monitorexit
    //   50: aload_0
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   34	5	0	localdb	db
    //   40	5	0	localObject1	Object
    //   46	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   12	28	40	finally
    //   28	31	40	finally
    //   41	44	40	finally
    //   3	12	46	finally
    //   31	35	46	finally
    //   44	46	46	finally
  }
  
  private void b(Context paramContext)
  {
    if (z.a(14)) {
      paramContext = null;
    }
    try
    {
      if ((c.e instanceof Activity)) {
        paramContext = ((Activity)c.e).getApplication();
      }
      for (;;)
      {
        if ((paramContext != null) && (!m))
        {
          Object localObject = Class.forName("android.app.Application$ActivityLifecycleCallbacks");
          localObject = paramContext.getClass().getMethod("registerActivityLifecycleCallbacks", new Class[] { localObject });
          n = new bv();
          ((Method)localObject).invoke(paramContext, new Object[] { n });
          m = true;
          return;
          if ((c.e instanceof Application))
          {
            paramContext = (Application)c.e;
            continue;
            paramContext = new co(this, paramContext);
            try
            {
              z.a(Class.forName("android.app.ActivityManagerNative"), paramContext, "gDefault", "android.app.IActivityManager");
              m = true;
              return;
            }
            catch (Throwable paramContext)
            {
              h.eForDeveloper("registerActivityLifecycleListener " + paramContext.getMessage());
              return;
            }
          }
        }
      }
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  public static Handler c()
  {
    return q;
  }
  
  public static boolean f()
  {
    return g.get();
  }
  
  public String a(Context paramContext)
  {
    return c.a(paramContext);
  }
  
  public void a(Activity paramActivity, a parama)
  {
    try
    {
      if ((m) && (c.n)) {
        return;
      }
      cx.a(paramActivity, parama);
      return;
    }
    catch (Throwable paramActivity) {}
  }
  
  public void a(Activity paramActivity, String paramString1, String paramString2, a parama)
  {
    try
    {
      if (!j) {
        a(paramActivity, paramString1, paramString2, parama);
      }
      b(paramActivity);
      a(paramActivity, parama);
      return;
    }
    catch (Throwable paramActivity) {}
  }
  
  public void a(Context paramContext, a parama)
  {
    a(paramContext, null, null, parama);
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, a parama)
  {
    if (paramContext == null) {}
    try
    {
      h.iForDeveloper("Init failed Context is null");
      return;
    }
    catch (Throwable paramContext)
    {
      av.postSDKError(paramContext);
      return;
    }
    if (!z.b(paramContext, "android.permission.INTERNET"))
    {
      h.eForDeveloper("[SDKInit] Permission \"android.permission.INTERNET\" is needed.");
      return;
    }
    if (parama == null)
    {
      h.eForDeveloper("Failed to initialize!");
      return;
    }
    try
    {
      if (!j)
      {
        c.e = paramContext.getApplicationContext();
        b(paramContext);
        j = true;
      }
      z.execute(new cp(this, paramString1, paramString2, parama));
      return;
    }
    catch (Throwable paramContext)
    {
      h.a("[SDKInit] Failed to initialize!", paramContext);
      av.postSDKError(paramContext);
    }
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, Map paramMap, a parama)
  {
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramString1))
        {
          h.eForDeveloper("TalkingDataGA.onEvent()# event id is empty.");
          return;
        }
        if ((!j) && (paramContext != null)) {
          a(paramContext, null, null, parama);
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onEvent being called! eventId: ");
        if (paramString1 == null)
        {
          paramContext = "null";
          localStringBuilder.append(paramContext);
          if (parama.c() != 3)
          {
            localStringBuilder.append(", eventLabel: ");
            if (paramString2 != null) {
              break label190;
            }
            paramContext = "null";
            localStringBuilder.append(paramContext);
          }
          localStringBuilder.append(", eventMap: ");
          if (paramMap == null)
          {
            paramContext = "null";
            localStringBuilder.append(paramContext);
            h.iForDeveloper(localStringBuilder.toString());
            z.execute(new cq(this, parama, paramString1, paramString2, paramMap));
            return;
          }
          paramContext = "mapSize: " + String.valueOf(paramMap.size());
          continue;
        }
        paramContext = paramString1;
      }
      catch (Throwable paramContext)
      {
        return;
      }
      continue;
      label190:
      paramContext = paramString2;
    }
  }
  
  public void a(b paramb, a parama)
  {
    try
    {
      h.iForDeveloper("onViewShoppingCart called --> shoppingCart: " + paramb);
      if ((paramb == null) || (paramb.length() <= 0))
      {
        h.eForDeveloper("viewShoppingCart# shoppingCart can't be null or empty");
        return;
      }
      z.execute(new cm(this, parama, paramb));
      return;
    }
    catch (Throwable paramb)
    {
      av.postSDKError(paramb);
    }
  }
  
  public void a(String paramString, a parama)
  {
    try
    {
      h.iForDeveloper("createRole called --> roleName: " + paramString);
      z.execute(new cr(this, paramString, parama));
      return;
    }
    catch (Throwable paramString)
    {
      av.postSDKError(paramString);
    }
  }
  
  public void a(String paramString, com.tendcloud.appcpa.a parama, a parama1)
  {
    if (paramString != null) {}
    try
    {
      if (paramString.trim().length() <= 0)
      {
        h.eForDeveloper("onPlaceOrder: account could not be null or empty");
        return;
      }
      if (parama == null)
      {
        h.eForDeveloper("onPlaceOrder: order could not be null");
        return;
      }
    }
    catch (Throwable paramString)
    {
      av.postSDKError(paramString);
      return;
    }
    h.iForDeveloper("onPlaceOrder called --> account: " + paramString + " ,order: " + parama.toString());
    z.execute(new ck(this, parama1, paramString, parama));
  }
  
  public void a(String paramString, Object paramObject)
  {
    if ((paramString != null) && (paramObject != null)) {
      h.iForDeveloper("setGlobalKV# key:" + paramString + " value:" + paramObject.toString());
    }
    c.c.put(paramString, paramObject);
  }
  
  public void a(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, a parama)
  {
    if (paramString1 != null) {}
    try
    {
      if (paramString1.trim().length() <= 0)
      {
        h.eForDeveloper("onOrderPaySucc: account could not be null or empty");
        return;
      }
      h.iForDeveloper("onOrderPaySucc called --> account: " + paramString1 + " ,orderid: " + paramString2 + " ,amount: " + paramInt + " ,currencyType: " + paramString3 + " ,payType: " + paramString4);
      if (paramString3.trim().length() != 3)
      {
        h.eForDeveloper("currencyType length must be 3 likes CNY so so");
        return;
      }
    }
    catch (Throwable paramString1)
    {
      av.postSDKError(paramString1);
      return;
    }
    z.execute(new cw(this, parama, paramString1, paramString2, paramInt, paramString3, paramString4));
  }
  
  public void a(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, com.tendcloud.appcpa.a parama, a parama1)
  {
    if (paramString1 != null) {}
    try
    {
      if (paramString1.trim().length() <= 0)
      {
        h.eForDeveloper("onPay: account could not be null or empty");
        return;
      }
      if (parama == null)
      {
        h.eForDeveloper("onPay: order could not be null");
        return;
      }
    }
    catch (Throwable paramString1)
    {
      av.postSDKError(paramString1);
      return;
    }
    h.iForDeveloper("onPay called --> account: " + paramString1 + " ,orderid: " + paramString2 + " ,amount: " + paramInt + " ,currencyType: " + paramString3 + " ,payType: " + paramString4 + " ,order: " + parama.toString());
    if (paramString3.trim().length() != 3)
    {
      h.eForDeveloper("currencyType length must be 3 likes CNY so so");
      return;
    }
    z.execute(new cj(this, parama1, paramString1, paramString2, paramInt, paramString3, paramString4, parama));
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, String paramString5, int paramInt2, a parama)
  {
    if (paramString1 != null) {}
    try
    {
      if (paramString1.trim().length() <= 0)
      {
        h.eForDeveloper("onPay: account could not be null or empty");
        return;
      }
      h.iForDeveloper("onPay called --> account: " + paramString1 + " ,orderid: " + paramString2 + " ,amount: " + paramInt1 + " ,currencyType: " + paramString3 + " ,payType: " + paramString4 + " ,itemId: " + paramString5 + " ,itemCount: " + paramInt2);
      if (paramString3.trim().length() != 3)
      {
        h.eForDeveloper("currencyType length must be 3 likes CNY so so");
        return;
      }
    }
    catch (Throwable paramString1)
    {
      av.postSDKError(paramString1);
      return;
    }
    z.execute(new ci(this, parama, paramString1, paramString2, paramInt1, paramString3, paramString4, paramString5, paramInt2));
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, a parama)
  {
    try
    {
      h.iForDeveloper("onAddItemToShoppingCart called --> itemId: " + paramString1 + " ,category: " + paramString2 + " ,name: " + paramString3 + " ,unitPrice: " + paramInt1 + " ,amount: " + paramInt2);
      z.execute(new cv(this, parama, paramString1, paramString2, paramString3, paramInt1, paramInt2));
      return;
    }
    catch (Throwable paramString1)
    {
      av.postSDKError(paramString1);
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt, a parama)
  {
    try
    {
      h.iForDeveloper("onViewItem called --> itemId: " + paramString1 + " ,category: " + paramString2 + " ,name: " + paramString3 + " ,unitPrice: " + paramInt);
      z.execute(new cl(this, parama, paramString1, paramString2, paramString3, paramInt));
      return;
    }
    catch (Throwable paramString1)
    {
      av.postSDKError(paramString1);
    }
  }
  
  public String b(Context paramContext, a parama)
  {
    if (paramContext != null) {}
    try
    {
      if (!j) {
        a(paramContext, c.a(paramContext, parama), c.a(paramContext), parama);
      }
      paramContext = l.a(paramContext);
      return paramContext;
    }
    catch (Throwable paramContext) {}
    return null;
  }
  
  public void b(Activity paramActivity, a parama)
  {
    try
    {
      if (!j) {
        return;
      }
      if (!m)
      {
        b(paramActivity);
        cx.b(paramActivity, parama);
        return;
      }
    }
    catch (Throwable paramActivity) {}
  }
  
  public void b(String paramString, a parama)
  {
    try
    {
      if (TextUtils.isEmpty(paramString))
      {
        h.eForDeveloper("onLogin: account could not be null or empty");
        return;
      }
      h.iForDeveloper("onLogin called --> account is " + paramString);
      z.execute(new cs(this, parama, paramString));
      return;
    }
    catch (Throwable paramString)
    {
      av.postSDKError(paramString);
    }
  }
  
  public void b(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, a parama)
  {
    if (paramString1 != null) {}
    try
    {
      if (paramString1.trim().length() <= 0)
      {
        h.eForDeveloper("onPay: account could not be null or empty");
        return;
      }
      h.iForDeveloper("onPay called --> account: " + paramString1 + " ,orderid: " + paramString2 + " ,amount: " + paramInt + " ,currencyType: " + paramString3 + " ,payType: " + paramString4);
      if (paramString3.trim().length() != 3)
      {
        h.eForDeveloper("currencyType length must be 3 likes CNY so so");
        return;
      }
    }
    catch (Throwable paramString1)
    {
      av.postSDKError(paramString1);
      return;
    }
    z.execute(new ch(this, parama, paramString1, paramString2, paramInt, paramString3, paramString4));
  }
  
  public String c(Context paramContext, a parama)
  {
    return c.a(paramContext, parama);
  }
  
  public void c(String paramString, a parama)
  {
    try
    {
      if (TextUtils.isEmpty(paramString))
      {
        h.eForDeveloper("onRegister: account could not be null or empty");
        return;
      }
      h.iForDeveloper("onRegister called --> account is " + paramString);
      z.execute(new ct(this, parama, paramString));
      return;
    }
    catch (Throwable paramString)
    {
      av.postSDKError(paramString);
    }
  }
  
  public Context d()
  {
    try
    {
      Context localContext = c.e;
      return localContext;
    }
    catch (Throwable localThrowable) {}
    return null;
  }
  
  public void d(String paramString, a parama)
  {
    try
    {
      if (TextUtils.isEmpty(paramString))
      {
        h.eForDeveloper("onReceiveDeepLink: url could not be null or empty");
        return;
      }
      h.iForDeveloper("onReceiveDeepLink --> link: " + paramString);
      z.execute(new cn(this, paramString, parama));
      return;
    }
    catch (Throwable paramString)
    {
      av.postSDKError(paramString);
    }
  }
  
  public void e()
  {
    try
    {
      h.a = false;
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public void onLogout(a parama)
  {
    try
    {
      h.iForDeveloper("ModuleAccount.logout ");
      z.execute(new cu(this, parama));
      return;
    }
    catch (Throwable parama)
    {
      av.postSDKError(parama);
    }
  }
  
  public void removeGlobalKV(String paramString)
  {
    if (paramString != null) {
      h.iForDeveloper("removeGlobalKV# key:" + paramString);
    }
    c.c.remove(paramString);
  }
  
  public static class a
  {
    public HashMap a = new HashMap();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/g/a/db.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */