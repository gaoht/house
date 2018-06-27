package com.ziroom.credit.view.XListView;

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
import com.ziroom.credit.R.id;
import com.ziroom.credit.R.layout;
import com.ziroom.credit.R.string;

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
    this.a = ((LinearLayout)LayoutInflater.from(paramContext).inflate(R.layout.credit_xlistview_header, null));
    addView(this.a, localLayoutParams);
    setGravity(80);
    this.b = ((ImageView)findViewById(R.id.credit_xlistview_header_arrow));
    this.d = ((TextView)findViewById(R.id.credit_xlistview_header_hint_textview));
    this.c = ((ProgressBar)findViewById(R.id.credit_xlistview_header_progressbar));
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
      this.d.setText(R.string.credit_xlistview_header_hint_normal);
      continue;
      if (this.e != 1)
      {
        this.b.clearAnimation();
        this.b.startAnimation(this.f);
        this.d.setText(R.string.credit_xlistview_header_hint_ready);
        continue;
        this.d.setText(R.string.credit_xlistview_header_hint_loading);
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


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/credit/view/XListView/XListViewHeader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */