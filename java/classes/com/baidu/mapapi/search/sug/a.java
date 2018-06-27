package com.baidu.mapapi.search.sug;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class a
  implements Parcelable.Creator<SuggestionResult>
{
  public SuggestionResult a(Parcel paramParcel)
  {
    return new SuggestionResult(paramParcel);
  }
  
  public SuggestionResult[] a(int paramInt)
  {
    return new SuggestionResult[paramInt];
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/search/sug/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */