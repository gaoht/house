package cn.jiguang.e;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

public final class d
{
  static final Object[] a = new Object[0];
  static final Class<?>[] b = new Class[0];
  
  public static List<Class<?>> a(Class<?> paramClass)
  {
    if (paramClass == null) {
      return null;
    }
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    a(paramClass, localLinkedHashSet);
    return new ArrayList(localLinkedHashSet);
  }
  
  private static void a(Class<?> paramClass, HashSet<Class<?>> paramHashSet)
  {
    while (paramClass != null)
    {
      Class[] arrayOfClass = paramClass.getInterfaces();
      int j = arrayOfClass.length;
      int i = 0;
      while (i < j)
      {
        Class localClass = arrayOfClass[i];
        if (paramHashSet.add(localClass)) {
          a(localClass, paramHashSet);
        }
        i += 1;
      }
      paramClass = paramClass.getSuperclass();
    }
  }
  
  static boolean a(Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
  {
    return ((paramArrayOfObject1 != null) || (paramArrayOfObject2 == null) || (paramArrayOfObject2.length <= 0)) && ((paramArrayOfObject2 != null) || (paramArrayOfObject1 == null) || (paramArrayOfObject1.length <= 0)) && ((paramArrayOfObject1 == null) || (paramArrayOfObject2 == null) || (paramArrayOfObject1.length == paramArrayOfObject2.length));
  }
  
  static Class<?>[] a(Class<?>[] paramArrayOfClass)
  {
    Object localObject;
    if (paramArrayOfClass != null)
    {
      localObject = paramArrayOfClass;
      if (paramArrayOfClass.length != 0) {}
    }
    else
    {
      localObject = b;
    }
    return (Class<?>[])localObject;
  }
  
  static Class<?>[] a(Object... paramVarArgs)
  {
    if (paramVarArgs == null) {
      return null;
    }
    if (paramVarArgs.length == 0) {
      return b;
    }
    Class[] arrayOfClass = new Class[paramVarArgs.length];
    int i = 0;
    if (i < paramVarArgs.length)
    {
      if (paramVarArgs[i] == null) {}
      for (Class localClass = null;; localClass = paramVarArgs[i].getClass())
      {
        arrayOfClass[i] = localClass;
        i += 1;
        break;
      }
    }
    return arrayOfClass;
  }
  
  static Object[] b(Object[] paramArrayOfObject)
  {
    Object[] arrayOfObject;
    if (paramArrayOfObject != null)
    {
      arrayOfObject = paramArrayOfObject;
      if (paramArrayOfObject.length != 0) {}
    }
    else
    {
      arrayOfObject = a;
    }
    return arrayOfObject;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/e/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */