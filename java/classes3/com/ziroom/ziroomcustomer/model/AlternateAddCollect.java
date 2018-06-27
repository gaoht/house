package com.ziroom.ziroomcustomer.model;

import java.util.List;

public class AlternateAddCollect
{
  private List<AlternateCollection> collect;
  
  public List<AlternateCollection> getCollect()
  {
    return this.collect;
  }
  
  public void setCollect(List<AlternateCollection> paramList)
  {
    this.collect = paramList;
  }
  
  public String toString()
  {
    return "AlternateAddCollect{collect=" + this.collect + '}';
  }
  
  public static class AlternateCollection
  {
    private long add_time;
    private String code;
    private String house_code;
    private int house_type;
    private String status;
    private String type = "APP";
    
    public long getAdd_time()
    {
      return this.add_time;
    }
    
    public String getCode()
    {
      return this.code;
    }
    
    public String getHouse_code()
    {
      return this.house_code;
    }
    
    public int getHouse_type()
    {
      return this.house_type;
    }
    
    public String getStatus()
    {
      return this.status;
    }
    
    public String getType()
    {
      return this.type;
    }
    
    public void setAdd_time(long paramLong)
    {
      this.add_time = paramLong;
    }
    
    public void setCode(String paramString)
    {
      this.code = paramString;
    }
    
    public void setHouse_code(String paramString)
    {
      this.house_code = paramString;
    }
    
    public void setHouse_type(int paramInt)
    {
      this.house_type = paramInt;
    }
    
    public void setStatus(String paramString)
    {
      this.status = paramString;
    }
    
    public void setType(String paramString)
    {
      this.type = paramString;
    }
    
    public String toString()
    {
      return "AlternateAddCollect{house_code='" + this.house_code + '\'' + ", add_time=" + this.add_time + ", house_type=" + this.house_type + ", type='" + this.type + '\'' + '}';
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/AlternateAddCollect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */