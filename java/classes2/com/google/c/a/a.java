package com.google.c.a;

public final class a
{
  private int[] a;
  private int b;
  
  public a()
  {
    this.b = 0;
    this.a = new int[1];
  }
  
  public a(int paramInt)
  {
    this.b = paramInt;
    this.a = b(paramInt);
  }
  
  private void a(int paramInt)
  {
    if (paramInt > this.a.length << 5)
    {
      int[] arrayOfInt = b(paramInt);
      System.arraycopy(this.a, 0, arrayOfInt, 0, this.a.length);
      this.a = arrayOfInt;
    }
  }
  
  private static int[] b(int paramInt)
  {
    return new int[paramInt + 31 >> 5];
  }
  
  public void appendBit(boolean paramBoolean)
  {
    a(this.b + 1);
    if (paramBoolean)
    {
      int[] arrayOfInt = this.a;
      int i = this.b >> 5;
      arrayOfInt[i] |= 1 << (this.b & 0x1F);
    }
    this.b += 1;
  }
  
  public void appendBitArray(a parama)
  {
    int j = parama.b;
    a(this.b + j);
    int i = 0;
    while (i < j)
    {
      appendBit(parama.get(i));
      i += 1;
    }
  }
  
  public void appendBits(int paramInt1, int paramInt2)
  {
    if ((paramInt2 < 0) || (paramInt2 > 32)) {
      throw new IllegalArgumentException("Num bits must be between 0 and 32");
    }
    a(this.b + paramInt2);
    if (paramInt2 > 0)
    {
      if ((paramInt1 >> paramInt2 - 1 & 0x1) == 1) {}
      for (boolean bool = true;; bool = false)
      {
        appendBit(bool);
        paramInt2 -= 1;
        break;
      }
    }
  }
  
  public void clear()
  {
    int j = this.a.length;
    int i = 0;
    while (i < j)
    {
      this.a[i] = 0;
      i += 1;
    }
  }
  
  public void flip(int paramInt)
  {
    int[] arrayOfInt = this.a;
    int i = paramInt >> 5;
    arrayOfInt[i] ^= 1 << (paramInt & 0x1F);
  }
  
  public boolean get(int paramInt)
  {
    return (this.a[(paramInt >> 5)] & 1 << (paramInt & 0x1F)) != 0;
  }
  
  public int[] getBitArray()
  {
    return this.a;
  }
  
  public int getNextSet(int paramInt)
  {
    if (paramInt >= this.b) {
      paramInt = this.b;
    }
    int i;
    do
    {
      return paramInt;
      i = paramInt >> 5;
      for (paramInt = this.a[i] & ((1 << (paramInt & 0x1F)) - 1 ^ 0xFFFFFFFF); paramInt == 0; paramInt = this.a[i])
      {
        i += 1;
        if (i == this.a.length) {
          return this.b;
        }
      }
      i = Integer.numberOfTrailingZeros(paramInt) + (i << 5);
      paramInt = i;
    } while (i <= this.b);
    return this.b;
  }
  
  public int getNextUnset(int paramInt)
  {
    if (paramInt >= this.b) {
      paramInt = this.b;
    }
    int i;
    do
    {
      return paramInt;
      i = paramInt >> 5;
      for (paramInt = (this.a[i] ^ 0xFFFFFFFF) & ((1 << (paramInt & 0x1F)) - 1 ^ 0xFFFFFFFF); paramInt == 0; paramInt = this.a[i] ^ 0xFFFFFFFF)
      {
        i += 1;
        if (i == this.a.length) {
          return this.b;
        }
      }
      i = Integer.numberOfTrailingZeros(paramInt) + (i << 5);
      paramInt = i;
    } while (i <= this.b);
    return this.b;
  }
  
  public int getSize()
  {
    return this.b;
  }
  
  public int getSizeInBytes()
  {
    return this.b + 7 >> 3;
  }
  
  public boolean isRange(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramInt2 < paramInt1) {
      throw new IllegalArgumentException();
    }
    if (paramInt2 == paramInt1) {
      return true;
    }
    int i1 = paramInt2 - 1;
    int m = paramInt1 >> 5;
    int i2 = i1 >> 5;
    int j = m;
    while (j <= i2)
    {
      int k;
      if (j > m)
      {
        paramInt2 = 0;
        if (j >= i2) {
          break label115;
        }
        k = 31;
        label67:
        if ((paramInt2 != 0) || (k != 31)) {
          break label125;
        }
        paramInt2 = -1;
        k = this.a[j];
        if (!paramBoolean) {
          break label158;
        }
      }
      label115:
      label125:
      label158:
      for (int i = paramInt2;; i = 0)
      {
        if ((k & paramInt2) == i) {
          break label164;
        }
        return false;
        paramInt2 = paramInt1 & 0x1F;
        break;
        k = i1 & 0x1F;
        break label67;
        int n;
        for (i = 0;; i = 1 << n | i)
        {
          n = paramInt2;
          paramInt2 = i;
          if (n > k) {
            break;
          }
          paramInt2 = n + 1;
        }
      }
      label164:
      j += 1;
    }
    return true;
  }
  
  public void reverse()
  {
    int[] arrayOfInt = new int[this.a.length];
    int j = this.b;
    int i = 0;
    while (i < j)
    {
      if (get(j - i - 1))
      {
        int k = i >> 5;
        arrayOfInt[k] |= 1 << (i & 0x1F);
      }
      i += 1;
    }
    this.a = arrayOfInt;
  }
  
  public void set(int paramInt)
  {
    int[] arrayOfInt = this.a;
    int i = paramInt >> 5;
    arrayOfInt[i] |= 1 << (paramInt & 0x1F);
  }
  
  public void setBulk(int paramInt1, int paramInt2)
  {
    this.a[(paramInt1 >> 5)] = paramInt2;
  }
  
  public void setRange(int paramInt1, int paramInt2)
  {
    if (paramInt2 < paramInt1) {
      throw new IllegalArgumentException();
    }
    if (paramInt2 == paramInt1) {
      return;
    }
    int i1 = paramInt2 - 1;
    int m = paramInt1 >> 5;
    int i2 = i1 >> 5;
    int j = m;
    label39:
    if (j <= i2)
    {
      if (j <= m) {
        break label106;
      }
      paramInt2 = 0;
      label55:
      if (j >= i2) {
        break label114;
      }
    }
    label106:
    label114:
    for (int k = 31;; k = i1 & 0x1F)
    {
      if ((paramInt2 != 0) || (k != 31)) {
        break label124;
      }
      i = -1;
      int[] arrayOfInt = this.a;
      arrayOfInt[j] = (i | arrayOfInt[j]);
      j += 1;
      break label39;
      break;
      paramInt2 = paramInt1 & 0x1F;
      break label55;
    }
    label124:
    int n = 0;
    int i = paramInt2;
    for (paramInt2 = n;; paramInt2 = 1 << n | paramInt2)
    {
      n = i;
      i = paramInt2;
      if (n > k) {
        break;
      }
      i = n + 1;
    }
  }
  
  public void toBytes(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    int i = 0;
    while (i < paramInt3)
    {
      int j = 0;
      int m;
      for (int k = 0; j < 8; k = m)
      {
        m = k;
        if (get(paramInt1)) {
          m = k | 1 << 7 - j;
        }
        paramInt1 += 1;
        j += 1;
      }
      paramArrayOfByte[(paramInt2 + i)] = ((byte)k);
      i += 1;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(this.b);
    int i = 0;
    if (i < this.b)
    {
      if ((i & 0x7) == 0) {
        localStringBuilder.append(' ');
      }
      if (get(i)) {}
      for (char c = 'X';; c = '.')
      {
        localStringBuilder.append(c);
        i += 1;
        break;
      }
    }
    return localStringBuilder.toString();
  }
  
  public void xor(a parama)
  {
    if (this.a.length != parama.a.length) {
      throw new IllegalArgumentException("Sizes don't match");
    }
    int i = 0;
    while (i < this.a.length)
    {
      int[] arrayOfInt = this.a;
      arrayOfInt[i] ^= parama.a[i];
      i += 1;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/google/c/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */