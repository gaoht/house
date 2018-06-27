package com.ziroom.ziroomcustomer.ziroomapartment.model.sign;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ZryuSignCertType
  implements Parcelable
{
  public static final Parcelable.Creator<ZryuSignCertType> CREATOR = new Parcelable.Creator()
  {
    public ZryuSignCertType createFromParcel(Parcel paramAnonymousParcel)
    {
      return new ZryuSignCertType(paramAnonymousParcel);
    }
    
    public ZryuSignCertType[] newArray(int paramAnonymousInt)
    {
      return new ZryuSignCertType[paramAnonymousInt];
    }
  };
  private Integer code;
  private String name;
  
  public ZryuSignCertType() {}
  
  protected ZryuSignCertType(Parcel paramParcel)
  {
    this.name = paramParcel.readString();
    this.code = ((Integer)paramParcel.readValue(Integer.class.getClassLoader()));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Integer getCode()
  {
    return this.code;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public void setCode(Integer paramInteger)
  {
    this.code = paramInteger;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.name);
    paramParcel.writeValue(this.code);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/model/sign/ZryuSignCertType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */