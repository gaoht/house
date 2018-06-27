package com.ziroom.ziroomcustomer.ziroomstation.utils.takephoto;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.ziroom.ziroomcustomer.util.u;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class a
{
  public static final String a = a.class.getSimpleName();
  
  @SuppressLint({"NewApi"})
  public static byte[] Bitmap2Bytes(Bitmap paramBitmap)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.JPEG, 100, localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }
  
  public static byte[] bitmapTobyteArray(Bitmap paramBitmap)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }
  
  @SuppressLint({"NewApi"})
  public static Bitmap compressImage(Bitmap paramBitmap)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    int i = 80;
    paramBitmap.compress(Bitmap.CompressFormat.PNG, 80, localByteArrayOutputStream);
    while ((localByteArrayOutputStream.toByteArray().length / 1024 > 100) && (i > 0))
    {
      localByteArrayOutputStream.reset();
      i -= 10;
      paramBitmap.compress(Bitmap.CompressFormat.PNG, i, localByteArrayOutputStream);
    }
    try
    {
      paramBitmap = new FileOutputStream(new File("/storage/emulated/0/ziroom_houseconfig/abc.png"));
      paramBitmap.write(localByteArrayOutputStream.toByteArray());
      paramBitmap.flush();
      paramBitmap.close();
      return BitmapFactory.decodeStream(new ByteArrayInputStream(localByteArrayOutputStream.toByteArray()), null, null);
    }
    catch (Exception paramBitmap)
    {
      for (;;)
      {
        paramBitmap.printStackTrace();
      }
    }
  }
  
  /* Error */
  public static byte[] fileToBype(File paramFile)
  {
    // Byte code:
    //   0: new 29	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 30	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore 4
    //   9: new 99	java/io/FileInputStream
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 100	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   17: astore_2
    //   18: aload_2
    //   19: astore_0
    //   20: sipush 1024
    //   23: newarray <illegal type>
    //   25: astore_3
    //   26: aload_2
    //   27: astore_0
    //   28: aload_2
    //   29: aload_3
    //   30: invokevirtual 104	java/io/FileInputStream:read	([B)I
    //   33: istore_1
    //   34: iload_1
    //   35: iconst_m1
    //   36: if_icmpeq +37 -> 73
    //   39: aload_2
    //   40: astore_0
    //   41: aload 4
    //   43: aload_3
    //   44: iconst_0
    //   45: iload_1
    //   46: invokevirtual 107	java/io/ByteArrayOutputStream:write	([BII)V
    //   49: goto -23 -> 26
    //   52: astore_3
    //   53: aload_2
    //   54: astore_0
    //   55: aload_3
    //   56: invokevirtual 93	java/lang/Exception:printStackTrace	()V
    //   59: aload_2
    //   60: ifnull +7 -> 67
    //   63: aload_2
    //   64: invokevirtual 108	java/io/FileInputStream:close	()V
    //   67: aload 4
    //   69: invokevirtual 46	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   72: areturn
    //   73: aload_2
    //   74: ifnull -7 -> 67
    //   77: aload_2
    //   78: invokevirtual 108	java/io/FileInputStream:close	()V
    //   81: goto -14 -> 67
    //   84: astore_0
    //   85: aload_0
    //   86: invokevirtual 109	java/io/IOException:printStackTrace	()V
    //   89: goto -22 -> 67
    //   92: astore_0
    //   93: aload_0
    //   94: invokevirtual 109	java/io/IOException:printStackTrace	()V
    //   97: goto -30 -> 67
    //   100: astore_2
    //   101: aconst_null
    //   102: astore_0
    //   103: aload_0
    //   104: ifnull +7 -> 111
    //   107: aload_0
    //   108: invokevirtual 108	java/io/FileInputStream:close	()V
    //   111: aload_2
    //   112: athrow
    //   113: astore_0
    //   114: aload_0
    //   115: invokevirtual 109	java/io/IOException:printStackTrace	()V
    //   118: goto -7 -> 111
    //   121: astore_2
    //   122: goto -19 -> 103
    //   125: astore_3
    //   126: aconst_null
    //   127: astore_2
    //   128: goto -75 -> 53
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	paramFile	File
    //   33	13	1	i	int
    //   17	61	2	localFileInputStream	java.io.FileInputStream
    //   100	12	2	localObject1	Object
    //   121	1	2	localObject2	Object
    //   127	1	2	localObject3	Object
    //   25	19	3	arrayOfByte	byte[]
    //   52	4	3	localException1	Exception
    //   125	1	3	localException2	Exception
    //   7	61	4	localByteArrayOutputStream	ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   20	26	52	java/lang/Exception
    //   28	34	52	java/lang/Exception
    //   41	49	52	java/lang/Exception
    //   77	81	84	java/io/IOException
    //   63	67	92	java/io/IOException
    //   9	18	100	finally
    //   107	111	113	java/io/IOException
    //   20	26	121	finally
    //   28	34	121	finally
    //   41	49	121	finally
    //   55	59	121	finally
    //   9	18	125	java/lang/Exception
  }
  
  @SuppressLint({"NewApi"})
  public static Bitmap getCompressImage(String paramString)
  {
    int j = 1;
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    localOptions.inJustDecodeBounds = false;
    int i = localOptions.outWidth;
    int k = localOptions.outHeight;
    if ((i > k) && (i > 480.0F)) {
      i = (int)(localOptions.outWidth / 480.0F);
    }
    for (;;)
    {
      if (i <= 0) {
        i = j;
      }
      for (;;)
      {
        u.e("PhotoUtil", "be" + i);
        localOptions.inSampleSize = i;
        return BitmapFactory.decodeFile(paramString, localOptions);
        if ((i >= k) || (k <= 800.0F)) {
          break label139;
        }
        i = (int)(localOptions.outHeight / 800.0F);
        break;
      }
      label139:
      i = 1;
    }
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
  
  public static void recursionDeleteFile(File paramFile)
  {
    if (paramFile.isFile()) {
      paramFile.delete();
    }
    while (!paramFile.isDirectory()) {
      return;
    }
    File[] arrayOfFile = paramFile.listFiles();
    if ((arrayOfFile == null) || (arrayOfFile.length == 0))
    {
      paramFile.delete();
      return;
    }
    int j = arrayOfFile.length;
    int i = 0;
    while (i < j)
    {
      recursionDeleteFile(arrayOfFile[i]);
      i += 1;
    }
    paramFile.delete();
  }
  
  public static Bitmap rotaingImageView(int paramInt, Bitmap paramBitmap)
  {
    Matrix localMatrix = new Matrix();
    localMatrix.postRotate(paramInt);
    return Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), localMatrix, true);
  }
  
  public static String saveBitmap(Bitmap paramBitmap)
  {
    String str = Environment.getExternalStorageDirectory() + "/ziroom_temp_images/" + String.valueOf(System.currentTimeMillis()) + ".png";
    File localFile = new File(str);
    if (!localFile.exists()) {
      localFile.getParentFile().mkdirs();
    }
    try
    {
      for (;;)
      {
        FileOutputStream localFileOutputStream = new FileOutputStream(localFile);
        paramBitmap.compress(Bitmap.CompressFormat.PNG, 90, localFileOutputStream);
        localFileOutputStream.flush();
        localFileOutputStream.close();
        Log.i("PhotoUtil", "已经保存");
        if (!localFile.exists()) {
          break;
        }
        return str;
        if (localFile.exists()) {
          localFile.delete();
        }
      }
    }
    catch (FileNotFoundException paramBitmap)
    {
      for (;;)
      {
        paramBitmap.printStackTrace();
      }
    }
    catch (IOException paramBitmap)
    {
      for (;;)
      {
        paramBitmap.printStackTrace();
      }
    }
    return null;
  }
  
  public static void saveImageByFrescoCache(Handler paramHandler, Uri paramUri, Context paramContext)
  {
    paramUri = ImageRequestBuilder.newBuilderWithSource(paramUri).setProgressiveRenderingEnabled(true).build();
    Fresco.getImagePipeline().fetchDecodedImage(paramUri, paramContext).subscribe(new BaseBitmapDataSubscriber()
    {
      public void onFailureImpl(DataSource paramAnonymousDataSource)
      {
        this.a.sendEmptyMessage(0);
      }
      
      public void onNewResultImpl(Bitmap paramAnonymousBitmap)
      {
        if (paramAnonymousBitmap == null)
        {
          this.a.sendEmptyMessage(0);
          return;
        }
        paramAnonymousBitmap = a.saveBitmap(paramAnonymousBitmap);
        Message localMessage = new Message();
        localMessage.obj = paramAnonymousBitmap;
        this.a.sendMessage(localMessage);
      }
    }, CallerThreadExecutor.getInstance());
  }
  
  public static void saveImageByFrescoCache(Handler paramHandler, String paramString, Context paramContext)
  {
    saveImageByFrescoCache(paramHandler, Uri.parse(paramString), paramContext);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/utils/takephoto/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */