package android.support.v7.app;

import android.app.UiModeManager;
import android.content.Context;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Window;
import android.view.Window.Callback;

class j
  extends i
{
  private final UiModeManager t;
  
  j(Context paramContext, Window paramWindow, d paramd)
  {
    super(paramContext, paramWindow, paramd);
    this.t = ((UiModeManager)paramContext.getSystemService("uimode"));
  }
  
  int a(int paramInt)
  {
    if ((paramInt == 0) && (this.t.getNightMode() == 0)) {
      return -1;
    }
    return super.a(paramInt);
  }
  
  Window.Callback a(Window.Callback paramCallback)
  {
    return new a(paramCallback);
  }
  
  class a
    extends i.a
  {
    a(Window.Callback paramCallback)
    {
      super(paramCallback);
    }
    
    public ActionMode onWindowStartingActionMode(ActionMode.Callback paramCallback)
    {
      return null;
    }
    
    public ActionMode onWindowStartingActionMode(ActionMode.Callback paramCallback, int paramInt)
    {
      if (j.this.isHandleNativeActionModesEnabled()) {}
      switch (paramInt)
      {
      default: 
        return super.onWindowStartingActionMode(paramCallback, paramInt);
      }
      return a(paramCallback);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/app/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */