package com.baidu.mapapi.search.sug;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.SearchResult.ERRORNO;
import java.util.ArrayList;
import java.util.List;

public class SuggestionResult
  extends SearchResult
  implements Parcelable
{
  public static final Parcelable.Creator<SuggestionResult> CREATOR = new a();
  private ArrayList<SuggestionInfo> a;
  
  public SuggestionResult() {}
  
  protected SuggestionResult(Parcel paramParcel)
  {
    this.a = paramParcel.readArrayList(SuggestionInfo.class.getClassLoader());
  }
  
  SuggestionResult(SearchResult.ERRORNO paramERRORNO)
  {
    super(paramERRORNO);
  }
  
  void a(ArrayList<SuggestionInfo> paramArrayList)
  {
    this.a = paramArrayList;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public List<SuggestionInfo> getAllSuggestions()
  {
    return this.a;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeList(this.a);
  }
  
  public static class SuggestionInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<SuggestionInfo> CREATOR = new b();
    public String city;
    public String district;
    public String key;
    public LatLng pt;
    public String uid;
    
    protected SuggestionInfo() {}
    
    protected SuggestionInfo(Parcel paramParcel)
    {
      this.key = paramParcel.readString();
      this.city = paramParcel.readString();
      this.district = paramParcel.readString();
      this.pt = ((LatLng)paramParcel.readValue(LatLng.class.getClassLoader()));
      this.uid = paramParcel.readString();
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.key);
      paramParcel.writeString(this.city);
      paramParcel.writeString(this.district);
      paramParcel.writeValue(this.pt);
      paramParcel.writeString(this.uid);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/search/sug/SuggestionResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */