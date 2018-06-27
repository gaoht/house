package cn.testin.analysis;

import android.annotation.TargetApi;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@TargetApi(11)
public class fm
{
  private static Field a;
  private static Field b;
  private static Field c;
  
  public static int a(PagerAdapter paramPagerAdapter)
  {
    if (paramPagerAdapter == null) {
      return -1;
    }
    if (paramPagerAdapter.getCount() < 100) {
      return paramPagerAdapter.getCount();
    }
    Field[] arrayOfField = paramPagerAdapter.getClass().getDeclaredFields();
    if (arrayOfField == null) {
      return paramPagerAdapter.getCount();
    }
    int i = a(paramPagerAdapter, arrayOfField, true);
    if (i != -1) {
      return i;
    }
    return a(paramPagerAdapter, arrayOfField, false);
  }
  
  private static int a(PagerAdapter paramPagerAdapter, Field[] paramArrayOfField, boolean paramBoolean)
  {
    int j = paramArrayOfField.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramArrayOfField[i];
      try
      {
        int k;
        if (((Field)localObject).getType().isAssignableFrom(List.class))
        {
          ((Field)localObject).setAccessible(true);
          localObject = (List)((Field)localObject).get(paramPagerAdapter);
          k = ((List)localObject).size();
          if (k > 0)
          {
            if (!paramBoolean) {
              return k;
            }
            if ((((List)localObject).get(0) instanceof View)) {
              return k;
            }
          }
        }
        else if (((Field)localObject).getType().isArray())
        {
          ((Field)localObject).setAccessible(true);
          localObject = (Object[])((Field)localObject).get(paramPagerAdapter);
          k = localObject.length;
          if (k > 0)
          {
            if (!paramBoolean) {
              return k;
            }
            boolean bool = localObject[0] instanceof View;
            if (bool) {
              return k;
            }
          }
        }
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        localIllegalAccessException.printStackTrace();
        i += 1;
      }
    }
    return paramPagerAdapter.getCount();
  }
  
  public static int a(ViewPager paramViewPager, View paramView)
  {
    Object localObject = paramViewPager.getAdapter();
    if (localObject == null) {
      return -1;
    }
    try
    {
      int j = a((PagerAdapter)localObject);
      if (j == -1) {
        return -1;
      }
      if (a == null)
      {
        a = ViewPager.class.getDeclaredField("mItems");
        a.setAccessible(true);
      }
      paramViewPager = (ArrayList)a.get(paramViewPager);
      int i = 0;
      while (i < paramViewPager.size())
      {
        localObject = paramViewPager.get(i);
        if (c == null)
        {
          c = localObject.getClass().getDeclaredField("object");
          c.setAccessible(true);
        }
        if (a(c.get(localObject)) == paramView)
        {
          if (b == null)
          {
            b = localObject.getClass().getDeclaredField("position");
            b.setAccessible(true);
          }
          i = ((Integer)b.get(localObject)).intValue();
          return i % j;
        }
        i += 1;
      }
      return -1;
    }
    catch (Exception paramViewPager)
    {
      paramViewPager.printStackTrace();
    }
  }
  
  public static View a(ViewPager paramViewPager, int paramInt)
  {
    Object localObject = paramViewPager.getAdapter();
    if (localObject == null) {
      return null;
    }
    try
    {
      int j = a((PagerAdapter)localObject);
      if (j == -1) {
        return null;
      }
      if (a == null)
      {
        a = ViewPager.class.getDeclaredField("mItems");
        a.setAccessible(true);
      }
      paramViewPager = (ArrayList)a.get(paramViewPager);
      int i = 0;
      while (i < paramViewPager.size())
      {
        localObject = paramViewPager.get(i);
        if (b == null)
        {
          b = localObject.getClass().getDeclaredField("position");
          b.setAccessible(true);
        }
        if (((Integer)b.get(localObject)).intValue() % j == paramInt % j)
        {
          if (c == null)
          {
            c = localObject.getClass().getDeclaredField("object");
            c.setAccessible(true);
          }
          paramViewPager = a(c.get(localObject));
          return paramViewPager;
        }
        i += 1;
      }
      return null;
    }
    catch (Exception paramViewPager)
    {
      paramViewPager.printStackTrace();
    }
  }
  
  private static View a(Object paramObject)
  {
    if ((paramObject instanceof View)) {
      return (View)paramObject;
    }
    if ((paramObject instanceof android.support.v4.app.Fragment)) {
      return ((android.support.v4.app.Fragment)paramObject).getView();
    }
    if ((paramObject instanceof android.app.Fragment)) {
      return ((android.app.Fragment)paramObject).getView();
    }
    return null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/fm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */