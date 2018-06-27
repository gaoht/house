package com.unionpay.tsmservice.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class TransRecord
  implements Parcelable
{
  public static final Parcelable.Creator<TransRecord> CREATOR = new TransRecord.1();
  private String mMerchantName;
  private String mTransAmount;
  private String mTransTime;
  private String mTransType;
  
  public TransRecord() {}
  
  public TransRecord(Parcel paramParcel)
  {
    this.mTransTime = paramParcel.readString();
    this.mMerchantName = paramParcel.readString();
    this.mTransType = paramParcel.readString();
    this.mTransAmount = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getMerchantName()
  {
    return this.mMerchantName;
  }
  
  public String getTransAmount()
  {
    return this.mTransAmount;
  }
  
  public String getTransTime()
  {
    return this.mTransTime;
  }
  
  public String getTransType()
  {
    return this.mTransType;
  }
  
  public void setMerchantName(String paramString)
  {
    this.mMerchantName = paramString;
  }
  
  public void setTransAmount(String paramString)
  {
    this.mTransAmount = paramString;
  }
  
  public void setTransTime(String paramString)
  {
    this.mTransTime = paramString;
  }
  
  public void setTransType(String paramString)
  {
    this.mTransType = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mTransTime);
    paramParcel.writeString(this.mMerchantName);
    paramParcel.writeString(this.mTransType);
    paramParcel.writeString(this.mTransAmount);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/tsmservice/data/TransRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */