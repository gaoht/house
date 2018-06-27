package com.ziroom.ziroomcustomer.minsu.landlord.d;

import android.content.Context;
import com.freelxl.baselibrary.f.g;
import java.net.UnknownHostException;

public class a<T>
  extends com.ziroom.commonlibrary.a.a<T>
{
  public a(Context paramContext, com.freelxl.baselibrary.d.f.a parama)
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
    if ((paramThrowable instanceof com.ziroom.ziroomcustomer.e.b.a))
    {
      ((com.ziroom.ziroomcustomer.e.b.a)paramThrowable).getCode();
      g.textToast(this.b, paramThrowable.getMessage());
      return;
    }
    if ((paramThrowable instanceof UnknownHostException))
    {
      g.textToast(this.b, "网络请求失败，请检查网络连接");
      return;
    }
    g.textToast(this.b, "服务器请求异常！");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlord/d/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */