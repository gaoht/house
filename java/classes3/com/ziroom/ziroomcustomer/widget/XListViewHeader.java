package com.ziroom.ziroomcustomer.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;

public class XListViewHeader
  extends LinearLayout
{
  private LinearLayout a;
  private ImageView b;
  private ProgressBar c;
  private TextView d;
  private int e = 0;
  private Animation f;
  private Animation g;
  private final int h = 180;
  
  public XListViewHeader(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public XListViewHeader(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, 0);
    this.a = ((LinearLayout)LayoutInflater.from(paramContext).inflate(2130905241, null));
    addView(this.a, localLayoutParams);
    setGravity(80);
    this.b = ((ImageView)findViewById(2131697826));
    this.d = ((TextView)findViewById(2131697824));
    this.c = ((ProgressBar)findViewById(2131697827));
    this.f = new RotateAnimation(0.0F, -180.0F, 1, 0.5F, 1, 0.5F);
    this.f.setDuration(180L);
    this.f.setFillAfter(true);
    this.g = new RotateAnimation(-180.0F, 0.0F, 1, 0.5F, 1, 0.5F);
    this.g.setDuration(180L);
    this.g.setFillAfter(true);
  }
  
  public int getVisiableHeight()
  {
    return this.a.getHeight();
  }
  
  public void setState(int paramInt)
  {
    if (paramInt == this.e) {
      return;
    }
    if (paramInt == 2)
    {
      this.b.clearAnimation();
      this.b.setVisibility(4);
      this.c.setVisibility(0);
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      this.e = paramInt;
      return;
      this.b.setVisibility(0);
      this.c.setVisibility(4);
      break;
      if (this.e == 1) {
        this.b.startAnimation(this.g);
      }
      if (this.e == 2) {
        this.b.clearAnimation();
      }
      this.d.setText(2131297546);
      continue;
      if (this.e != 1)
      {
        this.b.clearAnimation();
        this.b.startAnimation(this.f);
        this.d.setText(2131297547);
        continue;
        this.d.setText(2131297545);
      }
    }
  }
  
  public void setVisiableHeight(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.a.getLayoutParams();
    localLayoutParams.height = i;
    this.a.setLayoutParams(localLayoutParams);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/widget/XListViewHeader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */