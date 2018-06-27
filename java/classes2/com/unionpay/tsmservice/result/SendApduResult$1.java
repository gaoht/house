package com.unionpay.tsmservice.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class SendApduResult$1
  implements Parcelable.Creator<SendApduResult>
{
  public final SendApduResult createFromParcel(Parcel paramParcel)
  {
    return new SendApduResult(paramParcel);
  }
  
  public final SendApduResult[] newArray(int paramInt)
  {
    return new SendApduResult[paramInt];
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/tsmservice/result/SendApduResult$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */