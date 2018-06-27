package com.baidu.mapapi.search.geocode;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class c
  implements Parcelable.Creator<ReverseGeoCodeResult>
{
  public ReverseGeoCodeResult a(Parcel paramParcel)
  {
    return new ReverseGeoCodeResult(paramParcel);
  }
  
  public ReverseGeoCodeResult[] a(int paramInt)
  {
    return new ReverseGeoCodeResult[paramInt];
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/search/geocode/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */