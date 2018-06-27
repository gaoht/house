package com.ziroom.ziroomcustomer.minsu.landlordrelease.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class EditHouseRuleResult
  implements Parcelable
{
  public static final Parcelable.Creator<EditHouseRuleResult> CREATOR = new Parcelable.Creator()
  {
    public EditHouseRuleResult createFromParcel(Parcel paramAnonymousParcel)
    {
      return new EditHouseRuleResult(paramAnonymousParcel);
    }
    
    public EditHouseRuleResult[] newArray(int paramAnonymousInt)
    {
      return new EditHouseRuleResult[paramAnonymousInt];
    }
  };
  public String list;
  public String text;
  
  public EditHouseRuleResult() {}
  
  protected EditHouseRuleResult(Parcel paramParcel)
  {
    this.text = paramParcel.readString();
    this.list = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.text);
    paramParcel.writeString(this.list);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/model/EditHouseRuleResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */