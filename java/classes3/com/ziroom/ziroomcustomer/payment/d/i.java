package com.ziroom.ziroomcustomer.payment.d;

import android.content.Context;
import com.freelxl.baselibrary.f.g;
import com.ziroom.commonlibrary.a.b;

public class i<T>
  extends com.ziroom.commonlibrary.a.a<T>
{
  private boolean c = true;
  
  public i(Context paramContext, com.freelxl.baselibrary.d.f.a<T> parama)
  {
    super(paramContext, parama);
  }
  
  public i(Context paramContext, com.freelxl.baselibrary.d.f.a<T> parama, boolean paramBoolean)
  {
    super(paramContext, parama);
    this.c = paramBoolean;
  }
  
  public void onFailure(Throwable paramThrowable)
  {
    if (this.c) {
      super.onFailure(paramThrowable);
    }
    if ((paramThrowable instanceof com.freelxl.baselibrary.d.d.a))
    {
      g.textToast(this.b, paramThrowable.getMessage());
      return;
    }
    if ((paramThrowable instanceof b))
    {
      g.textToast(this.b, paramThrowable.getMessage());
      return;
    }
    g.textToast(this.b, "网络请求失败，请检查网络连接！");
  }
  
  public void onStart()
  {
    super.onStart();
    if (this.c) {
      showProgress();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/payment/d/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */