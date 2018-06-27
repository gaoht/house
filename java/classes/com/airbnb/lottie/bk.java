package com.airbnb.lottie;

import android.graphics.PointF;
import java.util.List;

class bk
  extends au<PointF>
{
  private final PointF b = new PointF();
  
  bk(List<at<PointF>> paramList)
  {
    super(paramList);
  }
  
  public PointF getValue(at<PointF> paramat, float paramFloat)
  {
    if ((paramat.a == null) || (paramat.b == null)) {
      throw new IllegalStateException("Missing values for keyframe.");
    }
    PointF localPointF1 = (PointF)paramat.a;
    paramat = (PointF)paramat.b;
    PointF localPointF2 = this.b;
    float f1 = localPointF1.x;
    float f2 = paramat.x;
    float f3 = localPointF1.x;
    float f4 = localPointF1.y;
    localPointF2.set(f1 + (f2 - f3) * paramFloat, (paramat.y - localPointF1.y) * paramFloat + f4);
    return this.b;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/airbnb/lottie/bk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */