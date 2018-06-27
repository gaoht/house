package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.unionpay.tsmservice.AppID;

public class GetAccountBalanceRequestParams
  extends RequestParams
{
  public static final Parcelable.Creator<GetAccountBalanceRequestParams> CREATOR = new GetAccountBalanceRequestParams.1();
  private AppID mAppID;
  private String mEncryptPin;
  
  public GetAccountBalanceRequestParams() {}
  
  public GetAccountBalanceRequestParams(Parcel paramParcel)
  {
    super(paramParcel);
    this.mAppID = ((AppID)paramParcel.readParcelable(AppID.class.getClassLoader()));
    this.mEncryptPin = paramParcel.readString();
  }
  
  public AppID getAppID()
  {
    return this.mAppID;
  }
  
  public String getEncryptPin()
  {
    return this.mEncryptPin;
  }
  
  public void setAppID(AppID paramAppID)
  {
    this.mAppID = paramAppID;
  }
  
  public void setEncryptPin(String paramString)
  {
    this.mEncryptPin = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeParcelable(this.mAppID, paramInt);
    paramParcel.writeString(this.mEncryptPin);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/tsmservice/request/GetAccountBalanceRequestParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */