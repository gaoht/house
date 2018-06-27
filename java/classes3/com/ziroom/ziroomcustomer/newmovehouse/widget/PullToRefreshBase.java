package com.ziroom.ziroomcustomer.newmovehouse.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.ziroom.ziroomcustomer.R.styleable;
import com.ziroom.ziroomcustomer.newmovehouse.widget.internal.FlipLoadingLayout;
import com.ziroom.ziroomcustomer.newmovehouse.widget.internal.LoadingLayout;
import com.ziroom.ziroomcustomer.newmovehouse.widget.internal.RotateLoadingLayout;

public abstract class PullToRefreshBase<T extends View>
  extends LinearLayout
{
  T a;
  private int b;
  private float c;
  private float d;
  private float e;
  private float f;
  private boolean g = false;
  private i h = i.a;
  private b i = b.a();
  private b j;
  private FrameLayout k;
  private boolean l = true;
  private boolean m = false;
  private boolean n = true;
  private boolean o = true;
  private boolean p = true;
  private Interpolator q;
  private a r = a.a();
  private LoadingLayout s;
  private LoadingLayout t;
  private d<T> u;
  private e<T> v;
  private c<T> w;
  private PullToRefreshBase<T>.h x;
  
  public PullToRefreshBase(Context paramContext)
  {
    super(paramContext);
    b(paramContext, null);
  }
  
  public PullToRefreshBase(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b(paramContext, paramAttributeSet);
  }
  
  public PullToRefreshBase(Context paramContext, b paramb)
  {
    super(paramContext);
    this.i = paramb;
    b(paramContext, null);
  }
  
  public PullToRefreshBase(Context paramContext, b paramb, a parama)
  {
    super(paramContext);
    this.i = paramb;
    this.r = parama;
    b(paramContext, null);
  }
  
  private final void a(int paramInt, long paramLong)
  {
    a(paramInt, paramLong, 0L, null);
  }
  
  private final void a(int paramInt, long paramLong1, long paramLong2, f paramf)
  {
    if (this.x != null) {
      this.x.stop();
    }
    switch (4.a[getPullToRefreshScrollDirection().ordinal()])
    {
    }
    for (int i1 = getScrollY();; i1 = getScrollX())
    {
      if (i1 != paramInt)
      {
        if (this.q == null) {
          this.q = new DecelerateInterpolator();
        }
        this.x = new h(i1, paramInt, paramLong1, paramf);
        if (paramLong2 <= 0L) {
          break;
        }
        postDelayed(this.x, paramLong2);
      }
      return;
    }
    post(this.x);
  }
  
  private void a(Context paramContext, T paramT)
  {
    this.k = new FrameLayout(paramContext);
    this.k.addView(paramT, -1, -1);
    a(this.k, new LinearLayout.LayoutParams(-1, -1));
  }
  
  private final void b(int paramInt)
  {
    a(paramInt, 200L, 0L, new f()
    {
      public void onSmoothScrollFinished()
      {
        PullToRefreshBase.a(PullToRefreshBase.this, 0, 200L, 225L, null);
      }
    });
  }
  
  private void b(Context paramContext, AttributeSet paramAttributeSet)
  {
    TypedArray localTypedArray;
    switch (4.a[getPullToRefreshScrollDirection().ordinal()])
    {
    default: 
      setOrientation(1);
      setGravity(17);
      this.b = ViewConfiguration.get(paramContext).getScaledTouchSlop();
      localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.PullToRefresh);
      if (localTypedArray.hasValue(4)) {
        this.i = b.a(localTypedArray.getInteger(4, 0));
      }
      if (localTypedArray.hasValue(12)) {
        this.r = a.a(localTypedArray.getInteger(12, 0));
      }
      this.a = a(paramContext, paramAttributeSet);
      a(paramContext, this.a);
      this.s = a(paramContext, b.b, localTypedArray);
      this.t = a(paramContext, b.c, localTypedArray);
      if (localTypedArray.hasValue(0))
      {
        paramContext = localTypedArray.getDrawable(0);
        if (paramContext != null) {
          this.a.setBackgroundDrawable(paramContext);
        }
      }
      break;
    }
    for (;;)
    {
      if (localTypedArray.hasValue(9)) {
        this.o = localTypedArray.getBoolean(9, true);
      }
      if (localTypedArray.hasValue(13)) {
        this.m = localTypedArray.getBoolean(13, false);
      }
      a(localTypedArray);
      localTypedArray.recycle();
      g();
      return;
      setOrientation(0);
      break;
      if (localTypedArray.hasValue(16))
      {
        com.ziroom.ziroomcustomer.newmovehouse.widget.internal.a.warnDeprecation("ptrAdapterViewBackground", "ptrRefreshableViewBackground");
        paramContext = localTypedArray.getDrawable(16);
        if (paramContext != null) {
          this.a.setBackgroundDrawable(paramContext);
        }
      }
    }
  }
  
  private LinearLayout.LayoutParams getLoadingLayoutLayoutParams()
  {
    switch (4.a[getPullToRefreshScrollDirection().ordinal()])
    {
    default: 
      return new LinearLayout.LayoutParams(-1, -2);
    }
    return new LinearLayout.LayoutParams(-2, -1);
  }
  
  private int getMaximumPullScroll()
  {
    switch (4.a[getPullToRefreshScrollDirection().ordinal()])
    {
    default: 
      return Math.round(getHeight() / 2.0F);
    }
    return Math.round(getWidth() / 2.0F);
  }
  
  private void h()
  {
    if (this.u != null) {
      this.u.onRefresh(this);
    }
    do
    {
      do
      {
        return;
      } while (this.v == null);
      if (this.j == b.b)
      {
        this.v.onPullDownToRefresh(this);
        return;
      }
    } while (this.j != b.c);
    this.v.onPullUpToRefresh(this);
  }
  
  private boolean i()
  {
    switch (4.c[this.i.ordinal()])
    {
    }
    do
    {
      return false;
      return b();
      return a();
    } while ((!a()) && (!b()));
    return true;
  }
  
  private void j()
  {
    float f2;
    float f1;
    int i2;
    int i1;
    switch (4.a[getPullToRefreshScrollDirection().ordinal()])
    {
    default: 
      f2 = this.f;
      f1 = this.d;
      switch (4.c[this.j.ordinal()])
      {
      default: 
        i2 = Math.round(Math.min(f2 - f1, 0.0F) / 2.0F);
        i1 = getHeaderSize();
        label87:
        setHeaderScroll(i2);
        if ((i2 != 0) && (!isRefreshing()))
        {
          f1 = Math.abs(i2) / i1;
          switch (4.c[this.j.ordinal()])
          {
          default: 
            this.s.onPull(f1);
            label152:
            if ((this.h != i.b) && (i1 >= Math.abs(i2))) {
              a(i.b, new boolean[0]);
            }
            break;
          }
        }
        break;
      }
      break;
    }
    while ((this.h != i.b) || (i1 >= Math.abs(i2)))
    {
      return;
      f2 = this.e;
      f1 = this.c;
      break;
      i2 = Math.round(Math.max(f2 - f1, 0.0F) / 2.0F);
      i1 = getFooterSize();
      break label87;
      this.t.onPull(f1);
      break label152;
    }
    a(i.c, new boolean[0]);
  }
  
  protected abstract T a(Context paramContext, AttributeSet paramAttributeSet);
  
  protected b a(boolean paramBoolean1, boolean paramBoolean2)
  {
    b localb = new b();
    if ((paramBoolean1) && (this.i.showHeaderLoadingLayout())) {
      localb.addLayout(this.s);
    }
    if ((paramBoolean2) && (this.i.showFooterLoadingLayout())) {
      localb.addLayout(this.t);
    }
    return localb;
  }
  
  protected LoadingLayout a(Context paramContext, b paramb, TypedArray paramTypedArray)
  {
    paramContext = this.r.a(paramContext, paramb, getPullToRefreshScrollDirection(), paramTypedArray);
    paramContext.setVisibility(4);
    return paramContext;
  }
  
  protected final void a(int paramInt)
  {
    a(paramInt, getPullToRefreshScrollDuration());
  }
  
  protected final void a(int paramInt1, int paramInt2)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.k.getLayoutParams();
    switch (4.a[getPullToRefreshScrollDirection().ordinal()])
    {
    }
    do
    {
      do
      {
        return;
      } while (localLayoutParams.width == paramInt1);
      localLayoutParams.width = paramInt1;
      this.k.requestLayout();
      return;
    } while (localLayoutParams.height == paramInt2);
    localLayoutParams.height = paramInt2;
    this.k.requestLayout();
  }
  
  protected final void a(int paramInt, f paramf)
  {
    a(paramInt, getPullToRefreshScrollDuration(), 0L, paramf);
  }
  
  protected void a(TypedArray paramTypedArray) {}
  
  protected void a(Bundle paramBundle) {}
  
  protected final void a(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.addView(paramView, paramInt, paramLayoutParams);
  }
  
  protected final void a(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.addView(paramView, -1, paramLayoutParams);
  }
  
  final void a(i parami, boolean... paramVarArgs)
  {
    this.h = parami;
    Log.d("PullToRefresh", "State: " + this.h.name());
    switch (4.b[this.h.ordinal()])
    {
    }
    for (;;)
    {
      if (this.w != null) {
        this.w.onPullEvent(this, this.h, this.j);
      }
      return;
      e();
      continue;
      c();
      continue;
      d();
      continue;
      a(paramVarArgs[0]);
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    if (this.i.showHeaderLoadingLayout()) {
      this.s.refreshing();
    }
    if (this.i.showFooterLoadingLayout()) {
      this.t.refreshing();
    }
    if (paramBoolean)
    {
      if (this.l)
      {
        f local1 = new f()
        {
          public void onSmoothScrollFinished()
          {
            PullToRefreshBase.a(PullToRefreshBase.this);
          }
        };
        switch (4.c[this.j.ordinal()])
        {
        case 2: 
        default: 
          a(-getHeaderSize(), local1);
          return;
        }
        a(getFooterSize(), local1);
        return;
      }
      a(0);
      return;
    }
    h();
  }
  
  protected abstract boolean a();
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    Log.d("PullToRefresh", "addView: " + paramView.getClass().getSimpleName());
    View localView = getRefreshableView();
    if ((localView instanceof ViewGroup))
    {
      ((ViewGroup)localView).addView(paramView, paramInt, paramLayoutParams);
      return;
    }
    throw new UnsupportedOperationException("Refreshable View is not a ViewGroup so can't addView");
  }
  
  protected void b(Bundle paramBundle) {}
  
  protected abstract boolean b();
  
  protected void c()
  {
    switch (4.c[this.j.ordinal()])
    {
    default: 
      return;
    case 1: 
      this.t.pullToRefresh();
      return;
    }
    this.s.pullToRefresh();
  }
  
  protected void d()
  {
    switch (4.c[this.j.ordinal()])
    {
    default: 
      return;
    case 1: 
      this.t.releaseToRefresh();
      return;
    }
    this.s.releaseToRefresh();
  }
  
  public final boolean demo()
  {
    if ((this.i.showHeaderLoadingLayout()) && (b()))
    {
      b(-getHeaderSize() * 2);
      return true;
    }
    if ((this.i.showFooterLoadingLayout()) && (a()))
    {
      b(getFooterSize() * 2);
      return true;
    }
    return false;
  }
  
  protected void e()
  {
    this.g = false;
    this.p = true;
    this.s.reset();
    this.t.reset();
    a(0);
  }
  
  protected final void f()
  {
    int i6 = (int)(getMaximumPullScroll() * 1.2F);
    int i2 = getPaddingLeft();
    int i5 = getPaddingTop();
    int i3 = getPaddingRight();
    int i4 = getPaddingBottom();
    int i1;
    switch (4.a[getPullToRefreshScrollDirection().ordinal()])
    {
    default: 
      i1 = i4;
      i6 = i3;
      i3 = i5;
      i4 = i2;
      i2 = i6;
    }
    for (;;)
    {
      Log.d("PullToRefresh", String.format("Setting Padding. L: %d, T: %d, R: %d, B: %d", new Object[] { Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(i2), Integer.valueOf(i1) }));
      setPadding(i4, i3, i2, i1);
      return;
      if (this.i.showHeaderLoadingLayout()) {
        this.s.setWidth(i6);
      }
      for (i1 = -i6;; i1 = 0)
      {
        if (!this.i.showFooterLoadingLayout()) {
          break label206;
        }
        this.t.setWidth(i6);
        i2 = -i6;
        i3 = i5;
        i5 = i1;
        i1 = i4;
        i4 = i5;
        break;
      }
      label206:
      i3 = i5;
      i5 = i1;
      i1 = i4;
      i2 = 0;
      i4 = i5;
      continue;
      if (this.i.showHeaderLoadingLayout()) {
        this.s.setHeight(i6);
      }
      for (i1 = -i6;; i1 = 0)
      {
        if (!this.i.showFooterLoadingLayout()) {
          break label293;
        }
        this.t.setHeight(i6);
        i6 = -i6;
        i4 = i2;
        i5 = i1;
        i1 = i6;
        i2 = i3;
        i3 = i5;
        break;
      }
      label293:
      i4 = i2;
      i5 = i1;
      i1 = 0;
      i2 = i3;
      i3 = i5;
    }
  }
  
  protected void g()
  {
    Object localObject = getLoadingLayoutLayoutParams();
    if (this == this.s.getParent()) {
      removeView(this.s);
    }
    if (this.i.showHeaderLoadingLayout()) {
      a(this.s, 0, (ViewGroup.LayoutParams)localObject);
    }
    if (this == this.t.getParent()) {
      removeView(this.t);
    }
    if (this.i.showFooterLoadingLayout()) {
      a(this.t, (ViewGroup.LayoutParams)localObject);
    }
    f();
    if (this.i != b.d) {}
    for (localObject = this.i;; localObject = b.b)
    {
      this.j = ((b)localObject);
      return;
    }
  }
  
  public final b getCurrentMode()
  {
    return this.j;
  }
  
  public final boolean getFilterTouchEvents()
  {
    return this.n;
  }
  
  protected final LoadingLayout getFooterLayout()
  {
    return this.t;
  }
  
  protected final int getFooterSize()
  {
    return this.t.getContentSize();
  }
  
  protected final LoadingLayout getHeaderLayout()
  {
    return this.s;
  }
  
  protected final int getHeaderSize()
  {
    return this.s.getContentSize();
  }
  
  public final a getLoadingLayoutProxy()
  {
    return getLoadingLayoutProxy(true, true);
  }
  
  public final a getLoadingLayoutProxy(boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(paramBoolean1, paramBoolean2);
  }
  
  public final b getMode()
  {
    return this.i;
  }
  
  public abstract g getPullToRefreshScrollDirection();
  
  protected int getPullToRefreshScrollDuration()
  {
    return 200;
  }
  
  protected int getPullToRefreshScrollDurationLonger()
  {
    return 325;
  }
  
  public final T getRefreshableView()
  {
    return this.a;
  }
  
  protected FrameLayout getRefreshableViewWrapper()
  {
    return this.k;
  }
  
  public final boolean getShowViewWhileRefreshing()
  {
    return this.l;
  }
  
  public final i getState()
  {
    return this.h;
  }
  
  public final boolean isDisableScrollingWhileRefreshing()
  {
    return !isScrollingWhileRefreshingEnabled();
  }
  
  public final boolean isPullToRefreshEnabled()
  {
    return this.i.b();
  }
  
  public final boolean isPullToRefreshOverScrollEnabled()
  {
    return (Build.VERSION.SDK_INT >= 9) && (this.o) && (c.a(this.a));
  }
  
  public final boolean isRefreshing()
  {
    return (this.h == i.d) || (this.h == i.e);
  }
  
  public final boolean isScrollingWhileRefreshingEnabled()
  {
    return this.m;
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!isPullToRefreshEnabled()) {
      return false;
    }
    int i1 = paramMotionEvent.getAction();
    if ((i1 == 3) || (i1 == 1))
    {
      this.g = false;
      return false;
    }
    if ((i1 != 0) && (this.g)) {
      return true;
    }
    switch (i1)
    {
    }
    for (;;)
    {
      return this.g;
      if ((!this.m) && (isRefreshing())) {
        return true;
      }
      if (i())
      {
        float f3 = paramMotionEvent.getY();
        float f4 = paramMotionEvent.getX();
        float f2;
        switch (4.a[getPullToRefreshScrollDirection().ordinal()])
        {
        default: 
          f2 = f3 - this.d;
        }
        for (float f1 = f4 - this.c;; f1 = f3 - this.d)
        {
          float f5 = Math.abs(f2);
          if ((f5 <= this.b) || ((this.n) && (f5 <= Math.abs(f1)))) {
            break;
          }
          if ((!this.i.showHeaderLoadingLayout()) || (f2 < 1.0F) || (!b())) {
            break label273;
          }
          this.d = f3;
          this.c = f4;
          this.g = true;
          if (this.i != b.d) {
            break;
          }
          this.j = b.b;
          break;
          f2 = f4 - this.c;
        }
        label273:
        if ((this.i.showFooterLoadingLayout()) && (f2 <= -1.0F) && (a()))
        {
          this.d = f3;
          this.c = f4;
          this.g = true;
          if (this.i == b.d)
          {
            this.j = b.c;
            continue;
            if (i())
            {
              f1 = paramMotionEvent.getY();
              this.f = f1;
              this.d = f1;
              f1 = paramMotionEvent.getX();
              this.e = f1;
              this.c = f1;
              this.g = false;
            }
          }
        }
      }
    }
  }
  
  public final void onRefreshComplete()
  {
    if (isRefreshing()) {
      a(i.a, new boolean[0]);
    }
  }
  
  protected final void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof Bundle))
    {
      paramParcelable = (Bundle)paramParcelable;
      setMode(b.a(paramParcelable.getInt("ptr_mode", 0)));
      this.j = b.a(paramParcelable.getInt("ptr_current_mode", 0));
      this.m = paramParcelable.getBoolean("ptr_disable_scrolling", false);
      this.l = paramParcelable.getBoolean("ptr_show_refreshing_view", true);
      super.onRestoreInstanceState(paramParcelable.getParcelable("ptr_super"));
      i locali = i.a(paramParcelable.getInt("ptr_state", 0));
      if ((locali == i.d) || (locali == i.e)) {
        a(locali, new boolean[] { true });
      }
      a(paramParcelable);
      return;
    }
    super.onRestoreInstanceState(paramParcelable);
  }
  
  protected final Parcelable onSaveInstanceState()
  {
    Bundle localBundle = new Bundle();
    b(localBundle);
    localBundle.putInt("ptr_state", this.h.a());
    localBundle.putInt("ptr_mode", this.i.c());
    localBundle.putInt("ptr_current_mode", this.j.c());
    localBundle.putBoolean("ptr_disable_scrolling", this.m);
    localBundle.putBoolean("ptr_show_refreshing_view", this.l);
    localBundle.putParcelable("ptr_super", super.onSaveInstanceState());
    return localBundle;
  }
  
  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Log.d("PullToRefresh", String.format("onSizeChanged. W: %d, H: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    f();
    a(paramInt1, paramInt2);
    post(new Runnable()
    {
      public void run()
      {
        PullToRefreshBase.this.requestLayout();
      }
    });
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!isPullToRefreshEnabled()) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return false;
            if ((!this.m) && (isRefreshing())) {
              return true;
            }
          } while ((paramMotionEvent.getAction() == 0) && (paramMotionEvent.getEdgeFlags() != 0));
          switch (paramMotionEvent.getAction())
          {
          default: 
            return false;
          }
        } while (!i());
        float f1 = paramMotionEvent.getY();
        this.f = f1;
        this.d = f1;
        f1 = paramMotionEvent.getX();
        this.e = f1;
        this.c = f1;
        return true;
      } while (!this.g);
      this.d = paramMotionEvent.getY();
      this.c = paramMotionEvent.getX();
      j();
      return true;
    } while (!this.g);
    this.g = false;
    if ((this.h == i.c) && ((this.u != null) || (this.v != null)))
    {
      a(i.d, new boolean[] { true });
      return true;
    }
    if (isRefreshing())
    {
      a(0);
      return true;
    }
    a(i.a, new boolean[0]);
    return true;
  }
  
  public void setDisableScrollingWhileRefreshing(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      setScrollingWhileRefreshingEnabled(paramBoolean);
      return;
    }
  }
  
  public final void setFilterTouchEvents(boolean paramBoolean)
  {
    this.n = paramBoolean;
  }
  
  protected final void setHeaderScroll(int paramInt)
  {
    Log.d("PullToRefresh", "setHeaderScroll: " + paramInt);
    int i1 = getMaximumPullScroll();
    paramInt = Math.min(i1, Math.max(-i1, paramInt));
    if (this.p)
    {
      if (paramInt >= 0) {
        break label97;
      }
      this.s.setVisibility(0);
    }
    for (;;)
    {
      switch (4.a[getPullToRefreshScrollDirection().ordinal()])
      {
      default: 
        return;
        label97:
        if (paramInt > 0)
        {
          this.t.setVisibility(0);
        }
        else
        {
          this.s.setVisibility(4);
          this.t.setVisibility(4);
        }
        break;
      }
    }
    scrollTo(0, paramInt);
    return;
    scrollTo(paramInt, 0);
  }
  
  public void setLastUpdatedLabel(CharSequence paramCharSequence)
  {
    getLoadingLayoutProxy().setLastUpdatedLabel(paramCharSequence);
  }
  
  public void setLoadingDrawable(Drawable paramDrawable)
  {
    getLoadingLayoutProxy().setLoadingDrawable(paramDrawable);
  }
  
  public void setLoadingDrawable(Drawable paramDrawable, b paramb)
  {
    getLoadingLayoutProxy(paramb.showHeaderLoadingLayout(), paramb.showFooterLoadingLayout()).setLoadingDrawable(paramDrawable);
  }
  
  public void setLongClickable(boolean paramBoolean)
  {
    getRefreshableView().setLongClickable(paramBoolean);
  }
  
  public final void setMode(b paramb)
  {
    if (paramb != this.i)
    {
      Log.d("PullToRefresh", "Setting mode to: " + paramb);
      this.i = paramb;
      g();
    }
  }
  
  public void setOnPullEventListener(c<T> paramc)
  {
    this.w = paramc;
  }
  
  public final void setOnRefreshListener(d<T> paramd)
  {
    this.u = paramd;
    this.v = null;
  }
  
  public final void setOnRefreshListener(e<T> parame)
  {
    this.v = parame;
    this.u = null;
  }
  
  public void setPullLabel(CharSequence paramCharSequence)
  {
    getLoadingLayoutProxy().setPullLabel(paramCharSequence);
  }
  
  public void setPullLabel(CharSequence paramCharSequence, b paramb)
  {
    getLoadingLayoutProxy(paramb.showHeaderLoadingLayout(), paramb.showFooterLoadingLayout()).setPullLabel(paramCharSequence);
  }
  
  public final void setPullToRefreshEnabled(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (b localb = b.a();; localb = b.a)
    {
      setMode(localb);
      return;
    }
  }
  
  public final void setPullToRefreshOverScrollEnabled(boolean paramBoolean)
  {
    this.o = paramBoolean;
  }
  
  public final void setRefreshing()
  {
    setRefreshing(true);
  }
  
  public final void setRefreshing(boolean paramBoolean)
  {
    if (!isRefreshing()) {
      a(i.e, new boolean[] { paramBoolean });
    }
  }
  
  public void setRefreshingLabel(CharSequence paramCharSequence)
  {
    getLoadingLayoutProxy().setRefreshingLabel(paramCharSequence);
  }
  
  public void setRefreshingLabel(CharSequence paramCharSequence, b paramb)
  {
    getLoadingLayoutProxy(paramb.showHeaderLoadingLayout(), paramb.showFooterLoadingLayout()).setRefreshingLabel(paramCharSequence);
  }
  
  public void setReleaseLabel(CharSequence paramCharSequence)
  {
    setReleaseLabel(paramCharSequence, b.d);
  }
  
  public void setReleaseLabel(CharSequence paramCharSequence, b paramb)
  {
    getLoadingLayoutProxy(paramb.showHeaderLoadingLayout(), paramb.showFooterLoadingLayout()).setReleaseLabel(paramCharSequence);
  }
  
  public void setScrollAnimationInterpolator(Interpolator paramInterpolator)
  {
    this.q = paramInterpolator;
  }
  
  public final void setScrollingWhileRefreshingEnabled(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
  
  public final void setShowViewWhileRefreshing(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public static enum a
  {
    private a() {}
    
    static a a()
    {
      return a;
    }
    
    static a a(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return a;
      }
      return b;
    }
    
    LoadingLayout a(Context paramContext, PullToRefreshBase.b paramb, PullToRefreshBase.g paramg, TypedArray paramTypedArray)
    {
      switch (PullToRefreshBase.4.d[ordinal()])
      {
      default: 
        return new RotateLoadingLayout(paramContext, paramb, paramg, paramTypedArray);
      }
      return new FlipLoadingLayout(paramContext, paramb, paramg, paramTypedArray);
    }
  }
  
  public static enum b
  {
    public static b f = b;
    public static b g = c;
    private int h;
    
    private b(int paramInt)
    {
      this.h = paramInt;
    }
    
    static b a()
    {
      return b;
    }
    
    static b a(int paramInt)
    {
      b[] arrayOfb = values();
      int k = arrayOfb.length;
      int j = 0;
      while (j < k)
      {
        b localb = arrayOfb[j];
        if (paramInt == localb.c()) {
          return localb;
        }
        j += 1;
      }
      return a();
    }
    
    boolean b()
    {
      return (this != a) && (this != e);
    }
    
    int c()
    {
      return this.h;
    }
    
    public boolean showFooterLoadingLayout()
    {
      return (this == c) || (this == d) || (this == e);
    }
    
    public boolean showHeaderLoadingLayout()
    {
      return (this == b) || (this == d);
    }
  }
  
  public static abstract interface c<V extends View>
  {
    public abstract void onPullEvent(PullToRefreshBase<V> paramPullToRefreshBase, PullToRefreshBase.i parami, PullToRefreshBase.b paramb);
  }
  
  public static abstract interface d<V extends View>
  {
    public abstract void onRefresh(PullToRefreshBase<V> paramPullToRefreshBase);
  }
  
  public static abstract interface e<V extends View>
  {
    public abstract void onPullDownToRefresh(PullToRefreshBase<V> paramPullToRefreshBase);
    
    public abstract void onPullUpToRefresh(PullToRefreshBase<V> paramPullToRefreshBase);
  }
  
  static abstract interface f
  {
    public abstract void onSmoothScrollFinished();
  }
  
  public static enum g
  {
    private g() {}
  }
  
  final class h
    implements Runnable
  {
    private final Interpolator b;
    private final int c;
    private final int d;
    private final long e;
    private PullToRefreshBase.f f;
    private boolean g = true;
    private long h = -1L;
    private int i = -1;
    
    public h(int paramInt1, int paramInt2, long paramLong, PullToRefreshBase.f paramf)
    {
      this.d = paramInt1;
      this.c = paramInt2;
      this.b = PullToRefreshBase.b(PullToRefreshBase.this);
      this.e = paramLong;
      this.f = paramf;
    }
    
    public void run()
    {
      if (this.h == -1L)
      {
        this.h = System.currentTimeMillis();
        if ((!this.g) || (this.c == this.i)) {
          break label128;
        }
        com.ziroom.ziroomcustomer.newmovehouse.widget.internal.b.postOnAnimation(PullToRefreshBase.this, this);
      }
      label128:
      while (this.f == null)
      {
        return;
        long l = Math.max(Math.min((System.currentTimeMillis() - this.h) * 1000L / this.e, 1000L), 0L);
        float f1 = this.d - this.c;
        int j = Math.round(this.b.getInterpolation((float)l / 1000.0F) * f1);
        this.i = (this.d - j);
        PullToRefreshBase.this.setHeaderScroll(this.i);
        break;
      }
      this.f.onSmoothScrollFinished();
    }
    
    public void stop()
    {
      this.g = false;
      PullToRefreshBase.this.removeCallbacks(this);
    }
  }
  
  public static enum i
  {
    private int g;
    
    private i(int paramInt)
    {
      this.g = paramInt;
    }
    
    static i a(int paramInt)
    {
      i[] arrayOfi = values();
      int j = arrayOfi.length;
      int i = 0;
      while (i < j)
      {
        i locali = arrayOfi[i];
        if (paramInt == locali.a()) {
          return locali;
        }
        i += 1;
      }
      return a;
    }
    
    int a()
    {
      return this.g;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/widget/PullToRefreshBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */