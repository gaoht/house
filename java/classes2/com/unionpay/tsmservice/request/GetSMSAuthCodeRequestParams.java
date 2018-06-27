package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.unionpay.tsmservice.AppID;

public class GetSMSAuthCodeRequestParams
  extends RequestParams
{
  public static final Parcelable.Creator<GetSMSAuthCodeRequestParams> CREATOR = new GetSMSAuthCodeRequestParams.1();
  private AppID mAppID;
  private String mPan;
  private String mSisdn;
  
  public GetSMSAuthCodeRequestParams() {}
  
  public GetSMSAuthCodeRequestParams(Parcel paramParcel)
  {
    super(paramParcel);
    this.mAppID = ((AppID)paramParcel.readParcelable(AppID.class.getClassLoader()));
    this.mPan = paramParcel.readString();
    this.mSisdn = paramParcel.readString();
  }
  
  public AppID getAppID()
  {
    return this.mAppID;
  }
  
  public String getMsisdn()
  {
    return this.mSisdn;
  }
  
  public String getPan()
  {
    return this.mPan;
  }
  
  public void setAppID(AppID paramAppID)
  {
    this.mAppID = paramAppID;
  }
  
  public void setMsisdn(String paramString)
  {
    this.mSisdn = paramString;
  }
  
  public void setPan(String paramString)
  {
    this.mPan = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeParcelable(this.mAppID, paramInt);
    paramParcel.writeString(this.mPan);
    paramParcel.writeString(this.mSisdn);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/tsmservice/request/GetSMSAuthCodeRequestParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */