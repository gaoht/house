package com.d.a;

import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Arrays;

class i
{
  int a;
  h b;
  h c;
  Interpolator d;
  ArrayList<h> e;
  m f;
  
  public i(h... paramVarArgs)
  {
    this.a = paramVarArgs.length;
    this.e = new ArrayList();
    this.e.addAll(Arrays.asList(paramVarArgs));
    this.b = ((h)this.e.get(0));
    this.c = ((h)this.e.get(this.a - 1));
    this.d = this.c.getInterpolator();
  }
  
  public static i ofFloat(float... paramVarArgs)
  {
    int i = 1;
    int j = paramVarArgs.length;
    h.a[] arrayOfa = new h.a[Math.max(j, 2)];
    if (j == 1)
    {
      arrayOfa[0] = ((h.a)h.ofFloat(0.0F));
      arrayOfa[1] = ((h.a)h.ofFloat(1.0F, paramVarArgs[0]));
    }
    for (;;)
    {
      return new e(arrayOfa);
      arrayOfa[0] = ((h.a)h.ofFloat(0.0F, paramVarArgs[0]));
      while (i < j)
      {
        arrayOfa[i] = ((h.a)h.ofFloat(i / (j - 1), paramVarArgs[i]));
        i += 1;
      }
    }
  }
  
  public static i ofInt(int... paramVarArgs)
  {
    int i = 1;
    int j = paramVarArgs.length;
    h.b[] arrayOfb = new h.b[Math.max(j, 2)];
    if (j == 1)
    {
      arrayOfb[0] = ((h.b)h.ofInt(0.0F));
      arrayOfb[1] = ((h.b)h.ofInt(1.0F, paramVarArgs[0]));
    }
    for (;;)
    {
      return new g(arrayOfb);
      arrayOfb[0] = ((h.b)h.ofInt(0.0F, paramVarArgs[0]));
      while (i < j)
      {
        arrayOfb[i] = ((h.b)h.ofInt(i / (j - 1), paramVarArgs[i]));
        i += 1;
      }
    }
  }
  
  public static i ofKeyframe(h... paramVarArgs)
  {
    int n = 0;
    int i1 = paramVarArgs.length;
    int i = 0;
    int m = 0;
    int k = 0;
    int j = 0;
    if (i < i1)
    {
      if ((paramVarArgs[i] instanceof h.a)) {
        j = 1;
      }
      for (;;)
      {
        i += 1;
        break;
        if ((paramVarArgs[i] instanceof h.b)) {
          k = 1;
        } else {
          m = 1;
        }
      }
    }
    Object localObject;
    if ((j != 0) && (k == 0) && (m == 0))
    {
      localObject = new h.a[i1];
      i = n;
      while (i < i1)
      {
        localObject[i] = ((h.a)paramVarArgs[i]);
        i += 1;
      }
      return new e((h.a[])localObject);
    }
    if ((k != 0) && (j == 0) && (m == 0))
    {
      localObject = new h.b[i1];
      i = 0;
      while (i < i1)
      {
        localObject[i] = ((h.b)paramVarArgs[i]);
        i += 1;
      }
      return new g((h.b[])localObject);
    }
    return new i(paramVarArgs);
  }
  
  public static i ofObject(Object... paramVarArgs)
  {
    int i = 1;
    int j = paramVarArgs.length;
    h.c[] arrayOfc = new h.c[Math.max(j, 2)];
    if (j == 1)
    {
      arrayOfc[0] = ((h.c)h.ofObject(0.0F));
      arrayOfc[1] = ((h.c)h.ofObject(1.0F, paramVarArgs[0]));
    }
    for (;;)
    {
      return new i(arrayOfc);
      arrayOfc[0] = ((h.c)h.ofObject(0.0F, paramVarArgs[0]));
      while (i < j)
      {
        arrayOfc[i] = ((h.c)h.ofObject(i / (j - 1), paramVarArgs[i]));
        i += 1;
      }
    }
  }
  
  public i clone()
  {
    ArrayList localArrayList = this.e;
    int j = this.e.size();
    h[] arrayOfh = new h[j];
    int i = 0;
    while (i < j)
    {
      arrayOfh[i] = ((h)localArrayList.get(i)).clone();
      i += 1;
    }
    return new i(arrayOfh);
  }
  
  public Object getValue(float paramFloat)
  {
    float f1;
    if (this.a == 2)
    {
      f1 = paramFloat;
      if (this.d != null) {
        f1 = this.d.getInterpolation(paramFloat);
      }
      return this.f.evaluate(f1, this.b.getValue(), this.c.getValue());
    }
    Object localObject2;
    if (paramFloat <= 0.0F)
    {
      localObject1 = (h)this.e.get(1);
      localObject2 = ((h)localObject1).getInterpolator();
      f1 = paramFloat;
      if (localObject2 != null) {
        f1 = ((Interpolator)localObject2).getInterpolation(paramFloat);
      }
      paramFloat = this.b.getFraction();
      paramFloat = (f1 - paramFloat) / (((h)localObject1).getFraction() - paramFloat);
      return this.f.evaluate(paramFloat, this.b.getValue(), ((h)localObject1).getValue());
    }
    if (paramFloat >= 1.0F)
    {
      localObject1 = (h)this.e.get(this.a - 2);
      localObject2 = this.c.getInterpolator();
      f1 = paramFloat;
      if (localObject2 != null) {
        f1 = ((Interpolator)localObject2).getInterpolation(paramFloat);
      }
      paramFloat = ((h)localObject1).getFraction();
      paramFloat = (f1 - paramFloat) / (this.c.getFraction() - paramFloat);
      return this.f.evaluate(paramFloat, ((h)localObject1).getValue(), this.c.getValue());
    }
    Object localObject1 = this.b;
    int i = 1;
    while (i < this.a)
    {
      localObject2 = (h)this.e.get(i);
      if (paramFloat < ((h)localObject2).getFraction())
      {
        Interpolator localInterpolator = ((h)localObject2).getInterpolator();
        f1 = paramFloat;
        if (localInterpolator != null) {
          f1 = localInterpolator.getInterpolation(paramFloat);
        }
        paramFloat = ((h)localObject1).getFraction();
        paramFloat = (f1 - paramFloat) / (((h)localObject2).getFraction() - paramFloat);
        return this.f.evaluate(paramFloat, ((h)localObject1).getValue(), ((h)localObject2).getValue());
      }
      i += 1;
      localObject1 = localObject2;
    }
    return this.c.getValue();
  }
  
  public void setEvaluator(m paramm)
  {
    this.f = paramm;
  }
  
  public String toString()
  {
    String str = " ";
    int i = 0;
    while (i < this.a)
    {
      str = str + ((h)this.e.get(i)).getValue() + "  ";
      i += 1;
    }
    return str;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/d/a/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */