package com.airbnb.lottie;

import java.util.List;

class u
  extends au<Integer>
{
  u(List<at<Integer>> paramList)
  {
    super(paramList);
  }
  
  public Integer getValue(at<Integer> paramat, float paramFloat)
  {
    if ((paramat.a == null) || (paramat.b == null)) {
      throw new IllegalStateException("Missing values for keyframe.");
    }
    return Integer.valueOf(af.a(paramFloat, ((Integer)paramat.a).intValue(), ((Integer)paramat.b).intValue()));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/airbnb/lottie/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */