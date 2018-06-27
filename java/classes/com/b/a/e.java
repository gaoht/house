package com.b.a;

public final class e
{
  public static final double a = Math.sqrt(2.0D);
  
  public static double apertureToFStop(double paramDouble)
  {
    return Math.pow(a, paramDouble);
  }
  
  public static double shutterSpeedToExposureTime(double paramDouble)
  {
    return (float)(1.0D / Math.exp(Math.log(2.0D) * paramDouble));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */