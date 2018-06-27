package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;

abstract class l
  implements n, r, AdapterView.OnItemClickListener
{
  private Rect a;
  
  protected static int a(ListAdapter paramListAdapter, ViewGroup paramViewGroup, Context paramContext, int paramInt)
  {
    int i1 = View.MeasureSpec.makeMeasureSpec(0, 0);
    int i2 = View.MeasureSpec.makeMeasureSpec(0, 0);
    int i3 = paramListAdapter.getCount();
    int j = 0;
    int m = 0;
    View localView = null;
    int i = 0;
    int k;
    if (j < i3)
    {
      int n = paramListAdapter.getItemViewType(j);
      k = m;
      if (n != m)
      {
        k = n;
        localView = null;
      }
      if (paramViewGroup != null) {
        break label146;
      }
      paramViewGroup = new FrameLayout(paramContext);
      label82:
      localView = paramListAdapter.getView(j, localView, paramViewGroup);
      localView.measure(i1, i2);
      m = localView.getMeasuredWidth();
      if (m >= paramInt) {
        return paramInt;
      }
      if (m <= i) {
        break label149;
      }
      i = m;
    }
    label146:
    label149:
    for (;;)
    {
      j += 1;
      m = k;
      break;
      return i;
      break label82;
    }
  }
  
  protected static g a(ListAdapter paramListAdapter)
  {
    if ((paramListAdapter instanceof HeaderViewListAdapter)) {
      return (g)((HeaderViewListAdapter)paramListAdapter).getWrappedAdapter();
    }
    return (g)paramListAdapter;
  }
  
  protected static boolean a(h paramh)
  {
    boolean bool2 = false;
    int j = paramh.size();
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        MenuItem localMenuItem = paramh.getItem(i);
        if ((localMenuItem.isVisible()) && (localMenuItem.getIcon() != null)) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      i += 1;
    }
  }
  
  protected boolean a()
  {
    return true;
  }
  
  public abstract void addMenu(h paramh);
  
  public boolean collapseItemActionView(h paramh, j paramj)
  {
    return false;
  }
  
  public boolean expandItemActionView(h paramh, j paramj)
  {
    return false;
  }
  
  public Rect getEpicenterBounds()
  {
    return this.a;
  }
  
  public int getId()
  {
    return 0;
  }
  
  public o getMenuView(ViewGroup paramViewGroup)
  {
    throw new UnsupportedOperationException("MenuPopups manage their own views");
  }
  
  public void initForMenu(Context paramContext, h paramh) {}
  
  @Instrumented
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    VdsAgent.onItemClick(this, paramAdapterView, paramView, paramInt, paramLong);
    paramView = (ListAdapter)paramAdapterView.getAdapter();
    paramAdapterView = a(paramView).b;
    paramView = (MenuItem)paramView.getItem(paramInt);
    if (a()) {}
    for (paramInt = 0;; paramInt = 4)
    {
      paramAdapterView.performItemAction(paramView, this, paramInt);
      return;
    }
  }
  
  public abstract void setAnchorView(View paramView);
  
  public void setEpicenterBounds(Rect paramRect)
  {
    this.a = paramRect;
  }
  
  public abstract void setForceShowIcon(boolean paramBoolean);
  
  public abstract void setGravity(int paramInt);
  
  public abstract void setHorizontalOffset(int paramInt);
  
  public abstract void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener);
  
  public abstract void setShowTitle(boolean paramBoolean);
  
  public abstract void setVerticalOffset(int paramInt);
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/view/menu/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */