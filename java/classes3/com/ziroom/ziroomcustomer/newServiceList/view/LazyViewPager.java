package com.ziroom.ziroomcustomer.newServiceList.view;

import android.content.Context;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.v4.os.ParcelableCompat;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;
import android.support.v4.view.KeyEventCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.VelocityTrackerCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v4.widget.EdgeEffectCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class LazyViewPager
  extends ViewGroup
{
  private static final Comparator<a> a = new Comparator()
  {
    public int compare(LazyViewPager.a paramAnonymousa1, LazyViewPager.a paramAnonymousa2)
    {
      return paramAnonymousa1.b - paramAnonymousa2.b;
    }
  };
  private static final Interpolator b = new Interpolator()
  {
    public float getInterpolation(float paramAnonymousFloat)
    {
      paramAnonymousFloat -= 1.0F;
      return paramAnonymousFloat * (paramAnonymousFloat * paramAnonymousFloat) + 1.0F;
    }
  };
  private VelocityTracker A;
  private int B;
  private int C;
  private float D;
  private float E;
  private boolean F;
  private long G;
  private EdgeEffectCompat H;
  private EdgeEffectCompat I;
  private boolean J = true;
  private b K;
  private int L = 0;
  private final ArrayList<a> c = new ArrayList();
  private PagerAdapter d;
  private int e;
  private int f = -1;
  private Parcelable g = null;
  private ClassLoader h = null;
  private Scroller i;
  private c j;
  private int k;
  private Drawable l;
  private int m;
  private int n;
  private boolean o;
  private boolean p;
  private boolean q;
  private boolean r;
  private int s = 0;
  private boolean t;
  private boolean u;
  private int v;
  private float w;
  private float x;
  private float y;
  private int z = -1;
  
  public LazyViewPager(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public LazyViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt1 += paramInt3;
    if (paramInt2 > 0)
    {
      paramInt3 = getScrollX();
      paramInt2 += paramInt4;
      paramInt4 = paramInt3 / paramInt2;
      paramInt2 = (int)((paramInt3 % paramInt2 / paramInt2 + paramInt4) * paramInt1);
      scrollTo(paramInt2, getScrollY());
      if (!this.i.isFinished())
      {
        paramInt3 = this.i.getDuration();
        paramInt4 = this.i.timePassed();
        this.i.startScroll(paramInt2, 0, paramInt1 * this.e, 0, paramInt3 - paramInt4);
      }
    }
    do
    {
      return;
      paramInt1 = this.e * paramInt1;
    } while (paramInt1 == getScrollX());
    f();
    scrollTo(paramInt1, getScrollY());
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    int i1 = MotionEventCompat.getActionIndex(paramMotionEvent);
    if (MotionEventCompat.getPointerId(paramMotionEvent, i1) == this.z) {
      if (i1 != 0) {
        break label56;
      }
    }
    label56:
    for (i1 = 1;; i1 = 0)
    {
      this.x = MotionEventCompat.getX(paramMotionEvent, i1);
      this.z = MotionEventCompat.getPointerId(paramMotionEvent, i1);
      if (this.A != null) {
        this.A.clear();
      }
      return;
    }
  }
  
  private void f()
  {
    boolean bool = this.r;
    if (bool)
    {
      setScrollingCacheEnabled(false);
      this.i.abortAnimation();
      i1 = getScrollX();
      int i2 = getScrollY();
      int i3 = this.i.getCurrX();
      int i4 = this.i.getCurrY();
      if ((i1 != i3) || (i2 != i4)) {
        scrollTo(i3, i4);
      }
      setScrollState(0);
    }
    this.q = false;
    this.r = false;
    int i1 = 0;
    while (i1 < this.c.size())
    {
      a locala = (a)this.c.get(i1);
      if (locala.c)
      {
        bool = true;
        locala.c = false;
      }
      i1 += 1;
    }
    if (bool) {
      c();
    }
  }
  
  private void g()
  {
    this.t = false;
    this.u = false;
    if (this.A != null)
    {
      this.A.recycle();
      this.A = null;
    }
  }
  
  private void setScrollState(int paramInt)
  {
    if (this.L == paramInt) {}
    do
    {
      return;
      this.L = paramInt;
    } while (this.K == null);
    this.K.onPageScrollStateChanged(paramInt);
  }
  
  private void setScrollingCacheEnabled(boolean paramBoolean)
  {
    if (this.p != paramBoolean) {
      this.p = paramBoolean;
    }
  }
  
  a a(View paramView)
  {
    int i1 = 0;
    while (i1 < this.c.size())
    {
      a locala = (a)this.c.get(i1);
      if (this.d.isViewFromObject(paramView, locala.a)) {
        return locala;
      }
      i1 += 1;
    }
    return null;
  }
  
  void a()
  {
    setWillNotDraw(false);
    setDescendantFocusability(262144);
    setFocusable(true);
    Context localContext = getContext();
    this.i = new Scroller(localContext, b);
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(localContext);
    this.v = ViewConfigurationCompat.getScaledPagingTouchSlop(localViewConfiguration);
    this.B = localViewConfiguration.getScaledMinimumFlingVelocity();
    this.C = localViewConfiguration.getScaledMaximumFlingVelocity();
    this.H = new EdgeEffectCompat(localContext);
    this.I = new EdgeEffectCompat(localContext);
    this.D = (localContext.getResources().getDisplayMetrics().density * 2500.0F);
    this.E = 0.4F;
  }
  
  void a(int paramInt1, int paramInt2)
  {
    a locala = new a();
    locala.b = paramInt1;
    locala.a = this.d.instantiateItem(this, paramInt1);
    if (paramInt2 < 0)
    {
      this.c.add(locala);
      return;
    }
    this.c.add(paramInt2, locala);
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (getChildCount() == 0)
    {
      setScrollingCacheEnabled(false);
      return;
    }
    int i1 = getScrollX();
    int i2 = getScrollY();
    int i3 = paramInt1 - i1;
    paramInt2 -= i2;
    if ((i3 == 0) && (paramInt2 == 0))
    {
      f();
      setScrollState(0);
      return;
    }
    setScrollingCacheEnabled(true);
    this.r = true;
    setScrollState(2);
    paramInt1 = (int)(Math.abs(i3) / (getWidth() + this.k) * 100.0F);
    paramInt3 = Math.abs(paramInt3);
    if (paramInt3 > 0)
    {
      float f1 = paramInt1;
      paramInt1 = (int)(paramInt1 / (paramInt3 / this.D) * this.E + f1);
    }
    for (;;)
    {
      paramInt1 = Math.min(paramInt1, 600);
      this.i.startScroll(i1, i2, i3, paramInt2, paramInt1);
      invalidate();
      return;
      paramInt1 += 100;
    }
  }
  
  void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramInt, paramBoolean1, paramBoolean2, 0);
  }
  
  void a(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    if ((this.d == null) || (this.d.getCount() <= 0))
    {
      setScrollingCacheEnabled(false);
      return;
    }
    if ((!paramBoolean2) && (this.e == paramInt1) && (this.c.size() != 0))
    {
      setScrollingCacheEnabled(false);
      return;
    }
    int i1;
    if (paramInt1 < 0) {
      i1 = 0;
    }
    for (;;)
    {
      paramInt1 = this.s;
      if ((i1 <= this.e + paramInt1) && (i1 >= this.e - paramInt1)) {
        break;
      }
      paramInt1 = 0;
      while (paramInt1 < this.c.size())
      {
        ((a)this.c.get(paramInt1)).c = true;
        paramInt1 += 1;
      }
      i1 = paramInt1;
      if (paramInt1 >= this.d.getCount()) {
        i1 = this.d.getCount() - 1;
      }
    }
    if (this.e != i1) {}
    int i2;
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      this.e = i1;
      c();
      i2 = (getWidth() + this.k) * i1;
      if (!paramBoolean1) {
        break label224;
      }
      a(i2, 0, paramInt2);
      if ((paramInt1 == 0) || (this.K == null)) {
        break;
      }
      this.K.onPageSelected(i1);
      return;
    }
    label224:
    if ((paramInt1 != 0) && (this.K != null)) {
      this.K.onPageSelected(i1);
    }
    f();
    scrollTo(i2, 0);
  }
  
  protected boolean a(View paramView, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    int i1;
    if ((paramView instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      int i2 = paramView.getScrollX();
      int i3 = paramView.getScrollY();
      i1 = localViewGroup.getChildCount() - 1;
      if (i1 >= 0)
      {
        localView = localViewGroup.getChildAt(i1);
        if ((paramInt2 + i2 < localView.getLeft()) || (paramInt2 + i2 >= localView.getRight()) || (paramInt3 + i3 < localView.getTop()) || (paramInt3 + i3 >= localView.getBottom()) || (!a(localView, true, paramInt1, paramInt2 + i2 - localView.getLeft(), paramInt3 + i3 - localView.getTop()))) {}
      }
    }
    while ((paramBoolean) && (ViewCompat.canScrollHorizontally(paramView, -paramInt1)))
    {
      View localView;
      return true;
      i1 -= 1;
      break;
    }
    return false;
  }
  
  public void addFocusables(ArrayList<View> paramArrayList, int paramInt1, int paramInt2)
  {
    int i2 = paramArrayList.size();
    int i3 = getDescendantFocusability();
    if (i3 != 393216)
    {
      int i1 = 0;
      while (i1 < getChildCount())
      {
        View localView = getChildAt(i1);
        if (localView.getVisibility() == 0)
        {
          a locala = a(localView);
          if ((locala != null) && (locala.b == this.e)) {
            localView.addFocusables(paramArrayList, paramInt1, paramInt2);
          }
        }
        i1 += 1;
      }
    }
    if (((i3 == 262144) && (i2 != paramArrayList.size())) || (!isFocusable())) {}
    while ((((paramInt2 & 0x1) == 1) && (isInTouchMode()) && (!isFocusableInTouchMode())) || (paramArrayList == null)) {
      return;
    }
    paramArrayList.add(this);
  }
  
  public void addTouchables(ArrayList<View> paramArrayList)
  {
    int i1 = 0;
    while (i1 < getChildCount())
    {
      View localView = getChildAt(i1);
      if (localView.getVisibility() == 0)
      {
        a locala = a(localView);
        if ((locala != null) && (locala.b == this.e)) {
          localView.addTouchables(paramArrayList);
        }
      }
      i1 += 1;
    }
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (this.o)
    {
      addViewInLayout(paramView, paramInt, paramLayoutParams);
      paramView.measure(this.m, this.n);
      return;
    }
    super.addView(paramView, paramInt, paramLayoutParams);
  }
  
  public boolean arrowScroll(int paramInt)
  {
    View localView2 = findFocus();
    View localView1 = localView2;
    if (localView2 == this) {
      localView1 = null;
    }
    localView2 = FocusFinder.getInstance().findNextFocus(this, localView1, paramInt);
    boolean bool;
    if ((localView2 != null) && (localView2 != localView1)) {
      if (paramInt == 17) {
        if ((localView1 != null) && (localView2.getLeft() >= localView1.getLeft())) {
          bool = d();
        }
      }
    }
    for (;;)
    {
      if (bool) {
        playSoundEffect(SoundEffectConstants.getContantForFocusDirection(paramInt));
      }
      return bool;
      bool = localView2.requestFocus();
      continue;
      if (paramInt == 66)
      {
        if ((localView1 != null) && (localView2.getLeft() <= localView1.getLeft()))
        {
          bool = e();
          continue;
        }
        bool = localView2.requestFocus();
        continue;
        if ((paramInt == 17) || (paramInt == 1))
        {
          bool = d();
          continue;
        }
        if ((paramInt == 66) || (paramInt == 2))
        {
          bool = e();
          continue;
        }
      }
      bool = false;
    }
  }
  
  a b(View paramView)
  {
    for (;;)
    {
      ViewParent localViewParent = paramView.getParent();
      if (localViewParent == this) {
        break;
      }
      if ((localViewParent == null) || (!(localViewParent instanceof View))) {
        return null;
      }
      paramView = (View)localViewParent;
    }
    return a(paramView);
  }
  
  void b()
  {
    int i4 = 1;
    int i1;
    int i3;
    int i5;
    int i2;
    label43:
    a locala;
    if ((this.c.size() < 3) && (this.c.size() < this.d.getCount()))
    {
      i1 = 1;
      i3 = 0;
      i5 = -1;
      i2 = i1;
      i1 = i5;
      if (i3 >= this.c.size()) {
        break label212;
      }
      locala = (a)this.c.get(i3);
      i5 = this.d.getItemPosition(locala.a);
      if (i5 != -1) {
        break label99;
      }
    }
    for (;;)
    {
      i3 += 1;
      break label43;
      i1 = 0;
      break;
      label99:
      if (i5 == -2)
      {
        this.c.remove(i3);
        i3 -= 1;
        this.d.destroyItem(this, locala.b, locala.a);
        if (this.e == locala.b)
        {
          i1 = Math.max(0, Math.min(this.e, this.d.getCount() - 1));
          i2 = 1;
        }
      }
      else
      {
        if (locala.b != i5)
        {
          if (locala.b == this.e) {
            i1 = i5;
          }
          locala.b = i5;
          i2 = 1;
          continue;
          label212:
          Collections.sort(this.c, a);
          if (i1 >= 0) {
            a(i1, false, true);
          }
          for (i1 = i4;; i1 = i2)
          {
            if (i1 != 0)
            {
              c();
              requestLayout();
            }
            return;
          }
        }
        continue;
      }
      i2 = 1;
    }
  }
  
  public boolean beginFakeDrag()
  {
    if (this.t) {
      return false;
    }
    this.F = true;
    setScrollState(1);
    this.x = 0.0F;
    this.w = 0.0F;
    if (this.A == null) {
      this.A = VelocityTracker.obtain();
    }
    for (;;)
    {
      long l1 = SystemClock.uptimeMillis();
      MotionEvent localMotionEvent = MotionEvent.obtain(l1, l1, 0, 0.0F, 0.0F, 0);
      this.A.addMovement(localMotionEvent);
      localMotionEvent.recycle();
      this.G = l1;
      return true;
      this.A.clear();
    }
  }
  
  void c()
  {
    a locala = null;
    int i6 = 0;
    if (this.d == null)
    {
      break label13;
      break label13;
    }
    label13:
    while ((this.q) || (getWindowToken() == null)) {
      return;
    }
    this.d.startUpdate(this);
    int i1 = this.s;
    int i5 = Math.max(0, this.e - i1);
    int i7 = Math.min(this.d.getCount() - 1, i1 + this.e);
    i1 = 0;
    int i2 = -1;
    label77:
    Object localObject1;
    if (i1 < this.c.size())
    {
      localObject1 = (a)this.c.get(i1);
      if (((((a)localObject1).b < i5) || (((a)localObject1).b > i7)) && (!((a)localObject1).c))
      {
        this.c.remove(i1);
        this.d.destroyItem(this, ((a)localObject1).b, ((a)localObject1).a);
        i1 -= 1;
      }
    }
    for (;;)
    {
      i2 = ((a)localObject1).b;
      i1 += 1;
      break label77;
      int i4 = i1;
      if (i2 < i7)
      {
        i4 = i1;
        if (((a)localObject1).b > i5)
        {
          i4 = i2 + 1;
          i2 = i1;
          int i3 = i4;
          if (i4 < i5)
          {
            i3 = i5;
            i2 = i1;
          }
          for (;;)
          {
            i4 = i2;
            if (i3 > i7) {
              break;
            }
            i4 = i2;
            if (i3 >= ((a)localObject1).b) {
              break;
            }
            a(i3, i2);
            i3 += 1;
            i2 += 1;
          }
          if (this.c.size() > 0)
          {
            i1 = ((a)this.c.get(this.c.size() - 1)).b;
            if (i1 >= i7) {
              break label334;
            }
            i1 += 1;
            if (i1 <= i5) {
              break label328;
            }
          }
          for (;;)
          {
            if (i1 > i7) {
              break label334;
            }
            a(i1, -1);
            i1 += 1;
            continue;
            i1 = -1;
            break;
            label328:
            i1 = i5;
          }
          label334:
          i1 = 0;
          label336:
          if (i1 < this.c.size()) {
            if (((a)this.c.get(i1)).b != this.e) {}
          }
          for (localObject1 = (a)this.c.get(i1);; localObject1 = null)
          {
            Object localObject2 = this.d;
            i1 = this.e;
            if (localObject1 != null) {}
            for (localObject1 = ((a)localObject1).a;; localObject1 = null)
            {
              ((PagerAdapter)localObject2).setPrimaryItem(this, i1, localObject1);
              this.d.finishUpdate(this);
              if (!hasFocus()) {
                break;
              }
              localObject2 = findFocus();
              localObject1 = locala;
              if (localObject2 != null) {
                localObject1 = b((View)localObject2);
              }
              i1 = i6;
              if (localObject1 != null)
              {
                if (((a)localObject1).b == this.e) {
                  break;
                }
                i1 = i6;
              }
              for (;;)
              {
                if (i1 >= getChildCount()) {
                  break label528;
                }
                localObject1 = getChildAt(i1);
                locala = a((View)localObject1);
                if ((locala != null) && (locala.b == this.e) && (((View)localObject1).requestFocus(2))) {
                  break;
                }
                i1 += 1;
              }
              label528:
              break label13;
              i1 += 1;
              break label336;
            }
          }
        }
      }
      i1 = i4;
    }
  }
  
  public void computeScroll()
  {
    if ((!this.i.isFinished()) && (this.i.computeScrollOffset()))
    {
      int i2 = getScrollX();
      int i3 = getScrollY();
      int i1 = this.i.getCurrX();
      int i4 = this.i.getCurrY();
      if ((i2 != i1) || (i3 != i4)) {
        scrollTo(i1, i4);
      }
      if (this.K != null)
      {
        i2 = getWidth() + this.k;
        i3 = i1 / i2;
        i1 %= i2;
        float f1 = i1 / i2;
        this.K.onPageScrolled(i3, f1, i1);
      }
      invalidate();
      return;
    }
    f();
  }
  
  boolean d()
  {
    if (this.e > 0)
    {
      setCurrentItem(this.e - 1, true);
      return true;
    }
    return false;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return (super.dispatchKeyEvent(paramKeyEvent)) || (executeKeyEvent(paramKeyEvent));
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    boolean bool2 = false;
    int i2 = getChildCount();
    int i1 = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i1 < i2)
      {
        View localView = getChildAt(i1);
        if (localView.getVisibility() == 0)
        {
          a locala = a(localView);
          if ((locala != null) && (locala.b == this.e) && (localView.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent))) {
            bool1 = true;
          }
        }
      }
      else
      {
        return bool1;
      }
      i1 += 1;
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    int i4 = 1;
    super.draw(paramCanvas);
    int i3 = 0;
    int i1 = 0;
    int i5 = ViewCompat.getOverScrollMode(this);
    boolean bool;
    if ((i5 == 0) || ((i5 == 1) && (this.d != null) && (this.d.getCount() > 1)))
    {
      int i2;
      if (!this.H.isFinished())
      {
        i3 = paramCanvas.save();
        i1 = getHeight() - getPaddingTop() - getPaddingBottom();
        paramCanvas.rotate(270.0F);
        paramCanvas.translate(-i1 + getPaddingTop(), 0.0F);
        this.H.setSize(i1, getWidth());
        i2 = false | this.H.draw(paramCanvas);
        paramCanvas.restoreToCount(i3);
      }
      i3 = i2;
      if (!this.I.isFinished())
      {
        i5 = paramCanvas.save();
        int i6 = getWidth();
        int i7 = getHeight();
        int i8 = getPaddingTop();
        int i9 = getPaddingBottom();
        i3 = i4;
        if (this.d != null) {
          i3 = this.d.getCount();
        }
        paramCanvas.rotate(90.0F);
        paramCanvas.translate(-getPaddingTop(), -i3 * (this.k + i6) + this.k);
        this.I.setSize(i7 - i8 - i9, i6);
        bool = i2 | this.I.draw(paramCanvas);
        paramCanvas.restoreToCount(i5);
      }
    }
    for (;;)
    {
      if (bool) {
        invalidate();
      }
      return;
      this.H.finish();
      this.I.finish();
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    Drawable localDrawable = this.l;
    if ((localDrawable != null) && (localDrawable.isStateful())) {
      localDrawable.setState(getDrawableState());
    }
  }
  
  boolean e()
  {
    if ((this.d != null) && (this.e < this.d.getCount() - 1))
    {
      setCurrentItem(this.e + 1, true);
      return true;
    }
    return false;
  }
  
  public void endFakeDrag()
  {
    if (!this.F) {
      throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    }
    VelocityTracker localVelocityTracker = this.A;
    localVelocityTracker.computeCurrentVelocity(1000, this.C);
    int i1 = (int)VelocityTrackerCompat.getYVelocity(localVelocityTracker, this.z);
    this.q = true;
    if ((Math.abs(i1) > this.B) || (Math.abs(this.w - this.x) >= getWidth() / 3)) {
      if (this.x > this.w) {
        a(this.e - 1, true, true);
      }
    }
    for (;;)
    {
      g();
      this.F = false;
      return;
      a(this.e + 1, true, true);
      continue;
      a(this.e, true, true);
    }
  }
  
  public boolean executeKeyEvent(KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getAction() == 0) {
      switch (paramKeyEvent.getKeyCode())
      {
      }
    }
    do
    {
      return false;
      return arrowScroll(17);
      return arrowScroll(66);
      if (KeyEventCompat.hasNoModifiers(paramKeyEvent)) {
        return arrowScroll(2);
      }
    } while (!KeyEventCompat.hasModifiers(paramKeyEvent, 1));
    return arrowScroll(1);
  }
  
  public void fakeDragBy(float paramFloat)
  {
    if (!this.F) {
      throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    }
    this.x += paramFloat;
    paramFloat = getScrollX() - paramFloat;
    int i1 = getWidth() + this.k;
    float f1 = Math.max(0, (this.e - 1) * i1);
    float f2 = Math.min(this.e + 1, this.d.getCount() - 1) * i1;
    if (paramFloat < f1) {
      paramFloat = f1;
    }
    for (;;)
    {
      this.x += paramFloat - (int)paramFloat;
      scrollTo((int)paramFloat, getScrollY());
      if (this.K != null)
      {
        int i2 = (int)paramFloat / i1;
        int i3 = (int)paramFloat % i1;
        paramFloat = i3 / i1;
        this.K.onPageScrolled(i2, paramFloat, i3);
      }
      long l1 = SystemClock.uptimeMillis();
      MotionEvent localMotionEvent = MotionEvent.obtain(this.G, l1, 2, this.x, 0.0F, 0);
      this.A.addMovement(localMotionEvent);
      localMotionEvent.recycle();
      return;
      if (paramFloat > f2) {
        paramFloat = f2;
      }
    }
  }
  
  public PagerAdapter getAdapter()
  {
    return this.d;
  }
  
  public int getCurrentItem()
  {
    return this.e;
  }
  
  public int getOffscreenPageLimit()
  {
    return this.s;
  }
  
  public int getPageMargin()
  {
    return this.k;
  }
  
  public boolean isFakeDragging()
  {
    return this.F;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.J = true;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.k > 0) && (this.l != null))
    {
      int i1 = getScrollX();
      int i2 = getWidth();
      int i3 = i1 % (this.k + i2);
      if (i3 != 0)
      {
        i1 = i1 - i3 + i2;
        this.l.setBounds(i1, 0, this.k + i1, getHeight());
        this.l.draw(paramCanvas);
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction() & 0xFF;
    if ((i1 == 3) || (i1 == 1))
    {
      this.t = false;
      this.u = false;
      this.z = -1;
    }
    do
    {
      return false;
      if (i1 == 0) {
        break;
      }
      if (this.t) {
        return true;
      }
    } while (this.u);
    switch (i1)
    {
    }
    for (;;)
    {
      return this.t;
      i1 = this.z;
      if (i1 != -1)
      {
        i1 = MotionEventCompat.findPointerIndex(paramMotionEvent, i1);
        float f1 = MotionEventCompat.getX(paramMotionEvent, i1);
        float f2 = f1 - this.x;
        float f3 = Math.abs(f2);
        float f4 = MotionEventCompat.getY(paramMotionEvent, i1);
        float f5 = Math.abs(f4 - this.y);
        i1 = getScrollX();
        if (((f2 > 0.0F) && (i1 == 0)) || ((f2 >= 0.0F) || (this.d == null) || (i1 < (this.d.getCount() - 1) * getWidth() - 1)) || (a(this, false, (int)f2, (int)f1, (int)f4)))
        {
          this.x = f1;
          this.w = f1;
          this.y = f4;
          return false;
        }
        if ((f3 > this.v) && (f3 > f5))
        {
          this.t = true;
          setScrollState(1);
          this.x = f1;
          setScrollingCacheEnabled(true);
        }
        else if (f5 > this.v)
        {
          this.u = true;
          continue;
          f1 = paramMotionEvent.getX();
          this.w = f1;
          this.x = f1;
          this.y = paramMotionEvent.getY();
          this.z = MotionEventCompat.getPointerId(paramMotionEvent, 0);
          if (this.L == 2)
          {
            this.t = true;
            this.u = false;
            setScrollState(1);
          }
          else
          {
            f();
            this.t = false;
            this.u = false;
            continue;
            a(paramMotionEvent);
          }
        }
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.o = true;
    c();
    this.o = false;
    paramInt4 = getChildCount();
    paramInt2 = 0;
    while (paramInt2 < paramInt4)
    {
      View localView = getChildAt(paramInt2);
      if (localView.getVisibility() != 8)
      {
        a locala = a(localView);
        if (locala != null)
        {
          int i1 = this.k;
          i1 = locala.b * (i1 + (paramInt3 - paramInt1)) + getPaddingLeft();
          int i2 = getPaddingTop();
          localView.layout(i1, i2, localView.getMeasuredWidth() + i1, localView.getMeasuredHeight() + i2);
        }
      }
      paramInt2 += 1;
    }
    this.J = false;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i1 = 0;
    setMeasuredDimension(getDefaultSize(0, paramInt1), getDefaultSize(0, paramInt2));
    this.m = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), 1073741824);
    this.n = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), 1073741824);
    this.o = true;
    c();
    this.o = false;
    paramInt2 = getChildCount();
    paramInt1 = i1;
    while (paramInt1 < paramInt2)
    {
      View localView = getChildAt(paramInt1);
      if (localView.getVisibility() != 8) {
        localView.measure(this.m, this.n);
      }
      paramInt1 += 1;
    }
  }
  
  protected boolean onRequestFocusInDescendants(int paramInt, Rect paramRect)
  {
    int i3 = -1;
    int i2 = getChildCount();
    int i1;
    if ((paramInt & 0x2) != 0)
    {
      i3 = 1;
      i1 = 0;
    }
    while (i1 != i2)
    {
      View localView = getChildAt(i1);
      if (localView.getVisibility() == 0)
      {
        a locala = a(localView);
        if ((locala != null) && (locala.b == this.e) && (localView.requestFocus(paramInt, paramRect)))
        {
          return true;
          i1 = i2 - 1;
          i2 = -1;
          continue;
        }
      }
      i1 += i3;
    }
    return false;
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    if (this.d != null)
    {
      this.d.restoreState(paramParcelable.b, paramParcelable.c);
      a(paramParcelable.a, false, true);
      return;
    }
    this.f = paramParcelable.a;
    this.g = paramParcelable.b;
    this.h = paramParcelable.c;
  }
  
  public Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.a = this.e;
    if (this.d != null) {
      localSavedState.b = this.d.saveState();
    }
    return localSavedState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt1 != paramInt3) {
      a(paramInt1, paramInt3, this.k, this.k);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool5 = false;
    if (this.F) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          if (paramMotionEvent.getAction() != 0) {
            break;
          }
          bool1 = bool5;
        } while (paramMotionEvent.getEdgeFlags() != 0);
        bool1 = bool5;
      } while (this.d == null);
      bool1 = bool5;
    } while (this.d.getCount() == 0);
    if (this.A == null) {
      this.A = VelocityTracker.obtain();
    }
    this.A.addMovement(paramMotionEvent);
    boolean bool1 = bool2;
    float f1;
    int i1;
    float f2;
    float f3;
    int i2;
    int i3;
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
      bool1 = bool2;
    case 4: 
    case 0: 
    case 2: 
      do
      {
        for (;;)
        {
          if (bool1) {
            invalidate();
          }
          return true;
          f();
          f1 = paramMotionEvent.getX();
          this.w = f1;
          this.x = f1;
          this.z = MotionEventCompat.getPointerId(paramMotionEvent, 0);
          bool1 = bool2;
        }
        if (!this.t)
        {
          i1 = MotionEventCompat.findPointerIndex(paramMotionEvent, this.z);
          f1 = MotionEventCompat.getX(paramMotionEvent, i1);
          f2 = Math.abs(f1 - this.x);
          f3 = Math.abs(MotionEventCompat.getY(paramMotionEvent, i1) - this.y);
          if ((f2 > this.v) && (f2 > f3))
          {
            this.t = true;
            this.x = f1;
            setScrollState(1);
            setScrollingCacheEnabled(true);
          }
        }
        bool1 = bool2;
      } while (!this.t);
      f1 = MotionEventCompat.getX(paramMotionEvent, MotionEventCompat.findPointerIndex(paramMotionEvent, this.z));
      f2 = this.x;
      this.x = f1;
      f2 = getScrollX() + (f2 - f1);
      i2 = getWidth();
      i1 = i2 + this.k;
      i3 = this.d.getCount() - 1;
      f1 = Math.max(0, (this.e - 1) * i1);
      f3 = Math.min(this.e + 1, i3) * i1;
      if (f2 < f1)
      {
        bool1 = bool3;
        if (f1 == 0.0F)
        {
          f2 = -f2;
          bool1 = this.H.onPull(f2 / i2);
        }
      }
      break;
    }
    for (;;)
    {
      this.x += f1 - (int)f1;
      scrollTo((int)f1, getScrollY());
      if (this.K != null)
      {
        i2 = (int)f1 / i1;
        i3 = (int)f1 % i1;
        f1 = i3 / i1;
        this.K.onPageScrolled(i2, f1, i3);
      }
      break;
      if (f2 > f3)
      {
        bool1 = bool4;
        if (f3 == i3 * i1) {
          bool1 = this.I.onPull((f2 - f3) / i2);
        }
        f1 = f3;
        continue;
        bool1 = bool2;
        if (!this.t) {
          break;
        }
        paramMotionEvent = this.A;
        paramMotionEvent.computeCurrentVelocity(1000, this.C);
        i2 = (int)VelocityTrackerCompat.getXVelocity(paramMotionEvent, this.z);
        this.q = true;
        i1 = getWidth();
        i3 = this.k;
        i1 = getScrollX() / (i1 + i3);
        if (i2 > 0) {}
        for (;;)
        {
          a(i1, true, true, i2);
          this.z = -1;
          g();
          bool1 = this.H.onRelease() | this.I.onRelease();
          break;
          i1 += 1;
        }
        bool1 = bool2;
        if (!this.t) {
          break;
        }
        a(this.e, true, true);
        this.z = -1;
        g();
        bool1 = this.H.onRelease() | this.I.onRelease();
        break;
        i1 = MotionEventCompat.getActionIndex(paramMotionEvent);
        this.x = MotionEventCompat.getX(paramMotionEvent, i1);
        this.z = MotionEventCompat.getPointerId(paramMotionEvent, i1);
        bool1 = bool2;
        break;
        a(paramMotionEvent);
        this.x = MotionEventCompat.getX(paramMotionEvent, MotionEventCompat.findPointerIndex(paramMotionEvent, this.z));
        bool1 = bool2;
        break;
      }
      bool1 = false;
      f1 = f2;
    }
  }
  
  public void setAdapter(PagerAdapter paramPagerAdapter)
  {
    if (this.d != null)
    {
      this.d.startUpdate(this);
      int i1 = 0;
      while (i1 < this.c.size())
      {
        a locala = (a)this.c.get(i1);
        this.d.destroyItem(this, locala.b, locala.a);
        i1 += 1;
      }
      this.d.finishUpdate(this);
      this.c.clear();
      removeAllViews();
      this.e = 0;
      scrollTo(0, 0);
    }
    this.d = paramPagerAdapter;
    if (this.d != null)
    {
      if (this.j == null) {
        this.j = new c(null);
      }
      this.q = false;
      if (this.f >= 0)
      {
        this.d.restoreState(this.g, this.h);
        a(this.f, false, true);
        this.f = -1;
        this.g = null;
        this.h = null;
      }
    }
    else
    {
      return;
    }
    c();
  }
  
  public void setCurrentItem(int paramInt)
  {
    this.q = false;
    if (!this.J) {}
    for (boolean bool = true;; bool = false)
    {
      a(paramInt, bool, false);
      return;
    }
  }
  
  public void setCurrentItem(int paramInt, boolean paramBoolean)
  {
    this.q = false;
    a(paramInt, paramBoolean, false);
  }
  
  public void setOffscreenPageLimit(int paramInt)
  {
    int i1 = paramInt;
    if (paramInt < 0)
    {
      Log.w("LazyViewPager", "Requested offscreen page limit " + paramInt + " too small; defaulting to " + 0);
      i1 = 0;
    }
    if (i1 != this.s)
    {
      this.s = i1;
      c();
    }
  }
  
  public void setOnPageChangeListener(b paramb)
  {
    this.K = paramb;
  }
  
  public void setPageMargin(int paramInt)
  {
    int i1 = this.k;
    this.k = paramInt;
    int i2 = getWidth();
    a(i2, i2, paramInt, i1);
    requestLayout();
  }
  
  public void setPageMarginDrawable(int paramInt)
  {
    setPageMarginDrawable(getContext().getResources().getDrawable(paramInt));
  }
  
  public void setPageMarginDrawable(Drawable paramDrawable)
  {
    this.l = paramDrawable;
    if (paramDrawable != null) {
      refreshDrawableState();
    }
    if (paramDrawable == null) {}
    for (boolean bool = true;; bool = false)
    {
      setWillNotDraw(bool);
      invalidate();
      return;
    }
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == this.l);
  }
  
  public static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = ParcelableCompat.newCreator(new ParcelableCompatCreatorCallbacks()
    {
      public LazyViewPager.SavedState createFromParcel(Parcel paramAnonymousParcel, ClassLoader paramAnonymousClassLoader)
      {
        return new LazyViewPager.SavedState(paramAnonymousParcel, paramAnonymousClassLoader);
      }
      
      public LazyViewPager.SavedState[] newArray(int paramAnonymousInt)
      {
        return new LazyViewPager.SavedState[paramAnonymousInt];
      }
    });
    int a;
    Parcelable b;
    ClassLoader c;
    
    SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super();
      ClassLoader localClassLoader = paramClassLoader;
      if (paramClassLoader == null) {
        localClassLoader = getClass().getClassLoader();
      }
      this.a = paramParcel.readInt();
      this.b = paramParcel.readParcelable(localClassLoader);
      this.c = localClassLoader;
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public String toString()
    {
      return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.a + "}";
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.a);
      paramParcel.writeParcelable(this.b, paramInt);
    }
  }
  
  static class a
  {
    Object a;
    int b;
    boolean c;
  }
  
  public static abstract interface b
  {
    public abstract void onPageScrollStateChanged(int paramInt);
    
    public abstract void onPageScrolled(int paramInt1, float paramFloat, int paramInt2);
    
    public abstract void onPageSelected(int paramInt);
  }
  
  private class c
    extends DataSetObserver
  {
    private c() {}
    
    public void onChanged()
    {
      LazyViewPager.this.b();
    }
    
    public void onInvalidated()
    {
      LazyViewPager.this.b();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/view/LazyViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */