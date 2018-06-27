package android.support.multidex;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.util.Log;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipFile;

public final class a
{
  private static final Set<File> a = new HashSet();
  private static final boolean b = a(System.getProperty("java.vm.version"));
  
  private static ApplicationInfo a(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getApplicationInfo();
      return paramContext;
    }
    catch (RuntimeException paramContext)
    {
      Log.w("MultiDex", "Failure while trying to obtain ApplicationInfo from Context. Must be running in test mode. Skip patching.", paramContext);
    }
    return null;
  }
  
  private static File a(Context paramContext, File paramFile, String paramString)
    throws IOException
  {
    paramFile = new File(paramFile, "code_cache");
    try
    {
      a(paramFile);
      paramContext = paramFile;
    }
    catch (IOException paramFile)
    {
      for (;;)
      {
        paramContext = new File(paramContext.getFilesDir(), "code_cache");
        a(paramContext);
      }
    }
    paramContext = new File(paramContext, paramString);
    a(paramContext);
    return paramContext;
  }
  
  private static void a(Context paramContext, File paramFile1, File paramFile2, String paramString1, String paramString2)
    throws IOException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException
  {
    ClassLoader localClassLoader;
    synchronized (a)
    {
      if (a.contains(paramFile1)) {
        return;
      }
      a.add(paramFile1);
      if (Build.VERSION.SDK_INT > 20) {
        Log.w("MultiDex", "MultiDex is not guaranteed to work in SDK version " + Build.VERSION.SDK_INT + ": SDK version higher than " + 20 + " should be backed by " + "runtime with built-in multidex capabilty but it's not the " + "case here: java.vm.version=\"" + System.getProperty("java.vm.version") + "\"");
      }
    }
    try
    {
      b(paramContext);
      paramFile2 = a(paramContext, paramFile2, paramString1);
      a(localClassLoader, paramFile2, b.a(paramContext, paramFile1, paramFile2, paramString2, false));
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Log.w("MultiDex", "Something went wrong when trying to clear old MultiDex extraction, continuing without cleaning.", localThrowable);
      }
    }
  }
  
  private static void a(File paramFile)
    throws IOException
  {
    paramFile.mkdir();
    if (!paramFile.isDirectory())
    {
      File localFile = paramFile.getParentFile();
      if (localFile == null) {
        Log.e("MultiDex", "Failed to create dir " + paramFile.getPath() + ". Parent file is null.");
      }
      for (;;)
      {
        throw new IOException("Failed to create directory " + paramFile.getPath());
        Log.e("MultiDex", "Failed to create dir " + paramFile.getPath() + ". parent file is a dir " + localFile.isDirectory() + ", a file " + localFile.isFile() + ", exists " + localFile.exists() + ", readable " + localFile.canRead() + ", writable " + localFile.canWrite());
      }
    }
  }
  
  private static void a(ClassLoader paramClassLoader, File paramFile, List<? extends File> paramList)
    throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, IOException
  {
    if (!paramList.isEmpty())
    {
      if (Build.VERSION.SDK_INT >= 19) {
        b.a(paramClassLoader, paramList, paramFile);
      }
    }
    else {
      return;
    }
    if (Build.VERSION.SDK_INT >= 14)
    {
      a.a(paramClassLoader, paramList, paramFile);
      return;
    }
    c.a(paramClassLoader, paramList);
  }
  
  static boolean a(String paramString)
  {
    bool2 = false;
    bool1 = bool2;
    if (paramString != null)
    {
      localObject = Pattern.compile("(\\d+)\\.(\\d+)(\\.\\d+)?").matcher(paramString);
      bool1 = bool2;
      if (!((Matcher)localObject).matches()) {}
    }
    try
    {
      int i = Integer.parseInt(((Matcher)localObject).group(1));
      int j = Integer.parseInt(((Matcher)localObject).group(2));
      if (i <= 2)
      {
        bool1 = bool2;
        if (i == 2)
        {
          bool1 = bool2;
          if (j < 1) {}
        }
      }
      else
      {
        bool1 = true;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        bool1 = bool2;
      }
    }
    Object localObject = new StringBuilder().append("VM with version ").append(paramString);
    if (bool1) {}
    for (paramString = " has multidex support";; paramString = " does not have multidex support")
    {
      Log.i("MultiDex", paramString);
      return bool1;
    }
  }
  
  private static Field b(Object paramObject, String paramString)
    throws NoSuchFieldException
  {
    Class localClass = paramObject.getClass();
    while (localClass != null) {
      try
      {
        Field localField = localClass.getDeclaredField(paramString);
        if (!localField.isAccessible()) {
          localField.setAccessible(true);
        }
        return localField;
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        localClass = localClass.getSuperclass();
      }
    }
    throw new NoSuchFieldException("Field " + paramString + " not found in " + paramObject.getClass());
  }
  
  private static Method b(Object paramObject, String paramString, Class<?>... paramVarArgs)
    throws NoSuchMethodException
  {
    Class localClass = paramObject.getClass();
    while (localClass != null) {
      try
      {
        Method localMethod = localClass.getDeclaredMethod(paramString, paramVarArgs);
        if (!localMethod.isAccessible()) {
          localMethod.setAccessible(true);
        }
        return localMethod;
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        localClass = localClass.getSuperclass();
      }
    }
    throw new NoSuchMethodException("Method " + paramString + " with parameters " + Arrays.asList(paramVarArgs) + " not found in " + paramObject.getClass());
  }
  
  private static void b(Context paramContext)
    throws Exception
  {
    paramContext = new File(paramContext.getFilesDir(), "secondary-dexes");
    File[] arrayOfFile;
    if (paramContext.isDirectory())
    {
      Log.i("MultiDex", "Clearing old secondary dex dir (" + paramContext.getPath() + ").");
      arrayOfFile = paramContext.listFiles();
      if (arrayOfFile == null) {
        Log.w("MultiDex", "Failed to list secondary dex dir content (" + paramContext.getPath() + ").");
      }
    }
    else
    {
      return;
    }
    int j = arrayOfFile.length;
    int i = 0;
    if (i < j)
    {
      File localFile = arrayOfFile[i];
      Log.i("MultiDex", "Trying to delete old file " + localFile.getPath() + " of size " + localFile.length());
      if (!localFile.delete()) {
        Log.w("MultiDex", "Failed to delete old file " + localFile.getPath());
      }
      for (;;)
      {
        i += 1;
        break;
        Log.i("MultiDex", "Deleted old file " + localFile.getPath());
      }
    }
    if (!paramContext.delete())
    {
      Log.w("MultiDex", "Failed to delete secondary dex dir " + paramContext.getPath());
      return;
    }
    Log.i("MultiDex", "Deleted old secondary dex dir " + paramContext.getPath());
  }
  
  private static void b(Object paramObject, String paramString, Object[] paramArrayOfObject)
    throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException
  {
    paramString = b(paramObject, paramString);
    Object[] arrayOfObject1 = (Object[])paramString.get(paramObject);
    Object[] arrayOfObject2 = (Object[])Array.newInstance(arrayOfObject1.getClass().getComponentType(), arrayOfObject1.length + paramArrayOfObject.length);
    System.arraycopy(arrayOfObject1, 0, arrayOfObject2, 0, arrayOfObject1.length);
    System.arraycopy(paramArrayOfObject, 0, arrayOfObject2, arrayOfObject1.length, paramArrayOfObject.length);
    paramString.set(paramObject, arrayOfObject2);
  }
  
  public static void install(Context paramContext)
  {
    Log.i("MultiDex", "Installing application");
    if (b)
    {
      Log.i("MultiDex", "VM has multidex support, MultiDex support library is disabled.");
      return;
    }
    if (Build.VERSION.SDK_INT < 4) {
      throw new RuntimeException("MultiDex installation failed. SDK " + Build.VERSION.SDK_INT + " is unsupported. Min SDK version is " + 4 + ".");
    }
    ApplicationInfo localApplicationInfo;
    try
    {
      localApplicationInfo = a(paramContext);
      if (localApplicationInfo == null)
      {
        Log.i("MultiDex", "No ApplicationInfo available, i.e. running on a test Context: MultiDex support library is disabled.");
        return;
      }
    }
    catch (Exception paramContext)
    {
      Log.e("MultiDex", "MultiDex installation failure", paramContext);
      throw new RuntimeException("MultiDex installation failed (" + paramContext.getMessage() + ").");
    }
    a(paramContext, new File(localApplicationInfo.sourceDir), new File(localApplicationInfo.dataDir), "secondary-dexes", "");
    Log.i("MultiDex", "install done");
  }
  
  public static void installInstrumentation(Context paramContext1, Context paramContext2)
  {
    Log.i("MultiDex", "Installing instrumentation");
    if (b)
    {
      Log.i("MultiDex", "VM has multidex support, MultiDex support library is disabled.");
      return;
    }
    if (Build.VERSION.SDK_INT < 4) {
      throw new RuntimeException("MultiDex installation failed. SDK " + Build.VERSION.SDK_INT + " is unsupported. Min SDK version is " + 4 + ".");
    }
    ApplicationInfo localApplicationInfo1;
    try
    {
      localApplicationInfo1 = a(paramContext1);
      if (localApplicationInfo1 == null)
      {
        Log.i("MultiDex", "No ApplicationInfo available for instrumentation, i.e. running on a test Context: MultiDex support library is disabled.");
        return;
      }
    }
    catch (Exception paramContext1)
    {
      Log.e("MultiDex", "MultiDex installation failure", paramContext1);
      throw new RuntimeException("MultiDex installation failed (" + paramContext1.getMessage() + ").");
    }
    ApplicationInfo localApplicationInfo2 = a(paramContext2);
    if (localApplicationInfo2 == null)
    {
      Log.i("MultiDex", "No ApplicationInfo available, i.e. running on a test Context: MultiDex support library is disabled.");
      return;
    }
    paramContext1 = paramContext1.getPackageName() + ".";
    File localFile = new File(localApplicationInfo2.dataDir);
    a(paramContext2, new File(localApplicationInfo1.sourceDir), localFile, paramContext1 + "secondary-dexes", paramContext1);
    a(paramContext2, new File(localApplicationInfo2.sourceDir), localFile, "secondary-dexes", "");
    Log.i("MultiDex", "Installation done");
  }
  
  private static final class a
  {
    private static Object[] a(Object paramObject, ArrayList<File> paramArrayList, File paramFile)
      throws IllegalAccessException, InvocationTargetException, NoSuchMethodException
    {
      return (Object[])a.a(paramObject, "makeDexElements", new Class[] { ArrayList.class, File.class }).invoke(paramObject, new Object[] { paramArrayList, paramFile });
    }
    
    private static void b(ClassLoader paramClassLoader, List<? extends File> paramList, File paramFile)
      throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException
    {
      paramClassLoader = a.a(paramClassLoader, "pathList").get(paramClassLoader);
      a.a(paramClassLoader, "dexElements", a(paramClassLoader, new ArrayList(paramList), paramFile));
    }
  }
  
  private static final class b
  {
    private static Object[] a(Object paramObject, ArrayList<File> paramArrayList, File paramFile, ArrayList<IOException> paramArrayList1)
      throws IllegalAccessException, InvocationTargetException, NoSuchMethodException
    {
      return (Object[])a.a(paramObject, "makeDexElements", new Class[] { ArrayList.class, File.class, ArrayList.class }).invoke(paramObject, new Object[] { paramArrayList, paramFile, paramArrayList1 });
    }
    
    private static void b(ClassLoader paramClassLoader, List<? extends File> paramList, File paramFile)
      throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException
    {
      Object localObject = a.a(paramClassLoader, "pathList").get(paramClassLoader);
      ArrayList localArrayList = new ArrayList();
      a.a(localObject, "dexElements", a(localObject, new ArrayList(paramList), paramFile, localArrayList));
      if (localArrayList.size() > 0)
      {
        paramClassLoader = localArrayList.iterator();
        while (paramClassLoader.hasNext()) {
          Log.w("MultiDex", "Exception in makeDexElement", (IOException)paramClassLoader.next());
        }
        paramList = a.a(localObject, "dexElementsSuppressedExceptions");
        paramFile = (IOException[])paramList.get(localObject);
        if (paramFile != null) {
          break label131;
        }
        paramClassLoader = (IOException[])localArrayList.toArray(new IOException[localArrayList.size()]);
      }
      for (;;)
      {
        paramList.set(localObject, paramClassLoader);
        return;
        label131:
        paramClassLoader = new IOException[localArrayList.size() + paramFile.length];
        localArrayList.toArray(paramClassLoader);
        System.arraycopy(paramFile, 0, paramClassLoader, localArrayList.size(), paramFile.length);
      }
    }
  }
  
  private static final class c
  {
    private static void b(ClassLoader paramClassLoader, List<? extends File> paramList)
      throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, IOException
    {
      int i = paramList.size();
      Field localField = a.a(paramClassLoader, "path");
      StringBuilder localStringBuilder = new StringBuilder((String)localField.get(paramClassLoader));
      String[] arrayOfString = new String[i];
      File[] arrayOfFile = new File[i];
      ZipFile[] arrayOfZipFile = new ZipFile[i];
      DexFile[] arrayOfDexFile = new DexFile[i];
      paramList = paramList.listIterator();
      while (paramList.hasNext())
      {
        File localFile = (File)paramList.next();
        String str = localFile.getAbsolutePath();
        localStringBuilder.append(':').append(str);
        i = paramList.previousIndex();
        arrayOfString[i] = str;
        arrayOfFile[i] = localFile;
        arrayOfZipFile[i] = new ZipFile(localFile);
        arrayOfDexFile[i] = DexFile.loadDex(str, str + ".dex", 0);
      }
      localField.set(paramClassLoader, localStringBuilder.toString());
      a.a(paramClassLoader, "mPaths", arrayOfString);
      a.a(paramClassLoader, "mFiles", arrayOfFile);
      a.a(paramClassLoader, "mZips", arrayOfZipFile);
      a.a(paramClassLoader, "mDexs", arrayOfDexFile);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/multidex/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */