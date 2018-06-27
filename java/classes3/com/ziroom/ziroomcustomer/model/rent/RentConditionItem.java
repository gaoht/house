package com.ziroom.ziroomcustomer.model.rent;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.List;

public class RentConditionItem
  implements Parcelable
{
  public static final Parcelable.Creator<RentConditionItem> CREATOR = new Parcelable.Creator()
  {
    public RentConditionItem createFromParcel(Parcel paramAnonymousParcel)
    {
      return new RentConditionItem(paramAnonymousParcel);
    }
    
    public RentConditionItem[] newArray(int paramAnonymousInt)
    {
      return new RentConditionItem[paramAnonymousInt];
    }
  };
  private boolean check;
  private List<RentConditionItem> children;
  private String title;
  private String value;
  
  public RentConditionItem() {}
  
  protected RentConditionItem(Parcel paramParcel)
  {
    this.title = paramParcel.readString();
    this.value = paramParcel.readString();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.check = bool;
      this.children = paramParcel.createTypedArrayList(CREATOR);
      return;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    return paramObject.toString().equals(toString());
  }
  
  public List<RentConditionItem> getChildren()
  {
    return this.children;
  }
  
  public String getTitle()
  {
    return this.title;
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
  
  public void setChildren(List<RentConditionItem> paramList)
  {
    this.children = paramList;
  }
  
  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
  
  public void setValue(String paramString)
  {
    this.value = paramString;
  }
  
  public String toString()
  {
    return "RentConditionItem{title='" + this.title + '\'' + ", value='" + this.value + '\'' + ", children=" + this.children + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.value);
    if (this.check) {}
    for (byte b = 1;; b = 0)
    {
      paramParcel.writeByte(b);
      paramParcel.writeTypedList(this.children);
      return;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/rent/RentConditionItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */