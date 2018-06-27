package com.unionpay.tsmservice.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class SeAppListItem
  implements Parcelable
{
  public static final Parcelable.Creator<SeAppListItem> CREATOR = new SeAppListItem.1();
  private AppDetail mAppDetail;
  private VirtualCardInfo mVirtualCardInfo;
  
  public SeAppListItem() {}
  
  public SeAppListItem(Parcel paramParcel)
  {
    this.mAppDetail = ((AppDetail)paramParcel.readParcelable(AppDetail.class.getClassLoader()));
    this.mVirtualCardInfo = ((VirtualCardInfo)paramParcel.readParcelable(VirtualCardInfo.class.getClassLoader()));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public AppDetail getAppDetail()
  {
    return this.mAppDetail;
  }
  
  public VirtualCardInfo getVirtualCardInfo()
  {
    return this.mVirtualCardInfo;
  }
  
  public void setAppDetail(AppDetail paramAppDetail)
  {
    this.mAppDetail = paramAppDetail;
  }
  
  public void setVirtualCardInfo(VirtualCardInfo paramVirtualCardInfo)
  {
    this.mVirtualCardInfo = paramVirtualCardInfo;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.mAppDetail, paramInt);
    paramParcel.writeParcelable(this.mVirtualCardInfo, paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/tsmservice/data/SeAppListItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */