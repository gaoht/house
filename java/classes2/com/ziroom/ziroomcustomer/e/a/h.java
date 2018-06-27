package com.ziroom.ziroomcustomer.e.a;

import android.content.Context;
import com.freelxl.baselibrary.f.g;
import com.ziroom.commonlibrary.a.b;

public class h<T>
  extends com.ziroom.commonlibrary.a.a<T>
{
  public h(Context paramContext, com.freelxl.baselibrary.d.f.a<T> parama)
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
    g.textToast(this.b, "网络请求失败，请检查网络连接！");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/e/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */