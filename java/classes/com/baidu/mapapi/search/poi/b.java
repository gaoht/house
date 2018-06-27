package com.baidu.mapapi.search.poi;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class b
  implements Parcelable.Creator<PoiIndoorResult>
{
  public PoiIndoorResult a(Parcel paramParcel)
  {
    return new PoiIndoorResult(paramParcel);
  }
  
  public PoiIndoorResult[] a(int paramInt)
  {
    return new PoiIndoorResult[paramInt];
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/search/poi/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */