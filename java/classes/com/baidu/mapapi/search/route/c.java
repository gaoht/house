package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class c
  implements Parcelable.Creator<BikingRouteLine>
{
  public BikingRouteLine a(Parcel paramParcel)
  {
    return new BikingRouteLine(paramParcel);
  }
  
  public BikingRouteLine[] a(int paramInt)
  {
    return new BikingRouteLine[paramInt];
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/search/route/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */