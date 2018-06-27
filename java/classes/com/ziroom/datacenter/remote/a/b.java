package com.ziroom.datacenter.remote.a;

import android.content.Context;
import android.os.Handler;
import com.ziroom.commonlib.utils.s;
import com.ziroom.commonlib.ziroomhttp.d.c;
import java.io.IOException;
import java.net.UnknownHostException;

public class b<T>
  extends com.ziroom.commonlib.ziroomhttp.c.a<T>
{
  private com.ziroom.datacenter.remote.b.a b;
  protected com.ziroom.datacenter.remote.a c;
  
  @Deprecated
  public b(Context paramContext, com.ziroom.datacenter.remote.b.a parama, com.ziroom.commonlib.ziroomhttp.f.a<T> parama1)
  {
    super(parama1);
    this.b = parama;
  }
  
  public b(com.ziroom.commonlib.ziroomhttp.f.a<T> parama)
  {
    super(parama);
  }
  
  public b(com.ziroom.commonlib.ziroomhttp.f.a<T> parama, com.ziroom.datacenter.remote.b.a parama1, com.ziroom.datacenter.remote.a parama2)
  {
    super(parama);
    this.b = parama1;
    this.c = parama2;
  }
  
  public b(com.ziroom.datacenter.remote.b.a parama, com.ziroom.commonlib.ziroomhttp.f.a<T> parama1)
  {
    super(parama1);
    this.b = parama;
  }
  
  protected void a(Throwable paramThrowable, String paramString)
  {
    if ((this.b == null) || (!this.b.onHandleMessage(paramThrowable, paramString))) {
      s.showToast(paramString);
    }
  }
  
  public void onFailure(Throwable paramThrowable)
  {
    if (((paramThrowable instanceof com.ziroom.commonlib.ziroomhttp.d.b)) || ((paramThrowable instanceof com.ziroom.commonlib.ziroomhttp.d.a))) {
      a(paramThrowable, paramThrowable.getMessage());
    }
    c localc;
    do
    {
      do
      {
        return;
      } while (((paramThrowable instanceof IOException)) && ("Canceled".equals(paramThrowable.getMessage())));
      if (!(paramThrowable instanceof c)) {
        break;
      }
      localc = (c)paramThrowable;
      a(paramThrowable, paramThrowable.getMessage());
    } while (localc.getCode() != -1);
    com.ziroom.commonlib.ziroomhttp.b.handleMessage("40005");
    return;
    if ((paramThrowable instanceof UnknownHostException))
    {
      a(paramThrowable, "网络请求失败，请检查网络连接");
      return;
    }
    a(paramThrowable, "服务器请求异常！");
  }
  
  public void onStart()
  {
    super.onStart();
    if (this.b != null) {
      a.post(new b.1(this));
    }
  }
  
  public void onSuccess(int paramInt, T paramT) {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/ziroom/datacenter/remote/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */