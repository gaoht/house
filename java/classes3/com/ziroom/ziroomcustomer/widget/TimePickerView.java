package com.ziroom.ziroomcustomer.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Paint.Style;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class TimePickerView
  extends View
{
  Handler a = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      if (Math.abs(TimePickerView.a(TimePickerView.this)) < 2.0F)
      {
        TimePickerView.a(TimePickerView.this, 0.0F);
        if (TimePickerView.b(TimePickerView.this) != null)
        {
          TimePickerView.b(TimePickerView.this).cancel();
          TimePickerView.a(TimePickerView.this, null);
          TimePickerView.c(TimePickerView.this);
        }
      }
      for (;;)
      {
        TimePickerView.this.invalidate();
        return;
        TimePickerView.a(TimePickerView.this, TimePickerView.a(TimePickerView.this) - TimePickerView.a(TimePickerView.this) / Math.abs(TimePickerView.a(TimePickerView.this)) * 2.0F);
      }
    }
  };
  private List<String> b;
  private int c;
  private int d;
  private Paint e;
  private float f = 80.0F;
  private float g = 40.0F;
  private float h = 255.0F;
  private float i = 120.0F;
  private int j = 4473924;
  private int k;
  private int l;
  private float m;
  private float n = 0.0F;
  private boolean o = false;
  private b p;
  private Timer q;
  private a r;
  
  public TimePickerView(Context paramContext)
  {
    super(paramContext);
    d();
  }
  
  public TimePickerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    d();
  }
  
  private float a(float paramFloat1, float paramFloat2)
  {
    paramFloat1 = (float)(1.0D - Math.pow(paramFloat2 / paramFloat1, 2.0D));
    if (paramFloat1 < 0.0F) {
      return 0.0F;
    }
    return paramFloat1;
  }
  
  private void a()
  {
    if (this.p != null) {
      this.p.onSelect((String)this.b.get(this.c), this.d);
    }
  }
  
  private void a(Canvas paramCanvas)
  {
    float f1 = a(this.k / 4.0F, this.n);
    float f2 = this.f;
    float f3 = this.g;
    float f4 = this.g;
    this.e.setTextSize((f2 - f3) * f1 + f4);
    f2 = (float)(this.l / 2.0D);
    f3 = (float)(this.k / 2.0D + this.n);
    Paint.FontMetricsInt localFontMetricsInt = this.e.getFontMetricsInt();
    double d1 = f3;
    double d2 = localFontMetricsInt.bottom / 2.0D;
    f3 = (float)(d1 - (localFontMetricsInt.top / 2.0D + d2));
    this.e.setAlpha(70);
    paramCanvas.drawLine(0.0F, (int)(this.k / 2.55D), this.l, (int)(this.k / 2.55D), this.e);
    this.e.setAlpha((int)((this.h - this.i) * f1 + this.i));
    paramCanvas.drawText((String)this.b.get(this.c), f2, f3, this.e);
    this.e.setAlpha(70);
    paramCanvas.drawLine(0.0F, (int)(this.k / 1.6D), this.l, (int)(this.k / 1.6D), this.e);
    if (this.b.size() < 4)
    {
      i1 = 1;
      while (i1 < 2)
      {
        a(paramCanvas, i1, -1, this.b.size() - i1);
        i1 += 1;
      }
      i1 = 1;
      while (i1 < 2)
      {
        a(paramCanvas, i1, 1);
        i1 += 1;
      }
    }
    int i1 = 1;
    while (i1 < 3)
    {
      a(paramCanvas, i1, -1, this.b.size() - i1);
      i1 += 1;
    }
    i1 = 1;
    while (i1 < 3)
    {
      a(paramCanvas, i1, 1);
      i1 += 1;
    }
  }
  
  private void a(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    float f1 = 3.0F * this.g * paramInt1 + paramInt2 * this.n;
    float f2 = a(this.k / 4.0F, f1);
    float f3 = this.f;
    float f4 = this.g;
    float f5 = this.g;
    this.e.setTextSize(f2 * (f3 - f4) + f5);
    this.e.setAlpha(60);
    double d1 = this.k / 2.0D;
    f1 = (float)(f1 * paramInt2 + d1);
    Paint.FontMetricsInt localFontMetricsInt = this.e.getFontMetricsInt();
    d1 = f1;
    double d2 = localFontMetricsInt.bottom / 2.0D;
    f1 = (float)(d1 - (localFontMetricsInt.top / 2.0D + d2));
    paramCanvas.drawText((String)this.b.get(this.c + paramInt2 * paramInt1), (float)(this.l / 2.0D), f1, this.e);
  }
  
  private void a(Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3)
  {
    float f1 = 3.0F * this.g * paramInt1 + paramInt2 * this.n;
    float f2 = a(this.k / 4.0F, f1);
    float f3 = this.f;
    float f4 = this.g;
    float f5 = this.g;
    this.e.setTextSize(f2 * (f3 - f4) + f5);
    this.e.setAlpha(60);
    double d1 = this.k / 2.0D;
    f1 = (float)(f1 * paramInt2 + d1);
    Paint.FontMetricsInt localFontMetricsInt = this.e.getFontMetricsInt();
    d1 = f1;
    double d2 = localFontMetricsInt.bottom / 2.0D;
    f1 = (float)(d1 - (localFontMetricsInt.top / 2.0D + d2));
    paramCanvas.drawText((String)this.b.get(paramInt3), (float)(this.l / 2.0D), f1, this.e);
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    if (this.r != null)
    {
      this.r.cancel();
      this.r = null;
    }
    this.m = paramMotionEvent.getY();
  }
  
  private void b()
  {
    String str = (String)this.b.get(0);
    this.b.remove(0);
    this.b.add(str);
  }
  
  private void b(MotionEvent paramMotionEvent)
  {
    this.n += paramMotionEvent.getY() - this.m;
    if (this.b == null) {
      return;
    }
    if (("".equals(this.b.get(this.b.size() - 1))) && (this.n > this.g * 3.0F / 2.0F - 2.0F))
    {
      this.n -= paramMotionEvent.getY() - this.m;
      return;
    }
    if (("".equals(this.b.get(this.c + 1))) && (this.n < this.g * -3.0F / 2.0F + 2.0F))
    {
      this.n -= paramMotionEvent.getY() - this.m;
      return;
    }
    if (this.n > this.g * 3.0F / 2.0F)
    {
      c();
      this.n -= this.g * 3.0F;
      if (this.d == 0) {
        this.d = (this.b.size() - 1);
      }
    }
    for (;;)
    {
      this.m = paramMotionEvent.getY();
      invalidate();
      return;
      this.d -= 1;
      continue;
      if (this.n < this.g * -3.0F / 2.0F)
      {
        b();
        this.n += this.g * 3.0F;
        if (this.d == this.b.size() - 1) {
          this.d = 0;
        } else {
          this.d += 1;
        }
      }
    }
  }
  
  private void c()
  {
    String str = (String)this.b.get(this.b.size() - 1);
    this.b.remove(this.b.size() - 1);
    this.b.add(0, str);
  }
  
  private void c(MotionEvent paramMotionEvent)
  {
    if (Math.abs(this.n) < 1.0E-4D)
    {
      this.n = 0.0F;
      return;
    }
    if (this.r != null)
    {
      this.r.cancel();
      this.r = null;
    }
    this.r = new a(this.a);
    this.q.schedule(this.r, 0L, 10L);
  }
  
  private void d()
  {
    this.q = new Timer();
    this.b = new ArrayList();
    this.e = new Paint(1);
    this.e.setStyle(Paint.Style.FILL);
    this.e.setTextAlign(Paint.Align.CENTER);
    this.e.setColor(this.j);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    try
    {
      if (this.o) {
        a(paramCanvas);
      }
      return;
    }
    catch (Exception paramCanvas)
    {
      paramCanvas.printStackTrace();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.k = getMeasuredHeight();
    this.l = getMeasuredWidth();
    this.f = sp2px(getContext(), 18.0F);
    this.g = sp2px(getContext(), 18.0F);
    this.o = true;
    invalidate();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      return true;
      a(paramMotionEvent);
      continue;
      b(paramMotionEvent);
      continue;
      c(paramMotionEvent);
    }
  }
  
  public void setData(List<String> paramList)
  {
    this.b = paramList;
    this.c = 0;
    invalidate();
  }
  
  public void setData(List<String> paramList, int paramInt)
  {
    this.b = paramList;
    this.c = paramInt;
    invalidate();
  }
  
  public void setOnSelectListener(b paramb)
  {
    this.p = paramb;
  }
  
  public void setSelected(int paramInt)
  {
    this.c = paramInt;
  }
  
  public int sp2px(Context paramContext, float paramFloat)
  {
    return (int)TypedValue.applyDimension(2, paramFloat, paramContext.getResources().getDisplayMetrics());
  }
  
  class a
    extends TimerTask
  {
    Handler a;
    
    public a(Handler paramHandler)
    {
      this.a = paramHandler;
    }
    
    public void run()
    {
      this.a.sendMessage(this.a.obtainMessage());
    }
  }
  
  public static abstract interface b
  {
    public abstract void onSelect(String paramString, int paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/widget/TimePickerView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */