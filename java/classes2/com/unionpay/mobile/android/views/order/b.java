package com.unionpay.mobile.android.views.order;

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
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.unionpay.mobile.android.upviews.a.a;
import com.unionpay.mobile.android.utils.j;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b
  extends AbstractMethod
{
  private TextView A;
  private boolean B = false;
  private int C = l.b.intValue();
  private JSONObject g;
  private JSONArray h;
  private boolean i;
  private com.unionpay.mobile.android.upviews.a j;
  private List<Map<String, Object>> k;
  private Drawable l;
  private PopupWindow m;
  private com.unionpay.mobile.android.upwidget.g n;
  private com.unionpay.mobile.android.upwidget.c o;
  private String p;
  private final View.OnClickListener q = new c(this);
  private final View.OnClickListener r = new d(this);
  private final AdapterView.OnItemClickListener s = new e(this);
  private a t;
  private int u = -1;
  private int v = 1;
  private b w;
  private Drawable x;
  private Drawable y;
  private Drawable z;
  
  public b(Context paramContext, List<Map<String, Object>> paramList, String paramString)
  {
    super(paramContext);
    this.k = paramList;
    this.p = paramString;
    this.o = new com.unionpay.mobile.android.upwidget.c(this.b, this.k, com.unionpay.mobile.android.languages.c.bD.bh, this.p, com.unionpay.mobile.android.languages.c.bD.bi, this.v, 0);
    this.o.a(this.q);
    this.n = new com.unionpay.mobile.android.upwidget.g(this.b, this.o);
    this.n.a(this.s);
    this.n.a(this.r);
  }
  
  private final void c(int paramInt)
  {
    int i1 = paramInt - this.o.c();
    if (paramInt == 0) {
      return;
    }
    if ((this.k != null) && (paramInt == this.k.size() + this.o.c()))
    {
      j.a("direct", " new ");
      if (this.w != null) {
        this.w.a();
      }
      this.m.dismiss();
      return;
    }
    if ((this.o.b()) && (this.o.c(paramInt)))
    {
      j.a("direct", " delete " + paramInt);
      i();
      if (this.w != null)
      {
        this.u = i1;
        this.w.a(i1);
      }
    }
    for (;;)
    {
      this.m.dismiss();
      return;
      this.v = paramInt;
      this.o.a(this.v);
      j.a("direct", " pay with " + paramInt);
      if (this.t != null) {
        this.t.b.setText(this.o.b(this.v));
      }
      if (this.w != null) {
        this.w.b(i1);
      }
    }
  }
  
  private boolean h()
  {
    return (this.i) || (this.k == null) || (this.k.size() == 0);
  }
  
  private void i()
  {
    String str1;
    if (this.o != null)
    {
      this.o.a();
      if (!this.o.b()) {
        break label72;
      }
      str1 = com.unionpay.mobile.android.languages.c.bD.bj;
      if (!this.o.b()) {
        break label82;
      }
    }
    label72:
    label82:
    for (String str2 = com.unionpay.mobile.android.languages.c.bD.bk;; str2 = com.unionpay.mobile.android.languages.c.bD.bi)
    {
      this.o.a(str1);
      this.o.b(str2);
      this.o.notifyDataSetChanged();
      return;
      str1 = com.unionpay.mobile.android.languages.c.bD.bh;
      break;
    }
  }
  
  public final b a(Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3)
  {
    this.x = paramDrawable1;
    this.y = paramDrawable2;
    this.z = paramDrawable3;
    return this;
  }
  
  public final b a(b paramb)
  {
    this.w = paramb;
    return this;
  }
  
  public final b a(JSONArray paramJSONArray)
  {
    this.h = paramJSONArray;
    return this;
  }
  
  public final b a(JSONObject paramJSONObject)
  {
    this.g = paramJSONObject;
    if (this.A != null) {
      this.A.setText(Html.fromHtml(a(this.g, "label")));
    }
    return this;
  }
  
  public final void a(int paramInt)
  {
    if (this.k != null) {}
    for (int i1 = this.k.size();; i1 = 0)
    {
      if ((i1 > 0) && (this.u >= 0) && (this.u < i1))
      {
        this.k.remove(this.u);
        this.u = -1;
        this.o.notifyDataSetChanged();
      }
      c(this.o.c() + paramInt);
      return;
    }
  }
  
  public final void a(RelativeLayout paramRelativeLayout)
  {
    Object localObject = new TextView(this.b);
    ((TextView)localObject).setTextSize(com.unionpay.mobile.android.global.b.k);
    ((TextView)localObject).setTextColor(-13421773);
    ((TextView)localObject).setText(this.c);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(9, -1);
    localLayoutParams.addRule(15, -1);
    localLayoutParams.leftMargin = com.unionpay.mobile.android.utils.f.a(this.b, 10.0F);
    paramRelativeLayout.addView((View)localObject, localLayoutParams);
    if (TextUtils.isEmpty(this.c)) {
      paramRelativeLayout.setVisibility(8);
    }
    if (!h()) {
      return;
    }
    localObject = a(this.g, "label");
    this.A = new TextView(this.b);
    this.A.setOnClickListener(new f(this));
    if (!a((String)localObject)) {
      this.A.setText(Html.fromHtml((String)localObject));
    }
    a(this.A);
    localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(11, -1);
    ((RelativeLayout.LayoutParams)localObject).rightMargin = com.unionpay.mobile.android.utils.f.a(this.b, 10.0F);
    ((RelativeLayout.LayoutParams)localObject).addRule(15, -1);
    paramRelativeLayout.addView(this.A, (ViewGroup.LayoutParams)localObject);
  }
  
  public final int b()
  {
    return this.C;
  }
  
  public final b b(Drawable paramDrawable)
  {
    this.l = paramDrawable;
    return this;
  }
  
  public final b b(boolean paramBoolean)
  {
    this.B = paramBoolean;
    return this;
  }
  
  public final void b(int paramInt)
  {
    this.C = paramInt;
  }
  
  public final void b(RelativeLayout paramRelativeLayout)
  {
    if ((h()) || (this.B))
    {
      if (this.B) {
        g();
      }
      this.j = new com.unionpay.mobile.android.upviews.a(this.b, this.h, this, "bankpay");
      localObject1 = new RelativeLayout.LayoutParams(-1, -1);
      ((RelativeLayout.LayoutParams)localObject1).topMargin = com.unionpay.mobile.android.global.a.f;
      paramRelativeLayout.addView(this.j, (ViewGroup.LayoutParams)localObject1);
      return;
    }
    Object localObject2 = new LinearLayout(this.b);
    ((LinearLayout)localObject2).setId(localObject2.hashCode());
    ((LinearLayout)localObject2).setBackgroundColor(-3419943);
    Object localObject1 = new RelativeLayout.LayoutParams(-1, 1);
    ((RelativeLayout.LayoutParams)localObject1).topMargin = com.unionpay.mobile.android.global.a.f;
    paramRelativeLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
    localObject1 = new RelativeLayout(this.b);
    ((RelativeLayout)localObject1).setId(localObject1.hashCode());
    ((RelativeLayout)localObject1).setBackgroundDrawable(this.l);
    ((RelativeLayout)localObject1).setOnClickListener(new g(this));
    Object localObject3 = new RelativeLayout.LayoutParams(-1, com.unionpay.mobile.android.global.b.n);
    ((RelativeLayout.LayoutParams)localObject3).addRule(3, ((LinearLayout)localObject2).getId());
    paramRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
    localObject3 = new ImageView(this.b);
    ((ImageView)localObject3).setId(localObject3.hashCode());
    ((ImageView)localObject3).setBackgroundDrawable(com.unionpay.mobile.android.resource.c.a(this.b).a(1002));
    int i1 = com.unionpay.mobile.android.utils.f.a(this.b, 15.0F);
    localObject2 = new RelativeLayout.LayoutParams(i1, i1);
    ((RelativeLayout.LayoutParams)localObject2).addRule(11, -1);
    ((RelativeLayout.LayoutParams)localObject2).addRule(15, -1);
    ((RelativeLayout.LayoutParams)localObject2).rightMargin = com.unionpay.mobile.android.utils.f.a(this.b, 10.0F);
    ((RelativeLayout)localObject1).addView((View)localObject3, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new TextView(this.b);
    ((TextView)localObject2).setText(this.o.b(this.v));
    ((TextView)localObject2).setTextSize(com.unionpay.mobile.android.global.b.k);
    ((TextView)localObject2).setTextColor(-10066330);
    ((TextView)localObject2).setSingleLine(true);
    ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.MIDDLE);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(9, -1);
    localLayoutParams.addRule(15, -1);
    localLayoutParams.addRule(0, ((ImageView)localObject3).getId());
    localLayoutParams.leftMargin = com.unionpay.mobile.android.utils.f.a(this.b, 10.0F);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    localObject3 = new LinearLayout(this.b);
    ((LinearLayout)localObject3).setBackgroundColor(-3419943);
    localLayoutParams = new RelativeLayout.LayoutParams(-1, 1);
    localLayoutParams.bottomMargin = com.unionpay.mobile.android.global.a.f;
    localLayoutParams.addRule(3, ((RelativeLayout)localObject1).getId());
    paramRelativeLayout.addView((View)localObject3, localLayoutParams);
    this.t = new a((byte)0);
    this.t.a = ((View)localObject1);
    this.t.b = ((TextView)localObject2);
  }
  
  public final void b(String paramString)
  {
    if (this.t != null) {
      this.t.b.setText(paramString);
    }
  }
  
  public final a.a c()
  {
    if (this.j != null) {
      return this.j.b();
    }
    return null;
  }
  
  public final void c(RelativeLayout paramRelativeLayout)
  {
    paramRelativeLayout.setVisibility(8);
  }
  
  public final int d()
  {
    return this.v - this.o.c();
  }
  
  public final b d(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public final b e(String paramString)
  {
    this.d = paramString;
    return this;
  }
  
  public final String e()
  {
    return this.d;
  }
  
  public final void f(String paramString)
  {
    this.o.b(paramString);
  }
  
  public final boolean f()
  {
    return (this.j == null) || (this.j.e());
  }
  
  public final void t() {}
  
  private final class a
  {
    View a;
    TextView b;
    
    private a() {}
  }
  
  public static abstract interface b
  {
    public abstract int a();
    
    public abstract int a(int paramInt);
    
    public abstract int b(int paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/views/order/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */