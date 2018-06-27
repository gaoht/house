package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class m
  implements Parcelable.Creator<WalkingRouteLine>
{
  public WalkingRouteLine a(Parcel paramParcel)
  {
    return new WalkingRouteLine(paramParcel);
  }
  
  public WalkingRouteLine[] a(int paramInt)
  {
    return new WalkingRouteLine[paramInt];
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/search/route/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */