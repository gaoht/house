package com.ziroom.ziroomcustomer.home.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.ActionBar.c;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.util.n;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class CustomTabLayout
  extends HorizontalScrollView
{
  private final ArrayList<b> a = new ArrayList();
  private b b;
  private final SlidingTabStrip c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private ColorStateList i;
  private final int j;
  private final int k;
  private int l;
  private final int m;
  private int n;
  private int o;
  private int p;
  private int q = 18;
  private a r;
  private View.OnClickListener s;
  private d t;
  private d u;
  
  public CustomTabLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CustomTabLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CustomTabLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setHorizontalScrollBarEnabled(false);
    setFillViewport(true);
    this.c = new SlidingTabStrip(paramContext);
    addView(this.c, -2, -1);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, android.support.design.R.styleable.TabLayout, paramInt, 2131427329);
    this.q = paramContext.obtainStyledAttributes(paramAttributeSet, com.ziroom.ziroomcustomer.R.styleable.CustomTabLayout).getInteger(0, this.q);
    this.c.b(localTypedArray.getDimensionPixelSize(1, 0));
    this.c.a(localTypedArray.getColor(0, 0));
    this.h = localTypedArray.getResourceId(8, 2131427660);
    paramInt = localTypedArray.getDimensionPixelSize(15, 0);
    this.g = paramInt;
    this.f = paramInt;
    this.e = paramInt;
    this.d = paramInt;
    this.d = localTypedArray.getDimensionPixelSize(11, this.d);
    this.e = localTypedArray.getDimensionPixelSize(12, this.e);
    this.f = localTypedArray.getDimensionPixelSize(13, this.f);
    this.g = localTypedArray.getDimensionPixelSize(14, this.g);
    this.i = e(this.h);
    if (localTypedArray.hasValue(9)) {
      this.i = localTypedArray.getColorStateList(9);
    }
    if (localTypedArray.hasValue(10))
    {
      paramInt = localTypedArray.getColor(10, 0);
      this.i = a(this.i.getDefaultColor(), paramInt);
    }
    this.k = localTypedArray.getDimensionPixelSize(6, 0);
    this.m = localTypedArray.getDimensionPixelSize(7, 0);
    this.j = localTypedArray.getResourceId(3, 0);
    this.n = localTypedArray.getDimensionPixelSize(2, 0);
    this.p = localTypedArray.getInt(4, 1);
    this.o = localTypedArray.getInt(5, 0);
    localTypedArray.recycle();
    c();
  }
  
  private int a(int paramInt, float paramFloat)
  {
    int i1 = 0;
    int i2 = 0;
    View localView2;
    View localView1;
    if (this.p == 0)
    {
      localView2 = this.c.getChildAt(paramInt);
      if (paramInt + 1 >= this.c.getChildCount()) {
        break label110;
      }
      localView1 = this.c.getChildAt(paramInt + 1);
      if (localView2 == null) {
        break label116;
      }
    }
    label110:
    label116:
    for (paramInt = localView2.getWidth();; paramInt = 0)
    {
      i1 = i2;
      if (localView1 != null) {
        i1 = localView1.getWidth();
      }
      i2 = localView2.getLeft();
      i1 = (int)((i1 + paramInt) * paramFloat * 0.5F) + i2 + localView2.getWidth() / 2 - getWidth() / 2;
      return i1;
      localView1 = null;
      break;
    }
  }
  
  private static ColorStateList a(int paramInt1, int paramInt2)
  {
    return new ColorStateList(new int[][] { SELECTED_STATE_SET, EMPTY_STATE_SET }, new int[] { paramInt2, paramInt1 });
  }
  
  private void a()
  {
    int i1 = 0;
    int i2 = this.c.getChildCount();
    while (i1 < i2)
    {
      a(i1);
      i1 += 1;
    }
  }
  
  private void a(int paramInt)
  {
    TabView localTabView = (TabView)this.c.getChildAt(paramInt);
    if (localTabView != null) {
      localTabView.a();
    }
  }
  
  private void a(LinearLayout.LayoutParams paramLayoutParams)
  {
    if ((this.p == 1) && (this.o == 0))
    {
      paramLayoutParams.width = 0;
      paramLayoutParams.weight = 1.0F;
      return;
    }
    paramLayoutParams.width = -2;
    paramLayoutParams.weight = 0.0F;
  }
  
  private void a(b paramb, int paramInt)
  {
    paramb.a(paramInt);
    this.a.add(paramInt, paramb);
    int i1 = this.a.size();
    paramInt += 1;
    while (paramInt < i1)
    {
      ((b)this.a.get(paramInt)).a(paramInt);
      paramInt += 1;
    }
  }
  
  private void a(b paramb, int paramInt, boolean paramBoolean)
  {
    paramb = b(paramb);
    this.c.addView(paramb, paramInt, b());
    if (paramBoolean) {
      paramb.setSelected(true);
    }
  }
  
  private int b(int paramInt)
  {
    return Math.round(getResources().getDisplayMetrics().density * paramInt);
  }
  
  private LinearLayout.LayoutParams b()
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -1);
    a(localLayoutParams);
    return localLayoutParams;
  }
  
  private TabView b(b paramb)
  {
    paramb = new TabView(getContext(), paramb);
    paramb.setFocusable(true);
    if (this.s == null) {
      this.s = new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          ((CustomTabLayout.TabView)paramAnonymousView).getTab().select();
        }
      };
    }
    paramb.setOnClickListener(this.s);
    return paramb;
  }
  
  private void b(b paramb, boolean paramBoolean)
  {
    paramb = b(paramb);
    this.c.addView(paramb, b());
    if (paramBoolean) {
      paramb.setSelected(true);
    }
  }
  
  private void c()
  {
    if (this.p == 0) {}
    for (int i1 = Math.max(0, this.n - this.d);; i1 = 0)
    {
      ViewCompat.setPaddingRelative(this.c, i1, 0, 0, 0);
      switch (this.p)
      {
      }
      for (;;)
      {
        d();
        return;
        this.c.setGravity(8388611);
        continue;
        this.c.setGravity(1);
      }
    }
  }
  
  private void c(int paramInt)
  {
    this.c.removeViewAt(paramInt);
    requestLayout();
  }
  
  private void d()
  {
    int i1 = 0;
    while (i1 < this.c.getChildCount())
    {
      View localView = this.c.getChildAt(i1);
      a((LinearLayout.LayoutParams)localView.getLayoutParams());
      localView.requestLayout();
      i1 += 1;
    }
  }
  
  private void d(int paramInt)
  {
    if (paramInt != -1)
    {
      if ((getWindowToken() != null) && (ViewCompat.isLaidOut(this)) && (!this.c.a()))
      {
        int i1 = getScrollX();
        int i2 = a(paramInt, 0.0F);
        if (i1 != i2)
        {
          if (this.t == null)
          {
            this.t = g.a();
            this.t.setInterpolator(a.b);
            this.t.setDuration(300);
            this.t.setUpdateListener(new d.c()
            {
              public void onAnimationUpdate(d paramAnonymousd)
              {
                CustomTabLayout.this.scrollTo(paramAnonymousd.getAnimatedIntValue(), 0);
              }
            });
          }
          this.t.setIntValues(i1, i2);
          this.t.start();
        }
        this.c.a(paramInt, 300);
      }
    }
    else {
      return;
    }
    setScrollPosition(paramInt, 0.0F, true);
  }
  
  private ColorStateList e(int paramInt)
  {
    TypedArray localTypedArray = getContext().obtainStyledAttributes(paramInt, android.support.design.R.styleable.TextAppearance);
    try
    {
      ColorStateList localColorStateList = localTypedArray.getColorStateList(3);
      return localColorStateList;
    }
    finally
    {
      localTypedArray.recycle();
    }
  }
  
  private void setSelectedTabView(int paramInt)
  {
    int i2 = this.c.getChildCount();
    int i1 = 0;
    if (i1 < i2)
    {
      View localView = this.c.getChildAt(i1);
      if (i1 == paramInt) {}
      for (boolean bool = true;; bool = false)
      {
        localView.setSelected(bool);
        i1 += 1;
        break;
      }
    }
  }
  
  void a(b paramb)
  {
    a(paramb, true);
  }
  
  void a(b paramb, boolean paramBoolean)
  {
    if (this.b == paramb)
    {
      if (this.b != null)
      {
        if (this.r != null) {
          this.r.onTabReselected(this.b);
        }
        d(paramb.getPosition());
      }
      return;
    }
    int i1;
    if (paramb != null)
    {
      i1 = paramb.getPosition();
      label53:
      setSelectedTabView(i1);
      if (paramBoolean)
      {
        if (((this.b != null) && (this.b.getPosition() != -1)) || (i1 == -1)) {
          break label157;
        }
        setScrollPosition(i1, 0.0F, true);
      }
    }
    for (;;)
    {
      if ((this.b != null) && (this.r != null)) {
        this.r.onTabUnselected(this.b);
      }
      this.b = paramb;
      if ((this.b == null) || (this.r == null)) {
        break;
      }
      this.r.onTabSelected(this.b);
      return;
      i1 = -1;
      break label53;
      label157:
      d(i1);
    }
  }
  
  public void addTab(b paramb)
  {
    addTab(paramb, this.a.isEmpty());
  }
  
  public void addTab(b paramb, int paramInt)
  {
    addTab(paramb, paramInt, this.a.isEmpty());
  }
  
  public void addTab(b paramb, int paramInt, boolean paramBoolean)
  {
    if (b.a(paramb) != this) {
      throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }
    a(paramb, paramInt, paramBoolean);
    a(paramb, paramInt);
    if (paramBoolean) {
      paramb.select();
    }
  }
  
  public void addTab(b paramb, boolean paramBoolean)
  {
    if (b.a(paramb) != this) {
      throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }
    b(paramb, paramBoolean);
    a(paramb, this.a.size());
    if (paramBoolean) {
      paramb.select();
    }
  }
  
  public int getSelectedTabPosition()
  {
    if (this.b != null) {
      return this.b.getPosition();
    }
    return -1;
  }
  
  public b getTabAt(int paramInt)
  {
    return (b)this.a.get(paramInt);
  }
  
  public int getTabCount()
  {
    return this.a.size();
  }
  
  public int getTabGravity()
  {
    return this.o;
  }
  
  public int getTabMode()
  {
    return this.p;
  }
  
  public ColorStateList getTabTextColors()
  {
    return this.i;
  }
  
  public b newTab()
  {
    return new b(this);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i1 = b(48) + getPaddingTop() + getPaddingBottom();
    switch (View.MeasureSpec.getMode(paramInt2))
    {
    }
    for (;;)
    {
      super.onMeasure(paramInt1, paramInt2);
      if ((this.p == 1) && (getChildCount() == 1))
      {
        View localView = getChildAt(0);
        paramInt1 = getMeasuredWidth();
        if (localView.getMeasuredWidth() > paramInt1)
        {
          paramInt2 = getChildMeasureSpec(paramInt2, getPaddingTop() + getPaddingBottom(), localView.getLayoutParams().height);
          localView.measure(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), paramInt2);
        }
      }
      paramInt2 = this.m;
      i1 = getMeasuredWidth() - b(56);
      if (paramInt2 != 0)
      {
        paramInt1 = paramInt2;
        if (paramInt2 <= i1) {}
      }
      else
      {
        paramInt1 = i1;
      }
      this.l = paramInt1;
      return;
      paramInt2 = View.MeasureSpec.makeMeasureSpec(Math.min(i1, View.MeasureSpec.getSize(paramInt2)), 1073741824);
      continue;
      paramInt2 = View.MeasureSpec.makeMeasureSpec(i1, 1073741824);
    }
  }
  
  public void removeAllTabs()
  {
    this.c.removeAllViews();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      ((b)localIterator.next()).a(-1);
      localIterator.remove();
    }
    this.b = null;
  }
  
  public void removeTab(b paramb)
  {
    if (b.a(paramb) != this) {
      throw new IllegalArgumentException("Tab does not belong to this TabLayout.");
    }
    removeTabAt(paramb.getPosition());
  }
  
  public void removeTabAt(int paramInt)
  {
    if (this.b != null) {}
    for (int i1 = this.b.getPosition();; i1 = 0)
    {
      c(paramInt);
      localb = (b)this.a.remove(paramInt);
      if (localb != null) {
        localb.a(-1);
      }
      int i3 = this.a.size();
      int i2 = paramInt;
      while (i2 < i3)
      {
        ((b)this.a.get(i2)).a(i2);
        i2 += 1;
      }
    }
    if (i1 == paramInt) {
      if (!this.a.isEmpty()) {
        break label113;
      }
    }
    label113:
    for (b localb = null;; localb = (b)this.a.get(Math.max(0, paramInt - 1)))
    {
      a(localb);
      return;
    }
  }
  
  public void setOnTabSelectedListener(a parama)
  {
    this.r = parama;
  }
  
  public void setScrollPosition(int paramInt, float paramFloat, boolean paramBoolean)
  {
    if (((this.u == null) || (!this.u.isRunning())) && (paramInt >= 0) && (paramInt < this.c.getChildCount()))
    {
      this.c.a(paramInt, paramFloat);
      scrollTo(a(paramInt, paramFloat), 0);
      if (paramBoolean) {
        setSelectedTabView(Math.round(paramInt + paramFloat));
      }
    }
  }
  
  public void setTabGravity(int paramInt)
  {
    if (this.o != paramInt)
    {
      this.o = paramInt;
      c();
    }
  }
  
  public void setTabMode(int paramInt)
  {
    if (paramInt != this.p)
    {
      this.p = paramInt;
      c();
    }
  }
  
  public void setTabTextColors(int paramInt1, int paramInt2)
  {
    setTabTextColors(a(paramInt1, paramInt2));
  }
  
  public void setTabTextColors(ColorStateList paramColorStateList)
  {
    if (this.i != paramColorStateList)
    {
      this.i = paramColorStateList;
      a();
    }
  }
  
  public void setTabsFromPagerAdapter(PagerAdapter paramPagerAdapter)
  {
    removeAllTabs();
    int i1 = 0;
    int i2 = paramPagerAdapter.getCount();
    while (i1 < i2)
    {
      addTab(newTab().setText(paramPagerAdapter.getPageTitle(i1)));
      i1 += 1;
    }
  }
  
  public void setupWithViewPager(ViewPager paramViewPager)
  {
    PagerAdapter localPagerAdapter = paramViewPager.getAdapter();
    if (localPagerAdapter == null) {
      throw new IllegalArgumentException("ViewPager does not have a PagerAdapter set");
    }
    setTabsFromPagerAdapter(localPagerAdapter);
    paramViewPager.addOnPageChangeListener(new c(this));
    setOnTabSelectedListener(new d(paramViewPager));
    if ((this.b == null) || (this.b.getPosition() != paramViewPager.getCurrentItem())) {
      getTabAt(paramViewPager.getCurrentItem()).select();
    }
  }
  
  private class SlidingTabStrip
    extends LinearLayout
  {
    private int b;
    private final Paint c;
    private int d = -1;
    private float e;
    private int f = -1;
    private int g = -1;
    
    SlidingTabStrip(Context paramContext)
    {
      super();
      setWillNotDraw(false);
      this.c = new Paint();
      this.c.setColor(Color.parseColor("#ffa000"));
    }
    
    private void b()
    {
      int i = -1;
      View localView = getChildAt(this.d);
      int j;
      if ((localView != null) && (localView.getWidth() > 0))
      {
        i = localView.getLeft();
        int m = n.dip2px(getContext(), CustomTabLayout.e(CustomTabLayout.this)) + i;
        int k = localView.getRight() - n.dip2px(getContext(), CustomTabLayout.e(CustomTabLayout.this));
        i = k;
        j = m;
        if (this.e > 0.0F)
        {
          i = k;
          j = m;
          if (this.d < getChildCount() - 1)
          {
            localView = getChildAt(this.d + 1);
            float f1 = this.e;
            float f2 = localView.getLeft();
            float f3 = n.dip2px(getContext(), CustomTabLayout.e(CustomTabLayout.this));
            float f4 = this.e;
            j = (int)(m * (1.0F - f4) + (f1 * f2 + f3));
            f1 = this.e;
            f2 = localView.getRight();
            f3 = n.dip2px(getContext(), CustomTabLayout.e(CustomTabLayout.this));
            f4 = this.e;
            i = (int)(k * (1.0F - f4) + (f2 * f1 - f3));
          }
        }
      }
      for (;;)
      {
        b(j, i);
        return;
        j = -1;
      }
    }
    
    private void b(int paramInt1, int paramInt2)
    {
      if ((paramInt1 != this.f) || (paramInt2 != this.g))
      {
        this.f = paramInt1;
        this.g = paramInt2;
        ViewCompat.postInvalidateOnAnimation(this);
      }
    }
    
    void a(int paramInt)
    {
      this.c.setColor(paramInt);
      this.c.setColor(Color.parseColor("#ffa000"));
      ViewCompat.postInvalidateOnAnimation(this);
    }
    
    void a(int paramInt, float paramFloat)
    {
      if ((CustomTabLayout.a(CustomTabLayout.this) == null) || (!CustomTabLayout.a(CustomTabLayout.this).isRunning()))
      {
        this.d = paramInt;
        this.e = paramFloat;
        b();
      }
    }
    
    void a(final int paramInt1, int paramInt2)
    {
      final int i;
      Object localObject;
      final int k;
      final int m;
      final int j;
      if (ViewCompat.getLayoutDirection(this) == 1)
      {
        i = 1;
        localObject = getChildAt(paramInt1);
        k = ((View)localObject).getLeft() + n.dip2px(getContext(), CustomTabLayout.e(CustomTabLayout.this));
        m = ((View)localObject).getRight() - n.dip2px(getContext(), CustomTabLayout.e(CustomTabLayout.this));
        if (Math.abs(paramInt1 - this.d) > 1) {
          break label178;
        }
        i = this.f;
        j = this.g;
      }
      for (;;)
      {
        if ((i != k) || (j != m))
        {
          localObject = CustomTabLayout.a(CustomTabLayout.this, g.a());
          ((d)localObject).setInterpolator(a.b);
          ((d)localObject).setDuration(paramInt2);
          ((d)localObject).setFloatValues(0.0F, 1.0F);
          ((d)localObject).setUpdateListener(new d.c()
          {
            public void onAnimationUpdate(d paramAnonymousd)
            {
              float f = paramAnonymousd.getAnimatedFraction();
              CustomTabLayout.SlidingTabStrip.a(CustomTabLayout.SlidingTabStrip.this, a.a(i, k, f), a.a(j, m, f));
            }
          });
          ((d)localObject).setListener(new d.b()
          {
            public void onAnimationCancel(d paramAnonymousd)
            {
              CustomTabLayout.SlidingTabStrip.a(CustomTabLayout.SlidingTabStrip.this, paramInt1);
              CustomTabLayout.SlidingTabStrip.a(CustomTabLayout.SlidingTabStrip.this, 0.0F);
            }
            
            public void onAnimationEnd(d paramAnonymousd)
            {
              CustomTabLayout.SlidingTabStrip.a(CustomTabLayout.SlidingTabStrip.this, paramInt1);
              CustomTabLayout.SlidingTabStrip.a(CustomTabLayout.SlidingTabStrip.this, 0.0F);
            }
          });
          ((d)localObject).start();
        }
        return;
        i = 0;
        break;
        label178:
        j = CustomTabLayout.a(CustomTabLayout.this, 24);
        if (paramInt1 < this.d)
        {
          if (i != 0)
          {
            j = k - j;
            i = j;
          }
          else
          {
            j = m + j;
            i = j;
          }
        }
        else if (i != 0)
        {
          j = m + j;
          i = j;
        }
        else
        {
          j = k - j;
          i = j;
        }
      }
    }
    
    boolean a()
    {
      boolean bool2 = false;
      int j = getChildCount();
      int i = 0;
      for (;;)
      {
        boolean bool1 = bool2;
        if (i < j)
        {
          if (getChildAt(i).getWidth() <= 0) {
            bool1 = true;
          }
        }
        else {
          return bool1;
        }
        i += 1;
      }
    }
    
    void b(int paramInt)
    {
      this.b = paramInt;
      ViewCompat.postInvalidateOnAnimation(this);
    }
    
    public void draw(Canvas paramCanvas)
    {
      super.draw(paramCanvas);
      if ((this.f >= 0) && (this.g > this.f)) {
        paramCanvas.drawRect(this.f, getHeight() - this.b, this.g, getHeight(), this.c);
      }
    }
    
    protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      b();
    }
    
    protected void onMeasure(int paramInt1, int paramInt2)
    {
      super.onMeasure(paramInt1, paramInt2);
      int k;
      int i;
      Object localObject;
      if ((View.MeasureSpec.getMode(paramInt1) == 1073741824) && (CustomTabLayout.b(CustomTabLayout.this) == 1) && (CustomTabLayout.c(CustomTabLayout.this) == 1))
      {
        k = getChildCount();
        int m = View.MeasureSpec.makeMeasureSpec(0, 0);
        j = 0;
        i = 0;
        while (j < k)
        {
          localObject = getChildAt(j);
          ((View)localObject).measure(m, paramInt2);
          i = Math.max(i, ((View)localObject).getMeasuredWidth());
          j += 1;
        }
        if (i > 0) {}
      }
      else
      {
        return;
      }
      int j = CustomTabLayout.a(CustomTabLayout.this, 16);
      if (i * k <= getMeasuredWidth() - j * 2)
      {
        j = 0;
        while (j < k)
        {
          localObject = (LinearLayout.LayoutParams)getChildAt(j).getLayoutParams();
          ((LinearLayout.LayoutParams)localObject).width = i;
          ((LinearLayout.LayoutParams)localObject).weight = 0.0F;
          j += 1;
        }
      }
      CustomTabLayout.b(CustomTabLayout.this, 0);
      CustomTabLayout.d(CustomTabLayout.this);
      super.onMeasure(paramInt1, paramInt2);
    }
  }
  
  class TabView
    extends LinearLayout
    implements View.OnLongClickListener
  {
    private final CustomTabLayout.b b;
    private TextView c;
    private ImageView d;
    private View e;
    private TextView f;
    private ImageView g;
    
    public TabView(Context paramContext, CustomTabLayout.b paramb)
    {
      super();
      this.b = paramb;
      if (CustomTabLayout.f(CustomTabLayout.this) != 0) {}
      ViewCompat.setPaddingRelative(this, CustomTabLayout.g(CustomTabLayout.this), CustomTabLayout.h(CustomTabLayout.this), CustomTabLayout.i(CustomTabLayout.this), CustomTabLayout.j(CustomTabLayout.this));
      setGravity(17);
      a();
      this.c.getPaint().setFakeBoldText(true);
    }
    
    private void a(CustomTabLayout.b paramb, TextView paramTextView, ImageView paramImageView)
    {
      Drawable localDrawable = paramb.getIcon();
      CharSequence localCharSequence = paramb.getText();
      int i;
      if (paramImageView != null)
      {
        if (localDrawable != null)
        {
          paramImageView.setImageDrawable(localDrawable);
          paramImageView.setVisibility(0);
          setVisibility(0);
          paramImageView.setContentDescription(paramb.getContentDescription());
        }
      }
      else
      {
        if (TextUtils.isEmpty(localCharSequence)) {
          break label124;
        }
        i = 1;
        label56:
        if (paramTextView != null)
        {
          if (i == 0) {
            break label130;
          }
          paramTextView.setText(localCharSequence);
          paramTextView.setContentDescription(paramb.getContentDescription());
          paramTextView.setVisibility(0);
          setVisibility(0);
        }
      }
      for (;;)
      {
        if ((i != 0) || (TextUtils.isEmpty(paramb.getContentDescription()))) {
          break label144;
        }
        setOnLongClickListener(this);
        return;
        paramImageView.setVisibility(8);
        paramImageView.setImageDrawable(null);
        break;
        label124:
        i = 0;
        break label56;
        label130:
        paramTextView.setVisibility(8);
        paramTextView.setText(null);
      }
      label144:
      setOnLongClickListener(null);
      setLongClickable(false);
    }
    
    final void a()
    {
      CustomTabLayout.b localb = this.b;
      Object localObject = localb.a();
      if (localObject != null)
      {
        ViewParent localViewParent = ((View)localObject).getParent();
        if (localViewParent != this)
        {
          if (localViewParent != null) {
            ((ViewGroup)localViewParent).removeView((View)localObject);
          }
          addView((View)localObject);
        }
        this.e = ((View)localObject);
        if (this.c != null) {
          this.c.setVisibility(8);
        }
        if (this.d != null)
        {
          this.d.setVisibility(8);
          this.d.setImageDrawable(null);
        }
        if (this.e != null) {
          break label253;
        }
        if (this.d == null)
        {
          localObject = (ImageView)LayoutInflater.from(getContext()).inflate(2130903750, this, false);
          addView((View)localObject, 0);
          this.d = ((ImageView)localObject);
        }
        if (this.c == null)
        {
          localObject = (TextView)LayoutInflater.from(getContext()).inflate(2130903751, this, false);
          addView((View)localObject);
          this.c = ((TextView)localObject);
        }
        this.c.setTextAppearance(getContext(), CustomTabLayout.m(CustomTabLayout.this));
        if (CustomTabLayout.n(CustomTabLayout.this) != null) {
          this.c.setTextColor(CustomTabLayout.n(CustomTabLayout.this));
        }
        a(localb, this.c, this.d);
      }
      label253:
      while ((this.f == null) && (this.g == null))
      {
        return;
        if (this.e != null)
        {
          removeView(this.e);
          this.e = null;
        }
        this.f = null;
        this.g = null;
        break;
      }
      a(localb, this.f, this.g);
    }
    
    public CustomTabLayout.b getTab()
    {
      return this.b;
    }
    
    @TargetApi(14)
    public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
    {
      super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
      paramAccessibilityEvent.setClassName(ActionBar.c.class.getName());
    }
    
    @TargetApi(14)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
    {
      super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
      paramAccessibilityNodeInfo.setClassName(ActionBar.c.class.getName());
    }
    
    public boolean onLongClick(View paramView)
    {
      paramView = new int[2];
      getLocationOnScreen(paramView);
      Object localObject = getContext();
      int i = getWidth();
      int j = getHeight();
      int k = ((Context)localObject).getResources().getDisplayMetrics().widthPixels;
      localObject = Toast.makeText((Context)localObject, this.b.getContentDescription(), 0);
      ((Toast)localObject).setGravity(49, paramView[0] + i / 2 - k / 2, j);
      if (!(localObject instanceof Toast)) {
        ((Toast)localObject).show();
      }
      for (;;)
      {
        return true;
        VdsAgent.showToast((Toast)localObject);
      }
    }
    
    public void onMeasure(int paramInt1, int paramInt2)
    {
      super.onMeasure(paramInt1, paramInt2);
      paramInt1 = getMeasuredWidth();
      if ((paramInt1 < CustomTabLayout.k(CustomTabLayout.this)) || (paramInt1 > CustomTabLayout.l(CustomTabLayout.this))) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(c.a(paramInt1, CustomTabLayout.k(CustomTabLayout.this), CustomTabLayout.l(CustomTabLayout.this)), 1073741824), paramInt2);
      }
    }
    
    public void setSelected(boolean paramBoolean)
    {
      if (isSelected() != paramBoolean) {}
      for (int i = 1;; i = 0)
      {
        super.setSelected(paramBoolean);
        if ((i != 0) && (paramBoolean))
        {
          sendAccessibilityEvent(4);
          if (this.c != null) {
            this.c.setSelected(paramBoolean);
          }
          if (this.d != null) {
            this.d.setSelected(paramBoolean);
          }
        }
        return;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void onTabReselected(CustomTabLayout.b paramb);
    
    public abstract void onTabSelected(CustomTabLayout.b paramb);
    
    public abstract void onTabUnselected(CustomTabLayout.b paramb);
  }
  
  public static final class b
  {
    private Object a;
    private Drawable b;
    private CharSequence c;
    private CharSequence d;
    private int e = -1;
    private View f;
    private final CustomTabLayout g;
    
    b(CustomTabLayout paramCustomTabLayout)
    {
      this.g = paramCustomTabLayout;
    }
    
    View a()
    {
      return this.f;
    }
    
    void a(int paramInt)
    {
      this.e = paramInt;
    }
    
    public CharSequence getContentDescription()
    {
      return this.d;
    }
    
    public Drawable getIcon()
    {
      return this.b;
    }
    
    public int getPosition()
    {
      return this.e;
    }
    
    public Object getTag()
    {
      return this.a;
    }
    
    public CharSequence getText()
    {
      return this.c;
    }
    
    public boolean isSelected()
    {
      return this.g.getSelectedTabPosition() == this.e;
    }
    
    public void select()
    {
      this.g.a(this);
    }
    
    public b setContentDescription(int paramInt)
    {
      return setContentDescription(this.g.getResources().getText(paramInt));
    }
    
    public b setContentDescription(CharSequence paramCharSequence)
    {
      this.d = paramCharSequence;
      if (this.e >= 0) {
        CustomTabLayout.c(this.g, this.e);
      }
      return this;
    }
    
    public b setCustomView(int paramInt)
    {
      return setCustomView(LayoutInflater.from(this.g.getContext()).inflate(paramInt, null));
    }
    
    public b setCustomView(View paramView)
    {
      this.f = paramView;
      if (this.e >= 0) {
        CustomTabLayout.c(this.g, this.e);
      }
      return this;
    }
    
    public b setIcon(int paramInt)
    {
      return setIcon(this.g.getContext().getResources().getDrawable(paramInt));
    }
    
    public b setIcon(Drawable paramDrawable)
    {
      this.b = paramDrawable;
      if (this.e >= 0) {
        CustomTabLayout.c(this.g, this.e);
      }
      return this;
    }
    
    public b setTag(Object paramObject)
    {
      this.a = paramObject;
      return this;
    }
    
    public b setText(int paramInt)
    {
      return setText(this.g.getResources().getText(paramInt));
    }
    
    public b setText(CharSequence paramCharSequence)
    {
      this.c = paramCharSequence;
      if (this.e >= 0) {
        CustomTabLayout.c(this.g, this.e);
      }
      return this;
    }
  }
  
  public static class c
    implements ViewPager.OnPageChangeListener
  {
    private final WeakReference<CustomTabLayout> a;
    private int b;
    private int c;
    
    public c(CustomTabLayout paramCustomTabLayout)
    {
      this.a = new WeakReference(paramCustomTabLayout);
    }
    
    public void onPageScrollStateChanged(int paramInt)
    {
      this.b = this.c;
      this.c = paramInt;
    }
    
    public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
    {
      boolean bool2 = true;
      CustomTabLayout localCustomTabLayout = (CustomTabLayout)this.a.get();
      if (localCustomTabLayout != null)
      {
        bool1 = bool2;
        if (this.c != 1) {
          if ((this.c != 2) || (this.b != 1)) {
            break label62;
          }
        }
      }
      label62:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        localCustomTabLayout.setScrollPosition(paramInt1, paramFloat, bool1);
        return;
      }
    }
    
    public void onPageSelected(int paramInt)
    {
      CustomTabLayout localCustomTabLayout = (CustomTabLayout)this.a.get();
      CustomTabLayout.b localb;
      if (localCustomTabLayout != null)
      {
        localb = localCustomTabLayout.getTabAt(paramInt);
        if (this.c != 0) {
          break label39;
        }
      }
      label39:
      for (boolean bool = true;; bool = false)
      {
        localCustomTabLayout.a(localb, bool);
        return;
      }
    }
  }
  
  public static class d
    implements CustomTabLayout.a
  {
    private final ViewPager a;
    
    public d(ViewPager paramViewPager)
    {
      this.a = paramViewPager;
    }
    
    public void onTabReselected(CustomTabLayout.b paramb) {}
    
    public void onTabSelected(CustomTabLayout.b paramb)
    {
      this.a.setCurrentItem(paramb.getPosition());
    }
    
    public void onTabUnselected(CustomTabLayout.b paramb) {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/home/view/CustomTabLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */