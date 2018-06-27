package com.baidu.mapapi.search.district;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class a
  implements Parcelable.Creator<DistrictResult>
{
  public DistrictResult a(Parcel paramParcel)
  {
    return new DistrictResult(paramParcel);
  }
  
  public DistrictResult[] a(int paramInt)
  {
    return new DistrictResult[paramInt];
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/search/district/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */