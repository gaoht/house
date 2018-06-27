package com.unionpay.mobile.android.nocard.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.unionpay.mobile.android.nocard.utils.f;
import com.unionpay.mobile.android.upviews.a.a;
import com.unionpay.mobile.android.upviews.a.b;
import com.unionpay.mobile.android.upwidget.UPScrollView;
import com.unionpay.mobile.android.upwidget.w;
import com.unionpay.mobile.android.widgets.ay;
import com.unionpay.mobile.android.widgets.m;
import org.json.JSONObject;

public final class af
  extends b
  implements a.b
{
  private TextView r = null;
  private View.OnClickListener s = null;
  private com.unionpay.mobile.android.upviews.a t = null;
  private int u = 0;
  
  public af(Context paramContext)
  {
    super(paramContext);
    this.f = 12;
    setBackgroundColor(-1052684);
    e();
  }
  
  public final void a(a.a parama) {}
  
  public final void a(JSONObject paramJSONObject)
  {
    switch (this.u)
    {
    default: 
      return;
    }
    this.b.c();
    f.c(this.a, paramJSONObject);
    int i = f.b(this.a, paramJSONObject);
    if (i != 0)
    {
      b(i);
      return;
    }
    if (this.t != null) {
      this.t.f();
    }
    d(13);
  }
  
  public final void a(boolean paramBoolean)
  {
    TextView localTextView;
    if (this.r != null)
    {
      localTextView = this.r;
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
    Object localObject = com.unionpay.mobile.android.languages.c.bD.m;
    localObject = new ay(this.d, (String)localObject, this);
    localLayoutParams.addRule(13, -1);
    this.k.addView((View)localObject, localLayoutParams);
  }
  
  protected final void c()
  {
    boolean bool2 = true;
    this.o.a(this);
    Object localObject1 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(10, -1);
    ((RelativeLayout.LayoutParams)localObject1).topMargin = com.unionpay.mobile.android.global.a.f;
    this.t = new com.unionpay.mobile.android.upviews.a(this.d, this.a.X, this, "");
    this.t.setOrientation(1);
    this.t.setId(this.t.hashCode());
    this.m.addView(this.t, (ViewGroup.LayoutParams)localObject1);
    localObject1 = w.a(this.d, this.a.Y, this.c.a(1017));
    if (localObject1 != null)
    {
      ((w)localObject1).setId(localObject1.hashCode());
      ((w)localObject1).a(new ah(this, ((w)localObject1).a()));
      localObject2 = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(3, this.t.getId());
      i = com.unionpay.mobile.android.global.a.d;
      ((RelativeLayout.LayoutParams)localObject2).bottomMargin = i;
      ((RelativeLayout.LayoutParams)localObject2).topMargin = i;
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = com.unionpay.mobile.android.global.a.d;
      this.m.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    }
    this.r = new TextView(this.d);
    this.r.setText(com.unionpay.mobile.android.languages.c.bD.n);
    this.r.setTextSize(com.unionpay.mobile.android.global.b.i);
    this.r.setTextColor(p());
    this.r.setGravity(17);
    Object localObject2 = this.r;
    boolean bool1 = bool2;
    if (this.t != null)
    {
      if (this.t.e()) {
        bool1 = bool2;
      }
    }
    else
    {
      ((TextView)localObject2).setEnabled(bool1);
      i = com.unionpay.mobile.android.global.a.n;
      localObject2 = this.c.a(2008);
      this.r.setBackgroundDrawable((Drawable)localObject2);
      this.r.setOnClickListener(this.s);
      localObject2 = new RelativeLayout.LayoutParams(-1, i);
      if (localObject1 == null) {
        break label399;
      }
    }
    label399:
    for (int i = ((w)localObject1).getId();; i = this.t.getId())
    {
      ((RelativeLayout.LayoutParams)localObject2).addRule(3, i);
      ((RelativeLayout.LayoutParams)localObject2).topMargin = com.unionpay.mobile.android.global.a.f;
      this.m.addView(this.r, (ViewGroup.LayoutParams)localObject2);
      return;
      bool1 = false;
      break;
    }
  }
  
  public final void c(String paramString) {}
  
  public final void c(String paramString1, String paramString2) {}
  
  public final void t() {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/nocard/views/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */