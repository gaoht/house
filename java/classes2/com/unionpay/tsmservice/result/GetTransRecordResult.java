package com.unionpay.tsmservice.result;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.unionpay.tsmservice.data.TransRecord;
import java.util.Arrays;

public class GetTransRecordResult
  implements Parcelable
{
  public static final Parcelable.Creator<GetTransRecordResult> CREATOR = new GetTransRecordResult.1();
  private TransRecord[] mTransRecord;
  
  public GetTransRecordResult() {}
  
  public GetTransRecordResult(Parcel paramParcel)
  {
    paramParcel = paramParcel.readParcelableArray(TransRecord.class.getClassLoader());
    if (paramParcel != null) {
      this.mTransRecord = ((TransRecord[])Arrays.copyOf(paramParcel, paramParcel.length, TransRecord[].class));
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public TransRecord[] getTransRecord()
  {
    return this.mTransRecord;
  }
  
  public void setTransRecord(TransRecord[] paramArrayOfTransRecord)
  {
    this.mTransRecord = paramArrayOfTransRecord;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelableArray(this.mTransRecord, paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/tsmservice/result/GetTransRecordResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */