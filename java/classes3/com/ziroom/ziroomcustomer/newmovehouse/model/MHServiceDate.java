package com.ziroom.ziroomcustomer.newmovehouse.model;

import java.util.List;

public class MHServiceDate
{
  private DataBean data;
  private String message;
  private String status;
  
  public DataBean getData()
  {
    return this.data;
  }
  
  public String getMessage()
  {
    return this.message;
  }
  
  public String getStatus()
  {
    return this.status;
  }
  
  public void setData(DataBean paramDataBean)
  {
    this.data = paramDataBean;
  }
  
  public void setMessage(String paramString)
  {
    this.message = paramString;
  }
  
  public void setStatus(String paramString)
  {
    this.status = paramString;
  }
  
  public static class DataBean
  {
    private List<MoveOrderDateBean> moveOrderDate;
    
    public List<MoveOrderDateBean> getMoveOrderDate()
    {
      return this.moveOrderDate;
    }
    
    public void setMoveOrderDate(List<MoveOrderDateBean> paramList)
    {
      this.moveOrderDate = paramList;
    }
    
    public static class MoveOrderDateBean
    {
      private long dateKey;
      private String dateValue;
      
      public long getDateKey()
      {
        return this.dateKey;
      }
      
      public String getDateValue()
      {
        return this.dateValue;
      }
      
      public void setDateKey(long paramLong)
      {
        this.dateKey = paramLong;
      }
      
      public void setDateValue(String paramString)
      {
        this.dateValue = paramString;
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/model/MHServiceDate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */