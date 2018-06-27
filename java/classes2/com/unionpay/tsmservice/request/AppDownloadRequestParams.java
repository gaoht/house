package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.unionpay.tsmservice.AppID;

public class AppDownloadRequestParams
  extends RequestParams
{
  public static final Parcelable.Creator<AppDownloadRequestParams> CREATOR = new AppDownloadRequestParams.1();
  private AppID mAppID;
  private String mAppName;
  
  public AppDownloadRequestParams() {}
  
  public AppDownloadRequestParams(Parcel paramParcel)
  {
    super(paramParcel);
    this.mAppID = ((AppID)paramParcel.readParcelable(AppID.class.getClassLoader()));
    this.mAppName = paramParcel.readString();
  }
  
  public AppID getAppID()
  {
    return this.mAppID;
  }
  
  public String getAppName()
  {
    return this.mAppName;
  }
  
  public void setAppID(AppID paramAppID)
  {
    this.mAppID = paramAppID;
  }
  
  public void setAppName(String paramString)
  {
    this.mAppName = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeParcelable(this.mAppID, paramInt);
    paramParcel.writeString(this.mAppName);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/tsmservice/request/AppDownloadRequestParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */