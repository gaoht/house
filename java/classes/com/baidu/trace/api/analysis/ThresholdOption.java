package com.baidu.trace.api.analysis;

public final class ThresholdOption
{
  private double a;
  private double b;
  private double c;
  private double d;
  
  public ThresholdOption() {}
  
  public ThresholdOption(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    this.a = paramDouble1;
    this.b = paramDouble2;
    this.c = paramDouble3;
    this.d = paramDouble4;
  }
  
  public final double getHarshAccelerationThreshold()
  {
    return this.b;
  }
  
  public final double getHarshBreakingThreshold()
  {
    return this.c;
  }
  
  public final double getHarshSteeringThreshold()
  {
    return this.d;
  }
  
  public final double getSpeedingThreshold()
  {
    return this.a;
  }
  
  public final ThresholdOption setHarshAccelerationThreshold(double paramDouble)
  {
    this.b = paramDouble;
    return this;
  }
  
  public final ThresholdOption setHarshBreakingThreshold(double paramDouble)
  {
    this.c = paramDouble;
    return this;
  }
  
  public final ThresholdOption setHarshSteeringThreshold(double paramDouble)
  {
    this.d = paramDouble;
    return this;
  }
  
  public final ThresholdOption setSpeedingThreshold(double paramDouble)
  {
    this.a = paramDouble;
    return this;
  }
  
  public final String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("ThresholdOption{");
    localStringBuffer.append("speedingThreshold=").append(this.a);
    localStringBuffer.append(", harshAccelerationThreshold=").append(this.b);
    localStringBuffer.append(", harshBreakingThreshold=").append(this.c);
    localStringBuffer.append(", harshSteeringThreshold=").append(this.d);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/api/analysis/ThresholdOption.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */