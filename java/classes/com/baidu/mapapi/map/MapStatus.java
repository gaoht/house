package com.baidu.mapapi.map;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapapi.model.LatLngBounds.Builder;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.platform.comapi.map.D;
import com.baidu.platform.comapi.map.D.a;

public final class MapStatus
  implements Parcelable
{
  public static final Parcelable.Creator<MapStatus> CREATOR = new h();
  D a;
  private double b;
  public final LatLngBounds bound;
  private double c;
  public final float overlook;
  public final float rotate;
  public final LatLng target;
  public final android.graphics.Point targetScreen;
  public final float zoom;
  
  MapStatus(float paramFloat1, LatLng paramLatLng, float paramFloat2, float paramFloat3, android.graphics.Point paramPoint, double paramDouble1, double paramDouble2, LatLngBounds paramLatLngBounds)
  {
    this.rotate = paramFloat1;
    this.target = paramLatLng;
    this.overlook = paramFloat2;
    this.zoom = paramFloat3;
    this.targetScreen = paramPoint;
    this.b = paramDouble1;
    this.c = paramDouble2;
    this.bound = paramLatLngBounds;
  }
  
  MapStatus(float paramFloat1, LatLng paramLatLng, float paramFloat2, float paramFloat3, android.graphics.Point paramPoint, LatLngBounds paramLatLngBounds)
  {
    this.rotate = paramFloat1;
    this.target = paramLatLng;
    this.overlook = paramFloat2;
    this.zoom = paramFloat3;
    this.targetScreen = paramPoint;
    if (this.target != null)
    {
      this.b = CoordUtil.ll2mc(this.target).getLongitudeE6();
      this.c = CoordUtil.ll2mc(this.target).getLatitudeE6();
    }
    this.bound = paramLatLngBounds;
  }
  
  MapStatus(float paramFloat1, LatLng paramLatLng, float paramFloat2, float paramFloat3, android.graphics.Point paramPoint, D paramD, double paramDouble1, double paramDouble2, LatLngBounds paramLatLngBounds)
  {
    this.rotate = paramFloat1;
    this.target = paramLatLng;
    this.overlook = paramFloat2;
    this.zoom = paramFloat3;
    this.targetScreen = paramPoint;
    this.a = paramD;
    this.b = paramDouble1;
    this.c = paramDouble2;
    this.bound = paramLatLngBounds;
  }
  
  protected MapStatus(Parcel paramParcel)
  {
    this.rotate = paramParcel.readFloat();
    this.target = ((LatLng)paramParcel.readParcelable(LatLng.class.getClassLoader()));
    this.overlook = paramParcel.readFloat();
    this.zoom = paramParcel.readFloat();
    this.targetScreen = ((android.graphics.Point)paramParcel.readParcelable(android.graphics.Point.class.getClassLoader()));
    this.bound = ((LatLngBounds)paramParcel.readParcelable(LatLngBounds.class.getClassLoader()));
    this.b = paramParcel.readDouble();
    this.c = paramParcel.readDouble();
  }
  
  static MapStatus a(D paramD)
  {
    if (paramD == null) {
      return null;
    }
    float f1 = paramD.b;
    double d1 = paramD.e;
    double d2 = paramD.d;
    LatLng localLatLng1 = CoordUtil.mc2ll(new GeoPoint(d1, d2));
    float f2 = paramD.c;
    float f3 = paramD.a;
    android.graphics.Point localPoint = new android.graphics.Point(paramD.f, paramD.g);
    LatLng localLatLng2 = CoordUtil.mc2ll(new GeoPoint(paramD.k.e.y, paramD.k.e.x));
    LatLng localLatLng3 = CoordUtil.mc2ll(new GeoPoint(paramD.k.f.y, paramD.k.f.x));
    LatLng localLatLng4 = CoordUtil.mc2ll(new GeoPoint(paramD.k.h.y, paramD.k.h.x));
    LatLng localLatLng5 = CoordUtil.mc2ll(new GeoPoint(paramD.k.g.y, paramD.k.g.x));
    LatLngBounds.Builder localBuilder = new LatLngBounds.Builder();
    localBuilder.include(localLatLng2);
    localBuilder.include(localLatLng3);
    localBuilder.include(localLatLng4);
    localBuilder.include(localLatLng5);
    return new MapStatus(f1, localLatLng1, f2, f3, localPoint, paramD, d2, d1, localBuilder.build());
  }
  
  double a()
  {
    return this.b;
  }
  
  double b()
  {
    return this.c;
  }
  
  D b(D paramD)
  {
    if (this.rotate != -2.14748365E9F) {
      paramD.b = ((int)this.rotate);
    }
    if (this.zoom != -2.14748365E9F) {
      paramD.a = this.zoom;
    }
    if (this.overlook != -2.14748365E9F) {
      paramD.c = ((int)this.overlook);
    }
    if (this.target != null)
    {
      CoordUtil.ll2mc(this.target);
      paramD.d = this.b;
      paramD.e = this.c;
    }
    if (this.targetScreen != null)
    {
      paramD.f = this.targetScreen.x;
      paramD.g = this.targetScreen.y;
    }
    return paramD;
  }
  
  D c()
  {
    return b(new D());
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.target != null)
    {
      localStringBuilder.append("target lat: " + this.target.latitude + "\n");
      localStringBuilder.append("target lng: " + this.target.longitude + "\n");
    }
    if (this.targetScreen != null)
    {
      localStringBuilder.append("target screen x: " + this.targetScreen.x + "\n");
      localStringBuilder.append("target screen y: " + this.targetScreen.y + "\n");
    }
    localStringBuilder.append("zoom: " + this.zoom + "\n");
    localStringBuilder.append("rotate: " + this.rotate + "\n");
    localStringBuilder.append("overlook: " + this.overlook + "\n");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeFloat(this.rotate);
    paramParcel.writeParcelable(this.target, paramInt);
    paramParcel.writeFloat(this.overlook);
    paramParcel.writeFloat(this.zoom);
    paramParcel.writeParcelable(this.targetScreen, paramInt);
    paramParcel.writeParcelable(this.bound, paramInt);
    paramParcel.writeDouble(this.b);
    paramParcel.writeDouble(this.c);
  }
  
  public static final class Builder
  {
    private float a = -2.14748365E9F;
    private LatLng b = null;
    private float c = -2.14748365E9F;
    private float d = -2.14748365E9F;
    private android.graphics.Point e = null;
    private LatLngBounds f = null;
    private double g = 0.0D;
    private double h = 0.0D;
    
    public Builder() {}
    
    public Builder(MapStatus paramMapStatus)
    {
      this.a = paramMapStatus.rotate;
      this.b = paramMapStatus.target;
      this.c = paramMapStatus.overlook;
      this.d = paramMapStatus.zoom;
      this.e = paramMapStatus.targetScreen;
      this.g = paramMapStatus.a();
      this.h = paramMapStatus.b();
    }
    
    public MapStatus build()
    {
      return new MapStatus(this.a, this.b, this.c, this.d, this.e, this.f);
    }
    
    public Builder overlook(float paramFloat)
    {
      this.c = paramFloat;
      return this;
    }
    
    public Builder rotate(float paramFloat)
    {
      this.a = paramFloat;
      return this;
    }
    
    public Builder target(LatLng paramLatLng)
    {
      this.b = paramLatLng;
      return this;
    }
    
    public Builder targetScreen(android.graphics.Point paramPoint)
    {
      this.e = paramPoint;
      return this;
    }
    
    public Builder zoom(float paramFloat)
    {
      this.d = paramFloat;
      return this;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/map/MapStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */