package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.baidu.mapapi.search.route.DrivingRouteLine.DrivingStep;
import com.baidu.mapapi.search.route.TransitRouteLine.TransitStep;
import com.baidu.mapapi.search.route.WalkingRouteLine.WalkingStep;
import java.util.List;

public class RouteLine<T extends RouteStep>
  implements Parcelable
{
  public static final Parcelable.Creator<RouteLine> CREATOR = new c();
  TYPE a;
  private RouteNode b;
  private RouteNode c;
  private String d;
  private List<T> e;
  private int f;
  private int g;
  
  protected RouteLine() {}
  
  protected RouteLine(Parcel paramParcel)
  {
    int i = paramParcel.readInt();
    this.b = ((RouteNode)paramParcel.readValue(RouteNode.class.getClassLoader()));
    this.c = ((RouteNode)paramParcel.readValue(RouteNode.class.getClassLoader()));
    this.d = paramParcel.readString();
    switch (i)
    {
    }
    for (;;)
    {
      this.f = paramParcel.readInt();
      this.g = paramParcel.readInt();
      return;
      this.e = paramParcel.createTypedArrayList(DrivingRouteLine.DrivingStep.CREATOR);
      continue;
      this.e = paramParcel.createTypedArrayList(TransitRouteLine.TransitStep.CREATOR);
      continue;
      this.e = paramParcel.createTypedArrayList(WalkingRouteLine.WalkingStep.CREATOR);
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public List<T> getAllStep()
  {
    return this.e;
  }
  
  public int getDistance()
  {
    return this.f;
  }
  
  public int getDuration()
  {
    return this.g;
  }
  
  public RouteNode getStarting()
  {
    return this.b;
  }
  
  public RouteNode getTerminal()
  {
    return this.c;
  }
  
  public String getTitle()
  {
    return this.d;
  }
  
  protected TYPE getType()
  {
    return this.a;
  }
  
  public void setDistance(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void setDuration(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void setStarting(RouteNode paramRouteNode)
  {
    this.b = paramRouteNode;
  }
  
  public void setSteps(List<T> paramList)
  {
    this.e = paramList;
  }
  
  public void setTerminal(RouteNode paramRouteNode)
  {
    this.c = paramRouteNode;
  }
  
  public void setTitle(String paramString)
  {
    this.d = paramString;
  }
  
  protected void setType(TYPE paramTYPE)
  {
    this.a = paramTYPE;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(TYPE.a(this.a));
    paramParcel.writeValue(this.b);
    paramParcel.writeValue(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeTypedList(this.e);
    paramParcel.writeInt(this.f);
    paramParcel.writeInt(this.g);
  }
  
  protected static enum TYPE
  {
    private int a;
    
    private TYPE(int paramInt)
    {
      this.a = paramInt;
    }
    
    private int a()
    {
      return this.a;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/search/core/RouteLine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */