package com.unionpay.tsmservice.result;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.unionpay.tsmservice.data.AssociatedCardBalance;

public class GetAccountBalanceResult
  implements Parcelable
{
  public static final Parcelable.Creator<GetAccountBalanceResult> CREATOR = new GetAccountBalanceResult.1();
  private AssociatedCardBalance mAssociatedCardBalance;
  
  public GetAccountBalanceResult() {}
  
  public GetAccountBalanceResult(Parcel paramParcel)
  {
    this.mAssociatedCardBalance = ((AssociatedCardBalance)paramParcel.readParcelable(AssociatedCardBalance.class.getClassLoader()));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public AssociatedCardBalance getAssociatedCardBalance()
  {
    return this.mAssociatedCardBalance;
  }
  
  public void setAssociatedCardBalance(AssociatedCardBalance paramAssociatedCardBalance)
  {
    this.mAssociatedCardBalance = paramAssociatedCardBalance;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.mAssociatedCardBalance, paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/tsmservice/result/GetAccountBalanceResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */