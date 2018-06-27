package com.unionpay.mobile.android.views.order;

import android.content.Context;
import android.text.Html;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.unionpay.mobile.android.global.b;
import com.unionpay.mobile.android.languages.c;
import com.unionpay.mobile.android.upviews.a.a;
import com.unionpay.mobile.android.utils.PreferenceUtils;
import com.unionpay.mobile.android.utils.f;
import org.json.JSONArray;
import org.json.JSONObject;

public final class i
  extends AbstractMethod
{
  private JSONObject g;
  private JSONObject h;
  private com.unionpay.mobile.android.upviews.a i;
  private TextView j;
  private TextView k;
  private RelativeLayout l;
  
  public i(Context paramContext)
  {
    super(paramContext);
  }
  
  private static JSONArray e(String paramString)
  {
    JSONArray localJSONArray = new JSONArray();
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("label", "");
      localJSONObject.put("name", "user_name");
      if (!a(paramString)) {
        localJSONObject.put("value", paramString);
      }
      localJSONObject.put("regexp", "[.@_A-Za-z0-9]{1,64}");
      localJSONObject.put("type", "user_name");
      localJSONObject.put("tip", "");
      localJSONObject.put("placeholder", c.bD.bw);
      localJSONArray.put(localJSONObject);
      paramString = new JSONObject();
      paramString.put("label", "");
      paramString.put("name", "password");
      paramString.put("type", "password");
      paramString.put("placeholder", c.bD.bx);
      localJSONArray.put(paramString);
      return localJSONArray;
    }
    catch (Exception paramString) {}
    return localJSONArray;
  }
  
  public final i a(JSONObject paramJSONObject)
  {
    this.g = paramJSONObject;
    if (this.j != null)
    {
      paramJSONObject = a(this.g, "label");
      if (!TextUtils.isEmpty(paramJSONObject))
      {
        this.j.setText(Html.fromHtml(paramJSONObject));
        if (this.l != null) {
          this.l.setVisibility(0);
        }
      }
    }
    return this;
  }
  
  public final void a(RelativeLayout paramRelativeLayout)
  {
    TextView localTextView = new TextView(this.b);
    localTextView.setText(this.c);
    localTextView.setTextColor(-13421773);
    localTextView.setTextSize(b.k);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(9, -1);
    localLayoutParams.addRule(15, -1);
    localLayoutParams.leftMargin = f.a(this.b, 10.0F);
    paramRelativeLayout.addView(localTextView, localLayoutParams);
  }
  
  public final int b()
  {
    return l.c.intValue();
  }
  
  public final i b(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public final i b(JSONObject paramJSONObject)
  {
    this.h = paramJSONObject;
    if (this.k != null)
    {
      paramJSONObject = a(this.h, "label");
      if (!TextUtils.isEmpty(paramJSONObject))
      {
        this.k.setText(Html.fromHtml(paramJSONObject));
        if (this.l != null) {
          this.l.setVisibility(0);
        }
      }
    }
    return this;
  }
  
  public final void b(RelativeLayout paramRelativeLayout)
  {
    this.i = new com.unionpay.mobile.android.upviews.a(this.b, e(PreferenceUtils.c(this.b)), this, "");
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams.topMargin = com.unionpay.mobile.android.global.a.f;
    paramRelativeLayout.addView(this.i, localLayoutParams);
  }
  
  public final a.a c()
  {
    if (this.i != null) {
      return this.i.b();
    }
    return null;
  }
  
  public final void c(RelativeLayout paramRelativeLayout)
  {
    String str = a(this.g, "label");
    this.j = new TextView(this.b);
    a(this.j);
    if (!TextUtils.isEmpty(str)) {
      this.j.setText(Html.fromHtml(str));
    }
    this.j.setOnClickListener(new j(this));
    Object localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(9, -1);
    ((RelativeLayout.LayoutParams)localObject).addRule(15, -1);
    ((RelativeLayout.LayoutParams)localObject).leftMargin = f.a(this.b, 10.0F);
    paramRelativeLayout.addView(this.j, (ViewGroup.LayoutParams)localObject);
    localObject = a(this.h, "label");
    this.k = new TextView(this.b);
    a(this.k);
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.k.setText(Html.fromHtml((String)localObject));
    }
    this.k.setOnClickListener(new k(this));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(11, -1);
    localLayoutParams.addRule(15, -1);
    localLayoutParams.rightMargin = f.a(this.b, 10.0F);
    paramRelativeLayout.addView(this.k, localLayoutParams);
    if ((TextUtils.isEmpty((CharSequence)localObject)) && (TextUtils.isEmpty(str))) {
      paramRelativeLayout.setVisibility(8);
    }
    this.l = paramRelativeLayout;
  }
  
  public final i d(String paramString)
  {
    this.d = paramString;
    return this;
  }
  
  public final String e()
  {
    return this.d;
  }
  
  public final boolean f()
  {
    return (this.i == null) || (this.i.e());
  }
  
  public final String h()
  {
    if (this.i != null) {
      return this.i.b("user_name");
    }
    return "";
  }
  
  protected final void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    TextUtils.isEmpty(h());
  }
  
  protected final void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.i != null) {
      this.i.f();
    }
  }
  
  public final void t() {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/views/order/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */