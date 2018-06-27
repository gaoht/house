package cn.testin.analysis;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

class ca
  extends bz
  implements AbsListView.OnScrollListener
{
  private AbsListView.OnScrollListener d;
  private int e;
  private int f;
  
  ca(bv parambv, AbsListView paramAbsListView, AbsListView.OnScrollListener paramOnScrollListener)
  {
    super(parambv);
    this.d = paramOnScrollListener;
    paramAbsListView.setOnScrollListener(this);
  }
  
  public void cleanUp(View paramView)
  {
    super.cleanUp(paramView);
    ((AbsListView)paramView).setOnScrollListener(this.d);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.d != null) {
      this.d.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
    try
    {
      if ((this.e == paramInt1) && (this.f == paramInt2)) {
        return;
      }
      this.e = paramInt1;
      this.f = paramInt2;
      if (!paramAbsListView.isLayoutRequested())
      {
        Iterator localIterator = this.a.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (Map.Entry)localIterator.next();
          bv localbv = (bv)((Map.Entry)localObject).getKey();
          localObject = (List)((Map.Entry)localObject).getValue();
          bv.a(localbv, paramAbsListView, ((List)localObject).subList(1, ((List)localObject).size()), (by)((List)localObject).get(0), false);
        }
      }
      return;
    }
    catch (Exception paramAbsListView)
    {
      ar.a(paramAbsListView);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    try
    {
      if (this.d != null) {
        this.d.onScrollStateChanged(paramAbsListView, paramInt);
      }
      return;
    }
    catch (Exception paramAbsListView)
    {
      ar.a(paramAbsListView);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/ca.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */