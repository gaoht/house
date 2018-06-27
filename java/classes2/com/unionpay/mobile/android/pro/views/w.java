package com.unionpay.mobile.android.pro.views;

import android.content.Context;
import com.unionpay.mobile.android.model.e;
import com.unionpay.mobile.android.pro.pboc.engine.b;
import com.unionpay.uppay.PayActivity;

public final class w
  extends x
{
  public w(Context paramContext, e parame)
  {
    super(paramContext, parame);
  }
  
  public final b u()
  {
    Object localObject = ((PayActivity)this.d).a(b.class.toString());
    if (localObject != null) {
      return (b)localObject;
    }
    return null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/pro/views/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */