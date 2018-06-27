package com.ziroom.credit.view.rose;

public class b
{
  public static a calculateCoordinate(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, double paramDouble)
  {
    double d8 = Math.toRadians(paramDouble);
    paramDouble = paramFloat3 - paramFloat1;
    double d1 = Math.cos(d8);
    double d2 = paramFloat4 - paramFloat2;
    double d3 = Math.sin(d8);
    double d4 = paramFloat1;
    double d5 = paramFloat3 - paramFloat1;
    double d6 = Math.sin(d8);
    double d7 = paramFloat4 - paramFloat2;
    d8 = Math.cos(d8);
    double d9 = paramFloat2;
    return new a((float)(paramDouble * d1 - d2 * d3 + d4), (float)(d8 * d7 + d5 * d6 + d9));
  }
  
  public static double distance4PointF(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramFloat1 -= paramFloat3;
    paramFloat2 -= paramFloat4;
    return Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2);
  }
  
  public static int getRoatationTo(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    if ((paramFloat1 - paramFloat5) * (paramFloat4 - paramFloat6) - (paramFloat2 - paramFloat6) * (paramFloat3 - paramFloat5) < 0.0F) {
      return 1;
    }
    return -1;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/credit/view/rose/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */