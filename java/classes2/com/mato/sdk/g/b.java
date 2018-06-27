package com.mato.sdk.g;

import com.mato.sdk.b.g;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class b
{
  private static final String a = g.b("");
  
  public static InputStream a(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = new ByteArrayInputStream(a(new ByteArrayInputStream(paramArrayOfByte)));
      return paramArrayOfByte;
    }
    catch (IOException paramArrayOfByte) {}
    return null;
  }
  
  /* Error */
  private static void a(File paramFile1, File paramFile2)
    throws IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_1
    //   3: invokevirtual 40	java/io/File:exists	()Z
    //   6: ifne +8 -> 14
    //   9: aload_1
    //   10: invokevirtual 43	java/io/File:createNewFile	()Z
    //   13: pop
    //   14: new 45	java/io/FileInputStream
    //   17: dup
    //   18: aload_0
    //   19: invokespecial 48	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   22: invokevirtual 52	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   25: astore_2
    //   26: new 54	java/io/FileOutputStream
    //   29: dup
    //   30: aload_1
    //   31: invokespecial 55	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   34: invokevirtual 56	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   37: astore_1
    //   38: aload_1
    //   39: aload_2
    //   40: lconst_0
    //   41: aload_2
    //   42: invokevirtual 62	java/nio/channels/FileChannel:size	()J
    //   45: invokevirtual 66	java/nio/channels/FileChannel:transferFrom	(Ljava/nio/channels/ReadableByteChannel;JJ)J
    //   48: pop2
    //   49: aload_2
    //   50: ifnull +7 -> 57
    //   53: aload_2
    //   54: invokevirtual 69	java/nio/channels/FileChannel:close	()V
    //   57: aload_1
    //   58: ifnull +7 -> 65
    //   61: aload_1
    //   62: invokevirtual 69	java/nio/channels/FileChannel:close	()V
    //   65: return
    //   66: astore_0
    //   67: aconst_null
    //   68: astore_1
    //   69: aload_3
    //   70: astore_2
    //   71: aload_2
    //   72: ifnull +7 -> 79
    //   75: aload_2
    //   76: invokevirtual 69	java/nio/channels/FileChannel:close	()V
    //   79: aload_1
    //   80: ifnull +7 -> 87
    //   83: aload_1
    //   84: invokevirtual 69	java/nio/channels/FileChannel:close	()V
    //   87: aload_0
    //   88: athrow
    //   89: astore_0
    //   90: aconst_null
    //   91: astore_1
    //   92: goto -21 -> 71
    //   95: astore_0
    //   96: goto -25 -> 71
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	99	0	paramFile1	File
    //   0	99	1	paramFile2	File
    //   25	51	2	localObject1	Object
    //   1	69	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   14	26	66	finally
    //   26	38	89	finally
    //   38	49	95	finally
  }
  
  /* Error */
  private static void a(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    // Byte code:
    //   0: new 73	java/util/zip/GZIPOutputStream
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 76	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   8: astore_3
    //   9: aload_3
    //   10: astore_1
    //   11: sipush 1024
    //   14: newarray <illegal type>
    //   16: astore 4
    //   18: aload_3
    //   19: astore_1
    //   20: aload_0
    //   21: aload 4
    //   23: invokevirtual 82	java/io/InputStream:read	([B)I
    //   26: istore_2
    //   27: iload_2
    //   28: iconst_m1
    //   29: if_icmpeq +46 -> 75
    //   32: aload_3
    //   33: astore_1
    //   34: aload_3
    //   35: aload 4
    //   37: iconst_0
    //   38: iload_2
    //   39: invokevirtual 86	java/util/zip/GZIPOutputStream:write	([BII)V
    //   42: goto -24 -> 18
    //   45: astore 4
    //   47: aload_3
    //   48: astore_1
    //   49: aload 4
    //   51: astore_3
    //   52: aload_3
    //   53: athrow
    //   54: astore 4
    //   56: aload_1
    //   57: astore_3
    //   58: aload 4
    //   60: astore_1
    //   61: aload_0
    //   62: invokevirtual 87	java/io/InputStream:close	()V
    //   65: aload_3
    //   66: ifnull +7 -> 73
    //   69: aload_3
    //   70: invokevirtual 88	java/util/zip/GZIPOutputStream:close	()V
    //   73: aload_1
    //   74: athrow
    //   75: aload_3
    //   76: astore_1
    //   77: aload_3
    //   78: invokevirtual 91	java/util/zip/GZIPOutputStream:flush	()V
    //   81: aload_0
    //   82: invokevirtual 87	java/io/InputStream:close	()V
    //   85: aload_3
    //   86: invokevirtual 88	java/util/zip/GZIPOutputStream:close	()V
    //   89: return
    //   90: astore_0
    //   91: goto -6 -> 85
    //   94: astore_0
    //   95: return
    //   96: astore_0
    //   97: goto -32 -> 65
    //   100: astore_0
    //   101: goto -28 -> 73
    //   104: astore_1
    //   105: aconst_null
    //   106: astore_3
    //   107: goto -46 -> 61
    //   110: astore_3
    //   111: aconst_null
    //   112: astore_1
    //   113: goto -61 -> 52
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	116	0	paramInputStream	InputStream
    //   0	116	1	paramOutputStream	OutputStream
    //   26	13	2	i	int
    //   8	99	3	localObject1	Object
    //   110	1	3	localIOException1	IOException
    //   16	20	4	arrayOfByte	byte[]
    //   45	5	4	localIOException2	IOException
    //   54	5	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   11	18	45	java/io/IOException
    //   20	27	45	java/io/IOException
    //   34	42	45	java/io/IOException
    //   77	81	45	java/io/IOException
    //   11	18	54	finally
    //   20	27	54	finally
    //   34	42	54	finally
    //   52	54	54	finally
    //   77	81	54	finally
    //   81	85	90	java/io/IOException
    //   85	89	94	java/io/IOException
    //   61	65	96	java/io/IOException
    //   69	73	100	java/io/IOException
    //   0	9	104	finally
    //   0	9	110	java/io/IOException
  }
  
  private static void a(byte[] paramArrayOfByte, OutputStream paramOutputStream)
    throws IOException
  {
    a(new ByteArrayInputStream(paramArrayOfByte), paramOutputStream);
  }
  
  /* Error */
  public static boolean a(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: new 101	java/io/RandomAccessFile
    //   7: dup
    //   8: aload_0
    //   9: ldc 103
    //   11: invokespecial 106	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   14: astore_1
    //   15: aload_1
    //   16: lconst_0
    //   17: invokevirtual 110	java/io/RandomAccessFile:setLength	(J)V
    //   20: aload_1
    //   21: invokevirtual 111	java/io/RandomAccessFile:close	()V
    //   24: iconst_1
    //   25: ireturn
    //   26: astore_1
    //   27: aconst_null
    //   28: astore_1
    //   29: aload_0
    //   30: invokevirtual 115	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   33: pop
    //   34: aload_1
    //   35: ifnull -11 -> 24
    //   38: aload_1
    //   39: invokevirtual 111	java/io/RandomAccessFile:close	()V
    //   42: iconst_1
    //   43: ireturn
    //   44: astore_0
    //   45: iconst_1
    //   46: ireturn
    //   47: astore_0
    //   48: aload_2
    //   49: astore_0
    //   50: aload_0
    //   51: ifnull +7 -> 58
    //   54: aload_0
    //   55: invokevirtual 111	java/io/RandomAccessFile:close	()V
    //   58: iconst_0
    //   59: ireturn
    //   60: astore_0
    //   61: aload_3
    //   62: astore_1
    //   63: aload_1
    //   64: ifnull +7 -> 71
    //   67: aload_1
    //   68: invokevirtual 111	java/io/RandomAccessFile:close	()V
    //   71: aload_0
    //   72: athrow
    //   73: astore_0
    //   74: iconst_1
    //   75: ireturn
    //   76: astore_0
    //   77: goto -19 -> 58
    //   80: astore_1
    //   81: goto -10 -> 71
    //   84: astore_0
    //   85: goto -22 -> 63
    //   88: astore_0
    //   89: goto -26 -> 63
    //   92: astore_0
    //   93: aload_1
    //   94: astore_0
    //   95: goto -45 -> 50
    //   98: astore_2
    //   99: goto -70 -> 29
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	paramFile	File
    //   14	7	1	localRandomAccessFile	java.io.RandomAccessFile
    //   26	1	1	localFileNotFoundException1	java.io.FileNotFoundException
    //   28	40	1	localObject1	Object
    //   80	14	1	localIOException	IOException
    //   3	46	2	localObject2	Object
    //   98	1	2	localFileNotFoundException2	java.io.FileNotFoundException
    //   1	61	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   4	15	26	java/io/FileNotFoundException
    //   38	42	44	java/io/IOException
    //   4	15	47	java/lang/Exception
    //   4	15	60	finally
    //   20	24	73	java/io/IOException
    //   54	58	76	java/io/IOException
    //   67	71	80	java/io/IOException
    //   15	20	84	finally
    //   29	34	88	finally
    //   15	20	92	java/lang/Exception
    //   15	20	98	java/io/FileNotFoundException
  }
  
  public static boolean a(String paramString)
  {
    if ((paramString == null) || (paramString.length() > 255) || (paramString.length() == 0)) {
      return false;
    }
    return paramString.matches("^[^\\/:*?\"<>|\\s\\.][^\\/:*?\"<>|\\s]*[^\\/:*?\"<>|\\s\\.]$");
  }
  
  private static byte[] a(InputStream paramInputStream)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    a(paramInputStream, localByteArrayOutputStream);
    if (localByteArrayOutputStream.size() == 0) {
      return null;
    }
    return localByteArrayOutputStream.toByteArray();
  }
  
  /* Error */
  private static byte[] a(java.util.List<String> paramList)
  {
    // Byte code:
    //   0: new 129	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 130	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore 7
    //   9: new 139	java/util/zip/ZipOutputStream
    //   12: dup
    //   13: aload 7
    //   15: invokespecial 140	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   18: astore 4
    //   20: ldc -115
    //   22: newarray <illegal type>
    //   24: astore 8
    //   26: aload_0
    //   27: invokeinterface 144 1 0
    //   32: istore_2
    //   33: iconst_0
    //   34: istore_1
    //   35: aconst_null
    //   36: astore 5
    //   38: iload_1
    //   39: iload_2
    //   40: if_icmpge +124 -> 164
    //   43: new 146	java/io/BufferedInputStream
    //   46: dup
    //   47: new 45	java/io/FileInputStream
    //   50: dup
    //   51: aload_0
    //   52: iload_1
    //   53: invokeinterface 150 2 0
    //   58: checkcast 118	java/lang/String
    //   61: invokespecial 153	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   64: ldc -115
    //   66: invokespecial 156	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   69: astore 6
    //   71: aload 4
    //   73: new 158	java/util/zip/ZipEntry
    //   76: dup
    //   77: ldc 10
    //   79: invokespecial 159	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   82: invokevirtual 163	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   85: aload 6
    //   87: aload 8
    //   89: invokevirtual 164	java/io/BufferedInputStream:read	([B)I
    //   92: istore_3
    //   93: iload_3
    //   94: iconst_m1
    //   95: if_icmpeq +43 -> 138
    //   98: aload 4
    //   100: aload 8
    //   102: iconst_0
    //   103: iload_3
    //   104: invokevirtual 165	java/util/zip/ZipOutputStream:write	([BII)V
    //   107: goto -22 -> 85
    //   110: astore_0
    //   111: aload 6
    //   113: astore_0
    //   114: aload 4
    //   116: ifnull +8 -> 124
    //   119: aload 4
    //   121: invokevirtual 166	java/util/zip/ZipOutputStream:close	()V
    //   124: aload_0
    //   125: ifnull +7 -> 132
    //   128: aload_0
    //   129: invokevirtual 167	java/io/BufferedInputStream:close	()V
    //   132: aconst_null
    //   133: astore 4
    //   135: aload 4
    //   137: areturn
    //   138: aload 6
    //   140: invokevirtual 167	java/io/BufferedInputStream:close	()V
    //   143: aload 4
    //   145: invokevirtual 168	java/util/zip/ZipOutputStream:flush	()V
    //   148: aload 4
    //   150: invokevirtual 171	java/util/zip/ZipOutputStream:closeEntry	()V
    //   153: iload_1
    //   154: iconst_1
    //   155: iadd
    //   156: istore_1
    //   157: aload 6
    //   159: astore 5
    //   161: goto -123 -> 38
    //   164: aload 7
    //   166: invokevirtual 136	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   169: astore_0
    //   170: aload 4
    //   172: invokevirtual 166	java/util/zip/ZipOutputStream:close	()V
    //   175: aload_0
    //   176: astore 4
    //   178: aload 5
    //   180: ifnull -45 -> 135
    //   183: aload 5
    //   185: invokevirtual 167	java/io/BufferedInputStream:close	()V
    //   188: aload_0
    //   189: areturn
    //   190: astore 4
    //   192: aload_0
    //   193: areturn
    //   194: astore_0
    //   195: aconst_null
    //   196: astore 6
    //   198: aconst_null
    //   199: astore 4
    //   201: aload 4
    //   203: ifnull +8 -> 211
    //   206: aload 4
    //   208: invokevirtual 166	java/util/zip/ZipOutputStream:close	()V
    //   211: aload 6
    //   213: ifnull -81 -> 132
    //   216: aload 6
    //   218: invokevirtual 167	java/io/BufferedInputStream:close	()V
    //   221: goto -89 -> 132
    //   224: astore_0
    //   225: goto -93 -> 132
    //   228: astore_0
    //   229: aconst_null
    //   230: astore 6
    //   232: aconst_null
    //   233: astore 4
    //   235: aload 4
    //   237: ifnull +8 -> 245
    //   240: aload 4
    //   242: invokevirtual 166	java/util/zip/ZipOutputStream:close	()V
    //   245: aload 6
    //   247: ifnull +8 -> 255
    //   250: aload 6
    //   252: invokevirtual 167	java/io/BufferedInputStream:close	()V
    //   255: aload_0
    //   256: athrow
    //   257: astore 4
    //   259: goto -84 -> 175
    //   262: astore 4
    //   264: goto -140 -> 124
    //   267: astore_0
    //   268: goto -136 -> 132
    //   271: astore_0
    //   272: goto -61 -> 211
    //   275: astore 4
    //   277: goto -32 -> 245
    //   280: astore 4
    //   282: goto -27 -> 255
    //   285: astore_0
    //   286: aconst_null
    //   287: astore 6
    //   289: goto -54 -> 235
    //   292: astore_0
    //   293: goto -58 -> 235
    //   296: astore_0
    //   297: aload 5
    //   299: astore 6
    //   301: goto -66 -> 235
    //   304: astore_0
    //   305: aconst_null
    //   306: astore 6
    //   308: goto -107 -> 201
    //   311: astore_0
    //   312: goto -111 -> 201
    //   315: astore_0
    //   316: aload 5
    //   318: astore 6
    //   320: goto -119 -> 201
    //   323: astore_0
    //   324: aconst_null
    //   325: astore_0
    //   326: aconst_null
    //   327: astore 4
    //   329: goto -215 -> 114
    //   332: astore_0
    //   333: aconst_null
    //   334: astore_0
    //   335: goto -221 -> 114
    //   338: astore_0
    //   339: aload 5
    //   341: astore_0
    //   342: goto -228 -> 114
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	345	0	paramList	java.util.List<String>
    //   34	123	1	i	int
    //   32	9	2	j	int
    //   92	12	3	k	int
    //   18	159	4	localObject1	Object
    //   190	1	4	localIOException1	IOException
    //   199	42	4	localObject2	Object
    //   257	1	4	localIOException2	IOException
    //   262	1	4	localIOException3	IOException
    //   275	1	4	localIOException4	IOException
    //   280	1	4	localIOException5	IOException
    //   327	1	4	localObject3	Object
    //   36	304	5	localObject4	Object
    //   69	250	6	localObject5	Object
    //   7	158	7	localByteArrayOutputStream	ByteArrayOutputStream
    //   24	77	8	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   71	85	110	java/io/FileNotFoundException
    //   85	93	110	java/io/FileNotFoundException
    //   98	107	110	java/io/FileNotFoundException
    //   138	153	110	java/io/FileNotFoundException
    //   183	188	190	java/io/IOException
    //   9	20	194	java/io/IOException
    //   216	221	224	java/io/IOException
    //   9	20	228	finally
    //   170	175	257	java/io/IOException
    //   119	124	262	java/io/IOException
    //   128	132	267	java/io/IOException
    //   206	211	271	java/io/IOException
    //   240	245	275	java/io/IOException
    //   250	255	280	java/io/IOException
    //   20	33	285	finally
    //   71	85	292	finally
    //   85	93	292	finally
    //   98	107	292	finally
    //   138	153	292	finally
    //   43	71	296	finally
    //   164	170	296	finally
    //   20	33	304	java/io/IOException
    //   71	85	311	java/io/IOException
    //   85	93	311	java/io/IOException
    //   98	107	311	java/io/IOException
    //   138	153	311	java/io/IOException
    //   43	71	315	java/io/IOException
    //   164	170	315	java/io/IOException
    //   9	20	323	java/io/FileNotFoundException
    //   20	33	332	java/io/FileNotFoundException
    //   43	71	338	java/io/FileNotFoundException
    //   164	170	338	java/io/FileNotFoundException
  }
  
  public static byte[] b(File paramFile)
    throws IllegalArgumentException, IOException
  {
    if (paramFile == null) {
      throw new IllegalArgumentException("file is null");
    }
    paramFile = new FileInputStream(paramFile);
    if (paramFile.available() == 0)
    {
      paramFile.close();
      return null;
    }
    return a(paramFile);
  }
  
  private static byte[] b(byte[] paramArrayOfByte)
    throws IOException
  {
    return a(new ByteArrayInputStream(paramArrayOfByte));
  }
  
  public static InputStream c(File paramFile)
  {
    try
    {
      paramFile = b(paramFile);
      if (paramFile != null)
      {
        paramFile = new ByteArrayInputStream(paramFile);
        return paramFile;
      }
    }
    catch (IOException paramFile) {}
    return null;
  }
  
  /* Error */
  public static byte[] d(File paramFile)
  {
    // Byte code:
    //   0: new 45	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 48	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   8: astore_0
    //   9: new 129	java/io/ByteArrayOutputStream
    //   12: dup
    //   13: sipush 1000
    //   16: invokespecial 192	java/io/ByteArrayOutputStream:<init>	(I)V
    //   19: astore_2
    //   20: sipush 1000
    //   23: newarray <illegal type>
    //   25: astore_3
    //   26: aload_0
    //   27: aload_3
    //   28: invokevirtual 193	java/io/FileInputStream:read	([B)I
    //   31: istore_1
    //   32: iload_1
    //   33: iconst_m1
    //   34: if_icmpeq +32 -> 66
    //   37: aload_2
    //   38: aload_3
    //   39: iconst_0
    //   40: iload_1
    //   41: invokevirtual 194	java/io/ByteArrayOutputStream:write	([BII)V
    //   44: goto -18 -> 26
    //   47: astore_3
    //   48: aload_0
    //   49: ifnull +7 -> 56
    //   52: aload_0
    //   53: invokevirtual 183	java/io/FileInputStream:close	()V
    //   56: aload_2
    //   57: ifnull +7 -> 64
    //   60: aload_2
    //   61: invokevirtual 195	java/io/ByteArrayOutputStream:close	()V
    //   64: aconst_null
    //   65: areturn
    //   66: aload_2
    //   67: invokevirtual 136	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   70: astore_3
    //   71: aload_0
    //   72: invokevirtual 183	java/io/FileInputStream:close	()V
    //   75: aload_2
    //   76: invokevirtual 195	java/io/ByteArrayOutputStream:close	()V
    //   79: aload_3
    //   80: areturn
    //   81: astore_0
    //   82: aload_3
    //   83: areturn
    //   84: astore_0
    //   85: aconst_null
    //   86: astore_2
    //   87: aconst_null
    //   88: astore_0
    //   89: aload_0
    //   90: ifnull +7 -> 97
    //   93: aload_0
    //   94: invokevirtual 183	java/io/FileInputStream:close	()V
    //   97: aload_2
    //   98: ifnull -34 -> 64
    //   101: aload_2
    //   102: invokevirtual 195	java/io/ByteArrayOutputStream:close	()V
    //   105: aconst_null
    //   106: areturn
    //   107: astore_0
    //   108: aconst_null
    //   109: areturn
    //   110: astore_3
    //   111: aconst_null
    //   112: astore_0
    //   113: aconst_null
    //   114: astore_2
    //   115: aload_0
    //   116: ifnull +7 -> 123
    //   119: aload_0
    //   120: invokevirtual 183	java/io/FileInputStream:close	()V
    //   123: aload_2
    //   124: ifnull +7 -> 131
    //   127: aload_2
    //   128: invokevirtual 195	java/io/ByteArrayOutputStream:close	()V
    //   131: aload_3
    //   132: athrow
    //   133: astore_0
    //   134: goto -59 -> 75
    //   137: astore_0
    //   138: goto -82 -> 56
    //   141: astore_0
    //   142: aconst_null
    //   143: areturn
    //   144: astore_0
    //   145: goto -48 -> 97
    //   148: astore_0
    //   149: goto -26 -> 123
    //   152: astore_0
    //   153: goto -22 -> 131
    //   156: astore_3
    //   157: aconst_null
    //   158: astore_2
    //   159: goto -44 -> 115
    //   162: astore_3
    //   163: goto -48 -> 115
    //   166: astore_2
    //   167: aconst_null
    //   168: astore_2
    //   169: goto -80 -> 89
    //   172: astore_3
    //   173: goto -84 -> 89
    //   176: astore_0
    //   177: aconst_null
    //   178: astore_2
    //   179: aconst_null
    //   180: astore_0
    //   181: goto -133 -> 48
    //   184: astore_2
    //   185: aconst_null
    //   186: astore_2
    //   187: goto -139 -> 48
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	190	0	paramFile	File
    //   31	10	1	i	int
    //   19	140	2	localByteArrayOutputStream	ByteArrayOutputStream
    //   166	1	2	localIOException1	IOException
    //   168	11	2	localObject1	Object
    //   184	1	2	localFileNotFoundException1	java.io.FileNotFoundException
    //   186	1	2	localObject2	Object
    //   25	14	3	arrayOfByte1	byte[]
    //   47	1	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   70	13	3	arrayOfByte2	byte[]
    //   110	22	3	localObject3	Object
    //   156	1	3	localObject4	Object
    //   162	1	3	localObject5	Object
    //   172	1	3	localIOException2	IOException
    // Exception table:
    //   from	to	target	type
    //   20	26	47	java/io/FileNotFoundException
    //   26	32	47	java/io/FileNotFoundException
    //   37	44	47	java/io/FileNotFoundException
    //   66	71	47	java/io/FileNotFoundException
    //   75	79	81	java/io/IOException
    //   0	9	84	java/io/IOException
    //   101	105	107	java/io/IOException
    //   0	9	110	finally
    //   71	75	133	java/io/IOException
    //   52	56	137	java/io/IOException
    //   60	64	141	java/io/IOException
    //   93	97	144	java/io/IOException
    //   119	123	148	java/io/IOException
    //   127	131	152	java/io/IOException
    //   9	20	156	finally
    //   20	26	162	finally
    //   26	32	162	finally
    //   37	44	162	finally
    //   66	71	162	finally
    //   9	20	166	java/io/IOException
    //   20	26	172	java/io/IOException
    //   26	32	172	java/io/IOException
    //   37	44	172	java/io/IOException
    //   66	71	172	java/io/IOException
    //   0	9	176	java/io/FileNotFoundException
    //   9	20	184	java/io/FileNotFoundException
  }
  
  public static void e(File paramFile)
    throws IOException
  {
    if (!paramFile.exists()) {}
    do
    {
      return;
      File[] arrayOfFile = paramFile.listFiles();
      if (arrayOfFile != null)
      {
        int j = arrayOfFile.length;
        int i = 0;
        while (i < j)
        {
          e(arrayOfFile[i]);
          i += 1;
        }
      }
    } while (paramFile.delete());
    throw new IOException(String.format("Could not delete folder %s", new Object[] { paramFile }));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/g/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */