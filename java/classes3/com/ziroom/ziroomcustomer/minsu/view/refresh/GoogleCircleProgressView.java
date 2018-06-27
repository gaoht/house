package com.ziroom.ziroomcustomer.minsu.view.refresh;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RadialGradient;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.lsjwzh.widget.materialloadingprogressbar.a;
import com.ziroom.ziroomcustomer.R.styleable;

@SuppressLint({"AppCompatCustomView"})
public class GoogleCircleProgressView
  extends ImageView
{
  private Animation.AnimationListener a;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private Paint l;
  private int m;
  private int n;
  private boolean o;
  private boolean p;
  private a q;
  private ShapeDrawable r;
  private boolean s;
  private int[] t = { -16777216 };
  
  public GoogleCircleProgressView(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null, 0);
  }
  
  public GoogleCircleProgressView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet, 0);
  }
  
  public GoogleCircleProgressView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.GoogleCircleProgressView, paramInt, 0);
    float f1 = getContext().getResources().getDisplayMetrics().density;
    this.c = paramContext.getColor(1, -328966);
    this.d = paramContext.getColor(2, -328966);
    this.t = new int[] { this.d };
    this.k = paramContext.getDimensionPixelOffset(0, -1);
    this.e = paramContext.getDimensionPixelOffset(3, (int)(3.0F * f1));
    this.f = paramContext.getDimensionPixelOffset(6, -1);
    this.g = paramContext.getDimensionPixelOffset(7, -1);
    this.n = paramContext.getDimensionPixelOffset(10, (int)(f1 * 9.0F));
    this.m = paramContext.getColor(11, -16777216);
    this.p = paramContext.getBoolean(4, true);
    this.s = paramContext.getBoolean(5, true);
    this.h = paramContext.getInt(8, 0);
    this.i = paramContext.getInt(9, 100);
    if (paramContext.getInt(12, 1) != 1) {
      this.o = true;
    }
    this.l = new Paint();
    this.l.setStyle(Paint.Style.FILL);
    this.l.setColor(this.m);
    this.l.setTextSize(this.n);
    this.l.setAntiAlias(true);
    paramContext.recycle();
    this.q = new a(getContext(), this);
    super.setImageDrawable(this.q);
  }
  
  private boolean a()
  {
    return Build.VERSION.SDK_INT >= 21;
  }
  
  public boolean circleBackgroundEnabled()
  {
    return this.s;
  }
  
  public int getMax()
  {
    return this.i;
  }
  
  public int getProgress()
  {
    return this.h;
  }
  
  public int getVisibility()
  {
    return super.getVisibility();
  }
  
  public boolean isRunning()
  {
    return this.q.isRunning();
  }
  
  public boolean isShowArrow()
  {
    return this.p;
  }
  
  public boolean isShowProgressText()
  {
    return this.o;
  }
  
  public void onAnimationEnd()
  {
    super.onAnimationEnd();
    if (this.a != null) {
      this.a.onAnimationEnd(getAnimation());
    }
  }
  
  public void onAnimationStart()
  {
    super.onAnimationStart();
    if (this.a != null) {
      this.a.onAnimationStart(getAnimation());
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    a locala;
    if (this.q != null)
    {
      this.q.stop();
      locala = this.q;
      if (getVisibility() != 0) {
        break label44;
      }
    }
    label44:
    for (boolean bool = true;; bool = false)
    {
      locala.setVisible(bool, false);
      requestLayout();
      return;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.q != null)
    {
      this.q.stop();
      this.q.setVisible(false, false);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.o)
    {
      String str = String.format("%s%%", new Object[] { Integer.valueOf(this.h) });
      int i1 = getWidth() / 2;
      int i2 = str.length() * this.n / 4;
      int i3 = getHeight() / 2;
      int i4 = this.n / 4;
      paramCanvas.drawText(str, i1 - i2, i3 + i4, this.l);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    float f1 = getContext().getResources().getDisplayMetrics().density;
    this.j = Math.min(getMeasuredWidth(), getMeasuredHeight());
    if (this.j <= 0) {
      this.j = ((int)f1 * 56);
    }
    a locala;
    double d2;
    double d3;
    double d1;
    label219:
    double d4;
    if ((getBackground() == null) && (this.s))
    {
      paramInt1 = (int)(1.75F * f1);
      paramInt2 = (int)(0.0F * f1);
      this.b = ((int)(3.5F * f1));
      if (a())
      {
        this.r = new ShapeDrawable(new OvalShape());
        ViewCompat.setElevation(this, f1 * 4.0F);
        this.r.getPaint().setColor(this.c);
        setBackgroundDrawable(this.r);
      }
    }
    else
    {
      this.q.setBackgroundColor(this.c);
      this.q.setColorSchemeColors(this.t);
      locala = this.q;
      d2 = this.j;
      d3 = this.j;
      if (this.k > 0) {
        break label425;
      }
      d1 = (this.j - this.e * 2) / 4;
      d4 = this.e;
      if (this.f >= 0) {
        break label435;
      }
      f1 = this.e * 4;
      label242:
      if (this.g >= 0) {
        break label445;
      }
    }
    label425:
    label435:
    label445:
    for (float f2 = this.e * 2;; f2 = this.g)
    {
      locala.setSizeParameters(d2, d3, d1, d4, f1, f2);
      if (isShowArrow())
      {
        this.q.showArrowOnFirstStart(true);
        this.q.setArrowScale(1.0F);
        this.q.showArrow(true);
      }
      super.setImageDrawable(null);
      super.setImageDrawable(this.q);
      this.q.setAlpha(255);
      this.q.setStartEndTrim(0.0F, 0.75F);
      return;
      this.r = new ShapeDrawable(new a(this.b, this.j - this.b * 2));
      ViewCompat.setLayerType(this, 1, this.r.getPaint());
      this.r.getPaint().setShadowLayer(this.b, paramInt2, paramInt1, 503316480);
      paramInt1 = this.b;
      setPadding(paramInt1, paramInt1, paramInt1, paramInt1);
      break;
      d1 = this.k;
      break label219;
      f1 = this.f;
      break label242;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (!a()) {
      setMeasuredDimension(getMeasuredWidth() + this.b * 2, getMeasuredHeight() + this.b * 2);
    }
  }
  
  public void setAnimationListener(Animation.AnimationListener paramAnimationListener)
  {
    this.a = paramAnimationListener;
  }
  
  @SuppressLint({"ResourceType"})
  public void setBackgroundColor(int paramInt)
  {
    if ((getBackground() instanceof ShapeDrawable))
    {
      Resources localResources = getResources();
      ((ShapeDrawable)getBackground()).getPaint().setColor(localResources.getColor(paramInt));
    }
  }
  
  public void setCircleBackgroundEnabled(boolean paramBoolean)
  {
    this.s = paramBoolean;
  }
  
  public void setColorSchemeColors(int... paramVarArgs)
  {
    this.t = paramVarArgs;
    if (this.q != null) {
      this.q.setColorSchemeColors(paramVarArgs);
    }
  }
  
  public void setColorSchemeResources(int... paramVarArgs)
  {
    Resources localResources = getResources();
    int[] arrayOfInt = new int[paramVarArgs.length];
    int i1 = 0;
    while (i1 < paramVarArgs.length)
    {
      arrayOfInt[i1] = localResources.getColor(paramVarArgs[i1]);
      i1 += 1;
    }
    setColorSchemeColors(arrayOfInt);
  }
  
  public final void setImageDrawable(Drawable paramDrawable) {}
  
  public final void setImageResource(int paramInt) {}
  
  public final void setImageURI(Uri paramUri)
  {
    super.setImageURI(paramUri);
  }
  
  public void setMax(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void setProgress(int paramInt)
  {
    if (getMax() > paramInt) {
      this.h = paramInt;
    }
  }
  
  public void setProgressRotation(float paramFloat)
  {
    if (this.q.isRunning()) {
      stop();
    }
    this.q.showArrow(true);
    this.q.showArrowOnFirstStart(true);
    this.q.setProgressRotation(paramFloat);
  }
  
  public void setShowArrow(boolean paramBoolean)
  {
    this.p = paramBoolean;
  }
  
  public void setShowProgressText(boolean paramBoolean)
  {
    this.o = paramBoolean;
  }
  
  public void setStartEndTrim(float paramFloat1, float paramFloat2)
  {
    this.q.setStartEndTrim(paramFloat1, paramFloat2);
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    boolean bool;
    if (this.q != null)
    {
      a locala = this.q;
      if (paramInt != 0) {
        break label42;
      }
      bool = true;
      locala.setVisible(bool, false);
      if (paramInt == 0) {
        break label47;
      }
      this.q.stop();
    }
    label42:
    label47:
    while (!this.q.isRunning())
    {
      return;
      bool = false;
      break;
    }
    this.q.stop();
  }
  
  public void start()
  {
    if (!this.q.isRunning()) {
      this.q.start();
    }
  }
  
  public void stop()
  {
    if (this.q.isRunning()) {
      this.q.stop();
    }
  }
  
  private class a
    extends OvalShape
  {
    private RadialGradient b;
    private int c;
    private Paint d = new Paint();
    private int e;
    
    public a(int paramInt1, int paramInt2)
    {
      this.c = paramInt1;
      this.e = paramInt2;
      float f1 = this.e / 2;
      float f2 = this.e / 2;
      float f3 = this.c;
      this$1 = Shader.TileMode.CLAMP;
      this.b = new RadialGradient(f1, f2, f3, new int[] { 1023410176, 0 }, null, GoogleCircleProgressView.this);
      this.d.setShader(this.b);
    }
    
    public void draw(Canvas paramCanvas, Paint paramPaint)
    {
      int i = GoogleCircleProgressView.this.getWidth();
      int j = GoogleCircleProgressView.this.getHeight();
      paramCanvas.drawCircle(i / 2, j / 2, this.e / 2 + this.c, this.d);
      paramCanvas.drawCircle(i / 2, j / 2, this.e / 2, paramPaint);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/view/refresh/GoogleCircleProgressView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */