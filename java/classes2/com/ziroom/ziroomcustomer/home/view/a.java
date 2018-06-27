package com.ziroom.ziroomcustomer.home.view;

import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

public class a
{
  static final Interpolator a = new LinearInterpolator();
  static final Interpolator b = new FastOutSlowInInterpolator();
  static final Interpolator c = new DecelerateInterpolator();
  
  static float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (paramFloat2 - paramFloat1) * paramFloat3 + paramFloat1;
  }
  
  static int a(int paramInt1, int paramInt2, float paramFloat)
  {
    return Math.round((paramInt2 - paramInt1) * paramFloat) + paramInt1;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/home/view/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */