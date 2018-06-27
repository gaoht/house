package com.ziroom.ziroomcustomer.model;

import java.io.Serializable;
import java.util.List;

public class MoveOrderDetail
  implements Serializable
{
  private String booktime;
  private List<Demand> demands;
  private String e_log_lat;
  private String endaddress;
  private int evaluateStatus;
  private String goodsprice;
  private String house_code;
  private List<MoveGood> items;
  private String miles;
  private String money;
  private String moneyStatus;
  private String phone;
  private String rule;
  private String s_log_lat;
  private String score;
  private String startaddress;
  private String type;
  private String uid;
  private String version;
  
  public String getBooktime()
  {
    return this.booktime;
  }
  
  public List<Demand> getDemands()
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
  
  public int getEvaluateStatus()
  {
    return this.evaluateStatus;
  }
  
  public String getGoodsprice()
  {
    return this.goodsprice;
  }
  
  public String getHouse_code()
  {
    return this.house_code;
  }
  
  public List<MoveGood> getItems()
  {
    return this.items;
  }
  
  public String getMiles()
  {
    return this.miles;
  }
  
  public String getMoney()
  {
    return this.money;
  }
  
  public String getMoneyStatus()
  {
    return this.moneyStatus;
  }
  
  public String getPhone()
  {
    return this.phone;
  }
  
  public String getRule()
  {
    return this.rule;
  }
  
  public String getS_log_lat()
  {
    return this.s_log_lat;
  }
  
  public String getScore()
  {
    return this.score;
  }
  
  public String getStartaddress()
  {
    return this.startaddress;
  }
  
  public String getType()
  {
    return this.type;
  }
  
  public String getUid()
  {
    return this.uid;
  }
  
  public String getVersion()
  {
    return this.version;
  }
  
  public void setBooktime(String paramString)
  {
    this.booktime = paramString;
  }
  
  public void setDemands(List<Demand> paramList)
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
  
  public void setEvaluateStatus(int paramInt)
  {
    this.evaluateStatus = paramInt;
  }
  
  public void setGoodsprice(String paramString)
  {
    this.goodsprice = paramString;
  }
  
  public void setHouse_code(String paramString)
  {
    this.house_code = paramString;
  }
  
  public void setItems(List<MoveGood> paramList)
  {
    this.items = paramList;
  }
  
  public void setMiles(String paramString)
  {
    this.miles = paramString;
  }
  
  public void setMoney(String paramString)
  {
    this.money = paramString;
  }
  
  public void setMoneyStatus(String paramString)
  {
    this.moneyStatus = paramString;
  }
  
  public void setPhone(String paramString)
  {
    this.phone = paramString;
  }
  
  public void setRule(String paramString)
  {
    this.rule = paramString;
  }
  
  public void setS_log_lat(String paramString)
  {
    this.s_log_lat = paramString;
  }
  
  public void setScore(String paramString)
  {
    this.score = paramString;
  }
  
  public void setStartaddress(String paramString)
  {
    this.startaddress = paramString;
  }
  
  public void setType(String paramString)
  {
    this.type = paramString;
  }
  
  public void setUid(String paramString)
  {
    this.uid = paramString;
  }
  
  public void setVersion(String paramString)
  {
    this.version = paramString;
  }
  
  public String toString()
  {
    return "MoveOrderDetail [startaddress=" + this.startaddress + ", endaddress=" + this.endaddress + ", s_log_lat=" + this.s_log_lat + ", e_log_lat=" + this.e_log_lat + ", house_code=" + this.house_code + ", evaluateStatus=" + this.evaluateStatus + ", booktime=" + this.booktime + ", goodsprice=" + this.goodsprice + ", score=" + this.score + ", uid=" + this.uid + ", phone=" + this.phone + ", version=" + this.version + ", demands=" + this.demands + ", items=" + this.items + ", money=" + this.money + ", moneyStatus=" + this.moneyStatus + ", type=" + this.type + ", miles=" + this.miles + ", rule=" + this.rule + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/MoveOrderDetail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */