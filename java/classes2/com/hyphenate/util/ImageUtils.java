package com.hyphenate.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.ExifInterface;
import android.media.ThumbnailUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class ImageUtils
{
  public static final int SCALE_IMAGE_HEIGHT = 960;
  public static final int SCALE_IMAGE_WIDTH = 640;
  
  public static int calculateInSampleSize(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int k = paramOptions.outHeight;
    int j = paramOptions.outWidth;
    int i = 1;
    if ((k > paramInt2) || (j > paramInt1))
    {
      i = Math.round(k / paramInt2);
      paramInt1 = Math.round(j / paramInt1);
      if (i <= paramInt1) {}
    }
    else
    {
      return i;
    }
    return paramInt1;
  }
  
  public static Bitmap decodeScaleImage(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeResource(paramContext.getResources(), paramInt1, localOptions);
    localOptions.inSampleSize = calculateInSampleSize(localOptions, paramInt2, paramInt3);
    localOptions.inJustDecodeBounds = false;
    return BitmapFactory.decodeResource(paramContext.getResources(), paramInt1, localOptions);
  }
  
  public static Bitmap decodeScaleImage(String paramString, int paramInt1, int paramInt2)
  {
    Object localObject = getBitmapOptions(paramString);
    paramInt1 = calculateInSampleSize((BitmapFactory.Options)localObject, paramInt1, paramInt2);
    EMLog.d("img", "original wid" + ((BitmapFactory.Options)localObject).outWidth + " original height:" + ((BitmapFactory.Options)localObject).outHeight + " sample:" + paramInt1);
    ((BitmapFactory.Options)localObject).inSampleSize = paramInt1;
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
    localObject = BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
    paramInt1 = readPictureDegree(paramString);
    if ((localObject != null) && (paramInt1 != 0))
    {
      paramString = rotateImageView(paramInt1, (Bitmap)localObject);
      ((Bitmap)localObject).recycle();
      return paramString;
    }
    return (Bitmap)localObject;
  }
  
  public static BitmapFactory.Options getBitmapOptions(String paramString)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    return localOptions;
  }
  
  public static Bitmap getRoundedCornerBitmap(Bitmap paramBitmap)
  {
    return getRoundedCornerBitmap(paramBitmap, 6.0F);
  }
  
  public static Bitmap getRoundedCornerBitmap(Bitmap paramBitmap, float paramFloat)
  {
    Bitmap localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint();
    Rect localRect = new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
    RectF localRectF = new RectF(localRect);
    localPaint.setAntiAlias(true);
    localCanvas.drawARGB(0, 0, 0, 0);
    localPaint.setColor(-12434878);
    localCanvas.drawRoundRect(localRectF, paramFloat, paramFloat, localPaint);
    localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    localCanvas.drawBitmap(paramBitmap, localRect, localRect, localPaint);
    return localBitmap;
  }
  
  public static String getScaledImage(Context paramContext, String paramString)
  {
    Object localObject = new File(paramString);
    if (!((File)localObject).exists()) {
      return paramString;
    }
    long l = ((File)localObject).length();
    EMLog.d("img", "original img size:" + l);
    if (l <= 102400L)
    {
      EMLog.d("img", "use original small image");
      return paramString;
    }
    localObject = decodeScaleImage(paramString, 640, 960);
    try
    {
      paramContext = File.createTempFile("image", ".jpg", paramContext.getFilesDir());
      FileOutputStream localFileOutputStream = new FileOutputStream(paramContext);
      ((Bitmap)localObject).compress(Bitmap.CompressFormat.JPEG, 70, localFileOutputStream);
      localFileOutputStream.close();
      EMLog.d("img", "compared to small fle" + paramContext.getAbsolutePath() + " size:" + paramContext.length());
      paramContext = paramContext.getAbsolutePath();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return paramString;
  }
  
  public static String getScaledImage(Context paramContext, String paramString, int paramInt)
  {
    Object localObject2 = new File(paramString);
    Object localObject1 = paramString;
    if (((File)localObject2).exists())
    {
      long l = ((File)localObject2).length();
      EMLog.d("img", "original img size:" + l);
      localObject1 = paramString;
      if (l > 102400L) {
        localObject1 = decodeScaleImage(paramString, 640, 960);
      }
    }
    try
    {
      paramContext = new File(paramContext.getExternalCacheDir(), "eaemobTemp" + paramInt + ".jpg");
      localObject2 = new FileOutputStream(paramContext);
      ((Bitmap)localObject1).compress(Bitmap.CompressFormat.JPEG, 60, (OutputStream)localObject2);
      ((FileOutputStream)localObject2).close();
      EMLog.d("img", "compared to small fle" + paramContext.getAbsolutePath() + " size:" + paramContext.length());
      localObject1 = paramContext.getAbsolutePath();
      return (String)localObject1;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return paramString;
  }
  
  public static String getThumbnailImage(String paramString, int paramInt)
  {
    Object localObject = decodeScaleImage(paramString, paramInt, paramInt);
    try
    {
      File localFile = File.createTempFile("image", ".jpg");
      FileOutputStream localFileOutputStream = new FileOutputStream(localFile);
      ((Bitmap)localObject).compress(Bitmap.CompressFormat.JPEG, 60, localFileOutputStream);
      localFileOutputStream.close();
      EMLog.d("img", "generate thumbnail image at:" + localFile.getAbsolutePath() + " size:" + localFile.length());
      localObject = localFile.getAbsolutePath();
      return (String)localObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return paramString;
  }
  
  public static Bitmap getVideoThumbnail(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    paramString = ThumbnailUtils.createVideoThumbnail(paramString, paramInt3);
    EMLog.d("getVideoThumbnail", "video thumb width:" + paramString.getWidth());
    EMLog.d("getVideoThumbnail", "video thumb height:" + paramString.getHeight());
    return ThumbnailUtils.extractThumbnail(paramString, paramInt1, paramInt2, 2);
  }
  
  public static Bitmap mergeImages(int paramInt1, int paramInt2, List<Bitmap> paramList)
  {
    Bitmap localBitmap1 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap1);
    localCanvas.drawColor(-3355444);
    EMLog.d("img", "merge images to size:" + paramInt1 + "*" + paramInt2 + " with images:" + paramList.size());
    int k;
    int i;
    if (paramList.size() <= 4)
    {
      paramInt2 = 2;
      k = (paramInt1 - 4) / paramInt2;
      i = 0;
      paramInt1 = 0;
    }
    for (;;)
    {
      if (i >= paramInt2) {
        break label220;
      }
      int j = 0;
      for (;;)
      {
        if (j >= paramInt2) {
          break label213;
        }
        Bitmap localBitmap2 = Bitmap.createScaledBitmap((Bitmap)paramList.get(paramInt1), k, k, true);
        Bitmap localBitmap3 = getRoundedCornerBitmap(localBitmap2, 2.0F);
        localBitmap2.recycle();
        localCanvas.drawBitmap(localBitmap3, j * k + (j + 2), i * k + (i + 2), null);
        localBitmap3.recycle();
        paramInt1 += 1;
        if (paramInt1 == paramList.size())
        {
          return localBitmap1;
          paramInt2 = 3;
          break;
        }
        j += 1;
      }
      label213:
      i += 1;
    }
    label220:
    return localBitmap1;
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
  
  public static Bitmap rotateImageView(int paramInt, Bitmap paramBitmap)
  {
    Matrix localMatrix = new Matrix();
    localMatrix.postRotate(paramInt);
    return Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), localMatrix, true);
  }
  
  public static String saveVideoThumb(File paramFile, int paramInt1, int paramInt2, int paramInt3)
  {
    Bitmap localBitmap = getVideoThumbnail(paramFile.getAbsolutePath(), paramInt1, paramInt2, paramInt3);
    File localFile = new File(PathUtil.getInstance().getVideoPath(), "th" + paramFile.getName());
    try
    {
      localFile.createNewFile();
    }
    catch (IOException localIOException)
    {
      try
      {
        paramFile = new FileOutputStream(localFile);
        localBitmap.compress(Bitmap.CompressFormat.JPEG, 100, paramFile);
      }
      catch (FileNotFoundException localIOException)
      {
        try
        {
          paramFile.flush();
        }
        catch (IOException localIOException)
        {
          try
          {
            for (;;)
            {
              paramFile.close();
              return localFile.getAbsolutePath();
              paramFile = paramFile;
              paramFile.printStackTrace();
              continue;
              paramFile = paramFile;
              paramFile.printStackTrace();
              paramFile = null;
              continue;
              localIOException = localIOException;
              localIOException.printStackTrace();
            }
          }
          catch (IOException paramFile)
          {
            for (;;)
            {
              paramFile.printStackTrace();
            }
          }
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/util/ImageUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */