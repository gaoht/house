package com.g.a;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

final class ab
  implements InvocationHandler
{
  ab(x paramx, Object paramObject) {}
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    this.a.a(paramObject, paramMethod, paramArrayOfObject);
    Object localObject = paramMethod.invoke(this.b, paramArrayOfObject);
    this.a.a(paramObject, paramMethod, paramArrayOfObject, localObject);
    return localObject;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/g/a/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */