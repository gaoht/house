package com.ziroom.datacenter.remote.responsebody.financial.youpin;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class YouPinCouponMo
  implements Parcelable
{
  public static final Parcelable.Creator<YouPinCouponMo> CREATOR = new Parcelable.Creator()
  {
    public YouPinCouponMo createFromParcel(Parcel paramAnonymousParcel)
    {
      return new YouPinCouponMo(paramAnonymousParcel);
    }
    
    public YouPinCouponMo[] newArray(int paramAnonymousInt)
    {
      return new YouPinCouponMo[paramAnonymousInt];
    }
  };
  private String a;
  private String b;
  private String c;
  private double d;
  private String e;
  private String f;
  private String g;
  private String h;
  private int i;
  
  public YouPinCouponMo() {}
  
  protected YouPinCouponMo(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readDouble();
    this.e = paramParcel.readString();
    this.f = paramParcel.readString();
    this.g = paramParcel.readString();
    this.h = paramParcel.readString();
    this.i = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getDescription()
  {
    return this.h;
  }
  
  public String getEndDate()
  {
    return this.f;
  }
  
  public String getPromoCode()
  {
    return this.b;
  }
  
  public String getPromoId()
  {
    return this.a;
  }
  
  public double getPromoPrice()
  {
    return this.d;
  }
  
  public String getStartDate()
  {
    return this.e;
  }
  
  public int getState()
  {
    return this.i;
  }
  
  public String getTypeCode()
  {
    return this.c;
  }
  
  public String getTypeName()
  {
    return this.g;
  }
  
  public void setDescription(String paramString)
  {
    this.h = paramString;
  }
  
  public void setEndDate(String paramString)
  {
    this.f = paramString;
  }
  
  public void setPromoCode(String paramString)
  {
    this.b = paramString;
  }
  
  public void setPromoId(String paramString)
  {
    this.a = paramString;
  }
  
  public void setPromoPrice(double paramDouble)
  {
    this.d = paramDouble;
  }
  
  public void setStartDate(String paramString)
  {
    this.e = paramString;
  }
  
  public void setState(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void setTypeCode(String paramString)
  {
    this.c = paramString;
  }
  
  public void setTypeName(String paramString)
  {
    this.g = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeDouble(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeString(this.h);
    paramParcel.writeInt(this.i);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/datacenter/remote/responsebody/financial/youpin/YouPinCouponMo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */