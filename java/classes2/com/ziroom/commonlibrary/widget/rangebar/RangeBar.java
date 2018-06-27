package com.ziroom.commonlibrary.widget.rangebar;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewParent;
import com.ziroom.commonlibrary.R.drawable;

public class RangeBar
  extends View
{
  private static final int a = R.drawable.seek_thumb_normal;
  private static final int b = R.drawable.seek_thumb_pressed;
  private int c = 3;
  private float d = 24.0F;
  private float e = 2.0F;
  private int f = -3355444;
  private float g = 4.0F;
  private int h = -13388315;
  private int i = a;
  private int j = b;
  private float k = -1.0F;
  private int l = -1;
  private int m = -1;
  private boolean n = true;
  private int o = 500;
  private int p = 100;
  private c q;
  private c r;
  private a s;
  private b t;
  private a u;
  private int v = 0;
  private int w = this.c - 1;
  
  public RangeBar(Context paramContext)
  {
    super(paramContext);
  }
  
  public RangeBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  public RangeBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private void a()
  {
    this.s = new a(getContext(), getMarginLeft(), getYPos(), getBarLength(), this.c, this.d, this.e, this.f);
    invalidate();
  }
  
  private void a(float paramFloat)
  {
    if (this.q.c()) {
      a(this.q, paramFloat);
    }
    for (;;)
    {
      if (this.q.b() > this.r.b())
      {
        c localc = this.q;
        this.q = this.r;
        this.r = localc;
      }
      int i1 = this.s.b(this.q);
      int i2 = this.s.b(this.r);
      if ((i1 != this.v) || (i2 != this.w))
      {
        this.v = i1;
        this.w = i2;
        if (this.u != null) {
          this.u.onIndexChangeListener(this, this.v, this.w);
        }
      }
      return;
      if (this.r.c()) {
        a(this.r, paramFloat);
      }
    }
  }
  
  private void a(float paramFloat1, float paramFloat2)
  {
    if ((!this.q.c()) && (this.q.a(paramFloat1, paramFloat2))) {
      a(this.q);
    }
    while ((this.q.c()) || (!this.r.a(paramFloat1, paramFloat2))) {
      return;
    }
    a(this.r);
  }
  
  /* Error */
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    // Byte code:
    //   0: aload_1
    //   1: aload_2
    //   2: getstatic 161	com/ziroom/commonlibrary/R$styleable:RangeBar	[I
    //   5: iconst_0
    //   6: iconst_0
    //   7: invokevirtual 167	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;
    //   10: astore_1
    //   11: aload_1
    //   12: iconst_0
    //   13: iconst_3
    //   14: invokevirtual 173	android/content/res/TypedArray:getInteger	(II)I
    //   17: invokestatic 179	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   20: astore_2
    //   21: aload_0
    //   22: aload_2
    //   23: invokevirtual 183	java/lang/Integer:intValue	()I
    //   26: invokespecial 186	com/ziroom/commonlibrary/widget/rangebar/RangeBar:a	(I)Z
    //   29: ifeq +191 -> 220
    //   32: aload_0
    //   33: aload_2
    //   34: invokevirtual 183	java/lang/Integer:intValue	()I
    //   37: putfield 57	com/ziroom/commonlibrary/widget/rangebar/RangeBar:c	I
    //   40: aload_0
    //   41: iconst_0
    //   42: putfield 90	com/ziroom/commonlibrary/widget/rangebar/RangeBar:v	I
    //   45: aload_0
    //   46: aload_0
    //   47: getfield 57	com/ziroom/commonlibrary/widget/rangebar/RangeBar:c	I
    //   50: iconst_1
    //   51: isub
    //   52: putfield 92	com/ziroom/commonlibrary/widget/rangebar/RangeBar:w	I
    //   55: aload_0
    //   56: getfield 144	com/ziroom/commonlibrary/widget/rangebar/RangeBar:u	Lcom/ziroom/commonlibrary/widget/rangebar/RangeBar$a;
    //   59: ifnull +21 -> 80
    //   62: aload_0
    //   63: getfield 144	com/ziroom/commonlibrary/widget/rangebar/RangeBar:u	Lcom/ziroom/commonlibrary/widget/rangebar/RangeBar$a;
    //   66: aload_0
    //   67: aload_0
    //   68: getfield 90	com/ziroom/commonlibrary/widget/rangebar/RangeBar:v	I
    //   71: aload_0
    //   72: getfield 92	com/ziroom/commonlibrary/widget/rangebar/RangeBar:w	I
    //   75: invokeinterface 148 4 0
    //   80: aload_0
    //   81: aload_1
    //   82: getstatic 189	com/ziroom/commonlibrary/R$styleable:RangeBar_tickHeight	I
    //   85: ldc 58
    //   87: invokevirtual 193	android/content/res/TypedArray:getDimension	(IF)F
    //   90: putfield 60	com/ziroom/commonlibrary/widget/rangebar/RangeBar:d	F
    //   93: aload_0
    //   94: aload_1
    //   95: getstatic 196	com/ziroom/commonlibrary/R$styleable:RangeBar_barWeight	I
    //   98: fconst_2
    //   99: invokevirtual 193	android/content/res/TypedArray:getDimension	(IF)F
    //   102: putfield 62	com/ziroom/commonlibrary/widget/rangebar/RangeBar:e	F
    //   105: aload_0
    //   106: aload_1
    //   107: getstatic 199	com/ziroom/commonlibrary/R$styleable:RangeBar_barColor	I
    //   110: ldc -55
    //   112: invokestatic 207	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   115: invokevirtual 210	android/content/res/TypedArray:getColor	(II)I
    //   118: putfield 65	com/ziroom/commonlibrary/widget/rangebar/RangeBar:f	I
    //   121: aload_0
    //   122: aload_1
    //   123: getstatic 213	com/ziroom/commonlibrary/R$styleable:RangeBar_connectingLineWeight	I
    //   126: ldc 66
    //   128: invokevirtual 193	android/content/res/TypedArray:getDimension	(IF)F
    //   131: putfield 68	com/ziroom/commonlibrary/widget/rangebar/RangeBar:g	F
    //   134: aload_0
    //   135: aload_1
    //   136: getstatic 216	com/ziroom/commonlibrary/R$styleable:RangeBar_connectingLineColor	I
    //   139: ldc -38
    //   141: invokestatic 207	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   144: invokevirtual 210	android/content/res/TypedArray:getColor	(II)I
    //   147: putfield 71	com/ziroom/commonlibrary/widget/rangebar/RangeBar:h	I
    //   150: aload_0
    //   151: aload_1
    //   152: getstatic 221	com/ziroom/commonlibrary/R$styleable:RangeBar_thumbRadius	I
    //   155: ldc 76
    //   157: invokevirtual 193	android/content/res/TypedArray:getDimension	(IF)F
    //   160: putfield 78	com/ziroom/commonlibrary/widget/rangebar/RangeBar:k	F
    //   163: aload_0
    //   164: aload_1
    //   165: getstatic 224	com/ziroom/commonlibrary/R$styleable:RangeBar_thumbImageNormal	I
    //   168: getstatic 45	com/ziroom/commonlibrary/widget/rangebar/RangeBar:a	I
    //   171: invokevirtual 227	android/content/res/TypedArray:getResourceId	(II)I
    //   174: putfield 73	com/ziroom/commonlibrary/widget/rangebar/RangeBar:i	I
    //   177: aload_0
    //   178: aload_1
    //   179: getstatic 230	com/ziroom/commonlibrary/R$styleable:RangeBar_thumbImagePressed	I
    //   182: getstatic 50	com/ziroom/commonlibrary/widget/rangebar/RangeBar:b	I
    //   185: invokevirtual 227	android/content/res/TypedArray:getResourceId	(II)I
    //   188: putfield 75	com/ziroom/commonlibrary/widget/rangebar/RangeBar:j	I
    //   191: aload_0
    //   192: aload_1
    //   193: getstatic 233	com/ziroom/commonlibrary/R$styleable:RangeBar_thumbColorNormal	I
    //   196: iconst_m1
    //   197: invokevirtual 210	android/content/res/TypedArray:getColor	(II)I
    //   200: putfield 80	com/ziroom/commonlibrary/widget/rangebar/RangeBar:l	I
    //   203: aload_0
    //   204: aload_1
    //   205: getstatic 236	com/ziroom/commonlibrary/R$styleable:RangeBar_thumbColorPressed	I
    //   208: iconst_m1
    //   209: invokevirtual 210	android/content/res/TypedArray:getColor	(II)I
    //   212: putfield 82	com/ziroom/commonlibrary/widget/rangebar/RangeBar:m	I
    //   215: aload_1
    //   216: invokevirtual 239	android/content/res/TypedArray:recycle	()V
    //   219: return
    //   220: ldc -16
    //   222: ldc -14
    //   224: invokestatic 247	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   227: pop
    //   228: goto -148 -> 80
    //   231: astore_2
    //   232: aload_1
    //   233: invokevirtual 239	android/content/res/TypedArray:recycle	()V
    //   236: aload_2
    //   237: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	238	0	this	RangeBar
    //   0	238	1	paramContext	Context
    //   0	238	2	paramAttributeSet	AttributeSet
    // Exception table:
    //   from	to	target	type
    //   11	80	231	finally
    //   80	215	231	finally
    //   220	228	231	finally
  }
  
  private void a(c paramc)
  {
    if (this.n) {
      this.n = false;
    }
    paramc.d();
    invalidate();
  }
  
  private void a(c paramc, float paramFloat)
  {
    if ((paramFloat >= this.s.a()) && (paramFloat <= this.s.b()))
    {
      paramc.a(paramFloat);
      invalidate();
    }
  }
  
  private boolean a(int paramInt)
  {
    return paramInt > 1;
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    return (paramInt1 < 0) || (paramInt1 >= this.c) || (paramInt2 < 0) || (paramInt2 >= this.c);
  }
  
  private void b()
  {
    this.t = new b(getContext(), getYPos(), this.g, this.h);
    invalidate();
  }
  
  private void b(float paramFloat1, float paramFloat2)
  {
    if (this.q.c())
    {
      b(this.q);
      return;
    }
    if (this.r.c())
    {
      b(this.r);
      return;
    }
    if (Math.abs(this.q.b() - paramFloat1) < Math.abs(this.r.b() - paramFloat1))
    {
      this.q.a(paramFloat1);
      b(this.q);
    }
    for (;;)
    {
      int i1 = this.s.b(this.q);
      int i2 = this.s.b(this.r);
      if ((i1 == this.v) && (i2 == this.w)) {
        break;
      }
      this.v = i1;
      this.w = i2;
      if (this.u == null) {
        break;
      }
      this.u.onIndexChangeListener(this, this.v, this.w);
      return;
      this.r.a(paramFloat1);
      b(this.r);
    }
  }
  
  private void b(c paramc)
  {
    paramc.a(this.s.a(paramc));
    paramc.e();
    invalidate();
  }
  
  private void c()
  {
    Context localContext = getContext();
    float f1 = getYPos();
    this.q = new c(localContext, f1, this.l, this.m, this.k, this.i, this.j);
    this.r = new c(localContext, f1, this.l, this.m, this.k, this.i, this.j);
    f1 = getMarginLeft();
    float f2 = getBarLength();
    this.q.a(this.v / (this.c - 1) * f2 + f1);
    this.r.a(f1 + f2 * (this.w / (this.c - 1)));
    invalidate();
  }
  
  private float getBarLength()
  {
    return getWidth() - 2.0F * getMarginLeft();
  }
  
  private float getMarginLeft()
  {
    if (this.q != null) {
      return this.q.a();
    }
    return 0.0F;
  }
  
  private float getYPos()
  {
    return getHeight() / 2.0F;
  }
  
  public int getLeftIndex()
  {
    return this.v;
  }
  
  public int getRightIndex()
  {
    return this.w;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.s.a(paramCanvas);
    this.t.a(paramCanvas, this.q, this.r);
    this.q.a(paramCanvas);
    this.r.a(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i3 = View.MeasureSpec.getMode(paramInt1);
    int i2 = View.MeasureSpec.getMode(paramInt2);
    int i1 = View.MeasureSpec.getSize(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt2);
    if (i3 == Integer.MIN_VALUE)
    {
      paramInt2 = i1;
      if (i2 != Integer.MIN_VALUE) {
        break label74;
      }
      paramInt1 = Math.min(this.p, paramInt1);
    }
    for (;;)
    {
      setMeasuredDimension(paramInt2, paramInt1);
      return;
      paramInt2 = i1;
      if (i3 == 1073741824) {
        break;
      }
      paramInt2 = this.o;
      break;
      label74:
      if (i2 != 1073741824) {
        paramInt1 = this.p;
      }
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof Bundle))
    {
      paramParcelable = (Bundle)paramParcelable;
      this.c = paramParcelable.getInt("TICK_COUNT");
      this.d = paramParcelable.getFloat("TICK_HEIGHT_DP");
      this.e = paramParcelable.getFloat("BAR_WEIGHT");
      this.f = paramParcelable.getInt("BAR_COLOR");
      this.g = paramParcelable.getFloat("CONNECTING_LINE_WEIGHT");
      this.h = paramParcelable.getInt("CONNECTING_LINE_COLOR");
      this.i = paramParcelable.getInt("THUMB_IMAGE_NORMAL");
      this.j = paramParcelable.getInt("THUMB_IMAGE_PRESSED");
      this.k = paramParcelable.getFloat("THUMB_RADIUS_DP");
      this.l = paramParcelable.getInt("THUMB_COLOR_NORMAL");
      this.m = paramParcelable.getInt("THUMB_COLOR_PRESSED");
      this.v = paramParcelable.getInt("LEFT_INDEX");
      this.w = paramParcelable.getInt("RIGHT_INDEX");
      this.n = paramParcelable.getBoolean("FIRST_SET_TICK_COUNT");
      setThumbIndices(this.v, this.w);
      super.onRestoreInstanceState(paramParcelable.getParcelable("instanceState"));
      return;
    }
    super.onRestoreInstanceState(paramParcelable);
  }
  
  public Parcelable onSaveInstanceState()
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("instanceState", super.onSaveInstanceState());
    localBundle.putInt("TICK_COUNT", this.c);
    localBundle.putFloat("TICK_HEIGHT_DP", this.d);
    localBundle.putFloat("BAR_WEIGHT", this.e);
    localBundle.putInt("BAR_COLOR", this.f);
    localBundle.putFloat("CONNECTING_LINE_WEIGHT", this.g);
    localBundle.putInt("CONNECTING_LINE_COLOR", this.h);
    localBundle.putInt("THUMB_IMAGE_NORMAL", this.i);
    localBundle.putInt("THUMB_IMAGE_PRESSED", this.j);
    localBundle.putFloat("THUMB_RADIUS_DP", this.k);
    localBundle.putInt("THUMB_COLOR_NORMAL", this.l);
    localBundle.putInt("THUMB_COLOR_PRESSED", this.m);
    localBundle.putInt("LEFT_INDEX", this.v);
    localBundle.putInt("RIGHT_INDEX", this.w);
    localBundle.putBoolean("FIRST_SET_TICK_COUNT", this.n);
    return localBundle;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    Context localContext = getContext();
    float f1 = paramInt2 / 2.0F;
    this.q = new c(localContext, f1, this.l, this.m, this.k, this.i, this.j);
    this.r = new c(localContext, f1, this.l, this.m, this.k, this.i, this.j);
    float f2 = this.q.a();
    float f3 = paramInt1 - 2.0F * f2;
    this.s = new a(localContext, f2, f1, f3, this.c, this.d, this.e, this.f);
    this.q.a(this.v / (this.c - 1) * f3 + f2);
    this.r.a(this.w / (this.c - 1) * f3 + f2);
    paramInt1 = this.s.b(this.q);
    paramInt2 = this.s.b(this.r);
    if ((paramInt1 != this.v) || (paramInt2 != this.w))
    {
      this.v = paramInt1;
      this.w = paramInt2;
      if (this.u != null) {
        this.u.onIndexChangeListener(this, this.v, this.w);
      }
    }
    this.t = new b(localContext, f1, this.g, this.h);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!isEnabled()) {
      return false;
    }
    switch (paramMotionEvent.getAction())
    {
    default: 
      return false;
    case 0: 
      a(paramMotionEvent.getX(), paramMotionEvent.getY());
      return true;
    case 1: 
    case 3: 
      getParent().requestDisallowInterceptTouchEvent(false);
      b(paramMotionEvent.getX(), paramMotionEvent.getY());
      return true;
    }
    a(paramMotionEvent.getX());
    getParent().requestDisallowInterceptTouchEvent(true);
    return true;
  }
  
  public void setBarColor(int paramInt)
  {
    this.f = paramInt;
    a();
  }
  
  public void setBarWeight(float paramFloat)
  {
    this.e = paramFloat;
    a();
  }
  
  public void setConnectingLineColor(int paramInt)
  {
    this.h = paramInt;
    b();
  }
  
  public void setConnectingLineWeight(float paramFloat)
  {
    this.g = paramFloat;
    b();
  }
  
  public void setOnRangeBarChangeListener(a parama)
  {
    this.u = parama;
  }
  
  public void setThumbColorNormal(int paramInt)
  {
    this.l = paramInt;
    c();
  }
  
  public void setThumbColorPressed(int paramInt)
  {
    this.m = paramInt;
    c();
  }
  
  public void setThumbImageNormal(int paramInt)
  {
    this.i = paramInt;
    c();
  }
  
  public void setThumbImagePressed(int paramInt)
  {
    this.j = paramInt;
    c();
  }
  
  public void setThumbIndices(int paramInt1, int paramInt2)
  {
    if (a(paramInt1, paramInt2))
    {
      Log.e("RangeBar", "A thumb index is out of bounds. Check that it is between 0 and mTickCount - 1");
      throw new IllegalArgumentException("A thumb index is out of bounds. Check that it is between 0 and mTickCount - 1");
    }
    if (this.n) {
      this.n = false;
    }
    this.v = paramInt1;
    this.w = paramInt2;
    c();
    if (this.u != null) {
      this.u.onIndexChangeListener(this, this.v, this.w);
    }
    invalidate();
    requestLayout();
  }
  
  public void setThumbRadius(float paramFloat)
  {
    this.k = paramFloat;
    c();
  }
  
  public void setTickCount(int paramInt)
  {
    if (a(paramInt))
    {
      this.c = paramInt;
      if (this.n)
      {
        this.v = 0;
        this.w = (this.c - 1);
        if (this.u != null) {
          this.u.onIndexChangeListener(this, this.v, this.w);
        }
      }
      if (a(this.v, this.w))
      {
        this.v = 0;
        this.w = (this.c - 1);
        if (this.u != null) {
          this.u.onIndexChangeListener(this, this.v, this.w);
        }
      }
      a();
      c();
      return;
    }
    Log.e("RangeBar", "tickCount less than 2; invalid tickCount.");
    throw new IllegalArgumentException("tickCount less than 2; invalid tickCount.");
  }
  
  public void setTickHeight(float paramFloat)
  {
    this.d = paramFloat;
    a();
  }
  
  public static abstract interface a
  {
    public abstract void onIndexChangeListener(RangeBar paramRangeBar, int paramInt1, int paramInt2);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/commonlibrary/widget/rangebar/RangeBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */