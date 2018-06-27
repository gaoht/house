package com.airbnb.lottie;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region.Op;
import android.support.v4.util.LongSparseArray;
import java.util.ArrayList;
import java.util.List;

class v
  extends o
{
  private final List<o> e = new ArrayList();
  private final RectF f = new RectF();
  private final Rect g = new Rect();
  private final RectF h = new RectF();
  private Boolean i;
  private Boolean j;
  
  v(ax paramax, av paramav, List<av> paramList, aw paramaw)
  {
    super(paramax, paramav);
    LongSparseArray localLongSparseArray = new LongSparseArray(paramaw.b().size());
    int k = paramList.size() - 1;
    paramav = null;
    if (k >= 0)
    {
      av localav = (av)paramList.get(k);
      o localo = o.a(localav, paramax, paramaw);
      if (localo == null) {}
      for (;;)
      {
        k -= 1;
        break;
        localLongSparseArray.put(localo.a().c(), localo);
        if (paramav != null)
        {
          paramav.a(localo);
          paramav = null;
        }
        else
        {
          this.e.add(0, localo);
          switch (1.a[localav.j().ordinal()])
          {
          default: 
            break;
          case 1: 
          case 2: 
            paramav = localo;
          }
        }
      }
    }
    k = 0;
    while (k < localLongSparseArray.size())
    {
      paramax = (o)localLongSparseArray.get(localLongSparseArray.keyAt(k));
      paramav = (o)localLongSparseArray.get(paramax.a().k());
      if (paramav != null) {
        paramax.b(paramav);
      }
      k += 1;
    }
  }
  
  public void addColorFilter(String paramString1, String paramString2, ColorFilter paramColorFilter)
  {
    int k = 0;
    if (k < this.e.size())
    {
      o localo = (o)this.e.get(k);
      String str = localo.a().d();
      if (paramString1 == null) {
        localo.addColorFilter(null, null, paramColorFilter);
      }
      for (;;)
      {
        k += 1;
        break;
        if (str.equals(paramString1)) {
          localo.addColorFilter(paramString1, paramString2, paramColorFilter);
        }
      }
    }
  }
  
  boolean d()
  {
    if (this.j == null)
    {
      int k = this.e.size() - 1;
      while (k >= 0)
      {
        o localo = (o)this.e.get(k);
        if (((localo instanceof bw)) && (localo.c()))
        {
          this.j = Boolean.valueOf(true);
          return true;
        }
        k -= 1;
      }
      this.j = Boolean.valueOf(false);
    }
    return this.j.booleanValue();
  }
  
  void drawLayer(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    paramCanvas.getClipBounds(this.g);
    this.h.set(0.0F, 0.0F, this.c.f(), this.c.g());
    paramMatrix.mapRect(this.h);
    int k = this.e.size() - 1;
    while (k >= 0)
    {
      boolean bool = true;
      if (!this.h.isEmpty()) {
        bool = paramCanvas.clipRect(this.h);
      }
      if (bool) {
        ((o)this.e.get(k)).draw(paramCanvas, paramMatrix, paramInt);
      }
      k -= 1;
    }
    if (!this.g.isEmpty()) {
      paramCanvas.clipRect(this.g, Region.Op.REPLACE);
    }
  }
  
  boolean e()
  {
    if (this.i == null)
    {
      if (b())
      {
        this.i = Boolean.valueOf(true);
        return true;
      }
      int k = this.e.size() - 1;
      while (k >= 0)
      {
        if (((o)this.e.get(k)).b())
        {
          this.i = Boolean.valueOf(true);
          return true;
        }
        k -= 1;
      }
      this.i = Boolean.valueOf(false);
    }
    return this.i.booleanValue();
  }
  
  public void getBounds(RectF paramRectF, Matrix paramMatrix)
  {
    super.getBounds(paramRectF, paramMatrix);
    this.f.set(0.0F, 0.0F, 0.0F, 0.0F);
    int k = this.e.size() - 1;
    if (k >= 0)
    {
      ((o)this.e.get(k)).getBounds(this.f, this.a);
      if (paramRectF.isEmpty()) {
        paramRectF.set(this.f);
      }
      for (;;)
      {
        k -= 1;
        break;
        paramRectF.set(Math.min(paramRectF.left, this.f.left), Math.min(paramRectF.top, this.f.top), Math.max(paramRectF.right, this.f.right), Math.max(paramRectF.bottom, this.f.bottom));
      }
    }
  }
  
  public void setProgress(float paramFloat)
  {
    super.setProgress(paramFloat);
    float f1 = this.c.a();
    int k = this.e.size() - 1;
    while (k >= 0)
    {
      ((o)this.e.get(k)).setProgress(paramFloat - f1);
      k -= 1;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/airbnb/lottie/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */