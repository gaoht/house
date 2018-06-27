package com.unionpay.tsmservice.result;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.unionpay.tsmservice.data.VirtualCardInfo;

public class GetCardInfoBySpayResult
  implements Parcelable
{
  public static final Parcelable.Creator<GetCardInfoBySpayResult> CREATOR = new GetCardInfoBySpayResult.1();
  private VirtualCardInfo mVirtualCardInfo;
  
  public GetCardInfoBySpayResult() {}
  
  public GetCardInfoBySpayResult(Parcel paramParcel)
  {
    this.mVirtualCardInfo = ((VirtualCardInfo)paramParcel.readParcelable(VirtualCardInfo.class.getClassLoader()));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public VirtualCardInfo getVirtualCardInfo()
  {
    return this.mVirtualCardInfo;
  }
  
  public void setVirtualCardInfo(VirtualCardInfo paramVirtualCardInfo)
  {
    this.mVirtualCardInfo = paramVirtualCardInfo;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.mVirtualCardInfo, paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/tsmservice/result/GetCardInfoBySpayResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */