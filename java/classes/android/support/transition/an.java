package android.support.transition;

import android.animation.LayoutTransition;
import android.util.Log;
import android.view.ViewGroup;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class an
  implements ap
{
  private static LayoutTransition a;
  private static Field b;
  private static boolean c;
  private static Method d;
  private static boolean e;
  
  private static void a(LayoutTransition paramLayoutTransition)
  {
    if (!e) {}
    try
    {
      d = LayoutTransition.class.getDeclaredMethod("cancel", new Class[0]);
      d.setAccessible(true);
      e = true;
      if (d == null) {}
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        try
        {
          d.invoke(paramLayoutTransition, new Object[0]);
          return;
        }
        catch (IllegalAccessException paramLayoutTransition)
        {
          Log.i("ViewGroupUtilsApi14", "Failed to access cancel method by reflection");
          return;
        }
        catch (InvocationTargetException paramLayoutTransition)
        {
          Log.i("ViewGroupUtilsApi14", "Failed to invoke cancel method by reflection");
        }
        localNoSuchMethodException = localNoSuchMethodException;
        Log.i("ViewGroupUtilsApi14", "Failed to access cancel method by reflection");
      }
    }
  }
  
  public al getOverlay(ViewGroup paramViewGroup)
  {
    return aj.a(paramViewGroup);
  }
  
  public void suppressLayout(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    if (a == null)
    {
      a = new LayoutTransition()
      {
        public boolean isChangingLayout()
        {
          return true;
        }
      };
      a.setAnimator(2, null);
      a.setAnimator(0, null);
      a.setAnimator(1, null);
      a.setAnimator(3, null);
      a.setAnimator(4, null);
    }
    LayoutTransition localLayoutTransition;
    if (paramBoolean)
    {
      localLayoutTransition = paramViewGroup.getLayoutTransition();
      if (localLayoutTransition != null)
      {
        if (localLayoutTransition.isRunning()) {
          a(localLayoutTransition);
        }
        if (localLayoutTransition != a) {
          paramViewGroup.setTag(R.id.transition_layout_save, localLayoutTransition);
        }
      }
      paramViewGroup.setLayoutTransition(a);
    }
    for (;;)
    {
      return;
      paramViewGroup.setLayoutTransition(null);
      if (!c) {}
      try
      {
        b = ViewGroup.class.getDeclaredField("mLayoutSuppressed");
        b.setAccessible(true);
        c = true;
        paramBoolean = bool2;
        if (b != null) {
          paramBoolean = bool1;
        }
        try
        {
          bool1 = b.getBoolean(paramViewGroup);
          paramBoolean = bool1;
          if (bool1)
          {
            paramBoolean = bool1;
            b.setBoolean(paramViewGroup, false);
            paramBoolean = bool1;
          }
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          for (;;)
          {
            Log.i("ViewGroupUtilsApi14", "Failed to get mLayoutSuppressed field by reflection");
          }
        }
        if (paramBoolean) {
          paramViewGroup.requestLayout();
        }
        localLayoutTransition = (LayoutTransition)paramViewGroup.getTag(R.id.transition_layout_save);
        if (localLayoutTransition == null) {
          continue;
        }
        paramViewGroup.setTag(R.id.transition_layout_save, null);
        paramViewGroup.setLayoutTransition(localLayoutTransition);
        return;
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        for (;;)
        {
          Log.i("ViewGroupUtilsApi14", "Failed to access mLayoutSuppressed field by reflection");
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/transition/an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */