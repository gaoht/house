package com.unionpay.mobile.android.pro.views;

import android.content.Context;
import com.unionpay.mobile.android.nocard.views.l;
import com.unionpay.mobile.android.plugin.c;
import com.unionpay.mobile.android.pro.pboc.engine.a;
import com.unionpay.mobile.android.utils.j;
import com.unionpay.mobile.android.utils.k;
import org.simalliance.openmobileapi.Reader;
import org.simalliance.openmobileapi.SEService;

public class h
  extends l
{
  public h(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void B()
  {
    StringBuffer localStringBuffer = new StringBuffer("000");
    Object localObject = null;
    com.unionpay.mobile.android.model.b localb = this.a;
    if (com.unionpay.mobile.android.model.b.ba) {
      localObject = new k();
    }
    if ((localObject != null) && (k.a() != null) && (k.a().isConnected()))
    {
      localObject = k.a().getReaders();
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        localb = localObject[i];
        if (localb != null)
        {
          if (localb.getName().toLowerCase().startsWith("sim")) {
            localStringBuffer.setCharAt(0, '1');
          }
          if (localb.getName().toLowerCase().startsWith("ese")) {
            localStringBuffer.setCharAt(1, '1');
          }
          if (localb.getName().toLowerCase().startsWith("sd")) {
            localStringBuffer.setCharAt(2, '1');
          }
        }
        i += 1;
      }
    }
    d(localStringBuffer.toString());
  }
  
  public com.unionpay.mobile.android.pro.pboc.engine.b C()
  {
    return null;
  }
  
  protected final void t()
  {
    try
    {
      Class.forName("org.simalliance.openmobileapi.SEService");
      com.unionpay.mobile.android.model.b localb1 = this.a;
      com.unionpay.mobile.android.model.b.ba = true;
      new k(this.d, this);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      com.unionpay.mobile.android.model.b localb2 = this.a;
      com.unionpay.mobile.android.model.b.ba = false;
      u();
    }
  }
  
  public final void y()
  {
    for (;;)
    {
      try
      {
        j.c("uppay-pro", "checkAndGetSDCardsList +++");
        if ("00".equalsIgnoreCase(this.a.I.c)) {
          break label102;
        }
        if (!"95".equalsIgnoreCase(this.a.I.c)) {
          break label107;
        }
      }
      finally {}
      com.unionpay.mobile.android.pro.pboc.engine.b localb = C();
      i locali = new i(this);
      if (localb != null)
      {
        C().a(locali, bool);
        j.c("uppay-pro", "checkAndGetSDCardsList ---");
        return;
      }
      locali.a(null);
      continue;
      label102:
      boolean bool = true;
      continue;
      label107:
      bool = false;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/pro/views/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */