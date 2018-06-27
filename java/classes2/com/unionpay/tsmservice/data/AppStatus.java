package com.unionpay.tsmservice.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class AppStatus
  implements Parcelable
{
  public static final String APPLY = "06";
  public static final String APPROVED = "00";
  public static final String APPROVING = "02";
  public static final Parcelable.Creator<AppStatus> CREATOR = new AppStatus.1();
  public static final String NOT_APPROVED = "01";
  public static final String OPEN = "05";
  public static final String VIEW = "07";
  private String mStatus = "";
  
  public AppStatus() {}
  
  public AppStatus(Parcel paramParcel)
  {
    this.mStatus = paramParcel.readString();
  }
  
  public AppStatus(String paramString)
  {
    this.mStatus = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getStatus()
  {
    return this.mStatus;
  }
  
  public void setStatus(String paramString)
  {
    this.mStatus = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mStatus);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/tsmservice/data/AppStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */