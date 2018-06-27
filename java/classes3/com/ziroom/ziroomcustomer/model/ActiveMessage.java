package com.ziroom.ziroomcustomer.model;

import java.io.Serializable;

public class ActiveMessage
  implements Serializable
{
  private String activity_name;
  private String addr;
  private String begin_time;
  private String building_code;
  private String building_name;
  private String cate;
  private String contact;
  private String create_name;
  private String create_time = "";
  private String end_time;
  private String fanwei;
  private String for_where;
  private String img;
  private String introduce;
  private boolean is_sale;
  private int number = 0;
  private String uid;
  private int xd_number = 0;
  
  public String getActivity_name()
  {
    return this.activity_name;
  }
  
  public String getAddr()
  {
    return this.addr;
  }
  
  public String getBegin_time()
  {
    return this.begin_time;
  }
  
  public String getBuilding_code()
  {
    return this.building_code;
  }
  
  public String getBuilding_name()
  {
    return this.building_name;
  }
  
  public String getCate()
  {
    return this.cate;
  }
  
  public String getContact()
  {
    return this.contact;
  }
  
  public String getCreate_name()
  {
    return this.create_name;
  }
  
  public String getCreate_time()
  {
    return this.create_time;
  }
  
  public String getEnd_time()
  {
    return this.end_time;
  }
  
  public String getFanwei()
  {
    return this.fanwei;
  }
  
  public String getFor_where()
  {
    return this.for_where;
  }
  
  public String getImg()
  {
    return this.img;
  }
  
  public String getIntroduce()
  {
    return this.introduce;
  }
  
  public int getNumber()
  {
    return this.number;
  }
  
  public String getUid()
  {
    return this.uid;
  }
  
  public int getXd_number()
  {
    return this.xd_number;
  }
  
  public boolean isIs_sale()
  {
    return this.is_sale;
  }
  
  public void setActivity_name(String paramString)
  {
    this.activity_name = paramString;
  }
  
  public void setAddr(String paramString)
  {
    this.addr = paramString;
  }
  
  public void setBegin_time(String paramString)
  {
    this.begin_time = paramString;
  }
  
  public void setBuilding_code(String paramString)
  {
    this.building_code = paramString;
  }
  
  public void setBuilding_name(String paramString)
  {
    this.building_name = paramString;
  }
  
  public void setCate(String paramString)
  {
    this.cate = paramString;
  }
  
  public void setContact(String paramString)
  {
    this.contact = paramString;
  }
  
  public void setCreate_name(String paramString)
  {
    this.create_name = paramString;
  }
  
  public void setCreate_time(String paramString)
  {
    this.create_time = paramString;
  }
  
  public void setEnd_time(String paramString)
  {
    this.end_time = paramString;
  }
  
  public void setFanwei(String paramString)
  {
    this.fanwei = paramString;
  }
  
  public void setFor_where(String paramString)
  {
    this.for_where = paramString;
  }
  
  public void setImg(String paramString)
  {
    this.img = paramString;
  }
  
  public void setIntroduce(String paramString)
  {
    this.introduce = paramString;
  }
  
  public void setIs_sale(boolean paramBoolean)
  {
    this.is_sale = paramBoolean;
  }
  
  public void setNumber(int paramInt)
  {
    this.number = paramInt;
  }
  
  public void setUid(String paramString)
  {
    this.uid = paramString;
  }
  
  public void setXd_number(int paramInt)
  {
    this.xd_number = paramInt;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/ActiveMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */