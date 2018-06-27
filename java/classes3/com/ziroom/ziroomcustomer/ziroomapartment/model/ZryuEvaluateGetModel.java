package com.ziroom.ziroomcustomer.ziroomapartment.model;

import com.freelxl.baselibrary.b.b;
import java.util.List;

public class ZryuEvaluateGetModel
  extends b
{
  public DataBean data;
  
  public DataBean getData()
  {
    return this.data;
  }
  
  public void setData(DataBean paramDataBean)
  {
    this.data = paramDataBean;
  }
  
  public static class DataBean
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
        public String code;
        public String curSelCode;
        public String curSelDesc;
        public String index;
        public String label;
        public String optionType;
        public List<OptionsBean> options;
        
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
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/model/ZryuEvaluateGetModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */