package com.ziroom.ziroomcustomer.findhouse.presenter.model;

import com.freelxl.baselibrary.b.b;
import java.io.Serializable;
import java.util.List;

public class EntireHouseDetail
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
  {
    private String area;
    private int bedroom;
    private String bizcircle_code;
    private String bizcircle_name;
    private String code;
    private String district_name;
    private EnsuresBean ensures;
    private String face;
    private String floor;
    private String floor_total;
    private String heating_type;
    private String house_code;
    private String house_id;
    private int house_type;
    private List<String> hx_photos_big;
    private List<String> hx_photos_min;
    private String id;
    private String introduction;
    private int is_duanzu;
    private String is_newsign;
    private int is_reserve;
    private MomentsShareBean moments_share;
    private String name;
    private String notice_word;
    private int parlor;
    private List<String> photos_big;
    private List<String> photos_min;
    private String price;
    private String price_desc;
    private String price_unit;
    private QqShareBean qq_share;
    private QzoneShareBean qzone_share;
    private ResblockBean resblock;
    private String reserve_message;
    private String sign_date;
    private List<SpaceBean> space;
    private String status;
    private String subway_primary;
    private List<TagsBean> tags;
    private WechatShareBean wechat_share;
    private WeiboShareBean weibo_share;
    
    public String getArea()
    {
      return this.area;
    }
    
    public int getBedroom()
    {
      return this.bedroom;
    }
    
    public String getBizcircle_code()
    {
      return this.bizcircle_code;
    }
    
    public String getBizcircle_name()
    {
      return this.bizcircle_name;
    }
    
    public String getCode()
    {
      return this.code;
    }
    
    public String getDistrict_name()
    {
      return this.district_name;
    }
    
    public EnsuresBean getEnsures()
    {
      return this.ensures;
    }
    
    public String getFace()
    {
      return this.face;
    }
    
    public String getFloor()
    {
      return this.floor;
    }
    
    public String getFloor_total()
    {
      return this.floor_total;
    }
    
    public String getHeating_type()
    {
      return this.heating_type;
    }
    
    public String getHouse_code()
    {
      return this.house_code;
    }
    
    public String getHouse_id()
    {
      return this.house_id;
    }
    
    public int getHouse_type()
    {
      return this.house_type;
    }
    
    public List<String> getHx_photos_big()
    {
      return this.hx_photos_big;
    }
    
    public List<String> getHx_photos_min()
    {
      return this.hx_photos_min;
    }
    
    public String getId()
    {
      return this.id;
    }
    
    public String getIntroduction()
    {
      return this.introduction;
    }
    
    public int getIs_duanzu()
    {
      return this.is_duanzu;
    }
    
    public String getIs_newsign()
    {
      return this.is_newsign;
    }
    
    public int getIs_reserve()
    {
      return this.is_reserve;
    }
    
    public MomentsShareBean getMoments_share()
    {
      return this.moments_share;
    }
    
    public String getName()
    {
      return this.name;
    }
    
    public String getNotice_word()
    {
      return this.notice_word;
    }
    
    public int getParlor()
    {
      return this.parlor;
    }
    
    public List<String> getPhotos_big()
    {
      return this.photos_big;
    }
    
    public List<String> getPhotos_min()
    {
      return this.photos_min;
    }
    
    public String getPrice()
    {
      return this.price;
    }
    
    public String getPrice_desc()
    {
      return this.price_desc;
    }
    
    public String getPrice_unit()
    {
      return this.price_unit;
    }
    
    public QqShareBean getQq_share()
    {
      return this.qq_share;
    }
    
    public QzoneShareBean getQzone_share()
    {
      return this.qzone_share;
    }
    
    public ResblockBean getResblock()
    {
      return this.resblock;
    }
    
    public String getReserve_message()
    {
      return this.reserve_message;
    }
    
    public String getSign_date()
    {
      return this.sign_date;
    }
    
    public List<SpaceBean> getSpace()
    {
      return this.space;
    }
    
    public String getStatus()
    {
      return this.status;
    }
    
    public String getSubway_primary()
    {
      return this.subway_primary;
    }
    
    public List<TagsBean> getTags()
    {
      return this.tags;
    }
    
    public WechatShareBean getWechat_share()
    {
      return this.wechat_share;
    }
    
    public WeiboShareBean getWeibo_share()
    {
      return this.weibo_share;
    }
    
    public void setArea(String paramString)
    {
      this.area = paramString;
    }
    
    public void setBedroom(int paramInt)
    {
      this.bedroom = paramInt;
    }
    
    public void setBizcircle_code(String paramString)
    {
      this.bizcircle_code = paramString;
    }
    
    public void setBizcircle_name(String paramString)
    {
      this.bizcircle_name = paramString;
    }
    
    public void setCode(String paramString)
    {
      this.code = paramString;
    }
    
    public void setDistrict_name(String paramString)
    {
      this.district_name = paramString;
    }
    
    public void setEnsures(EnsuresBean paramEnsuresBean)
    {
      this.ensures = paramEnsuresBean;
    }
    
    public void setFace(String paramString)
    {
      this.face = paramString;
    }
    
    public void setFloor(String paramString)
    {
      this.floor = paramString;
    }
    
    public void setFloor_total(String paramString)
    {
      this.floor_total = paramString;
    }
    
    public void setHeating_type(String paramString)
    {
      this.heating_type = paramString;
    }
    
    public void setHouse_code(String paramString)
    {
      this.house_code = paramString;
    }
    
    public void setHouse_id(String paramString)
    {
      this.house_id = paramString;
    }
    
    public void setHouse_type(int paramInt)
    {
      this.house_type = paramInt;
    }
    
    public void setHx_photos_big(List<String> paramList)
    {
      this.hx_photos_big = paramList;
    }
    
    public void setHx_photos_min(List<String> paramList)
    {
      this.hx_photos_min = paramList;
    }
    
    public void setId(String paramString)
    {
      this.id = paramString;
    }
    
    public void setIntroduction(String paramString)
    {
      this.introduction = paramString;
    }
    
    public void setIs_duanzu(int paramInt)
    {
      this.is_duanzu = paramInt;
    }
    
    public void setIs_newsign(String paramString)
    {
      this.is_newsign = paramString;
    }
    
    public void setIs_reserve(int paramInt)
    {
      this.is_reserve = paramInt;
    }
    
    public void setMoments_share(MomentsShareBean paramMomentsShareBean)
    {
      this.moments_share = paramMomentsShareBean;
    }
    
    public void setName(String paramString)
    {
      this.name = paramString;
    }
    
    public void setNotice_word(String paramString)
    {
      this.notice_word = paramString;
    }
    
    public void setParlor(int paramInt)
    {
      this.parlor = paramInt;
    }
    
    public void setPhotos_big(List<String> paramList)
    {
      this.photos_big = paramList;
    }
    
    public void setPhotos_min(List<String> paramList)
    {
      this.photos_min = paramList;
    }
    
    public void setPrice(String paramString)
    {
      this.price = paramString;
    }
    
    public void setPrice_desc(String paramString)
    {
      this.price_desc = paramString;
    }
    
    public void setPrice_unit(String paramString)
    {
      this.price_unit = paramString;
    }
    
    public void setQq_share(QqShareBean paramQqShareBean)
    {
      this.qq_share = paramQqShareBean;
    }
    
    public void setQzone_share(QzoneShareBean paramQzoneShareBean)
    {
      this.qzone_share = paramQzoneShareBean;
    }
    
    public void setResblock(ResblockBean paramResblockBean)
    {
      this.resblock = paramResblockBean;
    }
    
    public void setReserve_message(String paramString)
    {
      this.reserve_message = paramString;
    }
    
    public void setSign_date(String paramString)
    {
      this.sign_date = paramString;
    }
    
    public void setSpace(List<SpaceBean> paramList)
    {
      this.space = paramList;
    }
    
    public void setStatus(String paramString)
    {
      this.status = paramString;
    }
    
    public void setSubway_primary(String paramString)
    {
      this.subway_primary = paramString;
    }
    
    public void setTags(List<TagsBean> paramList)
    {
      this.tags = paramList;
    }
    
    public void setWechat_share(WechatShareBean paramWechatShareBean)
    {
      this.wechat_share = paramWechatShareBean;
    }
    
    public void setWeibo_share(WeiboShareBean paramWeiboShareBean)
    {
      this.weibo_share = paramWeiboShareBean;
    }
    
    public static class EnsuresBean
    {
      private List<DetailedBean> detailed;
      private String title;
      
      public List<DetailedBean> getDetailed()
      {
        return this.detailed;
      }
      
      public String getTitle()
      {
        return this.title;
      }
      
      public void setDetailed(List<DetailedBean> paramList)
      {
        this.detailed = paramList;
      }
      
      public void setTitle(String paramString)
      {
        this.title = paramString;
      }
      
      public static class DetailedBean
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
    
    public static class MomentsShareBean
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
    
    public static class QqShareBean
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
    
    public static class QzoneShareBean
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
    
    public static class ResblockBean
    {
      private String around;
      private String build_type;
      private String build_year;
      private String greening_ratio;
      private String heating_type;
      private String id;
      private String lat;
      private String lng;
      private String name;
      private List<String> subway;
      private String traffic;
      
      public String getAround()
      {
        return this.around;
      }
      
      public String getBuild_type()
      {
        return this.build_type;
      }
      
      public String getBuild_year()
      {
        return this.build_year;
      }
      
      public String getGreening_ratio()
      {
        return this.greening_ratio;
      }
      
      public String getHeating_type()
      {
        return this.heating_type;
      }
      
      public String getId()
      {
        return this.id;
      }
      
      public String getLat()
      {
        return this.lat;
      }
      
      public String getLng()
      {
        return this.lng;
      }
      
      public String getName()
      {
        return this.name;
      }
      
      public List<String> getSubway()
      {
        return this.subway;
      }
      
      public String getTraffic()
      {
        return this.traffic;
      }
      
      public void setAround(String paramString)
      {
        this.around = paramString;
      }
      
      public void setBuild_type(String paramString)
      {
        this.build_type = paramString;
      }
      
      public void setBuild_year(String paramString)
      {
        this.build_year = paramString;
      }
      
      public void setGreening_ratio(String paramString)
      {
        this.greening_ratio = paramString;
      }
      
      public void setHeating_type(String paramString)
      {
        this.heating_type = paramString;
      }
      
      public void setId(String paramString)
      {
        this.id = paramString;
      }
      
      public void setLat(String paramString)
      {
        this.lat = paramString;
      }
      
      public void setLng(String paramString)
      {
        this.lng = paramString;
      }
      
      public void setName(String paramString)
      {
        this.name = paramString;
      }
      
      public void setSubway(List<String> paramList)
      {
        this.subway = paramList;
      }
      
      public void setTraffic(String paramString)
      {
        this.traffic = paramString;
      }
    }
    
    public static class SpaceBean
    {
      private String area;
      private List<ConfigBean> config;
      private String config_desc;
      private String face;
      private String name;
      private List<String> photos_big;
      private List<String> photos_min;
      
      public String getArea()
      {
        return this.area;
      }
      
      public List<ConfigBean> getConfig()
      {
        return this.config;
      }
      
      public String getConfig_desc()
      {
        return this.config_desc;
      }
      
      public String getFace()
      {
        return this.face;
      }
      
      public String getName()
      {
        return this.name;
      }
      
      public List<String> getPhotos_big()
      {
        return this.photos_big;
      }
      
      public List<String> getPhotos_min()
      {
        return this.photos_min;
      }
      
      public void setArea(String paramString)
      {
        this.area = paramString;
      }
      
      public void setConfig(List<ConfigBean> paramList)
      {
        this.config = paramList;
      }
      
      public void setConfig_desc(String paramString)
      {
        this.config_desc = paramString;
      }
      
      public void setFace(String paramString)
      {
        this.face = paramString;
      }
      
      public void setName(String paramString)
      {
        this.name = paramString;
      }
      
      public void setPhotos_big(List<String> paramList)
      {
        this.photos_big = paramList;
      }
      
      public void setPhotos_min(List<String> paramList)
      {
        this.photos_min = paramList;
      }
      
      public static class ConfigBean
      {
        private String icon;
        private String name;
        private int num;
        
        public String getIcon()
        {
          return this.icon;
        }
        
        public String getName()
        {
          return this.name;
        }
        
        public int getNum()
        {
          return this.num;
        }
        
        public void setIcon(String paramString)
        {
          this.icon = paramString;
        }
        
        public void setName(String paramString)
        {
          this.name = paramString;
        }
        
        public void setNum(int paramInt)
        {
          this.num = paramInt;
        }
      }
    }
    
    public static class TagsBean
    {
      private String title;
      
      public String getTitle()
      {
        return this.title;
      }
      
      public void setTitle(String paramString)
      {
        this.title = paramString;
      }
    }
    
    public static class WechatShareBean
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
    
    public static class WeiboShareBean
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
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/presenter/model/EntireHouseDetail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */