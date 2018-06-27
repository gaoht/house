package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class SetDefaultCardRequestParams
  extends RequestParams
{
  public static final Parcelable.Creator<SetDefaultCardRequestParams> CREATOR = new SetDefaultCardRequestParams.1();
  private String mAppAID;
  
  public SetDefaultCardRequestParams() {}
  
  public SetDefaultCardRequestParams(Parcel paramParcel)
  {
    super(paramParcel);
    this.mAppAID = paramParcel.readString();
  }
  
  public SetDefaultCardRequestParams(String paramString)
  {
    this.mAppAID = paramString;
  }
  
  public String getAppAID()
  {
    return this.mAppAID;
  }
  
  public void setAppAID(String paramString)
  {
    this.mAppAID = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.mAppAID);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/tsmservice/request/SetDefaultCardRequestParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */