package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class i
  implements Parcelable.Creator<VehicleInfo>
{
  public VehicleInfo a(Parcel paramParcel)
  {
    return new VehicleInfo(paramParcel);
  }
  
  public VehicleInfo[] a(int paramInt)
  {
    return new VehicleInfo[paramInt];
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/search/core/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */