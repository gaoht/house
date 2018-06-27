package com.unionpay.mobile.android.nocard.views;

import android.view.View;
import android.view.View.OnClickListener;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.unionpay.mobile.android.languages.c;
import com.unionpay.mobile.android.model.b;
import com.unionpay.mobile.android.upviews.a.a;
import com.unionpay.mobile.android.widgets.m;

final class au
  implements View.OnClickListener
{
  au(at paramat) {}
  
  @Instrumented
  public final void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    if (this.a.o()) {
      return;
    }
    paramView = "";
    if (at.a(this.a) != null)
    {
      at.a(this.a).d();
      paramView = at.a(this.a).b();
      if (!paramView.a())
      {
        this.a.a(paramView.b);
        return;
      }
      paramView = paramView.b;
    }
    at.b(this.a).d();
    Object localObject = at.b(this.a).b();
    if (!((a.a)localObject).a())
    {
      this.a.a(((a.a)localObject).b);
      return;
    }
    if ((at.c(this.a) != null) && (!at.c(this.a).e()))
    {
      this.a.a(at.c(this.a).b());
      return;
    }
    if ((at.d(this.a) != null) && (!at.d(this.a).e()))
    {
      this.a.a(at.d(this.a).b());
      return;
    }
    localObject = ((a.a)localObject).b;
    at localat = this.a;
    if (at.b(paramView)) {}
    for (paramView = (String)localObject + "," + paramView;; paramView = (View)localObject)
    {
      this.a.b.a(c.bD.U);
      localObject = this.a;
      at.a(this.a.d, this.a.q + "_apply");
      if ((this.a.a.E != null) && (this.a.a.E.length() > 0))
      {
        at.a(this.a, at.e(this.a), paramView);
        return;
      }
      at.a(this.a, paramView);
      return;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/nocard/views/au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */