package com.ziroom.ziroomcustomer.ziroomapartment.a;

import android.content.Context;
import com.freelxl.baselibrary.f.g;
import com.ziroom.commonlibrary.a.b;

public class d<T>
  extends com.ziroom.commonlibrary.a.a<T>
{
  public d(Context paramContext, com.freelxl.baselibrary.d.f.a<T> parama)
  {
    super(paramContext, parama);
  }
  
  public void onFailure(Throwable paramThrowable)
  {
    super.onFailure(paramThrowable);
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
    g.textToast(this.b, "服务器请求异常！");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */