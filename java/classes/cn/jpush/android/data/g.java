package cn.jpush.android.data;

public final class g
{
  private static final String[] z;
  private long a = 0L;
  private int b = 0;
  private int c = 0;
  private int d = 0;
  private String e = "";
  private long f = 0L;
  private long g = 0L;
  
  static
  {
    String[] arrayOfString = new String[7];
    int j = 0;
    Object localObject2 = "\037u\026{k\035u\001sa:y\024nn<t1XC2n\024:\\?t*scn";
    int i = -1;
    Object localObject1 = arrayOfString;
    char[] arrayOfChar = ((String)localObject2).toCharArray();
    int k = arrayOfChar.length;
    int i1 = 0;
    int m = 0;
    int i3 = i;
    localObject2 = arrayOfChar;
    int i4 = j;
    Object localObject3 = localObject1;
    int n = k;
    Object localObject4;
    int i2;
    if (k <= 1)
    {
      localObject4 = localObject1;
      localObject1 = arrayOfChar;
      i2 = i;
      label68:
      n = m;
      label71:
      localObject2 = localObject1;
      i1 = localObject2[m];
      switch (n % 5)
      {
      default: 
        i = 7;
      }
    }
    for (;;)
    {
      localObject2[m] = ((char)(i ^ i1));
      n += 1;
      if (k == 0)
      {
        m = k;
        break label71;
      }
      i1 = n;
      n = k;
      localObject3 = localObject4;
      i4 = j;
      localObject2 = localObject1;
      i3 = i2;
      i2 = i3;
      localObject1 = localObject2;
      j = i4;
      localObject4 = localObject3;
      k = n;
      m = i1;
      if (n > i1) {
        break label68;
      }
      localObject1 = new String((char[])localObject2).intern();
      switch (i3)
      {
      default: 
        localObject3[i4] = localObject1;
        j = 1;
        localObject2 = ":\031tX!\030uq6'";
        i = 0;
        localObject1 = arrayOfString;
        break;
      case 0: 
        localObject3[i4] = localObject1;
        j = 2;
        localObject2 = ":\031tX0u\000tsn";
        i = 1;
        localObject1 = arrayOfString;
        break;
      case 1: 
        localObject3[i4] = localObject1;
        j = 3;
        localObject2 = ":\031tX2~\021Es:w\020'";
        i = 2;
        localObject1 = arrayOfString;
        break;
      case 2: 
        localObject3[i4] = localObject1;
        j = 4;
        localObject2 = ":\031tX6b\001hfn";
        i = 3;
        localObject1 = arrayOfString;
        break;
      case 3: 
        localObject3[i4] = localObject1;
        j = 5;
        localObject2 = ":\031tX'c\005:";
        i = 4;
        localObject1 = arrayOfString;
        break;
      case 4: 
        localObject3[i4] = localObject1;
        j = 6;
        localObject2 = ":\031tX'h\034}`6h*nn>H";
        i = 5;
        localObject1 = arrayOfString;
        break;
      case 5: 
        localObject3[i4] = localObject1;
        z = arrayOfString;
        return;
        i = 83;
        continue;
        i = 26;
        continue;
        i = 117;
        continue;
        i = 26;
      }
    }
  }
  
  public final long a()
  {
    return this.a;
  }
  
  public final void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public final void a(long paramLong)
  {
    this.a = paramLong;
  }
  
  public final void a(String paramString)
  {
    this.e = paramString;
  }
  
  public final int b()
  {
    return this.b;
  }
  
  public final void b(int paramInt)
  {
    this.c = paramInt;
  }
  
  public final void b(long paramLong)
  {
    this.g = paramLong;
  }
  
  public final int c()
  {
    return this.c;
  }
  
  public final void c(int paramInt)
  {
    this.d = paramInt;
  }
  
  public final void c(long paramLong)
  {
    this.f = paramLong;
  }
  
  public final String d()
  {
    return this.e;
  }
  
  public final long e()
  {
    return this.g;
  }
  
  public final long f()
  {
    return this.f;
  }
  
  public final String toString()
  {
    return z[0] + this.a + z[2] + this.b + z[1] + this.c + z[5] + this.d + z[4] + this.e + z[6] + this.f + z[3] + this.g + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jpush/android/data/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */