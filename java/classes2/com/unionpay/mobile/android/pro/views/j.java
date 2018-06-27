package com.unionpay.mobile.android.pro.views;

import android.content.Context;
import com.unionpay.mobile.android.hce.f;
import com.unionpay.mobile.android.pro.pboc.engine.b;
import com.unionpay.uppay.PayActivity;

public final class j
  extends h
{
  public j(Context paramContext)
  {
    super(paramContext);
  }
  
  public final b C()
  {
    Object localObject = ((PayActivity)this.d).a(b.class.toString());
    if (localObject != null) {
      return (b)localObject;
    }
    return null;
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString1, String paramString2, int paramInt3, String paramString3)
  {
    Object localObject = ((PayActivity)this.d).a(f.class.toString());
    if (localObject != null)
    {
      localObject = (f)localObject;
      ((f)localObject).a();
      ((f)localObject).a(paramInt1);
      ((f)localObject).b(paramInt2);
      ((f)localObject).a(paramString1);
      ((f)localObject).b(paramString2);
      ((f)localObject).c(paramString3);
      ((f)localObject).c(paramInt3);
      ((f)localObject).c();
    }
  }
  
  public final boolean v()
  {
    return true;
  }
  
  public final boolean w()
  {
    return true;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/pro/views/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */