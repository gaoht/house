package com.baidu.mapapi.search.geocode;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class a
  implements Parcelable.Creator<GeoCodeResult>
{
  public GeoCodeResult a(Parcel paramParcel)
  {
    return new GeoCodeResult(paramParcel);
  }
  
  public GeoCodeResult[] a(int paramInt)
  {
    return new GeoCodeResult[paramInt];
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/search/geocode/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */