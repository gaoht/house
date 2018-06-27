package com.unionpay.mobile.android.upwidget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.unionpay.mobile.android.utils.g;
import com.unionpay.mobile.android.utils.i;
import org.json.JSONObject;

public final class w
  extends LinearLayout
{
  private String a = null;
  private x b = null;
  
  private w(Context paramContext, String paramString1, String paramString2, Drawable paramDrawable)
  {
    super(paramContext);
    setOrientation(0);
    this.a = paramString2;
    this.b = x.a(paramContext, paramDrawable);
    this.b.a(Html.fromHtml(String.format("<u>%s</u>", new Object[] { paramString1 })));
    paramContext = g.a(-13601621, -15909519);
    this.b.a(paramContext);
    addView(this.b);
  }
  
  public static final w a(Context paramContext, JSONObject paramJSONObject, Drawable paramDrawable)
  {
    w localw = null;
    if (paramJSONObject != null) {
      localw = new w(paramContext, i.a(paramJSONObject, "label"), i.a(paramJSONObject, "href"), paramDrawable);
    }
    return localw;
  }
  
  public final String a()
  {
    return this.a;
  }
  
  public final void a(View.OnClickListener paramOnClickListener)
  {
    if (this.b != null) {
      this.b.setOnClickListener(paramOnClickListener);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/upwidget/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */