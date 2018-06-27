package com.ziroom.ziroomcustomer.newmovehouse.mvp;

import android.graphics.Bitmap;
import android.view.View;
import android.view.View.MeasureSpec;

public class a
{
  public static com.baidu.mapapi.model.LatLng convertTrace2Map(com.baidu.trace.model.LatLng paramLatLng)
  {
    return new com.baidu.mapapi.model.LatLng(paramLatLng.latitude, paramLatLng.longitude);
  }
  
  public static double getAngle(com.baidu.mapapi.model.LatLng paramLatLng1, com.baidu.mapapi.model.LatLng paramLatLng2)
  {
    double d = getSlope(paramLatLng1, paramLatLng2);
    if (d == Double.MAX_VALUE)
    {
      if (paramLatLng2.latitude > paramLatLng1.latitude) {
        return 90.0D;
      }
      return -90.0D;
    }
    float f = 0.0F;
    if ((paramLatLng2.latitude - paramLatLng1.latitude) * d < 0.0D) {
      f = 180.0F;
    }
    d = Math.atan(d) / 3.141592653589793D;
    return f + d * 180.0D;
  }
  
  public static Bitmap getBitmapFromView(View paramView)
  {
    paramView.destroyDrawingCache();
    paramView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    paramView.layout(0, 0, paramView.getMeasuredWidth(), paramView.getMeasuredHeight());
    paramView.setDrawingCacheEnabled(true);
    return paramView.getDrawingCache(true);
  }
  
  public static double getDerection(com.baidu.mapapi.model.LatLng paramLatLng1, com.baidu.mapapi.model.LatLng paramLatLng2)
  {
    double d = getTan(paramLatLng1, paramLatLng2);
    if ((paramLatLng2.latitude >= paramLatLng1.latitude) && (paramLatLng2.longitude >= paramLatLng1.longitude)) {
      return 360.0D - Math.toDegrees(Math.atan(d));
    }
    if ((paramLatLng2.latitude >= paramLatLng1.latitude) && (paramLatLng2.longitude < paramLatLng1.longitude)) {
      return 180.0D - Math.toDegrees(Math.atan(d));
    }
    if ((paramLatLng2.latitude < paramLatLng1.latitude) && (paramLatLng2.longitude >= paramLatLng1.longitude)) {
      return -Math.toDegrees(Math.atan(d));
    }
    if ((paramLatLng2.latitude < paramLatLng1.latitude) && (paramLatLng2.longitude < paramLatLng1.longitude)) {
      return 180.0D - Math.toDegrees(Math.atan(d));
    }
    return Math.toDegrees(Math.atan(d));
  }
  
  public static double getSlope(com.baidu.mapapi.model.LatLng paramLatLng1, com.baidu.mapapi.model.LatLng paramLatLng2)
  {
    if (paramLatLng2.longitude == paramLatLng1.longitude) {
      return Double.MAX_VALUE;
    }
    return (paramLatLng2.latitude - paramLatLng1.latitude) / (paramLatLng2.longitude - paramLatLng1.longitude);
  }
  
  public static double getTan(com.baidu.mapapi.model.LatLng paramLatLng1, com.baidu.mapapi.model.LatLng paramLatLng2)
  {
    return (paramLatLng2.latitude - paramLatLng1.latitude) / (paramLatLng2.longitude - paramLatLng1.longitude);
  }
  
  public static boolean isEqualToZero(double paramDouble)
  {
    return Math.abs(paramDouble - 0.0D) < 0.01D;
  }
  
  public static boolean isZeroPoint(double paramDouble1, double paramDouble2)
  {
    return (isEqualToZero(paramDouble1)) && (isEqualToZero(paramDouble2));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/mvp/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */