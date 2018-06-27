package com.ziroom.ziroomcustomer.ziroomapartment.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ZryuCity
  implements Parcelable
{
  public static final Parcelable.Creator<ZryuCity> CREATOR = new Parcelable.Creator()
  {
    public ZryuCity createFromParcel(Parcel paramAnonymousParcel)
    {
      return new ZryuCity(paramAnonymousParcel);
    }
    
    public ZryuCity[] newArray(int paramAnonymousInt)
    {
      return new ZryuCity[paramAnonymousInt];
    }
  };
  private double centerLat;
  private double centerLon;
  public String cityCode;
  private String cityName;
  
  public ZryuCity() {}
  
  protected ZryuCity(Parcel paramParcel)
  {
    this.cityCode = paramParcel.readString();
    this.cityName = paramParcel.readString();
    this.centerLon = paramParcel.readDouble();
    this.centerLat = paramParcel.readDouble();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public double getCenterLat()
  {
    return this.centerLat;
  }
  
  public double getCenterLon()
  {
    return this.centerLon;
  }
  
  public String getCityCode()
  {
    return this.cityCode;
  }
  
  public String getCityName()
  {
    return this.cityName;
  }
  
  public void setCenterLat(double paramDouble)
  {
    this.centerLat = paramDouble;
  }
  
  public void setCenterLon(double paramDouble)
  {
    this.centerLon = paramDouble;
  }
  
  public void setCityCode(String paramString)
  {
    this.cityCode = paramString;
  }
  
  public void setCityName(String paramString)
  {
    this.cityName = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.cityCode);
    paramParcel.writeString(this.cityName);
    paramParcel.writeDouble(this.centerLon);
    paramParcel.writeDouble(this.centerLat);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/model/ZryuCity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */