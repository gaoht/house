package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class j
  implements Parcelable.Creator<TransitRouteLine>
{
  public TransitRouteLine a(Parcel paramParcel)
  {
    return new TransitRouteLine(paramParcel);
  }
  
  public TransitRouteLine[] a(int paramInt)
  {
    return new TransitRouteLine[paramInt];
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/search/route/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */