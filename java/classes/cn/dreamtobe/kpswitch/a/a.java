package cn.dreamtobe.kpswitch.a;

import android.view.View;
import android.view.Window;
import cn.dreamtobe.kpswitch.b.c;

public class a
{
  private final View a;
  private boolean b;
  private View c;
  
  public a(View paramView)
  {
    this.a = paramView;
  }
  
  private void a()
  {
    this.a.setVisibility(4);
    c.showKeyboard(this.c);
  }
  
  private void a(View paramView)
  {
    this.c = paramView;
    paramView.clearFocus();
    this.a.setVisibility(8);
  }
  
  public void onKeyboardShowing(boolean paramBoolean)
  {
    this.b = paramBoolean;
    if ((!paramBoolean) && (this.a.getVisibility() == 4)) {
      this.a.setVisibility(8);
    }
    if ((!paramBoolean) && (this.c != null))
    {
      a();
      this.c = null;
    }
  }
  
  public void recordKeyboardStatus(Window paramWindow)
  {
    paramWindow = paramWindow.getCurrentFocus();
    if (paramWindow == null) {
      return;
    }
    if (this.b)
    {
      a(paramWindow);
      return;
    }
    paramWindow.clearFocus();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/dreamtobe/kpswitch/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */