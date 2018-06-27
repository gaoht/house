package com.google.c.d.b;

import java.lang.reflect.Array;

public final class b
{
  private final byte[][] a;
  private final int b;
  private final int c;
  
  public b(int paramInt1, int paramInt2)
  {
    this.a = ((byte[][])Array.newInstance(Byte.TYPE, new int[] { paramInt2, paramInt1 }));
    this.b = paramInt1;
    this.c = paramInt2;
  }
  
  public void clear(byte paramByte)
  {
    int i = 0;
    while (i < this.c)
    {
      int j = 0;
      while (j < this.b)
      {
        this.a[i][j] = paramByte;
        j += 1;
      }
      i += 1;
    }
  }
  
  public byte get(int paramInt1, int paramInt2)
  {
    return this.a[paramInt2][paramInt1];
  }
  
  public byte[][] getArray()
  {
    return this.a;
  }
  
  public int getHeight()
  {
    return this.c;
  }
  
  public int getWidth()
  {
    return this.b;
  }
  
  public void set(int paramInt1, int paramInt2, byte paramByte)
  {
    this.a[paramInt2][paramInt1] = paramByte;
  }
  
  public void set(int paramInt1, int paramInt2, int paramInt3)
  {
    this.a[paramInt2][paramInt1] = ((byte)paramInt3);
  }
  
  public void set(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    byte[] arrayOfByte = this.a[paramInt2];
    if (paramBoolean) {}
    for (paramInt2 = 1;; paramInt2 = 0)
    {
      arrayOfByte[paramInt1] = ((byte)paramInt2);
      return;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(this.b * 2 * this.c + 2);
    int i = 0;
    while (i < this.c)
    {
      int j = 0;
      if (j < this.b)
      {
        switch (this.a[i][j])
        {
        default: 
          localStringBuilder.append("  ");
        }
        for (;;)
        {
          j += 1;
          break;
          localStringBuilder.append(" 0");
          continue;
          localStringBuilder.append(" 1");
        }
      }
      localStringBuilder.append('\n');
      i += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/google/c/d/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */