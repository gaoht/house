package com.ziroom.credit.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.ziroom.credit.R.drawable;
import com.ziroom.datacenter.remote.responsebody.financial.b.u;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreditChartView
  extends RelativeLayout
{
  List<Float> a = new ArrayList();
  private List<u> b;
  private boolean c;
  private boolean d = false;
  private ValueAnimator e;
  private boolean f;
  private int g;
  private int h;
  private Paint i;
  private int j = 0;
  private int k = 0;
  private int l = 0;
  private int m = 0;
  private int n = 0;
  private int o = dip2px(40.0F);
  private int p = dip2px(50.0F);
  private View q;
  private ArrayList<Float> r = new ArrayList();
  private ArrayList<Float> s = new ArrayList();
  private List<String> t = Arrays.asList(new String[] { "0", "60", "120", "180", "240" });
  
  public CreditChartView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public CreditChartView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public CreditChartView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.q = new ChartView(getContext());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    this.q.setLayoutParams(localLayoutParams);
    addView(this.q);
    this.i = new Paint();
    this.l = dip2px(30.0F);
  }
  
  private void b()
  {
    if (this.b == null) {}
    do
    {
      return;
      this.j = this.b.size();
      this.k = this.t.size();
      this.n = ((this.h - (this.k - 1) * this.o) / 2);
      if ((this.k != 0) && (this.j != 0)) {
        this.p = ((this.g - this.l - this.m) / this.j);
      }
      this.r.clear();
      this.s.clear();
      this.a.clear();
    } while ((this.b == null) || (this.b.size() <= 0));
    int i1 = 0;
    while (i1 < this.b.size())
    {
      Object localObject2 = Float.valueOf(((u)this.b.get(i1)).getScore());
      Object localObject1 = localObject2;
      if (Float.valueOf(((Float)localObject2).floatValue()).floatValue() < 0.0F) {
        localObject1 = Float.valueOf(0.0F);
      }
      localObject2 = localObject1;
      if (Float.valueOf(((Float)localObject1).floatValue()).floatValue() > 240.0F) {
        localObject2 = Float.valueOf(240.0F);
      }
      this.a.add(Float.valueOf(this.o * (this.t.size() - 1) + this.n - ((Float)localObject2).floatValue() * this.o / 60.0F));
      i1 += 1;
    }
    c();
  }
  
  private void c()
  {
    float[] arrayOfFloat = new float[this.a.size()];
    int i1 = 0;
    while (i1 < this.a.size())
    {
      arrayOfFloat[i1] = ((Float)this.a.get(i1)).floatValue();
      i1 += 1;
    }
    this.e = ValueAnimator.ofFloat(arrayOfFloat);
    this.e.setDuration(850L);
    this.e.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        CreditChartView.b(CreditChartView.this).clear();
        CreditChartView.a(CreditChartView.this).clear();
        int j = (int)(paramAnonymousValueAnimator.getAnimatedFraction() * CreditChartView.m(CreditChartView.this));
        int i = 0;
        while (i < j)
        {
          CreditChartView.b(CreditChartView.this).add(Float.valueOf(CreditChartView.f(CreditChartView.this) + (i + 1) * CreditChartView.g(CreditChartView.this) * 1.0F - CreditChartView.g(CreditChartView.this) / 2));
          CreditChartView.a(CreditChartView.this).add(CreditChartView.this.a.get(i));
          i += 1;
        }
        if ((j < CreditChartView.m(CreditChartView.this)) && (j > 0))
        {
          CreditChartView.b(CreditChartView.this).add(Float.valueOf(CreditChartView.f(CreditChartView.this) + paramAnonymousValueAnimator.getAnimatedFraction() * CreditChartView.m(CreditChartView.this) * CreditChartView.g(CreditChartView.this) * 1.0F - CreditChartView.g(CreditChartView.this) / 2));
          CreditChartView.a(CreditChartView.this).add(Float.valueOf(((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue()));
        }
        CreditChartView.n(CreditChartView.this).invalidate();
      }
    });
    if (this.c)
    {
      this.e.start();
      return;
    }
    this.e.end();
  }
  
  private Paint getShadeColorPaint()
  {
    if (this.f)
    {
      LinearGradient localLinearGradient = new LinearGradient(0.0F, 0.0F, 0.0F, this.h, 16777215, 553628257, Shader.TileMode.CLAMP);
      this.i.setShader(localLinearGradient);
    }
    for (;;)
    {
      return this.i;
      this.i.setColor(1626271470);
    }
  }
  
  public int dip2px(float paramFloat)
  {
    return (int)(getContext().getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    int i2 = 0;
    b();
    float[] arrayOfFloat = new float[(this.k + 0) * 4];
    int i1 = 0;
    float f1;
    float f2;
    while (i1 < this.k)
    {
      f1 = this.l;
      f2 = this.n + (i1 + 0) * this.o;
      float f3 = this.g - this.m;
      float f4 = this.n + (i1 + 0) * this.o;
      arrayOfFloat[(i1 * 4 + 0)] = f1;
      arrayOfFloat[(i1 * 4 + 1)] = f2;
      arrayOfFloat[(i1 * 4 + 2)] = f3;
      arrayOfFloat[(i1 * 4 + 3)] = f4;
      this.i.setColor(-6710887);
      this.i.setTextSize(dip2px(12.0F));
      this.i.setTextAlign(Paint.Align.CENTER);
      paramCanvas.drawText((String)this.t.get(this.k - i1 - 1), f1 - dip2px(20.0F), f2 + 10.0F, this.i);
      i1 += 1;
    }
    i1 = 0;
    while (i1 < this.j)
    {
      f1 = this.l + (i1 + 1) * this.p - this.p / 2;
      f2 = this.n + (this.k - 1) * this.o;
      paramCanvas.drawText(String.valueOf(((u)this.b.get(i1)).getDate()), f1, f2 + dip2px(25.0F), this.i);
      i1 += 1;
    }
    Paint localPaint = new Paint(1);
    localPaint.setStyle(Paint.Style.STROKE);
    localPaint.setColor(57802);
    localPaint.setAntiAlias(true);
    localPaint.setStrokeWidth(2.0F);
    localPaint.setPathEffect(new DashPathEffect(new float[] { 5.0F, 5.0F }, 1.0F));
    Path localPath = new Path();
    i1 = i2;
    while (i1 < arrayOfFloat.length)
    {
      f1 = arrayOfFloat[i1];
      i1 += 1;
      localPath.moveTo(f1, arrayOfFloat[i1]);
      i1 += 1;
      f1 = arrayOfFloat[i1];
      i1 += 1;
      localPath.lineTo(f1, arrayOfFloat[i1]);
      i1 += 1;
    }
    localPath.close();
    paramCanvas.drawPath(localPath, localPaint);
    localPaint = new Paint(1);
    localPaint.setStyle(Paint.Style.STROKE);
    localPaint.setColor(57802);
    localPaint.setAntiAlias(true);
    localPaint.setStrokeWidth(4.0F);
    localPath = new Path();
    if (arrayOfFloat.length > 4)
    {
      localPath.moveTo(arrayOfFloat[(arrayOfFloat.length - 4)], arrayOfFloat[(arrayOfFloat.length - 3)]);
      localPath.lineTo(arrayOfFloat[(arrayOfFloat.length - 2)], arrayOfFloat[(arrayOfFloat.length - 1)]);
    }
    localPath.close();
    paramCanvas.drawPath(localPath, localPaint);
    super.dispatchDraw(paramCanvas);
  }
  
  public List<u> getRankData()
  {
    return this.b;
  }
  
  public boolean isColor()
  {
    return this.f;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    this.g = View.MeasureSpec.getSize(paramInt1);
    this.h = View.MeasureSpec.getSize(paramInt2);
    if (this.g > this.h)
    {
      this.g = this.h;
      super.onMeasure(paramInt2, paramInt2);
      return;
    }
    this.h = this.g;
    super.onMeasure(paramInt1, paramInt1);
  }
  
  public void setRankData(List<u> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramList == null) {
      return;
    }
    this.c = paramBoolean1;
    this.b = paramList;
    this.f = paramBoolean2;
    postInvalidate();
  }
  
  public class ChartView
    extends View
  {
    public ChartView(Context paramContext)
    {
      super();
    }
    
    public ChartView(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    protected void onDraw(Canvas paramCanvas)
    {
      int j = 0;
      super.onDraw(paramCanvas);
      if ((CreditChartView.a(CreditChartView.this) == null) || (CreditChartView.a(CreditChartView.this).size() == 0) || (CreditChartView.b(CreditChartView.this) == null) || (CreditChartView.b(CreditChartView.this).size() == 0)) {
        return;
      }
      Object localObject1 = new float[CreditChartView.b(CreditChartView.this).size() * 4];
      Object localObject2 = new Path();
      ((Path)localObject2).moveTo(((Float)CreditChartView.b(CreditChartView.this).get(CreditChartView.b(CreditChartView.this).size() - 1)).floatValue(), CreditChartView.c(CreditChartView.this) + (CreditChartView.d(CreditChartView.this) - 1) * CreditChartView.e(CreditChartView.this));
      ((Path)localObject2).lineTo(CreditChartView.f(CreditChartView.this) + CreditChartView.g(CreditChartView.this) / 2, CreditChartView.c(CreditChartView.this) + (CreditChartView.d(CreditChartView.this) - 1) * CreditChartView.e(CreditChartView.this));
      int i = 0;
      if (i < CreditChartView.b(CreditChartView.this).size())
      {
        localObject1[(i * 4)] = ((Float)CreditChartView.b(CreditChartView.this).get(i)).floatValue();
        localObject1[(i * 4 + 1)] = ((Float)CreditChartView.a(CreditChartView.this).get(i)).floatValue();
        if (i + 1 < CreditChartView.b(CreditChartView.this).size())
        {
          localObject1[(i * 4 + 2)] = ((Float)CreditChartView.b(CreditChartView.this).get(i + 1)).floatValue();
          localObject1[(i * 4 + 3)] = ((Float)CreditChartView.a(CreditChartView.this).get(i + 1)).floatValue();
        }
        for (;;)
        {
          ((Path)localObject2).lineTo(((Float)CreditChartView.b(CreditChartView.this).get(i)).floatValue(), ((Float)CreditChartView.a(CreditChartView.this).get(i)).floatValue());
          i += 1;
          break;
          localObject1[(i * 4 + 2)] = ((Float)CreditChartView.b(CreditChartView.this).get(i)).floatValue();
          localObject1[(i * 4 + 3)] = ((Float)CreditChartView.a(CreditChartView.this).get(i)).floatValue();
        }
      }
      paramCanvas.drawPath((Path)localObject2, CreditChartView.h(CreditChartView.this));
      if (CreditChartView.b(CreditChartView.this).size() == 1)
      {
        CreditChartView.i(CreditChartView.this).reset();
        CreditChartView.i(CreditChartView.this).setStrokeWidth(1.0F);
        CreditChartView.i(CreditChartView.this).setColor(-12143874);
        paramCanvas.drawLine(((Float)CreditChartView.b(CreditChartView.this).get(0)).floatValue(), ((Float)CreditChartView.a(CreditChartView.this).get(0)).floatValue(), ((Float)CreditChartView.b(CreditChartView.this).get(0)).floatValue(), CreditChartView.c(CreditChartView.this) + (CreditChartView.d(CreditChartView.this) - 1) * CreditChartView.e(CreditChartView.this), CreditChartView.i(CreditChartView.this));
      }
      CreditChartView.i(CreditChartView.this).reset();
      CreditChartView.i(CreditChartView.this).setStrokeWidth(CreditChartView.this.dip2px(2.0F));
      if (CreditChartView.j(CreditChartView.this))
      {
        localObject2 = new LinearGradient(0.0F, 0.0F, CreditChartView.k(CreditChartView.this), 0.0F, -34489, 52846, Shader.TileMode.CLAMP);
        CreditChartView.i(CreditChartView.this).setShader((Shader)localObject2);
        CreditChartView.i(CreditChartView.this).setAntiAlias(true);
        paramCanvas.drawLines((float[])localObject1, CreditChartView.i(CreditChartView.this));
        CreditChartView.i(CreditChartView.this).setShader(null);
        CreditChartView.i(CreditChartView.this).setColor(-921103);
        localObject2 = new float[localObject1.length];
        i = j;
        if (i < localObject1.length)
        {
          if (i % 2 == 0) {
            localObject2[i] = localObject1[i];
          }
          for (;;)
          {
            i += 1;
            break;
            localObject1[i] += CreditChartView.this.dip2px(5.0F);
          }
        }
        paramCanvas.drawLines((float[])localObject2, CreditChartView.i(CreditChartView.this));
        label798:
        CreditChartView.i(CreditChartView.this).reset();
        i = CreditChartView.b(CreditChartView.this).size() - 1;
        label822:
        if (i < CreditChartView.b(CreditChartView.this).size())
        {
          CreditChartView.i(CreditChartView.this).setColor(-1);
          CreditChartView.i(CreditChartView.this).setStyle(Paint.Style.FILL);
          paramCanvas.drawCircle(((Float)CreditChartView.b(CreditChartView.this).get(i)).floatValue(), ((Float)CreditChartView.a(CreditChartView.this).get(i)).floatValue(), CreditChartView.this.dip2px(3.0F), CreditChartView.i(CreditChartView.this));
          if (!CreditChartView.j(CreditChartView.this)) {
            break label1347;
          }
          CreditChartView.i(CreditChartView.this).setColor(33098);
        }
      }
      for (;;)
      {
        CreditChartView.i(CreditChartView.this).setStyle(Paint.Style.FILL);
        paramCanvas.drawCircle(((Float)CreditChartView.b(CreditChartView.this).get(i)).floatValue(), ((Float)CreditChartView.a(CreditChartView.this).get(i)).floatValue(), CreditChartView.this.dip2px(2.0F), CreditChartView.i(CreditChartView.this));
        if (CreditChartView.j(CreditChartView.this))
        {
          localObject1 = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.credit_zrk_bg_cdt_score);
          float f1 = ((Float)CreditChartView.b(CreditChartView.this).get(i)).floatValue();
          float f2 = CreditChartView.this.dip2px(16.0F);
          float f3 = ((Float)CreditChartView.a(CreditChartView.this).get(i)).floatValue();
          float f4 = CreditChartView.this.dip2px(26.0F);
          float f5 = ((Float)CreditChartView.b(CreditChartView.this).get(i)).floatValue();
          paramCanvas.drawBitmap((Bitmap)localObject1, null, new RectF(f1 - f2, f3 - f4, CreditChartView.this.dip2px(16.0F) + f5, ((Float)CreditChartView.a(CreditChartView.this).get(i)).floatValue()), CreditChartView.i(CreditChartView.this));
          CreditChartView.i(CreditChartView.this).setColor(40960);
          CreditChartView.i(CreditChartView.this).setTextSize(CreditChartView.this.dip2px(12.0F));
          paramCanvas.drawText(((u)CreditChartView.l(CreditChartView.this).get(i)).getScore(), ((Float)CreditChartView.b(CreditChartView.this).get(i)).floatValue() - CreditChartView.this.dip2px(10.0F), ((Float)CreditChartView.a(CreditChartView.this).get(i)).floatValue() - CreditChartView.this.dip2px(10.0F), CreditChartView.i(CreditChartView.this));
        }
        i += 1;
        break label822;
        break;
        CreditChartView.i(CreditChartView.this).setColor(1626271470);
        CreditChartView.i(CreditChartView.this).setAntiAlias(true);
        paramCanvas.drawLines((float[])localObject1, CreditChartView.i(CreditChartView.this));
        break label798;
        label1347:
        CreditChartView.i(CreditChartView.this).setColor(-1118482);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/credit/view/CreditChartView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */