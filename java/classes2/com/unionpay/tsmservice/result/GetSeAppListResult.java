package com.unionpay.tsmservice.result;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.unionpay.tsmservice.data.SeAppListItem;

public class GetSeAppListResult
  implements Parcelable
{
  public static final Parcelable.Creator<GetSeAppListResult> CREATOR = new GetSeAppListResult.1();
  private SeAppListItem[] mSeAppList;
  
  public GetSeAppListResult() {}
  
  public GetSeAppListResult(Parcel paramParcel)
  {
    this.mSeAppList = ((SeAppListItem[])paramParcel.createTypedArray(SeAppListItem.CREATOR));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public SeAppListItem[] getSeAppList()
  {
    return this.mSeAppList;
  }
  
  public void setSeAppList(SeAppListItem[] paramArrayOfSeAppListItem)
  {
    this.mSeAppList = paramArrayOfSeAppListItem;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeTypedArray(this.mSeAppList, paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/tsmservice/result/GetSeAppListResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */