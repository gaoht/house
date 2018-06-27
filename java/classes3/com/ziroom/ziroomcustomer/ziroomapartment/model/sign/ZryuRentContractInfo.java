package com.ziroom.ziroomcustomer.ziroomapartment.model.sign;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ZryuRentContractInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ZryuRentContractInfo> CREATOR = new Parcelable.Creator()
  {
    public ZryuRentContractInfo createFromParcel(Parcel paramAnonymousParcel)
    {
      return new ZryuRentContractInfo(paramAnonymousParcel);
    }
    
    public ZryuRentContractInfo[] newArray(int paramAnonymousInt)
    {
      return new ZryuRentContractInfo[paramAnonymousInt];
    }
  };
  private String conEndDate;
  private String conSignDate;
  private String conStartDate;
  
  public ZryuRentContractInfo() {}
  
  protected ZryuRentContractInfo(Parcel paramParcel)
  {
    this.conSignDate = paramParcel.readString();
    this.conStartDate = paramParcel.readString();
    this.conEndDate = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getConEndDate()
  {
    return this.conEndDate;
  }
  
  public String getConSignDate()
  {
    return this.conSignDate;
  }
  
  public String getConStartDate()
  {
    return this.conStartDate;
  }
  
  public void setConEndDate(String paramString)
  {
    this.conEndDate = paramString;
  }
  
  public void setConSignDate(String paramString)
  {
    this.conSignDate = paramString;
  }
  
  public void setConStartDate(String paramString)
  {
    this.conStartDate = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.conSignDate);
    paramParcel.writeString(this.conStartDate);
    paramParcel.writeString(this.conEndDate);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/model/sign/ZryuRentContractInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */