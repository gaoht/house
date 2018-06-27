package com.pgyersdk.views;

import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.view.View;
import android.view.View.OnClickListener;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;

class e
  implements View.OnClickListener
{
  e(b paramb) {}
  
  @TargetApi(11)
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    f localf = (f)paramView.getTag();
    this.a.d.setColor(localf.a);
    if (this.a.m != null) {
      this.a.m.start();
    }
    for (;;)
    {
      b.a(this.a, false);
      b.a(this.a, paramView);
      return;
      if (this.a.o != null) {
        this.a.e.startAnimation(this.a.o);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/pgyersdk/views/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */