package com.baidu.mapapi.map;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

class x
  extends AnimatorListenerAdapter
{
  x(WearMapView paramWearMapView, View paramView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.setVisibility(4);
    super.onAnimationEnd(paramAnimator);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/map/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */