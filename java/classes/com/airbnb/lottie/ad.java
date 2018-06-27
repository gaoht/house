package com.airbnb.lottie;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.List;

class ad
  implements aa, n.a
{
  private final Path a = new Path();
  private final Paint b = new Paint(1);
  private final String c;
  private final List<bg> d = new ArrayList();
  private final au<Integer> e;
  private final au<Integer> f;
  private final ax g;
  
  ad(ax paramax, o paramo, bt parambt)
  {
    this.c = parambt.a();
    this.g = paramax;
    if ((parambt.b() == null) || (parambt.c() == null))
    {
      this.e = null;
      this.f = null;
      return;
    }
    this.a.setFillType(parambt.d());
    this.e = parambt.b().createAnimation();
    this.e.a(this);
    paramo.a(this.e);
    this.f = parambt.c().createAnimation();
    this.f.a(this);
    paramo.a(this.f);
  }
  
  public void addColorFilter(String paramString1, String paramString2, ColorFilter paramColorFilter)
  {
    this.b.setColorFilter(paramColorFilter);
  }
  
  public void draw(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    this.b.setColor(((Integer)this.e.getValue()).intValue());
    float f1 = paramInt / 255.0F;
    paramInt = (int)(((Integer)this.f.getValue()).intValue() * f1 / 100.0F * 255.0F);
    this.b.setAlpha(paramInt);
    this.a.reset();
    paramInt = 0;
    while (paramInt < this.d.size())
    {
      this.a.addPath(((bg)this.d.get(paramInt)).getPath(), paramMatrix);
      paramInt += 1;
    }
    paramCanvas.drawPath(this.a, this.b);
  }
  
  public void getBounds(RectF paramRectF, Matrix paramMatrix)
  {
    this.a.reset();
    int i = 0;
    while (i < this.d.size())
    {
      this.a.addPath(((bg)this.d.get(i)).getPath(), paramMatrix);
      i += 1;
    }
    this.a.computeBounds(paramRectF, false);
    paramRectF.set(paramRectF.left - 1.0F, paramRectF.top - 1.0F, paramRectF.right + 1.0F, paramRectF.bottom + 1.0F);
  }
  
  public String getName()
  {
    return this.c;
  }
  
  public void onValueChanged()
  {
    this.g.invalidateSelf();
  }
  
  public void setContents(List<x> paramList1, List<x> paramList2)
  {
    int i = 0;
    while (i < paramList2.size())
    {
      paramList1 = (x)paramList2.get(i);
      if ((paramList1 instanceof bg)) {
        this.d.add((bg)paramList1);
      }
      i += 1;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/airbnb/lottie/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */