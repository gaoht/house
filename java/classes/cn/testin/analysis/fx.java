package cn.testin.analysis;

public final class fx
  extends fu
{
  private final byte[] a;
  private final int b;
  private final int c;
  private final int d;
  private final int e;
  
  public fx(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean)
  {
    super(paramInt5, paramInt6);
    if ((paramInt3 + paramInt5 > paramInt1) || (paramInt4 + paramInt6 > paramInt2)) {
      throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
    }
    this.a = paramArrayOfByte;
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramInt3;
    this.e = paramInt4;
    if (paramBoolean) {
      a(paramInt5, paramInt6);
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = this.a;
    int j = this.e;
    int k = this.b;
    j = this.d + j * k;
    k = 0;
    while (k < paramInt2)
    {
      int i1 = paramInt1 / 2;
      int m = j + paramInt1 - 1;
      int n = j;
      while (n < j + i1)
      {
        int i = arrayOfByte[n];
        arrayOfByte[n] = arrayOfByte[m];
        arrayOfByte[m] = i;
        n += 1;
        m -= 1;
      }
      j += this.b;
      k += 1;
    }
  }
  
  public byte[] a()
  {
    int i = 0;
    int m = b();
    int n = c();
    Object localObject;
    if ((m == this.b) && (n == this.c))
    {
      localObject = this.a;
      return (byte[])localObject;
    }
    int i1 = m * n;
    byte[] arrayOfByte = new byte[i1];
    int k = this.e * this.b + this.d;
    int j = k;
    if (m == this.b)
    {
      System.arraycopy(this.a, k, arrayOfByte, 0, i1);
      return arrayOfByte;
    }
    for (;;)
    {
      localObject = arrayOfByte;
      if (i >= n) {
        break;
      }
      System.arraycopy(this.a, j, arrayOfByte, i * m, m);
      j += this.b;
      i += 1;
    }
  }
  
  public byte[] a(int paramInt, byte[] paramArrayOfByte)
  {
    if ((paramInt < 0) || (paramInt >= c())) {
      throw new IllegalArgumentException("Requested row is outside the image: " + paramInt);
    }
    int i = b();
    byte[] arrayOfByte;
    if (paramArrayOfByte != null)
    {
      arrayOfByte = paramArrayOfByte;
      if (paramArrayOfByte.length >= i) {}
    }
    else
    {
      arrayOfByte = new byte[i];
    }
    int j = this.e;
    int k = this.b;
    int m = this.d;
    System.arraycopy(this.a, (j + paramInt) * k + m, arrayOfByte, 0, i);
    return arrayOfByte;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/fx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */