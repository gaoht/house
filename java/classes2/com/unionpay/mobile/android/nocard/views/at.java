package com.unionpay.mobile.android.nocard.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
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
import com.unionpay.mobile.android.upwidget.UPScrollView;
import com.unionpay.mobile.android.utils.PreferenceUtils;
import com.unionpay.mobile.android.utils.h;
import com.unionpay.mobile.android.utils.i;
import com.unionpay.mobile.android.utils.j;
import com.unionpay.mobile.android.utils.o;
import com.unionpay.mobile.android.widgets.aj;
import com.unionpay.mobile.android.widgets.m;
import com.unionpay.mobile.android.widgets.p;
import com.unionpay.mobile.android.widgets.z;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class at
  extends b
  implements a.b
{
  private com.unionpay.mobile.android.upviews.a A = null;
  private com.unionpay.mobile.android.upviews.a B = null;
  private boolean C = false;
  private boolean D = false;
  private String E;
  private View.OnClickListener F = new au(this);
  private View.OnClickListener G = new av(this);
  private View.OnClickListener H = new aw(this);
  private View.OnClickListener I = new ax(this);
  private View.OnClickListener J = new ay(this);
  LinearLayout r = new LinearLayout(this.d);
  private String s = "00";
  private int t = 0;
  private int u = 0;
  private int v = 20;
  private int w = 5;
  private com.unionpay.mobile.android.upwidget.a x = null;
  private com.unionpay.mobile.android.upwidget.a y = null;
  private TextView z = null;
  
  public at(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public at(Context paramContext, e parame)
  {
    super(paramContext, parame);
    this.f = 6;
    if (this.a.K) {}
    for (this.q = "bankpay_phoneNO_change";; this.q = "bankpay")
    {
      if (!this.a.K) {
        bool = true;
      }
      this.D = bool;
      setBackgroundColor(-1052684);
      e();
      return;
    }
  }
  
  private void d(String paramString)
  {
    a(paramString, new az(this), new ba(this));
  }
  
  private void d(String paramString1, String paramString2)
  {
    this.u = 9;
    if (TextUtils.isEmpty(paramString2)) {
      this.e.c(paramString1, "");
    }
    for (;;)
    {
      this.w -= 1;
      return;
      paramString2 = "\"uuid\":\"" + paramString2 + "\"";
      this.e.a(paramString1, paramString2, 10);
    }
  }
  
  private static boolean d(JSONObject paramJSONObject)
  {
    return "0".equalsIgnoreCase(i.a(paramJSONObject, "reopen_flag"));
  }
  
  private void e(String paramString)
  {
    this.j = false;
    this.u = 3;
    String str2 = bh.a(this.a.C);
    if (this.x != null) {}
    for (String str1 = this.x.a();; str1 = null)
    {
      paramString = bh.c("1", "1", str1, paramString);
      this.e.c(str2, paramString);
      return;
    }
  }
  
  private void f(int paramInt)
  {
    this.u = 4;
    this.t = paramInt;
    paramInt = this.v;
    this.e.a("query", this.a.aj, 3);
    this.v -= 1;
  }
  
  private String u()
  {
    Object localObject2 = "";
    Object localObject1 = localObject2;
    Object localObject3;
    if (this.B != null)
    {
      localObject3 = this.B.b();
      localObject1 = localObject2;
      if (((a.a)localObject3).a()) {
        localObject1 = "" + ((a.a)localObject3).b;
      }
    }
    localObject2 = localObject1;
    if (this.A != null)
    {
      localObject3 = this.A.b();
      localObject2 = localObject1;
      if (((a.a)localObject3).a())
      {
        localObject3 = ((a.a)localObject3).b;
        localObject2 = localObject1;
        if (!TextUtils.isEmpty((CharSequence)localObject3))
        {
          localObject2 = localObject1;
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            localObject2 = (String)localObject1 + ",";
          }
          localObject2 = (String)localObject2 + (String)localObject3;
        }
      }
    }
    return (String)localObject2;
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
    this.u = 1;
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    this.D = false;
    switch (this.u)
    {
    case 5: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    default: 
    case 1: 
    case 6: 
    case 4: 
    case 2: 
    case 3: 
    case 7: 
    case 8: 
    case 9: 
      Object localObject;
      do
      {
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
                this.u = 0;
                this.B.a(com.unionpay.mobile.android.global.b.p);
                return;
                j();
                i = com.unionpay.mobile.android.nocard.utils.f.a(this.a, paramJSONObject, true);
                if (i != 0) {
                  b(i);
                }
                for (;;)
                {
                  this.u = 0;
                  return;
                  this.a.K = true;
                  paramJSONObject = com.unionpay.mobile.android.nocard.utils.f.a(paramJSONObject);
                  if ((this.a.z != null) && (this.a.z.length() > 0)) {
                    a(6, paramJSONObject);
                  } else if ((this.a.D != null) && (this.a.D.length() > 0)) {
                    d(5);
                  }
                }
                this.s = i.a(paramJSONObject, "status");
                if (d(paramJSONObject))
                {
                  d(i.a(paramJSONObject, "fail_msg"));
                  return;
                }
                if ((this.v > 0) && (this.s.equalsIgnoreCase("01")))
                {
                  f(this.t);
                  return;
                }
                this.u = 0;
                if (this.s.equalsIgnoreCase("00"))
                {
                  switch (this.t)
                  {
                  default: 
                    j();
                    this.u = 0;
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
                    if (this.B != null) {
                      this.B.f();
                    }
                    a(this.d, this.q + "_succeed");
                    if (this.a.f)
                    {
                      paramJSONObject = this.a.aQ;
                      PreferenceUtils.c(this.d, paramJSONObject);
                      this.a.I.f = "success";
                      k();
                      return;
                    }
                    break;
                  case 2: 
                    this.C = true;
                    e(u());
                    return;
                  }
                  d(8);
                  return;
                }
                if (this.s.equalsIgnoreCase("03"))
                {
                  paramJSONObject = i.a(paramJSONObject, "fail_msg");
                  a(this.d, this.q + "_fail", o.j, new String[] { this.s, paramJSONObject });
                  if (this.t == 3)
                  {
                    a(paramJSONObject);
                    return;
                  }
                  localObject = new bb(this);
                  bc localbc = new bc(this);
                  if (this.a.F)
                  {
                    this.b.a((View.OnClickListener)localObject, localbc);
                    this.b.a(com.unionpay.mobile.android.languages.c.bD.ab, paramJSONObject, com.unionpay.mobile.android.languages.c.bD.ac, com.unionpay.mobile.android.languages.c.bD.ad);
                    return;
                  }
                  this.b.a((View.OnClickListener)localObject, null);
                  this.b.a(com.unionpay.mobile.android.languages.c.bD.ab, paramJSONObject, com.unionpay.mobile.android.languages.c.bD.ac);
                  return;
                }
              } while (this.v > 0);
              localObject = c(19);
              paramJSONObject = (JSONObject)localObject;
              if (this.a.ak != null)
              {
                paramJSONObject = (JSONObject)localObject;
                if (!TextUtils.isEmpty(this.a.ak)) {
                  paramJSONObject = this.a.ak;
                }
              }
              if (this.t == 3)
              {
                a(paramJSONObject, true);
                return;
              }
              a(paramJSONObject);
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
              this.v = 20;
              f(this.u);
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
            return;
            j();
            paramJSONObject = i.d(paramJSONObject, "options");
          } while (this.A == null);
          this.A.a(paramJSONObject);
          return;
          localObject = i.a(paramJSONObject, "status");
          if ((localObject == null) || (!"01".equals(localObject))) {
            break;
          }
          paramJSONObject = i.a(paramJSONObject, "uuid");
          if (this.w >= 0)
          {
            d(this.E, paramJSONObject);
            return;
          }
          paramJSONObject = com.unionpay.mobile.android.languages.c.bD.D;
        } while (this.A == null);
        this.A.a(null, paramJSONObject);
        return;
        localObject = i.d(paramJSONObject, "options");
        paramJSONObject = i.a(paramJSONObject, "empty_info");
      } while (this.A == null);
      this.A.a((JSONArray)localObject, paramJSONObject);
      return;
    }
    if (this.b.a()) {
      this.b.c();
    }
    new JSONObject();
    if (!TextUtils.isEmpty(i.a(paramJSONObject, "instalment_empty_info"))) {}
    for (;;)
    {
      this.A.a(paramJSONObject);
      this.u = 0;
      return;
      paramJSONObject = i.c(paramJSONObject, "instalment");
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    TextView localTextView;
    if (this.z != null)
    {
      localTextView = this.z;
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
    this.D = false;
    if ((this.u == 1) && (d(paramJSONObject)))
    {
      d(paramString);
      return true;
    }
    return false;
  }
  
  protected final void b()
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    com.unionpay.mobile.android.widgets.ay localay = new com.unionpay.mobile.android.widgets.ay(getContext(), this.a.A, this);
    localLayoutParams.addRule(13, -1);
    this.k.addView(localay, localLayoutParams);
  }
  
  public final void b(int paramInt)
  {
    if (this.u == 16)
    {
      if (this.b != null) {
        this.b.c();
      }
      z localz = this.A.c("instalment");
      if (localz != null)
      {
        ((p)localz).a(false);
        ((p)localz).b(false);
      }
    }
    super.b(paramInt);
  }
  
  protected final void c()
  {
    this.m.removeAllViews();
    this.o.a(this);
    this.r.setId(this.r.hashCode());
    this.r.setOrientation(1);
    this.r.setBackgroundColor(0);
    Object localObject1 = new RelativeLayout.LayoutParams(-1, -2);
    this.m.addView(this.r, (ViewGroup.LayoutParams)localObject1);
    Object localObject2 = this.r;
    ((LinearLayout)localObject2).removeAllViews();
    localObject1 = new JSONArray();
    if (this.p != null)
    {
      com.unionpay.mobile.android.model.f localf = (com.unionpay.mobile.android.model.f)this.p;
      ((JSONArray)localObject1).put(localf.a("promotion"));
      ((JSONArray)localObject1).put(localf.a("instalment"));
      this.a.aU = localf.a("promotion_instalment_msgbox");
    }
    if (((JSONArray)localObject1).length() > 0)
    {
      this.A = new com.unionpay.mobile.android.upviews.a(this.d, (JSONArray)localObject1, this, this.q);
      this.A.a(this.b, this.a.aU);
      this.A.d(this.a.bs);
      this.A.a(this.G);
      this.A.b(this.H);
      this.A.c(this.I);
      localObject1 = new LinearLayout.LayoutParams(-1, -2);
      ((LinearLayout.LayoutParams)localObject1).topMargin = com.unionpay.mobile.android.global.a.f;
      ((LinearLayout)localObject2).addView(this.A, (ViewGroup.LayoutParams)localObject1);
    }
    localObject1 = null;
    if (this.A != null) {
      localObject1 = this.A.c("instalment");
    }
    this.B = new com.unionpay.mobile.android.upviews.a(this.d, this.a.z, this.e.c(), this, this.a.aq, true, false, (z)localObject1, this.a.ad, this.q);
    localObject1 = new LinearLayout.LayoutParams(-1, -2);
    ((LinearLayout.LayoutParams)localObject1).topMargin = com.unionpay.mobile.android.global.a.f;
    ((LinearLayout)localObject2).addView(this.B, (ViewGroup.LayoutParams)localObject1);
    localObject1 = new LinearLayout(this.d);
    ((LinearLayout)localObject1).setOrientation(1);
    ((LinearLayout)localObject1).setId(localObject1.hashCode());
    localObject2 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(3, this.r.getId());
    ((RelativeLayout.LayoutParams)localObject2).leftMargin = com.unionpay.mobile.android.global.a.f;
    ((RelativeLayout.LayoutParams)localObject2).topMargin = ((RelativeLayout.LayoutParams)localObject2).leftMargin;
    this.m.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    if ((i()) || (this.a.al != null) || (this.a.am != null))
    {
      if (this.a.al != null)
      {
        this.y = new com.unionpay.mobile.android.upwidget.a(this.d, this.a.al, this.J, this.q + "_agree_user_protocol");
        ((LinearLayout)localObject1).addView(this.y);
      }
      if (this.a.am != null)
      {
        this.x = new com.unionpay.mobile.android.upwidget.a(this.d, this.a.am, null, this.q + "_remember_bankNO");
        localObject2 = new LinearLayout.LayoutParams(-2, -2);
        ((LinearLayout.LayoutParams)localObject2).topMargin = com.unionpay.mobile.android.global.a.f;
        ((LinearLayout)localObject1).addView(this.x, (ViewGroup.LayoutParams)localObject2);
      }
    }
    this.z = new TextView(this.d);
    this.z.setText(i.a(this.a.C, "label"));
    this.z.setTextSize(com.unionpay.mobile.android.global.b.i);
    this.z.setTextColor(p());
    this.z.setGravity(17);
    localObject2 = this.z;
    if ((this.B == null) || (this.B.e())) {}
    for (boolean bool = true;; bool = false)
    {
      ((TextView)localObject2).setEnabled(bool);
      int i = com.unionpay.mobile.android.global.a.n;
      localObject2 = this.c.a(2008);
      this.z.setBackgroundDrawable((Drawable)localObject2);
      this.z.setOnClickListener(this.F);
      localObject2 = new RelativeLayout.LayoutParams(-1, i);
      ((RelativeLayout.LayoutParams)localObject2).addRule(3, ((LinearLayout)localObject1).getId());
      ((RelativeLayout.LayoutParams)localObject2).topMargin = com.unionpay.mobile.android.global.a.f;
      i = com.unionpay.mobile.android.utils.f.a(this.d, 10.0F);
      ((RelativeLayout.LayoutParams)localObject2).rightMargin = i;
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = i;
      this.m.addView(this.z, (ViewGroup.LayoutParams)localObject2);
      return;
    }
  }
  
  public final void c(String paramString)
  {
    this.j = false;
    this.b.a(com.unionpay.mobile.android.languages.c.bD.U);
    if (i()) {}
    for (String str = "\"card\":\"" + this.a.aq + "\"";; str = "\"card\":\"" + ((com.unionpay.mobile.android.model.c)this.a.q.get(this.a.N)).a() + "\"")
    {
      j.a("uppay", "cmd:" + paramString + ", ele:" + str);
      this.e.c(paramString, str);
      this.u = 6;
      return;
    }
  }
  
  public final void c(String paramString1, String paramString2)
  {
    a(paramString1, paramString2);
  }
  
  public final void l()
  {
    if (this.B.d()) {
      return;
    }
    if (this.a.L)
    {
      a(13);
      this.a.L = false;
      return;
    }
    if ((this.a.K) && (this.D))
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
  
  protected final void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.B.d();
  }
  
  public final void t()
  {
    this.b.a(com.unionpay.mobile.android.languages.c.bD.U);
    Object localObject = this.A.c("promotion");
    if (localObject != null) {}
    for (localObject = "\"" + ((aj)localObject).g() + "\"";; localObject = "\"\"")
    {
      this.e.c("instalment", "\"promotion\":" + (String)localObject);
      this.u = 16;
      return;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/nocard/views/at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */