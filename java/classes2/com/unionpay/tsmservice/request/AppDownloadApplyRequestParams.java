package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.unionpay.tsmservice.AppID;
import java.util.HashMap;
import java.util.Map;

public class AppDownloadApplyRequestParams
  extends RequestParams
{
  public static final Parcelable.Creator<AppDownloadApplyRequestParams> CREATOR = new AppDownloadApplyRequestParams.1();
  private AppID mAppID;
  private HashMap<String, String> mParams;
  
  public AppDownloadApplyRequestParams() {}
  
  public AppDownloadApplyRequestParams(Parcel paramParcel)
  {
    super(paramParcel);
    this.mAppID = ((AppID)paramParcel.readParcelable(AppID.class.getClassLoader()));
    this.mParams = paramParcel.readHashMap(HashMap.class.getClassLoader());
  }
  
  public AppID getAppID()
  {
    return this.mAppID;
  }
  
  public Map<String, String> getParams()
  {
    return this.mParams;
  }
  
  public void setAppID(AppID paramAppID)
  {
    this.mAppID = paramAppID;
  }
  
  public void setParams(HashMap<String, String> paramHashMap)
  {
    this.mParams = paramHashMap;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeParcelable(this.mAppID, paramInt);
    paramParcel.writeMap(this.mParams);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/tsmservice/request/AppDownloadApplyRequestParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */