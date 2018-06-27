package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class d
  implements Parcelable.Creator<RouteNode>
{
  public RouteNode a(Parcel paramParcel)
  {
    return new RouteNode(paramParcel);
  }
  
  public RouteNode[] a(int paramInt)
  {
    return new RouteNode[paramInt];
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/search/core/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */