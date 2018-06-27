package com.baidu.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class a
  implements Parcelable.Creator<BDLocation>
{
  public BDLocation createFromParcel(Parcel paramParcel)
  {
    return new BDLocation(paramParcel, null);
  }
  
  public BDLocation[] newArray(int paramInt)
  {
    return new BDLocation[paramInt];
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/location/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */