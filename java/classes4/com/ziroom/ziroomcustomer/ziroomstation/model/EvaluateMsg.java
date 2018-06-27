package com.ziroom.ziroomcustomer.ziroomstation.model;

import java.util.List;

public class EvaluateMsg
{
  public String ext;
  public String orderCode;
  public List<QuestionsBean> questions;
  public String requesterId;
  public String requesterType;
  
  public String getExt()
  {
    return this.ext;
  }
  
  public String getOrderCode()
  {
    return this.orderCode;
  }
  
  public List<QuestionsBean> getQuestions()
  {
    return this.questions;
  }
  
  public String getRequesterId()
  {
    return this.requesterId;
  }
  
  public String getRequesterType()
  {
    return this.requesterType;
  }
  
  public void setExt(String paramString)
  {
    this.ext = paramString;
  }
  
  public void setOrderCode(String paramString)
  {
    this.orderCode = paramString;
  }
  
  public void setQuestions(List<QuestionsBean> paramList)
  {
    this.questions = paramList;
  }
  
  public void setRequesterId(String paramString)
  {
    this.requesterId = paramString;
  }
  
  public void setRequesterType(String paramString)
  {
    this.requesterType = paramString;
  }
  
  public static class QuestionsBean
  {
    public String code;
    public String content;
    public String optionCode;
    public String picUrl;
    
    public String getCode()
    {
      return this.code;
    }
    
    public String getContent()
    {
      return this.content;
    }
    
    public String getOptionCode()
    {
      return this.optionCode;
    }
    
    public String getPicUrl()
    {
      return this.picUrl;
    }
    
    public void setCode(String paramString)
    {
      this.code = paramString;
    }
    
    public void setContent(String paramString)
    {
      this.content = paramString;
    }
    
    public void setOptionCode(String paramString)
    {
      this.optionCode = paramString;
    }
    
    public void setPicUrl(String paramString)
    {
      this.picUrl = paramString;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/model/EvaluateMsg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */