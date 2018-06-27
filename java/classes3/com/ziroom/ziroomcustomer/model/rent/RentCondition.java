package com.ziroom.ziroomcustomer.model.rent;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class RentCondition
  implements Parcelable
{
  public static final Parcelable.Creator<RentCondition> CREATOR = new Parcelable.Creator()
  {
    public RentCondition createFromParcel(Parcel paramAnonymousParcel)
    {
      return new RentCondition(paramAnonymousParcel);
    }
    
    public RentCondition[] newArray(int paramAnonymousInt)
    {
      return new RentCondition[paramAnonymousInt];
    }
  };
  private RentConditionItem area;
  private RentConditionItem around;
  private RentConditionItem bedroom;
  private RentConditionItem bizcircleCode;
  private RentConditionItem cLat;
  private RentConditionItem cLng;
  private RentConditionItem checkinDate;
  private RentConditionItem cityCode;
  private RentConditionItem districtCode;
  private RentConditionItem face;
  private RentConditionItem feature;
  private RentConditionItem hFace;
  private RentConditionItem keyWords;
  private RentConditionItem leaseType;
  private RentConditionItem live;
  private Double maxLat;
  private Double maxLng;
  private Double minLat;
  private Double minLng;
  private RentConditionItem page;
  private RentConditionItem price;
  private RentConditionItem rFace;
  private RentConditionItem reslockId;
  private RentConditionItem size;
  private RentConditionItem sort;
  private RentConditionItem style;
  private RentConditionItem subwayCode;
  private RentConditionItem subwayStationCode;
  private RentConditionItem suggestionType;
  private RentConditionItem suggestionValue;
  private RentConditionItem tag;
  private RentConditionItem type;
  private RentConditionItem version;
  
  public RentCondition() {}
  
  protected RentCondition(Parcel paramParcel)
  {
    this.cityCode = ((RentConditionItem)paramParcel.readParcelable(RentConditionItem.class.getClassLoader()));
    this.keyWords = ((RentConditionItem)paramParcel.readParcelable(RentConditionItem.class.getClassLoader()));
    this.type = ((RentConditionItem)paramParcel.readParcelable(RentConditionItem.class.getClassLoader()));
    this.subwayStationCode = ((RentConditionItem)paramParcel.readParcelable(RentConditionItem.class.getClassLoader()));
    this.subwayCode = ((RentConditionItem)paramParcel.readParcelable(RentConditionItem.class.getClassLoader()));
    this.districtCode = ((RentConditionItem)paramParcel.readParcelable(RentConditionItem.class.getClassLoader()));
    this.bizcircleCode = ((RentConditionItem)paramParcel.readParcelable(RentConditionItem.class.getClassLoader()));
    this.reslockId = ((RentConditionItem)paramParcel.readParcelable(RentConditionItem.class.getClassLoader()));
    this.cLng = ((RentConditionItem)paramParcel.readParcelable(RentConditionItem.class.getClassLoader()));
    this.cLat = ((RentConditionItem)paramParcel.readParcelable(RentConditionItem.class.getClassLoader()));
    this.leaseType = ((RentConditionItem)paramParcel.readParcelable(RentConditionItem.class.getClassLoader()));
    this.bedroom = ((RentConditionItem)paramParcel.readParcelable(RentConditionItem.class.getClassLoader()));
    this.price = ((RentConditionItem)paramParcel.readParcelable(RentConditionItem.class.getClassLoader()));
    this.sort = ((RentConditionItem)paramParcel.readParcelable(RentConditionItem.class.getClassLoader()));
    this.face = ((RentConditionItem)paramParcel.readParcelable(RentConditionItem.class.getClassLoader()));
    this.hFace = ((RentConditionItem)paramParcel.readParcelable(RentConditionItem.class.getClassLoader()));
    this.rFace = ((RentConditionItem)paramParcel.readParcelable(RentConditionItem.class.getClassLoader()));
    this.version = ((RentConditionItem)paramParcel.readParcelable(RentConditionItem.class.getClassLoader()));
    this.style = ((RentConditionItem)paramParcel.readParcelable(RentConditionItem.class.getClassLoader()));
    this.feature = ((RentConditionItem)paramParcel.readParcelable(RentConditionItem.class.getClassLoader()));
    this.around = ((RentConditionItem)paramParcel.readParcelable(RentConditionItem.class.getClassLoader()));
    this.area = ((RentConditionItem)paramParcel.readParcelable(RentConditionItem.class.getClassLoader()));
    this.tag = ((RentConditionItem)paramParcel.readParcelable(RentConditionItem.class.getClassLoader()));
    this.live = ((RentConditionItem)paramParcel.readParcelable(RentConditionItem.class.getClassLoader()));
    this.page = ((RentConditionItem)paramParcel.readParcelable(RentConditionItem.class.getClassLoader()));
    this.size = ((RentConditionItem)paramParcel.readParcelable(RentConditionItem.class.getClassLoader()));
    this.suggestionType = ((RentConditionItem)paramParcel.readParcelable(RentConditionItem.class.getClassLoader()));
    this.suggestionValue = ((RentConditionItem)paramParcel.readParcelable(RentConditionItem.class.getClassLoader()));
    this.checkinDate = ((RentConditionItem)paramParcel.readParcelable(RentConditionItem.class.getClassLoader()));
    this.minLng = ((Double)paramParcel.readValue(Double.class.getClassLoader()));
    this.maxLng = ((Double)paramParcel.readValue(Double.class.getClassLoader()));
    this.minLat = ((Double)paramParcel.readValue(Double.class.getClassLoader()));
    this.maxLat = ((Double)paramParcel.readValue(Double.class.getClassLoader()));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public RentConditionItem getArea()
  {
    return this.area;
  }
  
  public RentConditionItem getAround()
  {
    return this.around;
  }
  
  public RentConditionItem getBedroom()
  {
    return this.bedroom;
  }
  
  public RentConditionItem getBizcircleCode()
  {
    return this.bizcircleCode;
  }
  
  public RentConditionItem getCheckinDate()
  {
    return this.checkinDate;
  }
  
  public RentConditionItem getCityCode()
  {
    return this.cityCode;
  }
  
  public RentConditionItem getDistrictCode()
  {
    return this.districtCode;
  }
  
  public RentConditionItem getFace()
  {
    return this.face;
  }
  
  public RentConditionItem getFeature()
  {
    return this.feature;
  }
  
  public RentConditionItem getKeyWords()
  {
    return this.keyWords;
  }
  
  public RentConditionItem getLeaseType()
  {
    return this.leaseType;
  }
  
  public RentConditionItem getLive()
  {
    return this.live;
  }
  
  public Double getMaxLat()
  {
    return this.maxLat;
  }
  
  public Double getMaxLng()
  {
    return this.maxLng;
  }
  
  public Double getMinLat()
  {
    return this.minLat;
  }
  
  public Double getMinLng()
  {
    return this.minLng;
  }
  
  public RentConditionItem getPage()
  {
    return this.page;
  }
  
  public RentConditionItem getPrice()
  {
    return this.price;
  }
  
  public RentConditionItem getReslockId()
  {
    return this.reslockId;
  }
  
  public RentConditionItem getSize()
  {
    return this.size;
  }
  
  public RentConditionItem getSort()
  {
    return this.sort;
  }
  
  public RentConditionItem getStyle()
  {
    return this.style;
  }
  
  public RentConditionItem getSubwayCode()
  {
    return this.subwayCode;
  }
  
  public RentConditionItem getSubwayStationCode()
  {
    return this.subwayStationCode;
  }
  
  public RentConditionItem getSuggestionType()
  {
    return this.suggestionType;
  }
  
  public RentConditionItem getSuggestionValue()
  {
    return this.suggestionValue;
  }
  
  public RentConditionItem getTag()
  {
    return this.tag;
  }
  
  public RentConditionItem getType()
  {
    return this.type;
  }
  
  public RentConditionItem getVersion()
  {
    return this.version;
  }
  
  public RentConditionItem getcLat()
  {
    return this.cLat;
  }
  
  public RentConditionItem getcLng()
  {
    return this.cLng;
  }
  
  public RentConditionItem gethFace()
  {
    return this.hFace;
  }
  
  public RentConditionItem getrFace()
  {
    return this.rFace;
  }
  
  public void setArea(RentConditionItem paramRentConditionItem)
  {
    this.area = paramRentConditionItem;
  }
  
  public void setAround(RentConditionItem paramRentConditionItem)
  {
    this.around = paramRentConditionItem;
  }
  
  public void setBedroom(RentConditionItem paramRentConditionItem)
  {
    this.bedroom = paramRentConditionItem;
  }
  
  public void setBizcircleCode(RentConditionItem paramRentConditionItem)
  {
    this.bizcircleCode = paramRentConditionItem;
  }
  
  public void setCheckinDate(RentConditionItem paramRentConditionItem)
  {
    this.checkinDate = paramRentConditionItem;
  }
  
  public void setCityCode(RentConditionItem paramRentConditionItem)
  {
    this.cityCode = paramRentConditionItem;
  }
  
  public void setDistrictCode(RentConditionItem paramRentConditionItem)
  {
    this.districtCode = paramRentConditionItem;
  }
  
  public void setFace(RentConditionItem paramRentConditionItem)
  {
    this.face = paramRentConditionItem;
  }
  
  public void setFeature(RentConditionItem paramRentConditionItem)
  {
    this.feature = paramRentConditionItem;
  }
  
  public void setKeyWords(RentConditionItem paramRentConditionItem)
  {
    this.keyWords = paramRentConditionItem;
  }
  
  public void setLeaseType(RentConditionItem paramRentConditionItem)
  {
    this.leaseType = paramRentConditionItem;
  }
  
  public void setLive(RentConditionItem paramRentConditionItem)
  {
    this.live = paramRentConditionItem;
  }
  
  public void setMaxLat(Double paramDouble)
  {
    this.maxLat = paramDouble;
  }
  
  public void setMaxLng(Double paramDouble)
  {
    this.maxLng = paramDouble;
  }
  
  public void setMinLat(Double paramDouble)
  {
    this.minLat = paramDouble;
  }
  
  public void setMinLng(Double paramDouble)
  {
    this.minLng = paramDouble;
  }
  
  public void setPage(RentConditionItem paramRentConditionItem)
  {
    this.page = paramRentConditionItem;
  }
  
  public void setPrice(RentConditionItem paramRentConditionItem)
  {
    this.price = paramRentConditionItem;
  }
  
  public void setReslockId(RentConditionItem paramRentConditionItem)
  {
    this.reslockId = paramRentConditionItem;
  }
  
  public void setSize(RentConditionItem paramRentConditionItem)
  {
    this.size = paramRentConditionItem;
  }
  
  public void setSort(RentConditionItem paramRentConditionItem)
  {
    this.sort = paramRentConditionItem;
  }
  
  public void setStyle(RentConditionItem paramRentConditionItem)
  {
    this.style = paramRentConditionItem;
  }
  
  public void setSubwayCode(RentConditionItem paramRentConditionItem)
  {
    this.subwayCode = paramRentConditionItem;
  }
  
  public void setSubwayStationCode(RentConditionItem paramRentConditionItem)
  {
    this.subwayStationCode = paramRentConditionItem;
  }
  
  public void setSuggestionType(RentConditionItem paramRentConditionItem)
  {
    this.suggestionType = paramRentConditionItem;
  }
  
  public void setSuggestionValue(RentConditionItem paramRentConditionItem)
  {
    this.suggestionValue = paramRentConditionItem;
  }
  
  public void setTag(RentConditionItem paramRentConditionItem)
  {
    this.tag = paramRentConditionItem;
  }
  
  public void setType(RentConditionItem paramRentConditionItem)
  {
    this.type = paramRentConditionItem;
  }
  
  public void setVersion(RentConditionItem paramRentConditionItem)
  {
    this.version = paramRentConditionItem;
  }
  
  public void setcLat(RentConditionItem paramRentConditionItem)
  {
    this.cLat = paramRentConditionItem;
  }
  
  public void setcLng(RentConditionItem paramRentConditionItem)
  {
    this.cLng = paramRentConditionItem;
  }
  
  public void sethFace(RentConditionItem paramRentConditionItem)
  {
    this.hFace = paramRentConditionItem;
  }
  
  public void setrFace(RentConditionItem paramRentConditionItem)
  {
    this.rFace = paramRentConditionItem;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.cityCode, paramInt);
    paramParcel.writeParcelable(this.keyWords, paramInt);
    paramParcel.writeParcelable(this.type, paramInt);
    paramParcel.writeParcelable(this.subwayStationCode, paramInt);
    paramParcel.writeParcelable(this.subwayCode, paramInt);
    paramParcel.writeParcelable(this.districtCode, paramInt);
    paramParcel.writeParcelable(this.bizcircleCode, paramInt);
    paramParcel.writeParcelable(this.reslockId, paramInt);
    paramParcel.writeParcelable(this.cLng, paramInt);
    paramParcel.writeParcelable(this.cLat, paramInt);
    paramParcel.writeParcelable(this.leaseType, paramInt);
    paramParcel.writeParcelable(this.bedroom, paramInt);
    paramParcel.writeParcelable(this.price, paramInt);
    paramParcel.writeParcelable(this.sort, paramInt);
    paramParcel.writeParcelable(this.face, paramInt);
    paramParcel.writeParcelable(this.hFace, paramInt);
    paramParcel.writeParcelable(this.rFace, paramInt);
    paramParcel.writeParcelable(this.version, paramInt);
    paramParcel.writeParcelable(this.style, paramInt);
    paramParcel.writeParcelable(this.feature, paramInt);
    paramParcel.writeParcelable(this.around, paramInt);
    paramParcel.writeParcelable(this.area, paramInt);
    paramParcel.writeParcelable(this.tag, paramInt);
    paramParcel.writeParcelable(this.live, paramInt);
    paramParcel.writeParcelable(this.page, paramInt);
    paramParcel.writeParcelable(this.size, paramInt);
    paramParcel.writeParcelable(this.suggestionType, paramInt);
    paramParcel.writeParcelable(this.suggestionValue, paramInt);
    paramParcel.writeParcelable(this.checkinDate, paramInt);
    paramParcel.writeValue(this.minLng);
    paramParcel.writeValue(this.maxLng);
    paramParcel.writeValue(this.minLat);
    paramParcel.writeValue(this.maxLat);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/rent/RentCondition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */