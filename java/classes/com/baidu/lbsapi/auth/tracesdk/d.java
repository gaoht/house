package com.baidu.lbsapi.auth.tracesdk;

class d
  implements Runnable
{
  d(c paramc) {}
  
  public void run()
  {
    a.a("postWithHttps start Thread id = " + String.valueOf(Thread.currentThread().getId()));
    String str = new g(c.a(this.a)).a(c.b(this.a));
    c.a(this.a, str);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/lbsapi/auth/tracesdk/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */