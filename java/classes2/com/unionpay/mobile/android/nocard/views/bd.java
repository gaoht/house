package com.unionpay.mobile.android.nocard.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.unionpay.mobile.android.global.a;
import com.unionpay.mobile.android.nocard.utils.UPPayEngine;
import com.unionpay.mobile.android.upwidget.UPScrollView;
import com.unionpay.mobile.android.utils.PreferenceUtils;
import com.unionpay.mobile.android.utils.f;
import com.unionpay.mobile.android.utils.h;
import com.unionpay.mobile.android.utils.i;
import com.unionpay.mobile.android.utils.j;
import com.unionpay.mobile.android.views.order.l;
import com.unionpay.mobile.android.widgets.as;
import com.unionpay.mobile.android.widgets.ay;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class bd
  extends b
{
  private TextView r = null;
  private View.OnClickListener s = new be(this);
  private a t;
  
  public bd(Context paramContext)
  {
    super(paramContext);
    e();
    this.q = "result";
    this.a.aq = null;
    if (this.a.aV) {
      this.e.c("bingopromotion", "");
    }
  }
  
  private void t()
  {
    String str = this.a.aQ;
    j.c("functionEx", str);
    if ((this.a.aQ == l.b.intValue()) || (this.a.aQ == l.c.intValue())) {
      PreferenceUtils.c(this.d, str);
    }
    this.a.I.f = "success";
    k();
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    paramJSONObject = i.c(paramJSONObject, "luck_draw");
    if (paramJSONObject != null)
    {
      this.t.setVisibility(0);
      this.t.a(paramJSONObject);
    }
  }
  
  protected final void b()
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    ay localay = new ay(getContext(), this.a.A, this);
    localay.a();
    localLayoutParams.addRule(13, -1);
    this.k.addView(localay, localLayoutParams);
  }
  
  public final void b(int paramInt) {}
  
  protected final void c()
  {
    g();
    this.m.invalidate();
    this.o.setBackgroundColor(-1052684);
    RelativeLayout localRelativeLayout = new RelativeLayout(this.d);
    localRelativeLayout.setBackgroundColor(-1052684);
    localRelativeLayout.setId(localRelativeLayout.hashCode());
    Object localObject1 = new RelativeLayout.LayoutParams(-1, -1);
    ((RelativeLayout.LayoutParams)localObject1).addRule(10, -1);
    ((RelativeLayout.LayoutParams)localObject1).topMargin = a.d;
    this.m.addView(localRelativeLayout, (ViewGroup.LayoutParams)localObject1);
    localObject1 = new RelativeLayout(this.d);
    ((RelativeLayout)localObject1).setId(localObject1.hashCode());
    Object localObject2 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject2).topMargin = a.d;
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    int i = a.n;
    localObject2 = this.c.a(2008);
    this.r = new TextView(this.d);
    this.r.setId(this.r.hashCode());
    this.r.setText(com.unionpay.mobile.android.languages.c.bD.E);
    this.r.setTextSize(com.unionpay.mobile.android.global.b.i);
    this.r.setTextColor(p());
    this.r.setGravity(17);
    this.r.setOnClickListener(this.s);
    this.r.setBackgroundDrawable((Drawable)localObject2);
    localObject2 = new RelativeLayout.LayoutParams(-1, i);
    i = f.a(this.d, 12.0F);
    ((RelativeLayout.LayoutParams)localObject2).rightMargin = i;
    ((RelativeLayout.LayoutParams)localObject2).leftMargin = i;
    ((RelativeLayout.LayoutParams)localObject2).addRule(9, -1);
    ((RelativeLayout.LayoutParams)localObject2).addRule(15, -1);
    ((RelativeLayout)localObject1).addView(this.r, (ViewGroup.LayoutParams)localObject2);
    this.t = new a(this.d);
    this.t.setVisibility(8);
    localObject2 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(3, ((RelativeLayout)localObject1).getId());
    ((RelativeLayout.LayoutParams)localObject2).topMargin = f.a(this.d, 20.0F);
    localRelativeLayout.addView(this.t, (ViewGroup.LayoutParams)localObject2);
  }
  
  protected final void f()
  {
    Object localObject1 = null;
    Object localObject3 = null;
    int k;
    if (this.a.H != null)
    {
      localObject1 = new LinearLayout(this.d);
      ((LinearLayout)localObject1).setOrientation(1);
      j = f.a(this.d, 10.0F);
      if (!TextUtils.isEmpty(this.a.B))
      {
        localObject2 = new TextView(this.d);
        ((TextView)localObject2).setText(this.a.B);
        ((TextView)localObject2).setTextSize(24.0F);
        ((TextView)localObject2).setTextColor(-15365480);
        ((TextView)localObject2).setGravity(1);
        ((TextView)localObject2).setPadding(0, a.d, 0, 0);
        ((TextView)localObject2).getPaint().setFakeBoldText(true);
        ((LinearLayout)localObject1).addView((View)localObject2, new LinearLayout.LayoutParams(-1, -2));
        localObject2 = new LinearLayout(this.d);
        ((LinearLayout)localObject2).setOrientation(0);
        ((LinearLayout)localObject2).setBackgroundColor(-6958338);
        localObject3 = new LinearLayout.LayoutParams(-1, 1);
        i = a.d;
        ((LinearLayout.LayoutParams)localObject3).bottomMargin = i;
        ((LinearLayout.LayoutParams)localObject3).topMargin = i;
        ((LinearLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
        this.l.addView((View)localObject1);
      }
      localObject2 = this.a.H;
      if (localObject2 != null) {
        if (((JSONArray)localObject2).length() < 2) {
          break label420;
        }
      }
      label420:
      for (i = 2;; i = ((JSONArray)localObject2).length())
      {
        localObject3 = bh.a(this.d, (JSONArray)localObject2, 0, i);
        ((LinearLayout)localObject3).setBackgroundColor(0);
        localObject4 = new LinearLayout.LayoutParams(-1, -2);
        ((LinearLayout.LayoutParams)localObject4).rightMargin = j;
        ((LinearLayout.LayoutParams)localObject4).leftMargin = j;
        ((LinearLayout)localObject1).addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
        k = ((JSONArray)localObject2).length();
        localObject1 = bh.a(this.d, (JSONArray)localObject2, i, k);
        ((LinearLayout)localObject1).setBackgroundColor(0);
        localObject2 = new LinearLayout.LayoutParams(-1, -2);
        ((LinearLayout.LayoutParams)localObject2).rightMargin = j;
        ((LinearLayout.LayoutParams)localObject2).leftMargin = j;
        this.l.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
        localObject1 = new as(this.d);
        ((LinearLayout)localObject1).setId(localObject1.hashCode());
        this.l.setOnClickListener(new bf(this));
        localObject2 = new LinearLayout.LayoutParams(-1, -2);
        ((LinearLayout.LayoutParams)localObject2).bottomMargin = 0;
        this.l.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
        return;
      }
    }
    int i = f.a(this.d, 10.0F);
    LinearLayout localLinearLayout1 = new LinearLayout(this.d);
    localLinearLayout1.setPadding(i, i, i, i);
    localLinearLayout1.setOrientation(1);
    localLinearLayout1.setBackgroundColor(-1);
    this.l.addView(localLinearLayout1);
    Object localObject2 = new LinearLayout(this.d);
    ((LinearLayout)localObject2).setOrientation(0);
    localLinearLayout1.addView((View)localObject2);
    int j = f.a(this.d, 25.0F);
    Object localObject4 = new ImageView(this.d);
    ((ImageView)localObject4).setBackgroundDrawable(this.c.a(1035));
    ((LinearLayout)localObject2).addView((View)localObject4, new LinearLayout.LayoutParams(j, j));
    LinearLayout localLinearLayout2 = new LinearLayout(this.d);
    localLinearLayout2.setOrientation(1);
    localObject4 = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject4).leftMargin = i;
    ((LinearLayout)localObject2).addView(localLinearLayout2, (ViewGroup.LayoutParams)localObject4);
    localObject4 = this.a.aR;
    if (!h.b((String)localObject4))
    {
      i = ((String)localObject4).indexOf('<');
      if (-1 == i) {
        break label1168;
      }
    }
    label1168:
    for (localObject1 = ((String)localObject4).substring(0, i);; localObject1 = null)
    {
      j = ((String)localObject4).indexOf('>') + 1;
      if (-1 != j) {}
      for (localObject2 = ((String)localObject4).substring(j);; localObject2 = null)
      {
        k = i + 1;
        int m = j - 1;
        if ((-1 != i) && (k < m) && (j != -1))
        {
          localObject4 = ((String)localObject4).substring(k, m);
          if (!h.b((String)localObject4))
          {
            String[] arrayOfString = ((String)localObject4).split("#");
            if ((arrayOfString != null) && (arrayOfString.length == 2))
            {
              localObject4 = arrayOfString[0];
              localObject3 = arrayOfString[1];
            }
          }
        }
        for (;;)
        {
          localObject1 = h.a((String)localObject1, (String)localObject4, (String)localObject3, (String)localObject2);
          if (localObject1 != null)
          {
            localObject2 = new TextView(this.d);
            ((TextView)localObject2).setTextSize(20.0F);
            ((TextView)localObject2).setText((CharSequence)localObject1);
            localLinearLayout2.addView((View)localObject2);
          }
          if (b(this.a.aS))
          {
            localObject1 = new TextView(this.d);
            ((TextView)localObject1).setTextSize(com.unionpay.mobile.android.global.b.l);
            ((TextView)localObject1).setText(this.a.aS);
            ((TextView)localObject1).setTextColor(-10066330);
            localLinearLayout2.addView((View)localObject1);
          }
          if (b(this.a.aT))
          {
            localObject1 = new TextView(this.d);
            ((TextView)localObject1).setTextSize(com.unionpay.mobile.android.global.b.l);
            ((TextView)localObject1).setTextColor(-10066330);
            ((TextView)localObject1).setText(this.a.aT);
            localLinearLayout2.addView((View)localObject1);
          }
          i = f.a(this.d, 5.0F);
          localObject1 = new LinearLayout(this.d);
          ((LinearLayout)localObject1).setOrientation(1);
          ((LinearLayout)localObject1).setBackgroundColor(-1052684);
          ((LinearLayout)localObject1).setPadding(i, i, i, i);
          localObject2 = new LinearLayout.LayoutParams(-1, -2);
          ((LinearLayout.LayoutParams)localObject2).topMargin = f.a(this.d, 10.0F);
          localLinearLayout1.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
          ((LinearLayout)localObject1).setVisibility(8);
          if (("0".equals(this.a.aW)) && (b(this.a.aX)))
          {
            localObject2 = new TextView(this.d);
            ((TextView)localObject2).setTextSize(com.unionpay.mobile.android.global.b.l);
            ((TextView)localObject2).setText(this.a.aX);
            ((LinearLayout)localObject1).addView((View)localObject2);
            ((LinearLayout)localObject1).setVisibility(0);
          }
          localObject2 = this.c.a(1026);
          localObject1 = new LinearLayout(this.d);
          if (localObject2 != null) {
            ((LinearLayout)localObject1).setBackgroundDrawable((Drawable)localObject2);
          }
          localObject2 = new LinearLayout.LayoutParams(-1, f.a(this.d, 2.0F));
          this.l.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
          return;
          localObject4 = null;
        }
      }
    }
  }
  
  public final void l()
  {
    t();
  }
  
  public final class a
    extends LinearLayout
  {
    private Context b;
    
    public a(Context paramContext)
    {
      super();
      this.b = paramContext;
      setOrientation(1);
    }
    
    private void a(JSONArray paramJSONArray)
    {
      if ((paramJSONArray == null) || (paramJSONArray.length() <= 0)) {}
      for (;;)
      {
        return;
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
        LinearLayout localLinearLayout = new LinearLayout(bd.this.d);
        localLinearLayout.setOrientation(1);
        localLinearLayout.setBackgroundColor(-1);
        addView(localLinearLayout, localLayoutParams);
        localLayoutParams = new LinearLayout.LayoutParams(-1, com.unionpay.mobile.android.global.b.n);
        int i = 0;
        while (i < paramJSONArray.length())
        {
          try
          {
            Object localObject1 = paramJSONArray.getJSONObject(i);
            Object localObject3 = i.a((JSONObject)localObject1, "label");
            Object localObject4 = i.a((JSONObject)localObject1, "url");
            localObject1 = new LinearLayout(bd.this.d);
            ((LinearLayout)localObject1).setBackgroundColor(-3419943);
            Object localObject2 = new LinearLayout.LayoutParams(-1, 1);
            if (i != 0) {
              ((LinearLayout.LayoutParams)localObject2).leftMargin = f.a(bd.this.d, 12.0F);
            }
            localLinearLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
            localObject1 = this.b;
            localObject2 = new RelativeLayout(this.b);
            ((RelativeLayout)localObject2).setBackgroundDrawable(bd.this.c.a(2014));
            ((RelativeLayout)localObject2).setOnClickListener(new bg(this, i, (String)localObject3, (String)localObject4));
            localObject4 = new TextView((Context)localObject1);
            ((TextView)localObject4).setText((CharSequence)localObject3);
            ((TextView)localObject4).setTextSize(com.unionpay.mobile.android.global.b.k);
            ((TextView)localObject4).setTextColor(-13421773);
            localObject3 = new RelativeLayout.LayoutParams(-2, -2);
            ((RelativeLayout.LayoutParams)localObject3).addRule(15, -1);
            ((RelativeLayout.LayoutParams)localObject3).addRule(9, -1);
            ((RelativeLayout.LayoutParams)localObject3).leftMargin = f.a((Context)localObject1, 12.0F);
            ((RelativeLayout)localObject2).addView((View)localObject4, (ViewGroup.LayoutParams)localObject3);
            int j = f.a((Context)localObject1, 20.0F);
            localObject4 = bd.this.c.a(1002);
            localObject3 = new ImageView((Context)localObject1);
            ((ImageView)localObject3).setBackgroundDrawable((Drawable)localObject4);
            localObject4 = new RelativeLayout.LayoutParams(j, j);
            ((RelativeLayout.LayoutParams)localObject4).addRule(15, -1);
            ((RelativeLayout.LayoutParams)localObject4).addRule(11, -1);
            ((RelativeLayout.LayoutParams)localObject4).rightMargin = f.a((Context)localObject1, 12.0F);
            ((RelativeLayout)localObject2).addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
            localLinearLayout.addView((View)localObject2, localLayoutParams);
            if (i == paramJSONArray.length() - 1)
            {
              localObject1 = new LinearLayout(bd.this.d);
              ((LinearLayout)localObject1).setBackgroundColor(-3419943);
              localLinearLayout.addView((View)localObject1, new LinearLayout.LayoutParams(-1, 1));
            }
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              localJSONException.printStackTrace();
            }
          }
          i += 1;
        }
      }
    }
    
    public final void a(JSONObject paramJSONObject)
    {
      removeAllViews();
      String str = i.a(paramJSONObject, "label");
      Object localObject = bd.this;
      if (bd.b(str))
      {
        localObject = new LinearLayout.LayoutParams(-1, -2);
        ((LinearLayout.LayoutParams)localObject).leftMargin = f.a(bd.this.d, 12.0F);
        ((LinearLayout.LayoutParams)localObject).bottomMargin = a.f;
        TextView localTextView = new TextView(this.b);
        localTextView.setText(str);
        localTextView.setTextSize(com.unionpay.mobile.android.global.b.k);
        localTextView.setTextColor(40527);
        addView(localTextView, (ViewGroup.LayoutParams)localObject);
      }
      a(i.d(paramJSONObject, "options"));
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/nocard/views/bd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */