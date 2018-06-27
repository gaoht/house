package org.greenrobot.eventbus;

final class i
{
  private h a;
  private h b;
  
  h a()
  {
    try
    {
      h localh = this.a;
      if (this.a != null)
      {
        this.a = this.a.c;
        if (this.a == null) {
          this.b = null;
        }
      }
      return localh;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  h a(int paramInt)
    throws InterruptedException
  {
    try
    {
      if (this.a == null) {
        wait(paramInt);
      }
      h localh = a();
      return localh;
    }
    finally {}
  }
  
  void a(h paramh)
  {
    if (paramh == null) {
      try
      {
        throw new NullPointerException("null cannot be enqueued");
      }
      finally {}
    }
    if (this.b != null)
    {
      this.b.c = paramh;
      this.b = paramh;
    }
    for (;;)
    {
      notifyAll();
      return;
      if (this.a != null) {
        break;
      }
      this.b = paramh;
      this.a = paramh;
    }
    throw new IllegalStateException("Head present, but no tail");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/org/greenrobot/eventbus/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */