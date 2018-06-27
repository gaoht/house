package com.growingio.android.sdk.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Environment;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class FileOutUtil
{
  private static final File a = new File(Environment.getExternalStorageDirectory(), "GrowingIO" + File.separator);
  private String b;
  private String c;
  private DateFormat d = new SimpleDateFormat("HH:mm:ss.SSS", Locale.US);
  private DateFormat e = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
  private File f;
  
  public FileOutUtil(Context paramContext, String paramString)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    Object localObject = null;
    try
    {
      paramContext = localPackageManager.getApplicationInfo(paramContext.getApplicationInfo().packageName, 0);
      if (paramContext != null) {}
      for (paramContext = localPackageManager.getApplicationLabel(paramContext);; paramContext = "Unknown")
      {
        this.b = ((String)paramContext);
        this.c = paramString;
        this.f = new File(a, paramString + File.separator);
        return;
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        paramContext = (Context)localObject;
      }
    }
  }
  
  /* Error */
  public boolean a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: invokestatic 112	com/growingio/android/sdk/utils/PermissionUtil:c	()Z
    //   8: ifne +5 -> 13
    //   11: iconst_0
    //   12: ireturn
    //   13: aload_0
    //   14: getfield 102	com/growingio/android/sdk/utils/FileOutUtil:f	Ljava/io/File;
    //   17: invokevirtual 115	java/io/File:mkdirs	()Z
    //   20: ifne +13 -> 33
    //   23: aload_0
    //   24: getfield 102	com/growingio/android/sdk/utils/FileOutUtil:f	Ljava/io/File;
    //   27: invokevirtual 118	java/io/File:isDirectory	()Z
    //   30: ifeq +163 -> 193
    //   33: new 120	java/io/FileOutputStream
    //   36: dup
    //   37: ldc 122
    //   39: iconst_4
    //   40: anewarray 4	java/lang/Object
    //   43: dup
    //   44: iconst_0
    //   45: aload_0
    //   46: getfield 102	com/growingio/android/sdk/utils/FileOutUtil:f	Ljava/io/File;
    //   49: invokevirtual 125	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   52: aastore
    //   53: dup
    //   54: iconst_1
    //   55: getstatic 37	java/io/File:separator	Ljava/lang/String;
    //   58: aastore
    //   59: dup
    //   60: iconst_2
    //   61: aload_0
    //   62: getfield 98	com/growingio/android/sdk/utils/FileOutUtil:b	Ljava/lang/String;
    //   65: aastore
    //   66: dup
    //   67: iconst_3
    //   68: aload_0
    //   69: getfield 70	com/growingio/android/sdk/utils/FileOutUtil:e	Ljava/text/DateFormat;
    //   72: invokestatic 131	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   75: invokevirtual 135	java/util/Calendar:getTimeInMillis	()J
    //   78: invokestatic 141	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   81: invokevirtual 147	java/text/DateFormat:format	(Ljava/lang/Object;)Ljava/lang/String;
    //   84: aastore
    //   85: invokestatic 150	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   88: iconst_1
    //   89: invokespecial 153	java/io/FileOutputStream:<init>	(Ljava/lang/String;Z)V
    //   92: astore 5
    //   94: aload 5
    //   96: invokevirtual 157	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   99: invokevirtual 163	java/nio/channels/FileChannel:lock	()Ljava/nio/channels/FileLock;
    //   102: astore_2
    //   103: new 165	java/io/BufferedWriter
    //   106: dup
    //   107: new 167	java/io/OutputStreamWriter
    //   110: dup
    //   111: aload 5
    //   113: ldc -87
    //   115: invokespecial 172	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   118: invokespecial 175	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   121: astore_3
    //   122: aload_3
    //   123: ldc -79
    //   125: iconst_2
    //   126: anewarray 4	java/lang/Object
    //   129: dup
    //   130: iconst_0
    //   131: aload_0
    //   132: getfield 66	com/growingio/android/sdk/utils/FileOutUtil:d	Ljava/text/DateFormat;
    //   135: invokestatic 131	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   138: invokevirtual 135	java/util/Calendar:getTimeInMillis	()J
    //   141: invokestatic 141	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   144: invokevirtual 147	java/text/DateFormat:format	(Ljava/lang/Object;)Ljava/lang/String;
    //   147: aastore
    //   148: dup
    //   149: iconst_1
    //   150: aload_1
    //   151: aastore
    //   152: invokestatic 150	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   155: invokevirtual 181	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   158: ldc -73
    //   160: iconst_1
    //   161: anewarray 4	java/lang/Object
    //   164: dup
    //   165: iconst_0
    //   166: aload_1
    //   167: aastore
    //   168: invokestatic 188	com/growingio/android/sdk/utils/LogUtil:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   171: aload_3
    //   172: invokevirtual 191	java/io/BufferedWriter:close	()V
    //   175: aload_3
    //   176: ifnull +7 -> 183
    //   179: aload_3
    //   180: invokevirtual 191	java/io/BufferedWriter:close	()V
    //   183: aload_2
    //   184: ifnull +7 -> 191
    //   187: aload_2
    //   188: invokevirtual 196	java/nio/channels/FileLock:release	()V
    //   191: iconst_1
    //   192: ireturn
    //   193: iconst_0
    //   194: ifeq +11 -> 205
    //   197: new 198	java/lang/NullPointerException
    //   200: dup
    //   201: invokespecial 199	java/lang/NullPointerException:<init>	()V
    //   204: athrow
    //   205: iconst_0
    //   206: ifeq -195 -> 11
    //   209: new 198	java/lang/NullPointerException
    //   212: dup
    //   213: invokespecial 199	java/lang/NullPointerException:<init>	()V
    //   216: athrow
    //   217: astore_1
    //   218: iconst_0
    //   219: ireturn
    //   220: astore 4
    //   222: aconst_null
    //   223: astore_1
    //   224: aload_3
    //   225: astore_2
    //   226: aload 4
    //   228: astore_3
    //   229: ldc -73
    //   231: ldc -55
    //   233: aload_3
    //   234: invokestatic 204	com/growingio/android/sdk/utils/LogUtil:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   237: aload_1
    //   238: ifnull +7 -> 245
    //   241: aload_1
    //   242: invokevirtual 191	java/io/BufferedWriter:close	()V
    //   245: aload_2
    //   246: ifnull -235 -> 11
    //   249: aload_2
    //   250: invokevirtual 196	java/nio/channels/FileLock:release	()V
    //   253: iconst_0
    //   254: ireturn
    //   255: astore_1
    //   256: iconst_0
    //   257: ireturn
    //   258: astore_1
    //   259: aconst_null
    //   260: astore_3
    //   261: aload 4
    //   263: astore_2
    //   264: aload_3
    //   265: ifnull +7 -> 272
    //   268: aload_3
    //   269: invokevirtual 191	java/io/BufferedWriter:close	()V
    //   272: aload_2
    //   273: ifnull +7 -> 280
    //   276: aload_2
    //   277: invokevirtual 196	java/nio/channels/FileLock:release	()V
    //   280: aload_1
    //   281: athrow
    //   282: astore_1
    //   283: goto -100 -> 183
    //   286: astore_1
    //   287: goto -96 -> 191
    //   290: astore_1
    //   291: goto -86 -> 205
    //   294: astore_1
    //   295: goto -50 -> 245
    //   298: astore_3
    //   299: goto -27 -> 272
    //   302: astore_2
    //   303: goto -23 -> 280
    //   306: astore_1
    //   307: aconst_null
    //   308: astore_3
    //   309: goto -45 -> 264
    //   312: astore_1
    //   313: goto -49 -> 264
    //   316: astore 4
    //   318: aload_1
    //   319: astore_3
    //   320: aload 4
    //   322: astore_1
    //   323: goto -59 -> 264
    //   326: astore_3
    //   327: aconst_null
    //   328: astore_1
    //   329: goto -100 -> 229
    //   332: astore 4
    //   334: aload_3
    //   335: astore_1
    //   336: aload 4
    //   338: astore_3
    //   339: goto -110 -> 229
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	342	0	this	FileOutUtil
    //   0	342	1	paramString	String
    //   102	175	2	localObject1	Object
    //   302	1	2	localIOException1	java.io.IOException
    //   4	265	3	localObject2	Object
    //   298	1	3	localIOException2	java.io.IOException
    //   308	12	3	str	String
    //   326	9	3	localIOException3	java.io.IOException
    //   338	1	3	localIOException4	java.io.IOException
    //   1	1	4	localObject3	Object
    //   220	42	4	localIOException5	java.io.IOException
    //   316	5	4	localObject4	Object
    //   332	5	4	localIOException6	java.io.IOException
    //   92	20	5	localFileOutputStream	java.io.FileOutputStream
    // Exception table:
    //   from	to	target	type
    //   209	217	217	java/io/IOException
    //   13	33	220	java/io/IOException
    //   33	103	220	java/io/IOException
    //   249	253	255	java/io/IOException
    //   13	33	258	finally
    //   33	103	258	finally
    //   179	183	282	java/io/IOException
    //   187	191	286	java/io/IOException
    //   197	205	290	java/io/IOException
    //   241	245	294	java/io/IOException
    //   268	272	298	java/io/IOException
    //   276	280	302	java/io/IOException
    //   103	122	306	finally
    //   122	175	312	finally
    //   229	237	316	finally
    //   103	122	326	java/io/IOException
    //   122	175	332	java/io/IOException
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/growingio/android/sdk/utils/FileOutUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */