package com.unionpay.tsmservice.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class SMSAuthCode$1
  implements Parcelable.Creator<SMSAuthCode>
{
  public final SMSAuthCode createFromParcel(Parcel paramParcel)
  {
    return new SMSAuthCode(paramParcel);
  }
  
  public final SMSAuthCode[] newArray(int paramInt)
  {
    return new SMSAuthCode[paramInt];
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/tsmservice/data/SMSAuthCode$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */