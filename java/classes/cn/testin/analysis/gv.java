package cn.testin.analysis;

import java.util.HashMap;
import java.util.Map;

public enum gv
{
  private static final Map<Integer, gv> B;
  private static final Map<String, gv> C;
  private final int[] D;
  private final String[] E;
  
  static
  {
    A = new gv("EUC_KR", 26, 30, new String[] { "EUC-KR" });
    F = new gv[] { a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, A };
    B = new HashMap();
    C = new HashMap();
    gv[] arrayOfgv = values();
    int i3 = arrayOfgv.length;
    int i1 = 0;
    while (i1 < i3)
    {
      gv localgv = arrayOfgv[i1];
      Object localObject1 = localgv.D;
      int i4 = localObject1.length;
      int i2 = 0;
      while (i2 < i4)
      {
        int i5 = localObject1[i2];
        B.put(Integer.valueOf(i5), localgv);
        i2 += 1;
      }
      C.put(localgv.name(), localgv);
      localObject1 = localgv.E;
      i4 = localObject1.length;
      i2 = 0;
      while (i2 < i4)
      {
        Object localObject2 = localObject1[i2];
        C.put(localObject2, localgv);
        i2 += 1;
      }
      i1 += 1;
    }
  }
  
  private gv(int paramInt)
  {
    this(new int[] { paramInt }, new String[0]);
  }
  
  private gv(int paramInt, String... paramVarArgs)
  {
    this.D = new int[] { paramInt };
    this.E = paramVarArgs;
  }
  
  private gv(int[] paramArrayOfInt, String... paramVarArgs)
  {
    this.D = paramArrayOfInt;
    this.E = paramVarArgs;
  }
  
  public static gv a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= 900)) {
      throw ft.a();
    }
    return (gv)B.get(Integer.valueOf(paramInt));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/gv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */