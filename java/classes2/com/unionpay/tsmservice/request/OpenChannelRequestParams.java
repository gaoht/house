package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class OpenChannelRequestParams
  extends RequestParams
{
  public static final Parcelable.Creator<OpenChannelRequestParams> CREATOR = new OpenChannelRequestParams.1();
  private String mAppAID;
  
  public OpenChannelRequestParams() {}
  
  public OpenChannelRequestParams(Parcel paramParcel)
  {
    super(paramParcel);
    this.mAppAID = paramParcel.readString();
  }
  
  public OpenChannelRequestParams(String paramString)
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


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/tsmservice/request/OpenChannelRequestParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */