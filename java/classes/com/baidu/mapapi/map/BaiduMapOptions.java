package com.baidu.mapapi.map;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.map.B;

public final class BaiduMapOptions
  implements Parcelable
{
  public static final Parcelable.Creator<BaiduMapOptions> CREATOR = new e();
  MapStatus a = new MapStatus(0.0F, new LatLng(39.914935D, 116.403119D), 0.0F, 12.0F, null, null);
  boolean b = true;
  int c = 1;
  boolean d = true;
  boolean e = true;
  boolean f = true;
  boolean g = true;
  boolean h = true;
  boolean i = true;
  LogoPosition j;
  Point k;
  Point l;
  
  public BaiduMapOptions() {}
  
  protected BaiduMapOptions(Parcel paramParcel)
  {
    this.a = ((MapStatus)paramParcel.readParcelable(MapStatus.class.getClassLoader()));
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.b = bool1;
      this.c = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label236;
      }
      bool1 = true;
      label123:
      this.d = bool1;
      if (paramParcel.readByte() == 0) {
        break label241;
      }
      bool1 = true;
      label137:
      this.e = bool1;
      if (paramParcel.readByte() == 0) {
        break label246;
      }
      bool1 = true;
      label151:
      this.f = bool1;
      if (paramParcel.readByte() == 0) {
        break label251;
      }
      bool1 = true;
      label165:
      this.g = bool1;
      if (paramParcel.readByte() == 0) {
        break label256;
      }
      bool1 = true;
      label179:
      this.h = bool1;
      if (paramParcel.readByte() == 0) {
        break label261;
      }
    }
    label236:
    label241:
    label246:
    label251:
    label256:
    label261:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.i = bool1;
      this.k = ((Point)paramParcel.readParcelable(Point.class.getClassLoader()));
      this.l = ((Point)paramParcel.readParcelable(Point.class.getClassLoader()));
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label123;
      bool1 = false;
      break label137;
      bool1 = false;
      break label151;
      bool1 = false;
      break label165;
      bool1 = false;
      break label179;
    }
  }
  
  B a()
  {
    return new B().a(this.a.c()).a(this.b).a(this.c).b(this.d).c(this.e).d(this.f).e(this.g);
  }
  
  public BaiduMapOptions compassEnabled(boolean paramBoolean)
  {
    this.b = paramBoolean;
    return this;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public BaiduMapOptions logoPosition(LogoPosition paramLogoPosition)
  {
    this.j = paramLogoPosition;
    return this;
  }
  
  public BaiduMapOptions mapStatus(MapStatus paramMapStatus)
  {
    if (paramMapStatus != null) {
      this.a = paramMapStatus;
    }
    return this;
  }
  
  public BaiduMapOptions mapType(int paramInt)
  {
    this.c = paramInt;
    return this;
  }
  
  public BaiduMapOptions overlookingGesturesEnabled(boolean paramBoolean)
  {
    this.f = paramBoolean;
    return this;
  }
  
  public BaiduMapOptions rotateGesturesEnabled(boolean paramBoolean)
  {
    this.d = paramBoolean;
    return this;
  }
  
  public BaiduMapOptions scaleControlEnabled(boolean paramBoolean)
  {
    this.i = paramBoolean;
    return this;
  }
  
  public BaiduMapOptions scaleControlPosition(Point paramPoint)
  {
    this.k = paramPoint;
    return this;
  }
  
  public BaiduMapOptions scrollGesturesEnabled(boolean paramBoolean)
  {
    this.e = paramBoolean;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int n = 1;
    paramParcel.writeParcelable(this.a, paramInt);
    if (this.b)
    {
      m = 1;
      paramParcel.writeByte((byte)m);
      paramParcel.writeInt(this.c);
      if (!this.d) {
        break label150;
      }
      m = 1;
      label44:
      paramParcel.writeByte((byte)m);
      if (!this.e) {
        break label155;
      }
      m = 1;
      label59:
      paramParcel.writeByte((byte)m);
      if (!this.f) {
        break label160;
      }
      m = 1;
      label74:
      paramParcel.writeByte((byte)m);
      if (!this.g) {
        break label165;
      }
      m = 1;
      label89:
      paramParcel.writeByte((byte)m);
      if (!this.h) {
        break label170;
      }
      m = 1;
      label104:
      paramParcel.writeByte((byte)m);
      if (!this.i) {
        break label175;
      }
    }
    label150:
    label155:
    label160:
    label165:
    label170:
    label175:
    for (int m = n;; m = 0)
    {
      paramParcel.writeByte((byte)m);
      paramParcel.writeParcelable(this.k, paramInt);
      paramParcel.writeParcelable(this.l, paramInt);
      return;
      m = 0;
      break;
      m = 0;
      break label44;
      m = 0;
      break label59;
      m = 0;
      break label74;
      m = 0;
      break label89;
      m = 0;
      break label104;
    }
  }
  
  public BaiduMapOptions zoomControlsEnabled(boolean paramBoolean)
  {
    this.h = paramBoolean;
    return this;
  }
  
  public BaiduMapOptions zoomControlsPosition(Point paramPoint)
  {
    this.l = paramPoint;
    return this;
  }
  
  public BaiduMapOptions zoomGesturesEnabled(boolean paramBoolean)
  {
    this.g = paramBoolean;
    return this;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/map/BaiduMapOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */