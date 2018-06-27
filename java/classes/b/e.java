package b;

import java.io.Closeable;

public class e
  implements Closeable
{
  private final Object a = new Object();
  private f b;
  private Runnable c;
  private boolean d;
  
  e(f paramf, Runnable paramRunnable)
  {
    this.b = paramf;
    this.c = paramRunnable;
  }
  
  private void b()
  {
    if (this.d) {
      throw new IllegalStateException("Object already closed");
    }
  }
  
  void a()
  {
    synchronized (this.a)
    {
      b();
      this.c.run();
      close();
      return;
    }
  }
  
  public void close()
  {
    synchronized (this.a)
    {
      if (this.d) {
        return;
      }
      this.d = true;
      this.b.a(this);
      this.b = null;
      this.c = null;
      return;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/b/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */