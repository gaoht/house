package android.support.v7.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

class a
  extends Drawable
{
  final ActionBarContainer a;
  
  public a(ActionBarContainer paramActionBarContainer)
  {
    this.a = paramActionBarContainer;
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.a.d) {
      if (this.a.c != null) {
        this.a.c.draw(paramCanvas);
      }
    }
    do
    {
      return;
      if (this.a.a != null) {
        this.a.a.draw(paramCanvas);
      }
    } while ((this.a.b == null) || (!this.a.e));
    this.a.b.draw(paramCanvas);
  }
  
  public int getOpacity()
  {
    return 0;
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/widget/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */