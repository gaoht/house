package android.support.transition;

import android.util.Log;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ao
  extends an
{
  private static Method a;
  private static boolean b;
  
  private void a()
  {
    if (!b) {}
    try
    {
      a = ViewGroup.class.getDeclaredMethod("suppressLayout", new Class[] { Boolean.TYPE });
      a.setAccessible(true);
      b = true;
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        Log.i("ViewUtilsApi18", "Failed to retrieve suppressLayout method", localNoSuchMethodException);
      }
    }
  }
  
  public al getOverlay(ViewGroup paramViewGroup)
  {
    return new ak(paramViewGroup);
  }
  
  public void suppressLayout(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    a();
    if (a != null) {}
    try
    {
      a.invoke(paramViewGroup, new Object[] { Boolean.valueOf(paramBoolean) });
      return;
    }
    catch (IllegalAccessException paramViewGroup)
    {
      Log.i("ViewUtilsApi18", "Failed to invoke suppressLayout method", paramViewGroup);
      return;
    }
    catch (InvocationTargetException paramViewGroup)
    {
      Log.i("ViewUtilsApi18", "Error invoking suppressLayout method", paramViewGroup);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/transition/ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */