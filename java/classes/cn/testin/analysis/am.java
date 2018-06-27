package cn.testin.analysis;

import android.content.Context;
import android.os.Environment;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;

public class am
{
  public static String a(Context paramContext)
  {
    Object localObject3 = null;
    Object localObject2;
    if ((a()) && (al.b(paramContext, "android.permission.WRITE_EXTERNAL_STORAGE")))
    {
      localObject2 = paramContext.getExternalFilesDir(null);
      localObject1 = localObject2;
      if (localObject2 == null) {
        ar.f("External dir is null");
      }
    }
    for (Object localObject1 = localObject2;; localObject1 = null)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = paramContext.getFilesDir();
      }
      paramContext = (Context)localObject3;
      if (localObject2 != null) {
        paramContext = ((File)localObject2).getAbsolutePath() + "/" + "testin_ab";
      }
      return paramContext;
    }
  }
  
  /* Error */
  public static String a(String paramString)
  {
    // Byte code:
    //   0: new 43	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 64	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: aload_0
    //   10: invokevirtual 67	java/io/File:exists	()Z
    //   13: istore_1
    //   14: iload_1
    //   15: ifne +24 -> 39
    //   18: iconst_0
    //   19: ifeq +11 -> 30
    //   22: new 69	java/lang/NullPointerException
    //   25: dup
    //   26: invokespecial 70	java/lang/NullPointerException:<init>	()V
    //   29: athrow
    //   30: aconst_null
    //   31: areturn
    //   32: astore_0
    //   33: aload_0
    //   34: invokevirtual 73	java/io/IOException:printStackTrace	()V
    //   37: aconst_null
    //   38: areturn
    //   39: new 75	java/io/BufferedReader
    //   42: dup
    //   43: new 77	java/io/FileReader
    //   46: dup
    //   47: aload_0
    //   48: invokespecial 80	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   51: invokespecial 83	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   54: astore_2
    //   55: aload_2
    //   56: astore_0
    //   57: new 37	java/lang/StringBuilder
    //   60: dup
    //   61: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   64: astore 4
    //   66: aload_2
    //   67: astore_0
    //   68: aload_2
    //   69: invokevirtual 86	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   72: astore_3
    //   73: aload_3
    //   74: ifnull +39 -> 113
    //   77: aload_2
    //   78: astore_0
    //   79: aload 4
    //   81: aload_3
    //   82: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: pop
    //   86: goto -20 -> 66
    //   89: astore_3
    //   90: aload_2
    //   91: astore_0
    //   92: aload_3
    //   93: invokevirtual 73	java/io/IOException:printStackTrace	()V
    //   96: aload_2
    //   97: ifnull -67 -> 30
    //   100: aload_2
    //   101: invokevirtual 89	java/io/BufferedReader:close	()V
    //   104: aconst_null
    //   105: areturn
    //   106: astore_0
    //   107: aload_0
    //   108: invokevirtual 73	java/io/IOException:printStackTrace	()V
    //   111: aconst_null
    //   112: areturn
    //   113: aload_2
    //   114: astore_0
    //   115: new 91	java/lang/String
    //   118: dup
    //   119: aload 4
    //   121: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: iconst_2
    //   125: invokestatic 97	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   128: invokespecial 100	java/lang/String:<init>	([B)V
    //   131: astore_3
    //   132: aload_2
    //   133: ifnull +7 -> 140
    //   136: aload_2
    //   137: invokevirtual 89	java/io/BufferedReader:close	()V
    //   140: aload_3
    //   141: areturn
    //   142: astore_0
    //   143: aload_0
    //   144: invokevirtual 73	java/io/IOException:printStackTrace	()V
    //   147: goto -7 -> 140
    //   150: astore_2
    //   151: aconst_null
    //   152: astore_0
    //   153: aload_0
    //   154: ifnull +7 -> 161
    //   157: aload_0
    //   158: invokevirtual 89	java/io/BufferedReader:close	()V
    //   161: aload_2
    //   162: athrow
    //   163: astore_0
    //   164: aload_0
    //   165: invokevirtual 73	java/io/IOException:printStackTrace	()V
    //   168: goto -7 -> 161
    //   171: astore_2
    //   172: goto -19 -> 153
    //   175: astore_3
    //   176: aconst_null
    //   177: astore_2
    //   178: goto -88 -> 90
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	181	0	paramString	String
    //   13	2	1	bool	boolean
    //   54	83	2	localBufferedReader	java.io.BufferedReader
    //   150	12	2	localObject1	Object
    //   171	1	2	localObject2	Object
    //   177	1	2	localObject3	Object
    //   72	10	3	str1	String
    //   89	4	3	localIOException1	java.io.IOException
    //   131	10	3	str2	String
    //   175	1	3	localIOException2	java.io.IOException
    //   64	56	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   22	30	32	java/io/IOException
    //   57	66	89	java/io/IOException
    //   68	73	89	java/io/IOException
    //   79	86	89	java/io/IOException
    //   115	132	89	java/io/IOException
    //   100	104	106	java/io/IOException
    //   136	140	142	java/io/IOException
    //   0	14	150	finally
    //   39	55	150	finally
    //   157	161	163	java/io/IOException
    //   57	66	171	finally
    //   68	73	171	finally
    //   79	86	171	finally
    //   92	96	171	finally
    //   115	132	171	finally
    //   0	14	175	java/io/IOException
    //   39	55	175	java/io/IOException
  }
  
  /* Error */
  public static void a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: aload 5
    //   8: astore_3
    //   9: aload_1
    //   10: invokevirtual 105	java/lang/String:getBytes	()[B
    //   13: iconst_2
    //   14: invokestatic 109	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   17: astore 6
    //   19: aload 5
    //   21: astore_3
    //   22: new 43	java/io/File
    //   25: dup
    //   26: aload_0
    //   27: invokespecial 64	java/io/File:<init>	(Ljava/lang/String;)V
    //   30: astore_1
    //   31: aload 5
    //   33: astore_3
    //   34: aload_1
    //   35: invokevirtual 112	java/io/File:getParentFile	()Ljava/io/File;
    //   38: invokevirtual 67	java/io/File:exists	()Z
    //   41: ifne +14 -> 55
    //   44: aload 5
    //   46: astore_3
    //   47: aload_1
    //   48: invokevirtual 112	java/io/File:getParentFile	()Ljava/io/File;
    //   51: invokevirtual 115	java/io/File:mkdirs	()Z
    //   54: pop
    //   55: aload 5
    //   57: astore_3
    //   58: aload_1
    //   59: invokevirtual 112	java/io/File:getParentFile	()Ljava/io/File;
    //   62: invokevirtual 67	java/io/File:exists	()Z
    //   65: istore_2
    //   66: iload_2
    //   67: ifne +22 -> 89
    //   70: iconst_0
    //   71: ifeq +11 -> 82
    //   74: new 69	java/lang/NullPointerException
    //   77: dup
    //   78: invokespecial 70	java/lang/NullPointerException:<init>	()V
    //   81: athrow
    //   82: return
    //   83: astore_0
    //   84: aload_0
    //   85: invokevirtual 73	java/io/IOException:printStackTrace	()V
    //   88: return
    //   89: aload 5
    //   91: astore_3
    //   92: new 117	java/io/BufferedWriter
    //   95: dup
    //   96: new 119	java/io/FileWriter
    //   99: dup
    //   100: aload_1
    //   101: invokespecial 120	java/io/FileWriter:<init>	(Ljava/io/File;)V
    //   104: invokespecial 123	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   107: astore_1
    //   108: aload_1
    //   109: aload 6
    //   111: invokevirtual 126	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   114: new 37	java/lang/StringBuilder
    //   117: dup
    //   118: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   121: ldc -128
    //   123: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: aload_0
    //   127: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: invokestatic 31	cn/testin/analysis/ar:f	(Ljava/lang/String;)V
    //   136: aload_1
    //   137: ifnull -55 -> 82
    //   140: aload_1
    //   141: invokevirtual 131	java/io/BufferedWriter:flush	()V
    //   144: aload_1
    //   145: invokevirtual 132	java/io/BufferedWriter:close	()V
    //   148: return
    //   149: astore_0
    //   150: aload_0
    //   151: invokevirtual 73	java/io/IOException:printStackTrace	()V
    //   154: return
    //   155: astore_1
    //   156: aload 4
    //   158: astore_0
    //   159: aload_0
    //   160: astore_3
    //   161: aload_1
    //   162: invokestatic 135	cn/testin/analysis/ar:a	(Ljava/lang/Throwable;)V
    //   165: aload_0
    //   166: ifnull -84 -> 82
    //   169: aload_0
    //   170: invokevirtual 131	java/io/BufferedWriter:flush	()V
    //   173: aload_0
    //   174: invokevirtual 132	java/io/BufferedWriter:close	()V
    //   177: return
    //   178: astore_0
    //   179: aload_0
    //   180: invokevirtual 73	java/io/IOException:printStackTrace	()V
    //   183: return
    //   184: astore_0
    //   185: aload_3
    //   186: ifnull +11 -> 197
    //   189: aload_3
    //   190: invokevirtual 131	java/io/BufferedWriter:flush	()V
    //   193: aload_3
    //   194: invokevirtual 132	java/io/BufferedWriter:close	()V
    //   197: aload_0
    //   198: athrow
    //   199: astore_1
    //   200: aload_1
    //   201: invokevirtual 73	java/io/IOException:printStackTrace	()V
    //   204: goto -7 -> 197
    //   207: astore_0
    //   208: aload_1
    //   209: astore_3
    //   210: goto -25 -> 185
    //   213: astore_3
    //   214: aload_1
    //   215: astore_0
    //   216: aload_3
    //   217: astore_1
    //   218: goto -59 -> 159
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	221	0	paramString1	String
    //   0	221	1	paramString2	String
    //   65	2	2	bool	boolean
    //   8	202	3	localObject1	Object
    //   213	4	3	localIOException	java.io.IOException
    //   4	153	4	localObject2	Object
    //   1	89	5	localObject3	Object
    //   17	93	6	str	String
    // Exception table:
    //   from	to	target	type
    //   74	82	83	java/io/IOException
    //   140	148	149	java/io/IOException
    //   9	19	155	java/io/IOException
    //   22	31	155	java/io/IOException
    //   34	44	155	java/io/IOException
    //   47	55	155	java/io/IOException
    //   58	66	155	java/io/IOException
    //   92	108	155	java/io/IOException
    //   169	177	178	java/io/IOException
    //   9	19	184	finally
    //   22	31	184	finally
    //   34	44	184	finally
    //   47	55	184	finally
    //   58	66	184	finally
    //   92	108	184	finally
    //   161	165	184	finally
    //   189	197	199	java/io/IOException
    //   108	136	207	finally
    //   108	136	213	java/io/IOException
  }
  
  public static boolean a()
  {
    return Environment.getExternalStorageState().equals("mounted");
  }
  
  /* Error */
  public static byte[] a(InputStream paramInputStream)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: ifnonnull +7 -> 10
    //   6: aload_3
    //   7: astore_0
    //   8: aload_0
    //   9: areturn
    //   10: new 149	java/util/zip/GZIPInputStream
    //   13: dup
    //   14: aload_0
    //   15: invokespecial 152	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   18: astore_1
    //   19: aload_1
    //   20: astore_0
    //   21: aload_1
    //   22: invokestatic 154	cn/testin/analysis/am:b	(Ljava/io/InputStream;)[B
    //   25: astore_2
    //   26: aload_2
    //   27: astore_0
    //   28: aload_1
    //   29: ifnull -21 -> 8
    //   32: aload_1
    //   33: invokevirtual 155	java/util/zip/GZIPInputStream:close	()V
    //   36: aload_2
    //   37: areturn
    //   38: astore_0
    //   39: aload_0
    //   40: invokestatic 135	cn/testin/analysis/ar:a	(Ljava/lang/Throwable;)V
    //   43: aload_2
    //   44: areturn
    //   45: astore_2
    //   46: aconst_null
    //   47: astore_1
    //   48: aload_1
    //   49: astore_0
    //   50: aload_2
    //   51: invokestatic 135	cn/testin/analysis/ar:a	(Ljava/lang/Throwable;)V
    //   54: aload_3
    //   55: astore_0
    //   56: aload_1
    //   57: ifnull -49 -> 8
    //   60: aload_1
    //   61: invokevirtual 155	java/util/zip/GZIPInputStream:close	()V
    //   64: aconst_null
    //   65: areturn
    //   66: astore_0
    //   67: aload_0
    //   68: invokestatic 135	cn/testin/analysis/ar:a	(Ljava/lang/Throwable;)V
    //   71: aconst_null
    //   72: areturn
    //   73: astore_1
    //   74: aconst_null
    //   75: astore_0
    //   76: aload_0
    //   77: ifnull +7 -> 84
    //   80: aload_0
    //   81: invokevirtual 155	java/util/zip/GZIPInputStream:close	()V
    //   84: aload_1
    //   85: athrow
    //   86: astore_0
    //   87: aload_0
    //   88: invokestatic 135	cn/testin/analysis/ar:a	(Ljava/lang/Throwable;)V
    //   91: goto -7 -> 84
    //   94: astore_1
    //   95: goto -19 -> 76
    //   98: astore_2
    //   99: goto -51 -> 48
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	paramInputStream	InputStream
    //   18	43	1	localGZIPInputStream	java.util.zip.GZIPInputStream
    //   73	12	1	localObject1	Object
    //   94	1	1	localObject2	Object
    //   25	19	2	arrayOfByte	byte[]
    //   45	6	2	localIOException1	java.io.IOException
    //   98	1	2	localIOException2	java.io.IOException
    //   1	54	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   32	36	38	java/io/IOException
    //   10	19	45	java/io/IOException
    //   60	64	66	java/io/IOException
    //   10	19	73	finally
    //   80	84	86	java/io/IOException
    //   21	26	94	finally
    //   50	54	94	finally
    //   21	26	98	java/io/IOException
  }
  
  /* Error */
  public static byte[] a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: new 158	java/io/ByteArrayOutputStream
    //   9: dup
    //   10: aload_0
    //   11: arraylength
    //   12: invokespecial 161	java/io/ByteArrayOutputStream:<init>	(I)V
    //   15: astore 4
    //   17: new 163	java/util/zip/GZIPOutputStream
    //   20: dup
    //   21: aload 4
    //   23: invokespecial 166	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   26: astore_2
    //   27: aload_2
    //   28: astore_1
    //   29: aload_2
    //   30: aload_0
    //   31: iconst_0
    //   32: aload_0
    //   33: arraylength
    //   34: invokevirtual 169	java/util/zip/GZIPOutputStream:write	([BII)V
    //   37: aload_2
    //   38: astore_1
    //   39: aload_2
    //   40: invokevirtual 172	java/util/zip/GZIPOutputStream:finish	()V
    //   43: aload_2
    //   44: astore_1
    //   45: aload 4
    //   47: invokevirtual 173	java/io/ByteArrayOutputStream:flush	()V
    //   50: aload_2
    //   51: astore_1
    //   52: aload 4
    //   54: invokevirtual 176	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   57: astore_3
    //   58: aload_2
    //   59: ifnull +7 -> 66
    //   62: aload_2
    //   63: invokevirtual 177	java/util/zip/GZIPOutputStream:close	()V
    //   66: aload 4
    //   68: invokevirtual 178	java/io/ByteArrayOutputStream:close	()V
    //   71: aload_3
    //   72: areturn
    //   73: astore_0
    //   74: aload_0
    //   75: invokevirtual 73	java/io/IOException:printStackTrace	()V
    //   78: aload_3
    //   79: areturn
    //   80: astore_3
    //   81: aconst_null
    //   82: astore_2
    //   83: aload_2
    //   84: astore_1
    //   85: aload_3
    //   86: invokevirtual 73	java/io/IOException:printStackTrace	()V
    //   89: aload_2
    //   90: ifnull +7 -> 97
    //   93: aload_2
    //   94: invokevirtual 177	java/util/zip/GZIPOutputStream:close	()V
    //   97: aload 4
    //   99: invokevirtual 178	java/io/ByteArrayOutputStream:close	()V
    //   102: aload_0
    //   103: areturn
    //   104: astore_1
    //   105: aload_1
    //   106: invokevirtual 73	java/io/IOException:printStackTrace	()V
    //   109: aload_0
    //   110: areturn
    //   111: astore_0
    //   112: aconst_null
    //   113: astore_1
    //   114: aload_1
    //   115: ifnull +7 -> 122
    //   118: aload_1
    //   119: invokevirtual 177	java/util/zip/GZIPOutputStream:close	()V
    //   122: aload 4
    //   124: invokevirtual 178	java/io/ByteArrayOutputStream:close	()V
    //   127: aload_0
    //   128: athrow
    //   129: astore_1
    //   130: aload_1
    //   131: invokevirtual 73	java/io/IOException:printStackTrace	()V
    //   134: goto -7 -> 127
    //   137: astore_0
    //   138: goto -24 -> 114
    //   141: astore_3
    //   142: goto -59 -> 83
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	145	0	paramArrayOfByte	byte[]
    //   28	57	1	localGZIPOutputStream1	java.util.zip.GZIPOutputStream
    //   104	2	1	localIOException1	java.io.IOException
    //   113	6	1	localObject	Object
    //   129	2	1	localIOException2	java.io.IOException
    //   26	68	2	localGZIPOutputStream2	java.util.zip.GZIPOutputStream
    //   57	22	3	arrayOfByte	byte[]
    //   80	6	3	localIOException3	java.io.IOException
    //   141	1	3	localIOException4	java.io.IOException
    //   15	108	4	localByteArrayOutputStream	ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   62	66	73	java/io/IOException
    //   66	71	73	java/io/IOException
    //   17	27	80	java/io/IOException
    //   93	97	104	java/io/IOException
    //   97	102	104	java/io/IOException
    //   17	27	111	finally
    //   118	122	129	java/io/IOException
    //   122	127	129	java/io/IOException
    //   29	37	137	finally
    //   39	43	137	finally
    //   45	50	137	finally
    //   52	58	137	finally
    //   85	89	137	finally
    //   29	37	141	java/io/IOException
    //   39	43	141	java/io/IOException
    //   45	50	141	java/io/IOException
    //   52	58	141	java/io/IOException
  }
  
  public static byte[] b(InputStream paramInputStream)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte[' '];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte, 0, arrayOfByte.length);
      if (i == -1) {
        break;
      }
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
    localByteArrayOutputStream.flush();
    return localByteArrayOutputStream.toByteArray();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */