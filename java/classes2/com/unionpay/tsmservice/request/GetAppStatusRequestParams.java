package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.unionpay.tsmservice.AppID;

public class GetAppStatusRequestParams
  extends RequestParams
{
  public static final Parcelable.Creator<GetAppStatusRequestParams> CREATOR = new GetAppStatusRequestParams.1();
  private AppID mAppID;
  
  public GetAppStatusRequestParams() {}
  
  public GetAppStatusRequestParams(Parcel paramParcel)
  {
    super(paramParcel);
    this.mAppID = ((AppID)paramParcel.readParcelable(AppID.class.getClassLoader()));
  }
  
  public AppID getAppID()
  {
    return this.mAppID;
  }
  
  public void setAppID(AppID paramAppID)
  {
    this.mAppID = paramAppID;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeParcelable(this.mAppID, paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/tsmservice/request/GetAppStatusRequestParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */