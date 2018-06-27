package com.ziroom.ziroomcustomer.home.bean;

import com.freelxl.baselibrary.b.b;
import java.io.Serializable;
import java.util.List;

public class HomePageRentNew
  extends b
  implements Serializable
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
    implements Serializable
  {
    private ActivitiesBean activities;
    private List<BrandBean> brand;
    private BrandImgBean brand_img;
    private CommunitiesBean communities;
    private GonglveBean gonglve;
    private LeavesBean leaves;
    private RoomsBean rooms;
    private RoomsFzBean rooms_fz;
    private RoomsZzBean rooms_zz;
    private ServiceBean service;
    private ServiceV2Bean service_v2;
    private YezhuBean yezhu;
    private ZiroomerBean ziroomer;
    
    public ActivitiesBean getActivities()
    {
      return this.activities;
    }
    
    public List<BrandBean> getBrand()
    {
      return this.brand;
    }
    
    public BrandImgBean getBrand_img()
    {
      return this.brand_img;
    }
    
    public CommunitiesBean getCommunities()
    {
      return this.communities;
    }
    
    public GonglveBean getGonglve()
    {
      return this.gonglve;
    }
    
    public LeavesBean getLeaves()
    {
      return this.leaves;
    }
    
    public RoomsBean getRooms()
    {
      return this.rooms;
    }
    
    public RoomsFzBean getRooms_fz()
    {
      return this.rooms_fz;
    }
    
    public RoomsZzBean getRooms_zz()
    {
      return this.rooms_zz;
    }
    
    public ServiceBean getService()
    {
      return this.service;
    }
    
    public ServiceV2Bean getService_v2()
    {
      return this.service_v2;
    }
    
    public YezhuBean getYezhu()
    {
      return this.yezhu;
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
    
    public void setBrand_img(BrandImgBean paramBrandImgBean)
    {
      this.brand_img = paramBrandImgBean;
    }
    
    public void setCommunities(CommunitiesBean paramCommunitiesBean)
    {
      this.communities = paramCommunitiesBean;
    }
    
    public void setGonglve(GonglveBean paramGonglveBean)
    {
      this.gonglve = paramGonglveBean;
    }
    
    public void setLeaves(LeavesBean paramLeavesBean)
    {
      this.leaves = paramLeavesBean;
    }
    
    public void setRooms(RoomsBean paramRoomsBean)
    {
      this.rooms = paramRoomsBean;
    }
    
    public void setRooms_fz(RoomsFzBean paramRoomsFzBean)
    {
      this.rooms_fz = paramRoomsFzBean;
    }
    
    public void setRooms_zz(RoomsZzBean paramRoomsZzBean)
    {
      this.rooms_zz = paramRoomsZzBean;
    }
    
    public void setService(ServiceBean paramServiceBean)
    {
      this.service = paramServiceBean;
    }
    
    public void setService_v2(ServiceV2Bean paramServiceV2Bean)
    {
      this.service_v2 = paramServiceV2Bean;
    }
    
    public void setYezhu(YezhuBean paramYezhuBean)
    {
      this.yezhu = paramYezhuBean;
    }
    
    public void setZiroomer(ZiroomerBean paramZiroomerBean)
    {
      this.ziroomer = paramZiroomerBean;
    }
    
    public static class ActivitiesBean
    {
      private List<ContentBeanX> content;
      private String link;
      private MoreBeanX more;
      private String title;
      
      public List<ContentBeanX> getContent()
      {
        return this.content;
      }
      
      public String getLink()
      {
        return this.link;
      }
      
      public MoreBeanX getMore()
      {
        return this.more;
      }
      
      public String getTitle()
      {
        return this.title;
      }
      
      public void setContent(List<ContentBeanX> paramList)
      {
        this.content = paramList;
      }
      
      public void setLink(String paramString)
      {
        this.link = paramString;
      }
      
      public void setMore(MoreBeanX paramMoreBeanX)
      {
        this.more = paramMoreBeanX;
      }
      
      public void setTitle(String paramString)
      {
        this.title = paramString;
      }
      
      public static class ContentBeanX
        extends ContentBean
      {}
      
      public static class MoreBeanX {}
    }
    
    public static class BrandBean
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
    
    public static class BrandImgBean
    {
      private List<ContentBeanXXXXXXXXX> content;
      private String link;
      private MoreBeanXXXXXXXX more;
      private String title;
      
      public List<ContentBeanXXXXXXXXX> getContent()
      {
        return this.content;
      }
      
      public String getLink()
      {
        return this.link;
      }
      
      public MoreBeanXXXXXXXX getMore()
      {
        return this.more;
      }
      
      public String getTitle()
      {
        return this.title;
      }
      
      public void setContent(List<ContentBeanXXXXXXXXX> paramList)
      {
        this.content = paramList;
      }
      
      public void setLink(String paramString)
      {
        this.link = paramString;
      }
      
      public void setMore(MoreBeanXXXXXXXX paramMoreBeanXXXXXXXX)
      {
        this.more = paramMoreBeanXXXXXXXX;
      }
      
      public void setTitle(String paramString)
      {
        this.title = paramString;
      }
      
      public static class ContentBeanXXXXXXXXX
        extends ContentBean
      {}
      
      public static class MoreBeanXXXXXXXX {}
    }
    
    public static class CommunitiesBean
    {
      private List<ContentBeanXX> content;
      private String link;
      private MoreBeanXX more;
      private String subtitle;
      private String title;
      
      public List<ContentBeanXX> getContent()
      {
        return this.content;
      }
      
      public String getLink()
      {
        return this.link;
      }
      
      public MoreBeanXX getMore()
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
      
      public void setContent(List<ContentBeanXX> paramList)
      {
        this.content = paramList;
      }
      
      public void setLink(String paramString)
      {
        this.link = paramString;
      }
      
      public void setMore(MoreBeanXX paramMoreBeanXX)
      {
        this.more = paramMoreBeanXX;
      }
      
      public void setSubtitle(String paramString)
      {
        this.subtitle = paramString;
      }
      
      public void setTitle(String paramString)
      {
        this.title = paramString;
      }
      
      public static class ContentBeanXX
        extends ContentBean
      {}
      
      public static class MoreBeanXX {}
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
    
    public static class LeavesBean
    {
      private List<ContentBeanXXXXXXXX> content;
      private String link;
      private MoreBeanXXXXXXX more;
      private String subtitle;
      private String title;
      
      public List<ContentBeanXXXXXXXX> getContent()
      {
        return this.content;
      }
      
      public String getLink()
      {
        return this.link;
      }
      
      public MoreBeanXXXXXXX getMore()
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
      
      public void setContent(List<ContentBeanXXXXXXXX> paramList)
      {
        this.content = paramList;
      }
      
      public void setLink(String paramString)
      {
        this.link = paramString;
      }
      
      public void setMore(MoreBeanXXXXXXX paramMoreBeanXXXXXXX)
      {
        this.more = paramMoreBeanXXXXXXX;
      }
      
      public void setSubtitle(String paramString)
      {
        this.subtitle = paramString;
      }
      
      public void setTitle(String paramString)
      {
        this.title = paramString;
      }
      
      public static class ContentBeanXXXXXXXX
        extends ContentBean
      {}
      
      public static class MoreBeanXXXXXXX {}
    }
    
    public static class RoomsBean
    {
      private List<ContentBeanR> content;
      private String link;
      private MoreBean more;
      private String subtitle;
      private String title;
      
      public List<ContentBeanR> getContent()
      {
        return this.content;
      }
      
      public String getLink()
      {
        return this.link;
      }
      
      public MoreBean getMore()
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
      
      public void setContent(List<ContentBeanR> paramList)
      {
        this.content = paramList;
      }
      
      public void setLink(String paramString)
      {
        this.link = paramString;
      }
      
      public void setMore(MoreBean paramMoreBean)
      {
        this.more = paramMoreBean;
      }
      
      public void setSubtitle(String paramString)
      {
        this.subtitle = paramString;
      }
      
      public void setTitle(String paramString)
      {
        this.title = paramString;
      }
      
      public static class ContentBeanR
        extends ContentBean
      {}
      
      public static class MoreBean {}
    }
    
    public static class RoomsFzBean
      implements Serializable
    {
      private List<ContentBeanXXXX> content;
      private String link;
      private MoreBeanXXX more;
      private String subtitle;
      private String title;
      
      public List<ContentBeanXXXX> getContent()
      {
        return this.content;
      }
      
      public String getLink()
      {
        return this.link;
      }
      
      public MoreBeanXXX getMore()
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
      
      public void setContent(List<ContentBeanXXXX> paramList)
      {
        this.content = paramList;
      }
      
      public void setLink(String paramString)
      {
        this.link = paramString;
      }
      
      public void setMore(MoreBeanXXX paramMoreBeanXXX)
      {
        this.more = paramMoreBeanXXX;
      }
      
      public void setSubtitle(String paramString)
      {
        this.subtitle = paramString;
      }
      
      public void setTitle(String paramString)
      {
        this.title = paramString;
      }
      
      public static class ContentBeanXXXX
        extends ContentBean
      {}
      
      public static class MoreBeanXXX
        extends MoreBean
        implements Serializable
      {}
    }
    
    public static class RoomsZzBean
      implements Serializable
    {
      private List<ContentBeanXXXXX> content;
      private String link;
      private MoreBeanXXXX more;
      private String subtitle;
      private String title;
      
      public List<ContentBeanXXXXX> getContent()
      {
        return this.content;
      }
      
      public String getLink()
      {
        return this.link;
      }
      
      public MoreBeanXXXX getMore()
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
      
      public void setContent(List<ContentBeanXXXXX> paramList)
      {
        this.content = paramList;
      }
      
      public void setLink(String paramString)
      {
        this.link = paramString;
      }
      
      public void setMore(MoreBeanXXXX paramMoreBeanXXXX)
      {
        this.more = paramMoreBeanXXXX;
      }
      
      public void setSubtitle(String paramString)
      {
        this.subtitle = paramString;
      }
      
      public void setTitle(String paramString)
      {
        this.title = paramString;
      }
      
      public static class ContentBeanXXXXX
        extends ContentBean
        implements Serializable
      {}
      
      public static class MoreBeanXXXX
        extends MoreBean
        implements Serializable
      {}
    }
    
    public static class ServiceBean
    {
      private List<ContentBeanXXXXXXX> content;
      private String link;
      private MoreBeanXXXXXX more;
      private String subtitle;
      private String title;
      
      public List<ContentBeanXXXXXXX> getContent()
      {
        return this.content;
      }
      
      public String getLink()
      {
        return this.link;
      }
      
      public MoreBeanXXXXXX getMore()
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
      
      public void setContent(List<ContentBeanXXXXXXX> paramList)
      {
        this.content = paramList;
      }
      
      public void setLink(String paramString)
      {
        this.link = paramString;
      }
      
      public void setMore(MoreBeanXXXXXX paramMoreBeanXXXXXX)
      {
        this.more = paramMoreBeanXXXXXX;
      }
      
      public void setSubtitle(String paramString)
      {
        this.subtitle = paramString;
      }
      
      public void setTitle(String paramString)
      {
        this.title = paramString;
      }
      
      public static class ContentBeanXXXXXXX
        extends ContentBean
      {}
      
      public static class MoreBeanXXXXXX {}
    }
    
    public static class ServiceV2Bean
    {
      private List<ContentBeanV2> content;
      private String link;
      private String subtitle;
      private String title;
      
      public List<ContentBeanV2> getContent()
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
      
      public void setContent(List<ContentBeanV2> paramList)
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
      
      public static class ContentBeanV2
        extends ContentBean
      {
        private String rgb;
        
        public String getRgb()
        {
          return this.rgb;
        }
        
        public void setRgb(String paramString)
        {
          this.rgb = paramString;
        }
      }
    }
    
    public static class YezhuBean
      implements Serializable
    {
      private List<ContentBeanXXXXXX> content;
      private String link;
      private MoreBeanXXXXX more;
      private String subtitle;
      private String title;
      
      public List<ContentBeanXXXXXX> getContent()
      {
        return this.content;
      }
      
      public String getLink()
      {
        return this.link;
      }
      
      public MoreBeanXXXXX getMore()
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
      
      public void setContent(List<ContentBeanXXXXXX> paramList)
      {
        this.content = paramList;
      }
      
      public void setLink(String paramString)
      {
        this.link = paramString;
      }
      
      public void setMore(MoreBeanXXXXX paramMoreBeanXXXXX)
      {
        this.more = paramMoreBeanXXXXX;
      }
      
      public void setSubtitle(String paramString)
      {
        this.subtitle = paramString;
      }
      
      public void setTitle(String paramString)
      {
        this.title = paramString;
      }
      
      public static class ContentBeanXXXXXX
        extends ContentBean
        implements Serializable
      {}
      
      public static class MoreBeanXXXXX
        extends MoreBean
        implements Serializable
      {}
    }
    
    public static class ZiroomerBean
    {
      private ContentBeanXXX content;
      private String link;
      private String title;
      
      public ContentBeanXXX getContent()
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
      
      public void setContent(ContentBeanXXX paramContentBeanXXX)
      {
        this.content = paramContentBeanXXX;
      }
      
      public void setLink(String paramString)
      {
        this.link = paramString;
      }
      
      public void setTitle(String paramString)
      {
        this.title = paramString;
      }
      
      public static class ContentBeanXXX
        extends ContentBean
      {}
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/home/bean/HomePageRentNew.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */