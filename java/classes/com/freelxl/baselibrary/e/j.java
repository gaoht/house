package com.freelxl.baselibrary.e;

public class j<T>
  implements Runnable
{
  private final k a;
  private final i.a<T> b;
  
  public j(k paramk, i.a<T> parama)
  {
    this.a = paramk;
    this.b = parama;
  }
  
  public void run()
  {
    this.b.onSuccess(this.a);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/freelxl/baselibrary/e/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */