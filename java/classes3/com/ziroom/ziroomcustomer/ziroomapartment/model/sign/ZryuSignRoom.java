package com.ziroom.ziroomcustomer.ziroomapartment.model.sign;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ZryuSignRoom
  implements Parcelable
{
  public static final Parcelable.Creator<ZryuSignRoom> CREATOR = new Parcelable.Creator()
  {
    public ZryuSignRoom createFromParcel(Parcel paramAnonymousParcel)
    {
      return new ZryuSignRoom(paramAnonymousParcel);
    }
    
    public ZryuSignRoom[] newArray(int paramAnonymousInt)
    {
      return new ZryuSignRoom[paramAnonymousInt];
    }
  };
  private String floorNumber;
  private String houseTypeName;
  private String roomDirection;
  
  public ZryuSignRoom() {}
  
  protected ZryuSignRoom(Parcel paramParcel)
  {
    this.houseTypeName = paramParcel.readString();
    this.floorNumber = paramParcel.readString();
    this.roomDirection = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getFloorNumber()
  {
    return this.floorNumber;
  }
  
  public String getHouseTypeName()
  {
    return this.houseTypeName;
  }
  
  public String getRoomDirection()
  {
    return this.roomDirection;
  }
  
  public void setFloorNumber(String paramString)
  {
    this.floorNumber = paramString;
  }
  
  public void setHouseTypeName(String paramString)
  {
    this.houseTypeName = paramString;
  }
  
  public void setRoomDirection(String paramString)
  {
    this.roomDirection = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.houseTypeName);
    paramParcel.writeString(this.floorNumber);
    paramParcel.writeString(this.roomDirection);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/model/sign/ZryuSignRoom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */