package com.ziroom.ziroomcustomer.bestgoods.c;

import android.app.Activity;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class a
{
  private static List<WeakReference<Activity>> a;
  private static a b;
  private static Map<String, Integer> c;
  private static int d = -1;
  
  public static a getAppManager()
  {
    if (b == null) {
      b = new a();
    }
    return b;
  }
  
  public void addActivity(Activity paramActivity)
  {
    if (a == null) {
      a = new ArrayList();
    }
    Object localObject = paramActivity.getClass().getName();
    if ((c != null) && (c.containsKey(localObject)))
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = a.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if (((String)localObject).equals(((Activity)localWeakReference.get()).getClass().getName())) {
          localArrayList.add(localWeakReference);
        }
      }
      if (localArrayList.size() < ((Integer)c.get(localObject)).intValue())
      {
        a.add(new WeakReference(paramActivity));
        localArrayList.clear();
        return;
      }
      localObject = (WeakReference)localArrayList.remove(0);
      a.remove(localObject);
      finishActivity((Activity)((WeakReference)localObject).get());
      a.add(new WeakReference(paramActivity));
      localArrayList.clear();
      return;
    }
    a.add(new WeakReference(paramActivity));
  }
  
  public void addReservePageCount(String paramString, int paramInt)
  {
    if (c == null) {
      c = new HashMap();
    }
    c.put(paramString, Integer.valueOf(paramInt));
  }
  
  public Activity currentActivity()
  {
    if ((a != null) && (a.size() > 0)) {
      return (Activity)((WeakReference)a.get(a.size() - 1)).get();
    }
    return null;
  }
  
  public void finishActivity()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (a != null)
    {
      localObject1 = localObject2;
      if (a.size() > 0) {
        localObject1 = (Activity)((WeakReference)a.remove(a.size() - 1)).get();
      }
    }
    finishActivity((Activity)localObject1);
  }
  
  public void finishActivity(Activity paramActivity)
  {
    if ((paramActivity != null) && (!paramActivity.isFinishing())) {
      paramActivity.finish();
    }
  }
  
  public void finishActivity(Class<?> paramClass)
  {
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      Activity localActivity = (Activity)localWeakReference.get();
      if (((Activity)localWeakReference.get()).getClass().getName().equals(paramClass.getName()))
      {
        a.remove(localActivity);
        finishActivity(localActivity);
      }
    }
  }
  
  public void finishAllActivity()
  {
    int j = a.size();
    int i = 0;
    while (i < j)
    {
      finishActivity((Activity)((WeakReference)a.remove(i)).get());
      i += 1;
    }
    a.clear();
  }
  
  public int getReservePageCount()
  {
    return d;
  }
  
  public void removeAc(Activity paramActivity)
  {
    if ((a != null) && (a.size() > 0))
    {
      Iterator localIterator = a.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if (localWeakReference.get() == paramActivity) {
          a.remove(localWeakReference);
        }
      }
    }
  }
  
  public void removeReservePage(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (c != null) && (c.size() > 0)) {
      c.remove(paramString);
    }
  }
  
  public void setReservePageCount(int paramInt)
  {
    d = paramInt;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/bestgoods/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */