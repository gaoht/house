package com.unionpay.sdk;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class av
{
  private final Object a;
  private final Method b;
  private final int c;
  private boolean d = true;
  
  av(Object paramObject, Method paramMethod)
  {
    if (paramObject == null) {
      throw new NullPointerException("EventHandler target cannot be null.");
    }
    if (paramMethod == null) {
      throw new NullPointerException("EventHandler method cannot be null.");
    }
    this.a = paramObject;
    this.b = paramMethod;
    paramMethod.setAccessible(true);
    this.c = ((paramMethod.hashCode() + 31) * 31 + paramObject.hashCode());
  }
  
  public final boolean a()
  {
    return this.d;
  }
  
  public final void b()
  {
    this.d = false;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (paramObject == null) {
        return false;
      }
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (av)paramObject;
    } while ((this.b.equals(((av)paramObject).b)) && (this.a == ((av)paramObject).a));
    return false;
  }
  
  public final void handleEvent(Object paramObject)
  {
    if (!this.d) {
      throw new IllegalStateException(toString() + " has been invalidated and can no longer handle events.");
    }
    try
    {
      this.b.invoke(this.a, new Object[] { paramObject });
      return;
    }
    catch (IllegalAccessException paramObject)
    {
      throw new AssertionError(paramObject);
    }
    catch (InvocationTargetException paramObject)
    {
      if ((((InvocationTargetException)paramObject).getCause() instanceof Error)) {
        throw ((Error)((InvocationTargetException)paramObject).getCause());
      }
      throw ((Throwable)paramObject);
    }
  }
  
  public final int hashCode()
  {
    return this.c;
  }
  
  public final String toString()
  {
    return "[EventHandler " + this.b + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/sdk/av.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */