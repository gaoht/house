package com.ziroom.ziroomcustomer.model;

import java.util.List;

public class AlternateDelCollect
{
  private List<Collection> delete;
  
  public List<Collection> getDelete()
  {
    return this.delete;
  }
  
  public void setDelete(List<Collection> paramList)
  {
    this.delete = paramList;
  }
  
  public String toString()
  {
    return "AlternateDelCollect{delete=" + this.delete + '}';
  }
  
  public static class Collection
  {
    private long del_time;
    private String house_code;
    
    public long getDel_time()
    {
      return this.del_time;
    }
    
    public String getHouse_code()
    {
      return this.house_code;
    }
    
    public void setDel_time(long paramLong)
    {
      this.del_time = paramLong;
    }
    
    public void setHouse_code(String paramString)
    {
      this.house_code = paramString;
    }
    
    public String toString()
    {
      return "Collection{house_code='" + this.house_code + '\'' + ", del_time=" + this.del_time + '}';
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/AlternateDelCollect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */