package com.baidu.trace.api.analysis;

import com.baidu.trace.model.BaseResponse;
import java.util.List;

public final class DrivingBehaviorResponse
  extends BaseResponse
{
  private double a;
  private int b;
  private double c;
  private double d;
  private int e;
  private int f;
  private int g;
  private int h;
  private StartPoint i;
  private EndPoint j;
  private List<SpeedingInfo> k;
  private List<HarshAccelerationPoint> l;
  private List<HarshBreakingPoint> m;
  private List<HarshSteeringPoint> n;
  
  public DrivingBehaviorResponse() {}
  
  public DrivingBehaviorResponse(int paramInt1, int paramInt2, String paramString)
  {
    super(paramInt1, paramInt2, paramString);
  }
  
  public DrivingBehaviorResponse(int paramInt1, int paramInt2, String paramString, double paramDouble1, int paramInt3, double paramDouble2, double paramDouble3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, StartPoint paramStartPoint, EndPoint paramEndPoint, List<SpeedingInfo> paramList, List<HarshAccelerationPoint> paramList1, List<HarshBreakingPoint> paramList2, List<HarshSteeringPoint> paramList3)
  {
    super(paramInt1, paramInt2, paramString);
    this.a = paramDouble1;
    this.b = paramInt3;
    this.c = paramDouble2;
    this.d = paramDouble3;
    this.e = paramInt4;
    this.f = paramInt5;
    this.g = paramInt6;
    this.h = paramInt7;
    this.i = paramStartPoint;
    this.j = paramEndPoint;
    this.k = paramList;
    this.l = paramList1;
    this.m = paramList2;
    this.n = paramList3;
  }
  
  public final double getAverageSpeed()
  {
    return this.c;
  }
  
  public final double getDistance()
  {
    return this.a;
  }
  
  public final int getDuration()
  {
    return this.b;
  }
  
  public final EndPoint getEndPoint()
  {
    return this.j;
  }
  
  public final int getHarshAccelerationNum()
  {
    return this.f;
  }
  
  public final List<HarshAccelerationPoint> getHarshAccelerationPoints()
  {
    return this.l;
  }
  
  public final int getHarshBreakingNum()
  {
    return this.g;
  }
  
  public final List<HarshBreakingPoint> getHarshBreakingPoints()
  {
    return this.m;
  }
  
  public final int getHarshSteeringNum()
  {
    return this.h;
  }
  
  public final List<HarshSteeringPoint> getHarshSteeringPoints()
  {
    return this.n;
  }
  
  public final double getMaxSpeed()
  {
    return this.d;
  }
  
  public final int getSpeedingNum()
  {
    return this.e;
  }
  
  public final List<SpeedingInfo> getSpeedings()
  {
    return this.k;
  }
  
  public final StartPoint getStartPoint()
  {
    return this.i;
  }
  
  public final void setAverageSpeed(double paramDouble)
  {
    this.c = paramDouble;
  }
  
  public final void setDistance(double paramDouble)
  {
    this.a = paramDouble;
  }
  
  public final void setDuration(int paramInt)
  {
    this.b = paramInt;
  }
  
  public final void setEndPoint(EndPoint paramEndPoint)
  {
    this.j = paramEndPoint;
  }
  
  public final void setHarshAccelerationNum(int paramInt)
  {
    this.f = paramInt;
  }
  
  public final void setHarshAccelerationPoints(List<HarshAccelerationPoint> paramList)
  {
    this.l = paramList;
  }
  
  public final void setHarshBreakingNum(int paramInt)
  {
    this.g = paramInt;
  }
  
  public final void setHarshBreakingPoints(List<HarshBreakingPoint> paramList)
  {
    this.m = paramList;
  }
  
  public final void setHarshSteeringNum(int paramInt)
  {
    this.h = paramInt;
  }
  
  public final void setHarshSteeringPoints(List<HarshSteeringPoint> paramList)
  {
    this.n = paramList;
  }
  
  public final void setMaxSpeed(double paramDouble)
  {
    this.d = paramDouble;
  }
  
  public final void setSpeedingNum(int paramInt)
  {
    this.e = paramInt;
  }
  
  public final void setSpeedings(List<SpeedingInfo> paramList)
  {
    this.k = paramList;
  }
  
  public final void setStartPoint(StartPoint paramStartPoint)
  {
    this.i = paramStartPoint;
  }
  
  public final String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("[");
    if ((this.k != null) && (this.k.size() > 0))
    {
      int i3 = this.k.size();
      int i1 = 0;
      while (i1 < i3)
      {
        localStringBuffer.append("[");
        Object localObject = (SpeedingInfo)this.k.get(i1);
        if ((localObject != null) && (((SpeedingInfo)localObject).getPoints() != null) && (((SpeedingInfo)localObject).getPoints().size() != 0))
        {
          localObject = ((SpeedingInfo)localObject).getPoints();
          int i4 = ((List)localObject).size();
          int i2 = 0;
          while (i2 < i4)
          {
            localStringBuffer.append(((SpeedingPoint)((List)localObject).get(i2)).toString());
            if (i2 < i4 - 1) {
              localStringBuffer.append(",");
            }
            i2 += 1;
          }
          localStringBuffer.append("]");
          if (i1 < i3 - 1) {
            localStringBuffer.append(",");
          }
        }
        i1 += 1;
      }
    }
    localStringBuffer.append("]");
    return "DrivingBehaviorResponse [tag=" + this.tag + ", status=" + this.status + ", message=" + this.message + ", distance=" + this.a + ", duration=" + this.b + ", averageSpeed=" + this.c + ", maxSpeed=" + this.d + ", speedingNum=" + this.e + ", harshAccelerationNum=" + this.f + ", harshBreakingNum=" + this.g + ", harshSteeringNum=" + this.h + ", startPoint=" + this.i + ", endPoint=" + this.j + ", speedingPoints=" + localStringBuffer.toString() + ", harshAccelerationPoints=" + this.l + ", harshBreakingPoints=" + this.m + ", harshSteeringPoints=" + this.n + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/api/analysis/DrivingBehaviorResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */