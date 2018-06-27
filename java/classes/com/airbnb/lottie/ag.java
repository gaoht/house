package com.airbnb.lottie;

class ag
{
  private final float[] a;
  private final int[] b;
  
  ag(float[] paramArrayOfFloat, int[] paramArrayOfInt)
  {
    this.a = paramArrayOfFloat;
    this.b = paramArrayOfInt;
  }
  
  void a(ag paramag1, ag paramag2, float paramFloat)
  {
    if (paramag1.b.length != paramag2.b.length) {
      throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + paramag1.b.length + " vs " + paramag2.b.length + ")");
    }
    int i = 0;
    while (i < paramag1.b.length)
    {
      this.a[i] = bd.a(paramag1.a[i], paramag2.a[i], paramFloat);
      this.b[i] = af.a(paramFloat, paramag1.b[i], paramag2.b[i]);
      i += 1;
    }
  }
  
  float[] a()
  {
    return this.a;
  }
  
  int[] b()
  {
    return this.b;
  }
  
  int c()
  {
    return this.b.length;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/airbnb/lottie/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */