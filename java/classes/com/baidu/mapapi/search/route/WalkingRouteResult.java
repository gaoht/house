package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.SearchResult.ERRORNO;
import com.baidu.mapapi.search.core.TaxiInfo;
import java.util.ArrayList;
import java.util.List;

public class WalkingRouteResult
  extends SearchResult
  implements Parcelable
{
  public static final Parcelable.Creator<WalkingRouteResult> CREATOR = new o();
  private List<WalkingRouteLine> a;
  private TaxiInfo b;
  private SuggestAddrInfo c;
  
  WalkingRouteResult() {}
  
  protected WalkingRouteResult(Parcel paramParcel)
  {
    this.a = new ArrayList();
    paramParcel.readList(this.a, WalkingRouteLine.class.getClassLoader());
    this.b = ((TaxiInfo)paramParcel.readParcelable(TaxiInfo.class.getClassLoader()));
    this.c = ((SuggestAddrInfo)paramParcel.readParcelable(SuggestAddrInfo.class.getClassLoader()));
  }
  
  WalkingRouteResult(SearchResult.ERRORNO paramERRORNO)
  {
    super(paramERRORNO);
  }
  
  void a(TaxiInfo paramTaxiInfo)
  {
    this.b = paramTaxiInfo;
  }
  
  void a(SuggestAddrInfo paramSuggestAddrInfo)
  {
    this.c = paramSuggestAddrInfo;
  }
  
  void a(List<WalkingRouteLine> paramList)
  {
    this.a = paramList;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public List<WalkingRouteLine> getRouteLines()
  {
    return this.a;
  }
  
  public SuggestAddrInfo getSuggestAddrInfo()
  {
    return this.c;
  }
  
  public TaxiInfo getTaxiInfo()
  {
    return this.b;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeList(this.a);
    paramParcel.writeParcelable(this.b, 1);
    paramParcel.writeParcelable(this.c, 1);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/search/route/WalkingRouteResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */