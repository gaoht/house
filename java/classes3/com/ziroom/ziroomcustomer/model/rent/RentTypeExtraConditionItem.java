package com.ziroom.ziroomcustomer.model.rent;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class RentTypeExtraConditionItem
  implements Parcelable
{
  public static final Parcelable.Creator<RentTypeExtraConditionItem> CREATOR = new Parcelable.Creator()
  {
    public RentTypeExtraConditionItem createFromParcel(Parcel paramAnonymousParcel)
    {
      return new RentTypeExtraConditionItem(paramAnonymousParcel);
    }
    
    public RentTypeExtraConditionItem[] newArray(int paramAnonymousInt)
    {
      return new RentTypeExtraConditionItem[paramAnonymousInt];
    }
  };
  private String desc;
  private String link;
  private String link_text;
  private String title;
  private Integer type;
  
  public RentTypeExtraConditionItem() {}
  
  protected RentTypeExtraConditionItem(Parcel paramParcel)
  {
    this.type = ((Integer)paramParcel.readValue(Integer.class.getClassLoader()));
    this.title = paramParcel.readString();
    this.desc = paramParcel.readString();
    this.link = paramParcel.readString();
    this.link_text = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getDesc()
  {
    return this.desc;
  }
  
  public String getLink()
  {
    return this.link;
  }
  
  public String getLink_text()
  {
    return this.link_text;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public Integer getType()
  {
    return this.type;
  }
  
  public void setDesc(String paramString)
  {
    this.desc = paramString;
  }
  
  public void setLink(String paramString)
  {
    this.link = paramString;
  }
  
  public void setLink_text(String paramString)
  {
    this.link_text = paramString;
  }
  
  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
  
  public void setType(Integer paramInteger)
  {
    this.type = paramInteger;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeValue(this.type);
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.desc);
    paramParcel.writeString(this.link);
    paramParcel.writeString(this.link_text);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/rent/RentTypeExtraConditionItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */