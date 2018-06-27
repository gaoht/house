package com.ziroom.ziroomcustomer.minsu.searchlist.widget;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.h;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.webkit.WebView;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ScrollView;

public class a
{
  private View a;
  private a b;
  private int c = Build.VERSION.SDK_INT;
  
  private View a()
  {
    if (this.b == null) {
      return this.a;
    }
    return this.b.getScrollableView();
  }
  
  private static boolean a(RecyclerView paramRecyclerView)
  {
    if (paramRecyclerView != null)
    {
      RecyclerView.h localh = paramRecyclerView.getLayoutManager();
      if ((localh instanceof LinearLayoutManager))
      {
        int i = ((LinearLayoutManager)localh).findFirstVisibleItemPosition();
        paramRecyclerView = paramRecyclerView.getChildAt(0);
        if (paramRecyclerView == null) {
          return true;
        }
        if (i == 0)
        {
          i = ((ViewGroup.MarginLayoutParams)paramRecyclerView.getLayoutParams()).topMargin;
          if (paramRecyclerView.getTop() >= i) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  private static boolean a(WebView paramWebView)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramWebView != null)
    {
      bool1 = bool2;
      if (paramWebView.getScrollY() <= 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private static boolean a(AdapterView paramAdapterView)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramAdapterView != null)
    {
      int i = paramAdapterView.getFirstVisiblePosition();
      paramAdapterView = paramAdapterView.getChildAt(0);
      if (paramAdapterView != null)
      {
        bool1 = bool2;
        if (i == 0)
        {
          bool1 = bool2;
          if (paramAdapterView != null)
          {
            bool1 = bool2;
            if (paramAdapterView.getTop() != 0) {}
          }
        }
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private static boolean a(ScrollView paramScrollView)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramScrollView != null)
    {
      bool1 = bool2;
      if (paramScrollView.getScrollY() <= 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean isTop()
  {
    View localView = a();
    if (localView == null) {
      return false;
    }
    if ((localView instanceof AdapterView)) {
      return a((AdapterView)localView);
    }
    if ((localView instanceof ScrollView)) {
      return a((ScrollView)localView);
    }
    if ((localView instanceof RecyclerView)) {
      return a((RecyclerView)localView);
    }
    if ((localView instanceof WebView)) {
      return a((WebView)localView);
    }
    throw new IllegalStateException("scrollableView must be a instance of AdapterView|ScrollView|RecyclerView");
  }
  
  public void setCurrentScrollableContainer(View paramView)
  {
    this.a = paramView;
  }
  
  public void setCurrentScrollableContainer(a parama)
  {
    this.b = parama;
  }
  
  @SuppressLint({"NewApi"})
  public void smoothScrollBy(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = a();
    if ((localObject instanceof AbsListView))
    {
      localObject = (AbsListView)localObject;
      if (this.c >= 21) {
        ((AbsListView)localObject).fling(paramInt1);
      }
    }
    do
    {
      return;
      ((AbsListView)localObject).smoothScrollBy(paramInt2, paramInt3);
      return;
      if ((localObject instanceof ScrollView))
      {
        ((ScrollView)localObject).fling(paramInt1);
        return;
      }
      if ((localObject instanceof RecyclerView))
      {
        ((RecyclerView)localObject).fling(0, paramInt1);
        return;
      }
    } while (!(localObject instanceof WebView));
    ((WebView)localObject).flingScroll(0, paramInt1);
  }
  
  public static abstract interface a
  {
    public abstract View getScrollableView();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/searchlist/widget/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */