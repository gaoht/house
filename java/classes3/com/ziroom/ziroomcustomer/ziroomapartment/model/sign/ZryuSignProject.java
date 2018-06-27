package com.ziroom.ziroomcustomer.ziroomapartment.model.sign;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ZryuSignProject
  implements Parcelable
{
  public static final Parcelable.Creator<ZryuSignProject> CREATOR = new Parcelable.Creator()
  {
    public ZryuSignProject createFromParcel(Parcel paramAnonymousParcel)
    {
      return new ZryuSignProject(paramAnonymousParcel);
    }
    
    public ZryuSignProject[] newArray(int paramAnonymousInt)
    {
      return new ZryuSignProject[paramAnonymousInt];
    }
  };
  private String proAddress;
  private String proHeadFigureUrl;
  private String proName;
  private String roomSalesPrice;
  
  public ZryuSignProject() {}
  
  protected ZryuSignProject(Parcel paramParcel)
  {
    this.proName = paramParcel.readString();
    this.proAddress = paramParcel.readString();
    this.proHeadFigureUrl = paramParcel.readString();
    this.roomSalesPrice = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getProAddress()
  {
    return this.proAddress;
  }
  
  public String getProHeadFigureUrl()
  {
    return this.proHeadFigureUrl;
  }
  
  public String getProName()
  {
    return this.proName;
  }
  
  public String getRoomSalesPrice()
  {
    return this.roomSalesPrice;
  }
  
  public void setProAddress(String paramString)
  {
    this.proAddress = paramString;
  }
  
  public void setProHeadFigureUrl(String paramString)
  {
    this.proHeadFigureUrl = paramString;
  }
  
  public void setProName(String paramString)
  {
    this.proName = paramString;
  }
  
  public void setRoomSalesPrice(String paramString)
  {
    this.roomSalesPrice = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.proName);
    paramParcel.writeString(this.proAddress);
    paramParcel.writeString(this.proHeadFigureUrl);
    paramParcel.writeString(this.roomSalesPrice);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/model/sign/ZryuSignProject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */