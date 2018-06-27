package android.support.v7.app;

import android.content.Context;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.Window;
import android.view.Window.Callback;
import java.util.List;

class g
  extends j
{
  g(Context paramContext, Window paramWindow, d paramd)
  {
    super(paramContext, paramWindow, paramd);
  }
  
  Window.Callback a(Window.Callback paramCallback)
  {
    return new a(paramCallback);
  }
  
  class a
    extends j.a
  {
    a(Window.Callback paramCallback)
    {
      super(paramCallback);
    }
    
    public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> paramList, Menu paramMenu, int paramInt)
    {
      AppCompatDelegateImplV9.PanelFeatureState localPanelFeatureState = g.this.a(0, true);
      if ((localPanelFeatureState != null) && (localPanelFeatureState.j != null))
      {
        super.onProvideKeyboardShortcuts(paramList, localPanelFeatureState.j, paramInt);
        return;
      }
      super.onProvideKeyboardShortcuts(paramList, paramMenu, paramInt);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/app/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */