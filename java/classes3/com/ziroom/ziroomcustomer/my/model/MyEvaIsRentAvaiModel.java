package com.ziroom.ziroomcustomer.my.model;

import java.util.List;

public class MyEvaIsRentAvaiModel
{
  public EvaluateInfoBean evaluateInfo;
  
  public EvaluateInfoBean getEvaluateInfo()
  {
    return this.evaluateInfo;
  }
  
  public void setEvaluateInfo(EvaluateInfoBean paramEvaluateInfoBean)
  {
    this.evaluateInfo = paramEvaluateInfoBean;
  }
  
  public static class EvaluateInfoBean
  {
    public String message;
    public List<ResultBean> result;
    public String status;
    
    public String getMessage()
    {
      return this.message;
    }
    
    public List<ResultBean> getResult()
    {
      return this.result;
    }
    
    public String getStatus()
    {
      return this.status;
    }
    
    public void setMessage(String paramString)
    {
      this.message = paramString;
    }
    
    public void setResult(List<ResultBean> paramList)
    {
      this.result = paramList;
    }
    
    public void setStatus(String paramString)
    {
      this.status = paramString;
    }
    
    public static class ResultBean
    {
      public String content;
      public String orderCode;
      public String questionType;
      public String statusContent;
      public String statusDesc;
      public String title;
      
      public String getContent()
      {
        return this.content;
      }
      
      public String getOrderCode()
      {
        return this.orderCode;
      }
      
      public String getQuestionType()
      {
        return this.questionType;
      }
      
      public String getStatusContent()
      {
        return this.statusContent;
      }
      
      public String getStatusDesc()
      {
        return this.statusDesc;
      }
      
      public String getTitle()
      {
        return this.title;
      }
      
      public void setContent(String paramString)
      {
        this.content = paramString;
      }
      
      public void setOrderCode(String paramString)
      {
        this.orderCode = paramString;
      }
      
      public void setQuestionType(String paramString)
      {
        this.questionType = paramString;
      }
      
      public void setStatusContent(String paramString)
      {
        this.statusContent = paramString;
      }
      
      public void setStatusDesc(String paramString)
      {
        this.statusDesc = paramString;
      }
      
      public void setTitle(String paramString)
      {
        this.title = paramString;
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/model/MyEvaIsRentAvaiModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */