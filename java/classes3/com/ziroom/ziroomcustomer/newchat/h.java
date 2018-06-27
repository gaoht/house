package com.ziroom.ziroomcustomer.newchat;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.media.ExifInterface;
import com.hyphenate.util.EMLog;
import com.hyphenate.util.PathUtil;
import com.ziroom.ziroomcustomer.newchat.chat.a.b;
import java.io.IOException;

public class h
{
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
      paramString = rotaingImageView(paramInt1, (Bitmap)localObject);
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
  
  public static String getImagePath(String paramString)
  {
    paramString = paramString.substring(paramString.lastIndexOf("/") + 1, paramString.length());
    paramString = b.getInstance().getImagePath() + "/" + paramString;
    EMLog.d("msg", "image path:" + paramString);
    return paramString;
  }
  
  public static String getThumbnailImagePath(String paramString)
  {
    paramString = paramString.substring(paramString.lastIndexOf("/") + 1, paramString.length());
    paramString = PathUtil.getInstance().getImagePath() + "/th" + paramString;
    EMLog.d("msg", "thum image path:" + paramString);
    return paramString;
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
      case 3: 
        return 180;
      case 6: 
        return 90;
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
    return Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), localMatrix, true);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newchat/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */