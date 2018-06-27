package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.RouteLine;
import com.baidu.mapapi.search.core.RouteLine.TYPE;
import com.baidu.mapapi.search.core.RouteNode;
import com.baidu.mapapi.search.core.RouteStep;
import java.util.ArrayList;
import java.util.List;

public class BikingRouteLine
  extends RouteLine<BikingStep>
  implements Parcelable
{
  public static final Parcelable.Creator<WalkingRouteLine> CREATOR = new a();
  
  BikingRouteLine() {}
  
  protected BikingRouteLine(Parcel paramParcel)
  {
    super(paramParcel);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public List<BikingStep> getAllStep()
  {
    return super.getAllStep();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.setType(RouteLine.TYPE.WALKSTEP);
    super.writeToParcel(paramParcel, 1);
  }
  
  public static class BikingStep
    extends RouteStep
    implements Parcelable
  {
    public static final Parcelable.Creator<BikingStep> CREATOR = new b();
    private int c;
    private RouteNode d;
    private RouteNode e;
    private String f;
    private String g;
    private String h;
    private String i;
    
    public BikingStep() {}
    
    protected BikingStep(Parcel paramParcel)
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
    
    private List<LatLng> e(String paramString)
    {
      if ((paramString == null) || (paramString.length() == 0)) {
        paramString = null;
      }
      ArrayList localArrayList;
      String[] arrayOfString;
      int k;
      int j;
      do
      {
        return paramString;
        localArrayList = new ArrayList();
        arrayOfString = paramString.split(";");
        if ((arrayOfString == null) || (arrayOfString.length == 0)) {
          return null;
        }
        k = arrayOfString.length;
        j = 0;
        paramString = localArrayList;
      } while (j >= k);
      paramString = arrayOfString[j].split(",");
      if ((paramString == null) || (paramString.length < 2)) {}
      for (;;)
      {
        j += 1;
        break;
        localArrayList.add(new LatLng(Double.valueOf(paramString[1]).doubleValue(), Double.valueOf(paramString[0]).doubleValue()));
      }
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
        this.mWayPoints = e(this.f);
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


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/search/route/BikingRouteLine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */