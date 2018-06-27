package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class InitRequestParams
  extends RequestParams
{
  public static final Parcelable.Creator<InitRequestParams> CREATOR = new InitRequestParams.1();
  private String mSignature = "";
  
  public InitRequestParams() {}
  
  public InitRequestParams(Parcel paramParcel)
  {
    super(paramParcel);
    this.mSignature = paramParcel.readString();
  }
  
  public String getSignature()
  {
    return this.mSignature;
  }
  
  public void setSignature(String paramString)
  {
    this.mSignature = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.mSignature);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/tsmservice/request/InitRequestParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */