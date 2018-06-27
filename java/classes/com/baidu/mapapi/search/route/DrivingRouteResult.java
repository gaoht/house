package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.SearchResult.ERRORNO;
import com.baidu.mapapi.search.core.TaxiInfo;
import java.util.ArrayList;
import java.util.List;

public final class DrivingRouteResult
  extends SearchResult
  implements Parcelable
{
  public static final Parcelable.Creator<DrivingRouteResult> CREATOR = new f();
  private List<DrivingRouteLine> a;
  private List<TaxiInfo> b;
  private TaxiInfo c;
  private SuggestAddrInfo d;
  
  DrivingRouteResult() {}
  
  protected DrivingRouteResult(Parcel paramParcel)
  {
    this.a = new ArrayList();
    paramParcel.readTypedList(this.a, DrivingRouteLine.CREATOR);
    this.b = new ArrayList();
    paramParcel.readTypedList(this.b, TaxiInfo.CREATOR);
    this.d = ((SuggestAddrInfo)paramParcel.readParcelable(SuggestAddrInfo.class.getClassLoader()));
  }
  
  DrivingRouteResult(SearchResult.ERRORNO paramERRORNO)
  {
    super(paramERRORNO);
  }
  
  void a(SuggestAddrInfo paramSuggestAddrInfo)
  {
    this.d = paramSuggestAddrInfo;
  }
  
  void a(List<DrivingRouteLine> paramList)
  {
    this.a = paramList;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public List<DrivingRouteLine> getRouteLines()
  {
    return this.a;
  }
  
  public SuggestAddrInfo getSuggestAddrInfo()
  {
    return this.d;
  }
  
  @Deprecated
  public TaxiInfo getTaxiInfo()
  {
    return this.c;
  }
  
  public List<TaxiInfo> getTaxiInfos()
  {
    return this.b;
  }
  
  public void setTaxiInfos(List<TaxiInfo> paramList)
  {
    this.b = paramList;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeTypedList(this.a);
    paramParcel.writeTypedList(this.b);
    paramParcel.writeParcelable(this.d, 1);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/search/route/DrivingRouteResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */