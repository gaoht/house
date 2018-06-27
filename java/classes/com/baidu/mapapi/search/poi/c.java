package com.baidu.mapapi.search.poi;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class c
  implements Parcelable.Creator<PoiResult>
{
  public PoiResult a(Parcel paramParcel)
  {
    return new PoiResult(paramParcel);
  }
  
  public PoiResult[] a(int paramInt)
  {
    return new PoiResult[paramInt];
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/search/poi/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */