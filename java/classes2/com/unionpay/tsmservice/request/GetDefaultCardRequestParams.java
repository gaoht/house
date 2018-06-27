package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class GetDefaultCardRequestParams
  extends RequestParams
{
  public static final Parcelable.Creator<GetDefaultCardRequestParams> CREATOR = new GetDefaultCardRequestParams.1();
  
  public GetDefaultCardRequestParams() {}
  
  public GetDefaultCardRequestParams(Parcel paramParcel)
  {
    super(paramParcel);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/tsmservice/request/GetDefaultCardRequestParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */