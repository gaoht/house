package com.unionpay.tsmservice.result;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ECashTopUpResult
  implements Parcelable
{
  public static final Parcelable.Creator<ECashTopUpResult> CREATOR = new ECashTopUpResult.1();
  private String balance;
  private String overdraw;
  
  public ECashTopUpResult() {}
  
  public ECashTopUpResult(Parcel paramParcel)
  {
    this.balance = paramParcel.readString();
    this.overdraw = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getBalance()
  {
    return this.balance;
  }
  
  public String getOverdraw()
  {
    return this.overdraw;
  }
  
  public void setBalance(String paramString)
  {
    this.balance = paramString;
  }
  
  public void setOverdraw(String paramString)
  {
    this.overdraw = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.balance);
    paramParcel.writeString(this.overdraw);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/tsmservice/result/ECashTopUpResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */