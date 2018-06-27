package com.mato.sdk.f;

public final class i
{
  public final void a(e<?> parame, h<?> paramh)
  {
    new a(parame, paramh).run();
  }
  
  public final void a(e<?> parame, Throwable paramThrowable)
  {
    a(parame, h.a(paramThrowable));
  }
  
  final class a
    implements Runnable
  {
    private final e a;
    private final h b;
    
    public a(e parame, h paramh)
    {
      this.a = parame;
      this.b = paramh;
    }
    
    public final void run()
    {
      if (this.b.b == null) {}
      for (int i = 1; i != 0; i = 0)
      {
        this.a.a(this.b.a);
        return;
      }
      this.a.a(this.b.b);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/f/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */