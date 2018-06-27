package com.ziroom.ziroomcustomer.my.model;

import java.util.List;

public class MyEvaHistoryDetailModel
{
  public EvaluateInfoBean evaluateInfo;
  public KeeperInfoBean keeperInfo;
  
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
    public List<QuestionsBean> questions;
    public String status;
    public String tokenId;
    public String zoIntroduce;
    public String zoName;
    public String zoPhotoUrl;
    
    public String getMessage()
    {
      return this.message;
    }
    
    public List<QuestionsBean> getQuestions()
    {
      return this.questions;
    }
    
    public String getStatus()
    {
      return this.status;
    }
    
    public String getTokenId()
    {
      return this.tokenId;
    }
    
    public String getZoIntroduce()
    {
      return this.zoIntroduce;
    }
    
    public String getZoName()
    {
      return this.zoName;
    }
    
    public String getZoPhotoUrl()
    {
      return this.zoPhotoUrl;
    }
    
    public void setMessage(String paramString)
    {
      this.message = paramString;
    }
    
    public void setQuestions(List<QuestionsBean> paramList)
    {
      this.questions = paramList;
    }
    
    public void setStatus(String paramString)
    {
      this.status = paramString;
    }
    
    public void setTokenId(String paramString)
    {
      this.tokenId = paramString;
    }
    
    public void setZoIntroduce(String paramString)
    {
      this.zoIntroduce = paramString;
    }
    
    public void setZoName(String paramString)
    {
      this.zoName = paramString;
    }
    
    public void setZoPhotoUrl(String paramString)
    {
      this.zoPhotoUrl = paramString;
    }
    
    public static class QuestionsBean
    {
      public List<ChildrenBean> children;
      public String code;
      public String index;
      public String label;
      
      public List<ChildrenBean> getChildren()
      {
        return this.children;
      }
      
      public String getCode()
      {
        return this.code;
      }
      
      public String getIndex()
      {
        return this.index;
      }
      
      public String getLabel()
      {
        return this.label;
      }
      
      public void setChildren(List<ChildrenBean> paramList)
      {
        this.children = paramList;
      }
      
      public void setCode(String paramString)
      {
        this.code = paramString;
      }
      
      public void setIndex(String paramString)
      {
        this.index = paramString;
      }
      
      public void setLabel(String paramString)
      {
        this.label = paramString;
      }
      
      public static class ChildrenBean
      {
        public List<AnswersBean> answers;
        public String code;
        public String index;
        public String label;
        public String optionType;
        public List<OptionsBean> options;
        
        public List<AnswersBean> getAnswers()
        {
          return this.answers;
        }
        
        public String getCode()
        {
          return this.code;
        }
        
        public String getIndex()
        {
          return this.index;
        }
        
        public String getLabel()
        {
          return this.label;
        }
        
        public String getOptionType()
        {
          return this.optionType;
        }
        
        public List<OptionsBean> getOptions()
        {
          return this.options;
        }
        
        public void setAnswers(List<AnswersBean> paramList)
        {
          this.answers = paramList;
        }
        
        public void setCode(String paramString)
        {
          this.code = paramString;
        }
        
        public void setIndex(String paramString)
        {
          this.index = paramString;
        }
        
        public void setLabel(String paramString)
        {
          this.label = paramString;
        }
        
        public void setOptionType(String paramString)
        {
          this.optionType = paramString;
        }
        
        public void setOptions(List<OptionsBean> paramList)
        {
          this.options = paramList;
        }
        
        public static class AnswersBean
        {
          public String label;
          public String optionAnswerId;
          
          public String getLabel()
          {
            return this.label;
          }
          
          public String getOptionAnswerId()
          {
            return this.optionAnswerId;
          }
          
          public void setLabel(String paramString)
          {
            this.label = paramString;
          }
          
          public void setOptionAnswerId(String paramString)
          {
            this.optionAnswerId = paramString;
          }
        }
        
        public static class OptionsBean
        {
          public String code;
          public String desc;
          
          public String getCode()
          {
            return this.code;
          }
          
          public String getDesc()
          {
            return this.desc;
          }
          
          public void setCode(String paramString)
          {
            this.code = paramString;
          }
          
          public void setDesc(String paramString)
          {
            this.desc = paramString;
          }
        }
      }
    }
  }
  
  public static class KeeperInfoBean
  {
    public String keeperHeadCorn;
    public String keeperId;
    public String keeperName;
    public String keeperPresent;
    
    public String getKeeperHeadCorn()
    {
      return this.keeperHeadCorn;
    }
    
    public String getKeeperId()
    {
      return this.keeperId;
    }
    
    public String getKeeperName()
    {
      return this.keeperName;
    }
    
    public String getKeeperPresent()
    {
      return this.keeperPresent;
    }
    
    public void setKeeperHeadCorn(String paramString)
    {
      this.keeperHeadCorn = paramString;
    }
    
    public void setKeeperId(String paramString)
    {
      this.keeperId = paramString;
    }
    
    public void setKeeperName(String paramString)
    {
      this.keeperName = paramString;
    }
    
    public void setKeeperPresent(String paramString)
    {
      this.keeperPresent = paramString;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/model/MyEvaHistoryDetailModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */