package com.megvii.zhimasdk.b.a.a;

import java.util.Queue;

public class h
{
  private b a = b.a;
  private c b;
  private g c;
  private m d;
  private Queue<a> e;
  
  public void a()
  {
    this.a = b.a;
    this.e = null;
    this.b = null;
    this.c = null;
    this.d = null;
  }
  
  public void a(b paramb)
  {
    if (paramb != null) {}
    for (;;)
    {
      this.a = paramb;
      return;
      paramb = b.a;
    }
  }
  
  @Deprecated
  public void a(c paramc)
  {
    if (paramc == null)
    {
      a();
      return;
    }
    this.b = paramc;
  }
  
  public void a(c paramc, m paramm)
  {
    com.megvii.zhimasdk.b.a.o.a.a(paramc, "Auth scheme");
    com.megvii.zhimasdk.b.a.o.a.a(paramm, "Credentials");
    this.b = paramc;
    this.d = paramm;
    this.e = null;
  }
  
  @Deprecated
  public void a(m paramm)
  {
    this.d = paramm;
  }
  
  public void a(Queue<a> paramQueue)
  {
    com.megvii.zhimasdk.b.a.o.a.a(paramQueue, "Queue of auth options");
    this.e = paramQueue;
    this.b = null;
    this.d = null;
  }
  
  public b b()
  {
    return this.a;
  }
  
  public c c()
  {
    return this.b;
  }
  
  public m d()
  {
    return this.d;
  }
  
  public Queue<a> e()
  {
    return this.e;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("web_state:").append(this.a).append(";");
    if (this.b != null) {
      localStringBuilder.append("auth scheme:").append(this.b.a()).append(";");
    }
    if (this.d != null) {
      localStringBuilder.append("credentials present");
    }
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/megvii/zhimasdk/b/a/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */