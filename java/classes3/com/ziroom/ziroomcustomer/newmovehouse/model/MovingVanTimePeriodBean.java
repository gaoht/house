package com.ziroom.ziroomcustomer.newmovehouse.model;

import java.util.List;

public class MovingVanTimePeriodBean
{
  private int isTimeBlock;
  private List<MoveOrderTimeBean> moveOrderTime;
  
  public int getIsTimeBlock()
  {
    return this.isTimeBlock;
  }
  
  public List<MoveOrderTimeBean> getMoveOrderTime()
  {
    return this.moveOrderTime;
  }
  
  public void setIsTimeBlock(int paramInt)
  {
    this.isTimeBlock = paramInt;
  }
  
  public void setMoveOrderTime(List<MoveOrderTimeBean> paramList)
  {
    this.moveOrderTime = paramList;
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


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/model/MovingVanTimePeriodBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */