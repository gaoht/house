package com.ziroom.ziroomcustomer.model;

import java.io.Serializable;

public class MHRule
  implements Serializable
{
  private String ersion;
  private String id;
  private String movetype;
  private String special_term;
  private String terms;
  
  public String getErsion()
  {
    return this.ersion;
  }
  
  public String getId()
  {
    return this.id;
  }
  
  public String getMovetype()
  {
    return this.movetype;
  }
  
  public String getSpecial_term()
  {
    return this.special_term;
  }
  
  public String getTerms()
  {
    return this.terms;
  }
  
  public void setErsion(String paramString)
  {
    this.ersion = paramString;
  }
  
  public void setId(String paramString)
  {
    this.id = paramString;
  }
  
  public void setMovetype(String paramString)
  {
    this.movetype = paramString;
  }
  
  public void setSpecial_term(String paramString)
  {
    this.special_term = paramString;
  }
  
  public void setTerms(String paramString)
  {
    this.terms = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/MHRule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */