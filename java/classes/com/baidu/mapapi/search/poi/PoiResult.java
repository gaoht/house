package com.baidu.mapapi.search.poi;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.baidu.mapapi.search.core.CityInfo;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.SearchResult.ERRORNO;
import java.util.List;

public class PoiResult
  extends SearchResult
  implements Parcelable
{
  public static final Parcelable.Creator<PoiResult> CREATOR = new c();
  private int a = 0;
  private int b = 0;
  private int c = 0;
  private int d = 0;
  private List<PoiInfo> e;
  private List<CityInfo> f;
  private List<PoiAddrInfo> g;
  private boolean h = false;
  
  PoiResult() {}
  
  PoiResult(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    this.b = paramParcel.readInt();
    this.c = paramParcel.readInt();
    this.d = paramParcel.readInt();
    this.e = paramParcel.readArrayList(PoiInfo.class.getClassLoader());
    this.f = paramParcel.readArrayList(CityInfo.class.getClassLoader());
  }
  
  PoiResult(SearchResult.ERRORNO paramERRORNO)
  {
    super(paramERRORNO);
  }
  
  void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  void a(List<PoiInfo> paramList)
  {
    this.e = paramList;
  }
  
  void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  void b(int paramInt)
  {
    this.b = paramInt;
  }
  
  void b(List<PoiAddrInfo> paramList)
  {
    this.g = paramList;
  }
  
  void c(int paramInt)
  {
    this.c = paramInt;
  }
  
  void c(List<CityInfo> paramList)
  {
    this.f = paramList;
  }
  
  void d(int paramInt)
  {
    this.d = paramInt;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public List<PoiAddrInfo> getAllAddr()
  {
    return this.g;
  }
  
  public List<PoiInfo> getAllPoi()
  {
    return this.e;
  }
  
  public int getCurrentPageCapacity()
  {
    return this.c;
  }
  
  public int getCurrentPageNum()
  {
    return this.a;
  }
  
  public List<CityInfo> getSuggestCityList()
  {
    return this.f;
  }
  
  public int getTotalPageNum()
  {
    return this.b;
  }
  
  public int getTotalPoiNum()
  {
    return this.d;
  }
  
  public boolean isHasAddrInfo()
  {
    return this.h;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeInt(this.d);
    paramParcel.writeList(this.e);
    paramParcel.writeList(this.f);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/search/poi/PoiResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */