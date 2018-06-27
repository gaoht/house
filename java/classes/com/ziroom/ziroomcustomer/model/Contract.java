package com.ziroom.ziroomcustomer.model;

import java.io.Serializable;

public class Contract
  implements Serializable
{
  private String address;
  private String city_code;
  private String contract_code;
  private String contract_state;
  private String contract_type;
  private String effect_date;
  private String hire_commissioner_code;
  private String hire_commissioner_name;
  private String hire_commissioner_phone;
  private String hire_contract_code;
  private String house_code;
  private Integer id;
  private String isZiroom;
  private String latitude;
  private String longitude;
  private String old_contract_code;
  private Integer payment;
  private String price;
  private String room_code;
  private String stop_date;
  private String uid;
  
  public String getAddress()
  {
    return this.address;
  }
  
  public String getCity_code()
  {
    return this.city_code;
  }
  
  public String getContract_code()
  {
    return this.contract_code;
  }
  
  public String getContract_state()
  {
    return this.contract_state;
  }
  
  public String getContract_type()
  {
    return this.contract_type;
  }
  
  public String getEffect_date()
  {
    return this.effect_date;
  }
  
  public String getHire_commissioner_code()
  {
    return this.hire_commissioner_code;
  }
  
  public String getHire_commissioner_name()
  {
    return this.hire_commissioner_name;
  }
  
  public String getHire_commissioner_phone()
  {
    return this.hire_commissioner_phone;
  }
  
  public String getHire_contract_code()
  {
    return this.hire_contract_code;
  }
  
  public String getHouse_code()
  {
    return this.house_code;
  }
  
  public Integer getId()
  {
    return this.id;
  }
  
  public String getIsZiroom()
  {
    return this.isZiroom;
  }
  
  public String getLatitude()
  {
    return this.latitude;
  }
  
  public String getLongitude()
  {
    return this.longitude;
  }
  
  public String getOld_contract_code()
  {
    return this.old_contract_code;
  }
  
  public Integer getPayment()
  {
    return this.payment;
  }
  
  public String getPrice()
  {
    return this.price;
  }
  
  public String getRoom_code()
  {
    return this.room_code;
  }
  
  public String getStop_date()
  {
    return this.stop_date;
  }
  
  public String getUid()
  {
    return this.uid;
  }
  
  public void setAddress(String paramString)
  {
    this.address = paramString;
  }
  
  public void setCity_code(String paramString)
  {
    this.city_code = paramString;
  }
  
  public void setContract_code(String paramString)
  {
    this.contract_code = paramString;
  }
  
  public void setContract_state(String paramString)
  {
    this.contract_state = paramString;
  }
  
  public void setContract_type(String paramString)
  {
    this.contract_type = paramString;
  }
  
  public void setEffect_date(String paramString)
  {
    this.effect_date = paramString;
  }
  
  public void setHire_commissioner_code(String paramString)
  {
    this.hire_commissioner_code = paramString;
  }
  
  public void setHire_commissioner_name(String paramString)
  {
    this.hire_commissioner_name = paramString;
  }
  
  public void setHire_commissioner_phone(String paramString)
  {
    this.hire_commissioner_phone = paramString;
  }
  
  public void setHire_contract_code(String paramString)
  {
    this.hire_contract_code = paramString;
  }
  
  public void setHouse_code(String paramString)
  {
    this.house_code = paramString;
  }
  
  public void setId(Integer paramInteger)
  {
    this.id = paramInteger;
  }
  
  public void setIsZiroom(String paramString)
  {
    this.isZiroom = paramString;
  }
  
  public void setLatitude(String paramString)
  {
    this.latitude = paramString;
  }
  
  public void setLongitude(String paramString)
  {
    this.longitude = paramString;
  }
  
  public void setOld_contract_code(String paramString)
  {
    this.old_contract_code = paramString;
  }
  
  public void setPayment(Integer paramInteger)
  {
    this.payment = paramInteger;
  }
  
  public void setPrice(String paramString)
  {
    this.price = paramString;
  }
  
  public void setRoom_code(String paramString)
  {
    this.room_code = paramString;
  }
  
  public void setStop_date(String paramString)
  {
    this.stop_date = paramString;
  }
  
  public void setUid(String paramString)
  {
    this.uid = paramString;
  }
  
  public String toString()
  {
    return "Contract [uid=" + this.uid + ", contract_code=" + this.contract_code + ", stop_date=" + this.stop_date + ", effect_date=" + this.effect_date + ", price=" + this.price + ", address=" + this.address + ", payment=" + this.payment + ", house_code=" + this.house_code + ", room_code=" + this.room_code + ", contract_type=" + this.contract_type + ", contract_state=" + this.contract_state + ", hire_contract_code=" + this.hire_contract_code + ", hire_commissioner_code=" + this.hire_commissioner_code + ", hire_commissioner_name=" + this.hire_commissioner_name + ", hire_commissioner_phone=" + this.hire_commissioner_phone + ", city_code=" + this.city_code + ", longitude=" + this.longitude + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/ziroom/ziroomcustomer/model/Contract.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */