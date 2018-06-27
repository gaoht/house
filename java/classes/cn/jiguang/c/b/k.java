package cn.jiguang.c.b;

final class k
{
  private static final String[] z;
  String a;
  int b;
  
  static
  {
    String[] arrayOfString = new String[4];
    Object localObject1 = "=JxpK\035@.aH\006P.<\007D";
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
          i = 39;
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
        localObject1 = "=JxpK\035@.aH\006P.<\007";
        j = 1;
        i = 0;
        break;
      case 0: 
        localObject4[i3] = localObject1;
        localObject1 = "$K|e\007\035W.B\021@ku\007\022K|1FTRo}N\020\004ouC\006A}b\013TW~}N\000\004lh\007N";
        j = 2;
        i = 1;
        break;
      case 1: 
        localObject4[i3] = localObject1;
        j = 3;
        localObject1 = "=JxpK\035@.xWT\t.";
        i = 2;
        break;
      case 2: 
        localObject4[i3] = localObject1;
        z = arrayOfString;
        return;
        i = 116;
        break label91;
        i = 36;
        break label91;
        i = 14;
        break label91;
        i = 17;
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
  
  public k(String paramString)
  {
    int i = paramString.indexOf(':');
    if (i == -1) {
      throw new Exception(z[2]);
    }
    this.a = paramString.substring(0, i);
    if (!j.c(this.a)) {
      throw new Exception(z[3] + this.a);
    }
    paramString = paramString.substring(i + 1);
    try
    {
      this.b = Integer.parseInt(paramString);
      if (this.b == 0) {
        throw new Exception(z[0]);
      }
    }
    catch (Exception localException)
    {
      throw new Exception(z[1] + paramString);
    }
  }
  
  public final String toString()
  {
    return this.a + ":" + this.b;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/c/b/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */