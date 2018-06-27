package com.ziroom.ziroomcustomer.minsu.mapsojourn.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.baidu.mapapi.model.LatLng;

public class ZMarker
  implements Parcelable
{
  public static final Parcelable.Creator<ZMarker> CREATOR = new Parcelable.Creator()
  {
    public ZMarker createFromParcel(Parcel paramAnonymousParcel)
    {
      return new ZMarker(paramAnonymousParcel);
    }
    
    public ZMarker[] newArray(int paramAnonymousInt)
    {
      return new ZMarker[paramAnonymousInt];
    }
  };
  private LatLng a;
  private int b;
  private String c;
  private String d;
  private int e = -1;
  private String f;
  private Bundle g;
  private int h = 10;
  private int i;
  private int j = -1;
  private boolean k;
  private boolean l;
  private boolean m;
  
  public ZMarker() {}
  
  protected ZMarker(Parcel paramParcel)
  {
    this.a = ((LatLng)paramParcel.readParcelable(LatLng.class.getClassLoader()));
    this.b = paramParcel.readInt();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readInt();
    this.f = paramParcel.readString();
    this.g = paramParcel.readBundle();
    this.h = paramParcel.readInt();
    this.i = paramParcel.readInt();
    this.j = paramParcel.readInt();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.k = bool1;
      if (paramParcel.readByte() == 0) {
        break label158;
      }
      bool1 = true;
      label133:
      this.l = bool1;
      if (paramParcel.readByte() == 0) {
        break label163;
      }
    }
    label158:
    label163:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.m = bool1;
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label133;
    }
  }
  
  public ZMarker clone()
  {
    ZMarker localZMarker = new ZMarker();
    localZMarker.setIconUrl(this.f);
    localZMarker.setDefaultIconId(this.e);
    localZMarker.setIndex(this.h);
    localZMarker.setText1(this.c);
    localZMarker.setText2(this.d);
    localZMarker.setLatLng(this.a);
    localZMarker.setLayoutId(this.b);
    localZMarker.setTag(this.i);
    localZMarker.setData(this.g);
    return localZMarker;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = true;
    boolean bool3 = false;
    boolean bool1;
    if (this == paramObject) {
      bool1 = true;
    }
    label155:
    label179:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        return bool1;
                        bool1 = bool3;
                      } while (paramObject == null);
                      bool1 = bool3;
                    } while (getClass() != paramObject.getClass());
                    paramObject = (ZMarker)paramObject;
                    bool1 = bool3;
                  } while (this.b != ((ZMarker)paramObject).b);
                  bool1 = bool3;
                } while (this.e != ((ZMarker)paramObject).e);
                bool1 = bool3;
              } while (this.h != ((ZMarker)paramObject).h);
              if (this.a == null) {
                break;
              }
              bool1 = bool3;
            } while (this.a.latitude != ((ZMarker)paramObject).a.latitude);
            bool1 = bool3;
          } while (this.a.longitude != ((ZMarker)paramObject).a.longitude);
          if (this.c == null) {
            break label233;
          }
          bool1 = bool3;
        } while (!this.c.equals(((ZMarker)paramObject).c));
        if (this.d == null) {
          break label242;
        }
        bool1 = bool3;
      } while (!this.d.equals(((ZMarker)paramObject).d));
      if (this.f == null) {
        break label251;
      }
      bool1 = bool3;
    } while (!this.f.equals(((ZMarker)paramObject).f));
    label203:
    if (this.g != null) {
      bool1 = this.g.equals(((ZMarker)paramObject).g);
    }
    for (;;)
    {
      return bool1;
      if (((ZMarker)paramObject).a == null) {
        break;
      }
      return false;
      label233:
      if (((ZMarker)paramObject).c == null) {
        break label155;
      }
      return false;
      label242:
      if (((ZMarker)paramObject).d == null) {
        break label179;
      }
      return false;
      label251:
      if (((ZMarker)paramObject).f == null) {
        break label203;
      }
      return false;
      bool1 = bool2;
      if (((ZMarker)paramObject).g != null) {
        bool1 = false;
      }
    }
  }
  
  public int getBitmapRes()
  {
    return this.j;
  }
  
  public Bundle getData()
  {
    return this.g;
  }
  
  public int getDefaultIconId()
  {
    return this.e;
  }
  
  public String getIconUrl()
  {
    return this.f;
  }
  
  public int getIndex()
  {
    return this.h;
  }
  
  public LatLng getLatLng()
  {
    return this.a;
  }
  
  public int getLayoutId()
  {
    return this.b;
  }
  
  public int getTag()
  {
    return this.i;
  }
  
  public String getText1()
  {
    return this.c;
  }
  
  public String getText2()
  {
    return this.d;
  }
  
  public boolean isRepeatRoom()
  {
    return this.m;
  }
  
  public boolean isReserve()
  {
    return this.l;
  }
  
  public boolean isZryRoom()
  {
    return this.k;
  }
  
  public void setBitmapRes(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void setData(Bundle paramBundle)
  {
    this.g = paramBundle;
  }
  
  public void setDefaultIconId(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setIconUrl(String paramString)
  {
    this.f = paramString;
  }
  
  public void setIndex(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void setLatLng(LatLng paramLatLng)
  {
    this.a = paramLatLng;
  }
  
  public void setLayoutId(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void setRepeatRoom(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
  
  public void setReserve(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public void setTag(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void setText1(String paramString)
  {
    this.c = paramString;
  }
  
  public void setText2(String paramString)
  {
    this.d = paramString;
  }
  
  public void setZryRoom(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b2 = 1;
    paramParcel.writeParcelable(this.a, paramInt);
    paramParcel.writeInt(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeInt(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeBundle(this.g);
    paramParcel.writeInt(this.h);
    paramParcel.writeInt(this.i);
    paramParcel.writeInt(this.j);
    if (this.k)
    {
      b1 = 1;
      paramParcel.writeByte(b1);
      if (!this.l) {
        break label133;
      }
      b1 = 1;
      label107:
      paramParcel.writeByte(b1);
      if (!this.m) {
        break label138;
      }
    }
    label133:
    label138:
    for (byte b1 = b2;; b1 = 0)
    {
      paramParcel.writeByte(b1);
      return;
      b1 = 0;
      break;
      b1 = 0;
      break label107;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/mapsojourn/model/ZMarker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */