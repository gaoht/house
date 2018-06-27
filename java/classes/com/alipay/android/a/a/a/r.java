package com.alipay.android.a.a.a;

import android.content.Context;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public final class r
  extends d
{
  Context a;
  
  public r(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public final <T> T a(Class<T> paramClass, h paramh)
  {
    Object localObject = new e(new s(this, paramh));
    paramh = paramClass.getClassLoader();
    localObject = new f(((e)localObject).a, paramClass, ((e)localObject).b);
    return (T)Proxy.newProxyInstance(paramh, new Class[] { paramClass }, (InvocationHandler)localObject);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alipay/android/a/a/a/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */