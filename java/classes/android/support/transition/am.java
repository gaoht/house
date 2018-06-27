package android.support.transition;

import android.os.Build.VERSION;
import android.view.ViewGroup;

class am
{
  private static final ap a = new an();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 18)
    {
      a = new ao();
      return;
    }
  }
  
  static al a(ViewGroup paramViewGroup)
  {
    return a.getOverlay(paramViewGroup);
  }
  
  static void a(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    a.suppressLayout(paramViewGroup, paramBoolean);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/transition/am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */