package com.baidu.platform.comapi;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build.VERSION;
import java.io.InputStream;

public class AssetsLoadUtil
{
  private static final boolean a;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 8) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  /* Error */
  private static String a(String paramString1, String paramString2, Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: ldc 27
    //   5: astore 4
    //   7: new 29	java/lang/StringBuilder
    //   10: dup
    //   11: aload_2
    //   12: invokevirtual 35	android/content/Context:getFilesDir	()Ljava/io/File;
    //   15: invokevirtual 41	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   18: invokespecial 44	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   21: astore 6
    //   23: getstatic 16	com/baidu/platform/comapi/AssetsLoadUtil:a	Z
    //   26: ifeq +9 -> 35
    //   29: aload_2
    //   30: invokevirtual 47	android/content/Context:getPackageCodePath	()Ljava/lang/String;
    //   33: astore 4
    //   35: new 49	java/util/zip/ZipFile
    //   38: dup
    //   39: aload 4
    //   41: invokespecial 50	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   44: astore 4
    //   46: aload_1
    //   47: ldc 52
    //   49: invokevirtual 58	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   52: istore_3
    //   53: iload_3
    //   54: ifle +102 -> 156
    //   57: new 37	java/io/File
    //   60: dup
    //   61: aload_2
    //   62: invokevirtual 35	android/content/Context:getFilesDir	()Ljava/io/File;
    //   65: invokevirtual 41	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   68: invokespecial 59	java/io/File:<init>	(Ljava/lang/String;)V
    //   71: astore_2
    //   72: aload_1
    //   73: iconst_0
    //   74: iload_3
    //   75: invokevirtual 63	java/lang/String:substring	(II)Ljava/lang/String;
    //   78: astore 5
    //   80: aload_1
    //   81: iload_3
    //   82: iconst_1
    //   83: iadd
    //   84: aload_1
    //   85: invokevirtual 67	java/lang/String:length	()I
    //   88: invokevirtual 63	java/lang/String:substring	(II)Ljava/lang/String;
    //   91: astore_1
    //   92: new 37	java/io/File
    //   95: dup
    //   96: new 29	java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   103: aload_2
    //   104: invokevirtual 41	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   107: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: ldc 52
    //   112: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: aload 5
    //   117: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: aload_1
    //   124: invokespecial 78	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   127: astore_1
    //   128: aload_2
    //   129: invokevirtual 82	java/io/File:mkdirs	()Z
    //   132: pop
    //   133: aload 4
    //   135: aload_0
    //   136: invokevirtual 86	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   139: astore_2
    //   140: aload_2
    //   141: ifnonnull +75 -> 216
    //   144: aload 4
    //   146: ifnull +8 -> 154
    //   149: aload 4
    //   151: invokevirtual 89	java/util/zip/ZipFile:close	()V
    //   154: aconst_null
    //   155: areturn
    //   156: new 37	java/io/File
    //   159: dup
    //   160: aload_2
    //   161: invokevirtual 35	android/content/Context:getFilesDir	()Ljava/io/File;
    //   164: ldc 91
    //   166: invokespecial 94	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   169: astore_2
    //   170: new 37	java/io/File
    //   173: dup
    //   174: aload_2
    //   175: invokevirtual 41	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   178: aload_1
    //   179: invokespecial 78	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   182: astore_1
    //   183: goto -55 -> 128
    //   186: astore_1
    //   187: aload 4
    //   189: astore_0
    //   190: ldc 2
    //   192: invokevirtual 99	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   195: ldc 101
    //   197: aload_1
    //   198: invokestatic 107	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   201: pop
    //   202: aload_0
    //   203: ifnull +7 -> 210
    //   206: aload_0
    //   207: invokevirtual 89	java/util/zip/ZipFile:close	()V
    //   210: aload 6
    //   212: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   215: areturn
    //   216: aload 4
    //   218: aload_2
    //   219: invokevirtual 111	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   222: new 113	java/io/FileOutputStream
    //   225: dup
    //   226: aload_1
    //   227: invokespecial 116	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   230: invokestatic 119	com/baidu/platform/comapi/AssetsLoadUtil:a	(Ljava/io/InputStream;Ljava/io/FileOutputStream;)V
    //   233: aload 6
    //   235: ldc 52
    //   237: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: aload_0
    //   241: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: pop
    //   245: aload 4
    //   247: ifnull -37 -> 210
    //   250: aload 4
    //   252: invokevirtual 89	java/util/zip/ZipFile:close	()V
    //   255: goto -45 -> 210
    //   258: astore_0
    //   259: goto -49 -> 210
    //   262: astore_0
    //   263: aconst_null
    //   264: astore_1
    //   265: aload_1
    //   266: ifnull +7 -> 273
    //   269: aload_1
    //   270: invokevirtual 89	java/util/zip/ZipFile:close	()V
    //   273: aload_0
    //   274: athrow
    //   275: astore_0
    //   276: goto -122 -> 154
    //   279: astore_0
    //   280: goto -70 -> 210
    //   283: astore_1
    //   284: goto -11 -> 273
    //   287: astore_0
    //   288: aload 4
    //   290: astore_1
    //   291: goto -26 -> 265
    //   294: astore_2
    //   295: aload_0
    //   296: astore_1
    //   297: aload_2
    //   298: astore_0
    //   299: goto -34 -> 265
    //   302: astore_1
    //   303: aload 5
    //   305: astore_0
    //   306: goto -116 -> 190
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	309	0	paramString1	String
    //   0	309	1	paramString2	String
    //   0	309	2	paramContext	Context
    //   52	32	3	i	int
    //   5	284	4	localObject	Object
    //   1	303	5	str	String
    //   21	213	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   46	53	186	java/lang/Exception
    //   57	128	186	java/lang/Exception
    //   128	140	186	java/lang/Exception
    //   156	183	186	java/lang/Exception
    //   216	245	186	java/lang/Exception
    //   250	255	258	java/io/IOException
    //   35	46	262	finally
    //   149	154	275	java/io/IOException
    //   206	210	279	java/io/IOException
    //   269	273	283	java/io/IOException
    //   46	53	287	finally
    //   57	128	287	finally
    //   128	140	287	finally
    //   156	183	287	finally
    //   216	245	287	finally
    //   190	202	294	finally
    //   35	46	302	java/lang/Exception
  }
  
  /* Error */
  private static void a(InputStream paramInputStream, java.io.FileOutputStream paramFileOutputStream)
    throws java.io.IOException
  {
    // Byte code:
    //   0: sipush 4096
    //   3: newarray <illegal type>
    //   5: astore_3
    //   6: aload_0
    //   7: aload_3
    //   8: invokevirtual 125	java/io/InputStream:read	([B)I
    //   11: istore_2
    //   12: iload_2
    //   13: iconst_m1
    //   14: if_icmpeq +24 -> 38
    //   17: aload_1
    //   18: aload_3
    //   19: iconst_0
    //   20: iload_2
    //   21: invokevirtual 129	java/io/FileOutputStream:write	([BII)V
    //   24: goto -18 -> 6
    //   27: astore_3
    //   28: aload_0
    //   29: invokevirtual 130	java/io/InputStream:close	()V
    //   32: aload_1
    //   33: invokevirtual 131	java/io/FileOutputStream:close	()V
    //   36: aload_3
    //   37: athrow
    //   38: aload_1
    //   39: invokevirtual 134	java/io/FileOutputStream:flush	()V
    //   42: aload_0
    //   43: invokevirtual 130	java/io/InputStream:close	()V
    //   46: aload_1
    //   47: invokevirtual 131	java/io/FileOutputStream:close	()V
    //   50: return
    //   51: astore_0
    //   52: return
    //   53: astore_0
    //   54: return
    //   55: astore_0
    //   56: return
    //   57: astore_0
    //   58: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	paramInputStream	InputStream
    //   0	59	1	paramFileOutputStream	java.io.FileOutputStream
    //   11	10	2	i	int
    //   5	14	3	arrayOfByte	byte[]
    //   27	10	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   6	12	27	finally
    //   17	24	27	finally
    //   38	42	27	finally
    //   42	46	51	java/io/IOException
    //   46	50	53	java/io/IOException
    //   28	32	55	java/io/IOException
    //   32	36	57	java/io/IOException
  }
  
  /* Error */
  public static void copyFileFromAsset(String paramString1, String paramString2, Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_2
    //   4: invokevirtual 141	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   7: aload_0
    //   8: invokevirtual 147	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   11: astore_3
    //   12: aload_3
    //   13: ifnull +246 -> 259
    //   16: aload_3
    //   17: invokevirtual 150	java/io/InputStream:available	()I
    //   20: newarray <illegal type>
    //   22: astore 6
    //   24: aload_3
    //   25: aload 6
    //   27: invokevirtual 125	java/io/InputStream:read	([B)I
    //   30: pop
    //   31: new 37	java/io/File
    //   34: dup
    //   35: new 29	java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   42: aload_2
    //   43: invokevirtual 35	android/content/Context:getFilesDir	()Ljava/io/File;
    //   46: invokevirtual 41	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   49: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: ldc 52
    //   54: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: aload_1
    //   58: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokespecial 59	java/io/File:<init>	(Ljava/lang/String;)V
    //   67: astore 4
    //   69: aload 4
    //   71: invokevirtual 153	java/io/File:exists	()Z
    //   74: ifeq +9 -> 83
    //   77: aload 4
    //   79: invokevirtual 156	java/io/File:delete	()Z
    //   82: pop
    //   83: aload 4
    //   85: invokevirtual 159	java/io/File:createNewFile	()Z
    //   88: pop
    //   89: new 113	java/io/FileOutputStream
    //   92: dup
    //   93: aload 4
    //   95: invokespecial 116	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   98: astore 4
    //   100: aload 4
    //   102: aload 6
    //   104: invokevirtual 162	java/io/FileOutputStream:write	([B)V
    //   107: aload 4
    //   109: invokevirtual 131	java/io/FileOutputStream:close	()V
    //   112: aload_3
    //   113: ifnull +7 -> 120
    //   116: aload_3
    //   117: invokevirtual 130	java/io/InputStream:close	()V
    //   120: aload 4
    //   122: ifnull +8 -> 130
    //   125: aload 4
    //   127: invokevirtual 131	java/io/FileOutputStream:close	()V
    //   130: return
    //   131: astore_0
    //   132: aload_0
    //   133: invokevirtual 165	java/io/IOException:printStackTrace	()V
    //   136: return
    //   137: astore_3
    //   138: aconst_null
    //   139: astore_3
    //   140: aload 5
    //   142: astore 4
    //   144: new 29	java/lang/StringBuilder
    //   147: dup
    //   148: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   151: ldc -89
    //   153: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: aload_0
    //   157: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: aload_1
    //   164: aload_2
    //   165: invokestatic 169	com/baidu/platform/comapi/AssetsLoadUtil:a	(Ljava/lang/String;Ljava/lang/String;Landroid/content/Context;)Ljava/lang/String;
    //   168: pop
    //   169: aload_3
    //   170: ifnull +7 -> 177
    //   173: aload_3
    //   174: invokevirtual 130	java/io/InputStream:close	()V
    //   177: aload 4
    //   179: ifnull -49 -> 130
    //   182: aload 4
    //   184: invokevirtual 131	java/io/FileOutputStream:close	()V
    //   187: return
    //   188: astore_0
    //   189: aload_0
    //   190: invokevirtual 165	java/io/IOException:printStackTrace	()V
    //   193: return
    //   194: astore_0
    //   195: aconst_null
    //   196: astore_3
    //   197: aconst_null
    //   198: astore_1
    //   199: aload_3
    //   200: ifnull +7 -> 207
    //   203: aload_3
    //   204: invokevirtual 130	java/io/InputStream:close	()V
    //   207: aload_1
    //   208: ifnull +7 -> 215
    //   211: aload_1
    //   212: invokevirtual 131	java/io/FileOutputStream:close	()V
    //   215: aload_0
    //   216: athrow
    //   217: astore_1
    //   218: aload_1
    //   219: invokevirtual 165	java/io/IOException:printStackTrace	()V
    //   222: goto -7 -> 215
    //   225: astore_0
    //   226: aconst_null
    //   227: astore_1
    //   228: goto -29 -> 199
    //   231: astore_0
    //   232: aload 4
    //   234: astore_1
    //   235: goto -36 -> 199
    //   238: astore_0
    //   239: aload 4
    //   241: astore_1
    //   242: goto -43 -> 199
    //   245: astore 4
    //   247: aload 5
    //   249: astore 4
    //   251: goto -107 -> 144
    //   254: astore 5
    //   256: goto -112 -> 144
    //   259: aconst_null
    //   260: astore 4
    //   262: goto -150 -> 112
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	265	0	paramString1	String
    //   0	265	1	paramString2	String
    //   0	265	2	paramContext	Context
    //   11	106	3	localInputStream	InputStream
    //   137	1	3	localException1	Exception
    //   139	65	3	localObject1	Object
    //   67	173	4	localObject2	Object
    //   245	1	4	localException2	Exception
    //   249	12	4	localObject3	Object
    //   1	247	5	localObject4	Object
    //   254	1	5	localException3	Exception
    //   22	81	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   116	120	131	java/io/IOException
    //   125	130	131	java/io/IOException
    //   3	12	137	java/lang/Exception
    //   173	177	188	java/io/IOException
    //   182	187	188	java/io/IOException
    //   3	12	194	finally
    //   203	207	217	java/io/IOException
    //   211	215	217	java/io/IOException
    //   16	83	225	finally
    //   83	100	225	finally
    //   100	112	231	finally
    //   144	169	238	finally
    //   16	83	245	java/lang/Exception
    //   83	100	245	java/lang/Exception
    //   100	112	254	java/lang/Exception
  }
  
  public static Bitmap loadAssetsFile(String paramString, Context paramContext)
  {
    try
    {
      Object localObject = paramContext.getAssets().open(paramString);
      if (localObject != null)
      {
        localObject = BitmapFactory.decodeStream((InputStream)localObject);
        return (Bitmap)localObject;
      }
    }
    catch (Exception localException)
    {
      return BitmapFactory.decodeFile(a("assets/" + paramString, paramString, paramContext));
    }
    return null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/platform/comapi/AssetsLoadUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */