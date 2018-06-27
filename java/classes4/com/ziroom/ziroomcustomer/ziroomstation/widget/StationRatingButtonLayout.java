package com.ziroom.ziroomcustomer.ziroomstation.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class StationRatingButtonLayout
  extends LinearLayout
{
  private int a;
  private int b;
  private int c = 5;
  private ImageView[] d;
  private int e;
  private int f;
  private a g;
  
  public StationRatingButtonLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public StationRatingButtonLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void dealSwitch(int paramInt)
  {
    this.g.onSwitch(paramInt, this);
    this.c = paramInt;
    int i = 0;
    while (i < paramInt)
    {
      this.d[i].setImageResource(this.f);
      i += 1;
    }
    i = 4;
    while (i >= paramInt)
    {
      this.d[i].setImageResource(this.e);
      i -= 1;
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
    this.g = parama;
    this.d = new ImageView[] { (ImageView)findViewById(2131690054), (ImageView)findViewById(2131690055), (ImageView)findViewById(2131690056), (ImageView)findViewById(2131690057), (ImageView)findViewById(2131690058) };
    setTag(Integer.valueOf(this.c));
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
      this.b = getWidth();
      this.a = (this.b / 5);
      dealSwitch((int)(paramMotionEvent.getX() / this.a) + 1);
    }
  }
  
  public void setOnSwitchStateListener(a parama)
  {
    this.g = parama;
  }
  
  public void setScore(int paramInt)
  {
    this.c = paramInt;
    dealSwitch(paramInt);
  }
  
  public static abstract interface a
  {
    public abstract void onSwitch(int paramInt, StationRatingButtonLayout paramStationRatingButtonLayout);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/widget/StationRatingButtonLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */