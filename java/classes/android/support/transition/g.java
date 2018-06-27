package android.support.transition;

import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class g
  implements h
{
  private static Class<?> a;
  private static boolean b;
  private static Method c;
  private static boolean d;
  private static Method e;
  private static boolean f;
  private final View g;
  
  private g(View paramView)
  {
    this.g = paramView;
  }
  
  private static void e()
  {
    if (!b) {}
    try
    {
      a = Class.forName("android.view.GhostView");
      b = true;
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        Log.i("GhostViewApi21", "Failed to retrieve GhostView class", localClassNotFoundException);
      }
    }
  }
  
  private static void f()
  {
    if (!d) {}
    try
    {
      e();
      c = a.getDeclaredMethod("addGhost", new Class[] { View.class, ViewGroup.class, Matrix.class });
      c.setAccessible(true);
      d = true;
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        Log.i("GhostViewApi21", "Failed to retrieve addGhost method", localNoSuchMethodException);
      }
    }
  }
  
  private static void g()
  {
    if (!f) {}
    try
    {
      e();
      e = a.getDeclaredMethod("removeGhost", new Class[] { View.class });
      e.setAccessible(true);
      f = true;
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        Log.i("GhostViewApi21", "Failed to retrieve removeGhost method", localNoSuchMethodException);
      }
    }
  }
  
  public void reserveEndViewTransition(ViewGroup paramViewGroup, View paramView) {}
  
  public void setVisibility(int paramInt)
  {
    this.g.setVisibility(paramInt);
  }
  
  static class a
    implements h.a
  {
    public h addGhost(View paramView, ViewGroup paramViewGroup, Matrix paramMatrix)
    {
      
      if (g.b() != null) {
        try
        {
          paramView = new g((View)g.b().invoke(null, new Object[] { paramView, paramViewGroup, paramMatrix }), null);
          return paramView;
        }
        catch (InvocationTargetException paramView)
        {
          throw new RuntimeException(paramView.getCause());
        }
        catch (IllegalAccessException paramView) {}
      }
      return null;
    }
    
    public void removeGhost(View paramView)
    {
      
      if (g.d() != null) {}
      try
      {
        g.d().invoke(null, new Object[] { paramView });
        return;
      }
      catch (InvocationTargetException paramView)
      {
        throw new RuntimeException(paramView.getCause());
      }
      catch (IllegalAccessException paramView) {}
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/transition/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */