package com.ziroom.ziroomcustomer.minsu.searchlist.model;

import java.util.List;

public class LocationInfoBean
{
  private DataBeanXX data;
  private String message;
  private String status;
  
  public DataBeanXX getData()
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
  
  public void setData(DataBeanXX paramDataBeanXX)
  {
    this.data = paramDataBeanXX;
  }
  
  public void setMessage(String paramString)
  {
    this.message = paramString;
  }
  
  public void setStatus(String paramString)
  {
    this.status = paramString;
  }
  
  public static class DataBeanXX
  {
    private List<ListBean> list;
    
    public List<ListBean> getList()
    {
      return this.list;
    }
    
    public void setList(List<ListBean> paramList)
    {
      this.list = paramList;
    }
    
    public static class ListBean
    {
      private List<DataBeanX> data;
      private String key;
      private String name;
      
      public List<DataBeanX> getData()
      {
        return this.data;
      }
      
      public String getKey()
      {
        return this.key;
      }
      
      public String getName()
      {
        return this.name;
      }
      
      public void setData(List<DataBeanX> paramList)
      {
        this.data = paramList;
      }
      
      public void setKey(String paramString)
      {
        this.key = paramString;
      }
      
      public void setName(String paramString)
      {
        this.name = paramString;
      }
      
      public static class DataBeanX
      {
        private List<DataBean> data;
        private String key;
        private Double latitude;
        private Double longitude;
        private String name;
        private String value;
        
        public List<DataBean> getData()
        {
          return this.data;
        }
        
        public String getKey()
        {
          return this.key;
        }
        
        public Double getLatitude()
        {
          return this.latitude;
        }
        
        public Double getLongitude()
        {
          return this.longitude;
        }
        
        public String getName()
        {
          return this.name;
        }
        
        public String getValue()
        {
          return this.value;
        }
        
        public void setData(List<DataBean> paramList)
        {
          this.data = paramList;
        }
        
        public void setKey(String paramString)
        {
          this.key = paramString;
        }
        
        public void setLatitude(Double paramDouble)
        {
          this.latitude = paramDouble;
        }
        
        public void setLongitude(Double paramDouble)
        {
          this.longitude = paramDouble;
        }
        
        public void setName(String paramString)
        {
          this.name = paramString;
        }
        
        public void setValue(String paramString)
        {
          this.value = paramString;
        }
        
        public static class DataBean
        {
          private Double latitude;
          private Double longitude;
          private String name;
          private int unlimited;
          private String value;
          
          public Double getLatitude()
          {
            return this.latitude;
          }
          
          public Double getLongitude()
          {
            return this.longitude;
          }
          
          public String getName()
          {
            return this.name;
          }
          
          public int getUnlimited()
          {
            return this.unlimited;
          }
          
          public String getValue()
          {
            return this.value;
          }
          
          public void setLatitude(Double paramDouble)
          {
            this.latitude = paramDouble;
          }
          
          public void setLongitude(Double paramDouble)
          {
            this.longitude = paramDouble;
          }
          
          public void setName(String paramString)
          {
            this.name = paramString;
          }
          
          public void setUnlimited(int paramInt)
          {
            this.unlimited = paramInt;
          }
          
          public void setValue(String paramString)
          {
            this.value = paramString;
          }
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/searchlist/model/LocationInfoBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */