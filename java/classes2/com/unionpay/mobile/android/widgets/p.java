package com.unionpay.mobile.android.widgets;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.unionpay.mobile.android.global.a;
import com.unionpay.mobile.android.global.b;
import com.unionpay.mobile.android.upwidget.e;
import com.unionpay.mobile.android.upwidget.q.a;
import com.unionpay.mobile.android.utils.f;
import com.unionpay.mobile.android.utils.i;
import com.unionpay.mobile.android.utils.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class p
  extends z
{
  private final View.OnClickListener a = new q(this);
  private final AdapterView.OnItemClickListener b = new r(this);
  private JSONArray n = i.d(this.m, "new_instalments");
  private List<Map<String, Object>> o;
  private AlertDialog p;
  private PopupWindow q;
  private e r;
  private int s = 1;
  private TextView t;
  private com.unionpay.mobile.android.upwidget.q u;
  private TextView v;
  private String w;
  private RelativeLayout x;
  private boolean y = false;
  private boolean z = true;
  
  public p(Context paramContext, JSONObject paramJSONObject, String paramString)
  {
    super(paramContext, paramJSONObject, paramString);
    this.w = i.a(paramJSONObject, "label");
    if (a(this.w)) {
      this.w = com.unionpay.mobile.android.languages.c.bD.bg;
    }
    this.o = b(this.n);
    this.r = new e(this.c, this.o, "");
    a(this.l);
  }
  
  private String a(int paramInt, String paramString)
  {
    Object localObject = i.b(this.n, paramInt);
    if (localObject != null) {
      return i.a((JSONObject)localObject, paramString);
    }
    return "";
  }
  
  private JSONObject a(String paramString1, String paramString2, String paramString3)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", paramString1);
      localJSONObject.put("label", paramString2);
      localJSONObject.put("checked", paramString3);
      localJSONObject.put("ckb_style", "small");
      localJSONObject.put("required", "0");
      if ("instalment".equals(paramString1))
      {
        paramString1 = i.c(this.m, "url");
        if (paramString1 != null)
        {
          localJSONObject.put("href_label", i.a(paramString1, "label"));
          localJSONObject.put("href_url", i.a(paramString1, "href"));
        }
      }
      return localJSONObject;
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
    return localJSONObject;
  }
  
  private void a(int paramInt)
  {
    this.s = paramInt;
    int i = this.r.a();
    this.r.a(this.s);
    if (this.t != null) {
      this.t.setText(a(paramInt - i, "label"));
    }
  }
  
  private void a(RelativeLayout paramRelativeLayout)
  {
    Object localObject3 = com.unionpay.mobile.android.resource.c.a(this.c).a(2014);
    Object localObject2 = new LinearLayout(this.c);
    ((LinearLayout)localObject2).setId(localObject2.hashCode());
    ((LinearLayout)localObject2).setBackgroundColor(-3419943);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, 1);
    Object localObject1 = i.a(this.m, "type");
    if ("instalment".equals(localObject1)) {
      localLayoutParams.leftMargin = f.a(this.c, 10.0F);
    }
    paramRelativeLayout.addView((View)localObject2, localLayoutParams);
    this.x = new RelativeLayout(this.c);
    this.x.setId(this.x.hashCode());
    this.x.setBackgroundDrawable((Drawable)localObject3);
    this.x.setOnClickListener(new s(this));
    localObject3 = new RelativeLayout.LayoutParams(-1, a.n);
    ((RelativeLayout.LayoutParams)localObject3).addRule(15, -1);
    ((RelativeLayout.LayoutParams)localObject3).addRule(3, ((LinearLayout)localObject2).getId());
    paramRelativeLayout.addView(this.x, (ViewGroup.LayoutParams)localObject3);
    localObject2 = new ImageView(this.c);
    ((ImageView)localObject2).setId(localObject2.hashCode());
    ((ImageView)localObject2).setBackgroundDrawable(com.unionpay.mobile.android.resource.c.a(this.c).a(1002));
    int i = f.a(this.c, 15.0F);
    localObject3 = new RelativeLayout.LayoutParams(i, i);
    ((RelativeLayout.LayoutParams)localObject3).addRule(11, -1);
    ((RelativeLayout.LayoutParams)localObject3).addRule(15, -1);
    ((RelativeLayout.LayoutParams)localObject3).rightMargin = f.a(this.c, 10.0F);
    this.x.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
    this.t = new TextView(this.c);
    this.t.setTextSize(b.k);
    this.t.setEllipsize(TextUtils.TruncateAt.MIDDLE);
    this.t.setSingleLine(true);
    this.t.setTextColor(-10066330);
    localObject3 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject3).addRule(15, -1);
    ((RelativeLayout.LayoutParams)localObject3).addRule(9, -1);
    ((RelativeLayout.LayoutParams)localObject3).addRule(0, ((ImageView)localObject2).getId());
    ((RelativeLayout.LayoutParams)localObject3).leftMargin = f.a(this.c, 10.0F);
    ((RelativeLayout.LayoutParams)localObject3).rightMargin = ((RelativeLayout.LayoutParams)localObject3).leftMargin;
    this.x.addView(this.t, (ViewGroup.LayoutParams)localObject3);
    if (!"instalment".equals(localObject1))
    {
      localObject1 = new LinearLayout(this.c);
      ((LinearLayout)localObject1).setBackgroundColor(-3419943);
      localObject2 = new RelativeLayout.LayoutParams(-1, 1);
      ((RelativeLayout.LayoutParams)localObject2).bottomMargin = a.f;
      ((RelativeLayout.LayoutParams)localObject2).addRule(3, this.x.getId());
      paramRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    }
    b(g());
    a(this.r.a());
  }
  
  private List<Map<String, Object>> b(JSONArray paramJSONArray)
  {
    HashMap localHashMap = null;
    Object localObject = localHashMap;
    if (paramJSONArray != null)
    {
      localObject = localHashMap;
      if (paramJSONArray.length() > 0)
      {
        localObject = new ArrayList(paramJSONArray.length());
        int i = 0;
        while (i < paramJSONArray.length())
        {
          localHashMap = new HashMap();
          localHashMap.put("label", a(i, "label"));
          localHashMap.put("style", a(i, "rel_value_style"));
          String[] arrayOfString1 = a(i, "rel_value").split("\\|");
          ArrayList localArrayList1 = new ArrayList(arrayOfString1.length);
          ArrayList localArrayList2 = new ArrayList(arrayOfString1.length);
          int k = arrayOfString1.length;
          int j = 0;
          while (j < k)
          {
            String[] arrayOfString2 = arrayOfString1[j].split(":");
            localArrayList1.add(arrayOfString2[0]);
            localArrayList2.add(arrayOfString2[1]);
            j += 1;
          }
          localHashMap.put("keys", localArrayList1);
          localHashMap.put("values", localArrayList2);
          ((List)localObject).add(localHashMap);
          i += 1;
        }
      }
    }
    return (List<Map<String, Object>>)localObject;
  }
  
  public final String a()
  {
    String str2 = a(this.s - this.r.a(), "value");
    String str1 = str2;
    if (this.u != null)
    {
      str1 = str2;
      if (!this.u.b()) {
        str1 = null;
      }
    }
    j.c("uppay", q() + " : " + str1);
    return str1;
  }
  
  public final void a(q.a parama)
  {
    this.u.a(parama);
  }
  
  public final void a(JSONArray paramJSONArray)
  {
    if ((paramJSONArray != null) && (paramJSONArray.length() > 0))
    {
      this.z = true;
      this.n = paramJSONArray;
      this.o = b(paramJSONArray);
      this.r = new e(this.c, this.o, "");
      a(this.l);
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    this.y = paramBoolean;
  }
  
  protected final boolean a(LinearLayout paramLinearLayout, String paramString)
  {
    if (a(paramString)) {
      return true;
    }
    LinearLayout localLinearLayout1 = new LinearLayout(this.c);
    localLinearLayout1.setBackgroundColor(-1);
    localLinearLayout1.setOrientation(1);
    paramLinearLayout.addView(localLinearLayout1, new LinearLayout.LayoutParams(-1, a.n));
    paramLinearLayout = i.a(this.m, "type");
    if ("instalment".equals(paramLinearLayout))
    {
      LinearLayout localLinearLayout2 = new LinearLayout(this.c);
      localLinearLayout2.setId(localLinearLayout2.hashCode());
      localLinearLayout2.setBackgroundColor(-3419943);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, 1);
      localLayoutParams.leftMargin = f.a(this.c, 10.0F);
      localLinearLayout1.addView(localLinearLayout2, localLayoutParams);
    }
    paramLinearLayout = a(paramLinearLayout, paramString, i.a(this.m, "checked"));
    this.u = new com.unionpay.mobile.android.upwidget.q(this.c, paramLinearLayout, v() + "_agree_installment");
    this.u.a();
    this.u.a(b.k);
    paramLinearLayout = new LinearLayout.LayoutParams(-1, a.n);
    paramLinearLayout.gravity = 16;
    int i = f.a(this.c, 10.0F);
    paramLinearLayout.rightMargin = i;
    paramLinearLayout.leftMargin = i;
    localLinearLayout1.addView(this.u, paramLinearLayout);
    return true;
  }
  
  public final void b(boolean paramBoolean)
  {
    this.u.a(paramBoolean);
    if (!paramBoolean) {
      this.y = paramBoolean;
    }
    int i;
    if (this.y) {
      if (paramBoolean) {
        i = 0;
      }
    }
    for (;;)
    {
      this.l.setVisibility(i);
      if (this.v != null)
      {
        if (TextUtils.isEmpty(this.v.getText().toString())) {
          this.v.setVisibility(8);
        }
      }
      else
      {
        return;
        i = 8;
        continue;
      }
      this.v.setVisibility(i);
      return;
      i = 8;
    }
  }
  
  public final boolean b()
  {
    return true;
  }
  
  protected final boolean b_()
  {
    this.v = new TextView(this.c);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.leftMargin = f.a(this.c, 10.0F);
    int i = f.a(this.c, 5.0F);
    localLayoutParams.bottomMargin = i;
    localLayoutParams.topMargin = i;
    this.v.setTextSize(b.k);
    addView(this.v, localLayoutParams);
    this.v.setVisibility(8);
    return true;
  }
  
  public final boolean c()
  {
    return true;
  }
  
  protected final String d()
  {
    return "_select_installment";
  }
  
  public final boolean f()
  {
    String str = a(this.s - this.r.a(), "available");
    return (TextUtils.isEmpty(str)) || (!"1".equals(str));
  }
  
  public final boolean g()
  {
    if (this.u != null) {
      return this.u.b();
    }
    return true;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/widgets/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */