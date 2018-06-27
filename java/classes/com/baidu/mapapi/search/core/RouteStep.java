package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.baidu.mapapi.model.LatLng;
import java.util.ArrayList;
import java.util.List;

public class RouteStep
  implements Parcelable
{
  public static final Parcelable.Creator<RouteStep> CREATOR = new e();
  int a;
  int b;
  protected List<LatLng> mWayPoints;
  
  protected RouteStep() {}
  
  protected RouteStep(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    this.b = paramParcel.readInt();
    this.mWayPoints = new ArrayList();
    paramParcel.readList(this.mWayPoints, LatLng.class.getClassLoader());
    if (this.mWayPoints.size() == 0) {
      this.mWayPoints = null;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getDistance()
  {
    return this.a;
  }
  
  public int getDuration()
  {
    return this.b;
  }
  
  public List<LatLng> getWayPoints()
  {
    return this.mWayPoints;
  }
  
  public void setDistance(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void setDuration(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void setWayPoints(List<LatLng> paramList)
  {
    this.mWayPoints = paramList;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeList(this.mWayPoints);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/search/core/RouteStep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */