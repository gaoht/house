package com.ziroom.ziroomcustomer.ziroomapartment.model;

import java.util.List;

public class HomePageBeanZRY
{
  private List<ActivityBean> activity;
  private BusinessBean business;
  private CityBean city;
  private CommunityBean community;
  private HeadBean head;
  private RecommendBean recommend;
  private ZiroomerBean ziroomer;
  
  public List<ActivityBean> getActivity()
  {
    return this.activity;
  }
  
  public BusinessBean getBusiness()
  {
    return this.business;
  }
  
  public CityBean getCity()
  {
    return this.city;
  }
  
  public CommunityBean getCommunity()
  {
    return this.community;
  }
  
  public HeadBean getHead()
  {
    return this.head;
  }
  
  public RecommendBean getRecommend()
  {
    return this.recommend;
  }
  
  public ZiroomerBean getZiroomer()
  {
    return this.ziroomer;
  }
  
  public void setActivity(List<ActivityBean> paramList)
  {
    this.activity = paramList;
  }
  
  public void setBusiness(BusinessBean paramBusinessBean)
  {
    this.business = paramBusinessBean;
  }
  
  public void setCity(CityBean paramCityBean)
  {
    this.city = paramCityBean;
  }
  
  public void setCommunity(CommunityBean paramCommunityBean)
  {
    this.community = paramCommunityBean;
  }
  
  public void setHead(HeadBean paramHeadBean)
  {
    this.head = paramHeadBean;
  }
  
  public void setRecommend(RecommendBean paramRecommendBean)
  {
    this.recommend = paramRecommendBean;
  }
  
  public void setZiroomer(ZiroomerBean paramZiroomerBean)
  {
    this.ziroomer = paramZiroomerBean;
  }
  
  public static class ActivityBean
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
  
  public static class BusinessBean
  {
    private String business_mail;
    private String business_tel;
    
    public String getBusiness_mail()
    {
      return this.business_mail;
    }
    
    public String getBusiness_tel()
    {
      return this.business_tel;
    }
    
    public void setBusiness_mail(String paramString)
    {
      this.business_mail = paramString;
    }
    
    public void setBusiness_tel(String paramString)
    {
      this.business_tel = paramString;
    }
  }
  
  public static class CityBean
  {
    private List<CityNameBean> city_name;
    private String title;
    
    public List<CityNameBean> getCity_name()
    {
      return this.city_name;
    }
    
    public String getTitle()
    {
      return this.title;
    }
    
    public void setCity_name(List<CityNameBean> paramList)
    {
      this.city_name = paramList;
    }
    
    public void setTitle(String paramString)
    {
      this.title = paramString;
    }
    
    public static class CityNameBean
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
  
  public static class CommunityBean
  {
    private List<CommunitylistBean> communitylist;
    private String sub_title;
    private String title;
    
    public List<CommunitylistBean> getCommunitylist()
    {
      return this.communitylist;
    }
    
    public String getSub_title()
    {
      return this.sub_title;
    }
    
    public String getTitle()
    {
      return this.title;
    }
    
    public void setCommunitylist(List<CommunitylistBean> paramList)
    {
      this.communitylist = paramList;
    }
    
    public void setSub_title(String paramString)
    {
      this.sub_title = paramString;
    }
    
    public void setTitle(String paramString)
    {
      this.title = paramString;
    }
    
    public static class CommunitylistBean
    {
      private String activity_time;
      private String pic;
      private String rgb;
      private String subtitle;
      private String title;
      private String types;
      private String url;
      
      public String getActivity_time()
      {
        return this.activity_time;
      }
      
      public String getPic()
      {
        return this.pic;
      }
      
      public String getRgb()
      {
        return this.rgb;
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
      
      public String getUrl()
      {
        return this.url;
      }
      
      public void setActivity_time(String paramString)
      {
        this.activity_time = paramString;
      }
      
      public void setPic(String paramString)
      {
        this.pic = paramString;
      }
      
      public void setRgb(String paramString)
      {
        this.rgb = paramString;
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
      
      public void setUrl(String paramString)
      {
        this.url = paramString;
      }
    }
  }
  
  public static class HeadBean
  {
    private BannarBean bannar;
    private String sub_title;
    private String title;
    
    public BannarBean getBannar()
    {
      return this.bannar;
    }
    
    public String getSub_title()
    {
      return this.sub_title;
    }
    
    public String getTitle()
    {
      return this.title;
    }
    
    public void setBannar(BannarBean paramBannarBean)
    {
      this.bannar = paramBannarBean;
    }
    
    public void setSub_title(String paramString)
    {
      this.sub_title = paramString;
    }
    
    public void setTitle(String paramString)
    {
      this.title = paramString;
    }
    
    public static class BannarBean
    {
      private String img;
      private String target;
      private String title;
      private String type;
      
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
      
      public String getType()
      {
        return this.type;
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
      
      public void setType(String paramString)
      {
        this.type = paramString;
      }
    }
  }
  
  public static class RecommendBean
  {
    private List<CityNameBeanX> list;
    private String subtitle;
    private String title;
    
    public List<CityNameBeanX> getList()
    {
      return this.list;
    }
    
    public String getSubtitle()
    {
      return this.subtitle;
    }
    
    public String getTitle()
    {
      return this.title;
    }
    
    public void setList(List<CityNameBeanX> paramList)
    {
      this.list = paramList;
    }
    
    public void setSubtitle(String paramString)
    {
      this.subtitle = paramString;
    }
    
    public void setTitle(String paramString)
    {
      this.title = paramString;
    }
    
    public static class CityNameBeanX
    {
      private String app;
      private String description;
      private String img;
      private String share_desc;
      private String share_title;
      private String sub_title;
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
      
      public String getShare_desc()
      {
        return this.share_desc;
      }
      
      public String getShare_title()
      {
        return this.share_title;
      }
      
      public String getSub_title()
      {
        return this.sub_title;
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
      
      public void setShare_desc(String paramString)
      {
        this.share_desc = paramString;
      }
      
      public void setShare_title(String paramString)
      {
        this.share_title = paramString;
      }
      
      public void setSub_title(String paramString)
      {
        this.sub_title = paramString;
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
  
  public static class ZiroomerBean
  {
    private String sub_title;
    private String title;
    private List<ZiroomerlistBean> ziroomerlist;
    
    public String getSub_title()
    {
      return this.sub_title;
    }
    
    public String getTitle()
    {
      return this.title;
    }
    
    public List<ZiroomerlistBean> getZiroomerlist()
    {
      return this.ziroomerlist;
    }
    
    public void setSub_title(String paramString)
    {
      this.sub_title = paramString;
    }
    
    public void setTitle(String paramString)
    {
      this.title = paramString;
    }
    
    public void setZiroomerlist(List<ZiroomerlistBean> paramList)
    {
      this.ziroomerlist = paramList;
    }
    
    public static class ZiroomerlistBean
    {
      private String pic;
      private String rgb;
      private String subtitle;
      private String title;
      private String types;
      private String url;
      
      public String getPic()
      {
        return this.pic;
      }
      
      public String getRgb()
      {
        return this.rgb;
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
      
      public String getUrl()
      {
        return this.url;
      }
      
      public void setPic(String paramString)
      {
        this.pic = paramString;
      }
      
      public void setRgb(String paramString)
      {
        this.rgb = paramString;
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
      
      public void setUrl(String paramString)
      {
        this.url = paramString;
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/model/HomePageBeanZRY.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */