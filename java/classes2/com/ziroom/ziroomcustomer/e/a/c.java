package com.ziroom.ziroomcustomer.e.a;

import android.content.Context;
import com.freelxl.baselibrary.f.g;
import com.ziroom.commonlibrary.a.b;

public class c<T>
  extends com.ziroom.commonlibrary.a.a<T>
{
  public c(Context paramContext, com.freelxl.baselibrary.d.f.a parama)
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
    if (((paramThrowable instanceof b)) || ((paramThrowable instanceof com.ziroom.ziroomcustomer.e.b.a)))
    {
      g.textToast(this.b, paramThrowable.getMessage());
      return;
    }
    g.textToast(this.b, "服务器请求异常！");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/e/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */