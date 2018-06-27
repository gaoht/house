package com.unionpay.tsmservice.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class PhysicalCardInfo$1
  implements Parcelable.Creator<PhysicalCardInfo>
{
  public final PhysicalCardInfo createFromParcel(Parcel paramParcel)
  {
    return new PhysicalCardInfo(paramParcel);
  }
  
  public final PhysicalCardInfo[] newArray(int paramInt)
  {
    return new PhysicalCardInfo[paramInt];
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/tsmservice/data/PhysicalCardInfo$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */