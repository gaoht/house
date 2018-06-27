package com.alibaba.fastjson.util;

import java.lang.reflect.Method;
import java.lang.reflect.Type;

public class ASMUtils
{
  public static final boolean IS_ANDROID = isAndroid(JAVA_VM_NAME);
  public static final String JAVA_VM_NAME = System.getProperty("java.vm.name");
  
  public static boolean checkName(String paramString)
  {
    int i = 0;
    while (i < paramString.length())
    {
      int j = paramString.charAt(i);
      if ((j < 1) || (j > 127) || (j == 46)) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static String desc(Class<?> paramClass)
  {
    if (paramClass.isPrimitive()) {
      return getPrimitiveLetter(paramClass);
    }
    if (paramClass.isArray()) {
      return "[" + desc(paramClass.getComponentType());
    }
    return "L" + type(paramClass) + ";";
  }
  
  public static String desc(Method paramMethod)
  {
    Class[] arrayOfClass = paramMethod.getParameterTypes();
    StringBuilder localStringBuilder = new StringBuilder(arrayOfClass.length + 1 << 4);
    localStringBuilder.append('(');
    int i = 0;
    while (i < arrayOfClass.length)
    {
      localStringBuilder.append(desc(arrayOfClass[i]));
      i += 1;
    }
    localStringBuilder.append(')');
    localStringBuilder.append(desc(paramMethod.getReturnType()));
    return localStringBuilder.toString();
  }
  
  public static Type getMethodType(Class<?> paramClass, String paramString)
  {
    try
    {
      paramClass = paramClass.getMethod(paramString, new Class[0]).getGenericReturnType();
      return paramClass;
    }
    catch (Exception paramClass) {}
    return null;
  }
  
  public static String getPrimitiveLetter(Class<?> paramClass)
  {
    if (Integer.TYPE == paramClass) {
      return "I";
    }
    if (Void.TYPE == paramClass) {
      return "V";
    }
    if (Boolean.TYPE == paramClass) {
      return "Z";
    }
    if (Character.TYPE == paramClass) {
      return "C";
    }
    if (Byte.TYPE == paramClass) {
      return "B";
    }
    if (Short.TYPE == paramClass) {
      return "S";
    }
    if (Float.TYPE == paramClass) {
      return "F";
    }
    if (Long.TYPE == paramClass) {
      return "J";
    }
    if (Double.TYPE == paramClass) {
      return "D";
    }
    throw new IllegalStateException("Type: " + paramClass.getCanonicalName() + " is not a primitive type");
  }
  
  public static boolean isAndroid(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return false;
      paramString = paramString.toLowerCase();
    } while ((!paramString.contains("dalvik")) && (!paramString.contains("lemur")));
    return true;
  }
  
  public static String type(Class<?> paramClass)
  {
    if (paramClass.isArray()) {
      return "[" + desc(paramClass.getComponentType());
    }
    if (!paramClass.isPrimitive()) {
      return paramClass.getName().replace('.', '/');
    }
    return getPrimitiveLetter(paramClass);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/util/ASMUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */