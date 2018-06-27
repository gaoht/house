package cn.testin.analysis;

import android.text.TextUtils;

public class fn
{
  public static boolean a(Object paramObject)
  {
    return a(paramObject, "android.support.v4.view.ViewPager");
  }
  
  public static boolean a(Object paramObject, String paramString)
  {
    if ((paramObject == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    try
    {
      paramString = Class.forName(paramString);
      boolean bool = paramObject.getClass().isAssignableFrom(paramString);
      return bool;
    }
    catch (ClassNotFoundException paramObject)
    {
      ((ClassNotFoundException)paramObject).printStackTrace();
    }
    return false;
  }
  
  public static boolean b(Object paramObject)
  {
    return a(paramObject, "android.support.v7.widget.RecyclerView");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/fn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */