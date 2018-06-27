package com.ziroom.ziroomcustomer.newmovehouse.model;

import java.util.List;

public class MHServiceTime
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
    private List<MoveOrderTimeBean> moveOrderTime;
    private String remark;
    
    public List<MoveOrderTimeBean> getMoveOrderTime()
    {
      return this.moveOrderTime;
    }
    
    public String getRemark()
    {
      return this.remark;
    }
    
    public void setMoveOrderTime(List<MoveOrderTimeBean> paramList)
    {
      this.moveOrderTime = paramList;
    }
    
    public void setRemark(String paramString)
    {
      this.remark = paramString;
    }
    
    public static class MoveOrderTimeBean
    {
      private int capacityNum;
      private int haveCapacity;
      private String remark;
      private long timePointKey;
      private String timePointValue;
      
      public int getCapacityNum()
      {
        return this.capacityNum;
      }
      
      public int getHaveCapacity()
      {
        return this.haveCapacity;
      }
      
      public String getRemark()
      {
        return this.remark;
      }
      
      public long getTimePointKey()
      {
        return this.timePointKey;
      }
      
      public String getTimePointValue()
      {
        return this.timePointValue;
      }
      
      public void setCapacityNum(int paramInt)
      {
        this.capacityNum = paramInt;
      }
      
      public void setHaveCapacity(int paramInt)
      {
        this.haveCapacity = paramInt;
      }
      
      public void setRemark(String paramString)
      {
        this.remark = paramString;
      }
      
      public void setTimePointKey(long paramLong)
      {
        this.timePointKey = paramLong;
      }
      
      public void setTimePointValue(String paramString)
      {
        this.timePointValue = paramString;
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/model/MHServiceTime.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */