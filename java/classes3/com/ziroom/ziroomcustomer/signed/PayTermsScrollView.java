package com.ziroom.ziroomcustomer.signed;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

public class PayTermsScrollView
  extends ScrollView
{
  private a a = null;
  
  public PayTermsScrollView(Context paramContext)
  {
    super(paramContext);
  }
  
  public PayTermsScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public PayTermsScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public PayTermsScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }
  
  public a getScrollViewListener()
  {
    return this.a;
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.a != null) {
      this.a.onScrollChanged(this, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void setScrollViewListener(a parama)
  {
    this.a = parama;
  }
  
  public static abstract interface a
  {
    public abstract void onScrollChanged(PayTermsScrollView paramPayTermsScrollView, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/PayTermsScrollView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */