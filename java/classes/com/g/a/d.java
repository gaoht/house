package com.g.a;

import android.app.Activity;
import android.content.Context;
import com.tendcloud.appcpa.b;
import java.util.Map;

public final class d
{
  public static boolean a = true;
  private static p b;
  
  public static String a(Context paramContext)
  {
    return c.a(paramContext);
  }
  
  public static void a(Activity paramActivity, a parama)
  {
    try
    {
      d(paramActivity, parama);
      b.a(paramActivity, parama);
      return;
    }
    catch (Throwable paramActivity)
    {
      paramActivity.printStackTrace();
    }
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, a parama)
  {
    try
    {
      d(paramActivity, parama);
      b.a(paramActivity, paramString1, paramString2, parama);
      return;
    }
    catch (Throwable paramActivity)
    {
      paramActivity.printStackTrace();
    }
  }
  
  public static void a(Context paramContext, a parama)
  {
    try
    {
      d(paramContext, parama);
      b.a(paramContext, parama);
      return;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
    finally {}
  }
  
  public static void a(Context paramContext, String paramString, a parama)
  {
    b(paramContext, paramString, "", parama);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, a parama)
  {
    try
    {
      d(paramContext, parama);
      b.a(paramContext, paramString1, paramString2, parama);
      return;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
    finally {}
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, Map paramMap, a parama)
  {
    try
    {
      d(paramContext, parama);
      b.a(paramContext, paramString1, paramString2, paramMap, parama);
      return;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static void a(Context paramContext, String paramString, Map paramMap, a parama)
  {
    a(paramContext, paramString, null, paramMap, parama);
  }
  
  public static void a(a parama, String paramString)
  {
    try
    {
      d(c.e, parama);
      b.a(c.e, paramString, "", null, parama);
      return;
    }
    catch (Throwable parama)
    {
      parama.printStackTrace();
    }
  }
  
  public static void a(b paramb, a parama)
  {
    try
    {
      d(c.e, parama);
      b.a(paramb, parama);
      return;
    }
    catch (Throwable paramb)
    {
      paramb.printStackTrace();
    }
  }
  
  public static void a(String paramString, a parama)
  {
    try
    {
      d(c.e, parama);
      b.removeGlobalKV(paramString);
      return;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static void a(String paramString, com.tendcloud.appcpa.a parama, a parama1)
  {
    try
    {
      d(c.e, parama1);
      b.a(paramString, parama, parama1);
      return;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static void a(String paramString, Object paramObject, a parama)
  {
    try
    {
      d(c.e, parama);
      b.a(paramString, paramObject);
      return;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static void a(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, a parama)
  {
    try
    {
      d(c.e, parama);
      b.b(paramString1, paramString2, paramInt, paramString3, paramString4, parama);
      return;
    }
    catch (Throwable paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public static void a(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, com.tendcloud.appcpa.a parama, a parama1)
  {
    try
    {
      d(c.e, parama1);
      b.a(paramString1, paramString2, paramInt, paramString3, paramString4, parama, parama1);
      return;
    }
    catch (Throwable paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public static void a(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, String paramString5, int paramInt2, a parama)
  {
    try
    {
      d(c.e, parama);
      b.a(paramString1, paramString2, paramInt1, paramString3, paramString4, paramString5, paramInt2, parama);
      return;
    }
    catch (Throwable paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, a parama)
  {
    try
    {
      d(c.e, parama);
      b.a(paramString1, paramString2, paramString3, paramInt1, paramInt2, parama);
      return;
    }
    catch (Throwable paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, int paramInt, a parama)
  {
    try
    {
      d(c.e, parama);
      b.a(paramString1, paramString2, paramString3, paramInt, parama);
      return;
    }
    catch (Throwable paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public static boolean a()
  {
    return db.j;
  }
  
  public static final Context b()
  {
    return b.d();
  }
  
  public static String b(Context paramContext, a parama)
  {
    return c.a(paramContext, parama);
  }
  
  public static void b(Activity paramActivity, a parama)
  {
    try
    {
      d(paramActivity, parama);
      b.b(paramActivity, parama);
      return;
    }
    catch (Throwable paramActivity)
    {
      paramActivity.printStackTrace();
    }
  }
  
  public static void b(Context paramContext, String paramString1, String paramString2, a parama)
  {
    a(paramContext, paramString1, paramString2, null, parama);
  }
  
  public static void b(String paramString, a parama)
  {
    try
    {
      d(c.e, parama);
      b.b(paramString, parama);
      return;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static void b(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, a parama)
  {
    try
    {
      d(c.e, parama);
      b.a(paramString1, paramString2, paramInt, paramString3, paramString4, parama);
      return;
    }
    catch (Throwable paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public static String c(Context paramContext, a parama)
  {
    try
    {
      d(paramContext, parama);
      paramContext = b.b(paramContext, parama);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        paramContext = null;
      }
    }
    finally {}
  }
  
  public static void c(String paramString, a parama)
  {
    try
    {
      d(c.e, parama);
      b.c(paramString, parama);
      return;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  /* Error */
  private static void d(Context paramContext, a parama)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnull +10 -> 14
    //   7: aload_0
    //   8: invokevirtual 118	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   11: putstatic 60	com/g/a/c:e	Landroid/content/Context;
    //   14: getstatic 60	com/g/a/c:e	Landroid/content/Context;
    //   17: ifnonnull +12 -> 29
    //   20: ldc 120
    //   22: invokestatic 125	com/g/a/h:eForDeveloper	(Ljava/lang/String;)V
    //   25: ldc 2
    //   27: monitorexit
    //   28: return
    //   29: getstatic 30	com/g/a/d:b	Lcom/g/a/p;
    //   32: ifnonnull -7 -> 25
    //   35: invokestatic 131	java/lang/System:currentTimeMillis	()J
    //   38: pop2
    //   39: invokestatic 134	com/g/a/db:b	()Lcom/g/a/db;
    //   42: putstatic 30	com/g/a/d:b	Lcom/g/a/p;
    //   45: goto -20 -> 25
    //   48: astore_0
    //   49: ldc 2
    //   51: monitorexit
    //   52: aload_0
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	paramContext	Context
    //   0	54	1	parama	a
    // Exception table:
    //   from	to	target	type
    //   7	14	48	finally
    //   14	25	48	finally
    //   29	45	48	finally
  }
  
  public static void d(String paramString, a parama)
  {
    try
    {
      d(c.e, parama);
      b.a(paramString, parama);
      return;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static void e(String paramString, a parama)
  {
    try
    {
      d(c.e, parama);
      b.d(paramString, parama);
      return;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static void setVerboseLogDisable(a parama)
  {
    try
    {
      h.a = false;
      return;
    }
    catch (Throwable parama)
    {
      parama.printStackTrace();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/g/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */