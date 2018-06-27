package com.unionpay.sdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

final class bd
  implements InvocationHandler
{
  bd(m paramm, Object paramObject) {}
  
  public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    this.a.a(paramObject, paramMethod, paramArrayOfObject);
    Object localObject = paramMethod.invoke(this.b, paramArrayOfObject);
    this.a.a(paramObject, paramMethod, paramArrayOfObject, localObject);
    return localObject;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/sdk/bd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */