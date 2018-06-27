package com.baidu.mapapi.map;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class m
  extends AnimatorListenerAdapter
{
  m(SwipeDismissTouchListener paramSwipeDismissTouchListener) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    SwipeDismissTouchListener.a(this.a);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/map/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */