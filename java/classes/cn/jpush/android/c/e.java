package cn.jpush.android.c;

import cn.jiguang.api.BaseLogger;

public final class e
  extends BaseLogger
{
  private static final String A;
  
  static
  {
    Object localObject1 = "|B,\024\002".toCharArray();
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
        i = 106;
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
      A = new String((char[])localObject2).intern();
      return;
      i = 54;
      continue;
      i = 18;
      continue;
      i = 89;
      continue;
      i = 103;
    }
  }
  
  public final String getCommonTag()
  {
    return A;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jpush/android/c/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */