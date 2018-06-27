package com.unionpay.mobile.android.widgets;

import android.content.Context;
import android.text.TextUtils.TruncateAt;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Spinner;
import android.widget.TextView;
import com.unionpay.mobile.android.upwidget.g;
import com.unionpay.mobile.android.utils.f;
import com.unionpay.mobile.android.utils.i;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a
  extends z
{
  private static List<String> u;
  private static List<String> v;
  private Spinner a = null;
  private int b = 1;
  private String n;
  private com.unionpay.mobile.android.upwidget.c o;
  private TextView p;
  private RelativeLayout q;
  private PopupWindow r;
  private g s;
  private List<Map<String, Object>> t;
  private final View.OnClickListener w = new b(this);
  private final AdapterView.OnItemClickListener x = new c(this);
  
  public a(Context paramContext, JSONObject paramJSONObject, JSONArray paramJSONArray, String paramString)
  {
    super(paramContext, paramJSONObject, paramString);
    paramContext = new ArrayList(1);
    int i = 0;
    while (i < paramJSONArray.length())
    {
      paramContext.add((JSONArray)i.b(paramJSONArray, i));
      i += 1;
    }
    if (paramContext.size() > 0)
    {
      u = new ArrayList(paramContext.size());
      v = new ArrayList(paramContext.size());
      i = 0;
      while (i < paramContext.size())
      {
        v.add(i.a((JSONArray)paramContext.get(i), 0));
        u.add(i.a((JSONArray)paramContext.get(i), 1));
        i += 1;
      }
    }
    paramContext = this.l;
    paramJSONObject = com.unionpay.mobile.android.resource.c.a(this.c).a(2014);
    this.q = new RelativeLayout(this.c);
    this.q.setBackgroundDrawable(paramJSONObject);
    this.q.setOnClickListener(new d(this));
    paramJSONObject = new RelativeLayout.LayoutParams(-1, com.unionpay.mobile.android.global.a.n);
    paramJSONObject.addRule(15, -1);
    paramContext.addView(this.q, paramJSONObject);
    paramContext = new ImageView(this.c);
    paramContext.setId(paramContext.hashCode());
    paramContext.setBackgroundDrawable(com.unionpay.mobile.android.resource.c.a(this.c).a(1002));
    i = f.a(this.c, 15.0F);
    paramJSONObject = new RelativeLayout.LayoutParams(i, i);
    paramJSONObject.addRule(11, -1);
    paramJSONObject.addRule(15, -1);
    paramJSONObject.rightMargin = f.a(this.c, 10.0F);
    this.q.addView(paramContext, paramJSONObject);
    paramJSONObject = new TextView(this.c);
    paramJSONObject.setId(paramJSONObject.hashCode());
    paramJSONObject.setTextSize(com.unionpay.mobile.android.global.b.k);
    paramJSONObject.setEllipsize(TextUtils.TruncateAt.MIDDLE);
    paramJSONObject.setTextColor(-13421773);
    paramJSONObject.setSingleLine(true);
    paramJSONObject.setEms(4);
    paramJSONObject.setText(com.unionpay.mobile.android.languages.c.bD.bd);
    paramJSONArray = new RelativeLayout.LayoutParams(-2, -2);
    paramJSONArray.addRule(15, -1);
    paramJSONArray.addRule(9, -1);
    paramJSONArray.leftMargin = f.a(this.c, 10.0F);
    this.q.addView(paramJSONObject, paramJSONArray);
    this.p = new TextView(this.c);
    this.p.setTextSize(com.unionpay.mobile.android.global.b.k);
    this.p.setEllipsize(TextUtils.TruncateAt.MIDDLE);
    this.p.setSingleLine(true);
    this.p.setTextColor(-10066330);
    paramJSONArray = new RelativeLayout.LayoutParams(-1, -2);
    paramJSONArray.addRule(15, -1);
    paramJSONArray.addRule(1, paramJSONObject.getId());
    paramJSONArray.addRule(0, paramContext.getId());
    this.q.addView(this.p, paramJSONArray);
    if (this.h)
    {
      this.p.setText(b(i()));
      paramContext.setVisibility(8);
      this.q.setClickable(false);
    }
    while ((u == null) || (u.size() <= 0)) {
      return;
    }
    this.p.setText((CharSequence)u.get(0));
  }
  
  private static String b(String paramString)
  {
    String str = "";
    int i = 0;
    if (i < v.size())
    {
      if (!((String)v.get(i)).equals(paramString)) {
        break label59;
      }
      str = (String)u.get(i);
    }
    label59:
    for (;;)
    {
      i += 1;
      break;
      return str;
    }
  }
  
  public final String a()
  {
    if (this.o == null) {}
    for (int i = 1;; i = this.o.c())
    {
      i = this.b - i;
      if (!this.h) {
        break;
      }
      return i();
    }
    if ((i >= 0) && (i <= u.size())) {
      return (String)v.get(i);
    }
    return "";
  }
  
  public final boolean b()
  {
    return true;
  }
  
  public final boolean c()
  {
    return true;
  }
  
  protected final String d()
  {
    return "_select_areacode";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/widgets/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */