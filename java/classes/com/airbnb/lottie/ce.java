package com.airbnb.lottie;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;

class ce
  extends p
{
  private final String b;
  private final au<Integer> c;
  
  ce(ax paramax, o paramo, by paramby)
  {
    super(paramax, paramo, paramby.g().a(), paramby.h().a(), paramby.c(), paramby.d(), paramby.e(), paramby.f());
    this.b = paramby.a();
    this.c = paramby.b().createAnimation();
    this.c.a(this);
    paramo.a(this.c);
  }
  
  public void addColorFilter(String paramString1, String paramString2, ColorFilter paramColorFilter)
  {
    this.a.setColorFilter(paramColorFilter);
  }
  
  public void draw(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    this.a.setColor(((Integer)this.c.getValue()).intValue());
    super.draw(paramCanvas, paramMatrix, paramInt);
  }
  
  public String getName()
  {
    return this.b;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/airbnb/lottie/ce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */