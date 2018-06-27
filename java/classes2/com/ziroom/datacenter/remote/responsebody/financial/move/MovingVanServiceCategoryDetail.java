package com.ziroom.datacenter.remote.responsebody.financial.move;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class MovingVanServiceCategoryDetail
  implements Parcelable
{
  public static final Parcelable.Creator<MovingVanServiceCategoryDetail> CREATOR = new Parcelable.Creator()
  {
    public MovingVanServiceCategoryDetail createFromParcel(Parcel paramAnonymousParcel)
    {
      return new MovingVanServiceCategoryDetail(paramAnonymousParcel);
    }
    
    public MovingVanServiceCategoryDetail[] newArray(int paramAnonymousInt)
    {
      return new MovingVanServiceCategoryDetail[paramAnonymousInt];
    }
  };
  private String a;
  private String b;
  private String c;
  private int d;
  private String e;
  private String f;
  private int g;
  
  public MovingVanServiceCategoryDetail() {}
  
  protected MovingVanServiceCategoryDetail(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readInt();
    this.e = paramParcel.readString();
    this.f = paramParcel.readString();
    this.g = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getBuyNumber()
  {
    return this.g;
  }
  
  public String getCategoryDetail()
  {
    return this.f;
  }
  
  public int getCategoryIndex()
  {
    return this.d;
  }
  
  public String getCategoryName()
  {
    return this.b;
  }
  
  public String getCategoryParent()
  {
    return this.c;
  }
  
  public String getImgUrl()
  {
    return this.e;
  }
  
  public String getLogicCode()
  {
    return this.a;
  }
  
  public void setBuyNumber(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void setCategoryDetail(String paramString)
  {
    this.f = paramString;
  }
  
  public void setCategoryIndex(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setCategoryName(String paramString)
  {
    this.b = paramString;
  }
  
  public void setCategoryParent(String paramString)
  {
    this.c = paramString;
  }
  
  public void setImgUrl(String paramString)
  {
    this.e = paramString;
  }
  
  public void setLogicCode(String paramString)
  {
    this.a = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeInt(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeInt(this.g);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/datacenter/remote/responsebody/financial/move/MovingVanServiceCategoryDetail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */