package com.unionpay.tsmservice.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class TransElement$1
  implements Parcelable.Creator<TransElement>
{
  public final TransElement createFromParcel(Parcel paramParcel)
  {
    return new TransElement(paramParcel);
  }
  
  public final TransElement[] newArray(int paramInt)
  {
    return new TransElement[paramInt];
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/tsmservice/data/TransElement$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */