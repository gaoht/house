package android.support.v4.widget;

import android.os.Build.VERSION;
import android.view.View.OnTouchListener;
import android.widget.PopupMenu;

public final class PopupMenuCompat
{
  public static View.OnTouchListener getDragToOpenListener(Object paramObject)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return ((PopupMenu)paramObject).getDragToOpenListener();
    }
    return null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v4/widget/PopupMenuCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */