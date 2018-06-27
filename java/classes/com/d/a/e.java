package com.d.a;

import android.view.animation.Interpolator;
import java.util.ArrayList;

class e
  extends i
{
  private float g;
  private float h;
  private float i;
  private boolean j = true;
  
  public e(h.a... paramVarArgs)
  {
    super(paramVarArgs);
  }
  
  public e clone()
  {
    ArrayList localArrayList = this.e;
    int m = this.e.size();
    h.a[] arrayOfa = new h.a[m];
    int k = 0;
    while (k < m)
    {
      arrayOfa[k] = ((h.a)((h)localArrayList.get(k)).clone());
      k += 1;
    }
    return new e(arrayOfa);
  }
  
  public float getFloatValue(float paramFloat)
  {
    int k = 1;
    float f1;
    if (this.a == 2)
    {
      if (this.j)
      {
        this.j = false;
        this.g = ((h.a)this.e.get(0)).getFloatValue();
        this.h = ((h.a)this.e.get(1)).getFloatValue();
        this.i = (this.h - this.g);
      }
      f1 = paramFloat;
      if (this.d != null) {
        f1 = this.d.getInterpolation(paramFloat);
      }
      if (this.f == null) {
        return this.g + this.i * f1;
      }
      return ((Number)this.f.evaluate(f1, Float.valueOf(this.g), Float.valueOf(this.h))).floatValue();
    }
    h.a locala;
    float f2;
    float f3;
    float f4;
    float f5;
    if (paramFloat <= 0.0F)
    {
      localObject = (h.a)this.e.get(0);
      locala = (h.a)this.e.get(1);
      f2 = ((h.a)localObject).getFloatValue();
      f3 = locala.getFloatValue();
      f4 = ((h.a)localObject).getFraction();
      f5 = locala.getFraction();
      localObject = locala.getInterpolator();
      f1 = paramFloat;
      if (localObject != null) {
        f1 = ((Interpolator)localObject).getInterpolation(paramFloat);
      }
      paramFloat = (f1 - f4) / (f5 - f4);
      if (this.f == null) {
        return paramFloat * (f3 - f2) + f2;
      }
      return ((Number)this.f.evaluate(paramFloat, Float.valueOf(f2), Float.valueOf(f3))).floatValue();
    }
    if (paramFloat >= 1.0F)
    {
      localObject = (h.a)this.e.get(this.a - 2);
      locala = (h.a)this.e.get(this.a - 1);
      f2 = ((h.a)localObject).getFloatValue();
      f3 = locala.getFloatValue();
      f4 = ((h.a)localObject).getFraction();
      f5 = locala.getFraction();
      localObject = locala.getInterpolator();
      f1 = paramFloat;
      if (localObject != null) {
        f1 = ((Interpolator)localObject).getInterpolation(paramFloat);
      }
      paramFloat = (f1 - f4) / (f5 - f4);
      if (this.f == null) {
        return paramFloat * (f3 - f2) + f2;
      }
      return ((Number)this.f.evaluate(paramFloat, Float.valueOf(f2), Float.valueOf(f3))).floatValue();
    }
    for (Object localObject = (h.a)this.e.get(0); k < this.a; localObject = locala)
    {
      locala = (h.a)this.e.get(k);
      if (paramFloat < locala.getFraction())
      {
        Interpolator localInterpolator = locala.getInterpolator();
        f1 = paramFloat;
        if (localInterpolator != null) {
          f1 = localInterpolator.getInterpolation(paramFloat);
        }
        paramFloat = (f1 - ((h.a)localObject).getFraction()) / (locala.getFraction() - ((h.a)localObject).getFraction());
        f1 = ((h.a)localObject).getFloatValue();
        f2 = locala.getFloatValue();
        if (this.f == null) {
          return (f2 - f1) * paramFloat + f1;
        }
        return ((Number)this.f.evaluate(paramFloat, Float.valueOf(f1), Float.valueOf(f2))).floatValue();
      }
      k += 1;
    }
    return ((Number)((h)this.e.get(this.a - 1)).getValue()).floatValue();
  }
  
  public Object getValue(float paramFloat)
  {
    return Float.valueOf(getFloatValue(paramFloat));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/d/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */