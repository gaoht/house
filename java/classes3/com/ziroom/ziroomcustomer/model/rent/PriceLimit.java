package com.ziroom.ziroomcustomer.model.rent;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.Serializable;

public class PriceLimit
  implements Parcelable, Serializable
{
  public static final Parcelable.Creator<PriceLimit> CREATOR = new Parcelable.Creator()
  {
    public PriceLimit createFromParcel(Parcel paramAnonymousParcel)
    {
      return new PriceLimit(paramAnonymousParcel);
    }
    
    public PriceLimit[] newArray(int paramAnonymousInt)
    {
      return new PriceLimit[paramAnonymousInt];
    }
  };
  private int diff;
  private int fast_seg;
  private int max = 10000;
  private int mid;
  private int step = 100;
  
  public PriceLimit() {}
  
  protected PriceLimit(Parcel paramParcel)
  {
    this.step = paramParcel.readInt();
    this.mid = paramParcel.readInt();
    this.max = paramParcel.readInt();
    this.fast_seg = paramParcel.readInt();
    this.diff = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getDiff()
  {
    return this.diff;
  }
  
  public int getFast_seg()
  {
    return this.fast_seg;
  }
  
  public int getMax()
  {
    return this.max;
  }
  
  public int getMid()
  {
    return this.mid;
  }
  
  public int getStep()
  {
    return this.step;
  }
  
  public void setDiff(int paramInt)
  {
    this.diff = paramInt;
  }
  
  public void setFast_seg(int paramInt)
  {
    this.fast_seg = paramInt;
  }
  
  public void setMax(int paramInt)
  {
    this.max = paramInt;
  }
  
  public void setMid(int paramInt)
  {
    this.mid = paramInt;
  }
  
  public void setStep(int paramInt)
  {
    this.step = paramInt;
  }
  
  public String toString()
  {
    return "PriceLimit{step=" + this.step + ", mid=" + this.mid + ", max=" + this.max + ", fast_seg=" + this.fast_seg + ", diff=" + this.diff + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.step);
    paramParcel.writeInt(this.mid);
    paramParcel.writeInt(this.max);
    paramParcel.writeInt(this.fast_seg);
    paramParcel.writeInt(this.diff);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/rent/PriceLimit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */