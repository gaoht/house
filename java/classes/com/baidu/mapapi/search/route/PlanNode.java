package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.baidu.mapapi.model.LatLng;

public class PlanNode
  implements Parcelable
{
  public static final Parcelable.Creator<PlanNode> CREATOR = new g();
  private LatLng a = null;
  private String b = null;
  private String c = null;
  
  protected PlanNode(Parcel paramParcel)
  {
    this.a = ((LatLng)paramParcel.readValue(LatLng.class.getClassLoader()));
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
  }
  
  PlanNode(LatLng paramLatLng, String paramString1, String paramString2)
  {
    this.a = paramLatLng;
    this.b = paramString1;
    this.c = paramString2;
  }
  
  public static PlanNode withCityCodeAndPlaceName(int paramInt, String paramString)
  {
    return new PlanNode(null, String.valueOf(paramInt), paramString);
  }
  
  public static PlanNode withCityNameAndPlaceName(String paramString1, String paramString2)
  {
    return new PlanNode(null, paramString1, paramString2);
  }
  
  public static PlanNode withLocation(LatLng paramLatLng)
  {
    return new PlanNode(paramLatLng, null, null);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getCity()
  {
    return this.b;
  }
  
  public LatLng getLocation()
  {
    return this.a;
  }
  
  public String getName()
  {
    return this.c;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeValue(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/search/route/PlanNode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */