package com.baidu.mapapi.map;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class h
  implements Parcelable.Creator<MapStatus>
{
  public MapStatus a(Parcel paramParcel)
  {
    return new MapStatus(paramParcel);
  }
  
  public MapStatus[] a(int paramInt)
  {
    return new MapStatus[paramInt];
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/map/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */