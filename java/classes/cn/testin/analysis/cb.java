package cn.testin.analysis;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.i;
import android.view.View;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

class cb
  extends bz
  implements RecyclerView.i
{
  cb(bv parambv, RecyclerView paramRecyclerView)
  {
    super(parambv);
    paramRecyclerView.addOnChildAttachStateChangeListener(this);
  }
  
  private void a(View paramView)
  {
    try
    {
      Iterator localIterator = this.a.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        bv localbv = (bv)((Map.Entry)localObject).getKey();
        localObject = (List)((Map.Entry)localObject).getValue();
        bv.a(localbv, (RecyclerView)paramView.getParent(), ((List)localObject).subList(1, ((List)localObject).size()), (by)((List)localObject).get(0), false);
      }
      return;
    }
    catch (Exception paramView)
    {
      ar.a(paramView);
    }
  }
  
  public void cleanUp(View paramView)
  {
    super.cleanUp(paramView);
    ((RecyclerView)paramView).removeOnChildAttachStateChangeListener(this);
  }
  
  public void onChildViewAttachedToWindow(View paramView)
  {
    try
    {
      a(paramView);
      return;
    }
    catch (Exception paramView)
    {
      ar.a(paramView);
    }
  }
  
  public void onChildViewDetachedFromWindow(View paramView)
  {
    try
    {
      a(paramView);
      return;
    }
    catch (Exception paramView)
    {
      ar.a(paramView);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/cb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */