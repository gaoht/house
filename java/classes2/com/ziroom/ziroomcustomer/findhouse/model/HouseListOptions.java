package com.ziroom.ziroomcustomer.findhouse.model;

import java.util.List;

public class HouseListOptions
{
  private String adv_one;
  private List<LiveBean> live;
  private List<SelectBean> price;
  
  public String getAdv_one()
  {
    return this.adv_one;
  }
  
  public List<LiveBean> getLive()
  {
    return this.live;
  }
  
  public List<SelectBean> getPrice()
  {
    return this.price;
  }
  
  public void setAdv_one(String paramString)
  {
    this.adv_one = paramString;
  }
  
  public void setLive(List<LiveBean> paramList)
  {
    this.live = paramList;
  }
  
  public void setPrice(List<SelectBean> paramList)
  {
    this.price = paramList;
  }
  
  public static class LiveBean
  {
    private ChildrenBean children;
    private String title;
    private int value;
    
    public ChildrenBean getChildren()
    {
      return this.children;
    }
    
    public String getTitle()
    {
      return this.title;
    }
    
    public int getValue()
    {
      return this.value;
    }
    
    public void setChildren(ChildrenBean paramChildrenBean)
    {
      this.children = paramChildrenBean;
    }
    
    public void setTitle(String paramString)
    {
      this.title = paramString;
    }
    
    public void setValue(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static class ChildrenBean
    {
      private List<TypeBean> type;
      
      public List<TypeBean> getType()
      {
        return this.type;
      }
      
      public void setType(List<TypeBean> paramList)
      {
        this.type = paramList;
      }
      
      public static class TypeBean
      {
        private String show;
        private String title;
        private int type;
        private String value;
        
        public String getShow()
        {
          return this.show;
        }
        
        public String getTitle()
        {
          return this.title;
        }
        
        public int getType()
        {
          return this.type;
        }
        
        public String getValue()
        {
          return this.value;
        }
        
        public void setShow(String paramString)
        {
          this.show = paramString;
        }
        
        public void setTitle(String paramString)
        {
          this.title = paramString;
        }
        
        public void setType(int paramInt)
        {
          this.type = paramInt;
        }
        
        public void setValue(String paramString)
        {
          this.value = paramString;
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/model/HouseListOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */