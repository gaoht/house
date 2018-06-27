package c.a.b.b;

import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;

public class a
{
  private static final byte[] b;
  private static final byte[] c;
  private static final byte[] d;
  private static final byte[] e;
  private static final byte[] f;
  private static final byte[] g;
  
  static
  {
    if (!a.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      b = new byte[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
      c = new byte[] { -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9 };
      d = new byte[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95 };
      e = new byte[] { -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9 };
      f = new byte[] { 45, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 95, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122 };
      g = new byte[] { -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -9, -9, -9, -1, -9, -9, -9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, -9, -9, -9, -9, 37, -9, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9 };
      return;
    }
  }
  
  /* Error */
  public static Object a(String paramString, int paramInt, final ClassLoader paramClassLoader)
    throws IOException, ClassNotFoundException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: aconst_null
    //   4: astore_3
    //   5: aconst_null
    //   6: astore 6
    //   8: aconst_null
    //   9: astore 8
    //   11: aconst_null
    //   12: astore 7
    //   14: aconst_null
    //   15: astore 5
    //   17: aload_0
    //   18: iload_1
    //   19: invokestatic 178	c/a/b/b/a:a	(Ljava/lang/String;I)[B
    //   22: astore_0
    //   23: new 180	java/io/ByteArrayInputStream
    //   26: dup
    //   27: aload_0
    //   28: invokespecial 183	java/io/ByteArrayInputStream:<init>	([B)V
    //   31: astore 4
    //   33: aload_2
    //   34: ifnonnull +56 -> 90
    //   37: aload 9
    //   39: astore_0
    //   40: aload 4
    //   42: astore_3
    //   43: aload 8
    //   45: astore 5
    //   47: aload 7
    //   49: astore 6
    //   51: new 185	java/io/ObjectInputStream
    //   54: dup
    //   55: aload 4
    //   57: invokespecial 188	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   60: astore_2
    //   61: aload_2
    //   62: astore_0
    //   63: aload 4
    //   65: astore_3
    //   66: aload_2
    //   67: astore 5
    //   69: aload_2
    //   70: astore 6
    //   72: aload_2
    //   73: invokevirtual 192	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   76: astore 7
    //   78: aload 4
    //   80: invokevirtual 195	java/io/ByteArrayInputStream:close	()V
    //   83: aload_2
    //   84: invokevirtual 196	java/io/ObjectInputStream:close	()V
    //   87: aload 7
    //   89: areturn
    //   90: aload 9
    //   92: astore_0
    //   93: aload 4
    //   95: astore_3
    //   96: aload 8
    //   98: astore 5
    //   100: aload 7
    //   102: astore 6
    //   104: new 6	c/a/b/b/a$1
    //   107: dup
    //   108: aload 4
    //   110: aload_2
    //   111: invokespecial 199	c/a/b/b/a$1:<init>	(Ljava/io/InputStream;Ljava/lang/ClassLoader;)V
    //   114: astore_2
    //   115: goto -54 -> 61
    //   118: astore_2
    //   119: aconst_null
    //   120: astore_3
    //   121: aload 5
    //   123: astore_0
    //   124: aload_2
    //   125: athrow
    //   126: astore 4
    //   128: aload_0
    //   129: astore_2
    //   130: aload 4
    //   132: astore_0
    //   133: aload_3
    //   134: invokevirtual 195	java/io/ByteArrayInputStream:close	()V
    //   137: aload_2
    //   138: invokevirtual 196	java/io/ObjectInputStream:close	()V
    //   141: aload_0
    //   142: athrow
    //   143: astore_2
    //   144: aconst_null
    //   145: astore_3
    //   146: aload 6
    //   148: astore_0
    //   149: aload_2
    //   150: athrow
    //   151: astore_0
    //   152: goto -69 -> 83
    //   155: astore_0
    //   156: aload 7
    //   158: areturn
    //   159: astore_3
    //   160: goto -23 -> 137
    //   163: astore_2
    //   164: goto -23 -> 141
    //   167: astore_0
    //   168: aconst_null
    //   169: astore 4
    //   171: aload_3
    //   172: astore_2
    //   173: aload 4
    //   175: astore_3
    //   176: goto -43 -> 133
    //   179: astore_2
    //   180: aload 5
    //   182: astore_0
    //   183: aload 4
    //   185: astore_3
    //   186: goto -37 -> 149
    //   189: astore_2
    //   190: aload 6
    //   192: astore_0
    //   193: aload 4
    //   195: astore_3
    //   196: goto -72 -> 124
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	199	0	paramString	String
    //   0	199	1	paramInt	int
    //   0	199	2	paramClassLoader	ClassLoader
    //   4	142	3	localObject1	Object
    //   159	13	3	localException	Exception
    //   175	21	3	localObject2	Object
    //   31	78	4	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   126	5	4	localObject3	Object
    //   169	25	4	localObject4	Object
    //   15	166	5	localObject5	Object
    //   6	185	6	localObject6	Object
    //   12	145	7	localObject7	Object
    //   9	88	8	localObject8	Object
    //   1	90	9	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   23	33	118	java/io/IOException
    //   51	61	126	finally
    //   72	78	126	finally
    //   104	115	126	finally
    //   124	126	126	finally
    //   149	151	126	finally
    //   23	33	143	java/lang/ClassNotFoundException
    //   78	83	151	java/lang/Exception
    //   83	87	155	java/lang/Exception
    //   133	137	159	java/lang/Exception
    //   137	141	163	java/lang/Exception
    //   23	33	167	finally
    //   51	61	179	java/lang/ClassNotFoundException
    //   72	78	179	java/lang/ClassNotFoundException
    //   104	115	179	java/lang/ClassNotFoundException
    //   51	61	189	java/io/IOException
    //   72	78	189	java/io/IOException
    //   104	115	189	java/io/IOException
  }
  
  public static String a(Serializable paramSerializable)
    throws IOException
  {
    return a(paramSerializable, 0);
  }
  
  /* Error */
  public static String a(Serializable paramSerializable, int paramInt)
    throws IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore_3
    //   5: aconst_null
    //   6: astore 11
    //   8: aconst_null
    //   9: astore_2
    //   10: aload_0
    //   11: ifnonnull +13 -> 24
    //   14: new 208	java/lang/NullPointerException
    //   17: dup
    //   18: ldc -46
    //   20: invokespecial 213	java/lang/NullPointerException:<init>	(Ljava/lang/String;)V
    //   23: athrow
    //   24: new 215	java/io/ByteArrayOutputStream
    //   27: dup
    //   28: invokespecial 216	java/io/ByteArrayOutputStream:<init>	()V
    //   31: astore 6
    //   33: new 11	c/a/b/b/a$b
    //   36: dup
    //   37: aload 6
    //   39: iload_1
    //   40: iconst_1
    //   41: ior
    //   42: invokespecial 219	c/a/b/b/a$b:<init>	(Ljava/io/OutputStream;I)V
    //   45: astore 7
    //   47: iload_1
    //   48: iconst_2
    //   49: iand
    //   50: ifeq +108 -> 158
    //   53: new 221	java/util/zip/GZIPOutputStream
    //   56: dup
    //   57: aload 7
    //   59: invokespecial 224	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   62: astore 4
    //   64: aload 5
    //   66: astore_2
    //   67: aload 4
    //   69: astore_3
    //   70: aload 7
    //   72: astore 8
    //   74: aload 6
    //   76: astore 9
    //   78: aload 4
    //   80: astore 10
    //   82: new 226	java/io/ObjectOutputStream
    //   85: dup
    //   86: aload 4
    //   88: invokespecial 227	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   91: astore 5
    //   93: aload 5
    //   95: astore_2
    //   96: aload 4
    //   98: astore_3
    //   99: aload 7
    //   101: astore 8
    //   103: aload 6
    //   105: astore 9
    //   107: aload 5
    //   109: astore 11
    //   111: aload 4
    //   113: astore 10
    //   115: aload 5
    //   117: aload_0
    //   118: invokevirtual 231	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   121: aload 5
    //   123: invokevirtual 232	java/io/ObjectOutputStream:close	()V
    //   126: aload 4
    //   128: invokevirtual 233	java/util/zip/GZIPOutputStream:close	()V
    //   131: aload 7
    //   133: invokevirtual 236	java/io/OutputStream:close	()V
    //   136: aload 6
    //   138: invokevirtual 237	java/io/ByteArrayOutputStream:close	()V
    //   141: new 239	java/lang/String
    //   144: dup
    //   145: aload 6
    //   147: invokevirtual 243	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   150: ldc -11
    //   152: invokespecial 248	java/lang/String:<init>	([BLjava/lang/String;)V
    //   155: astore_0
    //   156: aload_0
    //   157: areturn
    //   158: new 226	java/io/ObjectOutputStream
    //   161: dup
    //   162: aload 7
    //   164: invokespecial 227	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   167: astore 5
    //   169: aconst_null
    //   170: astore 4
    //   172: goto -79 -> 93
    //   175: astore 4
    //   177: aconst_null
    //   178: astore_0
    //   179: aconst_null
    //   180: astore 5
    //   182: aconst_null
    //   183: astore 6
    //   185: aload_0
    //   186: astore_3
    //   187: aload 5
    //   189: astore 8
    //   191: aload 6
    //   193: astore 9
    //   195: aload 4
    //   197: athrow
    //   198: astore_0
    //   199: aload 9
    //   201: astore 6
    //   203: aload 8
    //   205: astore 4
    //   207: aload_2
    //   208: invokevirtual 232	java/io/ObjectOutputStream:close	()V
    //   211: aload_3
    //   212: invokevirtual 233	java/util/zip/GZIPOutputStream:close	()V
    //   215: aload 4
    //   217: invokevirtual 236	java/io/OutputStream:close	()V
    //   220: aload 6
    //   222: invokevirtual 237	java/io/ByteArrayOutputStream:close	()V
    //   225: aload_0
    //   226: athrow
    //   227: astore_0
    //   228: new 239	java/lang/String
    //   231: dup
    //   232: aload 6
    //   234: invokevirtual 243	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   237: invokespecial 249	java/lang/String:<init>	([B)V
    //   240: areturn
    //   241: astore_0
    //   242: goto -116 -> 126
    //   245: astore_0
    //   246: goto -115 -> 131
    //   249: astore_0
    //   250: goto -114 -> 136
    //   253: astore_0
    //   254: goto -113 -> 141
    //   257: astore_2
    //   258: goto -47 -> 211
    //   261: astore_2
    //   262: goto -47 -> 215
    //   265: astore_2
    //   266: goto -46 -> 220
    //   269: astore_2
    //   270: goto -45 -> 225
    //   273: astore_0
    //   274: aconst_null
    //   275: astore 5
    //   277: aconst_null
    //   278: astore 4
    //   280: aconst_null
    //   281: astore 6
    //   283: aload_3
    //   284: astore_2
    //   285: aload 5
    //   287: astore_3
    //   288: goto -81 -> 207
    //   291: astore_0
    //   292: aconst_null
    //   293: astore 5
    //   295: aconst_null
    //   296: astore 4
    //   298: aload_3
    //   299: astore_2
    //   300: aload 5
    //   302: astore_3
    //   303: goto -96 -> 207
    //   306: astore_0
    //   307: aconst_null
    //   308: astore 4
    //   310: aload_3
    //   311: astore_2
    //   312: aload 4
    //   314: astore_3
    //   315: aload 7
    //   317: astore 4
    //   319: goto -112 -> 207
    //   322: astore 4
    //   324: aconst_null
    //   325: astore_0
    //   326: aconst_null
    //   327: astore 5
    //   329: goto -144 -> 185
    //   332: astore 4
    //   334: aconst_null
    //   335: astore_0
    //   336: aload 7
    //   338: astore 5
    //   340: goto -155 -> 185
    //   343: astore 4
    //   345: aload 11
    //   347: astore_2
    //   348: aload 10
    //   350: astore_0
    //   351: aload 7
    //   353: astore 5
    //   355: goto -170 -> 185
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	358	0	paramSerializable	Serializable
    //   0	358	1	paramInt	int
    //   9	199	2	localObject1	Object
    //   257	1	2	localException1	Exception
    //   261	1	2	localException2	Exception
    //   265	1	2	localException3	Exception
    //   269	1	2	localException4	Exception
    //   284	64	2	localObject2	Object
    //   4	311	3	localObject3	Object
    //   62	109	4	localGZIPOutputStream1	java.util.zip.GZIPOutputStream
    //   175	21	4	localIOException1	IOException
    //   205	113	4	localObject4	Object
    //   322	1	4	localIOException2	IOException
    //   332	1	4	localIOException3	IOException
    //   343	1	4	localIOException4	IOException
    //   1	353	5	localObject5	Object
    //   31	251	6	localObject6	Object
    //   45	307	7	localb	b
    //   72	132	8	localObject7	Object
    //   76	124	9	localObject8	Object
    //   80	269	10	localGZIPOutputStream2	java.util.zip.GZIPOutputStream
    //   6	340	11	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   24	33	175	java/io/IOException
    //   82	93	198	finally
    //   115	121	198	finally
    //   195	198	198	finally
    //   141	156	227	java/io/UnsupportedEncodingException
    //   121	126	241	java/lang/Exception
    //   126	131	245	java/lang/Exception
    //   131	136	249	java/lang/Exception
    //   136	141	253	java/lang/Exception
    //   207	211	257	java/lang/Exception
    //   211	215	261	java/lang/Exception
    //   215	220	265	java/lang/Exception
    //   220	225	269	java/lang/Exception
    //   24	33	273	finally
    //   33	47	291	finally
    //   53	64	306	finally
    //   158	169	306	finally
    //   33	47	322	java/io/IOException
    //   53	64	332	java/io/IOException
    //   158	169	332	java/io/IOException
    //   82	93	343	java/io/IOException
    //   115	121	343	java/io/IOException
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    Object localObject = null;
    try
    {
      paramArrayOfByte = a(paramArrayOfByte, 0, paramArrayOfByte.length, 0);
      if ((!a) && (paramArrayOfByte == null)) {
        throw new AssertionError();
      }
    }
    catch (IOException localIOException)
    {
      do
      {
        paramArrayOfByte = (byte[])localObject;
      } while (a);
      throw new AssertionError(localIOException.getMessage());
    }
    return paramArrayOfByte;
  }
  
  public static String a(byte[] paramArrayOfByte, int paramInt)
    throws IOException
  {
    return a(paramArrayOfByte, 0, paramArrayOfByte.length, paramInt);
  }
  
  public static String a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Object localObject = null;
    try
    {
      paramArrayOfByte = a(paramArrayOfByte, paramInt1, paramInt2, 0);
      if ((!a) && (paramArrayOfByte == null)) {
        throw new AssertionError();
      }
    }
    catch (IOException localIOException)
    {
      do
      {
        paramArrayOfByte = (byte[])localObject;
      } while (a);
      throw new AssertionError(localIOException.getMessage());
    }
    return paramArrayOfByte;
  }
  
  public static String a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
    throws IOException
  {
    paramArrayOfByte = b(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
    try
    {
      String str = new String(paramArrayOfByte, "US-ASCII");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
    return new String(paramArrayOfByte);
  }
  
  /* Error */
  public static void a(String paramString1, String paramString2)
    throws IOException
  {
    // Byte code:
    //   0: new 11	c/a/b/b/a$b
    //   3: dup
    //   4: new 270	java/io/FileOutputStream
    //   7: dup
    //   8: aload_1
    //   9: invokespecial 271	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   12: iconst_0
    //   13: invokespecial 219	c/a/b/b/a$b:<init>	(Ljava/io/OutputStream;I)V
    //   16: astore_2
    //   17: aload_2
    //   18: astore_1
    //   19: aload_2
    //   20: aload_0
    //   21: ldc -11
    //   23: invokevirtual 275	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   26: invokevirtual 278	c/a/b/b/a$b:write	([B)V
    //   29: aload_2
    //   30: invokevirtual 279	c/a/b/b/a$b:close	()V
    //   33: return
    //   34: astore_0
    //   35: aconst_null
    //   36: astore_1
    //   37: aload_0
    //   38: athrow
    //   39: astore_0
    //   40: aload_1
    //   41: invokevirtual 279	c/a/b/b/a$b:close	()V
    //   44: aload_0
    //   45: athrow
    //   46: astore_0
    //   47: return
    //   48: astore_1
    //   49: goto -5 -> 44
    //   52: astore_0
    //   53: aconst_null
    //   54: astore_1
    //   55: goto -15 -> 40
    //   58: astore_0
    //   59: aload_2
    //   60: astore_1
    //   61: goto -24 -> 37
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	paramString1	String
    //   0	64	1	paramString2	String
    //   16	44	2	localb	b
    // Exception table:
    //   from	to	target	type
    //   0	17	34	java/io/IOException
    //   19	29	39	finally
    //   37	39	39	finally
    //   29	33	46	java/lang/Exception
    //   40	44	48	java/lang/Exception
    //   0	17	52	finally
    //   19	29	58	java/io/IOException
  }
  
  public static void a(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2)
  {
    byte[] arrayOfByte1 = new byte[3];
    byte[] arrayOfByte2 = new byte[4];
    while (paramByteBuffer1.hasRemaining())
    {
      int i = Math.min(3, paramByteBuffer1.remaining());
      paramByteBuffer1.get(arrayOfByte1, 0, i);
      b(arrayOfByte2, arrayOfByte1, i, 0);
      paramByteBuffer2.put(arrayOfByte2);
    }
  }
  
  public static void a(ByteBuffer paramByteBuffer, CharBuffer paramCharBuffer)
  {
    byte[] arrayOfByte1 = new byte[3];
    byte[] arrayOfByte2 = new byte[4];
    while (paramByteBuffer.hasRemaining())
    {
      int i = Math.min(3, paramByteBuffer.remaining());
      paramByteBuffer.get(arrayOfByte1, 0, i);
      b(arrayOfByte2, arrayOfByte1, i, 0);
      i = 0;
      while (i < 4)
      {
        paramCharBuffer.put((char)(arrayOfByte2[i] & 0xFF));
        i += 1;
      }
    }
  }
  
  /* Error */
  public static void a(byte[] paramArrayOfByte, String paramString)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +14 -> 15
    //   4: new 208	java/lang/NullPointerException
    //   7: dup
    //   8: ldc_w 314
    //   11: invokespecial 213	java/lang/NullPointerException:<init>	(Ljava/lang/String;)V
    //   14: athrow
    //   15: aconst_null
    //   16: astore_3
    //   17: new 11	c/a/b/b/a$b
    //   20: dup
    //   21: new 270	java/io/FileOutputStream
    //   24: dup
    //   25: aload_1
    //   26: invokespecial 271	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   29: iconst_1
    //   30: invokespecial 219	c/a/b/b/a$b:<init>	(Ljava/io/OutputStream;I)V
    //   33: astore_2
    //   34: aload_2
    //   35: astore_1
    //   36: aload_2
    //   37: aload_0
    //   38: invokevirtual 278	c/a/b/b/a$b:write	([B)V
    //   41: aload_2
    //   42: invokevirtual 279	c/a/b/b/a$b:close	()V
    //   45: return
    //   46: astore_0
    //   47: aconst_null
    //   48: astore_1
    //   49: aload_0
    //   50: athrow
    //   51: astore_0
    //   52: aload_1
    //   53: invokevirtual 279	c/a/b/b/a$b:close	()V
    //   56: aload_0
    //   57: athrow
    //   58: astore_0
    //   59: return
    //   60: astore_1
    //   61: goto -5 -> 56
    //   64: astore_0
    //   65: aload_3
    //   66: astore_1
    //   67: goto -15 -> 52
    //   70: astore_0
    //   71: aload_2
    //   72: astore_1
    //   73: goto -24 -> 49
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	paramArrayOfByte	byte[]
    //   0	76	1	paramString	String
    //   33	39	2	localb	b
    //   16	50	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   17	34	46	java/io/IOException
    //   36	41	51	finally
    //   49	51	51	finally
    //   41	45	58	java/lang/Exception
    //   52	56	60	java/lang/Exception
    //   17	34	64	finally
    //   36	41	70	java/io/IOException
  }
  
  public static byte[] a(String paramString)
    throws IOException
  {
    return a(paramString, 0);
  }
  
  /* Error */
  public static byte[] a(String paramString, int paramInt)
    throws IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore_3
    //   5: aload_0
    //   6: ifnonnull +14 -> 20
    //   9: new 208	java/lang/NullPointerException
    //   12: dup
    //   13: ldc_w 319
    //   16: invokespecial 213	java/lang/NullPointerException:<init>	(Ljava/lang/String;)V
    //   19: athrow
    //   20: aload_0
    //   21: ldc -11
    //   23: invokevirtual 275	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   26: astore_2
    //   27: aload_2
    //   28: astore_0
    //   29: aload_0
    //   30: iconst_0
    //   31: aload_0
    //   32: arraylength
    //   33: iload_1
    //   34: invokestatic 321	c/a/b/b/a:c	([BIII)[B
    //   37: astore 6
    //   39: iload_1
    //   40: iconst_4
    //   41: iand
    //   42: ifeq +143 -> 185
    //   45: iconst_1
    //   46: istore_1
    //   47: aload 6
    //   49: ifnull +124 -> 173
    //   52: aload 6
    //   54: arraylength
    //   55: iconst_4
    //   56: if_icmplt +117 -> 173
    //   59: iload_1
    //   60: ifne +113 -> 173
    //   63: ldc_w 322
    //   66: aload 6
    //   68: iconst_0
    //   69: baload
    //   70: sipush 255
    //   73: iand
    //   74: aload 6
    //   76: iconst_1
    //   77: baload
    //   78: bipush 8
    //   80: ishl
    //   81: ldc_w 323
    //   84: iand
    //   85: ior
    //   86: if_icmpne +87 -> 173
    //   89: sipush 2048
    //   92: newarray <illegal type>
    //   94: astore 7
    //   96: new 215	java/io/ByteArrayOutputStream
    //   99: dup
    //   100: invokespecial 216	java/io/ByteArrayOutputStream:<init>	()V
    //   103: astore 4
    //   105: new 180	java/io/ByteArrayInputStream
    //   108: dup
    //   109: aload 6
    //   111: invokespecial 183	java/io/ByteArrayInputStream:<init>	([B)V
    //   114: astore_2
    //   115: new 325	java/util/zip/GZIPInputStream
    //   118: dup
    //   119: aload_2
    //   120: invokespecial 326	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   123: astore_0
    //   124: aload_0
    //   125: aload 7
    //   127: invokevirtual 330	java/util/zip/GZIPInputStream:read	([B)I
    //   130: istore_1
    //   131: iload_1
    //   132: iflt +58 -> 190
    //   135: aload 4
    //   137: aload 7
    //   139: iconst_0
    //   140: iload_1
    //   141: invokevirtual 333	java/io/ByteArrayOutputStream:write	([BII)V
    //   144: goto -20 -> 124
    //   147: astore 5
    //   149: aload_0
    //   150: astore_3
    //   151: aload_2
    //   152: astore_0
    //   153: aload 5
    //   155: astore_2
    //   156: aload_2
    //   157: invokevirtual 336	java/io/IOException:printStackTrace	()V
    //   160: aload 4
    //   162: invokevirtual 237	java/io/ByteArrayOutputStream:close	()V
    //   165: aload_3
    //   166: invokevirtual 337	java/util/zip/GZIPInputStream:close	()V
    //   169: aload_0
    //   170: invokevirtual 195	java/io/ByteArrayInputStream:close	()V
    //   173: aload 6
    //   175: areturn
    //   176: astore_2
    //   177: aload_0
    //   178: invokevirtual 339	java/lang/String:getBytes	()[B
    //   181: astore_0
    //   182: goto -153 -> 29
    //   185: iconst_0
    //   186: istore_1
    //   187: goto -140 -> 47
    //   190: aload 4
    //   192: invokevirtual 243	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   195: astore_3
    //   196: aload 4
    //   198: invokevirtual 237	java/io/ByteArrayOutputStream:close	()V
    //   201: aload_0
    //   202: invokevirtual 337	java/util/zip/GZIPInputStream:close	()V
    //   205: aload_2
    //   206: invokevirtual 195	java/io/ByteArrayInputStream:close	()V
    //   209: aload_3
    //   210: areturn
    //   211: astore_0
    //   212: aload_3
    //   213: areturn
    //   214: astore_0
    //   215: aconst_null
    //   216: astore 4
    //   218: aconst_null
    //   219: astore_2
    //   220: aload 5
    //   222: astore_3
    //   223: aload 4
    //   225: invokevirtual 237	java/io/ByteArrayOutputStream:close	()V
    //   228: aload_3
    //   229: invokevirtual 337	java/util/zip/GZIPInputStream:close	()V
    //   232: aload_2
    //   233: invokevirtual 195	java/io/ByteArrayInputStream:close	()V
    //   236: aload_0
    //   237: athrow
    //   238: astore 4
    //   240: goto -39 -> 201
    //   243: astore_0
    //   244: goto -39 -> 205
    //   247: astore_2
    //   248: goto -83 -> 165
    //   251: astore_2
    //   252: goto -83 -> 169
    //   255: astore_0
    //   256: aload 6
    //   258: areturn
    //   259: astore 4
    //   261: goto -33 -> 228
    //   264: astore_3
    //   265: goto -33 -> 232
    //   268: astore_2
    //   269: goto -33 -> 236
    //   272: astore_0
    //   273: aconst_null
    //   274: astore_2
    //   275: aload 5
    //   277: astore_3
    //   278: goto -55 -> 223
    //   281: astore_0
    //   282: aload 5
    //   284: astore_3
    //   285: goto -62 -> 223
    //   288: astore 5
    //   290: aload_0
    //   291: astore_3
    //   292: aload 5
    //   294: astore_0
    //   295: goto -72 -> 223
    //   298: astore 5
    //   300: aload_0
    //   301: astore_2
    //   302: aload 5
    //   304: astore_0
    //   305: goto -82 -> 223
    //   308: astore_2
    //   309: aconst_null
    //   310: astore 4
    //   312: aconst_null
    //   313: astore_0
    //   314: goto -158 -> 156
    //   317: astore_2
    //   318: aconst_null
    //   319: astore_0
    //   320: goto -164 -> 156
    //   323: astore 5
    //   325: aload_2
    //   326: astore_0
    //   327: aload 5
    //   329: astore_2
    //   330: goto -174 -> 156
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	333	0	paramString	String
    //   0	333	1	paramInt	int
    //   26	131	2	localObject1	Object
    //   176	30	2	localUnsupportedEncodingException	UnsupportedEncodingException
    //   219	14	2	localObject2	Object
    //   247	1	2	localException1	Exception
    //   251	1	2	localException2	Exception
    //   268	1	2	localException3	Exception
    //   274	28	2	str	String
    //   308	1	2	localIOException1	IOException
    //   317	9	2	localIOException2	IOException
    //   329	1	2	localIOException3	IOException
    //   4	225	3	localObject3	Object
    //   264	1	3	localException4	Exception
    //   277	15	3	localObject4	Object
    //   103	121	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   238	1	4	localException5	Exception
    //   259	1	4	localException6	Exception
    //   310	1	4	localObject5	Object
    //   1	1	5	localObject6	Object
    //   147	136	5	localIOException4	IOException
    //   288	5	5	localObject7	Object
    //   298	5	5	localObject8	Object
    //   323	5	5	localIOException5	IOException
    //   37	220	6	arrayOfByte1	byte[]
    //   94	44	7	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   124	131	147	java/io/IOException
    //   135	144	147	java/io/IOException
    //   190	196	147	java/io/IOException
    //   20	27	176	java/io/UnsupportedEncodingException
    //   205	209	211	java/lang/Exception
    //   96	105	214	finally
    //   196	201	238	java/lang/Exception
    //   201	205	243	java/lang/Exception
    //   160	165	247	java/lang/Exception
    //   165	169	251	java/lang/Exception
    //   169	173	255	java/lang/Exception
    //   223	228	259	java/lang/Exception
    //   228	232	264	java/lang/Exception
    //   232	236	268	java/lang/Exception
    //   105	115	272	finally
    //   115	124	281	finally
    //   124	131	288	finally
    //   135	144	288	finally
    //   190	196	288	finally
    //   156	160	298	finally
    //   96	105	308	java/io/IOException
    //   105	115	317	java/io/IOException
    //   115	124	323	java/io/IOException
  }
  
  private static int b(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3)
  {
    if (paramArrayOfByte1 == null) {
      throw new NullPointerException("Source array was null.");
    }
    if (paramArrayOfByte2 == null) {
      throw new NullPointerException("Destination array was null.");
    }
    if ((paramInt1 < 0) || (paramInt1 + 3 >= paramArrayOfByte1.length)) {
      throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and still process four bytes.", new Object[] { Integer.valueOf(paramArrayOfByte1.length), Integer.valueOf(paramInt1) }));
    }
    if ((paramInt2 < 0) || (paramInt2 + 2 >= paramArrayOfByte2.length)) {
      throw new IllegalArgumentException(String.format("Destination array with length %d cannot have offset of %d and still store three bytes.", new Object[] { Integer.valueOf(paramArrayOfByte2.length), Integer.valueOf(paramInt2) }));
    }
    byte[] arrayOfByte = c(paramInt3);
    if (paramArrayOfByte1[(paramInt1 + 2)] == 61)
    {
      paramArrayOfByte2[paramInt2] = ((byte)(((arrayOfByte[paramArrayOfByte1[paramInt1]] & 0xFF) << 18 | (arrayOfByte[paramArrayOfByte1[(paramInt1 + 1)]] & 0xFF) << 12) >>> 16));
      return 1;
    }
    if (paramArrayOfByte1[(paramInt1 + 3)] == 61)
    {
      paramInt1 = (arrayOfByte[paramArrayOfByte1[paramInt1]] & 0xFF) << 18 | (arrayOfByte[paramArrayOfByte1[(paramInt1 + 1)]] & 0xFF) << 12 | (arrayOfByte[paramArrayOfByte1[(paramInt1 + 2)]] & 0xFF) << 6;
      paramArrayOfByte2[paramInt2] = ((byte)(paramInt1 >>> 16));
      paramArrayOfByte2[(paramInt2 + 1)] = ((byte)(paramInt1 >>> 8));
      return 2;
    }
    paramInt1 = (arrayOfByte[paramArrayOfByte1[paramInt1]] & 0xFF) << 18 | (arrayOfByte[paramArrayOfByte1[(paramInt1 + 1)]] & 0xFF) << 12 | (arrayOfByte[paramArrayOfByte1[(paramInt1 + 2)]] & 0xFF) << 6 | arrayOfByte[paramArrayOfByte1[(paramInt1 + 3)]] & 0xFF;
    paramArrayOfByte2[paramInt2] = ((byte)(paramInt1 >> 16));
    paramArrayOfByte2[(paramInt2 + 1)] = ((byte)(paramInt1 >> 8));
    paramArrayOfByte2[(paramInt2 + 2)] = ((byte)paramInt1);
    return 3;
  }
  
  public static Object b(String paramString)
    throws IOException, ClassNotFoundException
  {
    return a(paramString, 0, null);
  }
  
  /* Error */
  public static void b(String paramString1, String paramString2)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 369	c/a/b/b/a:d	(Ljava/lang/String;)Ljava/lang/String;
    //   4: astore_2
    //   5: new 371	java/io/BufferedOutputStream
    //   8: dup
    //   9: new 270	java/io/FileOutputStream
    //   12: dup
    //   13: aload_1
    //   14: invokespecial 271	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   17: invokespecial 372	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   20: astore_1
    //   21: aload_1
    //   22: astore_0
    //   23: aload_1
    //   24: aload_2
    //   25: ldc -11
    //   27: invokevirtual 275	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   30: invokevirtual 373	java/io/OutputStream:write	([B)V
    //   33: aload_1
    //   34: invokevirtual 236	java/io/OutputStream:close	()V
    //   37: return
    //   38: astore_2
    //   39: aconst_null
    //   40: astore_0
    //   41: aload_2
    //   42: athrow
    //   43: astore_2
    //   44: aload_0
    //   45: astore_1
    //   46: aload_2
    //   47: astore_0
    //   48: aload_1
    //   49: invokevirtual 236	java/io/OutputStream:close	()V
    //   52: aload_0
    //   53: athrow
    //   54: astore_0
    //   55: return
    //   56: astore_1
    //   57: goto -5 -> 52
    //   60: astore_0
    //   61: aconst_null
    //   62: astore_1
    //   63: goto -15 -> 48
    //   66: astore_2
    //   67: aload_1
    //   68: astore_0
    //   69: goto -28 -> 41
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	72	0	paramString1	String
    //   0	72	1	paramString2	String
    //   4	21	2	str	String
    //   38	4	2	localIOException1	IOException
    //   43	4	2	localObject	Object
    //   66	1	2	localIOException2	IOException
    // Exception table:
    //   from	to	target	type
    //   5	21	38	java/io/IOException
    //   23	33	43	finally
    //   41	43	43	finally
    //   33	37	54	java/lang/Exception
    //   48	52	56	java/lang/Exception
    //   5	21	60	finally
    //   23	33	66	java/io/IOException
  }
  
  private static final byte[] b(int paramInt)
  {
    if ((paramInt & 0x10) == 16) {
      return d;
    }
    if ((paramInt & 0x20) == 32) {
      return f;
    }
    return b;
  }
  
  public static byte[] b(byte[] paramArrayOfByte)
  {
    Object localObject = null;
    try
    {
      paramArrayOfByte = b(paramArrayOfByte, 0, paramArrayOfByte.length, 0);
      return paramArrayOfByte;
    }
    catch (IOException localIOException)
    {
      do
      {
        paramArrayOfByte = (byte[])localObject;
      } while (a);
      throw new AssertionError("IOExceptions only come from GZipping, which is turned off: " + localIOException.getMessage());
    }
  }
  
  /* Error */
  public static byte[] b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
    throws IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 14
    //   3: aconst_null
    //   4: astore 13
    //   6: aload_0
    //   7: ifnonnull +14 -> 21
    //   10: new 208	java/lang/NullPointerException
    //   13: dup
    //   14: ldc_w 388
    //   17: invokespecial 213	java/lang/NullPointerException:<init>	(Ljava/lang/String;)V
    //   20: athrow
    //   21: iload_1
    //   22: ifge +31 -> 53
    //   25: new 348	java/lang/IllegalArgumentException
    //   28: dup
    //   29: new 376	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 377	java/lang/StringBuilder:<init>	()V
    //   36: ldc_w 390
    //   39: invokevirtual 383	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: iload_1
    //   43: invokevirtual 393	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   46: invokevirtual 386	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokespecial 361	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   52: athrow
    //   53: iload_2
    //   54: ifge +31 -> 85
    //   57: new 348	java/lang/IllegalArgumentException
    //   60: dup
    //   61: new 376	java/lang/StringBuilder
    //   64: dup
    //   65: invokespecial 377	java/lang/StringBuilder:<init>	()V
    //   68: ldc_w 395
    //   71: invokevirtual 383	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: iload_2
    //   75: invokevirtual 393	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   78: invokevirtual 386	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: invokespecial 361	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   84: athrow
    //   85: iload_1
    //   86: iload_2
    //   87: iadd
    //   88: aload_0
    //   89: arraylength
    //   90: if_icmple +43 -> 133
    //   93: new 348	java/lang/IllegalArgumentException
    //   96: dup
    //   97: ldc_w 397
    //   100: iconst_3
    //   101: anewarray 4	java/lang/Object
    //   104: dup
    //   105: iconst_0
    //   106: iload_1
    //   107: invokestatic 356	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   110: aastore
    //   111: dup
    //   112: iconst_1
    //   113: iload_2
    //   114: invokestatic 356	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   117: aastore
    //   118: dup
    //   119: iconst_2
    //   120: aload_0
    //   121: arraylength
    //   122: invokestatic 356	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   125: aastore
    //   126: invokestatic 360	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   129: invokespecial 361	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   132: athrow
    //   133: iload_3
    //   134: iconst_2
    //   135: iand
    //   136: ifeq +116 -> 252
    //   139: new 215	java/io/ByteArrayOutputStream
    //   142: dup
    //   143: invokespecial 216	java/io/ByteArrayOutputStream:<init>	()V
    //   146: astore 10
    //   148: new 11	c/a/b/b/a$b
    //   151: dup
    //   152: aload 10
    //   154: iload_3
    //   155: iconst_1
    //   156: ior
    //   157: invokespecial 219	c/a/b/b/a$b:<init>	(Ljava/io/OutputStream;I)V
    //   160: astore 12
    //   162: new 221	java/util/zip/GZIPOutputStream
    //   165: dup
    //   166: aload 12
    //   168: invokespecial 224	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   171: astore 11
    //   173: aload 11
    //   175: aload_0
    //   176: iload_1
    //   177: iload_2
    //   178: invokevirtual 398	java/util/zip/GZIPOutputStream:write	([BII)V
    //   181: aload 11
    //   183: invokevirtual 233	java/util/zip/GZIPOutputStream:close	()V
    //   186: aload 11
    //   188: invokevirtual 233	java/util/zip/GZIPOutputStream:close	()V
    //   191: aload 12
    //   193: invokevirtual 279	c/a/b/b/a$b:close	()V
    //   196: aload 10
    //   198: invokevirtual 237	java/io/ByteArrayOutputStream:close	()V
    //   201: aload 10
    //   203: invokevirtual 243	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   206: astore_0
    //   207: aload_0
    //   208: areturn
    //   209: astore 11
    //   211: aconst_null
    //   212: astore 10
    //   214: aconst_null
    //   215: astore_0
    //   216: aload 13
    //   218: astore 12
    //   220: aload 11
    //   222: athrow
    //   223: astore 14
    //   225: aload_0
    //   226: astore 13
    //   228: aload 10
    //   230: astore 11
    //   232: aload 14
    //   234: astore_0
    //   235: aload 12
    //   237: invokevirtual 233	java/util/zip/GZIPOutputStream:close	()V
    //   240: aload 11
    //   242: invokevirtual 279	c/a/b/b/a$b:close	()V
    //   245: aload 13
    //   247: invokevirtual 237	java/io/ByteArrayOutputStream:close	()V
    //   250: aload_0
    //   251: athrow
    //   252: iload_3
    //   253: bipush 8
    //   255: iand
    //   256: ifeq +153 -> 409
    //   259: iconst_1
    //   260: istore 6
    //   262: iload_2
    //   263: iconst_3
    //   264: idiv
    //   265: istore 5
    //   267: iload_2
    //   268: iconst_3
    //   269: irem
    //   270: ifle +145 -> 415
    //   273: iconst_4
    //   274: istore 4
    //   276: iload 4
    //   278: iload 5
    //   280: iconst_4
    //   281: imul
    //   282: iadd
    //   283: istore 5
    //   285: iload 5
    //   287: istore 4
    //   289: iload 6
    //   291: ifeq +13 -> 304
    //   294: iload 5
    //   296: iload 5
    //   298: bipush 76
    //   300: idiv
    //   301: iadd
    //   302: istore 4
    //   304: iload 4
    //   306: newarray <illegal type>
    //   308: astore 10
    //   310: iconst_0
    //   311: istore 5
    //   313: iconst_0
    //   314: istore 4
    //   316: iconst_0
    //   317: istore 7
    //   319: iload 7
    //   321: iload_2
    //   322: iconst_2
    //   323: isub
    //   324: if_icmpge +97 -> 421
    //   327: aload_0
    //   328: iload 7
    //   330: iload_1
    //   331: iadd
    //   332: iconst_3
    //   333: aload 10
    //   335: iload 4
    //   337: iload_3
    //   338: invokestatic 342	c/a/b/b/a:b	([BII[BII)[B
    //   341: pop
    //   342: iload 5
    //   344: iconst_4
    //   345: iadd
    //   346: istore 9
    //   348: iload 9
    //   350: istore 5
    //   352: iload 4
    //   354: istore 8
    //   356: iload 6
    //   358: ifeq +36 -> 394
    //   361: iload 9
    //   363: istore 5
    //   365: iload 4
    //   367: istore 8
    //   369: iload 9
    //   371: bipush 76
    //   373: if_icmplt +21 -> 394
    //   376: aload 10
    //   378: iload 4
    //   380: iconst_4
    //   381: iadd
    //   382: bipush 10
    //   384: bastore
    //   385: iload 4
    //   387: iconst_1
    //   388: iadd
    //   389: istore 8
    //   391: iconst_0
    //   392: istore 5
    //   394: iload 8
    //   396: iconst_4
    //   397: iadd
    //   398: istore 4
    //   400: iload 7
    //   402: iconst_3
    //   403: iadd
    //   404: istore 7
    //   406: goto -87 -> 319
    //   409: iconst_0
    //   410: istore 6
    //   412: goto -150 -> 262
    //   415: iconst_0
    //   416: istore 4
    //   418: goto -142 -> 276
    //   421: iload 4
    //   423: istore 5
    //   425: iload 7
    //   427: iload_2
    //   428: if_icmpge +27 -> 455
    //   431: aload_0
    //   432: iload 7
    //   434: iload_1
    //   435: iadd
    //   436: iload_2
    //   437: iload 7
    //   439: isub
    //   440: aload 10
    //   442: iload 4
    //   444: iload_3
    //   445: invokestatic 342	c/a/b/b/a:b	([BII[BII)[B
    //   448: pop
    //   449: iload 4
    //   451: iconst_4
    //   452: iadd
    //   453: istore 5
    //   455: aload 10
    //   457: astore_0
    //   458: iload 5
    //   460: aload 10
    //   462: arraylength
    //   463: iconst_1
    //   464: isub
    //   465: if_icmpgt -258 -> 207
    //   468: iload 5
    //   470: newarray <illegal type>
    //   472: astore_0
    //   473: aload 10
    //   475: iconst_0
    //   476: aload_0
    //   477: iconst_0
    //   478: iload 5
    //   480: invokestatic 404	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   483: aload_0
    //   484: areturn
    //   485: astore_0
    //   486: goto -295 -> 191
    //   489: astore_0
    //   490: goto -294 -> 196
    //   493: astore_0
    //   494: goto -293 -> 201
    //   497: astore 10
    //   499: goto -259 -> 240
    //   502: astore 10
    //   504: goto -259 -> 245
    //   507: astore 10
    //   509: goto -259 -> 250
    //   512: astore_0
    //   513: aconst_null
    //   514: astore 11
    //   516: aconst_null
    //   517: astore 13
    //   519: aload 14
    //   521: astore 12
    //   523: goto -288 -> 235
    //   526: astore_0
    //   527: aconst_null
    //   528: astore 11
    //   530: aload 14
    //   532: astore 12
    //   534: aload 10
    //   536: astore 13
    //   538: goto -303 -> 235
    //   541: astore_0
    //   542: aload 12
    //   544: astore 11
    //   546: aload 14
    //   548: astore 12
    //   550: aload 10
    //   552: astore 13
    //   554: goto -319 -> 235
    //   557: astore_0
    //   558: aload 11
    //   560: astore 13
    //   562: aload 12
    //   564: astore 11
    //   566: aload 13
    //   568: astore 12
    //   570: aload 10
    //   572: astore 13
    //   574: goto -339 -> 235
    //   577: astore 11
    //   579: aconst_null
    //   580: astore 12
    //   582: aload 10
    //   584: astore_0
    //   585: aload 12
    //   587: astore 10
    //   589: aload 13
    //   591: astore 12
    //   593: goto -373 -> 220
    //   596: astore 11
    //   598: aload 10
    //   600: astore_0
    //   601: aload 12
    //   603: astore 10
    //   605: aload 13
    //   607: astore 12
    //   609: goto -389 -> 220
    //   612: astore 14
    //   614: aload 11
    //   616: astore 13
    //   618: aload 10
    //   620: astore_0
    //   621: aload 14
    //   623: astore 11
    //   625: aload 12
    //   627: astore 10
    //   629: aload 13
    //   631: astore 12
    //   633: goto -413 -> 220
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	636	0	paramArrayOfByte	byte[]
    //   0	636	1	paramInt1	int
    //   0	636	2	paramInt2	int
    //   0	636	3	paramInt3	int
    //   274	179	4	i	int
    //   265	214	5	j	int
    //   260	151	6	k	int
    //   317	123	7	m	int
    //   354	44	8	n	int
    //   346	28	9	i1	int
    //   146	328	10	localObject1	Object
    //   497	1	10	localException1	Exception
    //   502	1	10	localException2	Exception
    //   507	76	10	localException3	Exception
    //   587	41	10	localObject2	Object
    //   171	16	11	localGZIPOutputStream	java.util.zip.GZIPOutputStream
    //   209	12	11	localIOException1	IOException
    //   230	335	11	localObject3	Object
    //   577	1	11	localIOException2	IOException
    //   596	19	11	localIOException3	IOException
    //   623	1	11	localIOException4	IOException
    //   160	472	12	localObject4	Object
    //   4	626	13	localObject5	Object
    //   1	1	14	localObject6	Object
    //   223	324	14	localObject7	Object
    //   612	10	14	localIOException5	IOException
    // Exception table:
    //   from	to	target	type
    //   139	148	209	java/io/IOException
    //   220	223	223	finally
    //   186	191	485	java/lang/Exception
    //   191	196	489	java/lang/Exception
    //   196	201	493	java/lang/Exception
    //   235	240	497	java/lang/Exception
    //   240	245	502	java/lang/Exception
    //   245	250	507	java/lang/Exception
    //   139	148	512	finally
    //   148	162	526	finally
    //   162	173	541	finally
    //   173	186	557	finally
    //   148	162	577	java/io/IOException
    //   162	173	596	java/io/IOException
    //   173	186	612	java/io/IOException
  }
  
  private static byte[] b(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3, int paramInt4)
  {
    int j = 0;
    byte[] arrayOfByte = b(paramInt4);
    if (paramInt2 > 0)
    {
      paramInt4 = paramArrayOfByte1[paramInt1] << 24 >>> 8;
      label25:
      if (paramInt2 <= 1) {
        break label104;
      }
    }
    label104:
    for (int i = paramArrayOfByte1[(paramInt1 + 1)] << 24 >>> 16;; i = 0)
    {
      if (paramInt2 > 2) {
        j = paramArrayOfByte1[(paramInt1 + 2)] << 24 >>> 24;
      }
      paramInt1 = j | i | paramInt4;
      switch (paramInt2)
      {
      default: 
        return paramArrayOfByte2;
        paramInt4 = 0;
        break label25;
      }
    }
    paramArrayOfByte2[paramInt3] = arrayOfByte[(paramInt1 >>> 18)];
    paramArrayOfByte2[(paramInt3 + 1)] = arrayOfByte[(paramInt1 >>> 12 & 0x3F)];
    paramArrayOfByte2[(paramInt3 + 2)] = arrayOfByte[(paramInt1 >>> 6 & 0x3F)];
    paramArrayOfByte2[(paramInt3 + 3)] = arrayOfByte[(paramInt1 & 0x3F)];
    return paramArrayOfByte2;
    paramArrayOfByte2[paramInt3] = arrayOfByte[(paramInt1 >>> 18)];
    paramArrayOfByte2[(paramInt3 + 1)] = arrayOfByte[(paramInt1 >>> 12 & 0x3F)];
    paramArrayOfByte2[(paramInt3 + 2)] = arrayOfByte[(paramInt1 >>> 6 & 0x3F)];
    paramArrayOfByte2[(paramInt3 + 3)] = 61;
    return paramArrayOfByte2;
    paramArrayOfByte2[paramInt3] = arrayOfByte[(paramInt1 >>> 18)];
    paramArrayOfByte2[(paramInt3 + 1)] = arrayOfByte[(paramInt1 >>> 12 & 0x3F)];
    paramArrayOfByte2[(paramInt3 + 2)] = 61;
    paramArrayOfByte2[(paramInt3 + 3)] = 61;
    return paramArrayOfByte2;
  }
  
  private static byte[] b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2)
  {
    b(paramArrayOfByte2, 0, paramInt1, paramArrayOfByte1, 0, paramInt2);
    return paramArrayOfByte1;
  }
  
  /* Error */
  public static void c(String paramString1, String paramString2)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 408	c/a/b/b/a:c	(Ljava/lang/String;)[B
    //   4: astore_3
    //   5: aconst_null
    //   6: astore_2
    //   7: new 371	java/io/BufferedOutputStream
    //   10: dup
    //   11: new 270	java/io/FileOutputStream
    //   14: dup
    //   15: aload_1
    //   16: invokespecial 271	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   19: invokespecial 372	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   22: astore_1
    //   23: aload_1
    //   24: astore_0
    //   25: aload_1
    //   26: aload_3
    //   27: invokevirtual 373	java/io/OutputStream:write	([B)V
    //   30: aload_1
    //   31: invokevirtual 236	java/io/OutputStream:close	()V
    //   34: return
    //   35: astore_2
    //   36: aconst_null
    //   37: astore_0
    //   38: aload_2
    //   39: athrow
    //   40: astore_2
    //   41: aload_0
    //   42: astore_1
    //   43: aload_2
    //   44: astore_0
    //   45: aload_1
    //   46: invokevirtual 236	java/io/OutputStream:close	()V
    //   49: aload_0
    //   50: athrow
    //   51: astore_0
    //   52: return
    //   53: astore_1
    //   54: goto -5 -> 49
    //   57: astore_0
    //   58: aload_2
    //   59: astore_1
    //   60: goto -15 -> 45
    //   63: astore_2
    //   64: aload_1
    //   65: astore_0
    //   66: goto -28 -> 38
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	69	0	paramString1	String
    //   0	69	1	paramString2	String
    //   6	1	2	localObject1	Object
    //   35	4	2	localIOException1	IOException
    //   40	19	2	localObject2	Object
    //   63	1	2	localIOException2	IOException
    //   4	23	3	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   7	23	35	java/io/IOException
    //   25	30	40	finally
    //   38	40	40	finally
    //   30	34	51	java/lang/Exception
    //   45	49	53	java/lang/Exception
    //   7	23	57	finally
    //   25	30	63	java/io/IOException
  }
  
  private static final byte[] c(int paramInt)
  {
    if ((paramInt & 0x10) == 16) {
      return e;
    }
    if ((paramInt & 0x20) == 32) {
      return g;
    }
    return c;
  }
  
  /* Error */
  public static byte[] c(String paramString)
    throws IOException
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aconst_null
    //   3: astore 5
    //   5: aconst_null
    //   6: astore 4
    //   8: aload 5
    //   10: astore_3
    //   11: new 410	java/io/File
    //   14: dup
    //   15: aload_0
    //   16: invokespecial 411	java/io/File:<init>	(Ljava/lang/String;)V
    //   19: astore_0
    //   20: aload 5
    //   22: astore_3
    //   23: aload_0
    //   24: invokevirtual 415	java/io/File:length	()J
    //   27: ldc2_w 416
    //   30: lcmp
    //   31: ifle +56 -> 87
    //   34: aload 5
    //   36: astore_3
    //   37: new 171	java/io/IOException
    //   40: dup
    //   41: new 376	java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial 377	java/lang/StringBuilder:<init>	()V
    //   48: ldc_w 419
    //   51: invokevirtual 383	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: aload_0
    //   55: invokevirtual 415	java/io/File:length	()J
    //   58: invokevirtual 422	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   61: ldc_w 424
    //   64: invokevirtual 383	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: invokevirtual 386	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: invokespecial 425	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   73: athrow
    //   74: astore_0
    //   75: aload 4
    //   77: astore_3
    //   78: aload_0
    //   79: athrow
    //   80: astore_0
    //   81: aload_3
    //   82: invokevirtual 426	c/a/b/b/a$a:close	()V
    //   85: aload_0
    //   86: athrow
    //   87: aload 5
    //   89: astore_3
    //   90: aload_0
    //   91: invokevirtual 415	java/io/File:length	()J
    //   94: l2i
    //   95: newarray <illegal type>
    //   97: astore 6
    //   99: aload 5
    //   101: astore_3
    //   102: new 8	c/a/b/b/a$a
    //   105: dup
    //   106: new 428	java/io/BufferedInputStream
    //   109: dup
    //   110: new 430	java/io/FileInputStream
    //   113: dup
    //   114: aload_0
    //   115: invokespecial 433	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   118: invokespecial 434	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   121: iconst_0
    //   122: invokespecial 437	c/a/b/b/a$a:<init>	(Ljava/io/InputStream;I)V
    //   125: astore_0
    //   126: aload_0
    //   127: aload 6
    //   129: iload_1
    //   130: sipush 4096
    //   133: invokevirtual 440	c/a/b/b/a$a:read	([BII)I
    //   136: istore_2
    //   137: iload_2
    //   138: iflt +10 -> 148
    //   141: iload_1
    //   142: iload_2
    //   143: iadd
    //   144: istore_1
    //   145: goto -19 -> 126
    //   148: iload_1
    //   149: newarray <illegal type>
    //   151: astore_3
    //   152: aload 6
    //   154: iconst_0
    //   155: aload_3
    //   156: iconst_0
    //   157: iload_1
    //   158: invokestatic 404	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   161: aload_0
    //   162: invokevirtual 426	c/a/b/b/a$a:close	()V
    //   165: aload_3
    //   166: areturn
    //   167: astore_0
    //   168: aload_3
    //   169: areturn
    //   170: astore_3
    //   171: goto -86 -> 85
    //   174: astore 4
    //   176: aload_0
    //   177: astore_3
    //   178: aload 4
    //   180: astore_0
    //   181: goto -100 -> 81
    //   184: astore 4
    //   186: aload_0
    //   187: astore_3
    //   188: aload 4
    //   190: astore_0
    //   191: goto -113 -> 78
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	194	0	paramString	String
    //   1	157	1	i	int
    //   136	8	2	j	int
    //   10	159	3	localObject1	Object
    //   170	1	3	localException	Exception
    //   177	11	3	str	String
    //   6	70	4	localObject2	Object
    //   174	5	4	localObject3	Object
    //   184	5	4	localIOException	IOException
    //   3	97	5	localObject4	Object
    //   97	56	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   11	20	74	java/io/IOException
    //   23	34	74	java/io/IOException
    //   37	74	74	java/io/IOException
    //   90	99	74	java/io/IOException
    //   102	126	74	java/io/IOException
    //   11	20	80	finally
    //   23	34	80	finally
    //   37	74	80	finally
    //   78	80	80	finally
    //   90	99	80	finally
    //   102	126	80	finally
    //   161	165	167	java/lang/Exception
    //   81	85	170	java/lang/Exception
    //   126	137	174	finally
    //   148	161	174	finally
    //   126	137	184	java/io/IOException
    //   148	161	184	java/io/IOException
  }
  
  public static byte[] c(byte[] paramArrayOfByte)
    throws IOException
  {
    return c(paramArrayOfByte, 0, paramArrayOfByte.length, 0);
  }
  
  public static byte[] c(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
    throws IOException
  {
    if (paramArrayOfByte == null) {
      throw new NullPointerException("Cannot decode null source array.");
    }
    if ((paramInt1 < 0) || (paramInt1 + paramInt2 > paramArrayOfByte.length)) {
      throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and process %d bytes.", new Object[] { Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    }
    if (paramInt2 == 0) {
      return new byte[0];
    }
    if (paramInt2 < 4) {
      throw new IllegalArgumentException("Base64-encoded string must have at least four characters, but length specified was " + paramInt2);
    }
    byte[] arrayOfByte2 = c(paramInt3);
    byte[] arrayOfByte1 = new byte[paramInt2 * 3 / 4];
    byte[] arrayOfByte3 = new byte[4];
    int k = paramInt1;
    int j = 0;
    int i = 0;
    int m;
    if (k < paramInt1 + paramInt2)
    {
      m = arrayOfByte2[(paramArrayOfByte[k] & 0xFF)];
      if (m >= -5)
      {
        if (m < -1) {
          break label313;
        }
        m = j + 1;
        arrayOfByte3[j] = paramArrayOfByte[k];
        if (m <= 3) {
          break label302;
        }
        j = b(arrayOfByte3, 0, arrayOfByte1, i, paramInt3) + i;
        if (paramArrayOfByte[k] != 61) {
          break label274;
        }
      }
    }
    for (;;)
    {
      paramArrayOfByte = new byte[j];
      System.arraycopy(arrayOfByte1, 0, paramArrayOfByte, 0, j);
      return paramArrayOfByte;
      throw new IOException(String.format("Bad Base64 input character decimal %d in array position %d", new Object[] { Integer.valueOf(paramArrayOfByte[k] & 0xFF), Integer.valueOf(k) }));
      label274:
      i = 0;
      for (;;)
      {
        m = k + 1;
        k = j;
        j = i;
        i = k;
        k = m;
        break;
        label302:
        j = i;
        i = m;
        continue;
        label313:
        m = i;
        i = j;
        j = m;
      }
      j = i;
    }
  }
  
  /* Error */
  public static String d(String paramString)
    throws IOException
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aconst_null
    //   3: astore 4
    //   5: new 410	java/io/File
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 411	java/io/File:<init>	(Ljava/lang/String;)V
    //   13: astore_0
    //   14: aload_0
    //   15: invokevirtual 415	java/io/File:length	()J
    //   18: l2d
    //   19: ldc2_w 449
    //   22: dmul
    //   23: dconst_1
    //   24: dadd
    //   25: d2i
    //   26: bipush 40
    //   28: invokestatic 453	java/lang/Math:max	(II)I
    //   31: newarray <illegal type>
    //   33: astore 5
    //   35: new 8	c/a/b/b/a$a
    //   38: dup
    //   39: new 428	java/io/BufferedInputStream
    //   42: dup
    //   43: new 430	java/io/FileInputStream
    //   46: dup
    //   47: aload_0
    //   48: invokespecial 433	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   51: invokespecial 434	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   54: iconst_1
    //   55: invokespecial 437	c/a/b/b/a$a:<init>	(Ljava/io/InputStream;I)V
    //   58: astore_3
    //   59: aload_3
    //   60: astore_0
    //   61: aload_3
    //   62: aload 5
    //   64: iload_1
    //   65: sipush 4096
    //   68: invokevirtual 440	c/a/b/b/a$a:read	([BII)I
    //   71: istore_2
    //   72: iload_2
    //   73: iflt +10 -> 83
    //   76: iload_1
    //   77: iload_2
    //   78: iadd
    //   79: istore_1
    //   80: goto -21 -> 59
    //   83: aload_3
    //   84: astore_0
    //   85: new 239	java/lang/String
    //   88: dup
    //   89: aload 5
    //   91: iconst_0
    //   92: iload_1
    //   93: ldc -11
    //   95: invokespecial 456	java/lang/String:<init>	([BIILjava/lang/String;)V
    //   98: astore 4
    //   100: aload_3
    //   101: invokevirtual 426	c/a/b/b/a$a:close	()V
    //   104: aload 4
    //   106: areturn
    //   107: astore 4
    //   109: aconst_null
    //   110: astore_0
    //   111: aload 4
    //   113: athrow
    //   114: astore 4
    //   116: aload_0
    //   117: astore_3
    //   118: aload 4
    //   120: astore_0
    //   121: aload_3
    //   122: invokevirtual 426	c/a/b/b/a$a:close	()V
    //   125: aload_0
    //   126: athrow
    //   127: astore_0
    //   128: aload 4
    //   130: areturn
    //   131: astore_3
    //   132: goto -7 -> 125
    //   135: astore_0
    //   136: aload 4
    //   138: astore_3
    //   139: goto -18 -> 121
    //   142: astore 4
    //   144: aload_3
    //   145: astore_0
    //   146: goto -35 -> 111
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	149	0	paramString	String
    //   1	92	1	i	int
    //   71	8	2	j	int
    //   58	64	3	localObject	Object
    //   131	1	3	localException	Exception
    //   138	7	3	str1	String
    //   3	102	4	str2	String
    //   107	5	4	localIOException1	IOException
    //   114	23	4	str3	String
    //   142	1	4	localIOException2	IOException
    //   33	57	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   5	59	107	java/io/IOException
    //   61	72	114	finally
    //   85	100	114	finally
    //   111	114	114	finally
    //   100	104	127	java/lang/Exception
    //   121	125	131	java/lang/Exception
    //   5	59	135	finally
    //   61	72	142	java/io/IOException
    //   85	100	142	java/io/IOException
  }
  
  public static class a
    extends FilterInputStream
  {
    private boolean a;
    private int b;
    private byte[] c;
    private int d;
    private int e;
    private int f;
    private boolean g;
    private int h;
    private byte[] i;
    
    public a(InputStream paramInputStream)
    {
      this(paramInputStream, 0);
    }
    
    public a(InputStream paramInputStream, int paramInt)
    {
      super();
      this.h = paramInt;
      boolean bool1;
      if ((paramInt & 0x8) > 0)
      {
        bool1 = true;
        this.g = bool1;
        if ((paramInt & 0x1) <= 0) {
          break label94;
        }
        bool1 = bool2;
        label39:
        this.a = bool1;
        if (!this.a) {
          break label100;
        }
      }
      label94:
      label100:
      for (int j = 4;; j = 3)
      {
        this.d = j;
        this.c = new byte[this.d];
        this.b = -1;
        this.f = 0;
        this.i = a.a(paramInt);
        return;
        bool1 = false;
        break;
        bool1 = false;
        break label39;
      }
    }
    
    public int read()
      throws IOException
    {
      int k;
      if (this.b < 0)
      {
        if (!this.a) {
          break label110;
        }
        arrayOfByte = new byte[3];
        k = 0;
        j = 0;
        while (k < 3)
        {
          int m = this.in.read();
          if (m < 0) {
            break;
          }
          arrayOfByte[k] = ((byte)m);
          k += 1;
          j += 1;
        }
        if (j > 0)
        {
          a.a(arrayOfByte, 0, j, this.c, 0, this.h);
          this.b = 0;
          this.e = 4;
        }
      }
      else
      {
        if (this.b < 0) {
          break label299;
        }
        if (this.b < this.e) {
          break label213;
        }
        return -1;
      }
      return -1;
      label110:
      byte[] arrayOfByte = new byte[4];
      int j = 0;
      for (;;)
      {
        if (j < 4)
        {
          do
          {
            k = this.in.read();
          } while ((k >= 0) && (this.i[(k & 0x7F)] <= -5));
          if (k >= 0) {}
        }
        else
        {
          if (j != 4) {
            break label197;
          }
          this.e = a.a(arrayOfByte, 0, this.c, 0, this.h);
          this.b = 0;
          break;
        }
        arrayOfByte[j] = ((byte)k);
        j += 1;
      }
      label197:
      if (j == 0) {
        return -1;
      }
      throw new IOException("Improperly padded Base64 input.");
      label213:
      if ((this.a) && (this.g) && (this.f >= 76))
      {
        this.f = 0;
        return 10;
      }
      this.f += 1;
      arrayOfByte = this.c;
      j = this.b;
      this.b = (j + 1);
      j = arrayOfByte[j];
      if (this.b >= this.d) {
        this.b = -1;
      }
      return j & 0xFF;
      label299:
      throw new IOException("Error in Base64 code reading stream.");
    }
    
    public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      int j = 0;
      for (;;)
      {
        k = j;
        if (j >= paramInt2) {
          break label54;
        }
        k = read();
        if (k < 0) {
          break;
        }
        paramArrayOfByte[(paramInt1 + j)] = ((byte)k);
        j += 1;
      }
      int k = j;
      if (j == 0) {
        k = -1;
      }
      label54:
      return k;
    }
  }
  
  public static class b
    extends FilterOutputStream
  {
    private boolean a;
    private int b;
    private byte[] c;
    private int d;
    private int e;
    private boolean f;
    private byte[] g;
    private boolean h;
    private int i;
    private byte[] j;
    
    public b(OutputStream paramOutputStream)
    {
      this(paramOutputStream, 1);
    }
    
    public b(OutputStream paramOutputStream, int paramInt)
    {
      super();
      boolean bool1;
      if ((paramInt & 0x8) != 0)
      {
        bool1 = true;
        this.f = bool1;
        if ((paramInt & 0x1) == 0) {
          break label106;
        }
        bool1 = bool2;
        label34:
        this.a = bool1;
        if (!this.a) {
          break label112;
        }
      }
      label106:
      label112:
      for (int k = 3;; k = 4)
      {
        this.d = k;
        this.c = new byte[this.d];
        this.b = 0;
        this.e = 0;
        this.h = false;
        this.g = new byte[4];
        this.i = paramInt;
        this.j = a.a(paramInt);
        return;
        bool1 = false;
        break;
        bool1 = false;
        break label34;
      }
    }
    
    public void a()
      throws IOException
    {
      if (this.b > 0)
      {
        if (this.a)
        {
          this.out.write(a.a(this.g, this.c, this.b, this.i));
          this.b = 0;
        }
      }
      else {
        return;
      }
      throw new IOException("Base64 input not properly padded.");
    }
    
    public void b()
      throws IOException
    {
      a();
      this.h = true;
    }
    
    public void c()
    {
      this.h = false;
    }
    
    public void close()
      throws IOException
    {
      a();
      super.close();
      this.c = null;
      this.out = null;
    }
    
    public void write(int paramInt)
      throws IOException
    {
      if (this.h) {
        this.out.write(paramInt);
      }
      do
      {
        do
        {
          do
          {
            return;
            if (!this.a) {
              break;
            }
            arrayOfByte = this.c;
            k = this.b;
            this.b = (k + 1);
            arrayOfByte[k] = ((byte)paramInt);
          } while (this.b < this.d);
          this.out.write(a.a(this.g, this.c, this.d, this.i));
          this.e += 4;
          if ((this.f) && (this.e >= 76))
          {
            this.out.write(10);
            this.e = 0;
          }
          this.b = 0;
          return;
          if (this.j[(paramInt & 0x7F)] <= -5) {
            break;
          }
          byte[] arrayOfByte = this.c;
          int k = this.b;
          this.b = (k + 1);
          arrayOfByte[k] = ((byte)paramInt);
        } while (this.b < this.d);
        paramInt = a.a(this.c, 0, this.g, 0, this.i);
        this.out.write(this.g, 0, paramInt);
        this.b = 0;
        return;
      } while (this.j[(paramInt & 0x7F)] == -5);
      throw new IOException("Invalid character in Base64 data.");
    }
    
    public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      if (this.h) {
        this.out.write(paramArrayOfByte, paramInt1, paramInt2);
      }
      for (;;)
      {
        return;
        int k = 0;
        while (k < paramInt2)
        {
          write(paramArrayOfByte[(paramInt1 + k)]);
          k += 1;
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/c/a/b/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */