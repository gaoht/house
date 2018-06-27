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
import com.baidu.mapapi.search.core.TaxiInfo;
import com.baidu.mapapi.search.core.VehicleInfo;
import java.util.List;

public final class TransitRouteLine
  extends RouteLine<TransitStep>
  implements Parcelable
{
  public static final Parcelable.Creator<TransitRouteLine> CREATOR = new j();
  private TaxiInfo b;
  
  TransitRouteLine() {}
  
  protected TransitRouteLine(Parcel paramParcel)
  {
    super(paramParcel);
    this.b = ((TaxiInfo)paramParcel.readParcelable(TaxiInfo.class.getClassLoader()));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  @Deprecated
  public TaxiInfo getTaxitInfo()
  {
    return this.b;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.setType(RouteLine.TYPE.TRANSITSTEP);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeParcelable(this.b, 1);
  }
  
  public static class TransitStep
    extends RouteStep
    implements Parcelable
  {
    public static final Parcelable.Creator<TransitStep> CREATOR = new k();
    private VehicleInfo c;
    private RouteNode d;
    private RouteNode e;
    private TransitRouteStepType f;
    private String g;
    private String h;
    
    public TransitStep() {}
    
    protected TransitStep(Parcel paramParcel)
    {
      super();
      this.c = ((VehicleInfo)paramParcel.readParcelable(VehicleInfo.class.getClassLoader()));
      this.d = ((RouteNode)paramParcel.readParcelable(RouteNode.class.getClassLoader()));
      this.e = ((RouteNode)paramParcel.readParcelable(RouteNode.class.getClassLoader()));
      int i = paramParcel.readInt();
      if (i == -1) {}
      for (TransitRouteStepType localTransitRouteStepType = null;; localTransitRouteStepType = TransitRouteStepType.values()[i])
      {
        this.f = localTransitRouteStepType;
        this.g = paramParcel.readString();
        this.h = paramParcel.readString();
        return;
      }
    }
    
    void a(RouteNode paramRouteNode)
    {
      this.d = paramRouteNode;
    }
    
    void a(VehicleInfo paramVehicleInfo)
    {
      this.c = paramVehicleInfo;
    }
    
    void a(TransitRouteStepType paramTransitRouteStepType)
    {
      this.f = paramTransitRouteStepType;
    }
    
    void a(String paramString)
    {
      this.g = paramString;
    }
    
    void b(RouteNode paramRouteNode)
    {
      this.e = paramRouteNode;
    }
    
    void b(String paramString)
    {
      this.h = paramString;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public RouteNode getEntrance()
    {
      return this.d;
    }
    
    public RouteNode getExit()
    {
      return this.e;
    }
    
    public String getInstructions()
    {
      return this.g;
    }
    
    public TransitRouteStepType getStepType()
    {
      return this.f;
    }
    
    public VehicleInfo getVehicleInfo()
    {
      return this.c;
    }
    
    public List<LatLng> getWayPoints()
    {
      if (this.mWayPoints == null) {
        this.mWayPoints = CoordUtil.decodeLocationList(this.h);
      }
      return this.mWayPoints;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeParcelable(this.c, 1);
      paramParcel.writeParcelable(this.d, 1);
      paramParcel.writeParcelable(this.e, 1);
      if (this.f == null) {}
      for (paramInt = -1;; paramInt = this.f.ordinal())
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.g);
        paramParcel.writeString(this.h);
        return;
      }
    }
    
    public static enum TransitRouteStepType
    {
      BUSLINE,  SUBWAY,  WAKLING;
      
      private TransitRouteStepType() {}
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/search/route/TransitRouteLine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */