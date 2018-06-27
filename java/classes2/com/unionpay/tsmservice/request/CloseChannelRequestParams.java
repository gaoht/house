package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class CloseChannelRequestParams
  extends RequestParams
{
  public static final Parcelable.Creator<CloseChannelRequestParams> CREATOR = new CloseChannelRequestParams.1();
  private String mChannel;
  
  public CloseChannelRequestParams() {}
  
  public CloseChannelRequestParams(Parcel paramParcel)
  {
    super(paramParcel);
    this.mChannel = paramParcel.readString();
  }
  
  public CloseChannelRequestParams(String paramString)
  {
    this.mChannel = paramString;
  }
  
  public String getChannel()
  {
    return this.mChannel;
  }
  
  public void setChannel(String paramString)
  {
    this.mChannel = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.mChannel);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/tsmservice/request/CloseChannelRequestParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */