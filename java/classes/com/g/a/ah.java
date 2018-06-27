package com.g.a;

import java.lang.reflect.Method;

final class ah
{
  private final Object a;
  private final Method b;
  private final int c;
  private boolean d = true;
  
  ah(Object paramObject, Method paramMethod)
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
  
  public boolean a()
  {
    return this.d;
  }
  
  public void b()
  {
    this.d = false;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = true;
    boolean bool3 = false;
    boolean bool1;
    if (this == paramObject) {
      bool1 = true;
    }
    for (;;)
    {
      return bool1;
      bool1 = bool3;
      if (paramObject == null) {
        continue;
      }
      bool1 = bool3;
      try
      {
        if (getClass() != paramObject.getClass()) {
          continue;
        }
        Object localObject = (ah)paramObject;
        if (this.b.equals(((ah)localObject).b))
        {
          paramObject = this.a;
          localObject = ((ah)localObject).a;
          if (paramObject != localObject) {}
        }
        for (bool1 = bool2;; bool1 = false) {
          return bool1;
        }
        return false;
      }
      catch (Throwable paramObject)
      {
        av.postSDKError((Throwable)paramObject);
      }
    }
  }
  
  public void handleEvent(Object paramObject)
  {
    if (!this.d) {
      h.eForInternal(new String[] { toString() + " has been invalidated and can no longer handle events." });
    }
    try
    {
      this.b.invoke(this.a, new Object[] { paramObject });
      return;
    }
    catch (Throwable paramObject) {}
  }
  
  public int hashCode()
  {
    return this.c;
  }
  
  public String toString()
  {
    return "[EventHandler " + this.b + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/g/a/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */