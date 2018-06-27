package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class GetAssociatedAppRequestParams
  extends RequestParams
{
  public static final Parcelable.Creator<GetAssociatedAppRequestParams> CREATOR = new GetAssociatedAppRequestParams.1();
  private String mEncryptPan;
  
  public GetAssociatedAppRequestParams() {}
  
  public GetAssociatedAppRequestParams(Parcel paramParcel)
  {
    super(paramParcel);
    this.mEncryptPan = paramParcel.readString();
  }
  
  public GetAssociatedAppRequestParams(String paramString)
  {
    this.mEncryptPan = paramString;
  }
  
  public String getEncryptPan()
  {
    return this.mEncryptPan;
  }
  
  public void setEncryptPan(String paramString)
  {
    this.mEncryptPan = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.mEncryptPan);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/tsmservice/request/GetAssociatedAppRequestParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */