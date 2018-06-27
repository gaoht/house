package com.unionpay.tsmservice.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class AssociatedCardBalance
  implements Parcelable
{
  public static final Parcelable.Creator<AssociatedCardBalance> CREATOR = new AssociatedCardBalance.1();
  private String mBalance;
  
  public AssociatedCardBalance() {}
  
  public AssociatedCardBalance(Parcel paramParcel)
  {
    this.mBalance = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getBalance()
  {
    return this.mBalance;
  }
  
  public void setBalance(String paramString)
  {
    this.mBalance = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mBalance);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/tsmservice/data/AssociatedCardBalance.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */