package com.airbnb.lottie;

import java.util.List;

class bp
  extends au<bq>
{
  bp(List<at<bq>> paramList)
  {
    super(paramList);
  }
  
  public bq getValue(at<bq> paramat, float paramFloat)
  {
    if ((paramat.a == null) || (paramat.b == null)) {
      throw new IllegalStateException("Missing values for keyframe.");
    }
    bq localbq = (bq)paramat.a;
    paramat = (bq)paramat.b;
    return new bq(bd.a(localbq.a(), paramat.a(), paramFloat), bd.a(localbq.b(), paramat.b(), paramFloat));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/airbnb/lottie/bp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */