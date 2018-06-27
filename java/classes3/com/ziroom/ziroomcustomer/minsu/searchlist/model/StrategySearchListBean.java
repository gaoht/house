package com.ziroom.ziroomcustomer.minsu.searchlist.model;

import java.util.List;

public class StrategySearchListBean
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
      private String bannerImg;
      private String businessArea;
      private String cityCode;
      private String cityName;
      private String id;
      private String subCategory;
      private String subTitle;
      private String targetUrl;
      private String title;
      
      public boolean equals(Object paramObject)
      {
        if ((getId() != null) && (paramObject != null) && ((paramObject instanceof ListBean)))
        {
          paramObject = (ListBean)paramObject;
          return getId().equals(((ListBean)paramObject).getId());
        }
        return false;
      }
      
      public String getBannerImg()
      {
        return this.bannerImg;
      }
      
      public String getBusinessArea()
      {
        return this.businessArea;
      }
      
      public String getCityCode()
      {
        return this.cityCode;
      }
      
      public String getCityName()
      {
        return this.cityName;
      }
      
      public String getId()
      {
        return this.id;
      }
      
      public String getSubCategory()
      {
        return this.subCategory;
      }
      
      public String getSubTitle()
      {
        return this.subTitle;
      }
      
      public String getTargetUrl()
      {
        return this.targetUrl;
      }
      
      public String getTitle()
      {
        return this.title;
      }
      
      public void setBannerImg(String paramString)
      {
        this.bannerImg = paramString;
      }
      
      public void setBusinessArea(String paramString)
      {
        this.businessArea = paramString;
      }
      
      public void setCityCode(String paramString)
      {
        this.cityCode = paramString;
      }
      
      public void setCityName(String paramString)
      {
        this.cityName = paramString;
      }
      
      public void setId(String paramString)
      {
        this.id = paramString;
      }
      
      public void setSubCategory(String paramString)
      {
        this.subCategory = paramString;
      }
      
      public void setSubTitle(String paramString)
      {
        this.subTitle = paramString;
      }
      
      public void setTargetUrl(String paramString)
      {
        this.targetUrl = paramString;
      }
      
      public void setTitle(String paramString)
      {
        this.title = paramString;
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/searchlist/model/StrategySearchListBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */