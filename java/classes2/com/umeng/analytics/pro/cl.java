package com.umeng.analytics.pro;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class cl
{
  public static ck a(Class<? extends ck> paramClass, int paramInt)
  {
    try
    {
      paramClass = (ck)paramClass.getMethod("findByValue", new Class[] { Integer.TYPE }).invoke(null, new Object[] { Integer.valueOf(paramInt) });
      return paramClass;
    }
    catch (NoSuchMethodException paramClass)
    {
      return null;
    }
    catch (IllegalAccessException paramClass)
    {
      return null;
    }
    catch (InvocationTargetException paramClass) {}
    return null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/umeng/analytics/pro/cl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */