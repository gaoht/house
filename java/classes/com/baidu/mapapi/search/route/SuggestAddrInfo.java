package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.baidu.mapapi.search.core.CityInfo;
import com.baidu.mapapi.search.core.PoiInfo;
import java.util.List;

public class SuggestAddrInfo
  implements Parcelable
{
  public static final Parcelable.Creator<SuggestAddrInfo> CREATOR = new i();
  private List<PoiInfo> a;
  private List<PoiInfo> b;
  private List<List<PoiInfo>> c;
  private List<CityInfo> d;
  private List<CityInfo> e;
  private List<List<CityInfo>> f;
  
  protected SuggestAddrInfo() {}
  
  SuggestAddrInfo(Parcel paramParcel)
  {
    this.a = paramParcel.readArrayList(PoiInfo.class.getClassLoader());
    this.b = paramParcel.readArrayList(PoiInfo.class.getClassLoader());
    this.c = paramParcel.readArrayList(PoiInfo.class.getClassLoader());
    this.d = paramParcel.readArrayList(CityInfo.class.getClassLoader());
    this.e = paramParcel.readArrayList(CityInfo.class.getClassLoader());
    this.f = paramParcel.readArrayList(CityInfo.class.getClassLoader());
  }
  
  void a(List<PoiInfo> paramList)
  {
    this.a = paramList;
  }
  
  void b(List<PoiInfo> paramList)
  {
    this.b = paramList;
  }
  
  void c(List<List<PoiInfo>> paramList)
  {
    this.c = paramList;
  }
  
  void d(List<CityInfo> paramList)
  {
    this.d = paramList;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  void e(List<CityInfo> paramList)
  {
    this.e = paramList;
  }
  
  void f(List<List<CityInfo>> paramList)
  {
    this.f = paramList;
  }
  
  public List<CityInfo> getSuggestEndCity()
  {
    return this.e;
  }
  
  public List<PoiInfo> getSuggestEndNode()
  {
    return this.b;
  }
  
  public List<CityInfo> getSuggestStartCity()
  {
    return this.d;
  }
  
  public List<PoiInfo> getSuggestStartNode()
  {
    return this.a;
  }
  
  public List<List<CityInfo>> getSuggestWpCity()
  {
    return this.f;
  }
  
  public List<List<PoiInfo>> getSuggestWpNode()
  {
    return this.c;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeList(this.a);
    paramParcel.writeList(this.b);
    paramParcel.writeList(this.c);
    paramParcel.writeList(this.d);
    paramParcel.writeList(this.e);
    paramParcel.writeList(this.f);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/search/route/SuggestAddrInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */