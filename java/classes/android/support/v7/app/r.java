package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v4.view.ViewPropertyAnimatorUpdateListener;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.id;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.view.a;
import android.support.v7.view.b.a;
import android.support.v7.view.g;
import android.support.v7.view.menu.h.a;
import android.support.v7.view.menu.t;
import android.support.v7.widget.ActionBarContainer;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ActionBarOverlayLayout;
import android.support.v7.widget.ActionBarOverlayLayout.a;
import android.support.v7.widget.ScrollingTabContainerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.u;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.SpinnerAdapter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class r
  extends ActionBar
  implements ActionBarOverlayLayout.a
{
  private static final Interpolator t;
  private static final Interpolator u;
  private int A = -1;
  private boolean B;
  private boolean C;
  private ArrayList<ActionBar.a> D = new ArrayList();
  private boolean E;
  private int F = 0;
  private boolean G;
  private boolean H = true;
  private boolean I;
  Context a;
  ActionBarOverlayLayout b;
  ActionBarContainer c;
  u d;
  ActionBarContextView e;
  View f;
  ScrollingTabContainerView g;
  a h;
  android.support.v7.view.b i;
  b.a j;
  boolean k = true;
  boolean l;
  boolean m;
  android.support.v7.view.h n;
  boolean o;
  final ViewPropertyAnimatorListener p = new ViewPropertyAnimatorListenerAdapter()
  {
    public void onAnimationEnd(View paramAnonymousView)
    {
      if ((r.this.k) && (r.this.f != null))
      {
        r.this.f.setTranslationY(0.0F);
        r.this.c.setTranslationY(0.0F);
      }
      r.this.c.setVisibility(8);
      r.this.c.setTransitioning(false);
      r.this.n = null;
      r.this.b();
      if (r.this.b != null) {
        ViewCompat.requestApplyInsets(r.this.b);
      }
    }
  };
  final ViewPropertyAnimatorListener q = new ViewPropertyAnimatorListenerAdapter()
  {
    public void onAnimationEnd(View paramAnonymousView)
    {
      r.this.n = null;
      r.this.c.requestLayout();
    }
  };
  final ViewPropertyAnimatorUpdateListener r = new ViewPropertyAnimatorUpdateListener()
  {
    public void onAnimationUpdate(View paramAnonymousView)
    {
      ((View)r.this.c.getParent()).invalidate();
    }
  };
  private Context v;
  private Activity w;
  private Dialog x;
  private ArrayList<b> y = new ArrayList();
  private b z;
  
  static
  {
    if (!r.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      s = bool;
      t = new AccelerateInterpolator();
      u = new DecelerateInterpolator();
      return;
    }
  }
  
  public r(Activity paramActivity, boolean paramBoolean)
  {
    this.w = paramActivity;
    paramActivity = paramActivity.getWindow().getDecorView();
    a(paramActivity);
    if (!paramBoolean) {
      this.f = paramActivity.findViewById(16908290);
    }
  }
  
  public r(Dialog paramDialog)
  {
    this.x = paramDialog;
    a(paramDialog.getWindow().getDecorView());
  }
  
  public r(View paramView)
  {
    if ((!s) && (!paramView.isInEditMode())) {
      throw new AssertionError();
    }
    a(paramView);
  }
  
  private void a(ActionBar.c paramc, int paramInt)
  {
    paramc = (b)paramc;
    if (paramc.getCallback() == null) {
      throw new IllegalStateException("Action Bar Tab must have a Callback");
    }
    paramc.setPosition(paramInt);
    this.y.add(paramInt, paramc);
    int i1 = this.y.size();
    paramInt += 1;
    while (paramInt < i1)
    {
      ((b)this.y.get(paramInt)).setPosition(paramInt);
      paramInt += 1;
    }
  }
  
  private void a(View paramView)
  {
    this.b = ((ActionBarOverlayLayout)paramView.findViewById(R.id.decor_content_parent));
    if (this.b != null) {
      this.b.setActionBarVisibilityCallback(this);
    }
    this.d = b(paramView.findViewById(R.id.action_bar));
    this.e = ((ActionBarContextView)paramView.findViewById(R.id.action_context_bar));
    this.c = ((ActionBarContainer)paramView.findViewById(R.id.action_bar_container));
    if ((this.d == null) || (this.e == null) || (this.c == null)) {
      throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with a compatible window decor layout");
    }
    this.a = this.d.getContext();
    int i1;
    if ((this.d.getDisplayOptions() & 0x4) != 0)
    {
      i1 = 1;
      if (i1 != 0) {
        this.B = true;
      }
      paramView = a.get(this.a);
      if ((!paramView.enableHomeButtonByDefault()) && (i1 == 0)) {
        break label264;
      }
    }
    label264:
    for (boolean bool = true;; bool = false)
    {
      setHomeButtonEnabled(bool);
      a(paramView.hasEmbeddedTabs());
      paramView = this.a.obtainStyledAttributes(null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
      if (paramView.getBoolean(R.styleable.ActionBar_hideOnContentScroll, false)) {
        setHideOnContentScrollEnabled(true);
      }
      i1 = paramView.getDimensionPixelSize(R.styleable.ActionBar_elevation, 0);
      if (i1 != 0) {
        setElevation(i1);
      }
      paramView.recycle();
      return;
      i1 = 0;
      break;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    boolean bool = true;
    this.E = paramBoolean;
    int i1;
    label45:
    label78:
    Object localObject;
    if (!this.E)
    {
      this.d.setEmbeddedTabView(null);
      this.c.setTabContainer(this.g);
      if (getNavigationMode() != 2) {
        break label155;
      }
      i1 = 1;
      if (this.g != null)
      {
        if (i1 == 0) {
          break label160;
        }
        this.g.setVisibility(0);
        if (this.b != null) {
          ViewCompat.requestApplyInsets(this.b);
        }
      }
      localObject = this.d;
      if ((this.E) || (i1 == 0)) {
        break label172;
      }
      paramBoolean = true;
      label97:
      ((u)localObject).setCollapsible(paramBoolean);
      localObject = this.b;
      if ((this.E) || (i1 == 0)) {
        break label177;
      }
    }
    label155:
    label160:
    label172:
    label177:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      ((ActionBarOverlayLayout)localObject).setHasNonEmbeddedTabs(paramBoolean);
      return;
      this.c.setTabContainer(null);
      this.d.setEmbeddedTabView(this.g);
      break;
      i1 = 0;
      break label45;
      this.g.setVisibility(8);
      break label78;
      paramBoolean = false;
      break label97;
    }
  }
  
  static boolean a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramBoolean3) {}
    while ((!paramBoolean1) && (!paramBoolean2)) {
      return true;
    }
    return false;
  }
  
  private u b(View paramView)
  {
    if ((paramView instanceof u)) {
      return (u)paramView;
    }
    if ((paramView instanceof Toolbar)) {
      return ((Toolbar)paramView).getWrapper();
    }
    if ("Can't make a decor toolbar out of " + paramView != null) {}
    for (paramView = paramView.getClass().getSimpleName();; paramView = "null") {
      throw new IllegalStateException(paramView);
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (a(this.l, this.m, this.G)) {
      if (!this.H)
      {
        this.H = true;
        doShow(paramBoolean);
      }
    }
    while (!this.H) {
      return;
    }
    this.H = false;
    doHide(paramBoolean);
  }
  
  private void c()
  {
    if (this.g != null) {
      return;
    }
    ScrollingTabContainerView localScrollingTabContainerView = new ScrollingTabContainerView(this.a);
    if (this.E)
    {
      localScrollingTabContainerView.setVisibility(0);
      this.d.setEmbeddedTabView(localScrollingTabContainerView);
      this.g = localScrollingTabContainerView;
      return;
    }
    if (getNavigationMode() == 2)
    {
      localScrollingTabContainerView.setVisibility(0);
      if (this.b != null) {
        ViewCompat.requestApplyInsets(this.b);
      }
    }
    for (;;)
    {
      this.c.setTabContainer(localScrollingTabContainerView);
      break;
      localScrollingTabContainerView.setVisibility(8);
    }
  }
  
  private void d()
  {
    if (this.z != null) {
      selectTab(null);
    }
    this.y.clear();
    if (this.g != null) {
      this.g.removeAllTabs();
    }
    this.A = -1;
  }
  
  private void e()
  {
    if (!this.G)
    {
      this.G = true;
      if (this.b != null) {
        this.b.setShowingForActionMode(true);
      }
      b(false);
    }
  }
  
  private void f()
  {
    if (this.G)
    {
      this.G = false;
      if (this.b != null) {
        this.b.setShowingForActionMode(false);
      }
      b(false);
    }
  }
  
  private boolean g()
  {
    return ViewCompat.isLaidOut(this.c);
  }
  
  public void addOnMenuVisibilityListener(ActionBar.a parama)
  {
    this.D.add(parama);
  }
  
  public void addTab(ActionBar.c paramc)
  {
    addTab(paramc, this.y.isEmpty());
  }
  
  public void addTab(ActionBar.c paramc, int paramInt)
  {
    addTab(paramc, paramInt, this.y.isEmpty());
  }
  
  public void addTab(ActionBar.c paramc, int paramInt, boolean paramBoolean)
  {
    c();
    this.g.addTab(paramc, paramInt, paramBoolean);
    a(paramc, paramInt);
    if (paramBoolean) {
      selectTab(paramc);
    }
  }
  
  public void addTab(ActionBar.c paramc, boolean paramBoolean)
  {
    c();
    this.g.addTab(paramc, paramBoolean);
    a(paramc, this.y.size());
    if (paramBoolean) {
      selectTab(paramc);
    }
  }
  
  public void animateToMode(boolean paramBoolean)
  {
    ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat1;
    ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat2;
    if (paramBoolean)
    {
      e();
      if (!g()) {
        break label105;
      }
      if (!paramBoolean) {
        break label75;
      }
      localViewPropertyAnimatorCompat1 = this.d.setupAnimatorToVisibility(4, 100L);
      localViewPropertyAnimatorCompat2 = this.e.setupAnimatorToVisibility(0, 200L);
    }
    for (;;)
    {
      android.support.v7.view.h localh = new android.support.v7.view.h();
      localh.playSequentially(localViewPropertyAnimatorCompat1, localViewPropertyAnimatorCompat2);
      localh.start();
      return;
      f();
      break;
      label75:
      localViewPropertyAnimatorCompat2 = this.d.setupAnimatorToVisibility(0, 200L);
      localViewPropertyAnimatorCompat1 = this.e.setupAnimatorToVisibility(8, 100L);
    }
    label105:
    if (paramBoolean)
    {
      this.d.setVisibility(4);
      this.e.setVisibility(0);
      return;
    }
    this.d.setVisibility(0);
    this.e.setVisibility(8);
  }
  
  void b()
  {
    if (this.j != null)
    {
      this.j.onDestroyActionMode(this.i);
      this.i = null;
      this.j = null;
    }
  }
  
  public boolean collapseActionView()
  {
    if ((this.d != null) && (this.d.hasExpandedActionView()))
    {
      this.d.collapseActionView();
      return true;
    }
    return false;
  }
  
  public void dispatchMenuVisibilityChanged(boolean paramBoolean)
  {
    if (paramBoolean == this.C) {}
    for (;;)
    {
      return;
      this.C = paramBoolean;
      int i2 = this.D.size();
      int i1 = 0;
      while (i1 < i2)
      {
        ((ActionBar.a)this.D.get(i1)).onMenuVisibilityChanged(paramBoolean);
        i1 += 1;
      }
    }
  }
  
  public void doHide(boolean paramBoolean)
  {
    if (this.n != null) {
      this.n.cancel();
    }
    if ((this.F == 0) && ((this.I) || (paramBoolean)))
    {
      this.c.setAlpha(1.0F);
      this.c.setTransitioning(true);
      android.support.v7.view.h localh = new android.support.v7.view.h();
      float f2 = -this.c.getHeight();
      float f1 = f2;
      if (paramBoolean)
      {
        localObject = new int[2];
        Object tmp80_78 = localObject;
        tmp80_78[0] = 0;
        Object tmp84_80 = tmp80_78;
        tmp84_80[1] = 0;
        tmp84_80;
        this.c.getLocationInWindow((int[])localObject);
        f1 = f2 - localObject[1];
      }
      Object localObject = ViewCompat.animate(this.c).translationY(f1);
      ((ViewPropertyAnimatorCompat)localObject).setUpdateListener(this.r);
      localh.play((ViewPropertyAnimatorCompat)localObject);
      if ((this.k) && (this.f != null)) {
        localh.play(ViewCompat.animate(this.f).translationY(f1));
      }
      localh.setInterpolator(t);
      localh.setDuration(250L);
      localh.setListener(this.p);
      this.n = localh;
      localh.start();
      return;
    }
    this.p.onAnimationEnd(null);
  }
  
  public void doShow(boolean paramBoolean)
  {
    if (this.n != null) {
      this.n.cancel();
    }
    this.c.setVisibility(0);
    if ((this.F == 0) && ((this.I) || (paramBoolean)))
    {
      this.c.setTranslationY(0.0F);
      float f2 = -this.c.getHeight();
      float f1 = f2;
      if (paramBoolean)
      {
        localObject = new int[2];
        Object tmp71_69 = localObject;
        tmp71_69[0] = 0;
        Object tmp75_71 = tmp71_69;
        tmp75_71[1] = 0;
        tmp75_71;
        this.c.getLocationInWindow((int[])localObject);
        f1 = f2 - localObject[1];
      }
      this.c.setTranslationY(f1);
      Object localObject = new android.support.v7.view.h();
      ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat = ViewCompat.animate(this.c).translationY(0.0F);
      localViewPropertyAnimatorCompat.setUpdateListener(this.r);
      ((android.support.v7.view.h)localObject).play(localViewPropertyAnimatorCompat);
      if ((this.k) && (this.f != null))
      {
        this.f.setTranslationY(f1);
        ((android.support.v7.view.h)localObject).play(ViewCompat.animate(this.f).translationY(0.0F));
      }
      ((android.support.v7.view.h)localObject).setInterpolator(u);
      ((android.support.v7.view.h)localObject).setDuration(250L);
      ((android.support.v7.view.h)localObject).setListener(this.q);
      this.n = ((android.support.v7.view.h)localObject);
      ((android.support.v7.view.h)localObject).start();
    }
    for (;;)
    {
      if (this.b != null) {
        ViewCompat.requestApplyInsets(this.b);
      }
      return;
      this.c.setAlpha(1.0F);
      this.c.setTranslationY(0.0F);
      if ((this.k) && (this.f != null)) {
        this.f.setTranslationY(0.0F);
      }
      this.q.onAnimationEnd(null);
    }
  }
  
  public void enableContentAnimations(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }
  
  public View getCustomView()
  {
    return this.d.getCustomView();
  }
  
  public int getDisplayOptions()
  {
    return this.d.getDisplayOptions();
  }
  
  public float getElevation()
  {
    return ViewCompat.getElevation(this.c);
  }
  
  public int getHeight()
  {
    return this.c.getHeight();
  }
  
  public int getHideOffset()
  {
    return this.b.getActionBarHideOffset();
  }
  
  public int getNavigationItemCount()
  {
    switch (this.d.getNavigationMode())
    {
    default: 
      return 0;
    case 2: 
      return this.y.size();
    }
    return this.d.getDropdownItemCount();
  }
  
  public int getNavigationMode()
  {
    return this.d.getNavigationMode();
  }
  
  public int getSelectedNavigationIndex()
  {
    switch (this.d.getNavigationMode())
    {
    default: 
    case 2: 
      do
      {
        return -1;
      } while (this.z == null);
      return this.z.getPosition();
    }
    return this.d.getDropdownSelectedPosition();
  }
  
  public ActionBar.c getSelectedTab()
  {
    return this.z;
  }
  
  public CharSequence getSubtitle()
  {
    return this.d.getSubtitle();
  }
  
  public ActionBar.c getTabAt(int paramInt)
  {
    return (ActionBar.c)this.y.get(paramInt);
  }
  
  public int getTabCount()
  {
    return this.y.size();
  }
  
  public Context getThemedContext()
  {
    int i1;
    if (this.v == null)
    {
      TypedValue localTypedValue = new TypedValue();
      this.a.getTheme().resolveAttribute(R.attr.actionBarWidgetTheme, localTypedValue, true);
      i1 = localTypedValue.resourceId;
      if (i1 == 0) {
        break label61;
      }
    }
    label61:
    for (this.v = new ContextThemeWrapper(this.a, i1);; this.v = this.a) {
      return this.v;
    }
  }
  
  public CharSequence getTitle()
  {
    return this.d.getTitle();
  }
  
  public boolean hasIcon()
  {
    return this.d.hasIcon();
  }
  
  public boolean hasLogo()
  {
    return this.d.hasLogo();
  }
  
  public void hide()
  {
    if (!this.l)
    {
      this.l = true;
      b(false);
    }
  }
  
  public void hideForSystem()
  {
    if (!this.m)
    {
      this.m = true;
      b(true);
    }
  }
  
  public boolean isHideOnContentScrollEnabled()
  {
    return this.b.isHideOnContentScrollEnabled();
  }
  
  public boolean isShowing()
  {
    int i1 = getHeight();
    return (this.H) && ((i1 == 0) || (getHideOffset() < i1));
  }
  
  public boolean isTitleTruncated()
  {
    return (this.d != null) && (this.d.isTitleTruncated());
  }
  
  public ActionBar.c newTab()
  {
    return new b();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    a(a.get(this.a).hasEmbeddedTabs());
  }
  
  public void onContentScrollStarted()
  {
    if (this.n != null)
    {
      this.n.cancel();
      this.n = null;
    }
  }
  
  public void onContentScrollStopped() {}
  
  public boolean onKeyShortcut(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.h == null) {}
    Menu localMenu;
    do
    {
      return false;
      localMenu = this.h.getMenu();
    } while (localMenu == null);
    int i1;
    if (paramKeyEvent != null)
    {
      i1 = paramKeyEvent.getDeviceId();
      if (KeyCharacterMap.load(i1).getKeyboardType() == 1) {
        break label71;
      }
    }
    label71:
    for (boolean bool = true;; bool = false)
    {
      localMenu.setQwertyMode(bool);
      return localMenu.performShortcut(paramInt, paramKeyEvent, 0);
      i1 = -1;
      break;
    }
  }
  
  public void onWindowVisibilityChanged(int paramInt)
  {
    this.F = paramInt;
  }
  
  public void removeAllTabs()
  {
    d();
  }
  
  public void removeOnMenuVisibilityListener(ActionBar.a parama)
  {
    this.D.remove(parama);
  }
  
  public void removeTab(ActionBar.c paramc)
  {
    removeTabAt(paramc.getPosition());
  }
  
  public void removeTabAt(int paramInt)
  {
    if (this.g == null) {}
    int i1;
    do
    {
      return;
      if (this.z != null) {}
      for (i1 = this.z.getPosition();; i1 = this.A)
      {
        this.g.removeTabAt(paramInt);
        localb = (b)this.y.remove(paramInt);
        if (localb != null) {
          localb.setPosition(-1);
        }
        int i3 = this.y.size();
        int i2 = paramInt;
        while (i2 < i3)
        {
          ((b)this.y.get(i2)).setPosition(i2);
          i2 += 1;
        }
      }
    } while (i1 != paramInt);
    if (this.y.isEmpty()) {}
    for (b localb = null;; localb = (b)this.y.get(Math.max(0, paramInt - 1)))
    {
      selectTab(localb);
      return;
    }
  }
  
  public boolean requestFocus()
  {
    ViewGroup localViewGroup = this.d.getViewGroup();
    if ((localViewGroup != null) && (!localViewGroup.hasFocus()))
    {
      localViewGroup.requestFocus();
      return true;
    }
    return false;
  }
  
  public void selectTab(ActionBar.c paramc)
  {
    int i1 = -1;
    if (getNavigationMode() != 2) {
      if (paramc != null)
      {
        i1 = paramc.getPosition();
        this.A = i1;
      }
    }
    label137:
    label215:
    for (;;)
    {
      return;
      i1 = -1;
      break;
      FragmentTransaction localFragmentTransaction;
      if (((this.w instanceof FragmentActivity)) && (!this.d.getViewGroup().isInEditMode()))
      {
        localFragmentTransaction = ((FragmentActivity)this.w).getSupportFragmentManager().beginTransaction().disallowAddToBackStack();
        if (this.z != paramc) {
          break label137;
        }
        if (this.z != null)
        {
          this.z.getCallback().onTabReselected(this.z, localFragmentTransaction);
          this.g.animateToTab(paramc.getPosition());
        }
      }
      for (;;)
      {
        if ((localFragmentTransaction == null) || (localFragmentTransaction.isEmpty())) {
          break label215;
        }
        localFragmentTransaction.commit();
        return;
        localFragmentTransaction = null;
        break;
        ScrollingTabContainerView localScrollingTabContainerView = this.g;
        if (paramc != null) {
          i1 = paramc.getPosition();
        }
        localScrollingTabContainerView.setTabSelected(i1);
        if (this.z != null) {
          this.z.getCallback().onTabUnselected(this.z, localFragmentTransaction);
        }
        this.z = ((b)paramc);
        if (this.z != null) {
          this.z.getCallback().onTabSelected(this.z, localFragmentTransaction);
        }
      }
    }
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    this.c.setPrimaryBackground(paramDrawable);
  }
  
  public void setCustomView(int paramInt)
  {
    setCustomView(LayoutInflater.from(getThemedContext()).inflate(paramInt, this.d.getViewGroup(), false));
  }
  
  public void setCustomView(View paramView)
  {
    this.d.setCustomView(paramView);
  }
  
  public void setCustomView(View paramView, ActionBar.LayoutParams paramLayoutParams)
  {
    paramView.setLayoutParams(paramLayoutParams);
    this.d.setCustomView(paramView);
  }
  
  public void setDefaultDisplayHomeAsUpEnabled(boolean paramBoolean)
  {
    if (!this.B) {
      setDisplayHomeAsUpEnabled(paramBoolean);
    }
  }
  
  public void setDisplayHomeAsUpEnabled(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i1 = 4;; i1 = 0)
    {
      setDisplayOptions(i1, 4);
      return;
    }
  }
  
  public void setDisplayOptions(int paramInt)
  {
    if ((paramInt & 0x4) != 0) {
      this.B = true;
    }
    this.d.setDisplayOptions(paramInt);
  }
  
  public void setDisplayOptions(int paramInt1, int paramInt2)
  {
    int i1 = this.d.getDisplayOptions();
    if ((paramInt2 & 0x4) != 0) {
      this.B = true;
    }
    this.d.setDisplayOptions(i1 & (paramInt2 ^ 0xFFFFFFFF) | paramInt1 & paramInt2);
  }
  
  public void setDisplayShowCustomEnabled(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i1 = 16;; i1 = 0)
    {
      setDisplayOptions(i1, 16);
      return;
    }
  }
  
  public void setDisplayShowHomeEnabled(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i1 = 2;; i1 = 0)
    {
      setDisplayOptions(i1, 2);
      return;
    }
  }
  
  public void setDisplayShowTitleEnabled(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i1 = 8;; i1 = 0)
    {
      setDisplayOptions(i1, 8);
      return;
    }
  }
  
  public void setDisplayUseLogoEnabled(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i1 = 1;; i1 = 0)
    {
      setDisplayOptions(i1, 1);
      return;
    }
  }
  
  public void setElevation(float paramFloat)
  {
    ViewCompat.setElevation(this.c, paramFloat);
  }
  
  public void setHideOffset(int paramInt)
  {
    if ((paramInt != 0) && (!this.b.isInOverlayMode())) {
      throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to set a non-zero hide offset");
    }
    this.b.setActionBarHideOffset(paramInt);
  }
  
  public void setHideOnContentScrollEnabled(boolean paramBoolean)
  {
    if ((paramBoolean) && (!this.b.isInOverlayMode())) {
      throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
    }
    this.o = paramBoolean;
    this.b.setHideOnContentScrollEnabled(paramBoolean);
  }
  
  public void setHomeActionContentDescription(int paramInt)
  {
    this.d.setNavigationContentDescription(paramInt);
  }
  
  public void setHomeActionContentDescription(CharSequence paramCharSequence)
  {
    this.d.setNavigationContentDescription(paramCharSequence);
  }
  
  public void setHomeAsUpIndicator(int paramInt)
  {
    this.d.setNavigationIcon(paramInt);
  }
  
  public void setHomeAsUpIndicator(Drawable paramDrawable)
  {
    this.d.setNavigationIcon(paramDrawable);
  }
  
  public void setHomeButtonEnabled(boolean paramBoolean)
  {
    this.d.setHomeButtonEnabled(paramBoolean);
  }
  
  public void setIcon(int paramInt)
  {
    this.d.setIcon(paramInt);
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    this.d.setIcon(paramDrawable);
  }
  
  public void setListNavigationCallbacks(SpinnerAdapter paramSpinnerAdapter, ActionBar.b paramb)
  {
    this.d.setDropdownParams(paramSpinnerAdapter, new m(paramb));
  }
  
  public void setLogo(int paramInt)
  {
    this.d.setLogo(paramInt);
  }
  
  public void setLogo(Drawable paramDrawable)
  {
    this.d.setLogo(paramDrawable);
  }
  
  public void setNavigationMode(int paramInt)
  {
    boolean bool2 = true;
    int i1 = this.d.getNavigationMode();
    label88:
    Object localObject;
    switch (i1)
    {
    default: 
      if ((i1 != paramInt) && (!this.E) && (this.b != null)) {
        ViewCompat.requestApplyInsets(this.b);
      }
      this.d.setNavigationMode(paramInt);
      switch (paramInt)
      {
      default: 
        localObject = this.d;
        if ((paramInt == 2) && (!this.E))
        {
          bool1 = true;
          label108:
          ((u)localObject).setCollapsible(bool1);
          localObject = this.b;
          if ((paramInt != 2) || (this.E)) {
            break label210;
          }
        }
        break;
      }
      break;
    }
    label210:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((ActionBarOverlayLayout)localObject).setHasNonEmbeddedTabs(bool1);
      return;
      this.A = getSelectedNavigationIndex();
      selectTab(null);
      this.g.setVisibility(8);
      break;
      c();
      this.g.setVisibility(0);
      if (this.A == -1) {
        break label88;
      }
      setSelectedNavigationItem(this.A);
      this.A = -1;
      break label88;
      bool1 = false;
      break label108;
    }
  }
  
  public void setSelectedNavigationItem(int paramInt)
  {
    switch (this.d.getNavigationMode())
    {
    default: 
      throw new IllegalStateException("setSelectedNavigationIndex not valid for current navigation mode");
    case 2: 
      selectTab((ActionBar.c)this.y.get(paramInt));
      return;
    }
    this.d.setDropdownSelectedPosition(paramInt);
  }
  
  public void setShowHideAnimationEnabled(boolean paramBoolean)
  {
    this.I = paramBoolean;
    if ((!paramBoolean) && (this.n != null)) {
      this.n.cancel();
    }
  }
  
  public void setSplitBackgroundDrawable(Drawable paramDrawable) {}
  
  public void setStackedBackgroundDrawable(Drawable paramDrawable)
  {
    this.c.setStackedBackground(paramDrawable);
  }
  
  public void setSubtitle(int paramInt)
  {
    setSubtitle(this.a.getString(paramInt));
  }
  
  public void setSubtitle(CharSequence paramCharSequence)
  {
    this.d.setSubtitle(paramCharSequence);
  }
  
  public void setTitle(int paramInt)
  {
    setTitle(this.a.getString(paramInt));
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.d.setTitle(paramCharSequence);
  }
  
  public void setWindowTitle(CharSequence paramCharSequence)
  {
    this.d.setWindowTitle(paramCharSequence);
  }
  
  public void show()
  {
    if (this.l)
    {
      this.l = false;
      b(false);
    }
  }
  
  public void showForSystem()
  {
    if (this.m)
    {
      this.m = false;
      b(true);
    }
  }
  
  public android.support.v7.view.b startActionMode(b.a parama)
  {
    if (this.h != null) {
      this.h.finish();
    }
    this.b.setHideOnContentScrollEnabled(false);
    this.e.killMode();
    parama = new a(this.e.getContext(), parama);
    if (parama.dispatchOnCreate())
    {
      this.h = parama;
      parama.invalidate();
      this.e.initForMode(parama);
      animateToMode(true);
      this.e.sendAccessibilityEvent(32);
      return parama;
    }
    return null;
  }
  
  public class a
    extends android.support.v7.view.b
    implements h.a
  {
    private final Context b;
    private final android.support.v7.view.menu.h c;
    private b.a d;
    private WeakReference<View> e;
    
    public a(Context paramContext, b.a parama)
    {
      this.b = paramContext;
      this.d = parama;
      this.c = new android.support.v7.view.menu.h(paramContext).setDefaultShowAsAction(1);
      this.c.setCallback(this);
    }
    
    public boolean dispatchOnCreate()
    {
      this.c.stopDispatchingItemsChanged();
      try
      {
        boolean bool = this.d.onCreateActionMode(this, this.c);
        return bool;
      }
      finally
      {
        this.c.startDispatchingItemsChanged();
      }
    }
    
    public void finish()
    {
      if (r.this.h != this) {
        return;
      }
      if (!r.a(r.this.l, r.this.m, false))
      {
        r.this.i = this;
        r.this.j = this.d;
      }
      for (;;)
      {
        this.d = null;
        r.this.animateToMode(false);
        r.this.e.closeMode();
        r.this.d.getViewGroup().sendAccessibilityEvent(32);
        r.this.b.setHideOnContentScrollEnabled(r.this.o);
        r.this.h = null;
        return;
        this.d.onDestroyActionMode(this);
      }
    }
    
    public View getCustomView()
    {
      if (this.e != null) {
        return (View)this.e.get();
      }
      return null;
    }
    
    public Menu getMenu()
    {
      return this.c;
    }
    
    public MenuInflater getMenuInflater()
    {
      return new g(this.b);
    }
    
    public CharSequence getSubtitle()
    {
      return r.this.e.getSubtitle();
    }
    
    public CharSequence getTitle()
    {
      return r.this.e.getTitle();
    }
    
    public void invalidate()
    {
      if (r.this.h != this) {
        return;
      }
      this.c.stopDispatchingItemsChanged();
      try
      {
        this.d.onPrepareActionMode(this, this.c);
        return;
      }
      finally
      {
        this.c.startDispatchingItemsChanged();
      }
    }
    
    public boolean isTitleOptional()
    {
      return r.this.e.isTitleOptional();
    }
    
    public void onCloseMenu(android.support.v7.view.menu.h paramh, boolean paramBoolean) {}
    
    public void onCloseSubMenu(t paramt) {}
    
    public boolean onMenuItemSelected(android.support.v7.view.menu.h paramh, MenuItem paramMenuItem)
    {
      if (this.d != null) {
        return this.d.onActionItemClicked(this, paramMenuItem);
      }
      return false;
    }
    
    public void onMenuModeChange(android.support.v7.view.menu.h paramh)
    {
      if (this.d == null) {
        return;
      }
      invalidate();
      r.this.e.showOverflowMenu();
    }
    
    public boolean onSubMenuSelected(t paramt)
    {
      boolean bool = true;
      if (this.d == null) {
        bool = false;
      }
      while (!paramt.hasVisibleItems()) {
        return bool;
      }
      new android.support.v7.view.menu.m(r.this.getThemedContext(), paramt).show();
      return true;
    }
    
    public void setCustomView(View paramView)
    {
      r.this.e.setCustomView(paramView);
      this.e = new WeakReference(paramView);
    }
    
    public void setSubtitle(int paramInt)
    {
      setSubtitle(r.this.a.getResources().getString(paramInt));
    }
    
    public void setSubtitle(CharSequence paramCharSequence)
    {
      r.this.e.setSubtitle(paramCharSequence);
    }
    
    public void setTitle(int paramInt)
    {
      setTitle(r.this.a.getResources().getString(paramInt));
    }
    
    public void setTitle(CharSequence paramCharSequence)
    {
      r.this.e.setTitle(paramCharSequence);
    }
    
    public void setTitleOptionalHint(boolean paramBoolean)
    {
      super.setTitleOptionalHint(paramBoolean);
      r.this.e.setTitleOptional(paramBoolean);
    }
  }
  
  public class b
    extends ActionBar.c
  {
    private ActionBar.d b;
    private Object c;
    private Drawable d;
    private CharSequence e;
    private CharSequence f;
    private int g = -1;
    private View h;
    
    public b() {}
    
    public ActionBar.d getCallback()
    {
      return this.b;
    }
    
    public CharSequence getContentDescription()
    {
      return this.f;
    }
    
    public View getCustomView()
    {
      return this.h;
    }
    
    public Drawable getIcon()
    {
      return this.d;
    }
    
    public int getPosition()
    {
      return this.g;
    }
    
    public Object getTag()
    {
      return this.c;
    }
    
    public CharSequence getText()
    {
      return this.e;
    }
    
    public void select()
    {
      r.this.selectTab(this);
    }
    
    public ActionBar.c setContentDescription(int paramInt)
    {
      return setContentDescription(r.this.a.getResources().getText(paramInt));
    }
    
    public ActionBar.c setContentDescription(CharSequence paramCharSequence)
    {
      this.f = paramCharSequence;
      if (this.g >= 0) {
        r.this.g.updateTab(this.g);
      }
      return this;
    }
    
    public ActionBar.c setCustomView(int paramInt)
    {
      return setCustomView(LayoutInflater.from(r.this.getThemedContext()).inflate(paramInt, null));
    }
    
    public ActionBar.c setCustomView(View paramView)
    {
      this.h = paramView;
      if (this.g >= 0) {
        r.this.g.updateTab(this.g);
      }
      return this;
    }
    
    public ActionBar.c setIcon(int paramInt)
    {
      return setIcon(android.support.v7.a.a.b.getDrawable(r.this.a, paramInt));
    }
    
    public ActionBar.c setIcon(Drawable paramDrawable)
    {
      this.d = paramDrawable;
      if (this.g >= 0) {
        r.this.g.updateTab(this.g);
      }
      return this;
    }
    
    public void setPosition(int paramInt)
    {
      this.g = paramInt;
    }
    
    public ActionBar.c setTabListener(ActionBar.d paramd)
    {
      this.b = paramd;
      return this;
    }
    
    public ActionBar.c setTag(Object paramObject)
    {
      this.c = paramObject;
      return this;
    }
    
    public ActionBar.c setText(int paramInt)
    {
      return setText(r.this.a.getResources().getText(paramInt));
    }
    
    public ActionBar.c setText(CharSequence paramCharSequence)
    {
      this.e = paramCharSequence;
      if (this.g >= 0) {
        r.this.g.updateTab(this.g);
      }
      return this;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/app/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */