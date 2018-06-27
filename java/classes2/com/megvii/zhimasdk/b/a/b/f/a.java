package com.megvii.zhimasdk.b.a.b.f;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class a
{
  public static <T> T a(T paramT)
  {
    if (paramT == null) {
      return null;
    }
    if ((paramT instanceof Cloneable))
    {
      Object localObject = paramT.getClass();
      try
      {
        localObject = ((Class)localObject).getMethod("clone", (Class[])null);
        throw new CloneNotSupportedException();
      }
      catch (NoSuchMethodException paramT)
      {
        try
        {
          paramT = ((Method)localObject).invoke(paramT, (Object[])null);
          return paramT;
        }
        catch (InvocationTargetException paramT)
        {
          paramT = paramT.getCause();
          if (!(paramT instanceof CloneNotSupportedException)) {
            break label72;
          }
          throw ((CloneNotSupportedException)paramT);
          throw new Error("Unexpected exception", paramT);
        }
        catch (IllegalAccessException paramT)
        {
          throw new IllegalAccessError(paramT.getMessage());
        }
        paramT = paramT;
        throw new NoSuchMethodError(paramT.getMessage());
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/b/f/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */