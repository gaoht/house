package com.ziroom.ziroomcustomer.model;

import com.ziroom.ziroomcustomer.findhouse.presenter.model.Resblock;
import java.io.Serializable;
import java.util.List;

public class HouseDetail
  implements Serializable
{
  public static final int from_zz = 1;
  private List<BedRooms> bed_rooms;
  private String bizcircle_code;
  private String bizcircle_name;
  private String build_type;
  private String build_year;
  private String cengshu;
  private String cityCode;
  private String dispose_parlor_amount;
  private String double_clean;
  private String floor_total;
  private String free_clear;
  private String free_fixed;
  private String free_repair;
  private String free_wifi;
  private int from;
  private String fukuan_url;
  private String greening_ratio;
  private String heating_type;
  private String house_area;
  private String house_code;
  private String house_company;
  private List<HouseDetailConfig> house_config;
  private String house_evaluation_circum;
  private String house_evaluation_traffic;
  private String house_id;
  private String house_index;
  private String house_lat;
  private List<HouseDetailLife> house_life;
  private String house_lng;
  private String house_name;
  private String house_number;
  private List<String> house_photos;
  private List<String> house_photos_big;
  private List<String> house_photos_small;
  private String house_price;
  private String house_price_desc;
  private List<HouseRoommate> house_roommate;
  private String house_status;
  private List<String> house_tags;
  private String house_toward;
  private String house_type;
  private String huxing;
  private String huxing_photos;
  private int is_duanzu;
  private String is_newsign;
  private String is_reserve;
  private String latitude_and_longitude;
  private ShareMm moments_share;
  private String notice_word;
  private String out_house_product;
  private List<String> public_photos;
  private PublicPhotosBigAttiBean public_photos_big_atti;
  private List<String> puplic_photos_big;
  private List<String> puplic_photos_small;
  private ShareQq qq_share;
  private ShareQz qzone_share;
  private String resblock_id;
  private String resblock_name;
  private String reserve_message;
  private String room_code;
  private String room_config;
  private String room_evaluation;
  private String room_evaluation_price;
  private ServiceBean service;
  private int sign_date;
  private String steward_code;
  private String steward_img;
  private String steward_name;
  private String steward_phone;
  private String style_code;
  private String style_tag;
  private String subletReserveCode;
  private String subway_line_code;
  private String subway_station_info;
  private String subway_station_name;
  private String supply_heat;
  private SubletBean turn;
  private String turn_link;
  private String walktime;
  private String web_url;
  private ShareWc wechat_share;
  private ShareWb weibo_share;
  
  public HouseDetail() {}
  
  public HouseDetail(String paramString1, String paramString2, String paramString3)
  {
    this.house_type = paramString1;
    this.house_code = paramString2;
    this.house_id = paramString3;
  }
  
  public HouseDetail(String paramString1, List<String> paramList, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5)
  {
    this.house_type = paramString1;
    this.house_photos_small = paramList;
    this.house_price = paramString2;
    this.house_name = paramString3;
    this.is_duanzu = paramInt;
    this.house_code = paramString4;
    this.house_id = paramString5;
  }
  
  public List<BedRooms> getBed_rooms()
  {
    return this.bed_rooms;
  }
  
  public String getBizcircle_code()
  {
    return this.bizcircle_code;
  }
  
  public String getBizcircle_name()
  {
    return this.bizcircle_name;
  }
  
  public String getBuild_type()
  {
    return this.build_type;
  }
  
  public String getBuild_year()
  {
    return this.build_year;
  }
  
  public String getCengshu()
  {
    return this.cengshu;
  }
  
  public String getCityCode()
  {
    return this.cityCode;
  }
  
  public String getDispose_parlor_amount()
  {
    return this.dispose_parlor_amount;
  }
  
  public String getDouble_clean()
  {
    return this.double_clean;
  }
  
  public String getFloor_total()
  {
    return this.floor_total;
  }
  
  public String getFree_clear()
  {
    return this.free_clear;
  }
  
  public String getFree_fixed()
  {
    return this.free_fixed;
  }
  
  public String getFree_repair()
  {
    return this.free_repair;
  }
  
  public String getFree_wifi()
  {
    return this.free_wifi;
  }
  
  public int getFrom()
  {
    return this.from;
  }
  
  public String getFukuan_url()
  {
    return this.fukuan_url;
  }
  
  public String getGreening_ratio()
  {
    return this.greening_ratio;
  }
  
  public String getHeating_type()
  {
    return this.heating_type;
  }
  
  public String getHouse_area()
  {
    return this.house_area;
  }
  
  public String getHouse_code()
  {
    return this.house_code;
  }
  
  public String getHouse_company()
  {
    return this.house_company;
  }
  
  public List<HouseDetailConfig> getHouse_config()
  {
    return this.house_config;
  }
  
  public String getHouse_evaluation_circum()
  {
    return this.house_evaluation_circum;
  }
  
  public String getHouse_evaluation_traffic()
  {
    return this.house_evaluation_traffic;
  }
  
  public String getHouse_id()
  {
    return this.house_id;
  }
  
  public String getHouse_index()
  {
    return this.house_index;
  }
  
  public String getHouse_lat()
  {
    return this.house_lat;
  }
  
  public List<HouseDetailLife> getHouse_life()
  {
    return this.house_life;
  }
  
  public String getHouse_lng()
  {
    return this.house_lng;
  }
  
  public String getHouse_name()
  {
    return this.house_name;
  }
  
  public String getHouse_number()
  {
    return this.house_number;
  }
  
  public List<String> getHouse_photos()
  {
    return this.house_photos;
  }
  
  public List<String> getHouse_photos_big()
  {
    return this.house_photos_big;
  }
  
  public List<String> getHouse_photos_small()
  {
    return this.house_photos_small;
  }
  
  public String getHouse_price()
  {
    return this.house_price;
  }
  
  public String getHouse_price_desc()
  {
    return this.house_price_desc;
  }
  
  public List<HouseRoommate> getHouse_roommate()
  {
    return this.house_roommate;
  }
  
  public String getHouse_status()
  {
    return this.house_status;
  }
  
  public List<String> getHouse_tags()
  {
    return this.house_tags;
  }
  
  public String getHouse_toward()
  {
    return this.house_toward;
  }
  
  public String getHouse_type()
  {
    return this.house_type;
  }
  
  public String getHuxing()
  {
    return this.huxing;
  }
  
  public String getHuxing_photos()
  {
    return this.huxing_photos;
  }
  
  public int getIs_duanzu()
  {
    return this.is_duanzu;
  }
  
  public String getIs_newsign()
  {
    return this.is_newsign;
  }
  
  public String getIs_reserve()
  {
    return this.is_reserve;
  }
  
  public String getLatitude_and_longitude()
  {
    return this.latitude_and_longitude;
  }
  
  public ShareMm getMoments_share()
  {
    return this.moments_share;
  }
  
  public String getNotice_word()
  {
    return this.notice_word;
  }
  
  public String getOut_house_product()
  {
    return this.out_house_product;
  }
  
  public List<String> getPublic_photos()
  {
    return this.public_photos;
  }
  
  public PublicPhotosBigAttiBean getPublic_photos_big_atti()
  {
    return this.public_photos_big_atti;
  }
  
  public List<String> getPuplic_photos_big()
  {
    return this.puplic_photos_big;
  }
  
  public List<String> getPuplic_photos_small()
  {
    return this.puplic_photos_small;
  }
  
  public ShareQq getQq_share()
  {
    return this.qq_share;
  }
  
  public ShareQz getQzone_share()
  {
    return this.qzone_share;
  }
  
  public Resblock getResblock()
  {
    Resblock localResblock = new Resblock();
    int j;
    if ((this.house_life != null) && (this.house_life.size() > 0)) {
      j = 0;
    }
    int i;
    for (int k = 0;; k = i)
    {
      HouseDetailLife localHouseDetailLife;
      if (j < this.house_life.size())
      {
        localHouseDetailLife = (HouseDetailLife)this.house_life.get(j);
        if ((localHouseDetailLife == null) || (!"周边".equals(localHouseDetailLife.getTitle()))) {
          break label146;
        }
        i = k + 1;
        localResblock.setAround(localHouseDetailLife.getInfo());
      }
      while (i >= 3)
      {
        localResblock.setBuild_year(getBuild_year());
        localResblock.setBuild_type(getBuild_type());
        localResblock.setHeating_type(getHeating_type());
        localResblock.setGreening_ratio(getGreening_ratio());
        localResblock.setSubway_station_info(getSubway_station_info());
        return localResblock;
        label146:
        if ((localHouseDetailLife != null) && ("交通".equals(localHouseDetailLife.getTitle())))
        {
          i = k + 1;
          localResblock.setTraffic(localHouseDetailLife.getInfo());
        }
        else
        {
          i = k;
          if (localHouseDetailLife != null)
          {
            i = k;
            if ("房源点评".equals(localHouseDetailLife.getTitle()))
            {
              i = k + 1;
              localResblock.setComment(localHouseDetailLife.getInfo());
            }
          }
        }
      }
      j += 1;
    }
  }
  
  public String getResblock_id()
  {
    return this.resblock_id;
  }
  
  public String getResblock_name()
  {
    return this.resblock_name;
  }
  
  public String getReserve_message()
  {
    return this.reserve_message;
  }
  
  public String getRoom_code()
  {
    return this.room_code;
  }
  
  public String getRoom_config()
  {
    return this.room_config;
  }
  
  public String getRoom_evaluation()
  {
    return this.room_evaluation;
  }
  
  public String getRoom_evaluation_price()
  {
    return this.room_evaluation_price;
  }
  
  public ServiceBean getService()
  {
    return this.service;
  }
  
  public int getSign_date()
  {
    return this.sign_date;
  }
  
  public String getSteward_code()
  {
    return this.steward_code;
  }
  
  public String getSteward_img()
  {
    return this.steward_img;
  }
  
  public String getSteward_name()
  {
    return this.steward_name;
  }
  
  public String getSteward_phone()
  {
    return this.steward_phone;
  }
  
  public String getStyle_code()
  {
    return this.style_code;
  }
  
  public String getStyle_tag()
  {
    return this.style_tag;
  }
  
  public String getSubletReserveCode()
  {
    return this.subletReserveCode;
  }
  
  public String getSubway_line_code()
  {
    return this.subway_line_code;
  }
  
  public String getSubway_station_info()
  {
    return this.subway_station_info;
  }
  
  public String getSubway_station_name()
  {
    return this.subway_station_name;
  }
  
  public String getSupply_heat()
  {
    return this.supply_heat;
  }
  
  public SubletBean getTurn()
  {
    return this.turn;
  }
  
  public String getTurn_link()
  {
    return this.turn_link;
  }
  
  public String getWalktime()
  {
    return this.walktime;
  }
  
  public String getWeb_url()
  {
    return this.web_url;
  }
  
  public ShareWc getWechat_share()
  {
    return this.wechat_share;
  }
  
  public ShareWb getWeibo_share()
  {
    return this.weibo_share;
  }
  
  public void setBed_rooms(List<BedRooms> paramList)
  {
    this.bed_rooms = paramList;
  }
  
  public void setBizcircle_code(String paramString)
  {
    this.bizcircle_code = paramString;
  }
  
  public void setBizcircle_name(String paramString)
  {
    this.bizcircle_name = paramString;
  }
  
  public void setBuild_type(String paramString)
  {
    this.build_type = paramString;
  }
  
  public void setBuild_year(String paramString)
  {
    this.build_year = paramString;
  }
  
  public void setCengshu(String paramString)
  {
    this.cengshu = paramString;
  }
  
  public void setCityCode(String paramString)
  {
    this.cityCode = paramString;
  }
  
  public void setDispose_parlor_amount(String paramString)
  {
    this.dispose_parlor_amount = paramString;
  }
  
  public void setDouble_clean(String paramString)
  {
    this.double_clean = paramString;
  }
  
  public void setFloor_total(String paramString)
  {
    this.floor_total = paramString;
  }
  
  public void setFree_clear(String paramString)
  {
    this.free_clear = paramString;
  }
  
  public void setFree_fixed(String paramString)
  {
    this.free_fixed = paramString;
  }
  
  public void setFree_repair(String paramString)
  {
    this.free_repair = paramString;
  }
  
  public void setFree_wifi(String paramString)
  {
    this.free_wifi = paramString;
  }
  
  public void setFrom(int paramInt)
  {
    this.from = paramInt;
  }
  
  public void setFukuan_url(String paramString)
  {
    this.fukuan_url = paramString;
  }
  
  public void setGreening_ratio(String paramString)
  {
    this.greening_ratio = paramString;
  }
  
  public void setHeating_type(String paramString)
  {
    this.heating_type = paramString;
  }
  
  public void setHouse_area(String paramString)
  {
    this.house_area = paramString;
  }
  
  public void setHouse_code(String paramString)
  {
    this.house_code = paramString;
  }
  
  public void setHouse_company(String paramString)
  {
    this.house_company = paramString;
  }
  
  public void setHouse_config(List<HouseDetailConfig> paramList)
  {
    this.house_config = paramList;
  }
  
  public void setHouse_evaluation_circum(String paramString)
  {
    this.house_evaluation_circum = paramString;
  }
  
  public void setHouse_evaluation_traffic(String paramString)
  {
    this.house_evaluation_traffic = paramString;
  }
  
  public void setHouse_id(String paramString)
  {
    this.house_id = paramString;
  }
  
  public void setHouse_index(String paramString)
  {
    this.house_index = paramString;
  }
  
  public void setHouse_lat(String paramString)
  {
    this.house_lat = paramString;
  }
  
  public void setHouse_life(List<HouseDetailLife> paramList)
  {
    this.house_life = paramList;
  }
  
  public void setHouse_lng(String paramString)
  {
    this.house_lng = paramString;
  }
  
  public void setHouse_name(String paramString)
  {
    this.house_name = paramString;
  }
  
  public void setHouse_number(String paramString)
  {
    this.house_number = paramString;
  }
  
  public void setHouse_photos(List<String> paramList)
  {
    this.house_photos = paramList;
  }
  
  public void setHouse_photos_big(List<String> paramList)
  {
    this.house_photos_big = paramList;
  }
  
  public void setHouse_photos_small(List<String> paramList)
  {
    this.house_photos_small = paramList;
  }
  
  public void setHouse_price(String paramString)
  {
    this.house_price = paramString;
  }
  
  public void setHouse_price_desc(String paramString)
  {
    this.house_price_desc = paramString;
  }
  
  public void setHouse_roommate(List<HouseRoommate> paramList)
  {
    this.house_roommate = paramList;
  }
  
  public void setHouse_status(String paramString)
  {
    this.house_status = paramString;
  }
  
  public void setHouse_tags(List<String> paramList)
  {
    this.house_tags = paramList;
  }
  
  public void setHouse_toward(String paramString)
  {
    this.house_toward = paramString;
  }
  
  public void setHouse_type(String paramString)
  {
    this.house_type = paramString;
  }
  
  public void setHuxing(String paramString)
  {
    this.huxing = paramString;
  }
  
  public void setHuxing_photos(String paramString)
  {
    this.huxing_photos = paramString;
  }
  
  public void setIs_duanzu(int paramInt)
  {
    this.is_duanzu = paramInt;
  }
  
  public void setIs_newsign(String paramString)
  {
    this.is_newsign = paramString;
  }
  
  public void setIs_reserve(String paramString)
  {
    this.is_reserve = paramString;
  }
  
  public void setLatitude_and_longitude(String paramString)
  {
    this.latitude_and_longitude = paramString;
  }
  
  public void setMoments_share(ShareMm paramShareMm)
  {
    this.moments_share = paramShareMm;
  }
  
  public void setNotice_word(String paramString)
  {
    this.notice_word = paramString;
  }
  
  public void setOut_house_product(String paramString)
  {
    this.out_house_product = paramString;
  }
  
  public void setPublic_photos(List<String> paramList)
  {
    this.public_photos = paramList;
  }
  
  public void setPublic_photos_big_atti(PublicPhotosBigAttiBean paramPublicPhotosBigAttiBean)
  {
    this.public_photos_big_atti = paramPublicPhotosBigAttiBean;
  }
  
  public void setPuplic_photos_big(List<String> paramList)
  {
    this.puplic_photos_big = paramList;
  }
  
  public void setPuplic_photos_small(List<String> paramList)
  {
    this.puplic_photos_small = paramList;
  }
  
  public void setQq_share(ShareQq paramShareQq)
  {
    this.qq_share = paramShareQq;
  }
  
  public void setQzone_share(ShareQz paramShareQz)
  {
    this.qzone_share = paramShareQz;
  }
  
  public void setResblock_id(String paramString)
  {
    this.resblock_id = paramString;
  }
  
  public void setResblock_name(String paramString)
  {
    this.resblock_name = paramString;
  }
  
  public void setReserve_message(String paramString)
  {
    this.reserve_message = paramString;
  }
  
  public void setRoom_code(String paramString)
  {
    this.room_code = paramString;
  }
  
  public void setRoom_config(String paramString)
  {
    this.room_config = paramString;
  }
  
  public void setRoom_evaluation(String paramString)
  {
    this.room_evaluation = paramString;
  }
  
  public void setRoom_evaluation_price(String paramString)
  {
    this.room_evaluation_price = paramString;
  }
  
  public void setService(ServiceBean paramServiceBean)
  {
    this.service = paramServiceBean;
  }
  
  public void setSign_date(int paramInt)
  {
    this.sign_date = paramInt;
  }
  
  public void setSteward_code(String paramString)
  {
    this.steward_code = paramString;
  }
  
  public void setSteward_img(String paramString)
  {
    this.steward_img = paramString;
  }
  
  public void setSteward_name(String paramString)
  {
    this.steward_name = paramString;
  }
  
  public void setSteward_phone(String paramString)
  {
    this.steward_phone = paramString;
  }
  
  public void setStyle_code(String paramString)
  {
    this.style_code = paramString;
  }
  
  public void setStyle_tag(String paramString)
  {
    this.style_tag = paramString;
  }
  
  public void setSubletReserveCode(String paramString)
  {
    this.subletReserveCode = paramString;
  }
  
  public void setSubway_line_code(String paramString)
  {
    this.subway_line_code = paramString;
  }
  
  public void setSubway_station_info(String paramString)
  {
    this.subway_station_info = paramString;
  }
  
  public void setSubway_station_name(String paramString)
  {
    this.subway_station_name = paramString;
  }
  
  public void setSupply_heat(String paramString)
  {
    this.supply_heat = paramString;
  }
  
  public void setTurn(SubletBean paramSubletBean)
  {
    this.turn = paramSubletBean;
  }
  
  public void setTurn_link(String paramString)
  {
    this.turn_link = paramString;
  }
  
  public void setWalktime(String paramString)
  {
    this.walktime = paramString;
  }
  
  public void setWeb_url(String paramString)
  {
    this.web_url = paramString;
  }
  
  public void setWechat_share(ShareWc paramShareWc)
  {
    this.wechat_share = paramShareWc;
  }
  
  public void setWeibo_share(ShareWb paramShareWb)
  {
    this.weibo_share = paramShareWb;
  }
  
  public static class PublicPhotosBigAttiBean
    implements Serializable
  {
    private List<String> balcony;
    private List<String> kitchen;
    private List<String> livingroom;
    private List<String> washroom;
    
    public List<String> getBalcony()
    {
      return this.balcony;
    }
    
    public List<String> getKitchen()
    {
      return this.kitchen;
    }
    
    public List<String> getLivingroom()
    {
      return this.livingroom;
    }
    
    public List<String> getWashroom()
    {
      return this.washroom;
    }
    
    public void setBalcony(List<String> paramList)
    {
      this.balcony = paramList;
    }
    
    public void setKitchen(List<String> paramList)
    {
      this.kitchen = paramList;
    }
    
    public void setLivingroom(List<String> paramList)
    {
      this.livingroom = paramList;
    }
    
    public void setWashroom(List<String> paramList)
    {
      this.washroom = paramList;
    }
  }
  
  public class ServiceBean
    implements Serializable
  {
    private List<ServiceDetailBean> detail;
    private String title;
    
    public ServiceBean() {}
    
    public List<ServiceDetailBean> getDetail()
    {
      return this.detail;
    }
    
    public String getTitle()
    {
      return this.title;
    }
    
    public void setDetail(List<ServiceDetailBean> paramList)
    {
      this.detail = paramList;
    }
    
    public void setTitle(String paramString)
    {
      this.title = paramString;
    }
    
    public class ServiceDetailBean
      implements Serializable
    {
      private List<ServiceItemBean> item;
      private String title;
      private String type;
      private String url;
      
      public ServiceDetailBean() {}
      
      public List<ServiceItemBean> getItem()
      {
        return this.item;
      }
      
      public String getTitle()
      {
        return this.title;
      }
      
      public String getType()
      {
        return this.type;
      }
      
      public String getUrl()
      {
        return this.url;
      }
      
      public void setItem(List<ServiceItemBean> paramList)
      {
        this.item = paramList;
      }
      
      public void setTitle(String paramString)
      {
        this.title = paramString;
      }
      
      public void setType(String paramString)
      {
        this.type = paramString;
      }
      
      public void setUrl(String paramString)
      {
        this.url = paramString;
      }
      
      public class ServiceItemBean
        implements Serializable
      {
        private String desc;
        private String url;
        
        public ServiceItemBean() {}
        
        public String getDesc()
        {
          return this.desc;
        }
        
        public String getUrl()
        {
          return this.url;
        }
        
        public void setDesc(String paramString)
        {
          this.desc = paramString;
        }
        
        public void setUrl(String paramString)
        {
          this.url = paramString;
        }
      }
    }
  }
  
  public class ShareMm
    implements Serializable
  {
    private String active;
    private String content;
    private String title;
    private String url;
    
    public ShareMm() {}
    
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
  
  public class ShareQq
    implements Serializable
  {
    private String active;
    private String content;
    private String title;
    private String url;
    
    public ShareQq() {}
    
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
  
  public class ShareQz
    implements Serializable
  {
    private String active;
    private String content;
    private String title;
    private String url;
    
    public ShareQz() {}
    
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
  
  public class ShareWb
    implements Serializable
  {
    private String active;
    private String content;
    private String title;
    private String url;
    
    public ShareWb() {}
    
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
  
  public class ShareWc
    implements Serializable
  {
    private String active;
    private String content;
    private String title;
    private String url;
    
    public ShareWc() {}
    
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
  
  public static class SubletBean
    implements Serializable
  {
    private String checkin_date;
    private String contract_code;
    private String customer_name;
    private String customer_phone;
    private String describe;
    private String estimate_price;
    private String estimate_price_company;
    private String estimate_price_desc;
    private String signing;
    private String signing_max_date;
    private String signing_text;
    private String status;
    private String uid;
    
    public String getCheckin_date()
    {
      return this.checkin_date;
    }
    
    public String getContract_code()
    {
      return this.contract_code;
    }
    
    public String getCustomer_name()
    {
      return this.customer_name;
    }
    
    public String getCustomer_phone()
    {
      return this.customer_phone;
    }
    
    public String getDescribe()
    {
      return this.describe;
    }
    
    public String getEstimate_price()
    {
      return this.estimate_price;
    }
    
    public String getEstimate_price_company()
    {
      return this.estimate_price_company;
    }
    
    public String getEstimate_price_desc()
    {
      return this.estimate_price_desc;
    }
    
    public String getSigning()
    {
      return this.signing;
    }
    
    public String getSigning_max_date()
    {
      return this.signing_max_date;
    }
    
    public String getSigning_text()
    {
      return this.signing_text;
    }
    
    public String getStatus()
    {
      return this.status;
    }
    
    public String getUid()
    {
      return this.uid;
    }
    
    public void setCheckin_date(String paramString)
    {
      this.checkin_date = paramString;
    }
    
    public void setContract_code(String paramString)
    {
      this.contract_code = paramString;
    }
    
    public void setCustomer_name(String paramString)
    {
      this.customer_name = paramString;
    }
    
    public void setCustomer_phone(String paramString)
    {
      this.customer_phone = paramString;
    }
    
    public void setDescribe(String paramString)
    {
      this.describe = paramString;
    }
    
    public void setEstimate_price(String paramString)
    {
      this.estimate_price = paramString;
    }
    
    public void setEstimate_price_company(String paramString)
    {
      this.estimate_price_company = paramString;
    }
    
    public void setEstimate_price_desc(String paramString)
    {
      this.estimate_price_desc = paramString;
    }
    
    public void setSigning(String paramString)
    {
      this.signing = paramString;
    }
    
    public void setSigning_max_date(String paramString)
    {
      this.signing_max_date = paramString;
    }
    
    public void setSigning_text(String paramString)
    {
      this.signing_text = paramString;
    }
    
    public void setStatus(String paramString)
    {
      this.status = paramString;
    }
    
    public void setUid(String paramString)
    {
      this.uid = paramString;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/HouseDetail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */