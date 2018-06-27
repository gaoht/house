package com.baidu.mapapi.search.share;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class a
  implements Parcelable.Creator<ShareUrlResult>
{
  public ShareUrlResult a(Parcel paramParcel)
  {
    return new ShareUrlResult(paramParcel);
  }
  
  public ShareUrlResult[] a(int paramInt)
  {
    return new ShareUrlResult[paramInt];
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/search/share/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */