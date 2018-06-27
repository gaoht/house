package android.support.transition;

import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class aw
  extends av
{
  private static Method a;
  private static boolean b;
  private static Method c;
  private static boolean d;
  private static Method e;
  private static boolean f;
  
  private void a()
  {
    if (!b) {}
    try
    {
      a = View.class.getDeclaredMethod("transformMatrixToGlobal", new Class[] { Matrix.class });
      a.setAccessible(true);
      b = true;
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        Log.i("ViewUtilsApi21", "Failed to retrieve transformMatrixToGlobal method", localNoSuchMethodException);
      }
    }
  }
  
  private void b()
  {
    if (!d) {}
    try
    {
      c = View.class.getDeclaredMethod("transformMatrixToLocal", new Class[] { Matrix.class });
      c.setAccessible(true);
      d = true;
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        Log.i("ViewUtilsApi21", "Failed to retrieve transformMatrixToLocal method", localNoSuchMethodException);
      }
    }
  }
  
  private void c()
  {
    if (!f) {}
    try
    {
      e = View.class.getDeclaredMethod("setAnimationMatrix", new Class[] { Matrix.class });
      e.setAccessible(true);
      f = true;
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        Log.i("ViewUtilsApi21", "Failed to retrieve setAnimationMatrix method", localNoSuchMethodException);
      }
    }
  }
  
  public void setAnimationMatrix(View paramView, Matrix paramMatrix)
  {
    c();
    if (e != null) {}
    try
    {
      e.invoke(paramView, new Object[] { paramMatrix });
      return;
    }
    catch (IllegalAccessException paramView)
    {
      throw new RuntimeException(paramView.getCause());
    }
    catch (InvocationTargetException paramView) {}
  }
  
  public void transformMatrixToGlobal(View paramView, Matrix paramMatrix)
  {
    a();
    if (a != null) {}
    try
    {
      a.invoke(paramView, new Object[] { paramMatrix });
      return;
    }
    catch (InvocationTargetException paramView)
    {
      throw new RuntimeException(paramView.getCause());
    }
    catch (IllegalAccessException paramView) {}
  }
  
  public void transformMatrixToLocal(View paramView, Matrix paramMatrix)
  {
    b();
    if (c != null) {}
    try
    {
      c.invoke(paramView, new Object[] { paramMatrix });
      return;
    }
    catch (InvocationTargetException paramView)
    {
      throw new RuntimeException(paramView.getCause());
    }
    catch (IllegalAccessException paramView) {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/transition/aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */