package com.baidu.trace.model;

public class ProcessOption
{
  private boolean a = true;
  private boolean b = true;
  private boolean c = false;
  private int d = 0;
  private TransportMode e = TransportMode.driving;
  
  public ProcessOption() {}
  
  public ProcessOption(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt, TransportMode paramTransportMode)
  {
    this.a = paramBoolean1;
    this.b = paramBoolean2;
    this.c = paramBoolean3;
    this.d = paramInt;
    this.e = paramTransportMode;
  }
  
  public int getRadiusThreshold()
  {
    return this.d;
  }
  
  public TransportMode getTransportMode()
  {
    return this.e;
  }
  
  public boolean isNeedDenoise()
  {
    return this.a;
  }
  
  public boolean isNeedMapMatch()
  {
    return this.c;
  }
  
  public boolean isNeedVacuate()
  {
    return this.b;
  }
  
  public ProcessOption setNeedDenoise(boolean paramBoolean)
  {
    this.a = paramBoolean;
    return this;
  }
  
  public ProcessOption setNeedMapMatch(boolean paramBoolean)
  {
    this.c = paramBoolean;
    return this;
  }
  
  public ProcessOption setNeedVacuate(boolean paramBoolean)
  {
    this.b = paramBoolean;
    return this;
  }
  
  public ProcessOption setRadiusThreshold(int paramInt)
  {
    this.d = paramInt;
    return this;
  }
  
  public ProcessOption setTransportMode(TransportMode paramTransportMode)
  {
    this.e = paramTransportMode;
    return this;
  }
  
  public String toString()
  {
    return "ProcessOption [needDenoise=" + this.a + ", needVacuate=" + this.b + ", needMapMatch=" + this.c + ", radiusThreshold=" + this.d + ", transportMode=" + this.e + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/model/ProcessOption.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */