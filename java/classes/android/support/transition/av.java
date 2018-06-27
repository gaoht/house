package android.support.transition;

import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class av
  extends au
{
  private static Method a;
  private static boolean b;
  private static Method c;
  private static boolean d;
  
  private void a()
  {
    if (!b) {}
    try
    {
      a = View.class.getDeclaredMethod("setTransitionAlpha", new Class[] { Float.TYPE });
      a.setAccessible(true);
      b = true;
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        Log.i("ViewUtilsApi19", "Failed to retrieve setTransitionAlpha method", localNoSuchMethodException);
      }
    }
  }
  
  private void b()
  {
    if (!d) {}
    try
    {
      c = View.class.getDeclaredMethod("getTransitionAlpha", new Class[0]);
      c.setAccessible(true);
      d = true;
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        Log.i("ViewUtilsApi19", "Failed to retrieve getTransitionAlpha method", localNoSuchMethodException);
      }
    }
  }
  
  public void clearNonTransitionAlpha(View paramView) {}
  
  public float getTransitionAlpha(View paramView)
  {
    b();
    if (c != null) {
      try
      {
        float f = ((Float)c.invoke(paramView, new Object[0])).floatValue();
        return f;
      }
      catch (InvocationTargetException paramView)
      {
        throw new RuntimeException(paramView.getCause());
      }
      catch (IllegalAccessException localIllegalAccessException) {}
    }
    return super.getTransitionAlpha(paramView);
  }
  
  public void saveNonTransitionAlpha(View paramView) {}
  
  public void setTransitionAlpha(View paramView, float paramFloat)
  {
    a();
    if (a != null) {}
    try
    {
      a.invoke(paramView, new Object[] { Float.valueOf(paramFloat) });
      return;
    }
    catch (InvocationTargetException paramView)
    {
      throw new RuntimeException(paramView.getCause());
      paramView.setAlpha(paramFloat);
      return;
    }
    catch (IllegalAccessException paramView) {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/transition/av.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */