package com.alipay.android.a.a.a;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public final class f
  implements InvocationHandler
{
  protected q a;
  protected Class<?> b;
  protected g c;
  
  public f(q paramq, Class<?> paramClass, g paramg)
  {
    this.a = paramq;
    this.b = paramClass;
    this.c = paramg;
  }
  
  public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    return this.c.a(paramMethod, paramArrayOfObject);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alipay/android/a/a/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */