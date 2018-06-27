package android.support.transition;

import android.view.View;
import android.view.WindowId;

class bb
  implements bc
{
  private final WindowId a;
  
  bb(View paramView)
  {
    this.a = paramView.getWindowId();
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof bb)) && (((bb)paramObject).a.equals(this.a));
  }
  
  public int hashCode()
  {
    return this.a.hashCode();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/transition/bb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */