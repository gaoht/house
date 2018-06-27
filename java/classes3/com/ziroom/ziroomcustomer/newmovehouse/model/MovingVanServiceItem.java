package com.ziroom.ziroomcustomer.newmovehouse.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class MovingVanServiceItem
  implements Parcelable
{
  public static final Parcelable.Creator<MovingVanServiceItem> CREATOR = new Parcelable.Creator()
  {
    public MovingVanServiceItem createFromParcel(Parcel paramAnonymousParcel)
    {
      return new MovingVanServiceItem(paramAnonymousParcel);
    }
    
    public MovingVanServiceItem[] newArray(int paramAnonymousInt)
    {
      return new MovingVanServiceItem[paramAnonymousInt];
    }
  };
  public static final int FLAG_NOT_VALUATION = 0;
  public static final int FLAG_VALUATION = 1;
  public static final int STATUS_DEL = 10;
  public static final int STATUS_OFF = 5;
  public static final int STATUS_ON = 1;
  public static final int TYPE_ASSEMBLING = 2;
  public static final int TYPE_CARRY = 1;
  public int buyNumber;
  private String categoryCode;
  private String cityCode;
  private String imageAlt;
  private String imageUrl;
  private Integer isValuation;
  private String logicCode;
  private String serviceDetail;
  private String serviceName;
  private long servicePrice;
  private String serviceSpecification;
  private Integer serviceStatus;
  private Integer serviceType;
  
  public MovingVanServiceItem() {}
  
  protected MovingVanServiceItem(Parcel paramParcel)
  {
    this.logicCode = paramParcel.readString();
    this.categoryCode = paramParcel.readString();
    this.cityCode = paramParcel.readString();
    this.serviceName = paramParcel.readString();
    this.serviceDetail = paramParcel.readString();
    this.serviceSpecification = paramParcel.readString();
    this.servicePrice = paramParcel.readLong();
    this.isValuation = ((Integer)paramParcel.readValue(Integer.class.getClassLoader()));
    this.serviceStatus = ((Integer)paramParcel.readValue(Integer.class.getClassLoader()));
    this.serviceType = ((Integer)paramParcel.readValue(Integer.class.getClassLoader()));
    this.imageUrl = paramParcel.readString();
    this.imageAlt = paramParcel.readString();
    this.buyNumber = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject != null) && (getLogicCode() != null)) {
      return getLogicCode().equals(((MovingVanServiceItem)paramObject).getLogicCode());
    }
    return super.equals(paramObject);
  }
  
  public int getBuyNumber()
  {
    return this.buyNumber;
  }
  
  public String getCategoryCode()
  {
    return this.categoryCode;
  }
  
  public String getCityCode()
  {
    return this.cityCode;
  }
  
  public String getImageAlt()
  {
    return this.imageAlt;
  }
  
  public String getImageUrl()
  {
    return this.imageUrl;
  }
  
  public Integer getIsValuation()
  {
    return this.isValuation;
  }
  
  public String getLogicCode()
  {
    return this.logicCode;
  }
  
  public String getServiceDetail()
  {
    return this.serviceDetail;
  }
  
  public String getServiceName()
  {
    return this.serviceName;
  }
  
  public long getServicePrice()
  {
    return this.servicePrice;
  }
  
  public String getServiceSpecification()
  {
    return this.serviceSpecification;
  }
  
  public Integer getServiceStatus()
  {
    return this.serviceStatus;
  }
  
  public Integer getServiceType()
  {
    return this.serviceType;
  }
  
  public void setBuyNumber(int paramInt)
  {
    this.buyNumber = paramInt;
  }
  
  public void setCategoryCode(String paramString)
  {
    this.categoryCode = paramString;
  }
  
  public void setCityCode(String paramString)
  {
    this.cityCode = paramString;
  }
  
  public void setImageAlt(String paramString)
  {
    this.imageAlt = paramString;
  }
  
  public void setImageUrl(String paramString)
  {
    this.imageUrl = paramString;
  }
  
  public void setIsValuation(Integer paramInteger)
  {
    this.isValuation = paramInteger;
  }
  
  public void setLogicCode(String paramString)
  {
    this.logicCode = paramString;
  }
  
  public void setServiceDetail(String paramString)
  {
    this.serviceDetail = paramString;
  }
  
  public void setServiceName(String paramString)
  {
    this.serviceName = paramString;
  }
  
  public void setServicePrice(long paramLong)
  {
    this.servicePrice = paramLong;
  }
  
  public void setServiceSpecification(String paramString)
  {
    this.serviceSpecification = paramString;
  }
  
  public void setServiceStatus(Integer paramInteger)
  {
    this.serviceStatus = paramInteger;
  }
  
  public void setServiceType(Integer paramInteger)
  {
    this.serviceType = paramInteger;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.logicCode);
    paramParcel.writeString(this.categoryCode);
    paramParcel.writeString(this.cityCode);
    paramParcel.writeString(this.serviceName);
    paramParcel.writeString(this.serviceDetail);
    paramParcel.writeString(this.serviceSpecification);
    paramParcel.writeLong(this.servicePrice);
    paramParcel.writeValue(this.isValuation);
    paramParcel.writeValue(this.serviceStatus);
    paramParcel.writeValue(this.serviceType);
    paramParcel.writeString(this.imageUrl);
    paramParcel.writeString(this.imageAlt);
    paramParcel.writeInt(this.buyNumber);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/model/MovingVanServiceItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */