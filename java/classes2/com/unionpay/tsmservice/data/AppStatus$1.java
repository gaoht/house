package com.unionpay.tsmservice.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class AppStatus$1
  implements Parcelable.Creator<AppStatus>
{
  public final AppStatus createFromParcel(Parcel paramParcel)
  {
    return new AppStatus(paramParcel);
  }
  
  public final AppStatus[] newArray(int paramInt)
  {
    return new AppStatus[paramInt];
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/tsmservice/data/AppStatus$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */