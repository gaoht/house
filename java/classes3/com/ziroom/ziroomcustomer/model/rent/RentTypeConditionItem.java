package com.ziroom.ziroomcustomer.model.rent;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class RentTypeConditionItem
  implements Parcelable
{
  public static final Parcelable.Creator<RentTypeConditionItem> CREATOR = new Parcelable.Creator()
  {
    public RentTypeConditionItem createFromParcel(Parcel paramAnonymousParcel)
    {
      return new RentTypeConditionItem(paramAnonymousParcel);
    }
    
    public RentTypeConditionItem[] newArray(int paramAnonymousInt)
    {
      return new RentTypeConditionItem[paramAnonymousInt];
    }
  };
  private boolean check;
  private String show;
  private String title;
  private Integer type;
  private String value;
  
  public RentTypeConditionItem() {}
  
  protected RentTypeConditionItem(Parcel paramParcel)
  {
    this.title = paramParcel.readString();
    this.value = paramParcel.readString();
    this.show = paramParcel.readString();
    this.type = ((Integer)paramParcel.readValue(Integer.class.getClassLoader()));
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.check = bool;
      return;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getShow()
  {
    return this.show;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public Integer getType()
  {
    return this.type;
  }
  
  public String getValue()
  {
    return this.value;
  }
  
  public boolean isCheck()
  {
    return this.check;
  }
  
  public void setCheck(boolean paramBoolean)
  {
    this.check = paramBoolean;
  }
  
  public void setShow(String paramString)
  {
    this.show = paramString;
  }
  
  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
  
  public void setType(Integer paramInteger)
  {
    this.type = paramInteger;
  }
  
  public void setValue(String paramString)
  {
    this.value = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.value);
    paramParcel.writeString(this.show);
    paramParcel.writeValue(this.type);
    if (this.check) {}
    for (byte b = 1;; b = 0)
    {
      paramParcel.writeByte(b);
      return;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/rent/RentTypeConditionItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */