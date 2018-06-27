package com.megvii.zhimasdk.b.a.f;

import java.io.Serializable;
import java.util.Comparator;

public class d
  implements Serializable, Comparator<b>
{
  public int a(b paramb1, b paramb2)
  {
    int j = paramb1.a().compareTo(paramb2.a());
    int i = j;
    Object localObject2;
    Object localObject1;
    String str;
    if (j == 0)
    {
      localObject2 = paramb1.d();
      if (localObject2 != null) {
        break label122;
      }
      localObject1 = "";
      str = paramb2.d();
      if (str != null) {
        break label162;
      }
      localObject2 = "";
    }
    for (;;)
    {
      i = ((String)localObject1).compareToIgnoreCase((String)localObject2);
      j = i;
      if (i == 0)
      {
        localObject1 = paramb1.e();
        paramb1 = (b)localObject1;
        if (localObject1 == null) {
          paramb1 = "/";
        }
        localObject1 = paramb2.e();
        paramb2 = (b)localObject1;
        if (localObject1 == null) {
          paramb2 = "/";
        }
        j = paramb1.compareTo(paramb2);
      }
      return j;
      label122:
      localObject1 = localObject2;
      if (((String)localObject2).indexOf('.') != -1) {
        break;
      }
      localObject1 = (String)localObject2 + ".local";
      break;
      label162:
      localObject2 = str;
      if (str.indexOf('.') == -1) {
        localObject2 = str + ".local";
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/f/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */