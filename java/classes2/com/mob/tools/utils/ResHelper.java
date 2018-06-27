package com.mob.tools.utils;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Point;
import android.media.MediaScannerConnection.OnScanCompletedListener;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video.Media;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.network.KVPair;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLDecoder;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class ResHelper
{
  private static float density;
  private static int deviceWidth;
  private static Uri mediaUri;
  private static Object rp;
  
  public static void clearCache(Context paramContext)
    throws Throwable
  {
    deleteFileAndFolder(new File(getCachePath(paramContext, null)));
  }
  
  public static String contentUriToPath(Context paramContext, Uri paramUri)
  {
    if (paramUri == null) {
      return null;
    }
    if (new File(paramUri.getPath()).exists()) {
      return paramUri.getPath();
    }
    try
    {
      if (Build.VERSION.SDK_INT >= 19)
      {
        localObject = Class.forName("android.provider.DocumentsContract");
        Method localMethod = ((Class)localObject).getMethod("isDocumentUri", new Class[] { Context.class, Uri.class });
        localMethod.setAccessible(true);
        if (Boolean.TRUE.equals(localMethod.invoke(null, new Object[] { paramContext, paramUri })))
        {
          localObject = ((Class)localObject).getMethod("getDocumentId", new Class[] { Uri.class });
          ((Method)localObject).setAccessible(true);
          localObject = String.valueOf(localObject.invoke(null, new Object[] { paramUri })).split(":")[1];
          localObject = paramContext.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[] { "_data" }, "_id=?", new String[] { localObject }, null);
          if (localObject == null)
          {
            paramUri = paramContext.getContentResolver().query(paramUri, null, null, null, null);
            if (paramUri != null) {
              if (paramUri.moveToFirst())
              {
                paramContext = paramUri.getString(paramUri.getColumnIndex("_data"));
                paramUri.close();
                return paramContext;
              }
            }
          }
        }
      }
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        MobLog.getInstance().w(paramContext);
        paramContext = null;
        continue;
        paramContext = null;
        continue;
        paramContext = null;
        continue;
        paramUri = (Uri)localObject;
        continue;
        Object localObject = null;
      }
    }
  }
  
  public static void copyFile(FileInputStream paramFileInputStream, FileOutputStream paramFileOutputStream)
    throws Throwable
  {
    byte[] arrayOfByte = new byte[65536];
    for (int i = paramFileInputStream.read(arrayOfByte); i > 0; i = paramFileInputStream.read(arrayOfByte)) {
      paramFileOutputStream.write(arrayOfByte, 0, i);
    }
    paramFileInputStream.close();
    paramFileOutputStream.close();
  }
  
  public static boolean copyFile(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    while (!new File(paramString1).exists()) {
      return false;
    }
    try
    {
      copyFile(new FileInputStream(paramString1), new FileOutputStream(paramString2));
      return true;
    }
    catch (Throwable paramString1) {}
    return false;
  }
  
  public static int[] covertTimeInYears(long paramLong)
  {
    paramLong = System.currentTimeMillis() - paramLong;
    if (paramLong <= 0L) {
      return new int[] { 0, 0 };
    }
    paramLong /= 1000L;
    if (paramLong < 60L) {
      return new int[] { (int)paramLong, 0 };
    }
    paramLong /= 60L;
    if (paramLong < 60L) {
      return new int[] { (int)paramLong, 1 };
    }
    paramLong /= 60L;
    if (paramLong < 24L) {
      return new int[] { (int)paramLong, 2 };
    }
    paramLong /= 24L;
    if (paramLong < 30L) {
      return new int[] { (int)paramLong, 3 };
    }
    paramLong /= 30L;
    if (paramLong < 12L) {
      return new int[] { (int)paramLong, 4 };
    }
    return new int[] { (int)(paramLong / 12L), 5 };
  }
  
  public static long dateStrToLong(String paramString)
  {
    return new SimpleDateFormat("yyyy-MM-dd").parse(paramString, new ParsePosition(0)).getTime();
  }
  
  public static long dateToLong(String paramString)
  {
    try
    {
      paramString = new Date(paramString);
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTime(paramString);
      long l = localCalendar.getTimeInMillis();
      return l;
    }
    catch (Throwable paramString)
    {
      MobLog.getInstance().w(paramString);
    }
    return 0L;
  }
  
  public static Bundle decodeUrl(String paramString)
  {
    Bundle localBundle = new Bundle();
    if (paramString != null)
    {
      paramString = paramString.split("&");
      int j = paramString.length;
      int i = 0;
      if (i < j)
      {
        String[] arrayOfString = paramString[i].split("=");
        if ((arrayOfString.length < 2) || (arrayOfString[1] == null)) {
          localBundle.putString(URLDecoder.decode(arrayOfString[0]), "");
        }
        for (;;)
        {
          i += 1;
          break;
          localBundle.putString(URLDecoder.decode(arrayOfString[0]), URLDecoder.decode(arrayOfString[1]));
        }
      }
    }
    return localBundle;
  }
  
  public static void deleteFileAndFolder(File paramFile)
    throws Throwable
  {
    if ((paramFile == null) || (!paramFile.exists())) {
      return;
    }
    if (paramFile.isFile())
    {
      paramFile.delete();
      return;
    }
    String[] arrayOfString = paramFile.list();
    if ((arrayOfString == null) || (arrayOfString.length <= 0))
    {
      paramFile.delete();
      return;
    }
    int j = arrayOfString.length;
    int i = 0;
    if (i < j)
    {
      File localFile = new File(paramFile, arrayOfString[i]);
      if (localFile.isDirectory()) {
        deleteFileAndFolder(localFile);
      }
      for (;;)
      {
        i += 1;
        break;
        localFile.delete();
      }
    }
    paramFile.delete();
  }
  
  public static void deleteFilesInFolder(File paramFile)
    throws Throwable
  {
    if ((paramFile == null) || (!paramFile.exists())) {}
    String[] arrayOfString;
    do
    {
      return;
      if (paramFile.isFile())
      {
        paramFile.delete();
        return;
      }
      arrayOfString = paramFile.list();
    } while ((arrayOfString == null) || (arrayOfString.length <= 0));
    int j = arrayOfString.length;
    int i = 0;
    label44:
    File localFile;
    if (i < j)
    {
      localFile = new File(paramFile, arrayOfString[i]);
      if (!localFile.isDirectory()) {
        break label82;
      }
      deleteFilesInFolder(localFile);
    }
    for (;;)
    {
      i += 1;
      break label44;
      break;
      label82:
      localFile.delete();
    }
  }
  
  public static int designToDevice(Context paramContext, float paramFloat, int paramInt)
  {
    if (density <= 0.0F) {
      density = paramContext.getResources().getDisplayMetrics().density;
    }
    return (int)(paramInt * density / paramFloat + 0.5F);
  }
  
  public static int designToDevice(Context paramContext, int paramInt1, int paramInt2)
  {
    if (deviceWidth == 0)
    {
      paramContext = getScreenSize(paramContext);
      if (paramContext[0] >= paramContext[1]) {
        break label44;
      }
    }
    label44:
    for (int i = paramContext[0];; i = paramContext[1])
    {
      deviceWidth = i;
      return (int)(paramInt2 * deviceWidth / paramInt1 + 0.5F);
    }
  }
  
  public static int dipToPx(Context paramContext, int paramInt)
  {
    if (density <= 0.0F) {
      density = paramContext.getResources().getDisplayMetrics().density;
    }
    return (int)(paramInt * density + 0.5F);
  }
  
  public static String encodeUrl(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramBundle.keySet().iterator();
    int i = 1;
    if (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject2 = paramBundle.get(str);
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      if (i != 0) {
        i = 0;
      }
      for (;;)
      {
        localStringBuilder.append(Data.urlEncode(str) + "=" + Data.urlEncode(String.valueOf(localObject1)));
        break;
        localStringBuilder.append("&");
      }
    }
    return localStringBuilder.toString();
  }
  
  public static String encodeUrl(ArrayList<KVPair<String>> paramArrayList)
  {
    if (paramArrayList == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramArrayList.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      paramArrayList = (KVPair)localIterator.next();
      if (i > 0) {
        localStringBuilder.append('&');
      }
      String str2 = paramArrayList.name;
      String str1 = (String)paramArrayList.value;
      if (str2 != null)
      {
        paramArrayList = str1;
        if (str1 == null) {
          paramArrayList = "";
        }
        localStringBuilder.append(Data.urlEncode(str2) + "=" + Data.urlEncode(paramArrayList));
        i += 1;
      }
    }
    return localStringBuilder.toString();
  }
  
  public static <T> T forceCast(Object paramObject)
  {
    return (T)forceCast(paramObject, null);
  }
  
  public static <T> T forceCast(Object paramObject, T paramT)
  {
    boolean bool2 = true;
    boolean bool3 = true;
    boolean bool4 = true;
    boolean bool5 = true;
    boolean bool6 = true;
    boolean bool1 = true;
    if (paramObject == null) {
      return paramT;
    }
    int i;
    if ((paramObject instanceof Byte))
    {
      i = ((Byte)paramObject).byteValue();
      if ((paramT instanceof Boolean))
      {
        if (i != 0) {}
        for (bool1 = true;; bool1 = false) {
          return Boolean.valueOf(bool1);
        }
      }
      if ((paramT instanceof Short)) {
        return Short.valueOf((short)i);
      }
      if ((paramT instanceof Character)) {
        return Character.valueOf((char)i);
      }
      if ((paramT instanceof Integer)) {
        return Integer.valueOf(i);
      }
      if ((paramT instanceof Float)) {
        return Float.valueOf(i);
      }
      if ((paramT instanceof Long)) {
        return Long.valueOf(i);
      }
      if ((paramT instanceof Double)) {
        return Double.valueOf(i);
      }
    }
    else if ((paramObject instanceof Character))
    {
      i = ((Character)paramObject).charValue();
      if ((paramT instanceof Byte)) {
        return Byte.valueOf((byte)i);
      }
      if ((paramT instanceof Boolean))
      {
        if (i != 0) {}
        for (;;)
        {
          return Boolean.valueOf(bool1);
          bool1 = false;
        }
      }
      if ((paramT instanceof Short)) {
        return Short.valueOf((short)i);
      }
      if ((paramT instanceof Integer)) {
        return Integer.valueOf(i);
      }
      if ((paramT instanceof Float)) {
        return Float.valueOf(i);
      }
      if ((paramT instanceof Long)) {
        return Long.valueOf(i);
      }
      if ((paramT instanceof Double)) {
        return Double.valueOf(i);
      }
    }
    else if ((paramObject instanceof Short))
    {
      i = ((Short)paramObject).shortValue();
      if ((paramT instanceof Byte)) {
        return Byte.valueOf((byte)i);
      }
      if ((paramT instanceof Boolean))
      {
        if (i != 0) {}
        for (bool1 = bool2;; bool1 = false) {
          return Boolean.valueOf(bool1);
        }
      }
      if ((paramT instanceof Character)) {
        return Character.valueOf((char)i);
      }
      if ((paramT instanceof Integer)) {
        return Integer.valueOf(i);
      }
      if ((paramT instanceof Float)) {
        return Float.valueOf(i);
      }
      if ((paramT instanceof Long)) {
        return Long.valueOf(i);
      }
      if ((paramT instanceof Double)) {
        return Double.valueOf(i);
      }
    }
    else if ((paramObject instanceof Integer))
    {
      i = ((Integer)paramObject).intValue();
      if ((paramT instanceof Byte)) {
        return Byte.valueOf((byte)i);
      }
      if ((paramT instanceof Boolean))
      {
        if (i != 0) {}
        for (bool1 = bool3;; bool1 = false) {
          return Boolean.valueOf(bool1);
        }
      }
      if ((paramT instanceof Character)) {
        return Character.valueOf((char)i);
      }
      if ((paramT instanceof Short)) {
        return Short.valueOf((short)i);
      }
      if ((paramT instanceof Float)) {
        return Float.valueOf(i);
      }
      if ((paramT instanceof Long)) {
        return Long.valueOf(i);
      }
      if ((paramT instanceof Double)) {
        return Double.valueOf(i);
      }
    }
    else if ((paramObject instanceof Float))
    {
      float f = ((Float)paramObject).floatValue();
      if ((paramT instanceof Byte)) {
        return Byte.valueOf((byte)(int)f);
      }
      if ((paramT instanceof Boolean))
      {
        if (f != 0.0F) {}
        for (bool1 = bool4;; bool1 = false) {
          return Boolean.valueOf(bool1);
        }
      }
      if ((paramT instanceof Character)) {
        return Character.valueOf((char)(int)f);
      }
      if ((paramT instanceof Short)) {
        return Short.valueOf((short)(int)f);
      }
      if ((paramT instanceof Integer)) {
        return Integer.valueOf((int)f);
      }
      if ((paramT instanceof Long)) {
        return Long.valueOf(f);
      }
      if ((paramT instanceof Double)) {
        return Double.valueOf(f);
      }
    }
    else if ((paramObject instanceof Long))
    {
      long l = ((Long)paramObject).longValue();
      if ((paramT instanceof Byte)) {
        return Byte.valueOf((byte)(int)l);
      }
      if ((paramT instanceof Boolean))
      {
        if (l != 0L) {}
        for (bool1 = bool5;; bool1 = false) {
          return Boolean.valueOf(bool1);
        }
      }
      if ((paramT instanceof Character)) {
        return Character.valueOf((char)(int)l);
      }
      if ((paramT instanceof Short)) {
        return Short.valueOf((short)(int)l);
      }
      if ((paramT instanceof Integer)) {
        return Integer.valueOf((int)l);
      }
      if ((paramT instanceof Float)) {
        return Float.valueOf((float)l);
      }
      if ((paramT instanceof Double)) {
        return Double.valueOf(l);
      }
    }
    else if ((paramObject instanceof Double))
    {
      double d = ((Double)paramObject).doubleValue();
      if ((paramT instanceof Byte)) {
        return Byte.valueOf((byte)(int)d);
      }
      if ((paramT instanceof Boolean))
      {
        if (d != 0.0D) {}
        for (bool1 = bool6;; bool1 = false) {
          return Boolean.valueOf(bool1);
        }
      }
      if ((paramT instanceof Character)) {
        return Character.valueOf((char)(int)d);
      }
      if ((paramT instanceof Short)) {
        return Short.valueOf((short)(int)d);
      }
      if ((paramT instanceof Integer)) {
        return Integer.valueOf((int)d);
      }
      if ((paramT instanceof Float)) {
        return Float.valueOf((float)d);
      }
      if ((paramT instanceof Long)) {
        return Long.valueOf(d);
      }
    }
    return (T)paramObject;
  }
  
  public static int getAnimRes(Context paramContext, String paramString)
  {
    return getResId(paramContext, "anim", paramString);
  }
  
  public static int getBitmapRes(Context paramContext, String paramString)
  {
    int j = getResId(paramContext, "drawable", paramString);
    int i = j;
    if (j <= 0) {
      i = getResId(paramContext, "mipmap", paramString);
    }
    return i;
  }
  
  public static String getCachePath(Context paramContext, String paramString)
  {
    localObject = paramContext.getFilesDir().getAbsolutePath() + "/Mob/cache/";
    DeviceHelper localDeviceHelper = DeviceHelper.getInstance(paramContext);
    paramContext = (Context)localObject;
    try
    {
      if (localDeviceHelper.getSdcardState())
      {
        String str = localDeviceHelper.getSdcardPath();
        paramContext = (Context)localObject;
        if (str != null) {
          paramContext = str + "/Mob/" + localDeviceHelper.getPackageName() + "/cache/";
        }
      }
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        MobLog.getInstance().d(paramContext);
        paramContext = (Context)localObject;
      }
    }
    localObject = paramContext;
    if (!TextUtils.isEmpty(paramString)) {
      localObject = paramContext + paramString + "/";
    }
    paramContext = new File((String)localObject);
    if ((!paramContext.exists()) || (!paramContext.isDirectory())) {
      paramContext.mkdirs();
    }
    return (String)localObject;
  }
  
  public static String getCacheRoot(Context paramContext)
  {
    try
    {
      Object localObject1 = paramContext.getFilesDir().getAbsolutePath() + "/Mob/";
      Object localObject2 = DeviceHelper.getInstance(paramContext);
      paramContext = (Context)localObject1;
      if (((DeviceHelper)localObject2).getSdcardState())
      {
        localObject2 = ((DeviceHelper)localObject2).getSdcardPath();
        paramContext = (Context)localObject1;
        if (localObject2 != null) {
          paramContext = (String)localObject2 + "/Mob/";
        }
      }
      localObject1 = new File(paramContext);
      if (!((File)localObject1).exists()) {
        ((File)localObject1).mkdirs();
      }
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      MobLog.getInstance().w(paramContext);
    }
    return null;
  }
  
  public static File getCacheRootFile(Context paramContext, String paramString)
  {
    try
    {
      paramContext = getCacheRoot(paramContext);
      if (paramContext != null)
      {
        paramContext = new File(paramContext, paramString);
        if (!paramContext.getParentFile().exists()) {
          paramContext.getParentFile().mkdirs();
        }
        return paramContext;
      }
    }
    catch (Throwable paramContext)
    {
      MobLog.getInstance().w(paramContext);
    }
    return null;
  }
  
  public static int getColorRes(Context paramContext, String paramString)
  {
    return getResId(paramContext, "color", paramString);
  }
  
  public static String getDataCache(Context paramContext)
  {
    paramContext = paramContext.getFilesDir().getAbsolutePath() + "/Mob/";
    File localFile = new File(paramContext);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return paramContext;
  }
  
  public static long getFileSize(File paramFile)
    throws Throwable
  {
    int i = 0;
    if (!paramFile.exists()) {
      return 0L;
    }
    if (paramFile.isDirectory())
    {
      String[] arrayOfString = paramFile.list();
      int j = 0;
      while (i < arrayOfString.length)
      {
        File localFile = new File(paramFile, arrayOfString[i]);
        j = (int)(j + getFileSize(localFile));
        i += 1;
      }
      return j;
    }
    return paramFile.length();
  }
  
  public static long getFileSize(String paramString)
    throws Throwable
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0L;
    }
    return getFileSize(new File(paramString));
  }
  
  public static int getIdRes(Context paramContext, String paramString)
  {
    return getResId(paramContext, "id", paramString);
  }
  
  public static String getImageCachePath(Context paramContext)
  {
    return getCachePath(paramContext, "images");
  }
  
  public static int getLayoutRes(Context paramContext, String paramString)
  {
    return getResId(paramContext, "layout", paramString);
  }
  
  /* Error */
  public static Uri getMediaUri(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: new 4	java/lang/Object
    //   6: dup
    //   7: invokespecial 18	java/lang/Object:<init>	()V
    //   10: astore_3
    //   11: aconst_null
    //   12: putstatic 23	com/mob/tools/utils/ResHelper:mediaUri	Landroid/net/Uri;
    //   15: new 6	com/mob/tools/utils/ResHelper$1
    //   18: dup
    //   19: aload_3
    //   20: invokespecial 517	com/mob/tools/utils/ResHelper$1:<init>	(Ljava/lang/Object;)V
    //   23: astore 4
    //   25: aload_0
    //   26: iconst_1
    //   27: anewarray 98	java/lang/String
    //   30: dup
    //   31: iconst_0
    //   32: aload_1
    //   33: aastore
    //   34: iconst_1
    //   35: anewarray 98	java/lang/String
    //   38: dup
    //   39: iconst_0
    //   40: aload_2
    //   41: aastore
    //   42: aload 4
    //   44: invokestatic 523	android/media/MediaScannerConnection:scanFile	(Landroid/content/Context;[Ljava/lang/String;[Ljava/lang/String;Landroid/media/MediaScannerConnection$OnScanCompletedListener;)V
    //   47: getstatic 23	com/mob/tools/utils/ResHelper:mediaUri	Landroid/net/Uri;
    //   50: ifnonnull +14 -> 64
    //   53: aload_3
    //   54: monitorenter
    //   55: aload_3
    //   56: ldc2_w 524
    //   59: invokevirtual 529	java/lang/Object:wait	(J)V
    //   62: aload_3
    //   63: monitorexit
    //   64: getstatic 23	com/mob/tools/utils/ResHelper:mediaUri	Landroid/net/Uri;
    //   67: astore_0
    //   68: aconst_null
    //   69: putstatic 23	com/mob/tools/utils/ResHelper:mediaUri	Landroid/net/Uri;
    //   72: ldc 2
    //   74: monitorexit
    //   75: aload_0
    //   76: areturn
    //   77: astore_0
    //   78: aload_3
    //   79: monitorexit
    //   80: aload_0
    //   81: athrow
    //   82: astore_0
    //   83: goto -19 -> 64
    //   86: astore_0
    //   87: ldc 2
    //   89: monitorexit
    //   90: aload_0
    //   91: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	paramContext	Context
    //   0	92	1	paramString1	String
    //   0	92	2	paramString2	String
    //   10	69	3	localObject	Object
    //   23	20	4	local1	1
    // Exception table:
    //   from	to	target	type
    //   55	64	77	finally
    //   78	80	77	finally
    //   47	55	82	java/lang/Throwable
    //   80	82	82	java/lang/Throwable
    //   3	47	86	finally
    //   47	55	86	finally
    //   64	72	86	finally
    //   80	82	86	finally
  }
  
  public static int getPluralsRes(Context paramContext, String paramString)
  {
    return getResId(paramContext, "plurals", paramString);
  }
  
  public static int getRawRes(Context paramContext, String paramString)
  {
    return getResId(paramContext, "raw", paramString);
  }
  
  public static int getResId(Context paramContext, String paramString1, String paramString2)
  {
    int k;
    if ((paramContext == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      k = 0;
      return k;
    }
    if (rp != null) {}
    for (;;)
    {
      try
      {
        Object localObject = rp.getClass().getMethod("getResId", new Class[] { Context.class, String.class, String.class });
        ((Method)localObject).setAccessible(true);
        j = ((Integer)((Method)localObject).invoke(rp, new Object[] { paramContext, paramString1, paramString2 })).intValue();
        k = j;
        if (j > 0) {
          break;
        }
        localObject = paramContext.getPackageName();
        k = j;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break;
        }
        int i = j;
        if (j <= 0)
        {
          j = paramContext.getResources().getIdentifier(paramString2, paramString1, (String)localObject);
          i = j;
          if (j <= 0) {
            i = paramContext.getResources().getIdentifier(paramString2.toLowerCase(), paramString1, (String)localObject);
          }
        }
        k = i;
        if (i > 0) {
          break;
        }
        MobLog.getInstance().w("failed to parse " + paramString1 + " resource \"" + paramString2 + "\"");
        return i;
      }
      catch (Throwable localThrowable)
      {
        MobLog.getInstance().d(localThrowable);
      }
      int j = 0;
    }
  }
  
  public static int getScreenHeight(Context paramContext)
  {
    return getScreenSize(paramContext)[1];
  }
  
  public static int[] getScreenSize(Context paramContext)
  {
    try
    {
      WindowManager localWindowManager = (WindowManager)paramContext.getSystemService("window");
      if (localWindowManager == null) {
        return new int[] { 0, 0 };
      }
    }
    catch (Throwable localThrowable1)
    {
      Display localDisplay;
      for (;;)
      {
        MobLog.getInstance().w(localThrowable1);
        localDisplay = null;
      }
      try
      {
        localDisplay = localDisplay.getDefaultDisplay();
        if (localDisplay == null) {
          try
          {
            paramContext = paramContext.getResources().getDisplayMetrics();
            i = paramContext.widthPixels;
            j = paramContext.heightPixels;
            return new int[] { i, j };
          }
          catch (Throwable paramContext)
          {
            MobLog.getInstance().w(paramContext);
            return new int[] { 0, 0 };
          }
        }
      }
      catch (Throwable localThrowable2)
      {
        int i;
        int j;
        Object localObject;
        for (;;)
        {
          MobLog.getInstance().w(localThrowable2);
          localObject = null;
        }
        if (Build.VERSION.SDK_INT < 13) {
          try
          {
            paramContext = new DisplayMetrics();
            ((Display)localObject).getMetrics(paramContext);
            i = paramContext.widthPixels;
            j = paramContext.heightPixels;
            return new int[] { i, j };
          }
          catch (Throwable paramContext)
          {
            MobLog.getInstance().w(paramContext);
            return new int[] { 0, 0 };
          }
        }
        try
        {
          paramContext = new Point();
          Method localMethod = localObject.getClass().getMethod("getRealSize", new Class[] { Point.class });
          localMethod.setAccessible(true);
          localMethod.invoke(localObject, new Object[] { paramContext });
          i = paramContext.x;
          j = paramContext.y;
          return new int[] { i, j };
        }
        catch (Throwable paramContext)
        {
          MobLog.getInstance().w(paramContext);
        }
      }
    }
    return tmp270_266;
  }
  
  public static int getScreenWidth(Context paramContext)
  {
    return getScreenSize(paramContext)[0];
  }
  
  public static int getStringArrayRes(Context paramContext, String paramString)
  {
    return getResId(paramContext, "array", paramString);
  }
  
  public static int getStringRes(Context paramContext, String paramString)
  {
    return getResId(paramContext, "string", paramString);
  }
  
  public static <T> T getStringValue(Context paramContext, String paramString, T paramT)
  {
    try
    {
      paramContext = paramContext.getString(getStringRes(paramContext, paramString)).trim();
      if (paramT == null) {
        return String.valueOf(paramContext);
      }
      paramString = paramT.getClass();
      if (paramString.equals(String.class)) {
        return String.valueOf(paramContext);
      }
      if ((paramString.equals(Integer.TYPE)) || (paramString.equals(Integer.class))) {
        return Integer.valueOf(String.valueOf(paramContext));
      }
      if ((paramString.equals(Long.TYPE)) || (paramString.equals(Long.class))) {
        return Long.valueOf(String.valueOf(paramContext));
      }
      if ((paramString.equals(Boolean.TYPE)) || (paramString.equals(Boolean.class))) {
        return Boolean.valueOf(paramContext);
      }
      if ((paramString.equals(Float.TYPE)) || (paramString.equals(Float.class))) {
        return Float.valueOf(String.valueOf(paramContext));
      }
      if ((paramString.equals(Double.TYPE)) || (paramString.equals(Double.class))) {
        return Double.valueOf(String.valueOf(paramContext));
      }
      if ((paramString.equals(Character.TYPE)) || (paramString.equals(Character.class))) {
        return Character.valueOf(String.valueOf(paramContext).charAt(0));
      }
      if ((paramString.equals(Byte.TYPE)) || (paramString.equals(Byte.class))) {
        return Byte.valueOf(String.valueOf(paramContext));
      }
      if ((paramString.equals(Short.TYPE)) || (paramString.equals(Short.class))) {
        return Short.valueOf(String.valueOf(paramContext));
      }
      paramContext = new Hashon().fromJson(paramContext, paramString);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      MobLog.getInstance().d(paramContext);
    }
    return paramT;
  }
  
  public static int getStyleRes(Context paramContext, String paramString)
  {
    return getResId(paramContext, "style", paramString);
  }
  
  public static int[] getStyleableRes(Context paramContext, String paramString)
  {
    try
    {
      paramContext = ReflectHelper.getStaticField(ReflectHelper.importClass(paramContext.getPackageName() + ".R$styleable"), paramString);
      if (paramContext == null) {
        return new int[0];
      }
      if (paramContext.getClass().isArray()) {
        return (int[])paramContext;
      }
      int i = ((Integer)paramContext).intValue();
      return new int[] { i };
    }
    catch (Throwable paramContext)
    {
      MobLog.getInstance().d(paramContext);
    }
    return new int[0];
  }
  
  public static int getTextLengthInWord(String paramString)
  {
    int i = 0;
    int j;
    if (paramString == null)
    {
      paramString = new char[0];
      j = 0;
      label12:
      if (i >= paramString.length) {
        return j;
      }
      if (paramString[i] >= 'Ā') {
        break label48;
      }
    }
    label48:
    for (int k = 1;; k = 2)
    {
      j += k;
      i += 1;
      break label12;
      paramString = paramString.toCharArray();
      break;
    }
    return j;
  }
  
  public static <T> boolean isEqual(T paramT1, T paramT2)
  {
    if (((paramT1 == null) && (paramT2 != null)) || ((paramT1 != null) && (!paramT1.equals(paramT2)))) {}
    for (int i = 1; i == 0; i = 0) {
      return true;
    }
    return false;
  }
  
  public static boolean isLeapYear(int paramInt)
  {
    return (paramInt % 400 == 0) || ((paramInt % 4 == 0) && (paramInt % 100 != 0));
  }
  
  public static Date longToDate(long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    return localCalendar.getTime();
  }
  
  public static String longToTime(long paramLong, int paramInt)
  {
    String str = "yyyy-MM-dd kk:mm:ss";
    switch (paramInt)
    {
    }
    for (;;)
    {
      return new SimpleDateFormat(str).format(Long.valueOf(paramLong));
      str = "yyyy-MM-dd kk:mm";
      continue;
      str = "yyyy-MM-dd kk";
      continue;
      str = "yyyy-MM-dd";
      continue;
      str = "yyyy-MM";
      continue;
      str = "yyyy";
    }
  }
  
  public static int parseInt(String paramString)
    throws Throwable
  {
    return parseInt(paramString, 10);
  }
  
  public static int parseInt(String paramString, int paramInt)
    throws Throwable
  {
    return Integer.parseInt(paramString, paramInt);
  }
  
  public static long parseLong(String paramString)
    throws Throwable
  {
    return parseLong(paramString, 10);
  }
  
  public static long parseLong(String paramString, int paramInt)
    throws Throwable
  {
    return Long.parseLong(paramString, paramInt);
  }
  
  public static Uri pathToContentUri(Context paramContext, String paramString)
  {
    try
    {
      if (DeviceHelper.getInstance(paramContext).checkPermission("android.permission.READ_EXTERNAL_STORAGE"))
      {
        Object localObject = paramContext.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[] { "_id" }, "_data=? ", new String[] { paramString }, null);
        if ((localObject != null) && (((Cursor)localObject).moveToFirst()))
        {
          int i = ((Cursor)localObject).getInt(((Cursor)localObject).getColumnIndex("_id"));
          return Uri.withAppendedPath(Uri.parse("content://media/external/images/media"), "" + i);
        }
        if (new File(paramString).exists())
        {
          localObject = new ContentValues();
          ((ContentValues)localObject).put("_data", paramString);
          paramString = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
          paramContext = paramContext.getContentResolver().insert(paramString, (ContentValues)localObject);
          return paramContext;
        }
      }
    }
    catch (Throwable paramContext)
    {
      MobLog.getInstance().w(paramContext);
    }
    return null;
  }
  
  public static int pxToDip(Context paramContext, int paramInt)
  {
    if (density <= 0.0F) {
      density = paramContext.getResources().getDisplayMetrics().density;
    }
    return (int)(paramInt / density + 0.5F);
  }
  
  public static Object readObjectFromFile(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      paramString = new File(paramString);
      boolean bool = paramString.exists();
      if (!bool) {
        paramString = null;
      }
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        try
        {
          paramString = new ObjectInputStream(new GZIPInputStream(new FileInputStream(paramString)));
          localObject1 = paramString.readObject();
          paramString.close();
          return localObject1;
        }
        catch (Throwable paramString)
        {
          MobLog.getInstance().d(paramString);
        }
        paramString = paramString;
        MobLog.getInstance().d(paramString);
        paramString = null;
      }
    }
    localObject1 = localObject2;
    if (paramString != null) {}
    return null;
  }
  
  public static boolean saveObjectToFile(String paramString, Object paramObject)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      try
      {
        paramString = new File(paramString);
        if (paramString.exists()) {
          paramString.delete();
        }
        if (!paramString.getParentFile().exists()) {
          paramString.getParentFile().mkdirs();
        }
        paramString.createNewFile();
      }
      catch (Throwable paramString)
      {
        for (;;)
        {
          try
          {
            paramString = new ObjectOutputStream(new GZIPOutputStream(new FileOutputStream(paramString)));
            paramString.writeObject(paramObject);
            paramString.flush();
            paramString.close();
            return true;
          }
          catch (Throwable paramString)
          {
            MobLog.getInstance().d(paramString);
          }
          paramString = paramString;
          MobLog.getInstance().d(paramString);
          paramString = null;
        }
      }
      if (paramString == null) {}
    }
    return false;
  }
  
  public static void setResourceProvider(Object paramObject)
  {
    try
    {
      if (paramObject.getClass().getMethod("getResId", new Class[] { Context.class, String.class, String.class }) != null) {
        rp = paramObject;
      }
      return;
    }
    catch (Throwable paramObject)
    {
      MobLog.getInstance().d((Throwable)paramObject);
    }
  }
  
  public static long strToDate(String paramString)
  {
    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(paramString, new ParsePosition(0)).getTime();
  }
  
  public static String toString(Object paramObject)
  {
    if (paramObject == null) {
      return "";
    }
    return paramObject.toString();
  }
  
  public static String toWordText(String paramString, int paramInt)
  {
    paramString = paramString.toCharArray();
    StringBuilder localStringBuilder = new StringBuilder();
    int k = paramString.length;
    int i = paramInt * 2;
    paramInt = 0;
    while (paramInt < k)
    {
      char c = paramString[paramInt];
      if (c < 'Ā') {}
      for (int j = 1;; j = 2)
      {
        i -= j;
        if (i >= 0) {
          break;
        }
        return localStringBuilder.toString();
      }
      localStringBuilder.append(c);
      paramInt += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static Bundle urlToBundle(String paramString)
  {
    int i = paramString.indexOf("://");
    if (i >= 0) {}
    for (paramString = "http://" + paramString.substring(i + 1);; paramString = "http://" + paramString) {
      try
      {
        paramString = new URL(paramString);
        Bundle localBundle = decodeUrl(paramString.getQuery());
        localBundle.putAll(decodeUrl(paramString.getRef()));
        return localBundle;
      }
      catch (Throwable paramString)
      {
        MobLog.getInstance().w(paramString);
      }
    }
    return new Bundle();
  }
  
  public static Uri videoPathToContentUri(Context paramContext, String paramString)
  {
    try
    {
      if (DeviceHelper.getInstance(paramContext).checkPermission("android.permission.READ_EXTERNAL_STORAGE"))
      {
        Object localObject = paramContext.getContentResolver().query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, new String[] { "_id" }, "_data=? ", new String[] { paramString }, null);
        if ((localObject != null) && (((Cursor)localObject).moveToFirst()))
        {
          int i = ((Cursor)localObject).getInt(((Cursor)localObject).getColumnIndex("_id"));
          return Uri.withAppendedPath(Uri.parse("content://media/external/video/media"), "" + i);
        }
        if (new File(paramString).exists())
        {
          localObject = new ContentValues();
          ((ContentValues)localObject).put("_data", paramString);
          paramString = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
          paramContext = paramContext.getContentResolver().insert(paramString, (ContentValues)localObject);
          return paramContext;
        }
      }
    }
    catch (Throwable paramContext)
    {
      MobLog.getInstance().w(paramContext);
    }
    return null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mob/tools/utils/ResHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */