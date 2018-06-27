package com.freelxl.baselibrary.e;

public class b
  implements l
{
  private int a;
  private int b;
  private final int c;
  private final float d;
  
  public b()
  {
    this(2500, 1, 1.0F);
  }
  
  public b(int paramInt1, int paramInt2, float paramFloat)
  {
    this.a = paramInt1;
    this.c = paramInt2;
    this.d = paramFloat;
  }
  
  protected boolean a()
  {
    return this.b <= this.c;
  }
  
  public int getCurrentRetryCount()
  {
    return this.b;
  }
  
  public int getCurrentTimeout()
  {
    return this.a;
  }
  
  public void retry(Exception paramException)
    throws Exception
  {
    this.b += 1;
    this.a = ((int)(this.a + this.a * this.d));
    if (!a()) {
      throw paramException;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/freelxl/baselibrary/e/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */