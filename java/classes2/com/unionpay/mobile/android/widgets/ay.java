package com.unionpay.mobile.android.widgets;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.unionpay.mobile.android.global.a;
import com.unionpay.mobile.android.resource.c;
import com.unionpay.mobile.android.utils.f;

public final class ay
  extends RelativeLayout
{
  private Context a = null;
  private TextView b = null;
  private ImageView c = null;
  private TextView d = null;
  private Drawable e = null;
  private ImageView f;
  private LinearLayout g;
  private int h = 0;
  private int i = 0;
  private int j = 0;
  private a k;
  
  public ay(Context paramContext, String paramString, Drawable paramDrawable, int paramInt, a parama)
  {
    super(paramContext);
    this.a = paramContext;
    this.k = parama;
    this.j = f.a(this.a, 10.0F);
    this.e = paramDrawable;
    this.h = paramInt;
    b(paramString);
  }
  
  public ay(Context paramContext, String paramString, a parama)
  {
    this(paramContext, paramString, parama, (byte)0);
  }
  
  private ay(Context paramContext, String paramString, a parama, byte paramByte)
  {
    super(paramContext);
    this.a = paramContext;
    this.k = parama;
    this.j = f.a(this.a, 10.0F);
    b(paramString);
  }
  
  private void b(String paramString)
  {
    this.i = a.k;
    setLayoutParams(new RelativeLayout.LayoutParams(-1, this.i));
    setBackgroundColor(a.M);
    Object localObject1 = c.a(this.a);
    this.g = new LinearLayout(this.a);
    this.g.setOnClickListener(new az(this));
    this.g.setPadding(this.j, this.j, this.j, this.j);
    this.g.setGravity(16);
    Object localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(9, -1);
    ((RelativeLayout.LayoutParams)localObject2).addRule(15, -1);
    addView(this.g, (ViewGroup.LayoutParams)localObject2);
    int n = f.a(this.a, 20.0F);
    int m = f.a(this.a, 11.0F);
    if (this.h != 0) {
      m = this.h;
    }
    localObject2 = new ImageView(this.a);
    if (this.e != null) {
      ((ImageView)localObject2).setBackgroundDrawable(this.e);
    }
    for (;;)
    {
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(m, n);
      localLayoutParams.addRule(15, -1);
      this.g.addView((View)localObject2, localLayoutParams);
      localObject2 = new RelativeLayout.LayoutParams(a.l, this.i);
      ((RelativeLayout.LayoutParams)localObject2).addRule(13, -1);
      this.d = new TextView(this.a);
      this.d.setTextSize(20.0F);
      this.d.setTextColor(-1);
      this.d.setText(paramString);
      this.d.setGravity(17);
      this.d.setSingleLine(true);
      this.d.setEllipsize(TextUtils.TruncateAt.END);
      addView(this.d, (ViewGroup.LayoutParams)localObject2);
      if (!TextUtils.isEmpty(null))
      {
        m = a.e;
        paramString = new RelativeLayout.LayoutParams(-2, this.i);
        paramString.addRule(11, -1);
        paramString.addRule(15, -1);
        paramString.rightMargin = m;
        this.b = new TextView(this.a);
        this.b.setTextSize(16.0F);
        this.b.setTextColor(-1);
        this.b.setText(null);
        this.b.setGravity(16);
        this.b.setId(this.b.hashCode());
        addView(this.b, paramString);
        n = a.m;
        paramString = new RelativeLayout.LayoutParams(a.H, n);
        paramString.addRule(0, this.b.getId());
        paramString.addRule(15, -1);
        paramString.rightMargin = m;
        addView(new o(this.a, a.N, 1), paramString);
      }
      paramString = new RelativeLayout.LayoutParams(a.E, a.D);
      paramString.addRule(11, -1);
      paramString.addRule(15, -1);
      paramString.rightMargin = this.j;
      localObject1 = ((c)localObject1).a(1031);
      this.f = new ImageView(this.a);
      this.f.setBackgroundDrawable((Drawable)localObject1);
      addView(this.f, paramString);
      paramString = new RelativeLayout.LayoutParams(a.D, a.D);
      paramString.addRule(11, -1);
      paramString.addRule(15, -1);
      paramString.rightMargin = this.j;
      this.c = new ImageView(this.a);
      addView(this.c, paramString);
      return;
      ((ImageView)localObject2).setBackgroundDrawable(((c)localObject1).a(1029));
    }
  }
  
  public final void a()
  {
    if (this.g != null) {
      this.g.setVisibility(8);
    }
  }
  
  public final void a(int paramInt)
  {
    if (this.c != null)
    {
      if (paramInt != 0) {
        break label38;
      }
      this.f.setVisibility(8);
      this.c.setVisibility(8);
    }
    for (;;)
    {
      this.c.setVisibility(paramInt);
      return;
      label38:
      this.c.setVisibility(8);
      this.f.setVisibility(0);
    }
  }
  
  public final void a(String paramString)
  {
    if (this.d != null) {
      this.d.setText(paramString);
    }
  }
  
  public static abstract interface a
  {
    public abstract void m();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/widgets/ay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */