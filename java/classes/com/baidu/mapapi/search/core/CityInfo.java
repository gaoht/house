package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class CityInfo
  implements Parcelable
{
  public static final Parcelable.Creator<CityInfo> CREATOR = new a();
  public String city;
  public int num;
  
  public CityInfo() {}
  
  protected CityInfo(Parcel paramParcel)
  {
    this.city = paramParcel.readString();
    this.num = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.city);
    paramParcel.writeInt(this.num);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/search/core/CityInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */