package com.ziroom.ziroomcustomer.minsu.bean;

import java.util.List;

public class MinsuHomeTopHouseListBean
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
    private String top50ListShareTitle;
    private int total;
    
    public List<ListBean> getList()
    {
      return this.list;
    }
    
    public String getTop50ListShareTitle()
    {
      return this.top50ListShareTitle;
    }
    
    public int getTotal()
    {
      return this.total;
    }
    
    public void setList(List<ListBean> paramList)
    {
      this.list = paramList;
    }
    
    public void setTop50ListShareTitle(String paramString)
    {
      this.top50ListShareTitle = paramString;
    }
    
    public void setTotal(int paramInt)
    {
      this.total = paramInt;
    }
    
    public static class ListBean
    {
      private String fid;
      private String houseName;
      private List<String> indivLabelTipsList;
      private String picUrl;
      private int rentWay;
      
      public String getFid()
      {
        return this.fid;
      }
      
      public String getHouseName()
      {
        return this.houseName;
      }
      
      public List<String> getIndivLabelTipsList()
      {
        return this.indivLabelTipsList;
      }
      
      public String getPicUrl()
      {
        return this.picUrl;
      }
      
      public int getRentWay()
      {
        return this.rentWay;
      }
      
      public void setFid(String paramString)
      {
        this.fid = paramString;
      }
      
      public void setHouseName(String paramString)
      {
        this.houseName = paramString;
      }
      
      public void setIndivLabelTipsList(List<String> paramList)
      {
        this.indivLabelTipsList = paramList;
      }
      
      public void setPicUrl(String paramString)
      {
        this.picUrl = paramString;
      }
      
      public void setRentWay(int paramInt)
      {
        this.rentWay = paramInt;
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/bean/MinsuHomeTopHouseListBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */