package com.unionpay.client3.tsm;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class SeAppInfo
  implements Parcelable
{
  public static final Parcelable.Creator<SeAppInfo> CREATOR = new SeAppInfo.1();
  private String mAppAid;
  private String mAppIcon;
  private String mAppName;
  private String mAppProviderLogo;
  private String mAppProviderName;
  private String mAppSummary;
  private String mAppVersion;
  private String mBalance;
  private String mBankId;
  private String mCVN2;
  private int mDownloadTimes;
  private String mPan;
  private String mValidDate;
  
  public SeAppInfo() {}
  
  public SeAppInfo(Parcel paramParcel)
  {
    readFromParcel(paramParcel);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getAppAid()
  {
    return this.mAppAid;
  }
  
  public String getAppIcon()
  {
    return this.mAppIcon;
  }
  
  public String getAppName()
  {
    return this.mAppName;
  }
  
  public String getAppProviderLogo()
  {
    return this.mAppProviderLogo;
  }
  
  public String getAppProviderName()
  {
    return this.mAppProviderName;
  }
  
  public String getAppSummary()
  {
    return this.mAppSummary;
  }
  
  public String getAppVersion()
  {
    return this.mAppVersion;
  }
  
  public String getBalance()
  {
    return this.mBalance;
  }
  
  public String getBankId()
  {
    return this.mBankId;
  }
  
  public String getCVN2()
  {
    return this.mCVN2;
  }
  
  public int getDownloadTimes()
  {
    return this.mDownloadTimes;
  }
  
  public String getPan()
  {
    return this.mPan;
  }
  
  public String getValidDate()
  {
    return this.mValidDate;
  }
  
  public void readFromParcel(Parcel paramParcel)
  {
    this.mAppAid = paramParcel.readString();
    this.mAppIcon = paramParcel.readString();
    this.mAppName = paramParcel.readString();
    this.mBankId = paramParcel.readString();
    this.mAppProviderName = paramParcel.readString();
    this.mAppProviderLogo = paramParcel.readString();
    this.mAppSummary = paramParcel.readString();
    this.mAppVersion = paramParcel.readString();
    this.mDownloadTimes = paramParcel.readInt();
    this.mPan = paramParcel.readString();
    this.mValidDate = paramParcel.readString();
    this.mBalance = paramParcel.readString();
    this.mCVN2 = paramParcel.readString();
  }
  
  public void setAppAid(String paramString)
  {
    this.mAppAid = paramString;
  }
  
  public void setAppIcon(String paramString)
  {
    this.mAppIcon = paramString;
  }
  
  public void setAppName(String paramString)
  {
    this.mAppName = paramString;
  }
  
  public void setAppProviderLogo(String paramString)
  {
    this.mAppProviderLogo = paramString;
  }
  
  public void setAppProviderName(String paramString)
  {
    this.mAppProviderName = paramString;
  }
  
  public void setAppSummary(String paramString)
  {
    this.mAppSummary = paramString;
  }
  
  public void setAppVersion(String paramString)
  {
    this.mAppVersion = paramString;
  }
  
  public void setBalance(String paramString)
  {
    this.mBalance = paramString;
  }
  
  public void setBankId(String paramString)
  {
    this.mBankId = paramString;
  }
  
  public void setCVN2(String paramString)
  {
    this.mCVN2 = paramString;
  }
  
  public void setDownloadTimes(int paramInt)
  {
    this.mDownloadTimes = paramInt;
  }
  
  public void setPan(String paramString)
  {
    this.mPan = paramString;
  }
  
  public void setValidDate(String paramString)
  {
    this.mValidDate = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mAppAid);
    paramParcel.writeString(this.mAppIcon);
    paramParcel.writeString(this.mAppName);
    paramParcel.writeString(this.mBankId);
    paramParcel.writeString(this.mAppProviderName);
    paramParcel.writeString(this.mAppProviderLogo);
    paramParcel.writeString(this.mAppSummary);
    paramParcel.writeString(this.mAppVersion);
    paramParcel.writeInt(this.mDownloadTimes);
    paramParcel.writeString(this.mPan);
    paramParcel.writeString(this.mValidDate);
    paramParcel.writeString(this.mBalance);
    paramParcel.writeString(this.mCVN2);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/client3/tsm/SeAppInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */