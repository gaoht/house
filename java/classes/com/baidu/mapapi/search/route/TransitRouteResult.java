package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.SearchResult.ERRORNO;
import com.baidu.mapapi.search.core.TaxiInfo;
import java.util.ArrayList;
import java.util.List;

public final class TransitRouteResult
  extends SearchResult
  implements Parcelable
{
  public static final Parcelable.Creator<TransitRouteResult> CREATOR = new l();
  private TaxiInfo a;
  private List<TransitRouteLine> b;
  private SuggestAddrInfo c;
  
  TransitRouteResult() {}
  
  protected TransitRouteResult(Parcel paramParcel)
  {
    this.a = ((TaxiInfo)paramParcel.readParcelable(TaxiInfo.class.getClassLoader()));
    this.b = new ArrayList();
    paramParcel.readList(this.b, TransitRouteLine.class.getClassLoader());
    this.c = ((SuggestAddrInfo)paramParcel.readParcelable(SuggestAddrInfo.class.getClassLoader()));
  }
  
  TransitRouteResult(SearchResult.ERRORNO paramERRORNO)
  {
    super(paramERRORNO);
  }
  
  void a(TaxiInfo paramTaxiInfo)
  {
    this.a = paramTaxiInfo;
  }
  
  void a(SuggestAddrInfo paramSuggestAddrInfo)
  {
    this.c = paramSuggestAddrInfo;
  }
  
  void a(List<TransitRouteLine> paramList)
  {
    this.b = paramList;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public List<TransitRouteLine> getRouteLines()
  {
    return this.b;
  }
  
  public SuggestAddrInfo getSuggestAddrInfo()
  {
    return this.c;
  }
  
  public TaxiInfo getTaxiInfo()
  {
    return this.a;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.a, 1);
    paramParcel.writeList(this.b);
    paramParcel.writeParcelable(this.c, 1);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/search/route/TransitRouteResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */