package com.ziroom.ziroomcustomer.bestgoods.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class YouPinCommitOrderGoodsInfoMo
  implements Parcelable
{
  public static final Parcelable.Creator<YouPinCommitOrderGoodsInfoMo> CREATOR = new Parcelable.Creator()
  {
    public YouPinCommitOrderGoodsInfoMo createFromParcel(Parcel paramAnonymousParcel)
    {
      return new YouPinCommitOrderGoodsInfoMo(paramAnonymousParcel);
    }
    
    public YouPinCommitOrderGoodsInfoMo[] newArray(int paramAnonymousInt)
    {
      return new YouPinCommitOrderGoodsInfoMo[paramAnonymousInt];
    }
  };
  private String a;
  private String b;
  private String c;
  private String d;
  private Integer e;
  private Integer f;
  private Integer g;
  
  public YouPinCommitOrderGoodsInfoMo() {}
  
  protected YouPinCommitOrderGoodsInfoMo(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = ((Integer)paramParcel.readValue(Integer.class.getClassLoader()));
    this.f = ((Integer)paramParcel.readValue(Integer.class.getClassLoader()));
    this.g = ((Integer)paramParcel.readValue(Integer.class.getClassLoader()));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Integer getCount()
  {
    return this.e;
  }
  
  public Integer getDeliveryMode()
  {
    return this.g;
  }
  
  public Integer getFreight()
  {
    return this.f;
  }
  
  public String getProductCode()
  {
    return this.a;
  }
  
  public String getShoppingCartCode()
  {
    return this.c;
  }
  
  public String getSkuCode()
  {
    return this.b;
  }
  
  public String getSkuUrl()
  {
    return this.d;
  }
  
  public void setCount(Integer paramInteger)
  {
    this.e = paramInteger;
  }
  
  public void setDeliveryMode(Integer paramInteger)
  {
    this.g = paramInteger;
  }
  
  public void setFreight(Integer paramInteger)
  {
    this.f = paramInteger;
  }
  
  public void setProductCode(String paramString)
  {
    this.a = paramString;
  }
  
  public void setShoppingCartCode(String paramString)
  {
    this.c = paramString;
  }
  
  public void setSkuCode(String paramString)
  {
    this.b = paramString;
  }
  
  public void setSkuUrl(String paramString)
  {
    this.d = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeValue(this.e);
    paramParcel.writeValue(this.f);
    paramParcel.writeValue(this.g);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/bestgoods/model/YouPinCommitOrderGoodsInfoMo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */