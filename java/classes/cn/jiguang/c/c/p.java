package cn.jiguang.c.c;

public final class p
  extends m
{
  private int e;
  private int f;
  private int g;
  private j h;
  
  final String a()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(this.e + " ");
    localStringBuffer.append(this.f + " ");
    localStringBuffer.append(this.g + " ");
    localStringBuffer.append(this.h);
    return localStringBuffer.toString();
  }
  
  final void a(d paramd)
  {
    this.e = paramd.g();
    this.f = paramd.g();
    this.g = paramd.g();
    this.h = new j(paramd);
  }
  
  final void a(e parame, boolean paramBoolean)
  {
    parame.c(this.e);
    parame.c(this.f);
    parame.c(this.g);
    this.h.a(parame, null, true);
  }
  
  public final int h()
  {
    return this.g;
  }
  
  public final j i()
  {
    return this.h;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/c/c/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */