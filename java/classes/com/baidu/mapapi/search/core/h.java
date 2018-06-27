package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class h
  implements Parcelable.Creator<TaxiInfo>
{
  public TaxiInfo a(Parcel paramParcel)
  {
    return new TaxiInfo(paramParcel);
  }
  
  public TaxiInfo[] a(int paramInt)
  {
    return new TaxiInfo[paramInt];
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/search/core/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */