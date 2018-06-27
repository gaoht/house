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
import java.util.ArrayList;
import java.util.List;

public class DrivingRouteLine
  extends RouteLine<DrivingStep>
  implements Parcelable
{
  public static final Parcelable.Creator<DrivingRouteLine> CREATOR = new d();
  private boolean b;
  private List<RouteNode> c;
  private int d;
  private int e;
  
  DrivingRouteLine() {}
  
  protected DrivingRouteLine(Parcel paramParcel)
  {
    super(paramParcel);
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.b = bool;
      this.c = new ArrayList();
      paramParcel.readList(this.c, RouteNode.class.getClassLoader());
      this.d = paramParcel.readInt();
      this.e = paramParcel.readInt();
      return;
    }
  }
  
  void a(List<RouteNode> paramList)
  {
    this.c = paramList;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getCongestionDistance()
  {
    return this.d;
  }
  
  public int getLightNum()
  {
    return this.e;
  }
  
  public List<RouteNode> getWayPoints()
  {
    return this.c;
  }
  
  @Deprecated
  public boolean isSupportTraffic()
  {
    return this.b;
  }
  
  public void setCongestionDistance(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setLightNum(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.setType(RouteLine.TYPE.DRIVESTEP);
    super.writeToParcel(paramParcel, paramInt);
    if (this.b) {}
    for (byte b1 = 1;; b1 = 0)
    {
      paramParcel.writeByte(b1);
      paramParcel.writeList(this.c);
      paramParcel.writeInt(this.d);
      paramParcel.writeInt(this.e);
      return;
    }
  }
  
  public static class DrivingStep
    extends RouteStep
    implements Parcelable
  {
    public static final Parcelable.Creator<DrivingStep> CREATOR = new e();
    List<LatLng> c;
    int[] d;
    private int e;
    private RouteNode f;
    private RouteNode g;
    private String h;
    private String i;
    private String j;
    private String k;
    private int l;
    
    public DrivingStep() {}
    
    protected DrivingStep(Parcel paramParcel)
    {
      super();
      this.e = paramParcel.readInt();
      this.f = ((RouteNode)paramParcel.readParcelable(RouteNode.class.getClassLoader()));
      this.g = ((RouteNode)paramParcel.readParcelable(RouteNode.class.getClassLoader()));
      this.h = paramParcel.readString();
      this.i = paramParcel.readString();
      this.j = paramParcel.readString();
      this.k = paramParcel.readString();
      this.l = paramParcel.readInt();
      this.c = paramParcel.createTypedArrayList(LatLng.CREATOR);
      this.d = paramParcel.createIntArray();
    }
    
    void a(int paramInt)
    {
      this.e = paramInt;
    }
    
    void a(RouteNode paramRouteNode)
    {
      this.f = paramRouteNode;
    }
    
    void a(String paramString)
    {
      this.i = paramString;
    }
    
    void a(List<LatLng> paramList)
    {
      this.c = paramList;
    }
    
    void a(int[] paramArrayOfInt)
    {
      this.d = paramArrayOfInt;
    }
    
    void b(int paramInt)
    {
      this.l = paramInt;
    }
    
    void b(RouteNode paramRouteNode)
    {
      this.g = paramRouteNode;
    }
    
    void b(String paramString)
    {
      this.j = paramString;
    }
    
    void c(String paramString)
    {
      this.k = paramString;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public int getDirection()
    {
      return this.e;
    }
    
    public RouteNode getEntrance()
    {
      return this.f;
    }
    
    public String getEntranceInstructions()
    {
      return this.i;
    }
    
    public RouteNode getExit()
    {
      return this.g;
    }
    
    public String getExitInstructions()
    {
      return this.j;
    }
    
    public String getInstructions()
    {
      return this.k;
    }
    
    public int getNumTurns()
    {
      return this.l;
    }
    
    public int[] getTrafficList()
    {
      return this.d;
    }
    
    public List<LatLng> getWayPoints()
    {
      if (this.mWayPoints == null) {
        this.mWayPoints = CoordUtil.decodeLocationList(this.h);
      }
      return this.c;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.e);
      paramParcel.writeParcelable(this.f, 1);
      paramParcel.writeParcelable(this.g, 1);
      paramParcel.writeString(this.h);
      paramParcel.writeString(this.i);
      paramParcel.writeString(this.j);
      paramParcel.writeString(this.k);
      paramParcel.writeInt(this.l);
      paramParcel.writeTypedList(this.c);
      paramParcel.writeIntArray(this.d);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/search/route/DrivingRouteLine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */