package com.ziroom.datacenter.remote.responsebody.financial.clean;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class CleanSupply
  implements Parcelable
{
  public static final Parcelable.Creator<CleanSupply> CREATOR = new Parcelable.Creator()
  {
    public CleanSupply createFromParcel(Parcel paramAnonymousParcel)
    {
      return new CleanSupply(paramAnonymousParcel);
    }
    
    public CleanSupply[] newArray(int paramAnonymousInt)
    {
      return new CleanSupply[paramAnonymousInt];
    }
  };
  private String a;
  private String b;
  private String c;
  private String d;
  private double e;
  private String f;
  private int g;
  
  public CleanSupply() {}
  
  protected CleanSupply(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readDouble();
    this.f = paramParcel.readString();
    this.g = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getDesc()
  {
    return this.f;
  }
  
  public String getGoodsId()
  {
    return this.a;
  }
  
  public String getLargeimgurl()
  {
    return this.c;
  }
  
  public String getName()
  {
    return this.d;
  }
  
  public int getNum()
  {
    return this.g;
  }
  
  public double getPrice()
  {
    return this.e;
  }
  
  public String getSmallimgurl()
  {
    return this.b;
  }
  
  public void setDesc(String paramString)
  {
    this.f = paramString;
  }
  
  public void setGoodsId(String paramString)
  {
    this.a = paramString;
  }
  
  public void setLargeimgurl(String paramString)
  {
    this.c = paramString;
  }
  
  public void setName(String paramString)
  {
    this.d = paramString;
  }
  
  public void setNum(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void setPrice(double paramDouble)
  {
    this.e = paramDouble;
  }
  
  public void setSmallimgurl(String paramString)
  {
    this.b = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeDouble(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeInt(this.g);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/datacenter/remote/responsebody/financial/clean/CleanSupply.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */