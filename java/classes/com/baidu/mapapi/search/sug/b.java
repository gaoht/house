package com.baidu.mapapi.search.sug;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class b
  implements Parcelable.Creator<SuggestionResult.SuggestionInfo>
{
  public SuggestionResult.SuggestionInfo a(Parcel paramParcel)
  {
    return new SuggestionResult.SuggestionInfo(paramParcel);
  }
  
  public SuggestionResult.SuggestionInfo[] a(int paramInt)
  {
    return new SuggestionResult.SuggestionInfo[paramInt];
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/search/sug/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */