package com.unionpay.mobile.android.upwidget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.unionpay.mobile.android.resource.c;
import com.unionpay.mobile.android.utils.f;
import com.unionpay.mobile.android.utils.g;
import com.unionpay.mobile.android.utils.i;
import org.json.JSONObject;

public final class a
  extends LinearLayout
{
  private String a = "";
  private String b = "";
  private String c = "";
  private String d = "";
  private String e = "";
  private String f = "";
  private String g = "";
  private String h = "";
  private String i = "";
  private Button j = null;
  private boolean k = false;
  private Context l = null;
  private float m = 0.0F;
  private View.OnClickListener n = new b(this);
  private String o;
  private TextView p;
  private a q;
  private String r;
  
  public a(Context paramContext, JSONObject paramJSONObject, View.OnClickListener paramOnClickListener, String paramString)
  {
    this(paramContext, paramJSONObject, paramOnClickListener, paramString, (byte)0);
  }
  
  private a(Context paramContext, JSONObject paramJSONObject, View.OnClickListener paramOnClickListener, String paramString, byte paramByte)
  {
    super(paramContext);
    this.l = paramContext;
    this.m = 16.0F;
    this.r = paramString;
    this.a = i.a(paramJSONObject, "name");
    this.b = i.a(paramJSONObject, "value");
    this.c = i.a(paramJSONObject, "label");
    this.d = i.a(paramJSONObject, "href_label");
    this.e = i.a(paramJSONObject, "href_url");
    this.f = i.a(paramJSONObject, "href_title");
    this.g = i.a(paramJSONObject, "checked");
    this.h = i.a(paramJSONObject, "required");
    this.i = i.a(paramJSONObject, "error_info");
    this.o = i.a(paramJSONObject, "ckb_style");
    this.j = new Button(this.l);
    if ((a(this.g)) && (this.g.equalsIgnoreCase("0"))) {}
    for (this.k = true;; this.k = false)
    {
      this.j.setOnClickListener(this.n);
      g();
      f();
      paramByte = f.a(this.l, 20.0F);
      paramContext = new LinearLayout.LayoutParams(paramByte, paramByte);
      paramContext.gravity = 16;
      addView(this.j, paramContext);
      if (this.q != null)
      {
        paramContext = this.q;
        boolean bool = this.k;
      }
      if (a(this.c))
      {
        this.p = new TextView(this.l);
        this.p.setText(this.c);
        this.p.setTextSize(this.m);
        this.p.setTextColor(-16777216);
        this.p.setOnClickListener(this.n);
        paramContext = new LinearLayout.LayoutParams(-2, -2);
        paramContext.gravity = 16;
        paramContext.leftMargin = com.unionpay.mobile.android.global.a.d;
        addView(this.p, paramContext);
      }
      if ((a(this.d)) && (a(this.e)))
      {
        paramContext = new TextView(this.l);
        paramContext.setText(Html.fromHtml(this.d));
        paramContext.setTextColor(g.a(-10705958, -5846275, -5846275, -6710887));
        String.format("<u>%s</u>", new Object[] { this.d });
        paramContext.setTextSize(this.m);
        paramContext.setOnClickListener(paramOnClickListener);
        paramJSONObject = new LinearLayout.LayoutParams(-2, -2);
        paramJSONObject.gravity = 16;
        addView(paramContext, paramJSONObject);
      }
      return;
    }
  }
  
  private static boolean a(String paramString)
  {
    return (paramString != null) && (paramString.length() > 0);
  }
  
  private boolean f()
  {
    boolean bool = false;
    if ("small".equalsIgnoreCase(this.o)) {
      bool = true;
    }
    return bool;
  }
  
  private void g()
  {
    if (this.j == null) {
      return;
    }
    int i1;
    if (this.k)
    {
      i1 = 1008;
      if (!f()) {
        break label67;
      }
    }
    label67:
    for (int i2 = f.a(this.l, 15.0F);; i2 = com.unionpay.mobile.android.global.a.w)
    {
      Drawable localDrawable = c.a(this.l).a(i1, i2, i2);
      this.j.setBackgroundDrawable(localDrawable);
      return;
      i1 = 1007;
      break;
    }
  }
  
  public final String a()
  {
    if (this.k) {}
    for (String str = this.b;; str = "") {
      return String.format("\"%s\":\"%s\"", new Object[] { this.a, str });
    }
  }
  
  public final String b()
  {
    return this.i;
  }
  
  public final String c()
  {
    return this.e;
  }
  
  public final String d()
  {
    return this.f;
  }
  
  public final boolean e()
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (a(this.h))
    {
      bool1 = bool2;
      if (this.h.equalsIgnoreCase("0")) {
        bool1 = this.k;
      }
    }
    return bool1;
  }
  
  public static abstract interface a {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/upwidget/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */