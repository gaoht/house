package com.unionpay.mobile.android.widgets;

import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.unionpay.mobile.android.global.a;
import com.unionpay.mobile.android.resource.c;

public final class as
  extends LinearLayout
{
  private c a = null;
  private ImageView b = null;
  private ImageView c = null;
  
  public as(Context paramContext)
  {
    super(paramContext);
    this.a = c.a(paramContext);
    setBackgroundColor(0);
    setOrientation(1);
    this.c = new ImageView(paramContext);
    paramContext = new LinearLayout.LayoutParams(-1, a.C);
    paramContext.gravity = 80;
    addView(this.c, paramContext);
    paramContext = this.a.a(1001);
    if (this.b != null) {
      this.b.setBackgroundDrawable(paramContext);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/widgets/as.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */