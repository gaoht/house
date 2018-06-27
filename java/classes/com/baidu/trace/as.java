package com.baidu.trace;

import com.baidu.trace.api.entity.OnEntityListener;
import com.baidu.trace.c.e;
import com.baidu.trace.model.CoordType;
import com.baidu.trace.model.LatLng;
import com.baidu.trace.model.TraceLocation;

final class as
  extends OnEntityListener
{
  as(ar paramar) {}
  
  public final void onReceiveLocation(TraceLocation paramTraceLocation)
  {
    if (paramTraceLocation.getStatus() != 0) {}
    while ((Math.abs(paramTraceLocation.getLongitude()) < 0.1D) || (Math.abs(paramTraceLocation.getLatitude()) < 0.1D) || (Math.abs(paramTraceLocation.getRadius()) < 0.1D)) {
      return;
    }
    LatLng localLatLng = new LatLng(paramTraceLocation.getLatitude(), paramTraceLocation.getLongitude());
    long l = e.c(paramTraceLocation.getTime());
    if (l > 0L) {}
    for (;;)
    {
      ar.a(this.a, localLatLng, l, CoordType.bd09ll, paramTraceLocation.getRadius());
      return;
      l = e.b();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/as.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */