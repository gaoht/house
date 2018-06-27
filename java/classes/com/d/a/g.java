package com.d.a;

import android.view.animation.Interpolator;
import java.util.ArrayList;

class g
  extends i
{
  private int g;
  private int h;
  private int i;
  private boolean j = true;
  
  public g(h.b... paramVarArgs)
  {
    super(paramVarArgs);
  }
  
  public g clone()
  {
    ArrayList localArrayList = this.e;
    int m = this.e.size();
    h.b[] arrayOfb = new h.b[m];
    int k = 0;
    while (k < m)
    {
      arrayOfb[k] = ((h.b)((h)localArrayList.get(k)).clone());
      k += 1;
    }
    return new g(arrayOfb);
  }
  
  public int getIntValue(float paramFloat)
  {
    int k = 1;
    float f1;
    if (this.a == 2)
    {
      if (this.j)
      {
        this.j = false;
        this.g = ((h.b)this.e.get(0)).getIntValue();
        this.h = ((h.b)this.e.get(1)).getIntValue();
        this.i = (this.h - this.g);
      }
      f1 = paramFloat;
      if (this.d != null) {
        f1 = this.d.getInterpolation(paramFloat);
      }
      if (this.f == null) {
        return this.g + (int)(this.i * f1);
      }
      return ((Number)this.f.evaluate(f1, Integer.valueOf(this.g), Integer.valueOf(this.h))).intValue();
    }
    h.b localb;
    int m;
    float f2;
    float f3;
    if (paramFloat <= 0.0F)
    {
      localObject = (h.b)this.e.get(0);
      localb = (h.b)this.e.get(1);
      k = ((h.b)localObject).getIntValue();
      m = localb.getIntValue();
      f2 = ((h.b)localObject).getFraction();
      f3 = localb.getFraction();
      localObject = localb.getInterpolator();
      f1 = paramFloat;
      if (localObject != null) {
        f1 = ((Interpolator)localObject).getInterpolation(paramFloat);
      }
      paramFloat = (f1 - f2) / (f3 - f2);
      if (this.f == null) {
        return (int)(paramFloat * (m - k)) + k;
      }
      return ((Number)this.f.evaluate(paramFloat, Integer.valueOf(k), Integer.valueOf(m))).intValue();
    }
    if (paramFloat >= 1.0F)
    {
      localObject = (h.b)this.e.get(this.a - 2);
      localb = (h.b)this.e.get(this.a - 1);
      k = ((h.b)localObject).getIntValue();
      m = localb.getIntValue();
      f2 = ((h.b)localObject).getFraction();
      f3 = localb.getFraction();
      localObject = localb.getInterpolator();
      f1 = paramFloat;
      if (localObject != null) {
        f1 = ((Interpolator)localObject).getInterpolation(paramFloat);
      }
      paramFloat = (f1 - f2) / (f3 - f2);
      if (this.f == null) {
        return (int)(paramFloat * (m - k)) + k;
      }
      return ((Number)this.f.evaluate(paramFloat, Integer.valueOf(k), Integer.valueOf(m))).intValue();
    }
    for (Object localObject = (h.b)this.e.get(0); k < this.a; localObject = localb)
    {
      localb = (h.b)this.e.get(k);
      if (paramFloat < localb.getFraction())
      {
        Interpolator localInterpolator = localb.getInterpolator();
        f1 = paramFloat;
        if (localInterpolator != null) {
          f1 = localInterpolator.getInterpolation(paramFloat);
        }
        paramFloat = (f1 - ((h.b)localObject).getFraction()) / (localb.getFraction() - ((h.b)localObject).getFraction());
        k = ((h.b)localObject).getIntValue();
        m = localb.getIntValue();
        if (this.f == null) {
          return (int)((m - k) * paramFloat) + k;
        }
        return ((Number)this.f.evaluate(paramFloat, Integer.valueOf(k), Integer.valueOf(m))).intValue();
      }
      k += 1;
    }
    return ((Number)((h)this.e.get(this.a - 1)).getValue()).intValue();
  }
  
  public Object getValue(float paramFloat)
  {
    return Integer.valueOf(getIntValue(paramFloat));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/d/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */