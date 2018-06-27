package cn.testin.analysis;

class bx
{
  private final int[] a = new int['Ā'];
  private int b = 0;
  
  public int a(int paramInt)
  {
    return this.a[paramInt];
  }
  
  public boolean a()
  {
    return this.a.length == this.b;
  }
  
  public int b()
  {
    int i = this.b;
    this.b += 1;
    this.a[i] = 0;
    return i;
  }
  
  public void b(int paramInt)
  {
    int[] arrayOfInt = this.a;
    arrayOfInt[paramInt] += 1;
  }
  
  public void c()
  {
    this.b -= 1;
    if (this.b < 0) {
      throw new ArrayIndexOutOfBoundsException(this.b);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/bx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */