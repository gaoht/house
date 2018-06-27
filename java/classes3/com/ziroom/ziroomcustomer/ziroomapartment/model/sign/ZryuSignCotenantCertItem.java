package com.ziroom.ziroomcustomer.ziroomapartment.model.sign;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ZryuSignCotenantCertItem
  implements Parcelable
{
  public static final Parcelable.Creator<ZryuSignCotenantCertItem> CREATOR = new Parcelable.Creator()
  {
    public ZryuSignCotenantCertItem createFromParcel(Parcel paramAnonymousParcel)
    {
      return new ZryuSignCotenantCertItem(paramAnonymousParcel);
    }
    
    public ZryuSignCotenantCertItem[] newArray(int paramAnonymousInt)
    {
      return new ZryuSignCotenantCertItem[paramAnonymousInt];
    }
  };
  private String code;
  private String name;
  private String value;
  
  public ZryuSignCotenantCertItem() {}
  
  protected ZryuSignCotenantCertItem(Parcel paramParcel)
  {
    this.name = paramParcel.readString();
    this.value = paramParcel.readString();
    this.code = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getCode()
  {
    return this.code;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getValue()
  {
    return this.value;
  }
  
  public void setCode(String paramString)
  {
    this.code = paramString;
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
    paramParcel.writeString(this.code);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/model/sign/ZryuSignCotenantCertItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */