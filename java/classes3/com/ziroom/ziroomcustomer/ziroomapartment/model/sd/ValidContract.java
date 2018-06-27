package com.ziroom.ziroomcustomer.ziroomapartment.model.sd;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ValidContract
  implements Parcelable
{
  public static final Parcelable.Creator<ValidContract> CREATOR = new Parcelable.Creator()
  {
    public ValidContract createFromParcel(Parcel paramAnonymousParcel)
    {
      return new ValidContract(paramAnonymousParcel);
    }
    
    public ValidContract[] newArray(int paramAnonymousInt)
    {
      return new ValidContract[paramAnonymousInt];
    }
  };
  private String busiLine;
  private String cityCode;
  private String cityName;
  private String contractCode;
  private String contractId;
  private String customerMobile;
  private String customerName;
  private Integer customerType;
  private Integer isSmartLock;
  private Integer isSmartWatermeter;
  private Integer isSmartWattmeter;
  private String projectId;
  private String projectName;
  private String roomCode;
  private String roomId;
  
  public ValidContract() {}
  
  protected ValidContract(Parcel paramParcel)
  {
    this.busiLine = paramParcel.readString();
    this.cityCode = paramParcel.readString();
    this.cityName = paramParcel.readString();
    this.contractCode = paramParcel.readString();
    this.contractId = paramParcel.readString();
    this.customerMobile = paramParcel.readString();
    this.customerName = paramParcel.readString();
    this.customerType = ((Integer)paramParcel.readValue(Integer.class.getClassLoader()));
    this.isSmartLock = ((Integer)paramParcel.readValue(Integer.class.getClassLoader()));
    this.isSmartWatermeter = ((Integer)paramParcel.readValue(Integer.class.getClassLoader()));
    this.isSmartWattmeter = ((Integer)paramParcel.readValue(Integer.class.getClassLoader()));
    this.projectId = paramParcel.readString();
    this.projectName = paramParcel.readString();
    this.roomCode = paramParcel.readString();
    this.roomId = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getBusiLine()
  {
    return this.busiLine;
  }
  
  public String getCityCode()
  {
    return this.cityCode;
  }
  
  public String getCityName()
  {
    return this.cityName;
  }
  
  public String getContractCode()
  {
    return this.contractCode;
  }
  
  public String getContractId()
  {
    return this.contractId;
  }
  
  public String getCustomerMobile()
  {
    return this.customerMobile;
  }
  
  public String getCustomerName()
  {
    return this.customerName;
  }
  
  public Integer getCustomerType()
  {
    return this.customerType;
  }
  
  public Integer getIsSmartLock()
  {
    return this.isSmartLock;
  }
  
  public Integer getIsSmartWatermeter()
  {
    return this.isSmartWatermeter;
  }
  
  public Integer getIsSmartWattmeter()
  {
    return this.isSmartWattmeter;
  }
  
  public String getProjectId()
  {
    return this.projectId;
  }
  
  public String getProjectName()
  {
    return this.projectName;
  }
  
  public String getRoomCode()
  {
    return this.roomCode;
  }
  
  public String getRoomId()
  {
    return this.roomId;
  }
  
  public void setBusiLine(String paramString)
  {
    this.busiLine = paramString;
  }
  
  public void setCityCode(String paramString)
  {
    this.cityCode = paramString;
  }
  
  public void setCityName(String paramString)
  {
    this.cityName = paramString;
  }
  
  public void setContractCode(String paramString)
  {
    this.contractCode = paramString;
  }
  
  public void setContractId(String paramString)
  {
    this.contractId = paramString;
  }
  
  public void setCustomerMobile(String paramString)
  {
    this.customerMobile = paramString;
  }
  
  public void setCustomerName(String paramString)
  {
    this.customerName = paramString;
  }
  
  public void setCustomerType(Integer paramInteger)
  {
    this.customerType = paramInteger;
  }
  
  public void setIsSmartLock(Integer paramInteger)
  {
    this.isSmartLock = paramInteger;
  }
  
  public void setIsSmartWatermeter(Integer paramInteger)
  {
    this.isSmartWatermeter = paramInteger;
  }
  
  public void setIsSmartWattmeter(Integer paramInteger)
  {
    this.isSmartWattmeter = paramInteger;
  }
  
  public void setProjectId(String paramString)
  {
    this.projectId = paramString;
  }
  
  public void setProjectName(String paramString)
  {
    this.projectName = paramString;
  }
  
  public void setRoomCode(String paramString)
  {
    this.roomCode = paramString;
  }
  
  public void setRoomId(String paramString)
  {
    this.roomId = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.busiLine);
    paramParcel.writeString(this.cityCode);
    paramParcel.writeString(this.cityName);
    paramParcel.writeString(this.contractCode);
    paramParcel.writeString(this.contractId);
    paramParcel.writeString(this.customerMobile);
    paramParcel.writeString(this.customerName);
    paramParcel.writeValue(this.customerType);
    paramParcel.writeValue(this.isSmartLock);
    paramParcel.writeValue(this.isSmartWatermeter);
    paramParcel.writeValue(this.isSmartWattmeter);
    paramParcel.writeString(this.projectId);
    paramParcel.writeString(this.projectName);
    paramParcel.writeString(this.roomCode);
    paramParcel.writeString(this.roomId);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/model/sd/ValidContract.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */