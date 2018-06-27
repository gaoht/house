package com.unionpay.mobile.android.widgets;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.InputFilter.LengthFilter;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.unionpay.mobile.android.global.a;
import com.unionpay.mobile.android.global.b;
import com.unionpay.mobile.android.languages.c;
import com.unionpay.mobile.android.utils.g;
import org.json.JSONObject;

public final class ap
  extends aa
  implements Handler.Callback
{
  private a n = null;
  private TextView o = null;
  private Handler p = null;
  private int q = 0;
  
  public ap(Context paramContext, int paramInt, JSONObject paramJSONObject, String paramString)
  {
    super(paramContext, paramInt, paramJSONObject, paramString);
    j();
    this.n = null;
  }
  
  public ap(Context paramContext, int paramInt, JSONObject paramJSONObject, String paramString, byte paramByte)
  {
    super(paramContext, paramInt, paramJSONObject, paramString);
    j();
  }
  
  private void a(boolean paramBoolean, String paramString)
  {
    this.o.setText(paramString);
    this.o.setEnabled(paramBoolean);
  }
  
  private void j()
  {
    int i = this.a;
    i = a.b;
    this.b.a(new InputFilter.LengthFilter(6));
    this.b.a(2);
    Object localObject = new RelativeLayout.LayoutParams(-1, b.n);
    ((RelativeLayout.LayoutParams)localObject).addRule(9, -1);
    ((RelativeLayout.LayoutParams)localObject).addRule(15, -1);
    this.b.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = new LinearLayout(this.c);
    ((LinearLayout)localObject).setOrientation(1);
    ((LinearLayout)localObject).setBackgroundColor(-3419943);
    new LinearLayout.LayoutParams(1, -1);
    this.o = new TextView(getContext());
    this.o.setGravity(17);
    this.o.setText(c.bD.w);
    this.o.setTextColor(g.a(-10705958, -5846275, -5846275, -6710887));
    this.o.setTextSize(b.k);
    this.o.setOnClickListener(new aq(this));
    localObject = new LinearLayout.LayoutParams(-2, -1);
    this.b.a(this.o, (LinearLayout.LayoutParams)localObject);
  }
  
  public final void a(int paramInt)
  {
    this.p = new Handler(this);
    ar localar = new ar(this, paramInt);
    a(false, String.format(c.bD.x, new Object[] { Integer.valueOf(paramInt) }));
    localar.start();
  }
  
  public final void a(a parama)
  {
    this.n = parama;
  }
  
  public final boolean b()
  {
    if (this.h) {}
    while (6 == a().length()) {
      return true;
    }
    return false;
  }
  
  protected final String d()
  {
    return "_input_msg";
  }
  
  public final boolean handleMessage(Message paramMessage)
  {
    boolean bool = true;
    switch (paramMessage.what)
    {
    default: 
      bool = false;
    }
    do
    {
      return bool;
      if (c.bD != null) {
        a(true, c.bD.y);
      }
      this.p = null;
      return true;
      this.q = paramMessage.arg1;
    } while (c.bD == null);
    a(false, String.format(c.bD.x, new Object[] { Integer.valueOf(paramMessage.arg1) }));
    return true;
  }
  
  public static abstract interface a
  {
    public abstract void a(z paramz);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/widgets/ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */