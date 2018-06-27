package cn.jiguang.e;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

final class b
{
  private static final Class<?>[] a = { Byte.TYPE, Short.TYPE, Character.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE };
  private static final Map<Class<?>, Class<?>> b;
  private static final Map<Class<?>, Class<?>> c;
  
  static
  {
    Object localObject = new HashMap();
    b = (Map)localObject;
    ((Map)localObject).put(Boolean.TYPE, Boolean.class);
    b.put(Byte.TYPE, Byte.class);
    b.put(Character.TYPE, Character.class);
    b.put(Short.TYPE, Short.class);
    b.put(Integer.TYPE, Integer.class);
    b.put(Long.TYPE, Long.class);
    b.put(Double.TYPE, Double.class);
    b.put(Float.TYPE, Float.class);
    b.put(Void.TYPE, Void.TYPE);
    c = new HashMap();
    localObject = b.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Class localClass1 = (Class)((Iterator)localObject).next();
      Class localClass2 = (Class)b.get(localClass1);
      if (!localClass1.equals(localClass2)) {
        c.put(localClass2, localClass1);
      }
    }
  }
  
  private static float a(Class<?>[] paramArrayOfClass1, Class<?>[] paramArrayOfClass2)
  {
    int i = 0;
    float f3 = 0.0F;
    Object localObject1;
    Class<?> localClass;
    if (i < paramArrayOfClass1.length)
    {
      localObject1 = paramArrayOfClass1[i];
      localClass = paramArrayOfClass2[i];
      if (localClass.isPrimitive())
      {
        if (((Class)localObject1).isPrimitive()) {
          break label229;
        }
        localObject1 = a((Class)localObject1);
      }
    }
    label212:
    label229:
    for (float f1 = 0.1F;; f1 = 0.0F)
    {
      int j = 0;
      for (;;)
      {
        f2 = f1;
        if (localObject1 == localClass) {
          break;
        }
        f2 = f1;
        if (j >= a.length) {
          break;
        }
        Object localObject2 = localObject1;
        f2 = f1;
        if (localObject1 == a[j])
        {
          f1 += 0.1F;
          localObject2 = localObject1;
          f2 = f1;
          if (j < a.length - 1)
          {
            localObject2 = a[(j + 1)];
            f2 = f1;
          }
        }
        j += 1;
        localObject1 = localObject2;
        f1 = f2;
      }
      float f2 = 0.0F;
      for (;;)
      {
        f1 = f2;
        if (localObject1 != null)
        {
          f1 = f2;
          if (!localClass.equals(localObject1))
          {
            if ((!localClass.isInterface()) || (!a((Class)localObject1, localClass, true))) {
              break label212;
            }
            f1 = f2 + 0.25F;
          }
        }
        f2 = f1;
        if (localObject1 == null) {
          f2 = f1 + 1.5F;
        }
        f3 += f2;
        i += 1;
        break;
        f2 += 1.0F;
        localObject1 = ((Class)localObject1).getSuperclass();
      }
      return f3;
    }
  }
  
  static int a(Class<?>[] paramArrayOfClass1, Class<?>[] paramArrayOfClass2, Class<?>[] paramArrayOfClass3)
  {
    float f1 = a(paramArrayOfClass3, paramArrayOfClass1);
    float f2 = a(paramArrayOfClass3, paramArrayOfClass2);
    if (f1 < f2) {
      return -1;
    }
    if (f2 < f1) {
      return 1;
    }
    return 0;
  }
  
  private static Class<?> a(Class<?> paramClass)
  {
    return (Class)c.get(paramClass);
  }
  
  private static boolean a(Class<?> paramClass1, Class<?> paramClass2, boolean paramBoolean)
  {
    if (paramClass2 == null) {
      return false;
    }
    if (paramClass1 == null) {
      return !paramClass2.isPrimitive();
    }
    Object localObject2 = paramClass1;
    if (paramBoolean)
    {
      Object localObject1 = paramClass1;
      if (paramClass1.isPrimitive())
      {
        localObject1 = paramClass1;
        if (!paramClass2.isPrimitive())
        {
          localObject2 = paramClass1;
          if (paramClass1 != null)
          {
            localObject2 = paramClass1;
            if (paramClass1.isPrimitive()) {
              localObject2 = (Class)b.get(paramClass1);
            }
          }
          localObject1 = localObject2;
          if (localObject2 == null) {
            return false;
          }
        }
      }
      localObject2 = localObject1;
      if (paramClass2.isPrimitive())
      {
        localObject2 = localObject1;
        if (!((Class)localObject1).isPrimitive())
        {
          paramClass1 = a((Class)localObject1);
          localObject2 = paramClass1;
          if (paramClass1 == null) {
            return false;
          }
        }
      }
    }
    if (localObject2.equals(paramClass2)) {
      return true;
    }
    if (((Class)localObject2).isPrimitive())
    {
      if (!paramClass2.isPrimitive()) {
        return false;
      }
      if (Integer.TYPE.equals(localObject2)) {
        return (Long.TYPE.equals(paramClass2)) || (Float.TYPE.equals(paramClass2)) || (Double.TYPE.equals(paramClass2));
      }
      if (Long.TYPE.equals(localObject2)) {
        return (Float.TYPE.equals(paramClass2)) || (Double.TYPE.equals(paramClass2));
      }
      if (Boolean.TYPE.equals(localObject2)) {
        return false;
      }
      if (Double.TYPE.equals(localObject2)) {
        return false;
      }
      if (Float.TYPE.equals(localObject2)) {
        return Double.TYPE.equals(paramClass2);
      }
      if (Character.TYPE.equals(localObject2)) {
        return (Integer.TYPE.equals(paramClass2)) || (Long.TYPE.equals(paramClass2)) || (Float.TYPE.equals(paramClass2)) || (Double.TYPE.equals(paramClass2));
      }
      if (Short.TYPE.equals(localObject2)) {
        return (Integer.TYPE.equals(paramClass2)) || (Long.TYPE.equals(paramClass2)) || (Float.TYPE.equals(paramClass2)) || (Double.TYPE.equals(paramClass2));
      }
      if (Byte.TYPE.equals(localObject2)) {
        return (Short.TYPE.equals(paramClass2)) || (Integer.TYPE.equals(paramClass2)) || (Long.TYPE.equals(paramClass2)) || (Float.TYPE.equals(paramClass2)) || (Double.TYPE.equals(paramClass2));
      }
      return false;
    }
    return paramClass2.isAssignableFrom((Class)localObject2);
  }
  
  static boolean a(AccessibleObject paramAccessibleObject)
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
  
  static boolean a(Member paramMember)
  {
    return (paramMember != null) && (Modifier.isPublic(paramMember.getModifiers())) && (!paramMember.isSynthetic());
  }
  
  static boolean a(Class<?>[] paramArrayOfClass1, Class<?>[] paramArrayOfClass2, boolean paramBoolean)
  {
    if (!d.a(paramArrayOfClass1, paramArrayOfClass2)) {
      return false;
    }
    Object localObject = paramArrayOfClass1;
    if (paramArrayOfClass1 == null) {
      localObject = d.b;
    }
    paramArrayOfClass1 = paramArrayOfClass2;
    if (paramArrayOfClass2 == null) {
      paramArrayOfClass1 = d.b;
    }
    int i = 0;
    for (;;)
    {
      if (i >= localObject.length) {
        break label62;
      }
      if (!a(localObject[i], paramArrayOfClass1[i], true)) {
        break;
      }
      i += 1;
    }
    label62:
    return true;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/e/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */