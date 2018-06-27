package com.airbnb.lottie;

import java.util.List;

class aq
  extends au<Integer>
{
  aq(List<at<Integer>> paramList)
  {
    super(paramList);
  }
  
  Integer a(at<Integer> paramat, float paramFloat)
  {
    if ((paramat.a == null) || (paramat.b == null)) {
      throw new IllegalStateException("Missing values for keyframe.");
    }
    return Integer.valueOf(bd.a(((Integer)paramat.a).intValue(), ((Integer)paramat.b).intValue(), paramFloat));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/airbnb/lottie/aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */