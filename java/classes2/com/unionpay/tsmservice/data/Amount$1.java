package com.unionpay.tsmservice.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class Amount$1
  implements Parcelable.Creator<Amount>
{
  public final Amount createFromParcel(Parcel paramParcel)
  {
    return new Amount(paramParcel);
  }
  
  public final Amount[] newArray(int paramInt)
  {
    return new Amount[paramInt];
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/tsmservice/data/Amount$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */