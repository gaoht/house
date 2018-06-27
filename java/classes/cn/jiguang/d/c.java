package cn.jiguang.d;

import cn.jiguang.api.BaseLogger;

public final class c
  extends BaseLogger
{
  private static final String z;
  
  static
  {
    Object localObject1 = "./\025\bl".toCharArray();
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
        i = 9;
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
      i = 100;
      continue;
      i = 108;
      continue;
      i = 122;
      continue;
      i = 122;
    }
  }
  
  public final String getCommonTag()
  {
    return z;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/d/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */