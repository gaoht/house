package com.ziroom.ziroomcustomer.model;

import java.io.Serializable;
import java.util.List;

public class ChatMessage
  implements Serializable
{
  private List<HouseCard> house_list;
  private int id;
  public boolean isSend;
  private String message;
  private String mobile;
  private String msg_type;
  private String name;
  private String time;
  private String uid;
  
  public List<HouseCard> getHouse_list()
  {
    return this.house_list;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public String getMessage()
  {
    return this.message;
  }
  
  public String getMobile()
  {
    return this.mobile;
  }
  
  public String getMsg_type()
  {
    return this.msg_type;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getTime()
  {
    return this.time;
  }
  
  public String getUid()
  {
    return this.uid;
  }
  
  public boolean isSend()
  {
    return this.isSend;
  }
  
  public void setHouse_list(List<HouseCard> paramList)
  {
    this.house_list = paramList;
  }
  
  public void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public void setMessage(String paramString)
  {
    this.message = paramString;
  }
  
  public void setMobile(String paramString)
  {
    this.mobile = paramString;
  }
  
  public void setMsg_type(String paramString)
  {
    this.msg_type = paramString;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setSend(boolean paramBoolean) {}
  
  public void setTime(String paramString)
  {
    this.time = paramString;
  }
  
  public void setUid(String paramString)
  {
    this.uid = paramString;
  }
  
  public class HouseCard
    implements Serializable
  {
    private String house_code;
    private String house_id;
    private String house_name;
    private String house_price;
    private int house_type;
    private String image_url;
    private String lat_lng;
    private String room_code;
    
    public HouseCard() {}
    
    public String getHouse_code()
    {
      return this.house_code;
    }
    
    public String getHouse_id()
    {
      return this.house_id;
    }
    
    public String getHouse_name()
    {
      return this.house_name;
    }
    
    public String getHouse_price()
    {
      return this.house_price;
    }
    
    public int getHouse_type()
    {
      return this.house_type;
    }
    
    public String getImage_url()
    {
      return this.image_url;
    }
    
    public String getLat_lng()
    {
      return this.lat_lng;
    }
    
    public String getRoom_code()
    {
      return this.room_code;
    }
    
    public void setHouse_code(String paramString)
    {
      this.house_code = paramString;
    }
    
    public void setHouse_id(String paramString)
    {
      this.house_id = paramString;
    }
    
    public void setHouse_name(String paramString)
    {
      this.house_name = paramString;
    }
    
    public void setHouse_price(String paramString)
    {
      this.house_price = paramString;
    }
    
    public void setHouse_type(int paramInt)
    {
      this.house_type = paramInt;
    }
    
    public void setImage_url(String paramString)
    {
      this.image_url = paramString;
    }
    
    public void setLat_lng(String paramString)
    {
      this.lat_lng = paramString;
    }
    
    public void setRoom_code(String paramString)
    {
      this.room_code = paramString;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/ChatMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */