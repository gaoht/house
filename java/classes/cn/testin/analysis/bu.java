package cn.testin.analysis;

import android.os.Handler;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import java.lang.ref.WeakReference;

class bu
  implements ViewTreeObserver.OnGlobalLayoutListener, Runnable
{
  private volatile boolean a;
  private boolean b;
  private final WeakReference<View> c;
  private final bv d;
  private final Handler e;
  
  public bu(View paramView, bv parambv, Handler paramHandler)
  {
    this.d = parambv;
    this.c = new WeakReference(paramView);
    this.e = paramHandler;
    this.b = true;
    this.a = false;
    paramView = paramView.getViewTreeObserver();
    if (paramView.isAlive()) {
      paramView.addOnGlobalLayoutListener(this);
    }
    run();
  }
  
  private void c()
  {
    if (this.b)
    {
      b();
      this.d.a();
    }
    this.b = false;
  }
  
  public void a()
  {
    this.a = true;
    this.e.post(this);
  }
  
  public void b()
  {
    Object localObject = (View)this.c.get();
    if (localObject != null)
    {
      localObject = ((View)localObject).getViewTreeObserver();
      if (((ViewTreeObserver)localObject).isAlive()) {
        ((ViewTreeObserver)localObject).removeGlobalOnLayoutListener(this);
      }
    }
  }
  
  public void onGlobalLayout()
  {
    run();
  }
  
  public void run()
  {
    if (!this.b) {
      return;
    }
    try
    {
      View localView = (View)this.c.get();
      if ((localView == null) || (this.a))
      {
        c();
        return;
      }
    }
    catch (Exception localException)
    {
      ar.b(localException);
      return;
    }
    this.d.a(localException);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/bu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */