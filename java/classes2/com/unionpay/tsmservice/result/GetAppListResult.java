package com.unionpay.tsmservice.result;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.unionpay.tsmservice.data.AppDetail;

public class GetAppListResult
  implements Parcelable
{
  public static final Parcelable.Creator<GetAppListResult> CREATOR = new GetAppListResult.1();
  private AppDetail[] mAppList;
  
  public GetAppListResult() {}
  
  public GetAppListResult(Parcel paramParcel)
  {
    this.mAppList = ((AppDetail[])paramParcel.createTypedArray(AppDetail.CREATOR));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public AppDetail[] getAppList()
  {
    return this.mAppList;
  }
  
  public void setAppList(AppDetail[] paramArrayOfAppDetail)
  {
    this.mAppList = paramArrayOfAppDetail;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeTypedArray(this.mAppList, paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/tsmservice/result/GetAppListResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */