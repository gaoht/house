package com.megvii.zhimasdk.b.a.f;

import java.io.Serializable;
import java.util.Comparator;

public class f
  implements Serializable, Comparator<b>
{
  private String a(b paramb)
  {
    Object localObject = paramb.e();
    paramb = (b)localObject;
    if (localObject == null) {
      paramb = "/";
    }
    localObject = paramb;
    if (!paramb.endsWith("/")) {
      localObject = paramb + '/';
    }
    return (String)localObject;
  }
  
  public int a(b paramb1, b paramb2)
  {
    paramb1 = a(paramb1);
    paramb2 = a(paramb2);
    if (paramb1.equals(paramb2)) {}
    do
    {
      return 0;
      if (paramb1.startsWith(paramb2)) {
        return -1;
      }
    } while (!paramb2.startsWith(paramb1));
    return 1;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/f/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */