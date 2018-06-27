package com.unionpay.tsmservice.result;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.unionpay.tsmservice.data.AssociatedCardInfo;

public class GetAccountInfoResult
  implements Parcelable
{
  public static final Parcelable.Creator<GetAccountInfoResult> CREATOR = new GetAccountInfoResult.1();
  private AssociatedCardInfo mAssociatedCardInfo;
  
  public GetAccountInfoResult() {}
  
  public GetAccountInfoResult(Parcel paramParcel)
  {
    this.mAssociatedCardInfo = ((AssociatedCardInfo)paramParcel.readParcelable(AssociatedCardInfo.class.getClassLoader()));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public AssociatedCardInfo getAssociatedCardInfo()
  {
    return this.mAssociatedCardInfo;
  }
  
  public void setAssociatedCardInfo(AssociatedCardInfo paramAssociatedCardInfo)
  {
    this.mAssociatedCardInfo = paramAssociatedCardInfo;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.mAssociatedCardInfo, paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/tsmservice/result/GetAccountInfoResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */