package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class b
  implements Parcelable.Creator<BikingRouteLine.BikingStep>
{
  public BikingRouteLine.BikingStep a(Parcel paramParcel)
  {
    return new BikingRouteLine.BikingStep(paramParcel);
  }
  
  public BikingRouteLine.BikingStep[] a(int paramInt)
  {
    return new BikingRouteLine.BikingStep[paramInt];
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/search/route/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */