package com.pgyersdk.i;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.pgyersdk.d.c;
import java.nio.IntBuffer;
import javax.microedition.khronos.opengles.GL10;

public class a
{
  private static String a = "GLSurfaceUtils";
  private static a b = null;
  private static c f;
  private boolean c = false;
  private Context d;
  private int e = 0;
  
  private int a(Bitmap paramBitmap)
  {
    if (Build.VERSION.SDK_INT < 12) {
      return paramBitmap.getRowBytes() * paramBitmap.getHeight();
    }
    return paramBitmap.getByteCount();
  }
  
  private Bitmap a(int paramInt1, int paramInt2, GL10 paramGL10)
  {
    int[] arrayOfInt1 = new int[paramInt1 * paramInt2];
    int[] arrayOfInt2 = new int[paramInt1 * paramInt2];
    IntBuffer localIntBuffer = IntBuffer.wrap(arrayOfInt1);
    localIntBuffer.position(0);
    paramGL10.glReadPixels(0, 0, paramInt1, paramInt2, 6408, 5121, localIntBuffer);
    int i = 0;
    int j = 0;
    while (j < paramInt2)
    {
      int k = 0;
      while (k < paramInt1)
      {
        int m = arrayOfInt1[(j * paramInt1 + k)];
        arrayOfInt2[((paramInt2 - i - 1) * paramInt1 + k)] = (m & 0xFF00FF00 | m << 16 & 0xFFFF0000 | m >> 16 & 0xFF);
        k += 1;
      }
      j += 1;
      i += 1;
    }
    return Bitmap.createBitmap(arrayOfInt2, paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
  }
  
  public static DisplayMetrics getDisplayMetrics(Context paramContext)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
    return localDisplayMetrics;
  }
  
  public static a getInstance()
  {
    if (b == null) {
      b = new a();
    }
    return b;
  }
  
  public static void setIScreenShotListener(c paramc)
  {
    f = paramc;
  }
  
  public void destroy()
  {
    b = null;
  }
  
  public void setContext(Context paramContext)
  {
    this.d = paramContext;
  }
  
  public void setScreenShot(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  /* Error */
  public String takeScreenShot(GL10 paramGL10)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: getfield 30	com/pgyersdk/i/a:c	Z
    //   6: ifne +5 -> 11
    //   9: aconst_null
    //   10: areturn
    //   11: aload_0
    //   12: iconst_0
    //   13: putfield 30	com/pgyersdk/i/a:c	Z
    //   16: aload_0
    //   17: getfield 116	com/pgyersdk/i/a:d	Landroid/content/Context;
    //   20: ifnull -11 -> 9
    //   23: invokestatic 131	com/pgyersdk/i/d:a	()Lcom/pgyersdk/i/d;
    //   26: aload_0
    //   27: getfield 116	com/pgyersdk/i/a:d	Landroid/content/Context;
    //   30: invokevirtual 134	com/pgyersdk/i/d:a	(Landroid/content/Context;)Ljava/lang/String;
    //   33: astore 5
    //   35: aload_0
    //   36: getfield 116	com/pgyersdk/i/a:d	Landroid/content/Context;
    //   39: invokestatic 136	com/pgyersdk/i/a:getDisplayMetrics	(Landroid/content/Context;)Landroid/util/DisplayMetrics;
    //   42: astore 4
    //   44: aload_0
    //   45: aload 4
    //   47: getfield 139	android/util/DisplayMetrics:widthPixels	I
    //   50: aload 4
    //   52: getfield 142	android/util/DisplayMetrics:heightPixels	I
    //   55: aload_1
    //   56: invokespecial 144	com/pgyersdk/i/a:a	(IILjavax/microedition/khronos/opengles/GL10;)Landroid/graphics/Bitmap;
    //   59: astore 6
    //   61: aload_0
    //   62: aload 6
    //   64: invokespecial 146	com/pgyersdk/i/a:a	(Landroid/graphics/Bitmap;)I
    //   67: istore_2
    //   68: getstatic 22	com/pgyersdk/i/a:a	Ljava/lang/String;
    //   71: new 148	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   78: iload_2
    //   79: invokevirtual 153	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   82: ldc -101
    //   84: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: invokestatic 168	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   93: pop
    //   94: iload_2
    //   95: sipush 20000
    //   98: if_icmpge +27 -> 125
    //   101: aload_0
    //   102: getfield 32	com/pgyersdk/i/a:e	I
    //   105: istore_2
    //   106: aload_0
    //   107: iload_2
    //   108: iconst_1
    //   109: iadd
    //   110: putfield 32	com/pgyersdk/i/a:e	I
    //   113: iload_2
    //   114: iconst_5
    //   115: if_icmpge -106 -> 9
    //   118: aload_0
    //   119: iconst_1
    //   120: putfield 30	com/pgyersdk/i/a:c	Z
    //   123: aconst_null
    //   124: areturn
    //   125: new 170	java/io/File
    //   128: dup
    //   129: aload 5
    //   131: invokespecial 173	java/io/File:<init>	(Ljava/lang/String;)V
    //   134: astore_1
    //   135: new 175	java/io/FileOutputStream
    //   138: dup
    //   139: aload_1
    //   140: invokespecial 178	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   143: astore_1
    //   144: aload_1
    //   145: astore_3
    //   146: aload 6
    //   148: getstatic 184	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   151: bipush 100
    //   153: aload_1
    //   154: invokevirtual 188	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   157: pop
    //   158: aload_1
    //   159: astore_3
    //   160: aload_1
    //   161: invokevirtual 191	java/io/FileOutputStream:flush	()V
    //   164: aload_1
    //   165: astore_3
    //   166: getstatic 22	com/pgyersdk/i/a:a	Ljava/lang/String;
    //   169: ldc -63
    //   171: invokestatic 168	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   174: pop
    //   175: aload_1
    //   176: astore_3
    //   177: getstatic 111	com/pgyersdk/i/a:f	Lcom/pgyersdk/d/c;
    //   180: ifnull +41 -> 221
    //   183: aload_1
    //   184: astore_3
    //   185: getstatic 111	com/pgyersdk/i/a:f	Lcom/pgyersdk/d/c;
    //   188: aload 5
    //   190: invokeinterface 197 2 0
    //   195: aload_1
    //   196: invokevirtual 200	java/io/FileOutputStream:close	()V
    //   199: aload 6
    //   201: invokevirtual 203	android/graphics/Bitmap:recycle	()V
    //   204: aload_0
    //   205: iconst_0
    //   206: putfield 32	com/pgyersdk/i/a:e	I
    //   209: getstatic 22	com/pgyersdk/i/a:a	Ljava/lang/String;
    //   212: aload 5
    //   214: invokestatic 168	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   217: pop
    //   218: aload 5
    //   220: areturn
    //   221: aload_1
    //   222: astore_3
    //   223: invokestatic 208	com/pgyersdk/d/a:getInstance	()Lcom/pgyersdk/d/a;
    //   226: getfield 211	com/pgyersdk/d/a:a	Lcom/pgyersdk/d/b;
    //   229: ifnull +25 -> 254
    //   232: aload_1
    //   233: astore_3
    //   234: invokestatic 208	com/pgyersdk/d/a:getInstance	()Lcom/pgyersdk/d/a;
    //   237: getfield 211	com/pgyersdk/d/a:a	Lcom/pgyersdk/d/b;
    //   240: invokeinterface 215 1 0
    //   245: aload_1
    //   246: astore_3
    //   247: invokestatic 208	com/pgyersdk/d/a:getInstance	()Lcom/pgyersdk/d/a;
    //   250: aconst_null
    //   251: putfield 211	com/pgyersdk/d/a:a	Lcom/pgyersdk/d/b;
    //   254: aload_1
    //   255: astore_3
    //   256: new 217	android/content/Intent
    //   259: dup
    //   260: aload_0
    //   261: getfield 116	com/pgyersdk/i/a:d	Landroid/content/Context;
    //   264: ldc -37
    //   266: invokespecial 222	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   269: astore 4
    //   271: aload_1
    //   272: astore_3
    //   273: aload 4
    //   275: ldc -33
    //   277: invokevirtual 227	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   280: pop
    //   281: aload_1
    //   282: astore_3
    //   283: aload 4
    //   285: ldc -27
    //   287: aload 5
    //   289: invokevirtual 233	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   292: pop
    //   293: aload_1
    //   294: astore_3
    //   295: aload 4
    //   297: ldc -21
    //   299: iconst_1
    //   300: invokevirtual 238	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   303: pop
    //   304: aload_1
    //   305: astore_3
    //   306: aload_0
    //   307: getfield 116	com/pgyersdk/i/a:d	Landroid/content/Context;
    //   310: aload 4
    //   312: invokevirtual 242	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   315: goto -120 -> 195
    //   318: astore_3
    //   319: getstatic 22	com/pgyersdk/i/a:a	Ljava/lang/String;
    //   322: ldc -12
    //   324: invokestatic 168	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   327: pop
    //   328: aload_1
    //   329: invokevirtual 200	java/io/FileOutputStream:close	()V
    //   332: aload 6
    //   334: invokevirtual 203	android/graphics/Bitmap:recycle	()V
    //   337: aload_0
    //   338: iconst_0
    //   339: putfield 32	com/pgyersdk/i/a:e	I
    //   342: goto -133 -> 209
    //   345: astore_1
    //   346: aconst_null
    //   347: astore_1
    //   348: aload_1
    //   349: astore_3
    //   350: getstatic 22	com/pgyersdk/i/a:a	Ljava/lang/String;
    //   353: ldc -10
    //   355: invokestatic 168	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   358: pop
    //   359: aload_1
    //   360: invokevirtual 200	java/io/FileOutputStream:close	()V
    //   363: aload 6
    //   365: invokevirtual 203	android/graphics/Bitmap:recycle	()V
    //   368: aload_0
    //   369: iconst_0
    //   370: putfield 32	com/pgyersdk/i/a:e	I
    //   373: goto -164 -> 209
    //   376: astore 4
    //   378: aconst_null
    //   379: astore_1
    //   380: aload_1
    //   381: astore_3
    //   382: getstatic 22	com/pgyersdk/i/a:a	Ljava/lang/String;
    //   385: new 148	java/lang/StringBuilder
    //   388: dup
    //   389: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   392: ldc -8
    //   394: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: aload 4
    //   399: invokevirtual 251	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   402: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   408: invokestatic 168	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   411: pop
    //   412: aload_1
    //   413: invokevirtual 200	java/io/FileOutputStream:close	()V
    //   416: aload 6
    //   418: invokevirtual 203	android/graphics/Bitmap:recycle	()V
    //   421: aload_0
    //   422: iconst_0
    //   423: putfield 32	com/pgyersdk/i/a:e	I
    //   426: goto -217 -> 209
    //   429: astore_1
    //   430: aconst_null
    //   431: astore_3
    //   432: aload_3
    //   433: invokevirtual 200	java/io/FileOutputStream:close	()V
    //   436: aload 6
    //   438: invokevirtual 203	android/graphics/Bitmap:recycle	()V
    //   441: aload_0
    //   442: iconst_0
    //   443: putfield 32	com/pgyersdk/i/a:e	I
    //   446: aload_1
    //   447: athrow
    //   448: astore_3
    //   449: goto -8 -> 441
    //   452: astore_3
    //   453: goto -12 -> 441
    //   456: astore_1
    //   457: goto -25 -> 432
    //   460: astore 4
    //   462: aload_1
    //   463: astore_3
    //   464: aload 4
    //   466: astore_1
    //   467: goto -35 -> 432
    //   470: astore_1
    //   471: goto -50 -> 421
    //   474: astore_1
    //   475: goto -54 -> 421
    //   478: astore 4
    //   480: goto -100 -> 380
    //   483: astore_1
    //   484: goto -116 -> 368
    //   487: astore_1
    //   488: goto -120 -> 368
    //   491: astore_3
    //   492: goto -144 -> 348
    //   495: astore_1
    //   496: goto -159 -> 337
    //   499: astore_1
    //   500: goto -163 -> 337
    //   503: astore_1
    //   504: aload_3
    //   505: astore_1
    //   506: goto -187 -> 319
    //   509: astore_1
    //   510: goto -306 -> 204
    //   513: astore_1
    //   514: goto -310 -> 204
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	517	0	this	a
    //   0	517	1	paramGL10	GL10
    //   67	49	2	i	int
    //   1	305	3	localGL101	GL10
    //   318	1	3	localFileNotFoundException	java.io.FileNotFoundException
    //   349	84	3	localGL102	GL10
    //   448	1	3	localException1	Exception
    //   452	1	3	localIOException1	java.io.IOException
    //   463	1	3	localGL103	GL10
    //   491	14	3	localIOException2	java.io.IOException
    //   42	269	4	localObject1	Object
    //   376	22	4	localException2	Exception
    //   460	5	4	localObject2	Object
    //   478	1	4	localException3	Exception
    //   33	255	5	str	String
    //   59	378	6	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   146	158	318	java/io/FileNotFoundException
    //   160	164	318	java/io/FileNotFoundException
    //   166	175	318	java/io/FileNotFoundException
    //   177	183	318	java/io/FileNotFoundException
    //   185	195	318	java/io/FileNotFoundException
    //   223	232	318	java/io/FileNotFoundException
    //   234	245	318	java/io/FileNotFoundException
    //   247	254	318	java/io/FileNotFoundException
    //   256	271	318	java/io/FileNotFoundException
    //   273	281	318	java/io/FileNotFoundException
    //   283	293	318	java/io/FileNotFoundException
    //   295	304	318	java/io/FileNotFoundException
    //   306	315	318	java/io/FileNotFoundException
    //   135	144	345	java/io/IOException
    //   135	144	376	java/lang/Exception
    //   135	144	429	finally
    //   432	441	448	java/lang/Exception
    //   432	441	452	java/io/IOException
    //   146	158	456	finally
    //   160	164	456	finally
    //   166	175	456	finally
    //   177	183	456	finally
    //   185	195	456	finally
    //   223	232	456	finally
    //   234	245	456	finally
    //   247	254	456	finally
    //   256	271	456	finally
    //   273	281	456	finally
    //   283	293	456	finally
    //   295	304	456	finally
    //   306	315	456	finally
    //   350	359	456	finally
    //   382	412	456	finally
    //   319	328	460	finally
    //   412	421	470	java/lang/Exception
    //   412	421	474	java/io/IOException
    //   146	158	478	java/lang/Exception
    //   160	164	478	java/lang/Exception
    //   166	175	478	java/lang/Exception
    //   177	183	478	java/lang/Exception
    //   185	195	478	java/lang/Exception
    //   223	232	478	java/lang/Exception
    //   234	245	478	java/lang/Exception
    //   247	254	478	java/lang/Exception
    //   256	271	478	java/lang/Exception
    //   273	281	478	java/lang/Exception
    //   283	293	478	java/lang/Exception
    //   295	304	478	java/lang/Exception
    //   306	315	478	java/lang/Exception
    //   359	368	483	java/lang/Exception
    //   359	368	487	java/io/IOException
    //   146	158	491	java/io/IOException
    //   160	164	491	java/io/IOException
    //   166	175	491	java/io/IOException
    //   177	183	491	java/io/IOException
    //   185	195	491	java/io/IOException
    //   223	232	491	java/io/IOException
    //   234	245	491	java/io/IOException
    //   247	254	491	java/io/IOException
    //   256	271	491	java/io/IOException
    //   273	281	491	java/io/IOException
    //   283	293	491	java/io/IOException
    //   295	304	491	java/io/IOException
    //   306	315	491	java/io/IOException
    //   328	337	495	java/lang/Exception
    //   328	337	499	java/io/IOException
    //   135	144	503	java/io/FileNotFoundException
    //   195	204	509	java/lang/Exception
    //   195	204	513	java/io/IOException
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/pgyersdk/i/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */