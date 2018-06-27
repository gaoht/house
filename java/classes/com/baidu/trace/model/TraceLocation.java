package com.baidu.trace.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class TraceLocation
  extends BaseResponse
  implements Parcelable
{
  public static final Parcelable.Creator<TraceLocation> CREATOR = new a();
  private LocType a = LocType.NONE;
  private String b = "";
  private String c = "";
  private String d = "";
  private double e = 0.0D;
  private double f = 0.0D;
  private CoordType g = CoordType.bd09ll;
  private double h = 0.0D;
  private float i = 0.0F;
  private float j = 0.0F;
  private int k = 0;
  private String l = "";
  
  public TraceLocation() {}
  
  public TraceLocation(int paramInt1, int paramInt2, String paramString)
  {
    super(paramInt1, paramInt2, paramString);
  }
  
  public TraceLocation(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, double paramDouble1, double paramDouble2, CoordType paramCoordType, double paramDouble3, float paramFloat1, float paramFloat2, int paramInt3, String paramString5)
  {
    super(paramInt1, paramInt2, paramString1);
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramString4;
    this.e = paramDouble1;
    this.f = paramDouble2;
    this.g = paramCoordType;
    this.h = paramDouble3;
    this.i = paramFloat1;
    this.j = paramFloat2;
    this.k = paramInt3;
    this.l = paramString5;
  }
  
  private TraceLocation(Parcel paramParcel)
  {
    readFromParcel(paramParcel);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final int getAltitude()
  {
    return this.k;
  }
  
  public final String getBuilding()
  {
    return this.d;
  }
  
  public final CoordType getCoordType()
  {
    return this.g;
  }
  
  public final float getDirection()
  {
    return this.i;
  }
  
  public final String getFloor()
  {
    return this.b;
  }
  
  public final String getIndoor()
  {
    return this.c;
  }
  
  public final double getLatitude()
  {
    return this.e;
  }
  
  public final LocType getLocType()
  {
    return this.a;
  }
  
  public final double getLongitude()
  {
    return this.f;
  }
  
  public final double getRadius()
  {
    return this.h;
  }
  
  public final float getSpeed()
  {
    return this.j;
  }
  
  public final String getTime()
  {
    return this.l;
  }
  
  public final void readFromParcel(Parcel paramParcel)
  {
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readDouble();
    this.f = paramParcel.readDouble();
    switch (paramParcel.readInt())
    {
    }
    for (;;)
    {
      this.h = paramParcel.readDouble();
      this.i = paramParcel.readFloat();
      this.j = paramParcel.readFloat();
      this.k = paramParcel.readInt();
      this.l = paramParcel.readString();
      return;
      this.g = CoordType.wgs84;
      continue;
      this.g = CoordType.gcj02;
      continue;
      this.g = CoordType.bd09ll;
    }
  }
  
  public final void setAltitude(int paramInt)
  {
    this.k = paramInt;
  }
  
  public final void setBuilding(String paramString)
  {
    this.d = paramString;
  }
  
  public final void setCoordType(CoordType paramCoordType)
  {
    this.g = paramCoordType;
  }
  
  public final void setDirection(float paramFloat)
  {
    this.i = paramFloat;
  }
  
  public final void setFloor(String paramString)
  {
    this.b = paramString;
  }
  
  public final void setIndoor(String paramString)
  {
    this.c = paramString;
  }
  
  public final void setLatitude(double paramDouble)
  {
    this.e = paramDouble;
  }
  
  public final void setLocType(LocType paramLocType)
  {
    this.a = paramLocType;
  }
  
  public final void setLongitude(double paramDouble)
  {
    this.f = paramDouble;
  }
  
  public final void setRadius(double paramDouble)
  {
    this.h = paramDouble;
  }
  
  public final void setSpeed(float paramFloat)
  {
    this.j = paramFloat;
  }
  
  public final void setTime(String paramString)
  {
    this.l = paramString;
  }
  
  public final String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("TraceLocation{");
    localStringBuffer.append("tag=").append(this.tag);
    localStringBuffer.append(", status=").append(this.status);
    localStringBuffer.append(", message='").append(this.message).append('\'');
    localStringBuffer.append(", locType=").append(this.a);
    localStringBuffer.append(", floor='").append(this.b).append('\'');
    localStringBuffer.append(", indoor='").append(this.c).append('\'');
    localStringBuffer.append(", building='").append(this.d).append('\'');
    localStringBuffer.append(", latitude=").append(this.e);
    localStringBuffer.append(", longitude=").append(this.f);
    localStringBuffer.append(", coordType=").append(this.g);
    localStringBuffer.append(", radius=").append(this.h);
    localStringBuffer.append(", direction=").append(this.i);
    localStringBuffer.append(", speed=").append(this.j);
    localStringBuffer.append(", altitude=").append(this.k);
    localStringBuffer.append(", time='").append(this.l).append('\'');
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeDouble(this.e);
    paramParcel.writeDouble(this.f);
    paramParcel.writeInt(this.g.ordinal());
    paramParcel.writeDouble(this.h);
    paramParcel.writeFloat(this.i);
    paramParcel.writeFloat(this.j);
    paramParcel.writeInt(this.k);
    paramParcel.writeString(this.l);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/model/TraceLocation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */