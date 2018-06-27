package com.ziroom.ziroomcustomer.findhouse.model;

import java.io.Serializable;
import java.util.List;

public class DistrictDetail
{
  public EnvBean environment;
  private IntroBean intro;
  private String lat;
  private String lng;
  private Share moments_share;
  public PropertyBean property;
  private Share qq_share;
  private Share qzone_share;
  public RankBean rank;
  private String resblock_name;
  private List<HouseItem> rooms;
  private List<SpaceBean> space;
  private List<String> subway;
  private String subway_primary;
  public SurroundBean surround;
  public List<String> tag;
  private Share wechat_share;
  private Share weibo_share;
  
  public IntroBean getIntro()
  {
    return this.intro;
  }
  
  public String getLat()
  {
    return this.lat;
  }
  
  public String getLng()
  {
    return this.lng;
  }
  
  public Share getMoments_share()
  {
    return this.moments_share;
  }
  
  public Share getQq_share()
  {
    return this.qq_share;
  }
  
  public Share getQzone_share()
  {
    return this.qzone_share;
  }
  
  public String getResblock_name()
  {
    return this.resblock_name;
  }
  
  public List<HouseItem> getRooms()
  {
    return this.rooms;
  }
  
  public List<SpaceBean> getSpace()
  {
    return this.space;
  }
  
  public List<String> getSubway()
  {
    return this.subway;
  }
  
  public String getSubway_primary()
  {
    return this.subway_primary;
  }
  
  public Share getWechat_share()
  {
    return this.wechat_share;
  }
  
  public Share getWeibo_share()
  {
    return this.weibo_share;
  }
  
  public void setIntro(IntroBean paramIntroBean)
  {
    this.intro = paramIntroBean;
  }
  
  public void setLat(String paramString)
  {
    this.lat = paramString;
  }
  
  public void setLng(String paramString)
  {
    this.lng = paramString;
  }
  
  public void setMoments_share(Share paramShare)
  {
    this.moments_share = paramShare;
  }
  
  public void setQq_share(Share paramShare)
  {
    this.qq_share = paramShare;
  }
  
  public void setQzone_share(Share paramShare)
  {
    this.qzone_share = paramShare;
  }
  
  public void setResblock_name(String paramString)
  {
    this.resblock_name = paramString;
  }
  
  public void setRooms(List<HouseItem> paramList)
  {
    this.rooms = paramList;
  }
  
  public void setSpace(List<SpaceBean> paramList)
  {
    this.space = paramList;
  }
  
  public void setSubway(List<String> paramList)
  {
    this.subway = paramList;
  }
  
  public void setSubway_primary(String paramString)
  {
    this.subway_primary = paramString;
  }
  
  public void setWechat_share(Share paramShare)
  {
    this.wechat_share = paramShare;
  }
  
  public void setWeibo_share(Share paramShare)
  {
    this.weibo_share = paramShare;
  }
  
  public static class EnvBean
  {
    public String desc;
    public String title;
  }
  
  public static class IntroBean
  {
    private List<DataBean> data;
    private String title;
    private String total_title;
    
    public List<DataBean> getData()
    {
      return this.data;
    }
    
    public String getTitle()
    {
      return this.title;
    }
    
    public String getTotal_title()
    {
      return this.total_title;
    }
    
    public void setData(List<DataBean> paramList)
    {
      this.data = paramList;
    }
    
    public void setTitle(String paramString)
    {
      this.title = paramString;
    }
    
    public void setTotal_title(String paramString)
    {
      this.total_title = paramString;
    }
    
    public static class DataBean
    {
      private String desc;
      private String title;
      
      public String getDesc()
      {
        return this.desc;
      }
      
      public String getTitle()
      {
        return this.title;
      }
      
      public void setDesc(String paramString)
      {
        this.desc = paramString;
      }
      
      public void setTitle(String paramString)
      {
        this.title = paramString;
      }
    }
  }
  
  public static class PropertyBean
  {
    public String desc;
    public String title;
  }
  
  public static class RankBean
  {
    public String desc;
    public String icon;
  }
  
  public static class Share
    implements Serializable
  {
    private String active;
    private String content;
    private String title;
    private String url;
    
    public String getActive()
    {
      return this.active;
    }
    
    public String getContent()
    {
      return this.content;
    }
    
    public String getTitle()
    {
      return this.title;
    }
    
    public String getUrl()
    {
      return this.url;
    }
    
    public void setActive(String paramString)
    {
      this.active = paramString;
    }
    
    public void setContent(String paramString)
    {
      this.content = paramString;
    }
    
    public void setTitle(String paramString)
    {
      this.title = paramString;
    }
    
    public void setUrl(String paramString)
    {
      this.url = paramString;
    }
  }
  
  public static class SpaceBean
  {
    private List<String> photos_big;
    private List<String> photos_min;
    private String title;
    
    public List<String> getPhotos_big()
    {
      return this.photos_big;
    }
    
    public List<String> getPhotos_min()
    {
      return this.photos_min;
    }
    
    public String getTitle()
    {
      return this.title;
    }
    
    public void setPhotos_big(List<String> paramList)
    {
      this.photos_big = paramList;
    }
    
    public void setPhotos_min(List<String> paramList)
    {
      this.photos_min = paramList;
    }
    
    public void setTitle(String paramString)
    {
      this.title = paramString;
    }
  }
  
  public static class SurroundBean
  {
    public List<DataBean> data;
    public String title;
    
    public static class DataBean
    {
      public String desc;
      public List<String> keywords;
      public String title;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/model/DistrictDetail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */