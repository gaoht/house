package cn.jiguang.c.c;

public final class n
  extends IllegalArgumentException
{
  private static final String z;
  
  static
  {
    Object localObject1 = "Xswz1\021<j)p\021skb\020?k}t_=dt".toCharArray();
    int j = localObject1.length;
    int m = 0;
    int i = 0;
    Object localObject2 = localObject1;
    int k = j;
    label30:
    int n;
    if (j <= 1)
    {
      m = i;
      k = i;
      localObject2 = localObject1;
      n = localObject2[k];
      switch (m % 5)
      {
      default: 
        i = 17;
      }
    }
    for (;;)
    {
      localObject2[k] = ((char)(i ^ n));
      m += 1;
      if (j == 0)
      {
        k = j;
        break label30;
      }
      k = j;
      localObject2 = localObject1;
      localObject1 = localObject2;
      j = k;
      i = m;
      if (k > m) {
        break;
      }
      z = new String((char[])localObject2).intern();
      return;
      i = 127;
      continue;
      i = 83;
      continue;
      i = 30;
      continue;
      i = 9;
    }
  }
  
  public n(j paramj)
  {
    super("'" + paramj + z);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/c/c/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */