package com.ziroom.ziroomcustomer.ziroomapartment.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.List;

public class ZryuListItem
  implements Parcelable
{
  public static final Parcelable.Creator<ZryuListItem> CREATOR = new Parcelable.Creator()
  {
    public ZryuListItem createFromParcel(Parcel paramAnonymousParcel)
    {
      return new ZryuListItem(paramAnonymousParcel);
    }
    
    public ZryuListItem[] newArray(int paramAnonymousInt)
    {
      return new ZryuListItem[paramAnonymousInt];
    }
  };
  private String headPic;
  private int isNewDetail;
  private double lat;
  private double lng;
  private String maxPrice;
  private String minPrice;
  private int openingPeriod;
  private String openingTime;
  private String priceTag;
  private String proAddr;
  private String proCode;
  private String proFid;
  private String proName;
  private int projectState;
  private String showPic;
  private int tagFlag;
  private List<String> tagList;
  
  public ZryuListItem() {}
  
  protected ZryuListItem(Parcel paramParcel)
  {
    this.proFid = paramParcel.readString();
    this.proCode = paramParcel.readString();
    this.proName = paramParcel.readString();
    this.proAddr = paramParcel.readString();
    this.minPrice = paramParcel.readString();
    this.maxPrice = paramParcel.readString();
    this.tagList = paramParcel.createStringArrayList();
    this.lng = paramParcel.readDouble();
    this.lat = paramParcel.readDouble();
    this.headPic = paramParcel.readString();
    this.showPic = paramParcel.readString();
    this.priceTag = paramParcel.readString();
    this.tagFlag = paramParcel.readInt();
    this.projectState = paramParcel.readInt();
    this.openingTime = paramParcel.readString();
    this.openingPeriod = paramParcel.readInt();
    this.isNewDetail = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getHeadPic()
  {
    return this.headPic;
  }
  
  public int getIsNewDetail()
  {
    return this.isNewDetail;
  }
  
  public double getLat()
  {
    return this.lat;
  }
  
  public double getLng()
  {
    return this.lng;
  }
  
  public String getMaxPrice()
  {
    return this.maxPrice;
  }
  
  public String getMinPrice()
  {
    return this.minPrice;
  }
  
  public int getOpeningPeriod()
  {
    return this.openingPeriod;
  }
  
  public String getOpeningTime()
  {
    return this.openingTime;
  }
  
  public String getPriceTag()
  {
    return this.priceTag;
  }
  
  public String getProAddr()
  {
    return this.proAddr;
  }
  
  public String getProCode()
  {
    return this.proCode;
  }
  
  public String getProFid()
  {
    return this.proFid;
  }
  
  public String getProName()
  {
    return this.proName;
  }
  
  public int getProjectState()
  {
    return this.projectState;
  }
  
  public String getShowPic()
  {
    return this.showPic;
  }
  
  public int getTagFlag()
  {
    return this.tagFlag;
  }
  
  public List<String> getTagList()
  {
    return this.tagList;
  }
  
  public void setHeadPic(String paramString)
  {
    this.headPic = paramString;
  }
  
  public void setIsNewDetail(int paramInt)
  {
    this.isNewDetail = paramInt;
  }
  
  public void setLat(double paramDouble)
  {
    this.lat = paramDouble;
  }
  
  public void setLng(double paramDouble)
  {
    this.lng = paramDouble;
  }
  
  public void setMaxPrice(String paramString)
  {
    this.maxPrice = paramString;
  }
  
  public void setMinPrice(String paramString)
  {
    this.minPrice = paramString;
  }
  
  public void setOpeningPeriod(int paramInt)
  {
    this.openingPeriod = paramInt;
  }
  
  public void setOpeningTime(String paramString)
  {
    this.openingTime = paramString;
  }
  
  public void setPriceTag(String paramString)
  {
    this.priceTag = paramString;
  }
  
  public void setProAddr(String paramString)
  {
    this.proAddr = paramString;
  }
  
  public void setProCode(String paramString)
  {
    this.proCode = paramString;
  }
  
  public void setProFid(String paramString)
  {
    this.proFid = paramString;
  }
  
  public void setProName(String paramString)
  {
    this.proName = paramString;
  }
  
  public void setProjectState(int paramInt)
  {
    this.projectState = paramInt;
  }
  
  public void setShowPic(String paramString)
  {
    this.showPic = paramString;
  }
  
  public void setTagFlag(int paramInt)
  {
    this.tagFlag = paramInt;
  }
  
  public void setTagList(List<String> paramList)
  {
    this.tagList = paramList;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.proFid);
    paramParcel.writeString(this.proCode);
    paramParcel.writeString(this.proName);
    paramParcel.writeString(this.proAddr);
    paramParcel.writeString(this.minPrice);
    paramParcel.writeString(this.maxPrice);
    paramParcel.writeStringList(this.tagList);
    paramParcel.writeDouble(this.lng);
    paramParcel.writeDouble(this.lat);
    paramParcel.writeString(this.headPic);
    paramParcel.writeString(this.showPic);
    paramParcel.writeString(this.priceTag);
    paramParcel.writeInt(this.tagFlag);
    paramParcel.writeInt(this.projectState);
    paramParcel.writeString(this.openingTime);
    paramParcel.writeInt(this.openingPeriod);
    paramParcel.writeInt(this.isNewDetail);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/model/ZryuListItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */