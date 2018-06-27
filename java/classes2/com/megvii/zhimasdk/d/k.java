package com.megvii.zhimasdk.d;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

public class k
{
  public static float a = 0.15F;
  public static int b;
  public static int c;
  public static int d;
  public static int e;
  public static int f;
  public static float g;
  public static float h;
  public static float i;
  public static float j;
  public static float k;
  public static float l;
  public static float m;
  public static float n;
  public static float o = 0.0F;
  
  public static void a(Context paramContext)
  {
    if ((i == 0.0F) || (j == 0.0F) || (e == 0) || (f == 0) || (h == 0.0F))
    {
      paramContext = paramContext.getResources().getDisplayMetrics();
      h = paramContext.density;
      b = (int)(35.0F * h);
      e = paramContext.widthPixels;
      f = paramContext.heightPixels;
      c = paramContext.widthPixels;
      d = paramContext.heightPixels;
      g = paramContext.densityDpi;
      k = h * 30.0F;
      l = h * 30.0F;
      m = h * 50.0F;
      n = h * 40.0F;
      i = e - k - l;
      j = f - m - n;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/d/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */