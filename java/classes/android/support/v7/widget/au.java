package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v7.a.a.b;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.drawable;
import android.support.v7.appcompat.R.id;
import android.support.v7.appcompat.R.string;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.view.menu.a;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.h.a;
import android.support.v7.view.menu.n.a;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window.Callback;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;

public class au
  implements u
{
  Toolbar a;
  CharSequence b;
  Window.Callback c;
  boolean d;
  private int e;
  private View f;
  private Spinner g;
  private View h;
  private Drawable i;
  private Drawable j;
  private Drawable k;
  private boolean l;
  private CharSequence m;
  private CharSequence n;
  private ActionMenuPresenter o;
  private int p = 0;
  private int q = 0;
  private Drawable r;
  
  public au(Toolbar paramToolbar, boolean paramBoolean)
  {
    this(paramToolbar, paramBoolean, R.string.abc_action_bar_up_description, R.drawable.abc_ic_ab_back_material);
  }
  
  public au(Toolbar paramToolbar, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.a = paramToolbar;
    this.b = paramToolbar.getTitle();
    this.m = paramToolbar.getSubtitle();
    boolean bool;
    if (this.b != null)
    {
      bool = true;
      this.l = bool;
      this.k = paramToolbar.getNavigationIcon();
      paramToolbar = at.obtainStyledAttributes(paramToolbar.getContext(), null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
      this.r = paramToolbar.getDrawable(R.styleable.ActionBar_homeAsUpIndicator);
      if (!paramBoolean) {
        break label477;
      }
      Object localObject = paramToolbar.getText(R.styleable.ActionBar_title);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        setTitle((CharSequence)localObject);
      }
      localObject = paramToolbar.getText(R.styleable.ActionBar_subtitle);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        setSubtitle((CharSequence)localObject);
      }
      localObject = paramToolbar.getDrawable(R.styleable.ActionBar_logo);
      if (localObject != null) {
        setLogo((Drawable)localObject);
      }
      localObject = paramToolbar.getDrawable(R.styleable.ActionBar_icon);
      if (localObject != null) {
        setIcon((Drawable)localObject);
      }
      if ((this.k == null) && (this.r != null)) {
        setNavigationIcon(this.r);
      }
      setDisplayOptions(paramToolbar.getInt(R.styleable.ActionBar_displayOptions, 0));
      paramInt2 = paramToolbar.getResourceId(R.styleable.ActionBar_customNavigationLayout, 0);
      if (paramInt2 != 0)
      {
        setCustomView(LayoutInflater.from(this.a.getContext()).inflate(paramInt2, this.a, false));
        setDisplayOptions(this.e | 0x10);
      }
      paramInt2 = paramToolbar.getLayoutDimension(R.styleable.ActionBar_height, 0);
      if (paramInt2 > 0)
      {
        localObject = this.a.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).height = paramInt2;
        this.a.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      paramInt2 = paramToolbar.getDimensionPixelOffset(R.styleable.ActionBar_contentInsetStart, -1);
      int i1 = paramToolbar.getDimensionPixelOffset(R.styleable.ActionBar_contentInsetEnd, -1);
      if ((paramInt2 >= 0) || (i1 >= 0)) {
        this.a.setContentInsetsRelative(Math.max(paramInt2, 0), Math.max(i1, 0));
      }
      paramInt2 = paramToolbar.getResourceId(R.styleable.ActionBar_titleTextStyle, 0);
      if (paramInt2 != 0) {
        this.a.setTitleTextAppearance(this.a.getContext(), paramInt2);
      }
      paramInt2 = paramToolbar.getResourceId(R.styleable.ActionBar_subtitleTextStyle, 0);
      if (paramInt2 != 0) {
        this.a.setSubtitleTextAppearance(this.a.getContext(), paramInt2);
      }
      paramInt2 = paramToolbar.getResourceId(R.styleable.ActionBar_popupTheme, 0);
      if (paramInt2 != 0) {
        this.a.setPopupTheme(paramInt2);
      }
    }
    for (;;)
    {
      paramToolbar.recycle();
      setDefaultNavigationContentDescription(paramInt1);
      this.n = this.a.getNavigationContentDescription();
      this.a.setNavigationOnClickListener(new View.OnClickListener()
      {
        final a a = new a(au.this.a.getContext(), 0, 16908332, 0, 0, au.this.b);
        
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if ((au.this.c != null) && (au.this.d)) {
            au.this.c.onMenuItemSelected(0, this.a);
          }
        }
      });
      return;
      bool = false;
      break;
      label477:
      this.e = a();
    }
  }
  
  private int a()
  {
    int i1 = 11;
    if (this.a.getNavigationIcon() != null)
    {
      i1 = 15;
      this.r = this.a.getNavigationIcon();
    }
    return i1;
  }
  
  private void a(CharSequence paramCharSequence)
  {
    this.b = paramCharSequence;
    if ((this.e & 0x8) != 0) {
      this.a.setTitle(paramCharSequence);
    }
  }
  
  private void b()
  {
    Drawable localDrawable = null;
    if ((this.e & 0x2) != 0)
    {
      if ((this.e & 0x1) == 0) {
        break label49;
      }
      if (this.j == null) {
        break label41;
      }
      localDrawable = this.j;
    }
    for (;;)
    {
      this.a.setLogo(localDrawable);
      return;
      label41:
      localDrawable = this.i;
      continue;
      label49:
      localDrawable = this.i;
    }
  }
  
  private void c()
  {
    if (this.g == null)
    {
      this.g = new AppCompatSpinner(getContext(), null, R.attr.actionDropDownStyle);
      Toolbar.LayoutParams localLayoutParams = new Toolbar.LayoutParams(-2, -2, 8388627);
      this.g.setLayoutParams(localLayoutParams);
    }
  }
  
  private void d()
  {
    if ((this.e & 0x4) != 0)
    {
      Toolbar localToolbar = this.a;
      if (this.k != null) {}
      for (Drawable localDrawable = this.k;; localDrawable = this.r)
      {
        localToolbar.setNavigationIcon(localDrawable);
        return;
      }
    }
    this.a.setNavigationIcon(null);
  }
  
  private void e()
  {
    if ((this.e & 0x4) != 0)
    {
      if (TextUtils.isEmpty(this.n)) {
        this.a.setNavigationContentDescription(this.q);
      }
    }
    else {
      return;
    }
    this.a.setNavigationContentDescription(this.n);
  }
  
  public void animateToVisibility(int paramInt)
  {
    ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat = setupAnimatorToVisibility(paramInt, 200L);
    if (localViewPropertyAnimatorCompat != null) {
      localViewPropertyAnimatorCompat.start();
    }
  }
  
  public boolean canShowOverflowMenu()
  {
    return this.a.canShowOverflowMenu();
  }
  
  public void collapseActionView()
  {
    this.a.collapseActionView();
  }
  
  public void dismissPopupMenus()
  {
    this.a.dismissPopupMenus();
  }
  
  public Context getContext()
  {
    return this.a.getContext();
  }
  
  public View getCustomView()
  {
    return this.h;
  }
  
  public int getDisplayOptions()
  {
    return this.e;
  }
  
  public int getDropdownItemCount()
  {
    if (this.g != null) {
      return this.g.getCount();
    }
    return 0;
  }
  
  public int getDropdownSelectedPosition()
  {
    if (this.g != null) {
      return this.g.getSelectedItemPosition();
    }
    return 0;
  }
  
  public int getHeight()
  {
    return this.a.getHeight();
  }
  
  public Menu getMenu()
  {
    return this.a.getMenu();
  }
  
  public int getNavigationMode()
  {
    return this.p;
  }
  
  public CharSequence getSubtitle()
  {
    return this.a.getSubtitle();
  }
  
  public CharSequence getTitle()
  {
    return this.a.getTitle();
  }
  
  public ViewGroup getViewGroup()
  {
    return this.a;
  }
  
  public int getVisibility()
  {
    return this.a.getVisibility();
  }
  
  public boolean hasEmbeddedTabs()
  {
    return this.f != null;
  }
  
  public boolean hasExpandedActionView()
  {
    return this.a.hasExpandedActionView();
  }
  
  public boolean hasIcon()
  {
    return this.i != null;
  }
  
  public boolean hasLogo()
  {
    return this.j != null;
  }
  
  public boolean hideOverflowMenu()
  {
    return this.a.hideOverflowMenu();
  }
  
  public void initIndeterminateProgress()
  {
    Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
  }
  
  public void initProgress()
  {
    Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
  }
  
  public boolean isOverflowMenuShowPending()
  {
    return this.a.isOverflowMenuShowPending();
  }
  
  public boolean isOverflowMenuShowing()
  {
    return this.a.isOverflowMenuShowing();
  }
  
  public boolean isTitleTruncated()
  {
    return this.a.isTitleTruncated();
  }
  
  public void restoreHierarchyState(SparseArray<Parcelable> paramSparseArray)
  {
    this.a.restoreHierarchyState(paramSparseArray);
  }
  
  public void saveHierarchyState(SparseArray<Parcelable> paramSparseArray)
  {
    this.a.saveHierarchyState(paramSparseArray);
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    ViewCompat.setBackground(this.a, paramDrawable);
  }
  
  public void setCollapsible(boolean paramBoolean)
  {
    this.a.setCollapsible(paramBoolean);
  }
  
  public void setCustomView(View paramView)
  {
    if ((this.h != null) && ((this.e & 0x10) != 0)) {
      this.a.removeView(this.h);
    }
    this.h = paramView;
    if ((paramView != null) && ((this.e & 0x10) != 0)) {
      this.a.addView(this.h);
    }
  }
  
  public void setDefaultNavigationContentDescription(int paramInt)
  {
    if (paramInt == this.q) {}
    do
    {
      return;
      this.q = paramInt;
    } while (!TextUtils.isEmpty(this.a.getNavigationContentDescription()));
    setNavigationContentDescription(this.q);
  }
  
  public void setDefaultNavigationIcon(Drawable paramDrawable)
  {
    if (this.r != paramDrawable)
    {
      this.r = paramDrawable;
      d();
    }
  }
  
  public void setDisplayOptions(int paramInt)
  {
    int i1 = this.e ^ paramInt;
    this.e = paramInt;
    if (i1 != 0)
    {
      if ((i1 & 0x4) != 0)
      {
        if ((paramInt & 0x4) != 0) {
          e();
        }
        d();
      }
      if ((i1 & 0x3) != 0) {
        b();
      }
      if ((i1 & 0x8) != 0)
      {
        if ((paramInt & 0x8) == 0) {
          break label115;
        }
        this.a.setTitle(this.b);
        this.a.setSubtitle(this.m);
      }
    }
    for (;;)
    {
      if (((i1 & 0x10) != 0) && (this.h != null))
      {
        if ((paramInt & 0x10) == 0) {
          break;
        }
        this.a.addView(this.h);
      }
      return;
      label115:
      this.a.setTitle(null);
      this.a.setSubtitle(null);
    }
    this.a.removeView(this.h);
  }
  
  public void setDropdownParams(SpinnerAdapter paramSpinnerAdapter, AdapterView.OnItemSelectedListener paramOnItemSelectedListener)
  {
    c();
    this.g.setAdapter(paramSpinnerAdapter);
    this.g.setOnItemSelectedListener(paramOnItemSelectedListener);
  }
  
  public void setDropdownSelectedPosition(int paramInt)
  {
    if (this.g == null) {
      throw new IllegalStateException("Can't set dropdown selected position without an adapter");
    }
    this.g.setSelection(paramInt);
  }
  
  public void setEmbeddedTabView(ScrollingTabContainerView paramScrollingTabContainerView)
  {
    if ((this.f != null) && (this.f.getParent() == this.a)) {
      this.a.removeView(this.f);
    }
    this.f = paramScrollingTabContainerView;
    if ((paramScrollingTabContainerView != null) && (this.p == 2))
    {
      this.a.addView(this.f, 0);
      Toolbar.LayoutParams localLayoutParams = (Toolbar.LayoutParams)this.f.getLayoutParams();
      localLayoutParams.width = -2;
      localLayoutParams.height = -2;
      localLayoutParams.a = 8388691;
      paramScrollingTabContainerView.setAllowCollapse(true);
    }
  }
  
  public void setHomeButtonEnabled(boolean paramBoolean) {}
  
  public void setIcon(int paramInt)
  {
    if (paramInt != 0) {}
    for (Drawable localDrawable = b.getDrawable(getContext(), paramInt);; localDrawable = null)
    {
      setIcon(localDrawable);
      return;
    }
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    this.i = paramDrawable;
    b();
  }
  
  public void setLogo(int paramInt)
  {
    if (paramInt != 0) {}
    for (Drawable localDrawable = b.getDrawable(getContext(), paramInt);; localDrawable = null)
    {
      setLogo(localDrawable);
      return;
    }
  }
  
  public void setLogo(Drawable paramDrawable)
  {
    this.j = paramDrawable;
    b();
  }
  
  public void setMenu(Menu paramMenu, n.a parama)
  {
    if (this.o == null)
    {
      this.o = new ActionMenuPresenter(this.a.getContext());
      this.o.setId(R.id.action_menu_presenter);
    }
    this.o.setCallback(parama);
    this.a.setMenu((h)paramMenu, this.o);
  }
  
  public void setMenuCallbacks(n.a parama, h.a parama1)
  {
    this.a.setMenuCallbacks(parama, parama1);
  }
  
  public void setMenuPrepared()
  {
    this.d = true;
  }
  
  public void setNavigationContentDescription(int paramInt)
  {
    if (paramInt == 0) {}
    for (Object localObject = null;; localObject = getContext().getString(paramInt))
    {
      setNavigationContentDescription((CharSequence)localObject);
      return;
    }
  }
  
  public void setNavigationContentDescription(CharSequence paramCharSequence)
  {
    this.n = paramCharSequence;
    e();
  }
  
  public void setNavigationIcon(int paramInt)
  {
    if (paramInt != 0) {}
    for (Drawable localDrawable = b.getDrawable(getContext(), paramInt);; localDrawable = null)
    {
      setNavigationIcon(localDrawable);
      return;
    }
  }
  
  public void setNavigationIcon(Drawable paramDrawable)
  {
    this.k = paramDrawable;
    d();
  }
  
  public void setNavigationMode(int paramInt)
  {
    int i1 = this.p;
    if (paramInt != i1)
    {
      switch (i1)
      {
      }
      for (;;)
      {
        this.p = paramInt;
        switch (paramInt)
        {
        default: 
          throw new IllegalArgumentException("Invalid navigation mode " + paramInt);
          if ((this.g != null) && (this.g.getParent() == this.a))
          {
            this.a.removeView(this.g);
            continue;
            if ((this.f != null) && (this.f.getParent() == this.a)) {
              this.a.removeView(this.f);
            }
          }
          break;
        }
      }
      c();
      this.a.addView(this.g, 0);
    }
    do
    {
      return;
    } while (this.f == null);
    this.a.addView(this.f, 0);
    Toolbar.LayoutParams localLayoutParams = (Toolbar.LayoutParams)this.f.getLayoutParams();
    localLayoutParams.width = -2;
    localLayoutParams.height = -2;
    localLayoutParams.a = 8388691;
  }
  
  public void setSubtitle(CharSequence paramCharSequence)
  {
    this.m = paramCharSequence;
    if ((this.e & 0x8) != 0) {
      this.a.setSubtitle(paramCharSequence);
    }
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.l = true;
    a(paramCharSequence);
  }
  
  public void setVisibility(int paramInt)
  {
    this.a.setVisibility(paramInt);
  }
  
  public void setWindowCallback(Window.Callback paramCallback)
  {
    this.c = paramCallback;
  }
  
  public void setWindowTitle(CharSequence paramCharSequence)
  {
    if (!this.l) {
      a(paramCharSequence);
    }
  }
  
  public ViewPropertyAnimatorCompat setupAnimatorToVisibility(final int paramInt, long paramLong)
  {
    ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat = ViewCompat.animate(this.a);
    if (paramInt == 0) {}
    for (float f1 = 1.0F;; f1 = 0.0F) {
      localViewPropertyAnimatorCompat.alpha(f1).setDuration(paramLong).setListener(new ViewPropertyAnimatorListenerAdapter()
      {
        private boolean c = false;
        
        public void onAnimationCancel(View paramAnonymousView)
        {
          this.c = true;
        }
        
        public void onAnimationEnd(View paramAnonymousView)
        {
          if (!this.c) {
            au.this.a.setVisibility(paramInt);
          }
        }
        
        public void onAnimationStart(View paramAnonymousView)
        {
          au.this.a.setVisibility(0);
        }
      });
    }
  }
  
  public boolean showOverflowMenu()
  {
    return this.a.showOverflowMenu();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/widget/au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */