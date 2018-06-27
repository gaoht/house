package com.unionpay.mobile.android.pro.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.unionpay.mobile.android.model.e;
import com.unionpay.mobile.android.nocard.utils.UPPayEngine;
import com.unionpay.mobile.android.upviews.a.a;
import com.unionpay.mobile.android.upviews.a.b;
import com.unionpay.mobile.android.utils.h;
import com.unionpay.mobile.android.utils.i;
import com.unionpay.mobile.android.utils.j;
import com.unionpay.mobile.android.utils.o;
import com.unionpay.mobile.android.widgets.ay;
import com.unionpay.mobile.android.widgets.m;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class x
  extends com.unionpay.mobile.android.nocard.views.b
  implements Handler.Callback, a.b
{
  private com.unionpay.mobile.android.upviews.a A = null;
  private String B;
  private boolean C = false;
  private Handler D = null;
  private View.OnClickListener E = new y(this);
  private View.OnClickListener F = new z(this);
  private View.OnClickListener G = new aa(this);
  private View.OnClickListener H = new ab(this);
  private View.OnClickListener I = new ad(this);
  private String r = "00";
  private int s = 0;
  private int t = 0;
  private int u = 20;
  private int v = 5;
  private com.unionpay.mobile.android.upwidget.a w = null;
  private com.unionpay.mobile.android.upwidget.a x = null;
  private TextView y = null;
  private com.unionpay.mobile.android.upviews.a z = null;
  
  public x(Context paramContext, e parame)
  {
    super(paramContext, parame);
    this.f = 6;
    this.q = "sdpay";
    setBackgroundColor(-1052684);
    e();
  }
  
  private void d(String paramString1, String paramString2)
  {
    this.t = 8;
    if (TextUtils.isEmpty(paramString2)) {
      this.e.c(paramString1, "");
    }
    for (;;)
    {
      this.v -= 1;
      return;
      paramString2 = "\"uuid\":\"" + paramString2 + "\"";
      this.e.a(paramString1, paramString2, 10);
    }
  }
  
  private void f(int paramInt)
  {
    this.t = 4;
    this.s = paramInt;
    paramInt = this.u;
    this.e.a("query", this.a.aj, 3);
    this.u -= 1;
  }
  
  public final void a(a.a parama)
  {
    if (!parama.a())
    {
      a(parama.b);
      return;
    }
    j.a("uppay", "sms elements:" + parama.b);
    this.j = false;
    this.b.a(com.unionpay.mobile.android.languages.c.bD.U);
    this.e.c("sms", parama.b);
    this.t = 1;
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    this.C = false;
    switch (this.t)
    {
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            j();
            this.t = 0;
            this.A.a(com.unionpay.mobile.android.global.b.p);
            return;
            j();
            int i = com.unionpay.mobile.android.nocard.utils.f.a(this.a, paramJSONObject, false);
            if (i != 0) {
              b(i);
            }
            for (;;)
            {
              this.t = 0;
              return;
              this.a.K = true;
              if ((this.a.z != null) && (this.a.z.length() > 0)) {
                d(6);
              } else if ((this.a.D != null) && (this.a.D.length() > 0)) {
                d(5);
              }
            }
            this.r = i.a(paramJSONObject, "status");
            if ((this.u > 0) && (this.r.equalsIgnoreCase("01")))
            {
              f(this.s);
              return;
            }
            this.t = 0;
            if (this.r.equalsIgnoreCase("00"))
            {
              i = this.s;
              j();
              this.t = 0;
              this.a.H = i.d(paramJSONObject, "result");
              this.a.P = i.a(paramJSONObject, "openupgrade_flag");
              this.a.Q = i.a(paramJSONObject, "temporary_pay_flag");
              this.a.R = i.a(paramJSONObject, "temporary_pay_info");
              this.a.V = i.a(paramJSONObject, "front_url");
              this.a.W = i.a(paramJSONObject, "front_request");
              this.a.A = i.a(paramJSONObject, "title");
              this.a.B = i.a(paramJSONObject, "succ_info");
              com.unionpay.mobile.android.nocard.utils.b.b(paramJSONObject, this.a);
              com.unionpay.mobile.android.nocard.utils.b.a(paramJSONObject, this.a);
              if (this.A != null) {
                this.A.f();
              }
              a(this.d, this.q + "_succeed");
              if (this.a.f)
              {
                this.a.I.f = "success";
                k();
                return;
              }
              d(8);
              return;
            }
            if (this.r.equalsIgnoreCase("03"))
            {
              paramJSONObject = i.a(paramJSONObject, "fail_msg");
              a(this.d, this.q + "_fail", o.j, new String[] { this.r, paramJSONObject });
              if (this.t == 3)
              {
                a(paramJSONObject);
                return;
              }
              localObject = new ae(this);
              af localaf = new af(this);
              if (this.a.F)
              {
                this.b.a((View.OnClickListener)localObject, localaf);
                this.b.a(com.unionpay.mobile.android.languages.c.bD.Y, paramJSONObject, com.unionpay.mobile.android.languages.c.bD.W, com.unionpay.mobile.android.languages.c.bD.X);
                return;
              }
              this.b.a((View.OnClickListener)localObject, null);
              this.b.a(com.unionpay.mobile.android.languages.c.bD.Y, paramJSONObject, com.unionpay.mobile.android.languages.c.bD.W);
              return;
            }
          } while (this.u > 0);
          if (this.s == 3)
          {
            a(this.a.ak, true);
            return;
          }
          a(this.a.ak);
          return;
          this.a.aj = h.a(paramJSONObject.toString());
          paramJSONObject = i.a(paramJSONObject, "qn");
          if (!TextUtils.isEmpty(paramJSONObject)) {
            this.a.n = this.e.i(com.unionpay.mobile.android.utils.c.b(paramJSONObject));
          }
          if ((this.a.aj == null) || (this.a.aj.length() <= 0))
          {
            b(2);
            return;
          }
          this.u = 20;
          f(this.t);
          return;
          j();
          paramJSONObject = i.d(paramJSONObject, "options");
        } while (this.z == null);
        this.z.a(paramJSONObject);
        return;
        localObject = i.a(paramJSONObject, "status");
        if ((localObject == null) || (!"01".equals(localObject))) {
          break;
        }
        paramJSONObject = i.a(paramJSONObject, "uuid");
        if (this.v >= 0)
        {
          d(this.B, paramJSONObject);
          return;
        }
        paramJSONObject = com.unionpay.mobile.android.languages.c.bD.D;
      } while (this.z == null);
      this.z.a(null, paramJSONObject);
      return;
      localObject = i.d(paramJSONObject, "options");
      paramJSONObject = i.a(paramJSONObject, "empty_info");
    } while (this.z == null);
    this.z.a((JSONArray)localObject, paramJSONObject);
  }
  
  public final void a(boolean paramBoolean)
  {
    TextView localTextView;
    if (this.y != null)
    {
      localTextView = this.y;
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
    this.C = false;
    return false;
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
    boolean bool = false;
    Object localObject1 = new LinearLayout(this.d);
    ((LinearLayout)localObject1).setId(localObject1.hashCode());
    ((LinearLayout)localObject1).setOrientation(1);
    Object localObject2 = new RelativeLayout.LayoutParams(-1, -2);
    this.m.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new JSONArray();
    if (this.p != null)
    {
      localObject3 = (com.unionpay.mobile.android.model.f)this.p;
      ((JSONArray)localObject2).put(((com.unionpay.mobile.android.model.f)localObject3).a("promotion"));
      ((JSONArray)localObject2).put(((com.unionpay.mobile.android.model.f)localObject3).a("instalment"));
      this.a.aU = ((com.unionpay.mobile.android.model.f)localObject3).a("promotion_instalment_msgbox");
    }
    if (((JSONArray)localObject2).length() > 0)
    {
      this.z = new com.unionpay.mobile.android.upviews.a(this.d, (JSONArray)localObject2, this, this.q);
      this.z.a(this.b, this.a.aU);
      this.z.a(this.F);
      this.z.b(this.G);
      this.z.c(this.H);
      localObject2 = new LinearLayout.LayoutParams(-1, -2);
      ((LinearLayout.LayoutParams)localObject2).topMargin = com.unionpay.mobile.android.global.a.f;
      ((LinearLayout)localObject1).addView(this.z, (ViewGroup.LayoutParams)localObject2);
    }
    if (this.z != null) {
      this.z.c("instalment");
    }
    this.A = new com.unionpay.mobile.android.upviews.a(this.d, this.a.z, this.e.c(), this, this.a.aq, false, this.q);
    localObject2 = new LinearLayout.LayoutParams(-1, -2);
    ((LinearLayout.LayoutParams)localObject2).topMargin = com.unionpay.mobile.android.global.a.f;
    ((LinearLayout)localObject1).addView(this.A, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new LinearLayout(this.d);
    ((LinearLayout)localObject2).setOrientation(1);
    ((LinearLayout)localObject2).setId(localObject2.hashCode());
    Object localObject3 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject3).addRule(3, ((LinearLayout)localObject1).getId());
    ((RelativeLayout.LayoutParams)localObject3).leftMargin = com.unionpay.mobile.android.global.a.f;
    ((RelativeLayout.LayoutParams)localObject3).topMargin = ((RelativeLayout.LayoutParams)localObject3).leftMargin;
    this.m.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
    if ((i()) || (this.a.al != null) || (this.a.am != null))
    {
      if (this.a.al != null)
      {
        this.x = new com.unionpay.mobile.android.upwidget.a(this.d, this.a.al, this.I, this.q + "_agree_user_protocol");
        ((LinearLayout)localObject2).addView(this.x);
      }
      if (this.a.am != null)
      {
        this.w = new com.unionpay.mobile.android.upwidget.a(this.d, this.a.am, null, this.q + "_remember_bankNO");
        localObject1 = new LinearLayout.LayoutParams(-2, -2);
        ((LinearLayout.LayoutParams)localObject1).topMargin = com.unionpay.mobile.android.global.a.f;
        ((LinearLayout)localObject2).addView(this.w, (ViewGroup.LayoutParams)localObject1);
      }
    }
    this.y = new TextView(this.d);
    this.y.setText(i.a(this.a.C, "label"));
    this.y.setTextSize(com.unionpay.mobile.android.global.b.i);
    this.y.setTextColor(p());
    this.y.setGravity(17);
    localObject1 = this.y;
    if ((this.A == null) || (this.A.e())) {
      bool = true;
    }
    ((TextView)localObject1).setEnabled(bool);
    int i = com.unionpay.mobile.android.global.a.n;
    localObject1 = this.c.a(2008);
    this.y.setBackgroundDrawable((Drawable)localObject1);
    this.y.setOnClickListener(this.E);
    localObject1 = new RelativeLayout.LayoutParams(-1, i);
    ((RelativeLayout.LayoutParams)localObject1).addRule(3, ((LinearLayout)localObject2).getId());
    ((RelativeLayout.LayoutParams)localObject1).topMargin = com.unionpay.mobile.android.global.a.f;
    i = com.unionpay.mobile.android.utils.f.a(this.d, 10.0F);
    ((RelativeLayout.LayoutParams)localObject1).rightMargin = i;
    ((RelativeLayout.LayoutParams)localObject1).leftMargin = i;
    this.m.addView(this.y, (ViewGroup.LayoutParams)localObject1);
  }
  
  public final void c(String paramString)
  {
    this.j = false;
    this.b.a(com.unionpay.mobile.android.languages.c.bD.U);
    String str = "\"card\":\"" + ((com.unionpay.mobile.android.model.c)this.a.q.get(this.a.N)).a() + "\"";
    j.a("uppay", "cmd:" + paramString + ", ele:" + str);
    this.e.c(paramString, str);
    this.t = 6;
  }
  
  public final void c(String paramString1, String paramString2) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.obj != null)
    {
      Object localObject = (Bundle)paramMessage.obj;
      paramMessage = ((Bundle)localObject).getString("action_resp_code");
      localObject = ((Bundle)localObject).getString("action_resp_message");
      if ("0000".equalsIgnoreCase(paramMessage))
      {
        if (localObject != null)
        {
          a(0, (String)localObject);
          return true;
        }
        b(1);
        return true;
      }
      a(this.a.ap, false);
      return true;
    }
    b(1);
    return true;
  }
  
  public final void l()
  {
    if (this.A.d()) {
      return;
    }
    if ((this.a.K) && (this.C))
    {
      this.a.K = false;
      n();
      return;
    }
    this.a.K = false;
    this.a.bq = false;
    a(2);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.A.d();
  }
  
  public final void t() {}
  
  public com.unionpay.mobile.android.pro.pboc.engine.b u()
  {
    return null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/pro/views/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */