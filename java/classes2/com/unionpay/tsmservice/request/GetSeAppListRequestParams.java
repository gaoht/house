package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class GetSeAppListRequestParams
  extends RequestParams
{
  public static final Parcelable.Creator<GetSeAppListRequestParams> CREATOR = new GetSeAppListRequestParams.1();
  
  public GetSeAppListRequestParams() {}
  
  public GetSeAppListRequestParams(Parcel paramParcel)
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


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/tsmservice/request/GetSeAppListRequestParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */