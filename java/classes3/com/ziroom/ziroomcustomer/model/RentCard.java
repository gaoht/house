package com.ziroom.ziroomcustomer.model;

import java.util.List;

public class RentCard
{
  private List<RentCardDetail> detail;
  private int total_num;
  private int used_num;
  
  public List<RentCardDetail> getDetail()
  {
    return this.detail;
  }
  
  public int getTotal_num()
  {
    return this.total_num;
  }
  
  public int getUsed_num()
  {
    return this.used_num;
  }
  
  public void setDetail(List<RentCardDetail> paramList)
  {
    this.detail = paramList;
  }
  
  public void setTotal_num(int paramInt)
  {
    this.total_num = paramInt;
  }
  
  public void setUsed_num(int paramInt)
  {
    this.used_num = paramInt;
  }
  
  public String toString()
  {
    return "RentCard [total_num=" + this.total_num + ", used_num=" + this.used_num + ", detail=" + this.detail + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/RentCard.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */