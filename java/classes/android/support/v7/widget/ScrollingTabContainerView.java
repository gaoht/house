package android.support.v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBar.c;
import android.support.v7.appcompat.R.attr;
import android.support.v7.view.a;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;

public class ScrollingTabContainerView
  extends HorizontalScrollView
  implements AdapterView.OnItemSelectedListener
{
  private static final Interpolator l = new DecelerateInterpolator();
  Runnable a;
  LinearLayoutCompat b;
  int c;
  int d;
  protected ViewPropertyAnimator e;
  protected final c f = new c();
  private b g;
  private Spinner h;
  private boolean i;
  private int j;
  private int k;
  
  public ScrollingTabContainerView(Context paramContext)
  {
    super(paramContext);
    setHorizontalScrollBarEnabled(false);
    paramContext = a.get(paramContext);
    setContentHeight(paramContext.getTabContainerHeight());
    this.d = paramContext.getStackedTabMaxWidth();
    this.b = d();
    addView(this.b, new ViewGroup.LayoutParams(-2, -1));
  }
  
  private boolean a()
  {
    return (this.h != null) && (this.h.getParent() == this);
  }
  
  private void b()
  {
    if (a()) {
      return;
    }
    if (this.h == null) {
      this.h = e();
    }
    removeView(this.b);
    addView(this.h, new ViewGroup.LayoutParams(-2, -1));
    if (this.h.getAdapter() == null) {
      this.h.setAdapter(new a());
    }
    if (this.a != null)
    {
      removeCallbacks(this.a);
      this.a = null;
    }
    this.h.setSelection(this.k);
  }
  
  private boolean c()
  {
    if (!a()) {
      return false;
    }
    removeView(this.h);
    addView(this.b, new ViewGroup.LayoutParams(-2, -1));
    setTabSelected(this.h.getSelectedItemPosition());
    return false;
  }
  
  private LinearLayoutCompat d()
  {
    LinearLayoutCompat localLinearLayoutCompat = new LinearLayoutCompat(getContext(), null, R.attr.actionBarTabBarStyle);
    localLinearLayoutCompat.setMeasureWithLargestChildEnabled(true);
    localLinearLayoutCompat.setGravity(17);
    localLinearLayoutCompat.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
    return localLinearLayoutCompat;
  }
  
  private Spinner e()
  {
    AppCompatSpinner localAppCompatSpinner = new AppCompatSpinner(getContext(), null, R.attr.actionDropDownStyle);
    localAppCompatSpinner.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
    localAppCompatSpinner.setOnItemSelectedListener(this);
    return localAppCompatSpinner;
  }
  
  TabView a(ActionBar.c paramc, boolean paramBoolean)
  {
    paramc = new TabView(getContext(), paramc, paramBoolean);
    if (paramBoolean)
    {
      paramc.setBackgroundDrawable(null);
      paramc.setLayoutParams(new AbsListView.LayoutParams(-1, this.j));
      return paramc;
    }
    paramc.setFocusable(true);
    if (this.g == null) {
      this.g = new b();
    }
    paramc.setOnClickListener(this.g);
    return paramc;
  }
  
  public void addTab(ActionBar.c paramc, int paramInt, boolean paramBoolean)
  {
    paramc = a(paramc, false);
    this.b.addView(paramc, paramInt, new LinearLayoutCompat.LayoutParams(0, -1, 1.0F));
    if (this.h != null) {
      ((a)this.h.getAdapter()).notifyDataSetChanged();
    }
    if (paramBoolean) {
      paramc.setSelected(true);
    }
    if (this.i) {
      requestLayout();
    }
  }
  
  public void addTab(ActionBar.c paramc, boolean paramBoolean)
  {
    paramc = a(paramc, false);
    this.b.addView(paramc, new LinearLayoutCompat.LayoutParams(0, -1, 1.0F));
    if (this.h != null) {
      ((a)this.h.getAdapter()).notifyDataSetChanged();
    }
    if (paramBoolean) {
      paramc.setSelected(true);
    }
    if (this.i) {
      requestLayout();
    }
  }
  
  public void animateToTab(int paramInt)
  {
    final View localView = this.b.getChildAt(paramInt);
    if (this.a != null) {
      removeCallbacks(this.a);
    }
    this.a = new Runnable()
    {
      public void run()
      {
        int i = localView.getLeft();
        int j = (ScrollingTabContainerView.this.getWidth() - localView.getWidth()) / 2;
        ScrollingTabContainerView.this.smoothScrollTo(i - j, 0);
        ScrollingTabContainerView.this.a = null;
      }
    };
    post(this.a);
  }
  
  public void animateToVisibility(int paramInt)
  {
    if (this.e != null) {
      this.e.cancel();
    }
    if (paramInt == 0)
    {
      if (getVisibility() != 0) {
        setAlpha(0.0F);
      }
      localViewPropertyAnimator = animate().alpha(1.0F);
      localViewPropertyAnimator.setDuration(200L);
      localViewPropertyAnimator.setInterpolator(l);
      localViewPropertyAnimator.setListener(this.f.withFinalVisibility(localViewPropertyAnimator, paramInt));
      localViewPropertyAnimator.start();
      return;
    }
    ViewPropertyAnimator localViewPropertyAnimator = animate().alpha(0.0F);
    localViewPropertyAnimator.setDuration(200L);
    localViewPropertyAnimator.setInterpolator(l);
    localViewPropertyAnimator.setListener(this.f.withFinalVisibility(localViewPropertyAnimator, paramInt));
    localViewPropertyAnimator.start();
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.a != null) {
      post(this.a);
    }
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    paramConfiguration = a.get(getContext());
    setContentHeight(paramConfiguration.getTabContainerHeight());
    this.d = paramConfiguration.getStackedTabMaxWidth();
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.a != null) {
      removeCallbacks(this.a);
    }
  }
  
  @Instrumented
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    VdsAgent.onItemSelected(this, paramAdapterView, paramView, paramInt, paramLong);
    ((TabView)paramView).getTab().select();
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    paramInt2 = 1;
    int m = View.MeasureSpec.getMode(paramInt1);
    boolean bool;
    if (m == 1073741824)
    {
      bool = true;
      setFillViewport(bool);
      int n = this.b.getChildCount();
      if ((n <= 1) || ((m != 1073741824) && (m != Integer.MIN_VALUE))) {
        break label195;
      }
      if (n <= 2) {
        break label182;
      }
      this.c = ((int)(View.MeasureSpec.getSize(paramInt1) * 0.4F));
      label72:
      this.c = Math.min(this.c, this.d);
      label87:
      m = View.MeasureSpec.makeMeasureSpec(this.j, 1073741824);
      if ((bool) || (!this.i)) {
        break label203;
      }
      label110:
      if (paramInt2 == 0) {
        break label216;
      }
      this.b.measure(0, m);
      if (this.b.getMeasuredWidth() <= View.MeasureSpec.getSize(paramInt1)) {
        break label208;
      }
      b();
    }
    for (;;)
    {
      paramInt2 = getMeasuredWidth();
      super.onMeasure(paramInt1, m);
      paramInt1 = getMeasuredWidth();
      if ((bool) && (paramInt2 != paramInt1)) {
        setTabSelected(this.k);
      }
      return;
      bool = false;
      break;
      label182:
      this.c = (View.MeasureSpec.getSize(paramInt1) / 2);
      break label72;
      label195:
      this.c = -1;
      break label87;
      label203:
      paramInt2 = 0;
      break label110;
      label208:
      c();
      continue;
      label216:
      c();
    }
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView) {}
  
  public void removeAllTabs()
  {
    this.b.removeAllViews();
    if (this.h != null) {
      ((a)this.h.getAdapter()).notifyDataSetChanged();
    }
    if (this.i) {
      requestLayout();
    }
  }
  
  public void removeTabAt(int paramInt)
  {
    this.b.removeViewAt(paramInt);
    if (this.h != null) {
      ((a)this.h.getAdapter()).notifyDataSetChanged();
    }
    if (this.i) {
      requestLayout();
    }
  }
  
  public void setAllowCollapse(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public void setContentHeight(int paramInt)
  {
    this.j = paramInt;
    requestLayout();
  }
  
  public void setTabSelected(int paramInt)
  {
    this.k = paramInt;
    int n = this.b.getChildCount();
    int m = 0;
    if (m < n)
    {
      View localView = this.b.getChildAt(m);
      if (m == paramInt) {}
      for (boolean bool = true;; bool = false)
      {
        localView.setSelected(bool);
        if (bool) {
          animateToTab(paramInt);
        }
        m += 1;
        break;
      }
    }
    if ((this.h != null) && (paramInt >= 0)) {
      this.h.setSelection(paramInt);
    }
  }
  
  public void updateTab(int paramInt)
  {
    ((TabView)this.b.getChildAt(paramInt)).update();
    if (this.h != null) {
      ((a)this.h.getAdapter()).notifyDataSetChanged();
    }
    if (this.i) {
      requestLayout();
    }
  }
  
  private class TabView
    extends LinearLayoutCompat
  {
    private final int[] b = { 16842964 };
    private ActionBar.c c;
    private TextView d;
    private ImageView e;
    private View f;
    
    public TabView(Context paramContext, ActionBar.c paramc, boolean paramBoolean)
    {
      super(null, R.attr.actionBarTabStyle);
      this.c = paramc;
      this$1 = at.obtainStyledAttributes(paramContext, null, this.b, R.attr.actionBarTabStyle, 0);
      if (ScrollingTabContainerView.this.hasValue(0)) {
        setBackgroundDrawable(ScrollingTabContainerView.this.getDrawable(0));
      }
      ScrollingTabContainerView.this.recycle();
      if (paramBoolean) {
        setGravity(8388627);
      }
      update();
    }
    
    public void bindTab(ActionBar.c paramc)
    {
      this.c = paramc;
      update();
    }
    
    public ActionBar.c getTab()
    {
      return this.c;
    }
    
    public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
    {
      super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
      paramAccessibilityEvent.setClassName(ActionBar.c.class.getName());
    }
    
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
    {
      super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
      paramAccessibilityNodeInfo.setClassName(ActionBar.c.class.getName());
    }
    
    public void onMeasure(int paramInt1, int paramInt2)
    {
      super.onMeasure(paramInt1, paramInt2);
      if ((ScrollingTabContainerView.this.c > 0) && (getMeasuredWidth() > ScrollingTabContainerView.this.c)) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(ScrollingTabContainerView.this.c, 1073741824), paramInt2);
      }
    }
    
    public void setSelected(boolean paramBoolean)
    {
      if (isSelected() != paramBoolean) {}
      for (int i = 1;; i = 0)
      {
        super.setSelected(paramBoolean);
        if ((i != 0) && (paramBoolean)) {
          sendAccessibilityEvent(4);
        }
        return;
      }
    }
    
    public void update()
    {
      Object localObject1 = this.c;
      Object localObject2 = ((ActionBar.c)localObject1).getCustomView();
      if (localObject2 != null)
      {
        localObject1 = ((View)localObject2).getParent();
        if (localObject1 != this)
        {
          if (localObject1 != null) {
            ((ViewGroup)localObject1).removeView((View)localObject2);
          }
          addView((View)localObject2);
        }
        this.f = ((View)localObject2);
        if (this.d != null) {
          this.d.setVisibility(8);
        }
        if (this.e != null)
        {
          this.e.setVisibility(8);
          this.e.setImageDrawable(null);
        }
        return;
      }
      if (this.f != null)
      {
        removeView(this.f);
        this.f = null;
      }
      Object localObject3 = ((ActionBar.c)localObject1).getIcon();
      localObject2 = ((ActionBar.c)localObject1).getText();
      int i;
      if (localObject3 != null)
      {
        Object localObject4;
        if (this.e == null)
        {
          localObject4 = new AppCompatImageView(getContext());
          LinearLayoutCompat.LayoutParams localLayoutParams = new LinearLayoutCompat.LayoutParams(-2, -2);
          localLayoutParams.h = 16;
          ((ImageView)localObject4).setLayoutParams(localLayoutParams);
          addView((View)localObject4, 0);
          this.e = ((ImageView)localObject4);
        }
        this.e.setImageDrawable((Drawable)localObject3);
        this.e.setVisibility(0);
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label357;
        }
        i = 1;
        label209:
        if (i == 0) {
          break label362;
        }
        if (this.d == null)
        {
          localObject3 = new AppCompatTextView(getContext(), null, R.attr.actionBarTabTextStyle);
          ((TextView)localObject3).setEllipsize(TextUtils.TruncateAt.END);
          localObject4 = new LinearLayoutCompat.LayoutParams(-2, -2);
          ((LinearLayoutCompat.LayoutParams)localObject4).h = 16;
          ((TextView)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
          addView((View)localObject3);
          this.d = ((TextView)localObject3);
        }
        this.d.setText((CharSequence)localObject2);
        this.d.setVisibility(0);
        label300:
        if (this.e != null) {
          this.e.setContentDescription(((ActionBar.c)localObject1).getContentDescription());
        }
        if (i == 0) {
          break label389;
        }
      }
      label357:
      label362:
      label389:
      for (localObject1 = null;; localObject1 = ((ActionBar.c)localObject1).getContentDescription())
      {
        av.setTooltipText(this, (CharSequence)localObject1);
        return;
        if (this.e == null) {
          break;
        }
        this.e.setVisibility(8);
        this.e.setImageDrawable(null);
        break;
        i = 0;
        break label209;
        if (this.d == null) {
          break label300;
        }
        this.d.setVisibility(8);
        this.d.setText(null);
        break label300;
      }
    }
  }
  
  private class a
    extends BaseAdapter
  {
    a() {}
    
    public int getCount()
    {
      return ScrollingTabContainerView.this.b.getChildCount();
    }
    
    public Object getItem(int paramInt)
    {
      return ((ScrollingTabContainerView.TabView)ScrollingTabContainerView.this.b.getChildAt(paramInt)).getTab();
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null) {
        return ScrollingTabContainerView.this.a((ActionBar.c)getItem(paramInt), true);
      }
      ((ScrollingTabContainerView.TabView)paramView).bindTab((ActionBar.c)getItem(paramInt));
      return paramView;
    }
  }
  
  private class b
    implements View.OnClickListener
  {
    b() {}
    
    @Instrumented
    public void onClick(View paramView)
    {
      VdsAgent.onClick(this, paramView);
      ((ScrollingTabContainerView.TabView)paramView).getTab().select();
      int j = ScrollingTabContainerView.this.b.getChildCount();
      int i = 0;
      if (i < j)
      {
        View localView = ScrollingTabContainerView.this.b.getChildAt(i);
        if (localView == paramView) {}
        for (boolean bool = true;; bool = false)
        {
          localView.setSelected(bool);
          i += 1;
          break;
        }
      }
    }
  }
  
  protected class c
    extends AnimatorListenerAdapter
  {
    private boolean b = false;
    private int c;
    
    protected c() {}
    
    public void onAnimationCancel(Animator paramAnimator)
    {
      this.b = true;
    }
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      if (this.b) {
        return;
      }
      ScrollingTabContainerView.this.e = null;
      ScrollingTabContainerView.this.setVisibility(this.c);
    }
    
    public void onAnimationStart(Animator paramAnimator)
    {
      ScrollingTabContainerView.this.setVisibility(0);
      this.b = false;
    }
    
    public c withFinalVisibility(ViewPropertyAnimator paramViewPropertyAnimator, int paramInt)
    {
      this.c = paramInt;
      ScrollingTabContainerView.this.e = paramViewPropertyAnimator;
      return this;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/widget/ScrollingTabContainerView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */