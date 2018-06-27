package com.ziroom.ziroomcustomer.signed;

import java.io.Serializable;

public class a
  implements Serializable
{
  private String a;
  private String b;
  private double c;
  private double d;
  
  public a() {}
  
  public a(String paramString1, String paramString2, double paramDouble1, double paramDouble2)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramDouble1;
    this.d = paramDouble2;
  }
  
  public String getAddress()
  {
    return this.b;
  }
  
  public double getLatitude()
  {
    return this.c;
  }
  
  public double getLongitude()
  {
    return this.d;
  }
  
  public String getName()
  {
    return this.a;
  }
  
  public void setAddress(String paramString)
  {
    this.b = paramString;
  }
  
  public void setLatitude(double paramDouble)
  {
    this.c = paramDouble;
  }
  
  public void setLongitude(double paramDouble)
  {
    this.d = paramDouble;
  }
  
  public void setName(String paramString)
  {
    this.a = paramString;
  }
  
  public String toString()
  {
    return "AptitudeAddressEntity{name='" + this.a + '\'' + ", address='" + this.b + '\'' + ", latitude=" + this.c + ", longitude=" + this.d + '}';
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */