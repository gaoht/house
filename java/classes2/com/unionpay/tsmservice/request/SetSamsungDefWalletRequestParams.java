package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class SetSamsungDefWalletRequestParams
  extends RequestParams
{
  public static final Parcelable.Creator<SetSamsungDefWalletRequestParams> CREATOR = new SetSamsungDefWalletRequestParams.1();
  
  public SetSamsungDefWalletRequestParams() {}
  
  public SetSamsungDefWalletRequestParams(Parcel paramParcel)
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


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/tsmservice/request/SetSamsungDefWalletRequestParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */