package com.baidu.trace.b;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.baidu.trace.az;
import com.baidu.trace.c.e;
import com.baidu.trace.c.f.a;

public final class i
  extends Thread
{
  private Context a = null;
  private Handler b = null;
  private byte[] c = null;
  private f.a d = null;
  
  public i(Context paramContext, Handler paramHandler, byte[] paramArrayOfByte, f.a parama)
  {
    this.a = paramContext;
    this.b = paramHandler;
    this.c = paramArrayOfByte;
    this.d = parama;
  }
  
  public final void run()
  {
    if (d.a(this.a)) {
      if ((this.c != null) && (this.c.length > 0)) {
        if (this.d != null)
        {
          if (f.a.a != this.d) {
            break label72;
          }
          az.a = e.a();
        }
      }
    }
    label72:
    while (this.b == null) {
      for (;;)
      {
        az.a(this.d);
        a.a(this.c, this.b);
        this.c = null;
        return;
        if (f.a.b == this.d) {
          az.b = e.a();
        }
      }
    }
    this.b.obtainMessage(19).sendToTarget();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/b/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */