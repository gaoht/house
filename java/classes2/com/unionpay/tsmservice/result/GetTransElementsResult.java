package com.unionpay.tsmservice.result;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.unionpay.tsmservice.data.TransElement;
import java.util.Arrays;

public class GetTransElementsResult
  implements Parcelable
{
  public static final Parcelable.Creator<GetTransElementsResult> CREATOR = new GetTransElementsResult.1();
  private TransElement[] mCommonElements;
  private TransElement[] mCreditElements;
  private TransElement[] mDebitElements;
  
  public GetTransElementsResult() {}
  
  public GetTransElementsResult(Parcel paramParcel)
  {
    Parcelable[] arrayOfParcelable = paramParcel.readParcelableArray(TransElement.class.getClassLoader());
    if (arrayOfParcelable != null) {
      this.mDebitElements = ((TransElement[])Arrays.copyOf(arrayOfParcelable, arrayOfParcelable.length, TransElement[].class));
    }
    arrayOfParcelable = paramParcel.readParcelableArray(TransElement.class.getClassLoader());
    if (arrayOfParcelable != null) {
      this.mCreditElements = ((TransElement[])Arrays.copyOf(arrayOfParcelable, arrayOfParcelable.length, TransElement[].class));
    }
    paramParcel = paramParcel.readParcelableArray(TransElement.class.getClassLoader());
    if (paramParcel != null) {
      this.mCommonElements = ((TransElement[])Arrays.copyOf(paramParcel, paramParcel.length, TransElement[].class));
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public TransElement[] getCommonElements()
  {
    return this.mCommonElements;
  }
  
  public TransElement[] getCreditElements()
  {
    return this.mCreditElements;
  }
  
  public TransElement[] getDebitElements()
  {
    return this.mDebitElements;
  }
  
  public void setCommonElements(TransElement[] paramArrayOfTransElement)
  {
    this.mCommonElements = paramArrayOfTransElement;
  }
  
  public void setCreditElements(TransElement[] paramArrayOfTransElement)
  {
    this.mCreditElements = paramArrayOfTransElement;
  }
  
  public void setDebitElements(TransElement[] paramArrayOfTransElement)
  {
    this.mDebitElements = paramArrayOfTransElement;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelableArray(this.mDebitElements, paramInt);
    paramParcel.writeParcelableArray(this.mCreditElements, paramInt);
    paramParcel.writeParcelableArray(this.mCommonElements, paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/tsmservice/result/GetTransElementsResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */