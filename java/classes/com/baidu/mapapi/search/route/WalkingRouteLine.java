package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.RouteLine;
import com.baidu.mapapi.search.core.RouteLine.TYPE;
import com.baidu.mapapi.search.core.RouteNode;
import com.baidu.mapapi.search.core.RouteStep;
import java.util.List;

public class WalkingRouteLine
  extends RouteLine<WalkingStep>
  implements Parcelable
{
  public static final Parcelable.Creator<WalkingRouteLine> CREATOR = new m();
  
  WalkingRouteLine() {}
  
  protected WalkingRouteLine(Parcel paramParcel)
  {
    super(paramParcel);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public List<WalkingStep> getAllStep()
  {
    return super.getAllStep();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.setType(RouteLine.TYPE.WALKSTEP);
    super.writeToParcel(paramParcel, 1);
  }
  
  public static class WalkingStep
    extends RouteStep
    implements Parcelable
  {
    public static final Parcelable.Creator<WalkingStep> CREATOR = new n();
    private int c;
    private RouteNode d;
    private RouteNode e;
    private String f;
    private String g;
    private String h;
    private String i;
    
    public WalkingStep() {}
    
    protected WalkingStep(Parcel paramParcel)
    {
      super();
      this.c = paramParcel.readInt();
      this.d = ((RouteNode)paramParcel.readParcelable(RouteNode.class.getClassLoader()));
      this.e = ((RouteNode)paramParcel.readParcelable(RouteNode.class.getClassLoader()));
      this.f = paramParcel.readString();
      this.g = paramParcel.readString();
      this.h = paramParcel.readString();
      this.i = paramParcel.readString();
    }
    
    void a(int paramInt)
    {
      this.c = paramInt;
    }
    
    void a(RouteNode paramRouteNode)
    {
      this.d = paramRouteNode;
    }
    
    void a(String paramString)
    {
      this.f = paramString;
    }
    
    void b(RouteNode paramRouteNode)
    {
      this.e = paramRouteNode;
    }
    
    void b(String paramString)
    {
      this.g = paramString;
    }
    
    void c(String paramString)
    {
      this.h = paramString;
    }
    
    void d(String paramString)
    {
      this.i = paramString;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public int getDirection()
    {
      return this.c;
    }
    
    public RouteNode getEntrance()
    {
      return this.d;
    }
    
    public String getEntranceInstructions()
    {
      return this.g;
    }
    
    public RouteNode getExit()
    {
      return this.e;
    }
    
    public String getExitInstructions()
    {
      return this.h;
    }
    
    public String getInstructions()
    {
      return this.i;
    }
    
    public List<LatLng> getWayPoints()
    {
      if (this.mWayPoints == null) {
        this.mWayPoints = CoordUtil.decodeLocationList(this.f);
      }
      return this.mWayPoints;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, 1);
      paramParcel.writeInt(this.c);
      paramParcel.writeParcelable(this.d, 1);
      paramParcel.writeParcelable(this.e, 1);
      paramParcel.writeString(this.f);
      paramParcel.writeString(this.g);
      paramParcel.writeString(this.h);
      paramParcel.writeString(this.i);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/search/route/WalkingRouteLine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */