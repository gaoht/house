package com.airbnb.lottie;

import android.graphics.PointF;

class i
  implements k<PointF>
{
  private final b a;
  private final b b;
  
  i(b paramb1, b paramb2)
  {
    this.a = paramb1;
    this.b = paramb2;
  }
  
  public au<PointF> createAnimation()
  {
    return new cc(this.a.createAnimation(), this.b.createAnimation());
  }
  
  public boolean hasAnimation()
  {
    return (this.a.hasAnimation()) || (this.b.hasAnimation());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/airbnb/lottie/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */