package com.ziroom.ziroomcustomer.newrepair.b;

import java.io.Serializable;

public class k
  implements Serializable
{
  private String a;
  private String b;
  private double c;
  private double d;
  private double e;
  private int f;
  
  public double getPrice()
  {
    return this.c;
  }
  
  public String getSchemeId()
  {
    return this.a;
  }
  
  public String getSchemeName()
  {
    return this.b;
  }
  
  public double getTaxRate()
  {
    return this.d;
  }
  
  public double getTotalPrice()
  {
    return this.e;
  }
  
  public int getUsedNum()
  {
    return this.f;
  }
  
  public void setPrice(double paramDouble)
  {
    this.c = paramDouble;
  }
  
  public void setSchemeId(String paramString)
  {
    this.a = paramString;
  }
  
  public void setSchemeName(String paramString)
  {
    this.b = paramString;
  }
  
  public void setTaxRate(double paramDouble)
  {
    this.d = paramDouble;
  }
  
  public void setTotalPrice(double paramDouble)
  {
    this.e = paramDouble;
  }
  
  public void setUsedNum(int paramInt)
  {
    this.f = paramInt;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newrepair/b/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */