package com.ziroom.ziroomcustomer.minsu.view.stickylistheaders;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import java.util.Iterator;
import java.util.List;

public class ExpandableStickyListHeadersListView
  extends StickyListHeadersListView
{
  d a;
  a b = new a()
  {
    public void executeAnim(View paramAnonymousView, int paramAnonymousInt)
    {
      if (paramAnonymousInt == 0) {
        paramAnonymousView.setVisibility(0);
      }
      while (paramAnonymousInt != 1) {
        return;
      }
      paramAnonymousView.setVisibility(8);
    }
  };
  
  public ExpandableStickyListHeadersListView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ExpandableStickyListHeadersListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ExpandableStickyListHeadersListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(View paramView, int paramInt)
  {
    if ((paramInt == 0) && (paramView.getVisibility() == 0)) {}
    while (((1 == paramInt) && (paramView.getVisibility() != 0)) || (this.b == null)) {
      return;
    }
    this.b.executeAnim(paramView, paramInt);
  }
  
  public void collapse(long paramLong)
  {
    if (this.a.isHeaderCollapsed(paramLong)) {}
    for (;;)
    {
      return;
      this.a.collapse(paramLong);
      Object localObject = this.a.getItemViewsByHeaderId(paramLong);
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          a((View)((Iterator)localObject).next(), 1);
        }
      }
    }
  }
  
  public void expand(long paramLong)
  {
    if (!this.a.isHeaderCollapsed(paramLong)) {}
    for (;;)
    {
      return;
      this.a.expand(paramLong);
      Object localObject = this.a.getItemViewsByHeaderId(paramLong);
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          a((View)((Iterator)localObject).next(), 0);
        }
      }
    }
  }
  
  public long findItemIdByView(View paramView)
  {
    return this.a.findItemIdByView(paramView);
  }
  
  public View findViewByItemId(long paramLong)
  {
    return this.a.findViewByItemId(paramLong);
  }
  
  public d getAdapter()
  {
    return this.a;
  }
  
  public boolean isHeaderCollapsed(long paramLong)
  {
    return this.a.isHeaderCollapsed(paramLong);
  }
  
  public void setAdapter(f paramf)
  {
    this.a = new d(paramf);
    super.setAdapter(this.a);
  }
  
  public void setAnimExecutor(a parama)
  {
    this.b = parama;
  }
  
  public static abstract interface a
  {
    public abstract void executeAnim(View paramView, int paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/view/stickylistheaders/ExpandableStickyListHeadersListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */