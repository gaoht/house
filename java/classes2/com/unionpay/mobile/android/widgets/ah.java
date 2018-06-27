package com.unionpay.mobile.android.widgets;

import android.content.Context;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.unionpay.mobile.android.global.a;
import com.unionpay.mobile.android.global.b;
import com.unionpay.mobile.android.utils.i;
import org.json.JSONObject;

public final class ah
  extends aa
{
  private a n = null;
  private String o = null;
  private String p = null;
  
  public ah(Context paramContext, int paramInt, JSONObject paramJSONObject, String paramString)
  {
    this(paramContext, paramInt, paramJSONObject, paramString, (byte)0);
  }
  
  private ah(Context paramContext, int paramInt, JSONObject paramJSONObject, String paramString, byte paramByte)
  {
    super(paramContext, paramInt, paramJSONObject, paramString);
    this.o = i.a(paramJSONObject, "button_label");
    this.p = i.a(paramJSONObject, "button_action");
    this.b.a(new InputFilter.LengthFilter(11));
    this.b.a(2);
    if ((this.o == null) || (this.o.length() <= 0)) {
      return;
    }
    paramInt = this.a;
    paramInt = a.b;
    paramContext = new RelativeLayout.LayoutParams(-1, b.n);
    paramContext.addRule(9, -1);
    paramContext.addRule(15, -1);
    this.b.setLayoutParams(paramContext);
    paramContext = new TextView(getContext());
    paramContext.setGravity(17);
    paramContext.setText(this.o);
    paramContext.setTextColor(-7829368);
    paramContext.setTextSize(b.k);
    paramContext.setOnClickListener(new ai(this));
    paramJSONObject = new LinearLayout.LayoutParams(-2, -1);
    this.b.a(paramContext, paramJSONObject);
  }
  
  public final String a()
  {
    return this.b.b();
  }
  
  public final void a(a parama)
  {
    this.n = parama;
  }
  
  public final boolean b()
  {
    if (this.h) {}
    do
    {
      return true;
      if ((this.i == null) || (TextUtils.isEmpty(this.i))) {
        break;
      }
    } while (a().matches(this.i));
    while ((11 != a().length()) || (!a().startsWith("1"))) {
      return false;
    }
    return true;
  }
  
  protected final String d()
  {
    return "_input_phoneNO";
  }
  
  public static abstract interface a
  {
    public abstract void e(String paramString);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/widgets/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */