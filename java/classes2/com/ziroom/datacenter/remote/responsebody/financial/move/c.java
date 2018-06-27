package com.ziroom.datacenter.remote.responsebody.financial.move;

import java.io.Serializable;

public class c
  implements Serializable
{
  private String a;
  private double b;
  private String c;
  private int d;
  private String e;
  private String f;
  private int g;
  
  public int getElevator()
  {
    return this.g;
  }
  
  public int getFloors()
  {
    return this.d;
  }
  
  public double getFloorsFee()
  {
    return this.b;
  }
  
  public String getFloorsFeeDescribe()
  {
    return this.c;
  }
  
  public String getFloorsFeeId()
  {
    return this.a;
  }
  
  public String getServiceInfoId()
  {
    return this.e;
  }
  
  public String getXmid()
  {
    return this.f;
  }
  
  public void setElevator(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void setFloors(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setFloorsFee(double paramDouble)
  {
    this.b = paramDouble;
  }
  
  public void setFloorsFeeDescribe(String paramString)
  {
    this.c = paramString;
  }
  
  public void setFloorsFeeId(String paramString)
  {
    this.a = paramString;
  }
  
  public void setServiceInfoId(String paramString)
  {
    this.e = paramString;
  }
  
  public void setXmid(String paramString)
  {
    this.f = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/datacenter/remote/responsebody/financial/move/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */