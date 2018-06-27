package com.unionpay.mobile.android.views.order;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.text.Html;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.unionpay.mobile.android.global.b;
import com.unionpay.mobile.android.utils.f;
import java.util.HashMap;

public class CViewMethods
  extends LinearLayout
{
  private static final Integer a = Integer.valueOf(-1);
  private static final Integer b = Integer.valueOf(-2);
  private static final int c = b.a;
  private Context d;
  private int e;
  private TextView f;
  private HashMap<Integer, String> g;
  private HashMap<Integer, Drawable> h;
  private String i;
  private a j;
  private Drawable k;
  
  public CViewMethods(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CViewMethods(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CViewMethods(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext);
    this.d = paramContext;
    this.e = l.a.intValue();
    setOrientation(1);
  }
  
  private void a(LinearLayout paramLinearLayout, int paramInt)
  {
    float f1 = b.k;
    RelativeLayout localRelativeLayout = new RelativeLayout(this.d);
    localRelativeLayout.setClickable(true);
    if (this.k != null) {
      localRelativeLayout.setBackgroundDrawable(this.k.getConstantState().newDrawable());
    }
    localRelativeLayout.setOnClickListener(new h(this, paramInt));
    paramLinearLayout.addView(localRelativeLayout, new LinearLayout.LayoutParams(a.intValue(), b.n));
    paramLinearLayout = new ImageView(this.d);
    paramLinearLayout.setId(paramLinearLayout.hashCode());
    if (this.h != null)
    {
      localObject1 = (Drawable)this.h.get(Integer.valueOf(paramInt));
      if (localObject1 != null) {
        paramLinearLayout.setBackgroundDrawable((Drawable)localObject1);
      }
    }
    int m = f.a(this.d, 15.0F);
    Object localObject1 = new RelativeLayout.LayoutParams(m, m);
    ((RelativeLayout.LayoutParams)localObject1).addRule(15, -1);
    ((RelativeLayout.LayoutParams)localObject1).addRule(11, -1);
    ((RelativeLayout.LayoutParams)localObject1).rightMargin = c;
    localRelativeLayout.addView(paramLinearLayout, (ViewGroup.LayoutParams)localObject1);
    localObject1 = new TextView(this.d);
    ((TextView)localObject1).setClickable(false);
    ((TextView)localObject1).setTextSize(f1);
    ((TextView)localObject1).setTextColor(-13421773);
    if (this.g != null)
    {
      localObject2 = (String)this.g.get(Integer.valueOf(paramInt));
      if (localObject2 != null) {
        ((TextView)localObject1).setText(Html.fromHtml((String)localObject2));
      }
    }
    Object localObject2 = new RelativeLayout.LayoutParams(a.intValue(), b.intValue());
    ((RelativeLayout.LayoutParams)localObject2).addRule(15, -1);
    ((RelativeLayout.LayoutParams)localObject2).addRule(9, -1);
    ((RelativeLayout.LayoutParams)localObject2).addRule(0, paramLinearLayout.getId());
    ((RelativeLayout.LayoutParams)localObject2).leftMargin = c;
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
  }
  
  public final CViewMethods a(int paramInt)
  {
    if (paramInt > 0) {
      this.e = paramInt;
    }
    return this;
  }
  
  public final CViewMethods a(Drawable paramDrawable)
  {
    this.k = paramDrawable;
    return this;
  }
  
  public final CViewMethods a(a parama)
  {
    this.j = parama;
    return this;
  }
  
  public final CViewMethods a(String paramString)
  {
    this.i = paramString;
    return this;
  }
  
  public final CViewMethods a(HashMap<Integer, String> paramHashMap)
  {
    this.g = paramHashMap;
    return this;
  }
  
  public final void a()
  {
    removeAllViews();
    if (this.e == l.a.intValue())
    {
      setVisibility(8);
      return;
    }
    this.f = new TextView(this.d);
    this.f.setTextColor(-13421773);
    this.f.setTextSize(b.k);
    if (this.i != null)
    {
      localObject1 = this.i;
      if (this.f != null) {
        this.f.setText((CharSequence)localObject1);
      }
      localObject1 = this.f;
    }
    this.f.setGravity(19);
    Object localObject1 = new LinearLayout.LayoutParams(a.intValue(), b.intValue());
    ((LinearLayout.LayoutParams)localObject1).gravity = 19;
    ((LinearLayout.LayoutParams)localObject1).topMargin = c;
    ((LinearLayout.LayoutParams)localObject1).leftMargin = f.a(this.d, 10.0F);
    addView(this.f, (ViewGroup.LayoutParams)localObject1);
    localObject1 = new LinearLayout(this.d);
    ((LinearLayout)localObject1).setBackgroundColor(-3419943);
    Object localObject2 = new LinearLayout.LayoutParams(-1, 1);
    ((LinearLayout.LayoutParams)localObject2).topMargin = c;
    addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new LinearLayout.LayoutParams(-1, -2);
    localObject1 = new LinearLayout(this.d);
    ((LinearLayout)localObject1).setOrientation(1);
    ((LinearLayout)localObject1).setBackgroundColor(-1);
    addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    if (l.b.intValue() == (l.b.intValue() & this.e)) {
      a((LinearLayout)localObject1, l.b.intValue());
    }
    if (l.c.intValue() == (l.c.intValue() & this.e)) {
      a((LinearLayout)localObject1, l.c.intValue());
    }
    LinearLayout.LayoutParams localLayoutParams;
    if (l.e.intValue() == (l.e.intValue() & this.e))
    {
      localObject2 = new LinearLayout(this.d);
      ((LinearLayout)localObject2).setBackgroundColor(-3419943);
      localLayoutParams = new LinearLayout.LayoutParams(-1, 1);
      localLayoutParams.leftMargin = f.a(this.d, 10.0F);
      ((LinearLayout)localObject1).addView((View)localObject2, localLayoutParams);
      a((LinearLayout)localObject1, l.e.intValue());
    }
    if (l.d.intValue() == (l.d.intValue() & this.e))
    {
      localObject2 = new LinearLayout(this.d);
      ((LinearLayout)localObject2).setBackgroundColor(-3419943);
      localLayoutParams = new LinearLayout.LayoutParams(-1, 1);
      localLayoutParams.leftMargin = f.a(this.d, 10.0F);
      ((LinearLayout)localObject1).addView((View)localObject2, localLayoutParams);
      a((LinearLayout)localObject1, l.d.intValue());
    }
    if (l.f.intValue() == (l.f.intValue() & this.e))
    {
      localObject2 = new LinearLayout(this.d);
      ((LinearLayout)localObject2).setBackgroundColor(-3419943);
      localLayoutParams = new LinearLayout.LayoutParams(-1, 1);
      localLayoutParams.leftMargin = f.a(this.d, 10.0F);
      ((LinearLayout)localObject1).addView((View)localObject2, localLayoutParams);
      a((LinearLayout)localObject1, l.f.intValue());
    }
    localObject1 = new LinearLayout(this.d);
    ((LinearLayout)localObject1).setBackgroundColor(-3419943);
    addView((View)localObject1, new LinearLayout.LayoutParams(-1, 1));
  }
  
  public final CViewMethods b(HashMap<Integer, Drawable> paramHashMap)
  {
    this.h = paramHashMap;
    return this;
  }
  
  public static abstract interface a
  {
    public abstract void c(int paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/views/order/CViewMethods.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */