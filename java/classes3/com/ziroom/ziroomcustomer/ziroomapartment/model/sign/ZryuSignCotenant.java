package com.ziroom.ziroomcustomer.ziroomapartment.model.sign;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ZryuSignCotenant
  implements Parcelable
{
  public static final Parcelable.Creator<ZryuSignCotenant> CREATOR = new Parcelable.Creator()
  {
    public ZryuSignCotenant createFromParcel(Parcel paramAnonymousParcel)
    {
      return new ZryuSignCotenant(paramAnonymousParcel);
    }
    
    public ZryuSignCotenant[] newArray(int paramAnonymousInt)
    {
      return new ZryuSignCotenant[paramAnonymousInt];
    }
  };
  private ZryuSignCotenantCertItem certInfo;
  private String fid;
  private String name;
  private String phone;
  
  public ZryuSignCotenant() {}
  
  protected ZryuSignCotenant(Parcel paramParcel)
  {
    this.fid = paramParcel.readString();
    this.name = paramParcel.readString();
    this.phone = paramParcel.readString();
    this.certInfo = ((ZryuSignCotenantCertItem)paramParcel.readParcelable(ZryuSignCotenantCertItem.class.getClassLoader()));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public ZryuSignCotenantCertItem getCertInfo()
  {
    return this.certInfo;
  }
  
  public String getFid()
  {
    return this.fid;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getPhone()
  {
    return this.phone;
  }
  
  public void setCertInfo(ZryuSignCotenantCertItem paramZryuSignCotenantCertItem)
  {
    this.certInfo = paramZryuSignCotenantCertItem;
  }
  
  public void setFid(String paramString)
  {
    this.fid = paramString;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setPhone(String paramString)
  {
    this.phone = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.fid);
    paramParcel.writeString(this.name);
    paramParcel.writeString(this.phone);
    paramParcel.writeParcelable(this.certInfo, paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/model/sign/ZryuSignCotenant.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */