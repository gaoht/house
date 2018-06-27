package cn.jpush.android.c;

import cn.jiguang.api.JCoreInterface;

public final class j
{
  private static final String[] z;
  private String a;
  private String b;
  private boolean c = false;
  private long d;
  
  static
  {
    String[] arrayOfString = new String[3];
    Object localObject2 = "\036j\007";
    int i = -1;
    int j = 0;
    Object localObject1 = arrayOfString;
    localObject2 = ((String)localObject2).toCharArray();
    int k = localObject2.length;
    int m;
    Object localObject3;
    int n;
    int i1;
    label50:
    int i2;
    label99:
    label121:
    Object localObject4;
    int i3;
    if (k <= 1)
    {
      m = 0;
      localObject3 = localObject1;
      n = j;
      localObject1 = localObject2;
      i1 = i;
      j = m;
      for (;;)
      {
        localObject2 = localObject1;
        i2 = localObject2[m];
        switch (j % 5)
        {
        default: 
          i = 32;
          localObject2[m] = ((char)(i ^ i2));
          j += 1;
          if (k != 0) {
            break label121;
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
        break label50;
      }
      localObject1 = new String((char[])localObject2).intern();
      switch (i2)
      {
      default: 
        localObject4[i3] = localObject1;
        localObject2 = "\024}\nQtP=BQWX$D\031EKpA\036R\031w";
        j = 1;
        i = 0;
        break;
      case 0: 
        localObject4[i3] = localObject1;
        j = 2;
        localObject2 = "T#";
        i = 1;
        break;
      case 1: 
        localObject4[i3] = localObject1;
        z = arrayOfString;
        return;
        i = 57;
        break label99;
        i = 80;
        break label99;
        i = 39;
        break label99;
        i = 113;
        break label99;
        m = 0;
        i2 = i;
        i3 = j;
        localObject4 = localObject1;
        i = k;
        j = m;
      }
    }
  }
  
  public j(String paramString1, String paramString2)
  {
    if (JCoreInterface.getDebugMode())
    {
      this.a = paramString1;
      this.b = paramString2;
      this.d = System.currentTimeMillis();
    }
  }
  
  public final void a()
  {
    if (JCoreInterface.getDebugMode())
    {
      f.c(this.a, z[1] + this.b + z[0] + (System.currentTimeMillis() - this.d) + z[2]);
      if (!this.c) {
        this.d = System.currentTimeMillis();
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jpush/android/c/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */