package com.unionpay.tsmservice.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class TransRecord$1
  implements Parcelable.Creator<TransRecord>
{
  public final TransRecord createFromParcel(Parcel paramParcel)
  {
    return new TransRecord(paramParcel);
  }
  
  public final TransRecord[] newArray(int paramInt)
  {
    return new TransRecord[paramInt];
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/tsmservice/data/TransRecord$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */