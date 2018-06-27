package com.ziroom.ziroomcustomer.bestgoods.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class SKUMo
  implements Parcelable
{
  public static final Parcelable.Creator<SKUMo> CREATOR = new Parcelable.Creator()
  {
    public SKUMo createFromParcel(Parcel paramAnonymousParcel)
    {
      return new SKUMo(paramAnonymousParcel);
    }
    
    public SKUMo[] newArray(int paramAnonymousInt)
    {
      return new SKUMo[paramAnonymousInt];
    }
  };
  private String a;
  private String b;
  private int c;
  private int d;
  private String e;
  private String f;
  private Double g;
  private Double h;
  private String i;
  private String j;
  private double k;
  private boolean l;
  
  public SKUMo() {}
  
  protected SKUMo(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readInt();
    this.d = paramParcel.readInt();
    this.e = paramParcel.readString();
    this.f = paramParcel.readString();
    this.g = Double.valueOf(paramParcel.readDouble());
    this.i = paramParcel.readString();
    this.j = paramParcel.readString();
    this.k = paramParcel.readDouble();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.l = bool;
      return;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Double getActivityPrice()
  {
    return this.h;
  }
  
  public int getAmount()
  {
    return this.c;
  }
  
  public String getCityCode()
  {
    return this.f;
  }
  
  public String getCityName()
  {
    return this.e;
  }
  
  public int getCount()
  {
    return this.d;
  }
  
  public double getFreight()
  {
    return this.k;
  }
  
  public Double getPrice()
  {
    return this.g;
  }
  
  public String getProductCode()
  {
    return this.a;
  }
  
  public String getSkuCode()
  {
    return this.b;
  }
  
  public String getSkuImg()
  {
    return this.j;
  }
  
  public String getSkuName()
  {
    return this.i;
  }
  
  public boolean isChecked()
  {
    return this.l;
  }
  
  public void setActivityPrice(Double paramDouble)
  {
    this.h = paramDouble;
  }
  
  public void setAmount(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void setChecked(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public void setCityCode(String paramString)
  {
    this.f = paramString;
  }
  
  public void setCityName(String paramString)
  {
    this.e = paramString;
  }
  
  public void setCount(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setFreight(double paramDouble)
  {
    this.k = paramDouble;
  }
  
  public void setPrice(Double paramDouble)
  {
    this.g = paramDouble;
  }
  
  public void setProductCode(String paramString)
  {
    this.a = paramString;
  }
  
  public void setSkuCode(String paramString)
  {
    this.b = paramString;
  }
  
  public void setSkuImg(String paramString)
  {
    this.j = paramString;
  }
  
  public void setSkuName(String paramString)
  {
    this.i = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeInt(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeDouble(this.g.doubleValue());
    paramParcel.writeString(this.i);
    paramParcel.writeString(this.j);
    paramParcel.writeDouble(this.k);
    if (this.l) {}
    for (byte b1 = 1;; b1 = 0)
    {
      paramParcel.writeByte(b1);
      return;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/bestgoods/model/SKUMo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */