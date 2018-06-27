package com.ziroom.ziroomcustomer.newmovehouse.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.freelxl.baselibrary.f.d;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseFragment;
import java.util.Arrays;

public class LinkageSelectorFragment
  extends BaseFragment
{
  private final int a = 1610612736;
  private final int b = 536870912;
  private final int c = 1073741824;
  private ListView d;
  private ListView e;
  private BaseAdapter f;
  private BaseAdapter g;
  private a h;
  private int[] i;
  private int[] j;
  private int[] k;
  private int l;
  private boolean m;
  
  private LinkageSelectorFragment(a parama)
  {
    this.h = parama;
    c();
  }
  
  private void c()
  {
    d();
    this.f = new BaseAdapter()
    {
      public int getCount()
      {
        if ((LinkageSelectorFragment.a(LinkageSelectorFragment.this) == null) || (LinkageSelectorFragment.a(LinkageSelectorFragment.this).getItemIndex() == null)) {
          return 0;
        }
        return LinkageSelectorFragment.a(LinkageSelectorFragment.this).getItemIndex().length;
      }
      
      public Object getItem(int paramAnonymousInt)
      {
        if (LinkageSelectorFragment.a(LinkageSelectorFragment.this) == null) {
          throw new RuntimeException("");
        }
        if (LinkageSelectorFragment.b(LinkageSelectorFragment.this) == paramAnonymousInt) {
          return Integer.valueOf(LinkageSelectorFragment.a(LinkageSelectorFragment.this).getLeftItem(paramAnonymousInt).hashCode() + 1);
        }
        return Integer.valueOf(LinkageSelectorFragment.a(LinkageSelectorFragment.this).getLeftItem(paramAnonymousInt).hashCode());
      }
      
      public long getItemId(int paramAnonymousInt)
      {
        return paramAnonymousInt;
      }
      
      public View getView(int paramAnonymousInt, View paramAnonymousView, ViewGroup paramAnonymousViewGroup)
      {
        if (LinkageSelectorFragment.a(LinkageSelectorFragment.this) == null) {
          throw new RuntimeException("");
        }
        LinkageSelectorFragment.a locala = LinkageSelectorFragment.a(LinkageSelectorFragment.this);
        if (paramAnonymousInt == LinkageSelectorFragment.b(LinkageSelectorFragment.this)) {}
        for (boolean bool = true;; bool = false) {
          return locala.getLeftView(paramAnonymousInt, paramAnonymousView, paramAnonymousViewGroup, bool);
        }
      }
    };
    this.g = new BaseAdapter()
    {
      public int getCount()
      {
        if (LinkageSelectorFragment.c(LinkageSelectorFragment.this) == null) {
          return 0;
        }
        return LinkageSelectorFragment.c(LinkageSelectorFragment.this).length;
      }
      
      public Object getItem(int paramAnonymousInt)
      {
        paramAnonymousInt = LinkageSelectorFragment.c(LinkageSelectorFragment.this)[paramAnonymousInt];
        d.d("mAdapterRight", "mAdapterRight==================" + paramAnonymousInt + "===" + (paramAnonymousInt & 0x60000000) + "====" + (paramAnonymousInt & 0x9FFFFFFF));
        if ((paramAnonymousInt & 0x60000000) == 536870912)
        {
          if (LinkageSelectorFragment.b(LinkageSelectorFragment.this) == (paramAnonymousInt & 0x9FFFFFFF)) {
            return Integer.valueOf(LinkageSelectorFragment.a(LinkageSelectorFragment.this).getLeftItem(paramAnonymousInt & 0x9FFFFFFF).hashCode() + 1);
          }
          return Integer.valueOf(LinkageSelectorFragment.a(LinkageSelectorFragment.this).getLeftItem(paramAnonymousInt & 0x9FFFFFFF).hashCode());
        }
        if ((paramAnonymousInt & 0x60000000) == 1073741824) {
          return Integer.valueOf(LinkageSelectorFragment.a(LinkageSelectorFragment.this).getRightItem(paramAnonymousInt & 0x9FFFFFFF).hashCode());
        }
        return null;
      }
      
      public long getItemId(int paramAnonymousInt)
      {
        return paramAnonymousInt;
      }
      
      public int getItemViewType(int paramAnonymousInt)
      {
        paramAnonymousInt = LinkageSelectorFragment.c(LinkageSelectorFragment.this)[paramAnonymousInt];
        if ((paramAnonymousInt & 0x60000000) == 536870912) {}
        while ((paramAnonymousInt & 0x60000000) != 1073741824) {
          return 0;
        }
        return 1;
      }
      
      public View getView(int paramAnonymousInt, View paramAnonymousView, ViewGroup paramAnonymousViewGroup)
      {
        boolean bool = true;
        int i = LinkageSelectorFragment.c(LinkageSelectorFragment.this)[paramAnonymousInt];
        d.d("mAdapterRight", "mAdapterRight===getView===============" + i + "===" + (0x60000000 & i) + "====" + (i & 0x9FFFFFFF));
        if (getItemViewType(paramAnonymousInt) == 0)
        {
          LinkageSelectorFragment.a locala = LinkageSelectorFragment.a(LinkageSelectorFragment.this);
          if ((i & 0x9FFFFFFF) == LinkageSelectorFragment.b(LinkageSelectorFragment.this)) {}
          for (;;)
          {
            return locala.getRightParentView(paramAnonymousInt, i & 0x9FFFFFFF, paramAnonymousView, paramAnonymousViewGroup, bool);
            bool = false;
          }
        }
        if (getItemViewType(paramAnonymousInt) == 1) {
          return LinkageSelectorFragment.a(LinkageSelectorFragment.this).getRightItemView(paramAnonymousInt, i & 0x9FFFFFFF, paramAnonymousView, paramAnonymousViewGroup);
        }
        return null;
      }
      
      public int getViewTypeCount()
      {
        return 2;
      }
    };
  }
  
  private void d()
  {
    if (this.h != null) {}
    for (int[] arrayOfInt = this.h.getItemIndex();; arrayOfInt = null)
    {
      if (arrayOfInt == null)
      {
        this.i = null;
        return;
      }
      int i1 = arrayOfInt.length;
      int i2 = arrayOfInt.length;
      int n = 0;
      while (n < i2)
      {
        i1 += arrayOfInt[n];
        n += 1;
      }
      this.i = new int[i1];
      this.j = new int[arrayOfInt.length];
      this.k = new int[i1];
      int i6 = arrayOfInt.length;
      int i4 = 0;
      i2 = 0;
      int i3;
      for (n = 0; i2 < arrayOfInt.length; n = i3)
      {
        this.i[i4] = (536870912 + i2);
        this.j[i2] = i4;
        this.k[i4] = i2;
        int i5 = i4 + 1;
        int i7 = arrayOfInt[i2];
        i4 = 0;
        i3 = n;
        n = i5;
        while ((i4 < i7) && (i3 < i1 - i6))
        {
          this.i[n] = (1073741824 + i3);
          this.k[n] = i2;
          i3 += 1;
          i4 += 1;
          n += 1;
        }
        i2 += 1;
        i4 = n;
      }
      d.d("fragment", "======" + Arrays.toString(this.i));
      return;
    }
  }
  
  public static LinkageSelectorFragment getInstance(a parama)
  {
    return new LinkageSelectorFragment(parama);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130903929, paramViewGroup, false);
    this.d = ((ListView)paramLayoutInflater.findViewById(2131694150));
    this.e = ((ListView)paramLayoutInflater.findViewById(2131694151));
    this.d.setAdapter(this.f);
    this.e.setAdapter(this.g);
    this.d.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        d.d("setOnItemClickListener", "*****" + paramAnonymousInt);
        if ((LinkageSelectorFragment.a(LinkageSelectorFragment.this) != null) && (LinkageSelectorFragment.a(LinkageSelectorFragment.this).getItemIndex() != null) && (LinkageSelectorFragment.a(LinkageSelectorFragment.this).getItemIndex().length > paramAnonymousInt))
        {
          if (LinkageSelectorFragment.b(LinkageSelectorFragment.this) != paramAnonymousInt)
          {
            LinkageSelectorFragment.a(LinkageSelectorFragment.this, paramAnonymousInt);
            LinkageSelectorFragment.a(LinkageSelectorFragment.this, true);
            LinkageSelectorFragment.d(LinkageSelectorFragment.this).notifyDataSetChanged();
            LinkageSelectorFragment.e(LinkageSelectorFragment.this).notifyDataSetChanged();
            LinkageSelectorFragment.g(LinkageSelectorFragment.this).setSelection(LinkageSelectorFragment.f(LinkageSelectorFragment.this)[paramAnonymousInt]);
          }
        }
        else {
          return;
        }
        LinkageSelectorFragment.a(LinkageSelectorFragment.this, false);
      }
    });
    this.e.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        if ((LinkageSelectorFragment.h(LinkageSelectorFragment.this) == null) || (LinkageSelectorFragment.h(LinkageSelectorFragment.this).length == 0)) {}
        do
        {
          return;
          paramAnonymousInt1 = LinkageSelectorFragment.h(LinkageSelectorFragment.this)[LinkageSelectorFragment.g(LinkageSelectorFragment.this).getFirstVisiblePosition()];
        } while ((LinkageSelectorFragment.b(LinkageSelectorFragment.this) == paramAnonymousInt1) || (LinkageSelectorFragment.i(LinkageSelectorFragment.this)));
        LinkageSelectorFragment.a(LinkageSelectorFragment.this, paramAnonymousInt1);
        LinkageSelectorFragment.d(LinkageSelectorFragment.this).notifyDataSetChanged();
        LinkageSelectorFragment.e(LinkageSelectorFragment.this).notifyDataSetChanged();
      }
      
      public void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        LinkageSelectorFragment.a(LinkageSelectorFragment.this, false);
      }
    });
    return paramLayoutInflater;
  }
  
  public void refreshData(a parama)
  {
    if (parama == null) {
      throw new RuntimeException("");
    }
    this.h = parama;
    this.f.notifyDataSetChanged();
    this.g.notifyDataSetChanged();
  }
  
  public static abstract interface a
  {
    public abstract int[] getItemIndex();
    
    public abstract Object getLeftItem(int paramInt);
    
    public abstract View getLeftView(int paramInt, View paramView, ViewGroup paramViewGroup, boolean paramBoolean);
    
    public abstract Object getRightItem(int paramInt);
    
    public abstract View getRightItemView(int paramInt1, int paramInt2, View paramView, ViewGroup paramViewGroup);
    
    public abstract View getRightParentView(int paramInt1, int paramInt2, View paramView, ViewGroup paramViewGroup, boolean paramBoolean);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/fragment/LinkageSelectorFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */