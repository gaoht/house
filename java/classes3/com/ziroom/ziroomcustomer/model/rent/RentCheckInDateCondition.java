package com.ziroom.ziroomcustomer.model.rent;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class RentCheckInDateCondition
  implements Parcelable
{
  public static final Parcelable.Creator<RentCheckInDateCondition> CREATOR = new Parcelable.Creator()
  {
    public RentCheckInDateCondition createFromParcel(Parcel paramAnonymousParcel)
    {
      return new RentCheckInDateCondition(paramAnonymousParcel);
    }
    
    public RentCheckInDateCondition[] newArray(int paramAnonymousInt)
    {
      return new RentCheckInDateCondition[paramAnonymousInt];
    }
  };
  private String end_date;
  private String start_date;
  
  public RentCheckInDateCondition() {}
  
  protected RentCheckInDateCondition(Parcel paramParcel)
  {
    this.start_date = paramParcel.readString();
    this.end_date = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getEnd_date()
  {
    return this.end_date;
  }
  
  public String getStart_date()
  {
    return this.start_date;
  }
  
  public void setEnd_date(String paramString)
  {
    this.end_date = paramString;
  }
  
  public void setStart_date(String paramString)
  {
    this.start_date = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.start_date);
    paramParcel.writeString(this.end_date);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/rent/RentCheckInDateCondition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */