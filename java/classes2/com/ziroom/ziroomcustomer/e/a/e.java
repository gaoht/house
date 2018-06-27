package com.ziroom.ziroomcustomer.e.a;

import android.content.Context;
import com.freelxl.baselibrary.f.g;
import com.ziroom.commonlibrary.a.b;
import java.io.IOException;

public class e<T>
  extends com.freelxl.baselibrary.d.c.a<T>
{
  protected Context e;
  
  public e(Context paramContext, com.freelxl.baselibrary.d.f.a<T> parama)
  {
    super(parama);
    this.e = paramContext;
  }
  
  public void onFailure(Throwable paramThrowable)
  {
    if ((paramThrowable instanceof com.freelxl.baselibrary.d.d.a)) {
      g.textToast(this.e, paramThrowable.getMessage());
    }
    do
    {
      return;
      if ((paramThrowable instanceof b))
      {
        g.textToast(this.e, paramThrowable.getMessage());
        return;
      }
      if ((paramThrowable instanceof com.ziroom.ziroomcustomer.e.b.a))
      {
        g.textToast(this.e, paramThrowable.getMessage());
        return;
      }
    } while (((paramThrowable instanceof IOException)) && ("Canceled".equals(paramThrowable.getMessage())));
    g.textToast(this.e, "服务器请求异常！");
  }
  
  public void onSuccess(int paramInt, T paramT) {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/e/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */