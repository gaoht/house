package com.g.a;

class bb
  implements Runnable
{
  bb(ba paramba) {}
  
  public void run()
  {
    try
    {
      this.a.g = System.currentTimeMillis();
      if (this.a.g - this.a.h > ba.a(this.a))
      {
        this.a.h = this.a.g;
        this.a.d = ba.b(this.a);
        if (this.a.d == null)
        {
          ba.c(this.a);
          this.a.d = ba.d(this.a);
        }
        this.a.e = ba.d(this.a);
        if (this.a.d != null)
        {
          if (this.a.e == null) {
            return;
          }
          if (this.a.a.a(this.a.d, this.a.e) < 0.8D)
          {
            ba.c(this.a);
            return;
          }
        }
      }
    }
    catch (Throwable localThrowable)
    {
      av.postSDKError(localThrowable);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/g/a/bb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */