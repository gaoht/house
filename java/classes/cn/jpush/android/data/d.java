package cn.jpush.android.data;

import android.text.TextUtils;
import java.io.Serializable;

public final class d
  implements Serializable
{
  private static final String[] z;
  public String a;
  public String b;
  
  static
  {
    String[] arrayOfString = new String[2];
    Object localObject2 = "U1\026Tu\\bL+";
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
          i = 28;
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
        localObject2 = "\024bQdj]0\003bx]\035\034x{g+\025+!\030";
        m = 1;
        k = 0;
        break;
      case 0: 
        localObject4[i3] = localObject1;
        z = arrayOfString;
        return;
        i = 56;
        break label99;
        i = 66;
        break label99;
        i = 113;
        break label99;
        i = 11;
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
  
  public d() {}
  
  public d(c paramc)
  {
    this.a = paramc.c;
    this.b = paramc.d;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof d)) {}
    do
    {
      do
      {
        return false;
        paramObject = (d)paramObject;
      } while ((TextUtils.isEmpty(this.a)) || (TextUtils.isEmpty(((d)paramObject).a)) || (!TextUtils.equals(this.a, ((d)paramObject).a)));
      if ((TextUtils.isEmpty(this.b)) && (TextUtils.isEmpty(((d)paramObject).b))) {
        return true;
      }
    } while ((TextUtils.isEmpty(this.b)) || (TextUtils.isEmpty(((d)paramObject).b)) || (!TextUtils.equals(this.b, ((d)paramObject).b)));
    return true;
  }
  
  public final String toString()
  {
    return z[0] + this.a + z[1] + this.b;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jpush/android/data/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */