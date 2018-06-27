package com.ziroom.ziroomcustomer.newServiceList.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class AddressMo
  implements Parcelable
{
  public static final Parcelable.Creator<AddressMo> CREATOR = new Parcelable.Creator()
  {
    public AddressMo createFromParcel(Parcel paramAnonymousParcel)
    {
      return new AddressMo(paramAnonymousParcel);
    }
    
    public AddressMo[] newArray(int paramAnonymousInt)
    {
      return new AddressMo[paramAnonymousInt];
    }
  };
  private String a;
  private String b;
  private String c;
  private String d;
  private String e;
  private String f;
  private String g;
  private String h;
  private String i;
  private String j;
  private String k;
  private String l;
  private String m;
  private String n;
  
  public AddressMo() {}
  
  protected AddressMo(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
    this.f = paramParcel.readString();
    this.g = paramParcel.readString();
    this.h = paramParcel.readString();
    this.i = paramParcel.readString();
    this.j = paramParcel.readString();
    this.k = paramParcel.readString();
    this.l = paramParcel.readString();
    this.m = paramParcel.readString();
    this.n = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getCityCode()
  {
    return this.f;
  }
  
  public String getDataSource()
  {
    return this.n;
  }
  
  public String getDetAddress()
  {
    return this.k;
  }
  
  public String getFid()
  {
    return this.a;
  }
  
  public String getGrade()
  {
    return this.j;
  }
  
  public String getHouseCode()
  {
    return this.m;
  }
  
  public String getLatitude()
  {
    return this.h;
  }
  
  public String getLinkPhone()
  {
    return this.l;
  }
  
  public String getLongitude()
  {
    return this.g;
  }
  
  public String getProvinceCode()
  {
    return this.e;
  }
  
  public String getUserAccount()
  {
    return this.d;
  }
  
  public String getUserId()
  {
    return this.b;
  }
  
  public String getUserName()
  {
    return this.c;
  }
  
  public String getVillage()
  {
    return this.i;
  }
  
  public void setCityCode(String paramString)
  {
    this.f = paramString;
  }
  
  public void setDataSource(String paramString)
  {
    this.n = paramString;
  }
  
  public void setDetAddress(String paramString)
  {
    this.k = paramString;
  }
  
  public void setFid(String paramString)
  {
    this.a = paramString;
  }
  
  public void setGrade(String paramString)
  {
    this.j = paramString;
  }
  
  public void setHouseCode(String paramString)
  {
    this.m = paramString;
  }
  
  public void setLatitude(String paramString)
  {
    this.h = paramString;
  }
  
  public void setLinkPhone(String paramString)
  {
    this.l = paramString;
  }
  
  public void setLongitude(String paramString)
  {
    this.g = paramString;
  }
  
  public void setProvinceCode(String paramString)
  {
    this.e = paramString;
  }
  
  public void setUserAccount(String paramString)
  {
    this.d = paramString;
  }
  
  public void setUserId(String paramString)
  {
    this.b = paramString;
  }
  
  public void setUserName(String paramString)
  {
    this.c = paramString;
  }
  
  public void setVillage(String paramString)
  {
    this.i = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeString(this.h);
    paramParcel.writeString(this.i);
    paramParcel.writeString(this.j);
    paramParcel.writeString(this.k);
    paramParcel.writeString(this.l);
    paramParcel.writeString(this.m);
    paramParcel.writeString(this.n);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/model/AddressMo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */