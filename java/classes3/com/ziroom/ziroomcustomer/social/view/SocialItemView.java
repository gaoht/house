package com.ziroom.ziroomcustomer.social.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class SocialItemView
  extends RelativeLayout
{
  private Context a;
  
  public SocialItemView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SocialItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SocialItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
    a();
  }
  
  private void a() {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/social/view/SocialItemView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */