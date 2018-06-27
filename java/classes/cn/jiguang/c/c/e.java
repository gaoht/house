package cn.jiguang.c.c;

public final class e
{
  private static final String[] z;
  private byte[] a = new byte[32];
  private int b = 0;
  private int c = -1;
  
  static
  {
    String[] arrayOfString = new String[4];
    Object localObject1 = "m7`\016/zvd\025-~v~\0013zvk\016$.9h@$o\"o";
    int i = -1;
    int j = 0;
    Object localObject3 = arrayOfString;
    localObject1 = ((String)localObject1).toCharArray();
    int k = localObject1.length;
    int m;
    int n;
    int i1;
    label42:
    Object localObject2;
    int i2;
    label91:
    label113:
    Object localObject4;
    int i3;
    if (k <= 1)
    {
      m = 0;
      n = j;
      i1 = i;
      j = m;
      for (;;)
      {
        localObject2 = localObject1;
        i2 = localObject2[m];
        switch (j % 5)
        {
        default: 
          i = 64;
          localObject2[m] = ((char)(i ^ i2));
          j += 1;
          if (k != 0) {
            break label113;
          }
          m = k;
        }
      }
      i = k;
      localObject4 = localObject3;
      i3 = n;
      localObject2 = localObject1;
      i2 = i1;
    }
    for (;;)
    {
      i1 = i2;
      localObject1 = localObject2;
      n = i3;
      localObject3 = localObject4;
      k = i;
      m = j;
      if (i > j) {
        break label42;
      }
      localObject1 = new String((char[])localObject2).intern();
      switch (i2)
      {
      default: 
        localObject4[i3] = localObject1;
        localObject1 = ".4g\024`x7b\025%";
        j = 1;
        i = 0;
        break;
      case 0: 
        localObject4[i3] = localObject1;
        localObject1 = ".9{\024`a0.\022!`1k@&a$.";
        j = 2;
        i = 1;
        break;
      case 1: 
        localObject4[i3] = localObject1;
        j = 3;
        localObject1 = "m7`\016/zvy\022)z3.\020!}\".\005.jva\006`j7z\001";
        i = 2;
        break;
      case 2: 
        localObject4[i3] = localObject1;
        z = arrayOfString;
        return;
        i = 14;
        break label91;
        i = 86;
        break label91;
        i = 14;
        break label91;
        i = 96;
        break label91;
        m = 0;
        i2 = i;
        localObject2 = localObject1;
        i3 = j;
        localObject4 = localObject3;
        i = k;
        j = m;
      }
    }
  }
  
  public e()
  {
    this(32);
  }
  
  private e(int paramInt) {}
  
  private static void a(long paramLong, int paramInt)
  {
    if ((paramLong < 0L) || (paramLong > 1L << paramInt)) {
      throw new IllegalArgumentException(paramLong + z[2] + paramInt + z[1]);
    }
  }
  
  private void d(int paramInt)
  {
    if (this.a.length - this.b >= paramInt) {
      return;
    }
    int j = this.a.length * 2;
    int i = j;
    if (j < this.b + paramInt) {
      i = this.b + paramInt;
    }
    byte[] arrayOfByte = new byte[i];
    System.arraycopy(this.a, 0, arrayOfByte, 0, this.b);
    this.a = arrayOfByte;
  }
  
  public final int a()
  {
    return this.b;
  }
  
  public final void a(int paramInt)
  {
    if (paramInt > this.b) {
      throw new IllegalArgumentException(z[0]);
    }
    this.b = paramInt;
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    a(paramInt1, 16);
    if (paramInt2 > this.b - 2) {
      throw new IllegalArgumentException(z[3]);
    }
    this.a[paramInt2] = ((byte)(paramInt1 >>> 8 & 0xFF));
    this.a[(paramInt2 + 1)] = ((byte)(paramInt1 & 0xFF));
  }
  
  public final void a(long paramLong)
  {
    a(paramLong, 32);
    d(4);
    byte[] arrayOfByte = this.a;
    int i = this.b;
    this.b = (i + 1);
    arrayOfByte[i] = ((byte)(int)(paramLong >>> 24 & 0xFF));
    arrayOfByte = this.a;
    i = this.b;
    this.b = (i + 1);
    arrayOfByte[i] = ((byte)(int)(paramLong >>> 16 & 0xFF));
    arrayOfByte = this.a;
    i = this.b;
    this.b = (i + 1);
    arrayOfByte[i] = ((byte)(int)(paramLong >>> 8 & 0xFF));
    arrayOfByte = this.a;
    i = this.b;
    this.b = (i + 1);
    arrayOfByte[i] = ((byte)(int)(paramLong & 0xFF));
  }
  
  public final void a(byte[] paramArrayOfByte)
  {
    a(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public final void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    d(paramInt2);
    System.arraycopy(paramArrayOfByte, paramInt1, this.a, this.b, paramInt2);
    this.b += paramInt2;
  }
  
  public final void b(int paramInt)
  {
    a(0L, 8);
    d(1);
    byte[] arrayOfByte = this.a;
    paramInt = this.b;
    this.b = (paramInt + 1);
    arrayOfByte[paramInt] = 0;
  }
  
  public final byte[] b()
  {
    byte[] arrayOfByte = new byte[this.b];
    System.arraycopy(this.a, 0, arrayOfByte, 0, this.b);
    return arrayOfByte;
  }
  
  public final void c(int paramInt)
  {
    a(paramInt, 16);
    d(2);
    byte[] arrayOfByte = this.a;
    int i = this.b;
    this.b = (i + 1);
    arrayOfByte[i] = ((byte)(paramInt >>> 8 & 0xFF));
    arrayOfByte = this.a;
    i = this.b;
    this.b = (i + 1);
    arrayOfByte[i] = ((byte)(paramInt & 0xFF));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/c/c/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */