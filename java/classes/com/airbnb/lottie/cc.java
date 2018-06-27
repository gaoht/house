package com.airbnb.lottie;

import android.graphics.PointF;
import java.util.Collections;
import java.util.List;

class cc
  extends au<PointF>
{
  private final PointF b = new PointF();
  private final au<Float> c;
  private final au<Float> d;
  
  cc(au<Float> paramau1, au<Float> paramau2)
  {
    super(Collections.emptyList());
    this.c = paramau1;
    this.d = paramau2;
  }
  
  PointF a(at<PointF> paramat, float paramFloat)
  {
    return this.b;
  }
  
  public PointF getValue()
  {
    return a(null, 0.0F);
  }
  
  void setProgress(float paramFloat)
  {
    this.c.setProgress(paramFloat);
    this.d.setProgress(paramFloat);
    this.b.set(((Float)this.c.getValue()).floatValue(), ((Float)this.d.getValue()).floatValue());
    int i = 0;
    while (i < this.a.size())
    {
      ((n.a)this.a.get(i)).onValueChanged();
      i += 1;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/airbnb/lottie/cc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */