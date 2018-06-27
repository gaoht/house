package com.ziroom.ziroomcustomer.sublet.model;

import java.io.Serializable;

public class LeaseSubletReserveEntity
  implements Serializable
{
  private String prompt_text;
  private String prompt_title;
  private String text;
  private String type;
  
  public String getPrompt_text()
  {
    return this.prompt_text;
  }
  
  public String getPrompt_title()
  {
    return this.prompt_title;
  }
  
  public String getText()
  {
    return this.text;
  }
  
  public String getType()
  {
    return this.type;
  }
  
  public void setPrompt_text(String paramString)
  {
    this.prompt_text = paramString;
  }
  
  public void setPrompt_title(String paramString)
  {
    this.prompt_title = paramString;
  }
  
  public void setText(String paramString)
  {
    this.text = paramString;
  }
  
  public void setType(String paramString)
  {
    this.type = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/sublet/model/LeaseSubletReserveEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */