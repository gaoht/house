package cn.testin.analysis;

class bj
  implements Runnable
{
  bj(bd parambd) {}
  
  public void run()
  {
    try
    {
      Thread.sleep(1000L);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      ar.a(localInterruptedException);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/bj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */