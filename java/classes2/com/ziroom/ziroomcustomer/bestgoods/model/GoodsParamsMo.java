package com.ziroom.ziroomcustomer.bestgoods.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class GoodsParamsMo
  implements Parcelable
{
  public static final Parcelable.Creator<GoodsParamsMo> CREATOR = new Parcelable.Creator()
  {
    public GoodsParamsMo createFromParcel(Parcel paramAnonymousParcel)
    {
      return new GoodsParamsMo(paramAnonymousParcel);
    }
    
    public GoodsParamsMo[] newArray(int paramAnonymousInt)
    {
      return new GoodsParamsMo[paramAnonymousInt];
    }
  };
  private String a;
  private String b;
  private String c;
  private String d;
  
  public GoodsParamsMo() {}
  
  protected GoodsParamsMo(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getAttributeName()
  {
    return this.a;
  }
  
  public String getAttributeNameCode()
  {
    return this.d;
  }
  
  public String getAttributeValue()
  {
    return this.b;
  }
  
  public String getAttributeimg()
  {
    return this.c;
  }
  
  public void setAttributeName(String paramString)
  {
    this.a = paramString;
  }
  
  public void setAttributeNameCode(String paramString)
  {
    this.d = paramString;
  }
  
  public void setAttributeValue(String paramString)
  {
    this.b = paramString;
  }
  
  public void setAttributeimg(String paramString)
  {
    this.c = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/bestgoods/model/GoodsParamsMo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */