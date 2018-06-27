package android.support.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

class aq
  implements ar
{
  private final ViewOverlay a;
  
  aq(View paramView)
  {
    this.a = paramView.getOverlay();
  }
  
  public void add(Drawable paramDrawable)
  {
    this.a.add(paramDrawable);
  }
  
  public void clear()
  {
    this.a.clear();
  }
  
  public void remove(Drawable paramDrawable)
  {
    this.a.remove(paramDrawable);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/transition/aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */