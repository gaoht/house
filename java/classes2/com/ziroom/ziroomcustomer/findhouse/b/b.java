package com.ziroom.ziroomcustomer.findhouse.b;

import android.content.Context;
import android.util.Log;
import com.freelxl.baselibrary.f.d;
import com.freelxl.baselibrary.f.g;

public class b<T>
  extends com.freelxl.baselibrary.d.c.a<T>
{
  protected Context c;
  
  public b(Context paramContext, com.freelxl.baselibrary.d.f.a<T> parama)
  {
    super(parama);
    this.c = paramContext;
  }
  
  public void onFailure(Throwable paramThrowable)
  {
    if ((paramThrowable instanceof com.freelxl.baselibrary.d.d.a))
    {
      d.d("findHouse", "=======http " + ((com.freelxl.baselibrary.d.d.a)paramThrowable).getStatusCode());
      g.textToast(this.c.getApplicationContext(), "服务器异常，正在努力抢修中，请稍后再试!");
    }
    do
    {
      return;
      if (!(paramThrowable instanceof com.ziroom.commonlibrary.a.b)) {
        break;
      }
      paramThrowable = (com.ziroom.commonlibrary.a.b)paramThrowable;
      d.d("findHouse", "=======ServiceException: " + paramThrowable.getMessage());
      g.textToast(this.c.getApplicationContext(), paramThrowable.getMessage());
    } while (paramThrowable.getCode() == -1);
    g.textToast(this.c, paramThrowable.getMessage());
    return;
    d.d("findHouse", "=======e:" + Log.getStackTraceString(paramThrowable));
    paramThrowable.printStackTrace();
  }
  
  public void onSuccess(int paramInt, T paramT) {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */