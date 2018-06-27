package com.huawei.hms.update.provider;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import java.io.File;
import java.io.IOException;

class a
{
  private Context a;
  private String b;
  
  /* Error */
  private String a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 16	com/huawei/hms/update/provider/a:a	Landroid/content/Context;
    //   4: ldc 18
    //   6: invokestatic 23	com/huawei/hms/a/a:b	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   9: checkcast 25	android/content/Context
    //   12: astore_1
    //   13: aload_0
    //   14: monitorenter
    //   15: aload_0
    //   16: getfield 27	com/huawei/hms/update/provider/a:b	Ljava/lang/String;
    //   19: ifnonnull +21 -> 40
    //   22: aload_1
    //   23: invokevirtual 31	android/content/Context:getExternalCacheDir	()Ljava/io/File;
    //   26: ifnull +23 -> 49
    //   29: aload_0
    //   30: aload_1
    //   31: invokevirtual 31	android/content/Context:getExternalCacheDir	()Ljava/io/File;
    //   34: invokestatic 34	com/huawei/hms/update/provider/a:a	(Ljava/io/File;)Ljava/lang/String;
    //   37: putfield 27	com/huawei/hms/update/provider/a:b	Ljava/lang/String;
    //   40: aload_0
    //   41: getfield 27	com/huawei/hms/update/provider/a:b	Ljava/lang/String;
    //   44: astore_1
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_1
    //   48: areturn
    //   49: aload_0
    //   50: aload_1
    //   51: invokevirtual 37	android/content/Context:getFilesDir	()Ljava/io/File;
    //   54: invokestatic 34	com/huawei/hms/update/provider/a:a	(Ljava/io/File;)Ljava/lang/String;
    //   57: putfield 27	com/huawei/hms/update/provider/a:b	Ljava/lang/String;
    //   60: goto -20 -> 40
    //   63: astore_1
    //   64: aload_0
    //   65: monitorexit
    //   66: aload_1
    //   67: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	this	a
    //   12	39	1	localObject1	Object
    //   63	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   15	40	63	finally
    //   40	47	63	finally
    //   49	60	63	finally
    //   64	66	63	finally
  }
  
  private static String a(File paramFile)
  {
    try
    {
      paramFile = paramFile.getCanonicalPath();
      return paramFile;
    }
    catch (IOException paramFile) {}
    return null;
  }
  
  private String b(String paramString)
  {
    String str = a();
    if (!paramString.startsWith(str)) {
      return null;
    }
    if (str.endsWith("/")) {}
    for (int i = str.length();; i = str.length() + 1) {
      return Uri.encode("update") + '/' + paramString.substring(i);
    }
  }
  
  private String c(String paramString)
  {
    int i = paramString.indexOf('/', 1);
    if (i < 0) {}
    String str;
    do
    {
      do
      {
        return null;
      } while (!"update".equals(Uri.decode(paramString.substring(1, i))));
      str = a();
      paramString = a(new File(str, Uri.decode(paramString.substring(i + 1))));
    } while ((paramString == null) || (!paramString.startsWith(str)));
    return paramString;
  }
  
  public Uri a(File paramFile, String paramString)
  {
    paramFile = a(paramFile);
    if (paramFile == null) {}
    do
    {
      return null;
      paramFile = b(paramFile);
    } while (paramFile == null);
    return new Uri.Builder().scheme("content").authority(paramString).encodedPath(paramFile).build();
  }
  
  public File a(Uri paramUri)
  {
    paramUri = paramUri.getEncodedPath();
    if (paramUri == null) {}
    do
    {
      return null;
      paramUri = c(paramUri);
    } while (paramUri == null);
    return new File(paramUri);
  }
  
  public File a(String paramString)
  {
    return new File(a(), paramString);
  }
  
  public void a(Context paramContext)
  {
    com.huawei.hms.a.a.a(paramContext, "context nust not be null.");
    this.a = paramContext;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/huawei/hms/update/provider/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */