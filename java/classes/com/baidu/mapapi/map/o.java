package com.baidu.mapapi.map;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

class o
  implements ValueAnimator.AnimatorUpdateListener
{
  o(SwipeDismissTouchListener paramSwipeDismissTouchListener, ViewGroup.LayoutParams paramLayoutParams) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.height = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    SwipeDismissTouchListener.b(this.b).setLayoutParams(this.a);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/map/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */