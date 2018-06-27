package com.ziroom.ziroomcustomer.model;

import java.io.Serializable;

public class HouseRoommate
  implements Serializable, Comparable
{
  private String gender;
  private String header_image;
  private String house_code;
  private String house_company;
  private String house_dzz;
  private String house_type;
  private String room_code;
  private String room_photos;
  private String room_price;
  private String show_type;
  private String sublet_attestation;
  private String xingzuo;
  
  public int compareTo(Object paramObject)
  {
    paramObject = (HouseRoommate)paramObject;
    try
    {
      int i = Integer.parseInt(this.house_code);
      int j = Integer.parseInt(((HouseRoommate)paramObject).getHouse_code());
      return i - j;
    }
    catch (NumberFormatException paramObject)
    {
      ((NumberFormatException)paramObject).printStackTrace();
    }
    return 0;
  }
  
  public String getGender()
  {
    return this.gender;
  }
  
  public String getHeader_image()
  {
    return this.header_image;
  }
  
  public String getHouse_code()
  {
    return this.house_code;
  }
  
  public String getHouse_company()
  {
    return this.house_company;
  }
  
  public String getHouse_dzz()
  {
    return this.house_dzz;
  }
  
  public String getHouse_type()
  {
    return this.house_type;
  }
  
  public String getRoom_code()
  {
    return this.room_code;
  }
  
  public String getRoom_photos()
  {
    return this.room_photos;
  }
  
  public String getRoom_price()
  {
    return this.room_price;
  }
  
  public String getShow_type()
  {
    return this.show_type;
  }
  
  public String getSublet_attestation()
  {
    return this.sublet_attestation;
  }
  
  public String getXingzuo()
  {
    return this.xingzuo;
  }
  
  public void setGender(String paramString)
  {
    this.gender = paramString;
  }
  
  public void setHeader_image(String paramString)
  {
    this.header_image = paramString;
  }
  
  public void setHouse_code(String paramString)
  {
    this.house_code = paramString;
  }
  
  public void setHouse_company(String paramString)
  {
    this.house_company = paramString;
  }
  
  public void setHouse_dzz(String paramString)
  {
    this.house_dzz = paramString;
  }
  
  public void setHouse_type(String paramString)
  {
    this.house_type = paramString;
  }
  
  public void setRoom_code(String paramString)
  {
    this.room_code = paramString;
  }
  
  public void setRoom_photos(String paramString)
  {
    this.room_photos = paramString;
  }
  
  public void setRoom_price(String paramString)
  {
    this.room_price = paramString;
  }
  
  public void setShow_type(String paramString)
  {
    this.show_type = paramString;
  }
  
  public void setSublet_attestation(String paramString)
  {
    this.sublet_attestation = paramString;
  }
  
  public void setXingzuo(String paramString)
  {
    this.xingzuo = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/HouseRoommate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */