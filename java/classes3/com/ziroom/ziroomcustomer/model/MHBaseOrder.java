package com.ziroom.ziroomcustomer.model;

import java.io.Serializable;
import java.util.List;

public class MHBaseOrder
  implements Serializable
{
  private String contract;
  private String date;
  private List<MHNeedLike> demands;
  private String e_log_lat;
  private String endaddress;
  private String house_code;
  private List<Commodity> items;
  private double miles;
  private String modeid;
  private String name;
  private String note;
  private String phone;
  private String s_log_lat;
  private String startaddress;
  private int timeId;
  private String uid;
  private String version;
  
  public String getContract()
  {
    return this.contract;
  }
  
  public String getDate()
  {
    return this.date;
  }
  
  public List<MHNeedLike> getDemands()
  {
    return this.demands;
  }
  
  public String getE_log_lat()
  {
    return this.e_log_lat;
  }
  
  public String getEndaddress()
  {
    return this.endaddress;
  }
  
  public String getHouse_code()
  {
    return this.house_code;
  }
  
  public List<Commodity> getItems()
  {
    return this.items;
  }
  
  public double getMiles()
  {
    return this.miles;
  }
  
  public String getModeid()
  {
    return this.modeid;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getNote()
  {
    return this.note;
  }
  
  public String getPhone()
  {
    return this.phone;
  }
  
  public String getS_log_lat()
  {
    return this.s_log_lat;
  }
  
  public String getStartaddress()
  {
    return this.startaddress;
  }
  
  public int getTimeId()
  {
    return this.timeId;
  }
  
  public String getUid()
  {
    return this.uid;
  }
  
  public String getVersion()
  {
    return this.version;
  }
  
  public void setContract(String paramString)
  {
    this.contract = paramString;
  }
  
  public void setDate(String paramString)
  {
    this.date = paramString;
  }
  
  public void setDemands(List<MHNeedLike> paramList)
  {
    this.demands = paramList;
  }
  
  public void setE_log_lat(String paramString)
  {
    this.e_log_lat = paramString;
  }
  
  public void setEndaddress(String paramString)
  {
    this.endaddress = paramString;
  }
  
  public void setHouse_code(String paramString)
  {
    this.house_code = paramString;
  }
  
  public void setItems(List<Commodity> paramList)
  {
    this.items = paramList;
  }
  
  public void setMiles(double paramDouble)
  {
    this.miles = paramDouble;
  }
  
  public void setModeid(String paramString)
  {
    this.modeid = paramString;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setNote(String paramString)
  {
    this.note = paramString;
  }
  
  public void setPhone(String paramString)
  {
    this.phone = paramString;
  }
  
  public void setS_log_lat(String paramString)
  {
    this.s_log_lat = paramString;
  }
  
  public void setStartaddress(String paramString)
  {
    this.startaddress = paramString;
  }
  
  public void setTimeId(int paramInt)
  {
    this.timeId = paramInt;
  }
  
  public void setUid(String paramString)
  {
    this.uid = paramString;
  }
  
  public void setVersion(String paramString)
  {
    this.version = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/MHBaseOrder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */