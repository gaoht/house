package com.google.a;

import java.io.UnsupportedEncodingException;

public final class b
{
  public static final b a = new b(new byte[0]);
  private final byte[] b;
  private volatile int c = 0;
  
  protected b(byte[] paramArrayOfByte)
  {
    this.b = paramArrayOfByte;
  }
  
  public static b a(String paramString)
  {
    try
    {
      paramString = new b(paramString.getBytes("UTF-8"));
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new RuntimeException("UTF-8 not supported?");
    }
  }
  
  public static b a(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static b a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = new byte[paramInt2];
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, paramInt2);
    return new b(arrayOfByte);
  }
  
  public final int a()
  {
    return this.b.length;
  }
  
  public final byte[] b()
  {
    int i = this.b.length;
    byte[] arrayOfByte = new byte[i];
    System.arraycopy(this.b, 0, arrayOfByte, 0, i);
    return arrayOfByte;
  }
  
  public final c c()
  {
    byte[] arrayOfByte = this.b;
    return c.a(arrayOfByte, 0, arrayOfByte.length);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    for (;;)
    {
      return true;
      if (!(paramObject instanceof b)) {
        return false;
      }
      Object localObject = (b)paramObject;
      int j = this.b.length;
      if (j != ((b)localObject).b.length) {
        return false;
      }
      paramObject = this.b;
      localObject = ((b)localObject).b;
      int i = 0;
      while (i < j)
      {
        if (paramObject[i] != localObject[i]) {
          return false;
        }
        i += 1;
      }
    }
  }
  
  public final int hashCode()
  {
    int i = this.c;
    int j = i;
    if (i == 0)
    {
      byte[] arrayOfByte = this.b;
      int k = this.b.length;
      j = 0;
      int m;
      for (i = k; j < k; i = m + i * 31)
      {
        m = arrayOfByte[j];
        j += 1;
      }
      j = i;
      if (i == 0) {
        j = 1;
      }
      this.c = j;
    }
    return j;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/google/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */