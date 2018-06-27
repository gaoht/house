package com.ziroom.ziroomcustomer.minsu.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

public class MinsuEvaluteButton
  extends LinearLayout
{
  private int a;
  private int b;
  private int c = 5;
  private a d;
  
  public MinsuEvaluteButton(Context paramContext)
  {
    super(paramContext);
  }
  
  public MinsuEvaluteButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public int getStep()
  {
    return this.c;
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
      this.a = (this.b / getStep());
      i = (int)(paramMotionEvent.getX() / this.a);
      this.d.onSwitch(i + 1);
      return true;
      f = paramMotionEvent.getX();
    } while (f > this.b);
    if (f <= 0.0F)
    {
      this.d.onSwitch(0);
      return true;
    }
    int i = (int)(f / this.a);
    this.d.onSwitch(i + 1);
    return true;
  }
  
  public void setOnSwitchStateListener(a parama)
  {
    this.d = parama;
  }
  
  public void setStep(int paramInt)
  {
    this.c = paramInt;
  }
  
  public static abstract interface a
  {
    public abstract void onSwitch(int paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/view/MinsuEvaluteButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */