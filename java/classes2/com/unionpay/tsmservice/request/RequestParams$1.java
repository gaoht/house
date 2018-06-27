package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class RequestParams$1
  implements Parcelable.Creator<RequestParams>
{
  public final RequestParams createFromParcel(Parcel paramParcel)
  {
    return new RequestParams(paramParcel);
  }
  
  public final RequestParams[] newArray(int paramInt)
  {
    return new RequestParams[paramInt];
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/tsmservice/request/RequestParams$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */