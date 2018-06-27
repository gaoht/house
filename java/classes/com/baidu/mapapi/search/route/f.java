package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class f
  implements Parcelable.Creator<DrivingRouteResult>
{
  public DrivingRouteResult a(Parcel paramParcel)
  {
    return new DrivingRouteResult(paramParcel);
  }
  
  public DrivingRouteResult[] a(int paramInt)
  {
    return new DrivingRouteResult[paramInt];
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/search/route/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */