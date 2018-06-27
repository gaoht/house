package com.ziroom.ziroomcustomer.model;

public class ConsumeScoreDetail
{
  private String consume_id;
  private String consume_type;
  private String consume_type_txt;
  private String cost_num;
  private String creation_date;
  
  public String getConsume_id()
  {
    return this.consume_id;
  }
  
  public String getConsume_type()
  {
    return this.consume_type;
  }
  
  public String getConsume_type_txt()
  {
    return this.consume_type_txt;
  }
  
  public String getCost_num()
  {
    return this.cost_num;
  }
  
  public String getCreation_date()
  {
    return this.creation_date;
  }
  
  public void setConsume_id(String paramString)
  {
    this.consume_id = paramString;
  }
  
  public void setConsume_type(String paramString)
  {
    this.consume_type = paramString;
  }
  
  public void setConsume_type_txt(String paramString)
  {
    this.consume_type_txt = paramString;
  }
  
  public void setCost_num(String paramString)
  {
    this.cost_num = paramString;
  }
  
  public void setCreation_date(String paramString)
  {
    this.creation_date = paramString;
  }
  
  public String toString()
  {
    return "ConsumeScoreDetail [consume_id=" + this.consume_id + ", consume_type=" + this.consume_type + ", cost_num=" + this.cost_num + ", creation_date=" + this.creation_date + ", consume_type_txt=" + this.consume_type_txt + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/ConsumeScoreDetail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */