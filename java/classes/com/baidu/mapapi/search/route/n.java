package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class n
  implements Parcelable.Creator<WalkingRouteLine.WalkingStep>
{
  public WalkingRouteLine.WalkingStep a(Parcel paramParcel)
  {
    return new WalkingRouteLine.WalkingStep(paramParcel);
  }
  
  public WalkingRouteLine.WalkingStep[] a(int paramInt)
  {
    return new WalkingRouteLine.WalkingStep[paramInt];
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/search/route/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */