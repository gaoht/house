package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.unionpay.tsmservice.AppID;

public class GetAppDetailRequestParams
  extends RequestParams
{
  public static final Parcelable.Creator<GetAppDetailRequestParams> CREATOR = new GetAppDetailRequestParams.1();
  private AppID mAppID;
  private String mTransType;
  
  public GetAppDetailRequestParams() {}
  
  public GetAppDetailRequestParams(Parcel paramParcel)
  {
    super(paramParcel);
    this.mAppID = ((AppID)paramParcel.readParcelable(AppID.class.getClassLoader()));
    this.mTransType = paramParcel.readString();
  }
  
  public AppID getAppID()
  {
    return this.mAppID;
  }
  
  public String getTransType()
  {
    return this.mTransType;
  }
  
  public void setAppID(AppID paramAppID)
  {
    this.mAppID = paramAppID;
  }
  
  public void setTransType(String paramString)
  {
    this.mTransType = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeParcelable(this.mAppID, paramInt);
    paramParcel.writeString(this.mTransType);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/tsmservice/request/GetAppDetailRequestParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */