package com.baidu.mapapi.map;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class e
  implements Parcelable.Creator<BaiduMapOptions>
{
  public BaiduMapOptions a(Parcel paramParcel)
  {
    return new BaiduMapOptions(paramParcel);
  }
  
  public BaiduMapOptions[] a(int paramInt)
  {
    return new BaiduMapOptions[paramInt];
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/map/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */