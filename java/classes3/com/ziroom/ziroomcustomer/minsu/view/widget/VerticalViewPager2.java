package com.ziroom.ziroomcustomer.minsu.view.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.v4.os.ParcelableCompat;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.KeyEventCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.VelocityTrackerCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.view.ViewPager.PageTransformer;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
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
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class VerticalViewPager2
  extends ViewGroup
{
  private static final int[] a = { 16842931 };
  private static final f ah = new f();
  private static final Comparator<b> c = new Comparator()
  {
    public int compare(VerticalViewPager2.b paramAnonymousb1, VerticalViewPager2.b paramAnonymousb2)
    {
      return paramAnonymousb1.b - paramAnonymousb2.b;
    }
  };
  private static final Interpolator d = new Interpolator()
  {
    public float getInterpolation(float paramAnonymousFloat)
    {
      paramAnonymousFloat -= 1.0F;
      return paramAnonymousFloat * (paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat) + 1.0F;
    }
  };
  private boolean A;
  private boolean B;
  private int C;
  private int D;
  private int E;
  private float F;
  private float G;
  private float H;
  private float I;
  private int J = -1;
  private VelocityTracker K;
  private int L;
  private int M;
  private int N;
  private int O;
  private boolean P;
  private long Q;
  private EdgeEffectCompat R;
  private EdgeEffectCompat S;
  private boolean T = true;
  private boolean U = false;
  private boolean V;
  private int W;
  private ViewPager.OnPageChangeListener aa;
  private ViewPager.OnPageChangeListener ab;
  private d ac;
  private ViewPager.PageTransformer ad;
  private Method ae;
  private int af;
  private ArrayList<View> ag;
  private final Runnable ai = new Runnable()
  {
    public void run()
    {
      VerticalViewPager2.a(VerticalViewPager2.this, 0);
      VerticalViewPager2.this.c();
    }
  };
  private int aj = 0;
  private int b;
  private final ArrayList<b> e = new ArrayList();
  private final b f = new b();
  private final Rect g = new Rect();
  private PagerAdapter h;
  private int i;
  private int j = -1;
  private Parcelable k = null;
  private ClassLoader l = null;
  private Scroller m;
  private e n;
  private int o;
  private Drawable p;
  private int q;
  private int r;
  private float s = -3.4028235E38F;
  private float t = Float.MAX_VALUE;
  private int u;
  private int v;
  private boolean w;
  private boolean x;
  private boolean y;
  private int z = 1;
  
  public VerticalViewPager2(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public VerticalViewPager2(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private int a(int paramInt1, float paramFloat, int paramInt2, int paramInt3)
  {
    if ((Math.abs(paramInt3) > this.N) && (Math.abs(paramInt2) > this.L))
    {
      if (paramInt2 > 0) {}
      for (;;)
      {
        paramInt2 = paramInt1;
        if (this.e.size() > 0)
        {
          b localb1 = (b)this.e.get(0);
          b localb2 = (b)this.e.get(this.e.size() - 1);
          paramInt2 = Math.max(localb1.b, Math.min(paramInt1, localb2.b));
        }
        return paramInt2;
        paramInt1 += 1;
      }
    }
    if (paramInt1 >= this.i) {}
    for (float f1 = 0.4F;; f1 = 0.6F)
    {
      paramInt1 = (int)(f1 + (paramInt1 + paramFloat));
      break;
    }
  }
  
  private Rect a(Rect paramRect, View paramView)
  {
    if (paramRect == null) {
      paramRect = new Rect();
    }
    for (;;)
    {
      if (paramView == null)
      {
        paramRect.set(0, 0, 0, 0);
        return paramRect;
      }
      paramRect.left = paramView.getLeft();
      paramRect.right = paramView.getRight();
      paramRect.top = paramView.getTop();
      paramRect.bottom = paramView.getBottom();
      for (paramView = paramView.getParent(); ((paramView instanceof ViewGroup)) && (paramView != this); paramView = paramView.getParent())
      {
        paramView = (ViewGroup)paramView;
        paramRect.left += paramView.getLeft();
        paramRect.right += paramView.getRight();
        paramRect.top += paramView.getTop();
        paramRect.bottom += paramView.getBottom();
      }
      return paramRect;
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt2 > 0) && (!this.e.isEmpty()))
    {
      int i1 = getPaddingTop();
      int i2 = getPaddingBottom();
      int i3 = getPaddingTop();
      int i4 = getPaddingBottom();
      f1 = getScrollY() / (paramInt2 - i3 - i4 + paramInt4);
      paramInt2 = (int)((paramInt1 - i1 - i2 + paramInt3) * f1);
      scrollTo(getScrollX(), paramInt2);
      if (!this.m.isFinished())
      {
        paramInt3 = this.m.getDuration();
        paramInt4 = this.m.timePassed();
        localb = b(this.i);
        this.m.startScroll(0, paramInt2, 0, (int)(localb.e * paramInt1), paramInt3 - paramInt4);
      }
      return;
    }
    b localb = b(this.i);
    if (localb != null) {}
    for (float f1 = Math.min(localb.e, this.t);; f1 = 0.0F)
    {
      paramInt1 = (int)(f1 * (paramInt1 - getPaddingTop() - getPaddingBottom()));
      if (paramInt1 == getScrollY()) {
        break;
      }
      a(false);
      scrollTo(getScrollX(), paramInt1);
      return;
    }
  }
  
  private void a(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    b localb = b(paramInt1);
    float f1;
    if (localb != null) {
      f1 = getClientHeight();
    }
    for (int i1 = (int)(Math.max(this.s, Math.min(localb.e, this.t)) * f1);; i1 = 0)
    {
      if (paramBoolean1)
      {
        a(0, i1, paramInt2);
        if ((paramBoolean2) && (this.aa != null)) {
          this.aa.onPageSelected(paramInt1);
        }
        if ((paramBoolean2) && (this.ab != null)) {
          this.ab.onPageSelected(paramInt1);
        }
        return;
      }
      if ((paramBoolean2) && (this.aa != null)) {
        this.aa.onPageSelected(paramInt1);
      }
      if ((paramBoolean2) && (this.ab != null)) {
        this.ab.onPageSelected(paramInt1);
      }
      a(false);
      scrollTo(0, i1);
      c(i1);
      return;
    }
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    int i1 = MotionEventCompat.getActionIndex(paramMotionEvent);
    if (MotionEventCompat.getPointerId(paramMotionEvent, i1) == this.J) {
      if (i1 != 0) {
        break label56;
      }
    }
    label56:
    for (i1 = 1;; i1 = 0)
    {
      this.G = MotionEventCompat.getY(paramMotionEvent, i1);
      this.J = MotionEventCompat.getPointerId(paramMotionEvent, i1);
      if (this.K != null) {
        this.K.clear();
      }
      return;
    }
  }
  
  private void a(b paramb1, int paramInt, b paramb2)
  {
    int i4 = this.h.getCount();
    int i1 = getClientHeight();
    float f2;
    if (i1 > 0)
    {
      f2 = this.o / i1;
      if (paramb2 == null) {
        break label409;
      }
      i1 = paramb2.b;
      if (i1 < paramb1.b)
      {
        f1 = paramb2.e + paramb2.d + f2;
        i1 += 1;
        i2 = 0;
      }
    }
    else
    {
      for (;;)
      {
        if ((i1 > paramb1.b) || (i2 >= this.e.size())) {
          break label409;
        }
        for (paramb2 = (b)this.e.get(i2);; paramb2 = (b)this.e.get(i2))
        {
          i3 = i1;
          f3 = f1;
          if (i1 <= paramb2.b) {
            break;
          }
          i3 = i1;
          f3 = f1;
          if (i2 >= this.e.size() - 1) {
            break;
          }
          i2 += 1;
        }
        f2 = 0.0F;
        break;
        while (i3 < paramb2.b)
        {
          f3 += this.h.getPageWidth(i3) + f2;
          i3 += 1;
        }
        paramb2.e = f3;
        f1 = f3 + (paramb2.d + f2);
        i1 = i3 + 1;
      }
    }
    if (i1 > paramb1.b)
    {
      i2 = this.e.size() - 1;
      f1 = paramb2.e;
      i1 -= 1;
      while ((i1 >= paramb1.b) && (i2 >= 0))
      {
        for (paramb2 = (b)this.e.get(i2);; paramb2 = (b)this.e.get(i2))
        {
          i3 = i1;
          f3 = f1;
          if (i1 >= paramb2.b) {
            break;
          }
          i3 = i1;
          f3 = f1;
          if (i2 <= 0) {
            break;
          }
          i2 -= 1;
        }
        while (i3 > paramb2.b)
        {
          f3 -= this.h.getPageWidth(i3) + f2;
          i3 -= 1;
        }
        f1 = f3 - (paramb2.d + f2);
        paramb2.e = f1;
        i1 = i3 - 1;
      }
    }
    label409:
    int i3 = this.e.size();
    float f3 = paramb1.e;
    i1 = paramb1.b - 1;
    if (paramb1.b == 0)
    {
      f1 = paramb1.e;
      this.s = f1;
      if (paramb1.b != i4 - 1) {
        break label550;
      }
      f1 = paramb1.e + paramb1.d - 1.0F;
      label475:
      this.t = f1;
      i2 = paramInt - 1;
      f1 = f3;
    }
    for (;;)
    {
      if (i2 < 0) {
        break label603;
      }
      paramb2 = (b)this.e.get(i2);
      for (;;)
      {
        if (i1 > paramb2.b)
        {
          f1 -= this.h.getPageWidth(i1) + f2;
          i1 -= 1;
          continue;
          f1 = -3.4028235E38F;
          break;
          label550:
          f1 = Float.MAX_VALUE;
          break label475;
        }
      }
      f1 -= paramb2.d + f2;
      paramb2.e = f1;
      if (paramb2.b == 0) {
        this.s = f1;
      }
      i1 -= 1;
      i2 -= 1;
    }
    label603:
    float f1 = paramb1.e + paramb1.d + f2;
    int i2 = paramb1.b + 1;
    i1 = paramInt + 1;
    paramInt = i2;
    while (i1 < i3)
    {
      paramb1 = (b)this.e.get(i1);
      while (paramInt < paramb1.b)
      {
        f1 = this.h.getPageWidth(paramInt) + f2 + f1;
        paramInt += 1;
      }
      if (paramb1.b == i4 - 1) {
        this.t = (paramb1.d + f1 - 1.0F);
      }
      paramb1.e = f1;
      f1 += paramb1.d + f2;
      paramInt += 1;
      i1 += 1;
    }
    this.U = false;
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.aj == 2) {}
    int i2;
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 != 0)
      {
        setScrollingCacheEnabled(false);
        this.m.abortAnimation();
        i2 = getScrollX();
        i3 = getScrollY();
        int i4 = this.m.getCurrX();
        int i5 = this.m.getCurrY();
        if ((i2 != i4) || (i3 != i5)) {
          scrollTo(i4, i5);
        }
      }
      this.y = false;
      int i3 = 0;
      i2 = i1;
      i1 = i3;
      while (i1 < this.e.size())
      {
        b localb = (b)this.e.get(i1);
        if (localb.c)
        {
          localb.c = false;
          i2 = 1;
        }
        i1 += 1;
      }
    }
    if (i2 != 0)
    {
      if (paramBoolean) {
        ViewCompat.postOnAnimation(this, this.ai);
      }
    }
    else {
      return;
    }
    this.ai.run();
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    return ((paramFloat1 < this.D) && (paramFloat2 > 0.0F)) || ((paramFloat1 > getHeight() - this.D) && (paramFloat2 < 0.0F));
  }
  
  private void b(boolean paramBoolean)
  {
    int i3 = getChildCount();
    int i1 = 0;
    if (i1 < i3)
    {
      if (paramBoolean) {}
      for (int i2 = 2;; i2 = 0)
      {
        ViewCompat.setLayerType(getChildAt(i1), i2, null);
        i1 += 1;
        break;
      }
    }
  }
  
  private boolean b(float paramFloat)
  {
    int i2 = 1;
    boolean bool2 = false;
    boolean bool1 = false;
    float f1 = this.G;
    this.G = paramFloat;
    float f2 = getScrollY() + (f1 - paramFloat);
    int i3 = getClientHeight();
    paramFloat = i3 * this.s;
    f1 = i3;
    float f3 = this.t;
    b localb1 = (b)this.e.get(0);
    b localb2 = (b)this.e.get(this.e.size() - 1);
    if (localb1.b != 0) {
      paramFloat = localb1.e * i3;
    }
    for (int i1 = 0;; i1 = 1)
    {
      if (localb2.b != this.h.getCount() - 1)
      {
        f1 = localb2.e * i3;
        i2 = 0;
      }
      for (;;)
      {
        if (f2 < paramFloat)
        {
          f1 = paramFloat;
          if (i1 != 0)
          {
            bool1 = this.R.onPull(Math.abs(paramFloat - f2) / i3);
            f1 = paramFloat;
          }
        }
        for (;;)
        {
          this.F += f1 - (int)f1;
          scrollTo(getScrollX(), (int)f1);
          c((int)f1);
          return bool1;
          if (f2 > f1)
          {
            bool1 = bool2;
            if (i2 != 0) {
              bool1 = this.S.onPull(Math.abs(f2 - f1) / i3);
            }
          }
          else
          {
            f1 = f2;
          }
        }
        f1 *= f3;
      }
    }
  }
  
  private void c(boolean paramBoolean)
  {
    ViewParent localViewParent = getParent();
    if (localViewParent != null) {
      localViewParent.requestDisallowInterceptTouchEvent(paramBoolean);
    }
  }
  
  private boolean c(int paramInt)
  {
    boolean bool = false;
    if (this.e.size() == 0)
    {
      this.V = false;
      a(0, 0.0F, 0);
      if (!this.V) {
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
      }
    }
    else
    {
      b localb = i();
      int i2 = getClientHeight();
      int i3 = this.o;
      float f1 = this.o / i2;
      int i1 = localb.b;
      f1 = (paramInt / i2 - localb.e) / (localb.d + f1);
      paramInt = (int)((i3 + i2) * f1);
      this.V = false;
      a(i1, f1, paramInt);
      if (!this.V) {
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
      }
      bool = true;
    }
    return bool;
  }
  
  private void g()
  {
    int i2;
    for (int i1 = 0; i1 < getChildCount(); i1 = i2 + 1)
    {
      i2 = i1;
      if (!((LayoutParams)getChildAt(i1).getLayoutParams()).a)
      {
        removeViewAt(i1);
        i2 = i1 - 1;
      }
    }
  }
  
  private int getClientHeight()
  {
    return getMeasuredHeight() - getPaddingTop() - getPaddingBottom();
  }
  
  private void h()
  {
    if (this.af != 0)
    {
      if (this.ag == null) {
        this.ag = new ArrayList();
      }
      for (;;)
      {
        int i2 = getChildCount();
        int i1 = 0;
        while (i1 < i2)
        {
          View localView = getChildAt(i1);
          this.ag.add(localView);
          i1 += 1;
        }
        this.ag.clear();
      }
      Collections.sort(this.ag, ah);
    }
  }
  
  private b i()
  {
    int i1 = getClientHeight();
    float f1;
    float f2;
    label36:
    float f4;
    float f3;
    int i3;
    int i2;
    Object localObject1;
    label53:
    Object localObject2;
    b localb;
    if (i1 > 0)
    {
      f1 = getScrollY() / i1;
      if (i1 <= 0) {
        break label214;
      }
      f2 = this.o / i1;
      f4 = 0.0F;
      f3 = 0.0F;
      i3 = -1;
      i1 = 0;
      i2 = 1;
      localObject1 = null;
      localObject2 = localObject1;
      if (i1 < this.e.size())
      {
        localb = (b)this.e.get(i1);
        if ((i2 != 0) || (localb.b == i3 + 1)) {
          break label249;
        }
        localb = this.f;
        localb.e = (f4 + f3 + f2);
        localb.b = (i3 + 1);
        localb.d = this.h.getPageWidth(localb.b);
        i1 -= 1;
      }
    }
    label214:
    label219:
    label249:
    for (;;)
    {
      f3 = localb.e;
      f4 = localb.d;
      if (i2 == 0)
      {
        localObject2 = localObject1;
        if (f1 < f3) {}
      }
      else
      {
        if ((f1 >= f4 + f3 + f2) && (i1 != this.e.size() - 1)) {
          break label219;
        }
        localObject2 = localb;
      }
      return (b)localObject2;
      f1 = 0.0F;
      break;
      f2 = 0.0F;
      break label36;
      i3 = localb.b;
      f4 = localb.d;
      i2 = 0;
      i1 += 1;
      localObject1 = localb;
      break label53;
    }
  }
  
  private void j()
  {
    this.A = false;
    this.B = false;
    if (this.K != null)
    {
      this.K.recycle();
      this.K = null;
    }
  }
  
  private void setScrollState(int paramInt)
  {
    if (this.aj == paramInt) {
      return;
    }
    this.aj = paramInt;
    if (this.ad != null) {
      if (paramInt == 0) {
        break label50;
      }
    }
    label50:
    for (boolean bool = true;; bool = false)
    {
      b(bool);
      if (this.aa == null) {
        break;
      }
      this.aa.onPageScrollStateChanged(paramInt);
      return;
    }
  }
  
  private void setScrollingCacheEnabled(boolean paramBoolean)
  {
    if (this.x != paramBoolean) {
      this.x = paramBoolean;
    }
  }
  
  float a(float paramFloat)
  {
    return (float)Math.sin((float)((paramFloat - 0.5F) * 0.4712389167638204D));
  }
  
  b a(int paramInt1, int paramInt2)
  {
    b localb = new b();
    localb.b = paramInt1;
    localb.a = this.h.instantiateItem(this, paramInt1);
    localb.d = this.h.getPageWidth(paramInt1);
    if ((paramInt2 < 0) || (paramInt2 >= this.e.size()))
    {
      this.e.add(localb);
      return localb;
    }
    this.e.add(paramInt2, localb);
    return localb;
  }
  
  b a(View paramView)
  {
    int i1 = 0;
    while (i1 < this.e.size())
    {
      b localb = (b)this.e.get(i1);
      if (this.h.isViewFromObject(paramView, localb.a)) {
        return localb;
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
    this.m = new Scroller(localContext, d);
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(localContext);
    float f1 = localContext.getResources().getDisplayMetrics().density;
    this.E = ViewConfigurationCompat.getScaledPagingTouchSlop(localViewConfiguration);
    this.L = ((int)(400.0F * f1));
    this.M = localViewConfiguration.getScaledMaximumFlingVelocity();
    this.R = new EdgeEffectCompat(localContext);
    this.S = new EdgeEffectCompat(localContext);
    this.N = ((int)(25.0F * f1));
    this.O = ((int)(2.0F * f1));
    this.C = ((int)(16.0F * f1));
    ViewCompat.setAccessibilityDelegate(this, new c());
    if (ViewCompat.getImportantForAccessibility(this) == 0) {
      ViewCompat.setImportantForAccessibility(this, 1);
    }
  }
  
  void a(int paramInt)
  {
    int i1;
    Object localObject2;
    if (this.i != paramInt) {
      if (this.i < paramInt)
      {
        i1 = 130;
        localObject2 = b(this.i);
        this.i = paramInt;
      }
    }
    for (int i2 = i1;; i2 = 2)
    {
      if (this.h == null) {
        h();
      }
      do
      {
        return;
        i1 = 33;
        break;
        if (this.y)
        {
          h();
          return;
        }
      } while (getWindowToken() == null);
      this.h.startUpdate(this);
      paramInt = this.z;
      int i8 = Math.max(0, this.i - paramInt);
      int i6 = this.h.getCount();
      int i7 = Math.min(i6 - 1, paramInt + this.i);
      Object localObject1;
      if (i6 != this.b) {
        try
        {
          String str = getResources().getResourceName(getId());
          throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.b + ", found: " + i6 + " Pager id: " + str + " Pager class: " + getClass() + " Problematic adapter: " + this.h.getClass());
        }
        catch (Resources.NotFoundException localNotFoundException)
        {
          for (;;)
          {
            localObject1 = Integer.toHexString(getId());
          }
        }
      }
      paramInt = 0;
      if (paramInt < this.e.size())
      {
        localObject1 = (b)this.e.get(paramInt);
        if (((b)localObject1).b >= this.i) {
          if (((b)localObject1).b != this.i) {
            break label1274;
          }
        }
      }
      for (;;)
      {
        if ((localObject1 == null) && (i6 > 0)) {}
        for (Object localObject3 = a(this.i, paramInt);; localObject3 = localObject1)
        {
          int i5;
          label345:
          int i9;
          label358:
          float f3;
          int i4;
          int i3;
          Object localObject4;
          float f1;
          if (localObject3 != null)
          {
            i5 = paramInt - 1;
            if (i5 < 0) {
              break label641;
            }
            localObject1 = (b)this.e.get(i5);
            i9 = getClientHeight();
            if (i9 > 0) {
              break label647;
            }
            f2 = 0.0F;
            i1 = this.i;
            f3 = 0.0F;
            i4 = i1 - 1;
            i3 = paramInt;
            localObject4 = localObject1;
            if (i4 >= 0)
            {
              if ((f3 < f2) || (i4 >= i8)) {
                break label802;
              }
              if (localObject4 != null) {
                break label668;
              }
            }
            f1 = ((b)localObject3).d;
            paramInt = i3 + 1;
            if (f1 < 2.0F)
            {
              if (paramInt >= this.e.size()) {
                break label922;
              }
              localObject1 = (b)this.e.get(paramInt);
              label445:
              if (i9 > 0) {
                break label928;
              }
            }
          }
          label464:
          label522:
          label641:
          label647:
          label668:
          label793:
          label802:
          label922:
          label928:
          for (float f2 = 0.0F;; f2 = getPaddingRight() / i9 + 2.0F)
          {
            i1 = this.i;
            i1 += 1;
            if (i1 < i6)
            {
              if ((f1 < f2) || (i1 <= i7)) {
                break label1024;
              }
              if (localObject1 != null) {
                break label943;
              }
            }
            a((b)localObject3, i3, (b)localObject2);
            localObject2 = this.h;
            paramInt = this.i;
            if (localObject3 == null) {
              break label1146;
            }
            localObject1 = ((b)localObject3).a;
            ((PagerAdapter)localObject2).setPrimaryItem(this, paramInt, localObject1);
            this.h.finishUpdate(this);
            i1 = getChildCount();
            paramInt = 0;
            while (paramInt < i1)
            {
              localObject2 = getChildAt(paramInt);
              localObject1 = (LayoutParams)((View)localObject2).getLayoutParams();
              ((LayoutParams)localObject1).f = paramInt;
              if ((!((LayoutParams)localObject1).a) && (((LayoutParams)localObject1).c == 0.0F))
              {
                localObject2 = a((View)localObject2);
                if (localObject2 != null)
                {
                  ((LayoutParams)localObject1).c = ((b)localObject2).d;
                  ((LayoutParams)localObject1).e = ((b)localObject2).b;
                }
              }
              paramInt += 1;
            }
            paramInt += 1;
            break;
            localObject1 = null;
            break label345;
            f2 = 2.0F - ((b)localObject3).d + getPaddingLeft() / i9;
            break label358;
            localObject1 = localObject4;
            paramInt = i5;
            f1 = f3;
            i1 = i3;
            if (i4 == ((b)localObject4).b)
            {
              localObject1 = localObject4;
              paramInt = i5;
              f1 = f3;
              i1 = i3;
              if (!((b)localObject4).c)
              {
                this.e.remove(i5);
                this.h.destroyItem(this, i4, ((b)localObject4).a);
                paramInt = i5 - 1;
                i1 = i3 - 1;
                if (paramInt < 0) {
                  break label793;
                }
                localObject1 = (b)this.e.get(paramInt);
                f1 = f3;
              }
            }
            for (;;)
            {
              i4 -= 1;
              localObject4 = localObject1;
              i5 = paramInt;
              f3 = f1;
              i3 = i1;
              break;
              localObject1 = null;
              f1 = f3;
              continue;
              if ((localObject4 != null) && (i4 == ((b)localObject4).b))
              {
                f1 = f3 + ((b)localObject4).d;
                paramInt = i5 - 1;
                if (paramInt >= 0)
                {
                  localObject1 = (b)this.e.get(paramInt);
                  i1 = i3;
                }
                else
                {
                  localObject1 = null;
                  i1 = i3;
                }
              }
              else
              {
                f1 = f3 + a(i4, i5 + 1).d;
                i1 = i3 + 1;
                if (i5 >= 0)
                {
                  localObject1 = (b)this.e.get(i5);
                  paramInt = i5;
                }
                else
                {
                  localObject1 = null;
                  paramInt = i5;
                }
              }
            }
            localObject1 = null;
            break label445;
          }
          label943:
          if ((i1 == ((b)localObject1).b) && (!((b)localObject1).c))
          {
            this.e.remove(paramInt);
            this.h.destroyItem(this, i1, ((b)localObject1).a);
            if (paramInt < this.e.size()) {
              localObject1 = (b)this.e.get(paramInt);
            }
          }
          for (;;)
          {
            i1 += 1;
            break label464;
            localObject1 = null;
            continue;
            label1024:
            if ((localObject1 != null) && (i1 == ((b)localObject1).b))
            {
              f3 = ((b)localObject1).d;
              paramInt += 1;
              if (paramInt < this.e.size()) {}
              for (localObject1 = (b)this.e.get(paramInt);; localObject1 = null)
              {
                f1 += f3;
                break;
              }
            }
            localObject1 = a(i1, paramInt);
            paramInt += 1;
            f3 = ((b)localObject1).d;
            if (paramInt < this.e.size()) {}
            for (localObject1 = (b)this.e.get(paramInt);; localObject1 = null)
            {
              f1 += f3;
              break;
            }
            label1146:
            localObject1 = null;
            break label522;
            h();
            if (!hasFocus()) {
              break;
            }
            localObject1 = findFocus();
            if (localObject1 != null) {}
            for (localObject1 = b((View)localObject1);; localObject1 = null)
            {
              if ((localObject1 != null) && (((b)localObject1).b == this.i)) {
                break label1262;
              }
              paramInt = 0;
              for (;;)
              {
                if (paramInt >= getChildCount()) {
                  break label1256;
                }
                localObject1 = getChildAt(paramInt);
                localObject2 = a((View)localObject1);
                if ((localObject2 != null) && (((b)localObject2).b == this.i) && (((View)localObject1).requestFocus(i2))) {
                  break;
                }
                paramInt += 1;
              }
              label1256:
              break;
            }
            label1262:
            break;
          }
        }
        label1274:
        localObject1 = null;
      }
      localObject2 = null;
    }
  }
  
  protected void a(int paramInt1, float paramFloat, int paramInt2)
  {
    int i1;
    View localView;
    if (this.W > 0)
    {
      int i6 = getScrollY();
      i1 = getPaddingTop();
      int i2 = getPaddingBottom();
      int i7 = getHeight();
      int i8 = getChildCount();
      int i5 = 0;
      while (i5 < i8)
      {
        localView = getChildAt(i5);
        LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
        int i4;
        int i3;
        if (!localLayoutParams.a)
        {
          i4 = i1;
          i3 = i2;
          i5 += 1;
          i1 = i4;
          i2 = i3;
        }
        else
        {
          switch (localLayoutParams.b & 0x70)
          {
          default: 
            i3 = i1;
            i4 = i2;
            i2 = i1;
            i1 = i4;
          }
          for (;;)
          {
            int i9 = i3 + i6 - localView.getTop();
            i3 = i1;
            i4 = i2;
            if (i9 == 0) {
              break;
            }
            localView.offsetTopAndBottom(i9);
            i3 = i1;
            i4 = i2;
            break;
            i3 = localView.getHeight();
            i4 = i3 + i1;
            i3 = i1;
            i1 = i2;
            i2 = i4;
            continue;
            i3 = Math.max((i7 - localView.getMeasuredHeight()) / 2, i1);
            i4 = i1;
            i1 = i2;
            i2 = i4;
            continue;
            i3 = i7 - i2 - localView.getMeasuredHeight();
            i9 = localView.getMeasuredHeight();
            i4 = i1;
            i1 = i2 + i9;
            i2 = i4;
          }
        }
      }
    }
    if (this.aa != null) {
      this.aa.onPageScrolled(paramInt1, paramFloat, paramInt2);
    }
    if (this.ab != null) {
      this.ab.onPageScrolled(paramInt1, paramFloat, paramInt2);
    }
    if (this.ad != null)
    {
      paramInt2 = getScrollY();
      i1 = getChildCount();
      paramInt1 = 0;
      if (paramInt1 < i1)
      {
        localView = getChildAt(paramInt1);
        if (((LayoutParams)localView.getLayoutParams()).a) {}
        for (;;)
        {
          paramInt1 += 1;
          break;
          paramFloat = (localView.getTop() - paramInt2) / getClientHeight();
          this.ad.transformPage(localView, paramFloat);
        }
      }
    }
    this.V = true;
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
      a(false);
      c();
      setScrollState(0);
      return;
    }
    setScrollingCacheEnabled(true);
    setScrollState(2);
    paramInt1 = getClientHeight();
    int i4 = paramInt1 / 2;
    float f3 = Math.min(1.0F, Math.abs(i3) * 1.0F / paramInt1);
    float f1 = i4;
    float f2 = i4;
    f3 = a(f3);
    paramInt3 = Math.abs(paramInt3);
    if (paramInt3 > 0) {}
    for (paramInt1 = Math.round(1000.0F * Math.abs((f2 * f3 + f1) / paramInt3)) * 4;; paramInt1 = (int)((Math.abs(i3) / (f1 * f2 + this.o) + 1.0F) * 100.0F))
    {
      paramInt1 = Math.min(paramInt1, 600);
      this.m.startScroll(i1, i2, i3, paramInt2, paramInt1);
      ViewCompat.postInvalidateOnAnimation(this);
      return;
      f1 = paramInt1;
      f2 = this.h.getPageWidth(this.i);
    }
  }
  
  void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramInt, paramBoolean1, paramBoolean2, 0);
  }
  
  void a(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    boolean bool = false;
    if ((this.h == null) || (this.h.getCount() <= 0))
    {
      setScrollingCacheEnabled(false);
      return;
    }
    if ((!paramBoolean2) && (this.i == paramInt1) && (this.e.size() != 0))
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
      paramInt1 = this.z;
      if ((i1 <= this.i + paramInt1) && (i1 >= this.i - paramInt1)) {
        break;
      }
      paramInt1 = 0;
      while (paramInt1 < this.e.size())
      {
        ((b)this.e.get(paramInt1)).c = true;
        paramInt1 += 1;
      }
      i1 = paramInt1;
      if (paramInt1 >= this.h.getCount()) {
        i1 = this.h.getCount() - 1;
      }
    }
    paramBoolean2 = bool;
    if (this.i != i1) {
      paramBoolean2 = true;
    }
    if (this.T)
    {
      this.i = i1;
      if ((paramBoolean2) && (this.aa != null)) {
        this.aa.onPageSelected(i1);
      }
      if ((paramBoolean2) && (this.ab != null)) {
        this.ab.onPageSelected(i1);
      }
      requestLayout();
      return;
    }
    a(i1);
    a(i1, paramBoolean1, paramInt2, paramBoolean2);
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
        if ((paramInt3 + i3 < localView.getTop()) || (paramInt3 + i3 >= localView.getBottom()) || (paramInt2 + i2 < localView.getLeft()) || (paramInt2 + i2 >= localView.getRight()) || (!a(localView, true, paramInt1, paramInt2 + i2 - localView.getLeft(), paramInt3 + i3 - localView.getTop()))) {}
      }
    }
    while ((paramBoolean) && (ViewCompat.canScrollVertically(paramView, -paramInt1)))
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
          b localb = a(localView);
          if ((localb != null) && (localb.b == this.i)) {
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
        b localb = a(localView);
        if ((localb != null) && (localb.b == this.i)) {
          localView.addTouchables(paramArrayList);
        }
      }
      i1 += 1;
    }
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (!checkLayoutParams(paramLayoutParams)) {
      paramLayoutParams = generateLayoutParams(paramLayoutParams);
    }
    for (;;)
    {
      LayoutParams localLayoutParams = (LayoutParams)paramLayoutParams;
      localLayoutParams.a |= paramView instanceof a;
      if (this.w)
      {
        if ((localLayoutParams != null) && (localLayoutParams.a)) {
          throw new IllegalStateException("Cannot add pager decor view during layout");
        }
        localLayoutParams.d = true;
        addViewInLayout(paramView, paramInt, paramLayoutParams);
        return;
      }
      super.addView(paramView, paramInt, paramLayoutParams);
      return;
    }
  }
  
  public boolean arrowScroll(int paramInt)
  {
    View localView = findFocus();
    Object localObject;
    int i2;
    boolean bool;
    if (localView == this)
    {
      localObject = null;
      localView = FocusFinder.getInstance().findNextFocus(this, (View)localObject, paramInt);
      if ((localView == null) || (localView == localObject)) {
        break label330;
      }
      if (paramInt != 33) {
        break label266;
      }
      i1 = a(this.g, localView).top;
      i2 = a(this.g, (View)localObject).top;
      if ((localObject != null) && (i1 >= i2))
      {
        bool = d();
        label89:
        if (bool) {
          playSoundEffect(SoundEffectConstants.getContantForFocusDirection(paramInt));
        }
        return bool;
      }
    }
    else
    {
      if (localView == null) {
        break label377;
      }
      localObject = localView.getParent();
      if (!(localObject instanceof ViewGroup)) {
        break label384;
      }
      if (localObject != this) {}
    }
    label266:
    label330:
    label377:
    label384:
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 == 0)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localView.getClass().getSimpleName());
        localObject = localView.getParent();
        for (;;)
        {
          if ((localObject instanceof ViewGroup))
          {
            localStringBuilder.append(" => ").append(localObject.getClass().getSimpleName());
            localObject = ((ViewParent)localObject).getParent();
            continue;
            localObject = ((ViewParent)localObject).getParent();
            break;
          }
        }
        Log.e("ViewPager", "arrowScroll tried to find focus based on non-child current focused view " + localStringBuilder.toString());
        localObject = null;
        break;
        bool = localView.requestFocus();
        break label89;
        if (paramInt == 130)
        {
          i1 = a(this.g, localView).bottom;
          i2 = a(this.g, (View)localObject).bottom;
          if ((localObject != null) && (i1 <= i2))
          {
            bool = e();
            break label89;
          }
          bool = localView.requestFocus();
          break label89;
          if ((paramInt == 33) || (paramInt == 1))
          {
            bool = d();
            break label89;
          }
          if ((paramInt == 130) || (paramInt == 2))
          {
            bool = e();
            break label89;
          }
        }
        bool = false;
        break label89;
      }
      localObject = localView;
      break;
    }
  }
  
  b b(int paramInt)
  {
    int i1 = 0;
    while (i1 < this.e.size())
    {
      b localb = (b)this.e.get(i1);
      if (localb.b == paramInt) {
        return localb;
      }
      i1 += 1;
    }
    return null;
  }
  
  b b(View paramView)
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
    int i7 = this.h.getCount();
    this.b = i7;
    int i1;
    int i2;
    int i3;
    int i5;
    int i4;
    label67:
    Object localObject;
    int i6;
    if ((this.e.size() < this.z * 2 + 1) && (this.e.size() < i7))
    {
      i1 = 1;
      i2 = this.i;
      i3 = 0;
      i5 = 0;
      i4 = i1;
      i1 = i2;
      i2 = i3;
      i3 = i5;
      if (i3 >= this.e.size()) {
        break label299;
      }
      localObject = (b)this.e.get(i3);
      i5 = this.h.getItemPosition(((b)localObject).a);
      if (i5 != -1) {
        break label157;
      }
      i5 = i3;
      i6 = i2;
      i3 = i4;
      i2 = i1;
      i1 = i6;
      i4 = i5;
    }
    for (;;)
    {
      i5 = i3;
      i6 = i2;
      i3 = i4 + 1;
      i2 = i1;
      i1 = i6;
      i4 = i5;
      break label67;
      i1 = 0;
      break;
      label157:
      if (i5 == -2)
      {
        this.e.remove(i3);
        i4 = i3 - 1;
        i3 = i2;
        if (i2 == 0)
        {
          this.h.startUpdate(this);
          i3 = 1;
        }
        this.h.destroyItem(this, ((b)localObject).b, ((b)localObject).a);
        if (this.i == ((b)localObject).b)
        {
          i2 = Math.max(0, Math.min(this.i, i7 - 1));
          i1 = i3;
          i3 = 1;
        }
      }
      else
      {
        if (((b)localObject).b != i5)
        {
          if (((b)localObject).b == this.i) {
            i1 = i5;
          }
          ((b)localObject).b = i5;
          i5 = i1;
          i6 = 1;
          i4 = i3;
          i1 = i2;
          i2 = i5;
          i3 = i6;
          continue;
          label299:
          if (i2 != 0) {
            this.h.finishUpdate(this);
          }
          Collections.sort(this.e, c);
          if (i4 != 0)
          {
            i3 = getChildCount();
            i2 = 0;
            while (i2 < i3)
            {
              localObject = (LayoutParams)getChildAt(i2).getLayoutParams();
              if (!((LayoutParams)localObject).a) {
                ((LayoutParams)localObject).c = 0.0F;
              }
              i2 += 1;
            }
            a(i1, false, true);
            requestLayout();
          }
          return;
        }
        i5 = i1;
        i6 = i4;
        i4 = i3;
        i1 = i2;
        i2 = i5;
        i3 = i6;
        continue;
      }
      i2 = i1;
      i5 = 1;
      i1 = i3;
      i3 = i5;
    }
  }
  
  public boolean beginFakeDrag()
  {
    if (this.A) {
      return false;
    }
    this.P = true;
    setScrollState(1);
    this.G = 0.0F;
    this.I = 0.0F;
    if (this.K == null) {
      this.K = VelocityTracker.obtain();
    }
    for (;;)
    {
      long l1 = SystemClock.uptimeMillis();
      MotionEvent localMotionEvent = MotionEvent.obtain(l1, l1, 0, 0.0F, 0.0F, 0);
      this.K.addMovement(localMotionEvent);
      localMotionEvent.recycle();
      this.Q = l1;
      return true;
      this.K.clear();
    }
  }
  
  void c()
  {
    a(this.i);
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof LayoutParams)) && (super.checkLayoutParams(paramLayoutParams));
  }
  
  public void computeScroll()
  {
    if ((!this.m.isFinished()) && (this.m.computeScrollOffset()))
    {
      int i1 = getScrollX();
      int i2 = getScrollY();
      int i3 = this.m.getCurrX();
      int i4 = this.m.getCurrY();
      if ((i1 != i3) || (i2 != i4))
      {
        scrollTo(i3, i4);
        if (!c(i4))
        {
          this.m.abortAnimation();
          scrollTo(i3, 0);
        }
      }
      ViewCompat.postInvalidateOnAnimation(this);
      return;
    }
    a(true);
  }
  
  boolean d()
  {
    if (this.i > 0)
    {
      setCurrentItem(this.i - 1, true);
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
    boolean bool1;
    if (paramAccessibilityEvent.getEventType() == 4096)
    {
      bool1 = super.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent);
      return bool1;
    }
    int i2 = getChildCount();
    int i1 = 0;
    for (;;)
    {
      bool1 = bool2;
      if (i1 >= i2) {
        break;
      }
      View localView = getChildAt(i1);
      if (localView.getVisibility() == 0)
      {
        b localb = a(localView);
        if ((localb != null) && (localb.b == this.i) && (localView.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent))) {
          return true;
        }
      }
      i1 += 1;
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    int i3 = 0;
    int i1 = 0;
    int i4 = ViewCompat.getOverScrollMode(this);
    boolean bool;
    if ((i4 == 0) || ((i4 == 1) && (this.h != null) && (this.h.getCount() > 1)))
    {
      int i5;
      int i2;
      if (!this.R.isFinished())
      {
        i3 = paramCanvas.save();
        i1 = getHeight();
        i4 = getWidth();
        i5 = getPaddingLeft();
        int i6 = getPaddingRight();
        paramCanvas.translate(getPaddingLeft(), this.s * i1);
        this.R.setSize(i4 - i5 - i6, i1);
        i2 = false | this.R.draw(paramCanvas);
        paramCanvas.restoreToCount(i3);
      }
      i3 = i2;
      if (!this.S.isFinished())
      {
        i4 = paramCanvas.save();
        i3 = getHeight();
        i5 = getWidth() - getPaddingLeft() - getPaddingRight();
        paramCanvas.rotate(180.0F);
        paramCanvas.translate(-i5 - getPaddingLeft(), -(this.t + 1.0F) * i3);
        this.S.setSize(i5, i3);
        bool = i2 | this.S.draw(paramCanvas);
        paramCanvas.restoreToCount(i4);
      }
    }
    for (;;)
    {
      if (bool) {
        ViewCompat.postInvalidateOnAnimation(this);
      }
      return;
      this.R.finish();
      this.S.finish();
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    Drawable localDrawable = this.p;
    if ((localDrawable != null) && (localDrawable.isStateful())) {
      localDrawable.setState(getDrawableState());
    }
  }
  
  boolean e()
  {
    if ((this.h != null) && (this.i < this.h.getCount() - 1))
    {
      setCurrentItem(this.i + 1, true);
      return true;
    }
    return false;
  }
  
  public void endFakeDrag()
  {
    if (!this.P) {
      throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    }
    Object localObject = this.K;
    ((VelocityTracker)localObject).computeCurrentVelocity(1000, this.M);
    int i1 = (int)VelocityTrackerCompat.getYVelocity((VelocityTracker)localObject, this.J);
    this.y = true;
    int i2 = getClientHeight();
    int i3 = getScrollY();
    localObject = i();
    a(a(((b)localObject).b, (i3 / i2 - ((b)localObject).e) / ((b)localObject).d, i1, (int)(this.G - this.I)), true, true, i1);
    j();
    this.P = false;
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
      do
      {
        return false;
        return arrowScroll(17);
        return arrowScroll(66);
      } while (Build.VERSION.SDK_INT < 11);
      if (KeyEventCompat.hasNoModifiers(paramKeyEvent)) {
        return arrowScroll(2);
      }
    } while (!KeyEventCompat.hasModifiers(paramKeyEvent, 1));
    return arrowScroll(1);
  }
  
  public void fakeDragBy(float paramFloat)
  {
    if (!this.P) {
      throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    }
    this.G += paramFloat;
    float f2 = getScrollY() - paramFloat;
    int i1 = getClientHeight();
    paramFloat = i1;
    float f4 = this.s;
    float f1 = i1;
    float f3 = this.t;
    Object localObject = (b)this.e.get(0);
    b localb = (b)this.e.get(this.e.size() - 1);
    if (((b)localObject).b != 0) {}
    for (paramFloat = ((b)localObject).e * i1;; paramFloat *= f4)
    {
      if (localb.b != this.h.getCount() - 1) {}
      for (f1 = localb.e * i1;; f1 *= f3)
      {
        if (f2 < paramFloat) {}
        for (;;)
        {
          this.G += paramFloat - (int)paramFloat;
          scrollTo(getScrollX(), (int)paramFloat);
          c((int)paramFloat);
          long l1 = SystemClock.uptimeMillis();
          localObject = MotionEvent.obtain(this.Q, l1, 2, 0.0F, this.G, 0);
          this.K.addMovement((MotionEvent)localObject);
          ((MotionEvent)localObject).recycle();
          return;
          if (f2 > f1) {
            paramFloat = f1;
          } else {
            paramFloat = f2;
          }
        }
      }
    }
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new LayoutParams();
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return generateDefaultLayoutParams();
  }
  
  public PagerAdapter getAdapter()
  {
    return this.h;
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    int i1 = paramInt2;
    if (this.af == 2) {
      i1 = paramInt1 - 1 - paramInt2;
    }
    return ((LayoutParams)((View)this.ag.get(i1)).getLayoutParams()).f;
  }
  
  public int getCurrentItem()
  {
    return this.i;
  }
  
  public int getOffscreenPageLimit()
  {
    return this.z;
  }
  
  public int getPageMargin()
  {
    return this.o;
  }
  
  public boolean internalCanScrollVertically(int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (this.h == null) {}
    int i1;
    int i2;
    do
    {
      return false;
      i1 = getClientHeight();
      i2 = getScrollY();
      if (paramInt < 0)
      {
        if (i2 > (int)(i1 * this.s)) {}
        for (;;)
        {
          return bool1;
          bool1 = false;
        }
      }
    } while (paramInt <= 0);
    if (i2 < (int)(i1 * this.t)) {}
    for (bool1 = bool2;; bool1 = false) {
      return bool1;
    }
  }
  
  public boolean isFakeDragging()
  {
    return this.P;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.T = true;
  }
  
  protected void onDetachedFromWindow()
  {
    removeCallbacks(this.ai);
    super.onDetachedFromWindow();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i3;
    int i4;
    float f3;
    Object localObject;
    float f1;
    int i5;
    int i1;
    int i6;
    int i2;
    if ((this.o > 0) && (this.p != null) && (this.e.size() > 0) && (this.h != null))
    {
      i3 = getScrollY();
      i4 = getHeight();
      f3 = this.o / i4;
      localObject = (b)this.e.get(0);
      f1 = ((b)localObject).e;
      i5 = this.e.size();
      i1 = ((b)localObject).b;
      i6 = ((b)this.e.get(i5 - 1)).b;
      i2 = 0;
    }
    for (;;)
    {
      float f2;
      if (i1 < i6)
      {
        while ((i1 > ((b)localObject).b) && (i2 < i5))
        {
          localObject = this.e;
          i2 += 1;
          localObject = (b)((ArrayList)localObject).get(i2);
        }
        if (i1 != ((b)localObject).b) {
          break label271;
        }
        f2 = (((b)localObject).e + ((b)localObject).d) * i4;
      }
      label271:
      float f4;
      for (f1 = ((b)localObject).e + ((b)localObject).d + f3;; f1 += f4 + f3)
      {
        if (this.o + f2 > i3)
        {
          this.p.setBounds(this.q, (int)f2, this.r, (int)(this.o + f2 + 0.5F));
          this.p.draw(paramCanvas);
        }
        if (f2 <= i3 + i4) {
          break;
        }
        return;
        f4 = this.h.getPageWidth(i1);
        f2 = (f1 + f4) * i4;
      }
      i1 += 1;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction() & 0xFF;
    if ((i1 == 3) || (i1 == 1))
    {
      this.A = false;
      this.B = false;
      this.J = -1;
      if (this.K != null)
      {
        this.K.recycle();
        this.K = null;
      }
    }
    do
    {
      return false;
      if (i1 == 0) {
        break;
      }
      if (this.A) {
        return true;
      }
    } while (this.B);
    switch (i1)
    {
    }
    for (;;)
    {
      if (this.K == null) {
        this.K = VelocityTracker.obtain();
      }
      this.K.addMovement(paramMotionEvent);
      return this.A;
      i1 = this.J;
      if (i1 != -1)
      {
        i1 = MotionEventCompat.findPointerIndex(paramMotionEvent, i1);
        float f2 = MotionEventCompat.getY(paramMotionEvent, i1);
        float f1 = f2 - this.G;
        float f4 = Math.abs(f1);
        float f3 = MotionEventCompat.getX(paramMotionEvent, i1);
        float f5 = Math.abs(f3 - this.H);
        if ((f1 != 0.0F) && (!a(this.G, f1)) && (a(this, false, (int)f1, (int)f3, (int)f2)))
        {
          this.F = f3;
          this.G = f2;
          this.B = true;
          return false;
        }
        if ((f4 > this.E) && (0.5F * f4 > f5))
        {
          this.A = true;
          c(true);
          setScrollState(1);
          if (f1 > 0.0F)
          {
            f1 = this.I + this.E;
            label310:
            this.G = f1;
            this.F = f3;
            setScrollingCacheEnabled(true);
          }
        }
        while ((this.A) && (b(f2)))
        {
          ViewCompat.postInvalidateOnAnimation(this);
          break;
          f1 = this.I - this.E;
          break label310;
          if (f5 > this.E) {
            this.B = true;
          }
        }
        f1 = paramMotionEvent.getX();
        this.H = f1;
        this.F = f1;
        f1 = paramMotionEvent.getY();
        this.I = f1;
        this.G = f1;
        this.J = MotionEventCompat.getPointerId(paramMotionEvent, 0);
        this.B = false;
        this.m.computeScrollOffset();
        if ((this.aj == 2) && (Math.abs(this.m.getFinalY() - this.m.getCurrY()) > this.O))
        {
          this.m.abortAnimation();
          this.y = false;
          c();
          this.A = true;
          c(true);
          setScrollState(1);
        }
        else
        {
          a(false);
          this.A = false;
          continue;
          a(paramMotionEvent);
        }
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i6 = getChildCount();
    int i7 = paramInt3 - paramInt1;
    int i8 = paramInt4 - paramInt2;
    paramInt2 = getPaddingLeft();
    paramInt1 = getPaddingTop();
    paramInt4 = getPaddingRight();
    paramInt3 = getPaddingBottom();
    int i9 = getScrollY();
    int i2 = 0;
    int i4 = 0;
    View localView;
    LayoutParams localLayoutParams;
    int i1;
    int i10;
    int i3;
    label154:
    int i5;
    if (i4 < i6)
    {
      localView = getChildAt(i4);
      if (localView.getVisibility() == 8) {
        break label667;
      }
      localLayoutParams = (LayoutParams)localView.getLayoutParams();
      if (!localLayoutParams.a) {
        break label667;
      }
      i1 = localLayoutParams.b;
      i10 = localLayoutParams.b;
      switch (i1 & 0x7)
      {
      case 2: 
      case 4: 
      default: 
        i1 = paramInt2;
        i3 = paramInt2;
        switch (i10 & 0x70)
        {
        default: 
          i5 = paramInt1;
          paramInt2 = paramInt1;
          paramInt1 = paramInt3;
          paramInt3 = i5;
          label204:
          paramInt3 += i9;
          localView.layout(i1, paramInt3, localView.getMeasuredWidth() + i1, localView.getMeasuredHeight() + paramInt3);
          i2 += 1;
          paramInt3 = i3;
          i1 = paramInt1;
          paramInt1 = i2;
        }
        break;
      }
    }
    for (;;)
    {
      i4 += 1;
      i3 = paramInt3;
      i2 = paramInt1;
      paramInt1 = paramInt2;
      paramInt3 = i1;
      paramInt2 = i3;
      break;
      i3 = localView.getMeasuredWidth();
      i1 = paramInt2;
      i3 += paramInt2;
      break label154;
      i1 = Math.max((i7 - localView.getMeasuredWidth()) / 2, paramInt2);
      i3 = paramInt2;
      break label154;
      i3 = localView.getMeasuredWidth();
      i1 = paramInt4 + localView.getMeasuredWidth();
      i5 = i7 - paramInt4 - i3;
      paramInt4 = i1;
      i3 = paramInt2;
      i1 = i5;
      break label154;
      i5 = localView.getMeasuredHeight();
      paramInt2 = paramInt3;
      i5 += paramInt1;
      paramInt3 = paramInt1;
      paramInt1 = paramInt2;
      paramInt2 = i5;
      break label204;
      i5 = Math.max((i8 - localView.getMeasuredHeight()) / 2, paramInt1);
      paramInt2 = paramInt1;
      paramInt1 = paramInt3;
      paramInt3 = i5;
      break label204;
      i5 = i8 - paramInt3 - localView.getMeasuredHeight();
      i10 = localView.getMeasuredHeight();
      paramInt2 = paramInt1;
      paramInt1 = paramInt3 + i10;
      paramInt3 = i5;
      break label204;
      i1 = i8 - paramInt1 - paramInt3;
      paramInt3 = 0;
      while (paramInt3 < i6)
      {
        localView = getChildAt(paramInt3);
        if (localView.getVisibility() != 8)
        {
          localLayoutParams = (LayoutParams)localView.getLayoutParams();
          if (!localLayoutParams.a)
          {
            b localb = a(localView);
            if (localb != null)
            {
              float f1 = i1;
              i3 = (int)(localb.e * f1) + paramInt1;
              if (localLayoutParams.d)
              {
                localLayoutParams.d = false;
                i4 = View.MeasureSpec.makeMeasureSpec(i7 - paramInt2 - paramInt4, 1073741824);
                f1 = i1;
                localView.measure(i4, View.MeasureSpec.makeMeasureSpec((int)(localLayoutParams.c * f1), 1073741824));
              }
              localView.layout(paramInt2, i3, localView.getMeasuredWidth() + paramInt2, localView.getMeasuredHeight() + i3);
            }
          }
        }
        paramInt3 += 1;
      }
      this.q = paramInt2;
      this.r = (i7 - paramInt4);
      this.W = i2;
      if (this.T) {
        a(this.i, false, 0, false);
      }
      this.T = false;
      return;
      label667:
      i1 = i2;
      i2 = paramInt1;
      i3 = paramInt2;
      paramInt1 = i1;
      i1 = paramInt3;
      paramInt2 = i2;
      paramInt3 = i3;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(getDefaultSize(0, paramInt1), getDefaultSize(0, paramInt2));
    paramInt2 = getMeasuredHeight();
    this.D = Math.min(paramInt2 / 10, this.C);
    paramInt1 = getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
    paramInt2 = paramInt2 - getPaddingTop() - getPaddingBottom();
    int i9 = getChildCount();
    int i3 = 0;
    View localView;
    int i1;
    int i2;
    LayoutParams localLayoutParams;
    int i4;
    int i6;
    label183:
    int i5;
    if (i3 < i9)
    {
      localView = getChildAt(i3);
      i1 = paramInt1;
      i2 = paramInt2;
      if (localView.getVisibility() != 8)
      {
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        i1 = paramInt1;
        i2 = paramInt2;
        if (localLayoutParams != null)
        {
          i1 = paramInt1;
          i2 = paramInt2;
          if (localLayoutParams.a)
          {
            i1 = localLayoutParams.b & 0x7;
            i4 = localLayoutParams.b & 0x70;
            i6 = Integer.MIN_VALUE;
            i2 = Integer.MIN_VALUE;
            if ((i4 != 48) && (i4 != 80)) {
              break label333;
            }
            i4 = 1;
            if ((i1 != 3) && (i1 != 5)) {
              break label339;
            }
            i5 = 1;
            label198:
            if (i4 == 0) {
              break label345;
            }
            i1 = 1073741824;
            label208:
            if (localLayoutParams.width == -2) {
              break label532;
            }
            i6 = 1073741824;
            if (localLayoutParams.width == -1) {
              break label526;
            }
            i1 = localLayoutParams.width;
          }
        }
      }
    }
    for (;;)
    {
      int i8;
      if (localLayoutParams.height != -2)
      {
        i7 = 1073741824;
        i2 = i7;
        if (localLayoutParams.height != -1)
        {
          i8 = localLayoutParams.height;
          i2 = i7;
        }
      }
      for (int i7 = i8;; i7 = paramInt2)
      {
        localView.measure(View.MeasureSpec.makeMeasureSpec(i1, i6), View.MeasureSpec.makeMeasureSpec(i7, i2));
        if (i4 != 0)
        {
          i2 = paramInt2 - localView.getMeasuredHeight();
          i1 = paramInt1;
        }
        for (;;)
        {
          i3 += 1;
          paramInt1 = i1;
          paramInt2 = i2;
          break;
          label333:
          i4 = 0;
          break label183;
          label339:
          i5 = 0;
          break label198;
          label345:
          i1 = i6;
          if (i5 == 0) {
            break label208;
          }
          i2 = 1073741824;
          i1 = i6;
          break label208;
          i1 = paramInt1;
          i2 = paramInt2;
          if (i5 != 0)
          {
            i1 = paramInt1 - localView.getMeasuredWidth();
            i2 = paramInt2;
          }
        }
        this.u = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
        this.v = View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824);
        this.w = true;
        c();
        this.w = false;
        i1 = getChildCount();
        paramInt1 = 0;
        while (paramInt1 < i1)
        {
          localView = getChildAt(paramInt1);
          if (localView.getVisibility() != 8)
          {
            localLayoutParams = (LayoutParams)localView.getLayoutParams();
            if ((localLayoutParams == null) || (!localLayoutParams.a))
            {
              float f1 = paramInt2;
              i2 = View.MeasureSpec.makeMeasureSpec((int)(localLayoutParams.c * f1), 1073741824);
              localView.measure(this.u, i2);
            }
          }
          paramInt1 += 1;
        }
        return;
      }
      label526:
      i1 = paramInt1;
      continue;
      label532:
      i6 = i1;
      i1 = paramInt1;
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
        b localb = a(localView);
        if ((localb != null) && (localb.b == this.i) && (localView.requestFocus(paramInt, paramRect)))
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
    if (this.h != null)
    {
      this.h.restoreState(paramParcelable.b, paramParcelable.c);
      a(paramParcelable.a, false, true);
      return;
    }
    this.j = paramParcelable.a;
    this.k = paramParcelable.b;
    this.l = paramParcelable.c;
  }
  
  public Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.a = this.i;
    if (this.h != null) {
      localSavedState.b = this.h.saveState();
    }
    return localSavedState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt2 != paramInt4) {
      a(paramInt2, paramInt4, this.o, this.o);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i4 = 0;
    if (this.P) {
      return true;
    }
    if ((paramMotionEvent.getAction() == 0) && (paramMotionEvent.getEdgeFlags() != 0)) {
      return false;
    }
    if ((this.h == null) || (this.h.getCount() == 0)) {
      return false;
    }
    if (this.K == null) {
      this.K = VelocityTracker.obtain();
    }
    this.K.addMovement(paramMotionEvent);
    int i1 = i4;
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
      i1 = i4;
    }
    for (;;)
    {
      if (i1 != 0) {
        ViewCompat.postInvalidateOnAnimation(this);
      }
      return true;
      this.m.abortAnimation();
      this.y = false;
      c();
      float f1 = paramMotionEvent.getX();
      this.H = f1;
      this.F = f1;
      f1 = paramMotionEvent.getY();
      this.I = f1;
      this.G = f1;
      this.J = MotionEventCompat.getPointerId(paramMotionEvent, 0);
      i1 = i4;
      continue;
      float f2;
      if (!this.A)
      {
        i1 = MotionEventCompat.findPointerIndex(paramMotionEvent, this.J);
        f1 = MotionEventCompat.getY(paramMotionEvent, i1);
        float f3 = Math.abs(f1 - this.G);
        f2 = MotionEventCompat.getX(paramMotionEvent, i1);
        float f4 = Math.abs(f2 - this.F);
        if ((f3 > this.E) && (f3 > f4))
        {
          this.A = true;
          c(true);
          if (f1 - this.I <= 0.0F) {
            break label378;
          }
        }
      }
      Object localObject;
      label378:
      for (f1 = this.I + this.E;; f1 = this.I - this.E)
      {
        this.G = f1;
        this.F = f2;
        setScrollState(1);
        setScrollingCacheEnabled(true);
        localObject = getParent();
        if (localObject != null) {
          ((ViewParent)localObject).requestDisallowInterceptTouchEvent(true);
        }
        i1 = i4;
        if (!this.A) {
          break;
        }
        bool1 = false | b(MotionEventCompat.getY(paramMotionEvent, MotionEventCompat.findPointerIndex(paramMotionEvent, this.J)));
        break;
      }
      boolean bool1 = i4;
      if (this.A)
      {
        localObject = this.K;
        ((VelocityTracker)localObject).computeCurrentVelocity(1000, this.M);
        int i2 = (int)VelocityTrackerCompat.getYVelocity((VelocityTracker)localObject, this.J);
        this.y = true;
        i4 = getClientHeight();
        int i5 = getScrollY();
        localObject = i();
        a(a(((b)localObject).b, (i5 / i4 - ((b)localObject).e) / ((b)localObject).d, i2, (int)(MotionEventCompat.getY(paramMotionEvent, MotionEventCompat.findPointerIndex(paramMotionEvent, this.J)) - this.I)), true, true, i2);
        this.J = -1;
        j();
        boolean bool3 = this.R.onRelease();
        boolean bool2 = this.S.onRelease() | bool3;
        continue;
        bool2 = i4;
        if (this.A)
        {
          a(this.i, true, 0, false);
          this.J = -1;
          j();
          bool3 = this.R.onRelease();
          bool2 = this.S.onRelease() | bool3;
          continue;
          int i3 = MotionEventCompat.getActionIndex(paramMotionEvent);
          this.G = MotionEventCompat.getY(paramMotionEvent, i3);
          this.J = MotionEventCompat.getPointerId(paramMotionEvent, i3);
          i3 = i4;
          continue;
          a(paramMotionEvent);
          this.G = MotionEventCompat.getY(paramMotionEvent, MotionEventCompat.findPointerIndex(paramMotionEvent, this.J));
          i3 = i4;
        }
      }
    }
  }
  
  public void removeView(View paramView)
  {
    if (this.w)
    {
      removeViewInLayout(paramView);
      return;
    }
    super.removeView(paramView);
  }
  
  public void setAdapter(PagerAdapter paramPagerAdapter)
  {
    if (this.h != null)
    {
      this.h.unregisterDataSetObserver(this.n);
      this.h.startUpdate(this);
      int i1 = 0;
      while (i1 < this.e.size())
      {
        localObject = (b)this.e.get(i1);
        this.h.destroyItem(this, ((b)localObject).b, ((b)localObject).a);
        i1 += 1;
      }
      this.h.finishUpdate(this);
      this.e.clear();
      g();
      this.i = 0;
      scrollTo(0, 0);
    }
    Object localObject = this.h;
    this.h = paramPagerAdapter;
    this.b = 0;
    boolean bool;
    if (this.h != null)
    {
      if (this.n == null) {
        this.n = new e(null);
      }
      this.h.registerDataSetObserver(this.n);
      this.y = false;
      bool = this.T;
      this.T = true;
      this.b = this.h.getCount();
      if (this.j < 0) {
        break label260;
      }
      this.h.restoreState(this.k, this.l);
      a(this.j, false, true);
      this.j = -1;
      this.k = null;
      this.l = null;
    }
    for (;;)
    {
      if ((this.ac != null) && (localObject != paramPagerAdapter)) {
        this.ac.onAdapterChanged((PagerAdapter)localObject, paramPagerAdapter);
      }
      return;
      label260:
      if (!bool) {
        c();
      } else {
        requestLayout();
      }
    }
  }
  
  void setChildrenDrawingOrderEnabledCompat(boolean paramBoolean)
  {
    if ((Build.VERSION.SDK_INT < 7) || (this.ae == null)) {}
    try
    {
      this.ae = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[] { Boolean.TYPE });
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        try
        {
          this.ae.invoke(this, new Object[] { Boolean.valueOf(paramBoolean) });
          return;
        }
        catch (Exception localException)
        {
          Log.e("ViewPager", "Error changing children drawing order", localException);
        }
        localNoSuchMethodException = localNoSuchMethodException;
        Log.e("ViewPager", "Can't find setChildrenDrawingOrderEnabled", localNoSuchMethodException);
      }
    }
  }
  
  public void setCurrentItem(int paramInt)
  {
    this.y = false;
    if (!this.T) {}
    for (boolean bool = true;; bool = false)
    {
      a(paramInt, bool, false);
      return;
    }
  }
  
  public void setCurrentItem(int paramInt, boolean paramBoolean)
  {
    this.y = false;
    a(paramInt, paramBoolean, false);
  }
  
  public void setOffscreenPageLimit(int paramInt)
  {
    int i1 = paramInt;
    if (paramInt < 1)
    {
      Log.w("ViewPager", "Requested offscreen page limit " + paramInt + " too small; defaulting to " + 1);
      i1 = 1;
    }
    if (i1 != this.z)
    {
      this.z = i1;
      c();
    }
  }
  
  void setOnAdapterChangeListener(d paramd)
  {
    this.ac = paramd;
  }
  
  public void setOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    this.aa = paramOnPageChangeListener;
  }
  
  public void setPageMargin(int paramInt)
  {
    int i1 = this.o;
    this.o = paramInt;
    int i2 = getHeight();
    a(i2, i2, paramInt, i1);
    requestLayout();
  }
  
  public void setPageMarginDrawable(int paramInt)
  {
    setPageMarginDrawable(getContext().getResources().getDrawable(paramInt));
  }
  
  public void setPageMarginDrawable(Drawable paramDrawable)
  {
    this.p = paramDrawable;
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
  
  public void setPageTransformer(boolean paramBoolean, ViewPager.PageTransformer paramPageTransformer)
  {
    int i2 = 1;
    boolean bool1;
    boolean bool2;
    label28:
    int i1;
    if (Build.VERSION.SDK_INT >= 11)
    {
      if (paramPageTransformer == null) {
        break label75;
      }
      bool1 = true;
      if (this.ad == null) {
        break label81;
      }
      bool2 = true;
      if (bool1 == bool2) {
        break label87;
      }
      i1 = 1;
      label37:
      this.ad = paramPageTransformer;
      setChildrenDrawingOrderEnabledCompat(bool1);
      if (!bool1) {
        break label92;
      }
      if (paramBoolean) {
        i2 = 2;
      }
    }
    label75:
    label81:
    label87:
    label92:
    for (this.af = i2;; this.af = 0)
    {
      if (i1 != 0) {
        c();
      }
      return;
      bool1 = false;
      break;
      bool2 = false;
      break label28;
      i1 = 0;
      break label37;
    }
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == this.p);
  }
  
  public static class LayoutParams
    extends ViewGroup.LayoutParams
  {
    public boolean a;
    public int b;
    float c = 0.0F;
    boolean d;
    int e;
    int f;
    
    public LayoutParams()
    {
      super(-1);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, VerticalViewPager2.f());
      this.b = paramContext.getInteger(0, 48);
      paramContext.recycle();
    }
  }
  
  public static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = ParcelableCompat.newCreator(new ParcelableCompatCreatorCallbacks()
    {
      public VerticalViewPager2.SavedState createFromParcel(Parcel paramAnonymousParcel, ClassLoader paramAnonymousClassLoader)
      {
        return new VerticalViewPager2.SavedState(paramAnonymousParcel, paramAnonymousClassLoader);
      }
      
      public VerticalViewPager2.SavedState[] newArray(int paramAnonymousInt)
      {
        return new VerticalViewPager2.SavedState[paramAnonymousInt];
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
  
  static abstract interface a {}
  
  static class b
  {
    Object a;
    int b;
    boolean c;
    float d;
    float e;
  }
  
  class c
    extends AccessibilityDelegateCompat
  {
    c() {}
    
    private boolean a()
    {
      return (VerticalViewPager2.a(VerticalViewPager2.this) != null) && (VerticalViewPager2.a(VerticalViewPager2.this).getCount() > 1);
    }
    
    public void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
      paramAccessibilityEvent.setClassName(ViewPager.class.getName());
      paramView = AccessibilityRecordCompat.obtain();
      paramView.setScrollable(a());
      if ((paramAccessibilityEvent.getEventType() == 4096) && (VerticalViewPager2.a(VerticalViewPager2.this) != null))
      {
        paramView.setItemCount(VerticalViewPager2.a(VerticalViewPager2.this).getCount());
        paramView.setFromIndex(VerticalViewPager2.b(VerticalViewPager2.this));
        paramView.setToIndex(VerticalViewPager2.b(VerticalViewPager2.this));
      }
    }
    
    public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
    {
      super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
      paramAccessibilityNodeInfoCompat.setClassName(ViewPager.class.getName());
      paramAccessibilityNodeInfoCompat.setScrollable(a());
      if (VerticalViewPager2.this.internalCanScrollVertically(1)) {
        paramAccessibilityNodeInfoCompat.addAction(4096);
      }
      if (VerticalViewPager2.this.internalCanScrollVertically(-1)) {
        paramAccessibilityNodeInfoCompat.addAction(8192);
      }
    }
    
    public boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
    {
      if (super.performAccessibilityAction(paramView, paramInt, paramBundle)) {
        return true;
      }
      switch (paramInt)
      {
      default: 
        return false;
      case 4096: 
        if (VerticalViewPager2.this.internalCanScrollVertically(1))
        {
          VerticalViewPager2.this.setCurrentItem(VerticalViewPager2.b(VerticalViewPager2.this) + 1);
          return true;
        }
        return false;
      }
      if (VerticalViewPager2.this.internalCanScrollVertically(-1))
      {
        VerticalViewPager2.this.setCurrentItem(VerticalViewPager2.b(VerticalViewPager2.this) - 1);
        return true;
      }
      return false;
    }
  }
  
  static abstract interface d
  {
    public abstract void onAdapterChanged(PagerAdapter paramPagerAdapter1, PagerAdapter paramPagerAdapter2);
  }
  
  private class e
    extends DataSetObserver
  {
    private e() {}
    
    public void onChanged()
    {
      VerticalViewPager2.this.b();
    }
    
    public void onInvalidated()
    {
      VerticalViewPager2.this.b();
    }
  }
  
  static class f
    implements Comparator<View>
  {
    public int compare(View paramView1, View paramView2)
    {
      paramView1 = (VerticalViewPager2.LayoutParams)paramView1.getLayoutParams();
      paramView2 = (VerticalViewPager2.LayoutParams)paramView2.getLayoutParams();
      if (paramView1.a != paramView2.a)
      {
        if (paramView1.a) {
          return 1;
        }
        return -1;
      }
      return paramView1.e - paramView2.e;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/view/widget/VerticalViewPager2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */