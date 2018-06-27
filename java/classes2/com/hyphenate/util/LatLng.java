package com.hyphenate.util;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class LatLng
  implements Parcelable
{
  public static final Parcelable.Creator<LatLng> CREATOR = new Parcelable.Creator()
  {
    public LatLng createFromParcel(Parcel paramAnonymousParcel)
    {
      return new LatLng(paramAnonymousParcel);
    }
    
    public LatLng[] newArray(int paramAnonymousInt)
    {
      return new LatLng[paramAnonymousInt];
    }
  };
  public double latitude;
  public double longitude;
  
  public LatLng(double paramDouble1, double paramDouble2)
  {
    this.latitude = paramDouble1;
    this.longitude = paramDouble2;
  }
  
  public LatLng(Parcel paramParcel)
  {
    this.latitude = paramParcel.readDouble();
    this.longitude = paramParcel.readDouble();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeDouble(this.latitude);
    paramParcel.writeDouble(this.longitude);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/util/LatLng.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */