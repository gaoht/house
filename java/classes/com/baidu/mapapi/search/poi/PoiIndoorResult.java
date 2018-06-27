package com.baidu.mapapi.search.poi;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.SearchResult.ERRORNO;
import java.util.List;

public class PoiIndoorResult
  extends SearchResult
  implements Parcelable
{
  public static final Parcelable.Creator<PoiIndoorResult> CREATOR = new b();
  int a;
  int b;
  private List<PoiIndoorInfo> c;
  
  PoiIndoorResult() {}
  
  protected PoiIndoorResult(Parcel paramParcel)
  {
    super(paramParcel);
    this.a = paramParcel.readInt();
    this.b = paramParcel.readInt();
  }
  
  public PoiIndoorResult(SearchResult.ERRORNO paramERRORNO)
  {
    super(paramERRORNO);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getPageNum()
  {
    return this.b;
  }
  
  public int getPoiNum()
  {
    return this.a;
  }
  
  public List<PoiIndoorInfo> getmArrayPoiInfo()
  {
    return this.c;
  }
  
  public void setPageNum(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void setPoiNum(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void setmArrayPoiInfo(List<PoiIndoorInfo> paramList)
  {
    this.c = paramList;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.a);
    paramParcel.writeInt(this.b);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/search/poi/PoiIndoorResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */