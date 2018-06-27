package com.ziroom.ziroomcustomer.social.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.os.Environment;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class b
{
  private static int a = 90;
  
  public static Bitmap compressImage(Bitmap paramBitmap)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.JPEG, 100, localByteArrayOutputStream);
    int i = a;
    while ((localByteArrayOutputStream.toByteArray().length / 1024 > 1000) && (i > 0))
    {
      localByteArrayOutputStream.reset();
      paramBitmap.compress(Bitmap.CompressFormat.JPEG, i, localByteArrayOutputStream);
      i -= 10;
    }
    return BitmapFactory.decodeStream(new ByteArrayInputStream(localByteArrayOutputStream.toByteArray()), null, null);
  }
  
  public static Bitmap getimage(String paramString)
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
        localOptions.inSampleSize = i;
        return compressImage(BitmapFactory.decodeFile(paramString, localOptions));
        if ((i >= k) || (k <= 800.0F)) {
          break label118;
        }
        i = (int)(localOptions.outHeight / 800.0F);
        break;
      }
      label118:
      i = 1;
    }
  }
  
  public static void reReadImage(File paramFile1, File paramFile2)
  {
    paramFile1 = getimage(paramFile1.getAbsolutePath());
    if (paramFile2.exists()) {
      paramFile2.delete();
    }
    try
    {
      paramFile2 = new FileOutputStream(paramFile2);
      paramFile1.compress(Bitmap.CompressFormat.PNG, 90, paramFile2);
      paramFile2.flush();
      paramFile2.close();
      return;
    }
    catch (FileNotFoundException paramFile1)
    {
      paramFile1.printStackTrace();
      return;
    }
    catch (IOException paramFile1)
    {
      paramFile1.printStackTrace();
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
  
  public static Bitmap rotaingImageView(int paramInt, Bitmap paramBitmap)
  {
    Matrix localMatrix = new Matrix();
    localMatrix.postRotate(paramInt);
    System.out.println("angle2=" + paramInt);
    return Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), localMatrix, true);
  }
  
  public static File saveImageToGallery(File paramFile)
  {
    paramFile = rotaingImageView(readPictureDegree(paramFile.getAbsolutePath()), getimage(paramFile.getAbsolutePath()));
    if (paramFile == null) {
      return null;
    }
    File localFile = new File(Environment.getExternalStorageDirectory(), "credit");
    if (!localFile.exists()) {
      localFile.mkdir();
    }
    localFile = new File(localFile, "upload.jpg");
    if (localFile.exists()) {
      localFile.delete();
    }
    try
    {
      FileOutputStream localFileOutputStream = new FileOutputStream(localFile);
      paramFile.compress(Bitmap.CompressFormat.JPEG, 100, localFileOutputStream);
      localFileOutputStream.flush();
      localFileOutputStream.close();
      return localFile;
    }
    catch (FileNotFoundException paramFile)
    {
      paramFile.printStackTrace();
      return null;
    }
    catch (IOException paramFile)
    {
      paramFile.printStackTrace();
    }
    return null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/social/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */