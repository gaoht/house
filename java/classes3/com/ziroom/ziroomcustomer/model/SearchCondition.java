package com.ziroom.ziroomcustomer.model;

import com.ziroom.ziroomcustomer.findhouse.model.SelectBean;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;

public class SearchCondition
  implements Serializable
{
  private String area = "";
  private List<SelectBean> areaBeanList;
  private String areaStr = "不限";
  private String areaText = "";
  private String around = "";
  private List<SelectBean> aroundBeanList;
  private SelectBean bedroom = new SelectBean();
  private SelectBean bizcircle = new SelectBean();
  private String bizcircle_code = "";
  private String bizcircle_name = "";
  private int can_sign;
  private String checkin_date;
  private String childVersionIndex = "";
  private String city_id;
  private String clat = "";
  private String clng = "";
  private String commute_name = "";
  private String configs = "";
  private String district = "";
  private String districtName = "";
  private String face = "";
  private List<SelectBean> faceBeanList;
  private String feature = "";
  private List<SelectBean> featureBeanList;
  private List<SelectBean> hFaceBeanList;
  private String heating = "";
  private String heatingStr = "不限";
  private String hface = "";
  private String houseType = "1";
  private String houseTypeStr = "不限";
  private int house_tags_0;
  private int house_tags_1;
  private int house_tags_2;
  private int house_tags_3;
  private int house_tags_4;
  private int house_tags_6;
  private String house_type = "合租";
  private String huxing = "";
  private String is_commute = "2";
  private int is_reserve;
  private String keywords = "";
  private List<SelectBean> leaseTypeBeanList;
  private String leasetype = "";
  private String live = "";
  private String longitude_and_latitude = "";
  private int mAreaIndex = -1;
  private int mHeatingIndex = -1;
  private int mHouseTypeIndex = -1;
  private int mMoneyIndex = -1;
  private int maxPrice = 0;
  private String max_area = "";
  private String max_lat = "";
  private String max_lng = "";
  private String max_rentfee = "";
  private int minPrice = 0;
  private String min_area = "";
  private String min_lat = "";
  private String min_lng = "";
  private String min_rentfee = "";
  private String moneyStr = "不限";
  private int more_count = 0;
  private int page = 1;
  private SelectBean price = new SelectBean();
  private List<SelectBean> rFaceBeanList;
  private String rapid;
  private List<SelectBean> rapidBeanList;
  private String resblock_id = "";
  private String rface = "";
  private String size = "10";
  private String sort = "";
  private int sort_type = -1;
  private String style = "";
  private List<SelectBean> styleBeanList;
  private String style_code = "";
  private String style_codes = "";
  private String subWayStr = "";
  private String subway = "";
  private String subwayName = "";
  private String subway_line = "";
  private String subway_link_name;
  private String subway_station_name = "";
  private String suggestion_type;
  private String suggestion_value;
  private String tags = "";
  private List<SelectBean> tagsBeanList;
  private String tran_sport = "";
  private String type = "";
  private String typeName = "";
  private HashSet<Integer> typeSet = new HashSet();
  private String version = "";
  private List<SelectBean> versionBeanList;
  private String version_id = "";
  private String work_time = "";
  
  public String getArea()
  {
    return this.area;
  }
  
  public List<SelectBean> getAreaBeanList()
  {
    return this.areaBeanList;
  }
  
  public String getAreaStr()
  {
    return this.areaStr;
  }
  
  public String getAreaText()
  {
    return this.areaText;
  }
  
  public String getAround()
  {
    return this.around;
  }
  
  public List<SelectBean> getAroundBeanList()
  {
    return this.aroundBeanList;
  }
  
  public SelectBean getBedroom()
  {
    return this.bedroom;
  }
  
  public SelectBean getBizcircle()
  {
    return this.bizcircle;
  }
  
  public String getBizcircle_code()
  {
    return this.bizcircle_code;
  }
  
  public String getBizcircle_name()
  {
    return this.bizcircle_name;
  }
  
  public int getCan_sign()
  {
    return this.can_sign;
  }
  
  public String getCheckin_date()
  {
    return this.checkin_date;
  }
  
  public String getChildVersionIndex()
  {
    return this.childVersionIndex;
  }
  
  public String getCity_id()
  {
    return this.city_id;
  }
  
  public String getClat()
  {
    return this.clat;
  }
  
  public String getClng()
  {
    return this.clng;
  }
  
  public String getCommute_name()
  {
    return this.commute_name;
  }
  
  public String getConfigs()
  {
    return this.configs;
  }
  
  public String getDistrict()
  {
    return this.district;
  }
  
  public String getDistrictName()
  {
    return this.districtName;
  }
  
  public String getFace()
  {
    return this.face;
  }
  
  public List<SelectBean> getFaceBeanList()
  {
    return this.faceBeanList;
  }
  
  public String getFeature()
  {
    return this.feature;
  }
  
  public List<SelectBean> getFeatureBeanList()
  {
    return this.featureBeanList;
  }
  
  public String getHeating()
  {
    return this.heating;
  }
  
  public String getHeatingStr()
  {
    return this.heatingStr;
  }
  
  public String getHface()
  {
    return this.hface;
  }
  
  public String getHouseType()
  {
    return this.houseType;
  }
  
  public String getHouseTypeStr()
  {
    return this.houseTypeStr;
  }
  
  public int getHouse_tags_0()
  {
    return this.house_tags_0;
  }
  
  public int getHouse_tags_1()
  {
    return this.house_tags_1;
  }
  
  public int getHouse_tags_2()
  {
    return this.house_tags_2;
  }
  
  public int getHouse_tags_3()
  {
    return this.house_tags_3;
  }
  
  public int getHouse_tags_4()
  {
    return this.house_tags_4;
  }
  
  public int getHouse_tags_6()
  {
    return this.house_tags_6;
  }
  
  public String getHouse_type()
  {
    return this.house_type;
  }
  
  public String getHuxing()
  {
    return this.huxing;
  }
  
  public String getIs_commute()
  {
    return this.is_commute;
  }
  
  public int getIs_reserve()
  {
    return this.is_reserve;
  }
  
  public String getKeywords()
  {
    return this.keywords;
  }
  
  public List<SelectBean> getLeaseTypeBeanList()
  {
    return this.leaseTypeBeanList;
  }
  
  public String getLeasetype()
  {
    return this.leasetype;
  }
  
  public String getLive()
  {
    return this.live;
  }
  
  public String getLongitude_and_latitude()
  {
    return this.longitude_and_latitude;
  }
  
  public int getMaxPrice()
  {
    return this.maxPrice;
  }
  
  public String getMax_area()
  {
    return this.max_area;
  }
  
  public String getMax_lat()
  {
    return this.max_lat;
  }
  
  public String getMax_lng()
  {
    return this.max_lng;
  }
  
  public String getMax_rentfee()
  {
    return this.max_rentfee;
  }
  
  public int getMinPrice()
  {
    return this.minPrice;
  }
  
  public String getMin_area()
  {
    return this.min_area;
  }
  
  public String getMin_lat()
  {
    return this.min_lat;
  }
  
  public String getMin_lng()
  {
    return this.min_lng;
  }
  
  public String getMin_rentfee()
  {
    return this.min_rentfee;
  }
  
  public String getMoneyStr()
  {
    return this.moneyStr;
  }
  
  public int getMore_count()
  {
    return this.more_count;
  }
  
  public int getPage()
  {
    return this.page;
  }
  
  public SelectBean getPrice()
  {
    return this.price;
  }
  
  public String getRapid()
  {
    return this.rapid;
  }
  
  public List<SelectBean> getRapidBeanList()
  {
    return this.rapidBeanList;
  }
  
  public String getResblock_id()
  {
    return this.resblock_id;
  }
  
  public String getRface()
  {
    return this.rface;
  }
  
  public String getSize()
  {
    return this.size;
  }
  
  public String getSort()
  {
    return this.sort;
  }
  
  public int getSort_type()
  {
    return this.sort_type;
  }
  
  public String getStyle()
  {
    return this.style;
  }
  
  public List<SelectBean> getStyleBeanList()
  {
    return this.styleBeanList;
  }
  
  public String getStyle_code()
  {
    return this.style_code;
  }
  
  public String getStyle_codes()
  {
    return this.style_codes;
  }
  
  public String getSubWayStr()
  {
    return this.subWayStr;
  }
  
  public String getSubway()
  {
    return this.subway;
  }
  
  public String getSubwayName()
  {
    return this.subwayName;
  }
  
  public String getSubway_line()
  {
    return this.subway_line;
  }
  
  public String getSubway_link_name()
  {
    return this.subway_link_name;
  }
  
  public String getSubway_station_name()
  {
    return this.subway_station_name;
  }
  
  public String getSuggestion_type()
  {
    return this.suggestion_type;
  }
  
  public String getSuggestion_value()
  {
    return this.suggestion_value;
  }
  
  public String getTags()
  {
    return this.tags;
  }
  
  public List<SelectBean> getTagsBeanList()
  {
    return this.tagsBeanList;
  }
  
  public String getTran_sport()
  {
    return this.tran_sport;
  }
  
  public String getType()
  {
    return this.type;
  }
  
  public String getTypeName()
  {
    return this.typeName;
  }
  
  public HashSet<Integer> getTypeSet()
  {
    return this.typeSet;
  }
  
  public String getVersion()
  {
    return this.version;
  }
  
  public List<SelectBean> getVersionBeanList()
  {
    return this.versionBeanList;
  }
  
  public String getVersion_id()
  {
    return this.version_id;
  }
  
  public String getWork_time()
  {
    return this.work_time;
  }
  
  public List<SelectBean> gethFaceBeanList()
  {
    return this.hFaceBeanList;
  }
  
  public int getmAreaIndex()
  {
    return this.mAreaIndex;
  }
  
  public int getmHeatingIndex()
  {
    return this.mHeatingIndex;
  }
  
  public int getmHouseTypeIndex()
  {
    return this.mHouseTypeIndex;
  }
  
  public int getmMoneyIndex()
  {
    return this.mMoneyIndex;
  }
  
  public List<SelectBean> getrFaceBeanList()
  {
    return this.rFaceBeanList;
  }
  
  public void setArea(String paramString)
  {
    this.area = paramString;
  }
  
  public void setAreaBeanList(List<SelectBean> paramList)
  {
    this.areaBeanList = paramList;
  }
  
  public void setAreaStr(String paramString)
  {
    this.areaStr = paramString;
  }
  
  public void setAreaText(String paramString)
  {
    this.areaText = paramString;
  }
  
  public void setAround(String paramString)
  {
    this.around = paramString;
  }
  
  public void setAroundBeanList(List<SelectBean> paramList)
  {
    this.aroundBeanList = paramList;
  }
  
  public void setBedroom(SelectBean paramSelectBean)
  {
    this.bedroom = paramSelectBean;
  }
  
  public void setBizcircle(SelectBean paramSelectBean)
  {
    this.bizcircle = paramSelectBean;
  }
  
  public void setBizcircle_code(String paramString)
  {
    this.bizcircle_code = paramString;
  }
  
  public void setBizcircle_name(String paramString)
  {
    this.bizcircle_name = paramString;
  }
  
  public void setCan_sign(int paramInt)
  {
    this.can_sign = paramInt;
  }
  
  public void setCheckin_date(String paramString)
  {
    this.checkin_date = paramString;
  }
  
  public void setChildVersionIndex(String paramString)
  {
    this.childVersionIndex = paramString;
  }
  
  public void setCity_id(String paramString)
  {
    this.city_id = paramString;
  }
  
  public void setClat(String paramString)
  {
    this.clat = paramString;
  }
  
  public void setClng(String paramString)
  {
    this.clng = paramString;
  }
  
  public void setCommute_name(String paramString)
  {
    this.commute_name = paramString;
  }
  
  public void setConfigs(String paramString)
  {
    this.configs = paramString;
  }
  
  public void setDistrict(String paramString)
  {
    this.district = paramString;
  }
  
  public void setDistrictName(String paramString)
  {
    this.districtName = paramString;
  }
  
  public void setFace(String paramString)
  {
    this.face = paramString;
  }
  
  public void setFaceBeanList(List<SelectBean> paramList)
  {
    this.faceBeanList = paramList;
  }
  
  public void setFeature(String paramString)
  {
    this.feature = paramString;
  }
  
  public void setFeatureBeanList(List<SelectBean> paramList)
  {
    this.featureBeanList = paramList;
  }
  
  public void setHeating(String paramString)
  {
    this.heating = paramString;
  }
  
  public void setHeatingStr(String paramString)
  {
    this.heatingStr = paramString;
  }
  
  public void setHface(String paramString)
  {
    this.hface = paramString;
  }
  
  public void setHouseType(String paramString)
  {
    this.houseType = paramString;
  }
  
  public void setHouseTypeStr(String paramString)
  {
    this.houseTypeStr = paramString;
  }
  
  public void setHouse_tags_0(int paramInt)
  {
    this.house_tags_0 = paramInt;
  }
  
  public void setHouse_tags_1(int paramInt)
  {
    this.house_tags_1 = paramInt;
  }
  
  public void setHouse_tags_2(int paramInt)
  {
    this.house_tags_2 = paramInt;
  }
  
  public void setHouse_tags_3(int paramInt)
  {
    this.house_tags_3 = paramInt;
  }
  
  public void setHouse_tags_4(int paramInt)
  {
    this.house_tags_4 = paramInt;
  }
  
  public void setHouse_tags_6(int paramInt)
  {
    this.house_tags_6 = paramInt;
  }
  
  public void setHouse_type(String paramString)
  {
    this.house_type = paramString;
  }
  
  public void setHuxing(String paramString)
  {
    this.huxing = paramString;
  }
  
  public void setIs_commute(String paramString)
  {
    this.is_commute = paramString;
  }
  
  public void setIs_reserve(int paramInt)
  {
    this.is_reserve = paramInt;
  }
  
  public void setKeywords(String paramString)
  {
    this.keywords = paramString;
  }
  
  public void setLeaseTypeBeanList(List<SelectBean> paramList)
  {
    this.leaseTypeBeanList = paramList;
  }
  
  public void setLeasetype(String paramString)
  {
    this.leasetype = paramString;
  }
  
  public void setLive(String paramString)
  {
    this.live = paramString;
  }
  
  public void setLongitude_and_latitude(String paramString)
  {
    this.longitude_and_latitude = paramString;
  }
  
  public void setMaxPrice(int paramInt)
  {
    this.maxPrice = paramInt;
  }
  
  public void setMax_area(String paramString)
  {
    this.max_area = paramString;
  }
  
  public void setMax_lat(String paramString)
  {
    this.max_lat = paramString;
  }
  
  public void setMax_lng(String paramString)
  {
    this.max_lng = paramString;
  }
  
  public void setMax_rentfee(String paramString)
  {
    this.max_rentfee = paramString;
  }
  
  public void setMinPrice(int paramInt)
  {
    this.minPrice = paramInt;
  }
  
  public void setMin_area(String paramString)
  {
    this.min_area = paramString;
  }
  
  public void setMin_lat(String paramString)
  {
    this.min_lat = paramString;
  }
  
  public void setMin_lng(String paramString)
  {
    this.min_lng = paramString;
  }
  
  public void setMin_rentfee(String paramString)
  {
    this.min_rentfee = paramString;
  }
  
  public void setMoneyStr(String paramString)
  {
    this.moneyStr = paramString;
  }
  
  public void setMore_count(int paramInt)
  {
    this.more_count = paramInt;
  }
  
  public void setPage(int paramInt)
  {
    this.page = paramInt;
  }
  
  public void setPrice(SelectBean paramSelectBean)
  {
    this.price = paramSelectBean;
  }
  
  public void setRapid(String paramString)
  {
    this.rapid = paramString;
  }
  
  public void setRapidBeanList(List<SelectBean> paramList)
  {
    this.rapidBeanList = paramList;
  }
  
  public void setResblock_id(String paramString)
  {
    this.resblock_id = paramString;
  }
  
  public void setRface(String paramString)
  {
    this.rface = paramString;
  }
  
  public void setSize(String paramString)
  {
    this.size = paramString;
  }
  
  public void setSort(String paramString)
  {
    this.sort = paramString;
  }
  
  public void setSort_type(int paramInt)
  {
    this.sort_type = paramInt;
  }
  
  public void setStyle(String paramString)
  {
    this.style = paramString;
  }
  
  public void setStyleBeanList(List<SelectBean> paramList)
  {
    this.styleBeanList = paramList;
  }
  
  public void setStyle_code(String paramString)
  {
    this.style_code = paramString;
  }
  
  public void setStyle_codes(String paramString)
  {
    this.style_codes = paramString;
  }
  
  public void setSubWayStr(String paramString)
  {
    this.subWayStr = paramString;
  }
  
  public void setSubway(String paramString)
  {
    this.subway = paramString;
  }
  
  public void setSubwayName(String paramString)
  {
    this.subwayName = paramString;
  }
  
  public void setSubway_line(String paramString)
  {
    this.subway_line = paramString;
  }
  
  public void setSubway_link_name(String paramString)
  {
    this.subway_link_name = paramString;
  }
  
  public void setSubway_station_name(String paramString)
  {
    this.subway_station_name = paramString;
  }
  
  public void setSuggestion_type(String paramString)
  {
    this.suggestion_type = paramString;
  }
  
  public void setSuggestion_value(String paramString)
  {
    this.suggestion_value = paramString;
  }
  
  public void setTags(String paramString)
  {
    this.tags = paramString;
  }
  
  public void setTagsBeanList(List<SelectBean> paramList)
  {
    this.tagsBeanList = paramList;
  }
  
  public void setTran_sport(String paramString)
  {
    this.tran_sport = paramString;
  }
  
  public void setType(String paramString)
  {
    this.type = paramString;
  }
  
  public void setTypeName(String paramString)
  {
    this.typeName = paramString;
  }
  
  public void setTypeSet(HashSet<Integer> paramHashSet)
  {
    this.typeSet = paramHashSet;
  }
  
  public void setVersion(String paramString)
  {
    this.version = paramString;
  }
  
  public void setVersionBeanList(List<SelectBean> paramList)
  {
    this.versionBeanList = paramList;
  }
  
  public void setVersion_id(String paramString)
  {
    this.version_id = paramString;
  }
  
  public void setWork_time(String paramString)
  {
    this.work_time = paramString;
  }
  
  public void sethFaceBeanList(List<SelectBean> paramList)
  {
    this.hFaceBeanList = paramList;
  }
  
  public void setmAreaIndex(int paramInt)
  {
    this.mAreaIndex = paramInt;
  }
  
  public void setmHeatingIndex(int paramInt)
  {
    this.mHeatingIndex = paramInt;
  }
  
  public void setmHouseTypeIndex(int paramInt)
  {
    this.mHouseTypeIndex = paramInt;
  }
  
  public void setmMoneyIndex(int paramInt)
  {
    this.mMoneyIndex = paramInt;
  }
  
  public void setrFaceBeanList(List<SelectBean> paramList)
  {
    this.rFaceBeanList = paramList;
  }
  
  public String toString()
  {
    return "SearchCondition{min_lng='" + this.min_lng + '\'' + ", max_lng='" + this.max_lng + '\'' + ", min_lat='" + this.min_lat + '\'' + ", max_lat='" + this.max_lat + '\'' + ", house_type='" + this.house_type + '\'' + ", houseType='" + this.houseType + '\'' + ", subway_station_name='" + this.subway_station_name + '\'' + ", bizcircle_code='" + this.bizcircle_code + '\'' + ", bizcircle_name='" + this.bizcircle_name + '\'' + ", min_rentfee='" + this.min_rentfee + '\'' + ", max_rentfee='" + this.max_rentfee + '\'' + ", min_area='" + this.min_area + '\'' + ", max_area='" + this.max_area + '\'' + ", huxing='" + this.huxing + '\'' + ", heating='" + this.heating + '\'' + ", house_tags_0=" + this.house_tags_0 + ", house_tags_1=" + this.house_tags_1 + ", house_tags_2=" + this.house_tags_2 + ", house_tags_3=" + this.house_tags_3 + ", house_tags_4=" + this.house_tags_4 + ", house_tags_6=" + this.house_tags_6 + ", can_sign=" + this.can_sign + ", is_reserve=" + this.is_reserve + ", sort_type=" + this.sort_type + ", subWayStr='" + this.subWayStr + '\'' + ", subway_line='" + this.subway_line + '\'' + ", district='" + this.district + '\'' + ", districtName='" + this.districtName + '\'' + ", mMoneyIndex=" + this.mMoneyIndex + ", mAreaIndex=" + this.mAreaIndex + ", mHouseTypeIndex=" + this.mHouseTypeIndex + ", mHeatingIndex=" + this.mHeatingIndex + ", moneyStr='" + this.moneyStr + '\'' + ", areaStr='" + this.areaStr + '\'' + ", houseTypeStr='" + this.houseTypeStr + '\'' + ", heatingStr='" + this.heatingStr + '\'' + ", longitude_and_latitude='" + this.longitude_and_latitude + '\'' + ", tran_sport='" + this.tran_sport + '\'' + ", work_time='" + this.work_time + '\'' + ", is_commute='" + this.is_commute + '\'' + ", commute_name='" + this.commute_name + '\'' + ", more_count=" + this.more_count + ", style_code='" + this.style_code + '\'' + ", style_codes='" + this.style_codes + '\'' + ", version_id='" + this.version_id + '\'' + ", city_id='" + this.city_id + '\'' + ", subway_link_name='" + this.subway_link_name + '\'' + ", clng='" + this.clng + '\'' + ", clat='" + this.clat + '\'' + ", keywords='" + this.keywords + '\'' + ", subway='" + this.subway + '\'' + ", subwayName='" + this.subwayName + '\'' + ", bizcircle=" + this.bizcircle + ", resblock_id='" + this.resblock_id + '\'' + ", bedroom=" + this.bedroom + ", price=" + this.price + ", minPrice=" + this.minPrice + ", maxPrice=" + this.maxPrice + ", sort='" + this.sort + '\'' + ", face='" + this.face + '\'' + ", style='" + this.style + '\'' + ", configs='" + this.configs + '\'' + ", tags='" + this.tags + '\'' + ", page=" + this.page + ", size='" + this.size + '\'' + ", type='" + this.type + '\'' + ", typeName='" + this.typeName + '\'' + ", childVersionIndex='" + this.childVersionIndex + '\'' + ", feature='" + this.feature + '\'' + ", version='" + this.version + '\'' + ", leasetype='" + this.leasetype + '\'' + ", hface='" + this.hface + '\'' + ", rface='" + this.rface + '\'' + ", around='" + this.around + '\'' + ", area='" + this.area + '\'' + ", typeSet=" + this.typeSet + ", live='" + this.live + '\'' + ", suggestion_type='" + this.suggestion_type + '\'' + ", suggestion_value='" + this.suggestion_value + '\'' + '}';
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/SearchCondition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */