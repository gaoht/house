package com.ziroom.commonlibrary.a.a;

import android.content.Context;
import com.freelxl.baselibrary.f.g;

public class b<T>
  extends com.ziroom.commonlibrary.a.a<T>
{
  public b(Context paramContext, com.freelxl.baselibrary.d.f.a parama)
  {
    super(paramContext, parama);
  }
  
  public void onFailure(Throwable paramThrowable)
  {
    super.onFailure(paramThrowable);
    if ((paramThrowable instanceof com.freelxl.baselibrary.d.d.a)) {
      g.textToast(this.b, paramThrowable.getMessage());
    }
    while ((paramThrowable instanceof com.ziroom.commonlibrary.a.b)) {
      return;
    }
    g.textToast(this.b, "服务器请求异常！");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/commonlibrary/a/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */