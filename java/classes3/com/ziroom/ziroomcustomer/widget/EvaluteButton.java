package com.ziroom.ziroomcustomer.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

public class EvaluteButton
  extends LinearLayout
{
  private int a;
  private int b;
  private a c;
  
  public EvaluteButton(Context paramContext)
  {
    super(paramContext);
  }
  
  public EvaluteButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    float f;
    do
    {
      return true;
      this.b = getWidth();
      this.a = (this.b / 5);
      i = (int)(paramMotionEvent.getX() / this.a);
      this.c.onSwitch(i + 1);
      return true;
      f = paramMotionEvent.getX();
    } while (f > this.b);
    if (f <= 0.0F)
    {
      this.c.onSwitch(0);
      return true;
    }
    int i = (int)(f / this.a);
    this.c.onSwitch(i + 1);
    return true;
  }
  
  public void setOnSwitchStateListener(a parama)
  {
    this.c = parama;
  }
  
  public static abstract interface a
  {
    public abstract void onSwitch(int paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/widget/EvaluteButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */