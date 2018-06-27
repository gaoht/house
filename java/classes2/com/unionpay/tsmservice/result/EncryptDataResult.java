package com.unionpay.tsmservice.result;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

public class EncryptDataResult
  implements Parcelable
{
  public static final Parcelable.Creator<EncryptDataResult> CREATOR = new EncryptDataResult.1();
  private List<String> mEncryptData;
  
  public EncryptDataResult() {}
  
  public EncryptDataResult(Parcel paramParcel)
  {
    this.mEncryptData = new ArrayList();
    paramParcel.readList(this.mEncryptData, ClassLoader.getSystemClassLoader());
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public List<String> getEncryptData()
  {
    return this.mEncryptData;
  }
  
  public void setEncryptData(List<String> paramList)
  {
    this.mEncryptData = paramList;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeList(this.mEncryptData);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/tsmservice/result/EncryptDataResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */