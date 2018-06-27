package com.ziroom.ziroomcustomer.model;

import java.io.Serializable;
import java.util.List;

public class AreaInfo
  implements Serializable
{
  private String address;
  private String bizcirc;
  private List<AreaBus> bus;
  private String city;
  private List<String> picPaths;
  private String posXy;
  private String rent_code;
  private String resbkDesc;
  private String resbkId;
  private String resbkName;
  private List<AreaSubway> subway;
  private AreaWyCompany wycompany;
  
  public String getAddress()
  {
    return this.address;
  }
  
  public String getBizcirc()
  {
    return this.bizcirc;
  }
  
  public List<AreaBus> getBus()
  {
    return this.bus;
  }
  
  public String getCity()
  {
    return this.city;
  }
  
  public List<String> getPicPaths()
  {
    return this.picPaths;
  }
  
  public String getPosXy()
  {
    return this.posXy;
  }
  
  public String getRent_code()
  {
    return this.rent_code;
  }
  
  public String getResbkDesc()
  {
    return this.resbkDesc;
  }
  
  public String getResbkId()
  {
    return this.resbkId;
  }
  
  public String getResbkName()
  {
    return this.resbkName;
  }
  
  public List<AreaSubway> getSubway()
  {
    return this.subway;
  }
  
  public AreaWyCompany getWycompany()
  {
    return this.wycompany;
  }
  
  public void setAddress(String paramString)
  {
    this.address = paramString;
  }
  
  public void setBizcirc(String paramString)
  {
    this.bizcirc = paramString;
  }
  
  public void setBus(List<AreaBus> paramList)
  {
    this.bus = paramList;
  }
  
  public void setCity(String paramString)
  {
    this.city = paramString;
  }
  
  public void setPicPaths(List<String> paramList)
  {
    this.picPaths = paramList;
  }
  
  public void setPosXy(String paramString)
  {
    this.posXy = paramString;
  }
  
  public void setRent_code(String paramString)
  {
    this.rent_code = paramString;
  }
  
  public void setResbkDesc(String paramString)
  {
    this.resbkDesc = paramString;
  }
  
  public void setResbkId(String paramString)
  {
    this.resbkId = paramString;
  }
  
  public void setResbkName(String paramString)
  {
    this.resbkName = paramString;
  }
  
  public void setSubway(List<AreaSubway> paramList)
  {
    this.subway = paramList;
  }
  
  public void setWycompany(AreaWyCompany paramAreaWyCompany)
  {
    this.wycompany = paramAreaWyCompany;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/ziroom/ziroomcustomer/model/AreaInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */