package com.ziroom.ziroomcustomer.widget;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlib.utils.h;
import com.ziroom.ziroomcustomer.base.BaseFragment;
import com.ziroom.ziroomcustomer.util.n;
import java.util.ArrayList;

public class TabListFragment
  extends BaseFragment
{
  private static boolean h = true;
  private ArrayList<String> a;
  private b b;
  private ListView c;
  private ListView d;
  private c e;
  private a f;
  private int g = 0;
  
  private int a(int paramInt)
  {
    int i = 0;
    int k;
    for (int j = paramInt; i < paramInt; j = k)
    {
      k = j;
      if (this.b != null)
      {
        k = j;
        if (this.b.getDetailCount() != null) {
          k = j + this.b.getDetailCount().get(i);
        }
      }
      i += 1;
    }
    return j;
  }
  
  private void a(View paramView)
  {
    this.c = ((ListView)paramView.findViewById(2131694374));
    this.d = ((ListView)paramView.findViewById(2131694375));
  }
  
  private void c()
  {
    Bundle localBundle = getArguments();
    if (localBundle != null)
    {
      this.a = localBundle.getStringArrayList("tabList");
      this.g = localBundle.getInt("tabIndex", 0);
      if ((this.g < 0) || (this.g >= this.a.size())) {
        this.g = 0;
      }
    }
    if ((getActivity() instanceof b)) {
      this.b = ((b)getActivity());
    }
    while (4 == h.getsEnvironment())
    {
      this.e = new c(null);
      this.f = new a(null);
      this.c.setAdapter(this.e);
      this.d.setAdapter(this.f);
      return;
    }
    throw new RuntimeException("Please implements DetailListImpl by your activity!!!");
  }
  
  private void d()
  {
    this.c.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        TabListFragment.a(TabListFragment.this).setSelectPosition(paramAnonymousInt);
        TabListFragment.b(TabListFragment.this).setSelection(TabListFragment.a(TabListFragment.this, paramAnonymousInt));
      }
    });
    this.d.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        if (TabListFragment.c(TabListFragment.this) != null) {
          TabListFragment.c(TabListFragment.this).onItemClick(TabListFragment.d(TabListFragment.this).getRealDetailPosition(paramAnonymousInt), paramAnonymousView);
        }
      }
    });
    this.d.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        if (TabListFragment.d(TabListFragment.this).reachBottom())
        {
          TabListFragment.a(TabListFragment.this).setSelectPosition(TabListFragment.e(TabListFragment.this).size() - 1);
          return;
        }
        TabListFragment.a(TabListFragment.this).setSelectPosition(TabListFragment.d(TabListFragment.this).getRealTitlePosition(paramAnonymousInt1));
      }
      
      public void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {}
    });
  }
  
  public static TabListFragment newInstance(ArrayList<String> paramArrayList, int paramInt)
  {
    TabListFragment localTabListFragment = new TabListFragment();
    Bundle localBundle = new Bundle();
    localBundle.putStringArrayList("tabList", paramArrayList);
    localBundle.putInt("tabIndex", paramInt);
    localTabListFragment.setArguments(localBundle);
    return localTabListFragment;
  }
  
  public void notifyDetail()
  {
    if (this.f != null)
    {
      this.f.notifyDataSetChanged();
      if (h) {
        this.d.setSelection(a(this.g));
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = LayoutInflater.from(getActivity()).inflate(2130903993, paramViewGroup, false);
    a(paramLayoutInflater);
    c();
    d();
    this.e.setSelectPosition(this.g);
    h = true;
    return paramLayoutInflater;
  }
  
  public void onResume()
  {
    super.onResume();
    new Thread(new Runnable()
    {
      public void run()
      {
        try
        {
          Thread.sleep(1000L);
          FragmentActivity localFragmentActivity = TabListFragment.this.getActivity();
          if (localFragmentActivity != null) {
            localFragmentActivity.runOnUiThread(new Runnable()
            {
              public void run()
              {
                TabListFragment.a(false);
              }
            });
          }
          return;
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            localInterruptedException.printStackTrace();
          }
        }
      }
    }).start();
  }
  
  private class a
    extends BaseAdapter
  {
    private a() {}
    
    public int getCount()
    {
      int j = 0;
      int i = 0;
      while ((TabListFragment.e(TabListFragment.this) != null) && (j < TabListFragment.e(TabListFragment.this).size()))
      {
        int k = i + 1;
        i = k;
        if (TabListFragment.c(TabListFragment.this) != null)
        {
          i = k;
          if (TabListFragment.c(TabListFragment.this).getDetailCount() != null) {
            i = k + TabListFragment.c(TabListFragment.this).getDetailCount().get(j);
          }
        }
        j += 1;
      }
      return i;
    }
    
    public Object getItem(int paramInt)
    {
      return Integer.valueOf(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public int getItemViewType(int paramInt)
    {
      int k = 0;
      int j = 0;
      int m;
      for (int i = 1;; i = m)
      {
        if (k <= paramInt)
        {
          k += 1;
          if (k > paramInt) {
            i = 2;
          }
        }
        else
        {
          return i;
        }
        i = k;
        if (TabListFragment.c(TabListFragment.this) != null)
        {
          i = k;
          if (TabListFragment.c(TabListFragment.this).getDetailCount() != null) {
            i = k + TabListFragment.c(TabListFragment.this).getDetailCount().get(j);
          }
        }
        j += 1;
        m = 3;
        k = i;
      }
    }
    
    public int getRealDetailPosition(int paramInt)
    {
      return paramInt - getRealTitlePosition(paramInt) - 1;
    }
    
    public int getRealTitlePosition(int paramInt)
    {
      int i = 0;
      int j = 0;
      for (;;)
      {
        if (i < paramInt)
        {
          int k = i + 1;
          i = k;
          if (TabListFragment.c(TabListFragment.this) != null)
          {
            i = k;
            if (TabListFragment.c(TabListFragment.this).getDetailCount() != null)
            {
              k += TabListFragment.c(TabListFragment.this).getDetailCount().get(j);
              i = k;
              if (k <= paramInt) {}
            }
          }
        }
        else
        {
          return j;
        }
        j += 1;
      }
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      switch (getItemViewType(paramInt))
      {
      default: 
        paramView = new View(TabListFragment.this.getActivity());
        paramView.setLayoutParams(new AbsListView.LayoutParams(-1, 0));
        return paramView;
      case 2: 
        paramView = new TextView(TabListFragment.this.getActivity());
        paramView.setText((CharSequence)TabListFragment.e(TabListFragment.this).get(getRealTitlePosition(paramInt)));
        paramView.setTextColor(Color.parseColor("#ffa000"));
        paramView.setGravity(80);
        paramView.setPadding(0, 0, 0, n.dip2px(TabListFragment.this.getActivity(), 8.0F));
        paramView.setTextSize(12.0F);
        paramView.setLayoutParams(new AbsListView.LayoutParams(-1, n.dip2px(TabListFragment.this.getActivity(), 48.0F)));
        return paramView;
      }
      if (TabListFragment.c(TabListFragment.this) != null) {
        return TabListFragment.c(TabListFragment.this).getView(getRealDetailPosition(paramInt), paramView, paramViewGroup);
      }
      paramView = new View(TabListFragment.this.getActivity());
      paramView.setLayoutParams(new AbsListView.LayoutParams(-1, 0));
      return paramView;
    }
    
    public boolean reachBottom()
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (TabListFragment.b(TabListFragment.this).getChildAt(TabListFragment.b(TabListFragment.this).getChildCount() - 1) != null)
      {
        bool1 = bool2;
        if (TabListFragment.b(TabListFragment.this).getChildAt(TabListFragment.b(TabListFragment.this).getChildCount() - 1).getBottom() == TabListFragment.b(TabListFragment.this).getBottom()) {
          bool1 = true;
        }
      }
      return bool1;
    }
  }
  
  public static abstract interface b
  {
    public abstract SparseIntArray getDetailCount();
    
    public abstract View getView(int paramInt, View paramView, ViewGroup paramViewGroup);
    
    public abstract void onItemClick(int paramInt, View paramView);
  }
  
  private class c
    extends BaseAdapter
  {
    private int b = 0;
    
    private c() {}
    
    public int getCount()
    {
      if (TabListFragment.e(TabListFragment.this) == null) {
        return 0;
      }
      return TabListFragment.e(TabListFragment.this).size();
    }
    
    public Object getItem(int paramInt)
    {
      return TabListFragment.e(TabListFragment.this).get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      paramView = new TextView(TabListFragment.this.getActivity());
      paramView.setText((CharSequence)TabListFragment.e(TabListFragment.this).get(paramInt));
      paramView.setGravity(17);
      paramView.setLayoutParams(new AbsListView.LayoutParams(-1, n.dip2px(TabListFragment.this.getActivity(), 48.0F)));
      paramView.setTextSize(12.0F);
      if (paramInt == this.b)
      {
        paramView.setTextColor(Color.parseColor("#ffa000"));
        paramView.setBackgroundColor(Color.parseColor("#ffffff"));
        return paramView;
      }
      paramView.setTextColor(Color.parseColor("#999999"));
      paramView.setBackgroundColor(Color.parseColor("#00ffffff"));
      return paramView;
    }
    
    public void setSelectPosition(int paramInt)
    {
      if ((paramInt < 0) || (paramInt > TabListFragment.e(TabListFragment.this).size() - 1)) {}
      for (this.b = 0;; this.b = paramInt)
      {
        notifyDataSetChanged();
        return;
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/widget/TabListFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */