package cn.jpush.android.c;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import java.io.File;
import java.util.Arrays;

public final class c
{
  public static final String a;
  private static final String[] z;
  
  static
  {
    Object localObject2 = new String[10];
    int j = 0;
    Object localObject3 = "M|J7moo[{fz|L7yczJb{o9LrzelLtl*_~eo}\020";
    int i = -1;
    Object localObject1 = localObject2;
    int i4;
    Object localObject4;
    int n;
    for (;;)
    {
      char[] arrayOfChar = ((String)localObject3).toCharArray();
      k = arrayOfChar.length;
      int i1 = 0;
      m = 0;
      int i3 = i;
      localObject3 = arrayOfChar;
      i4 = j;
      localObject4 = localObject1;
      n = k;
      Object localObject5;
      int i2;
      if (k <= 1)
      {
        localObject5 = localObject1;
        localObject1 = arrayOfChar;
        i2 = i;
      }
      label143:
      do
      {
        n = m;
        for (;;)
        {
          localObject3 = localObject1;
          i1 = localObject3[m];
          switch (n % 5)
          {
          default: 
            i = 9;
            localObject3[m] = ((char)(i ^ i1));
            n += 1;
            if (k != 0) {
              break label143;
            }
            m = k;
          }
        }
        i1 = n;
        n = k;
        localObject4 = localObject5;
        i4 = j;
        localObject3 = localObject1;
        i3 = i2;
        i2 = i3;
        localObject1 = localObject3;
        j = i4;
        localObject5 = localObject4;
        k = n;
        m = i1;
      } while (n > i1);
      localObject1 = new String((char[])localObject3).intern();
      switch (i3)
      {
      default: 
        localObject4[i4] = localObject1;
        j = 1;
        localObject3 = "Dv\036DMIxLs)lvKym$";
        i = 0;
        localObject1 = localObject2;
        break;
      case 0: 
        localObject4[i4] = localObject1;
        j = 2;
        localObject3 = "NpLrj~vLn\\~pRd";
        i = 1;
        localObject1 = localObject2;
        break;
      case 1: 
        localObject4[i4] = localObject1;
        j = 3;
        localObject3 = "IxP0}*Wym*}[alfvNr{*iWt}k[7{ojQb{i|\036~g*JzThx}\020";
        i = 2;
        localObject1 = localObject2;
        break;
      case 2: 
        localObject4[i4] = localObject1;
        j = 4;
        localObject3 = "%XPs{epZ8mkm_8";
        i = 3;
        localObject1 = localObject2;
        break;
      case 3: 
        localObject4[i4] = localObject1;
        j = 5;
        localObject3 = "N|Rr}o9Z~{*|Lefx";
        i = 4;
        localObject1 = localObject2;
        break;
      case 4: 
        localObject4[i4] = localObject1;
        j = 6;
        localObject3 = "&9]xg~|Pc3";
        i = 5;
        localObject1 = localObject2;
        break;
      case 5: 
        localObject4[i4] = localObject1;
        j = 7;
        localObject3 = "DLr[)ivPclrm";
        i = 6;
        localObject1 = localObject2;
        break;
      case 6: 
        localObject4[i4] = localObject1;
        j = 8;
        localObject3 = "_Mx:1";
        i = 7;
        localObject1 = localObject2;
        break;
      case 7: 
        localObject4[i4] = localObject1;
        j = 9;
        localObject3 = "kzJ~fd#]elkm[_}gux~eo9\0237ocu[Gh~q\004";
        i = 8;
        localObject1 = localObject2;
      }
    }
    localObject4[i4] = localObject1;
    z = (String[])localObject2;
    localObject3 = new StringBuilder().append(File.separator);
    localObject1 = "xp]".toCharArray();
    j = localObject1.length;
    int m = 0;
    i = 0;
    localObject2 = localObject1;
    int k = j;
    if (j <= 1) {}
    label522:
    label637:
    do
    {
      m = i;
      k = i;
      localObject2 = localObject1;
      n = localObject2[k];
      switch (m % 5)
      {
      default: 
        i = 9;
      }
      for (;;)
      {
        localObject2[k] = ((char)(i ^ n));
        m += 1;
        if (j != 0) {
          break label637;
        }
        k = j;
        break label522;
        i = 10;
        break;
        i = 25;
        break;
        i = 62;
        break;
        i = 23;
        break;
        i = 10;
        continue;
        i = 25;
        continue;
        i = 62;
        continue;
        i = 23;
      }
      k = j;
      localObject2 = localObject1;
      localObject1 = localObject2;
      j = k;
      i = m;
    } while (k > m);
    a = new String((char[])localObject2).intern() + File.separator;
  }
  
  public static String a(Context paramContext, String paramString)
  {
    paramContext = paramContext.getFilesDir() + "/" + paramString;
    try
    {
      paramString = new File(paramContext);
      if (!paramString.exists()) {
        paramString.mkdir();
      }
      return paramContext + "/";
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    return paramString.substring(paramString.lastIndexOf("/") + 1, paramString.length());
  }
  
  private static boolean a(File paramFile)
  {
    for (;;)
    {
      int i;
      try
      {
        if (!paramFile.exists()) {
          return false;
        }
        if (paramFile.isFile()) {
          return paramFile.delete();
        }
        String[] arrayOfString = paramFile.list();
        if (arrayOfString != null)
        {
          int j = arrayOfString.length;
          i = 0;
          if (i < j)
          {
            File localFile = new File(paramFile, arrayOfString[i]);
            if (localFile.isDirectory()) {
              a(localFile);
            } else {
              localFile.delete();
            }
          }
        }
      }
      catch (Exception paramFile)
      {
        f.i(z[2], z[5]);
        return false;
      }
      boolean bool = paramFile.delete();
      return bool;
      i += 1;
    }
  }
  
  /* Error */
  public static boolean a(String paramString1, String paramString2, Context paramContext)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +17 -> 18
    //   4: new 145	java/lang/IllegalArgumentException
    //   7: dup
    //   8: getstatic 46	cn/jpush/android/c/c:z	[Ljava/lang/String;
    //   11: bipush 7
    //   13: aaload
    //   14: invokespecial 146	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   17: athrow
    //   18: getstatic 46	cn/jpush/android/c/c:z	[Ljava/lang/String;
    //   21: iconst_2
    //   22: aaload
    //   23: new 48	java/lang/StringBuilder
    //   26: dup
    //   27: getstatic 46	cn/jpush/android/c/c:z	[Ljava/lang/String;
    //   30: bipush 9
    //   32: aaload
    //   33: invokespecial 147	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   36: aload_0
    //   37: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: getstatic 46	cn/jpush/android/c/c:z	[Ljava/lang/String;
    //   43: bipush 6
    //   45: aaload
    //   46: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: aload_1
    //   50: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokestatic 149	cn/jpush/android/c/f:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   59: aload_0
    //   60: invokestatic 101	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   63: ifne +86 -> 149
    //   66: aload_1
    //   67: invokestatic 101	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   70: ifne +79 -> 149
    //   73: new 52	java/io/File
    //   76: dup
    //   77: aload_0
    //   78: invokespecial 84	java/io/File:<init>	(Ljava/lang/String;)V
    //   81: astore_0
    //   82: aload_0
    //   83: invokevirtual 88	java/io/File:exists	()Z
    //   86: ifne +8 -> 94
    //   89: aload_0
    //   90: invokevirtual 152	java/io/File:createNewFile	()Z
    //   93: pop
    //   94: new 154	java/io/FileOutputStream
    //   97: dup
    //   98: aload_0
    //   99: invokespecial 157	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   102: astore_2
    //   103: aload_2
    //   104: aload_1
    //   105: getstatic 46	cn/jpush/android/c/c:z	[Ljava/lang/String;
    //   108: bipush 8
    //   110: aaload
    //   111: invokevirtual 161	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   114: invokevirtual 165	java/io/FileOutputStream:write	([B)V
    //   117: aload_2
    //   118: invokevirtual 168	java/io/FileOutputStream:flush	()V
    //   121: aload_2
    //   122: invokevirtual 171	java/io/FileOutputStream:close	()V
    //   125: iconst_1
    //   126: ireturn
    //   127: aload_1
    //   128: ifnull +7 -> 135
    //   131: aload_1
    //   132: invokevirtual 171	java/io/FileOutputStream:close	()V
    //   135: aload_0
    //   136: athrow
    //   137: astore_0
    //   138: getstatic 46	cn/jpush/android/c/c:z	[Ljava/lang/String;
    //   141: iconst_2
    //   142: aaload
    //   143: ldc 103
    //   145: aload_0
    //   146: invokestatic 174	cn/jpush/android/c/f:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   149: iconst_0
    //   150: ireturn
    //   151: astore_0
    //   152: aload_2
    //   153: astore_1
    //   154: goto -27 -> 127
    //   157: astore_0
    //   158: aconst_null
    //   159: astore_1
    //   160: goto -33 -> 127
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	163	0	paramString1	String
    //   0	163	1	paramString2	String
    //   0	163	2	paramContext	Context
    // Exception table:
    //   from	to	target	type
    //   73	94	137	java/io/IOException
    //   121	125	137	java/io/IOException
    //   131	135	137	java/io/IOException
    //   135	137	137	java/io/IOException
    //   103	121	151	finally
    //   94	103	157	finally
  }
  
  /* Error */
  public static boolean a(String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 101	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +66 -> 70
    //   7: aload_1
    //   8: arraylength
    //   9: ifle +61 -> 70
    //   12: new 52	java/io/File
    //   15: dup
    //   16: aload_0
    //   17: invokespecial 84	java/io/File:<init>	(Ljava/lang/String;)V
    //   20: astore_0
    //   21: aload_0
    //   22: invokevirtual 88	java/io/File:exists	()Z
    //   25: ifne +8 -> 33
    //   28: aload_0
    //   29: invokevirtual 152	java/io/File:createNewFile	()Z
    //   32: pop
    //   33: new 154	java/io/FileOutputStream
    //   36: dup
    //   37: aload_0
    //   38: invokespecial 157	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   41: astore_2
    //   42: aload_2
    //   43: aload_1
    //   44: invokevirtual 165	java/io/FileOutputStream:write	([B)V
    //   47: aload_2
    //   48: invokevirtual 168	java/io/FileOutputStream:flush	()V
    //   51: aload_2
    //   52: invokevirtual 171	java/io/FileOutputStream:close	()V
    //   55: iconst_1
    //   56: ireturn
    //   57: astore_0
    //   58: aconst_null
    //   59: astore_1
    //   60: aload_1
    //   61: ifnull +7 -> 68
    //   64: aload_1
    //   65: invokevirtual 171	java/io/FileOutputStream:close	()V
    //   68: aload_0
    //   69: athrow
    //   70: iconst_0
    //   71: ireturn
    //   72: astore_0
    //   73: aload_2
    //   74: astore_1
    //   75: goto -15 -> 60
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	paramString	String
    //   0	78	1	paramArrayOfByte	byte[]
    //   41	33	2	localFileOutputStream	java.io.FileOutputStream
    // Exception table:
    //   from	to	target	type
    //   33	42	57	finally
    //   42	51	72	finally
  }
  
  public static String b(Context paramContext, String paramString)
  {
    try
    {
      Object localObject;
      if (a.a())
      {
        localObject = Environment.getExternalStorageDirectory().getAbsolutePath();
        paramString = (String)localObject + z[4] + paramContext.getPackageName() + File.separator + paramString + File.separator;
        localObject = new File(paramString);
        paramContext = paramString;
        if (!((File)localObject).exists())
        {
          ((File)localObject).mkdirs();
          return paramString;
        }
      }
      else
      {
        localObject = new File(paramContext.getFilesDir() + a);
        if ((((File)localObject).exists()) && (((File)localObject).isDirectory()))
        {
          localObject = ((File)localObject).listFiles();
          if ((localObject != null) && (localObject.length > 10))
          {
            Arrays.sort((Object[])localObject, new d());
            a(localObject[(localObject.length - 1)]);
          }
        }
        paramContext = d(paramContext, paramString);
        return paramContext;
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      paramContext = "";
    }
    return paramContext;
  }
  
  public static String c(Context paramContext, String paramString)
  {
    try
    {
      if (a.a())
      {
        String str = Environment.getExternalStorageDirectory().getAbsolutePath();
        paramContext = str + z[4] + paramContext.getPackageName() + File.separator + paramString;
        if (new File(paramContext).exists()) {
          return paramContext;
        }
        f.h(z[2], z[3]);
        return "";
      }
      f.h(z[2], z[1]);
      return "";
    }
    catch (Exception paramContext)
    {
      f.h(z[2], z[0]);
      paramContext.printStackTrace();
    }
    return "";
  }
  
  private static String d(Context paramContext, String paramString)
  {
    paramContext = paramContext.getFilesDir() + a + paramString;
    try
    {
      paramString = new File(paramContext);
      if (!paramString.exists()) {
        paramString.mkdirs();
      }
      return paramContext + "/";
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jpush/android/c/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */