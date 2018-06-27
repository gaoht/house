package com.ziroom.ziroomcustomer.ziroomstation.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

public class IntoTagTextView
  extends TextView
{
  String a;
  
  public IntoTagTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public IntoTagTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public IntoTagTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public String getTagBean()
  {
    return this.a;
  }
  
  public void setTagBean(String paramString)
  {
    this.a = paramString;
    setText(paramString);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/widget/IntoTagTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */