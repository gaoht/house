package com.airbnb.lottie;

import java.util.List;

class ae
  extends au<Float>
{
  ae(List<at<Float>> paramList)
  {
    super(paramList);
  }
  
  Float a(at<Float> paramat, float paramFloat)
  {
    if ((paramat.a == null) || (paramat.b == null)) {
      throw new IllegalStateException("Missing values for keyframe.");
    }
    return Float.valueOf(bd.a(((Float)paramat.a).floatValue(), ((Float)paramat.b).floatValue(), paramFloat));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/airbnb/lottie/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */