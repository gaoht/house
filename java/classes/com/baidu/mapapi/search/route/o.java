package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class o
  implements Parcelable.Creator<WalkingRouteResult>
{
  public WalkingRouteResult a(Parcel paramParcel)
  {
    return new WalkingRouteResult(paramParcel);
  }
  
  public WalkingRouteResult[] a(int paramInt)
  {
    return new WalkingRouteResult[paramInt];
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/search/route/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */