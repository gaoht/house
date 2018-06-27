package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.unionpay.tsmservice.data.Amount;

public class GetCardInfoBySpayRequestParams
  extends RequestParams
{
  public static final Parcelable.Creator<GetCardInfoBySpayRequestParams> CREATOR = new GetCardInfoBySpayRequestParams.1();
  private Amount mAmount;
  
  public GetCardInfoBySpayRequestParams() {}
  
  public GetCardInfoBySpayRequestParams(Parcel paramParcel)
  {
    super(paramParcel);
    this.mAmount = ((Amount)paramParcel.readParcelable(Amount.class.getClassLoader()));
  }
  
  public Amount getAmount()
  {
    return this.mAmount;
  }
  
  public void setAmount(Amount paramAmount)
  {
    this.mAmount = paramAmount;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeParcelable(this.mAmount, paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/tsmservice/request/GetCardInfoBySpayRequestParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */