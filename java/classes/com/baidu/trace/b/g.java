package com.baidu.trace.b;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.baidu.trace.ax;
import java.io.DataInputStream;

public final class g
  extends Thread
{
  private Context a = null;
  private Handler b = null;
  private boolean c = true;
  private DataInputStream d = null;
  
  public g(Context paramContext, Handler paramHandler)
  {
    this.a = paramContext;
    this.b = paramHandler;
  }
  
  public final void a()
  {
    this.c = false;
  }
  
  public final void run()
  {
    for (;;)
    {
      if (this.c)
      {
        if (!d.a(this.a)) {
          break label92;
        }
        try
        {
          this.d = a.c();
          if ((this.d == null) || (ax.a(this.d))) {
            break label58;
          }
          throw new Exception();
        }
        catch (Exception localException)
        {
          if (this.c) {
            break label66;
          }
        }
      }
      else
      {
        return;
      }
      label58:
      this.d = null;
      continue;
      label66:
      this.c = false;
      if (this.b != null)
      {
        this.b.obtainMessage(4).sendToTarget();
        continue;
        label92:
        this.c = false;
        if (this.b != null) {
          this.b.obtainMessage(19).sendToTarget();
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/b/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */