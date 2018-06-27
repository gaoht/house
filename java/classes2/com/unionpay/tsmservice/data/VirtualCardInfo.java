package com.unionpay.tsmservice.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.unionpay.tsmservice.AppID;

public class VirtualCardInfo
  implements Parcelable
{
  public static final Parcelable.Creator<VirtualCardInfo> CREATOR = new VirtualCardInfo.1();
  private AppID mAppID;
  private String mBalance = "";
  private String mCVN2 = "";
  private String mCardNo = "";
  private String mReferenceID = "";
  private String mValidDate = "";
  
  public VirtualCardInfo() {}
  
  public VirtualCardInfo(Parcel paramParcel)
  {
    this.mAppID = ((AppID)paramParcel.readParcelable(AppID.class.getClassLoader()));
    this.mReferenceID = paramParcel.readString();
    this.mCardNo = paramParcel.readString();
    this.mValidDate = paramParcel.readString();
    this.mCVN2 = paramParcel.readString();
    this.mBalance = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public AppID getAppID()
  {
    return this.mAppID;
  }
  
  public String getBalance()
  {
    return this.mBalance;
  }
  
  public String getCVN2()
  {
    return this.mCVN2;
  }
  
  public String getCardNo()
  {
    return this.mCardNo;
  }
  
  public String getReferenceID()
  {
    return this.mReferenceID;
  }
  
  public String getValidDate()
  {
    return this.mValidDate;
  }
  
  public void setAppID(AppID paramAppID)
  {
    this.mAppID = paramAppID;
  }
  
  public void setBalance(String paramString)
  {
    this.mBalance = paramString;
  }
  
  public void setCVN2(String paramString)
  {
    this.mCVN2 = paramString;
  }
  
  public void setCardNo(String paramString)
  {
    this.mCardNo = paramString;
  }
  
  public void setReferenceID(String paramString)
  {
    this.mReferenceID = paramString;
  }
  
  public void setValidDate(String paramString)
  {
    this.mValidDate = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.mAppID, paramInt);
    paramParcel.writeString(this.mReferenceID);
    paramParcel.writeString(this.mCardNo);
    paramParcel.writeString(this.mValidDate);
    paramParcel.writeString(this.mCVN2);
    paramParcel.writeString(this.mBalance);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/tsmservice/data/VirtualCardInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */