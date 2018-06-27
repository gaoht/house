package com.unionpay.mobile.android.nocard.views;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.unionpay.mobile.android.global.a;
import com.unionpay.mobile.android.upviews.b.a;
import com.unionpay.mobile.android.upviews.b.b;
import com.unionpay.mobile.android.utils.f;
import com.unionpay.mobile.android.widgets.ay;
import com.unionpay.mobile.android.widgets.m;
import org.json.JSONObject;

public final class bi
  extends b
  implements b.a, b.b
{
  private static String w = "download://";
  private com.unionpay.mobile.android.upviews.b r = null;
  private ViewGroup s = null;
  private int t = 0;
  private boolean u = false;
  private boolean v = false;
  
  public bi(Context paramContext)
  {
    this(paramContext, 0, false, false);
  }
  
  public bi(Context paramContext, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramContext);
    this.f = 14;
    this.t = paramInt;
    this.u = paramBoolean1;
    this.v = paramBoolean2;
    this.k = a();
    b();
    d();
  }
  
  public final void a(JSONObject paramJSONObject) {}
  
  protected final void b()
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    ay localay = new ay(this.d, this.a.af, this);
    if (this.u) {
      localay = new ay(this.d, this.a.af, this.c.a(1030), f.a(this.d, 20.0F), this);
    }
    localLayoutParams.addRule(13, -1);
    this.k.addView(localay, localLayoutParams);
  }
  
  public final void c(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0) && (paramString.startsWith(w)))
    {
      paramString = paramString.substring(w.length());
      Intent localIntent = new Intent();
      localIntent.setAction("android.intent.action.VIEW");
      localIntent.setData(Uri.parse(paramString));
      this.d.startActivity(localIntent);
    }
  }
  
  protected final void d()
  {
    super.d();
    this.r = new com.unionpay.mobile.android.upviews.b(this.d, this);
    this.r.setOnTouchListener(new bj(this));
    if (this.v) {
      this.r.a(w);
    }
    if (this.t == 0) {}
    for (Object localObject = new RelativeLayout.LayoutParams(-1, -1);; localObject = new RelativeLayout.LayoutParams(-1, this.t))
    {
      ((RelativeLayout.LayoutParams)localObject).addRule(3, this.k.getId());
      ((RelativeLayout.LayoutParams)localObject).addRule(12, -1);
      this.m.addView(this.r, (ViewGroup.LayoutParams)localObject);
      this.s = new RelativeLayout(this.d);
      localObject = new RelativeLayout.LayoutParams(-1, a.t - a.k);
      ((RelativeLayout.LayoutParams)localObject).addRule(3, this.k.getId());
      ((RelativeLayout.LayoutParams)localObject).addRule(12, -1);
      ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = 0;
      ((RelativeLayout.LayoutParams)localObject).topMargin = 0;
      this.m.addView(this.s, (ViewGroup.LayoutParams)localObject);
      localObject = new ProgressBar(this.d);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(13, -1);
      this.s.addView((View)localObject, localLayoutParams);
      this.r.b(this.a.ag);
      if (this.u) {
        a(this.a.bh, false);
      }
      return;
    }
  }
  
  public final void l()
  {
    ((InputMethodManager)this.d.getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
    if (this.u)
    {
      bk localbk = new bk(this);
      bl localbl = new bl(this);
      this.b.a(localbk, localbl);
      this.b.a(com.unionpay.mobile.android.languages.c.bD.Y, com.unionpay.mobile.android.languages.c.bD.av, com.unionpay.mobile.android.languages.c.bD.W, com.unionpay.mobile.android.languages.c.bD.X);
      return;
    }
    super.l();
  }
  
  public final void t()
  {
    this.r.setVisibility(8);
    this.s.setVisibility(0);
  }
  
  public final void u()
  {
    this.r.setVisibility(0);
    this.s.setVisibility(8);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/nocard/views/bi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */