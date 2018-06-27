package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class CheckSSamsungPayRequestParams
  extends RequestParams
{
  public static final Parcelable.Creator<CheckSSamsungPayRequestParams> CREATOR = new CheckSSamsungPayRequestParams.1();
  
  public CheckSSamsungPayRequestParams() {}
  
  public CheckSSamsungPayRequestParams(Parcel paramParcel)
  {
    super(paramParcel);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/tsmservice/request/CheckSSamsungPayRequestParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */