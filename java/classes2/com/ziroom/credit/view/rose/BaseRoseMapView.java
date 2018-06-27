package com.ziroom.credit.view.rose;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BaseRoseMapView
  extends View
{
  Paint a = new Paint();
  Paint b = new Paint();
  Paint c = new Paint();
  public float d = 0.0F;
  int e = 0;
  List<Float> f = new ArrayList();
  private float g;
  private float h;
  private float i;
  private int j;
  private float k = 1.0F;
  private int l = 2;
  
  public BaseRoseMapView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public BaseRoseMapView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public BaseRoseMapView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private a a(a parama, float paramFloat)
  {
    paramFloat = paramFloat / this.d * this.i * this.k;
    a locala = new a();
    locala.a = (this.g - (this.g - parama.a) / this.i * paramFloat);
    locala.b = (this.h - paramFloat * ((this.h - parama.b) / this.i));
    return locala;
  }
  
  private void a()
  {
    this.a.setAntiAlias(true);
    this.b.setAntiAlias(true);
    this.b.setColor(61147);
    this.b.setStyle(Paint.Style.STROKE);
    this.b.setStrokeWidth(1.0F);
    this.c.setAntiAlias(true);
    this.c.setStyle(Paint.Style.FILL);
    this.c.setColor(54152);
    this.a.setStyle(Paint.Style.STROKE);
    this.a.setStrokeWidth(dip2px(getContext(), 2.0F));
  }
  
  public static int dip2px(Context paramContext, float paramFloat)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().density * paramFloat / 1.5D + 0.5D);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    int n = 0;
    if (this.j == 0) {}
    float f1;
    do
    {
      return;
      m = 3;
      while (m > 0)
      {
        localObject1 = new Path();
        ((Path)localObject1).moveTo(this.g - this.i * m / 3.0F, this.h);
        ((Path)localObject1).lineTo(this.g, this.h - this.i * m / 3.0F);
        ((Path)localObject1).lineTo(this.g + this.i * m / 3.0F, this.h);
        ((Path)localObject1).lineTo(this.g, this.h + this.i * m / 3.0F);
        ((Path)localObject1).close();
        this.b.setStyle(Paint.Style.FILL);
        this.b.setColor(65019);
        paramCanvas.drawPath((Path)localObject1, this.b);
        this.b.setStrokeWidth(dip2px(getContext(), 0.8F));
        this.b.setStyle(Paint.Style.STROKE);
        this.b.setColor(57802);
        paramCanvas.drawPath((Path)localObject1, this.b);
        m -= 1;
      }
      m = 0;
      while (m < 2)
      {
        paramCanvas.save();
        paramCanvas.rotate(360 / this.j * m, this.g, this.h);
        f1 = this.g;
        float f2 = this.i;
        float f3 = this.h;
        float f4 = this.g;
        paramCanvas.drawLine(f1 - f2, f3, this.i + f4, this.h, this.b);
        paramCanvas.restore();
        m += 1;
      }
    } while (this.j == 0);
    Object localObject1 = new float[this.j * 4];
    int m = 0;
    if (m < this.j)
    {
      localObject2 = a(b.calculateCoordinate(this.g, this.h, this.g, this.e, 360 / this.j * m), ((Float)this.f.get(m)).floatValue());
      localObject1[(m * 4)] = ((a)localObject2).a;
      localObject1[(m * 4 + 1)] = ((a)localObject2).b;
      if (m + 1 < this.j)
      {
        localObject2 = a(b.calculateCoordinate(this.g, this.h, this.g, this.e, 360 / this.j * (m + 1)), ((Float)this.f.get(m + 1)).floatValue());
        localObject1[(m * 4 + 2)] = ((a)localObject2).a;
        localObject1[(m * 4 + 3)] = ((a)localObject2).b;
      }
      for (;;)
      {
        m += 1;
        break;
        localObject2 = a(b.calculateCoordinate(this.g, this.h, this.g, this.e, 360 / this.j * 0), ((Float)this.f.get(0)).floatValue());
        localObject1[(m * 4 + 2)] = ((a)localObject2).a;
        localObject1[(m * 4 + 3)] = ((a)localObject2).b;
      }
    }
    Object localObject2 = new float[localObject1.length];
    int i1 = dip2px(getContext(), 6.0F);
    m = n;
    while (m < localObject1.length) {
      switch (this.l)
      {
      default: 
        m += 1;
        break;
      case 2: 
        if (m % 2 == 1) {}
        for (f1 = localObject1[m] + i1;; f1 = localObject1[m])
        {
          localObject2[m] = f1;
          break;
        }
      case 0: 
        if (m % 2 == 1) {}
        for (f1 = localObject1[m] - i1;; f1 = localObject1[m])
        {
          localObject2[m] = f1;
          break;
        }
      case 1: 
        if (m % 2 == 0) {}
        for (f1 = localObject1[m] + i1;; f1 = localObject1[m])
        {
          localObject2[m] = f1;
          break;
        }
      case 3: 
        if (m % 2 == 0) {}
        for (f1 = localObject1[m] - i1;; f1 = localObject1[m])
        {
          localObject2[m] = f1;
          break;
        }
      }
    }
    this.a.setShader(null);
    this.a.setColor(-921103);
    paramCanvas.drawLines((float[])localObject2, this.a);
    localObject2 = new LinearGradient(0.0F, 0.0F, getWidth(), 0.0F, -34489, 52846, Shader.TileMode.CLAMP);
    this.a.setShader((Shader)localObject2);
    this.a.setAntiAlias(true);
    paramCanvas.drawLines((float[])localObject1, this.a);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.g = ((paramInt3 - paramInt1) / 2);
    this.h = ((paramInt3 - paramInt1) / 2);
    this.i = ((paramInt3 - paramInt1) / 2 - this.e);
  }
  
  public void setPading(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setmCurrentSelected(int paramInt)
  {
    this.l = paramInt;
    postInvalidate();
  }
  
  public void setmData(List<Float> paramList)
  {
    this.f = paramList;
    if (paramList == null) {}
    for (int m = 0;; m = paramList.size())
    {
      this.j = m;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Float localFloat = (Float)paramList.next();
        if (this.d < localFloat.floatValue()) {
          this.d = localFloat.floatValue();
        }
      }
    }
    postInvalidate();
  }
  
  public void setmRatio(float paramFloat)
  {
    this.k = paramFloat;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/credit/view/rose/BaseRoseMapView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */