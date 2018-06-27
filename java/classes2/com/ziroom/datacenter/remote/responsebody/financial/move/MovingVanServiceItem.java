package com.ziroom.datacenter.remote.responsebody.financial.move;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class MovingVanServiceItem
  implements Parcelable
{
  public static final Parcelable.Creator<MovingVanServiceItem> CREATOR = new Parcelable.Creator()
  {
    public MovingVanServiceItem createFromParcel(Parcel paramAnonymousParcel)
    {
      return new MovingVanServiceItem(paramAnonymousParcel);
    }
    
    public MovingVanServiceItem[] newArray(int paramAnonymousInt)
    {
      return new MovingVanServiceItem[paramAnonymousInt];
    }
  };
  public int a;
  private String b;
  private String c;
  private String d;
  private String e;
  private String f;
  private String g;
  private long h;
  private Integer i;
  private Integer j;
  private Integer k;
  private String l;
  private String m;
  
  public MovingVanServiceItem() {}
  
  protected MovingVanServiceItem(Parcel paramParcel)
  {
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
    this.f = paramParcel.readString();
    this.g = paramParcel.readString();
    this.h = paramParcel.readLong();
    this.i = ((Integer)paramParcel.readValue(Integer.class.getClassLoader()));
    this.j = ((Integer)paramParcel.readValue(Integer.class.getClassLoader()));
    this.k = ((Integer)paramParcel.readValue(Integer.class.getClassLoader()));
    this.l = paramParcel.readString();
    this.m = paramParcel.readString();
    this.a = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject != null) && (getLogicCode() != null)) {
      return getLogicCode().equals(((MovingVanServiceItem)paramObject).getLogicCode());
    }
    return super.equals(paramObject);
  }
  
  public int getBuyNumber()
  {
    return this.a;
  }
  
  public String getCategoryCode()
  {
    return this.c;
  }
  
  public String getCityCode()
  {
    return this.d;
  }
  
  public String getImageAlt()
  {
    return this.m;
  }
  
  public String getImageUrl()
  {
    return this.l;
  }
  
  public Integer getIsValuation()
  {
    return this.i;
  }
  
  public String getLogicCode()
  {
    return this.b;
  }
  
  public String getServiceDetail()
  {
    return this.f;
  }
  
  public String getServiceName()
  {
    return this.e;
  }
  
  public long getServicePrice()
  {
    return this.h;
  }
  
  public String getServiceSpecification()
  {
    return this.g;
  }
  
  public Integer getServiceStatus()
  {
    return this.j;
  }
  
  public Integer getServiceType()
  {
    return this.k;
  }
  
  public void setBuyNumber(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void setCategoryCode(String paramString)
  {
    this.c = paramString;
  }
  
  public void setCityCode(String paramString)
  {
    this.d = paramString;
  }
  
  public void setImageAlt(String paramString)
  {
    this.m = paramString;
  }
  
  public void setImageUrl(String paramString)
  {
    this.l = paramString;
  }
  
  public void setIsValuation(Integer paramInteger)
  {
    this.i = paramInteger;
  }
  
  public void setLogicCode(String paramString)
  {
    this.b = paramString;
  }
  
  public void setServiceDetail(String paramString)
  {
    this.f = paramString;
  }
  
  public void setServiceName(String paramString)
  {
    this.e = paramString;
  }
  
  public void setServicePrice(long paramLong)
  {
    this.h = paramLong;
  }
  
  public void setServiceSpecification(String paramString)
  {
    this.g = paramString;
  }
  
  public void setServiceStatus(Integer paramInteger)
  {
    this.j = paramInteger;
  }
  
  public void setServiceType(Integer paramInteger)
  {
    this.k = paramInteger;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeLong(this.h);
    paramParcel.writeValue(this.i);
    paramParcel.writeValue(this.j);
    paramParcel.writeValue(this.k);
    paramParcel.writeString(this.l);
    paramParcel.writeString(this.m);
    paramParcel.writeInt(this.a);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/datacenter/remote/responsebody/financial/move/MovingVanServiceItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */