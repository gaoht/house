package com.unionpay.mobile.android.pro.views;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import com.unionpay.mobile.android.hce.c;
import com.unionpay.mobile.android.hce.f;
import com.unionpay.mobile.android.model.e;
import com.unionpay.mobile.android.nocard.views.ao;
import com.unionpay.uppay.PayActivity;
import java.util.Iterator;
import java.util.List;

public final class u
  extends ao
{
  public u(Context paramContext, e parame)
  {
    super(paramContext, parame);
  }
  
  protected final void a(Handler paramHandler)
  {
    Object localObject = ((PayActivity)this.d).a(f.class.toString());
    if (localObject != null) {
      ((f)localObject).a(paramHandler);
    }
  }
  
  protected final void d(String paramString1, String paramString2)
  {
    if (com.unionpay.mobile.android.model.b.bm) {
      a(this.a.ap, false);
    }
    Object localObject;
    do
    {
      return;
      localObject = ((PayActivity)this.d).a(com.unionpay.mobile.android.pro.pboc.engine.b.class.toString());
    } while (localObject == null);
    ((com.unionpay.mobile.android.pro.pboc.engine.b)localObject).a(new Handler(new v(this)), paramString1, paramString2);
  }
  
  protected final boolean v()
  {
    return true;
  }
  
  protected final void w()
  {
    if (com.unionpay.mobile.android.model.b.bb != null)
    {
      Iterator localIterator = com.unionpay.mobile.android.model.b.bb.iterator();
      while (localIterator.hasNext())
      {
        ServiceConnection localServiceConnection = ((c)localIterator.next()).h();
        try
        {
          this.d.unbindService(localServiceConnection);
        }
        catch (IllegalArgumentException localIllegalArgumentException) {}
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/pro/views/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */