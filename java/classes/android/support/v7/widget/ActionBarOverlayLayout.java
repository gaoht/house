package android.support.v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.NestedScrollingParentHelper;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.id;
import android.support.v7.view.menu.n.a;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.Window.Callback;
import android.widget.OverScroller;

public class ActionBarOverlayLayout
  extends ViewGroup
  implements NestedScrollingParent, t
{
  static final int[] e = { R.attr.actionBarSize, 16842841 };
  private final Runnable A = new Runnable()
  {
    public void run()
    {
      ActionBarOverlayLayout.this.c();
      ActionBarOverlayLayout.this.c = ActionBarOverlayLayout.this.a.animate().translationY(0.0F).setListener(ActionBarOverlayLayout.this.d);
    }
  };
  private final Runnable B = new Runnable()
  {
    public void run()
    {
      ActionBarOverlayLayout.this.c();
      ActionBarOverlayLayout.this.c = ActionBarOverlayLayout.this.a.animate().translationY(-ActionBarOverlayLayout.this.a.getHeight()).setListener(ActionBarOverlayLayout.this.d);
    }
  };
  private final NestedScrollingParentHelper C;
  ActionBarContainer a;
  boolean b;
  ViewPropertyAnimator c;
  final AnimatorListenerAdapter d = new AnimatorListenerAdapter()
  {
    public void onAnimationCancel(Animator paramAnonymousAnimator)
    {
      ActionBarOverlayLayout.this.c = null;
      ActionBarOverlayLayout.this.b = false;
    }
    
    public void onAnimationEnd(Animator paramAnonymousAnimator)
    {
      ActionBarOverlayLayout.this.c = null;
      ActionBarOverlayLayout.this.b = false;
    }
  };
  private int f;
  private int g = 0;
  private ContentFrameLayout h;
  private u i;
  private Drawable j;
  private boolean k;
  private boolean l;
  private boolean m;
  private boolean n;
  private int o;
  private int p;
  private final Rect q = new Rect();
  private final Rect r = new Rect();
  private final Rect s = new Rect();
  private final Rect t = new Rect();
  private final Rect u = new Rect();
  private final Rect v = new Rect();
  private final Rect w = new Rect();
  private a x;
  private final int y = 600;
  private OverScroller z;
  
  public ActionBarOverlayLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ActionBarOverlayLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
    this.C = new NestedScrollingParentHelper(this);
  }
  
  private u a(View paramView)
  {
    if ((paramView instanceof u)) {
      return (u)paramView;
    }
    if ((paramView instanceof Toolbar)) {
      return ((Toolbar)paramView).getWrapper();
    }
    throw new IllegalStateException("Can't make a decor toolbar out of " + paramView.getClass().getSimpleName());
  }
  
  private void a(Context paramContext)
  {
    boolean bool2 = true;
    TypedArray localTypedArray = getContext().getTheme().obtainStyledAttributes(e);
    this.f = localTypedArray.getDimensionPixelSize(0, 0);
    this.j = localTypedArray.getDrawable(1);
    if (this.j == null)
    {
      bool1 = true;
      setWillNotDraw(bool1);
      localTypedArray.recycle();
      if (paramContext.getApplicationInfo().targetSdkVersion >= 19) {
        break label94;
      }
    }
    label94:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.k = bool1;
      this.z = new OverScroller(paramContext);
      return;
      bool1 = false;
      break;
    }
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    boolean bool = false;
    this.z.fling(0, 0, 0, (int)paramFloat2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
    if (this.z.getFinalY() > this.a.getHeight()) {
      bool = true;
    }
    return bool;
  }
  
  private boolean a(View paramView, Rect paramRect, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    boolean bool2 = false;
    paramView = (LayoutParams)paramView.getLayoutParams();
    boolean bool1 = bool2;
    if (paramBoolean1)
    {
      bool1 = bool2;
      if (paramView.leftMargin != paramRect.left)
      {
        paramView.leftMargin = paramRect.left;
        bool1 = true;
      }
    }
    paramBoolean1 = bool1;
    if (paramBoolean2)
    {
      paramBoolean1 = bool1;
      if (paramView.topMargin != paramRect.top)
      {
        paramView.topMargin = paramRect.top;
        paramBoolean1 = true;
      }
    }
    paramBoolean2 = paramBoolean1;
    if (paramBoolean4)
    {
      paramBoolean2 = paramBoolean1;
      if (paramView.rightMargin != paramRect.right)
      {
        paramView.rightMargin = paramRect.right;
        paramBoolean2 = true;
      }
    }
    if ((paramBoolean3) && (paramView.bottomMargin != paramRect.bottom))
    {
      paramView.bottomMargin = paramRect.bottom;
      return true;
    }
    return paramBoolean2;
  }
  
  private void d()
  {
    c();
    postDelayed(this.A, 600L);
  }
  
  private void e()
  {
    c();
    postDelayed(this.B, 600L);
  }
  
  private void f()
  {
    c();
    this.A.run();
  }
  
  private void g()
  {
    c();
    this.B.run();
  }
  
  protected LayoutParams a()
  {
    return new LayoutParams(-1, -1);
  }
  
  void b()
  {
    if (this.h == null)
    {
      this.h = ((ContentFrameLayout)findViewById(R.id.action_bar_activity_content));
      this.a = ((ActionBarContainer)findViewById(R.id.action_bar_container));
      this.i = a(findViewById(R.id.action_bar));
    }
  }
  
  void c()
  {
    removeCallbacks(this.A);
    removeCallbacks(this.B);
    if (this.c != null) {
      this.c.cancel();
    }
  }
  
  public boolean canShowOverflowMenu()
  {
    b();
    return this.i.canShowOverflowMenu();
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  public void dismissPopups()
  {
    b();
    this.i.dismissPopupMenus();
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if ((this.j != null) && (!this.k)) {
      if (this.a.getVisibility() != 0) {
        break label82;
      }
    }
    label82:
    for (int i1 = (int)(this.a.getBottom() + this.a.getTranslationY() + 0.5F);; i1 = 0)
    {
      this.j.setBounds(0, i1, getWidth(), this.j.getIntrinsicHeight() + i1);
      this.j.draw(paramCanvas);
      return;
    }
  }
  
  protected boolean fitSystemWindows(Rect paramRect)
  {
    b();
    if ((ViewCompat.getWindowSystemUiVisibility(this) & 0x100) != 0) {}
    boolean bool = a(this.a, paramRect, true, true, false, true);
    this.t.set(paramRect);
    bb.computeFitSystemWindows(this, this.t, this.q);
    if (!this.u.equals(this.t))
    {
      this.u.set(this.t);
      bool = true;
    }
    if (!this.r.equals(this.q))
    {
      this.r.set(this.q);
      bool = true;
    }
    if (bool) {
      requestLayout();
    }
    return true;
  }
  
  public LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new LayoutParams(paramLayoutParams);
  }
  
  public int getActionBarHideOffset()
  {
    if (this.a != null) {
      return -(int)this.a.getTranslationY();
    }
    return 0;
  }
  
  public int getNestedScrollAxes()
  {
    return this.C.getNestedScrollAxes();
  }
  
  public CharSequence getTitle()
  {
    b();
    return this.i.getTitle();
  }
  
  public boolean hasIcon()
  {
    b();
    return this.i.hasIcon();
  }
  
  public boolean hasLogo()
  {
    b();
    return this.i.hasLogo();
  }
  
  public boolean hideOverflowMenu()
  {
    b();
    return this.i.hideOverflowMenu();
  }
  
  public void initFeature(int paramInt)
  {
    b();
    switch (paramInt)
    {
    default: 
      return;
    case 2: 
      this.i.initProgress();
      return;
    case 5: 
      this.i.initIndeterminateProgress();
      return;
    }
    setOverlayMode(true);
  }
  
  public boolean isHideOnContentScrollEnabled()
  {
    return this.n;
  }
  
  public boolean isInOverlayMode()
  {
    return this.l;
  }
  
  public boolean isOverflowMenuShowPending()
  {
    b();
    return this.i.isOverflowMenuShowPending();
  }
  
  public boolean isOverflowMenuShowing()
  {
    b();
    return this.i.isOverflowMenuShowing();
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    a(getContext());
    ViewCompat.requestApplyInsets(this);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    c();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt2 = getChildCount();
    paramInt3 = getPaddingLeft();
    getPaddingRight();
    paramInt4 = getPaddingTop();
    getPaddingBottom();
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      View localView = getChildAt(paramInt1);
      if (localView.getVisibility() != 8)
      {
        LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
        int i1 = localView.getMeasuredWidth();
        int i2 = localView.getMeasuredHeight();
        int i3 = localLayoutParams.leftMargin + paramInt3;
        int i4 = localLayoutParams.topMargin + paramInt4;
        localView.layout(i3, i4, i1 + i3, i2 + i4);
      }
      paramInt1 += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    b();
    measureChildWithMargins(this.a, paramInt1, 0, paramInt2, 0);
    Object localObject = (LayoutParams)this.a.getLayoutParams();
    int i6 = Math.max(0, this.a.getMeasuredWidth() + ((LayoutParams)localObject).leftMargin + ((LayoutParams)localObject).rightMargin);
    int i1 = this.a.getMeasuredHeight();
    int i2 = ((LayoutParams)localObject).topMargin;
    int i5 = Math.max(0, ((LayoutParams)localObject).bottomMargin + (i1 + i2));
    int i4 = View.combineMeasuredStates(0, this.a.getMeasuredState());
    int i3;
    if ((ViewCompat.getWindowSystemUiVisibility(this) & 0x100) != 0)
    {
      i2 = 1;
      if (i2 == 0) {
        break label448;
      }
      i3 = this.f;
      i1 = i3;
      if (this.m)
      {
        i1 = i3;
        if (this.a.getTabContainer() != null) {
          i1 = i3 + this.f;
        }
      }
    }
    for (;;)
    {
      label153:
      this.s.set(this.q);
      this.v.set(this.t);
      if ((!this.l) && (i2 == 0))
      {
        localObject = this.s;
        ((Rect)localObject).top = (i1 + ((Rect)localObject).top);
        localObject = this.s;
      }
      for (((Rect)localObject).bottom += 0;; ((Rect)localObject).bottom += 0)
      {
        a(this.h, this.s, true, true, true, true);
        if (!this.w.equals(this.v))
        {
          this.w.set(this.v);
          this.h.dispatchFitSystemWindows(this.v);
        }
        measureChildWithMargins(this.h, paramInt1, 0, paramInt2, 0);
        localObject = (LayoutParams)this.h.getLayoutParams();
        i1 = Math.max(i6, this.h.getMeasuredWidth() + ((LayoutParams)localObject).leftMargin + ((LayoutParams)localObject).rightMargin);
        i2 = this.h.getMeasuredHeight();
        i3 = ((LayoutParams)localObject).topMargin;
        i2 = Math.max(i5, ((LayoutParams)localObject).bottomMargin + (i2 + i3));
        i3 = View.combineMeasuredStates(i4, this.h.getMeasuredState());
        i4 = getPaddingLeft();
        i5 = getPaddingRight();
        i2 = Math.max(i2 + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(i1 + (i4 + i5), getSuggestedMinimumWidth()), paramInt1, i3), View.resolveSizeAndState(i2, paramInt2, i3 << 16));
        return;
        i2 = 0;
        break;
        label448:
        if (this.a.getVisibility() == 8) {
          break label510;
        }
        i1 = this.a.getMeasuredHeight();
        break label153;
        localObject = this.v;
        ((Rect)localObject).top = (i1 + ((Rect)localObject).top);
        localObject = this.v;
      }
      label510:
      i1 = 0;
    }
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if ((!this.n) || (!paramBoolean)) {
      return false;
    }
    if (a(paramFloat1, paramFloat2)) {
      g();
    }
    for (;;)
    {
      this.b = true;
      return true;
      f();
    }
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt) {}
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.o += paramInt2;
    setActionBarHideOffset(this.o);
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    this.C.onNestedScrollAccepted(paramView1, paramView2, paramInt);
    this.o = getActionBarHideOffset();
    c();
    if (this.x != null) {
      this.x.onContentScrollStarted();
    }
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    if (((paramInt & 0x2) == 0) || (this.a.getVisibility() != 0)) {
      return false;
    }
    return this.n;
  }
  
  public void onStopNestedScroll(View paramView)
  {
    if ((this.n) && (!this.b))
    {
      if (this.o > this.a.getHeight()) {
        break label49;
      }
      d();
    }
    for (;;)
    {
      if (this.x != null) {
        this.x.onContentScrollStopped();
      }
      return;
      label49:
      e();
    }
  }
  
  public void onWindowSystemUiVisibilityChanged(int paramInt)
  {
    boolean bool = true;
    if (Build.VERSION.SDK_INT >= 16) {
      super.onWindowSystemUiVisibilityChanged(paramInt);
    }
    b();
    int i3 = this.p;
    this.p = paramInt;
    int i1;
    int i2;
    if ((paramInt & 0x4) == 0)
    {
      i1 = 1;
      if ((paramInt & 0x100) == 0) {
        break label120;
      }
      i2 = 1;
      label49:
      if (this.x != null)
      {
        a locala = this.x;
        if (i2 != 0) {
          break label125;
        }
        label66:
        locala.enableContentAnimations(bool);
        if ((i1 == 0) && (i2 != 0)) {
          break label131;
        }
        this.x.showForSystem();
      }
    }
    for (;;)
    {
      if ((((i3 ^ paramInt) & 0x100) != 0) && (this.x != null)) {
        ViewCompat.requestApplyInsets(this);
      }
      return;
      i1 = 0;
      break;
      label120:
      i2 = 0;
      break label49;
      label125:
      bool = false;
      break label66;
      label131:
      this.x.hideForSystem();
    }
  }
  
  protected void onWindowVisibilityChanged(int paramInt)
  {
    super.onWindowVisibilityChanged(paramInt);
    this.g = paramInt;
    if (this.x != null) {
      this.x.onWindowVisibilityChanged(paramInt);
    }
  }
  
  public void restoreToolbarHierarchyState(SparseArray<Parcelable> paramSparseArray)
  {
    b();
    this.i.restoreHierarchyState(paramSparseArray);
  }
  
  public void saveToolbarHierarchyState(SparseArray<Parcelable> paramSparseArray)
  {
    b();
    this.i.saveHierarchyState(paramSparseArray);
  }
  
  public void setActionBarHideOffset(int paramInt)
  {
    c();
    paramInt = Math.max(0, Math.min(paramInt, this.a.getHeight()));
    this.a.setTranslationY(-paramInt);
  }
  
  public void setActionBarVisibilityCallback(a parama)
  {
    this.x = parama;
    if (getWindowToken() != null)
    {
      this.x.onWindowVisibilityChanged(this.g);
      if (this.p != 0)
      {
        onWindowSystemUiVisibilityChanged(this.p);
        ViewCompat.requestApplyInsets(this);
      }
    }
  }
  
  public void setHasNonEmbeddedTabs(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
  
  public void setHideOnContentScrollEnabled(boolean paramBoolean)
  {
    if (paramBoolean != this.n)
    {
      this.n = paramBoolean;
      if (!paramBoolean)
      {
        c();
        setActionBarHideOffset(0);
      }
    }
  }
  
  public void setIcon(int paramInt)
  {
    b();
    this.i.setIcon(paramInt);
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    b();
    this.i.setIcon(paramDrawable);
  }
  
  public void setLogo(int paramInt)
  {
    b();
    this.i.setLogo(paramInt);
  }
  
  public void setMenu(Menu paramMenu, n.a parama)
  {
    b();
    this.i.setMenu(paramMenu, parama);
  }
  
  public void setMenuPrepared()
  {
    b();
    this.i.setMenuPrepared();
  }
  
  public void setOverlayMode(boolean paramBoolean)
  {
    this.l = paramBoolean;
    if ((paramBoolean) && (getContext().getApplicationInfo().targetSdkVersion < 19)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.k = paramBoolean;
      return;
    }
  }
  
  public void setShowingForActionMode(boolean paramBoolean) {}
  
  public void setUiOptions(int paramInt) {}
  
  public void setWindowCallback(Window.Callback paramCallback)
  {
    b();
    this.i.setWindowCallback(paramCallback);
  }
  
  public void setWindowTitle(CharSequence paramCharSequence)
  {
    b();
    this.i.setWindowTitle(paramCharSequence);
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return false;
  }
  
  public boolean showOverflowMenu()
  {
    b();
    return this.i.showOverflowMenu();
  }
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
    }
  }
  
  public static abstract interface a
  {
    public abstract void enableContentAnimations(boolean paramBoolean);
    
    public abstract void hideForSystem();
    
    public abstract void onContentScrollStarted();
    
    public abstract void onContentScrollStopped();
    
    public abstract void onWindowVisibilityChanged(int paramInt);
    
    public abstract void showForSystem();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/widget/ActionBarOverlayLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */