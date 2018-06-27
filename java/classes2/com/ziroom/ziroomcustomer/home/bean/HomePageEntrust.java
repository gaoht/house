package com.ziroom.ziroomcustomer.home.bean;

import com.freelxl.baselibrary.b.b;
import java.util.List;

public class HomePageEntrust
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
    private List<KnowZiroomBean> know_ziroom;
    private List<NewEntrustBean> new_entrust;
    private List<OwnerStoryBean> owner_story;
    private List<ContentBean> special;
    private WeituoBean weituo;
    private List<WhyChoiceBean> why_choice;
    
    public List<KnowZiroomBean> getKnow_ziroom()
    {
      return this.know_ziroom;
    }
    
    public List<NewEntrustBean> getNew_entrust()
    {
      return this.new_entrust;
    }
    
    public List<OwnerStoryBean> getOwner_story()
    {
      return this.owner_story;
    }
    
    public List<ContentBean> getSpecial()
    {
      return this.special;
    }
    
    public WeituoBean getWeituo()
    {
      return this.weituo;
    }
    
    public List<WhyChoiceBean> getWhy_choice()
    {
      return this.why_choice;
    }
    
    public void setKnow_ziroom(List<KnowZiroomBean> paramList)
    {
      this.know_ziroom = paramList;
    }
    
    public void setNew_entrust(List<NewEntrustBean> paramList)
    {
      this.new_entrust = paramList;
    }
    
    public void setOwner_story(List<OwnerStoryBean> paramList)
    {
      this.owner_story = paramList;
    }
    
    public void setSpecial(List<ContentBean> paramList)
    {
      this.special = paramList;
    }
    
    public void setWeituo(WeituoBean paramWeituoBean)
    {
      this.weituo = paramWeituoBean;
    }
    
    public void setWhy_choice(List<WhyChoiceBean> paramList)
    {
      this.why_choice = paramList;
    }
    
    public static class KnowZiroomBean
      extends ContentBean
    {}
    
    public static class NewEntrustBean
      extends ContentBean
    {}
    
    public static class OwnerStoryBean
      extends ContentBean
    {}
    
    public static class WeituoBean
    {
      private String link;
      private String subtitle;
      private String title;
      
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
    }
    
    public static class WhyChoiceBean
    {
      private String describe;
      private String pic;
      private String title;
      
      public String getDescribe()
      {
        return this.describe;
      }
      
      public String getPic()
      {
        return this.pic;
      }
      
      public String getTitle()
      {
        return this.title;
      }
      
      public void setDescribe(String paramString)
      {
        this.describe = paramString;
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
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/home/bean/HomePageEntrust.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */