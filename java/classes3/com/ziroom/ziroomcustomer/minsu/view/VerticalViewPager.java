package com.ziroom.ziroomcustomer.minsu.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.PageTransformer;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class VerticalViewPager
  extends ViewPager
{
  private boolean a = true;
  
  public VerticalViewPager(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public VerticalViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private MotionEvent a(MotionEvent paramMotionEvent)
  {
    float f1 = getWidth();
    float f2 = getHeight();
    paramMotionEvent.setLocation(paramMotionEvent.getY() / f2 * f1, paramMotionEvent.getX() / f1 * f2);
    return paramMotionEvent;
  }
  
  private void a()
  {
    setPageTransformer(true, new a(null));
    setOverScrollMode(2);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.onInterceptTouchEvent(a(paramMotionEvent));
    a(paramMotionEvent);
    if (!this.a) {
      return bool;
    }
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.a) {
      return super.onTouchEvent(paramMotionEvent);
    }
    return false;
  }
  
  private class a
    implements ViewPager.PageTransformer
  {
    private a() {}
    
    public void transformPage(View paramView, float paramFloat)
    {
      if (paramFloat < -1.0F)
      {
        paramView.setAlpha(0.0F);
        return;
      }
      if (paramFloat <= 1.0F)
      {
        paramView.setAlpha(1.0F);
        paramView.setTranslationX(paramView.getWidth() * -paramFloat);
        paramView.setTranslationY(paramView.getHeight() * paramFloat);
        return;
      }
      paramView.setAlpha(0.0F);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/view/VerticalViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */