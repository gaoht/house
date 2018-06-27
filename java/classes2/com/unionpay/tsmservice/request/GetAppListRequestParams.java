package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class GetAppListRequestParams
  extends RequestParams
  implements Parcelable
{
  public static final Parcelable.Creator<GetAppListRequestParams> CREATOR = new GetAppListRequestParams.1();
  private String mKeyword;
  private String[] mStatus;
  
  public GetAppListRequestParams() {}
  
  public GetAppListRequestParams(Parcel paramParcel)
  {
    super(paramParcel);
    this.mKeyword = paramParcel.readString();
    this.mStatus = paramParcel.createStringArray();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getKeyword()
  {
    return this.mKeyword;
  }
  
  public String[] getStatus()
  {
    return this.mStatus;
  }
  
  public void setKeyword(String paramString)
  {
    this.mKeyword = paramString;
  }
  
  public void setStatus(String[] paramArrayOfString)
  {
    this.mStatus = paramArrayOfString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.mKeyword);
    paramParcel.writeStringArray(this.mStatus);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/tsmservice/request/GetAppListRequestParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */