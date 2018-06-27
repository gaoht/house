package com.ziroom.ziroomcustomer.newServiceList.model;

import android.widget.TextView;

public class u
{
  private TextView a;
  private String b;
  
  public u(TextView paramTextView, String paramString)
  {
    this.a = paramTextView;
    this.b = paramString;
  }
  
  public String getTvName()
  {
    return this.b;
  }
  
  public TextView getTvText()
  {
    return this.a;
  }
  
  public void setTvName(String paramString)
  {
    this.b = paramString;
  }
  
  public void setTvText(TextView paramTextView)
  {
    this.a = paramTextView;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/model/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */