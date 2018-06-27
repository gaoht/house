package com.unionpay.mobile.android.upwidget;

import android.content.Context;
import android.graphics.drawable.Drawable;
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
import com.unionpay.mobile.android.resource.c;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class e
  extends BaseAdapter
{
  private Drawable a;
  private Context b;
  private String c = null;
  private String d = null;
  private int e = 1;
  private List<Map<String, Object>> f;
  private ArrayList<View.OnClickListener> g = new ArrayList();
  private View.OnClickListener h = new f(this);
  
  public e(Context paramContext, List<Map<String, Object>> paramList, String paramString)
  {
    this.b = paramContext;
    this.f = paramList;
    this.c = paramString;
    this.e = 0;
    this.a = c.a(this.b).a(1015);
  }
  
  private boolean b()
  {
    return (this.c != null) && (!TextUtils.isEmpty(this.c));
  }
  
  private boolean b(int paramInt)
  {
    paramInt -= a();
    if (this.f == null) {}
    while (paramInt == this.f.size()) {
      return true;
    }
    Object localObject = ((Map)this.f.get(paramInt)).get("available");
    if ((localObject != null) && (Boolean.FALSE == (Boolean)localObject)) {}
    for (boolean bool = false;; bool = true) {
      return bool;
    }
  }
  
  public final int a()
  {
    if (b()) {
      return 1;
    }
    return 0;
  }
  
  public final void a(int paramInt)
  {
    this.e = paramInt;
  }
  
  public final int getCount()
  {
    int j = 1;
    if (this.f == null) {
      return 0;
    }
    int k = this.f.size();
    int m = a();
    if ((this.d != null) && (!TextUtils.isEmpty(this.d)))
    {
      i = 1;
      if (i == 0) {
        break label64;
      }
    }
    label64:
    for (int i = j;; i = 0)
    {
      return m + k + i;
      i = 0;
      break;
    }
  }
  
  public final Object getItem(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt != 0)
    {
      localObject1 = localObject2;
      if (this.f != null)
      {
        localObject1 = localObject2;
        if (paramInt < this.f.size()) {
          localObject1 = this.f.get(paramInt - a());
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
    getItem(paramInt);
    paramView = (Map)this.f.get(paramInt - a());
    Object localObject4 = (String)paramView.get("style");
    Object localObject1 = (List)paramView.get("keys");
    List localList = (List)paramView.get("values");
    paramView = new LinearLayout(this.b);
    paramView.setOrientation(1);
    paramViewGroup = new RelativeLayout(this.b);
    int j = b.g;
    paramViewGroup.setPadding(j, j, j, j);
    paramView.addView(paramViewGroup);
    LinearLayout localLinearLayout = new LinearLayout(this.b);
    localLinearLayout.setBackgroundColor(-3419943);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, 1);
    Object localObject2 = new ImageView(this.b);
    ((ImageView)localObject2).setVisibility(4);
    ((ImageView)localObject2).setId(localObject2.hashCode());
    Object localObject3 = new TextView(this.b);
    ((TextView)localObject3).setSingleLine(true);
    ((TextView)localObject3).setEllipsize(TextUtils.TruncateAt.END);
    ((TextView)localObject3).setText((CharSequence)localObject4);
    ((TextView)localObject3).setTextSize(b.i);
    ((TextView)localObject3).setTextColor(-10066330);
    int k = com.unionpay.mobile.android.utils.f.a(this.b, 20.0F);
    if (this.e == paramInt) {}
    for (int i = 1008;; i = 1007)
    {
      int m = com.unionpay.mobile.android.utils.f.a(this.b, 20.0F);
      localObject4 = c.a(this.b).a(i, k, k);
      if (b(paramInt)) {
        ((ImageView)localObject2).setVisibility(0);
      }
      ((ImageView)localObject2).setBackgroundDrawable((Drawable)localObject4);
      localObject4 = this.a;
      localObject4 = new RelativeLayout.LayoutParams(m, m);
      ((RelativeLayout.LayoutParams)localObject4).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject4).addRule(9, -1);
      paramViewGroup.addView((View)localObject2, (ViewGroup.LayoutParams)localObject4);
      localObject4 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject4).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject4).addRule(1, localObject2.hashCode());
      ((RelativeLayout.LayoutParams)localObject4).leftMargin = b.g;
      paramViewGroup.addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
      localObject2 = new LinearLayout(this.b);
      ((LinearLayout)localObject2).setOrientation(1);
      ((LinearLayout)localObject2).setGravity(5);
      ((LinearLayout)localObject2).setId(localObject2.hashCode());
      localObject3 = new LinearLayout(this.b);
      ((LinearLayout)localObject3).setOrientation(1);
      ((LinearLayout)localObject3).setGravity(5);
      ((LinearLayout)localObject3).setId(localObject3.hashCode());
      paramInt = 0;
      while (paramInt < ((List)localObject1).size())
      {
        TextView localTextView = new TextView(this.b);
        localTextView.setSingleLine(true);
        localTextView.setEllipsize(TextUtils.TruncateAt.END);
        localTextView.setText((CharSequence)((List)localObject1).get(paramInt));
        localTextView.setTextSize(b.k);
        localTextView.setTextColor(-6710887);
        localObject4 = new LinearLayout.LayoutParams(-2, -2);
        ((LinearLayout.LayoutParams)localObject4).gravity = 5;
        ((LinearLayout)localObject2).addView(localTextView, (ViewGroup.LayoutParams)localObject4);
        localTextView = new TextView(this.b);
        localTextView.setSingleLine(true);
        localTextView.setEllipsize(TextUtils.TruncateAt.END);
        localTextView.setText((CharSequence)localList.get(paramInt));
        localTextView.setTextSize(b.k);
        localTextView.setTextColor(-6710887);
        ((LinearLayout)localObject3).addView(localTextView, (ViewGroup.LayoutParams)localObject4);
        paramInt += 1;
      }
    }
    localObject1 = new RelativeLayout.LayoutParams(com.unionpay.mobile.android.utils.f.a(this.b, 120.0F), -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(11, -1);
    paramViewGroup.addView((View)localObject3, (ViewGroup.LayoutParams)localObject1);
    localObject1 = new RelativeLayout.LayoutParams(com.unionpay.mobile.android.utils.f.a(this.b, 100.0F), -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(0, ((LinearLayout)localObject3).getId());
    paramViewGroup.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
    localLayoutParams.rightMargin = j;
    localLayoutParams.leftMargin = j;
    paramView.addView(localLinearLayout, localLayoutParams);
    return paramView;
  }
  
  public final boolean isEnabled(int paramInt)
  {
    if (((b()) && (paramInt == 0)) || (!b(paramInt))) {
      return false;
    }
    return super.isEnabled(paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/upwidget/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */