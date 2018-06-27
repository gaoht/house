package com.baidu.trace;

import com.baidu.trace.api.fence.AlarmPoint;
import com.baidu.trace.model.CoordType;
import com.baidu.trace.model.LatLng;

final class bi
  extends AlarmPoint
{
  public bi(LatLng paramLatLng, CoordType paramCoordType, long paramLong, double paramDouble)
  {
    super(paramLatLng, paramCoordType, paramLong, paramDouble);
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == null) {}
    double d2;
    double d4;
    do
    {
      do
      {
        return false;
        if (this == paramObject) {
          return true;
        }
      } while (getClass() != paramObject.getClass());
      paramObject = (bi)paramObject;
      if (this.c != ((bi)paramObject).c) {
        bool = false;
      }
      double d1 = this.a.latitude;
      d2 = this.a.longitude;
      double d3 = ((bi)paramObject).a.latitude;
      d4 = ((bi)paramObject).a.longitude;
      if (Double.doubleToLongBits(d1) != Double.doubleToLongBits(d3)) {
        bool = false;
      }
    } while (Double.doubleToLongBits(d2) != Double.doubleToLongBits(d4));
    return bool;
  }
  
  public final int hashCode()
  {
    return super.hashCode();
  }
  
  public final String toString()
  {
    return "TrackPoint [location=" + this.a + ", coordType=" + this.b + ", locTime=" + this.c + ", radius=" + this.d + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/bi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */