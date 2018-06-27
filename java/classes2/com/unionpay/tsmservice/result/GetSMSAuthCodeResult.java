package com.unionpay.tsmservice.result;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.unionpay.tsmservice.data.SMSAuthCode;

public class GetSMSAuthCodeResult
  implements Parcelable
{
  public static final Parcelable.Creator<GetSMSAuthCodeResult> CREATOR = new GetSMSAuthCodeResult.1();
  private SMSAuthCode smsAuthCode;
  
  public GetSMSAuthCodeResult() {}
  
  public GetSMSAuthCodeResult(Parcel paramParcel)
  {
    this.smsAuthCode = ((SMSAuthCode)paramParcel.readParcelable(SMSAuthCode.class.getClassLoader()));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public SMSAuthCode getSmsAuthCode()
  {
    return this.smsAuthCode;
  }
  
  public void setSmsAuthCode(SMSAuthCode paramSMSAuthCode)
  {
    this.smsAuthCode = paramSMSAuthCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.smsAuthCode, paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/tsmservice/result/GetSMSAuthCodeResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */