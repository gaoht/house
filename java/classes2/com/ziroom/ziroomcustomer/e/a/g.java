package com.ziroom.ziroomcustomer.e.a;

import com.ziroom.commonlibrary.a.b;
import com.ziroom.ziroomcustomer.util.u;

public class g<T>
  extends com.freelxl.baselibrary.d.c.a<T>
{
  public g(com.freelxl.baselibrary.d.f.a<T> parama)
  {
    super(parama);
  }
  
  public void onFailure(Throwable paramThrowable)
  {
    if ((paramThrowable instanceof com.freelxl.baselibrary.d.d.a))
    {
      u.i("PushFeedback", paramThrowable.getMessage());
      return;
    }
    if (((paramThrowable instanceof b)) || ((paramThrowable instanceof com.ziroom.ziroomcustomer.e.b.a)))
    {
      u.i("PushFeedback", paramThrowable.getMessage());
      return;
    }
    u.i("PushFeedback", "服务器请求异常！");
    u.i("PushFeedback", paramThrowable.getMessage());
  }
  
  public void onSuccess(int paramInt, T paramT) {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/e/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */