package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class HideAppApplyRequestParams
  extends RequestParams
{
  public static final Parcelable.Creator<HideAppApplyRequestParams> CREATOR = new HideAppApplyRequestParams.1();
  private String mApplyId;
  
  public HideAppApplyRequestParams() {}
  
  public HideAppApplyRequestParams(Parcel paramParcel)
  {
    super(paramParcel);
    this.mApplyId = paramParcel.readString();
  }
  
  public HideAppApplyRequestParams(String paramString)
  {
    this.mApplyId = paramString;
  }
  
  public String getApplyId()
  {
    return this.mApplyId;
  }
  
  public void setApplyId(String paramString)
  {
    this.mApplyId = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.mApplyId);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/tsmservice/request/HideAppApplyRequestParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */