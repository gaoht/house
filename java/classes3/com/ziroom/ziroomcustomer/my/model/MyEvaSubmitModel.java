package com.ziroom.ziroomcustomer.my.model;

import java.util.List;

public class MyEvaSubmitModel
{
  public String orderCode;
  public List<QuestionsBean> questions;
  public String requesterId;
  public String requesterType;
  
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
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/model/MyEvaSubmitModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */