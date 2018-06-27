package com.baidu.mapapi.search.geocode;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.SearchResult.ERRORNO;

public class GeoCodeResult
  extends SearchResult
  implements Parcelable
{
  public static final Parcelable.Creator<GeoCodeResult> CREATOR = new a();
  private LatLng a;
  private String b;
  
  GeoCodeResult() {}
  
  protected GeoCodeResult(Parcel paramParcel)
  {
    this.a = ((LatLng)paramParcel.readValue(LatLng.class.getClassLoader()));
    this.b = paramParcel.readString();
  }
  
  GeoCodeResult(SearchResult.ERRORNO paramERRORNO)
  {
    super(paramERRORNO);
  }
  
  void a(LatLng paramLatLng)
  {
    this.a = paramLatLng;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getAddress()
  {
    return this.b;
  }
  
  public LatLng getLocation()
  {
    return this.a;
  }
  
  public void setAddress(String paramString)
  {
    this.b = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeValue(this.a);
    paramParcel.writeString(this.b);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/search/geocode/GeoCodeResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */