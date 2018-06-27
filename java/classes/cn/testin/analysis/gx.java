package cn.testin.analysis;

public final class gx
  extends ha
{
  public gt a(gt paramgt, int paramInt1, int paramInt2, hc paramhc)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
      throw fw.a();
    }
    gt localgt = new gt(paramInt1, paramInt2);
    float[] arrayOfFloat = new float[paramInt1 * 2];
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      int j = arrayOfFloat.length;
      float f = paramInt1;
      int i = 0;
      while (i < j)
      {
        arrayOfFloat[i] = (i / 2 + 0.5F);
        arrayOfFloat[(i + 1)] = (f + 0.5F);
        i += 2;
      }
      paramhc.a(arrayOfFloat);
      a(paramgt, arrayOfFloat);
      i = 0;
      while (i < j) {
        try
        {
          if (paramgt.a((int)arrayOfFloat[i], (int)arrayOfFloat[(i + 1)])) {
            localgt.b(i / 2, paramInt1);
          }
          i += 2;
        }
        catch (ArrayIndexOutOfBoundsException paramgt)
        {
          throw fw.a();
        }
      }
      paramInt1 += 1;
    }
    return localgt;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/gx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */