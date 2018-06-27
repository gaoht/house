package com.b.b;

import java.text.DecimalFormat;

public final class g
{
  private final double a;
  private final double b;
  
  public g(double paramDouble1, double paramDouble2)
  {
    this.a = paramDouble1;
    this.b = paramDouble2;
  }
  
  public static double[] decimalToDegreesMinutesSeconds(double paramDouble)
  {
    int i = (int)paramDouble;
    paramDouble = Math.abs(paramDouble % 1.0D * 60.0D);
    return new double[] { i, (int)paramDouble, paramDouble % 1.0D * 60.0D };
  }
  
  public static String decimalToDegreesMinutesSecondsString(double paramDouble)
  {
    double[] arrayOfDouble = decimalToDegreesMinutesSeconds(paramDouble);
    DecimalFormat localDecimalFormat = new DecimalFormat("0.##");
    return String.format("%s° %s' %s\"", new Object[] { localDecimalFormat.format(arrayOfDouble[0]), localDecimalFormat.format(arrayOfDouble[1]), localDecimalFormat.format(arrayOfDouble[2]) });
  }
  
  public static Double degreesMinutesSecondsToDecimal(l paraml1, l paraml2, l paraml3, boolean paramBoolean)
  {
    double d2 = Math.abs(paraml1.doubleValue()) + paraml2.doubleValue() / 60.0D + paraml3.doubleValue() / 3600.0D;
    if (Double.isNaN(d2)) {
      return null;
    }
    double d1 = d2;
    if (paramBoolean) {
      d1 = d2 * -1.0D;
    }
    return Double.valueOf(d1);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (g)paramObject;
      if (Double.compare(((g)paramObject).a, this.a) != 0) {
        return false;
      }
    } while (Double.compare(((g)paramObject).b, this.b) == 0);
    return false;
  }
  
  public double getLatitude()
  {
    return this.a;
  }
  
  public double getLongitude()
  {
    return this.b;
  }
  
  public int hashCode()
  {
    long l2 = 0L;
    if (this.a != 0.0D) {}
    for (long l1 = Double.doubleToLongBits(this.a);; l1 = 0L)
    {
      int i = (int)(l1 ^ l1 >>> 32);
      l1 = l2;
      if (this.b != 0.0D) {
        l1 = Double.doubleToLongBits(this.b);
      }
      return i * 31 + (int)(l1 ^ l1 >>> 32);
    }
  }
  
  public boolean isZero()
  {
    return (this.a == 0.0D) && (this.b == 0.0D);
  }
  
  public String toDMSString()
  {
    return decimalToDegreesMinutesSecondsString(this.a) + ", " + decimalToDegreesMinutesSecondsString(this.b);
  }
  
  public String toString()
  {
    return this.a + ", " + this.b;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/b/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */