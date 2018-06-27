package com.ziroom.ziroomcustomer.home.bean;

import com.freelxl.baselibrary.b.b;
import java.util.List;

public class HomePageEntrustNew
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
    public AboutZiroomBean about_ziroom;
    public EntrustBean entrust;
    public HomePageEntrustNew.Estimate fangwugujia;
    public IntroduceBean introduce;
    public SelectNameBean select_name;
    public StoryBean story;
    public VideoBean video;
    public ZiroomProductBean ziroom_product;
    
    public AboutZiroomBean getAbout_ziroom()
    {
      return this.about_ziroom;
    }
    
    public EntrustBean getEntrust()
    {
      return this.entrust;
    }
    
    public HomePageEntrustNew.Estimate getFangwugujia()
    {
      return this.fangwugujia;
    }
    
    public IntroduceBean getIntroduce()
    {
      return this.introduce;
    }
    
    public SelectNameBean getSelect_name()
    {
      return this.select_name;
    }
    
    public StoryBean getStory()
    {
      return this.story;
    }
    
    public VideoBean getVideo()
    {
      return this.video;
    }
    
    public ZiroomProductBean getZiroom_product()
    {
      return this.ziroom_product;
    }
    
    public void setAbout_ziroom(AboutZiroomBean paramAboutZiroomBean)
    {
      this.about_ziroom = paramAboutZiroomBean;
    }
    
    public void setEntrust(EntrustBean paramEntrustBean)
    {
      this.entrust = paramEntrustBean;
    }
    
    public void setFangwugujia(HomePageEntrustNew.Estimate paramEstimate)
    {
      this.fangwugujia = paramEstimate;
    }
    
    public void setIntroduce(IntroduceBean paramIntroduceBean)
    {
      this.introduce = paramIntroduceBean;
    }
    
    public void setSelect_name(SelectNameBean paramSelectNameBean)
    {
      this.select_name = paramSelectNameBean;
    }
    
    public void setStory(StoryBean paramStoryBean)
    {
      this.story = paramStoryBean;
    }
    
    public void setVideo(VideoBean paramVideoBean)
    {
      this.video = paramVideoBean;
    }
    
    public void setZiroom_product(ZiroomProductBean paramZiroomProductBean)
    {
      this.ziroom_product = paramZiroomProductBean;
    }
    
    public static class AboutZiroomBean
    {
      public List<ContentBean> content;
      public String link;
      public String subtitle;
      public String title;
      
      public List<ContentBean> getContent()
      {
        return this.content;
      }
      
      public String getLink()
      {
        return this.link;
      }
      
      public String getSubtitle()
      {
        return this.subtitle;
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
      
      public void setSubtitle(String paramString)
      {
        this.subtitle = paramString;
      }
      
      public void setTitle(String paramString)
      {
        this.title = paramString;
      }
      
      public static class ContentBean
      {
        public String app;
        public String description;
        public String img;
        public String target;
        public String title;
        
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
    
    public static class EntrustBean
    {
      public String subtitle;
      public String title;
      
      public String getSubtitle()
      {
        return this.subtitle;
      }
      
      public String getTitle()
      {
        return this.title;
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
    
    public static class IntroduceBean
    {
      public List<ContentBean> content;
      
      public List<ContentBean> getContent()
      {
        return this.content;
      }
      
      public void setContent(List<ContentBean> paramList)
      {
        this.content = paramList;
      }
      
      public static class ContentBean
      {
        public String app;
        public String description;
        public String img;
        public String target;
        public String title;
        
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
    
    public static class SelectNameBean
    {
      public List<ContentBean> content;
      public String title;
      
      public List<ContentBean> getContent()
      {
        return this.content;
      }
      
      public String getTitle()
      {
        return this.title;
      }
      
      public void setContent(List<ContentBean> paramList)
      {
        this.content = paramList;
      }
      
      public void setTitle(String paramString)
      {
        this.title = paramString;
      }
      
      public static class ContentBean
      {
        public String app;
        public String description;
        public String img;
        public String target;
        public String title;
        
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
    
    public static class StoryBean
    {
      public List<ContentBean> content;
      public String link;
      public String more;
      public String subtitle;
      public String title;
      
      public List<ContentBean> getContent()
      {
        return this.content;
      }
      
      public String getLink()
      {
        return this.link;
      }
      
      public String getMore()
      {
        return this.more;
      }
      
      public String getSubtitle()
      {
        return this.subtitle;
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
      
      public void setMore(String paramString)
      {
        this.more = paramString;
      }
      
      public void setSubtitle(String paramString)
      {
        this.subtitle = paramString;
      }
      
      public void setTitle(String paramString)
      {
        this.title = paramString;
      }
      
      public static class ContentBean
      {
        public String app;
        public String description;
        public String img;
        public String target;
        public String title;
        
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
    
    public static class VideoBean
    {
      public List<ContentBean> content;
      public String title;
      
      public List<ContentBean> getContent()
      {
        return this.content;
      }
      
      public String getTitle()
      {
        return this.title;
      }
      
      public void setContent(List<ContentBean> paramList)
      {
        this.content = paramList;
      }
      
      public void setTitle(String paramString)
      {
        this.title = paramString;
      }
      
      public static class ContentBean
      {
        public String app;
        public String description;
        public String img;
        public String target;
        public String title;
        
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
    
    public static class ZiroomProductBean
    {
      public List<ContentBean> content;
      public String link;
      public String more;
      public String subtitle;
      public String title;
      
      public List<ContentBean> getContent()
      {
        return this.content;
      }
      
      public String getLink()
      {
        return this.link;
      }
      
      public String getMore()
      {
        return this.more;
      }
      
      public String getSubtitle()
      {
        return this.subtitle;
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
      
      public void setMore(String paramString)
      {
        this.more = paramString;
      }
      
      public void setSubtitle(String paramString)
      {
        this.subtitle = paramString;
      }
      
      public void setTitle(String paramString)
      {
        this.title = paramString;
      }
      
      public static class ContentBean
      {
        public String app;
        public String description;
        public String img;
        public String target;
        public String title;
        
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
  
  public static class Estimate
  {
    private String gujia;
    
    public String getGujia()
    {
      return this.gujia;
    }
    
    public void setGujia(String paramString)
    {
      this.gujia = paramString;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/home/bean/HomePageEntrustNew.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */