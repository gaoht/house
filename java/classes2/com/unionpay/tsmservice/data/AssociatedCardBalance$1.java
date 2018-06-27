package com.unionpay.tsmservice.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class AssociatedCardBalance$1
  implements Parcelable.Creator<AssociatedCardBalance>
{
  public final AssociatedCardBalance createFromParcel(Parcel paramParcel)
  {
    return new AssociatedCardBalance(paramParcel);
  }
  
  public final AssociatedCardBalance[] newArray(int paramInt)
  {
    return new AssociatedCardBalance[paramInt];
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/tsmservice/data/AssociatedCardBalance$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */