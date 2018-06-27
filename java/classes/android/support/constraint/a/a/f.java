package android.support.constraint.a.a;

public class f
{
  public int a;
  public int b;
  public int c;
  public int d;
  
  void a(int paramInt1, int paramInt2)
  {
    this.a -= paramInt1;
    this.b -= paramInt2;
    this.c += paramInt1 * 2;
    this.d += paramInt2 * 2;
  }
  
  boolean a(f paramf)
  {
    return (this.a >= paramf.a) && (this.a < paramf.a + paramf.c) && (this.b >= paramf.b) && (this.b < paramf.b + paramf.d);
  }
  
  public boolean contains(int paramInt1, int paramInt2)
  {
    return (paramInt1 >= this.a) && (paramInt1 < this.a + this.c) && (paramInt2 >= this.b) && (paramInt2 < this.b + this.d);
  }
  
  public int getCenterX()
  {
    return (this.a + this.c) / 2;
  }
  
  public int getCenterY()
  {
    return (this.b + this.d) / 2;
  }
  
  public void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/constraint/a/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */