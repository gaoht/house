package com.baidu.mapapi.search.busline;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class a
  implements Parcelable.Creator<BusLineResult>
{
  public BusLineResult a(Parcel paramParcel)
  {
    return new BusLineResult(paramParcel);
  }
  
  public BusLineResult[] a(int paramInt)
  {
    return new BusLineResult[paramInt];
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/search/busline/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */