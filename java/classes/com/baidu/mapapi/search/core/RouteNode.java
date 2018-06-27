package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.baidu.mapapi.model.LatLng;

public class RouteNode
  implements Parcelable
{
  public static final Parcelable.Creator<RouteNode> CREATOR = new d();
  private String a;
  private LatLng b;
  private String c;
  
  public RouteNode() {}
  
  protected RouteNode(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = ((LatLng)paramParcel.readValue(LatLng.class.getClassLoader()));
    this.c = paramParcel.readString();
  }
  
  public static RouteNode location(LatLng paramLatLng)
  {
    RouteNode localRouteNode = new RouteNode();
    localRouteNode.setLocation(paramLatLng);
    return localRouteNode;
  }
  
  public static RouteNode titleAndLocation(String paramString, LatLng paramLatLng)
  {
    RouteNode localRouteNode = new RouteNode();
    localRouteNode.setTitle(paramString);
    localRouteNode.setLocation(paramLatLng);
    return localRouteNode;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public LatLng getLocation()
  {
    return this.b;
  }
  
  public String getTitle()
  {
    return this.a;
  }
  
  public String getUid()
  {
    return this.c;
  }
  
  public void setLocation(LatLng paramLatLng)
  {
    this.b = paramLatLng;
  }
  
  public void setTitle(String paramString)
  {
    this.a = paramString;
  }
  
  public void setUid(String paramString)
  {
    this.c = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeValue(this.b);
    paramParcel.writeString(this.c);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/search/core/RouteNode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */