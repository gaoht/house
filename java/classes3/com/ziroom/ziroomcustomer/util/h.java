package com.ziroom.ziroomcustomer.util;

import android.content.ContentResolver;
import android.content.Context;
import android.content.CursorLoader;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.provider.MediaStore.Images.Media;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class h
{
  public static final String a = Environment.getExternalStorageDirectory().getAbsolutePath() + "/images";
  public static float b = 480.0F;
  public static float c = 800.0F;
  private static int d = 1;
  private static int e = 1048576;
  
  private static int a()
  {
    StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
    double d1 = localStatFs.getAvailableBlocks();
    return (int)(localStatFs.getBlockSize() * d1 / e);
  }
  
  private static int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    double d1 = paramOptions.outWidth;
    double d2 = paramOptions.outHeight;
    int i;
    int j;
    if (paramInt2 == -1)
    {
      i = 1;
      if (paramInt1 != -1) {
        break label60;
      }
      j = 128;
      label31:
      if (j >= i) {
        break label84;
      }
    }
    label60:
    label84:
    do
    {
      return i;
      i = (int)Math.ceil(Math.sqrt(d1 * d2 / paramInt2));
      break;
      j = (int)Math.min(Math.floor(d1 / paramInt1), Math.floor(d2 / paramInt1));
      break label31;
      if ((paramInt2 == -1) && (paramInt1 == -1)) {
        return 1;
      }
    } while (paramInt1 == -1);
    return j;
  }
  
  private static String a(Context paramContext, Uri paramUri)
  {
    Object localObject1 = null;
    Object localObject2 = android.provider.DocumentsContract.getDocumentId(paramUri).split(":")[1];
    paramUri = new String[1];
    paramUri[0] = "_data";
    localObject2 = paramContext.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, paramUri, "_id=?", new String[] { localObject2 }, null);
    int i = ((Cursor)localObject2).getColumnIndex(paramUri[0]);
    paramContext = (Context)localObject1;
    if (((Cursor)localObject2).moveToFirst()) {
      paramContext = ((Cursor)localObject2).getString(i);
    }
    ((Cursor)localObject2).close();
    return paramContext;
  }
  
  private static String b(Context paramContext, Uri paramUri)
  {
    Object localObject = null;
    String[] arrayOfString = new String[1];
    arrayOfString[0] = "_data";
    paramUri = new CursorLoader(paramContext, paramUri, arrayOfString, null, null, null).loadInBackground();
    paramContext = (Context)localObject;
    if (paramUri != null)
    {
      paramUri.moveToFirst();
      paramContext = paramUri.getString(paramUri.getColumnIndex(arrayOfString[0]));
      paramUri.close();
    }
    return paramContext;
  }
  
  private static String c(Context paramContext, Uri paramUri)
  {
    Object localObject = null;
    String[] arrayOfString = new String[1];
    arrayOfString[0] = "_data";
    paramUri = paramContext.getContentResolver().query(paramUri, arrayOfString, null, null, null);
    paramContext = (Context)localObject;
    if (paramUri != null)
    {
      paramUri.moveToFirst();
      paramContext = paramUri.getString(paramUri.getColumnIndex(arrayOfString[0]));
      paramUri.close();
    }
    return paramContext;
  }
  
  public static Bitmap compImgByQuality(String paramString)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    localOptions.inJustDecodeBounds = false;
    localOptions.inSampleSize = setSimpleSize(localOptions.outWidth, localOptions.outHeight);
    return BitmapFactory.decodeFile(paramString, localOptions);
  }
  
  /* Error */
  public static Bitmap compImgBySize(Bitmap paramBitmap, int paramInt)
  {
    // Byte code:
    //   0: bipush 100
    //   2: istore_2
    //   3: aconst_null
    //   4: astore 6
    //   6: new 186	java/io/ByteArrayOutputStream
    //   9: dup
    //   10: invokespecial 187	java/io/ByteArrayOutputStream:<init>	()V
    //   13: astore 4
    //   15: aload 4
    //   17: astore_3
    //   18: aload_0
    //   19: getstatic 193	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   22: bipush 100
    //   24: aload 4
    //   26: invokevirtual 199	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   29: pop
    //   30: aload 4
    //   32: astore_3
    //   33: aload 4
    //   35: invokevirtual 203	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   38: arraylength
    //   39: sipush 1024
    //   42: idiv
    //   43: iload_1
    //   44: if_icmple +33 -> 77
    //   47: aload 4
    //   49: astore_3
    //   50: aload 4
    //   52: invokevirtual 206	java/io/ByteArrayOutputStream:reset	()V
    //   55: aload 4
    //   57: astore_3
    //   58: aload_0
    //   59: getstatic 193	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   62: iload_2
    //   63: aload 4
    //   65: invokevirtual 199	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   68: pop
    //   69: iload_2
    //   70: bipush 10
    //   72: isub
    //   73: istore_2
    //   74: goto -44 -> 30
    //   77: aload 4
    //   79: astore_3
    //   80: new 208	java/io/ByteArrayInputStream
    //   83: dup
    //   84: aload 4
    //   86: invokevirtual 203	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   89: invokespecial 211	java/io/ByteArrayInputStream:<init>	([B)V
    //   92: aconst_null
    //   93: aconst_null
    //   94: invokestatic 215	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   97: astore_0
    //   98: aload_0
    //   99: astore_3
    //   100: aload 4
    //   102: ifnull +10 -> 112
    //   105: aload 4
    //   107: invokevirtual 216	java/io/ByteArrayOutputStream:close	()V
    //   110: aload_0
    //   111: astore_3
    //   112: aload_3
    //   113: areturn
    //   114: astore_3
    //   115: aload_3
    //   116: invokevirtual 219	java/io/IOException:printStackTrace	()V
    //   119: aload_0
    //   120: areturn
    //   121: astore 5
    //   123: aconst_null
    //   124: astore_0
    //   125: aload_0
    //   126: astore_3
    //   127: aload 5
    //   129: invokevirtual 220	java/lang/Exception:printStackTrace	()V
    //   132: aload 6
    //   134: astore_3
    //   135: aload_0
    //   136: ifnull -24 -> 112
    //   139: aload_0
    //   140: invokevirtual 216	java/io/ByteArrayOutputStream:close	()V
    //   143: aconst_null
    //   144: areturn
    //   145: astore_0
    //   146: aload_0
    //   147: invokevirtual 219	java/io/IOException:printStackTrace	()V
    //   150: aconst_null
    //   151: areturn
    //   152: astore_0
    //   153: aconst_null
    //   154: astore_3
    //   155: aload_3
    //   156: ifnull +7 -> 163
    //   159: aload_3
    //   160: invokevirtual 216	java/io/ByteArrayOutputStream:close	()V
    //   163: aload_0
    //   164: athrow
    //   165: astore_3
    //   166: aload_3
    //   167: invokevirtual 219	java/io/IOException:printStackTrace	()V
    //   170: goto -7 -> 163
    //   173: astore_0
    //   174: goto -19 -> 155
    //   177: astore 5
    //   179: aload 4
    //   181: astore_0
    //   182: goto -57 -> 125
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	185	0	paramBitmap	Bitmap
    //   0	185	1	paramInt	int
    //   2	72	2	i	int
    //   17	96	3	localObject1	Object
    //   114	2	3	localIOException1	IOException
    //   126	34	3	localObject2	Object
    //   165	2	3	localIOException2	IOException
    //   13	167	4	localByteArrayOutputStream	ByteArrayOutputStream
    //   121	7	5	localException1	Exception
    //   177	1	5	localException2	Exception
    //   4	129	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   105	110	114	java/io/IOException
    //   6	15	121	java/lang/Exception
    //   139	143	145	java/io/IOException
    //   6	15	152	finally
    //   159	163	165	java/io/IOException
    //   18	30	173	finally
    //   33	47	173	finally
    //   50	55	173	finally
    //   58	69	173	finally
    //   80	98	173	finally
    //   127	132	173	finally
    //   18	30	177	java/lang/Exception
    //   33	47	177	java/lang/Exception
    //   50	55	177	java/lang/Exception
    //   58	69	177	java/lang/Exception
    //   80	98	177	java/lang/Exception
  }
  
  public static int computeSampleSize(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int i = a(paramOptions, paramInt1, paramInt2);
    if (i <= 8)
    {
      paramInt1 = 1;
      for (;;)
      {
        paramInt2 = paramInt1;
        if (paramInt1 >= i) {
          break;
        }
        paramInt1 <<= 1;
      }
    }
    paramInt2 = (i + 7) / 8 * 8;
    return paramInt2;
  }
  
  public static boolean exist(String paramString)
  {
    return new File(a + "/" + paramString).exists();
  }
  
  public static Bitmap getBitmap(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    Log.e("jj", "图片宽度" + i + ",screenWidth=" + paramInt1);
    Matrix localMatrix = new Matrix();
    localMatrix.postScale(paramInt1 / i, paramInt2 / j);
    return Bitmap.createBitmap(paramBitmap, 0, 0, i, j, localMatrix, true);
  }
  
  /* Error */
  public static Bitmap getBitmap(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +10 -> 11
    //   4: aload_0
    //   5: invokevirtual 270	java/lang/String:length	()I
    //   8: ifne +5 -> 13
    //   11: aconst_null
    //   12: areturn
    //   13: new 272	java/io/FileInputStream
    //   16: dup
    //   17: aload_0
    //   18: invokespecial 273	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   21: astore_3
    //   22: new 73	android/graphics/BitmapFactory$Options
    //   25: dup
    //   26: invokespecial 161	android/graphics/BitmapFactory$Options:<init>	()V
    //   29: astore 4
    //   31: aload 4
    //   33: iconst_1
    //   34: putfield 165	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   37: aload_3
    //   38: aconst_null
    //   39: aload 4
    //   41: invokestatic 215	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   44: pop
    //   45: aload 4
    //   47: aload 4
    //   49: iload_1
    //   50: iload_2
    //   51: invokestatic 275	com/ziroom/ziroomcustomer/util/h:computeSampleSize	(Landroid/graphics/BitmapFactory$Options;II)I
    //   54: putfield 178	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   57: aload 4
    //   59: iconst_0
    //   60: putfield 165	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   63: aload_0
    //   64: aload 4
    //   66: invokestatic 171	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   69: astore_0
    //   70: aload_0
    //   71: ifnull -60 -> 11
    //   74: aload_0
    //   75: areturn
    //   76: astore_0
    //   77: aconst_null
    //   78: areturn
    //   79: astore_0
    //   80: aconst_null
    //   81: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	paramString	String
    //   0	82	1	paramInt1	int
    //   0	82	2	paramInt2	int
    //   21	17	3	localFileInputStream	FileInputStream
    //   29	36	4	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   13	57	76	java/lang/Exception
    //   57	70	76	java/lang/Exception
    //   57	70	79	java/lang/OutOfMemoryError
  }
  
  public static byte[] getBitmapByte(String paramString)
  {
    Object localObject4 = null;
    Object localObject5 = null;
    Object localObject6 = null;
    Object localObject1 = null;
    File localFile = new File(a, paramString);
    paramString = (String)localObject1;
    Object localObject2;
    Object localObject3;
    if (localFile.exists())
    {
      localObject1 = localObject4;
      localObject2 = localObject5;
      localObject3 = localObject6;
    }
    try
    {
      FileInputStream localFileInputStream = new FileInputStream(localFile);
      localObject1 = localObject4;
      localObject2 = localObject5;
      localObject3 = localObject6;
      paramString = new byte[(int)localFile.length()];
      localObject1 = paramString;
      localObject2 = paramString;
      localObject3 = paramString;
      localFileInputStream.read(paramString);
      localObject1 = paramString;
      localObject2 = paramString;
      localObject3 = paramString;
      localFileInputStream.close();
      return paramString;
    }
    catch (FileNotFoundException paramString)
    {
      paramString.printStackTrace();
      return (byte[])localObject1;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
      return (byte[])localObject2;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return (byte[])localObject3;
  }
  
  public static byte[] getBytes(InputStream paramInputStream)
    throws IOException
  {
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      byte[] arrayOfByte = new byte['Ѐ'];
      for (;;)
      {
        int i = paramInputStream.read(arrayOfByte);
        if (i == -1) {
          break;
        }
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      localByteArrayOutputStream.close();
      paramInputStream = localByteArrayOutputStream.toByteArray();
      return paramInputStream;
    }
    catch (Exception paramInputStream) {}
    return null;
  }
  
  public static String getRealPathFromUri(Context paramContext, Uri paramUri)
  {
    int i = Build.VERSION.SDK_INT;
    if (i < 11) {
      return c(paramContext, paramUri);
    }
    if (i < 19) {
      return b(paramContext, paramUri);
    }
    return a(paramContext, paramUri);
  }
  
  public static Bitmap readBitmapById(Context paramContext, int paramInt)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
    localOptions.inPurgeable = true;
    localOptions.inInputShareable = true;
    return BitmapFactory.decodeStream(paramContext.getResources().openRawResource(paramInt), null, localOptions);
  }
  
  public static Bitmap readBitmapById(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
    localOptions.inInputShareable = true;
    localOptions.inPurgeable = true;
    return getBitmap(BitmapFactory.decodeStream(paramContext.getResources().openRawResource(paramInt1), null, localOptions), paramInt2, paramInt3);
  }
  
  public static int readPictureDegree(String paramString)
  {
    try
    {
      int i = new ExifInterface(paramString).getAttributeInt("Orientation", 1);
      switch (i)
      {
      case 4: 
      case 5: 
      case 7: 
      default: 
        return 0;
      case 6: 
        return 90;
      case 3: 
        return 180;
      }
      return 270;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
    return 0;
  }
  
  public static void saveBitmap(Bitmap paramBitmap, String paramString, int paramInt)
  {
    if (d > a()) {}
    while (!"mounted".equals(Environment.getExternalStorageState())) {
      return;
    }
    File localFile = new File(a);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    paramString = new File(a + "/" + paramString);
    try
    {
      paramString.createNewFile();
      paramString = new FileOutputStream(paramString);
      paramBitmap.compress(Bitmap.CompressFormat.JPEG, paramInt, paramString);
      paramString.flush();
      paramString.close();
      return;
    }
    catch (Exception paramBitmap)
    {
      paramBitmap.printStackTrace();
    }
  }
  
  public static int setSimpleSize(float paramFloat1, float paramFloat2)
  {
    float f1 = b;
    float f2 = c;
    int i;
    if ((paramFloat1 > paramFloat2) && (paramFloat1 > f2)) {
      i = (int)(paramFloat1 / f2 + 0.5F);
    }
    for (;;)
    {
      int j = i;
      if (i <= 0) {
        j = 1;
      }
      i = j;
      if (j > 1)
      {
        i = j;
        if (j % 2 != 0) {
          i = j + 1;
        }
      }
      return i;
      if ((paramFloat1 <= paramFloat2) && (paramFloat2 > f1)) {
        i = (int)(paramFloat2 / f1 + 0.5F);
      } else {
        i = 1;
      }
    }
  }
  
  public static Bitmap toturn(Bitmap paramBitmap, int paramInt)
  {
    Matrix localMatrix = new Matrix();
    localMatrix.postRotate(paramInt);
    return Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), localMatrix, true);
  }
  
  /* Error */
  public static Bitmap tryGetBitmap(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +10 -> 11
    //   4: aload_0
    //   5: invokevirtual 270	java/lang/String:length	()I
    //   8: ifne +5 -> 13
    //   11: aconst_null
    //   12: areturn
    //   13: new 272	java/io/FileInputStream
    //   16: dup
    //   17: new 21	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   24: getstatic 47	com/ziroom/ziroomcustomer/util/h:a	Ljava/lang/String;
    //   27: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: ldc -29
    //   32: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload_0
    //   36: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokespecial 273	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   45: astore_3
    //   46: new 73	android/graphics/BitmapFactory$Options
    //   49: dup
    //   50: invokespecial 161	android/graphics/BitmapFactory$Options:<init>	()V
    //   53: astore 4
    //   55: aload 4
    //   57: iconst_1
    //   58: putfield 165	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   61: aload_3
    //   62: aconst_null
    //   63: aload 4
    //   65: invokestatic 215	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   68: pop
    //   69: aload 4
    //   71: aload 4
    //   73: iload_1
    //   74: iload_2
    //   75: invokestatic 275	com/ziroom/ziroomcustomer/util/h:computeSampleSize	(Landroid/graphics/BitmapFactory$Options;II)I
    //   78: putfield 178	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   81: aload 4
    //   83: iconst_0
    //   84: putfield 165	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   87: new 21	java/lang/StringBuilder
    //   90: dup
    //   91: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   94: getstatic 47	com/ziroom/ziroomcustomer/util/h:a	Ljava/lang/String;
    //   97: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: ldc -29
    //   102: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: aload_0
    //   106: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: aload 4
    //   114: invokestatic 171	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   117: astore_0
    //   118: aload_0
    //   119: ifnull -108 -> 11
    //   122: aload_0
    //   123: areturn
    //   124: astore_0
    //   125: aconst_null
    //   126: areturn
    //   127: astore_0
    //   128: aconst_null
    //   129: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	130	0	paramString	String
    //   0	130	1	paramInt1	int
    //   0	130	2	paramInt2	int
    //   45	17	3	localFileInputStream	FileInputStream
    //   53	60	4	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   13	81	124	java/lang/Exception
    //   81	118	124	java/lang/Exception
    //   81	118	127	java/lang/OutOfMemoryError
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/util/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */