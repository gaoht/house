package com.ziroom.ziroomcustomer.ziroomstation.model;

import com.ziroom.ziroomcustomer.ziroomstation.b.a;
import java.io.Serializable;
import java.util.List;

public class StationCoupon
  extends a
  implements Serializable
{
  private List<DataEntity> data;
  
  public List<DataEntity> getData()
  {
    return this.data;
  }
  
  public void setData(List<DataEntity> paramList)
  {
    this.data = paramList;
  }
  
  public static class DataEntity
    implements Serializable
  {
    private String activityName;
    private int amount;
    private String condition;
    private String endDate;
    private boolean isUsable;
    private String startDate;
    private String ticketBid;
    
    public String getActivityName()
    {
      return this.activityName;
    }
    
    public int getAmount()
    {
      return this.amount;
    }
    
    public String getCondition()
    {
      return this.condition;
    }
    
    public String getEndDate()
    {
      return this.endDate;
    }
    
    public String getStartDate()
    {
      return this.startDate;
    }
    
    public String getTicketBid()
    {
      return this.ticketBid;
    }
    
    public boolean isIsUsable()
    {
      return this.isUsable;
    }
    
    public void setActivityName(String paramString)
    {
      this.activityName = paramString;
    }
    
    public void setAmount(int paramInt)
    {
      this.amount = paramInt;
    }
    
    public void setCondition(String paramString)
    {
      this.condition = paramString;
    }
    
    public void setEndDate(String paramString)
    {
      this.endDate = paramString;
    }
    
    public void setIsUsable(boolean paramBoolean)
    {
      this.isUsable = paramBoolean;
    }
    
    public void setStartDate(String paramString)
    {
      this.startDate = paramString;
    }
    
    public void setTicketBid(String paramString)
    {
      this.ticketBid = paramString;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/model/StationCoupon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */