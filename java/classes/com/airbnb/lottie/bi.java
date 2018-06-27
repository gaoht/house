package com.airbnb.lottie;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;

class bi
  extends au<PointF>
{
  private final PointF b = new PointF();
  private final float[] c = new float[2];
  private bh d;
  private PathMeasure e;
  
  bi(List<? extends at<PointF>> paramList)
  {
    super(paramList);
  }
  
  public PointF getValue(at<PointF> paramat, float paramFloat)
  {
    bh localbh = (bh)paramat;
    Path localPath = localbh.e();
    if (localPath == null) {
      return (PointF)paramat.a;
    }
    if (this.d != localbh)
    {
      this.e = new PathMeasure(localPath, false);
      this.d = localbh;
    }
    this.e.getPosTan(this.e.getLength() * paramFloat, this.c, null);
    this.b.set(this.c[0], this.c[1]);
    return this.b;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/airbnb/lottie/bi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */