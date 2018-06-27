package com.megvii.zhimasdk.b.a.o;

import java.io.Serializable;

public final class c
  implements Serializable
{
  private byte[] a;
  private int b;
  
  public c(int paramInt)
  {
    a.b(paramInt, "Buffer capacity");
    this.a = new byte[paramInt];
  }
  
  private void c(int paramInt)
  {
    byte[] arrayOfByte = new byte[Math.max(this.a.length << 1, paramInt)];
    System.arraycopy(this.a, 0, arrayOfByte, 0, this.b);
    this.a = arrayOfByte;
  }
  
  public void a()
  {
    this.b = 0;
  }
  
  public void a(int paramInt)
  {
    int i = this.b + 1;
    if (i > this.a.length) {
      c(i);
    }
    this.a[this.b] = ((byte)paramInt);
    this.b = i;
  }
  
  public void a(d paramd, int paramInt1, int paramInt2)
  {
    if (paramd == null) {
      return;
    }
    a(paramd.b(), paramInt1, paramInt2);
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte == null) {}
    do
    {
      return;
      if ((paramInt1 < 0) || (paramInt1 > paramArrayOfByte.length) || (paramInt2 < 0) || (paramInt1 + paramInt2 < 0) || (paramInt1 + paramInt2 > paramArrayOfByte.length)) {
        throw new IndexOutOfBoundsException("off: " + paramInt1 + " len: " + paramInt2 + " b.length: " + paramArrayOfByte.length);
      }
    } while (paramInt2 == 0);
    int i = this.b + paramInt2;
    if (i > this.a.length) {
      c(i);
    }
    System.arraycopy(paramArrayOfByte, paramInt1, this.a, this.b, paramInt2);
    this.b = i;
  }
  
  public void a(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if (paramArrayOfChar == null) {}
    do
    {
      return;
      if ((paramInt1 < 0) || (paramInt1 > paramArrayOfChar.length) || (paramInt2 < 0) || (paramInt1 + paramInt2 < 0) || (paramInt1 + paramInt2 > paramArrayOfChar.length)) {
        throw new IndexOutOfBoundsException("off: " + paramInt1 + " len: " + paramInt2 + " b.length: " + paramArrayOfChar.length);
      }
    } while (paramInt2 == 0);
    int j = this.b;
    int k = j + paramInt2;
    paramInt2 = j;
    int i = paramInt1;
    if (k > this.a.length)
    {
      c(k);
      i = paramInt1;
      paramInt2 = j;
    }
    while (paramInt2 < k)
    {
      this.a[paramInt2] = ((byte)paramArrayOfChar[i]);
      i += 1;
      paramInt2 += 1;
    }
    this.b = k;
  }
  
  public int b(int paramInt)
  {
    return this.a[paramInt];
  }
  
  public byte[] b()
  {
    byte[] arrayOfByte = new byte[this.b];
    if (this.b > 0) {
      System.arraycopy(this.a, 0, arrayOfByte, 0, this.b);
    }
    return arrayOfByte;
  }
  
  public int c()
  {
    return this.a.length;
  }
  
  public int d()
  {
    return this.b;
  }
  
  public byte[] e()
  {
    return this.a;
  }
  
  public boolean f()
  {
    return this.b == 0;
  }
  
  public boolean g()
  {
    return this.b == this.a.length;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/o/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */