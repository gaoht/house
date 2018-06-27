package com.xiaomi.channel.commonutils.reflect;

import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class a
{
  private static final Map<Class<?>, Class<?>> a = new HashMap();
  
  static
  {
    a.put(Boolean.class, Boolean.TYPE);
    a.put(Byte.class, Byte.TYPE);
    a.put(Character.class, Character.TYPE);
    a.put(Short.class, Short.TYPE);
    a.put(Integer.class, Integer.TYPE);
    a.put(Float.class, Float.TYPE);
    a.put(Long.class, Long.TYPE);
    a.put(Double.class, Double.TYPE);
    a.put(Boolean.TYPE, Boolean.TYPE);
    a.put(Byte.TYPE, Byte.TYPE);
    a.put(Character.TYPE, Character.TYPE);
    a.put(Short.TYPE, Short.TYPE);
    a.put(Integer.TYPE, Integer.TYPE);
    a.put(Float.TYPE, Float.TYPE);
    a.put(Long.TYPE, Long.TYPE);
    a.put(Double.TYPE, Double.TYPE);
  }
  
  public static <T> T a(Class<? extends Object> paramClass, Object paramObject, String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = paramClass;
    paramClass = (Class<? extends Object>)localObject2;
    for (;;)
    {
      if (paramClass == null)
      {
        try
        {
          Field localField = ((Class)localObject1).getDeclaredField(paramString);
          paramClass = localField;
          localField.setAccessible(true);
          localObject2 = localObject1;
          paramClass = localField;
        }
        catch (NoSuchFieldException localNoSuchFieldException)
        {
          for (;;)
          {
            Class localClass = ((Class)localObject1).getSuperclass();
          }
        }
        localObject1 = localObject2;
        if (localObject2 == null) {
          throw new NoSuchFieldException();
        }
      }
    }
    paramClass.setAccessible(true);
    return (T)paramClass.get(paramObject);
  }
  
  public static <T> T a(Class<? extends Object> paramClass, String paramString)
  {
    try
    {
      paramClass = a(paramClass, null, paramString);
      return paramClass;
    }
    catch (NoSuchFieldException paramClass)
    {
      paramClass.printStackTrace();
      return null;
    }
    catch (IllegalAccessException paramClass)
    {
      paramClass.printStackTrace();
    }
    return null;
  }
  
  public static <T> T a(Class<?> paramClass, String paramString, Object... paramVarArgs)
  {
    return (T)a(paramClass, paramString, a(paramVarArgs)).invoke(null, b(paramVarArgs));
  }
  
  public static <T> T a(Object paramObject, String paramString)
  {
    try
    {
      paramObject = a(paramObject.getClass(), paramObject, paramString);
      return (T)paramObject;
    }
    catch (NoSuchFieldException paramObject)
    {
      ((NoSuchFieldException)paramObject).printStackTrace();
      return null;
    }
    catch (IllegalAccessException paramObject)
    {
      for (;;)
      {
        ((IllegalAccessException)paramObject).printStackTrace();
      }
    }
  }
  
  public static <T> T a(Object paramObject, String paramString, Object... paramVarArgs)
  {
    try
    {
      paramVarArgs = b(paramObject, paramString, paramVarArgs);
      return paramVarArgs;
    }
    catch (Exception paramVarArgs)
    {
      Log.w("JavaCalls", "Meet exception when call Method '" + paramString + "' in " + paramObject, paramVarArgs);
    }
    return null;
  }
  
  public static <T> T a(String paramString1, String paramString2, Object... paramVarArgs)
  {
    try
    {
      paramVarArgs = a(Class.forName(paramString1), paramString2, paramVarArgs);
      return paramVarArgs;
    }
    catch (Exception paramVarArgs)
    {
      Log.w("JavaCalls", "Meet exception when call Method '" + paramString2 + "' in " + paramString1, paramVarArgs);
    }
    return null;
  }
  
  private static Method a(Class<?> paramClass, String paramString, Class<?>... paramVarArgs)
  {
    Method localMethod = a(paramClass.getDeclaredMethods(), paramString, paramVarArgs);
    if (localMethod == null)
    {
      if (paramClass.getSuperclass() != null) {
        return a(paramClass.getSuperclass(), paramString, paramVarArgs);
      }
      throw new NoSuchMethodException();
    }
    localMethod.setAccessible(true);
    return localMethod;
  }
  
  private static Method a(Method[] paramArrayOfMethod, String paramString, Class<?>[] paramArrayOfClass)
  {
    if (paramString == null) {
      throw new NullPointerException("Method name must not be null.");
    }
    int j = paramArrayOfMethod.length;
    int i = 0;
    while (i < j)
    {
      Method localMethod = paramArrayOfMethod[i];
      if ((localMethod.getName().equals(paramString)) && (a(localMethod.getParameterTypes(), paramArrayOfClass))) {
        return localMethod;
      }
      i += 1;
    }
    return null;
  }
  
  private static boolean a(Class<?>[] paramArrayOfClass1, Class<?>[] paramArrayOfClass2)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramArrayOfClass1 == null) {
      if ((paramArrayOfClass2 == null) || (paramArrayOfClass2.length == 0)) {
        bool1 = true;
      }
    }
    do
    {
      for (;;)
      {
        return bool1;
        bool1 = false;
      }
      if (paramArrayOfClass2 != null) {
        break;
      }
      bool1 = bool2;
    } while (paramArrayOfClass1.length == 0);
    return false;
    if (paramArrayOfClass1.length != paramArrayOfClass2.length) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      bool1 = bool2;
      if (i >= paramArrayOfClass1.length) {
        break;
      }
      if ((!paramArrayOfClass1[i].isAssignableFrom(paramArrayOfClass2[i])) && ((!a.containsKey(paramArrayOfClass1[i])) || (!((Class)a.get(paramArrayOfClass1[i])).equals(a.get(paramArrayOfClass2[i]))))) {
        return false;
      }
      i += 1;
    }
  }
  
  private static Class<?>[] a(Object... paramVarArgs)
  {
    Class[] arrayOfClass = null;
    Object localObject = arrayOfClass;
    if (paramVarArgs != null)
    {
      localObject = arrayOfClass;
      if (paramVarArgs.length > 0)
      {
        arrayOfClass = new Class[paramVarArgs.length];
        int i = 0;
        while (i < paramVarArgs.length)
        {
          localObject = paramVarArgs[i];
          if ((localObject != null) && ((localObject instanceof a)))
          {
            arrayOfClass[i] = ((a)localObject).a;
            i += 1;
          }
          else
          {
            if (localObject == null) {}
            for (localObject = null;; localObject = localObject.getClass())
            {
              arrayOfClass[i] = localObject;
              break;
            }
          }
        }
        localObject = arrayOfClass;
      }
    }
    return (Class<?>[])localObject;
  }
  
  public static <T> T b(Object paramObject, String paramString, Object... paramVarArgs)
  {
    return (T)a(paramObject.getClass(), paramString, a(paramVarArgs)).invoke(paramObject, b(paramVarArgs));
  }
  
  private static Object[] b(Object... paramVarArgs)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramVarArgs != null)
    {
      localObject1 = localObject2;
      if (paramVarArgs.length > 0)
      {
        localObject1 = new Object[paramVarArgs.length];
        int i = 0;
        if (i < paramVarArgs.length)
        {
          localObject2 = paramVarArgs[i];
          if ((localObject2 != null) && ((localObject2 instanceof a))) {
            localObject1[i] = ((a)localObject2).b;
          }
          for (;;)
          {
            i += 1;
            break;
            localObject1[i] = localObject2;
          }
        }
      }
    }
    return (Object[])localObject1;
  }
  
  public static class a<T>
  {
    public final Class<? extends T> a;
    public final T b;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/channel/commonutils/reflect/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */