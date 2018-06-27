package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;
import java.util.ArrayList;

public final class MarkerOptions
  extends OverlayOptions
{
  int a;
  boolean b = true;
  Bundle c;
  private LatLng d;
  private BitmapDescriptor e;
  private float f = 0.5F;
  private float g = 1.0F;
  private boolean h = true;
  private boolean i = false;
  private float j;
  private String k;
  private int l;
  private boolean m = false;
  private ArrayList<BitmapDescriptor> n;
  private int o = 20;
  private float p = 1.0F;
  private int q = MarkerAnimateType.none.ordinal();
  
  MarkerOptions a(int paramInt)
  {
    this.l = paramInt;
    return this;
  }
  
  Overlay a()
  {
    Marker localMarker = new Marker();
    localMarker.s = this.b;
    localMarker.r = this.a;
    localMarker.t = this.c;
    if (this.d == null) {
      throw new IllegalStateException("when you add marker, you must set the position");
    }
    localMarker.a = this.d;
    if ((this.e == null) && (this.n == null)) {
      throw new IllegalStateException("when you add marker, you must set the icon or icons");
    }
    localMarker.b = this.e;
    localMarker.c = this.f;
    localMarker.d = this.g;
    localMarker.e = this.h;
    localMarker.f = this.i;
    localMarker.g = this.j;
    localMarker.h = this.k;
    localMarker.i = this.l;
    localMarker.j = this.m;
    localMarker.n = this.n;
    localMarker.o = this.o;
    localMarker.l = this.p;
    localMarker.m = this.q;
    return localMarker;
  }
  
  public MarkerOptions alpha(float paramFloat)
  {
    if ((paramFloat < 0.0F) || (paramFloat > 1.0F))
    {
      this.p = 1.0F;
      return this;
    }
    this.p = paramFloat;
    return this;
  }
  
  public MarkerOptions anchor(float paramFloat1, float paramFloat2)
  {
    if ((paramFloat1 < 0.0F) || (paramFloat1 > 1.0F)) {}
    while ((paramFloat2 < 0.0F) || (paramFloat2 > 1.0F)) {
      return this;
    }
    this.f = paramFloat1;
    this.g = paramFloat2;
    return this;
  }
  
  public MarkerOptions animateType(MarkerAnimateType paramMarkerAnimateType)
  {
    MarkerAnimateType localMarkerAnimateType = paramMarkerAnimateType;
    if (paramMarkerAnimateType == null) {
      localMarkerAnimateType = MarkerAnimateType.none;
    }
    this.q = localMarkerAnimateType.ordinal();
    return this;
  }
  
  public MarkerOptions draggable(boolean paramBoolean)
  {
    this.i = paramBoolean;
    return this;
  }
  
  public MarkerOptions extraInfo(Bundle paramBundle)
  {
    this.c = paramBundle;
    return this;
  }
  
  public MarkerOptions flat(boolean paramBoolean)
  {
    this.m = paramBoolean;
    return this;
  }
  
  public float getAlpha()
  {
    return this.p;
  }
  
  public float getAnchorX()
  {
    return this.f;
  }
  
  public float getAnchorY()
  {
    return this.g;
  }
  
  public MarkerAnimateType getAnimateType()
  {
    switch (this.q)
    {
    default: 
      return MarkerAnimateType.none;
    case 1: 
      return MarkerAnimateType.drop;
    }
    return MarkerAnimateType.grow;
  }
  
  public Bundle getExtraInfo()
  {
    return this.c;
  }
  
  public BitmapDescriptor getIcon()
  {
    return this.e;
  }
  
  public ArrayList<BitmapDescriptor> getIcons()
  {
    return this.n;
  }
  
  public int getPeriod()
  {
    return this.o;
  }
  
  public LatLng getPosition()
  {
    return this.d;
  }
  
  public float getRotate()
  {
    return this.j;
  }
  
  public String getTitle()
  {
    return this.k;
  }
  
  public int getZIndex()
  {
    return this.a;
  }
  
  public MarkerOptions icon(BitmapDescriptor paramBitmapDescriptor)
  {
    if (paramBitmapDescriptor == null) {
      throw new IllegalArgumentException("marker's icon can not be null");
    }
    this.e = paramBitmapDescriptor;
    return this;
  }
  
  public MarkerOptions icons(ArrayList<BitmapDescriptor> paramArrayList)
  {
    if (paramArrayList == null) {
      throw new IllegalArgumentException("marker's icons can not be null");
    }
    if (paramArrayList.size() == 0) {
      return this;
    }
    int i1 = 0;
    for (;;)
    {
      if (i1 >= paramArrayList.size()) {
        break label62;
      }
      if ((paramArrayList.get(i1) == null) || (((BitmapDescriptor)paramArrayList.get(i1)).a == null)) {
        break;
      }
      i1 += 1;
    }
    label62:
    this.n = paramArrayList;
    return this;
  }
  
  public boolean isDraggable()
  {
    return this.i;
  }
  
  public boolean isFlat()
  {
    return this.m;
  }
  
  public boolean isPerspective()
  {
    return this.h;
  }
  
  public boolean isVisible()
  {
    return this.b;
  }
  
  public MarkerOptions period(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("marker's period must be greater than zero ");
    }
    this.o = paramInt;
    return this;
  }
  
  public MarkerOptions perspective(boolean paramBoolean)
  {
    this.h = paramBoolean;
    return this;
  }
  
  public MarkerOptions position(LatLng paramLatLng)
  {
    if (paramLatLng == null) {
      throw new IllegalArgumentException("marker's position can not be null");
    }
    this.d = paramLatLng;
    return this;
  }
  
  public MarkerOptions rotate(float paramFloat)
  {
    while (paramFloat < 0.0F) {
      paramFloat += 360.0F;
    }
    this.j = (paramFloat % 360.0F);
    return this;
  }
  
  public MarkerOptions title(String paramString)
  {
    this.k = paramString;
    return this;
  }
  
  public MarkerOptions visible(boolean paramBoolean)
  {
    this.b = paramBoolean;
    return this;
  }
  
  public MarkerOptions zIndex(int paramInt)
  {
    this.a = paramInt;
    return this;
  }
  
  public static enum MarkerAnimateType
  {
    static
    {
      drop = new MarkerAnimateType("drop", 1);
      grow = new MarkerAnimateType("grow", 2);
    }
    
    private MarkerAnimateType() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/map/MarkerOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */