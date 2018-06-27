package cn.testin.analysis;

import java.util.Map;

public final class hx
{
  private final hh a = new hh(hf.a);
  
  private gw a(hk paramhk, Map<fs, ?> paramMap)
  {
    ic localic = paramhk.b();
    hy localhy = paramhk.a().a();
    paramhk = hl.a(paramhk.c(), localic, localhy);
    int k = paramhk.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      j += paramhk[i].a();
      i += 1;
    }
    byte[] arrayOfByte1 = new byte[j];
    int m = paramhk.length;
    j = 0;
    i = 0;
    while (j < m)
    {
      Object localObject = paramhk[j];
      byte[] arrayOfByte2 = ((hl)localObject).b();
      int n = ((hl)localObject).a();
      a(arrayOfByte2, n);
      k = 0;
      while (k < n)
      {
        arrayOfByte1[i] = arrayOfByte2[k];
        k += 1;
        i += 1;
      }
      j += 1;
    }
    return hv.a(arrayOfByte1, localic, localhy, paramMap);
  }
  
  private void a(byte[] paramArrayOfByte, int paramInt)
  {
    int j = 0;
    int k = paramArrayOfByte.length;
    int[] arrayOfInt = new int[k];
    int i = 0;
    while (i < k)
    {
      paramArrayOfByte[i] &= 0xFF;
      i += 1;
    }
    try
    {
      this.a.a(arrayOfInt, paramArrayOfByte.length - paramInt);
      i = j;
      while (i < paramInt)
      {
        paramArrayOfByte[i] = ((byte)arrayOfInt[i]);
        i += 1;
      }
      return;
    }
    catch (hi paramArrayOfByte)
    {
      throw fr.a();
    }
  }
  
  /* Error */
  public gw a(gt paramgt, Map<fs, ?> paramMap)
  {
    // Byte code:
    //   0: new 26	cn/testin/analysis/hk
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 78	cn/testin/analysis/hk:<init>	(Lcn/testin/analysis/gt;)V
    //   8: astore 4
    //   10: aload_0
    //   11: aload 4
    //   13: aload_2
    //   14: invokespecial 80	cn/testin/analysis/hx:a	(Lcn/testin/analysis/hk;Ljava/util/Map;)Lcn/testin/analysis/gw;
    //   17: astore_1
    //   18: aload_1
    //   19: areturn
    //   20: astore_3
    //   21: aconst_null
    //   22: astore_1
    //   23: aload 4
    //   25: invokevirtual 83	cn/testin/analysis/hk:d	()V
    //   28: aload 4
    //   30: iconst_1
    //   31: invokevirtual 86	cn/testin/analysis/hk:a	(Z)V
    //   34: aload 4
    //   36: invokevirtual 30	cn/testin/analysis/hk:b	()Lcn/testin/analysis/ic;
    //   39: pop
    //   40: aload 4
    //   42: invokevirtual 33	cn/testin/analysis/hk:a	()Lcn/testin/analysis/hz;
    //   45: pop
    //   46: aload 4
    //   48: invokevirtual 89	cn/testin/analysis/hk:e	()V
    //   51: aload_0
    //   52: aload 4
    //   54: aload_2
    //   55: invokespecial 80	cn/testin/analysis/hx:a	(Lcn/testin/analysis/hk;Ljava/util/Map;)Lcn/testin/analysis/gw;
    //   58: astore_2
    //   59: aload_2
    //   60: new 91	cn/testin/analysis/ib
    //   63: dup
    //   64: iconst_1
    //   65: invokespecial 93	cn/testin/analysis/ib:<init>	(Z)V
    //   68: invokevirtual 98	cn/testin/analysis/gw:a	(Ljava/lang/Object;)V
    //   71: aload_2
    //   72: areturn
    //   73: astore_2
    //   74: aload_3
    //   75: ifnull +11 -> 86
    //   78: aload_3
    //   79: athrow
    //   80: astore_1
    //   81: aconst_null
    //   82: astore_3
    //   83: goto -60 -> 23
    //   86: aload_1
    //   87: ifnull +5 -> 92
    //   90: aload_1
    //   91: athrow
    //   92: aload_2
    //   93: athrow
    //   94: astore_2
    //   95: goto -21 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	this	hx
    //   0	98	1	paramgt	gt
    //   0	98	2	paramMap	Map<fs, ?>
    //   20	59	3	localft	ft
    //   82	1	3	localObject	Object
    //   8	45	4	localhk	hk
    // Exception table:
    //   from	to	target	type
    //   10	18	20	cn/testin/analysis/ft
    //   23	71	73	cn/testin/analysis/ft
    //   10	18	80	cn/testin/analysis/fr
    //   23	71	94	cn/testin/analysis/fr
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/hx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */