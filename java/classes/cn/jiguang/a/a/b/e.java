package cn.jiguang.a.a.b;

import cn.jiguang.c.d.l;
import cn.jiguang.c.d.m;
import org.json.JSONArray;
import org.json.JSONObject;

final class e
  extends Thread
  implements m
{
  private static final String[] z;
  
  static
  {
    String[] arrayOfString = new String[4];
    Object localObject1 = "G\\!v\021h\037x?\fcO:m\nEM4l\026JP2?\031cKuy\027jZur\013rZ&?\030gV9z\032";
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
          i = 126;
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
        localObject1 = "TZ%p\fr{<m\033eKu|\021hK0g\n&V&?\020sS9";
        j = 1;
        i = 0;
        break;
      case 0: 
        localObject4[i3] = localObject1;
        localObject1 = "Lo l\026EM4l\026N^;{\022cM";
        j = 2;
        i = 1;
        break;
      case 1: 
        localObject4[i3] = localObject1;
        j = 3;
        localObject1 = "TZ%p\fr{<m\033eKuz\ftP'\\\021bZo";
        i = 2;
        break;
      case 2: 
        localObject4[i3] = localObject1;
        z = arrayOfString;
        return;
        i = 6;
        break label91;
        i = 63;
        break label91;
        i = 85;
        break label91;
        i = 31;
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
  
  e(d paramd) {}
  
  public final void a(int paramInt)
  {
    cn.jiguang.d.d.g(z[2], z[3] + paramInt);
    if (paramInt == 0) {
      d.d(d.a(this.a));
    }
  }
  
  public final void run()
  {
    if (d.a(this.a) == null)
    {
      cn.jiguang.d.d.g(z[2], z[1]);
      return;
    }
    if (d.a(this.a, d.a(this.a)))
    {
      JSONObject localJSONObject = d.e(d.a(this.a));
      if (localJSONObject != null) {
        l.a(d.a(this.a), new JSONArray().put(localJSONObject), this);
      }
      d.b(this.a);
      return;
    }
    cn.jiguang.d.d.a(z[2], z[0]);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/a/a/b/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */