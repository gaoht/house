package com.unionpay.tsmservice.result;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class CheckSSamsungPayResult
  implements Parcelable
{
  public static final Parcelable.Creator<CheckSSamsungPayResult> CREATOR = new CheckSSamsungPayResult.1();
  
  public CheckSSamsungPayResult() {}
  
  public CheckSSamsungPayResult(Parcel paramParcel) {}
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/tsmservice/result/CheckSSamsungPayResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */