package com.baidu.mapapi.map;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

class n
  extends AnimatorListenerAdapter
{
  n(SwipeDismissTouchListener paramSwipeDismissTouchListener, ViewGroup.LayoutParams paramLayoutParams, int paramInt) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    SwipeDismissTouchListener.d(this.c).onDismiss(SwipeDismissTouchListener.b(this.c), SwipeDismissTouchListener.c(this.c));
    SwipeDismissTouchListener.b(this.c).setTranslationX(0.0F);
    this.a.height = this.b;
    SwipeDismissTouchListener.b(this.c).setLayoutParams(this.a);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/map/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */