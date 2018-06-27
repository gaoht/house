package com.unionpay.mobile.android.nocard.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.unionpay.mobile.android.model.d;
import com.unionpay.mobile.android.model.e;
import com.unionpay.mobile.android.nocard.utils.UPPayEngine;
import com.unionpay.mobile.android.upviews.a.a;
import com.unionpay.mobile.android.upviews.a.b;
import com.unionpay.mobile.android.upwidget.UPScrollView;
import com.unionpay.mobile.android.utils.PreferenceUtils;
import com.unionpay.mobile.android.utils.i;
import com.unionpay.mobile.android.utils.j;
import com.unionpay.mobile.android.views.order.l;
import com.unionpay.mobile.android.views.order.o.a;
import com.unionpay.mobile.android.widgets.ay;
import com.unionpay.mobile.android.widgets.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ao
  extends b
  implements a.b
{
  private Handler A = new Handler(new ap(this));
  List<Map<String, Object>> r = new ArrayList(1);
  private int s = 0;
  private int t = -1;
  private Button u = null;
  private com.unionpay.mobile.android.upviews.a v = null;
  private com.unionpay.mobile.android.views.order.o w;
  private LinearLayout x;
  private boolean y = false;
  private Handler z = null;
  
  public ao(Context paramContext, e parame)
  {
    super(paramContext, parame);
    this.f = 2;
    if ((this.a.aE) && (this.a.az)) {
      this.a.aP = l.e.intValue();
    }
    this.q = "order";
    setBackgroundColor(-1052684);
    int i = this.a.ah;
    e();
    if ((!TextUtils.isEmpty(this.a.u)) || (this.a.aC)) {
      this.z = new Handler(new aq(this));
    }
  }
  
  private static Map<String, Object> b(d paramd)
  {
    HashMap localHashMap = new HashMap();
    String str = paramd.a().substring(0, 4) + " **** " + paramd.a().substring(paramd.a().length() - 4);
    localHashMap.put("text1", paramd.b() + paramd.c());
    localHashMap.put("text2", str);
    return localHashMap;
  }
  
  private void d(JSONObject paramJSONObject)
  {
    int i = com.unionpay.mobile.android.nocard.utils.f.a(this.a, paramJSONObject, false);
    if (i != 0) {
      b(i);
    }
    for (;;)
    {
      this.s = 0;
      return;
      paramJSONObject = com.unionpay.mobile.android.nocard.utils.f.a(paramJSONObject);
      if ((this.a.z != null) && (this.a.z.length() > 0)) {
        a(6, paramJSONObject);
      } else if ((this.a.D != null) && (this.a.D.length() > 0)) {
        d(5);
      }
    }
  }
  
  private void e(JSONObject paramJSONObject)
  {
    int i = com.unionpay.mobile.android.nocard.utils.f.b(this.a, paramJSONObject);
    if (i != 0)
    {
      b(i);
      return;
    }
    String str = i.a(paramJSONObject, "userId");
    if (!TextUtils.isEmpty(str)) {
      a(this.d, "_login", com.unionpay.mobile.android.utils.o.e, new Object[] { str });
    }
    if (this.w != null)
    {
      str = this.w.b();
      if (!TextUtils.isEmpty(str)) {
        PreferenceUtils.d(this.d, str);
      }
    }
    a(13, com.unionpay.mobile.android.nocard.utils.f.a(paramJSONObject));
    this.s = 0;
  }
  
  protected void a(Handler paramHandler) {}
  
  protected final void a(com.unionpay.mobile.android.model.a parama)
  {
    this.a.bq = true;
    this.a.br = parama;
    this.s = 2;
    this.b.a(com.unionpay.mobile.android.languages.c.bD.U);
    this.a.M = "0";
    parama = bh.b(this.a.M, "\"pan\":\"" + parama.b() + "\"", "2", "1\",\"carrier_tp\":\"10");
    this.e.c(bh.a(this.a.j), parama);
  }
  
  public final void a(a.a parama) {}
  
  public final void a(JSONObject paramJSONObject)
  {
    this.b.c();
    switch (this.s)
    {
    default: 
    case 2: 
      do
      {
        return;
      } while (b(paramJSONObject));
      d(paramJSONObject);
      return;
    case 1: 
      com.unionpay.mobile.android.model.b localb = this.a;
      localb.X = i.d(paramJSONObject, "login_rules");
      localb.Y = i.c(paramJSONObject, "register_url");
      if ((localb.X != null) && (localb.X.length() > 0)) {
        break;
      }
    }
    for (int i = 2;; i = 0)
    {
      if (i != 0) {
        b(2);
      }
      for (;;)
      {
        this.s = 0;
        return;
        d(12);
      }
      paramJSONObject = this.a;
      i = this.t;
      if ((paramJSONObject.q != null) && (i < paramJSONObject.q.size())) {
        paramJSONObject.q.remove(i);
      }
      if ((this.a.q != null) && (this.a.q.size() > 0)) {
        if (this.t == this.a.N)
        {
          this.a.N = 0;
          this.w.c(this.a.N);
        }
      }
      for (;;)
      {
        this.s = 0;
        return;
        if (this.t >= this.a.N) {
          break;
        }
        paramJSONObject = this.a;
        paramJSONObject.N -= 1;
        break;
        this.a.N = -1;
        c();
      }
      if (b(paramJSONObject)) {
        break;
      }
      e(paramJSONObject);
      return;
      j();
      i = com.unionpay.mobile.android.nocard.utils.f.a(this.a, paramJSONObject, false);
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
      if ((this.a.D == null) || (this.a.D.length() <= 0)) {
        break;
      }
      d(5);
      return;
      this.b.c();
      i = com.unionpay.mobile.android.nocard.utils.f.a(this.a, paramJSONObject, false);
      if (i != 0)
      {
        b(i);
        return;
      }
      a(18, com.unionpay.mobile.android.nocard.utils.f.a(paramJSONObject));
      return;
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    Button localButton;
    if ((this.u != null) && (this.u != null))
    {
      localButton = this.u;
      if (paramBoolean) {
        break label31;
      }
    }
    label31:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localButton.setEnabled(paramBoolean);
      return;
    }
  }
  
  protected final void b()
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    String str = this.a.o;
    Object localObject2 = new ay(this.d, str, this);
    if (!this.a.J)
    {
      if (((!this.a.aE) || (this.a.aP != l.e.intValue())) && (this.a.aP != l.a.intValue()))
      {
        localObject1 = localObject2;
        if (this.a.aP != l.c.intValue()) {
          break label179;
        }
        localObject1 = localObject2;
        if (!this.a.aC) {
          break label179;
        }
        if (this.a.q != null)
        {
          localObject1 = localObject2;
          if (this.a.q.size() > 0) {
            break label179;
          }
        }
      }
      Object localObject1 = new ay(this.d, str, this.c.a(1030), com.unionpay.mobile.android.utils.f.a(this.d, 20.0F), this);
      label179:
      localObject2 = localObject1;
      if (this.a.aP == l.e.intValue())
      {
        ((ay)localObject1).a(com.unionpay.mobile.android.languages.c.bD.bq);
        localObject2 = localObject1;
      }
    }
    for (;;)
    {
      localLayoutParams.addRule(13, -1);
      this.k.addView((View)localObject2, localLayoutParams);
      return;
      ((ay)localObject2).a(com.unionpay.mobile.android.languages.c.bD.l);
    }
  }
  
  protected final void b(String paramString, JSONObject paramJSONObject)
  {
    if ("init".equals(paramString)) {
      if (this.a.J) {
        n();
      }
    }
    do
    {
      return;
      if (!"".equals(paramString)) {
        break;
      }
      if (this.s == 2)
      {
        d(paramJSONObject);
        return;
      }
    } while (this.s != 4);
    e(paramJSONObject);
    return;
    this.b.a(com.unionpay.mobile.android.languages.c.bD.U);
    this.j = false;
    this.s = 5;
    this.e.c(paramString, "");
  }
  
  protected final void c()
  {
    this.m.removeAllViews();
    this.o.a(this);
    Drawable localDrawable2 = this.c.a(2014);
    Drawable localDrawable1 = this.c.a(1002);
    Object localObject2;
    Object localObject1;
    if ((this.a.aP == l.b.intValue()) || (this.a.J))
    {
      localObject2 = com.unionpay.mobile.android.nocard.views.xlistview.a.a(this.d, this.a.q, true);
      localObject1 = localObject2;
      if (this.a.J) {
        if (this.a.aP != l.b.intValue())
        {
          localObject1 = localObject2;
          if (l.a.intValue() != this.a.aP) {}
        }
        else
        {
          localObject1 = null;
        }
      }
      localObject2 = i.a(this.a.w, "label");
      this.w = com.unionpay.mobile.android.views.order.o.a(this.d, this.a.t, (List)localObject1, localDrawable2, localDrawable1, (String)localObject2);
    }
    for (;;)
    {
      this.w.a(new a());
      this.w.b(this.a.au);
      this.w.c(this.a.Y);
      if (!TextUtils.isEmpty(this.a.s)) {}
      try
      {
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("href", this.a.s);
        ((JSONObject)localObject1).put("title", com.unionpay.mobile.android.languages.c.bD.k);
        ((JSONObject)localObject1).put("label", com.unionpay.mobile.android.languages.c.bD.j);
        this.w.a((JSONObject)localObject1);
        localObject1 = this.c.a(2008);
        this.w.b((Drawable)localObject1);
        localObject1 = new RelativeLayout.LayoutParams(-1, -1);
        this.m.addView(this.w, (ViewGroup.LayoutParams)localObject1);
        if ((this.a.aP == l.e.intValue()) && (!com.unionpay.mobile.android.model.b.bk))
        {
          a(this.A);
          this.x = new LinearLayout(this.d);
          this.x.setOrientation(0);
          i = com.unionpay.mobile.android.global.a.w;
          localObject1 = new LinearLayout.LayoutParams(i, i);
          ((LinearLayout.LayoutParams)localObject1).gravity = 17;
          localObject2 = new ProgressBar(this.d);
          this.x.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
          localObject1 = new TextView(this.d);
          ((TextView)localObject1).setText(com.unionpay.mobile.android.languages.c.bD.bs);
          ((TextView)localObject1).setTextSize(com.unionpay.mobile.android.global.b.l);
          ((TextView)localObject1).setTextColor(-10066330);
          localObject2 = new LinearLayout.LayoutParams(-2, -2);
          ((LinearLayout.LayoutParams)localObject2).gravity = 17;
          ((LinearLayout.LayoutParams)localObject2).leftMargin = com.unionpay.mobile.android.global.a.b;
          this.x.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
          this.w.setVisibility(8);
          localObject1 = new RelativeLayout.LayoutParams(-2, -2);
          ((RelativeLayout.LayoutParams)localObject1).topMargin = com.unionpay.mobile.android.global.a.n;
          ((RelativeLayout.LayoutParams)localObject1).addRule(14, -1);
          this.m.addView(this.x, (ViewGroup.LayoutParams)localObject1);
        }
        return;
        if (this.a.aP == l.c.intValue())
        {
          this.w = com.unionpay.mobile.android.views.order.o.a(this.d, localDrawable2, localDrawable1);
          continue;
        }
        if (this.a.aP == l.e.intValue())
        {
          localObject1 = new HashMap();
          if (com.unionpay.mobile.android.model.b.bk)
          {
            if ((com.unionpay.mobile.android.model.b.bb != null) && (com.unionpay.mobile.android.model.b.bb.size() > 0))
            {
              j = com.unionpay.mobile.android.model.b.bb.size();
              i = 0;
              while (i < j)
              {
                localObject1 = b((d)com.unionpay.mobile.android.model.b.bb.get(i));
                this.r.add(localObject1);
                i += 1;
              }
            }
          }
          else {
            this.r.add(localObject1);
          }
          this.w = com.unionpay.mobile.android.views.order.o.b(this.d, this.a.t, this.r, localDrawable2, localDrawable1, "");
          continue;
        }
        this.w = com.unionpay.mobile.android.views.order.o.a(this.d, localDrawable2);
        localObject1 = this.w;
        ((com.unionpay.mobile.android.views.order.o)localObject1).a(localDrawable1);
        int j = l.a.intValue();
        boolean bool = com.unionpay.mobile.android.nocard.utils.f.a(this.a.t);
        int i = j;
        int k;
        if (!bool)
        {
          localObject2 = i.a(this.a.v, "label");
          i = j;
          if (this.a.v != null)
          {
            i = j;
            if (((String)localObject2).length() > 0) {
              i = j | l.c.intValue();
            }
          }
          j.a("uppay", i);
          localObject2 = i.a(this.a.w, "label");
          if ((this.a.w != null) && (((String)localObject2).length() > 0) && (this.a.q != null) && (this.a.q.size() > 0)) {
            ((com.unionpay.mobile.android.views.order.o)localObject1).a(com.unionpay.mobile.android.nocard.views.xlistview.a.a(this.d, this.a.q, true));
          }
          j = i;
          if (this.a.ax)
          {
            j = i;
            if (this.a.ay)
            {
              j = i;
              if (!this.a.aC) {
                j = i | l.d.intValue();
              }
            }
          }
          k = j;
          if (v())
          {
            k = j;
            if (this.a.az)
            {
              k = j;
              if (!this.a.aC) {
                k = j | l.e.intValue();
              }
            }
          }
          i = k;
          if (v())
          {
            i = k;
            if (com.unionpay.mobile.android.model.b.aA)
            {
              i = k;
              if (com.unionpay.mobile.android.model.b.aB)
              {
                i = k;
                if (this.a.aP == l.a.intValue())
                {
                  i = k;
                  if (!"1".equalsIgnoreCase(this.a.an))
                  {
                    j.c("spay", "in");
                    i = k | l.f.intValue();
                  }
                }
              }
            }
          }
        }
        if (this.a.aD) {
          i = l.a.intValue();
        }
        if ((this.a.aC) && (!TextUtils.isEmpty(this.a.u)) && ((this.a.q == null) || (this.a.q.size() <= 0)))
        {
          i = l.a.intValue();
          j = l.a.intValue() | l.c.intValue();
          ((com.unionpay.mobile.android.views.order.o)localObject1).b(i);
        }
        for (;;)
        {
          ((com.unionpay.mobile.android.views.order.o)localObject1).a(this.a.t);
          j.a("uppay", j);
          ((com.unionpay.mobile.android.views.order.o)localObject1).a(i.a(this.a.w, "label"));
          ((com.unionpay.mobile.android.views.order.o)localObject1).a(j);
          ((com.unionpay.mobile.android.views.order.o)localObject1).a(bool);
          ((com.unionpay.mobile.android.views.order.o)localObject1).c();
          break;
          k = com.unionpay.mobile.android.nocard.utils.c.a(this.d, this.a) & i;
          j = k;
          if (k == 0)
          {
            j = k;
            if (!this.a.aD) {
              j = l.b.intValue();
            }
          }
          ((com.unionpay.mobile.android.views.order.o)localObject1).b(j);
          j = i;
          if (!this.a.aD) {
            j = i | l.b.intValue();
          }
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
    }
  }
  
  public final void c(String paramString) {}
  
  public final void c(String paramString1, String paramString2) {}
  
  protected void d(String paramString1, String paramString2) {}
  
  protected final void e(String paramString1, String paramString2)
  {
    if ((paramString2 != null) && (paramString2.length() > 0)) {
      this.a.I.f = paramString2;
    }
    a(paramString1, true);
  }
  
  public final void l()
  {
    if ((!this.a.aE) && (this.a.J))
    {
      super.l();
      this.a.J = false;
      return;
    }
    if ((!this.a.aE) && (((this.a.aP != l.a.intValue()) && ((this.a.aP != l.c.intValue()) || (!this.a.aC) || ((this.a.q != null) && (this.a.q.size() > 0)))) || (this.a.aP == l.e.intValue())))
    {
      super.l();
      this.a.aP = l.a.intValue();
      return;
    }
    u();
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if ((com.unionpay.mobile.android.model.b.bl) && (this.a.aP == l.a.intValue()) && (!"1".equalsIgnoreCase(this.a.an)))
    {
      j.c("spay", "out");
      d(this.a.bo, this.a.bp);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.v != null) {
      this.v.clearFocus();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((!this.y) && (this.z != null))
    {
      this.y = true;
      this.z.sendEmptyMessage(0);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public final void t() {}
  
  protected final void u()
  {
    ar localar = new ar(this);
    as localas = new as(this);
    this.b.a(localar, localas);
    this.b.a(com.unionpay.mobile.android.languages.c.bD.Y, com.unionpay.mobile.android.languages.c.bD.av, com.unionpay.mobile.android.languages.c.bD.W, com.unionpay.mobile.android.languages.c.bD.X);
  }
  
  protected boolean v()
  {
    return false;
  }
  
  protected void w() {}
  
  public final class a
    implements o.a
  {
    public a() {}
    
    public final int a()
    {
      ao.this.a.J = true;
      ao.this.d(2);
      return 0;
    }
    
    public final int a(int paramInt)
    {
      ao.a(ao.this, paramInt);
      ao.b(ao.this, 3);
      ao.this.j = false;
      ao.this.b.a(com.unionpay.mobile.android.languages.c.bD.U);
      ao.this.e.m(((com.unionpay.mobile.android.model.c)ao.this.a.q.get(paramInt)).a());
      return 0;
    }
    
    public final void a(int paramInt1, boolean paramBoolean, int paramInt2, a.a parama)
    {
      if (ao.a(ao.this) != null)
      {
        ao.this.a.aQ = ao.a(ao.this).a();
        j.c("functionEx", ao.this.a.aQ);
      }
      if (paramInt1 == l.e.intValue())
      {
        ao.c(ao.this, paramInt2);
        return;
      }
      if (paramBoolean)
      {
        parama = ao.this;
        ao.a(ao.this.d, "bankpay_choose_bankcard_next");
        ao.this.a.N = paramInt2;
        ao.this.j = false;
        ao.b(ao.this, 2);
        ao.this.b.a(com.unionpay.mobile.android.languages.c.bD.U);
        if (((com.unionpay.mobile.android.model.c)ao.this.a.q.get(paramInt2)).c() == 0)
        {
          parama = ((com.unionpay.mobile.android.model.c)ao.this.a.q.get(paramInt2)).a();
          ao.this.a.M = "1";
        }
        for (parama = bh.a(ao.this.a.M, parama, "1", "1");; parama = bh.b(ao.this.a.M, "\"pan\":\"" + parama + "\"", "2", "1\",\"carrier_tp\":\"2"))
        {
          ao.this.e.c(bh.a(ao.this.a.j), parama);
          return;
          ao.this.a.M = "0";
          parama = ((com.unionpay.mobile.android.model.c)ao.this.a.q.get(paramInt2)).b();
        }
      }
      if (!parama.a())
      {
        ao.this.a(parama.b);
        return;
      }
      if (paramInt1 == l.c.intValue())
      {
        localao = ao.this;
        ao.a(ao.this.d, "login");
        ao.this.j = false;
        ao.b(ao.this, 4);
        ao.this.b.a(com.unionpay.mobile.android.languages.c.bD.U);
        ao.this.e.n(parama.b);
        return;
      }
      ao localao = ao.this;
      ao.a(ao.this.d, "bankpay_input_cardNO_next");
      ao.this.j = false;
      ao.b(ao.this, 2);
      ao.this.b.a(com.unionpay.mobile.android.languages.c.bD.U);
      ao.this.a.M = "0";
      parama = bh.b(ao.this.a.M, parama.b, "1", "1");
      ao.this.e.c(bh.a(ao.this.a.j), parama);
    }
    
    public final void a(String paramString1, String paramString2)
    {
      ao.this.a(paramString1, paramString2);
    }
    
    public final int b(int paramInt)
    {
      ao localao = ao.this;
      ao.a(ao.this.d, "bankpay_choose_bankcard", com.unionpay.mobile.android.utils.o.f, new Object[] { Integer.valueOf(paramInt) });
      return 0;
    }
    
    public final void c(int paramInt)
    {
      ao localao;
      if (paramInt == l.b.intValue())
      {
        localao = ao.this;
        ao.a(ao.this.d, "open_bankpay");
        ao.this.a.aP = l.b.intValue();
        ao.this.d(2);
      }
      do
      {
        return;
        if (paramInt == l.c.intValue())
        {
          localao = ao.this;
          ao.a(ao.this.d, "open_loginpay");
          ao.c(ao.this);
          return;
        }
        if (paramInt == l.d.intValue())
        {
          localao = ao.this;
          ao.a(ao.this.d, "open_nfcpay");
          ao.d(ao.this);
          return;
        }
        if (paramInt == l.e.intValue())
        {
          ao.e(ao.this);
          return;
        }
      } while (paramInt != l.f.intValue());
      ao.this.d(ao.this.a.bo, ao.this.a.bp);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/nocard/views/ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */