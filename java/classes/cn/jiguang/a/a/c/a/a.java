package cn.jiguang.a.a.c.a;

import android.content.Context;
import cn.jiguang.a.a.c.a.a.c;
import cn.jiguang.d.d;

public final class a
{
  private static a c;
  private static Object d;
  private static final String[] z;
  private Context a;
  private boolean b = false;
  
  static
  {
    String[] arrayOfString = new String[2];
    Object localObject2 = "\024i_\022s=eD\026G%";
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
          i = 53;
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
        localObject2 = "=jB\034T8\020\020[5rU\035";
        m = 1;
        k = 0;
        break;
      case 0: 
        localObject4[i3] = localObject1;
        z = arrayOfString;
        d = new Object();
        return;
        i = 92;
        break label99;
        i = 6;
        break label99;
        i = 48;
        break label99;
        i = 121;
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
  
  public static a a()
  {
    synchronized (d)
    {
      if (c == null) {
        c = new a();
      }
      return c;
    }
  }
  
  public final void a(Context paramContext)
  {
    this.a = paramContext;
    if (this.b)
    {
      d.i(z[0], z[1]);
      return;
    }
    this.b = true;
    new c();
    c.a(paramContext);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/a/a/c/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */