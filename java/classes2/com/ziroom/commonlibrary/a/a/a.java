package com.ziroom.commonlibrary.a.a;

import android.content.Context;
import com.freelxl.baselibrary.f.g;
import com.ziroom.commonlibrary.a.b;

public class a<T>
  extends com.freelxl.baselibrary.d.c.a<T>
{
  protected Context b;
  
  public a(Context paramContext, com.freelxl.baselibrary.d.f.a<T> parama)
  {
    super(parama);
    this.b = paramContext;
  }
  
  public void onFailure(Throwable paramThrowable)
  {
    if ((paramThrowable instanceof com.freelxl.baselibrary.d.d.a)) {
      g.textToast(this.b, paramThrowable.getMessage());
    }
    while ((paramThrowable instanceof b)) {
      return;
    }
    g.textToast(this.b, "服务器请求异常！");
  }
  
  public void onSuccess(int paramInt, T paramT) {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/commonlibrary/a/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */