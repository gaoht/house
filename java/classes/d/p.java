package d;

import javax.annotation.Nullable;

final class p
{
  final byte[] a;
  int b;
  int c;
  boolean d;
  boolean e;
  p f;
  p g;
  
  p()
  {
    this.a = new byte[' '];
    this.e = true;
    this.d = false;
  }
  
  p(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.a = paramArrayOfByte;
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramBoolean1;
    this.e = paramBoolean2;
  }
  
  p a()
  {
    this.d = true;
    return new p(this.a, this.b, this.c, true, false);
  }
  
  p b()
  {
    return new p((byte[])this.a.clone(), this.b, this.c, false, true);
  }
  
  public void compact()
  {
    if (this.g == this) {
      throw new IllegalStateException();
    }
    if (!this.g.e) {}
    for (;;)
    {
      return;
      int j = this.c - this.b;
      int k = this.g.c;
      if (this.g.d) {}
      for (int i = 0; j <= i + (8192 - k); i = this.g.b)
      {
        writeTo(this.g, j);
        pop();
        q.a(this);
        return;
      }
    }
  }
  
  @Nullable
  public p pop()
  {
    if (this.f != this) {}
    for (p localp = this.f;; localp = null)
    {
      this.g.f = this.f;
      this.f.g = this.g;
      this.f = null;
      this.g = null;
      return localp;
    }
  }
  
  public p push(p paramp)
  {
    paramp.g = this;
    paramp.f = this.f;
    this.f.g = paramp;
    this.f = paramp;
    return paramp;
  }
  
  public p split(int paramInt)
  {
    if ((paramInt <= 0) || (paramInt > this.c - this.b)) {
      throw new IllegalArgumentException();
    }
    p localp;
    if (paramInt >= 1024) {
      localp = a();
    }
    for (;;)
    {
      localp.c = (localp.b + paramInt);
      this.b += paramInt;
      this.g.push(localp);
      return localp;
      localp = q.a();
      System.arraycopy(this.a, this.b, localp.a, 0, paramInt);
    }
  }
  
  public void writeTo(p paramp, int paramInt)
  {
    if (!paramp.e) {
      throw new IllegalArgumentException();
    }
    if (paramp.c + paramInt > 8192)
    {
      if (paramp.d) {
        throw new IllegalArgumentException();
      }
      if (paramp.c + paramInt - paramp.b > 8192) {
        throw new IllegalArgumentException();
      }
      System.arraycopy(paramp.a, paramp.b, paramp.a, 0, paramp.c - paramp.b);
      paramp.c -= paramp.b;
      paramp.b = 0;
    }
    System.arraycopy(this.a, this.b, paramp.a, paramp.c, paramInt);
    paramp.c += paramInt;
    this.b += paramInt;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/d/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */