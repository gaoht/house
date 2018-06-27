package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class e
  implements Parcelable.Creator<DrivingRouteLine.DrivingStep>
{
  public DrivingRouteLine.DrivingStep a(Parcel paramParcel)
  {
    return new DrivingRouteLine.DrivingStep(paramParcel);
  }
  
  public DrivingRouteLine.DrivingStep[] a(int paramInt)
  {
    return new DrivingRouteLine.DrivingStep[paramInt];
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/search/route/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */