package com.ziroom.ziroomcustomer.newServiceList.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class TitleItemView
  extends RelativeLayout
{
  public TitleItemView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public TitleItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public TitleItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(Context paramContext)
  {
    TextView localTextView = new TextView(paramContext);
    localTextView.setGravity(17);
    localTextView.setTextColor(-16777216);
    localTextView.setBackgroundColor(-1);
    localTextView.setTextSize(15.0F);
    paramContext = new TextView(paramContext);
    paramContext.setGravity(17);
    paramContext.setTextColor(-16777216);
    paramContext.setBackgroundColor(-1);
    paramContext.setTextSize(15.0F);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/view/TitleItemView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */