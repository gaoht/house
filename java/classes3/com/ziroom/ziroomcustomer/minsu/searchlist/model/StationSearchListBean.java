package com.ziroom.ziroomcustomer.minsu.searchlist.model;

import java.util.List;

public class StationSearchListBean
{
  private DataBean data;
  private String message;
  private String status;
  
  public DataBean getData()
  {
    return this.data;
  }
  
  public String getMessage()
  {
    return this.message;
  }
  
  public String getStatus()
  {
    return this.status;
  }
  
  public void setData(DataBean paramDataBean)
  {
    this.data = paramDataBean;
  }
  
  public void setMessage(String paramString)
  {
    this.message = paramString;
  }
  
  public void setStatus(String paramString)
  {
    this.status = paramString;
  }
  
  public static class DataBean
  {
    private List<ListBean> list;
    private List<ListBean> suggest;
    private String suggestMsg;
    private int total;
    
    public List<ListBean> getList()
    {
      return this.list;
    }
    
    public List<ListBean> getSuggest()
    {
      return this.suggest;
    }
    
    public String getSuggestMsg()
    {
      return this.suggestMsg;
    }
    
    public int getTotal()
    {
      return this.total;
    }
    
    public void setList(List<ListBean> paramList)
    {
      this.list = paramList;
    }
    
    public void setSuggest(List<ListBean> paramList)
    {
      this.suggest = paramList;
    }
    
    public void setSuggestMsg(String paramString)
    {
      this.suggestMsg = paramString;
    }
    
    public void setTotal(int paramInt)
    {
      this.total = paramInt;
    }
    
    public static class ListBean
    {
      private String areaName;
      private String cityName;
      private int evaluateCount;
      private double evaluateScore;
      private int houseModelCount;
      private List<LabelTipBean> labelTipsList;
      private int maxPrice;
      private int minPrice;
      private String picUrl;
      private String projectBid;
      private String projectName;
      private int status;
      
      public boolean equals(Object paramObject)
      {
        if ((getProjectBid() != null) && (paramObject != null) && ((paramObject instanceof ListBean)))
        {
          paramObject = (ListBean)paramObject;
          return getProjectBid().equals(((ListBean)paramObject).getProjectBid());
        }
        return false;
      }
      
      public String getAreaName()
      {
        return this.areaName;
      }
      
      public String getCityName()
      {
        return this.cityName;
      }
      
      public int getEvaluateCount()
      {
        return this.evaluateCount;
      }
      
      public double getEvaluateScore()
      {
        return this.evaluateScore;
      }
      
      public int getHouseModelCount()
      {
        return this.houseModelCount;
      }
      
      public List<LabelTipBean> getLabelTipsList()
      {
        return this.labelTipsList;
      }
      
      public int getMaxPrice()
      {
        return this.maxPrice;
      }
      
      public int getMinPrice()
      {
        return this.minPrice;
      }
      
      public String getPicUrl()
      {
        return this.picUrl;
      }
      
      public String getProjectBid()
      {
        return this.projectBid;
      }
      
      public String getProjectName()
      {
        return this.projectName;
      }
      
      public int getStatus()
      {
        return this.status;
      }
      
      public void setAreaName(String paramString)
      {
        this.areaName = paramString;
      }
      
      public void setCityName(String paramString)
      {
        this.cityName = paramString;
      }
      
      public void setEvaluateCount(int paramInt)
      {
        this.evaluateCount = paramInt;
      }
      
      public void setEvaluateScore(double paramDouble)
      {
        this.evaluateScore = paramDouble;
      }
      
      public void setHouseModelCount(int paramInt)
      {
        this.houseModelCount = paramInt;
      }
      
      public void setLabelTipsList(List<LabelTipBean> paramList)
      {
        this.labelTipsList = paramList;
      }
      
      public void setMaxPrice(int paramInt)
      {
        this.maxPrice = paramInt;
      }
      
      public void setMinPrice(int paramInt)
      {
        this.minPrice = paramInt;
      }
      
      public void setPicUrl(String paramString)
      {
        this.picUrl = paramString;
      }
      
      public void setProjectBid(String paramString)
      {
        this.projectBid = paramString;
      }
      
      public void setProjectName(String paramString)
      {
        this.projectName = paramString;
      }
      
      public void setStatus(int paramInt)
      {
        this.status = paramInt;
      }
      
      public static class LabelTipBean
      {
        private int index;
        private String name;
        private String tipsType;
        
        public int getIndex()
        {
          return this.index;
        }
        
        public String getName()
        {
          return this.name;
        }
        
        public String getTipsType()
        {
          return this.tipsType;
        }
        
        public void setIndex(int paramInt)
        {
          this.index = paramInt;
        }
        
        public void setName(String paramString)
        {
          this.name = paramString;
        }
        
        public void setTipsType(String paramString)
        {
          this.tipsType = paramString;
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/searchlist/model/StationSearchListBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */