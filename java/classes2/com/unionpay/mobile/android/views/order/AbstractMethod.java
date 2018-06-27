package com.unionpay.mobile.android.views.order;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.unionpay.mobile.android.global.b;
import com.unionpay.mobile.android.upviews.a.a;
import com.unionpay.mobile.android.upviews.a.b;
import com.unionpay.mobile.android.utils.f;
import com.unionpay.mobile.android.utils.g;
import com.unionpay.mobile.android.utils.j;
import com.unionpay.sdk.UPAgent;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class AbstractMethod
  extends LinearLayout
  implements a.b
{
  protected static final int a = b.a;
  protected Context b;
  protected String c;
  protected String d;
  protected b e;
  protected a f;
  private Button g;
  private RelativeLayout h;
  
  public AbstractMethod(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AbstractMethod(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AbstractMethod(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext);
    this.b = paramContext;
    setOrientation(1);
  }
  
  protected static String a(JSONObject paramJSONObject, String paramString)
  {
    String str = null;
    if (paramJSONObject != null) {}
    try
    {
      str = paramJSONObject.getString(paramString);
      return str;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return null;
  }
  
  public static void a(Context paramContext, String paramString)
  {
    if (com.unionpay.mobile.android.global.a.L)
    {
      j.a("uppay-TD", "event:" + paramString + ", keys:" + Arrays.toString(null) + ", values:" + Arrays.toString(null));
      UPAgent.onEvent(paramContext, paramString);
    }
  }
  
  protected static void a(TextView paramTextView)
  {
    if (paramTextView == null) {
      return;
    }
    paramTextView.setTextSize(b.k);
    paramTextView.setTextColor(g.a(-10705958, -5846275, -5846275, -6710887));
  }
  
  protected static boolean a(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
  }
  
  public final void a()
  {
    this.h = new RelativeLayout(this.b);
    Object localObject = new LinearLayout.LayoutParams(-1, -2);
    addView(this.h, (ViewGroup.LayoutParams)localObject);
    a(this.h);
    localObject = new RelativeLayout(this.b);
    addView((View)localObject, new LinearLayout.LayoutParams(-1, -2));
    b((RelativeLayout)localObject);
    RelativeLayout localRelativeLayout = new RelativeLayout(this.b);
    localObject = new LinearLayout.LayoutParams(-1, -2);
    ((LinearLayout.LayoutParams)localObject).topMargin = com.unionpay.mobile.android.global.a.f;
    addView(localRelativeLayout, (ViewGroup.LayoutParams)localObject);
    this.g = new Button(this.b);
    this.g.setText(e());
    this.g.setTextColor(g.a(b.b, b.c, b.c, b.d));
    this.g.setTextSize(b.i);
    this.g.setOnClickListener(new a(this));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, b.n);
    localLayoutParams.addRule(15, -1);
    localLayoutParams.topMargin = com.unionpay.mobile.android.global.a.f;
    int i = f.a(this.b, 10.0F);
    localLayoutParams.rightMargin = i;
    localLayoutParams.leftMargin = i;
    localRelativeLayout.addView(this.g, localLayoutParams);
    localRelativeLayout = new RelativeLayout(this.b);
    addView(localRelativeLayout, (ViewGroup.LayoutParams)localObject);
    c(localRelativeLayout);
    this.g.setEnabled(f());
  }
  
  public final void a(Drawable paramDrawable)
  {
    if ((this.g != null) && (paramDrawable != null)) {
      this.g.setBackgroundDrawable(paramDrawable);
    }
  }
  
  public abstract void a(RelativeLayout paramRelativeLayout);
  
  public final void a(a.a parama) {}
  
  public final void a(a parama)
  {
    this.f = parama;
  }
  
  public final void a(b paramb)
  {
    this.e = paramb;
  }
  
  public final void a(boolean paramBoolean)
  {
    Button localButton = this.g;
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localButton.setEnabled(paramBoolean);
      return;
    }
  }
  
  public abstract int b();
  
  public abstract void b(RelativeLayout paramRelativeLayout);
  
  public abstract a.a c();
  
  public abstract void c(RelativeLayout paramRelativeLayout);
  
  public final void c(String paramString) {}
  
  public final void c(String paramString1, String paramString2) {}
  
  public int d()
  {
    return 0;
  }
  
  public abstract String e();
  
  public abstract boolean f();
  
  protected final void g()
  {
    this.h.setVisibility(8);
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt1, boolean paramBoolean, int paramInt2, a.a parama);
  }
  
  public static abstract interface b
  {
    public abstract void a(String paramString1, String paramString2);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/views/order/AbstractMethod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */