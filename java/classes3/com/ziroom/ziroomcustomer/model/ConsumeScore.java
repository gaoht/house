package com.ziroom.ziroomcustomer.model;

import java.util.List;

public class ConsumeScore
{
  private List<ConsumeScoreDetail> reduce_detail;
  private String total_num;
  
  public List<ConsumeScoreDetail> getReduce_detail()
  {
    return this.reduce_detail;
  }
  
  public String getTotal_num()
  {
    return this.total_num;
  }
  
  public void setReduce_detail(List<ConsumeScoreDetail> paramList)
  {
    this.reduce_detail = paramList;
  }
  
  public void setTotal_num(String paramString)
  {
    this.total_num = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/ConsumeScore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */