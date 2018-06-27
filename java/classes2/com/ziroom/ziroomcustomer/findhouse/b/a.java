package com.ziroom.ziroomcustomer.findhouse.b;

import android.content.Context;
import android.util.Log;
import com.freelxl.baselibrary.f.d;
import com.freelxl.baselibrary.f.g;
import com.ziroom.commonlibrary.a.b;

public class a<T>
  extends com.ziroom.commonlibrary.a.a<T>
{
  public a(Context paramContext, com.freelxl.baselibrary.d.f.a<T> parama)
  {
    super(paramContext, parama);
  }
  
  public void onFailure(Throwable paramThrowable)
  {
    super.onFailure(paramThrowable);
    if ((paramThrowable instanceof com.freelxl.baselibrary.d.d.a))
    {
      d.d("findHouse", "=======http " + ((com.freelxl.baselibrary.d.d.a)paramThrowable).getStatusCode());
      g.textToast(this.b.getApplicationContext(), "服务器异常，正在努力抢修中，请稍后再试!");
    }
    do
    {
      return;
      if (!(paramThrowable instanceof b)) {
        break;
      }
      paramThrowable = (b)paramThrowable;
      d.d("findHouse", "=======ServiceException: " + paramThrowable.getMessage());
      g.textToast(this.b.getApplicationContext(), paramThrowable.getMessage());
    } while (paramThrowable.getCode() == -1);
    g.textToast(this.b, paramThrowable.getMessage());
    return;
    d.d("findHouse", "=======e:" + Log.getStackTraceString(paramThrowable));
    paramThrowable.printStackTrace();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */