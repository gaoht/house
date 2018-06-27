package com.baidu.mapapi.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class a
  implements Parcelable.Creator<LatLng>
{
  public LatLng a(Parcel paramParcel)
  {
    return new LatLng(paramParcel);
  }
  
  public LatLng[] a(int paramInt)
  {
    return new LatLng[paramInt];
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/model/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */