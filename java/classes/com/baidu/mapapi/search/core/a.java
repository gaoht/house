package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class a
  implements Parcelable.Creator<CityInfo>
{
  public CityInfo a(Parcel paramParcel)
  {
    return new CityInfo(paramParcel);
  }
  
  public CityInfo[] a(int paramInt)
  {
    return new CityInfo[paramInt];
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/search/core/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */