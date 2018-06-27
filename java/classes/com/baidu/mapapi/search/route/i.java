package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class i
  implements Parcelable.Creator<SuggestAddrInfo>
{
  public SuggestAddrInfo a(Parcel paramParcel)
  {
    return new SuggestAddrInfo(paramParcel);
  }
  
  public SuggestAddrInfo[] a(int paramInt)
  {
    return new SuggestAddrInfo[paramInt];
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/search/route/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */