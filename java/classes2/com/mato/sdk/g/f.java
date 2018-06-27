package com.mato.sdk.g;

import android.text.TextUtils;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class f
{
  private static Map<String, Field> a = new HashMap();
  private static final int b = 7;
  
  public static Object a(Object paramObject, String paramString)
  {
    return a(paramObject, paramString, new Class[0], new Object[0]);
  }
  
  private static Object a(Object paramObject, String paramString, Class<?>[] paramArrayOfClass)
  {
    return a(paramObject, paramString, paramArrayOfClass, new Object[0]);
  }
  
  private static Object a(Object paramObject, String paramString, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject)
  {
    try
    {
      paramString = a(paramObject.getClass(), paramString, paramArrayOfClass);
      paramString.setAccessible(true);
      paramObject = paramString.invoke(paramObject, paramArrayOfObject);
      return paramObject;
    }
    catch (Exception paramObject)
    {
      throw new RuntimeException((Throwable)paramObject);
    }
  }
  
  public static Object a(Object paramObject, String paramString, Object[] paramArrayOfObject, Class<?>... paramVarArgs)
    throws Exception
  {
    if ((paramObject instanceof Class)) {}
    for (Class localClass = (Class)paramObject;; localClass = paramObject.getClass()) {
      return localClass.getMethod(paramString, paramVarArgs).invoke(paramObject, paramArrayOfObject);
    }
  }
  
  private static String a(Class<?> paramClass, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramClass.toString()).append("#").append(paramString);
    return localStringBuilder.toString();
  }
  
  private static Field a(Class<?> arg0, String paramString, boolean paramBoolean)
  {
    if (??? != null) {
      paramBoolean = true;
    }
    String str;
    for (;;)
    {
      a.a(paramBoolean, "The class must not be null", new Object[0]);
      if (!TextUtils.isEmpty(paramString))
      {
        paramBoolean = true;
        a.a(paramBoolean, "The field name must not be blank/empty", new Object[0]);
        ??? = new StringBuilder();
        ((StringBuilder)???).append(???.toString()).append("#").append(paramString);
        str = ((StringBuilder)???).toString();
      }
      synchronized (a)
      {
        ??? = (Field)a.get(str);
        if (??? != null)
        {
          if (!((Field)???).isAccessible()) {
            ((Field)???).setAccessible(true);
          }
          return (Field)???;
          paramBoolean = false;
          continue;
          paramBoolean = false;
        }
      }
    }
    ??? = ???;
    for (;;)
    {
      if (??? != null) {
        try
        {
          Field localField = ((Class)???).getDeclaredField(paramString);
          if (!Modifier.isPublic(localField.getModifiers())) {
            localField.setAccessible(true);
          }
          synchronized (a)
          {
            a.put(str, localField);
            return localField;
          }
        }
        catch (NoSuchFieldException localNoSuchFieldException1)
        {
          ??? = ((Class)???).getSuperclass();
        }
      }
    }
    Iterator localIterator = i.a(???).iterator();
    ??? = null;
    for (;;)
    {
      Object localObject3;
      if (localIterator.hasNext()) {
        localObject3 = (Class)localIterator.next();
      }
      try
      {
        localObject3 = ((Class)localObject3).getField(paramString);
        if (??? == null) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          a.a(paramBoolean, "Reference to field %s is ambiguous relative to %s; a matching field exists on two or more implemented interfaces.", new Object[] { paramString, ??? });
          ??? = localObject3;
          break;
        }
        synchronized (a)
        {
          a.put(str, ???);
          return (Field)???;
        }
      }
      catch (NoSuchFieldException localNoSuchFieldException2) {}
    }
  }
  
  private static Method a(Class<?> paramClass, String paramString, Class<?>[] paramArrayOfClass)
    throws Exception
  {
    try
    {
      Method localMethod1 = paramClass.getDeclaredMethod(paramString, paramArrayOfClass);
      return localMethod1;
    }
    catch (NoSuchMethodException localNoSuchMethodException1)
    {
      try
      {
        Method localMethod2 = paramClass.getMethod(paramString, paramArrayOfClass);
        return localMethod2;
      }
      catch (NoSuchMethodException localNoSuchMethodException2)
      {
        if (paramClass.getSuperclass() == null) {
          return null;
        }
      }
    }
    return a(paramClass.getSuperclass(), paramString, paramArrayOfClass);
  }
  
  public static void a(Class<?> paramClass, String paramString, Object paramObject)
    throws IllegalAccessException
  {
    Field localField = a(paramClass, paramString, true);
    boolean bool;
    if (localField != null)
    {
      bool = true;
      a.a(bool, "Cannot locate field %s on %s", new Object[] { paramString, paramClass });
      if (localField == null) {
        break label130;
      }
      bool = true;
      label40:
      a.a(bool, "The field must not be null", new Object[0]);
      a.a(Modifier.isStatic(localField.getModifiers()), "The field %s.%s is not static", new Object[] { localField.getDeclaringClass().getName(), localField.getName() });
      if (localField == null) {
        break label135;
      }
      bool = true;
      label93:
      a.a(bool, "The field must not be null", new Object[0]);
      if (localField.isAccessible()) {
        break label140;
      }
      localField.setAccessible(true);
    }
    for (;;)
    {
      localField.set(null, paramObject);
      return;
      bool = false;
      break;
      label130:
      bool = false;
      break label40;
      label135:
      bool = false;
      break label93;
      label140:
      a(localField);
    }
  }
  
  public static void a(Object paramObject1, String paramString, Object paramObject2)
    throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException
  {
    paramString = paramObject1.getClass().getDeclaredField(paramString);
    paramString.setAccessible(true);
    paramString.set(paramObject1, paramObject2);
  }
  
  private static void a(Field paramField, Object paramObject1, Object paramObject2, boolean paramBoolean)
    throws IllegalAccessException
  {
    boolean bool;
    if (paramField != null)
    {
      bool = true;
      a.a(bool, "The field must not be null", new Object[0]);
      if ((!paramBoolean) || (paramField.isAccessible())) {
        break label47;
      }
      paramField.setAccessible(true);
    }
    for (;;)
    {
      paramField.set(null, paramObject2);
      return;
      bool = false;
      break;
      label47:
      a(paramField);
    }
  }
  
  private static void a(Field paramField, Object paramObject, boolean paramBoolean)
    throws IllegalAccessException
  {
    if (paramField != null)
    {
      paramBoolean = true;
      a.a(paramBoolean, "The field must not be null", new Object[0]);
      a.a(Modifier.isStatic(paramField.getModifiers()), "The field %s.%s is not static", new Object[] { paramField.getDeclaringClass().getName(), paramField.getName() });
      if (paramField == null) {
        break label89;
      }
      paramBoolean = true;
      label55:
      a.a(paramBoolean, "The field must not be null", new Object[0]);
      if (paramField.isAccessible()) {
        break label94;
      }
      paramField.setAccessible(true);
    }
    for (;;)
    {
      paramField.set(null, paramObject);
      return;
      paramBoolean = false;
      break;
      label89:
      paramBoolean = false;
      break label55;
      label94:
      a(paramField);
    }
  }
  
  private static boolean a(int paramInt)
  {
    return (paramInt & 0x7) == 0;
  }
  
  private static boolean a(AccessibleObject paramAccessibleObject)
  {
    if ((paramAccessibleObject == null) || (paramAccessibleObject.isAccessible())) {
      return false;
    }
    Member localMember = (Member)paramAccessibleObject;
    if ((!paramAccessibleObject.isAccessible()) && (Modifier.isPublic(localMember.getModifiers())))
    {
      if ((localMember.getDeclaringClass().getModifiers() & 0x7) == 0) {}
      for (int i = 1; i != 0; i = 0) {
        try
        {
          paramAccessibleObject.setAccessible(true);
          return true;
        }
        catch (SecurityException paramAccessibleObject) {}
      }
    }
    return false;
  }
  
  public static Object b(Object paramObject, String paramString)
    throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException
  {
    paramString = paramObject.getClass().getDeclaredField(paramString);
    paramString.setAccessible(true);
    return paramString.get(paramObject);
  }
  
  static final class a
  {
    static void a(boolean paramBoolean, String paramString, Object... paramVarArgs)
    {
      if (!paramBoolean) {
        throw new IllegalArgumentException(String.format(paramString, paramVarArgs));
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/g/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */