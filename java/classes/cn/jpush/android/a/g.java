package cn.jpush.android.a;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.net.HttpResponse;

final class g
  extends Thread
{
  private static final String[] z;
  
  static
  {
    String[] arrayOfString = new String[2];
    Object localObject2 = "q\r\b\001ASL\025\002\004[\003\000\t\004]\037\016\003\004Q\036\016\000\004B\036\r";
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
          i = 36;
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
        localObject2 = "g\036\016\031KT\003\r%A[\034\004\037";
        m = 1;
        k = 0;
        break;
      case 0: 
        localObject4[i3] = localObject1;
        z = arrayOfString;
        return;
        i = 55;
        break label99;
        i = 108;
        break label99;
        i = 97;
        break label99;
        i = 109;
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
  
  g(String paramString1, Context paramContext, String paramString2) {}
  
  public final void run()
  {
    int i = 0;
    Object localObject;
    while (i < 4)
    {
      int j = i + 1;
      localObject = cn.jpush.android.b.a.a(this.a, 5, 8000L);
      i = j;
      if (localObject != null)
      {
        i = j;
        if (((HttpResponse)localObject).getResponseCode() == 200) {
          localObject = ((HttpResponse)localObject).getResponseBody();
        }
      }
    }
    for (i = 1;; i = 0)
    {
      if ((i != 0) && (!TextUtils.isEmpty((CharSequence)localObject)))
      {
        f.a(this.b, (String)localObject);
        return;
      }
      b.a(this.c, 1021, cn.jpush.android.c.a.a(this.b, this.a), this.b);
      b.a(this.c, 996, this.b);
      cn.jpush.android.c.f.c(z[1], z[0]);
      return;
      localObject = null;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jpush/android/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */