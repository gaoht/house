package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class f
  implements Parcelable.Creator<SearchResult>
{
  public SearchResult a(Parcel paramParcel)
  {
    return new SearchResult(paramParcel);
  }
  
  public SearchResult[] a(int paramInt)
  {
    return new SearchResult[paramInt];
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/search/core/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */