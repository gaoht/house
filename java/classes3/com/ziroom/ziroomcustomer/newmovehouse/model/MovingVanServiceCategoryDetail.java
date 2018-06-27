package com.ziroom.ziroomcustomer.newmovehouse.model;

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
  private int buyNumber;
  private String categoryDetail;
  private int categoryIndex;
  private String categoryName;
  private String categoryParent;
  private String imgUrl;
  private String logicCode;
  
  public MovingVanServiceCategoryDetail() {}
  
  protected MovingVanServiceCategoryDetail(Parcel paramParcel)
  {
    this.logicCode = paramParcel.readString();
    this.categoryName = paramParcel.readString();
    this.categoryParent = paramParcel.readString();
    this.categoryIndex = paramParcel.readInt();
    this.imgUrl = paramParcel.readString();
    this.categoryDetail = paramParcel.readString();
    this.buyNumber = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getBuyNumber()
  {
    return this.buyNumber;
  }
  
  public String getCategoryDetail()
  {
    return this.categoryDetail;
  }
  
  public int getCategoryIndex()
  {
    return this.categoryIndex;
  }
  
  public String getCategoryName()
  {
    return this.categoryName;
  }
  
  public String getCategoryParent()
  {
    return this.categoryParent;
  }
  
  public String getImgUrl()
  {
    return this.imgUrl;
  }
  
  public String getLogicCode()
  {
    return this.logicCode;
  }
  
  public void setBuyNumber(int paramInt)
  {
    this.buyNumber = paramInt;
  }
  
  public void setCategoryDetail(String paramString)
  {
    this.categoryDetail = paramString;
  }
  
  public void setCategoryIndex(int paramInt)
  {
    this.categoryIndex = paramInt;
  }
  
  public void setCategoryName(String paramString)
  {
    this.categoryName = paramString;
  }
  
  public void setCategoryParent(String paramString)
  {
    this.categoryParent = paramString;
  }
  
  public void setImgUrl(String paramString)
  {
    this.imgUrl = paramString;
  }
  
  public void setLogicCode(String paramString)
  {
    this.logicCode = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.logicCode);
    paramParcel.writeString(this.categoryName);
    paramParcel.writeString(this.categoryParent);
    paramParcel.writeInt(this.categoryIndex);
    paramParcel.writeString(this.imgUrl);
    paramParcel.writeString(this.categoryDetail);
    paramParcel.writeInt(this.buyNumber);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/model/MovingVanServiceCategoryDetail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */