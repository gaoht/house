package com.unionpay.mobile.android.upwidget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.unionpay.mobile.android.global.b;
import com.unionpay.mobile.android.utils.f;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class c
  extends BaseAdapter
{
  private Drawable a;
  private Drawable b;
  private Drawable c;
  private Context d;
  private String e = null;
  private String f = null;
  private String g = null;
  private boolean h = false;
  private int i = 1;
  private int j = 0;
  private List<Map<String, Object>> k;
  private ArrayList<View.OnClickListener> l = new ArrayList();
  private View.OnClickListener m = new d(this);
  
  public c(Context paramContext, List<Map<String, Object>> paramList, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    this.d = paramContext;
    this.k = paramList;
    this.e = paramString1;
    this.f = paramString2;
    this.g = paramString3;
    this.i = paramInt1;
    this.j = paramInt2;
    this.a = com.unionpay.mobile.android.resource.c.a(this.d).a(1015);
    this.b = com.unionpay.mobile.android.resource.c.a(this.d).a(1016);
    this.c = com.unionpay.mobile.android.resource.c.a(this.d).a(1002);
  }
  
  private boolean d()
  {
    return (this.e != null) && (!TextUtils.isEmpty(this.e));
  }
  
  private boolean d(int paramInt)
  {
    paramInt -= c();
    if (paramInt == this.k.size()) {
      return true;
    }
    Object localObject = ((Map)this.k.get(paramInt)).get("available");
    if ((localObject != null) && (Boolean.FALSE == (Boolean)localObject)) {}
    for (boolean bool = false;; bool = true) {
      return bool;
    }
  }
  
  private boolean e()
  {
    return (this.f != null) && (!TextUtils.isEmpty(this.f));
  }
  
  public final void a()
  {
    if (!this.h) {}
    for (boolean bool = true;; bool = false)
    {
      this.h = bool;
      return;
    }
  }
  
  public final void a(int paramInt)
  {
    this.i = paramInt;
  }
  
  public final void a(View.OnClickListener paramOnClickListener)
  {
    this.l.add(paramOnClickListener);
  }
  
  public final void a(String paramString)
  {
    this.e = paramString;
  }
  
  public final Spanned b(int paramInt)
  {
    paramInt -= c();
    if (paramInt == this.k.size()) {
      return null;
    }
    Object localObject = (Map)this.k.get(paramInt);
    String str = (String)((Map)localObject).get("text1");
    localObject = (String)((Map)localObject).get("text2");
    return Html.fromHtml(str + " " + (String)localObject);
  }
  
  public final void b(String paramString)
  {
    this.g = paramString;
  }
  
  public final boolean b()
  {
    return this.h;
  }
  
  public final int c()
  {
    if (d()) {
      return 1;
    }
    return 0;
  }
  
  public final boolean c(int paramInt)
  {
    paramInt -= c();
    if (paramInt == this.k.size()) {
      return true;
    }
    Object localObject = ((Map)this.k.get(paramInt)).get("editable");
    if ((localObject != null) && (Boolean.FALSE == (Boolean)localObject)) {}
    for (boolean bool = false;; bool = true) {
      return bool;
    }
  }
  
  public final int getCount()
  {
    int n = 0;
    if (this.k == null) {
      return 0;
    }
    int i1 = this.k.size();
    int i2 = c();
    if (e()) {
      n = 1;
    }
    return n + (i1 + i2);
  }
  
  public final Object getItem(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt != 0)
    {
      localObject1 = localObject2;
      if (this.k != null)
      {
        localObject1 = localObject2;
        if (paramInt < this.k.size()) {
          localObject1 = this.k.get(paramInt - c());
        }
      }
    }
    return localObject1;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = new LinearLayout(this.d);
    paramViewGroup.setOrientation(1);
    RelativeLayout localRelativeLayout = new RelativeLayout(this.d);
    int i2 = b.g;
    localRelativeLayout.setPadding(i2, i2, i2, i2);
    paramViewGroup.addView(localRelativeLayout);
    Object localObject1 = new LinearLayout(this.d);
    ((LinearLayout)localObject1).setBackgroundColor(-3419943);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, 1);
    int n;
    if (paramInt - c() == this.k.size())
    {
      n = 1;
      if ((!d()) || (paramInt != 0)) {
        break label325;
      }
      paramView = new TextView(this.d);
      paramView.setText(this.e);
      paramView.setTextSize(b.k);
      paramView.setTextColor(-13421773);
      localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(9, -1);
      ((RelativeLayout.LayoutParams)localObject2).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = b.f;
      localRelativeLayout.addView(paramView, (ViewGroup.LayoutParams)localObject2);
      if ((this.g == null) || (TextUtils.isEmpty(this.g))) {
        break label320;
      }
    }
    label320:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt != 0)
      {
        paramView = new TextView(this.d);
        paramView.setText(this.g);
        paramView.setTextSize(b.k);
        paramView.setTextColor(-13421773);
        paramView.setOnClickListener(this.m);
        localObject2 = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject2).addRule(11, -1);
        ((RelativeLayout.LayoutParams)localObject2).addRule(15, -1);
        ((RelativeLayout.LayoutParams)localObject2).rightMargin = b.f;
        localRelativeLayout.addView(paramView, (ViewGroup.LayoutParams)localObject2);
      }
      paramViewGroup.addView((View)localObject1, localLayoutParams);
      return paramViewGroup;
      n = 0;
      break;
    }
    label325:
    if ((e()) && (n != 0))
    {
      paramView = new TextView(this.d);
      paramView.setText(this.f);
      paramView.setTextSize(b.k);
      paramView.setTextColor(-10066330);
      localObject1 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject1).addRule(9, -1);
      localRelativeLayout.addView(paramView, (ViewGroup.LayoutParams)localObject1);
      paramView = new ImageView(this.d);
      paramView.setBackgroundDrawable(this.c);
      paramInt = f.a(this.d, 20.0F);
      localObject1 = new RelativeLayout.LayoutParams(paramInt, paramInt);
      ((RelativeLayout.LayoutParams)localObject1).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject1).addRule(11, -1);
      localRelativeLayout.addView(paramView, (ViewGroup.LayoutParams)localObject1);
      return paramViewGroup;
    }
    Object localObject2 = new ImageView(this.d);
    ((ImageView)localObject2).setVisibility(4);
    ((ImageView)localObject2).setId(localObject2.hashCode());
    TextView localTextView = new TextView(this.d);
    localTextView.setSingleLine(true);
    localTextView.setEllipsize(TextUtils.TruncateAt.END);
    localTextView.setText(b(paramInt));
    localTextView.setTextSize(b.k);
    localTextView.setTextColor(-10066330);
    int i3 = f.a(this.d, 20.0F);
    if (this.j == 0) {
      if (this.h)
      {
        paramView = this.b;
        if ((this.h) || (this.i != paramInt) || (paramView == null)) {
          break label724;
        }
        ((ImageView)localObject2).setVisibility(0);
        ((ImageView)localObject2).setBackgroundDrawable(paramView);
        label616:
        paramView = new RelativeLayout.LayoutParams(i3, i3);
        paramView.addRule(15, -1);
        paramView.addRule(9, -1);
        localRelativeLayout.addView((View)localObject2, paramView);
        paramView = new RelativeLayout.LayoutParams(-2, -2);
        paramView.addRule(15, -1);
        paramView.addRule(1, localObject2.hashCode());
        paramView.leftMargin = b.g;
        localRelativeLayout.addView(localTextView, paramView);
      }
    }
    label694:
    label724:
    int i1;
    label779:
    int i4;
    for (;;)
    {
      if ((!e()) || (n == 0))
      {
        paramViewGroup.addView((View)localObject1, localLayoutParams);
        return paramViewGroup;
        paramView = this.a;
        break;
        if ((!c(paramInt)) || (!this.h) || (paramView == null)) {
          break label616;
        }
        ((ImageView)localObject2).setVisibility(0);
        ((ImageView)localObject2).setBackgroundDrawable(paramView);
        break label616;
        if (this.j == 1)
        {
          if (this.i != paramInt) {
            break label934;
          }
          i1 = 1008;
          i4 = f.a(this.d, 20.0F);
          paramView = com.unionpay.mobile.android.resource.c.a(this.d).a(i1, i3, i3);
          if (d(paramInt)) {
            ((ImageView)localObject2).setVisibility(0);
          }
          ((ImageView)localObject2).setBackgroundDrawable(paramView);
          if (!this.h) {
            break label942;
          }
        }
      }
    }
    label934:
    label942:
    for (paramView = this.b;; paramView = this.a)
    {
      paramView = new RelativeLayout.LayoutParams(i4, i4);
      paramView.addRule(15, -1);
      paramView.addRule(11, -1);
      localRelativeLayout.addView((View)localObject2, paramView);
      paramView = new RelativeLayout.LayoutParams(-2, -2);
      paramView.addRule(15, -1);
      paramView.addRule(9, -1);
      paramView.addRule(0, localObject2.hashCode());
      paramView.rightMargin = b.g;
      localRelativeLayout.addView(localTextView, paramView);
      localLayoutParams.leftMargin = i2;
      break label694;
      break;
      i1 = 1007;
      break label779;
    }
  }
  
  public final boolean isEnabled(int paramInt)
  {
    if (((d()) && (paramInt == 0)) || (!d(paramInt))) {
      return false;
    }
    return super.isEnabled(paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/upwidget/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */