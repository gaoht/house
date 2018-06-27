package com.pgyersdk.a;

import android.content.Context;
import com.pgyersdk.i.i;
import com.pgyersdk.i.k;

public class a
{
  private static Context a;
  
  public static void a(Context paramContext)
  {
    a = paramContext;
    com.pgyersdk.i.b.a(new b(paramContext));
  }
  
  public static void b(Context paramContext)
  {
    a = paramContext;
    com.pgyersdk.i.b.a(new c(paramContext));
  }
  
  public static void c(Context paramContext)
  {
    a = paramContext;
    if (com.pgyersdk.e.a.b == null) {
      new com.pgyersdk.e.a().e(paramContext);
    }
    if (k.a(i.a(paramContext, "install"))) {
      a(paramContext);
    }
    b(paramContext);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/pgyersdk/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */