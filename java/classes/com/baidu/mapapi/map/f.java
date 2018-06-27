package com.baidu.mapapi.map;

import android.graphics.Point;

class f
{
  public final double a;
  public final double b;
  public final double c;
  public final double d;
  public final double e;
  public final double f;
  
  public f(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    this.a = paramDouble1;
    this.b = paramDouble3;
    this.c = paramDouble2;
    this.d = paramDouble4;
    this.e = ((paramDouble1 + paramDouble2) / 2.0D);
    this.f = ((paramDouble3 + paramDouble4) / 2.0D);
  }
  
  public boolean a(double paramDouble1, double paramDouble2)
  {
    return (this.a <= paramDouble1) && (paramDouble1 <= this.c) && (this.b <= paramDouble2) && (paramDouble2 <= this.d);
  }
  
  public boolean a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    return (paramDouble1 < this.c) && (this.a < paramDouble2) && (paramDouble3 < this.d) && (this.b < paramDouble4);
  }
  
  public boolean a(Point paramPoint)
  {
    return a(paramPoint.x, paramPoint.y);
  }
  
  public boolean a(f paramf)
  {
    return a(paramf.a, paramf.c, paramf.b, paramf.d);
  }
  
  public boolean b(f paramf)
  {
    return (paramf.a >= this.a) && (paramf.c <= this.c) && (paramf.b >= this.b) && (paramf.d <= this.d);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("minX: " + this.a);
    localStringBuilder.append(" minY: " + this.b);
    localStringBuilder.append(" maxX: " + this.c);
    localStringBuilder.append(" maxY: " + this.d);
    localStringBuilder.append(" midX: " + this.e);
    localStringBuilder.append(" midY: " + this.f);
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/map/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */