package com.ziroom.ziroomcustomer.home.bean;

import com.freelxl.baselibrary.b.b;
import java.util.List;

public class HomePageRent
  extends b
{
  private DataBean data;
  
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
    private ActivitiesBean activities;
    private List<BrandBean> brand;
    private CommunitiesBean communities;
    private GonglveBean gonglve;
    private RoomsBean rooms;
    private ZiroomerBean ziroomer;
    
    public ActivitiesBean getActivities()
    {
      return this.activities;
    }
    
    public List<BrandBean> getBrand()
    {
      return this.brand;
    }
    
    public CommunitiesBean getCommunities()
    {
      return this.communities;
    }
    
    public GonglveBean getGonglve()
    {
      return this.gonglve;
    }
    
    public RoomsBean getRooms()
    {
      return this.rooms;
    }
    
    public ZiroomerBean getZiroomer()
    {
      return this.ziroomer;
    }
    
    public void setActivities(ActivitiesBean paramActivitiesBean)
    {
      this.activities = paramActivitiesBean;
    }
    
    public void setBrand(List<BrandBean> paramList)
    {
      this.brand = paramList;
    }
    
    public void setCommunities(CommunitiesBean paramCommunitiesBean)
    {
      this.communities = paramCommunitiesBean;
    }
    
    public void setGonglve(GonglveBean paramGonglveBean)
    {
      this.gonglve = paramGonglveBean;
    }
    
    public void setRooms(RoomsBean paramRoomsBean)
    {
      this.rooms = paramRoomsBean;
    }
    
    public void setZiroomer(ZiroomerBean paramZiroomerBean)
    {
      this.ziroomer = paramZiroomerBean;
    }
    
    public static class ActivitiesBean
    {
      private List<ContentBean> content;
      private String link;
      private String title;
      
      public List<ContentBean> getContent()
      {
        return this.content;
      }
      
      public String getLink()
      {
        return this.link;
      }
      
      public String getTitle()
      {
        return this.title;
      }
      
      public void setContent(List<ContentBean> paramList)
      {
        this.content = paramList;
      }
      
      public void setLink(String paramString)
      {
        this.link = paramString;
      }
      
      public void setTitle(String paramString)
      {
        this.title = paramString;
      }
      
      public static class ContentBean
      {
        private String link;
        private String pic;
        private String subtitle;
        private String title;
        
        public String getLink()
        {
          return this.link;
        }
        
        public String getPic()
        {
          return this.pic;
        }
        
        public String getSubtitle()
        {
          return this.subtitle;
        }
        
        public String getTitle()
        {
          return this.title;
        }
        
        public void setLink(String paramString)
        {
          this.link = paramString;
        }
        
        public void setPic(String paramString)
        {
          this.pic = paramString;
        }
        
        public void setSubtitle(String paramString)
        {
          this.subtitle = paramString;
        }
        
        public void setTitle(String paramString)
        {
          this.title = paramString;
        }
      }
    }
    
    public static class BrandBean
    {
      private String link;
      private String pic;
      private String subtitle;
      private String title;
      
      public String getLink()
      {
        return this.link;
      }
      
      public String getPic()
      {
        return this.pic;
      }
      
      public String getSubtitle()
      {
        return this.subtitle;
      }
      
      public String getTitle()
      {
        return this.title;
      }
      
      public void setLink(String paramString)
      {
        this.link = paramString;
      }
      
      public void setPic(String paramString)
      {
        this.pic = paramString;
      }
      
      public void setSubtitle(String paramString)
      {
        this.subtitle = paramString;
      }
      
      public void setTitle(String paramString)
      {
        this.title = paramString;
      }
    }
    
    public static class CommunitiesBean
    {
      private List<ContentBean> content;
      private String link;
      private String title;
      
      public List<ContentBean> getContent()
      {
        return this.content;
      }
      
      public String getLink()
      {
        return this.link;
      }
      
      public String getTitle()
      {
        return this.title;
      }
      
      public void setContent(List<ContentBean> paramList)
      {
        this.content = paramList;
      }
      
      public void setLink(String paramString)
      {
        this.link = paramString;
      }
      
      public void setTitle(String paramString)
      {
        this.title = paramString;
      }
      
      public static class ContentBean
      {
        private String link;
        private String pic;
        private String subtitle;
        private String title;
        
        public String getLink()
        {
          return this.link;
        }
        
        public String getPic()
        {
          return this.pic;
        }
        
        public String getSubtitle()
        {
          return this.subtitle;
        }
        
        public String getTitle()
        {
          return this.title;
        }
        
        public void setLink(String paramString)
        {
          this.link = paramString;
        }
        
        public void setPic(String paramString)
        {
          this.pic = paramString;
        }
        
        public void setSubtitle(String paramString)
        {
          this.subtitle = paramString;
        }
        
        public void setTitle(String paramString)
        {
          this.title = paramString;
        }
      }
    }
    
    public static class GonglveBean
    {
      private String link;
      private String pic;
      private String title;
      
      public String getLink()
      {
        return this.link;
      }
      
      public String getPic()
      {
        return this.pic;
      }
      
      public String getTitle()
      {
        return this.title;
      }
      
      public void setLink(String paramString)
      {
        this.link = paramString;
      }
      
      public void setPic(String paramString)
      {
        this.pic = paramString;
      }
      
      public void setTitle(String paramString)
      {
        this.title = paramString;
      }
    }
    
    public static class RoomsBean
    {
      private List<ContentBean> content;
      private String link;
      private String title;
      
      public List<ContentBean> getContent()
      {
        return this.content;
      }
      
      public String getLink()
      {
        return this.link;
      }
      
      public String getTitle()
      {
        return this.title;
      }
      
      public void setContent(List<ContentBean> paramList)
      {
        this.content = paramList;
      }
      
      public void setLink(String paramString)
      {
        this.link = paramString;
      }
      
      public void setTitle(String paramString)
      {
        this.title = paramString;
      }
      
      public static class ContentBean
      {
        private String link;
        private String pic;
        private String subtitle;
        private String title;
        private String types;
        
        public String getLink()
        {
          return this.link;
        }
        
        public String getPic()
        {
          return this.pic;
        }
        
        public String getSubtitle()
        {
          return this.subtitle;
        }
        
        public String getTitle()
        {
          return this.title;
        }
        
        public String getTypes()
        {
          return this.types;
        }
        
        public void setLink(String paramString)
        {
          this.link = paramString;
        }
        
        public void setPic(String paramString)
        {
          this.pic = paramString;
        }
        
        public void setSubtitle(String paramString)
        {
          this.subtitle = paramString;
        }
        
        public void setTitle(String paramString)
        {
          this.title = paramString;
        }
        
        public void setTypes(String paramString)
        {
          this.types = paramString;
        }
      }
    }
    
    public static class ZiroomerBean
    {
      private ContentBean content;
      private String link;
      private String title;
      
      public ContentBean getContent()
      {
        return this.content;
      }
      
      public String getLink()
      {
        return this.link;
      }
      
      public String getTitle()
      {
        return this.title;
      }
      
      public void setContent(ContentBean paramContentBean)
      {
        this.content = paramContentBean;
      }
      
      public void setLink(String paramString)
      {
        this.link = paramString;
      }
      
      public void setTitle(String paramString)
      {
        this.title = paramString;
      }
      
      public static class ContentBean
      {
        private String link;
        private String pic;
        private String subtitle;
        private String title;
        
        public String getLink()
        {
          return this.link;
        }
        
        public String getPic()
        {
          return this.pic;
        }
        
        public String getSubtitle()
        {
          return this.subtitle;
        }
        
        public String getTitle()
        {
          return this.title;
        }
        
        public void setLink(String paramString)
        {
          this.link = paramString;
        }
        
        public void setPic(String paramString)
        {
          this.pic = paramString;
        }
        
        public void setSubtitle(String paramString)
        {
          this.subtitle = paramString;
        }
        
        public void setTitle(String paramString)
        {
          this.title = paramString;
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/home/bean/HomePageRent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */