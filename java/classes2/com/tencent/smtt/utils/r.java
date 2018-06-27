package com.tencent.smtt.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.smtt.sdk.a.d;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class r
{
  private static r a = null;
  private Handler b = null;
  
  private int a(Context paramContext)
  {
    if (a("com.tencent.mtt", paramContext, 128) != null) {
      return 2;
    }
    if (!TextUtils.isEmpty(e(paramContext))) {
      return 1;
    }
    return 0;
  }
  
  public static r a()
  {
    if (a == null) {
      a = new r();
    }
    return a;
  }
  
  private Map<String, String> a(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      paramString = null;
    }
    for (;;)
    {
      return paramString;
      for (;;)
      {
        try
        {
          localHashMap = new HashMap();
        }
        catch (Throwable paramString)
        {
          String[] arrayOfString;
          int j;
          int i;
          Object localObject;
          HashMap localHashMap = null;
          continue;
          i += 1;
          continue;
        }
        try
        {
          arrayOfString = paramString.split("\n");
          j = arrayOfString.length;
          i = 0;
          paramString = localHashMap;
          if (i >= j) {
            break;
          }
          paramString = arrayOfString[i];
          if ((paramString == null) || (paramString.length() <= 0)) {
            continue;
          }
          localObject = paramString.trim().split("=", 2);
          if ((localObject == null) || (localObject.length < 2)) {
            continue;
          }
          paramString = localObject[0];
          localObject = localObject[1];
          if ((paramString == null) || (paramString.length() <= 0)) {
            continue;
          }
          localHashMap.put(paramString, localObject);
        }
        catch (Throwable paramString) {}
      }
    }
    paramString.printStackTrace();
    return localHashMap;
  }
  
  private void b(Context paramContext)
  {
    Message localMessage = new Message();
    localMessage.what = 1;
    localMessage.obj = new Object[] { paramContext };
    this.b.sendMessage(localMessage);
  }
  
  public static void b(Context paramContext, String paramString)
  {
    if ((paramContext != null) && (paramString != null) && (paramString.length() > 0)) {
      d.a(paramContext, paramString, null, null);
    }
  }
  
  private void c(Context paramContext)
  {
    try
    {
      Object localObject = e(paramContext);
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        return;
      }
      localObject = new File((String)localObject);
      if (((File)localObject).exists())
      {
        Intent localIntent = new Intent("android.intent.action.VIEW");
        localIntent.addFlags(268435456);
        localIntent.setDataAndType(Uri.fromFile((File)localObject), "application/vnd.android.package-archive");
        paramContext.startActivity(localIntent);
        t.a(paramContext).a(paramContext.getApplicationInfo().processName);
        return;
      }
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  private void c(Context paramContext, String paramString)
  {
    Message localMessage = new Message();
    localMessage.what = 0;
    localMessage.obj = new Object[] { paramContext, paramString };
    this.b.sendMessage(localMessage);
  }
  
  /* Error */
  private Map<String, String> d(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: ldc -80
    //   8: astore_2
    //   9: aload 6
    //   11: astore_1
    //   12: new 118	java/io/File
    //   15: dup
    //   16: ldc -78
    //   18: invokespecial 121	java/io/File:<init>	(Ljava/lang/String;)V
    //   21: astore 4
    //   23: aload 4
    //   25: ifnull +17 -> 42
    //   28: aload 4
    //   30: astore_3
    //   31: aload 6
    //   33: astore_1
    //   34: aload 4
    //   36: invokevirtual 125	java/io/File:exists	()Z
    //   39: ifne +16 -> 55
    //   42: aload 6
    //   44: astore_1
    //   45: new 118	java/io/File
    //   48: dup
    //   49: ldc -76
    //   51: invokespecial 121	java/io/File:<init>	(Ljava/lang/String;)V
    //   54: astore_3
    //   55: aload_3
    //   56: ifnull +16 -> 72
    //   59: aload_3
    //   60: astore 4
    //   62: aload 6
    //   64: astore_1
    //   65: aload_3
    //   66: invokevirtual 125	java/io/File:exists	()Z
    //   69: ifne +17 -> 86
    //   72: aload 6
    //   74: astore_1
    //   75: new 118	java/io/File
    //   78: dup
    //   79: ldc -74
    //   81: invokespecial 121	java/io/File:<init>	(Ljava/lang/String;)V
    //   84: astore 4
    //   86: aload 4
    //   88: ifnull +161 -> 249
    //   91: aload 6
    //   93: astore_1
    //   94: aload 4
    //   96: invokevirtual 125	java/io/File:exists	()Z
    //   99: ifeq +150 -> 249
    //   102: aload 6
    //   104: astore_1
    //   105: new 184	java/io/FileInputStream
    //   108: dup
    //   109: aload 4
    //   111: invokespecial 187	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   114: astore_3
    //   115: aload_3
    //   116: invokestatic 192	com/tencent/smtt/utils/j:b	(Ljava/io/InputStream;)[B
    //   119: astore 4
    //   121: aload_2
    //   122: astore_1
    //   123: aload_3
    //   124: astore 5
    //   126: aload 4
    //   128: ifnull +18 -> 146
    //   131: new 52	java/lang/String
    //   134: dup
    //   135: aload 4
    //   137: ldc -62
    //   139: invokespecial 197	java/lang/String:<init>	([BLjava/lang/String;)V
    //   142: astore_1
    //   143: aload_3
    //   144: astore 5
    //   146: aload_1
    //   147: astore 4
    //   149: aload 5
    //   151: ifnull +11 -> 162
    //   154: aload 5
    //   156: invokevirtual 200	java/io/FileInputStream:close	()V
    //   159: aload_1
    //   160: astore 4
    //   162: aload_0
    //   163: aload 4
    //   165: invokespecial 202	com/tencent/smtt/utils/r:a	(Ljava/lang/String;)Ljava/util/Map;
    //   168: areturn
    //   169: astore 4
    //   171: aload 5
    //   173: astore_3
    //   174: aload_3
    //   175: astore_1
    //   176: aload 4
    //   178: invokevirtual 83	java/lang/Throwable:printStackTrace	()V
    //   181: aload_2
    //   182: astore 4
    //   184: aload_3
    //   185: ifnull -23 -> 162
    //   188: aload_3
    //   189: invokevirtual 200	java/io/FileInputStream:close	()V
    //   192: aload_2
    //   193: astore 4
    //   195: goto -33 -> 162
    //   198: astore_3
    //   199: aload_2
    //   200: astore_1
    //   201: aload_3
    //   202: invokevirtual 203	java/io/IOException:printStackTrace	()V
    //   205: aload_1
    //   206: astore 4
    //   208: goto -46 -> 162
    //   211: astore_3
    //   212: aload_1
    //   213: astore_2
    //   214: aload_3
    //   215: astore_1
    //   216: aload_2
    //   217: ifnull +7 -> 224
    //   220: aload_2
    //   221: invokevirtual 200	java/io/FileInputStream:close	()V
    //   224: aload_1
    //   225: athrow
    //   226: astore_2
    //   227: aload_2
    //   228: invokevirtual 203	java/io/IOException:printStackTrace	()V
    //   231: goto -7 -> 224
    //   234: astore_3
    //   235: goto -34 -> 201
    //   238: astore_1
    //   239: aload_3
    //   240: astore_2
    //   241: goto -25 -> 216
    //   244: astore 4
    //   246: goto -72 -> 174
    //   249: aconst_null
    //   250: astore 5
    //   252: aload_2
    //   253: astore_1
    //   254: goto -108 -> 146
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	257	0	this	r
    //   0	257	1	paramContext	Context
    //   8	213	2	localObject1	Object
    //   226	2	2	localIOException1	java.io.IOException
    //   240	13	2	localObject2	Object
    //   30	159	3	localObject3	Object
    //   198	4	3	localIOException2	java.io.IOException
    //   211	4	3	localObject4	Object
    //   234	6	3	localIOException3	java.io.IOException
    //   21	143	4	localObject5	Object
    //   169	8	4	localThrowable1	Throwable
    //   182	25	4	localObject6	Object
    //   244	1	4	localThrowable2	Throwable
    //   4	247	5	localObject7	Object
    //   1	102	6	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   12	23	169	java/lang/Throwable
    //   34	42	169	java/lang/Throwable
    //   45	55	169	java/lang/Throwable
    //   65	72	169	java/lang/Throwable
    //   75	86	169	java/lang/Throwable
    //   94	102	169	java/lang/Throwable
    //   105	115	169	java/lang/Throwable
    //   188	192	198	java/io/IOException
    //   12	23	211	finally
    //   34	42	211	finally
    //   45	55	211	finally
    //   65	72	211	finally
    //   75	86	211	finally
    //   94	102	211	finally
    //   105	115	211	finally
    //   176	181	211	finally
    //   220	224	226	java/io/IOException
    //   154	159	234	java/io/IOException
    //   115	121	238	finally
    //   131	143	238	finally
    //   115	121	244	java/lang/Throwable
    //   131	143	244	java/lang/Throwable
  }
  
  private void d(Context paramContext, String paramString)
  {
    Message localMessage = new Message();
    localMessage.what = 2;
    localMessage.obj = new Object[] { paramContext, paramString };
    this.b.sendMessage(localMessage);
  }
  
  private String e(Context paramContext)
  {
    Object localObject = d(paramContext);
    if ((localObject != null) && (((Map)localObject).size() > 0))
    {
      paramContext = (String)((Map)localObject).get("FileDownloadPath");
      localObject = (String)((Map)localObject).get("FileDownloadVerifyInfo");
      if (TextUtils.isEmpty(paramContext)) {
        paramContext = "";
      }
      File localFile;
      do
      {
        return paramContext;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          return "";
        }
        localFile = new File(paramContext);
        if (!localFile.exists()) {
          return "";
        }
      } while (TextUtils.equals(n.a(localFile.lastModified() + ""), (CharSequence)localObject));
    }
    return "";
  }
  
  private void e(Context paramContext, String paramString)
  {
    if ((paramContext != null) && (paramString != null) && (paramString.length() > 0))
    {
      paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
      paramString.addFlags(268435456);
      paramContext.startActivity(paramString);
    }
  }
  
  public PackageInfo a(String paramString, Context paramContext, int paramInt)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    try
    {
      paramString = paramContext.getPackageManager().getPackageInfo(paramString, paramInt);
      return paramString;
    }
    catch (Throwable paramString) {}
    return null;
  }
  
  public boolean a(Context paramContext, String paramString)
  {
    Object localObject2 = null;
    boolean bool = true;
    if (paramString != null) {}
    Object localObject1;
    String str;
    label182:
    label209:
    label221:
    do
    {
      for (;;)
      {
        try
        {
          if (!paramString.startsWith("tbsqbdownload://")) {
            break label182;
          }
          String[] arrayOfString1 = paramString.substring("tbsqbdownload://".length()).split(",");
          if (arrayOfString1.length <= 1) {
            break;
          }
          paramString = arrayOfString1[0].split("=");
          if ((paramString.length <= 1) || (!"url".equalsIgnoreCase(paramString[0]))) {
            break label209;
          }
          paramString = arrayOfString1[0].substring("url".length() + 1);
          String[] arrayOfString2 = arrayOfString1[1].split("=");
          localObject1 = localObject2;
          str = paramString;
          if (arrayOfString2.length <= 1) {
            break label221;
          }
          localObject1 = localObject2;
          str = paramString;
          if (!"downloadurl".equalsIgnoreCase(arrayOfString2[0])) {
            break label221;
          }
          localObject1 = arrayOfString1[1].substring("downloadurl".length() + 1);
          str = paramString;
        }
        catch (Exception paramContext)
        {
          paramContext.printStackTrace();
        }
        int i = a(paramContext);
        if (i == 2)
        {
          c(paramContext, str);
          return true;
          return false;
        }
        if (i == 1)
        {
          b(paramContext);
          return true;
        }
        if (i != 0) {
          break label234;
        }
        d(paramContext, (String)localObject1);
        return true;
        paramString = null;
      }
      str = null;
      localObject1 = localObject2;
    } while ((str != null) && (localObject1 != null));
    bool = false;
    label234:
    return bool;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/tencent/smtt/utils/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */