package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class ExchangeKeyRequestParams
  extends RequestParams
{
  public static final Parcelable.Creator<ExchangeKeyRequestParams> CREATOR = new ExchangeKeyRequestParams.1();
  private String mTempKey;
  private int mType;
  
  public ExchangeKeyRequestParams() {}
  
  public ExchangeKeyRequestParams(Parcel paramParcel)
  {
    super(paramParcel);
    this.mType = paramParcel.readInt();
    this.mTempKey = paramParcel.readString();
  }
  
  public String getTempKey()
  {
    return this.mTempKey;
  }
  
  public int getType()
  {
    return this.mType;
  }
  
  public void setTempKey(String paramString)
  {
    this.mTempKey = paramString;
  }
  
  public void setType(int paramInt)
  {
    this.mType = paramInt;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.mType);
    paramParcel.writeString(this.mTempKey);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/tsmservice/request/ExchangeKeyRequestParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */