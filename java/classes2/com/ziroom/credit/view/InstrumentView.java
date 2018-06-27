package com.ziroom.credit.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;

public class InstrumentView
  extends View
{
  private static final String[] q = { "200以上", "150", "100", "70", "30" };
  private Paint a = new Paint(1);
  private int b = -328966;
  private Paint c = new Paint(1);
  private final int[] d = { 50514, 50514, 50514, 50514, 50514 };
  private int e = this.b;
  private Paint f = new Paint(1);
  private Paint g = new Paint(1);
  private Paint h = new Paint(1);
  private int i;
  private int j;
  private int k;
  private float l = 0.0F;
  private float m = 0.0F;
  private int n = 0;
  private float o = 0.0F;
  private boolean p = false;
  
  public InstrumentView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public InstrumentView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public InstrumentView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.a.setStyle(Paint.Style.STROKE);
    this.a.setShadowLayer(2.0F, 2.0F, 2.0F, -3355444);
    this.a.setStrokeWidth(dip2px(getContext(), 1.0F));
    this.a.setColor(this.b);
    this.g.setStyle(Paint.Style.STROKE);
    this.g.setShadowLayer(2.0F, 2.0F, 2.0F, -3355444);
    this.g.setStrokeWidth(dip2px(getContext(), 20.0F));
    this.g.setColor(-1);
    SweepGradient localSweepGradient = new SweepGradient(0.0F, 0.0F, new int[] { -951216, this.e }, new float[] { 0.0F, 0.5F });
    this.c.setShader(localSweepGradient);
    this.c.setStyle(Paint.Style.STROKE);
    this.c.setStrokeWidth(dip2px(getContext(), 16.0F));
    this.c.setStrokeCap(Paint.Cap.ROUND);
  }
  
  private void b()
  {
    SweepGradient localSweepGradient = new SweepGradient(0.0F, 0.0F, new int[] { -951216, this.e }, new float[] { 0.0F, 0.5F });
    this.c.setShader(localSweepGradient);
  }
  
  public static int dip2px(Context paramContext, float paramFloat)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().density * paramFloat / 1.5D + 0.5D);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    paramCanvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
    float f1 = this.j - dip2px(getContext(), 2.0F);
    paramCanvas.save();
    paramCanvas.translate(this.j, this.j);
    this.a.setStrokeWidth(dip2px(getContext(), 1.0F));
    paramCanvas.drawArc(new RectF(-f1, -f1, f1, f1), 137.0F, 264.0F, false, this.a);
    f1 -= dip2px(getContext(), 20.0F);
    this.a.setStrokeWidth(dip2px(getContext(), 16.0F));
    paramCanvas.drawArc(new RectF(-f1, -f1, f1, f1), 135.0F, 270.0F, false, this.a);
    paramCanvas.restore();
    b();
    this.h.setColor(-6710887);
    this.h.setTextSize(dip2px(getContext(), 16.0F));
    int i1 = 1;
    while (i1 < 5)
    {
      paramCanvas.save();
      float f2 = this.h.measureText(q[i1]);
      double d1 = Math.toDegrees(Math.acos((this.j * this.j * 2 - f2 * f2) / (this.j * 2 * this.j)));
      paramCanvas.rotate((float)(i1 * -54 - d1 / 2.0D + 133.0D), this.j, this.j);
      paramCanvas.drawText(q[i1], this.j, dip2px(getContext(), 50.0F), this.h);
      paramCanvas.restore();
      i1 += 1;
    }
    this.h.setColor(-1118482);
    i1 = 0;
    while (i1 < 5)
    {
      paramCanvas.save();
      paramCanvas.rotate(i1 * -54 + 113, this.j, this.j);
      paramCanvas.drawCircle(this.j - dip2px(getContext(), 10.0F), dip2px(getContext(), 40.0F), dip2px(getContext(), 3.0F), this.h);
      paramCanvas.restore();
      i1 += 1;
    }
    paramCanvas.save();
    paramCanvas.translate(this.j, this.j);
    paramCanvas.rotate(128.0F);
    paramCanvas.drawArc(new RectF(-f1, -f1, f1, f1), 4.0F, this.m, false, this.c);
    paramCanvas.restore();
    paramCanvas.save();
    paramCanvas.translate(this.j, this.j);
    paramCanvas.rotate(128.0F);
    paramCanvas.drawArc(new RectF(-f1, -f1, f1, f1), 0.0F, 7.0F, false, this.g);
    paramCanvas.restore();
    this.f.setColor(-1);
    this.f.setStrokeWidth(dip2px(getContext(), 2.0F));
    int i2 = this.j * 2 - dip2px(getContext(), 30.0F);
    i1 = 0;
    while (i1 < 6)
    {
      paramCanvas.save();
      paramCanvas.rotate(i1 * 54 + 135, this.j, this.j);
      paramCanvas.drawLine(i2, this.j, dip2px(getContext(), 16.0F) + i2, this.j, this.f);
      paramCanvas.restore();
      i1 += 1;
    }
    super.onDraw(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    this.i = View.MeasureSpec.getSize(paramInt1);
    if (paramInt2 < this.i) {
      this.i = paramInt2;
    }
    paramInt1 = this.i / 2;
    this.k = paramInt1;
    this.j = paramInt1;
    setMeasuredDimension(this.i, this.i);
  }
  
  public void setReferValue(int paramInt, final a parama)
  {
    this.n = paramInt;
    this.m = 0.0F;
    if (paramInt <= 30) {
      this.l = (paramInt / 30.0F * 54.0F);
    }
    for (;;)
    {
      this.o = (this.l / 54.0F);
      new Thread(new Runnable()
      {
        public void run()
        {
          int i = 1;
          for (;;)
          {
            if (i != 0) {
              try
              {
                Thread.sleep(16L);
                InstrumentView.a(InstrumentView.this, InstrumentView.a(InstrumentView.this) + InstrumentView.b(InstrumentView.this));
                if (InstrumentView.a(InstrumentView.this) >= InstrumentView.c(InstrumentView.this))
                {
                  InstrumentView.a(InstrumentView.this, InstrumentView.c(InstrumentView.this));
                  i = 0;
                }
                if (parama != null)
                {
                  if (InstrumentView.a(InstrumentView.this) <= 54.0F)
                  {
                    f = InstrumentView.a(InstrumentView.this) / 54.0F * 30.0F;
                    InstrumentView.a(InstrumentView.this, InstrumentView.d(InstrumentView.this)[0]);
                    if (InstrumentView.a(InstrumentView.this) != InstrumentView.c(InstrumentView.this)) {
                      break label376;
                    }
                    parama.rotate(InstrumentView.a(InstrumentView.this), InstrumentView.e(InstrumentView.this), InstrumentView.f(InstrumentView.this));
                  }
                }
                else {
                  InstrumentView.this.postInvalidate();
                }
              }
              catch (InterruptedException localInterruptedException)
              {
                for (;;)
                {
                  float f;
                  localInterruptedException.printStackTrace();
                  continue;
                  if (InstrumentView.a(InstrumentView.this) <= 108.0F)
                  {
                    f = (InstrumentView.a(InstrumentView.this) - 54.0F) / 54.0F * 40.0F + 30.0F;
                    InstrumentView.a(InstrumentView.this, InstrumentView.d(InstrumentView.this)[1]);
                  }
                  else if (InstrumentView.a(InstrumentView.this) <= 162.0F)
                  {
                    f = 70.0F + (InstrumentView.a(InstrumentView.this) - 108.0F) / 54.0F * 30.0F;
                    InstrumentView.a(InstrumentView.this, InstrumentView.d(InstrumentView.this)[2]);
                  }
                  else if (InstrumentView.a(InstrumentView.this) <= 216.0F)
                  {
                    f = 100.0F + (InstrumentView.a(InstrumentView.this) - 162.0F) / 54.0F * 50.0F;
                    InstrumentView.a(InstrumentView.this, InstrumentView.d(InstrumentView.this)[3]);
                  }
                  else
                  {
                    InstrumentView.a(InstrumentView.this, InstrumentView.d(InstrumentView.this)[4]);
                    f = InstrumentView.e(InstrumentView.this);
                    continue;
                    label376:
                    parama.rotate(InstrumentView.a(InstrumentView.this), f, InstrumentView.f(InstrumentView.this));
                  }
                }
              }
            }
          }
        }
      }).start();
      return;
      if (paramInt <= 70) {
        this.l = ((paramInt - 30) * 54 / 40.0F + 54.0F);
      } else if (paramInt <= 100) {
        this.l = ((paramInt - 70) * 54 / 30.0F + 108.0F);
      } else if (paramInt <= 150) {
        this.l = ((paramInt - 100) * 54 / 50.0F + 162.0F);
      } else {
        this.l = 243.0F;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void rotate(float paramFloat1, float paramFloat2, int paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/credit/view/InstrumentView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */