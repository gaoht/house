package com.ziroom.ziroomcustomer.pay.huifu.views.wheelview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class WheelView
  extends View
{
  private static final int[] b = { -15658735, 11184810, 11184810 };
  private static int c = 15;
  private static int d = 40;
  private static final int e = d / 5;
  private final int A = 0;
  private final int B = 1;
  private Handler C = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      WheelView.b(WheelView.this).computeScrollOffset();
      int i = WheelView.b(WheelView.this).getCurrY();
      int j = WheelView.i(WheelView.this) - i;
      WheelView.b(WheelView.this, i);
      if (j != 0) {
        WheelView.a(WheelView.this, j);
      }
      if (Math.abs(i - WheelView.b(WheelView.this).getFinalY()) < 1)
      {
        WheelView.b(WheelView.this).getFinalY();
        WheelView.b(WheelView.this).forceFinished(true);
      }
      if (!WheelView.b(WheelView.this).isFinished())
      {
        WheelView.j(WheelView.this).sendEmptyMessage(paramAnonymousMessage.what);
        return;
      }
      if (paramAnonymousMessage.what == 0)
      {
        WheelView.k(WheelView.this);
        return;
      }
      WheelView.this.c();
    }
  };
  boolean a = false;
  private c f = null;
  private int g = 0;
  private int h = 0;
  private int i = 0;
  private int j = 5;
  private int k = 0;
  private TextPaint l;
  private TextPaint m;
  private StaticLayout n;
  private StaticLayout o;
  private StaticLayout p;
  private String q;
  private Drawable r;
  private boolean s;
  private int t;
  private GestureDetector u;
  private Scroller v;
  private int w;
  private List<a> x = new LinkedList();
  private List<b> y = new LinkedList();
  private GestureDetector.SimpleOnGestureListener z = new GestureDetector.SimpleOnGestureListener()
  {
    public boolean onDown(MotionEvent paramAnonymousMotionEvent)
    {
      if (WheelView.a(WheelView.this))
      {
        WheelView.b(WheelView.this).forceFinished(true);
        WheelView.c(WheelView.this);
        return true;
      }
      return false;
    }
    
    public boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
    {
      WheelView.b(WheelView.this, WheelView.e(WheelView.this) * WheelView.f(WheelView.this) + WheelView.g(WheelView.this));
      int i;
      if (WheelView.this.a)
      {
        i = Integer.MAX_VALUE;
        if (!WheelView.this.a) {
          break label126;
        }
      }
      label126:
      for (int j = -i;; j = 0)
      {
        WheelView.b(WheelView.this).fling(0, WheelView.i(WheelView.this), 0, (int)-paramAnonymousFloat2 / 2, 0, 0, j, i);
        WheelView.c(WheelView.this, 0);
        return true;
        i = WheelView.h(WheelView.this).getItemsCount() * WheelView.f(WheelView.this);
        break;
      }
    }
    
    public boolean onScroll(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
    {
      WheelView.d(WheelView.this);
      WheelView.a(WheelView.this, (int)-paramAnonymousFloat2);
      return true;
    }
  };
  
  public WheelView(Context paramContext)
  {
    super(paramContext);
    d = (int)paramContext.getResources().getDimension(2131231258);
    a(paramContext);
  }
  
  public WheelView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    d = (int)paramContext.getResources().getDimension(2131231258);
    a(paramContext);
  }
  
  public WheelView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    d = (int)paramContext.getResources().getDimension(2131231258);
    a(paramContext);
  }
  
  private int a(Layout paramLayout)
  {
    if (paramLayout == null) {
      return 0;
    }
    return Math.max(getItemHeight() * this.j - e * 2 - c, getSuggestedMinimumHeight());
  }
  
  private String a(int paramInt)
  {
    if ((this.f == null) || (this.f.getItemsCount() == 0)) {}
    int i2;
    do
    {
      return null;
      i2 = this.f.getItemsCount();
      if (paramInt >= 0)
      {
        i1 = paramInt;
        if (paramInt < i2) {
          break;
        }
      }
    } while (!this.a);
    int i1 = paramInt;
    while (i1 < 0) {
      i1 += i2;
    }
    return this.f.getItem(i1 % i2);
  }
  
  private String a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i2 = this.j / 2 + 1;
    int i1 = this.g - i2;
    while (i1 <= this.g + i2)
    {
      if ((paramBoolean) || (i1 != this.g))
      {
        String str = a(i1);
        if (str != null) {
          localStringBuilder.append(str);
        }
      }
      if (i1 < this.g + i2) {
        localStringBuilder.append("\n");
      }
      i1 += 1;
    }
    return localStringBuilder.toString();
  }
  
  private void a(Context paramContext)
  {
    c = d;
    this.u = new GestureDetector(paramContext, this.z);
    this.u.setIsLongpressEnabled(false);
    this.v = new Scroller(paramContext);
  }
  
  private void a(Canvas paramCanvas)
  {
    this.m.setColor(-15658735);
    this.m.drawableState = getDrawableState();
    Rect localRect = new Rect();
    this.n.getLineBounds(this.j / 2, localRect);
    if (this.o != null)
    {
      paramCanvas.save();
      paramCanvas.translate(this.n.getWidth() + 8, localRect.top);
      this.o.draw(paramCanvas);
      paramCanvas.restore();
    }
    if (this.p != null)
    {
      paramCanvas.save();
      paramCanvas.translate(0.0F, localRect.top + this.t);
      this.p.draw(paramCanvas);
      paramCanvas.restore();
    }
  }
  
  private int b(int paramInt1, int paramInt2)
  {
    e();
    int i1 = getMaxTextLength();
    if (i1 > 0)
    {
      float f1 = (float)Math.ceil(Layout.getDesiredWidth("0", this.l));
      this.h = ((int)(i1 * f1));
      this.h += 200;
      this.i = 0;
      if ((this.q != null) && (this.q.length() > 0)) {
        this.i = ((int)Math.ceil(Layout.getDesiredWidth(this.q, this.m)));
      }
      if (paramInt2 != 1073741824) {
        break label196;
      }
      paramInt2 = 1;
    }
    for (;;)
    {
      label103:
      if (paramInt2 != 0)
      {
        paramInt2 = paramInt1 - 8;
        if (paramInt2 <= 0)
        {
          this.i = 0;
          this.h = 0;
        }
        if (this.i <= 0) {
          break label254;
        }
        this.h = ((int)(this.h * paramInt2 / (this.h + this.i)));
        this.i = (paramInt2 - this.h);
      }
      for (;;)
      {
        if (this.h > 0) {
          c(this.h, this.i);
        }
        return paramInt1;
        this.h = 0;
        break;
        label196:
        int i2 = this.h + this.i;
        i1 = i2;
        if (this.i > 0) {
          i1 = i2 + 8;
        }
        i1 = Math.max(i1, getSuggestedMinimumWidth());
        if ((paramInt2 != Integer.MIN_VALUE) || (paramInt1 >= i1)) {
          break label265;
        }
        paramInt2 = 1;
        break label103;
        label254:
        this.h = (paramInt2 + 8);
      }
      label265:
      paramInt1 = i1;
      paramInt2 = 0;
    }
  }
  
  private void b(int paramInt)
  {
    this.t += paramInt;
    int i1 = this.t / getItemHeight();
    int i2 = this.g - i1;
    if ((this.a) && (this.f.getItemsCount() > 0))
    {
      while (i2 < 0) {
        i2 += this.f.getItemsCount();
      }
      paramInt = i2 % this.f.getItemsCount();
      i2 = this.t;
      if (paramInt == this.g) {
        break label229;
      }
      setCurrentItem(paramInt, false);
    }
    for (;;)
    {
      this.t = (i2 - getItemHeight() * i1);
      if (this.t > getHeight()) {
        this.t = (this.t % getHeight() + getHeight());
      }
      return;
      if (this.s)
      {
        if (i2 < 0)
        {
          i1 = this.g;
          paramInt = 0;
          break;
        }
        paramInt = i2;
        if (i2 < this.f.getItemsCount()) {
          break;
        }
        i1 = this.g - this.f.getItemsCount() + 1;
        paramInt = this.f.getItemsCount() - 1;
        break;
      }
      paramInt = Math.min(Math.max(i2, 0), this.f.getItemsCount() - 1);
      break;
      label229:
      invalidate();
    }
  }
  
  private void b(Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.translate(0.0F, -this.n.getLineTop(1) + this.t);
    this.l.setColor(-7829368);
    this.l.drawableState = getDrawableState();
    this.n.draw(paramCanvas);
    paramCanvas.restore();
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    Object localObject2;
    Object localObject1;
    if ((this.n == null) || (this.n.getWidth() > paramInt1))
    {
      localObject2 = a(this.s);
      TextPaint localTextPaint = this.l;
      if (paramInt2 > 0)
      {
        localObject1 = Layout.Alignment.ALIGN_OPPOSITE;
        this.n = new StaticLayout((CharSequence)localObject2, localTextPaint, paramInt1, (Layout.Alignment)localObject1, 1.0F, c, false);
        label65:
        if ((this.s) || ((this.p != null) && (this.p.getWidth() <= paramInt1))) {
          break label243;
        }
        if (getAdapter() == null) {
          break label223;
        }
        localObject1 = getAdapter().getItem(this.g);
        label111:
        if (localObject1 == null) {
          break label228;
        }
        label115:
        localTextPaint = this.m;
        if (paramInt2 <= 0) {
          break label235;
        }
        localObject2 = Layout.Alignment.ALIGN_OPPOSITE;
        label130:
        this.p = new StaticLayout((CharSequence)localObject1, localTextPaint, paramInt1, (Layout.Alignment)localObject2, 1.0F, c, false);
      }
    }
    for (;;)
    {
      if (paramInt2 > 0)
      {
        if ((this.o != null) && (this.o.getWidth() <= paramInt2)) {
          break label269;
        }
        this.o = new StaticLayout(this.q, this.m, paramInt2, Layout.Alignment.ALIGN_NORMAL, 1.0F, c, false);
      }
      return;
      localObject1 = Layout.Alignment.ALIGN_CENTER;
      break;
      this.n.increaseWidthTo(paramInt1);
      break label65;
      label223:
      localObject1 = null;
      break label111;
      label228:
      localObject1 = "";
      break label115;
      label235:
      localObject2 = Layout.Alignment.ALIGN_CENTER;
      break label130;
      label243:
      if (this.s) {
        this.p = null;
      } else {
        this.p.increaseWidthTo(paramInt1);
      }
    }
    label269:
    this.o.increaseWidthTo(paramInt2);
  }
  
  private void c(Canvas paramCanvas)
  {
    int i1 = getHeight() / 2;
    int i2 = getItemHeight() / 2;
    this.r.setBounds(0, i1 - i2, getWidth(), i1 + i2);
    this.r.draw(paramCanvas);
  }
  
  private void d()
  {
    this.n = null;
    this.p = null;
    this.t = 0;
  }
  
  private void e()
  {
    if (this.l == null)
    {
      this.l = new TextPaint(1);
      this.l.setTextSize(d);
    }
    if (this.m == null)
    {
      this.m = new TextPaint(5);
      this.m.setTextSize(d);
      this.m.setShadowLayer(0.1F, 0.0F, 0.1F, -4144960);
    }
    if (this.r == null) {
      this.r = getContext().getResources().getDrawable(2130838575);
    }
  }
  
  private void f()
  {
    this.C.removeMessages(0);
    this.C.removeMessages(1);
  }
  
  private void g()
  {
    if (this.f == null) {
      return;
    }
    this.w = 0;
    int i3 = this.t;
    int i4 = getItemHeight();
    int i1;
    if (i3 > 0) {
      if (this.g < this.f.getItemsCount())
      {
        i1 = 1;
        if (!this.a)
        {
          i2 = i3;
          if (i1 == 0) {}
        }
        else
        {
          i2 = i3;
          if (Math.abs(i3) > i4 / 2.0F) {
            if (i3 >= 0) {
              break label136;
            }
          }
        }
      }
    }
    label136:
    for (int i2 = i3 + (i4 + 1);; i2 = i3 - (i4 + 1))
    {
      if (Math.abs(i2) <= 1) {
        break label146;
      }
      this.v.startScroll(0, 0, 0, i2, 400);
      setNextMessage(1);
      return;
      i1 = 0;
      break;
      if (this.g > 0)
      {
        i1 = 1;
        break;
      }
      i1 = 0;
      break;
    }
    label146:
    c();
  }
  
  private int getItemHeight()
  {
    if (this.k != 0) {
      return this.k;
    }
    if ((this.n != null) && (this.n.getLineCount() > 2))
    {
      this.k = (this.n.getLineTop(2) - this.n.getLineTop(1));
      return this.k;
    }
    return getHeight() / this.j;
  }
  
  private int getMaxTextLength()
  {
    c localc = getAdapter();
    if (localc == null) {
      return 0;
    }
    int i1 = localc.getMaximumLength();
    if (i1 > 0) {
      return i1;
    }
    i1 = this.j / 2;
    i1 = Math.max(this.g - i1, 0);
    Object localObject2;
    for (Object localObject1 = null; i1 < Math.min(this.g + this.j, localc.getItemsCount()); localObject1 = localObject2)
    {
      String str = localc.getItem(i1);
      localObject2 = localObject1;
      if (str != null) {
        if (localObject1 != null)
        {
          localObject2 = localObject1;
          if (((String)localObject1).length() >= str.length()) {}
        }
        else
        {
          localObject2 = str;
        }
      }
      i1 += 1;
    }
    if (localObject1 != null) {}
    for (i1 = ((String)localObject1).length();; i1 = 0) {
      return i1;
    }
  }
  
  private void h()
  {
    if (!this.s)
    {
      this.s = true;
      a();
    }
  }
  
  private void setNextMessage(int paramInt)
  {
    f();
    this.C.sendEmptyMessage(paramInt);
  }
  
  protected void a()
  {
    Iterator localIterator = this.y.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).onScrollingStarted(this);
    }
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.x.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).onChanged(this, paramInt1, paramInt2);
    }
  }
  
  public void addChangingListener(a parama)
  {
    this.x.add(parama);
  }
  
  public void addScrollingListener(b paramb)
  {
    this.y.add(paramb);
  }
  
  protected void b()
  {
    Iterator localIterator = this.y.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).onScrollingFinished(this);
    }
  }
  
  void c()
  {
    if (this.s)
    {
      b();
      this.s = false;
    }
    d();
    invalidate();
  }
  
  public c getAdapter()
  {
    return this.f;
  }
  
  public int getCurrentItem()
  {
    return this.g;
  }
  
  public String getLabel()
  {
    return this.q;
  }
  
  public int getVisibleItems()
  {
    return this.j;
  }
  
  public boolean isCyclic()
  {
    return this.a;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.n == null)
    {
      if (this.h != 0) {
        break label73;
      }
      b(getWidth(), 1073741824);
    }
    for (;;)
    {
      if (this.h > 0)
      {
        paramCanvas.save();
        paramCanvas.translate(0.0F, -e);
        b(paramCanvas);
        a(paramCanvas);
        paramCanvas.restore();
      }
      c(paramCanvas);
      return;
      label73:
      c(this.h, this.i);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    postInvalidate();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i2 = View.MeasureSpec.getMode(paramInt1);
    int i1 = View.MeasureSpec.getMode(paramInt2);
    int i3 = View.MeasureSpec.getSize(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt2);
    i2 = b(i3, i2);
    if (i1 == 1073741824) {}
    for (;;)
    {
      setMeasuredDimension(i2, paramInt1);
      return;
      paramInt2 = a(this.n);
      if (i1 == Integer.MIN_VALUE) {
        paramInt1 = Math.min(paramInt2, paramInt1);
      } else {
        paramInt1 = paramInt2;
      }
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    postInvalidate();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (getAdapter() == null) {}
    while ((this.u.onTouchEvent(paramMotionEvent)) || (paramMotionEvent.getAction() != 1)) {
      return true;
    }
    g();
    return true;
  }
  
  public void removeChangingListener(a parama)
  {
    this.x.remove(parama);
  }
  
  public void removeScrollingListener(b paramb)
  {
    this.y.remove(paramb);
  }
  
  public void scroll(int paramInt1, int paramInt2)
  {
    this.v.forceFinished(true);
    this.w = this.t;
    int i1 = getItemHeight();
    this.v.startScroll(0, this.w, 0, paramInt1 * i1 - this.w, paramInt2);
    setNextMessage(0);
    h();
  }
  
  public void setAdapter(c paramc)
  {
    this.f = paramc;
    d();
    invalidate();
  }
  
  public void setCurrentItem(int paramInt)
  {
    setCurrentItem(paramInt, false);
  }
  
  public void setCurrentItem(int paramInt, boolean paramBoolean)
  {
    if ((this.f == null) || (this.f.getItemsCount() == 0)) {}
    int i1;
    do
    {
      do
      {
        return;
        if (paramInt >= 0)
        {
          i1 = paramInt;
          if (paramInt < this.f.getItemsCount()) {
            break;
          }
        }
      } while (!this.a);
      while (paramInt < 0) {
        paramInt += this.f.getItemsCount();
      }
      i1 = paramInt % this.f.getItemsCount();
    } while (i1 == this.g);
    if (paramBoolean)
    {
      scroll(i1 - this.g, 400);
      return;
    }
    d();
    paramInt = this.g;
    this.g = i1;
    a(paramInt, this.g);
    invalidate();
  }
  
  public void setCyclic(boolean paramBoolean)
  {
    this.a = paramBoolean;
    invalidate();
    d();
  }
  
  public void setInterpolator(Interpolator paramInterpolator)
  {
    this.v.forceFinished(true);
    this.v = new Scroller(getContext(), paramInterpolator);
  }
  
  public void setLabel(String paramString)
  {
    if ((this.q == null) || (!this.q.equals(paramString)))
    {
      this.q = paramString;
      this.o = null;
      invalidate();
    }
  }
  
  public void setVisibleItems(int paramInt)
  {
    this.j = paramInt;
    invalidate();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/pay/huifu/views/wheelview/WheelView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */