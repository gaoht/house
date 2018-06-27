package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class c
  implements Parcelable.Creator<RouteLine>
{
  public RouteLine a(Parcel paramParcel)
  {
    return new RouteLine(paramParcel);
  }
  
  public RouteLine[] a(int paramInt)
  {
    return new RouteLine[paramInt];
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/search/core/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */