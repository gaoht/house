package com.ziroom.ziroomcustomer.newmovehouse.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;

public class PullToRefreshScrollView
  extends PullToRefreshBase<ScrollView>
{
  private a b;
  
  public PullToRefreshScrollView(Context paramContext)
  {
    super(paramContext);
  }
  
  public PullToRefreshScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public PullToRefreshScrollView(Context paramContext, PullToRefreshBase.b paramb)
  {
    super(paramContext, paramb);
  }
  
  public PullToRefreshScrollView(Context paramContext, PullToRefreshBase.b paramb, PullToRefreshBase.a parama)
  {
    super(paramContext, paramb, parama);
  }
  
  protected boolean a()
  {
    View localView = ((ScrollView)this.a).getChildAt(0);
    if (localView != null) {
      return ((ScrollView)this.a).getScrollY() >= localView.getHeight() - getHeight();
    }
    return false;
  }
  
  protected ScrollView b(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (Build.VERSION.SDK_INT >= 9) {}
    for (paramContext = new InternalScrollViewSDK9(paramContext, paramAttributeSet);; paramContext = new ScrollView(paramContext, paramAttributeSet)
        {
          protected void onScrollChanged(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
          {
            super.onScrollChanged(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4);
            if (PullToRefreshScrollView.a(PullToRefreshScrollView.this) != null) {
              PullToRefreshScrollView.a(PullToRefreshScrollView.this).onScroll();
            }
          }
        })
    {
      paramContext.setId(2131689506);
      return paramContext;
    }
  }
  
  protected boolean b()
  {
    return ((ScrollView)this.a).getScrollY() == 0;
  }
  
  public final PullToRefreshBase.g getPullToRefreshScrollDirection()
  {
    return PullToRefreshBase.g.a;
  }
  
  public void setOnScrollListener(a parama)
  {
    this.b = parama;
  }
  
  @TargetApi(9)
  final class InternalScrollViewSDK9
    extends ScrollView
  {
    public InternalScrollViewSDK9(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    private int a()
    {
      int i = 0;
      if (getChildCount() > 0) {
        i = Math.max(0, getChildAt(0).getHeight() - (getHeight() - getPaddingBottom() - getPaddingTop()));
      }
      return i;
    }
    
    protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
      if (PullToRefreshScrollView.a(PullToRefreshScrollView.this) != null) {
        PullToRefreshScrollView.a(PullToRefreshScrollView.this).onScroll();
      }
    }
    
    protected boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
    {
      boolean bool = super.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
      c.overScrollBy(PullToRefreshScrollView.this, paramInt1, paramInt3, paramInt2, paramInt4, a(), paramBoolean);
      return bool;
    }
  }
  
  public static abstract interface a
  {
    public abstract void onScroll();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/widget/PullToRefreshScrollView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */