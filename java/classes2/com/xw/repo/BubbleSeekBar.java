package com.xw.repo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Cap;
import android.graphics.Paint.FontMetrics;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.Property;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.LinearInterpolator;
import com.xw.repo.bubbleseekbar.R.color;
import com.xw.repo.bubbleseekbar.R.styleable;
import java.math.BigDecimal;

public class BubbleSeekBar
  extends View
{
  private long A;
  private boolean B;
  private int C;
  private int D;
  private int E;
  private float F;
  private float G;
  private float H;
  private float I;
  private float J;
  private boolean K;
  private int L;
  private boolean M;
  private boolean N;
  private a O;
  private float P;
  private float Q;
  private Paint R;
  private Rect S;
  private WindowManager T;
  private BubbleView U;
  private int V;
  private float W;
  float a;
  private float aa;
  private float ab;
  private WindowManager.LayoutParams ac;
  private int[] ad = new int[2];
  private boolean ae = true;
  private float af;
  private a ag;
  private float b;
  private float c;
  private float d;
  private boolean e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  private boolean n;
  private boolean o;
  private boolean p;
  private int q;
  private int r;
  private int s = -1;
  private int t;
  private boolean u;
  private int v;
  private int w;
  private boolean x;
  private boolean y;
  private boolean z;
  
  public BubbleSeekBar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BubbleSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BubbleSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.BubbleSeekBar, paramInt, 0);
    this.b = paramAttributeSet.getFloat(R.styleable.BubbleSeekBar_bsb_min, 0.0F);
    this.c = paramAttributeSet.getFloat(R.styleable.BubbleSeekBar_bsb_max, 100.0F);
    this.d = paramAttributeSet.getFloat(R.styleable.BubbleSeekBar_bsb_progress, this.b);
    this.e = paramAttributeSet.getBoolean(R.styleable.BubbleSeekBar_bsb_is_float_type, false);
    this.f = paramAttributeSet.getDimensionPixelSize(R.styleable.BubbleSeekBar_bsb_track_size, b.a(2));
    this.g = paramAttributeSet.getDimensionPixelSize(R.styleable.BubbleSeekBar_bsb_second_track_size, this.f + b.a(2));
    this.h = paramAttributeSet.getDimensionPixelSize(R.styleable.BubbleSeekBar_bsb_thumb_radius, this.g + b.a(2));
    this.i = paramAttributeSet.getDimensionPixelSize(R.styleable.BubbleSeekBar_bsb_thumb_radius, this.g * 2);
    this.m = paramAttributeSet.getInteger(R.styleable.BubbleSeekBar_bsb_section_count, 10);
    this.j = paramAttributeSet.getColor(R.styleable.BubbleSeekBar_bsb_track_color, ContextCompat.getColor(paramContext, R.color.colorPrimary));
    this.k = paramAttributeSet.getColor(R.styleable.BubbleSeekBar_bsb_second_track_color, ContextCompat.getColor(paramContext, R.color.colorAccent));
    this.l = paramAttributeSet.getColor(R.styleable.BubbleSeekBar_bsb_thumb_color, this.k);
    this.p = paramAttributeSet.getBoolean(R.styleable.BubbleSeekBar_bsb_show_section_text, false);
    this.q = paramAttributeSet.getDimensionPixelSize(R.styleable.BubbleSeekBar_bsb_section_text_size, b.b(14));
    this.r = paramAttributeSet.getColor(R.styleable.BubbleSeekBar_bsb_section_text_color, this.j);
    this.z = paramAttributeSet.getBoolean(R.styleable.BubbleSeekBar_bsb_seek_by_section, false);
    paramInt = paramAttributeSet.getInteger(R.styleable.BubbleSeekBar_bsb_section_text_position, -1);
    long l1;
    if (paramInt == 0)
    {
      this.s = 0;
      this.t = paramAttributeSet.getInteger(R.styleable.BubbleSeekBar_bsb_section_text_interval, 1);
      this.u = paramAttributeSet.getBoolean(R.styleable.BubbleSeekBar_bsb_show_thumb_text, false);
      this.v = paramAttributeSet.getDimensionPixelSize(R.styleable.BubbleSeekBar_bsb_thumb_text_size, b.b(14));
      this.w = paramAttributeSet.getColor(R.styleable.BubbleSeekBar_bsb_thumb_text_color, this.k);
      this.C = paramAttributeSet.getColor(R.styleable.BubbleSeekBar_bsb_bubble_color, this.k);
      this.D = paramAttributeSet.getDimensionPixelSize(R.styleable.BubbleSeekBar_bsb_bubble_text_size, b.b(14));
      this.E = paramAttributeSet.getColor(R.styleable.BubbleSeekBar_bsb_bubble_text_color, -1);
      this.n = paramAttributeSet.getBoolean(R.styleable.BubbleSeekBar_bsb_show_section_mark, false);
      this.o = paramAttributeSet.getBoolean(R.styleable.BubbleSeekBar_bsb_auto_adjust_section_mark, false);
      this.x = paramAttributeSet.getBoolean(R.styleable.BubbleSeekBar_bsb_show_progress_in_float, false);
      paramInt = paramAttributeSet.getInteger(R.styleable.BubbleSeekBar_bsb_anim_duration, -1);
      if (paramInt >= 0) {
        break label635;
      }
      l1 = 200L;
      label448:
      this.A = l1;
      this.y = paramAttributeSet.getBoolean(R.styleable.BubbleSeekBar_bsb_touch_to_seek, false);
      this.B = paramAttributeSet.getBoolean(R.styleable.BubbleSeekBar_bsb_always_show_bubble, false);
      paramAttributeSet.recycle();
      this.R = new Paint();
      this.R.setAntiAlias(true);
      this.R.setStrokeCap(Paint.Cap.ROUND);
      this.R.setTextAlign(Paint.Align.CENTER);
      this.S = new Rect();
      this.L = b.a(2);
      this.T = ((WindowManager)paramContext.getSystemService("window"));
      this.U = new BubbleView(paramContext);
      paramAttributeSet = this.U;
      if (!this.x) {
        break label642;
      }
    }
    label635:
    label642:
    for (paramContext = String.valueOf(getProgressFloat());; paramContext = String.valueOf(getProgress()))
    {
      paramAttributeSet.a(paramContext);
      a();
      b();
      return;
      if (paramInt == 1)
      {
        this.s = 1;
        break;
      }
      if (paramInt == 2)
      {
        this.s = 2;
        break;
      }
      this.s = -1;
      break;
      l1 = paramInt;
      break label448;
    }
  }
  
  private String a(float paramFloat)
  {
    return String.valueOf(b(paramFloat));
  }
  
  private void a()
  {
    if (this.b == this.c)
    {
      this.b = 0.0F;
      this.c = 100.0F;
    }
    if (this.b > this.c)
    {
      float f1 = this.c;
      this.c = this.b;
      this.b = f1;
    }
    if (this.d < this.b) {
      this.d = this.b;
    }
    if (this.d > this.c) {
      this.d = this.c;
    }
    if (this.g < this.f) {
      this.g = (this.f + b.a(2));
    }
    if (this.h <= this.g) {
      this.h = (this.g + b.a(2));
    }
    if (this.i <= this.g) {
      this.i = (this.g * 2);
    }
    if (this.m <= 0) {
      this.m = 10;
    }
    this.F = (this.c - this.b);
    this.G = (this.F / this.m);
    if (this.G < 1.0F) {
      this.e = true;
    }
    if (this.e) {
      this.x = true;
    }
    if (this.s != -1) {
      this.p = true;
    }
    if (this.p)
    {
      if (this.s == -1) {
        this.s = 0;
      }
      if (this.s == 2) {
        this.n = true;
      }
    }
    if (this.t < 1) {
      this.t = 1;
    }
    if ((this.o) && (!this.n)) {
      this.o = false;
    }
    if (this.z)
    {
      this.af = this.b;
      if (this.d != this.b) {
        this.af = this.G;
      }
      this.n = true;
      this.o = true;
      this.y = false;
    }
    if (this.B) {
      setProgress(this.d);
    }
    if ((this.e) || (this.z) || ((this.p) && (this.s == 2))) {}
    for (int i1 = this.q;; i1 = this.v)
    {
      this.v = i1;
      return;
    }
  }
  
  private boolean a(MotionEvent paramMotionEvent)
  {
    if (!isEnabled()) {}
    float f1;
    float f2;
    float f3;
    float f4;
    float f5;
    do
    {
      return false;
      f1 = this.I / this.F * (this.d - this.b) + this.P;
      f2 = getMeasuredHeight() / 2.0F;
      f3 = paramMotionEvent.getX();
      f4 = paramMotionEvent.getX();
      f5 = paramMotionEvent.getY();
    } while ((f4 - f1) * (f3 - f1) + (paramMotionEvent.getY() - f2) * (f5 - f2) > (this.P + b.a(8)) * (this.P + b.a(8)));
    return true;
  }
  
  private float b(float paramFloat)
  {
    return BigDecimal.valueOf(paramFloat).setScale(1, 4).floatValue();
  }
  
  private void b()
  {
    this.R.setTextSize(this.D);
    int i1;
    int i2;
    if (this.x)
    {
      str = a(this.b);
      this.R.getTextBounds(str, 0, str.length(), this.S);
      i1 = this.S.width();
      i2 = this.L;
      if (!this.x) {
        break label164;
      }
    }
    label164:
    for (String str = a(this.c);; str = getMaxText())
    {
      this.R.getTextBounds(str, 0, str.length(), this.S);
      int i3 = this.S.width();
      int i4 = this.L;
      this.V = b.a(14);
      this.V = (Math.max(this.V, Math.max(i1 + i2 * 2 >> 1, i3 + i4 * 2 >> 1)) + this.L);
      return;
      str = getMinText();
      break;
    }
  }
  
  private boolean b(MotionEvent paramMotionEvent)
  {
    if (!isEnabled()) {}
    while ((paramMotionEvent.getX() < getPaddingLeft()) || (paramMotionEvent.getX() > getMeasuredWidth() - getPaddingRight()) || (paramMotionEvent.getY() < getPaddingTop()) || (paramMotionEvent.getY() > getPaddingTop() + this.i * 2)) {
      return false;
    }
    return true;
  }
  
  private void c()
  {
    getLocationOnScreen(this.ad);
    this.W = (this.ad[0] + this.P - this.U.getMeasuredWidth() / 2.0F);
    this.ab = (this.W + this.I * (this.d - this.b) / this.F);
    this.aa = (this.ad[1] - this.U.getMeasuredHeight());
    this.aa -= b.a(24);
    if (b.a()) {
      this.aa += b.a(4);
    }
  }
  
  private void d()
  {
    if (this.U.getParent() != null) {
      return;
    }
    BubbleView localBubbleView;
    if (this.ac == null)
    {
      this.ac = new WindowManager.LayoutParams();
      this.ac.gravity = 8388659;
      this.ac.width = -2;
      this.ac.height = -2;
      this.ac.format = -3;
      this.ac.flags = 524328;
      if ((b.a()) || (Build.VERSION.SDK_INT >= 25)) {
        this.ac.type = 2;
      }
    }
    else
    {
      this.ac.x = ((int)(this.ab + 0.5F));
      this.ac.y = ((int)(this.aa + 0.5F));
      this.U.setAlpha(0.0F);
      this.U.setVisibility(0);
      this.U.animate().alpha(1.0F).setDuration(this.A).setListener(new AnimatorListenerAdapter()
      {
        public void onAnimationStart(Animator paramAnonymousAnimator)
        {
          BubbleSeekBar.h(BubbleSeekBar.this).addView(BubbleSeekBar.f(BubbleSeekBar.this), BubbleSeekBar.g(BubbleSeekBar.this));
        }
      }).start();
      localBubbleView = this.U;
      if (!this.x) {
        break label217;
      }
    }
    label217:
    for (String str = String.valueOf(getProgressFloat());; str = String.valueOf(getProgress()))
    {
      localBubbleView.a(str);
      return;
      this.ac.type = 2005;
      break;
    }
  }
  
  private void e()
  {
    float f2 = 0.0F;
    float f1 = 0.0F;
    int i1 = 0;
    int i2;
    label74:
    AnimatorSet localAnimatorSet;
    ValueAnimator localValueAnimator;
    if (i1 <= this.m)
    {
      f1 = i1 * this.J + this.P;
      if ((f1 > this.H) || (this.H - f1 > this.J)) {}
    }
    else
    {
      if (BigDecimal.valueOf(this.H).setScale(1, 4).floatValue() != f1) {
        break label232;
      }
      i2 = 1;
      localAnimatorSet = new AnimatorSet();
      if (i2 != 0) {
        break label302;
      }
      if (this.H - f1 > this.J / 2.0F) {
        break label238;
      }
      localValueAnimator = ValueAnimator.ofFloat(new float[] { this.H, f1 });
      label123:
      localValueAnimator.setInterpolator(new LinearInterpolator());
      localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          BubbleSeekBar.a(BubbleSeekBar.this, ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
          BubbleSeekBar.b(BubbleSeekBar.this, (BubbleSeekBar.i(BubbleSeekBar.this) - BubbleSeekBar.j(BubbleSeekBar.this)) * BubbleSeekBar.k(BubbleSeekBar.this) / BubbleSeekBar.l(BubbleSeekBar.this) + BubbleSeekBar.m(BubbleSeekBar.this));
          BubbleSeekBar.c(BubbleSeekBar.this, BubbleSeekBar.n(BubbleSeekBar.this) + BubbleSeekBar.i(BubbleSeekBar.this) - BubbleSeekBar.j(BubbleSeekBar.this));
          BubbleSeekBar.g(BubbleSeekBar.this).x = ((int)(BubbleSeekBar.o(BubbleSeekBar.this) + 0.5F));
          if (BubbleSeekBar.f(BubbleSeekBar.this).getParent() != null) {
            BubbleSeekBar.h(BubbleSeekBar.this).updateViewLayout(BubbleSeekBar.f(BubbleSeekBar.this), BubbleSeekBar.g(BubbleSeekBar.this));
          }
          BubbleSeekBar.BubbleView localBubbleView = BubbleSeekBar.f(BubbleSeekBar.this);
          if (BubbleSeekBar.p(BubbleSeekBar.this)) {}
          for (paramAnonymousValueAnimator = String.valueOf(BubbleSeekBar.this.getProgressFloat());; paramAnonymousValueAnimator = String.valueOf(BubbleSeekBar.this.getProgress()))
          {
            localBubbleView.a(paramAnonymousValueAnimator);
            BubbleSeekBar.this.invalidate();
            if (BubbleSeekBar.d(BubbleSeekBar.this) != null) {
              BubbleSeekBar.d(BubbleSeekBar.this).onProgressChanged(BubbleSeekBar.this.getProgress(), BubbleSeekBar.this.getProgressFloat());
            }
            return;
          }
        }
      });
    }
    for (;;)
    {
      Object localObject = this.U;
      Property localProperty = View.ALPHA;
      f1 = f2;
      if (this.B) {
        f1 = 1.0F;
      }
      localObject = ObjectAnimator.ofFloat(localObject, localProperty, new float[] { f1 });
      if (i2 != 0) {
        localAnimatorSet.setDuration(this.A).play((Animator)localObject);
      }
      for (;;)
      {
        localAnimatorSet.addListener(new AnimatorListenerAdapter()
        {
          public void onAnimationCancel(Animator paramAnonymousAnimator)
          {
            if (!BubbleSeekBar.b(BubbleSeekBar.this)) {
              BubbleSeekBar.c(BubbleSeekBar.this);
            }
            BubbleSeekBar.b(BubbleSeekBar.this, (BubbleSeekBar.i(BubbleSeekBar.this) - BubbleSeekBar.j(BubbleSeekBar.this)) * BubbleSeekBar.k(BubbleSeekBar.this) / BubbleSeekBar.l(BubbleSeekBar.this) + BubbleSeekBar.m(BubbleSeekBar.this));
            BubbleSeekBar.b(BubbleSeekBar.this, false);
            BubbleSeekBar.a(BubbleSeekBar.this, true);
            BubbleSeekBar.this.invalidate();
          }
          
          public void onAnimationEnd(Animator paramAnonymousAnimator)
          {
            if (!BubbleSeekBar.b(BubbleSeekBar.this)) {
              BubbleSeekBar.c(BubbleSeekBar.this);
            }
            BubbleSeekBar.b(BubbleSeekBar.this, (BubbleSeekBar.i(BubbleSeekBar.this) - BubbleSeekBar.j(BubbleSeekBar.this)) * BubbleSeekBar.k(BubbleSeekBar.this) / BubbleSeekBar.l(BubbleSeekBar.this) + BubbleSeekBar.m(BubbleSeekBar.this));
            BubbleSeekBar.b(BubbleSeekBar.this, false);
            BubbleSeekBar.a(BubbleSeekBar.this, true);
            BubbleSeekBar.this.invalidate();
            if (BubbleSeekBar.d(BubbleSeekBar.this) != null) {
              BubbleSeekBar.d(BubbleSeekBar.this).getProgressOnFinally(BubbleSeekBar.this.getProgress(), BubbleSeekBar.this.getProgressFloat());
            }
          }
        });
        localAnimatorSet.start();
        return;
        i1 += 1;
        break;
        label232:
        i2 = 0;
        break label74;
        label238:
        localValueAnimator = ValueAnimator.ofFloat(new float[] { this.H, (i1 + 1) * this.J + this.P });
        break label123;
        localAnimatorSet.setDuration(this.A).playTogether(new Animator[] { localValueAnimator, localObject });
      }
      label302:
      localValueAnimator = null;
    }
  }
  
  private void f()
  {
    this.U.setVisibility(8);
    if (this.U.getParent() != null) {
      this.T.removeViewImmediate(this.U);
    }
  }
  
  private String getMaxText()
  {
    if (this.e) {
      return a(this.c);
    }
    return String.valueOf((int)this.c);
  }
  
  private String getMinText()
  {
    if (this.e) {
      return a(this.b);
    }
    return String.valueOf((int)this.b);
  }
  
  void a(a parama)
  {
    this.b = parama.a;
    this.c = parama.b;
    this.d = parama.c;
    this.e = parama.d;
    this.f = parama.e;
    this.g = parama.f;
    this.h = parama.g;
    this.i = parama.h;
    this.j = parama.i;
    this.k = parama.j;
    this.l = parama.k;
    this.m = parama.l;
    this.n = parama.m;
    this.o = parama.n;
    this.p = parama.o;
    this.q = parama.p;
    this.r = parama.q;
    this.s = parama.r;
    this.t = parama.s;
    this.u = parama.t;
    this.v = parama.u;
    this.w = parama.v;
    this.x = parama.w;
    this.y = parama.x;
    this.z = parama.y;
    this.C = parama.z;
    this.D = parama.A;
    this.E = parama.B;
    this.B = parama.C;
    a();
    b();
    if (this.O != null)
    {
      this.O.onProgressChanged(getProgress(), getProgressFloat());
      this.O.getProgressOnFinally(getProgress(), getProgressFloat());
    }
    this.ag = null;
    requestLayout();
  }
  
  public void correctOffsetWhenContainerOnScrolling()
  {
    c();
    if (this.U.getParent() != null) {
      postInvalidate();
    }
  }
  
  public a getConfigBuilder()
  {
    if (this.ag == null) {
      this.ag = new a(this);
    }
    this.ag.a = this.b;
    this.ag.b = this.c;
    this.ag.c = this.d;
    this.ag.d = this.e;
    this.ag.e = this.f;
    this.ag.f = this.g;
    this.ag.g = this.h;
    this.ag.h = this.i;
    this.ag.i = this.j;
    this.ag.j = this.k;
    this.ag.k = this.l;
    this.ag.l = this.m;
    this.ag.m = this.n;
    this.ag.n = this.o;
    this.ag.o = this.p;
    this.ag.p = this.q;
    this.ag.q = this.r;
    this.ag.r = this.s;
    this.ag.s = this.t;
    this.ag.t = this.u;
    this.ag.u = this.v;
    this.ag.v = this.w;
    this.ag.w = this.x;
    this.ag.x = this.y;
    this.ag.y = this.z;
    this.ag.z = this.C;
    this.ag.A = this.D;
    this.ag.B = this.E;
    this.ag.C = this.B;
    return this.ag;
  }
  
  public float getMax()
  {
    return this.c;
  }
  
  public float getMin()
  {
    return this.b;
  }
  
  public a getOnProgressChangedListener()
  {
    return this.O;
  }
  
  public int getProgress()
  {
    if ((this.z) && (this.N))
    {
      float f1 = this.G / 2.0F;
      if (this.d >= this.af)
      {
        if (this.d >= f1 + this.af)
        {
          this.af += this.G;
          return Math.round(this.af);
        }
        return Math.round(this.af);
      }
      if (this.d >= this.af - f1) {
        return Math.round(this.af);
      }
      this.af -= this.G;
      return Math.round(this.af);
    }
    return Math.round(this.d);
  }
  
  public float getProgressFloat()
  {
    return b(this.d);
  }
  
  protected void onDetachedFromWindow()
  {
    f();
    super.onDetachedFromWindow();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    float f4 = getPaddingLeft();
    float f3 = getMeasuredWidth() - getPaddingRight();
    float f5 = getPaddingTop() + this.i;
    float f1;
    Object localObject;
    float f2;
    if (this.p)
    {
      this.R.setTextSize(this.q);
      this.R.setColor(this.r);
      if (this.s == 0)
      {
        f1 = this.S.height() / 2.0F + f5;
        localObject = getMinText();
        this.R.getTextBounds((String)localObject, 0, ((String)localObject).length(), this.S);
        paramCanvas.drawText((String)localObject, this.S.width() / 2.0F + f4, f1, this.R);
        f2 = f4 + (this.S.width() + this.L);
        localObject = getMaxText();
        this.R.getTextBounds((String)localObject, 0, ((String)localObject).length(), this.S);
        paramCanvas.drawText((String)localObject, f3 - this.S.width() / 2.0F, f1, this.R);
        f1 = f3 - (this.S.width() + this.L);
        if (((this.p) || (this.u)) && (this.s != 0)) {
          break label1241;
        }
        f2 += this.i;
        f1 -= this.i;
      }
    }
    label274:
    label286:
    label404:
    label451:
    label774:
    label780:
    label789:
    label816:
    label890:
    label1232:
    label1241:
    for (;;)
    {
      int i1;
      int i2;
      float f6;
      float f8;
      int i3;
      float f9;
      int i4;
      if ((this.p) && (this.s == 2))
      {
        i1 = 1;
        if (this.m % 2 != 0) {
          break label774;
        }
        i2 = 1;
        if ((i1 == 0) && (!this.n)) {
          break label890;
        }
        f3 = (this.i - b.a(2)) / 2.0F;
        f4 = this.I / this.F;
        f6 = Math.abs(this.d - this.b);
        float f7 = this.P;
        this.R.setTextSize(this.q);
        this.R.getTextBounds("0123456789", 0, "0123456789".length(), this.S);
        f8 = this.S.height() + f5 + this.i + this.L;
        i3 = 0;
        if (i3 > this.m) {
          break label890;
        }
        f9 = f2 + i3 * this.J;
        localObject = this.R;
        if (f9 > f4 * f6 + f7) {
          break label780;
        }
        i4 = this.k;
        ((Paint)localObject).setColor(i4);
        paramCanvas.drawCircle(f9, f5, f3, this.R);
        if (i1 != 0)
        {
          this.R.setColor(this.r);
          if (this.t <= 1) {
            break label816;
          }
          if ((i2 != 0) && (i3 % this.t == 0))
          {
            f10 = this.b + this.G * i3;
            if (!this.e) {
              break label789;
            }
          }
        }
      }
      for (localObject = a(f10);; localObject = (int)f10 + "")
      {
        paramCanvas.drawText((String)localObject, f9, f8, this.R);
        i3 += 1;
        break label404;
        f1 = f3;
        f2 = f4;
        if (this.s < 1) {
          break;
        }
        f1 = this.i;
        f2 = this.L;
        localObject = getMinText();
        this.R.getTextBounds((String)localObject, 0, ((String)localObject).length(), this.S);
        f6 = f1 + f5 + f2 + this.S.height();
        f3 = this.P;
        if (this.s == 1) {
          paramCanvas.drawText((String)localObject, f3, f6, this.R);
        }
        localObject = getMaxText();
        this.R.getTextBounds((String)localObject, 0, ((String)localObject).length(), this.S);
        f4 = this.Q;
        f1 = f4;
        f2 = f3;
        if (this.s != 1) {
          break;
        }
        paramCanvas.drawText((String)localObject, f4, f6, this.R);
        f1 = f4;
        f2 = f3;
        break;
        f1 = f3;
        f2 = f4;
        if (!this.u) {
          break;
        }
        f1 = f3;
        f2 = f4;
        if (this.s != -1) {
          break;
        }
        f2 = this.P;
        f1 = this.Q;
        break;
        i1 = 0;
        break label274;
        i2 = 0;
        break label286;
        i4 = this.j;
        break label451;
      }
      float f10 = this.b + this.G * i3;
      if (this.e) {}
      for (localObject = a(f10);; localObject = (int)f10 + "")
      {
        paramCanvas.drawText((String)localObject, f9, f8, this.R);
        break;
      }
      if ((!this.K) || (this.B)) {
        this.H = (this.I / this.F * (this.d - this.b) + f2);
      }
      if ((this.u) && (!this.K) && (this.ae))
      {
        this.R.setColor(this.w);
        this.R.setTextSize(this.v);
        this.R.getTextBounds("0123456789", 0, "0123456789".length(), this.S);
        f3 = this.S.height() + f5 + this.i + this.L;
        if ((this.e) || ((this.x) && (this.s == 1) && (this.d != this.b) && (this.d != this.c))) {
          paramCanvas.drawText(String.valueOf(getProgressFloat()), this.H, f3, this.R);
        }
      }
      else
      {
        this.R.setColor(this.k);
        this.R.setStrokeWidth(this.g);
        paramCanvas.drawLine(f2, f5, this.H, f5, this.R);
        this.R.setColor(this.j);
        this.R.setStrokeWidth(this.f);
        paramCanvas.drawLine(this.H, f5, f1, f5, this.R);
        this.R.setColor(this.l);
        f2 = this.H;
        if (!this.K) {
          break label1232;
        }
      }
      for (f1 = this.i;; f1 = this.h)
      {
        paramCanvas.drawCircle(f2, f5, f1, this.R);
        return;
        paramCanvas.drawText(String.valueOf(getProgress()), this.H, f3, this.R);
        break;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i2 = this.i * 2;
    int i1 = i2;
    if (this.u)
    {
      this.R.setTextSize(this.v);
      this.R.getTextBounds("j", 0, 1, this.S);
      i1 = i2 + (this.S.height() + this.L);
    }
    i2 = i1;
    if (this.p)
    {
      i2 = i1;
      if (this.s >= 1)
      {
        this.R.setTextSize(this.q);
        this.R.getTextBounds("j", 0, 1, this.S);
        i2 = Math.max(i1, this.i * 2 + this.S.height() + this.L);
      }
    }
    setMeasuredDimension(resolveSize(getSuggestedMinimumWidth(), paramInt1), i2);
    this.P = (getPaddingLeft() + this.i);
    this.Q = (getMeasuredWidth() - getPaddingRight() - this.i);
    String str;
    if (this.p)
    {
      this.R.setTextSize(this.q);
      if (this.s == 0)
      {
        str = getMinText();
        this.R.getTextBounds(str, 0, str.length(), this.S);
        this.P += this.S.width() + this.L;
        str = getMaxText();
        this.R.getTextBounds(str, 0, str.length(), this.S);
        this.Q -= this.S.width() + this.L;
      }
    }
    for (;;)
    {
      this.I = (this.Q - this.P);
      this.J = (this.I * 1.0F / this.m);
      this.U.measure(paramInt1, paramInt2);
      c();
      return;
      if (this.s >= 1)
      {
        str = getMinText();
        this.R.getTextBounds(str, 0, str.length(), this.S);
        this.P = (Math.max(this.i, this.S.width() / 2.0F) + getPaddingLeft() + this.L);
        str = getMaxText();
        this.R.getTextBounds(str, 0, str.length(), this.S);
        float f1 = Math.max(this.i, this.S.width() / 2.0F);
        this.Q = (getMeasuredWidth() - getPaddingRight() - f1 - this.L);
        continue;
        if ((this.u) && (this.s == -1))
        {
          this.R.setTextSize(this.v);
          str = getMinText();
          this.R.getTextBounds(str, 0, str.length(), this.S);
          this.P = (Math.max(this.i, this.S.width() / 2.0F) + getPaddingLeft() + this.L);
          str = getMaxText();
          this.R.getTextBounds(str, 0, str.length(), this.S);
          f1 = Math.max(this.i, this.S.width() / 2.0F);
          this.Q = (getMeasuredWidth() - getPaddingRight() - f1 - this.L);
        }
      }
    }
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof Bundle))
    {
      paramParcelable = (Bundle)paramParcelable;
      this.d = paramParcelable.getFloat("progress");
      super.onRestoreInstanceState(paramParcelable.getParcelable("save_instance"));
      BubbleView localBubbleView = this.U;
      if (this.x) {}
      for (paramParcelable = String.valueOf(getProgressFloat());; paramParcelable = String.valueOf(getProgress()))
      {
        localBubbleView.a(paramParcelable);
        if (this.B) {
          setProgress(this.d);
        }
        return;
      }
    }
    super.onRestoreInstanceState(paramParcelable);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("save_instance", super.onSaveInstanceState());
    localBundle.putFloat("progress", this.d);
    return localBundle;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    post(new Runnable()
    {
      public void run()
      {
        BubbleSeekBar.this.requestLayout();
      }
    });
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    long l1 = 300L;
    long l2 = 0L;
    switch (paramMotionEvent.getActionMasked())
    {
    }
    while ((this.K) || (this.y) || (super.onTouchEvent(paramMotionEvent)))
    {
      return true;
      this.K = a(paramMotionEvent);
      if (this.K)
      {
        if ((this.z) && (!this.N)) {
          this.N = true;
        }
        if ((this.B) && (!this.M)) {
          this.M = true;
        }
        d();
        invalidate();
      }
      for (;;)
      {
        this.a = (this.H - paramMotionEvent.getX());
        break;
        if ((this.y) && (b(paramMotionEvent)))
        {
          if (this.B)
          {
            f();
            this.M = true;
          }
          this.H = paramMotionEvent.getX();
          if (this.H < this.P) {
            this.H = this.P;
          }
          if (this.H > this.Q) {
            this.H = this.Q;
          }
          this.d = ((this.H - this.P) * this.F / this.I + this.b);
          this.ab = (this.W + this.I * (this.d - this.b) / this.F);
          d();
          invalidate();
        }
      }
      if (this.K)
      {
        this.H = (paramMotionEvent.getX() + this.a);
        if (this.H < this.P) {
          this.H = this.P;
        }
        if (this.H > this.Q) {
          this.H = this.Q;
        }
        this.d = ((this.H - this.P) * this.F / this.I + this.b);
        this.ab = (this.W + this.I * (this.d - this.b) / this.F);
        this.ac.x = ((int)(this.ab + 0.5F));
        this.T.updateViewLayout(this.U, this.ac);
        Object localObject2 = this.U;
        if (this.x) {}
        for (Object localObject1 = String.valueOf(getProgressFloat());; localObject1 = String.valueOf(getProgress()))
        {
          ((BubbleView)localObject2).a((String)localObject1);
          invalidate();
          if (this.O == null) {
            break;
          }
          this.O.onProgressChanged(getProgress(), getProgressFloat());
          break;
        }
        if (this.o) {
          if (this.y)
          {
            localObject1 = this.U;
            localObject2 = new Runnable()
            {
              public void run()
              {
                BubbleSeekBar.a(BubbleSeekBar.this, false);
                BubbleSeekBar.a(BubbleSeekBar.this);
              }
            };
            if (this.K)
            {
              l1 = l2;
              label549:
              ((BubbleView)localObject1).postDelayed((Runnable)localObject2, l1);
            }
          }
        }
        for (;;)
        {
          label558:
          if (this.O != null)
          {
            this.O.getProgressOnActionUp(getProgress(), getProgressFloat());
            break;
            l1 = 300L;
            break label549;
            e();
            continue;
            if ((this.K) || (this.y))
            {
              localObject1 = this.U;
              localObject2 = new Runnable()
              {
                public void run()
                {
                  ViewPropertyAnimator localViewPropertyAnimator = BubbleSeekBar.f(BubbleSeekBar.this).animate();
                  if (BubbleSeekBar.b(BubbleSeekBar.this)) {}
                  for (float f = 1.0F;; f = 0.0F)
                  {
                    localViewPropertyAnimator.alpha(f).setDuration(BubbleSeekBar.e(BubbleSeekBar.this)).setListener(new AnimatorListenerAdapter()
                    {
                      public void onAnimationCancel(Animator paramAnonymous2Animator)
                      {
                        if (!BubbleSeekBar.b(BubbleSeekBar.this)) {
                          BubbleSeekBar.c(BubbleSeekBar.this);
                        }
                        BubbleSeekBar.b(BubbleSeekBar.this, false);
                        BubbleSeekBar.this.invalidate();
                      }
                      
                      public void onAnimationEnd(Animator paramAnonymous2Animator)
                      {
                        if (!BubbleSeekBar.b(BubbleSeekBar.this)) {
                          BubbleSeekBar.c(BubbleSeekBar.this);
                        }
                        BubbleSeekBar.b(BubbleSeekBar.this, false);
                        BubbleSeekBar.this.invalidate();
                        if (BubbleSeekBar.d(BubbleSeekBar.this) != null) {
                          BubbleSeekBar.d(BubbleSeekBar.this).onProgressChanged(BubbleSeekBar.this.getProgress(), BubbleSeekBar.this.getProgressFloat());
                        }
                      }
                    }).start();
                    return;
                  }
                }
              };
              if ((this.K) || (!this.y)) {
                break label655;
              }
            }
          }
        }
        for (;;)
        {
          ((BubbleView)localObject1).postDelayed((Runnable)localObject2, l1);
          break label558;
          break;
          label655:
          l1 = 0L;
        }
      }
    }
    return false;
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    if (!this.B) {
      return;
    }
    if (paramInt != 0) {
      f();
    }
    for (;;)
    {
      super.onVisibilityChanged(paramView, paramInt);
      return;
      if (this.M) {
        d();
      }
    }
  }
  
  public void setOnProgressChangedListener(a parama)
  {
    this.O = parama;
  }
  
  public void setProgress(float paramFloat)
  {
    this.d = paramFloat;
    this.ab = (this.W + this.I * (this.d - this.b) / this.F);
    if (this.O != null)
    {
      this.O.onProgressChanged(getProgress(), getProgressFloat());
      this.O.getProgressOnFinally(getProgress(), getProgressFloat());
    }
    Runnable local7;
    if (this.B)
    {
      f();
      int[] arrayOfInt = new int[2];
      getLocationOnScreen(arrayOfInt);
      local7 = new Runnable()
      {
        public void run()
        {
          BubbleSeekBar.q(BubbleSeekBar.this);
          BubbleSeekBar.c(BubbleSeekBar.this, true);
        }
      };
      if ((arrayOfInt[0] != 0) || (arrayOfInt[1] != 0)) {
        break label137;
      }
    }
    label137:
    for (long l1 = 200L;; l1 = 0L)
    {
      postDelayed(local7, l1);
      postInvalidate();
      return;
    }
  }
  
  private class BubbleView
    extends View
  {
    private Paint b = new Paint();
    private Path c;
    private RectF d;
    private Rect e;
    private String f = "";
    
    BubbleView(Context paramContext)
    {
      this(paramContext, null);
    }
    
    BubbleView(Context paramContext, AttributeSet paramAttributeSet)
    {
      this(paramContext, paramAttributeSet, 0);
    }
    
    BubbleView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    {
      super(paramAttributeSet, paramInt);
      this.b.setAntiAlias(true);
      this.b.setTextAlign(Paint.Align.CENTER);
      this.c = new Path();
      this.d = new RectF();
      this.e = new Rect();
    }
    
    void a(String paramString)
    {
      if ((paramString != null) && (!this.f.equals(paramString)))
      {
        this.f = paramString;
        invalidate();
      }
    }
    
    protected void onDraw(Canvas paramCanvas)
    {
      super.onDraw(paramCanvas);
      this.c.reset();
      float f1 = getMeasuredWidth() / 2.0F;
      float f2 = getMeasuredHeight() - BubbleSeekBar.r(BubbleSeekBar.this) / 3.0F;
      this.c.moveTo(f1, f2);
      float f4 = (float)(getMeasuredWidth() / 2.0F - Math.sqrt(3.0D) / 2.0D * BubbleSeekBar.r(BubbleSeekBar.this));
      float f3 = 1.5F * BubbleSeekBar.r(BubbleSeekBar.this);
      this.c.quadTo(f4 - b.a(2), f3 - b.a(2), f4, f3);
      this.c.arcTo(this.d, 150.0F, 240.0F);
      f4 = (float)(getMeasuredWidth() / 2.0F + Math.sqrt(3.0D) / 2.0D * BubbleSeekBar.r(BubbleSeekBar.this));
      this.c.quadTo(f4 + b.a(2), f3 - b.a(2), f1, f2);
      this.c.close();
      this.b.setColor(BubbleSeekBar.s(BubbleSeekBar.this));
      paramCanvas.drawPath(this.c, this.b);
      this.b.setTextSize(BubbleSeekBar.t(BubbleSeekBar.this));
      this.b.setColor(BubbleSeekBar.u(BubbleSeekBar.this));
      this.b.getTextBounds(this.f, 0, this.f.length(), this.e);
      Paint.FontMetrics localFontMetrics = this.b.getFontMetrics();
      f1 = BubbleSeekBar.r(BubbleSeekBar.this);
      f2 = (localFontMetrics.descent - localFontMetrics.ascent) / 2.0F;
      f3 = localFontMetrics.descent;
      paramCanvas.drawText(this.f, getMeasuredWidth() / 2.0F, f1 + f2 - f3, this.b);
    }
    
    protected void onMeasure(int paramInt1, int paramInt2)
    {
      super.onMeasure(paramInt1, paramInt2);
      setMeasuredDimension(BubbleSeekBar.r(BubbleSeekBar.this) * 3, BubbleSeekBar.r(BubbleSeekBar.this) * 3);
      this.d.set(getMeasuredWidth() / 2.0F - BubbleSeekBar.r(BubbleSeekBar.this), 0.0F, getMeasuredWidth() / 2.0F + BubbleSeekBar.r(BubbleSeekBar.this), BubbleSeekBar.r(BubbleSeekBar.this) * 2);
    }
  }
  
  public static abstract interface a
  {
    public abstract void getProgressOnActionUp(int paramInt, float paramFloat);
    
    public abstract void getProgressOnFinally(int paramInt, float paramFloat);
    
    public abstract void onProgressChanged(int paramInt, float paramFloat);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xw/repo/BubbleSeekBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */