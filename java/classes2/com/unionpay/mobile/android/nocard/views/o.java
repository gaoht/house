package com.unionpay.mobile.android.nocard.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
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
import com.unionpay.mobile.android.widgets.aj;
import com.unionpay.mobile.android.widgets.ay;
import com.unionpay.mobile.android.widgets.m;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class o
  extends b
  implements a.b
{
  private int A = 20;
  private int B = 5;
  private com.unionpay.mobile.android.upwidget.a C = null;
  private com.unionpay.mobile.android.upviews.a D = null;
  private b E;
  private String F;
  private View.OnClickListener G = new p(this);
  private View.OnClickListener H = new u(this);
  private boolean I = false;
  LinearLayout r = null;
  private int s = 0;
  private com.unionpay.mobile.android.upviews.a t = null;
  private View.OnClickListener u = null;
  private View.OnClickListener v = null;
  private View.OnClickListener w = null;
  private TextView x = null;
  private int y = 0;
  private int z = 0;
  
  public o(Context paramContext, e parame)
  {
    super(paramContext, parame);
    this.f = 13;
    if (this.a.K) {}
    for (this.q = "loginpay_phoneNO_change";; this.q = "loginpay")
    {
      this.u = new v(this);
      this.v = new w(this);
      this.w = new x(this);
      if ((!q()) && (!v()) && (!this.a.aZ)) {
        this.I = true;
      }
      setBackgroundColor(-1052684);
      e();
      if (this.a.aF != null) {
        c(null);
      }
      return;
    }
  }
  
  private void a(LinearLayout paramLinearLayout)
  {
    JSONArray localJSONArray = this.a.ac;
    if (localJSONArray == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < localJSONArray.length())
      {
        com.unionpay.mobile.android.widgets.z localz = a((JSONObject)i.b(localJSONArray, i), this.q);
        if (localz != null) {
          paramLinearLayout.addView(localz);
        }
        i += 1;
      }
    }
  }
  
  private void d(String paramString1, String paramString2)
  {
    this.s = 9;
    if (TextUtils.isEmpty(paramString2)) {
      this.e.c(paramString1, "");
    }
    for (;;)
    {
      this.B -= 1;
      return;
      paramString2 = "\"uuid\":\"" + paramString2 + "\"";
      this.e.a(paramString1, paramString2, 10);
    }
  }
  
  private void d(JSONObject paramJSONObject)
  {
    Object localObject = null;
    boolean bool2 = true;
    int i = com.unionpay.mobile.android.nocard.utils.f.a(this.a, paramJSONObject, false);
    if (i != 0)
    {
      b(i);
      if (1 == this.s) {
        f(this.z);
      }
    }
    do
    {
      return;
      paramJSONObject = com.unionpay.mobile.android.nocard.utils.f.a(paramJSONObject);
      if (5 != this.s) {
        break;
      }
      if ((this.a.z != null) && (this.a.z.length() > 0))
      {
        a(6, paramJSONObject);
        return;
      }
    } while ((this.a.D == null) || (this.a.D.length() <= 0));
    d(5);
    return;
    this.p = paramJSONObject;
    f(this.y);
    this.D.a(u(), this.a.aq, true, null, this.a.ad, this.q);
    this.D.a(this.G);
    this.D.b(this.H);
    this.D.a(this.b, this.a.aU);
    this.D.d(this.a.bs);
    paramJSONObject = (JSONObject)localObject;
    if (this.D != null) {
      paramJSONObject = this.D.c("instalment");
    }
    this.t.a(this.a.z, this.a.aq, true, paramJSONObject, this.a.ad, this.q);
    paramJSONObject = this.x;
    boolean bool1 = bool2;
    if (this.t != null) {
      if (!this.t.e()) {
        break label302;
      }
    }
    label302:
    for (bool1 = bool2;; bool1 = false)
    {
      paramJSONObject.setEnabled(bool1);
      return;
    }
  }
  
  private void f(int paramInt)
  {
    this.y = paramInt;
    this.E.a(this.y);
  }
  
  private JSONArray u()
  {
    JSONArray localJSONArray = new JSONArray();
    if (this.p != null)
    {
      com.unionpay.mobile.android.model.f localf = (com.unionpay.mobile.android.model.f)this.p;
      localJSONArray.put(localf.a("promotion"));
      localJSONArray.put(localf.a("instalment"));
      this.a.aU = localf.a("promotion_instalment_msgbox");
    }
    return localJSONArray;
  }
  
  private final boolean v()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!this.a.aZ)
    {
      bool1 = bool2;
      if (this.a.ab != null)
      {
        bool1 = bool2;
        if (this.a.ab.size() > 0) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void w()
  {
    this.s = 4;
    int i = this.A;
    this.e.a("query", this.a.aj, 3);
    this.A -= 1;
  }
  
  public final void a(a.a parama)
  {
    this.t.d();
    if (!parama.a())
    {
      a(parama.b);
      return;
    }
    this.j = false;
    this.b.a(com.unionpay.mobile.android.languages.c.bD.U);
    this.e.c("sms", parama.b);
    this.s = 2;
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    switch (this.s)
    {
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    default: 
    case 2: 
    case 1: 
    case 5: 
    case 6: 
    case 3: 
    case 4: 
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
                do
                {
                  return;
                  j();
                  this.t.a(com.unionpay.mobile.android.global.b.p);
                  return;
                  j();
                } while (b(paramJSONObject));
                if (this.s == 5) {
                  this.a.L = true;
                }
                d(paramJSONObject);
                return;
                j();
                i = com.unionpay.mobile.android.nocard.utils.f.a(this.a, paramJSONObject, true);
                if (i != 0) {
                  b(i);
                }
                for (;;)
                {
                  this.s = 0;
                  return;
                  this.a.K = true;
                  paramJSONObject = com.unionpay.mobile.android.nocard.utils.f.a(paramJSONObject);
                  if ((this.a.z != null) && (this.a.z.length() > 0)) {
                    a(6, paramJSONObject);
                  } else if ((this.a.D != null) && (this.a.D.length() > 0)) {
                    d(5);
                  }
                }
                this.a.aj = h.a(paramJSONObject.toString());
                paramJSONObject = i.a(paramJSONObject, "qn");
                if (!TextUtils.isEmpty(paramJSONObject)) {
                  this.a.n = this.e.i(com.unionpay.mobile.android.utils.c.b(paramJSONObject));
                }
                if (this.a.aj == null)
                {
                  b(2);
                  return;
                }
                this.A = 20;
                w();
                return;
                localObject = i.a(paramJSONObject, "status");
                if ((this.A > 0) && (((String)localObject).equalsIgnoreCase("01")))
                {
                  w();
                  return;
                }
                j();
                if (((String)localObject).equalsIgnoreCase("00"))
                {
                  this.s = 0;
                  this.a.H = i.d(paramJSONObject, "result");
                  this.a.P = i.a(paramJSONObject, "openupgrade_flag");
                  this.a.Q = i.a(paramJSONObject, "temporary_pay_flag");
                  this.a.R = i.a(paramJSONObject, "temporary_pay_info");
                  this.a.V = i.a(paramJSONObject, "front_url");
                  this.a.W = i.a(paramJSONObject, "front_request");
                  this.a.A = i.a(paramJSONObject, "title");
                  this.a.B = i.a(paramJSONObject, "succ_info");
                  com.unionpay.mobile.android.nocard.utils.b.a(paramJSONObject, this.a);
                  com.unionpay.mobile.android.nocard.utils.b.b(paramJSONObject, this.a);
                  a(this.d, this.q + "_succeed");
                  if (this.a.f)
                  {
                    paramJSONObject = this.a.aQ;
                    PreferenceUtils.c(this.d, paramJSONObject);
                    this.a.I.f = "success";
                    k();
                    return;
                  }
                  d(8);
                  return;
                }
                if (((String)localObject).equalsIgnoreCase("03"))
                {
                  paramJSONObject = i.a(paramJSONObject, "fail_msg");
                  a(this.d, this.q + "_fail", com.unionpay.mobile.android.utils.o.j, new String[] { localObject, paramJSONObject });
                  a(paramJSONObject);
                  return;
                }
              } while (this.A > 0);
              b(19);
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
          } while (this.D == null);
          this.D.a(paramJSONObject);
          return;
          localObject = i.a(paramJSONObject, "status");
          if ((localObject == null) || (!"01".equals(localObject))) {
            break;
          }
          paramJSONObject = i.a(paramJSONObject, "uuid");
          if (this.B >= 0)
          {
            d(this.F, paramJSONObject);
            return;
          }
          paramJSONObject = com.unionpay.mobile.android.languages.c.bD.D;
        } while (this.D == null);
        this.D.a(null, paramJSONObject);
        return;
        localObject = i.d(paramJSONObject, "options");
        paramJSONObject = i.a(paramJSONObject, "empty_info");
      } while (this.D == null);
      this.D.a((JSONArray)localObject, paramJSONObject);
      return;
    }
    if (this.b.a()) {
      this.b.c();
    }
    new JSONObject();
    if (!TextUtils.isEmpty(i.a(paramJSONObject, "instalment_empty_info"))) {}
    for (;;)
    {
      this.D.a(paramJSONObject);
      this.s = 0;
      return;
      paramJSONObject = i.c(paramJSONObject, "instalment");
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    TextView localTextView = this.x;
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localTextView.setEnabled(paramBoolean);
      return;
    }
  }
  
  protected final boolean a(String paramString, JSONObject paramJSONObject)
  {
    if (this.s == 1)
    {
      f(this.z);
      j();
      a(paramString);
      return true;
    }
    return false;
  }
  
  protected final void b()
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    String str = com.unionpay.mobile.android.languages.c.bD.o;
    ay localay2 = new ay(this.d, str, this);
    ay localay1 = localay2;
    if (this.a.aC) {
      if (this.a.q != null)
      {
        localay1 = localay2;
        if (this.a.q.size() != 0) {}
      }
      else
      {
        localay1 = localay2;
        if (!this.a.aZ)
        {
          localay1 = localay2;
          if (!TextUtils.isEmpty(this.a.u)) {
            localay1 = new ay(this.d, str, this.c.a(1030), com.unionpay.mobile.android.utils.f.a(this.d, 20.0F), this);
          }
        }
      }
    }
    localLayoutParams.addRule(13, -1);
    this.k.addView(localay1, localLayoutParams);
  }
  
  public final void b(int paramInt)
  {
    if (this.s == 16)
    {
      if (this.b != null) {
        this.b.c();
      }
      com.unionpay.mobile.android.widgets.z localz = this.D.c("instalment");
      if (localz != null)
      {
        ((com.unionpay.mobile.android.widgets.p)localz).a(false);
        ((com.unionpay.mobile.android.widgets.p)localz).b(false);
      }
    }
    super.b(paramInt);
  }
  
  protected final void b(String paramString, JSONObject paramJSONObject)
  {
    if ("init".equals(paramString)) {
      a(2);
    }
    do
    {
      return;
      if (!"".equals(paramString)) {
        break;
      }
      if (this.s == 5) {
        this.a.L = true;
      }
    } while (paramJSONObject == null);
    d(paramJSONObject);
    return;
    this.b.a(com.unionpay.mobile.android.languages.c.bD.U);
    this.j = false;
    this.s = 7;
    this.e.c(paramString, "");
  }
  
  protected final void c()
  {
    this.m.removeAllViews();
    this.o.a(this);
    LinearLayout localLinearLayout = new LinearLayout(this.d);
    localLinearLayout.setOrientation(1);
    Object localObject1 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject1).topMargin = com.unionpay.mobile.android.global.a.f;
    ((RelativeLayout.LayoutParams)localObject1).addRule(10, -1);
    this.m.addView(localLinearLayout, (ViewGroup.LayoutParams)localObject1);
    a(localLinearLayout);
    localObject1 = u();
    if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0) && (v()))
    {
      this.D = new com.unionpay.mobile.android.upviews.a(this.d, (JSONArray)localObject1, this, this.q);
      this.D.a(this.G);
      this.D.b(this.H);
      this.D.a(this.b, this.a.aU);
      this.D.d(this.a.bs);
      localObject1 = new LinearLayout.LayoutParams(-1, -2);
      ((LinearLayout.LayoutParams)localObject1).bottomMargin = com.unionpay.mobile.android.global.a.f;
      localLinearLayout.addView(this.D, (ViewGroup.LayoutParams)localObject1);
    }
    Object localObject2;
    Object localObject3;
    boolean bool;
    if (q()) {
      if (!v())
      {
        if (!TextUtils.isEmpty(this.a.ae))
        {
          localObject1 = new LinearLayout.LayoutParams(-1, -2);
          ((LinearLayout.LayoutParams)localObject1).topMargin = com.unionpay.mobile.android.global.a.f;
          localObject2 = new TextView(this.d);
          ((TextView)localObject2).setTextSize(com.unionpay.mobile.android.global.b.k);
          ((TextView)localObject2).setText(this.a.ae);
          localLinearLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
        }
        localObject1 = new LinearLayout(this.d);
        ((LinearLayout)localObject1).setOrientation(1);
        ((LinearLayout)localObject1).setId(localObject1.hashCode());
        localObject2 = new LinearLayout.LayoutParams(-1, -2);
        ((LinearLayout.LayoutParams)localObject2).topMargin = com.unionpay.mobile.android.global.a.d;
        localLinearLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
        if ((this.a.Z != null) && (v()))
        {
          this.C = new com.unionpay.mobile.android.upwidget.a(this.d, com.unionpay.mobile.android.nocard.views.xlistview.a.a(this.a.Z, com.unionpay.mobile.android.languages.c.bD.s), new q(this), this.q + "_agree_user_protocol");
          ((LinearLayout)localObject1).addView(this.C);
        }
        localObject2 = com.unionpay.mobile.android.upwidget.w.a(this.d, this.a.aa, this.c.a(1017));
        if (localObject2 != null)
        {
          ((com.unionpay.mobile.android.upwidget.w)localObject2).a(new r(this, ((com.unionpay.mobile.android.upwidget.w)localObject2).a()));
          localObject3 = new LinearLayout.LayoutParams(-2, -2);
          ((LinearLayout.LayoutParams)localObject3).topMargin = com.unionpay.mobile.android.global.a.f;
          ((LinearLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
        }
        this.x = new TextView(this.d);
        if (!v()) {
          break label1500;
        }
        this.x.setText(com.unionpay.mobile.android.languages.c.bD.p);
        this.x.setOnClickListener(this.u);
        localObject1 = this.x;
        if ((this.t != null) && (!this.t.e())) {
          break label1495;
        }
        bool = true;
        label575:
        ((TextView)localObject1).setEnabled(bool);
      }
    }
    for (;;)
    {
      this.x.setTextSize(com.unionpay.mobile.android.global.b.i);
      this.x.setTextColor(p());
      this.x.setGravity(17);
      int i = com.unionpay.mobile.android.global.a.n;
      localObject1 = this.c.a(2008);
      this.x.setBackgroundDrawable((Drawable)localObject1);
      localObject1 = new LinearLayout.LayoutParams(-1, i);
      ((LinearLayout.LayoutParams)localObject1).topMargin = com.unionpay.mobile.android.global.a.f;
      i = com.unionpay.mobile.android.utils.f.a(this.d, 10.0F);
      ((LinearLayout.LayoutParams)localObject1).rightMargin = i;
      ((LinearLayout.LayoutParams)localObject1).leftMargin = i;
      localLinearLayout.addView(this.x, (ViewGroup.LayoutParams)localObject1);
      return;
      localObject1 = new LinearLayout(this.d);
      ((LinearLayout)localObject1).setBackgroundColor(-3419943);
      localObject2 = new LinearLayout.LayoutParams(-1, 1);
      ((LinearLayout.LayoutParams)localObject2).topMargin = com.unionpay.mobile.android.global.a.f;
      localLinearLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      localObject2 = new LinearLayout.LayoutParams(-1, -2);
      this.E = new b(this.d, new z(this), com.unionpay.mobile.android.nocard.views.xlistview.a.a(this.d, this.a.ab, false), com.unionpay.mobile.android.languages.c.bD.bh, this.a.aY);
      localLinearLayout.addView(this.E, (ViewGroup.LayoutParams)localObject2);
      localObject1 = null;
      if (this.D != null) {
        localObject1 = this.D.c("instalment");
      }
      this.t = new com.unionpay.mobile.android.upviews.a(this.d, this.a.z, this.e.c(), this, this.a.aq, true, true, (com.unionpay.mobile.android.widgets.z)localObject1, this.a.ad, this.q);
      localLinearLayout.addView(this.t, (ViewGroup.LayoutParams)localObject2);
      break;
      if (!v())
      {
        if (TextUtils.isEmpty(this.a.aY))
        {
          localObject1 = new LinearLayout.LayoutParams(-1, -2);
          ((LinearLayout.LayoutParams)localObject1).topMargin = com.unionpay.mobile.android.global.a.f;
          ((LinearLayout.LayoutParams)localObject1).leftMargin = com.unionpay.mobile.android.utils.f.a(this.d, 10.0F);
          localObject2 = new TextView(this.d);
          ((TextView)localObject2).setTextSize(com.unionpay.mobile.android.global.b.k);
          ((TextView)localObject2).setText(this.a.ae);
          localLinearLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
          break;
        }
        localObject1 = new RelativeLayout(this.d);
        localObject2 = new TextView(this.d);
        ((TextView)localObject2).setTextSize(com.unionpay.mobile.android.global.b.k);
        ((TextView)localObject2).setTextColor(-13421773);
        ((TextView)localObject2).setText(com.unionpay.mobile.android.languages.c.bD.bA);
        localObject3 = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject3).addRule(9, -1);
        ((RelativeLayout.LayoutParams)localObject3).addRule(15, -1);
        ((RelativeLayout.LayoutParams)localObject3).leftMargin = com.unionpay.mobile.android.utils.f.a(this.d, 10.0F);
        ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
        localObject2 = new TextView(this.d);
        ((TextView)localObject2).setText(Html.fromHtml(com.unionpay.mobile.android.languages.c.bD.j));
        ((TextView)localObject2).setTextSize(com.unionpay.mobile.android.global.b.k);
        ((TextView)localObject2).setTextColor(com.unionpay.mobile.android.utils.g.a(-10705958, -5846275, -5846275, -6710887));
        ((TextView)localObject2).setOnClickListener(new y(this));
        localObject3 = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject3).addRule(11, -1);
        ((RelativeLayout.LayoutParams)localObject3).rightMargin = com.unionpay.mobile.android.utils.f.a(this.d, 10.0F);
        ((RelativeLayout.LayoutParams)localObject3).addRule(15, -1);
        ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
        localObject2 = new LinearLayout.LayoutParams(-1, -2);
        ((LinearLayout.LayoutParams)localObject2).topMargin = com.unionpay.mobile.android.global.a.f;
        localLinearLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
        this.t = new com.unionpay.mobile.android.upviews.a(this.d, this.a.t, this, this.q);
        localObject1 = new LinearLayout.LayoutParams(-1, -2);
        ((LinearLayout.LayoutParams)localObject1).topMargin = com.unionpay.mobile.android.global.a.f;
        localLinearLayout.addView(this.t, (ViewGroup.LayoutParams)localObject1);
        break;
      }
      localObject1 = new LinearLayout(this.d);
      ((LinearLayout)localObject1).setBackgroundColor(-3419943);
      localLinearLayout.addView((View)localObject1, new LinearLayout.LayoutParams(-1, 1));
      localObject1 = new LinearLayout.LayoutParams(-1, -2);
      this.E = new b(this.d, new aa(this), com.unionpay.mobile.android.nocard.views.xlistview.a.a(this.d, this.a.ab, false), com.unionpay.mobile.android.languages.c.bD.bh, this.a.aY);
      localLinearLayout.addView(this.E, (ViewGroup.LayoutParams)localObject1);
      localObject1 = null;
      if (this.D != null) {
        localObject1 = this.D.c("instalment");
      }
      this.t = new com.unionpay.mobile.android.upviews.a(this.d, this.a.z, this.e.c(), this, this.a.aq, true, true, (com.unionpay.mobile.android.widgets.z)localObject1, this.a.ad, this.q);
      localObject1 = new LinearLayout.LayoutParams(-1, -2);
      localLinearLayout.addView(this.t, (ViewGroup.LayoutParams)localObject1);
      break;
      label1495:
      bool = false;
      break label575;
      label1500:
      if (q())
      {
        this.x.setText(com.unionpay.mobile.android.languages.c.bD.q);
        this.x.setOnClickListener(new ab(this));
        this.x.setEnabled(true);
      }
      else
      {
        if ((TextUtils.isEmpty(this.a.aY)) && (!this.a.aZ))
        {
          if ((this.a.q == null) || (this.a.q.size() == 0)) {
            this.x.setText(com.unionpay.mobile.android.languages.c.bD.bu);
          }
          for (;;)
          {
            this.x.setOnClickListener(this.w);
            this.x.setEnabled(true);
            break;
            this.x.setText(com.unionpay.mobile.android.languages.c.bD.bv);
          }
        }
        this.x.setText(com.unionpay.mobile.android.languages.c.bD.r);
        this.x.setOnClickListener(this.v);
        this.x.setEnabled(false);
      }
    }
  }
  
  public final void c(String paramString)
  {
    this.j = false;
    this.b.a(com.unionpay.mobile.android.languages.c.bD.U);
    if (this.a.aZ) {}
    for (String str = "\"card\":\"" + this.a.aq + "\"";; str = "\"card\":\"" + ((com.unionpay.mobile.android.model.c)this.a.ab.get(this.y)).a() + "\"")
    {
      j.a("uppay", "cmd:" + paramString + ", ele:" + str);
      this.e.c(paramString, str);
      this.s = 6;
      return;
    }
  }
  
  public final void c(String paramString1, String paramString2)
  {
    a(paramString1, paramString2);
  }
  
  public final void l()
  {
    if ((!TextUtils.isEmpty(this.a.u)) && (this.a.aC) && ((this.a.q == null) || (this.a.q.size() == 0)))
    {
      s locals = new s(this);
      t localt = new t(this);
      this.b.a(locals, localt);
      this.b.a(com.unionpay.mobile.android.languages.c.bD.Y, com.unionpay.mobile.android.languages.c.bD.av, com.unionpay.mobile.android.languages.c.bD.W, com.unionpay.mobile.android.languages.c.bD.X);
    }
    do
    {
      return;
      if (this.a.aZ) {
        this.a.aZ = false;
      }
    } while ((this.t != null) && (this.t.d()));
    if ((this.a.u != null) && (this.a.u.length() > 0))
    {
      a(2);
      return;
    }
    n();
  }
  
  protected final void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    boolean bool = this.I;
  }
  
  public final void t()
  {
    this.b.a(com.unionpay.mobile.android.languages.c.bD.U);
    Object localObject = this.D.c("promotion");
    if (localObject != null) {}
    for (localObject = "\"" + ((aj)localObject).g() + "\"";; localObject = "\"\"")
    {
      this.e.c("instalment", "\"promotion\":" + (String)localObject);
      this.s = 16;
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt);
  }
  
  private final class b
    extends LinearLayout
  {
    private PopupWindow b;
    private com.unionpay.mobile.android.upwidget.c c;
    private com.unionpay.mobile.android.upwidget.g d;
    private String e;
    private TextView f;
    private int g = 1;
    private final View.OnClickListener h = new ac(this);
    private final AdapterView.OnItemClickListener i = new ad(this);
    private List<Map<String, Object>> j;
    private o.a k;
    private String l;
    
    public b(o.a parama, List<Map<String, Object>> paramList, JSONArray paramJSONArray, String paramString)
    {
      super();
      setOrientation(1);
      this.k = paramList;
      this.j = paramJSONArray;
      this.e = paramString;
      String str;
      this.l = str;
      this.c = new com.unionpay.mobile.android.upwidget.c(o.this.d, this.j, this.e, this.l, "", this.g, 0);
      this.d = new com.unionpay.mobile.android.upwidget.g(o.this.d, this.c);
      this.d.a(this.i);
      this.d.a(this.h);
      if ((paramJSONArray != null) && (paramJSONArray.size() > 0))
      {
        parama = com.unionpay.mobile.android.resource.c.a(o.this.d).a(2014);
        this$1 = new RelativeLayout(o.this.d);
        o.this.setBackgroundDrawable(parama);
        o.this.setOnClickListener(new ae(this));
        addView(o.this, new LinearLayout.LayoutParams(-1, com.unionpay.mobile.android.global.a.n));
        parama = new ImageView(o.this.d);
        parama.setId(parama.hashCode());
        parama.setBackgroundDrawable(com.unionpay.mobile.android.resource.c.a(o.this.d).a(1002));
        int m = com.unionpay.mobile.android.utils.f.a(o.this.d, 15.0F);
        paramList = new RelativeLayout.LayoutParams(m, m);
        paramList.addRule(11, -1);
        paramList.addRule(15, -1);
        paramList.rightMargin = com.unionpay.mobile.android.utils.f.a(o.this.d, 10.0F);
        o.this.addView(parama, paramList);
        this.f = new TextView(o.this.d);
        this.f.setTextSize(com.unionpay.mobile.android.global.b.k);
        this.f.setTextColor(-10066330);
        paramList = new RelativeLayout.LayoutParams(-1, -2);
        this.f.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        this.f.setSingleLine(true);
        paramList.leftMargin = com.unionpay.mobile.android.utils.f.a(o.this.d, 10.0F);
        paramList.rightMargin = paramList.leftMargin;
        paramList.addRule(15, -1);
        paramList.addRule(9, -1);
        paramList.addRule(0, parama.getId());
        o.this.addView(this.f, paramList);
        a(0);
      }
    }
    
    public final void a(int paramInt)
    {
      int m = this.c.c();
      if (this.f != null) {
        this.f.setText(this.c.b(m + paramInt));
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/nocard/views/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */