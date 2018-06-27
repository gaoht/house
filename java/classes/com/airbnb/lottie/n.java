package com.airbnb.lottie;

import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.List;

abstract class n<K, A>
{
  final List<a> a = new ArrayList();
  private boolean b = false;
  private final List<? extends at<K>> c;
  private float d = 0.0F;
  private at<K> e;
  
  n(List<? extends at<K>> paramList)
  {
    this.c = paramList;
  }
  
  private at<K> c()
  {
    int i = 0;
    if (this.c.isEmpty()) {
      throw new IllegalStateException("There are no keyframes");
    }
    if ((this.e != null) && (this.e.a(this.d))) {
      return this.e;
    }
    at localat2 = (at)this.c.get(0);
    at localat1 = localat2;
    if (this.d < localat2.a())
    {
      this.e = localat2;
      return localat2;
    }
    while ((!localat1.a(this.d)) && (i < this.c.size()))
    {
      localat1 = (at)this.c.get(i);
      i += 1;
    }
    this.e = localat1;
    return localat1;
  }
  
  private float d()
  {
    if (this.b) {}
    at localat;
    do
    {
      return 0.0F;
      localat = c();
    } while (localat.c());
    float f1 = this.d;
    float f2 = localat.a();
    float f3 = localat.b();
    float f4 = localat.a();
    return localat.c.getInterpolation((f1 - f2) / (f3 - f4));
  }
  
  private float e()
  {
    if (this.c.isEmpty()) {
      return 0.0F;
    }
    return ((at)this.c.get(0)).a();
  }
  
  private float f()
  {
    if (this.c.isEmpty()) {
      return 1.0F;
    }
    return ((at)this.c.get(this.c.size() - 1)).b();
  }
  
  void a()
  {
    this.b = true;
  }
  
  void a(a parama)
  {
    this.a.add(parama);
  }
  
  float b()
  {
    return this.d;
  }
  
  public A getValue()
  {
    return (A)getValue(c(), d());
  }
  
  abstract A getValue(at<K> paramat, float paramFloat);
  
  void setProgress(float paramFloat)
  {
    float f;
    if (paramFloat < e())
    {
      f = 0.0F;
      if (f != this.d) {
        break label37;
      }
    }
    for (;;)
    {
      return;
      f = paramFloat;
      if (paramFloat <= f()) {
        break;
      }
      f = 1.0F;
      break;
      label37:
      this.d = f;
      int i = 0;
      while (i < this.a.size())
      {
        ((a)this.a.get(i)).onValueChanged();
        i += 1;
      }
    }
  }
  
  static abstract interface a
  {
    public abstract void onValueChanged();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/airbnb/lottie/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */