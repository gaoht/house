package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class GetSMSAuthCodeRequestParams$1
  implements Parcelable.Creator<GetSMSAuthCodeRequestParams>
{
  public final GetSMSAuthCodeRequestParams createFromParcel(Parcel paramParcel)
  {
    return new GetSMSAuthCodeRequestParams(paramParcel);
  }
  
  public final GetSMSAuthCodeRequestParams[] newArray(int paramInt)
  {
    return new GetSMSAuthCodeRequestParams[paramInt];
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/tsmservice/request/GetSMSAuthCodeRequestParams$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */