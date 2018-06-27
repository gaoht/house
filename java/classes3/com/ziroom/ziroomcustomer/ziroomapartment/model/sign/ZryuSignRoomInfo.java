package com.ziroom.ziroomcustomer.ziroomapartment.model.sign;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ZryuSignRoomInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ZryuSignRoomInfo> CREATOR = new Parcelable.Creator()
  {
    public ZryuSignRoomInfo createFromParcel(Parcel paramAnonymousParcel)
    {
      return new ZryuSignRoomInfo(paramAnonymousParcel);
    }
    
    public ZryuSignRoomInfo[] newArray(int paramAnonymousInt)
    {
      return new ZryuSignRoomInfo[paramAnonymousInt];
    }
  };
  private String contractCode;
  private String contractId;
  private String handleZOPhone;
  private ZryuSignProject projectInfo;
  private String rentTime;
  private ZryuSignRoom roomInfo;
  
  public ZryuSignRoomInfo() {}
  
  protected ZryuSignRoomInfo(Parcel paramParcel)
  {
    this.handleZOPhone = paramParcel.readString();
    this.contractId = paramParcel.readString();
    this.contractCode = paramParcel.readString();
    this.projectInfo = ((ZryuSignProject)paramParcel.readParcelable(ZryuSignProject.class.getClassLoader()));
    this.roomInfo = ((ZryuSignRoom)paramParcel.readParcelable(ZryuSignRoom.class.getClassLoader()));
    this.rentTime = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getContractCode()
  {
    return this.contractCode;
  }
  
  public String getContractId()
  {
    return this.contractId;
  }
  
  public String getHandleZOPhone()
  {
    return this.handleZOPhone;
  }
  
  public ZryuSignProject getProjectInfo()
  {
    return this.projectInfo;
  }
  
  public String getRentTime()
  {
    return this.rentTime;
  }
  
  public ZryuSignRoom getRoomInfo()
  {
    return this.roomInfo;
  }
  
  public void setContractCode(String paramString)
  {
    this.contractCode = paramString;
  }
  
  public void setContractId(String paramString)
  {
    this.contractId = paramString;
  }
  
  public void setHandleZOPhone(String paramString)
  {
    this.handleZOPhone = paramString;
  }
  
  public void setProjectInfo(ZryuSignProject paramZryuSignProject)
  {
    this.projectInfo = paramZryuSignProject;
  }
  
  public void setRentTime(String paramString)
  {
    this.rentTime = paramString;
  }
  
  public void setRoomInfo(ZryuSignRoom paramZryuSignRoom)
  {
    this.roomInfo = paramZryuSignRoom;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.handleZOPhone);
    paramParcel.writeString(this.contractId);
    paramParcel.writeString(this.contractCode);
    paramParcel.writeParcelable(this.projectInfo, paramInt);
    paramParcel.writeParcelable(this.roomInfo, paramInt);
    paramParcel.writeString(this.rentTime);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/model/sign/ZryuSignRoomInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */