package com.ziroom.ziroomcustomer.minsu.bean;

import java.util.List;

public class MinsuMapKeywordBean
{
  private DataBean data;
  private int error_code;
  private String error_message;
  private String status;
  
  public DataBean getData()
  {
    return this.data;
  }
  
  public int getError_code()
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
  
  public void setData(DataBean paramDataBean)
  {
    this.data = paramDataBean;
  }
  
  public void setError_code(int paramInt)
  {
    this.error_code = paramInt;
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
    private List<POIBean> POI;
    
    public List<POIBean> getPOI()
    {
      return this.POI;
    }
    
    public void setPOI(List<POIBean> paramList)
    {
      this.POI = paramList;
    }
    
    public static class POIBean
    {
      private String app;
      private String description;
      private String img;
      private String target;
      private String title;
      
      public String getApp()
      {
        return this.app;
      }
      
      public String getDescription()
      {
        return this.description;
      }
      
      public String getImg()
      {
        return this.img;
      }
      
      public String getTarget()
      {
        return this.target;
      }
      
      public String getTitle()
      {
        return this.title;
      }
      
      public void setApp(String paramString)
      {
        this.app = paramString;
      }
      
      public void setDescription(String paramString)
      {
        this.description = paramString;
      }
      
      public void setImg(String paramString)
      {
        this.img = paramString;
      }
      
      public void setTarget(String paramString)
      {
        this.target = paramString;
      }
      
      public void setTitle(String paramString)
      {
        this.title = paramString;
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/bean/MinsuMapKeywordBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */