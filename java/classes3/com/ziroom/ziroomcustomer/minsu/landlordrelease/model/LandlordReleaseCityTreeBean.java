package com.ziroom.ziroomcustomer.minsu.landlordrelease.model;

import java.util.List;

public class LandlordReleaseCityTreeBean
{
  private DataBean data;
  private String message;
  private int status;
  
  public DataBean getData()
  {
    return this.data;
  }
  
  public String getMessage()
  {
    return this.message;
  }
  
  public int getStatus()
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
  
  public void setStatus(int paramInt)
  {
    this.status = paramInt;
  }
  
  public static class DataBean
  {
    private List<CityTreeListBean> cityTreeList;
    
    public List<CityTreeListBean> getCityTreeList()
    {
      return this.cityTreeList;
    }
    
    public void setCityTreeList(List<CityTreeListBean> paramList)
    {
      this.cityTreeList = paramList;
    }
    
    public static class CityTreeListBean
    {
      private String code;
      private int level;
      private List<NodesBeanXX> nodes;
      private String text;
      
      public String getCode()
      {
        return this.code;
      }
      
      public int getLevel()
      {
        return this.level;
      }
      
      public List<NodesBeanXX> getNodes()
      {
        return this.nodes;
      }
      
      public String getText()
      {
        return this.text;
      }
      
      public void setCode(String paramString)
      {
        this.code = paramString;
      }
      
      public void setLevel(int paramInt)
      {
        this.level = paramInt;
      }
      
      public void setNodes(List<NodesBeanXX> paramList)
      {
        this.nodes = paramList;
      }
      
      public void setText(String paramString)
      {
        this.text = paramString;
      }
      
      public static class NodesBeanXX
      {
        private String code;
        private int level;
        private List<NodesBeanX> nodes;
        private String text;
        
        public String getCode()
        {
          return this.code;
        }
        
        public int getLevel()
        {
          return this.level;
        }
        
        public List<NodesBeanX> getNodes()
        {
          return this.nodes;
        }
        
        public String getText()
        {
          return this.text;
        }
        
        public void setCode(String paramString)
        {
          this.code = paramString;
        }
        
        public void setLevel(int paramInt)
        {
          this.level = paramInt;
        }
        
        public void setNodes(List<NodesBeanX> paramList)
        {
          this.nodes = paramList;
        }
        
        public void setText(String paramString)
        {
          this.text = paramString;
        }
        
        public static class NodesBeanX
        {
          private String code;
          private int level;
          private List<NodesBean> nodes;
          private String text;
          
          public String getCode()
          {
            return this.code;
          }
          
          public int getLevel()
          {
            return this.level;
          }
          
          public List<NodesBean> getNodes()
          {
            return this.nodes;
          }
          
          public String getText()
          {
            return this.text;
          }
          
          public void setCode(String paramString)
          {
            this.code = paramString;
          }
          
          public void setLevel(int paramInt)
          {
            this.level = paramInt;
          }
          
          public void setNodes(List<NodesBean> paramList)
          {
            this.nodes = paramList;
          }
          
          public void setText(String paramString)
          {
            this.text = paramString;
          }
          
          public static class NodesBean
          {
            private String code;
            private int level;
            private List<?> nodes;
            private String text;
            
            public String getCode()
            {
              return this.code;
            }
            
            public int getLevel()
            {
              return this.level;
            }
            
            public List<?> getNodes()
            {
              return this.nodes;
            }
            
            public String getText()
            {
              return this.text;
            }
            
            public void setCode(String paramString)
            {
              this.code = paramString;
            }
            
            public void setLevel(int paramInt)
            {
              this.level = paramInt;
            }
            
            public void setNodes(List<?> paramList)
            {
              this.nodes = paramList;
            }
            
            public void setText(String paramString)
            {
              this.text = paramString;
            }
          }
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/model/LandlordReleaseCityTreeBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */