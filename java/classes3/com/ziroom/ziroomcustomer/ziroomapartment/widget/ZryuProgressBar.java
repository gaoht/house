package com.ziroom.ziroomcustomer.ziroomapartment.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.animation.AccelerateInterpolator;
import com.ziroom.ziroomcustomer.R.styleable;
import com.ziroom.ziroomcustomer.ziroomapartment.model.sd.MeterDetail.IntellectDialsVo;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ZryuProgressBar
  extends View
{
  private int A = 0;
  private String B = "";
  private int C = 0;
  private int D = (int)a(getResources(), 6.0F);
  private int E = (int)a(getResources(), 12.0F);
  private int F = (int)a(getResources(), 2.0F);
  private int G = this.D / 2 - this.D;
  private int H;
  private String I;
  private String J;
  private int K;
  private float L;
  private float M;
  private float N;
  private float O;
  private int P;
  private int Q;
  private boolean R = false;
  private int S;
  private List<MeterDetail.IntellectDialsVo> T = new ArrayList();
  private final int a = 100;
  private final int b = 5000;
  private int c;
  private int d = 1;
  private Paint e;
  private Paint f;
  private Paint g;
  private Paint h = new Paint(1);
  private Paint i;
  private Paint j;
  private RectF k;
  private RectF l;
  private Rect m;
  private Path n;
  private int o = 135;
  private int p = 270;
  private int q;
  private int r;
  private float s;
  private float t;
  private float u;
  private float v = a(getResources(), 2.0F);
  private int w = -2236963;
  private int x = 40960;
  private int y = -2236963;
  private int z = 40960;
  
  public ZryuProgressBar(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public ZryuProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ZryuProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
    a();
  }
  
  private float a(float paramFloat)
  {
    return getResources().getDisplayMetrics().density * paramFloat + 0.5F;
  }
  
  private float a(Resources paramResources, float paramFloat)
  {
    return paramResources.getDisplayMetrics().density * paramFloat + 0.5F;
  }
  
  private int a(int paramInt)
  {
    return (int)(getResources().getDisplayMetrics().scaledDensity * paramInt + 0.5F);
  }
  
  private String a(String paramString)
  {
    if (paramString == null) {
      paramString = "";
    }
    for (;;)
    {
      return paramString;
      StringBuilder localStringBuilder = new StringBuilder(paramString);
      int i1 = paramString.length() - 1;
      while (i1 > 0)
      {
        localStringBuilder.insert(i1, " ");
        paramString = localStringBuilder.toString();
        i1 -= 1;
      }
    }
  }
  
  private void a()
  {
    this.h.setColor(-12303292);
    this.h.setTextSize(a(getResources(), 10.0F));
    this.f = new Paint();
    this.f.setAntiAlias(true);
    this.f.setStyle(Paint.Style.STROKE);
    this.f.setStrokeWidth(this.v);
    this.f.setColor(this.w);
    this.f.setStrokeCap(Paint.Cap.ROUND);
    this.e = new Paint();
    this.e.setAntiAlias(true);
    this.e.setStyle(Paint.Style.STROKE);
    this.e.setStrokeWidth(this.v);
    this.e.setColor(this.x);
    this.e.setStrokeCap(Paint.Cap.ROUND);
    this.e.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
    this.g = new Paint();
    this.g.setAntiAlias(true);
    this.g.setStrokeWidth(this.F);
    this.g.setColor(this.y);
    this.i = new Paint();
    this.i.setAntiAlias(true);
    this.i.setColor(-12303292);
    this.i.setTextSize(this.H);
    this.j = new Paint();
    this.j.setAntiAlias(true);
    this.j.setColor(-6710887);
    this.j.setTextSize(a(getResources(), 12.0F));
    this.n = new Path();
    this.m = new Rect();
    this.u = a(getResources(), 10.0F);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ArcProgressBar);
    this.A = paramContext.getInteger(0, this.A);
    this.w = paramContext.getColor(1, this.w);
    this.d = paramContext.getInteger(12, 1);
    this.y = paramContext.getColor(2, this.y);
    this.z = paramContext.getColor(3, this.z);
    this.C = paramContext.getInteger(4, this.C);
    this.D = paramContext.getInteger(5, this.D);
    this.F = paramContext.getInteger(6, this.F);
    this.G = paramContext.getInteger(7, this.G);
    this.I = paramContext.getString(9);
    this.H = ((int)paramContext.getDimension(10, a(64)));
    this.B = paramContext.getString(11);
    if (TextUtils.isEmpty(this.B)) {
      this.B = "";
    }
    paramContext.recycle();
  }
  
  private void a(Canvas paramCanvas)
  {
    String str1 = "";
    String str2 = "";
    if (!TextUtils.isEmpty(this.I)) {
      str1 = this.I;
    }
    if (!TextUtils.isEmpty(this.J)) {
      str2 = this.J;
    }
    paramCanvas.drawText(str1, this.P - this.i.measureText(str1) / 2.0F, this.P, this.i);
    paramCanvas.drawText(str2, this.P - this.j.measureText(str2) / 2.0F, this.P + a(getResources(), 24.0F), this.j);
  }
  
  private void a(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    this.g.setColor(paramInt1);
    float f1 = (float)(6.283185307179586D / this.C);
    float f2 = f1 / 2.0F;
    paramInt1 = 0;
    if (paramInt1 < paramInt2)
    {
      float f3 = paramInt1 * f1;
      if ((f3 > 4.6774826F) && (f3 < 6.2831855F)) {}
      for (;;)
      {
        paramInt1 += 1;
        break;
        f3 += 3.9269907F + f2;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        if ((this.T != null) && (this.T.size() > 0) && (((MeterDetail.IntellectDialsVo)this.T.get(0)).getDialsNum().intValue() - 1 == paramInt1))
        {
          f4 = this.P;
          f5 = (float)Math.sin(f3);
          f6 = this.O;
          f7 = this.P;
          f8 = (float)Math.cos(f3);
          f9 = this.O;
          f10 = this.P;
          paramCanvas.drawLine(f5 * f6 + f4, f7 - f8 * f9, (float)Math.sin(f3) * this.L + f10, this.P - (float)Math.cos(f3) * this.L, this.g);
          paramCanvas.save();
          this.h.setColor(-12303292);
          this.h.setTextSize(a(getResources(), 10.0F));
          this.h.getTextBounds(((MeterDetail.IntellectDialsVo)this.T.get(0)).getIntellectReadings(), 0, ((MeterDetail.IntellectDialsVo)this.T.get(0)).getIntellectReadings().length(), this.m);
          f3 = (float)(this.m.width() * 180 / 2 / (3.141592653589793D * (this.c - this.t - this.m.height())));
          this.n.reset();
          this.n.addArc(this.l, this.o + (paramInt1 + 0.5F) * (this.p / (this.C * 0.75F)) - f3, this.p);
          paramCanvas.drawTextOnPath(a(((MeterDetail.IntellectDialsVo)this.T.get(0)).getIntellectReadings()), this.n, a(getResources(), -2.0F), a(getResources(), 20.0F), this.h);
          this.T.add(this.T.get(0));
          this.T.remove(0);
        }
        else
        {
          f4 = this.P;
          f5 = (float)Math.sin(f3);
          f6 = this.N;
          f7 = this.P;
          f8 = (float)Math.cos(f3);
          f9 = this.N;
          f10 = this.P;
          paramCanvas.drawLine(f5 * f6 + f4, f7 - f8 * f9, (float)Math.sin(f3) * this.L + f10, this.P - (float)Math.cos(f3) * this.L, this.g);
        }
      }
    }
    this.h.setColor(-1118482);
  }
  
  private float[] a(float paramFloat1, float paramFloat2)
  {
    float[] arrayOfFloat = new float[2];
    double d1 = Math.toRadians(paramFloat2);
    double d2;
    if (paramFloat2 < 90.0F)
    {
      arrayOfFloat[0] = ((float)(this.q + Math.cos(d1) * paramFloat1));
      d2 = this.r;
      arrayOfFloat[1] = ((float)(Math.sin(d1) * paramFloat1 + d2));
      return arrayOfFloat;
    }
    if (paramFloat2 == 90.0F)
    {
      arrayOfFloat[0] = this.q;
      arrayOfFloat[1] = (this.r + paramFloat1);
      return arrayOfFloat;
    }
    if ((paramFloat2 > 90.0F) && (paramFloat2 < 180.0F))
    {
      d1 = (180.0F - paramFloat2) * 3.141592653589793D / 180.0D;
      arrayOfFloat[0] = ((float)(this.q - Math.cos(d1) * paramFloat1));
      d2 = this.r;
      arrayOfFloat[1] = ((float)(Math.sin(d1) * paramFloat1 + d2));
      return arrayOfFloat;
    }
    if (paramFloat2 == 180.0F)
    {
      arrayOfFloat[0] = (this.q - paramFloat1);
      arrayOfFloat[1] = this.r;
      return arrayOfFloat;
    }
    if ((paramFloat2 > 180.0F) && (paramFloat2 < 270.0F))
    {
      d1 = (paramFloat2 - 180.0F) * 3.141592653589793D / 180.0D;
      arrayOfFloat[0] = ((float)(this.q - Math.cos(d1) * paramFloat1));
      arrayOfFloat[1] = ((float)(this.r - Math.sin(d1) * paramFloat1));
      return arrayOfFloat;
    }
    if (paramFloat2 == 270.0F)
    {
      arrayOfFloat[0] = this.q;
      arrayOfFloat[1] = (this.r - paramFloat1);
      return arrayOfFloat;
    }
    d1 = (360.0F - paramFloat2) * 3.141592653589793D / 180.0D;
    arrayOfFloat[0] = ((float)(this.q + Math.cos(d1) * paramFloat1));
    arrayOfFloat[1] = ((float)(this.r - Math.sin(d1) * paramFloat1));
    return arrayOfFloat;
  }
  
  private SweepGradient b()
  {
    float f1 = this.q;
    float f2 = this.c;
    int i1 = Color.argb(255, 255, 175, 79);
    int i2 = Color.argb(255, 255, 199, 49);
    float f3 = c() / this.p;
    SweepGradient localSweepGradient = new SweepGradient(f1, f2, new int[] { i1, i2 }, new float[] { 0.0F, f3 });
    Matrix localMatrix = new Matrix();
    localMatrix.setRotate(this.o - 1, this.q, this.r);
    localSweepGradient.setLocalMatrix(localMatrix);
    return localSweepGradient;
  }
  
  private void b(Canvas paramCanvas)
  {
    if (this.S == 0) {
      return;
    }
    Paint localPaint = new Paint();
    localPaint.setStyle(Paint.Style.FILL);
    localPaint.setStrokeWidth(a(getResources(), 2.0F));
    localPaint.setColor(50483);
    float[] arrayOfFloat = a(this.c - this.u - 2.0F, this.o + c());
    paramCanvas.drawCircle(arrayOfFloat[0], arrayOfFloat[1], this.u / 2.0F, localPaint);
    localPaint.setStyle(Paint.Style.FILL);
    localPaint.setStrokeWidth(a(getResources(), 0.0F));
    localPaint.setColor(-1);
    paramCanvas.drawCircle(arrayOfFloat[0], arrayOfFloat[1], this.u / 2.0F - a(getResources(), 2.0F), localPaint);
  }
  
  private void b(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    this.g.setColor(paramInt1);
    float f1 = (float)(6.283185307179586D / this.C);
    float f2 = f1 / 2.0F;
    paramInt1 = 0;
    if (paramInt1 < paramInt2)
    {
      float f3 = paramInt1 * f1;
      if ((f3 > 4.6774826F) && (f3 < 6.2831855F)) {}
      for (;;)
      {
        paramInt1 += 1;
        break;
        f3 += 3.9269907F + f2;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        if (this.K == paramInt1 + 1)
        {
          f4 = this.P;
          f5 = (float)Math.sin(f3);
          f6 = this.O;
          f7 = this.P;
          f8 = (float)Math.cos(f3);
          f9 = this.O;
          f10 = this.P;
          paramCanvas.drawLine(f5 * f6 + f4, f7 - f8 * f9, (float)Math.sin(f3) * this.M + f10, this.P - (float)Math.cos(f3) * this.M, this.g);
          paramCanvas.save();
        }
        else if ((this.T != null) && (this.T.size() > 0) && (((MeterDetail.IntellectDialsVo)this.T.get(0)).getDialsNum().intValue() - 1 == paramInt1))
        {
          f4 = this.P;
          f5 = (float)Math.sin(f3);
          f6 = this.O;
          f7 = this.P;
          f8 = (float)Math.cos(f3);
          f9 = this.O;
          f10 = this.P;
          paramCanvas.drawLine(f5 * f6 + f4, f7 - f8 * f9, (float)Math.sin(f3) * this.L + f10, this.P - (float)Math.cos(f3) * this.L, this.g);
          paramCanvas.save();
          this.h.setColor(-12303292);
          this.h.setTextSize(a(getResources(), 10.0F));
          this.h.getTextBounds(((MeterDetail.IntellectDialsVo)this.T.get(0)).getIntellectReadings(), 0, ((MeterDetail.IntellectDialsVo)this.T.get(0)).getIntellectReadings().length(), this.m);
          f3 = (float)(this.m.width() * 180 / 2 / (3.141592653589793D * (this.c - this.t - this.m.height())));
          this.n.reset();
          this.n.addArc(this.l, this.o + (paramInt1 + 0.5F) * (this.p / (this.C * 0.75F)) - f3, this.p);
          paramCanvas.drawTextOnPath(a(((MeterDetail.IntellectDialsVo)this.T.get(0)).getIntellectReadings()), this.n, a(getResources(), -2.0F), a(getResources(), 20.0F), this.h);
          this.T.add(this.T.get(0));
          this.T.remove(0);
        }
        else
        {
          f4 = this.P;
          f5 = (float)Math.sin(f3);
          f6 = this.N;
          f7 = this.P;
          f8 = (float)Math.cos(f3);
          f9 = this.N;
          f10 = this.P;
          paramCanvas.drawLine(f5 * f6 + f4, f7 - f8 * f9, (float)Math.sin(f3) * this.L + f10, this.P - (float)Math.cos(f3) * this.L, this.g);
        }
      }
    }
    this.h.setColor(-1118482);
  }
  
  private float c()
  {
    return this.S * this.p / this.C * 4 / 3;
  }
  
  private void c(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    float f1 = (float)(6.283185307179586D / this.C);
    float f2 = f1 / 2.0F;
    int i1 = 0;
    if (i1 < paramInt2)
    {
      float f3 = i1 * f1;
      if ((f3 > 4.6774826F) && (f3 < 6.2831855F)) {}
      for (;;)
      {
        i1 += 1;
        break;
        f3 += 3.9269907F + f2;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        if ((this.T != null) && (this.T.size() > 0) && (((MeterDetail.IntellectDialsVo)this.T.get(0)).getDialsNum().intValue() - 1 == i1))
        {
          this.g.setColor(paramInt1);
          f4 = this.P;
          f5 = (float)Math.sin(f3);
          f6 = this.O;
          f7 = this.P;
          f8 = (float)Math.cos(f3);
          f9 = this.O;
          f10 = this.P;
          paramCanvas.drawLine(f5 * f6 + f4, f7 - f8 * f9, (float)Math.sin(f3) * this.M + f10, this.P - (float)Math.cos(f3) * this.M, this.g);
          paramCanvas.save();
          this.h.setColor(-12303292);
          this.h.setTextSize(a(getResources(), 10.0F));
          this.h.getTextBounds(((MeterDetail.IntellectDialsVo)this.T.get(0)).getIntellectReadings(), 0, ((MeterDetail.IntellectDialsVo)this.T.get(0)).getIntellectReadings().length(), this.m);
          f3 = (float)(this.m.width() * 180 / 2 / (3.141592653589793D * (this.c - this.t - this.m.height())));
          this.n.reset();
          this.n.addArc(this.l, this.o + (i1 + 0.5F) * (this.p / (this.C * 0.75F)) - f3, this.p);
          paramCanvas.drawTextOnPath(a(((MeterDetail.IntellectDialsVo)this.T.get(0)).getIntellectReadings()), this.n, a(getResources(), -2.0F), a(getResources(), 20.0F), this.h);
          this.T.add(this.T.get(0));
          this.T.remove(0);
        }
        else
        {
          this.g.setColor(0);
          f4 = this.P;
          f5 = (float)Math.sin(f3);
          f6 = this.N;
          f7 = this.P;
          f8 = (float)Math.cos(f3);
          f9 = this.N;
          f10 = this.P;
          paramCanvas.drawLine(f5 * f6 + f4, f7 - f8 * f9, (float)Math.sin(f3) * this.L + f10, this.P - (float)Math.cos(f3) * this.L, this.g);
        }
      }
    }
    this.h.setColor(-1118482);
  }
  
  public static int getInt(float paramFloat)
  {
    return new BigDecimal(paramFloat).setScale(0, 4).intValue();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    float f1 = c();
    if (f1 > this.p) {
      f1 = this.p;
    }
    for (;;)
    {
      if (this.d == 2)
      {
        this.e.setShader(b());
        paramCanvas.drawArc(this.k, this.o, this.p, false, this.f);
        paramCanvas.drawArc(this.k, this.o, f1, false, this.e);
        a(paramCanvas);
        c(paramCanvas, this.y, this.C);
        c(paramCanvas, this.z, this.K);
        b(paramCanvas);
      }
      do
      {
        do
        {
          return;
        } while (this.d != 1);
        a(paramCanvas, this.y, this.C);
        a(paramCanvas);
      } while (this.R);
      b(paramCanvas, this.z, this.K);
      return;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    paramInt2 = Math.max(Math.max(getPaddingLeft(), getPaddingTop()), Math.max(getPaddingRight(), getPaddingBottom()));
    setPadding(paramInt2, paramInt2, paramInt2, paramInt2);
    this.s = (paramInt2 + a(getResources(), 10.0F) / 2.0F + a(getResources(), 8.0F));
    this.t = (this.s + a(getResources(), 1.0F) + a(getResources(), 5.0F));
    this.c = ((resolveSize((int)a(getResources(), 220.0F), paramInt1) - paramInt2 * 2) / 2);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    paramInt2 = paramInt1 / 2;
    this.r = paramInt2;
    this.q = paramInt2;
    setMeasuredDimension(paramInt1, paramInt1);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.P = ((int)(paramInt1 / 2.0F));
    this.k = new RectF();
    this.k.top = 5.0F;
    this.k.left = 5.0F;
    this.k.right = paramInt1;
    this.k.bottom = paramInt2;
    this.k.inset(this.u, this.u);
    this.l = new RectF();
    this.l.top = 10.0F;
    this.l.left = 5.0F;
    this.l.right = paramInt1;
    this.l.bottom = paramInt2;
    this.l.inset(this.u + 10.0F, this.u + 10.0F);
    this.Q = ((int)(this.k.width() / 2.0F));
    this.L = (this.Q - this.v / 2.0F - this.G);
    this.M = (this.L + this.D);
    this.N = (this.L - this.D);
    this.O = (this.L - this.E);
  }
  
  public void restart()
  {
    this.R = true;
    this.S = 0;
    this.I = "";
    invalidate();
  }
  
  public void setCalibraList(List<MeterDetail.IntellectDialsVo> paramList)
  {
    this.T = paramList;
    postInvalidate();
  }
  
  public void setDottedLineCount(int paramInt)
  {
    int i1 = paramInt;
    if (paramInt > 100) {
      i1 = 100;
    }
    this.C = (i1 / 3 + i1);
  }
  
  public void setProgress(int paramInt1, int paramInt2)
  {
    int i1 = paramInt1;
    if (paramInt1 < 0) {
      i1 = 0;
    }
    paramInt1 = i1;
    if (i1 > this.C) {
      paramInt1 = this.C;
    }
    i1 = paramInt2;
    if (paramInt2 > 5000) {
      i1 = 5000;
    }
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, paramInt1 });
    localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        ZryuProgressBar.a(ZryuProgressBar.this, ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
        ZryuProgressBar.a(ZryuProgressBar.this, false);
        ZryuProgressBar.b(ZryuProgressBar.this, ZryuProgressBar.a(ZryuProgressBar.this));
        ZryuProgressBar.this.postInvalidate();
      }
    });
    localValueAnimator.setInterpolator(new AccelerateInterpolator());
    localValueAnimator.setDuration(i1 * paramInt1);
    localValueAnimator.start();
  }
  
  public void setProgressDesc(String paramString1, String paramString2)
  {
    this.I = paramString1;
    this.J = paramString2;
    this.i.setTextSize(this.H);
    float f1 = this.i.measureText(this.I);
    f1 = (this.O * 2.0F - a(40.0F)) / f1;
    if ((f1 < 1.0F) && (f1 > 0.0F)) {
      this.i.setTextSize(f1 * this.H);
    }
    postInvalidate();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/widget/ZryuProgressBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */