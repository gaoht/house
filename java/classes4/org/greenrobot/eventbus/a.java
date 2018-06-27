package org.greenrobot.eventbus;

import java.util.concurrent.ExecutorService;

class a
  implements Runnable
{
  private final i a;
  private final c b;
  
  a(c paramc)
  {
    this.b = paramc;
    this.a = new i();
  }
  
  public void enqueue(n paramn, Object paramObject)
  {
    paramn = h.a(paramn, paramObject);
    this.a.a(paramn);
    this.b.a().execute(this);
  }
  
  public void run()
  {
    h localh = this.a.a();
    if (localh == null) {
      throw new IllegalStateException("No pending post available");
    }
    this.b.a(localh);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/org/greenrobot/eventbus/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */