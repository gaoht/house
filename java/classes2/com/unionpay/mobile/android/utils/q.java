package com.unionpay.mobile.android.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.unionpay.mobile.android.net.c;
import com.unionpay.mobile.android.net.d;
import java.lang.ref.WeakReference;

public final class q
  implements Handler.Callback, Runnable
{
  private d a = null;
  private Handler b = null;
  private WeakReference<a> c = null;
  private Context d;
  
  public q(Context paramContext, String paramString, a parama)
  {
    this.a = new d(0, paramString, null);
    this.b = new Handler(this);
    this.c = new WeakReference(parama);
    this.d = paramContext;
  }
  
  public final void a()
  {
    new Thread(this).start();
  }
  
  public final boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return true;
    } while ((this.c == null) || (this.c.get() == null));
    if (paramMessage.obj != null) {}
    for (byte[] arrayOfByte = (byte[])paramMessage.obj;; arrayOfByte = null)
    {
      ((a)this.c.get()).a(paramMessage.arg1, arrayOfByte);
      break;
    }
  }
  
  public final void run()
  {
    c localc = new c(this.a, this.d);
    int i = localc.a();
    if (this.b != null)
    {
      Message localMessage = this.b.obtainMessage();
      localMessage.what = 0;
      localMessage.arg1 = i;
      localMessage.obj = localc.b();
      this.b.sendMessage(localMessage);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt, byte[] paramArrayOfByte);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/utils/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */