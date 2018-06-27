package com.mato.sdk.b;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class p
{
  private static Class<?> a;
  
  public static Class<?> a()
    throws ClassNotFoundException
  {
    if (e.o == null) {
      e.o = Class.forName("android.webkit.WebViewFactory");
    }
    return e.o;
  }
  
  public static Object b()
    throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, ClassNotFoundException
  {
    Method localMethod = e.m().getDeclaredMethod("getProvider", new Class[0]);
    if (!localMethod.isAccessible()) {
      localMethod.setAccessible(true);
    }
    return localMethod.invoke(null, new Object[0]);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/b/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */