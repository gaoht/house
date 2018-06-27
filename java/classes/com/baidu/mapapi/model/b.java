package com.baidu.mapapi.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class b
  implements Parcelable.Creator<LatLngBounds>
{
  public LatLngBounds a(Parcel paramParcel)
  {
    return new LatLngBounds(paramParcel);
  }
  
  public LatLngBounds[] a(int paramInt)
  {
    return new LatLngBounds[paramInt];
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/model/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */