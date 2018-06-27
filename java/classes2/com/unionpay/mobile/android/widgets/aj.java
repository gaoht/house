package com.unionpay.mobile.android.widgets;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.style.ForegroundColorSpan;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.unionpay.mobile.android.global.b;
import com.unionpay.mobile.android.upwidget.q;
import com.unionpay.mobile.android.upwidget.q.a;
import com.unionpay.mobile.android.utils.f;
import com.unionpay.mobile.android.utils.i;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class aj
  extends z
{
  private String A = "";
  private boolean B = true;
  private String C = "";
  private a D = null;
  private final View.OnClickListener a = new ak(this);
  private final View.OnClickListener b = new al(this);
  private final AdapterView.OnItemClickListener n = new am(this);
  private JSONArray o;
  private PopupWindow p;
  private com.unionpay.mobile.android.upwidget.j q;
  private int r;
  private int s = 0;
  private JSONArray t = null;
  private JSONArray u = null;
  private TextView v;
  private q w;
  private TextView x;
  private String y;
  private RelativeLayout z;
  
  public aj(Context paramContext, JSONObject paramJSONObject, String paramString, a parama)
  {
    super(paramContext, paramJSONObject, paramString);
    this.D = parama;
    this.r = 0;
    this.o = i.d(this.m, "items");
    this.y = i.a(paramJSONObject, "label");
    if (a(this.y)) {
      this.y = com.unionpay.mobile.android.languages.c.bD.bg;
    }
    if (!TextUtils.isEmpty(i.a(paramJSONObject, "default_item_idx"))) {
      this.s = Integer.parseInt(i.a(paramJSONObject, "default_item_idx"));
    }
    this.q = new com.unionpay.mobile.android.upwidget.j(paramContext, this.o, this.s, paramString);
    this.q.a(this.n);
    this.q.a(this.a);
    this.q.d(this.b);
    paramContext = this.l;
    paramString = com.unionpay.mobile.android.resource.c.a(this.c).a(2014);
    paramJSONObject = new LinearLayout(this.c);
    paramJSONObject.setId(paramJSONObject.hashCode());
    paramJSONObject.setBackgroundColor(-3419943);
    parama = new RelativeLayout.LayoutParams(-1, 1);
    i.a(this.m, "type");
    paramContext.addView(paramJSONObject, parama);
    this.z = new RelativeLayout(this.c);
    this.z.setId(this.z.hashCode());
    this.z.setBackgroundDrawable(paramString);
    this.z.setOnClickListener(new an(this));
    paramString = new RelativeLayout.LayoutParams(-1, com.unionpay.mobile.android.global.a.n);
    paramString.addRule(15, -1);
    paramString.addRule(3, paramJSONObject.getId());
    paramContext.addView(this.z, paramString);
    paramJSONObject = new ImageView(this.c);
    paramJSONObject.setId(paramJSONObject.hashCode());
    paramJSONObject.setBackgroundDrawable(com.unionpay.mobile.android.resource.c.a(this.c).a(1002));
    int i = f.a(this.c, 15.0F);
    paramString = new RelativeLayout.LayoutParams(i, i);
    paramString.addRule(11, -1);
    paramString.addRule(15, -1);
    paramString.rightMargin = f.a(this.c, 10.0F);
    this.z.addView(paramJSONObject, paramString);
    this.v = new TextView(this.c);
    this.v.setTextSize(b.k);
    this.v.setEllipsize(TextUtils.TruncateAt.MIDDLE);
    this.v.setSingleLine(true);
    this.v.setTextColor(-10066330);
    paramString = new RelativeLayout.LayoutParams(-1, -2);
    paramString.addRule(15, -1);
    paramString.addRule(9, -1);
    paramString.addRule(0, paramJSONObject.getId());
    paramString.leftMargin = f.a(this.c, 10.0F);
    paramString.rightMargin = paramString.leftMargin;
    this.z.addView(this.v, paramString);
    if (!"instalment".equals("promotion"))
    {
      paramJSONObject = new LinearLayout(this.c);
      paramJSONObject.setBackgroundColor(-3419943);
      paramString = new RelativeLayout.LayoutParams(-1, 1);
      paramString.bottomMargin = com.unionpay.mobile.android.global.a.f;
      paramString.addRule(3, this.z.getId());
      paramContext.addView(paramJSONObject, paramString);
    }
    if (this.w != null) {
      bool = this.w.b();
    }
    a(bool);
    a(this.s, 0);
  }
  
  private String a(int paramInt1, int paramInt2, String paramString)
  {
    Object localObject = i.b(this.o, paramInt1);
    if (localObject != null)
    {
      localObject = (JSONObject)localObject;
      String str = i.a((JSONObject)localObject, "type");
      if ("coupon".equals(str)) {
        localObject = this.t;
      }
      for (;;)
      {
        localObject = i.b((JSONArray)localObject, paramInt2);
        if (localObject == null) {
          break;
        }
        return i.a((JSONObject)localObject, paramString);
        if ("point".equals(str)) {
          localObject = this.u;
        } else {
          localObject = i.d((JSONObject)localObject, "options");
        }
      }
    }
    return "";
  }
  
  private static JSONObject a(String paramString1, String paramString2, String paramString3)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", paramString1);
      localJSONObject.put("label", paramString2);
      localJSONObject.put("checked", paramString3);
      localJSONObject.put("ckb_style", "small");
      localJSONObject.put("required", "0");
      return localJSONObject;
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
    return localJSONObject;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    int i = 0;
    this.s = paramInt1;
    this.r = paramInt2;
    if (this.v != null) {
      this.v.setText(a(paramInt1, paramInt2, "label"));
    }
    Object localObject1 = this.C;
    Object localObject3 = a(paramInt1, paramInt2, "rel_label");
    Object localObject4 = a(paramInt1, paramInt2, "rel_value");
    Object localObject2 = a(paramInt1, paramInt2, "rel_value_style");
    this.C = ((String)localObject4);
    if (!this.B) {
      this.D.g();
    }
    this.B = false;
    this.A = a(paramInt1, paramInt2, "value");
    if ((a((String)localObject3)) && (a((String)localObject4)))
    {
      this.x.setVisibility(8);
      return;
    }
    localObject1 = localObject2;
    if (com.unionpay.mobile.android.data.a.a((String)localObject2))
    {
      paramInt1 = Color.parseColor((String)localObject2);
      localObject1 = Integer.toString(paramInt1, 16);
    }
    localObject2 = "#ff" + (String)localObject1;
    localObject1 = this.x;
    paramInt2 = Color.parseColor((String)localObject2);
    int j = ((String)localObject3).length();
    boolean bool;
    if (TextUtils.isEmpty((CharSequence)localObject4))
    {
      paramInt1 = 0;
      localObject2 = new SpannableStringBuilder((String)localObject3 + (String)localObject4);
      localObject3 = new ForegroundColorSpan(-13421773);
      localObject4 = new ForegroundColorSpan(paramInt2);
      ((SpannableStringBuilder)localObject2).setSpan(localObject3, 0, j, 33);
      ((SpannableStringBuilder)localObject2).setSpan(localObject4, j, paramInt1 + j, 18);
      ((TextView)localObject1).setText((CharSequence)localObject2);
      if (this.w == null) {
        break label355;
      }
      bool = this.w.b();
      label330:
      if (!bool) {
        break label361;
      }
    }
    label355:
    label361:
    for (paramInt1 = i;; paramInt1 = 8)
    {
      this.x.setVisibility(paramInt1);
      return;
      paramInt1 = ((String)localObject4).length();
      break;
      bool = true;
      break label330;
    }
  }
  
  public final String a()
  {
    Object localObject2 = a(this.s, this.r, "value");
    Object localObject1 = localObject2;
    if (localObject2 != null) {
      localObject1 = ((String)localObject2).replace("\"", "\\\"");
    }
    localObject2 = localObject1;
    if (this.w != null)
    {
      localObject2 = localObject1;
      if (!this.w.b()) {
        localObject2 = null;
      }
    }
    com.unionpay.mobile.android.utils.j.c("uppay", q() + " : " + (String)localObject2);
    return (String)localObject2;
  }
  
  public final void a(View.OnClickListener paramOnClickListener)
  {
    this.q.b(this.a);
    this.q.b(paramOnClickListener);
  }
  
  public final void a(q.a parama)
  {
    if (this.w != null) {
      this.w.a(parama);
    }
  }
  
  public final void a(JSONArray paramJSONArray)
  {
    this.t = paramJSONArray;
    this.q.a(paramJSONArray);
  }
  
  public final void a(JSONArray paramJSONArray, String paramString)
  {
    this.u = paramJSONArray;
    this.q.a(paramJSONArray, paramString);
  }
  
  public final void a(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      this.A = "";
      if (this.w != null) {
        this.w.a(paramBoolean);
      }
      if (!paramBoolean) {
        break label96;
      }
    }
    label96:
    for (int i = 0;; i = 8)
    {
      this.l.setVisibility(i);
      if (this.x != null)
      {
        if (!TextUtils.isEmpty(this.x.getText().toString())) {
          break label102;
        }
        this.x.setVisibility(8);
      }
      return;
      this.A = a(this.s, this.r, "value");
      break;
    }
    label102:
    this.x.setVisibility(i);
  }
  
  protected final boolean a(LinearLayout paramLinearLayout, String paramString)
  {
    if (a(paramString)) {
      return true;
    }
    LinearLayout localLinearLayout = new LinearLayout(this.c);
    localLinearLayout.setBackgroundColor(-1);
    localLinearLayout.setOrientation(1);
    paramLinearLayout.addView(localLinearLayout, new LinearLayout.LayoutParams(-1, com.unionpay.mobile.android.global.a.n));
    paramLinearLayout = a(i.a(this.m, "type"), paramString, i.a(this.m, "checked"));
    this.w = new q(this.c, paramLinearLayout, v() + "_agree_reduce_activity");
    this.w.a();
    this.w.a(b.k);
    paramLinearLayout = new LinearLayout.LayoutParams(-1, com.unionpay.mobile.android.global.a.n);
    paramLinearLayout.gravity = 16;
    int i = f.a(this.c, 10.0F);
    paramLinearLayout.rightMargin = i;
    paramLinearLayout.leftMargin = i;
    localLinearLayout.addView(this.w, paramLinearLayout);
    return true;
  }
  
  public final void b(View.OnClickListener paramOnClickListener)
  {
    this.q.e(paramOnClickListener);
  }
  
  public final boolean b()
  {
    return true;
  }
  
  protected final boolean b_()
  {
    this.x = new TextView(this.c);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.leftMargin = f.a(this.c, 10.0F);
    int i = f.a(this.c, 5.0F);
    localLayoutParams.bottomMargin = i;
    localLayoutParams.topMargin = i;
    this.x.setTextSize(b.k);
    addView(this.x, localLayoutParams);
    this.x.setVisibility(8);
    return true;
  }
  
  public final void c(View.OnClickListener paramOnClickListener)
  {
    this.q.c(paramOnClickListener);
  }
  
  public final boolean c()
  {
    return true;
  }
  
  protected final String d()
  {
    return "_select_reduce_activity";
  }
  
  public final boolean f()
  {
    String str = a(this.s, this.r, "available");
    return (TextUtils.isEmpty(str)) || (!"1".equals(str));
  }
  
  public final String g()
  {
    return this.A;
  }
  
  public static abstract interface a
  {
    public abstract void g();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/widgets/aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */