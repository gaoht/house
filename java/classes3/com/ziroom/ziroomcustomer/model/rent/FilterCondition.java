package com.ziroom.ziroomcustomer.model.rent;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.List;

public class FilterCondition
  implements Parcelable
{
  public static final Parcelable.Creator<FilterCondition> CREATOR = new Parcelable.Creator()
  {
    public FilterCondition createFromParcel(Parcel paramAnonymousParcel)
    {
      return new FilterCondition(paramAnonymousParcel);
    }
    
    public FilterCondition[] newArray(int paramAnonymousInt)
    {
      return new FilterCondition[paramAnonymousInt];
    }
  };
  private List<RentConditionItem> area2;
  private List<RentConditionItem> around;
  private List<RentCheckInDateCondition> checkin_date;
  private List<RentConditionItem> face;
  private List<RentConditionItem> feature;
  private List<RentConditionItem> feature1;
  private List<RentConditionItem> feature2;
  private List<RentConditionItem> hface2;
  private String keywords;
  private List<RentConditionItem> leasetype;
  private Double max_lat;
  private Double max_lng;
  private Double min_lat;
  private Double min_lng;
  private List<RentConditionItem> price;
  private List<RentConditionItem> price1;
  private List<RentConditionItem> price2;
  private List<RentConditionItem> rface1;
  private List<RentConditionItem> sort;
  private Integer suggestion_type;
  private String suggestion_value;
  private List<RentConditionItem> tag;
  private List<RentTypeConditionItem> type;
  private List<RentTypeExtraConditionItem> type_extra;
  private List<RentConditionItem> version1;
  private List<RentConditionItem> version2;
  
  public FilterCondition() {}
  
  protected FilterCondition(Parcel paramParcel)
  {
    this.keywords = paramParcel.readString();
    this.suggestion_type = ((Integer)paramParcel.readValue(Integer.class.getClassLoader()));
    this.suggestion_value = paramParcel.readString();
    this.min_lng = ((Double)paramParcel.readValue(Double.class.getClassLoader()));
    this.max_lng = ((Double)paramParcel.readValue(Double.class.getClassLoader()));
    this.min_lat = ((Double)paramParcel.readValue(Double.class.getClassLoader()));
    this.max_lat = ((Double)paramParcel.readValue(Double.class.getClassLoader()));
    this.leasetype = paramParcel.createTypedArrayList(RentConditionItem.CREATOR);
    this.type = paramParcel.createTypedArrayList(RentTypeConditionItem.CREATOR);
    this.price = paramParcel.createTypedArrayList(RentConditionItem.CREATOR);
    this.price1 = paramParcel.createTypedArrayList(RentConditionItem.CREATOR);
    this.price2 = paramParcel.createTypedArrayList(RentConditionItem.CREATOR);
    this.sort = paramParcel.createTypedArrayList(RentConditionItem.CREATOR);
    this.face = paramParcel.createTypedArrayList(RentConditionItem.CREATOR);
    this.hface2 = paramParcel.createTypedArrayList(RentConditionItem.CREATOR);
    this.rface1 = paramParcel.createTypedArrayList(RentConditionItem.CREATOR);
    this.feature = paramParcel.createTypedArrayList(RentConditionItem.CREATOR);
    this.feature1 = paramParcel.createTypedArrayList(RentConditionItem.CREATOR);
    this.feature2 = paramParcel.createTypedArrayList(RentConditionItem.CREATOR);
    this.tag = paramParcel.createTypedArrayList(RentConditionItem.CREATOR);
    this.around = paramParcel.createTypedArrayList(RentConditionItem.CREATOR);
    this.area2 = paramParcel.createTypedArrayList(RentConditionItem.CREATOR);
    this.version1 = paramParcel.createTypedArrayList(RentConditionItem.CREATOR);
    this.version2 = paramParcel.createTypedArrayList(RentConditionItem.CREATOR);
    this.type_extra = paramParcel.createTypedArrayList(RentTypeExtraConditionItem.CREATOR);
    this.checkin_date = paramParcel.createTypedArrayList(RentCheckInDateCondition.CREATOR);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public List<RentConditionItem> getArea2()
  {
    return this.area2;
  }
  
  public List<RentConditionItem> getAround()
  {
    return this.around;
  }
  
  public List<RentCheckInDateCondition> getCheckin_date()
  {
    return this.checkin_date;
  }
  
  public List<RentConditionItem> getFace()
  {
    return this.face;
  }
  
  public List<RentConditionItem> getFeature()
  {
    return this.feature;
  }
  
  public List<RentConditionItem> getFeature1()
  {
    return this.feature1;
  }
  
  public List<RentConditionItem> getFeature2()
  {
    return this.feature2;
  }
  
  public List<RentConditionItem> getHface2()
  {
    return this.hface2;
  }
  
  public String getKeywords()
  {
    return this.keywords;
  }
  
  public List<RentConditionItem> getLeasetype()
  {
    return this.leasetype;
  }
  
  public Double getMax_lat()
  {
    return this.max_lat;
  }
  
  public Double getMax_lng()
  {
    return this.max_lng;
  }
  
  public Double getMin_lat()
  {
    return this.min_lat;
  }
  
  public Double getMin_lng()
  {
    return this.min_lng;
  }
  
  public List<RentConditionItem> getPrice()
  {
    return this.price;
  }
  
  public List<RentConditionItem> getPrice1()
  {
    return this.price1;
  }
  
  public List<RentConditionItem> getPrice2()
  {
    return this.price2;
  }
  
  public List<RentConditionItem> getRface1()
  {
    return this.rface1;
  }
  
  public List<RentConditionItem> getSort()
  {
    return this.sort;
  }
  
  public Integer getSuggestion_type()
  {
    return this.suggestion_type;
  }
  
  public String getSuggestion_value()
  {
    return this.suggestion_value;
  }
  
  public List<RentConditionItem> getTag()
  {
    return this.tag;
  }
  
  public List<RentTypeConditionItem> getType()
  {
    return this.type;
  }
  
  public List<RentTypeExtraConditionItem> getType_extra()
  {
    return this.type_extra;
  }
  
  public List<RentConditionItem> getVersion1()
  {
    return this.version1;
  }
  
  public List<RentConditionItem> getVersion2()
  {
    return this.version2;
  }
  
  public void setArea2(List<RentConditionItem> paramList)
  {
    this.area2 = paramList;
  }
  
  public void setAround(List<RentConditionItem> paramList)
  {
    this.around = paramList;
  }
  
  public void setCheckin_date(List<RentCheckInDateCondition> paramList)
  {
    this.checkin_date = paramList;
  }
  
  public void setFace(List<RentConditionItem> paramList)
  {
    this.face = paramList;
  }
  
  public void setFeature(List<RentConditionItem> paramList)
  {
    this.feature = paramList;
  }
  
  public void setFeature1(List<RentConditionItem> paramList)
  {
    this.feature1 = paramList;
  }
  
  public void setFeature2(List<RentConditionItem> paramList)
  {
    this.feature2 = paramList;
  }
  
  public void setHface2(List<RentConditionItem> paramList)
  {
    this.hface2 = paramList;
  }
  
  public void setKeywords(String paramString)
  {
    this.keywords = paramString;
  }
  
  public void setLeasetype(List<RentConditionItem> paramList)
  {
    this.leasetype = paramList;
  }
  
  public void setMax_lat(Double paramDouble)
  {
    this.max_lat = paramDouble;
  }
  
  public void setMax_lng(Double paramDouble)
  {
    this.max_lng = paramDouble;
  }
  
  public void setMin_lat(Double paramDouble)
  {
    this.min_lat = paramDouble;
  }
  
  public void setMin_lng(Double paramDouble)
  {
    this.min_lng = paramDouble;
  }
  
  public void setPrice(List<RentConditionItem> paramList)
  {
    this.price = paramList;
  }
  
  public void setPrice1(List<RentConditionItem> paramList)
  {
    this.price1 = paramList;
  }
  
  public void setPrice2(List<RentConditionItem> paramList)
  {
    this.price2 = paramList;
  }
  
  public void setRface1(List<RentConditionItem> paramList)
  {
    this.rface1 = paramList;
  }
  
  public void setSort(List<RentConditionItem> paramList)
  {
    this.sort = paramList;
  }
  
  public void setSuggestion_type(Integer paramInteger)
  {
    this.suggestion_type = paramInteger;
  }
  
  public void setSuggestion_value(String paramString)
  {
    this.suggestion_value = paramString;
  }
  
  public void setTag(List<RentConditionItem> paramList)
  {
    this.tag = paramList;
  }
  
  public void setType(List<RentTypeConditionItem> paramList)
  {
    this.type = paramList;
  }
  
  public void setType_extra(List<RentTypeExtraConditionItem> paramList)
  {
    this.type_extra = paramList;
  }
  
  public void setVersion1(List<RentConditionItem> paramList)
  {
    this.version1 = paramList;
  }
  
  public void setVersion2(List<RentConditionItem> paramList)
  {
    this.version2 = paramList;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.keywords);
    paramParcel.writeValue(this.suggestion_type);
    paramParcel.writeString(this.suggestion_value);
    paramParcel.writeValue(this.min_lng);
    paramParcel.writeValue(this.max_lng);
    paramParcel.writeValue(this.min_lat);
    paramParcel.writeValue(this.max_lat);
    paramParcel.writeTypedList(this.leasetype);
    paramParcel.writeTypedList(this.type);
    paramParcel.writeTypedList(this.price);
    paramParcel.writeTypedList(this.price1);
    paramParcel.writeTypedList(this.price2);
    paramParcel.writeTypedList(this.sort);
    paramParcel.writeTypedList(this.face);
    paramParcel.writeTypedList(this.hface2);
    paramParcel.writeTypedList(this.rface1);
    paramParcel.writeTypedList(this.feature);
    paramParcel.writeTypedList(this.feature1);
    paramParcel.writeTypedList(this.feature2);
    paramParcel.writeTypedList(this.tag);
    paramParcel.writeTypedList(this.around);
    paramParcel.writeTypedList(this.area2);
    paramParcel.writeTypedList(this.version1);
    paramParcel.writeTypedList(this.version2);
    paramParcel.writeTypedList(this.type_extra);
    paramParcel.writeTypedList(this.checkin_date);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/rent/FilterCondition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */