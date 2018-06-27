package com.unionpay.tsmservice.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class SMSAuthCode
  implements Parcelable
{
  public static final Parcelable.Creator<SMSAuthCode> CREATOR = new SMSAuthCode.1();
  private String mExpireNote;
  
  public SMSAuthCode() {}
  
  public SMSAuthCode(Parcel paramParcel)
  {
    this.mExpireNote = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getExpireNote()
  {
    return this.mExpireNote;
  }
  
  public void setExpireNote(String paramString)
  {
    this.mExpireNote = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mExpireNote);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/tsmservice/data/SMSAuthCode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */