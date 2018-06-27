package com.ziroom.ziroomcustomer.ziroomstation.model;

import java.util.List;

public class StationRuleBean
{
  private List<DataBean> data;
  private String error_code;
  private String error_message;
  private String status;
  
  public List<DataBean> getData()
  {
    return this.data;
  }
  
  public String getError_code()
  {
    return this.error_code;
  }
  
  public String getError_message()
  {
    return this.error_message;
  }
  
  public String getStatus()
  {
    return this.status;
  }
  
  public void setData(List<DataBean> paramList)
  {
    this.data = paramList;
  }
  
  public void setError_code(String paramString)
  {
    this.error_code = paramString;
  }
  
  public void setError_message(String paramString)
  {
    this.error_message = paramString;
  }
  
  public void setStatus(String paramString)
  {
    this.status = paramString;
  }
  
  public static class DataBean
  {
    private String content;
    private String ruleType;
    private String title;
    
    public String getContent()
    {
      return this.content;
    }
    
    public String getRuleType()
    {
      return this.ruleType;
    }
    
    public String getTitle()
    {
      return this.title;
    }
    
    public void setContent(String paramString)
    {
      this.content = paramString;
    }
    
    public void setRuleType(String paramString)
    {
      this.ruleType = paramString;
    }
    
    public void setTitle(String paramString)
    {
      this.title = paramString;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/model/StationRuleBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */