package com.ziroom.ziroomcustomer.ziroomapartment.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class ZryuEvaluteButton
  extends LinearLayout
{
  private int a;
  private int b;
  private int c = 5;
  private ImageView[] d;
  private int e;
  private int f;
  private boolean g = true;
  private a h;
  
  public ZryuEvaluteButton(Context paramContext)
  {
    super(paramContext);
  }
  
  public ZryuEvaluteButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void dealSwitch(int paramInt)
  {
    if ((paramInt >= 1) && (paramInt <= 5))
    {
      this.h.onSwitch(paramInt);
      this.c = paramInt;
      int i = 0;
      if (i < paramInt)
      {
        if (i < this.d.length) {
          this.d[i].setImageResource(this.f);
        }
        for (;;)
        {
          i += 1;
          break;
          this.d[(this.d.length - 1)].setImageResource(this.f);
        }
      }
      i = 4;
      while (i >= paramInt)
      {
        this.d[i].setImageResource(this.e);
        i -= 1;
      }
    }
  }
  
  public int getScore()
  {
    return this.c;
  }
  
  public void initRatingBtn(ImageView[] paramArrayOfImageView, int paramInt1, int paramInt2, a parama)
  {
    this.d = paramArrayOfImageView;
    this.e = paramInt1;
    this.f = paramInt2;
    this.h = parama;
    this.d = new ImageView[] { (ImageView)findViewById(2131690054), (ImageView)findViewById(2131690055), (ImageView)findViewById(2131690056), (ImageView)findViewById(2131690057), (ImageView)findViewById(2131690058) };
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
    for (;;)
    {
      return true;
      if (this.g)
      {
        this.b = getWidth();
        this.a = (this.b / 5);
        dealSwitch((int)(paramMotionEvent.getX() / this.a) + 1);
      }
    }
  }
  
  public void setIsClickable(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public void setOnSwitchStateListener(a parama)
  {
    this.h = parama;
  }
  
  public void setScore(int paramInt)
  {
    this.c = paramInt;
    dealSwitch(paramInt);
  }
  
  public static abstract interface a
  {
    public abstract void onSwitch(int paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/widget/ZryuEvaluteButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */