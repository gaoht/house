package com.ziroom.ziroomcustomer.home.view;

import android.content.Context;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;

public class NestScrollView
  extends NestedScrollView
{
  private boolean a;
  
  public NestScrollView(Context paramContext)
  {
    super(paramContext);
  }
  
  public NestScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public NestScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt4 > paramInt2) && (paramInt2 <= 0)) {
      this.a = true;
    }
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/home/view/NestScrollView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */