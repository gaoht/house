package com.pgyersdk.h;

import android.app.Activity;
import android.os.AsyncTask.Status;

public class a
{
  private static com.pgyersdk.g.a a = null;
  private static b b = null;
  private static Activity c;
  
  private static void a(Activity paramActivity, String paramString, b paramb, boolean paramBoolean)
  {
    c = paramActivity;
    try
    {
      com.pgyersdk.e.c.a(paramActivity);
      b = paramb;
      a(paramActivity, paramString, com.pgyersdk.b.a.l, paramb, paramBoolean);
      com.pgyersdk.a.a.c(paramActivity);
      return;
    }
    catch (Exception paramActivity) {}
  }
  
  private static void a(Activity paramActivity, String paramString1, String paramString2, b paramb, boolean paramBoolean)
  {
    if ((a == null) || (a.getStatus() == AsyncTask.Status.FINISHED))
    {
      if (paramb == null) {}
      for (a = new com.pgyersdk.g.c(paramActivity, paramString1, paramString2, paramb, paramBoolean);; a = new com.pgyersdk.g.a(paramActivity, paramString1, paramString2, paramb))
      {
        com.pgyersdk.i.b.a(a);
        return;
      }
    }
    a.a(paramActivity);
  }
  
  public static void register(Activity paramActivity)
  {
    a(paramActivity, "http://www.pgyer.com/", null, true);
  }
  
  public static void register(Activity paramActivity, b paramb)
  {
    a(paramActivity, "http://www.pgyer.com/", paramb, true);
  }
  
  public static void unregister()
  {
    if (a != null)
    {
      a.cancel(true);
      a.a();
      a = null;
    }
    com.pgyersdk.e.a.f(c);
    b = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/pgyersdk/h/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */