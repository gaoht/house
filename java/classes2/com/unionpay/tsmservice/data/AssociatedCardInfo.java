package com.unionpay.tsmservice.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class AssociatedCardInfo
  implements Parcelable
{
  public static final Parcelable.Creator<AssociatedCardInfo> CREATOR = new AssociatedCardInfo.1();
  private String mCardNo;
  private String mCardType;
  
  public AssociatedCardInfo() {}
  
  public AssociatedCardInfo(Parcel paramParcel)
  {
    this.mCardType = paramParcel.readString();
    this.mCardNo = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getCardNo()
  {
    return this.mCardNo;
  }
  
  public String getCardType()
  {
    return this.mCardType;
  }
  
  public void setCardNo(String paramString)
  {
    this.mCardNo = paramString;
  }
  
  public void setCardType(String paramString)
  {
    this.mCardType = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mCardType);
    paramParcel.writeString(this.mCardNo);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/tsmservice/data/AssociatedCardInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */