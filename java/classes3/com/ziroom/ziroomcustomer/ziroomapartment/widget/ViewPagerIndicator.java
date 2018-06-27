package com.ziroom.ziroomcustomer.ziroomapartment.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.ziroom.ziroomcustomer.util.ah;

public class ViewPagerIndicator
  extends LinearLayout
{
  private int a = 0;
  private int b = 0;
  private Context c;
  private int d;
  private int e;
  
  public ViewPagerIndicator(Context paramContext)
  {
    super(paramContext);
    this.c = paramContext;
    init();
  }
  
  public ViewPagerIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.c = paramContext;
    init();
  }
  
  public ViewPagerIndicator(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.c = paramContext;
    init();
  }
  
  public ViewPagerIndicator(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }
  
  public void draw()
  {
    int i = 0;
    if (i < this.a)
    {
      ImageView localImageView = new ImageView(this.c);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(20, 20);
      localLayoutParams.height = ah.dip2px(this.c, 3.0F);
      localLayoutParams.width = ah.dip2px(this.c, 9.0F);
      localLayoutParams.leftMargin = ah.dip2px(this.c, 6.0F);
      localLayoutParams.topMargin = ah.dip2px(this.c, 0.0F);
      localImageView.setLayoutParams(localLayoutParams);
      if (i == this.b) {
        localImageView.setBackgroundResource(this.d);
      }
      for (;;)
      {
        addView(localImageView);
        i += 1;
        break;
        localImageView.setBackgroundResource(this.e);
      }
    }
  }
  
  public float getDistance()
  {
    return getChildAt(1).getX() - getChildAt(0).getX();
  }
  
  public int getSelected()
  {
    return this.b;
  }
  
  public int getSum()
  {
    return this.a;
  }
  
  public void init()
  {
    setOrientation(0);
    setGravity(1);
  }
  
  public void setLength(int paramInt)
  {
    this.a = paramInt;
    this.b = 0;
    draw();
  }
  
  public void setSelected(int paramInt)
  {
    removeAllViews();
    if (this.a == 0) {
      paramInt = 0;
    }
    for (;;)
    {
      this.b = paramInt;
      draw();
      return;
      paramInt %= this.a;
    }
  }
  
  public void setSelected(int paramInt1, int paramInt2, int paramInt3)
  {
    removeAllViews();
    this.d = paramInt2;
    this.e = paramInt3;
    if (this.a == 0) {
      paramInt1 = 0;
    }
    for (;;)
    {
      this.b = paramInt1;
      draw();
      return;
      paramInt1 %= this.a;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/widget/ViewPagerIndicator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */