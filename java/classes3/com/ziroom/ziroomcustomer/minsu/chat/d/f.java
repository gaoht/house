package com.ziroom.ziroomcustomer.minsu.chat.d;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.hyphenate.util.EMLog;
import com.hyphenate.util.ImageUtils;
import com.hyphenate.util.PathUtil;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.newchat.d;
import com.ziroom.ziroomcustomer.util.n;
import com.ziroom.ziroomcustomer.util.u;

public class f
  extends ImageUtils
{
  public static Bitmap convertBitmap(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    float f2;
    float f1;
    if (i < j) {
      if (j < paramInt2)
      {
        f2 = i * (paramInt2 / j) / i;
        f1 = paramInt2 / j;
      }
    }
    for (;;)
    {
      Matrix localMatrix = new Matrix();
      localMatrix.postScale(f2, f1);
      return Bitmap.createBitmap(paramBitmap, 0, 0, i, j, localMatrix, true);
      f1 = j;
      float f3 = paramInt1 / i;
      f2 = paramInt1 / i;
      f1 = f1 * f3 / j;
      continue;
      if (i < paramInt1)
      {
        f1 = j;
        f3 = paramInt1 / i;
        f2 = paramInt1 / i;
        f1 = f1 * f3 / j;
      }
      else
      {
        f2 = i * (paramInt2 / j) / i;
        f1 = paramInt2 / j;
      }
    }
  }
  
  public static Bitmap convertBitmapBigger(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    float f2;
    float f1;
    if (i < j) {
      if (j < paramInt2)
      {
        f2 = i * (paramInt2 / j) / i + 1.0F;
        f1 = paramInt2 / j + 1.0F;
      }
    }
    for (;;)
    {
      Matrix localMatrix = new Matrix();
      localMatrix.postScale(f2, f1);
      return Bitmap.createBitmap(paramBitmap, 0, 0, i, j, localMatrix, true);
      f1 = j;
      float f3 = paramInt1 / i;
      f2 = paramInt1 / i;
      f1 = f1 * f3 / j;
      continue;
      if (i < paramInt1)
      {
        f1 = j;
        f3 = paramInt1 / i;
        f2 = paramInt1 / i + 1.0F;
        f1 = f1 * f3 / j + 1.0F;
      }
      else
      {
        f2 = i * (paramInt2 / j) / i;
        f1 = paramInt2 / j;
      }
    }
  }
  
  public static Bitmap convertDongBitmap(Bitmap paramBitmap)
  {
    int i3 = paramBitmap.getWidth();
    int i4 = paramBitmap.getHeight();
    u.d("huanxin", "=====  bitmap的宽高： " + n.px2dip(ApplicationEx.c, i3) + "   " + n.px2dip(ApplicationEx.c, i4));
    u.d("huanxin", "=====  bitmap的宽高： " + i3 + "   " + i4);
    u.d("huanxin", "=====  bitmap的宽高： " + n.px2dip(ApplicationEx.c, 124.0F) + "   " + i4);
    int i;
    int j;
    float f1;
    if (i3 == i4)
    {
      i = d.convertDip2Px(ApplicationEx.c, 124);
      j = d.convertDip2Px(ApplicationEx.c, 124);
      u.d("huanxin", " ===== " + i);
      if (i3 < i)
      {
        f1 = j / i3;
        f1 = i / i4;
      }
    }
    for (;;)
    {
      int i1 = i;
      int m = j;
      int i2;
      int k;
      int n;
      if (i3 < i4)
      {
        i2 = d.convertDip2Px(ApplicationEx.c, 64);
        k = d.convertDip2Px(ApplicationEx.c, 124);
        n = i;
        m = j;
        if (i3 < i2)
        {
          n = i;
          m = j;
          if (i4 < k)
          {
            u.d("huanxin", "=====   bitmap宽高都小于要宽高求的");
            m = i3 * (k / i4);
            n = k;
          }
        }
        i1 = n;
        i = m;
        if (i4 > k)
        {
          i1 = n;
          i = m;
          if (i3 < i2)
          {
            u.d("huanxin", "=====   //bitmap高大于要求的高度，bitmap的宽小于要求的宽度，：高度是要求的高度，宽度压缩");
            i = i3 * (k / i4);
            i1 = k;
          }
        }
        n = i1;
        j = i;
        if (i4 < k)
        {
          n = i1;
          j = i;
          if (i3 > i2)
          {
            u.d("huanxin", "=====   bitmap高小于要求的高度，bitmap的宽大于要求的宽度，：宽度是要求的宽度，高度压缩");
            n = i2 / i3 * i4;
            j = i2;
          }
        }
        i1 = n;
        m = j;
        if (i4 > k)
        {
          i1 = n;
          m = j;
          if (i3 > i2)
          {
            i = i3 * (k / i4);
            j = k;
          }
        }
      }
      for (;;)
      {
        i1 = i;
        m = j;
        if (i3 > i4)
        {
          k = d.convertDip2Px(ApplicationEx.c, 124);
          i2 = d.convertDip2Px(ApplicationEx.c, 56);
          n = i;
          m = j;
          if (i3 < k)
          {
            n = i;
            m = j;
            if (i4 < i2)
            {
              u.d("huanxin", "=====   bitmap宽高都小于要宽高求的");
              m = i4 * (k / i3);
              n = k;
            }
          }
          i1 = n;
          i = m;
          if (i3 > k)
          {
            i1 = n;
            i = m;
            if (i4 < i2)
            {
              i = i4 * (k / i3);
              i1 = k;
            }
          }
          n = i1;
          j = i;
          if (i3 < k)
          {
            n = i1;
            j = i;
            if (i4 > i2)
            {
              n = i2 / i4 * i3;
              j = i2;
            }
          }
          i1 = n;
          m = j;
          if (i4 > i2)
          {
            i1 = n;
            m = j;
            if (i3 <= k) {}
          }
        }
        for (i = k / i3 * i4;; i = m)
        {
          f1 = k / i3;
          float f2 = i / i4;
          u.d("huanxin", "=====  scaleWidth： " + f1 + "   scaleHeight: " + f2);
          Matrix localMatrix = new Matrix();
          localMatrix.postScale(f1, f2);
          paramBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, i3, i4, localMatrix, true);
          u.d("huanxin", "=====  newbm的宽高： " + n.px2dip(ApplicationEx.c, paramBitmap.getWidth()) + "   " + n.px2dip(ApplicationEx.c, paramBitmap.getHeight()));
          u.d("huanxin", "=====  newbm的宽高： " + paramBitmap.getWidth() + "   " + paramBitmap.getHeight());
          return paramBitmap;
          f1 = i / i3;
          f1 = j / i4;
          k = i;
          i = j;
          j = k;
          break;
          k = i1;
        }
        j = i1;
        i = m;
      }
      j = 0;
      i = 0;
    }
  }
  
  public static Bitmap convertLimitBitmap(Bitmap paramBitmap)
  {
    float f1 = 0.0F;
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    float f2;
    if (Float.valueOf(i).floatValue() / j < Float.valueOf(64.0F).floatValue() / 124.0F)
    {
      d.convertDip2Px(ApplicationEx.c, 124);
      f1 = Float.valueOf(d.convertDip2Px(ApplicationEx.c, 64)).floatValue() / i;
      j = i * 124 / 64;
      f2 = f1;
    }
    for (;;)
    {
      Matrix localMatrix = new Matrix();
      localMatrix.postScale(f2, f1);
      return Bitmap.createBitmap(paramBitmap, 0, 0, i, j, localMatrix, true);
      if ((Float.valueOf(64.0F).floatValue() / 124.0F <= Float.valueOf(i).floatValue() / j) && (Float.valueOf(i).floatValue() / j < 1.0F))
      {
        f1 = Float.valueOf(d.convertDip2Px(ApplicationEx.c, 124)).floatValue() / j;
        f2 = f1;
      }
      else if ((1.0F <= Float.valueOf(i).floatValue() / j) && (Float.valueOf(i).floatValue() / j <= Float.valueOf(124.0F).floatValue() / 55.0F))
      {
        f1 = Float.valueOf(d.convertDip2Px(ApplicationEx.c, 124)).floatValue() / i;
        f2 = f1;
      }
      else if (Float.valueOf(124.0F).floatValue() / 55.0F < Float.valueOf(i).floatValue() / j)
      {
        i = d.convertDip2Px(ApplicationEx.c, 55);
        d.convertDip2Px(ApplicationEx.c, 124);
        f1 = Float.valueOf(i).floatValue() / j;
        i = j * 124 / 55;
        f2 = f1;
      }
      else
      {
        f2 = 0.0F;
      }
    }
  }
  
  public static String getImagePath(String paramString)
  {
    paramString = paramString.substring(paramString.lastIndexOf("/") + 1, paramString.length());
    paramString = PathUtil.getInstance().getImagePath() + "/" + paramString;
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
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/chat/d/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */