package com.ziroom.ziroomcustomer.newmovehouse.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class MovingVanGoods
  implements Parcelable
{
  public static final Parcelable.Creator<MovingVanGoods> CREATOR = new Parcelable.Creator()
  {
    public MovingVanGoods createFromParcel(Parcel paramAnonymousParcel)
    {
      return new MovingVanGoods(paramAnonymousParcel);
    }
    
    public MovingVanGoods[] newArray(int paramAnonymousInt)
    {
      return new MovingVanGoods[paramAnonymousInt];
    }
  };
  public static final int FLAG_HOT = 1;
  public static final int FLAG_NOT_HOT = 0;
  public static final int FLAG_NOT_ONSALE = 0;
  public static final int FLAG_ONSALE = 1;
  public int buyNumber;
  public String imageAlt;
  public String imageUrl;
  public String isHot;
  public String isOnsale;
  public String logicCode;
  public String mainImageCode;
  public String materielColour;
  public String materielName;
  public String materielPurpose;
  public String materielStandard;
  public String materielTexture;
  public long materielUnitPrice;
  
  public MovingVanGoods() {}
  
  protected MovingVanGoods(Parcel paramParcel)
  {
    this.logicCode = paramParcel.readString();
    this.materielUnitPrice = paramParcel.readLong();
    this.materielStandard = paramParcel.readString();
    this.materielPurpose = paramParcel.readString();
    this.materielTexture = paramParcel.readString();
    this.materielColour = paramParcel.readString();
    this.materielName = paramParcel.readString();
    this.isOnsale = paramParcel.readString();
    this.isHot = paramParcel.readString();
    this.mainImageCode = paramParcel.readString();
    this.imageAlt = paramParcel.readString();
    this.imageUrl = paramParcel.readString();
    this.buyNumber = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject != null) && (this.logicCode != null) && (((MovingVanGoods)paramObject).logicCode != null)) {
      return this.logicCode.equals(((MovingVanGoods)paramObject).logicCode);
    }
    return super.equals(paramObject);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.logicCode);
    paramParcel.writeLong(this.materielUnitPrice);
    paramParcel.writeString(this.materielStandard);
    paramParcel.writeString(this.materielPurpose);
    paramParcel.writeString(this.materielTexture);
    paramParcel.writeString(this.materielColour);
    paramParcel.writeString(this.materielName);
    paramParcel.writeString(this.isOnsale);
    paramParcel.writeString(this.isHot);
    paramParcel.writeString(this.mainImageCode);
    paramParcel.writeString(this.imageAlt);
    paramParcel.writeString(this.imageUrl);
    paramParcel.writeInt(this.buyNumber);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/model/MovingVanGoods.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */