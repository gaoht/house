package com.ziroom.ziroomcustomer.model;

import java.io.Serializable;

public class AssetTenant
  implements Serializable
{
  private int age;
  private String duty;
  private int sex;
  
  public int getAge()
  {
    return this.age;
  }
  
  public String getDuty()
  {
    return this.duty;
  }
  
  public int getSex()
  {
    return this.sex;
  }
  
  public void setAge(int paramInt)
  {
    this.age = paramInt;
  }
  
  public void setDuty(String paramString)
  {
    this.duty = paramString;
  }
  
  public void setSex(int paramInt)
  {
    this.sex = paramInt;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/AssetTenant.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */