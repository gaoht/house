package com.baidu.trace.b;

import android.os.Handler;
import android.os.Message;

public class e
{
  e(f paramf) {}
  
  public void a()
  {
    f.a(this.a, false);
    f.a(this.a).obtainMessage(1).sendToTarget();
  }
  
  public void b()
  {
    if (f.b(this.a) > 0)
    {
      this.a.b();
      return;
    }
    f.a(this.a, false);
    f.a(this.a).obtainMessage(19).sendToTarget();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/b/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */