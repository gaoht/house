package com.unionpay.tsmservice.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class PhysicalCardInfo
  implements Parcelable
{
  public static final Parcelable.Creator<PhysicalCardInfo> CREATOR = new PhysicalCardInfo.1();
  public static final String TYPE_CREDIT = "02";
  public static final String TYPE_DEBIT = "01";
  private String mBankLogo = "";
  private String mBankName = "";
  private String mCardIcon = "";
  private String mCardNo = "";
  private String mCardType = "";
  private String mReferenceID = "";
  
  public PhysicalCardInfo() {}
  
  public PhysicalCardInfo(Parcel paramParcel)
  {
    this.mReferenceID = paramParcel.readString();
    this.mCardNo = paramParcel.readString();
    this.mCardType = paramParcel.readString();
    this.mCardIcon = paramParcel.readString();
    this.mBankName = paramParcel.readString();
    this.mBankLogo = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getBankLogo()
  {
    return this.mBankLogo;
  }
  
  public String getBankName()
  {
    return this.mBankName;
  }
  
  public String getCardIcon()
  {
    return this.mCardIcon;
  }
  
  public String getCardNo()
  {
    return this.mCardNo;
  }
  
  public String getCardType()
  {
    return this.mCardType;
  }
  
  public String getReferenceID()
  {
    return this.mReferenceID;
  }
  
  public void setBankLogo(String paramString)
  {
    this.mBankLogo = paramString;
  }
  
  public void setBankName(String paramString)
  {
    this.mBankName = paramString;
  }
  
  public void setCardIcon(String paramString)
  {
    this.mCardIcon = paramString;
  }
  
  public void setCardNo(String paramString)
  {
    this.mCardNo = paramString;
  }
  
  public void setCardType(String paramString)
  {
    this.mCardType = paramString;
  }
  
  public void setReferenceID(String paramString)
  {
    this.mReferenceID = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mReferenceID);
    paramParcel.writeString(this.mCardNo);
    paramParcel.writeString(this.mCardType);
    paramParcel.writeString(this.mCardIcon);
    paramParcel.writeString(this.mBankName);
    paramParcel.writeString(this.mBankLogo);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/tsmservice/data/PhysicalCardInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */