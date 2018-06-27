package com.unionpay.mobile.android.widgets;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.unionpay.mobile.android.global.b;
import com.unionpay.mobile.android.utils.i;
import org.json.JSONObject;

public final class ad
  extends z
{
  private int a = 0;
  private String b;
  private TextView n;
  private TextView o;
  
  public ad(Context paramContext, int paramInt, JSONObject paramJSONObject, String paramString)
  {
    this(paramContext, paramInt, paramJSONObject, paramString, (byte)0);
  }
  
  private ad(Context paramContext, int paramInt, JSONObject paramJSONObject, String paramString, byte paramByte)
  {
    super(paramContext, paramJSONObject, paramString);
    this.a = paramInt;
    if (paramJSONObject != null) {
      this.b = i.a(paramJSONObject, "style");
    }
    paramJSONObject = this.l;
    paramContext = new LinearLayout(this.c);
    paramJSONObject.addView(paramContext, new RelativeLayout.LayoutParams(-1, -2));
    paramContext.setOrientation(0);
    paramInt = this.a;
    paramInt = this.a;
    paramInt = com.unionpay.mobile.android.global.a.f;
    this.n = new TextView(this.c);
    this.n.setTextSize(b.k);
    this.n.setText(s());
    this.n.setGravity(3);
    this.n.setTextColor(-13421773);
    paramJSONObject = new LinearLayout.LayoutParams(0, -2, 0.3F);
    paramJSONObject.gravity = 3;
    paramContext.addView(this.n, paramJSONObject);
    this.o = new TextView(this.c);
    this.o.setGravity(16);
    this.o.setTextSize(b.k);
    paramJSONObject = com.unionpay.mobile.android.data.a.a(i(), this.b);
    this.o.setText(paramJSONObject);
    this.o.setPadding(0, 0, com.unionpay.mobile.android.global.a.g, 0);
    paramJSONObject = new LinearLayout.LayoutParams(0, -2, 0.7F);
    paramJSONObject.gravity = 21;
    paramContext.addView(this.o, paramJSONObject);
  }
  
  public ad(Context paramContext, JSONObject paramJSONObject, String paramString)
  {
    super(paramContext, paramJSONObject, paramString);
    int i = com.unionpay.mobile.android.global.a.f;
    paramContext = s();
    if ((paramContext != null) && (paramContext.length() > 0))
    {
      this.n = new TextView(this.c);
      this.n.setTextSize(b.k);
      this.n.setText(s());
      this.n.setTextColor(-7829368);
      addView(this.n);
    }
    paramContext = i();
    if ((paramContext != null) && (paramContext.length() > 0))
    {
      this.o = new TextView(this.c);
      this.o.setTextSize(b.k);
      this.o.setTextColor(-7829368);
      this.o.setText(i());
      addView(this.o);
    }
  }
  
  public final String a()
  {
    return null;
  }
  
  public final void a(float paramFloat)
  {
    this.o.setTextSize(paramFloat);
  }
  
  public final boolean b()
  {
    return true;
  }
  
  public final boolean c()
  {
    return true;
  }
  
  public final void g()
  {
    this.o.setTextColor(-6710887);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/widgets/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */