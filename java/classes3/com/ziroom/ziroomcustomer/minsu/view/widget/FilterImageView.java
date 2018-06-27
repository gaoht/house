package com.ziroom.ziroomcustomer.minsu.view.widget;

import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.facebook.drawee.view.SimpleDraweeView;

public class FilterImageView
  extends SimpleDraweeView
{
  public FilterImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public FilterImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public FilterImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a()
  {
    Drawable localDrawable2 = getDrawable();
    Drawable localDrawable1 = localDrawable2;
    if (localDrawable2 == null) {
      localDrawable1 = getBackground();
    }
    if (localDrawable1 != null) {
      localDrawable1.setColorFilter(-7829368, PorterDuff.Mode.MULTIPLY);
    }
  }
  
  private void b()
  {
    Drawable localDrawable2 = getDrawable();
    Drawable localDrawable1 = localDrawable2;
    if (localDrawable2 == null) {
      localDrawable1 = getBackground();
    }
    if (localDrawable1 != null) {
      localDrawable1.clearColorFilter();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      return true;
      a();
      continue;
      performClick();
      b();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/view/widget/FilterImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */