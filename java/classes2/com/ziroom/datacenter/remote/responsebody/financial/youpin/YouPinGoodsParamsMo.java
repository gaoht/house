package com.ziroom.datacenter.remote.responsebody.financial.youpin;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class YouPinGoodsParamsMo
  implements Parcelable
{
  public static final Parcelable.Creator<YouPinGoodsParamsMo> CREATOR = new Parcelable.Creator()
  {
    public YouPinGoodsParamsMo createFromParcel(Parcel paramAnonymousParcel)
    {
      return new YouPinGoodsParamsMo(paramAnonymousParcel);
    }
    
    public YouPinGoodsParamsMo[] newArray(int paramAnonymousInt)
    {
      return new YouPinGoodsParamsMo[paramAnonymousInt];
    }
  };
  private String a;
  private String b;
  private String c;
  private String d;
  
  public YouPinGoodsParamsMo() {}
  
  protected YouPinGoodsParamsMo(Parcel paramParcel)
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


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/datacenter/remote/responsebody/financial/youpin/YouPinGoodsParamsMo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */