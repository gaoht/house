package cn.jiguang.c.c;

import java.util.Random;

public final class g
  implements Cloneable
{
  private static Random d;
  private static final String[] z;
  private int a;
  private int b = 256;
  private int[] c;
  
  static
  {
    String[] arrayOfString = new String[7];
    int j = 0;
    Object localObject2 = "\025\001o`O4,H)S?o_/I?;\034#]?!S4\0343*\034)R2=Y-Y?;Y$";
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
        i = 60;
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
        localObject2 = "\025\001o`Q4<O![4ou\004\034";
        i = 0;
        localObject1 = arrayOfString;
        break;
      case 0: 
        localObject3[i4] = localObject1;
        j = 2;
        localObject2 = "q&O`S$;\034/Zq=].[4";
        i = 1;
        localObject1 = arrayOfString;
        break;
      case 1: 
        localObject3[i4] = localObject1;
        j = 3;
        localObject2 = "}oU$\006q";
        i = 2;
        localObject1 = arrayOfString;
        break;
      case 2: 
        localObject3[i4] = localObject1;
        j = 4;
        localObject2 = "ko";
        i = 3;
        localObject1 = arrayOfString;
        break;
      case 3: 
        localObject3[i4] = localObject1;
        j = 5;
        localObject2 = "jt\034m\002o\007y\001x\024\035\000|\021q";
        i = 4;
        localObject1 = arrayOfString;
        break;
      case 4: 
        localObject3[i4] = localObject1;
        j = 6;
        localObject2 = "jo";
        i = 5;
        localObject1 = arrayOfString;
        break;
      case 5: 
        localObject3[i4] = localObject1;
        z = arrayOfString;
        d = new Random();
        return;
        i = 81;
        continue;
        i = 79;
        continue;
        i = 60;
        continue;
        i = 64;
      }
    }
  }
  
  public g()
  {
    b();
  }
  
  private g(int paramInt)
  {
    b();
    if ((paramInt < 0) || (paramInt > 65535)) {
      throw new IllegalArgumentException(z[1] + paramInt + z[2]);
    }
    this.a = paramInt;
  }
  
  g(d paramd)
  {
    this(paramd.g());
    int i = 0;
    while (i < this.c.length)
    {
      this.c[i] = paramd.g();
      i += 1;
    }
  }
  
  private void b()
  {
    this.c = new int[4];
    this.b = 256;
    this.a = -1;
  }
  
  private int c()
  {
    if (this.a >= 0) {
      return this.a;
    }
    try
    {
      if (this.a < 0) {
        this.a = d.nextInt(65535);
      }
      int i = this.a;
      return i;
    }
    finally {}
  }
  
  final int a()
  {
    return this.b;
  }
  
  final void a(int paramInt)
  {
    if (this.c[paramInt] == 65535) {
      throw new IllegalStateException(z[0]);
    }
    int[] arrayOfInt = this.c;
    arrayOfInt[paramInt] += 1;
  }
  
  final void a(e parame)
  {
    parame.c(c());
    parame.c(this.b);
    int i = 0;
    while (i < this.c.length)
    {
      parame.c(this.c[i]);
      i += 1;
    }
  }
  
  public final int b(int paramInt)
  {
    return this.c[paramInt];
  }
  
  public final Object clone()
  {
    g localg = new g();
    localg.a = this.a;
    localg.b = this.b;
    System.arraycopy(this.c, 0, localg.c, 0, this.c.length);
    return localg;
  }
  
  public final String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(z[5]);
    localStringBuffer.append(z[3] + c());
    localStringBuffer.append("\n");
    localStringBuffer.append(z[6]);
    int i = 0;
    while (i < 4)
    {
      localStringBuffer.append(q.a(i) + z[4] + this.c[i] + " ");
      i += 1;
    }
    return localStringBuffer.toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/c/c/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */