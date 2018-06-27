package cn.jiguang.c.d;

import android.content.Context;
import android.os.Bundle;
import cn.jiguang.c.b.b;
import cn.jiguang.d.d;

final class j
  implements Runnable
{
  private static final String[] z;
  private String b;
  private Bundle c;
  private int d;
  private Context e;
  
  static
  {
    String[] arrayOfString = new String[2];
    Object localObject2 = "e7\027`\"F\007\027Q;B\t\023|0g\001\036b1]";
    int k = -1;
    int m = 0;
    Object localObject1 = arrayOfString;
    localObject2 = ((String)localObject2).toCharArray();
    int j = localObject2.length;
    int i;
    Object localObject3;
    int n;
    int i1;
    label50:
    int i2;
    label99:
    label121:
    Object localObject4;
    int i3;
    if (j <= 1)
    {
      i = 0;
      localObject3 = localObject1;
      n = m;
      localObject1 = localObject2;
      i1 = k;
      m = i;
      for (k = i;; k = j)
      {
        localObject2 = localObject1;
        i2 = localObject2[k];
        switch (m % 5)
        {
        default: 
          i = 84;
          localObject2[k] = ((char)(i ^ i2));
          m += 1;
          if (j != 0) {
            break label121;
          }
        }
      }
      k = j;
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
      j = k;
      i = m;
      if (k > m) {
        break label50;
      }
      localObject1 = new String((char[])localObject2).intern();
      switch (i2)
      {
      default: 
        localObject4[i3] = localObject1;
        localObject2 = "F\027R5F\nRb&@\007\027a'\017IR";
        m = 1;
        k = 0;
        break;
      case 0: 
        localObject4[i3] = localObject1;
        z = arrayOfString;
        return;
        i = 47;
        break label99;
        i = 100;
        break label99;
        i = 114;
        break label99;
        i = 18;
        break label99;
        i = 0;
        i2 = k;
        i3 = m;
        localObject4 = localObject1;
        k = j;
        m = i;
      }
    }
  }
  
  public j(i parami, Context paramContext, String paramString, Bundle paramBundle, int paramInt)
  {
    this.b = paramString;
    this.c = paramBundle;
    this.e = paramContext;
    this.d = paramInt;
  }
  
  public final void run()
  {
    if (this.d == 1)
    {
      i.a(this.a, this.b, this.c);
      return;
    }
    if (b.c())
    {
      i.a(this.a, this.e, this.b, this.c);
      return;
    }
    if (i.a(this.a))
    {
      i.a(this.a, this.b, this.c);
      f.a().a(this.e);
      return;
    }
    d.i(z[0], z[1] + i.a(this.a));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/c/d/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */