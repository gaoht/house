package com.d.b;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class e<T, V>
  extends d<T, V>
{
  private Method a;
  private Method b;
  private Field c;
  
  public e(Class<T> paramClass, Class<V> paramClass1, String paramString)
  {
    super(paramClass1, paramString);
    char c1 = Character.toUpperCase(paramString.charAt(0));
    String str1 = paramString.substring(1);
    str1 = c1 + str1;
    String str2 = "get" + str1;
    try
    {
      this.b = paramClass.getMethod(str2, (Class[])null);
      paramString = this.b.getReturnType();
      if (!a(paramClass1, paramString)) {
        throw new c("Underlying type (" + paramString + ") " + "does not match Property type (" + paramClass1 + ")");
      }
    }
    catch (NoSuchMethodException localNoSuchMethodException3)
    {
      try
      {
        this.b = paramClass.getDeclaredMethod(str2, (Class[])null);
        this.b.setAccessible(true);
      }
      catch (NoSuchMethodException localNoSuchMethodException2)
      {
        for (;;)
        {
          String str3 = "is" + str1;
          try
          {
            this.b = paramClass.getMethod(str3, (Class[])null);
          }
          catch (NoSuchMethodException localNoSuchMethodException4)
          {
            try
            {
              this.b = paramClass.getDeclaredMethod(str3, (Class[])null);
              this.b.setAccessible(true);
            }
            catch (NoSuchMethodException localNoSuchMethodException1)
            {
              try
              {
                this.c = paramClass.getField(paramString);
                paramClass = this.c.getType();
                if (a(paramClass1, paramClass)) {
                  break label387;
                }
                throw new c("Underlying type (" + paramClass + ") " + "does not match Property type (" + paramClass1 + ")");
              }
              catch (NoSuchFieldException paramClass)
              {
                throw new c("No accessor method or field found for property with name " + paramString);
              }
            }
          }
        }
      }
      paramClass1 = "set" + localNoSuchMethodException1;
      try
      {
        this.a = paramClass.getDeclaredMethod(paramClass1, new Class[] { paramString });
        this.a.setAccessible(true);
        label387:
        return;
      }
      catch (NoSuchMethodException paramClass) {}
    }
  }
  
  private boolean a(Class<V> paramClass, Class paramClass1)
  {
    boolean bool2 = false;
    if (paramClass1 != paramClass)
    {
      boolean bool1 = bool2;
      if (paramClass1.isPrimitive()) {
        if (((paramClass1 != Float.TYPE) || (paramClass != Float.class)) && ((paramClass1 != Integer.TYPE) || (paramClass != Integer.class)) && ((paramClass1 != Boolean.TYPE) || (paramClass != Boolean.class)) && ((paramClass1 != Long.TYPE) || (paramClass != Long.class)) && ((paramClass1 != Double.TYPE) || (paramClass != Double.class)) && ((paramClass1 != Short.TYPE) || (paramClass != Short.class)) && ((paramClass1 != Byte.TYPE) || (paramClass != Byte.class)))
        {
          bool1 = bool2;
          if (paramClass1 == Character.TYPE)
          {
            bool1 = bool2;
            if (paramClass != Character.class) {}
          }
        }
        else
        {
          bool1 = true;
        }
      }
      return bool1;
    }
    return true;
  }
  
  public V get(T paramT)
  {
    if (this.b != null) {
      try
      {
        paramT = this.b.invoke(paramT, (Object[])null);
        return paramT;
      }
      catch (IllegalAccessException paramT)
      {
        throw new AssertionError();
      }
      catch (InvocationTargetException paramT)
      {
        throw new RuntimeException(paramT.getCause());
      }
    }
    if (this.c != null) {
      try
      {
        paramT = this.c.get(paramT);
        return paramT;
      }
      catch (IllegalAccessException paramT)
      {
        throw new AssertionError();
      }
    }
    throw new AssertionError();
  }
  
  public boolean isReadOnly()
  {
    return (this.a == null) && (this.c == null);
  }
  
  public void set(T paramT, V paramV)
  {
    if (this.a != null) {
      try
      {
        this.a.invoke(paramT, new Object[] { paramV });
        return;
      }
      catch (IllegalAccessException paramT)
      {
        throw new AssertionError();
      }
      catch (InvocationTargetException paramT)
      {
        throw new RuntimeException(paramT.getCause());
      }
    }
    if (this.c != null) {
      try
      {
        this.c.set(paramT, paramV);
        return;
      }
      catch (IllegalAccessException paramT)
      {
        throw new AssertionError();
      }
    }
    throw new UnsupportedOperationException("Property " + getName() + " is read-only");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/d/b/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */