package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class d
  implements Parcelable.Creator<DrivingRouteLine>
{
  public DrivingRouteLine a(Parcel paramParcel)
  {
    return new DrivingRouteLine(paramParcel);
  }
  
  public DrivingRouteLine[] a(int paramInt)
  {
    return new DrivingRouteLine[paramInt];
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/search/route/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */