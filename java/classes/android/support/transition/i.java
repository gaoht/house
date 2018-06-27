package android.support.transition;

import android.graphics.Matrix;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;

class i
{
  private static final h.a a = new GhostViewApi14.a();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      a = new g.a();
      return;
    }
  }
  
  static h a(View paramView, ViewGroup paramViewGroup, Matrix paramMatrix)
  {
    return a.addGhost(paramView, paramViewGroup, paramMatrix);
  }
  
  static void a(View paramView)
  {
    a.removeGhost(paramView);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/transition/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */