package com.unionpay.tsmservice.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.unionpay.tsmservice.AppID;

public class AppDetail
  implements Parcelable
{
  public static final Parcelable.Creator<AppDetail> CREATOR = new AppDetail.1();
  private String mAppApplyId;
  private String mAppDesc = "";
  private AppID mAppID;
  private String mAppIcon = "";
  private String mAppName = "";
  private String mAppProviderAgreement = "";
  private String mAppProviderLogo = "";
  private String mAppProviderName = "";
  private String mApplyMode = "";
  private long mDownloadTimes = 0L;
  private String mPublishData = "";
  private String mPublishStatus = "";
  private String mRechargeLowerLimit = "";
  private String mRechargeMode = "";
  private String mServicePhone = "";
  private AppStatus mStatus;
  private String mUpAgreement = "";
  
  public AppDetail() {}
  
  public AppDetail(Parcel paramParcel)
  {
    this.mAppID = ((AppID)paramParcel.readParcelable(AppID.class.getClassLoader()));
    this.mAppName = paramParcel.readString();
    this.mAppIcon = paramParcel.readString();
    this.mAppDesc = paramParcel.readString();
    this.mAppProviderLogo = paramParcel.readString();
    this.mAppProviderName = paramParcel.readString();
    this.mAppProviderAgreement = paramParcel.readString();
    this.mUpAgreement = paramParcel.readString();
    this.mApplyMode = paramParcel.readString();
    this.mServicePhone = paramParcel.readString();
    this.mDownloadTimes = paramParcel.readLong();
    this.mPublishData = paramParcel.readString();
    this.mPublishStatus = paramParcel.readString();
    this.mRechargeMode = paramParcel.readString();
    this.mRechargeLowerLimit = paramParcel.readString();
    this.mAppApplyId = paramParcel.readString();
    this.mStatus = ((AppStatus)paramParcel.readParcelable(AppStatus.class.getClassLoader()));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getAppApplyId()
  {
    return this.mAppApplyId;
  }
  
  public String getAppDesc()
  {
    return this.mAppDesc;
  }
  
  public AppID getAppID()
  {
    return this.mAppID;
  }
  
  public String getAppIcon()
  {
    return this.mAppIcon;
  }
  
  public String getAppName()
  {
    return this.mAppName;
  }
  
  public String getAppProviderAgreement()
  {
    return this.mAppProviderAgreement;
  }
  
  public String getAppProviderLogo()
  {
    return this.mAppProviderLogo;
  }
  
  public String getAppProviderName()
  {
    return this.mAppProviderName;
  }
  
  public String getApplyMode()
  {
    return this.mApplyMode;
  }
  
  public long getDownloadTimes()
  {
    return this.mDownloadTimes;
  }
  
  public String getPublishData()
  {
    return this.mPublishData;
  }
  
  public String getPublishStatus()
  {
    return this.mPublishStatus;
  }
  
  public String getRechargeLowerLimit()
  {
    return this.mRechargeLowerLimit;
  }
  
  public String getRechargeMode()
  {
    return this.mRechargeMode;
  }
  
  public String getServicePhone()
  {
    return this.mServicePhone;
  }
  
  public AppStatus getStatus()
  {
    return this.mStatus;
  }
  
  public String getUpAgreement()
  {
    return this.mUpAgreement;
  }
  
  public void setAppApplyId(String paramString)
  {
    this.mAppApplyId = paramString;
  }
  
  public void setAppDesc(String paramString)
  {
    this.mAppDesc = paramString;
  }
  
  public void setAppID(AppID paramAppID)
  {
    this.mAppID = paramAppID;
  }
  
  public void setAppIcon(String paramString)
  {
    this.mAppIcon = paramString;
  }
  
  public void setAppName(String paramString)
  {
    this.mAppName = paramString;
  }
  
  public void setAppProviderAgreement(String paramString)
  {
    this.mAppProviderAgreement = paramString;
  }
  
  public void setAppProviderLogo(String paramString)
  {
    this.mAppProviderLogo = paramString;
  }
  
  public void setAppProviderName(String paramString)
  {
    this.mAppProviderName = paramString;
  }
  
  public void setApplyMode(String paramString)
  {
    this.mApplyMode = paramString;
  }
  
  public void setDownloadTimes(long paramLong)
  {
    this.mDownloadTimes = paramLong;
  }
  
  public void setPublishData(String paramString)
  {
    this.mPublishData = paramString;
  }
  
  public void setPublishStatus(String paramString)
  {
    this.mPublishStatus = paramString;
  }
  
  public void setRechargeLowerLimit(String paramString)
  {
    this.mRechargeLowerLimit = paramString;
  }
  
  public void setRechargeMode(String paramString)
  {
    this.mRechargeMode = paramString;
  }
  
  public void setServicePhone(String paramString)
  {
    this.mServicePhone = paramString;
  }
  
  public void setStatus(AppStatus paramAppStatus)
  {
    this.mStatus = paramAppStatus;
  }
  
  public void setUpAgreement(String paramString)
  {
    this.mUpAgreement = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.mAppID, paramInt);
    paramParcel.writeString(this.mAppName);
    paramParcel.writeString(this.mAppIcon);
    paramParcel.writeString(this.mAppDesc);
    paramParcel.writeString(this.mAppProviderLogo);
    paramParcel.writeString(this.mAppProviderName);
    paramParcel.writeString(this.mAppProviderAgreement);
    paramParcel.writeString(this.mUpAgreement);
    paramParcel.writeString(this.mApplyMode);
    paramParcel.writeString(this.mServicePhone);
    paramParcel.writeLong(this.mDownloadTimes);
    paramParcel.writeString(this.mPublishData);
    paramParcel.writeString(this.mPublishStatus);
    paramParcel.writeString(this.mRechargeMode);
    paramParcel.writeString(this.mRechargeLowerLimit);
    paramParcel.writeString(this.mAppApplyId);
    paramParcel.writeParcelable(this.mStatus, paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/tsmservice/data/AppDetail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */