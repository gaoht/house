package com.ziroom.ziroomcustomer.e.a;

import android.content.Context;
import com.freelxl.baselibrary.f.g;

public class b<T>
  extends com.freelxl.baselibrary.d.c.a<T>
{
  protected Context d;
  
  public b(Context paramContext, com.freelxl.baselibrary.d.f.a<T> parama)
  {
    super(parama);
    this.d = paramContext;
  }
  
  public void onFailure(Throwable paramThrowable)
  {
    if ((paramThrowable instanceof com.freelxl.baselibrary.d.d.a))
    {
      g.textToast(this.d, paramThrowable.getMessage());
      return;
    }
    if (((paramThrowable instanceof com.ziroom.commonlibrary.a.b)) || ((paramThrowable instanceof com.ziroom.ziroomcustomer.e.b.a)))
    {
      g.textToast(this.d, paramThrowable.getMessage());
      return;
    }
    g.textToast(this.d, "服务器请求异常！");
  }
  
  public void onSuccess(int paramInt, T paramT) {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/e/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */