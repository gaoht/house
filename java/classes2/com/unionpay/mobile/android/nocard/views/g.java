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
import com.unionpay.mobile.android.upwidget.UPScrollView;
import com.unionpay.mobile.android.utils.o;
import com.unionpay.mobile.android.widgets.ay;
import com.unionpay.mobile.android.widgets.m;
import org.json.JSONArray;
import org.json.JSONObject;

public final class g
  extends b
  implements a.b
{
  private int r = 20;
  private int s = 100;
  private com.unionpay.mobile.android.upwidget.a t = null;
  private TextView u = null;
  private com.unionpay.mobile.android.upviews.a v = null;
  private boolean w = false;
  private boolean x = true;
  private View.OnClickListener y = new h(this);
  private View.OnClickListener z = new i(this);
  
  public g(Context paramContext)
  {
    super(paramContext);
    this.f = 5;
    if (this.a.K)
    {
      this.q = "entrust_phoneNO_change";
      if (this.a.K) {
        break label124;
      }
    }
    for (;;)
    {
      this.x = bool;
      setBackgroundColor(-1052684);
      e();
      return;
      this.q = "entrust";
      break;
      label124:
      bool = false;
    }
  }
  
  private void d(JSONObject paramJSONObject)
  {
    j();
    this.a.z = com.unionpay.mobile.android.utils.i.d(paramJSONObject, "rules");
    this.a.A = com.unionpay.mobile.android.utils.i.a(paramJSONObject, "title");
    this.a.C = com.unionpay.mobile.android.utils.i.c(paramJSONObject, "followrules_button");
    this.a.al = com.unionpay.mobile.android.utils.i.c(paramJSONObject, "service_checkbox");
    this.a.am = com.unionpay.mobile.android.utils.i.c(paramJSONObject, "bind_card_checkbox");
    this.a.aq = com.unionpay.mobile.android.utils.i.a(paramJSONObject, "pan");
    if ((this.a.z == null) || (this.a.z.length() <= 0))
    {
      b(2);
      return;
    }
    if (this.v != null) {
      this.v.f();
    }
    paramJSONObject = com.unionpay.mobile.android.nocard.utils.f.a(paramJSONObject);
    this.a.K = false;
    a(6, paramJSONObject);
  }
  
  private void u()
  {
    this.e.k(this.v.a("pan"));
    this.s = 104;
  }
  
  private void v()
  {
    this.s = 103;
    int i = this.r;
    this.e.a("query", this.a.aj, 3);
    this.r -= 1;
  }
  
  public final void a(a.a parama)
  {
    if (parama.a())
    {
      this.j = false;
      this.s = 101;
      this.b.a(com.unionpay.mobile.android.languages.c.bD.U);
      com.unionpay.mobile.android.utils.j.a("uppay", "sms elements:" + parama.b);
      this.e.c("sms", parama.b);
      return;
    }
    a(parama.b);
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    this.x = false;
    switch (this.s)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
          this.v.a(com.unionpay.mobile.android.global.b.p);
          this.b.c();
          this.s = 100;
          return;
          this.a.aj = com.unionpay.mobile.android.utils.h.a(paramJSONObject.toString());
          if ((this.a.aj == null) || (this.a.aj.length() <= 0))
          {
            b(2);
            return;
          }
          this.r = 20;
          v();
          return;
          Object localObject = com.unionpay.mobile.android.utils.i.a(paramJSONObject, "status");
          paramJSONObject = com.unionpay.mobile.android.utils.i.a(paramJSONObject, "fail_msg");
          if ((this.r > 0) && (((String)localObject).equalsIgnoreCase("01")))
          {
            v();
            return;
          }
          this.s = 100;
          if (((String)localObject).equalsIgnoreCase("00"))
          {
            this.w = true;
            a(this.d, this.q + "_open_succeed");
            u();
            return;
          }
          j();
          a(this.d, this.q + "_open_fail", o.j, new String[] { localObject, paramJSONObject });
          if (((String)localObject).equalsIgnoreCase("03"))
          {
            localObject = new j(this);
            k localk = new k(this);
            if (this.a.F)
            {
              this.b.a((View.OnClickListener)localObject, localk);
              this.b.a(com.unionpay.mobile.android.languages.c.bD.ab, paramJSONObject, com.unionpay.mobile.android.languages.c.bD.ac, com.unionpay.mobile.android.languages.c.bD.ad);
              return;
            }
            this.b.a((View.OnClickListener)localObject, null);
            this.b.a(com.unionpay.mobile.android.languages.c.bD.ab, paramJSONObject, com.unionpay.mobile.android.languages.c.bD.ac);
            return;
          }
        } while (this.r > 0);
        a(this.a.ak);
        return;
      } while (b(paramJSONObject));
      d(paramJSONObject);
      return;
      j();
      int i = com.unionpay.mobile.android.nocard.utils.f.a(this.a, paramJSONObject, false);
      if (i != 0)
      {
        b(i);
        return;
      }
      paramJSONObject = com.unionpay.mobile.android.nocard.utils.f.a(paramJSONObject);
      if ((this.a.z != null) && (this.a.z.length() > 0))
      {
        a(6, paramJSONObject);
        return;
      }
    } while ((this.a.D == null) || (this.a.D.length() <= 0));
    d(5);
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
  
  protected final boolean a(String paramString, JSONObject paramJSONObject)
  {
    this.x = false;
    return false;
  }
  
  protected final void b()
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    ay localay = new ay(getContext(), this.a.A, this);
    localLayoutParams.addRule(13, -1);
    this.k.addView(localay, localLayoutParams);
  }
  
  protected final void b(String paramString, JSONObject paramJSONObject)
  {
    if ("init".equals(paramString))
    {
      a(2);
      return;
    }
    if ("".equals(paramString))
    {
      d(paramJSONObject);
      return;
    }
    this.b.a(com.unionpay.mobile.android.languages.c.bD.U);
    this.j = false;
    this.s = 105;
    this.e.c(paramString, "");
  }
  
  protected final void c()
  {
    boolean bool2 = true;
    this.o.a(this);
    LinearLayout localLinearLayout = new LinearLayout(this.d);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setId(localLinearLayout.hashCode());
    Object localObject = new RelativeLayout.LayoutParams(-1, -2);
    int i = com.unionpay.mobile.android.global.a.d;
    this.m.addView(localLinearLayout, (ViewGroup.LayoutParams)localObject);
    this.v = new com.unionpay.mobile.android.upviews.a(this.d, this.a.D, this.e.c(), this, this.a.aq, true, this.q);
    localObject = new LinearLayout.LayoutParams(-1, -1);
    ((LinearLayout.LayoutParams)localObject).topMargin = com.unionpay.mobile.android.global.a.f;
    localLinearLayout.addView(this.v, (ViewGroup.LayoutParams)localObject);
    localObject = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject).topMargin = i;
    ((RelativeLayout.LayoutParams)localObject).leftMargin = com.unionpay.mobile.android.global.a.f;
    ((RelativeLayout.LayoutParams)localObject).addRule(3, localLinearLayout.getId());
    localLinearLayout = new LinearLayout(this.d);
    localLinearLayout.setOrientation(0);
    localLinearLayout.setId(localLinearLayout.hashCode());
    this.t = new com.unionpay.mobile.android.upwidget.a(this.d, this.a.al, this.z, this.q + "_agree_user_protocol");
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLinearLayout.addView(this.t, localLayoutParams);
    this.m.addView(localLinearLayout, (ViewGroup.LayoutParams)localObject);
    this.u = new TextView(this.d);
    this.u.setText(com.unionpay.mobile.android.utils.i.a(this.a.C, "label"));
    this.u.setTextSize(com.unionpay.mobile.android.global.b.i);
    this.u.setTextColor(p());
    this.u.setGravity(17);
    i = com.unionpay.mobile.android.global.a.n;
    localObject = this.c.a(2008);
    this.u.setBackgroundDrawable((Drawable)localObject);
    this.u.setOnClickListener(this.y);
    localObject = this.u;
    boolean bool1 = bool2;
    if (this.v != null) {
      if (!this.v.e()) {
        break label488;
      }
    }
    label488:
    for (bool1 = bool2;; bool1 = false)
    {
      ((TextView)localObject).setEnabled(bool1);
      localObject = new RelativeLayout.LayoutParams(-1, i);
      ((RelativeLayout.LayoutParams)localObject).topMargin = com.unionpay.mobile.android.global.a.f;
      i = com.unionpay.mobile.android.utils.f.a(this.d, 10.0F);
      ((RelativeLayout.LayoutParams)localObject).rightMargin = i;
      ((RelativeLayout.LayoutParams)localObject).leftMargin = i;
      ((RelativeLayout.LayoutParams)localObject).addRule(3, localLinearLayout.getId());
      this.m.addView(this.u, (ViewGroup.LayoutParams)localObject);
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
    if (this.a.L)
    {
      a(13);
      this.a.L = false;
      return;
    }
    if ((this.a.K) && (this.x))
    {
      this.a.K = false;
      com.unionpay.mobile.android.nocard.utils.f.a(this.a, this.a.G);
      n();
      return;
    }
    this.a.K = false;
    this.a.G = null;
    a(2);
  }
  
  public final void t() {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/nocard/views/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */