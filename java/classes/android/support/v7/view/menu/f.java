package android.support.v7.view.menu;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.appcompat.R.layout;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import java.util.ArrayList;

public class f
  implements n, AdapterView.OnItemClickListener
{
  Context a;
  LayoutInflater b;
  h c;
  ExpandedMenuView d;
  int e;
  int f;
  int g;
  a h;
  private n.a i;
  private int j;
  
  public f(int paramInt1, int paramInt2)
  {
    this.g = paramInt1;
    this.f = paramInt2;
  }
  
  public f(Context paramContext, int paramInt)
  {
    this(paramInt, 0);
    this.a = paramContext;
    this.b = LayoutInflater.from(this.a);
  }
  
  public boolean collapseItemActionView(h paramh, j paramj)
  {
    return false;
  }
  
  public boolean expandItemActionView(h paramh, j paramj)
  {
    return false;
  }
  
  public boolean flagActionItems()
  {
    return false;
  }
  
  public ListAdapter getAdapter()
  {
    if (this.h == null) {
      this.h = new a();
    }
    return this.h;
  }
  
  public int getId()
  {
    return this.j;
  }
  
  public o getMenuView(ViewGroup paramViewGroup)
  {
    if (this.d == null)
    {
      this.d = ((ExpandedMenuView)this.b.inflate(R.layout.abc_expanded_menu_layout, paramViewGroup, false));
      if (this.h == null) {
        this.h = new a();
      }
      this.d.setAdapter(this.h);
      this.d.setOnItemClickListener(this);
    }
    return this.d;
  }
  
  public void initForMenu(Context paramContext, h paramh)
  {
    if (this.f != 0)
    {
      this.a = new ContextThemeWrapper(paramContext, this.f);
      this.b = LayoutInflater.from(this.a);
    }
    for (;;)
    {
      this.c = paramh;
      if (this.h != null) {
        this.h.notifyDataSetChanged();
      }
      return;
      if (this.a != null)
      {
        this.a = paramContext;
        if (this.b == null) {
          this.b = LayoutInflater.from(this.a);
        }
      }
    }
  }
  
  public void onCloseMenu(h paramh, boolean paramBoolean)
  {
    if (this.i != null) {
      this.i.onCloseMenu(paramh, paramBoolean);
    }
  }
  
  @Instrumented
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    VdsAgent.onItemClick(this, paramAdapterView, paramView, paramInt, paramLong);
    this.c.performItemAction(this.h.getItem(paramInt), this, 0);
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    restoreHierarchyState((Bundle)paramParcelable);
  }
  
  public Parcelable onSaveInstanceState()
  {
    if (this.d == null) {
      return null;
    }
    Bundle localBundle = new Bundle();
    saveHierarchyState(localBundle);
    return localBundle;
  }
  
  public boolean onSubMenuSelected(t paramt)
  {
    if (!paramt.hasVisibleItems()) {
      return false;
    }
    new i(paramt).show(null);
    if (this.i != null) {
      this.i.onOpenSubMenu(paramt);
    }
    return true;
  }
  
  public void restoreHierarchyState(Bundle paramBundle)
  {
    paramBundle = paramBundle.getSparseParcelableArray("android:menu:list");
    if (paramBundle != null) {
      this.d.restoreHierarchyState(paramBundle);
    }
  }
  
  public void saveHierarchyState(Bundle paramBundle)
  {
    SparseArray localSparseArray = new SparseArray();
    if (this.d != null) {
      this.d.saveHierarchyState(localSparseArray);
    }
    paramBundle.putSparseParcelableArray("android:menu:list", localSparseArray);
  }
  
  public void setCallback(n.a parama)
  {
    this.i = parama;
  }
  
  public void setId(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void setItemIndexOffset(int paramInt)
  {
    this.e = paramInt;
    if (this.d != null) {
      updateMenuView(false);
    }
  }
  
  public void updateMenuView(boolean paramBoolean)
  {
    if (this.h != null) {
      this.h.notifyDataSetChanged();
    }
  }
  
  private class a
    extends BaseAdapter
  {
    private int b = -1;
    
    public a()
    {
      a();
    }
    
    void a()
    {
      j localj = f.this.c.getExpandedItem();
      if (localj != null)
      {
        ArrayList localArrayList = f.this.c.getNonActionItems();
        int j = localArrayList.size();
        int i = 0;
        while (i < j)
        {
          if ((j)localArrayList.get(i) == localj)
          {
            this.b = i;
            return;
          }
          i += 1;
        }
      }
      this.b = -1;
    }
    
    public int getCount()
    {
      int i = f.this.c.getNonActionItems().size() - f.this.e;
      if (this.b < 0) {
        return i;
      }
      return i - 1;
    }
    
    public j getItem(int paramInt)
    {
      ArrayList localArrayList = f.this.c.getNonActionItems();
      int i = f.this.e + paramInt;
      paramInt = i;
      if (this.b >= 0)
      {
        paramInt = i;
        if (i >= this.b) {
          paramInt = i + 1;
        }
      }
      return (j)localArrayList.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null) {
        paramView = f.this.b.inflate(f.this.g, paramViewGroup, false);
      }
      for (;;)
      {
        ((o.a)paramView).initialize(getItem(paramInt), 0);
        return paramView;
      }
    }
    
    public void notifyDataSetChanged()
    {
      a();
      super.notifyDataSetChanged();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/view/menu/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */