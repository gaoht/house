package com.ziroom.ziroomcustomer.model;

import java.io.Serializable;

public class MHExplain
  implements Serializable
{
  private String evaluation_explain;
  private String order_status;
  private String special_term;
  
  public String getEvaluation_explain()
  {
    return this.evaluation_explain;
  }
  
  public String getOrder_status()
  {
    return this.order_status;
  }
  
  public String getSpecial_term()
  {
    return this.special_term;
  }
  
  public void setEvaluation_explain(String paramString)
  {
    this.evaluation_explain = paramString;
  }
  
  public void setOrder_status(String paramString)
  {
    this.order_status = paramString;
  }
  
  public void setSpecial_term(String paramString)
  {
    this.special_term = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/ziroom/ziroomcustomer/model/MHExplain.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */