package com.unionpay.tsmservice.result;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.unionpay.tsmservice.data.AppDetail;

public class GetAppDetailResult
  implements Parcelable
{
  public static final Parcelable.Creator<GetAppDetailResult> CREATOR = new GetAppDetailResult.1();
  private AppDetail mAppDetail;
  
  public GetAppDetailResult() {}
  
  public GetAppDetailResult(Parcel paramParcel)
  {
    this.mAppDetail = ((AppDetail)paramParcel.readParcelable(AppDetail.class.getClassLoader()));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public AppDetail getAppDetail()
  {
    return this.mAppDetail;
  }
  
  public void setAppDetail(AppDetail paramAppDetail)
  {
    this.mAppDetail = paramAppDetail;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.mAppDetail, paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/tsmservice/result/GetAppDetailResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */