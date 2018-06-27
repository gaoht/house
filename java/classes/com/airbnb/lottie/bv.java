package com.airbnb.lottie;

import android.graphics.Path;
import java.util.List;

class bv
  extends n<bs, Path>
{
  private final bs b = new bs();
  private final Path c = new Path();
  
  bv(List<at<bs>> paramList)
  {
    super(paramList);
  }
  
  public Path getValue(at<bs> paramat, float paramFloat)
  {
    bs localbs = (bs)paramat.a;
    paramat = (bs)paramat.b;
    this.b.a(localbs, paramat, paramFloat);
    bd.a(this.b, this.c);
    return this.c;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/airbnb/lottie/bv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */