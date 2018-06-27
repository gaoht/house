package com.baidu.mapapi.search.district;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.SearchResult.ERRORNO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DistrictResult
  extends SearchResult
  implements Parcelable
{
  public static final Parcelable.Creator<DistrictResult> CREATOR = new a();
  private LatLng a = null;
  private List<List<LatLng>> b = null;
  private int c;
  private String d = null;
  
  DistrictResult() {}
  
  protected DistrictResult(Parcel paramParcel)
  {
    super(paramParcel);
    this.a = ((LatLng)paramParcel.readParcelable(LatLng.class.getClassLoader()));
    int j = paramParcel.readInt();
    if (j > 0)
    {
      this.b = new ArrayList();
      int i = 0;
      while (i < j)
      {
        this.b.add(paramParcel.createTypedArrayList(LatLng.CREATOR));
        i += 1;
      }
    }
    this.c = paramParcel.readInt();
    this.d = paramParcel.readString();
  }
  
  DistrictResult(SearchResult.ERRORNO paramERRORNO)
  {
    super(paramERRORNO);
  }
  
  void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  void a(LatLng paramLatLng)
  {
    this.a = paramLatLng;
  }
  
  void a(String paramString)
  {
    this.d = paramString;
  }
  
  void a(List<List<LatLng>> paramList)
  {
    this.b = paramList;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public LatLng getCenterPt()
  {
    return this.a;
  }
  
  public int getCityCode()
  {
    return this.c;
  }
  
  public String getCityName()
  {
    return this.d;
  }
  
  public List<List<LatLng>> getPolylines()
  {
    return this.b;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeParcelable(this.a, paramInt);
    if (this.b == null) {}
    for (paramInt = 0;; paramInt = this.b.size())
    {
      paramParcel.writeInt(paramInt);
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext()) {
        paramParcel.writeTypedList((List)localIterator.next());
      }
    }
    paramParcel.writeInt(this.c);
    paramParcel.writeString(this.d);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/search/district/DistrictResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */