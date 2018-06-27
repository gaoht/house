package com.ziroom.credit.view.rose;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RoseMapView
  extends FrameLayout
  implements View.OnClickListener, View.OnTouchListener
{
  float a = 0.0F;
  float b = 0.0F;
  float c = 0.0F;
  float d = 0.0F;
  b e = null;
  List<View> f = new ArrayList();
  BaseRoseMapView g;
  float h = 0.0F;
  List<Float> i = new ArrayList();
  long j = 0L;
  long k = 0L;
  MotionEvent l;
  boolean m = false;
  float n = 0.0F;
  private float o = 180.0F;
  private Matrix p = new Matrix();
  private int q = 0;
  private a r = null;
  private float s = 1.0F;
  
  public RoseMapView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public RoseMapView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public RoseMapView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private float a(MotionEvent paramMotionEvent)
  {
    double d1 = b.distance4PointF(this.a, this.b, paramMotionEvent.getX(), paramMotionEvent.getY());
    double d2 = b.distance4PointF(this.a, this.b, this.q / 2, this.q / 2);
    double d3 = b.distance4PointF(this.q / 2, this.q / 2, paramMotionEvent.getX(), paramMotionEvent.getY());
    d1 = Math.acos((d2 * d2 + d3 * d3 - d1 * d1) / (d2 * 2.0D * d3));
    int i1 = b.getRoatationTo(this.q / 2, this.q / 2, paramMotionEvent.getX(), paramMotionEvent.getY(), this.a, this.b);
    this.a = paramMotionEvent.getX();
    this.b = paramMotionEvent.getY();
    float f1 = (float)Math.toDegrees(d1);
    return i1 * f1;
  }
  
  private void a()
  {
    setOnTouchListener(this);
    this.g = new BaseRoseMapView(getContext());
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    this.g.setLayoutParams(localLayoutParams);
    addView(this.g, 0);
  }
  
  private void a(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    int i2 = 1;
    int i1 = 0;
    int i4 = this.i.size();
    if (i4 == 0) {}
    int i3;
    do
    {
      for (;;)
      {
        return;
        i3 = 360 / i4;
        if ((!paramBoolean) || (this.e == null)) {
          break;
        }
        i1 = 0;
        while (i1 < i4)
        {
          if (a((View)this.f.get(i1), paramMotionEvent))
          {
            i2 = (int)(this.o % 360.0F) / i3;
            paramMotionEvent = (View)this.f.get((i1 - i2 + i4) % i4);
            this.e.onClick(paramMotionEvent);
            setmRotation(180 - i1 * i3);
            this.g.setmCurrentSelected(indexOfChild(paramMotionEvent) - 1);
            return;
          }
          i1 += 1;
        }
      }
      i4 = (int)this.o / i3;
      if ((int)Math.abs(this.o % i3 / (i3 / 2)) > 0) {
        i1 = 1;
      }
      if (this.o < 0.0F) {
        i2 = -1;
      }
      i1 = i1 * i2 + i4;
      this.n = (i1 * i3 - this.o);
      b();
    } while ((paramBoolean) || (this.r == null));
    i1 = (int)(i1 + this.h / i3);
    while (i1 < 0) {
      i1 += 360 / i3;
    }
    this.r.rotate(i1 * i3 % 360);
    i1 = (-(i1 * i3) % 360 + 180 + 360) % 360 / 90;
    this.g.setmCurrentSelected(i1);
  }
  
  private boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    return (paramMotionEvent.getX() >= paramView.getX()) && (paramMotionEvent.getX() <= paramView.getX() + paramView.getWidth()) && (paramMotionEvent.getY() >= paramView.getY()) && (paramMotionEvent.getY() <= paramView.getY() + paramView.getHeight());
  }
  
  private void b()
  {
    new Thread(new Runnable()
    {
      public void run()
      {
        float f = RoseMapView.this.n;
        int i;
        if (f < 0.0F) {
          i = -1;
        }
        while (Float.compare(f, 0.0F) != 0) {
          try
          {
            Thread.sleep(16L);
            if (Math.abs(f) > 6)
            {
              RoseMapView.a(RoseMapView.this, RoseMapView.a(RoseMapView.this) + 6 * i);
              f -= 6 * i;
              RoseMapView.this.postInvalidate();
              continue;
              i = 1;
            }
          }
          catch (InterruptedException localInterruptedException)
          {
            for (;;)
            {
              localInterruptedException.printStackTrace();
            }
            RoseMapView.a(RoseMapView.this, f + RoseMapView.a(RoseMapView.this));
            RoseMapView.this.postInvalidate();
            f = 0.0F;
          }
        }
      }
    }).start();
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    this.p.reset();
    if (Float.isNaN(this.o)) {
      this.o = 0.0F;
    }
    this.p.postRotate(this.o, this.q / 2, this.q / 2);
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext()) {
      ((View)localIterator.next()).setRotation(-this.o - this.h);
    }
    paramCanvas.save();
    paramCanvas.concat(this.p);
    super.dispatchDraw(paramCanvas);
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    if (this.e != null) {
      this.e.onClick(paramView);
    }
  }
  
  protected void onFinishInflate()
  {
    int i1 = 1;
    super.onFinishInflate();
    int i2 = getChildCount();
    if (i2 <= 1) {}
    for (;;)
    {
      return;
      this.f.clear();
      while (i1 < i2)
      {
        View localView = getChildAt(i1);
        this.f.add(localView);
        int i3 = localView.getLayoutParams().width;
        this.g.setPading(i3);
        i1 += 1;
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    this.q = View.MeasureSpec.getSize(paramInt1);
    int i1 = View.MeasureSpec.getSize(paramInt2);
    if (this.q > i1)
    {
      this.q = i1;
      super.onMeasure(paramInt2, paramInt2);
      return;
    }
    super.onMeasure(paramInt1, paramInt1);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      requestDisallowInterceptTouchEvent(true);
      do
      {
        return true;
        this.m = true;
        this.l = paramMotionEvent;
        this.j = System.currentTimeMillis();
        this.a = paramMotionEvent.getX();
        this.b = paramMotionEvent.getY();
        this.c = 0.0F;
        this.d = 0.0F;
        break;
        if (!this.m) {
          break;
        }
        this.c += Math.abs(paramMotionEvent.getX() - this.a);
        this.d += Math.abs(paramMotionEvent.getY() - this.b);
      } while ((this.c < 20.0F) || (this.d < 20.0F));
      this.o = (a(paramMotionEvent) + this.o % 360.0F);
      invalidate();
      continue;
      this.m = false;
      if ((System.currentTimeMillis() - this.j > 200L) || (this.c > 20.0F) || (this.d > 20.0F))
      {
        a(paramMotionEvent, false);
      }
      else if (System.currentTimeMillis() - this.k > 250L)
      {
        this.k = System.currentTimeMillis();
        a(paramMotionEvent, true);
      }
    }
  }
  
  public void setRotateListener(a parama)
  {
    this.r = parama;
  }
  
  public void setmData(List<Float> paramList)
  {
    this.i = paramList;
    this.g.setmData(paramList);
  }
  
  public void setmRatio(float paramFloat)
  {
    this.s = paramFloat;
    this.g.setmRatio(paramFloat);
  }
  
  public void setmRotation(float paramFloat)
  {
    this.n = (paramFloat - this.h);
    if (this.n <= -180.0F) {
      this.n += 360.0F;
    }
    for (;;)
    {
      b();
      return;
      if (this.n > 180.0F) {
        this.n -= 360.0F;
      }
    }
  }
  
  public void setonClickListener(b paramb)
  {
    this.e = paramb;
  }
  
  public static abstract interface a
  {
    public abstract void rotate(float paramFloat);
  }
  
  public static abstract interface b
  {
    @Instrumented
    public abstract void onClick(View paramView);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/credit/view/rose/RoseMapView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */