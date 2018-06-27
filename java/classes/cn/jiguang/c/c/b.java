package cn.jiguang.c.c;

public final class b
{
  private c[] a = new c[17];
  
  public final int a(j paramj)
  {
    int j = paramj.hashCode();
    int i = -1;
    for (c localc = this.a[((j & 0x7FFFFFFF) % 17)]; localc != null; localc = localc.c) {
      if (localc.a.equals(paramj)) {
        i = localc.b;
      }
    }
    return i;
  }
  
  public final void a(int paramInt, j paramj)
  {
    if (paramInt > 16383) {
      return;
    }
    int i = (paramj.hashCode() & 0x7FFFFFFF) % 17;
    c localc = new c((byte)0);
    localc.a = paramj;
    localc.b = paramInt;
    localc.c = this.a[i];
    this.a[i] = localc;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/c/c/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */