package com.ziroom.commonlibrary.a;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;

public class a<T>
  extends com.freelxl.baselibrary.d.c.a<T>
{
  protected Context b;
  
  public a(Context paramContext, com.freelxl.baselibrary.d.f.a<T> parama)
  {
    super(parama);
    this.b = paramContext;
  }
  
  public void dismissProgress()
  {
    if (this.b == null) {}
    while ((com.freelxl.baselibrary.widget.a.getDialog() == null) || (!com.freelxl.baselibrary.widget.a.isShowing())) {
      return;
    }
    com.freelxl.baselibrary.widget.a.dismiss();
  }
  
  public void onFailure(Throwable paramThrowable)
  {
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
    dismissProgress();
  }
  
  public boolean showProgress()
  {
    if (this.b == null) {
      return false;
    }
    if ((com.freelxl.baselibrary.widget.a.getDialog() != null) && (com.freelxl.baselibrary.widget.a.isShowing()) && ((this.b instanceof Activity))) {
      com.freelxl.baselibrary.widget.a.dismiss();
    }
    com.freelxl.baselibrary.widget.a.show(this.b, null, false, true);
    return true;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/commonlibrary/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */