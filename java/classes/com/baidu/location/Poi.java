package com.baidu.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class Poi
  implements Parcelable
{
  public static final Parcelable.Creator<Poi> CREATOR = new d();
  private final String mId;
  private final String mName;
  private final double mRank;
  
  public Poi(String paramString1, String paramString2, double paramDouble)
  {
    this.mId = paramString1;
    this.mName = paramString2;
    this.mRank = paramDouble;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getId()
  {
    return this.mId;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public double getRank()
  {
    return this.mRank;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mId);
    paramParcel.writeString(this.mName);
    paramParcel.writeDouble(this.mRank);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/location/Poi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */