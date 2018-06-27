package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class l
  implements Parcelable.Creator<TransitRouteResult>
{
  public TransitRouteResult a(Parcel paramParcel)
  {
    return new TransitRouteResult(paramParcel);
  }
  
  public TransitRouteResult[] a(int paramInt)
  {
    return new TransitRouteResult[paramInt];
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/search/route/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */