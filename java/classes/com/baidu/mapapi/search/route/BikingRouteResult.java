package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.SearchResult.ERRORNO;
import java.util.ArrayList;
import java.util.List;

public class BikingRouteResult
  extends SearchResult
  implements Parcelable
{
  public static final Parcelable.Creator<BikingRouteLine> CREATOR = new c();
  private List<BikingRouteLine> a;
  private SuggestAddrInfo b;
  
  BikingRouteResult() {}
  
  protected BikingRouteResult(Parcel paramParcel)
  {
    this.a = new ArrayList();
    paramParcel.readList(this.a, BikingRouteLine.class.getClassLoader());
    this.b = ((SuggestAddrInfo)paramParcel.readParcelable(SuggestAddrInfo.class.getClassLoader()));
  }
  
  BikingRouteResult(SearchResult.ERRORNO paramERRORNO)
  {
    super(paramERRORNO);
  }
  
  void a(SuggestAddrInfo paramSuggestAddrInfo)
  {
    this.b = paramSuggestAddrInfo;
  }
  
  void a(List<BikingRouteLine> paramList)
  {
    this.a = paramList;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public List<BikingRouteLine> getRouteLines()
  {
    return this.a;
  }
  
  public SuggestAddrInfo getSuggestAddrInfo()
  {
    return this.b;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeList(this.a);
    paramParcel.writeParcelable(this.b, 1);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/search/route/BikingRouteResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */