package com.hyphenate.util;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.res.Resources;
import android.os.Environment;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

public class EasyUtils
{
  public static final String TAG = "EasyUtils";
  private static Hashtable<String, String> resourceTable = new Hashtable();
  
  public static String convertByteArrayToString(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(String.format("0x%02X", new Object[] { Byte.valueOf(paramArrayOfByte[i]) }));
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static boolean copyFile(String paramString1, String paramString2)
  {
    try
    {
      if (new File(paramString1).exists())
      {
        paramString1 = new FileInputStream(paramString1);
        paramString2 = new FileOutputStream(paramString2);
        byte[] arrayOfByte = new byte['Ѐ'];
        int i = 0;
        for (;;)
        {
          int j = paramString1.read(arrayOfByte);
          if (j == -1) {
            break;
          }
          i += j;
          paramString2.write(arrayOfByte, 0, j);
        }
        paramString2.flush();
        paramString2.close();
        paramString1.close();
        return true;
      }
      return false;
    }
    catch (Exception paramString1) {}
    return false;
  }
  
  public static boolean copyFolder(String paramString1, String paramString2)
  {
    boolean bool2 = true;
    try
    {
      new File(paramString2).mkdirs();
      String[] arrayOfString = new File(paramString1).list();
      int j = arrayOfString.length;
      int i = 0;
      boolean bool1;
      for (;;)
      {
        bool1 = bool2;
        if (i >= j) {
          break;
        }
        String str = arrayOfString[i];
        File localFile;
        if (paramString1.endsWith(File.separator)) {
          localFile = new File(paramString1 + str);
        }
        while (localFile.isFile())
        {
          FileInputStream localFileInputStream = new FileInputStream(localFile);
          FileOutputStream localFileOutputStream = new FileOutputStream(paramString2 + "/" + localFile.getName());
          byte[] arrayOfByte = new byte['᐀'];
          for (;;)
          {
            int k = localFileInputStream.read(arrayOfByte);
            if (k == -1) {
              break;
            }
            localFileOutputStream.write(arrayOfByte, 0, k);
          }
          localFile = new File(paramString1 + File.separator + str);
          continue;
          localFileOutputStream.flush();
          localFileOutputStream.close();
          localFileInputStream.close();
        }
        if (localFile.isDirectory()) {
          copyFolder(paramString1 + "/" + str, paramString2 + "/" + str);
        }
        i += 1;
      }
      return bool1;
    }
    catch (Exception paramString1)
    {
      bool1 = false;
    }
  }
  
  public static String getAppResourceString(Context paramContext, String paramString)
  {
    String str = (String)resourceTable.get(paramString);
    if (str != null) {
      paramContext = str;
    }
    do
    {
      return paramContext;
      str = paramContext.getString(paramContext.getResources().getIdentifier(paramString, "string", paramContext.getPackageName()));
      paramContext = str;
    } while (str == null);
    resourceTable.put(paramString, str);
    return str;
  }
  
  public static List<String> getRunningApps(Context paramContext)
  {
    localArrayList = new ArrayList();
    try
    {
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
      if (paramContext == null) {
        return localArrayList;
      }
      Iterator localIterator = paramContext.iterator();
      while (localIterator.hasNext())
      {
        String str = ((ActivityManager.RunningAppProcessInfo)localIterator.next()).processName;
        paramContext = str;
        if (str.contains(":")) {
          paramContext = str.substring(0, str.indexOf(":"));
        }
        if (!localArrayList.contains(paramContext)) {
          localArrayList.add(paramContext);
        }
      }
      return localArrayList;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  @SuppressLint({"SimpleDateFormat"})
  public static String getTimeStamp()
  {
    Date localDate = new Date(System.currentTimeMillis());
    return new SimpleDateFormat("yyyyMMddHHmmss").format(localDate);
  }
  
  public static String getTopActivityName(Context paramContext)
  {
    paramContext = (ActivityManager)paramContext.getSystemService("activity");
    try
    {
      paramContext = paramContext.getRunningTasks(1);
      if ((paramContext != null) && (paramContext.size() >= 1))
      {
        paramContext = ((ActivityManager.RunningTaskInfo)paramContext.get(0)).topActivity.getClassName();
        return paramContext;
      }
    }
    catch (SecurityException paramContext)
    {
      EMLog.d("EasyUtils", "Apk doesn't hold GET_TASKS permission");
      paramContext.printStackTrace();
      return "";
    }
    return "";
  }
  
  public static boolean isAppRunningForeground(Context paramContext)
  {
    boolean bool1 = true;
    Object localObject = (ActivityManager)paramContext.getSystemService("activity");
    for (;;)
    {
      try
      {
        localObject = ((ActivityManager)localObject).getRunningTasks(1);
        if ((localObject == null) || (((List)localObject).size() < 1)) {
          break;
        }
        boolean bool2 = paramContext.getPackageName().equalsIgnoreCase(((ActivityManager.RunningTaskInfo)((List)localObject).get(0)).baseActivity.getPackageName());
        paramContext = new StringBuilder().append("app running in foregroud：");
        if (bool2)
        {
          EMLog.d("utils", bool1);
          return bool2;
        }
      }
      catch (SecurityException paramContext)
      {
        EMLog.d("EasyUtils", "Apk doesn't hold GET_TASKS permission");
        paramContext.printStackTrace();
        return false;
      }
      bool1 = false;
    }
    return false;
  }
  
  public static boolean isSDCardExist()
  {
    return Environment.getExternalStorageState().equals("mounted");
  }
  
  public static boolean isSingleActivity(Context paramContext)
  {
    paramContext = (ActivityManager)paramContext.getSystemService("activity");
    try
    {
      paramContext = paramContext.getRunningTasks(1);
      if ((paramContext == null) || (paramContext.size() < 1)) {
        return false;
      }
    }
    catch (SecurityException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        paramContext = null;
      }
      if (((ActivityManager.RunningTaskInfo)paramContext.get(0)).numRunning == 1) {
        return true;
      }
    }
    return false;
  }
  
  /* Error */
  public static boolean writeToZipFile(byte[] paramArrayOfByte, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 6
    //   6: new 67	java/io/FileOutputStream
    //   9: dup
    //   10: aload_1
    //   11: invokespecial 68	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   14: astore 5
    //   16: new 310	java/util/zip/GZIPOutputStream
    //   19: dup
    //   20: new 312	java/io/BufferedOutputStream
    //   23: dup
    //   24: aload 5
    //   26: invokespecial 315	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   29: invokespecial 316	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   32: astore 6
    //   34: aload 6
    //   36: aload_0
    //   37: invokevirtual 319	java/util/zip/GZIPOutputStream:write	([B)V
    //   40: aload 6
    //   42: ifnull +8 -> 50
    //   45: aload 6
    //   47: invokevirtual 320	java/util/zip/GZIPOutputStream:close	()V
    //   50: aload 5
    //   52: ifnull +8 -> 60
    //   55: aload 5
    //   57: invokevirtual 323	java/io/OutputStream:close	()V
    //   60: getstatic 327	com/hyphenate/util/EMLog:debugMode	Z
    //   63: ifeq +95 -> 158
    //   66: new 55	java/io/File
    //   69: dup
    //   70: aload_1
    //   71: invokespecial 58	java/io/File:<init>	(Ljava/lang/String;)V
    //   74: astore_1
    //   75: new 329	java/text/DecimalFormat
    //   78: dup
    //   79: ldc_w 331
    //   82: invokespecial 332	java/text/DecimalFormat:<init>	(Ljava/lang/String;)V
    //   85: aload_1
    //   86: invokevirtual 335	java/io/File:length	()J
    //   89: l2d
    //   90: aload_0
    //   91: arraylength
    //   92: i2d
    //   93: ddiv
    //   94: ldc2_w 336
    //   97: dmul
    //   98: invokevirtual 340	java/text/DecimalFormat:format	(D)Ljava/lang/String;
    //   101: invokestatic 345	java/lang/Double:valueOf	(Ljava/lang/String;)Ljava/lang/Double;
    //   104: invokevirtual 349	java/lang/Double:doubleValue	()D
    //   107: dstore_2
    //   108: ldc_w 351
    //   111: new 26	java/lang/StringBuilder
    //   114: dup
    //   115: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   118: ldc_w 353
    //   121: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: aload_0
    //   125: arraylength
    //   126: invokevirtual 356	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   129: ldc_w 358
    //   132: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: aload_1
    //   136: invokevirtual 335	java/io/File:length	()J
    //   139: invokevirtual 361	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   142: ldc_w 363
    //   145: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: dload_2
    //   149: invokevirtual 366	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   152: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   155: invokestatic 269	com/hyphenate/util/EMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   158: iconst_1
    //   159: istore 4
    //   161: iload 4
    //   163: ireturn
    //   164: astore 6
    //   166: aload 6
    //   168: invokevirtual 367	java/io/IOException:printStackTrace	()V
    //   171: goto -121 -> 50
    //   174: astore 5
    //   176: aload 5
    //   178: invokevirtual 367	java/io/IOException:printStackTrace	()V
    //   181: goto -121 -> 60
    //   184: astore 5
    //   186: aconst_null
    //   187: astore_0
    //   188: aload 6
    //   190: astore_1
    //   191: aload 5
    //   193: invokevirtual 209	java/lang/Exception:printStackTrace	()V
    //   196: iconst_0
    //   197: istore 4
    //   199: aload_0
    //   200: ifnull +7 -> 207
    //   203: aload_0
    //   204: invokevirtual 320	java/util/zip/GZIPOutputStream:close	()V
    //   207: aload_1
    //   208: ifnull -47 -> 161
    //   211: aload_1
    //   212: invokevirtual 323	java/io/OutputStream:close	()V
    //   215: iconst_0
    //   216: ireturn
    //   217: astore_0
    //   218: aload_0
    //   219: invokevirtual 367	java/io/IOException:printStackTrace	()V
    //   222: iconst_0
    //   223: ireturn
    //   224: astore_0
    //   225: aload_0
    //   226: invokevirtual 367	java/io/IOException:printStackTrace	()V
    //   229: goto -22 -> 207
    //   232: astore_0
    //   233: aconst_null
    //   234: astore 5
    //   236: aload 7
    //   238: astore_1
    //   239: aload_1
    //   240: ifnull +7 -> 247
    //   243: aload_1
    //   244: invokevirtual 320	java/util/zip/GZIPOutputStream:close	()V
    //   247: aload 5
    //   249: ifnull +8 -> 257
    //   252: aload 5
    //   254: invokevirtual 323	java/io/OutputStream:close	()V
    //   257: aload_0
    //   258: athrow
    //   259: astore_1
    //   260: aload_1
    //   261: invokevirtual 367	java/io/IOException:printStackTrace	()V
    //   264: goto -17 -> 247
    //   267: astore_1
    //   268: aload_1
    //   269: invokevirtual 367	java/io/IOException:printStackTrace	()V
    //   272: goto -15 -> 257
    //   275: astore_0
    //   276: aload 7
    //   278: astore_1
    //   279: goto -40 -> 239
    //   282: astore_0
    //   283: aload 6
    //   285: astore_1
    //   286: goto -47 -> 239
    //   289: astore 6
    //   291: aload_1
    //   292: astore 5
    //   294: aload_0
    //   295: astore_1
    //   296: aload 6
    //   298: astore_0
    //   299: goto -60 -> 239
    //   302: astore 6
    //   304: aconst_null
    //   305: astore_0
    //   306: aload 5
    //   308: astore_1
    //   309: aload 6
    //   311: astore 5
    //   313: goto -122 -> 191
    //   316: astore_0
    //   317: aload 5
    //   319: astore_1
    //   320: aload_0
    //   321: astore 5
    //   323: aload 6
    //   325: astore_0
    //   326: goto -135 -> 191
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	329	0	paramArrayOfByte	byte[]
    //   0	329	1	paramString	String
    //   107	42	2	d	double
    //   159	39	4	bool	boolean
    //   14	42	5	localFileOutputStream	FileOutputStream
    //   174	3	5	localIOException1	java.io.IOException
    //   184	8	5	localException1	Exception
    //   234	88	5	localObject1	Object
    //   4	42	6	localGZIPOutputStream	java.util.zip.GZIPOutputStream
    //   164	120	6	localIOException2	java.io.IOException
    //   289	8	6	localObject2	Object
    //   302	22	6	localException2	Exception
    //   1	276	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   45	50	164	java/io/IOException
    //   55	60	174	java/io/IOException
    //   6	16	184	java/lang/Exception
    //   211	215	217	java/io/IOException
    //   203	207	224	java/io/IOException
    //   6	16	232	finally
    //   243	247	259	java/io/IOException
    //   252	257	267	java/io/IOException
    //   16	34	275	finally
    //   34	40	282	finally
    //   191	196	289	finally
    //   16	34	302	java/lang/Exception
    //   34	40	316	java/lang/Exception
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/util/EasyUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */