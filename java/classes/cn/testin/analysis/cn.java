package cn.testin.analysis;

import android.os.Build.VERSION;
import android.util.Log;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;

public class cn
  extends cr
{
  private final int a;
  private final WeakHashMap<View, co> b;
  
  public cn(int paramInt, String paramString1, String paramString2, String paramString3, cs paramcs)
  {
    super(paramString1, paramString2, paramString3, paramcs, false);
    this.a = paramInt;
    this.b = new WeakHashMap();
  }
  
  private View.AccessibilityDelegate d(View paramView)
  {
    if (Build.VERSION.SDK_INT > 16) {
      try
      {
        paramView = (View.AccessibilityDelegate)paramView.getClass().getMethod("getAccessibilityDelegate", new Class[0]).invoke(paramView, new Object[0]);
        return paramView;
      }
      catch (NoSuchMethodException paramView)
      {
        return null;
      }
      catch (IllegalAccessException paramView)
      {
        return null;
      }
      catch (InvocationTargetException paramView)
      {
        Log.w("ViewVisitor", "getAccessibilityDelegate threw an exception when called.", paramView);
        return null;
      }
    }
    try
    {
      Field localField = View.class.getDeclaredField("mAccessibilityDelegate");
      localField.setAccessible(true);
      paramView = (View.AccessibilityDelegate)localField.get(paramView);
      return paramView;
    }
    catch (NoSuchFieldException paramView)
    {
      return null;
    }
    catch (IllegalAccessException paramView) {}
    return null;
  }
  
  public void a()
  {
    Iterator localIterator = this.b.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      View localView = (View)((Map.Entry)localObject).getKey();
      localObject = (co)((Map.Entry)localObject).getValue();
      View.AccessibilityDelegate localAccessibilityDelegate = d(localView);
      if (localAccessibilityDelegate == localObject) {
        localView.setAccessibilityDelegate(((co)localObject).a());
      } else if ((localAccessibilityDelegate instanceof co)) {
        ((co)localAccessibilityDelegate).a((co)localObject);
      }
    }
    this.b.clear();
  }
  
  public void a(View paramView)
  {
    Object localObject = d(paramView);
    if (((localObject instanceof co)) && (((co)localObject).a(c()))) {
      return;
    }
    localObject = new co(this, (View.AccessibilityDelegate)localObject);
    paramView.setAccessibilityDelegate((View.AccessibilityDelegate)localObject);
    this.b.put(paramView, localObject);
    c(paramView);
  }
  
  protected String b()
  {
    return c() + " event when (" + this.a + ")";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/cn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */