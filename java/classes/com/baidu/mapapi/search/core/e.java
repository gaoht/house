package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class e
  implements Parcelable.Creator<RouteStep>
{
  public RouteStep a(Parcel paramParcel)
  {
    return new RouteStep(paramParcel);
  }
  
  public RouteStep[] a(int paramInt)
  {
    return new RouteStep[paramInt];
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/search/core/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */