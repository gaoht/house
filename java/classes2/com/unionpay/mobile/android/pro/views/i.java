package com.unionpay.mobile.android.pro.views;

import com.unionpay.mobile.android.model.c;
import com.unionpay.mobile.android.pro.pboc.engine.a;
import com.unionpay.mobile.android.utils.j;
import java.util.ArrayList;
import java.util.List;

final class i
  implements a
{
  i(h paramh) {}
  
  public final void a(ArrayList<c> paramArrayList)
  {
    j.a("uppay", "deviceReady +++");
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      if (this.a.s == null) {
        this.a.s = new ArrayList(paramArrayList.size());
      }
      this.a.s.addAll(paramArrayList);
    }
    h.a(this.a);
    j.a("uppay", "deviceReady ---");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/pro/views/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */