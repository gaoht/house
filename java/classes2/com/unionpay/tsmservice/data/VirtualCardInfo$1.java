package com.unionpay.tsmservice.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class VirtualCardInfo$1
  implements Parcelable.Creator<VirtualCardInfo>
{
  public final VirtualCardInfo createFromParcel(Parcel paramParcel)
  {
    return new VirtualCardInfo(paramParcel);
  }
  
  public final VirtualCardInfo[] newArray(int paramInt)
  {
    return new VirtualCardInfo[paramInt];
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/tsmservice/data/VirtualCardInfo$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */