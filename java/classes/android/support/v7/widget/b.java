package android.support.v7.widget;

import android.graphics.Outline;
import android.graphics.drawable.Drawable;

class b
  extends a
{
  public b(ActionBarContainer paramActionBarContainer)
  {
    super(paramActionBarContainer);
  }
  
  public void getOutline(Outline paramOutline)
  {
    if (this.a.d) {
      if (this.a.c != null) {
        this.a.c.getOutline(paramOutline);
      }
    }
    while (this.a.a == null) {
      return;
    }
    this.a.a.getOutline(paramOutline);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/widget/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */