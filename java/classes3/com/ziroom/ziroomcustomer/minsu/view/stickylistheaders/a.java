package com.ziroom.ziroomcustomer.minsu.view.stickylistheaders;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Checkable;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import java.util.LinkedList;
import java.util.List;

class a
  extends BaseAdapter
  implements f
{
  f a;
  private final List<View> b = new LinkedList();
  private final Context c;
  private Drawable d;
  private int e;
  private a f;
  private DataSetObserver g = new DataSetObserver()
  {
    public void onChanged()
    {
      a.c(a.this);
    }
    
    public void onInvalidated()
    {
      a.a(a.this).clear();
      a.b(a.this);
    }
  };
  
  a(Context paramContext, f paramf)
  {
    this.c = paramContext;
    this.a = paramf;
    paramf.registerDataSetObserver(this.g);
  }
  
  private View a()
  {
    if (this.b.size() > 0) {
      return (View)this.b.remove(0);
    }
    return null;
  }
  
  private View a(WrapperView paramWrapperView, final int paramInt)
  {
    if (paramWrapperView.d == null) {}
    for (View localView = a();; localView = paramWrapperView.d)
    {
      paramWrapperView = this.a.getHeaderView(paramInt, localView, paramWrapperView);
      if (paramWrapperView != null) {
        break;
      }
      throw new NullPointerException("Header view must not be null.");
    }
    paramWrapperView.setClickable(true);
    paramWrapperView.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if (a.d(a.this) != null)
        {
          long l = a.this.a.getHeaderId(paramInt);
          a.d(a.this).onHeaderClick(paramAnonymousView, paramInt, l);
        }
      }
    });
    return paramWrapperView;
  }
  
  private void a(WrapperView paramWrapperView)
  {
    paramWrapperView = paramWrapperView.d;
    if (paramWrapperView != null)
    {
      paramWrapperView.setVisibility(0);
      this.b.add(paramWrapperView);
    }
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt != 0) && (this.a.getHeaderId(paramInt) == this.a.getHeaderId(paramInt - 1));
  }
  
  void a(Drawable paramDrawable, int paramInt)
  {
    this.d = paramDrawable;
    this.e = paramInt;
    notifyDataSetChanged();
  }
  
  public boolean areAllItemsEnabled()
  {
    return this.a.areAllItemsEnabled();
  }
  
  public boolean equals(Object paramObject)
  {
    return this.a.equals(paramObject);
  }
  
  public int getCount()
  {
    return this.a.getCount();
  }
  
  public View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return ((BaseAdapter)this.a).getDropDownView(paramInt, paramView, paramViewGroup);
  }
  
  public long getHeaderId(int paramInt)
  {
    return this.a.getHeaderId(paramInt);
  }
  
  public View getHeaderView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return this.a.getHeaderView(paramInt, paramView, paramViewGroup);
  }
  
  public Object getItem(int paramInt)
  {
    return this.a.getItem(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return this.a.getItemId(paramInt);
  }
  
  public int getItemViewType(int paramInt)
  {
    return this.a.getItemViewType(paramInt);
  }
  
  public WrapperView getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView2;
    View localView1;
    if (paramView == null)
    {
      paramView = new WrapperView(this.c);
      localView2 = this.a.getView(paramInt, paramView.a, paramViewGroup);
      localView1 = null;
      if (!a(paramInt)) {
        break label102;
      }
      a(paramView);
      label49:
      if ((!(localView2 instanceof Checkable)) || ((paramView instanceof CheckableWrapperView))) {
        break label113;
      }
      paramViewGroup = new CheckableWrapperView(this.c);
    }
    for (;;)
    {
      paramViewGroup.a(localView2, localView1, this.d, this.e);
      return paramViewGroup;
      paramView = (WrapperView)paramView;
      break;
      label102:
      localView1 = a(paramView, paramInt);
      break label49;
      label113:
      paramViewGroup = paramView;
      if (!(localView2 instanceof Checkable))
      {
        paramViewGroup = paramView;
        if ((paramView instanceof CheckableWrapperView)) {
          paramViewGroup = new WrapperView(this.c);
        }
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return this.a.getViewTypeCount();
  }
  
  public boolean hasStableIds()
  {
    return this.a.hasStableIds();
  }
  
  public int hashCode()
  {
    return this.a.hashCode();
  }
  
  public boolean isEmpty()
  {
    return this.a.isEmpty();
  }
  
  public boolean isEnabled(int paramInt)
  {
    return this.a.isEnabled(paramInt);
  }
  
  public void notifyDataSetChanged()
  {
    ((BaseAdapter)this.a).notifyDataSetChanged();
  }
  
  public void notifyDataSetInvalidated()
  {
    ((BaseAdapter)this.a).notifyDataSetInvalidated();
  }
  
  public void setOnHeaderClickListener(a parama)
  {
    this.f = parama;
  }
  
  public String toString()
  {
    return this.a.toString();
  }
  
  static abstract interface a
  {
    public abstract void onHeaderClick(View paramView, int paramInt, long paramLong);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/view/stickylistheaders/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */