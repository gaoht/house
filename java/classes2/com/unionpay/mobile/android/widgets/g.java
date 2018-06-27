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
import com.unionpay.mobile.android.global.a;
import com.unionpay.mobile.android.global.b;
import com.unionpay.mobile.android.utils.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public final class g
  extends z
{
  private static List<String> u;
  private static List<String> v;
  private Spinner a = null;
  private int b = 1;
  private String n = com.unionpay.mobile.android.languages.c.bD.bf;
  private com.unionpay.mobile.android.upwidget.c o;
  private TextView p;
  private RelativeLayout q;
  private PopupWindow r;
  private com.unionpay.mobile.android.upwidget.g s;
  private List<Map<String, Object>> t;
  private final View.OnClickListener w = new h(this);
  private final AdapterView.OnItemClickListener x = new i(this);
  
  static
  {
    ArrayList localArrayList = new ArrayList(8);
    localArrayList.add(com.unionpay.mobile.android.languages.c.bD.M);
    localArrayList.add(com.unionpay.mobile.android.languages.c.bD.N);
    localArrayList.add(com.unionpay.mobile.android.languages.c.bD.O);
    localArrayList.add(com.unionpay.mobile.android.languages.c.bD.P);
    localArrayList.add(com.unionpay.mobile.android.languages.c.bD.Q);
    localArrayList.add(com.unionpay.mobile.android.languages.c.bD.R);
    localArrayList.add(com.unionpay.mobile.android.languages.c.bD.S);
    localArrayList.add(com.unionpay.mobile.android.languages.c.bD.T);
    u = localArrayList;
    localArrayList = new ArrayList(8);
    localArrayList.add("01");
    localArrayList.add("02");
    localArrayList.add("03");
    localArrayList.add("04");
    localArrayList.add("05");
    localArrayList.add("06");
    localArrayList.add("07");
    localArrayList.add("99");
    v = localArrayList;
  }
  
  public g(Context paramContext, JSONObject paramJSONObject, String paramString)
  {
    super(paramContext, paramJSONObject, paramString);
    paramString = null;
    paramJSONObject = paramString;
    if (u != null)
    {
      paramJSONObject = paramString;
      if (u.size() > 0)
      {
        paramJSONObject = new ArrayList(u.size());
        i = 0;
        while (i < u.size())
        {
          paramString = new HashMap();
          paramString.put("text1", u.get(i));
          paramString.put("text2", "");
          paramString.put("editable", Boolean.FALSE);
          paramJSONObject.add(paramString);
          i += 1;
        }
      }
    }
    this.t = paramJSONObject;
    this.o = new com.unionpay.mobile.android.upwidget.c(paramContext, this.t, this.n, "", "", this.b, 0);
    this.s = new com.unionpay.mobile.android.upwidget.g(this.c, this.o);
    this.s.a(this.x);
    this.s.a(this.w);
    paramContext = this.l;
    paramJSONObject = com.unionpay.mobile.android.resource.c.a(this.c).a(2014);
    this.q = new RelativeLayout(this.c);
    this.q.setBackgroundDrawable(paramJSONObject);
    this.q.setOnClickListener(new j(this));
    paramJSONObject = new RelativeLayout.LayoutParams(-1, a.n);
    paramJSONObject.addRule(15, -1);
    paramContext.addView(this.q, paramJSONObject);
    paramContext = new ImageView(this.c);
    paramContext.setId(paramContext.hashCode());
    paramContext.setBackgroundDrawable(com.unionpay.mobile.android.resource.c.a(this.c).a(1002));
    int i = f.a(this.c, 15.0F);
    paramJSONObject = new RelativeLayout.LayoutParams(i, i);
    paramJSONObject.addRule(11, -1);
    paramJSONObject.addRule(15, -1);
    paramJSONObject.rightMargin = f.a(this.c, 10.0F);
    this.q.addView(paramContext, paramJSONObject);
    paramJSONObject = new TextView(this.c);
    paramJSONObject.setId(paramJSONObject.hashCode());
    paramJSONObject.setTextSize(b.k);
    paramJSONObject.setEllipsize(TextUtils.TruncateAt.MIDDLE);
    paramJSONObject.setSingleLine(true);
    paramJSONObject.setEms(4);
    paramJSONObject.setText(com.unionpay.mobile.android.languages.c.bD.bc);
    paramString = new RelativeLayout.LayoutParams(-2, -2);
    paramString.addRule(15, -1);
    paramString.addRule(9, -1);
    paramString.leftMargin = f.a(this.c, 10.0F);
    this.q.addView(paramJSONObject, paramString);
    this.p = new TextView(this.c);
    this.p.setTextSize(b.k);
    this.p.setEllipsize(TextUtils.TruncateAt.MIDDLE);
    this.p.setSingleLine(true);
    this.p.setTextColor(-10066330);
    paramString = new RelativeLayout.LayoutParams(-1, -2);
    paramString.addRule(15, -1);
    paramString.addRule(1, paramJSONObject.getId());
    paramString.addRule(0, paramContext.getId());
    this.q.addView(this.p, paramString);
    if (this.h)
    {
      this.p.setText(b(i()));
      paramContext.setVisibility(8);
      this.q.setClickable(false);
      return;
    }
    a(1);
  }
  
  private void a(int paramInt)
  {
    this.b = paramInt;
    int i = this.o.c();
    this.o.a(this.b);
    if ((this.p != null) && (u != null)) {
      this.p.setText((CharSequence)u.get(paramInt - i));
    }
  }
  
  private static String b(String paramString)
  {
    String str = "";
    int i = 0;
    if (i < v.size())
    {
      if (!((String)v.get(i)).equals(paramString)) {
        break label58;
      }
      str = (String)u.get(i);
    }
    label58:
    for (;;)
    {
      i += 1;
      break;
      return str;
    }
  }
  
  public final String a()
  {
    String str2 = "";
    int i = this.b - this.o.c();
    String str1;
    if (this.h) {
      str1 = i();
    }
    do
    {
      do
      {
        return str1;
        str1 = str2;
      } while (i < 0);
      str1 = str2;
    } while (i > u.size());
    return (String)v.get(i);
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
    return "_select_certtype";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/widgets/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */