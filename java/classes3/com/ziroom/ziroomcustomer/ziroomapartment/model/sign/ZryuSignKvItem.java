package com.ziroom.ziroomcustomer.ziroomapartment.model.sign;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ZryuSignKvItem
  implements Parcelable
{
  public static final Parcelable.Creator<ZryuSignKvItem> CREATOR = new Parcelable.Creator()
  {
    public ZryuSignKvItem createFromParcel(Parcel paramAnonymousParcel)
    {
      return new ZryuSignKvItem(paramAnonymousParcel);
    }
    
    public ZryuSignKvItem[] newArray(int paramAnonymousInt)
    {
      return new ZryuSignKvItem[paramAnonymousInt];
    }
  };
  private String description;
  private String name;
  private String value;
  
  public ZryuSignKvItem() {}
  
  protected ZryuSignKvItem(Parcel paramParcel)
  {
    this.name = paramParcel.readString();
    this.value = paramParcel.readString();
    this.description = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getDescription()
  {
    return this.description;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getValue()
  {
    return this.value;
  }
  
  public void setDescription(String paramString)
  {
    this.description = paramString;
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
    paramParcel.writeString(this.description);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/model/sign/ZryuSignKvItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */