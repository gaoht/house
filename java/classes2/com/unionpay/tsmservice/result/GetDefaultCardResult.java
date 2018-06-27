package com.unionpay.tsmservice.result;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class GetDefaultCardResult
  implements Parcelable
{
  public static final Parcelable.Creator<GetDefaultCardResult> CREATOR = new GetDefaultCardResult.1();
  private String mDefaultCard;
  
  public GetDefaultCardResult() {}
  
  public GetDefaultCardResult(Parcel paramParcel)
  {
    this.mDefaultCard = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getDefaultCard()
  {
    return this.mDefaultCard;
  }
  
  public void setDefaultCard(String paramString)
  {
    this.mDefaultCard = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mDefaultCard);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/tsmservice/result/GetDefaultCardResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */