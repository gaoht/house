package com.megvii.zhimasdk.b.a.o;

import java.io.Serializable;

public final class d
  implements Serializable
{
  private char[] a;
  private int b;
  
  public d(int paramInt)
  {
    a.b(paramInt, "Buffer capacity");
    this.a = new char[paramInt];
  }
  
  private void d(int paramInt)
  {
    char[] arrayOfChar = new char[Math.max(this.a.length << 1, paramInt)];
    System.arraycopy(this.a, 0, arrayOfChar, 0, this.b);
    this.a = arrayOfChar;
  }
  
  public char a(int paramInt)
  {
    return this.a[paramInt];
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt2;
    if (paramInt2 < 0) {
      i = 0;
    }
    paramInt2 = paramInt3;
    if (paramInt3 > this.b) {
      paramInt2 = this.b;
    }
    if (i > paramInt2) {}
    for (;;)
    {
      return -1;
      while (i < paramInt2)
      {
        if (this.a[i] == paramInt1) {
          return i;
        }
        i += 1;
      }
    }
  }
  
  public String a(int paramInt1, int paramInt2)
  {
    return new String(this.a, paramInt1, paramInt2 - paramInt1);
  }
  
  public void a()
  {
    this.b = 0;
  }
  
  public void a(char paramChar)
  {
    int i = this.b + 1;
    if (i > this.a.length) {
      d(i);
    }
    this.a[this.b] = paramChar;
    this.b = i;
  }
  
  public void a(c paramc, int paramInt1, int paramInt2)
  {
    if (paramc == null) {
      return;
    }
    a(paramc.e(), paramInt1, paramInt2);
  }
  
  public void a(d paramd, int paramInt1, int paramInt2)
  {
    if (paramd == null) {
      return;
    }
    a(paramd.a, paramInt1, paramInt2);
  }
  
  public void a(String paramString)
  {
    if (paramString != null) {}
    for (;;)
    {
      int i = paramString.length();
      int j = this.b + i;
      if (j > this.a.length) {
        d(j);
      }
      paramString.getChars(0, i, this.a, this.b);
      this.b = j;
      return;
      paramString = "null";
    }
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
    int j = this.b;
    int k = j + paramInt2;
    paramInt2 = j;
    int i = paramInt1;
    if (k > this.a.length)
    {
      d(k);
      i = paramInt1;
      paramInt2 = j;
    }
    while (paramInt2 < k)
    {
      this.a[paramInt2] = ((char)(paramArrayOfByte[i] & 0xFF));
      i += 1;
      paramInt2 += 1;
    }
    this.b = k;
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
    int i = this.b + paramInt2;
    if (i > this.a.length) {
      d(i);
    }
    System.arraycopy(paramArrayOfChar, paramInt1, this.a, this.b, paramInt2);
    this.b = i;
  }
  
  public String b(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {
      throw new IndexOutOfBoundsException("Negative beginIndex: " + paramInt1);
    }
    if (paramInt2 > this.b) {
      throw new IndexOutOfBoundsException("endIndex: " + paramInt2 + " > length: " + this.b);
    }
    int i = paramInt1;
    if (paramInt1 > paramInt2) {
      throw new IndexOutOfBoundsException("beginIndex: " + paramInt1 + " > endIndex: " + paramInt2);
    }
    for (;;)
    {
      paramInt1 = paramInt2;
      if (i >= paramInt2) {
        break;
      }
      paramInt1 = paramInt2;
      if (!com.megvii.zhimasdk.b.a.n.d.a(this.a[i])) {
        break;
      }
      i += 1;
    }
    while ((paramInt1 > i) && (com.megvii.zhimasdk.b.a.n.d.a(this.a[(paramInt1 - 1)]))) {
      paramInt1 -= 1;
    }
    return new String(this.a, i, paramInt1 - i);
  }
  
  public void b(int paramInt)
  {
    if (paramInt <= 0) {}
    while (paramInt <= this.a.length - this.b) {
      return;
    }
    d(this.b + paramInt);
  }
  
  public char[] b()
  {
    return this.a;
  }
  
  public int c()
  {
    return this.b;
  }
  
  public int c(int paramInt)
  {
    return a(paramInt, 0, this.b);
  }
  
  public boolean d()
  {
    return this.b == 0;
  }
  
  public String toString()
  {
    return new String(this.a, 0, this.b);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/o/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */