package com.ziroom.ziroomcustomer.newchat;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.util.DisplayMetrics;
import com.hyphenate.chat.EMMessage;
import com.hyphenate.chat.EMTextMessageBody;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.util.n;
import com.ziroom.ziroomcustomer.util.u;
import java.io.PrintStream;
import java.util.List;

public class d
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
  
  public static int convertDip2Px(Context paramContext, int paramInt)
  {
    float f1 = paramContext.getResources().getDisplayMetrics().density;
    float f2 = paramInt;
    if (paramInt >= 0) {}
    for (paramInt = 1;; paramInt = -1) {
      return (int)(paramInt * 0.5F + f2 * f1);
    }
  }
  
  public static Bitmap convertDongBitmap(Bitmap paramBitmap)
  {
    int i3 = paramBitmap.getWidth();
    int i4 = paramBitmap.getHeight();
    u.d("sdjgkljg", "=====  bitmap的宽高： " + n.px2dip(ApplicationEx.c, i3) + "   " + n.px2dip(ApplicationEx.c, i4));
    u.d("sdjgkljg", "=====  bitmap的宽高： " + i3 + "   " + i4);
    u.d("sdjgkljg", "=====  bitmap的宽高： " + n.px2dip(ApplicationEx.c, 124.0F) + "   " + i4);
    int i;
    int j;
    float f1;
    if (i3 == i4)
    {
      i = convertDip2Px(ApplicationEx.c, 124);
      j = convertDip2Px(ApplicationEx.c, 124);
      u.d("sdjgkljg", " ===== " + i);
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
        i2 = convertDip2Px(ApplicationEx.c, 64);
        k = convertDip2Px(ApplicationEx.c, 124);
        n = i;
        m = j;
        if (i3 < i2)
        {
          n = i;
          m = j;
          if (i4 < k)
          {
            u.d("sdjgkljg", "=====   bitmap宽高都小于要宽高求的");
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
            u.d("sdjgkljg", "=====   //bitmap高大于要求的高度，bitmap的宽小于要求的宽度，：高度是要求的高度，宽度压缩");
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
            u.d("sdjgkljg", "=====   bitmap高小于要求的高度，bitmap的宽大于要求的宽度，：宽度是要求的宽度，高度压缩");
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
          k = convertDip2Px(ApplicationEx.c, 124);
          i2 = convertDip2Px(ApplicationEx.c, 56);
          n = i;
          m = j;
          if (i3 < k)
          {
            n = i;
            m = j;
            if (i4 < i2)
            {
              u.d("sdjgkljg", "=====   bitmap宽高都小于要宽高求的");
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
          u.d("sdjgkljg", "=====  scaleWidth： " + f1 + "   scaleHeight: " + f2);
          Matrix localMatrix = new Matrix();
          localMatrix.postScale(f1, f2);
          paramBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, i3, i4, localMatrix, true);
          u.d("sdjgkljg", "=====  newbm的宽高： " + n.px2dip(ApplicationEx.c, paramBitmap.getWidth()) + "   " + n.px2dip(ApplicationEx.c, paramBitmap.getHeight()));
          u.d("sdjgkljg", "=====  newbm的宽高： " + paramBitmap.getWidth() + "   " + paramBitmap.getHeight());
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
  
  public static int convertPx2Dip(Context paramContext, int paramInt)
  {
    float f = paramContext.getResources().getDisplayMetrics().density;
    f = paramInt / f;
    if (paramInt >= 0) {}
    for (paramInt = 1;; paramInt = -1) {
      return (int)(paramInt * 0.5F + f);
    }
  }
  
  public static String getMessageDigest(EMMessage paramEMMessage, Context paramContext)
  {
    switch (1.a[paramEMMessage.getType().ordinal()])
    {
    default: 
      System.err.println("error, unknow type");
    }
    do
    {
      return "";
      return "[图片]";
    } while (paramEMMessage.getBooleanAttribute("is_voice_call", false));
    return ((EMTextMessageBody)paramEMMessage.getBody()).getMessage();
  }
  
  public static String getTopActivity(Context paramContext)
  {
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1);
    if (paramContext != null) {
      return ((ActivityManager.RunningTaskInfo)paramContext.get(0)).topActivity.getClassName();
    }
    return "";
  }
  
  public static boolean isExitsSdcard()
  {
    return Environment.getExternalStorageState().equals("mounted");
  }
  
  public static boolean isNetWorkConnected(Context paramContext)
  {
    if (paramContext != null)
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext != null) {
        return paramContext.isAvailable();
      }
    }
    return false;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newchat/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */