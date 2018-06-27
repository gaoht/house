package com.unionpay.tsmservice.result;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.unionpay.tsmservice.data.VirtualCardInfo;

public class GetCardInfoResult
  implements Parcelable
{
  public static final Parcelable.Creator<GetCardInfoResult> CREATOR = new GetCardInfoResult.1();
  private VirtualCardInfo[] mVirtualCardInfo;
  
  public GetCardInfoResult() {}
  
  public GetCardInfoResult(Parcel paramParcel)
  {
    this.mVirtualCardInfo = ((VirtualCardInfo[])paramParcel.createTypedArray(VirtualCardInfo.CREATOR));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public VirtualCardInfo[] getVirtualCardInfo()
  {
    return this.mVirtualCardInfo;
  }
  
  public void setVirtualCardInfo(VirtualCardInfo[] paramArrayOfVirtualCardInfo)
  {
    this.mVirtualCardInfo = paramArrayOfVirtualCardInfo;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeTypedArray(this.mVirtualCardInfo, paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/tsmservice/result/GetCardInfoResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */