package com.baidu.mapapi.search.poi;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class a
  implements Parcelable.Creator<PoiDetailResult>
{
  public PoiDetailResult a(Parcel paramParcel)
  {
    return new PoiDetailResult(paramParcel);
  }
  
  public PoiDetailResult[] a(int paramInt)
  {
    return new PoiDetailResult[paramInt];
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/search/poi/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */