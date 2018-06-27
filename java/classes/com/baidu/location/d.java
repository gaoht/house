package com.baidu.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class d
  implements Parcelable.Creator<Poi>
{
  public Poi createFromParcel(Parcel paramParcel)
  {
    return new Poi(paramParcel.readString(), paramParcel.readString(), paramParcel.readDouble());
  }
  
  public Poi[] newArray(int paramInt)
  {
    return new Poi[paramInt];
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/location/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */