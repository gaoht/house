package com.xiaomi.push.service;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.util.DisplayMetrics;
import com.maa.android.agent.instrumentation.Instrumented;
import com.xiaomi.channel.commonutils.logger.b;
import java.io.InputStream;

@Instrumented
public class ag
{
  private static int a(Context paramContext, InputStream paramInputStream)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeStream(paramInputStream, null, localOptions);
    if ((localOptions.outWidth == -1) || (localOptions.outHeight == -1)) {
      b.a("decode dimension failed for bitmap.");
    }
    int i;
    do
    {
      return 1;
      i = Math.round(paramContext.getResources().getDisplayMetrics().densityDpi / 160.0F * 48.0F);
    } while ((localOptions.outWidth <= i) || (localOptions.outHeight <= i));
    return Math.min(localOptions.outWidth / i, localOptions.outHeight / i);
  }
  
  /* Error */
  private static a a(String paramString)
  {
    // Byte code:
    //   0: ldc 76
    //   2: istore_1
    //   3: aconst_null
    //   4: astore 4
    //   6: new 78	java/net/URL
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 80	java/net/URL:<init>	(Ljava/lang/String;)V
    //   14: astore_3
    //   15: aload_3
    //   16: instanceof 78
    //   19: ifne +87 -> 106
    //   22: aload_3
    //   23: invokevirtual 84	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   26: astore_3
    //   27: aload_3
    //   28: checkcast 86	java/net/HttpURLConnection
    //   31: astore_3
    //   32: aload_3
    //   33: sipush 8000
    //   36: invokevirtual 90	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   39: aload_3
    //   40: sipush 20000
    //   43: invokevirtual 93	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   46: aload_3
    //   47: invokevirtual 96	java/net/HttpURLConnection:connect	()V
    //   50: aload_3
    //   51: invokevirtual 100	java/net/HttpURLConnection:getContentLength	()I
    //   54: istore_2
    //   55: iload_2
    //   56: ldc 76
    //   58: if_icmple +59 -> 117
    //   61: new 102	java/lang/StringBuilder
    //   64: dup
    //   65: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   68: ldc 105
    //   70: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: iload_2
    //   74: invokevirtual 112	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   77: ldc 114
    //   79: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: aload_0
    //   83: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: invokestatic 42	com/xiaomi/channel/commonutils/logger/b:a	(Ljava/lang/String;)V
    //   92: aconst_null
    //   93: invokestatic 123	com/xiaomi/channel/commonutils/file/a:a	(Ljava/io/InputStream;)V
    //   96: aload_3
    //   97: ifnull +7 -> 104
    //   100: aload_3
    //   101: invokevirtual 126	java/net/HttpURLConnection:disconnect	()V
    //   104: aconst_null
    //   105: areturn
    //   106: aload_3
    //   107: checkcast 78	java/net/URL
    //   110: invokestatic 131	com/mato/sdk/instrumentation/HttpInstrumentation:openConnection	(Ljava/net/URL;)Ljava/net/URLConnection;
    //   113: astore_3
    //   114: goto -87 -> 27
    //   117: aload_3
    //   118: invokevirtual 134	java/net/HttpURLConnection:getResponseCode	()I
    //   121: istore_2
    //   122: iload_2
    //   123: sipush 200
    //   126: if_icmpeq +44 -> 170
    //   129: new 102	java/lang/StringBuilder
    //   132: dup
    //   133: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   136: ldc -120
    //   138: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: iload_2
    //   142: invokevirtual 112	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   145: ldc -118
    //   147: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: invokestatic 42	com/xiaomi/channel/commonutils/logger/b:a	(Ljava/lang/String;)V
    //   156: aconst_null
    //   157: invokestatic 123	com/xiaomi/channel/commonutils/file/a:a	(Ljava/io/InputStream;)V
    //   160: aload_3
    //   161: ifnull +7 -> 168
    //   164: aload_3
    //   165: invokevirtual 126	java/net/HttpURLConnection:disconnect	()V
    //   168: aconst_null
    //   169: areturn
    //   170: aload_3
    //   171: invokevirtual 142	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   174: astore_0
    //   175: new 144	java/io/ByteArrayOutputStream
    //   178: dup
    //   179: invokespecial 145	java/io/ByteArrayOutputStream:<init>	()V
    //   182: astore 4
    //   184: sipush 1024
    //   187: newarray <illegal type>
    //   189: astore 5
    //   191: iload_1
    //   192: ifle +19 -> 211
    //   195: aload_0
    //   196: aload 5
    //   198: iconst_0
    //   199: sipush 1024
    //   202: invokevirtual 151	java/io/InputStream:read	([BII)I
    //   205: istore_2
    //   206: iload_2
    //   207: iconst_m1
    //   208: if_icmpne +39 -> 247
    //   211: iload_1
    //   212: ifgt +72 -> 284
    //   215: ldc -103
    //   217: invokestatic 42	com/xiaomi/channel/commonutils/logger/b:a	(Ljava/lang/String;)V
    //   220: new 6	com/xiaomi/push/service/ag$a
    //   223: dup
    //   224: aconst_null
    //   225: ldc 76
    //   227: invokespecial 156	com/xiaomi/push/service/ag$a:<init>	([BI)V
    //   230: astore 4
    //   232: aload_0
    //   233: invokestatic 123	com/xiaomi/channel/commonutils/file/a:a	(Ljava/io/InputStream;)V
    //   236: aload_3
    //   237: ifnull +7 -> 244
    //   240: aload_3
    //   241: invokevirtual 126	java/net/HttpURLConnection:disconnect	()V
    //   244: aload 4
    //   246: areturn
    //   247: iload_1
    //   248: iload_2
    //   249: isub
    //   250: istore_1
    //   251: aload 4
    //   253: aload 5
    //   255: iconst_0
    //   256: iload_2
    //   257: invokevirtual 160	java/io/ByteArrayOutputStream:write	([BII)V
    //   260: goto -69 -> 191
    //   263: astore 4
    //   265: aload 4
    //   267: invokestatic 163	com/xiaomi/channel/commonutils/logger/b:a	(Ljava/lang/Throwable;)V
    //   270: aload_0
    //   271: invokestatic 123	com/xiaomi/channel/commonutils/file/a:a	(Ljava/io/InputStream;)V
    //   274: aload_3
    //   275: ifnull +7 -> 282
    //   278: aload_3
    //   279: invokevirtual 126	java/net/HttpURLConnection:disconnect	()V
    //   282: aconst_null
    //   283: areturn
    //   284: aload 4
    //   286: invokevirtual 167	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   289: astore 4
    //   291: new 6	com/xiaomi/push/service/ag$a
    //   294: dup
    //   295: aload 4
    //   297: aload 4
    //   299: arraylength
    //   300: invokespecial 156	com/xiaomi/push/service/ag$a:<init>	([BI)V
    //   303: astore 4
    //   305: aload_0
    //   306: invokestatic 123	com/xiaomi/channel/commonutils/file/a:a	(Ljava/io/InputStream;)V
    //   309: aload_3
    //   310: ifnull +7 -> 317
    //   313: aload_3
    //   314: invokevirtual 126	java/net/HttpURLConnection:disconnect	()V
    //   317: aload 4
    //   319: areturn
    //   320: astore_3
    //   321: aconst_null
    //   322: astore_0
    //   323: aload_0
    //   324: invokestatic 123	com/xiaomi/channel/commonutils/file/a:a	(Ljava/io/InputStream;)V
    //   327: aload 4
    //   329: ifnull +8 -> 337
    //   332: aload 4
    //   334: invokevirtual 126	java/net/HttpURLConnection:disconnect	()V
    //   337: aload_3
    //   338: athrow
    //   339: astore 5
    //   341: aconst_null
    //   342: astore_0
    //   343: aload_3
    //   344: astore 4
    //   346: aload 5
    //   348: astore_3
    //   349: goto -26 -> 323
    //   352: astore 5
    //   354: aload_3
    //   355: astore 4
    //   357: aload 5
    //   359: astore_3
    //   360: goto -37 -> 323
    //   363: astore 5
    //   365: aload_3
    //   366: astore 4
    //   368: aload 5
    //   370: astore_3
    //   371: goto -48 -> 323
    //   374: astore 4
    //   376: aconst_null
    //   377: astore_3
    //   378: aconst_null
    //   379: astore_0
    //   380: goto -115 -> 265
    //   383: astore 4
    //   385: aconst_null
    //   386: astore_0
    //   387: goto -122 -> 265
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	390	0	paramString	String
    //   2	249	1	i	int
    //   54	203	2	j	int
    //   14	300	3	localObject1	Object
    //   320	24	3	localObject2	Object
    //   348	30	3	localObject3	Object
    //   4	248	4	localObject4	Object
    //   263	22	4	localIOException1	java.io.IOException
    //   289	78	4	localObject5	Object
    //   374	1	4	localIOException2	java.io.IOException
    //   383	1	4	localIOException3	java.io.IOException
    //   189	65	5	arrayOfByte	byte[]
    //   339	8	5	localObject6	Object
    //   352	6	5	localObject7	Object
    //   363	6	5	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   175	191	263	java/io/IOException
    //   195	206	263	java/io/IOException
    //   215	232	263	java/io/IOException
    //   251	260	263	java/io/IOException
    //   284	305	263	java/io/IOException
    //   6	27	320	finally
    //   27	32	320	finally
    //   106	114	320	finally
    //   32	55	339	finally
    //   61	92	339	finally
    //   117	122	339	finally
    //   129	156	339	finally
    //   170	175	339	finally
    //   175	191	352	finally
    //   195	206	352	finally
    //   215	232	352	finally
    //   251	260	352	finally
    //   284	305	352	finally
    //   265	270	363	finally
    //   6	27	374	java/io/IOException
    //   27	32	374	java/io/IOException
    //   106	114	374	java/io/IOException
    //   32	55	383	java/io/IOException
    //   61	92	383	java/io/IOException
    //   117	122	383	java/io/IOException
    //   129	156	383	java/io/IOException
    //   170	175	383	java/io/IOException
  }
  
  /* Error */
  public static b a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: new 9	com/xiaomi/push/service/ag$b
    //   3: dup
    //   4: aconst_null
    //   5: lconst_0
    //   6: invokespecial 173	com/xiaomi/push/service/ag$b:<init>	(Landroid/graphics/Bitmap;J)V
    //   9: astore 5
    //   11: aload_1
    //   12: invokestatic 175	com/xiaomi/push/service/ag:a	(Ljava/lang/String;)Lcom/xiaomi/push/service/ag$a;
    //   15: astore_1
    //   16: aload_1
    //   17: ifnonnull +10 -> 27
    //   20: aconst_null
    //   21: invokestatic 123	com/xiaomi/channel/commonutils/file/a:a	(Ljava/io/InputStream;)V
    //   24: aload 5
    //   26: areturn
    //   27: aload 5
    //   29: aload_1
    //   30: getfield 177	com/xiaomi/push/service/ag$a:b	I
    //   33: i2l
    //   34: putfield 180	com/xiaomi/push/service/ag$b:b	J
    //   37: aload_1
    //   38: getfield 183	com/xiaomi/push/service/ag$a:a	[B
    //   41: astore 4
    //   43: aload 4
    //   45: ifnull +98 -> 143
    //   48: new 185	java/io/ByteArrayInputStream
    //   51: dup
    //   52: aload 4
    //   54: invokespecial 188	java/io/ByteArrayInputStream:<init>	([B)V
    //   57: astore_3
    //   58: aload_3
    //   59: astore_1
    //   60: aload_0
    //   61: aload_3
    //   62: invokestatic 190	com/xiaomi/push/service/ag:a	(Landroid/content/Context;Ljava/io/InputStream;)I
    //   65: istore_2
    //   66: aload_3
    //   67: astore_1
    //   68: new 14	android/graphics/BitmapFactory$Options
    //   71: dup
    //   72: invokespecial 18	android/graphics/BitmapFactory$Options:<init>	()V
    //   75: astore_0
    //   76: aload_3
    //   77: astore_1
    //   78: aload_0
    //   79: iload_2
    //   80: putfield 193	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   83: aload_3
    //   84: astore_1
    //   85: aload 5
    //   87: aload 4
    //   89: iconst_0
    //   90: aload 4
    //   92: arraylength
    //   93: aload_0
    //   94: invokestatic 197	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   97: putfield 200	com/xiaomi/push/service/ag$b:a	Landroid/graphics/Bitmap;
    //   100: aload_3
    //   101: astore_0
    //   102: aload_0
    //   103: invokestatic 123	com/xiaomi/channel/commonutils/file/a:a	(Ljava/io/InputStream;)V
    //   106: aload 5
    //   108: areturn
    //   109: astore 4
    //   111: aconst_null
    //   112: astore_0
    //   113: aload_0
    //   114: astore_1
    //   115: aload 4
    //   117: invokestatic 163	com/xiaomi/channel/commonutils/logger/b:a	(Ljava/lang/Throwable;)V
    //   120: goto -18 -> 102
    //   123: astore_0
    //   124: aload_1
    //   125: invokestatic 123	com/xiaomi/channel/commonutils/file/a:a	(Ljava/io/InputStream;)V
    //   128: aload_0
    //   129: athrow
    //   130: astore_0
    //   131: aconst_null
    //   132: astore_1
    //   133: goto -9 -> 124
    //   136: astore 4
    //   138: aload_3
    //   139: astore_0
    //   140: goto -27 -> 113
    //   143: aconst_null
    //   144: astore_0
    //   145: goto -43 -> 102
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	148	0	paramContext	Context
    //   0	148	1	paramString	String
    //   65	15	2	i	int
    //   57	82	3	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   41	50	4	arrayOfByte	byte[]
    //   109	7	4	localException1	Exception
    //   136	1	4	localException2	Exception
    //   9	98	5	localb	b
    // Exception table:
    //   from	to	target	type
    //   11	16	109	java/lang/Exception
    //   27	43	109	java/lang/Exception
    //   48	58	109	java/lang/Exception
    //   60	66	123	finally
    //   68	76	123	finally
    //   78	83	123	finally
    //   85	100	123	finally
    //   115	120	123	finally
    //   11	16	130	finally
    //   27	43	130	finally
    //   48	58	130	finally
    //   60	66	136	java/lang/Exception
    //   68	76	136	java/lang/Exception
    //   78	83	136	java/lang/Exception
    //   85	100	136	java/lang/Exception
  }
  
  /* Error */
  public static Bitmap b(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_1
    //   4: invokestatic 207	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   7: astore_3
    //   8: aload_0
    //   9: invokevirtual 211	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   12: aload_3
    //   13: invokevirtual 217	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   16: astore_1
    //   17: aload_0
    //   18: aload_1
    //   19: invokestatic 190	com/xiaomi/push/service/ag:a	(Landroid/content/Context;Ljava/io/InputStream;)I
    //   22: istore_2
    //   23: aload_0
    //   24: invokevirtual 211	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   27: aload_3
    //   28: invokevirtual 217	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   31: astore_0
    //   32: aload_1
    //   33: astore 4
    //   35: aload_0
    //   36: astore_3
    //   37: new 14	android/graphics/BitmapFactory$Options
    //   40: dup
    //   41: invokespecial 18	android/graphics/BitmapFactory$Options:<init>	()V
    //   44: astore 5
    //   46: aload_1
    //   47: astore 4
    //   49: aload_0
    //   50: astore_3
    //   51: aload 5
    //   53: iload_2
    //   54: putfield 193	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   57: aload_1
    //   58: astore 4
    //   60: aload_0
    //   61: astore_3
    //   62: aload_0
    //   63: aconst_null
    //   64: aload 5
    //   66: invokestatic 28	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   69: astore 5
    //   71: aload 5
    //   73: astore_3
    //   74: aload_0
    //   75: invokestatic 123	com/xiaomi/channel/commonutils/file/a:a	(Ljava/io/InputStream;)V
    //   78: aload_1
    //   79: invokestatic 123	com/xiaomi/channel/commonutils/file/a:a	(Ljava/io/InputStream;)V
    //   82: aload_3
    //   83: areturn
    //   84: astore 5
    //   86: aconst_null
    //   87: astore_1
    //   88: aconst_null
    //   89: astore_0
    //   90: aload_1
    //   91: astore 4
    //   93: aload_0
    //   94: astore_3
    //   95: aload 5
    //   97: invokestatic 163	com/xiaomi/channel/commonutils/logger/b:a	(Ljava/lang/Throwable;)V
    //   100: aload_0
    //   101: invokestatic 123	com/xiaomi/channel/commonutils/file/a:a	(Ljava/io/InputStream;)V
    //   104: aload 6
    //   106: astore_3
    //   107: goto -29 -> 78
    //   110: astore_0
    //   111: aconst_null
    //   112: astore_1
    //   113: aconst_null
    //   114: astore_3
    //   115: aload_3
    //   116: invokestatic 123	com/xiaomi/channel/commonutils/file/a:a	(Ljava/io/InputStream;)V
    //   119: aload_1
    //   120: invokestatic 123	com/xiaomi/channel/commonutils/file/a:a	(Ljava/io/InputStream;)V
    //   123: aload_0
    //   124: athrow
    //   125: astore_0
    //   126: aconst_null
    //   127: astore_3
    //   128: goto -13 -> 115
    //   131: astore_0
    //   132: aload 4
    //   134: astore_1
    //   135: goto -20 -> 115
    //   138: astore 5
    //   140: aconst_null
    //   141: astore_0
    //   142: goto -52 -> 90
    //   145: astore 5
    //   147: goto -57 -> 90
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	150	0	paramContext	Context
    //   0	150	1	paramString	String
    //   22	32	2	i	int
    //   7	121	3	localObject1	Object
    //   33	100	4	str	String
    //   44	28	5	localObject2	Object
    //   84	12	5	localIOException1	java.io.IOException
    //   138	1	5	localIOException2	java.io.IOException
    //   145	1	5	localIOException3	java.io.IOException
    //   1	104	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   8	17	84	java/io/IOException
    //   8	17	110	finally
    //   17	32	125	finally
    //   37	46	131	finally
    //   51	57	131	finally
    //   62	71	131	finally
    //   95	100	131	finally
    //   17	32	138	java/io/IOException
    //   37	46	145	java/io/IOException
    //   51	57	145	java/io/IOException
    //   62	71	145	java/io/IOException
  }
  
  public static class a
  {
    byte[] a;
    int b;
    
    public a(byte[] paramArrayOfByte, int paramInt)
    {
      this.a = paramArrayOfByte;
      this.b = paramInt;
    }
  }
  
  public static class b
  {
    public Bitmap a;
    public long b;
    
    public b(Bitmap paramBitmap, long paramLong)
    {
      this.a = paramBitmap;
      this.b = paramLong;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/push/service/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */