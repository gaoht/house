package com.unionpay.tsmservice.result;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ExchangeKeyResult
  implements Parcelable
{
  public static final Parcelable.Creator<ExchangeKeyResult> CREATOR = new ExchangeKeyResult.1();
  private String key;
  
  public ExchangeKeyResult() {}
  
  public ExchangeKeyResult(Parcel paramParcel)
  {
    this.key = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getKey()
  {
    return this.key;
  }
  
  public void setKey(String paramString)
  {
    this.key = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.key);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/tsmservice/result/ExchangeKeyResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */