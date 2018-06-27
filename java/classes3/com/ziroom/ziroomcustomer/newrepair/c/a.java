package com.ziroom.ziroomcustomer.newrepair.c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.os.Environment;
import android.os.StatFs;
import android.util.Log;
import com.maa.android.agent.instrumentation.Instrumented;
import com.mato.sdk.instrumentation.HttpInstrumentation;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLEncoder;

@Instrumented
public class a
{
  private static int a = 1;
  private static int b = 1048576;
  
  private static int a()
  {
    StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
    double d = localStatFs.getAvailableBlocks();
    return (int)(localStatFs.getBlockSize() * d / b);
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
  
  public static byte[] compressBitmap(Bitmap paramBitmap, float paramFloat)
  {
    int i = 100;
    if (paramBitmap == null) {
      return null;
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.JPEG, 100, localByteArrayOutputStream);
    for (;;)
    {
      if (localByteArrayOutputStream.toByteArray().length / 1024.0F > paramFloat)
      {
        i -= 4;
        localByteArrayOutputStream.reset();
        if (i > 0) {}
      }
      else
      {
        return localByteArrayOutputStream.toByteArray();
      }
      paramBitmap.compress(Bitmap.CompressFormat.JPEG, i, localByteArrayOutputStream);
      Log.i("compress", "------质量--------" + localByteArrayOutputStream.toByteArray().length / 1024.0F);
    }
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
  
  public static boolean exist(String paramString1, String paramString2)
  {
    return new File(paramString1 + "/" + paramString2).exists();
  }
  
  public static int findBestSampleSize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    double d = Math.min(paramInt1 / paramInt3, paramInt2 / paramInt4);
    for (float f = 1.0F; f * 2.0F <= d; f *= 2.0F) {}
    return (int)f;
  }
  
  public static Bitmap getBitmap(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    Matrix localMatrix = new Matrix();
    localMatrix.postScale(paramInt1 / i, paramInt2 / j);
    return Bitmap.createBitmap(paramBitmap, 0, 0, i, j, localMatrix, true);
  }
  
  public static Bitmap getBitmap(String paramString1, String paramString2, int paramInt)
  {
    int i = 1;
    if (paramString2 == null) {
      return null;
    }
    String str = URLEncoder.encode(paramString2);
    label186:
    for (;;)
    {
      try
      {
        if (exist(paramString1, str))
        {
          paramString2 = new BitmapFactory.Options();
          paramString2.inJustDecodeBounds = true;
          BitmapFactory.decodeFile(paramString1 + "/" + str, paramString2);
          paramString2.inJustDecodeBounds = false;
          paramInt = (int)(paramString2.outHeight / 200.0F);
          if (paramInt > 0) {
            break label186;
          }
          paramInt = i;
          paramString2.inSampleSize = paramInt;
          return BitmapFactory.decodeFile(paramString1 + "/" + str, paramString2);
        }
        paramString2 = new URL(paramString2);
        if (!(paramString2 instanceof URL))
        {
          paramString2 = paramString2.openStream();
          Bitmap localBitmap = BitmapFactory.decodeStream(paramString2);
          if (localBitmap != null) {
            saveBitmap(paramString1, localBitmap, str, paramInt);
          }
          paramString2.close();
          return localBitmap;
        }
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        return null;
      }
      paramString2 = HttpInstrumentation.openStream((URL)paramString2);
    }
  }
  
  public static byte[] getBitmapByte(String paramString1, String paramString2)
  {
    Object localObject3 = null;
    Object localObject4 = null;
    Object localObject5 = null;
    Object localObject1 = null;
    File localFile = new File(paramString1, paramString2);
    paramString1 = (String)localObject1;
    Object localObject2;
    if (localFile.exists())
    {
      paramString2 = (String)localObject3;
      localObject1 = localObject4;
      localObject2 = localObject5;
    }
    try
    {
      FileInputStream localFileInputStream = new FileInputStream(localFile);
      paramString2 = (String)localObject3;
      localObject1 = localObject4;
      localObject2 = localObject5;
      paramString1 = new byte[(int)localFile.length()];
      paramString2 = paramString1;
      localObject1 = paramString1;
      localObject2 = paramString1;
      localFileInputStream.read(paramString1);
      paramString2 = paramString1;
      localObject1 = paramString1;
      localObject2 = paramString1;
      localFileInputStream.close();
      return paramString1;
    }
    catch (FileNotFoundException paramString1)
    {
      paramString1.printStackTrace();
      return paramString2;
    }
    catch (IOException paramString1)
    {
      paramString1.printStackTrace();
      return (byte[])localObject1;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
    return (byte[])localObject2;
  }
  
  public static int getBitmapSize(Bitmap paramBitmap)
  {
    return paramBitmap.getRowBytes() * paramBitmap.getHeight();
  }
  
  public static int getResizedDimension(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i;
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      i = paramInt3;
    }
    double d;
    do
    {
      do
      {
        return i;
        if (paramInt1 == 0) {
          return (int)(paramInt2 / paramInt4 * paramInt3);
        }
        i = paramInt1;
      } while (paramInt2 == 0);
      d = paramInt4 / paramInt3;
      i = paramInt1;
    } while (paramInt1 * d <= paramInt2);
    return (int)(paramInt2 / d);
  }
  
  public static byte[] getScaledBitmap(File paramFile, int paramInt)
  {
    int i = readPictureDegree(paramFile.getPath());
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramFile.getAbsolutePath(), (BitmapFactory.Options)localObject);
    int j = ((BitmapFactory.Options)localObject).outWidth;
    int k = ((BitmapFactory.Options)localObject).outHeight;
    int m = getResizedDimension(720, 480, j, k);
    int n = getResizedDimension(480, 720, k, j);
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
    ((BitmapFactory.Options)localObject).inSampleSize = findBestSampleSize(j, k, m, n);
    paramFile = BitmapFactory.decodeFile(paramFile.getAbsolutePath(), (BitmapFactory.Options)localObject);
    if ((paramFile != null) && ((paramFile.getWidth() > m) || (paramFile.getHeight() > n)))
    {
      localObject = Bitmap.createScaledBitmap(paramFile, m, n, true);
      paramFile.recycle();
      paramFile = (File)localObject;
    }
    while (i > 0)
    {
      localObject = new Matrix();
      ((Matrix)localObject).postRotate(i);
      localObject = Bitmap.createBitmap(paramFile, 0, 0, paramFile.getWidth(), paramFile.getHeight(), (Matrix)localObject, true);
      paramFile.recycle();
      return compressBitmap((Bitmap)localObject, paramInt);
    }
    return compressBitmap(paramFile, paramInt);
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
  
  public static void saveBitmap(String paramString1, Bitmap paramBitmap, String paramString2, int paramInt)
  {
    if (a > a()) {}
    while (!"mounted".equals(Environment.getExternalStorageState())) {
      return;
    }
    File localFile = new File(paramString1);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    paramString1 = new File(paramString1 + "/" + paramString2);
    try
    {
      paramString1.createNewFile();
      paramString1 = new FileOutputStream(paramString1);
      paramBitmap.compress(Bitmap.CompressFormat.JPEG, paramInt, paramString1);
      paramString1.flush();
      paramString1.close();
      return;
    }
    catch (FileNotFoundException paramString1) {}catch (IOException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  /* Error */
  public static Bitmap tryGetBitmap(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +10 -> 11
    //   4: aload_1
    //   5: invokevirtual 338	java/lang/String:length	()I
    //   8: ifne +5 -> 13
    //   11: aconst_null
    //   12: areturn
    //   13: new 212	java/io/FileInputStream
    //   16: dup
    //   17: new 95	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   24: aload_0
    //   25: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: ldc 121
    //   30: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload_1
    //   34: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokespecial 339	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   43: invokevirtual 343	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   46: astore 4
    //   48: new 44	android/graphics/BitmapFactory$Options
    //   51: dup
    //   52: invokespecial 159	android/graphics/BitmapFactory$Options:<init>	()V
    //   55: astore 5
    //   57: aload 5
    //   59: iconst_1
    //   60: putfield 163	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   63: aload 4
    //   65: aconst_null
    //   66: aload 5
    //   68: invokestatic 347	android/graphics/BitmapFactory:decodeFileDescriptor	(Ljava/io/FileDescriptor;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   71: pop
    //   72: aload 5
    //   74: aload 5
    //   76: iload_2
    //   77: iload_3
    //   78: invokestatic 349	com/ziroom/ziroomcustomer/newrepair/c/a:computeSampleSize	(Landroid/graphics/BitmapFactory$Options;II)I
    //   81: putfield 173	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   84: aload 5
    //   86: iconst_0
    //   87: putfield 163	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   90: new 95	java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   97: aload_0
    //   98: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: ldc 121
    //   103: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: aload_1
    //   107: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: aload 5
    //   115: invokestatic 169	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   118: astore_0
    //   119: aload_0
    //   120: ifnull -109 -> 11
    //   123: aload_0
    //   124: areturn
    //   125: astore_0
    //   126: aconst_null
    //   127: areturn
    //   128: astore_0
    //   129: aconst_null
    //   130: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	paramString1	String
    //   0	131	1	paramString2	String
    //   0	131	2	paramInt1	int
    //   0	131	3	paramInt2	int
    //   46	18	4	localFileDescriptor	java.io.FileDescriptor
    //   55	59	5	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   13	84	125	java/lang/Exception
    //   84	119	125	java/lang/Exception
    //   84	119	128	java/lang/OutOfMemoryError
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newrepair/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */