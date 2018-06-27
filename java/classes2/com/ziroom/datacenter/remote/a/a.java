package com.ziroom.datacenter.remote.a;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;

public class a<T>
  extends b<T>
{
  protected Context b;
  
  public a(Context paramContext, com.ziroom.commonlib.ziroomhttp.f.a<T> parama)
  {
    super(parama);
    this.b = paramContext;
  }
  
  public a(Context paramContext, com.ziroom.datacenter.remote.b.a parama, com.ziroom.commonlib.ziroomhttp.f.a<T> parama1)
  {
    super(parama, parama1);
    this.b = paramContext;
  }
  
  public a(Context paramContext, com.ziroom.datacenter.remote.b.a parama, com.ziroom.commonlib.ziroomhttp.f.a<T> parama1, com.ziroom.datacenter.remote.a parama2)
  {
    super(parama1, parama, parama2);
    this.b = paramContext;
  }
  
  public void dismissProgress()
  {
    if (this.b == null) {}
    while (((this.c != null) && (!this.c.isShowProgress())) || (com.ziroom.commonlib.ziroomui.a.getDialog() == null) || (!com.ziroom.commonlib.ziroomui.a.isShowing())) {
      return;
    }
    com.ziroom.commonlib.ziroomui.a.dismiss();
  }
  
  public void onFailure(Throwable paramThrowable)
  {
    super.onFailure(paramThrowable);
    dismissProgress();
  }
  
  public void onStart()
  {
    super.onStart();
    a.post(new Runnable()
    {
      public void run()
      {
        a.this.showProgress();
      }
    });
  }
  
  public void onSuccess(int paramInt, T paramT)
  {
    super.onSuccess(paramInt, paramT);
    dismissProgress();
  }
  
  public boolean showProgress()
  {
    if (this.b == null) {}
    while ((this.c != null) && (!this.c.isShowProgress())) {
      return false;
    }
    if ((com.ziroom.commonlib.ziroomui.a.getDialog() != null) && (com.ziroom.commonlib.ziroomui.a.isShowing()) && ((this.b instanceof Activity))) {
      com.ziroom.commonlib.ziroomui.a.dismiss();
    }
    com.ziroom.commonlib.ziroomui.a.show(this.b, null, false, true);
    return true;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/datacenter/remote/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */