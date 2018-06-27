package cn.testin.analysis;

import android.view.View;
import android.view.WindowManager;

final class bb
  implements Runnable
{
  bb(View paramView) {}
  
  public void run()
  {
    try
    {
      if ((ba.a(ba.b()) != null) && (!ba.b().isShown()))
      {
        ba.b(ba.b()).token = this.a.getWindowToken();
        ba.a(ba.b()).addView(ba.b(), ba.b(ba.b()));
      }
      return;
    }
    catch (Exception localException)
    {
      ar.b(localException);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/bb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */