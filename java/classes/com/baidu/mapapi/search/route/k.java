package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class k
  implements Parcelable.Creator<TransitRouteLine.TransitStep>
{
  public TransitRouteLine.TransitStep a(Parcel paramParcel)
  {
    return new TransitRouteLine.TransitStep(paramParcel);
  }
  
  public TransitRouteLine.TransitStep[] a(int paramInt)
  {
    return new TransitRouteLine.TransitStep[paramInt];
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/search/route/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */