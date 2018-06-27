package com.unionpay.tsmservice.result;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.unionpay.tsmservice.data.PhysicalCardInfo;

public class AppDownloadApplyResult
  implements Parcelable
{
  public static final Parcelable.Creator<AppDownloadApplyResult> CREATOR = new AppDownloadApplyResult.1();
  private PhysicalCardInfo mPhysicalCardInfo;
  
  public AppDownloadApplyResult() {}
  
  public AppDownloadApplyResult(Parcel paramParcel)
  {
    this.mPhysicalCardInfo = ((PhysicalCardInfo)paramParcel.readParcelable(PhysicalCardInfo.class.getClassLoader()));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public PhysicalCardInfo getPhysicalCardInfo()
  {
    return this.mPhysicalCardInfo;
  }
  
  public void setPhysicalCardInfo(PhysicalCardInfo paramPhysicalCardInfo)
  {
    this.mPhysicalCardInfo = paramPhysicalCardInfo;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.mPhysicalCardInfo, paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/tsmservice/result/AppDownloadApplyResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */