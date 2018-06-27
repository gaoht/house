package com.megvii.zhimasdk.b.a.i.b;

import com.megvii.zhimasdk.b.a.b.c.c;
import com.megvii.zhimasdk.b.a.o.f;
import com.megvii.zhimasdk.b.a.s;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class i
  implements InvocationHandler
{
  private static final Constructor<?> a;
  private final s b;
  
  static
  {
    try
    {
      a = Proxy.getProxyClass(i.class.getClassLoader(), new Class[] { c.class }).getConstructor(new Class[] { InvocationHandler.class });
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      throw new IllegalStateException(localNoSuchMethodException);
    }
  }
  
  i(s params)
  {
    this.b = params;
  }
  
  public static c a(s params)
  {
    try
    {
      params = (c)a.newInstance(new Object[] { new i(params) });
      return params;
    }
    catch (InstantiationException params)
    {
      throw new IllegalStateException(params);
    }
    catch (InvocationTargetException params)
    {
      throw new IllegalStateException(params);
    }
    catch (IllegalAccessException params)
    {
      throw new IllegalStateException(params);
    }
  }
  
  public void a()
  {
    f.a(this.b.b());
  }
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    if (paramMethod.getName().equals("close"))
    {
      a();
      return null;
    }
    try
    {
      paramObject = paramMethod.invoke(this.b, paramArrayOfObject);
      return paramObject;
    }
    catch (InvocationTargetException paramObject)
    {
      paramMethod = ((InvocationTargetException)paramObject).getCause();
      if (paramMethod != null) {
        throw paramMethod;
      }
      throw ((Throwable)paramObject);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/i/b/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */