package com.google.b.a;

public final class a
{
  public static final a a = new a(new byte[0]);
  private final byte[] b;
  private volatile int c = 0;
  
  private a(byte[] paramArrayOfByte)
  {
    this.b = paramArrayOfByte;
  }
  
  public static a a(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static a a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = new byte[paramInt2];
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, paramInt2);
    return new a(arrayOfByte);
  }
  
  public int a()
  {
    return this.b.length;
  }
  
  public byte[] b()
  {
    int i = this.b.length;
    byte[] arrayOfByte = new byte[i];
    System.arraycopy(this.b, 0, arrayOfByte, 0, i);
    return arrayOfByte;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    for (;;)
    {
      return true;
      if (!(paramObject instanceof a)) {
        return false;
      }
      Object localObject = (a)paramObject;
      int j = this.b.length;
      if (j != ((a)localObject).b.length) {
        return false;
      }
      paramObject = this.b;
      localObject = ((a)localObject).b;
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
  
  public int hashCode()
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


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/google/b/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */