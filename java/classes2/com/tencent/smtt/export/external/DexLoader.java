package com.tencent.smtt.export.external;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import android.util.Log;
import dalvik.system.DexClassLoader;
import dalvik.system.VMStack;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class DexLoader
{
  private DexClassLoader mClassLoader;
  
  public DexLoader(Context paramContext, String paramString1, String paramString2)
  {
    this(paramContext, new String[] { paramString1 }, paramString2);
  }
  
  public DexLoader(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    this(null, paramContext, paramArrayOfString, paramString);
  }
  
  public DexLoader(Context paramContext, String[] paramArrayOfString, String paramString, DexLoader paramDexLoader)
  {
    paramDexLoader = paramDexLoader.getClassLoader();
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      paramDexLoader = new DexClassLoader(paramArrayOfString[i], paramString, paramContext.getApplicationInfo().nativeLibraryDir, paramDexLoader);
      this.mClassLoader = paramDexLoader;
      i += 1;
    }
  }
  
  public DexLoader(Context paramContext, String[] paramArrayOfString, String paramString1, String paramString2)
  {
    ClassLoader localClassLoader = paramContext.getClassLoader();
    String str = paramContext.getApplicationInfo().nativeLibraryDir;
    paramContext = str;
    if (!TextUtils.isEmpty(paramString2)) {
      paramContext = str + File.pathSeparator + paramString2;
    }
    int i = 0;
    paramString2 = localClassLoader;
    while (i < paramArrayOfString.length)
    {
      paramString2 = new DexClassLoader(paramArrayOfString[i], paramString1, paramContext, paramString2);
      this.mClassLoader = paramString2;
      i += 1;
    }
  }
  
  public DexLoader(String paramString1, Context paramContext, String[] paramArrayOfString, String paramString2)
  {
    ClassLoader localClassLoader = VMStack.getCallingClassLoader();
    Object localObject = localClassLoader;
    if (localClassLoader == null) {
      localObject = paramContext.getClassLoader();
    }
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      localObject = new DexClassLoader(paramArrayOfString[i], paramString2, paramString1, (ClassLoader)localObject);
      this.mClassLoader = ((DexClassLoader)localObject);
      i += 1;
    }
  }
  
  public DexClassLoader getClassLoader()
  {
    return this.mClassLoader;
  }
  
  public Object getStaticField(String paramString1, String paramString2)
  {
    try
    {
      Object localObject = this.mClassLoader.loadClass(paramString1).getField(paramString2);
      ((Field)localObject).setAccessible(true);
      localObject = ((Field)localObject).get(null);
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      Log.e(getClass().getSimpleName(), "'" + paramString1 + "' get field '" + paramString2 + "' failed", localThrowable);
    }
    return null;
  }
  
  public Object invokeMethod(Object paramObject, String paramString1, String paramString2, Class<?>[] paramArrayOfClass, Object... paramVarArgs)
  {
    try
    {
      paramArrayOfClass = this.mClassLoader.loadClass(paramString1).getMethod(paramString2, paramArrayOfClass);
      paramArrayOfClass.setAccessible(true);
      paramObject = paramArrayOfClass.invoke(paramObject, paramVarArgs);
      return paramObject;
    }
    catch (Throwable paramObject)
    {
      Log.e(getClass().getSimpleName(), "'" + paramString1 + "' invoke method '" + paramString2 + "' failed", (Throwable)paramObject);
    }
    return null;
  }
  
  public Object invokeStaticMethod(String paramString1, String paramString2, Class<?>[] paramArrayOfClass, Object... paramVarArgs)
  {
    try
    {
      paramArrayOfClass = this.mClassLoader.loadClass(paramString1).getMethod(paramString2, paramArrayOfClass);
      paramArrayOfClass.setAccessible(true);
      paramArrayOfClass = paramArrayOfClass.invoke(null, paramVarArgs);
      return paramArrayOfClass;
    }
    catch (Throwable paramArrayOfClass)
    {
      if ((paramString2 != null) && (paramString2.equalsIgnoreCase("initTesRuntimeEnvironment")))
      {
        Log.e(getClass().getSimpleName(), "'" + paramString1 + "' invoke static method '" + paramString2 + "' failed", paramArrayOfClass);
        return paramArrayOfClass;
      }
      Log.e(getClass().getSimpleName(), "'" + paramString1 + "' invoke static method '" + paramString2 + "' failed", paramArrayOfClass);
    }
    return null;
  }
  
  public Class<?> loadClass(String paramString)
  {
    try
    {
      Class localClass = this.mClassLoader.loadClass(paramString);
      return localClass;
    }
    catch (Throwable localThrowable)
    {
      Log.e(getClass().getSimpleName(), "loadClass '" + paramString + "' failed", localThrowable);
    }
    return null;
  }
  
  public Object newInstance(String paramString)
  {
    try
    {
      Object localObject = this.mClassLoader.loadClass(paramString).newInstance();
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      Log.e(getClass().getSimpleName(), "create " + paramString + " instance failed", localThrowable);
    }
    return null;
  }
  
  public Object newInstance(String paramString, Class<?>[] paramArrayOfClass, Object... paramVarArgs)
  {
    try
    {
      paramArrayOfClass = this.mClassLoader.loadClass(paramString).getConstructor(paramArrayOfClass).newInstance(paramVarArgs);
      return paramArrayOfClass;
    }
    catch (Throwable paramArrayOfClass)
    {
      if ("com.tencent.smtt.webkit.adapter.X5WebViewAdapter".equalsIgnoreCase(paramString))
      {
        Log.e(getClass().getSimpleName(), "'newInstance " + paramString + " failed", paramArrayOfClass);
        return paramArrayOfClass;
      }
      Log.e(getClass().getSimpleName(), "create '" + paramString + "' instance failed", paramArrayOfClass);
    }
    return null;
  }
  
  public void setStaticField(String paramString1, String paramString2, Object paramObject)
  {
    try
    {
      Field localField = this.mClassLoader.loadClass(paramString1).getField(paramString2);
      localField.setAccessible(true);
      localField.set(null, paramObject);
      return;
    }
    catch (Throwable paramObject)
    {
      Log.e(getClass().getSimpleName(), "'" + paramString1 + "' set field '" + paramString2 + "' failed", (Throwable)paramObject);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/tencent/smtt/export/external/DexLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */