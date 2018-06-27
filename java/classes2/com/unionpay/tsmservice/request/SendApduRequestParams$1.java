package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class SendApduRequestParams$1
  implements Parcelable.Creator<SendApduRequestParams>
{
  public final SendApduRequestParams createFromParcel(Parcel paramParcel)
  {
    return new SendApduRequestParams(paramParcel);
  }
  
  public final SendApduRequestParams[] newArray(int paramInt)
  {
    return new SendApduRequestParams[paramInt];
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/tsmservice/request/SendApduRequestParams$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */