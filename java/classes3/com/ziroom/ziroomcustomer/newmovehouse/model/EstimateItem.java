package com.ziroom.ziroomcustomer.newmovehouse.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class EstimateItem
  implements Parcelable
{
  public static final Parcelable.Creator<EstimateItem> CREATOR = new Parcelable.Creator()
  {
    public EstimateItem createFromParcel(Parcel paramAnonymousParcel)
    {
      return new EstimateItem(paramAnonymousParcel);
    }
    
    public EstimateItem[] newArray(int paramAnonymousInt)
    {
      return new EstimateItem[paramAnonymousInt];
    }
  };
  private String name;
  private String value;
  
  public EstimateItem() {}
  
  protected EstimateItem(Parcel paramParcel)
  {
    this.name = paramParcel.readString();
    this.value = paramParcel.readString();
  }
  
  public EstimateItem(String paramString1, String paramString2)
  {
    this.name = paramString1;
    this.value = paramString2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getValue()
  {
    return this.value;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setValue(String paramString)
  {
    this.value = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.name);
    paramParcel.writeString(this.value);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/model/EstimateItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */