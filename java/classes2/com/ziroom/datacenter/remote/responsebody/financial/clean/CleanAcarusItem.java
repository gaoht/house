package com.ziroom.datacenter.remote.responsebody.financial.clean;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class CleanAcarusItem
  implements Parcelable
{
  public static final Parcelable.Creator<CleanAcarusItem> CREATOR = new Parcelable.Creator()
  {
    public CleanAcarusItem createFromParcel(Parcel paramAnonymousParcel)
    {
      return new CleanAcarusItem(paramAnonymousParcel);
    }
    
    public CleanAcarusItem[] newArray(int paramAnonymousInt)
    {
      return new CleanAcarusItem[paramAnonymousInt];
    }
  };
  private String a;
  private String b;
  private String c;
  private String d;
  private int e;
  private String f;
  private int g;
  private String h;
  private int i;
  private boolean j = false;
  
  public CleanAcarusItem() {}
  
  protected CleanAcarusItem(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readInt();
    this.f = paramParcel.readString();
    this.g = paramParcel.readInt();
    this.h = paramParcel.readString();
    this.i = paramParcel.readInt();
    if (paramParcel.readByte() != 0) {
      bool = true;
    }
    this.j = bool;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getAreaFlag()
  {
    return this.g;
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
  
  public int getNumber()
  {
    return this.i;
  }
  
  public int getPrice()
  {
    return this.e;
  }
  
  public String getSmallimgurl()
  {
    return this.b;
  }
  
  public String getStandard()
  {
    return this.h;
  }
  
  public boolean isIsArea()
  {
    return this.j;
  }
  
  public void setAreaFlag(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void setDesc(String paramString)
  {
    this.f = paramString;
  }
  
  public void setGoodsId(String paramString)
  {
    this.a = paramString;
  }
  
  public void setIsArea(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  public void setLargeimgurl(String paramString)
  {
    this.c = paramString;
  }
  
  public void setName(String paramString)
  {
    this.d = paramString;
  }
  
  public void setNumber(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void setPrice(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setSmallimgurl(String paramString)
  {
    this.b = paramString;
  }
  
  public void setStandard(String paramString)
  {
    this.h = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeInt(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeInt(this.g);
    paramParcel.writeString(this.h);
    paramParcel.writeInt(this.i);
    if (this.j) {}
    for (byte b1 = 1;; b1 = 0)
    {
      paramParcel.writeByte(b1);
      return;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/datacenter/remote/responsebody/financial/clean/CleanAcarusItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */