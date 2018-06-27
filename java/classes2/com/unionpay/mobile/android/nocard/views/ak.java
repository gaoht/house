package com.unionpay.mobile.android.nocard.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.unionpay.mobile.android.nocard.utils.UPPayEngine;
import com.unionpay.mobile.android.upviews.a.a;
import com.unionpay.mobile.android.upviews.a.b;
import com.unionpay.mobile.android.utils.h;
import com.unionpay.mobile.android.utils.i;
import com.unionpay.mobile.android.utils.j;
import com.unionpay.mobile.android.widgets.ay;
import com.unionpay.mobile.android.widgets.m;
import org.json.JSONObject;

public final class ak
  extends b
  implements a.b
{
  private int r = 100;
  private int s = 20;
  private com.unionpay.mobile.android.upwidget.a t = null;
  private TextView u = null;
  private com.unionpay.mobile.android.upviews.a v = null;
  private View.OnClickListener w = new al(this);
  private View.OnClickListener x = new am(this);
  
  public ak(Context paramContext)
  {
    super(paramContext);
    this.f = 10;
    this.q = "openupgrade";
    setBackgroundColor(-1052684);
    this.k = a();
    b();
    super.d();
    c();
  }
  
  private void u()
  {
    this.r = 103;
    j.c("uppay", this.s);
    int i = this.s;
    this.e.a("query", this.a.aj, 3);
    this.s -= 1;
  }
  
  public final void a(a.a parama)
  {
    if (!parama.a())
    {
      a(parama.b);
      return;
    }
    this.j = false;
    this.r = 101;
    this.b.a(com.unionpay.mobile.android.languages.c.bD.U);
    j.a("uppay", "sms elements:" + parama.b);
    this.e.c("sms", parama.b);
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    switch (this.r)
    {
    }
    do
    {
      return;
      this.v.a(com.unionpay.mobile.android.global.b.p);
      this.b.c();
      this.r = 100;
      return;
      this.a.aj = h.a(paramJSONObject.toString());
      if ((this.a.aj == null) || (this.a.aj.length() <= 0))
      {
        b(2);
        return;
      }
      this.s = 20;
      u();
      return;
      String str2 = i.a(paramJSONObject, "status");
      String str1 = i.a(paramJSONObject, "fail_msg");
      this.a.S = i.a(paramJSONObject, "open_info");
      this.a.A = i.a(paramJSONObject, "title");
      this.a.B = i.a(paramJSONObject, "succ_info");
      if ((this.s > 0) && (str2.equalsIgnoreCase("01")))
      {
        u();
        return;
      }
      this.r = 100;
      j();
      if (str2.equalsIgnoreCase("00"))
      {
        paramJSONObject = this.a.S;
        d(11);
        return;
      }
      if (str2.equalsIgnoreCase("03"))
      {
        paramJSONObject = new an(this);
        this.b.a(paramJSONObject, null);
        this.b.a(com.unionpay.mobile.android.languages.c.bD.ab, str1, com.unionpay.mobile.android.languages.c.bD.ac);
        return;
      }
    } while (this.s > 0);
    b(20);
  }
  
  public final void a(boolean paramBoolean)
  {
    TextView localTextView;
    if (this.u != null)
    {
      localTextView = this.u;
      if (paramBoolean) {
        break label24;
      }
    }
    label24:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localTextView.setEnabled(paramBoolean);
      return;
    }
  }
  
  protected final void b()
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    ay localay = new ay(getContext(), this.a.A, this);
    localLayoutParams.addRule(13, -1);
    this.k.addView(localay, localLayoutParams);
  }
  
  protected final void c()
  {
    boolean bool2 = true;
    Object localObject2 = new LinearLayout(this.d);
    ((LinearLayout)localObject2).setBackgroundColor(-1);
    ((LinearLayout)localObject2).setOrientation(1);
    ((LinearLayout)localObject2).setId(localObject2.hashCode());
    Object localObject1 = new RelativeLayout.LayoutParams(-1, -2);
    int i = com.unionpay.mobile.android.global.a.f;
    ((RelativeLayout.LayoutParams)localObject1).rightMargin = i;
    ((RelativeLayout.LayoutParams)localObject1).leftMargin = i;
    this.m.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
    this.v = new com.unionpay.mobile.android.upviews.a(this.d, this.a.T, this.e.c(), this, this.a.aq, true, this.q);
    new LinearLayout.LayoutParams(-1, -1).topMargin = com.unionpay.mobile.android.global.a.f;
    ((LinearLayout)localObject2).addView(this.v);
    localObject1 = new LinearLayout(this.d);
    ((LinearLayout)localObject1).setOrientation(1);
    ((LinearLayout)localObject1).setId(localObject1.hashCode());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.topMargin = com.unionpay.mobile.android.global.a.d;
    localLayoutParams.leftMargin = com.unionpay.mobile.android.global.a.d;
    localLayoutParams.addRule(3, ((LinearLayout)localObject2).getId());
    this.m.addView((View)localObject1, localLayoutParams);
    this.t = new com.unionpay.mobile.android.upwidget.a(this.d, this.a.al, this.x, this.q + "_agree_user_protocol");
    ((LinearLayout)localObject1).addView(this.t);
    this.u = new TextView(this.d);
    this.u.setText(i.a(this.a.C, "label"));
    this.u.setTextSize(com.unionpay.mobile.android.global.b.i);
    this.u.setTextColor(p());
    this.u.setGravity(17);
    i = com.unionpay.mobile.android.global.a.n;
    localObject2 = this.c.a(2008);
    this.u.setBackgroundDrawable((Drawable)localObject2);
    this.u.setOnClickListener(this.w);
    localObject2 = this.u;
    boolean bool1 = bool2;
    if (this.v != null) {
      if (!this.v.e()) {
        break label472;
      }
    }
    label472:
    for (bool1 = bool2;; bool1 = false)
    {
      ((TextView)localObject2).setEnabled(bool1);
      localObject2 = new RelativeLayout.LayoutParams(-1, i);
      ((RelativeLayout.LayoutParams)localObject2).topMargin = com.unionpay.mobile.android.global.a.d;
      i = com.unionpay.mobile.android.global.a.d;
      ((RelativeLayout.LayoutParams)localObject2).rightMargin = i;
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = i;
      ((RelativeLayout.LayoutParams)localObject2).addRule(3, ((LinearLayout)localObject1).getId());
      this.m.addView(this.u, (ViewGroup.LayoutParams)localObject2);
      return;
    }
  }
  
  public final void c(String paramString) {}
  
  public final void c(String paramString1, String paramString2) {}
  
  public final void l()
  {
    if (this.v.d()) {
      return;
    }
    n();
  }
  
  public final void t() {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/nocard/views/ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */