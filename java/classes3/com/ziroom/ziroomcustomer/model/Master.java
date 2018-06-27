package com.ziroom.ziroomcustomer.model;

import java.io.Serializable;

public class Master
  implements Serializable
{
  private String carSign;
  private int id;
  private String name;
  private String nativeplace;
  private String phone;
  private String photourl;
  private float scroe;
  private String status;
  private int times;
  
  public String getCarSign()
  {
    return this.carSign;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getNativeplace()
  {
    return this.nativeplace;
  }
  
  public String getPhone()
  {
    return this.phone;
  }
  
  public String getPhotourl()
  {
    return this.photourl;
  }
  
  public float getScroe()
  {
    return this.scroe;
  }
  
  public String getStatus()
  {
    return this.status;
  }
  
  public int getTimes()
  {
    return this.times;
  }
  
  public void setCarSign(String paramString)
  {
    this.carSign = paramString;
  }
  
  public void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setNativeplace(String paramString)
  {
    this.nativeplace = paramString;
  }
  
  public void setPhone(String paramString)
  {
    this.phone = paramString;
  }
  
  public void setPhotourl(String paramString)
  {
    this.photourl = paramString;
  }
  
  public void setScroe(float paramFloat)
  {
    this.scroe = paramFloat;
  }
  
  public void setStatus(String paramString)
  {
    this.status = paramString;
  }
  
  public void setTimes(int paramInt)
  {
    this.times = paramInt;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/Master.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */