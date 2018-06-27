package com.baidu.mapapi.search.geocode;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class d
  implements Parcelable.Creator<ReverseGeoCodeResult.AddressComponent>
{
  public ReverseGeoCodeResult.AddressComponent a(Parcel paramParcel)
  {
    return new ReverseGeoCodeResult.AddressComponent(paramParcel);
  }
  
  public ReverseGeoCodeResult.AddressComponent[] a(int paramInt)
  {
    return new ReverseGeoCodeResult.AddressComponent[paramInt];
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/search/geocode/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */