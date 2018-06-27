package android.support.transition;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

class aj
  extends ViewOverlayApi14
  implements al
{
  aj(Context paramContext, ViewGroup paramViewGroup, View paramView)
  {
    super(paramContext, paramViewGroup, paramView);
  }
  
  static aj a(ViewGroup paramViewGroup)
  {
    return (aj)ViewOverlayApi14.b(paramViewGroup);
  }
  
  public void add(View paramView)
  {
    this.a.add(paramView);
  }
  
  public void remove(View paramView)
  {
    this.a.remove(paramView);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/transition/aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */