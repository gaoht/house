package com.ziroom.ziroomcustomer.ziroomstation.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class StayDayView
  extends LinearLayout
{
  private View a;
  private TextView b;
  
  public StayDayView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public StayDayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public StayDayView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = LayoutInflater.from(paramContext).inflate(2130905155, this, true);
    a();
  }
  
  private void a()
  {
    this.b = ((TextView)findViewById(2131697606));
  }
  
  public String getStayDay()
  {
    return this.b.getText().toString();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
  }
  
  public void setStayDay(int paramInt)
  {
    this.b.setText("共" + paramInt + "晚");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/widget/StayDayView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */