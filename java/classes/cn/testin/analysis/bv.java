package cn.testin.analysis;

import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;

class bv
{
  private static Field a;
  private static WeakHashMap<View, bz> b = new WeakHashMap();
  private final bx c;
  private final String d = "PathFinder";
  private List<by> e;
  private List<cm> f;
  private WeakReference<View> g;
  
  public bv(List<by> paramList, String paramString)
  {
    this.e = paramList;
    this.f = new ArrayList();
    this.c = new bx();
  }
  
  private View a(by paramby, View paramView, int paramInt)
  {
    int i = this.c.a(paramInt);
    if (a(paramby, paramView))
    {
      this.c.b(paramInt);
      if ((paramby.c == -1) || (paramby.c == i)) {
        return paramView;
      }
    }
    if ((paramby.a == 1) && ((paramView instanceof ViewGroup)))
    {
      paramView = (ViewGroup)paramView;
      int j = paramView.getChildCount();
      i = 0;
      while (i < j)
      {
        View localView = a(paramby, paramView.getChildAt(i), paramInt);
        if (localView != null) {
          return localView;
        }
        i += 1;
      }
    }
    return null;
  }
  
  private void a(RecyclerView paramRecyclerView, List<by> paramList, by paramby)
  {
    try
    {
      if (!b.containsKey(paramRecyclerView))
      {
        cb localcb = new cb(this, paramRecyclerView);
        b.put(paramRecyclerView, localcb);
      }
      ((bz)b.get(paramRecyclerView)).addPath(this, paramList, paramby);
      return;
    }
    catch (Exception paramRecyclerView)
    {
      ar.a(paramRecyclerView);
    }
  }
  
  private void a(RecyclerView paramRecyclerView, List<by> paramList, by paramby, boolean paramBoolean)
  {
    int i = 0;
    View localView;
    if (i < paramRecyclerView.getChildCount())
    {
      localView = paramRecyclerView.getChildAt(i);
      if ((paramRecyclerView.getChildAdapterPosition(localView) != paramby.c) || (localView == null) || (!a(paramby, localView))) {}
    }
    for (;;)
    {
      a(localView, paramList, paramBoolean);
      if (paramBoolean) {
        a(paramRecyclerView, paramList, paramby);
      }
      return;
      i += 1;
      break;
      localView = null;
    }
  }
  
  private void a(View paramView, List<by> paramList)
  {
    int j = 0;
    if (paramList.isEmpty()) {
      c(paramView);
    }
    while (!(paramView instanceof ViewGroup)) {
      return;
    }
    if (this.c.a())
    {
      Log.v("PathFinder", "Path is too deep, will not match");
      return;
    }
    Object localObject = (ViewGroup)paramView;
    paramView = (by)paramList.get(0);
    paramList = paramList.subList(1, paramList.size());
    int k = ((ViewGroup)localObject).getChildCount();
    int m = this.c.b();
    if ((paramView.c != -1) && (fn.a(localObject)))
    {
      localObject = fm.a((ViewPager)localObject, paramView.c);
      if ((localObject != null) && (a(paramView, (View)localObject))) {
        a((View)localObject, paramList);
      }
    }
    for (;;)
    {
      this.c.c();
      return;
      if ((paramView.c != -1) && ((localObject instanceof AbsListView)))
      {
        a((AbsListView)localObject, paramList, paramView, true);
      }
      else
      {
        int i = j;
        if (paramView.c != -1)
        {
          i = j;
          if (fn.b(localObject))
          {
            a((RecyclerView)localObject, paramList, paramView, true);
            continue;
          }
        }
        do
        {
          i += 1;
          if (i >= k) {
            break;
          }
          View localView = a(paramView, ((ViewGroup)localObject).getChildAt(i), m);
          if (localView != null) {
            a(localView, paramList);
          }
        } while ((paramView.c < 0) || (this.c.a(m) <= paramView.c));
      }
    }
  }
  
  private void a(View paramView, List<by> paramList, boolean paramBoolean)
  {
    View localView = c();
    if (localView != paramView)
    {
      d(paramView);
      if (localView != null) {
        b();
      }
      if (paramView != null) {
        a(paramView, paramList);
      }
    }
    while ((!paramBoolean) || (paramView == null)) {
      return;
    }
    a(paramView, paramList);
  }
  
  private void a(AbsListView paramAbsListView, List<by> paramList, by paramby)
  {
    try
    {
      if (a == null)
      {
        a = AbsListView.class.getDeclaredField("mOnScrollListener");
        a.setAccessible(true);
      }
      AbsListView.OnScrollListener localOnScrollListener = (AbsListView.OnScrollListener)a.get(paramAbsListView);
      Object localObject;
      if (localOnScrollListener != null)
      {
        localObject = localOnScrollListener;
        if ((localOnScrollListener instanceof ca)) {}
      }
      else
      {
        localObject = new ca(this, paramAbsListView, localOnScrollListener);
        b.put(paramAbsListView, (ca)localObject);
      }
      ((ca)localObject).addPath(this, paramList, paramby);
      return;
    }
    catch (Exception paramAbsListView)
    {
      ar.a(paramAbsListView);
    }
  }
  
  private void a(AbsListView paramAbsListView, List<by> paramList, by paramby, boolean paramBoolean)
  {
    int i = paramAbsListView.getFirstVisiblePosition();
    View localView;
    if ((paramby.c >= i) && (paramby.c <= paramAbsListView.getLastVisiblePosition()))
    {
      localView = paramAbsListView.getChildAt(paramby.c - i);
      if ((localView == null) || (!a(paramby, localView))) {}
    }
    for (;;)
    {
      a(localView, paramList, paramBoolean);
      if (paramBoolean) {
        a(paramAbsListView, paramList, paramby);
      }
      return;
      localView = null;
    }
  }
  
  private boolean a(by paramby, View paramView)
  {
    if ((paramby.b != null) && (!a(paramView, paramby.b))) {}
    String str;
    do
    {
      do
      {
        return false;
      } while (((-1 != paramby.d) && (paramView.getId() != paramby.d)) || ((paramby.e != null) && (!paramby.e.equals(paramView.getContentDescription()))));
      str = paramby.f;
    } while ((paramby.f != null) && ((paramView.getTag() == null) || (!str.equals(paramView.getTag().toString()))));
    return true;
  }
  
  private static boolean a(Object paramObject, String paramString)
  {
    for (paramObject = paramObject.getClass();; paramObject = ((Class)paramObject).getSuperclass())
    {
      if (((Class)paramObject).getCanonicalName().equals(paramString)) {
        return true;
      }
      if (paramObject == Object.class) {
        return false;
      }
    }
  }
  
  private void b()
  {
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext()) {
      ((cm)localIterator.next()).a();
    }
  }
  
  private View c()
  {
    if (this.g == null) {
      return null;
    }
    return (View)this.g.get();
  }
  
  private void d(View paramView)
  {
    if (paramView == null) {}
    for (paramView = null;; paramView = new WeakReference(paramView))
    {
      this.g = paramView;
      return;
    }
  }
  
  public void a()
  {
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext()) {
      ((cm)localIterator.next()).a();
    }
    localIterator = b.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      View localView = (View)localEntry.getKey();
      ((bz)localEntry.getValue()).cleanUp(localView);
    }
    this.g = null;
    b.clear();
  }
  
  public void a(View paramView)
  {
    b(paramView);
  }
  
  public void a(cm paramcm)
  {
    this.f.add(paramcm);
  }
  
  public void b(View paramView)
  {
    if (this.e.isEmpty()) {}
    List localList;
    do
    {
      return;
      if (this.c.a())
      {
        Log.w("PathFinder", "There appears to be a concurrency issue in the pathfinding code. Path will not be matched.");
        return;
      }
      by localby = (by)this.e.get(0);
      localList = this.e.subList(1, this.e.size());
      paramView = a(localby, paramView, this.c.b());
      this.c.c();
    } while (paramView == null);
    a(paramView, localList);
  }
  
  public void c(View paramView)
  {
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext()) {
      ((cm)localIterator.next()).a(paramView);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/bv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */