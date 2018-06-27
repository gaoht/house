package com.mob.tools.utils;

import com.mob.tools.gui.CachePool;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class ReflectHelper
{
  private static CachePool<String, Constructor<?>> cachedConstr = new CachePool(5);
  private static CachePool<String, Method> cachedMethod;
  private static HashMap<String, Class<?>> classMap;
  private static HashMap<Class<?>, String> nameMap;
  private static HashSet<String> packageSet = new HashSet();
  
  static
  {
    packageSet.add("java.lang");
    packageSet.add("java.io");
    packageSet.add("java.nio");
    packageSet.add("java.net");
    packageSet.add("java.util");
    packageSet.add("com.mob.tools");
    packageSet.add("com.mob.tools.gui");
    packageSet.add("com.mob.tools.log");
    packageSet.add("com.mob.tools.network");
    packageSet.add("com.mob.tools.utils");
    classMap = new HashMap();
    classMap.put("double", Double.TYPE);
    classMap.put("float", Float.TYPE);
    classMap.put("long", Long.TYPE);
    classMap.put("int", Integer.TYPE);
    classMap.put("short", Short.TYPE);
    classMap.put("byte", Byte.TYPE);
    classMap.put("char", Character.TYPE);
    classMap.put("boolean", Boolean.TYPE);
    classMap.put("Object", Object.class);
    classMap.put("String", String.class);
    classMap.put("Thread", Thread.class);
    classMap.put("Runnable", Runnable.class);
    classMap.put("System", System.class);
    classMap.put("double", Double.class);
    classMap.put("Float", Float.class);
    classMap.put("Long", Long.class);
    classMap.put("Integer", Integer.class);
    classMap.put("Short", Short.class);
    classMap.put("Byte", Byte.class);
    classMap.put("Character", Character.class);
    classMap.put("Boolean", Boolean.class);
    nameMap = new HashMap();
    Iterator localIterator = classMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      nameMap.put(localEntry.getValue(), localEntry.getKey());
    }
    cachedMethod = new CachePool(25);
  }
  
  public static Object createProxy(HashMap<String, ReflectRunnable<Object, Object[]>> paramHashMap, Class<?>... paramVarArgs)
    throws Throwable
  {
    if (paramVarArgs.length == 0) {
      return null;
    }
    Proxy.newProxyInstance(paramVarArgs[0].getClassLoader(), paramVarArgs, new InvocationHandler()
    {
      public Object invoke(Object paramAnonymousObject, Method paramAnonymousMethod, Object[] paramAnonymousArrayOfObject)
        throws Throwable
      {
        paramAnonymousObject = (ReflectHelper.ReflectRunnable)this.val$proxyHandler.get(paramAnonymousMethod.getName());
        if (paramAnonymousObject != null) {
          return ((ReflectHelper.ReflectRunnable)paramAnonymousObject).run(paramAnonymousArrayOfObject);
        }
        throw new NoSuchMethodException();
      }
    });
  }
  
  public static Class<?> getClass(String paramString)
    throws Throwable
  {
    Class localClass1 = getImportedClass(paramString);
    Class localClass2 = localClass1;
    if (localClass1 == null) {
      localClass2 = localClass1;
    }
    try
    {
      localClass1 = Class.forName(paramString);
      localClass2 = localClass1;
      if (localClass1 != null)
      {
        localClass2 = localClass1;
        classMap.put(paramString, localClass1);
        localClass2 = localClass1;
      }
      return localClass2;
    }
    catch (Throwable paramString) {}
    return localClass2;
  }
  
  /* Error */
  private static Class<?> getImportedClass(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 60	com/mob/tools/utils/ReflectHelper:classMap	Ljava/util/HashMap;
    //   6: aload_0
    //   7: invokevirtual 215	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10: checkcast 186	java/lang/Class
    //   13: astore_2
    //   14: aload_2
    //   15: astore_1
    //   16: aload_2
    //   17: ifnonnull +77 -> 94
    //   20: getstatic 31	com/mob/tools/utils/ReflectHelper:packageSet	Ljava/util/HashSet;
    //   23: invokevirtual 216	java/util/HashSet:iterator	()Ljava/util/Iterator;
    //   26: astore_3
    //   27: aload_2
    //   28: astore_1
    //   29: aload_3
    //   30: invokeinterface 157 1 0
    //   35: ifeq +59 -> 94
    //   38: aload_3
    //   39: invokeinterface 161 1 0
    //   44: checkcast 113	java/lang/String
    //   47: astore_1
    //   48: new 218	java/lang/StringBuilder
    //   51: dup
    //   52: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   55: aload_1
    //   56: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: ldc -31
    //   61: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: aload_0
    //   65: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: invokestatic 233	com/mob/tools/utils/ReflectHelper:importClass	(Ljava/lang/String;)Ljava/lang/String;
    //   74: pop
    //   75: getstatic 60	com/mob/tools/utils/ReflectHelper:classMap	Ljava/util/HashMap;
    //   78: aload_0
    //   79: invokevirtual 215	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   82: checkcast 186	java/lang/Class
    //   85: astore_2
    //   86: aload_2
    //   87: astore_1
    //   88: aload_2
    //   89: ifnull -60 -> 29
    //   92: aload_2
    //   93: astore_1
    //   94: ldc 2
    //   96: monitorexit
    //   97: aload_1
    //   98: areturn
    //   99: astore_0
    //   100: ldc 2
    //   102: monitorexit
    //   103: aload_0
    //   104: athrow
    //   105: astore_1
    //   106: goto -31 -> 75
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	paramString	String
    //   15	83	1	localObject	Object
    //   105	1	1	localThrowable	Throwable
    //   13	80	2	localClass	Class
    //   26	13	3	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   3	14	99	finally
    //   20	27	99	finally
    //   29	48	99	finally
    //   48	75	99	finally
    //   75	86	99	finally
    //   48	75	105	java/lang/Throwable
  }
  
  public static <T> T getInstanceField(Object paramObject, String paramString)
    throws Throwable
  {
    try
    {
      Object localObject = onGetInstanceField(paramObject, paramString);
      return (T)localObject;
    }
    catch (Throwable localThrowable)
    {
      if ((localThrowable instanceof NoSuchFieldException)) {
        throw localThrowable;
      }
      throw new Throwable("className: " + paramObject.getClass() + ", fieldName: " + paramString, localThrowable);
    }
  }
  
  public static String getName(Class<?> paramClass)
    throws Throwable
  {
    String str2 = (String)nameMap.get(paramClass);
    String str1 = str2;
    if (str2 == null)
    {
      str1 = paramClass.getSimpleName();
      if (classMap.containsKey(str1)) {
        nameMap.remove(classMap.get(str1));
      }
      classMap.put(str1, paramClass);
      nameMap.put(paramClass, str1);
    }
    return str1;
  }
  
  public static <T> T getStaticField(String paramString1, String paramString2)
    throws Throwable
  {
    try
    {
      Object localObject = onGetStaticField(paramString1, paramString2);
      return (T)localObject;
    }
    catch (Throwable localThrowable)
    {
      if ((localThrowable instanceof NoSuchFieldException)) {
        throw localThrowable;
      }
      throw new Throwable("className: " + paramString1 + ", fieldName: " + paramString2, localThrowable);
    }
  }
  
  private static Class<?>[] getTypes(Object[] paramArrayOfObject)
  {
    Class[] arrayOfClass = new Class[paramArrayOfObject.length];
    int i = 0;
    if (i < paramArrayOfObject.length)
    {
      if (paramArrayOfObject[i] == null) {}
      for (Class localClass = null;; localClass = paramArrayOfObject[i].getClass())
      {
        arrayOfClass[i] = localClass;
        i += 1;
        break;
      }
    }
    return arrayOfClass;
  }
  
  public static String importClass(String paramString)
    throws Throwable
  {
    return importClass(null, paramString);
  }
  
  public static String importClass(String paramString1, String paramString2)
    throws Throwable
  {
    try
    {
      if (paramString2.endsWith(".*"))
      {
        packageSet.add(paramString2.substring(0, paramString2.length() - 2));
        paramString1 = "*";
        return paramString1;
      }
      paramString2 = Class.forName(paramString2);
      if (paramString1 == null) {
        paramString1 = paramString2.getSimpleName();
      }
      for (;;)
      {
        if (classMap.containsKey(paramString1)) {
          nameMap.remove(classMap.get(paramString1));
        }
        classMap.put(paramString1, paramString2);
        nameMap.put(paramString2, paramString1);
        break;
      }
    }
    finally {}
  }
  
  public static <T> T invokeInstanceMethod(Object paramObject, String paramString, Object... paramVarArgs)
    throws Throwable
  {
    try
    {
      paramVarArgs = invokeMethod(null, paramObject, paramString, paramVarArgs);
      return paramVarArgs;
    }
    catch (Throwable paramVarArgs)
    {
      if ((paramVarArgs instanceof NoSuchMethodException)) {
        throw paramVarArgs;
      }
      throw new Throwable("className: " + paramObject.getClass() + ", methodName: " + paramString, paramVarArgs);
    }
  }
  
  private static <T> T invokeMethod(String paramString1, Object paramObject, String paramString2, Object... paramVarArgs)
    throws Throwable
  {
    Object localObject2;
    Object localObject1;
    boolean bool;
    if (paramObject == null)
    {
      paramString1 = getImportedClass(paramString1);
      localObject2 = paramString1.getName() + "#" + paramString2 + "#" + paramVarArgs.length;
      localObject3 = (Method)cachedMethod.get(localObject2);
      localObject1 = getTypes(paramVarArgs);
      if (localObject3 == null) {
        break label165;
      }
      bool = Modifier.isStatic(((Method)localObject3).getModifiers());
      if (paramObject != null) {
        break label140;
      }
    }
    for (;;)
    {
      if ((bool) && (matchParams(((Method)localObject3).getParameterTypes(), (Class[])localObject1)))
      {
        ((Method)localObject3).setAccessible(true);
        if (((Method)localObject3).getReturnType() == Void.TYPE)
        {
          ((Method)localObject3).invoke(paramObject, paramVarArgs);
          return null;
          paramString1 = paramObject.getClass();
          break;
          label140:
          if (!bool)
          {
            bool = true;
            continue;
          }
          bool = false;
          continue;
        }
        return (T)((Method)localObject3).invoke(paramObject, paramVarArgs);
      }
    }
    label165:
    Object localObject4 = new ArrayList();
    while (paramString1 != null)
    {
      ((ArrayList)localObject4).add(paramString1);
      paramString1 = paramString1.getSuperclass();
    }
    paramString1 = new ArrayList();
    Object localObject3 = new ArrayList();
    localObject4 = ((ArrayList)localObject4).iterator();
    while (((Iterator)localObject4).hasNext())
    {
      Method[] arrayOfMethod = ((Class)((Iterator)localObject4).next()).getDeclaredMethods();
      j = arrayOfMethod.length;
      i = 0;
      while (i < j)
      {
        Method localMethod = arrayOfMethod[i];
        bool = Modifier.isStatic(localMethod.getModifiers());
        if (paramObject == null) {}
        while ((localMethod.getName().equals(paramString2)) && (bool))
        {
          Class[] arrayOfClass = localMethod.getParameterTypes();
          if (matchParams(arrayOfClass, (Class[])localObject1))
          {
            cachedMethod.put(localObject2, localMethod);
            localMethod.setAccessible(true);
            if (localMethod.getReturnType() == Void.TYPE)
            {
              localMethod.invoke(paramObject, paramVarArgs);
              return null;
              if (!bool) {
                bool = true;
              } else {
                bool = false;
              }
            }
            else
            {
              return (T)localMethod.invoke(paramObject, paramVarArgs);
            }
          }
          else if ((arrayOfClass.length > 0) && (arrayOfClass[(arrayOfClass.length - 1)].isArray()) && (localObject1.length >= arrayOfClass.length - 1))
          {
            paramString1.add(localMethod);
            ((ArrayList)localObject3).add(arrayOfClass);
          }
        }
        i += 1;
      }
    }
    int i = 0;
    if (i < ((ArrayList)localObject3).size())
    {
      localObject2 = (Class[])((ArrayList)localObject3).get(i);
      localObject4 = localObject2[(localObject2.length - 1)].getComponentType();
      if (tryMatchParams((Class[])localObject2, (Class[])localObject1))
      {
        paramString2 = new Object[paramVarArgs.length + 1];
        System.arraycopy(paramVarArgs, 0, paramString2, 0, paramVarArgs.length);
        paramString2[paramVarArgs.length] = Array.newInstance((Class)localObject4, 0);
        paramString1 = (Method)paramString1.get(i);
        paramString1.setAccessible(true);
        if (paramString1.getReturnType() == Void.TYPE)
        {
          paramString1.invoke(paramObject, paramString2);
          return null;
        }
        return (T)paramString1.invoke(paramObject, paramString2);
      }
      j = localObject2.length - 1;
      if (j >= localObject1.length) {
        break label765;
      }
      if (localObject1[j].equals(localObject4)) {}
    }
    label765:
    for (int j = 0;; j = 1)
    {
      if (j != 0)
      {
        int k = localObject1.length - localObject2.length + 1;
        localObject1 = Array.newInstance((Class)localObject4, k);
        j = 0;
        for (;;)
        {
          if (j < k)
          {
            Array.set(localObject1, j, paramVarArgs[(localObject2.length - 1 + j)]);
            j += 1;
            continue;
            j += 1;
            break;
          }
        }
        paramString2 = new Object[localObject2.length];
        System.arraycopy(paramVarArgs, 0, paramString2, 0, localObject2.length - 1);
        paramString2[(localObject2.length - 1)] = localObject1;
        paramString1 = (Method)paramString1.get(i);
        paramString1.setAccessible(true);
        if (paramString1.getReturnType() == Void.TYPE)
        {
          paramString1.invoke(paramObject, paramString2);
          return null;
        }
        return (T)paramString1.invoke(paramObject, paramString2);
      }
      i += 1;
      break;
      throw new NoSuchMethodException("className: " + paramObject.getClass() + ", methodName: " + paramString2);
    }
  }
  
  public static <T> T invokeStaticMethod(String paramString1, String paramString2, Object... paramVarArgs)
    throws Throwable
  {
    try
    {
      paramVarArgs = invokeMethod(paramString1, null, paramString2, paramVarArgs);
      return paramVarArgs;
    }
    catch (Throwable paramVarArgs)
    {
      if ((paramVarArgs instanceof NoSuchMethodException)) {
        throw paramVarArgs;
      }
      throw new Throwable("className: " + paramString1 + ", methodName: " + paramString2, paramVarArgs);
    }
  }
  
  private static boolean matchParams(Class<?>[] paramArrayOfClass1, Class<?>[] paramArrayOfClass2)
  {
    int i;
    if (paramArrayOfClass1.length == paramArrayOfClass2.length) {
      i = 0;
    }
    while (i < paramArrayOfClass2.length)
    {
      if ((paramArrayOfClass2[i] != null) && (!primitiveEquals(paramArrayOfClass1[i], paramArrayOfClass2[i])) && (!paramArrayOfClass1[i].isAssignableFrom(paramArrayOfClass2[i]))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private static Object newArray(String paramString, Object... paramVarArgs)
    throws Throwable
  {
    int j = 0;
    int i = 0;
    for (String str = paramString; str.startsWith("["); str = str.substring(1)) {
      i += 1;
    }
    int[] arrayOfInt;
    if (i == paramVarArgs.length)
    {
      arrayOfInt = new int[i];
      for (;;)
      {
        if (j < i) {
          try
          {
            arrayOfInt[j] = Integer.parseInt(String.valueOf(paramVarArgs[j]));
            j += 1;
          }
          catch (Throwable paramVarArgs)
          {
            arrayOfInt = null;
          }
        }
      }
    }
    for (;;)
    {
      if (arrayOfInt != null)
      {
        if ("B".equals(str)) {
          paramVarArgs = Byte.TYPE;
        }
        while (paramVarArgs != null)
        {
          return Array.newInstance(paramVarArgs, arrayOfInt);
          if ("S".equals(str)) {
            paramVarArgs = Short.TYPE;
          } else if ("I".equals(str)) {
            paramVarArgs = Integer.TYPE;
          } else if ("J".equals(str)) {
            paramVarArgs = Long.TYPE;
          } else if ("F".equals(str)) {
            paramVarArgs = Float.TYPE;
          } else if ("D".equals(str)) {
            paramVarArgs = Double.TYPE;
          } else if ("Z".equals(str)) {
            paramVarArgs = Boolean.TYPE;
          } else if ("C".equals(str)) {
            paramVarArgs = Character.TYPE;
          } else {
            paramVarArgs = getImportedClass(str);
          }
        }
      }
      throw new NoSuchMethodException("className: [" + paramString + ", methodName: <init>");
      continue;
      arrayOfInt = null;
    }
  }
  
  public static Object newInstance(String paramString, Object... paramVarArgs)
    throws Throwable
  {
    try
    {
      paramVarArgs = onNewInstance(paramString, paramVarArgs);
      return paramVarArgs;
    }
    catch (Throwable paramVarArgs)
    {
      if ((paramVarArgs instanceof NoSuchMethodException)) {
        throw paramVarArgs;
      }
      throw new Throwable("className: " + paramString + ", methodName: <init>", paramVarArgs);
    }
  }
  
  private static Object onGetElement(Object paramObject, String paramString)
    throws Throwable
  {
    if ("length".equals(paramString)) {
      return Integer.valueOf(Array.getLength(paramObject));
    }
    if ((paramString.startsWith("[")) && (paramString.endsWith("]"))) {
      try
      {
        i = Integer.parseInt(paramString.substring(1, paramString.length() - 1));
        if (i != -1) {
          return Array.get(paramObject, i);
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          int i = -1;
        }
      }
    }
    throw new NoSuchFieldException("className: " + paramObject.getClass() + ", fieldName: " + paramString);
  }
  
  private static <T> T onGetInstanceField(Object paramObject, String paramString)
    throws Throwable
  {
    if (paramObject.getClass().isArray()) {
      return (T)onGetElement(paramObject, paramString);
    }
    Object localObject3 = new ArrayList();
    for (Object localObject1 = paramObject.getClass(); localObject1 != null; localObject1 = ((Class)localObject1).getSuperclass()) {
      ((ArrayList)localObject3).add(localObject1);
    }
    localObject3 = ((ArrayList)localObject3).iterator();
    for (;;)
    {
      if (((Iterator)localObject3).hasNext())
      {
        localObject1 = (Class)((Iterator)localObject3).next();
        try
        {
          localObject1 = ((Class)localObject1).getDeclaredField(paramString);
          if ((localObject1 != null) && (!Modifier.isStatic(((Field)localObject1).getModifiers())))
          {
            ((Field)localObject1).setAccessible(true);
            return (T)((Field)localObject1).get(paramObject);
          }
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            Object localObject2 = null;
          }
        }
      }
    }
    throw new NoSuchFieldException("className: " + paramObject.getClass() + ", fieldName: " + paramString);
  }
  
  private static <T> T onGetStaticField(String paramString1, String paramString2)
    throws Throwable
  {
    Object localObject3 = new ArrayList();
    for (Object localObject1 = getImportedClass(paramString1); localObject1 != null; localObject1 = ((Class)localObject1).getSuperclass()) {
      ((ArrayList)localObject3).add(localObject1);
    }
    localObject3 = ((ArrayList)localObject3).iterator();
    for (;;)
    {
      if (((Iterator)localObject3).hasNext())
      {
        localObject1 = (Class)((Iterator)localObject3).next();
        try
        {
          localObject1 = ((Class)localObject1).getDeclaredField(paramString2);
          if ((localObject1 != null) && (Modifier.isStatic(((Field)localObject1).getModifiers())))
          {
            ((Field)localObject1).setAccessible(true);
            return (T)((Field)localObject1).get(null);
          }
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            Object localObject2 = null;
          }
        }
      }
    }
    throw new NoSuchFieldException("className: " + paramString1 + ", fieldName: " + paramString2);
  }
  
  private static Object onNewInstance(String paramString, Object... paramVarArgs)
    throws Throwable
  {
    if (paramString.startsWith("[")) {
      return newArray(paramString, paramVarArgs);
    }
    Object localObject1 = getImportedClass(paramString);
    Object localObject3 = ((Class)localObject1).getName() + "#" + paramVarArgs.length;
    Object localObject4 = (Constructor)cachedConstr.get(localObject3);
    Object localObject2 = getTypes(paramVarArgs);
    if ((localObject4 != null) && (matchParams(((Constructor)localObject4).getParameterTypes(), (Class[])localObject2)))
    {
      ((Constructor)localObject4).setAccessible(true);
      return ((Constructor)localObject4).newInstance(paramVarArgs);
    }
    Object localObject5 = ((Class)localObject1).getDeclaredConstructors();
    localObject1 = new ArrayList();
    localObject4 = new ArrayList();
    int j = localObject5.length;
    int i = 0;
    while (i < j)
    {
      Object localObject6 = localObject5[i];
      Class[] arrayOfClass = ((Constructor)localObject6).getParameterTypes();
      if (matchParams(arrayOfClass, (Class[])localObject2))
      {
        cachedConstr.put(localObject3, localObject6);
        ((Constructor)localObject6).setAccessible(true);
        return ((Constructor)localObject6).newInstance(paramVarArgs);
      }
      if ((arrayOfClass.length > 0) && (arrayOfClass[(arrayOfClass.length - 1)].isArray()) && (localObject2.length >= arrayOfClass.length - 1))
      {
        ((ArrayList)localObject1).add(localObject6);
        ((ArrayList)localObject4).add(arrayOfClass);
      }
      i += 1;
    }
    i = 0;
    if (i < ((ArrayList)localObject4).size())
    {
      localObject3 = (Class[])((ArrayList)localObject4).get(i);
      localObject5 = localObject3[(localObject3.length - 1)].getComponentType();
      if (tryMatchParams((Class[])localObject3, (Class[])localObject2))
      {
        paramString = new Object[paramVarArgs.length + 1];
        System.arraycopy(paramVarArgs, 0, paramString, 0, paramVarArgs.length);
        paramString[paramVarArgs.length] = Array.newInstance((Class)localObject5, 0);
        paramString = (Constructor)((ArrayList)localObject1).get(i);
        paramString.setAccessible(true);
        return paramString.newInstance(paramVarArgs);
      }
      j = localObject3.length - 1;
      if (j >= localObject2.length) {
        break label505;
      }
      if (localObject2[j].equals(localObject5)) {}
    }
    label505:
    for (j = 0;; j = 1)
    {
      if (j != 0)
      {
        int k = localObject2.length - localObject3.length + 1;
        paramString = Array.newInstance((Class)localObject5, k);
        j = 0;
        for (;;)
        {
          if (j < k)
          {
            Array.set(paramString, j, paramVarArgs[(localObject3.length - 1 + j)]);
            j += 1;
            continue;
            j += 1;
            break;
          }
        }
        localObject2 = new Object[paramVarArgs.length + 1];
        System.arraycopy(paramVarArgs, 0, localObject2, 0, paramVarArgs.length);
        localObject2[paramVarArgs.length] = paramString;
        paramString = (Constructor)((ArrayList)localObject1).get(i);
        paramString.setAccessible(true);
        return paramString.newInstance(paramVarArgs);
      }
      i += 1;
      break;
      throw new NoSuchMethodException("className: " + paramString + ", methodName: <init>");
    }
  }
  
  private static void onSetElement(Object paramObject1, String paramString, Object paramObject2)
    throws Throwable
  {
    Object localObject3 = null;
    Object localObject4 = null;
    Object localObject5 = null;
    Object localObject2 = null;
    int i;
    Class localClass;
    Object localObject1;
    if ((paramString.startsWith("[")) && (paramString.endsWith("]")))
    {
      try
      {
        i = Integer.parseInt(paramString.substring(1, paramString.length() - 1));
        if (i == -1) {
          break label720;
        }
        for (String str = paramObject1.getClass().getName(); str.startsWith("["); str = str.substring(1)) {}
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          i = -1;
        }
        localClass = paramObject2.getClass();
        if ("B".equals(localThrowable))
        {
          if (localClass != Byte.class) {
            break label720;
          }
          Array.set(paramObject1, i, paramObject2);
          return;
        }
        if ("S".equals(localThrowable))
        {
          if (localClass == Short.class) {
            localObject1 = paramObject2;
          }
          while (localObject1 != null)
          {
            Array.set(paramObject1, i, localObject1);
            return;
            localObject1 = localObject2;
            if (localClass == Byte.class) {
              localObject1 = Short.valueOf((short)((Byte)paramObject2).byteValue());
            }
          }
        }
        if ("I".equals(localObject1))
        {
          if (localClass == Integer.class) {
            localObject1 = paramObject2;
          }
          while (localObject1 != null)
          {
            Array.set(paramObject1, i, localObject1);
            return;
            if (localClass == Short.class)
            {
              localObject1 = Integer.valueOf(((Short)paramObject2).shortValue());
            }
            else
            {
              localObject1 = localObject3;
              if (localClass == Byte.class) {
                localObject1 = Integer.valueOf(((Byte)paramObject2).byteValue());
              }
            }
          }
        }
        if ("J".equals(localObject1))
        {
          if (localClass == Long.class) {
            localObject1 = paramObject2;
          }
          while (localObject1 != null)
          {
            Array.set(paramObject1, i, localObject1);
            return;
            if (localClass == Integer.class)
            {
              localObject1 = Long.valueOf(((Integer)paramObject2).intValue());
            }
            else if (localClass == Short.class)
            {
              localObject1 = Long.valueOf(((Short)paramObject2).shortValue());
            }
            else
            {
              localObject1 = localObject4;
              if (localClass == Byte.class) {
                localObject1 = Long.valueOf(((Byte)paramObject2).byteValue());
              }
            }
          }
        }
        if ("F".equals(localObject1))
        {
          if (localClass == Float.class) {
            localObject1 = paramObject2;
          }
          while (localObject1 != null)
          {
            Array.set(paramObject1, i, localObject1);
            return;
            if (localClass == Long.class)
            {
              localObject1 = Float.valueOf((float)((Long)paramObject2).longValue());
            }
            else if (localClass == Integer.class)
            {
              localObject1 = Float.valueOf(((Integer)paramObject2).intValue());
            }
            else if (localClass == Short.class)
            {
              localObject1 = Float.valueOf(((Short)paramObject2).shortValue());
            }
            else
            {
              localObject1 = localObject5;
              if (localClass == Byte.class) {
                localObject1 = Float.valueOf(((Byte)paramObject2).byteValue());
              }
            }
          }
        }
        if (!"D".equals(localObject1)) {
          break label650;
        }
      }
      if (localClass == Double.class) {
        localObject1 = paramObject2;
      }
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        Array.set(paramObject1, i, localObject1);
        return;
        if (localClass == Float.class)
        {
          localObject1 = Double.valueOf(((Float)paramObject2).floatValue());
          continue;
        }
        if (localClass == Long.class)
        {
          localObject1 = Double.valueOf(((Long)paramObject2).longValue());
          continue;
        }
        if (localClass == Integer.class)
        {
          localObject1 = Double.valueOf(((Integer)paramObject2).intValue());
          continue;
        }
        if (localClass == Short.class)
        {
          localObject1 = Double.valueOf(((Short)paramObject2).shortValue());
          continue;
        }
        if (localClass != Byte.class) {
          break label772;
        }
        localObject1 = Double.valueOf(((Byte)paramObject2).byteValue());
        continue;
        label650:
        if ("Z".equals(localObject1))
        {
          if (localClass == Boolean.class) {
            Array.set(paramObject1, i, paramObject2);
          }
        }
        else if ("C".equals(localObject1))
        {
          if (localClass == Character.class) {
            Array.set(paramObject1, i, paramObject2);
          }
        }
        else if (((String)localObject1).equals(localClass.getName()))
        {
          Array.set(paramObject1, i, paramObject2);
          return;
        }
      }
      label720:
      throw new NoSuchFieldException("className: " + paramObject1.getClass() + ", fieldName: " + paramString + ", value: " + String.valueOf(paramObject2));
      label772:
      localObject1 = null;
    }
  }
  
  private static void onSetInstanceField(Object paramObject1, String paramString, Object paramObject2)
    throws Throwable
  {
    if (paramObject1.getClass().isArray())
    {
      onSetElement(paramObject1, paramString, paramObject2);
      return;
    }
    Object localObject3 = new ArrayList();
    for (Object localObject1 = paramObject1.getClass(); localObject1 != null; localObject1 = ((Class)localObject1).getSuperclass()) {
      ((ArrayList)localObject3).add(localObject1);
    }
    localObject3 = ((ArrayList)localObject3).iterator();
    for (;;)
    {
      if (((Iterator)localObject3).hasNext())
      {
        localObject1 = (Class)((Iterator)localObject3).next();
        try
        {
          localObject1 = ((Class)localObject1).getDeclaredField(paramString);
          if ((localObject1 != null) && (!Modifier.isStatic(((Field)localObject1).getModifiers())))
          {
            ((Field)localObject1).setAccessible(true);
            ((Field)localObject1).set(paramObject1, paramObject2);
            return;
          }
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            Object localObject2 = null;
          }
        }
      }
    }
    throw new NoSuchFieldException("className: " + paramObject1.getClass() + ", fieldName: " + paramString + ", value: " + String.valueOf(paramObject2));
  }
  
  private static void onSetStaticField(String paramString1, String paramString2, Object paramObject)
    throws Throwable
  {
    Object localObject3 = new ArrayList();
    for (Object localObject1 = getImportedClass(paramString1); localObject1 != null; localObject1 = ((Class)localObject1).getSuperclass()) {
      ((ArrayList)localObject3).add(localObject1);
    }
    localObject3 = ((ArrayList)localObject3).iterator();
    for (;;)
    {
      if (((Iterator)localObject3).hasNext())
      {
        localObject1 = (Class)((Iterator)localObject3).next();
        try
        {
          localObject1 = ((Class)localObject1).getDeclaredField(paramString2);
          if ((localObject1 != null) && (Modifier.isStatic(((Field)localObject1).getModifiers())))
          {
            ((Field)localObject1).setAccessible(true);
            ((Field)localObject1).set(null, paramObject);
            return;
          }
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            Object localObject2 = null;
          }
        }
      }
    }
    throw new NoSuchFieldException("className: " + paramString1 + ", fieldName: " + paramString2 + ", value: " + String.valueOf(paramObject));
  }
  
  private static boolean primitiveEquals(Class<?> paramClass1, Class<?> paramClass2)
  {
    return ((paramClass1 == Byte.TYPE) && (paramClass2 == Byte.class)) || ((paramClass1 == Short.TYPE) && ((paramClass2 == Short.class) || (paramClass2 == Byte.class) || (paramClass2 == Character.class))) || ((paramClass1 == Character.TYPE) && ((paramClass2 == Character.class) || (paramClass2 == Short.class) || (paramClass2 == Byte.class))) || ((paramClass1 == Integer.TYPE) && ((paramClass2 == Integer.class) || (paramClass2 == Short.class) || (paramClass2 == Byte.class) || (paramClass2 == Character.class))) || ((paramClass1 == Long.TYPE) && ((paramClass2 == Long.class) || (paramClass2 == Integer.class) || (paramClass2 == Short.class) || (paramClass2 == Byte.class) || (paramClass2 == Character.class))) || ((paramClass1 == Float.TYPE) && ((paramClass2 == Float.class) || (paramClass2 == Long.class) || (paramClass2 == Integer.class) || (paramClass2 == Short.class) || (paramClass2 == Byte.class) || (paramClass2 == Character.class))) || ((paramClass1 == Double.TYPE) && ((paramClass2 == Double.class) || (paramClass2 == Float.class) || (paramClass2 == Long.class) || (paramClass2 == Integer.class) || (paramClass2 == Short.class) || (paramClass2 == Byte.class) || (paramClass2 == Character.class))) || ((paramClass1 == Boolean.TYPE) && (paramClass2 == Boolean.class));
  }
  
  public static void setInstanceField(Object paramObject1, String paramString, Object paramObject2)
    throws Throwable
  {
    try
    {
      onSetInstanceField(paramObject1, paramString, paramObject2);
      return;
    }
    catch (Throwable localThrowable)
    {
      if ((localThrowable instanceof NoSuchFieldException)) {
        throw localThrowable;
      }
      throw new Throwable("className: " + paramObject1.getClass() + ", fieldName: " + paramString + ", value: " + String.valueOf(paramObject2), localThrowable);
    }
  }
  
  public static void setStaticField(String paramString1, String paramString2, Object paramObject)
    throws Throwable
  {
    try
    {
      onSetStaticField(paramString1, paramString2, paramObject);
      return;
    }
    catch (Throwable localThrowable)
    {
      if ((localThrowable instanceof NoSuchFieldException)) {
        throw localThrowable;
      }
      throw new Throwable("className: " + paramString1 + ", fieldName: " + paramString2 + ", value: " + String.valueOf(paramObject), localThrowable);
    }
  }
  
  private static boolean tryMatchParams(Class<?>[] paramArrayOfClass1, Class<?>[] paramArrayOfClass2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramArrayOfClass1.length - paramArrayOfClass2.length == 1)
    {
      i = 0;
      if (i >= paramArrayOfClass2.length) {
        break label88;
      }
      if ((paramArrayOfClass2[i] == null) || (primitiveEquals(paramArrayOfClass1[i], paramArrayOfClass2[i])) || (paramArrayOfClass1[i].isAssignableFrom(paramArrayOfClass2[i]))) {
        break label81;
      }
    }
    label81:
    label88:
    for (int i = 0;; i = 1)
    {
      bool1 = bool2;
      if (i != 0)
      {
        bool1 = bool2;
        if (paramArrayOfClass1[(paramArrayOfClass1.length - 1)].isArray()) {
          bool1 = true;
        }
      }
      return bool1;
      i += 1;
      break;
    }
  }
  
  public static abstract interface ReflectRunnable<ArgType, RetType>
  {
    public abstract RetType run(ArgType paramArgType);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mob/tools/utils/ReflectHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */