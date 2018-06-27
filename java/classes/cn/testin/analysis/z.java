package cn.testin.analysis;

import java.util.List;

class z
  implements Runnable
{
  z(y paramy) {}
  
  public void run()
  {
    synchronized (u.a(this.a.a))
    {
      u.a(this.a.a).remove(this.a);
    }
    synchronized (this.a)
    {
      if (y.b(this.a) != null)
      {
        u.a(this.a.a, y.b(this.a), false);
        y.a(this.a, null);
      }
      y.a(this.a);
      return;
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */