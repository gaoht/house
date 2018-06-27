package cn.testin.analysis;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;

public class gr
  extends View
{
  private boolean A;
  private String B;
  private String C;
  private String D;
  private int E;
  private int F;
  private boolean G;
  private int H;
  private boolean I;
  private int J;
  private boolean K;
  private boolean L;
  private boolean M;
  private Drawable N;
  private Bitmap O;
  private float P;
  private float Q;
  private Bitmap R;
  private Bitmap S;
  private Bitmap T;
  private Bitmap U;
  private float V;
  private StaticLayout W;
  private int a;
  private int aa;
  private boolean ab;
  private int b;
  private Rect c;
  private float d;
  private float e;
  private Paint f = new Paint();
  private TextPaint g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  private int n;
  private int o;
  private int p;
  private int q;
  private int r;
  private boolean s;
  private Drawable t;
  private Bitmap u;
  private int v;
  private int w;
  private int x;
  private boolean y;
  private int z;
  
  public gr(Context paramContext)
  {
    super(paramContext);
    this.f.setAntiAlias(true);
    this.h = Color.parseColor("#33FFFFFF");
    this.i = -65536;
    this.j = ge.a(paramContext, 15.0F);
    this.k = ge.a(paramContext, 3.0F);
    this.p = ge.a(paramContext, 1.0F);
    this.q = -1;
    this.o = ge.a(paramContext, 90.0F);
    this.l = ge.a(paramContext, 200.0F);
    this.n = ge.a(paramContext, 140.0F);
    this.r = 0;
    this.s = true;
    this.t = null;
    this.u = null;
    this.v = ge.a(paramContext, 1.0F);
    this.w = 0;
    this.x = 1000;
    this.y = true;
    this.z = 0;
    this.A = false;
    this.a = ge.a(paramContext, 2.0F);
    this.D = null;
    this.E = ge.b(paramContext, 14.0F);
    this.F = -1;
    this.G = false;
    this.H = ge.a(paramContext, 20.0F);
    this.I = false;
    this.J = Color.parseColor("#22000000");
    this.K = false;
    this.L = true;
    this.M = false;
    this.g = new TextPaint();
    this.g.setAntiAlias(true);
    this.aa = ge.a(paramContext, 4.0F);
    this.ab = true;
    a();
  }
  
  private void a()
  {
    this.U = ge.a(this.T, 90);
    this.U = ge.a(this.U, 90);
    this.U = ge.a(this.U, 90);
    if (this.t != null) {
      this.R = ((BitmapDrawable)this.t).getBitmap();
    }
    this.S = ge.a(this.R, 90);
    this.o += this.z;
    this.V = (1.0F * this.k / 2.0F);
    this.g.setTextSize(this.E);
    this.g.setColor(this.F);
    setIsBarcode(this.A);
  }
  
  private void a(Canvas paramCanvas)
  {
    int i1 = paramCanvas.getWidth();
    int i2 = paramCanvas.getHeight();
    if (this.h != 0)
    {
      this.f.setStyle(Paint.Style.FILL);
      this.f.setColor(this.h);
      paramCanvas.drawRect(0.0F, 0.0F, i1, this.c.top, this.f);
      paramCanvas.drawRect(0.0F, this.c.top, this.c.left, this.c.bottom + 1, this.f);
      paramCanvas.drawRect(this.c.right + 1, this.c.top, i1, this.c.bottom + 1, this.f);
      paramCanvas.drawRect(0.0F, this.c.bottom + 1, i1, i2, this.f);
    }
  }
  
  private void b()
  {
    int i1;
    float f1;
    if (this.A) {
      if (this.O == null)
      {
        this.e += this.a;
        i1 = this.p;
        if (this.u != null) {
          i1 = this.u.getWidth();
        }
        if (this.L)
        {
          f1 = this.e;
          if ((i1 + f1 > this.c.right - this.V) || (this.e < this.c.left + this.V)) {
            this.a = (-this.a);
          }
        }
      }
    }
    for (;;)
    {
      postInvalidateDelayed(this.b, this.c.left, this.c.top, this.c.right, this.c.bottom);
      return;
      f1 = this.e;
      if (i1 + f1 > this.c.right - this.V)
      {
        this.e = (this.c.left + this.V + 0.5F);
        continue;
        this.Q += this.a;
        if (this.Q > this.c.right - this.V)
        {
          this.Q = (this.c.left + this.V + 0.5F);
          continue;
          if (this.O == null)
          {
            this.d += this.a;
            i1 = this.p;
            if (this.u != null) {
              i1 = this.u.getHeight();
            }
            if (this.L)
            {
              f1 = this.d;
              if ((i1 + f1 > this.c.bottom - this.V) || (this.d < this.c.top + this.V)) {
                this.a = (-this.a);
              }
            }
            else
            {
              f1 = this.d;
              if (i1 + f1 > this.c.bottom - this.V) {
                this.d = (this.c.top + this.V + 0.5F);
              }
            }
          }
          else
          {
            this.P += this.a;
            if (this.P > this.c.bottom - this.V) {
              this.P = (this.c.top + this.V + 0.5F);
            }
          }
        }
      }
    }
  }
  
  private void b(Canvas paramCanvas)
  {
    if (this.v > 0)
    {
      this.f.setStyle(Paint.Style.STROKE);
      this.f.setColor(this.w);
      this.f.setStrokeWidth(this.v);
      paramCanvas.drawRect(this.c, this.f);
    }
  }
  
  private void c()
  {
    int i1 = (getWidth() - this.l) / 2;
    this.c = new Rect(i1, this.o, this.l + i1, this.o + this.m);
    if (this.A)
    {
      f1 = this.c.left + this.V + 0.5F;
      this.e = f1;
      this.Q = f1;
      return;
    }
    float f1 = this.c.top + this.V + 0.5F;
    this.d = f1;
    this.P = f1;
  }
  
  private void c(Canvas paramCanvas)
  {
    if (this.V > 0.0F)
    {
      this.f.setStyle(Paint.Style.STROKE);
      this.f.setColor(this.i);
      this.f.setStrokeWidth(this.k);
      float f1 = this.c.left;
      float f2 = this.V;
      float f3 = this.c.top;
      float f4 = this.c.left;
      float f5 = this.V;
      paramCanvas.drawLine(f1 - f2, f3, this.j + (f4 - f5), this.c.top, this.f);
      f1 = this.c.left;
      f2 = this.c.top;
      f3 = this.V;
      f4 = this.c.left;
      f5 = this.c.top;
      float f6 = this.V;
      paramCanvas.drawLine(f1, f2 - f3, f4, this.j + (f5 - f6), this.f);
      f1 = this.c.right;
      paramCanvas.drawLine(this.V + f1, this.c.top, this.c.right + this.V - this.j, this.c.top, this.f);
      f1 = this.c.right;
      f2 = this.c.top;
      f3 = this.V;
      f4 = this.c.right;
      f5 = this.c.top;
      f6 = this.V;
      paramCanvas.drawLine(f1, f2 - f3, f4, this.j + (f5 - f6), this.f);
      f1 = this.c.left;
      f2 = this.V;
      f3 = this.c.bottom;
      f4 = this.c.left;
      f5 = this.V;
      paramCanvas.drawLine(f1 - f2, f3, this.j + (f4 - f5), this.c.bottom, this.f);
      f1 = this.c.left;
      f2 = this.c.bottom;
      paramCanvas.drawLine(f1, this.V + f2, this.c.left, this.c.bottom + this.V - this.j, this.f);
      f1 = this.c.right;
      paramCanvas.drawLine(this.V + f1, this.c.bottom, this.c.right + this.V - this.j, this.c.bottom, this.f);
      f1 = this.c.right;
      f2 = this.c.bottom;
      paramCanvas.drawLine(f1, this.V + f2, this.c.right, this.c.bottom + this.V - this.j, this.f);
    }
  }
  
  private void d(Canvas paramCanvas)
  {
    RectF localRectF;
    Rect localRect;
    if (this.A)
    {
      if (this.O != null)
      {
        localRectF = new RectF(this.c.left + this.V + 0.5F, this.c.top + this.V + this.r, this.Q, this.c.bottom - this.V - this.r);
        localRect = new Rect((int)(this.O.getWidth() - localRectF.width()), 0, this.O.getWidth(), this.O.getHeight());
        if (localRect.left < 0)
        {
          localRect.left = 0;
          localRectF.left = (localRectF.right - localRect.width());
        }
        paramCanvas.drawBitmap(this.O, localRect, localRectF, this.f);
        return;
      }
      if (this.u != null)
      {
        localRectF = new RectF(this.e, this.c.top + this.V + this.r, this.e + this.u.getWidth(), this.c.bottom - this.V - this.r);
        paramCanvas.drawBitmap(this.u, null, localRectF, this.f);
        return;
      }
      this.f.setStyle(Paint.Style.FILL);
      this.f.setColor(this.q);
      f1 = this.e;
      f2 = this.c.top;
      f3 = this.V;
      f4 = this.r;
      f5 = this.e;
      paramCanvas.drawRect(f1, f4 + (f2 + f3), this.p + f5, this.c.bottom - this.V - this.r, this.f);
      return;
    }
    if (this.O != null)
    {
      localRectF = new RectF(this.c.left + this.V + this.r, this.c.top + this.V + 0.5F, this.c.right - this.V - this.r, this.P);
      localRect = new Rect(0, (int)(this.O.getHeight() - localRectF.height()), this.O.getWidth(), this.O.getHeight());
      if (localRect.top < 0)
      {
        localRect.top = 0;
        localRectF.top = (localRectF.bottom - localRect.height());
      }
      paramCanvas.drawBitmap(this.O, localRect, localRectF, this.f);
      return;
    }
    if (this.u != null)
    {
      localRectF = new RectF(this.c.left + this.V + this.r, this.d, this.c.right - this.V - this.r, this.d + this.u.getHeight());
      paramCanvas.drawBitmap(this.u, null, localRectF, this.f);
      return;
    }
    this.f.setStyle(Paint.Style.FILL);
    this.f.setColor(this.q);
    float f1 = this.c.left;
    float f2 = this.V;
    float f3 = this.r;
    float f4 = this.d;
    float f5 = this.c.right;
    float f6 = this.V;
    float f7 = this.r;
    float f8 = this.d;
    paramCanvas.drawRect(f3 + (f1 + f2), f4, f5 - f6 - f7, this.p + f8, this.f);
  }
  
  private void e(Canvas paramCanvas)
  {
    if ((TextUtils.isEmpty(this.D)) || (this.W == null)) {
      return;
    }
    Rect localRect;
    float f1;
    if (this.G)
    {
      if (this.K)
      {
        this.f.setColor(this.J);
        this.f.setStyle(Paint.Style.FILL);
        if (this.I)
        {
          localRect = new Rect();
          this.g.getTextBounds(this.D, 0, this.D.length(), localRect);
          f1 = (paramCanvas.getWidth() - localRect.width()) / 2 - this.aa;
          paramCanvas.drawRoundRect(new RectF(f1, this.c.bottom + this.H - this.aa, localRect.width() + f1 + this.aa * 2, this.c.bottom + this.H + this.W.getHeight() + this.aa), this.aa, this.aa, this.f);
        }
      }
      else
      {
        paramCanvas.save();
        if (!this.I) {
          break label322;
        }
        paramCanvas.translate(0.0F, this.c.bottom + this.H);
      }
      for (;;)
      {
        this.W.draw(paramCanvas);
        paramCanvas.restore();
        return;
        paramCanvas.drawRoundRect(new RectF(this.c.left, this.c.bottom + this.H - this.aa, this.c.right, this.c.bottom + this.H + this.W.getHeight() + this.aa), this.aa, this.aa, this.f);
        break;
        label322:
        paramCanvas.translate(this.c.left + this.aa, this.c.bottom + this.H);
      }
    }
    if (this.K)
    {
      this.f.setColor(this.J);
      this.f.setStyle(Paint.Style.FILL);
      if (this.I)
      {
        localRect = new Rect();
        this.g.getTextBounds(this.D, 0, this.D.length(), localRect);
        f1 = (paramCanvas.getWidth() - localRect.width()) / 2 - this.aa;
        paramCanvas.drawRoundRect(new RectF(f1, this.c.top - this.H - this.W.getHeight() - this.aa, localRect.width() + f1 + this.aa * 2, this.c.top - this.H + this.aa), this.aa, this.aa, this.f);
      }
    }
    else
    {
      paramCanvas.save();
      if (!this.I) {
        break label660;
      }
      paramCanvas.translate(0.0F, this.c.top - this.H - this.W.getHeight());
    }
    for (;;)
    {
      this.W.draw(paramCanvas);
      paramCanvas.restore();
      return;
      paramCanvas.drawRoundRect(new RectF(this.c.left, this.c.top - this.H - this.W.getHeight() - this.aa, this.c.right, this.c.top - this.H + this.aa), this.aa, this.aa, this.f);
      break;
      label660:
      paramCanvas.translate(this.c.left + this.aa, this.c.top - this.H - this.W.getHeight());
    }
  }
  
  public Rect a(int paramInt)
  {
    if (this.ab)
    {
      Rect localRect = new Rect(this.c);
      float f1 = 1.0F * paramInt / getMeasuredHeight();
      localRect.left = ((int)(localRect.left * f1));
      localRect.right = ((int)(localRect.right * f1));
      localRect.top = ((int)(localRect.top * f1));
      localRect.bottom = ((int)(f1 * localRect.bottom));
      return localRect;
    }
    return null;
  }
  
  public int getAnimTime()
  {
    return this.x;
  }
  
  public String getBarCodeTipText()
  {
    return this.C;
  }
  
  public int getBarcodeRectHeight()
  {
    return this.n;
  }
  
  public int getBorderColor()
  {
    return this.w;
  }
  
  public int getBorderSize()
  {
    return this.v;
  }
  
  public int getCornerColor()
  {
    return this.i;
  }
  
  public int getCornerLength()
  {
    return this.j;
  }
  
  public int getCornerSize()
  {
    return this.k;
  }
  
  public Drawable getCustomScanLineDrawable()
  {
    return this.t;
  }
  
  public float getHalfCornerSize()
  {
    return this.V;
  }
  
  public boolean getIsBarcode()
  {
    return this.A;
  }
  
  public int getMaskColor()
  {
    return this.h;
  }
  
  public String getQRCodeTipText()
  {
    return this.B;
  }
  
  public int getRectHeight()
  {
    return this.m;
  }
  
  public int getRectWidth()
  {
    return this.l;
  }
  
  public Bitmap getScanLineBitmap()
  {
    return this.u;
  }
  
  public int getScanLineColor()
  {
    return this.q;
  }
  
  public int getScanLineMargin()
  {
    return this.r;
  }
  
  public int getScanLineSize()
  {
    return this.p;
  }
  
  public int getTipBackgroundColor()
  {
    return this.J;
  }
  
  public int getTipBackgroundRadius()
  {
    return this.aa;
  }
  
  public String getTipText()
  {
    return this.D;
  }
  
  public int getTipTextColor()
  {
    return this.F;
  }
  
  public int getTipTextMargin()
  {
    return this.H;
  }
  
  public int getTipTextSize()
  {
    return this.E;
  }
  
  public StaticLayout getTipTextSl()
  {
    return this.W;
  }
  
  public int getToolbarHeight()
  {
    return this.z;
  }
  
  public int getTopOffset()
  {
    return this.o;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    if (this.c == null) {
      return;
    }
    a(paramCanvas);
    b(paramCanvas);
    c(paramCanvas);
    d(paramCanvas);
    e(paramCanvas);
    b();
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    c();
  }
  
  public void setAnimTime(int paramInt)
  {
    this.x = paramInt;
  }
  
  public void setBarCodeTipText(String paramString)
  {
    this.C = paramString;
  }
  
  public void setBarcodeRectHeight(int paramInt)
  {
    this.n = paramInt;
  }
  
  public void setBorderColor(int paramInt)
  {
    this.w = paramInt;
  }
  
  public void setBorderSize(int paramInt)
  {
    this.v = paramInt;
  }
  
  public void setCenterVertical(boolean paramBoolean)
  {
    this.y = paramBoolean;
  }
  
  public void setCornerColor(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void setCornerLength(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void setCornerSize(int paramInt)
  {
    this.k = paramInt;
  }
  
  public void setCustomScanLineDrawable(Drawable paramDrawable)
  {
    this.t = paramDrawable;
  }
  
  public void setHalfCornerSize(float paramFloat)
  {
    this.V = paramFloat;
  }
  
  public void setIsBarcode(boolean paramBoolean)
  {
    this.A = paramBoolean;
    label81:
    label133:
    int i1;
    if ((this.N != null) || (this.M)) {
      if (this.A)
      {
        this.O = this.U;
        if (!this.A) {
          break label233;
        }
        this.D = this.C;
        this.m = this.n;
        this.b = ((int)(this.x * 1.0F * this.a / this.l));
        if (!TextUtils.isEmpty(this.D))
        {
          if (!this.I) {
            break label276;
          }
          this.W = new StaticLayout(this.D, this.g, ge.a(getContext()).x, Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, true);
        }
        if (this.y)
        {
          i1 = ge.a(getContext()).y;
          if (this.z != 0) {
            break label315;
          }
        }
      }
    }
    label233:
    label276:
    label315:
    for (this.o = ((i1 - this.m) / 2);; this.o = ((i1 - this.m) / 2 + this.z / 2))
    {
      c();
      postInvalidate();
      return;
      this.O = this.T;
      break;
      if ((this.t == null) && (!this.s)) {
        break;
      }
      if (this.A)
      {
        this.u = this.S;
        break;
      }
      this.u = this.R;
      break;
      this.D = this.B;
      this.m = this.l;
      this.b = ((int)(this.x * 1.0F * this.a / this.m));
      break label81;
      this.W = new StaticLayout(this.D, this.g, this.l - this.aa * 2, Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, true);
      break label133;
    }
  }
  
  public void setMaskColor(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void setOnlyDecodeScanBoxArea(boolean paramBoolean)
  {
    this.ab = paramBoolean;
  }
  
  public void setQRCodeTipText(String paramString)
  {
    this.B = paramString;
  }
  
  public void setRectHeight(int paramInt)
  {
    this.m = paramInt;
  }
  
  public void setRectWidth(int paramInt)
  {
    this.l = paramInt;
  }
  
  public void setScanLineBitmap(Bitmap paramBitmap)
  {
    this.u = paramBitmap;
  }
  
  public void setScanLineColor(int paramInt)
  {
    this.q = paramInt;
  }
  
  public void setScanLineMargin(int paramInt)
  {
    this.r = paramInt;
  }
  
  public void setScanLineReverse(boolean paramBoolean)
  {
    this.L = paramBoolean;
  }
  
  public void setScanLineSize(int paramInt)
  {
    this.p = paramInt;
  }
  
  public void setShowDefaultGridScanLineDrawable(boolean paramBoolean)
  {
    this.M = paramBoolean;
  }
  
  public void setShowDefaultScanLineDrawable(boolean paramBoolean)
  {
    this.s = paramBoolean;
  }
  
  public void setShowTipBackground(boolean paramBoolean)
  {
    this.K = paramBoolean;
  }
  
  public void setShowTipTextAsSingleLine(boolean paramBoolean)
  {
    this.I = paramBoolean;
  }
  
  public void setTipBackgroundColor(int paramInt)
  {
    this.J = paramInt;
  }
  
  public void setTipBackgroundRadius(int paramInt)
  {
    this.aa = paramInt;
  }
  
  public void setTipText(String paramString)
  {
    this.D = paramString;
  }
  
  public void setTipTextBelowRect(boolean paramBoolean)
  {
    this.G = paramBoolean;
  }
  
  public void setTipTextColor(int paramInt)
  {
    this.F = paramInt;
  }
  
  public void setTipTextMargin(int paramInt)
  {
    this.H = paramInt;
  }
  
  public void setTipTextSize(int paramInt)
  {
    this.E = paramInt;
  }
  
  public void setTipTextSl(StaticLayout paramStaticLayout)
  {
    this.W = paramStaticLayout;
  }
  
  public void setToolbarHeight(int paramInt)
  {
    this.z = paramInt;
  }
  
  public void setTopOffset(int paramInt)
  {
    this.o = paramInt;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/gr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */