package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class ExecuteCmdRequestParams
  extends RequestParams
{
  public static final Parcelable.Creator<ExecuteCmdRequestParams> CREATOR = new ExecuteCmdRequestParams.1();
  private String mSign;
  private String mSsid;
  
  public ExecuteCmdRequestParams() {}
  
  public ExecuteCmdRequestParams(Parcel paramParcel)
  {
    super(paramParcel);
    this.mSsid = paramParcel.readString();
    this.mSign = paramParcel.readString();
  }
  
  public String getSign()
  {
    return this.mSign;
  }
  
  public String getSsid()
  {
    return this.mSsid;
  }
  
  public void setSign(String paramString)
  {
    this.mSign = paramString;
  }
  
  public void setSsid(String paramString)
  {
    this.mSsid = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.mSsid);
    paramParcel.writeString(this.mSign);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/tsmservice/request/ExecuteCmdRequestParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */