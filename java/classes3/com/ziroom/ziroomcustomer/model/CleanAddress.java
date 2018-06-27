package com.ziroom.ziroomcustomer.model;

public class CleanAddress
{
  private String address;
  private String doorplate;
  private int id;
  private String uid;
  
  public CleanAddress(String paramString1, String paramString2, int paramInt)
  {
    this.address = paramString1;
    this.doorplate = paramString2;
    this.id = paramInt;
  }
  
  public CleanAddress(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this.uid = paramString1;
    this.address = paramString2;
    this.doorplate = paramString3;
    this.id = paramInt;
  }
  
  public String getAddress()
  {
    return this.address;
  }
  
  public String getDoorplate()
  {
    return this.doorplate;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public String getUid()
  {
    return this.uid;
  }
  
  public void setAddress(String paramString)
  {
    this.address = paramString;
  }
  
  public void setDoorplate(String paramString)
  {
    this.doorplate = paramString;
  }
  
  public void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public void setUid(String paramString)
  {
    this.uid = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/CleanAddress.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */