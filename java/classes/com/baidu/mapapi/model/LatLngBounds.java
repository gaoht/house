package com.baidu.mapapi.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class LatLngBounds
  implements Parcelable
{
  public static final Parcelable.Creator<LatLngBounds> CREATOR = new b();
  public final LatLng northeast;
  public final LatLng southwest;
  
  protected LatLngBounds(Parcel paramParcel)
  {
    this.northeast = ((LatLng)paramParcel.readParcelable(LatLng.class.getClassLoader()));
    this.southwest = ((LatLng)paramParcel.readParcelable(LatLng.class.getClassLoader()));
  }
  
  LatLngBounds(LatLng paramLatLng1, LatLng paramLatLng2)
  {
    this.northeast = paramLatLng1;
    this.southwest = paramLatLng2;
  }
  
  public boolean contains(LatLng paramLatLng)
  {
    if (paramLatLng == null) {}
    double d1;
    double d2;
    double d3;
    double d4;
    double d5;
    double d6;
    do
    {
      return false;
      d1 = this.southwest.latitude;
      d2 = this.northeast.latitude;
      d3 = this.southwest.longitude;
      d4 = this.northeast.longitude;
      d5 = paramLatLng.latitude;
      d6 = paramLatLng.longitude;
    } while ((d5 < d1) || (d5 > d2) || (d6 < d3) || (d6 > d4));
    return true;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public LatLng getCenter()
  {
    return new LatLng((this.northeast.latitude - this.southwest.latitude) / 2.0D + this.southwest.latitude, (this.northeast.longitude - this.southwest.longitude) / 2.0D + this.southwest.longitude);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("southwest: ");
    localStringBuilder.append(this.southwest.latitude);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.southwest.longitude);
    localStringBuilder.append("\n");
    localStringBuilder.append("northeast: ");
    localStringBuilder.append(this.northeast.latitude);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.northeast.longitude);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.northeast, paramInt);
    paramParcel.writeParcelable(this.southwest, paramInt);
  }
  
  public static final class Builder
  {
    private double a;
    private double b;
    private double c;
    private double d;
    private boolean e = true;
    
    public LatLngBounds build()
    {
      return new LatLngBounds(new LatLng(this.b, this.d), new LatLng(this.a, this.c));
    }
    
    public Builder include(LatLng paramLatLng)
    {
      if (paramLatLng == null) {}
      double d2;
      do
      {
        return this;
        if (this.e)
        {
          this.e = false;
          d1 = paramLatLng.latitude;
          this.a = d1;
          this.b = d1;
          d1 = paramLatLng.longitude;
          this.c = d1;
          this.d = d1;
        }
        double d1 = paramLatLng.latitude;
        d2 = paramLatLng.longitude;
        if (d1 < this.a) {
          this.a = d1;
        }
        if (d1 > this.b) {
          this.b = d1;
        }
        if (d2 < this.c) {
          this.c = d2;
        }
      } while (d2 <= this.d);
      this.d = d2;
      return this;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/model/LatLngBounds.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */