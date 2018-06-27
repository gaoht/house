package android.support.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;

class ak
  implements al
{
  private final ViewGroupOverlay a;
  
  ak(ViewGroup paramViewGroup)
  {
    this.a = paramViewGroup.getOverlay();
  }
  
  public void add(Drawable paramDrawable)
  {
    this.a.add(paramDrawable);
  }
  
  public void add(View paramView)
  {
    this.a.add(paramView);
  }
  
  public void clear()
  {
    this.a.clear();
  }
  
  public void remove(Drawable paramDrawable)
  {
    this.a.remove(paramDrawable);
  }
  
  public void remove(View paramView)
  {
    this.a.remove(paramView);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/transition/ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */