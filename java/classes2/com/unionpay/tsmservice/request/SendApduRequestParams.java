package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class SendApduRequestParams
  extends RequestParams
{
  public static final Parcelable.Creator<SendApduRequestParams> CREATOR = new SendApduRequestParams.1();
  private String channel;
  private String hexApdu;
  
  public SendApduRequestParams() {}
  
  public SendApduRequestParams(Parcel paramParcel)
  {
    super(paramParcel);
    this.channel = paramParcel.readString();
    this.hexApdu = paramParcel.readString();
  }
  
  public String getChannel()
  {
    return this.channel;
  }
  
  public String getHexApdu()
  {
    return this.hexApdu;
  }
  
  public void setChannel(String paramString)
  {
    this.channel = paramString;
  }
  
  public void setHexApdu(String paramString)
  {
    this.hexApdu = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.channel);
    paramParcel.writeString(this.hexApdu);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/tsmservice/request/SendApduRequestParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */