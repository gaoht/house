package com.unionpay.mobile.android.widgets;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.unionpay.mobile.android.global.a;
import com.unionpay.mobile.android.global.b;
import com.unionpay.mobile.android.resource.c;
import com.unionpay.mobile.android.utils.f;
import com.unionpay.mobile.android.utils.g;
import java.lang.ref.WeakReference;

public final class m
{
  private static final float k = b.k;
  private static final float l = b.k;
  private static final float m = b.j;
  private Context a = null;
  private TextView b = null;
  private WeakReference<View.OnClickListener> c = null;
  private TextView d = null;
  private WeakReference<View.OnClickListener> e = null;
  private int f = 0;
  private c g = null;
  private Dialog h = null;
  private Drawable i = null;
  private WeakReference<DialogInterface.OnDismissListener> j = null;
  
  public m(Context paramContext)
  {
    this(paramContext, (byte)0);
  }
  
  private m(Context paramContext, byte paramByte)
  {
    this.a = paramContext;
    this.j = new WeakReference(null);
    this.g = c.a(paramContext);
    this.f = (a.I - a.b * 4);
    paramByte = this.f / 2;
    this.i = this.g.a(1028, paramByte, -1);
  }
  
  private RelativeLayout a(Context paramContext)
  {
    c();
    this.h = new n(this, paramContext);
    if ((this.j != null) && (this.j.get() != null)) {
      this.h.setOnDismissListener((DialogInterface.OnDismissListener)this.j.get());
    }
    this.h.setCanceledOnTouchOutside(false);
    this.h.setOwnerActivity((Activity)paramContext);
    this.h.requestWindowFeature(1);
    this.h.getWindow().setBackgroundDrawable(this.g.a(4004));
    paramContext = new RelativeLayout(this.a);
    this.h.getWindow().setBackgroundDrawable(this.g.a(4004));
    Object localObject = new RelativeLayout.LayoutParams(this.f, -2);
    this.h.setContentView(paramContext, (ViewGroup.LayoutParams)localObject);
    localObject = new RelativeLayout(this.a);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(13, -1);
    paramContext.addView((View)localObject, localLayoutParams);
    return paramContext;
  }
  
  private boolean d()
  {
    return ((Activity)this.a).isFinishing();
  }
  
  public final void a(View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    this.c = new WeakReference(paramOnClickListener1);
    this.e = new WeakReference(paramOnClickListener2);
  }
  
  public final void a(String paramString)
  {
    int n = f.a(this.a, 12.0F);
    f.a(this.a, 20.0F);
    RelativeLayout localRelativeLayout = a(this.a);
    localRelativeLayout.setBackgroundColor(a.M);
    if (this.h != null)
    {
      localObject1 = this.h.getWindow().getAttributes();
      ((WindowManager.LayoutParams)localObject1).alpha = 0.7F;
      this.h.getWindow().setAttributes((WindowManager.LayoutParams)localObject1);
    }
    Object localObject1 = new LinearLayout(this.a);
    ((LinearLayout)localObject1).setOrientation(1);
    ((LinearLayout)localObject1).setGravity(17);
    int i1 = a.j;
    int i2 = this.f;
    Object localObject2 = new ImageView(this.a);
    ((ImageView)localObject2).setImageDrawable(this.i);
    ((LinearLayout)localObject1).addView((View)localObject2, new LinearLayout.LayoutParams(i2 - (i1 << 1), -2));
    localObject2 = new TextView(this.a);
    ((TextView)localObject2).setTextSize(l);
    ((TextView)localObject2).setTextColor(-1);
    ((TextView)localObject2).setText(paramString);
    ((TextView)localObject2).setGravity(16);
    paramString = new LinearLayout.LayoutParams(-2, -2);
    paramString.topMargin = n;
    ((LinearLayout)localObject1).addView((View)localObject2, paramString);
    paramString = new LinearLayout(this.a);
    paramString.setOrientation(0);
    paramString.setGravity(17);
    i1 = a.p;
    paramString = new LinearLayout.LayoutParams(i1, i1);
    paramString.topMargin = n;
    ((LinearLayout)localObject1).addView(new ProgressBar(this.a), paramString);
    paramString = new RelativeLayout.LayoutParams(-1, -2);
    paramString.addRule(10, -1);
    paramString.addRule(14, -1);
    n = f.a(this.a, 20.0F);
    localRelativeLayout.setPadding(n, n, n, n);
    localRelativeLayout.addView((View)localObject1, paramString);
    if ((this.h != null) && (!this.h.isShowing()) && (!d()))
    {
      paramString = this.h;
      if (!(paramString instanceof Dialog)) {
        paramString.show();
      }
    }
    else
    {
      return;
    }
    VdsAgent.showDialog((Dialog)paramString);
  }
  
  public final void a(String paramString1, String paramString2, String paramString3)
  {
    Object localObject = a(this.a);
    int n = a.b;
    LinearLayout localLinearLayout = new LinearLayout(this.a);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setGravity(1);
    ((RelativeLayout)localObject).addView(localLinearLayout, new LinearLayout.LayoutParams(-1, -2));
    if ((paramString1 != null) && (paramString1.length() != 0))
    {
      localObject = new TextView(this.a);
      ((TextView)localObject).getPaint().setFakeBoldText(true);
      ((TextView)localObject).setTextSize(k);
      ((TextView)localObject).setTextColor(-13421773);
      ((TextView)localObject).setText(paramString1);
      ((TextView)localObject).setGravity(17);
      ((TextView)localObject).setPadding(n, n << 1, n, n);
      localLinearLayout.addView((View)localObject, new LinearLayout.LayoutParams(-1, -2));
    }
    paramString1 = new TextView(this.a);
    paramString1.setTextSize(l);
    paramString1.setTextColor(-13421773);
    paramString1.setText(paramString2);
    paramString1.setPadding(n, n, n, 0);
    paramString1.setGravity(17);
    localLinearLayout.addView(paramString1, new LinearLayout.LayoutParams(-1, -2));
    paramString1 = new FrameLayout(this.a);
    paramString2 = new LinearLayout.LayoutParams(-1, -2);
    paramString2.topMargin = (a.b << 1);
    localLinearLayout.addView(paramString1, paramString2);
    paramString2 = new LinearLayout(this.a);
    paramString2.setOrientation(1);
    paramString1.addView(paramString2, new LinearLayout.LayoutParams(-1, -2));
    localLinearLayout = new LinearLayout(this.a);
    localLinearLayout.setOrientation(0);
    localLinearLayout.setBackgroundColor(-7829368);
    new LinearLayout.LayoutParams(-1, -2);
    paramString2.addView(localLinearLayout);
    localLinearLayout = new LinearLayout(this.a);
    paramString2.addView(localLinearLayout, new LinearLayout.LayoutParams(-1, -2));
    localLinearLayout.setOrientation(0);
    localLinearLayout.setGravity(17);
    this.b = new TextView(this.a);
    this.b.setPadding(5, 5, 5, 5);
    this.b.getPaint().setFakeBoldText(true);
    this.b.setText(paramString3);
    this.b.setTextSize(m);
    this.b.setTextColor(g.a(-15364869, -5846275));
    this.b.setGravity(17);
    n = a.o;
    if ((this.c != null) && (this.c.get() != null)) {
      this.b.setOnClickListener((View.OnClickListener)this.c.get());
    }
    paramString2 = new LinearLayout.LayoutParams(-1, n);
    localLinearLayout.addView(this.b, paramString2);
    paramString1.addView(new o(this.a), new FrameLayout.LayoutParams(-1, a.H));
    if ((this.h != null) && (!this.h.isShowing()) && (!d()))
    {
      paramString1 = this.h;
      if (!(paramString1 instanceof Dialog)) {
        paramString1.show();
      }
    }
    else
    {
      return;
    }
    VdsAgent.showDialog((Dialog)paramString1);
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    a(paramString1, paramString2, paramString3, paramString4, true);
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    Object localObject = a(this.a);
    int n = a.b;
    LinearLayout localLinearLayout = new LinearLayout(this.a);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setGravity(1);
    ((RelativeLayout)localObject).addView(localLinearLayout, new LinearLayout.LayoutParams(-1, -2));
    if ((paramString1 != null) && (paramString1.length() != 0))
    {
      localObject = new TextView(this.a);
      ((TextView)localObject).getPaint().setFakeBoldText(true);
      ((TextView)localObject).setTextSize(k);
      ((TextView)localObject).setTextColor(-13421773);
      ((TextView)localObject).setText(paramString1);
      ((TextView)localObject).setGravity(17);
      ((TextView)localObject).setPadding(n, n << 1, n, n);
      localLinearLayout.addView((View)localObject, new LinearLayout.LayoutParams(-1, -2));
    }
    paramString1 = new TextView(this.a);
    paramString1.setTextSize(l);
    paramString1.setTextColor(-13421773);
    paramString1.setText(paramString2);
    paramString1.setPadding(n, n, n, 0);
    paramString1.setGravity(17);
    localLinearLayout.addView(paramString1, new LinearLayout.LayoutParams(-1, -2));
    n = f.a(this.a, 1.0F);
    paramString1 = new LinearLayout(this.a);
    paramString1.setOrientation(0);
    paramString1.setBackgroundColor(-7829368);
    paramString2 = new LinearLayout.LayoutParams(-1, n);
    paramString2.topMargin = (a.b << 1);
    localLinearLayout.addView(paramString1, paramString2);
    paramString1 = new LinearLayout(this.a);
    paramString1.setBackgroundColor(-1);
    localLinearLayout.addView(paramString1, new LinearLayout.LayoutParams(-1, -2));
    paramString1.setOrientation(0);
    paramString1.setGravity(17);
    int i1 = this.f - a.H >> 1;
    this.b = new TextView(this.a);
    if (!paramBoolean) {
      this.b.getPaint().setFakeBoldText(true);
    }
    this.b.setText(paramString3);
    this.b.setTextSize(m);
    this.b.setTextColor(g.a(-15364869, -5846275));
    this.b.setGravity(17);
    int i2 = a.o;
    if ((this.c != null) && (this.c.get() != null)) {
      this.b.setOnClickListener((View.OnClickListener)this.c.get());
    }
    paramString2 = new LinearLayout.LayoutParams(i1, i2);
    paramString2.leftMargin = 5;
    paramString2.bottomMargin = 5;
    paramString1.addView(this.b, paramString2);
    paramString2 = new LinearLayout(this.a);
    paramString2.setOrientation(1);
    paramString2.setBackgroundColor(-7829368);
    paramString1.addView(paramString2, new LinearLayout.LayoutParams(n, -1));
    this.d = new TextView(this.a);
    if (paramBoolean) {
      this.d.getPaint().setFakeBoldText(true);
    }
    this.d.setText(paramString4);
    this.d.setTextSize(m);
    this.d.setTextColor(g.a(-15364869, -5846275));
    this.d.setGravity(17);
    if ((this.e != null) && (this.e.get() != null)) {
      this.d.setOnClickListener((View.OnClickListener)this.e.get());
    }
    paramString2 = new LinearLayout.LayoutParams(i1, i2);
    paramString2.leftMargin = 5;
    paramString2.bottomMargin = 5;
    paramString1.addView(this.d, paramString2);
    if ((this.h != null) && (!this.h.isShowing()) && (!d()))
    {
      paramString1 = this.h;
      if (!(paramString1 instanceof Dialog)) {
        paramString1.show();
      }
    }
    else
    {
      return;
    }
    VdsAgent.showDialog((Dialog)paramString1);
  }
  
  public final boolean a()
  {
    return (this.h != null) && (this.h.isShowing());
  }
  
  public final void b()
  {
    Dialog localDialog;
    if (this.h != null)
    {
      this.h.hide();
      localDialog = this.h;
      if (!(localDialog instanceof Dialog)) {
        localDialog.show();
      }
    }
    else
    {
      return;
    }
    VdsAgent.showDialog((Dialog)localDialog);
  }
  
  public final void c()
  {
    if ((this.h != null) && (this.h.isShowing()))
    {
      this.h.dismiss();
      this.h = null;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/widgets/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */