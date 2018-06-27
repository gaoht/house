package cn.testin.analysis;

public abstract class ha
{
  private static ha a = new gx();
  
  public static ha a()
  {
    return a;
  }
  
  protected static void a(gt paramgt, float[] paramArrayOfFloat)
  {
    int k = paramgt.c();
    int m = paramgt.d();
    int j = 0;
    int i = 1;
    int n;
    if ((j < paramArrayOfFloat.length) && (i != 0))
    {
      i = (int)paramArrayOfFloat[j];
      n = (int)paramArrayOfFloat[(j + 1)];
      if ((i < -1) || (i > k) || (n < -1) || (n > m)) {
        throw fw.a();
      }
      if (i == -1)
      {
        paramArrayOfFloat[j] = 0.0F;
        i = 1;
      }
    }
    for (;;)
    {
      label78:
      if (n == -1)
      {
        paramArrayOfFloat[(j + 1)] = 0.0F;
        i = 1;
      }
      for (;;)
      {
        j += 2;
        break;
        if (i != k) {
          break label275;
        }
        paramArrayOfFloat[j] = (k - 1);
        i = 1;
        break label78;
        if (n == m)
        {
          paramArrayOfFloat[(j + 1)] = (m - 1);
          i = 1;
        }
      }
      j = paramArrayOfFloat.length - 2;
      i = 1;
      if ((j >= 0) && (i != 0))
      {
        i = (int)paramArrayOfFloat[j];
        n = (int)paramArrayOfFloat[(j + 1)];
        if ((i < -1) || (i > k) || (n < -1) || (n > m)) {
          throw fw.a();
        }
        if (i == -1)
        {
          paramArrayOfFloat[j] = 0.0F;
          i = 1;
        }
      }
      for (;;)
      {
        label207:
        if (n == -1)
        {
          paramArrayOfFloat[(j + 1)] = 0.0F;
          i = 1;
        }
        for (;;)
        {
          j -= 2;
          break;
          if (i != k) {
            break label270;
          }
          paramArrayOfFloat[j] = (k - 1);
          i = 1;
          break label207;
          if (n == m)
          {
            paramArrayOfFloat[(j + 1)] = (m - 1);
            i = 1;
          }
        }
        return;
        label270:
        i = 0;
      }
      label275:
      i = 0;
    }
  }
  
  public abstract gt a(gt paramgt, int paramInt1, int paramInt2, hc paramhc);
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/ha.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */