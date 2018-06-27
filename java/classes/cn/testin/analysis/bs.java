package cn.testin.analysis;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class bs
  extends cg<Activity>
{
  private final Handler a = new Handler(Looper.getMainLooper());
  private final Map<String, List<bv>> b = new HashMap();
  private Map<Integer, List<bu>> c = new HashMap();
  private final String d = "EditState";
  
  private void a(Activity paramActivity, View paramView, List<bv> paramList)
  {
    synchronized (this.c)
    {
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        bu localbu = new bu(paramView, (bv)paramList.get(i), this.a);
        int k = paramActivity.hashCode();
        List localList = (List)this.c.get(Integer.valueOf(k));
        Object localObject = localList;
        if (localList == null)
        {
          localObject = new ArrayList();
          this.c.put(Integer.valueOf(k), localObject);
        }
        ((List)localObject).add(localbu);
        i += 1;
      }
      return;
    }
  }
  
  private void c()
  {
    if (Thread.currentThread() == this.a.getLooper().getThread())
    {
      d();
      return;
    }
    this.a.post(new bt(this));
  }
  
  private void d()
  {
    for (;;)
    {
      Object localObject3;
      Object localObject4;
      View localView;
      try
      {
        Iterator localIterator = b().iterator();
        if (localIterator.hasNext())
        {
          localObject3 = (Activity)localIterator.next();
          localObject4 = localObject3.getClass().getCanonicalName();
          localView = ((Activity)localObject3).getWindow().getDecorView().getRootView();
          synchronized (this.c)
          {
            int i = localObject3.hashCode();
            if (!this.c.containsKey(Integer.valueOf(i))) {
              break label144;
            }
            localObject3 = ((List)this.c.get(Integer.valueOf(i))).iterator();
            if (!((Iterator)localObject3).hasNext()) {
              break label138;
            }
            ((bu)((Iterator)localObject3).next()).run();
          }
        }
        return;
      }
      catch (Exception localException)
      {
        ar.b(localException);
      }
      label138:
      continue;
      label144:
      synchronized (this.b)
      {
        localObject4 = (List)this.b.get(localObject4);
        if (localObject4 == null) {
          continue;
        }
        a((Activity)localObject3, localView, (List)localObject4);
      }
    }
  }
  
  public void a()
  {
    c();
  }
  
  public void a(Activity paramActivity)
  {
    super.a(paramActivity);
  }
  
  public void a(Map<String, List<bv>> paramMap)
  {
    synchronized (this.c)
    {
      Iterator localIterator1 = this.c.entrySet().iterator();
      while (localIterator1.hasNext())
      {
        Iterator localIterator2 = ((List)((Map.Entry)localIterator1.next()).getValue()).iterator();
        if (localIterator2.hasNext()) {
          ((bu)localIterator2.next()).a();
        }
      }
    }
    this.c.clear();
    synchronized (this.b)
    {
      this.b.clear();
      this.b.putAll(paramMap);
      c();
      return;
    }
  }
  
  public void b(Activity paramActivity)
  {
    try
    {
      int i;
      synchronized (this.c)
      {
        i = paramActivity.hashCode();
        if (!this.c.containsKey(Integer.valueOf(i))) {
          break label99;
        }
        paramActivity = ((List)this.c.get(Integer.valueOf(i))).iterator();
        if (paramActivity.hasNext()) {
          ((bu)paramActivity.next()).b();
        }
      }
      this.c.remove(Integer.valueOf(i));
    }
    catch (Exception paramActivity)
    {
      ar.b(paramActivity);
      return;
    }
    label99:
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/bs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */