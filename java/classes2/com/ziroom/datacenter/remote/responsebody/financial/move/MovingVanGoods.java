package com.ziroom.datacenter.remote.responsebody.financial.move;

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
  public String a;
  public long b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  public String k;
  public String l;
  public int m;
  
  public MovingVanGoods() {}
  
  protected MovingVanGoods(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readLong();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
    this.f = paramParcel.readString();
    this.g = paramParcel.readString();
    this.h = paramParcel.readString();
    this.i = paramParcel.readString();
    this.j = paramParcel.readString();
    this.k = paramParcel.readString();
    this.l = paramParcel.readString();
    this.m = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject != null) && (this.a != null) && (((MovingVanGoods)paramObject).a != null)) {
      return this.a.equals(((MovingVanGoods)paramObject).a);
    }
    return super.equals(paramObject);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeLong(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeString(this.h);
    paramParcel.writeString(this.i);
    paramParcel.writeString(this.j);
    paramParcel.writeString(this.k);
    paramParcel.writeString(this.l);
    paramParcel.writeInt(this.m);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/datacenter/remote/responsebody/financial/move/MovingVanGoods.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */