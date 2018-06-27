package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MarginLayoutParamsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.a.a.b;
import android.support.v7.app.ActionBar.LayoutParams;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.view.c;
import android.support.v7.view.g;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.h.a;
import android.support.v7.view.menu.j;
import android.support.v7.view.menu.n;
import android.support.v7.view.menu.n.a;
import android.support.v7.view.menu.o;
import android.support.v7.view.menu.t;
import android.text.Layout;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import java.util.ArrayList;
import java.util.List;

public class Toolbar
  extends ViewGroup
{
  private int A;
  private int B;
  private boolean C;
  private boolean D;
  private final ArrayList<View> E = new ArrayList();
  private final ArrayList<View> F = new ArrayList();
  private final int[] G = new int[2];
  private final ActionMenuView.d H = new ActionMenuView.d()
  {
    @Instrumented
    public boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
    {
      VdsAgent.onMenuItemClick(this, paramAnonymousMenuItem);
      if (Toolbar.this.d != null)
      {
        boolean bool = Toolbar.this.d.onMenuItemClick(paramAnonymousMenuItem);
        VdsAgent.handleClickResult(new Boolean(bool));
        return bool;
      }
      VdsAgent.handleClickResult(new Boolean(false));
      return false;
    }
  };
  private au I;
  private ActionMenuPresenter J;
  private a K;
  private n.a L;
  private h.a M;
  private boolean N;
  private final Runnable O = new Runnable()
  {
    public void run()
    {
      Toolbar.this.showOverflowMenu();
    }
  };
  ImageButton a;
  View b;
  int c;
  b d;
  private ActionMenuView e;
  private TextView f;
  private TextView g;
  private ImageButton h;
  private ImageView i;
  private Drawable j;
  private CharSequence k;
  private Context l;
  private int m;
  private int n;
  private int o;
  private int p;
  private int q;
  private int r;
  private int s;
  private int t;
  private ak u;
  private int v;
  private int w;
  private int x = 8388627;
  private CharSequence y;
  private CharSequence z;
  
  public Toolbar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public Toolbar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.toolbarStyle);
  }
  
  public Toolbar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = at.obtainStyledAttributes(getContext(), paramAttributeSet, R.styleable.Toolbar, paramInt, 0);
    this.n = paramContext.getResourceId(R.styleable.Toolbar_titleTextAppearance, 0);
    this.o = paramContext.getResourceId(R.styleable.Toolbar_subtitleTextAppearance, 0);
    this.x = paramContext.getInteger(R.styleable.Toolbar_android_gravity, this.x);
    this.c = paramContext.getInteger(R.styleable.Toolbar_buttonGravity, 48);
    int i1 = paramContext.getDimensionPixelOffset(R.styleable.Toolbar_titleMargin, 0);
    paramInt = i1;
    if (paramContext.hasValue(R.styleable.Toolbar_titleMargins)) {
      paramInt = paramContext.getDimensionPixelOffset(R.styleable.Toolbar_titleMargins, i1);
    }
    this.t = paramInt;
    this.s = paramInt;
    this.r = paramInt;
    this.q = paramInt;
    paramInt = paramContext.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginStart, -1);
    if (paramInt >= 0) {
      this.q = paramInt;
    }
    paramInt = paramContext.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginEnd, -1);
    if (paramInt >= 0) {
      this.r = paramInt;
    }
    paramInt = paramContext.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginTop, -1);
    if (paramInt >= 0) {
      this.s = paramInt;
    }
    paramInt = paramContext.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginBottom, -1);
    if (paramInt >= 0) {
      this.t = paramInt;
    }
    this.p = paramContext.getDimensionPixelSize(R.styleable.Toolbar_maxButtonHeight, -1);
    paramInt = paramContext.getDimensionPixelOffset(R.styleable.Toolbar_contentInsetStart, Integer.MIN_VALUE);
    i1 = paramContext.getDimensionPixelOffset(R.styleable.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
    int i2 = paramContext.getDimensionPixelSize(R.styleable.Toolbar_contentInsetLeft, 0);
    int i3 = paramContext.getDimensionPixelSize(R.styleable.Toolbar_contentInsetRight, 0);
    k();
    this.u.setAbsolute(i2, i3);
    if ((paramInt != Integer.MIN_VALUE) || (i1 != Integer.MIN_VALUE)) {
      this.u.setRelative(paramInt, i1);
    }
    this.v = paramContext.getDimensionPixelOffset(R.styleable.Toolbar_contentInsetStartWithNavigation, Integer.MIN_VALUE);
    this.w = paramContext.getDimensionPixelOffset(R.styleable.Toolbar_contentInsetEndWithActions, Integer.MIN_VALUE);
    this.j = paramContext.getDrawable(R.styleable.Toolbar_collapseIcon);
    this.k = paramContext.getText(R.styleable.Toolbar_collapseContentDescription);
    paramAttributeSet = paramContext.getText(R.styleable.Toolbar_title);
    if (!TextUtils.isEmpty(paramAttributeSet)) {
      setTitle(paramAttributeSet);
    }
    paramAttributeSet = paramContext.getText(R.styleable.Toolbar_subtitle);
    if (!TextUtils.isEmpty(paramAttributeSet)) {
      setSubtitle(paramAttributeSet);
    }
    this.l = getContext();
    setPopupTheme(paramContext.getResourceId(R.styleable.Toolbar_popupTheme, 0));
    paramAttributeSet = paramContext.getDrawable(R.styleable.Toolbar_navigationIcon);
    if (paramAttributeSet != null) {
      setNavigationIcon(paramAttributeSet);
    }
    paramAttributeSet = paramContext.getText(R.styleable.Toolbar_navigationContentDescription);
    if (!TextUtils.isEmpty(paramAttributeSet)) {
      setNavigationContentDescription(paramAttributeSet);
    }
    paramAttributeSet = paramContext.getDrawable(R.styleable.Toolbar_logo);
    if (paramAttributeSet != null) {
      setLogo(paramAttributeSet);
    }
    paramAttributeSet = paramContext.getText(R.styleable.Toolbar_logoDescription);
    if (!TextUtils.isEmpty(paramAttributeSet)) {
      setLogoDescription(paramAttributeSet);
    }
    if (paramContext.hasValue(R.styleable.Toolbar_titleTextColor)) {
      setTitleTextColor(paramContext.getColor(R.styleable.Toolbar_titleTextColor, -1));
    }
    if (paramContext.hasValue(R.styleable.Toolbar_subtitleTextColor)) {
      setSubtitleTextColor(paramContext.getColor(R.styleable.Toolbar_subtitleTextColor, -1));
    }
    paramContext.recycle();
  }
  
  private int a(int paramInt)
  {
    int i1 = paramInt & 0x70;
    paramInt = i1;
    switch (i1)
    {
    default: 
      paramInt = this.x & 0x70;
    }
    return paramInt;
  }
  
  private int a(View paramView, int paramInt)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    int i2 = paramView.getMeasuredHeight();
    int i1;
    int i3;
    int i4;
    if (paramInt > 0)
    {
      paramInt = (i2 - paramInt) / 2;
      switch (a(localLayoutParams.a))
      {
      default: 
        i1 = getPaddingTop();
        i3 = getPaddingBottom();
        i4 = getHeight();
        paramInt = (i4 - i1 - i3 - i2) / 2;
        if (paramInt < localLayoutParams.topMargin) {
          paramInt = localLayoutParams.topMargin;
        }
        break;
      }
    }
    for (;;)
    {
      return paramInt + i1;
      paramInt = 0;
      break;
      return getPaddingTop() - paramInt;
      return getHeight() - getPaddingBottom() - i2 - localLayoutParams.bottomMargin - paramInt;
      i2 = i4 - i3 - i2 - paramInt - i1;
      if (i2 < localLayoutParams.bottomMargin) {
        paramInt = Math.max(0, paramInt - (localLayoutParams.bottomMargin - i2));
      }
    }
  }
  
  private int a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    int i1 = localMarginLayoutParams.leftMargin - paramArrayOfInt[0];
    int i2 = localMarginLayoutParams.rightMargin - paramArrayOfInt[1];
    int i3 = Math.max(0, i1) + Math.max(0, i2);
    paramArrayOfInt[0] = Math.max(0, -i1);
    paramArrayOfInt[1] = Math.max(0, -i2);
    paramView.measure(getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight() + i3 + paramInt2, localMarginLayoutParams.width), getChildMeasureSpec(paramInt3, getPaddingTop() + getPaddingBottom() + localMarginLayoutParams.topMargin + localMarginLayoutParams.bottomMargin + paramInt4, localMarginLayoutParams.height));
    return paramView.getMeasuredWidth() + i3;
  }
  
  private int a(View paramView, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    int i1 = localLayoutParams.leftMargin - paramArrayOfInt[0];
    paramInt1 = Math.max(0, i1) + paramInt1;
    paramArrayOfInt[0] = Math.max(0, -i1);
    paramInt2 = a(paramView, paramInt2);
    i1 = paramView.getMeasuredWidth();
    paramView.layout(paramInt1, paramInt2, paramInt1 + i1, paramView.getMeasuredHeight() + paramInt2);
    return localLayoutParams.rightMargin + i1 + paramInt1;
  }
  
  private int a(List<View> paramList, int[] paramArrayOfInt)
  {
    int i4 = paramArrayOfInt[0];
    int i3 = paramArrayOfInt[1];
    int i5 = paramList.size();
    int i2 = 0;
    int i1 = 0;
    while (i2 < i5)
    {
      paramArrayOfInt = (View)paramList.get(i2);
      LayoutParams localLayoutParams = (LayoutParams)paramArrayOfInt.getLayoutParams();
      i4 = localLayoutParams.leftMargin - i4;
      i3 = localLayoutParams.rightMargin - i3;
      int i6 = Math.max(0, i4);
      int i7 = Math.max(0, i3);
      i4 = Math.max(0, -i4);
      i3 = Math.max(0, -i3);
      int i8 = paramArrayOfInt.getMeasuredWidth();
      i2 += 1;
      i1 += i8 + i6 + i7;
    }
    return i1;
  }
  
  private void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    int i1 = getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight() + localMarginLayoutParams.leftMargin + localMarginLayoutParams.rightMargin + paramInt2, localMarginLayoutParams.width);
    paramInt2 = getChildMeasureSpec(paramInt3, getPaddingTop() + getPaddingBottom() + localMarginLayoutParams.topMargin + localMarginLayoutParams.bottomMargin + paramInt4, localMarginLayoutParams.height);
    paramInt3 = View.MeasureSpec.getMode(paramInt2);
    paramInt1 = paramInt2;
    if (paramInt3 != 1073741824)
    {
      paramInt1 = paramInt2;
      if (paramInt5 >= 0)
      {
        paramInt1 = paramInt5;
        if (paramInt3 != 0) {
          paramInt1 = Math.min(View.MeasureSpec.getSize(paramInt2), paramInt5);
        }
        paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
      }
    }
    paramView.measure(i1, paramInt1);
  }
  
  private void a(View paramView, boolean paramBoolean)
  {
    Object localObject = paramView.getLayoutParams();
    if (localObject == null) {
      localObject = b();
    }
    for (;;)
    {
      ((LayoutParams)localObject).b = 1;
      if ((!paramBoolean) || (this.b == null)) {
        break;
      }
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.F.add(paramView);
      return;
      if (!checkLayoutParams((ViewGroup.LayoutParams)localObject)) {
        localObject = a((ViewGroup.LayoutParams)localObject);
      } else {
        localObject = (LayoutParams)localObject;
      }
    }
    addView(paramView, (ViewGroup.LayoutParams)localObject);
  }
  
  private void a(List<View> paramList, int paramInt)
  {
    int i1 = 1;
    int i2 = 0;
    if (ViewCompat.getLayoutDirection(this) == 1) {}
    int i4;
    int i3;
    View localView;
    LayoutParams localLayoutParams;
    for (;;)
    {
      i4 = getChildCount();
      i3 = GravityCompat.getAbsoluteGravity(paramInt, ViewCompat.getLayoutDirection(this));
      paramList.clear();
      paramInt = i2;
      if (i1 == 0) {
        break;
      }
      paramInt = i4 - 1;
      while (paramInt >= 0)
      {
        localView = getChildAt(paramInt);
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if ((localLayoutParams.b == 0) && (a(localView)) && (b(localLayoutParams.a) == i3)) {
          paramList.add(localView);
        }
        paramInt -= 1;
      }
      i1 = 0;
    }
    while (paramInt < i4)
    {
      localView = getChildAt(paramInt);
      localLayoutParams = (LayoutParams)localView.getLayoutParams();
      if ((localLayoutParams.b == 0) && (a(localView)) && (b(localLayoutParams.a) == i3)) {
        paramList.add(localView);
      }
      paramInt += 1;
    }
  }
  
  private boolean a(View paramView)
  {
    return (paramView != null) && (paramView.getParent() == this) && (paramView.getVisibility() != 8);
  }
  
  private int b(int paramInt)
  {
    int i2 = ViewCompat.getLayoutDirection(this);
    int i1 = GravityCompat.getAbsoluteGravity(paramInt, i2) & 0x7;
    paramInt = i1;
    switch (i1)
    {
    case 2: 
    case 4: 
    default: 
      if (i2 == 1) {
        paramInt = 5;
      }
      break;
    case 1: 
    case 3: 
    case 5: 
      return paramInt;
    }
    return 3;
  }
  
  private int b(View paramView)
  {
    paramView = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    int i1 = MarginLayoutParamsCompat.getMarginStart(paramView);
    return MarginLayoutParamsCompat.getMarginEnd(paramView) + i1;
  }
  
  private int b(View paramView, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    int i1 = localLayoutParams.rightMargin - paramArrayOfInt[1];
    paramInt1 -= Math.max(0, i1);
    paramArrayOfInt[1] = Math.max(0, -i1);
    paramInt2 = a(paramView, paramInt2);
    i1 = paramView.getMeasuredWidth();
    paramView.layout(paramInt1 - i1, paramInt2, paramInt1, paramView.getMeasuredHeight() + paramInt2);
    return paramInt1 - (localLayoutParams.leftMargin + i1);
  }
  
  private int c(View paramView)
  {
    paramView = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    int i1 = paramView.topMargin;
    return paramView.bottomMargin + i1;
  }
  
  private boolean d(View paramView)
  {
    return (paramView.getParent() == this) || (this.F.contains(paramView));
  }
  
  private void e()
  {
    if (this.i == null) {
      this.i = new AppCompatImageView(getContext());
    }
  }
  
  private void f()
  {
    g();
    if (this.e.peekMenu() == null)
    {
      h localh = (h)this.e.getMenu();
      if (this.K == null) {
        this.K = new a();
      }
      this.e.setExpandedActionViewsExclusive(true);
      localh.addMenuPresenter(this.K, this.l);
    }
  }
  
  private void g()
  {
    if (this.e == null)
    {
      this.e = new ActionMenuView(getContext());
      this.e.setPopupTheme(this.m);
      this.e.setOnMenuItemClickListener(this.H);
      this.e.setMenuCallbacks(this.L, this.M);
      LayoutParams localLayoutParams = b();
      localLayoutParams.a = (0x800005 | this.c & 0x70);
      this.e.setLayoutParams(localLayoutParams);
      a(this.e, false);
    }
  }
  
  private MenuInflater getMenuInflater()
  {
    return new g(getContext());
  }
  
  private void h()
  {
    if (this.h == null)
    {
      this.h = new AppCompatImageButton(getContext(), null, R.attr.toolbarNavigationButtonStyle);
      LayoutParams localLayoutParams = b();
      localLayoutParams.a = (0x800003 | this.c & 0x70);
      this.h.setLayoutParams(localLayoutParams);
    }
  }
  
  private void i()
  {
    removeCallbacks(this.O);
    post(this.O);
  }
  
  private boolean j()
  {
    if (!this.N) {
      return false;
    }
    int i2 = getChildCount();
    int i1 = 0;
    for (;;)
    {
      if (i1 >= i2) {
        break label56;
      }
      View localView = getChildAt(i1);
      if ((a(localView)) && (localView.getMeasuredWidth() > 0) && (localView.getMeasuredHeight() > 0)) {
        break;
      }
      i1 += 1;
    }
    label56:
    return true;
  }
  
  private void k()
  {
    if (this.u == null) {
      this.u = new ak();
    }
  }
  
  protected LayoutParams a(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof LayoutParams)) {
      return new LayoutParams((LayoutParams)paramLayoutParams);
    }
    if ((paramLayoutParams instanceof ActionBar.LayoutParams)) {
      return new LayoutParams((ActionBar.LayoutParams)paramLayoutParams);
    }
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new LayoutParams(paramLayoutParams);
  }
  
  void a()
  {
    if (this.a == null)
    {
      this.a = new AppCompatImageButton(getContext(), null, R.attr.toolbarNavigationButtonStyle);
      this.a.setImageDrawable(this.j);
      this.a.setContentDescription(this.k);
      LayoutParams localLayoutParams = b();
      localLayoutParams.a = (0x800003 | this.c & 0x70);
      localLayoutParams.b = 2;
      this.a.setLayoutParams(localLayoutParams);
      this.a.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          Toolbar.this.collapseActionView();
        }
      });
    }
  }
  
  protected LayoutParams b()
  {
    return new LayoutParams(-2, -2);
  }
  
  void c()
  {
    int i1 = getChildCount() - 1;
    while (i1 >= 0)
    {
      View localView = getChildAt(i1);
      if ((((LayoutParams)localView.getLayoutParams()).b != 2) && (localView != this.e))
      {
        removeViewAt(i1);
        this.F.add(localView);
      }
      i1 -= 1;
    }
  }
  
  public boolean canShowOverflowMenu()
  {
    return (getVisibility() == 0) && (this.e != null) && (this.e.isOverflowReserved());
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return (super.checkLayoutParams(paramLayoutParams)) && ((paramLayoutParams instanceof LayoutParams));
  }
  
  public void collapseActionView()
  {
    if (this.K == null) {}
    for (j localj = null;; localj = this.K.b)
    {
      if (localj != null) {
        localj.collapseActionView();
      }
      return;
    }
  }
  
  void d()
  {
    int i1 = this.F.size() - 1;
    while (i1 >= 0)
    {
      addView((View)this.F.get(i1));
      i1 -= 1;
    }
    this.F.clear();
  }
  
  public void dismissPopupMenus()
  {
    if (this.e != null) {
      this.e.dismissPopupMenus();
    }
  }
  
  public LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  public int getContentInsetEnd()
  {
    if (this.u != null) {
      return this.u.getEnd();
    }
    return 0;
  }
  
  public int getContentInsetEndWithActions()
  {
    if (this.w != Integer.MIN_VALUE) {
      return this.w;
    }
    return getContentInsetEnd();
  }
  
  public int getContentInsetLeft()
  {
    if (this.u != null) {
      return this.u.getLeft();
    }
    return 0;
  }
  
  public int getContentInsetRight()
  {
    if (this.u != null) {
      return this.u.getRight();
    }
    return 0;
  }
  
  public int getContentInsetStart()
  {
    if (this.u != null) {
      return this.u.getStart();
    }
    return 0;
  }
  
  public int getContentInsetStartWithNavigation()
  {
    if (this.v != Integer.MIN_VALUE) {
      return this.v;
    }
    return getContentInsetStart();
  }
  
  public int getCurrentContentInsetEnd()
  {
    int i1;
    if (this.e != null)
    {
      h localh = this.e.peekMenu();
      if ((localh != null) && (localh.hasVisibleItems())) {
        i1 = 1;
      }
    }
    for (;;)
    {
      if (i1 != 0)
      {
        return Math.max(getContentInsetEnd(), Math.max(this.w, 0));
        i1 = 0;
      }
      else
      {
        return getContentInsetEnd();
        i1 = 0;
      }
    }
  }
  
  public int getCurrentContentInsetLeft()
  {
    if (ViewCompat.getLayoutDirection(this) == 1) {
      return getCurrentContentInsetEnd();
    }
    return getCurrentContentInsetStart();
  }
  
  public int getCurrentContentInsetRight()
  {
    if (ViewCompat.getLayoutDirection(this) == 1) {
      return getCurrentContentInsetStart();
    }
    return getCurrentContentInsetEnd();
  }
  
  public int getCurrentContentInsetStart()
  {
    if (getNavigationIcon() != null) {
      return Math.max(getContentInsetStart(), Math.max(this.v, 0));
    }
    return getContentInsetStart();
  }
  
  public Drawable getLogo()
  {
    if (this.i != null) {
      return this.i.getDrawable();
    }
    return null;
  }
  
  public CharSequence getLogoDescription()
  {
    if (this.i != null) {
      return this.i.getContentDescription();
    }
    return null;
  }
  
  public Menu getMenu()
  {
    f();
    return this.e.getMenu();
  }
  
  public CharSequence getNavigationContentDescription()
  {
    if (this.h != null) {
      return this.h.getContentDescription();
    }
    return null;
  }
  
  public Drawable getNavigationIcon()
  {
    if (this.h != null) {
      return this.h.getDrawable();
    }
    return null;
  }
  
  ActionMenuPresenter getOuterActionMenuPresenter()
  {
    return this.J;
  }
  
  public Drawable getOverflowIcon()
  {
    f();
    return this.e.getOverflowIcon();
  }
  
  Context getPopupContext()
  {
    return this.l;
  }
  
  public int getPopupTheme()
  {
    return this.m;
  }
  
  public CharSequence getSubtitle()
  {
    return this.z;
  }
  
  public CharSequence getTitle()
  {
    return this.y;
  }
  
  public int getTitleMarginBottom()
  {
    return this.t;
  }
  
  public int getTitleMarginEnd()
  {
    return this.r;
  }
  
  public int getTitleMarginStart()
  {
    return this.q;
  }
  
  public int getTitleMarginTop()
  {
    return this.s;
  }
  
  public u getWrapper()
  {
    if (this.I == null) {
      this.I = new au(this, true);
    }
    return this.I;
  }
  
  public boolean hasExpandedActionView()
  {
    return (this.K != null) && (this.K.b != null);
  }
  
  public boolean hideOverflowMenu()
  {
    return (this.e != null) && (this.e.hideOverflowMenu());
  }
  
  public void inflateMenu(int paramInt)
  {
    getMenuInflater().inflate(paramInt, getMenu());
  }
  
  public boolean isOverflowMenuShowPending()
  {
    return (this.e != null) && (this.e.isOverflowMenuShowPending());
  }
  
  public boolean isOverflowMenuShowing()
  {
    return (this.e != null) && (this.e.isOverflowMenuShowing());
  }
  
  public boolean isTitleTruncated()
  {
    if (this.f == null) {}
    for (;;)
    {
      return false;
      Layout localLayout = this.f.getLayout();
      if (localLayout != null)
      {
        int i2 = localLayout.getLineCount();
        int i1 = 0;
        while (i1 < i2)
        {
          if (localLayout.getEllipsisCount(i1) > 0) {
            return true;
          }
          i1 += 1;
        }
      }
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    removeCallbacks(this.O);
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getActionMasked();
    if (i1 == 9) {
      this.D = false;
    }
    if (!this.D)
    {
      boolean bool = super.onHoverEvent(paramMotionEvent);
      if ((i1 == 9) && (!bool)) {
        this.D = true;
      }
    }
    if ((i1 == 10) || (i1 == 3)) {
      this.D = false;
    }
    return true;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i3;
    int i6;
    int i9;
    int i2;
    int i7;
    int i8;
    int i10;
    int[] arrayOfInt;
    int i1;
    if (ViewCompat.getLayoutDirection(this) == 1)
    {
      i3 = 1;
      i6 = getWidth();
      i9 = getHeight();
      i2 = getPaddingLeft();
      i7 = getPaddingRight();
      i8 = getPaddingTop();
      i10 = getPaddingBottom();
      paramInt1 = i6 - i7;
      arrayOfInt = this.G;
      arrayOfInt[1] = 0;
      arrayOfInt[0] = 0;
      paramInt3 = ViewCompat.getMinimumHeight(this);
      if (paramInt3 < 0) {
        break label892;
      }
      i1 = Math.min(paramInt3, paramInt4 - paramInt2);
      label91:
      if (!a(this.h)) {
        break label1587;
      }
      if (i3 == 0) {
        break label898;
      }
      paramInt1 = b(this.h, paramInt1, arrayOfInt, i1);
      paramInt2 = i2;
    }
    for (;;)
    {
      label124:
      paramInt3 = paramInt1;
      paramInt4 = paramInt2;
      if (a(this.a))
      {
        if (i3 != 0)
        {
          paramInt3 = b(this.a, paramInt1, arrayOfInt, i1);
          paramInt4 = paramInt2;
        }
      }
      else
      {
        label164:
        paramInt1 = paramInt3;
        paramInt2 = paramInt4;
        if (a(this.e))
        {
          if (i3 == 0) {
            break label937;
          }
          paramInt2 = a(this.e, paramInt4, arrayOfInt, i1);
          paramInt1 = paramInt3;
        }
        label204:
        paramInt3 = getCurrentContentInsetLeft();
        paramInt4 = getCurrentContentInsetRight();
        arrayOfInt[0] = Math.max(0, paramInt3 - paramInt2);
        arrayOfInt[1] = Math.max(0, paramInt4 - (i6 - i7 - paramInt1));
        paramInt3 = Math.max(paramInt2, paramInt3);
        paramInt4 = Math.min(paramInt1, i6 - i7 - paramInt4);
        paramInt2 = paramInt4;
        paramInt1 = paramInt3;
        if (a(this.b))
        {
          if (i3 == 0) {
            break label958;
          }
          paramInt2 = b(this.b, paramInt4, arrayOfInt, i1);
          paramInt1 = paramInt3;
        }
        label308:
        if (!a(this.i)) {
          break label1581;
        }
        if (i3 == 0) {
          break label979;
        }
        paramInt2 = b(this.i, paramInt2, arrayOfInt, i1);
        paramInt3 = paramInt1;
      }
      for (;;)
      {
        label341:
        paramBoolean = a(this.f);
        boolean bool = a(this.g);
        paramInt1 = 0;
        Object localObject1;
        if (paramBoolean)
        {
          localObject1 = (LayoutParams)this.f.getLayoutParams();
          paramInt1 = ((LayoutParams)localObject1).topMargin;
          paramInt4 = this.f.getMeasuredHeight();
          paramInt1 = 0 + (((LayoutParams)localObject1).bottomMargin + (paramInt1 + paramInt4));
        }
        int i4;
        if (bool)
        {
          localObject1 = (LayoutParams)this.g.getLayoutParams();
          paramInt4 = ((LayoutParams)localObject1).topMargin;
          i4 = this.g.getMeasuredHeight();
        }
        for (int i5 = ((LayoutParams)localObject1).bottomMargin + (paramInt4 + i4) + paramInt1;; i5 = paramInt1)
        {
          label479:
          Object localObject2;
          if (!paramBoolean)
          {
            paramInt4 = paramInt2;
            paramInt1 = paramInt3;
            if (!bool) {}
          }
          else
          {
            if (!paramBoolean) {
              break label997;
            }
            localObject1 = this.f;
            if (!bool) {
              break label1006;
            }
            localObject2 = this.g;
            label490:
            localObject1 = (LayoutParams)((View)localObject1).getLayoutParams();
            localObject2 = (LayoutParams)((View)localObject2).getLayoutParams();
            if (((!paramBoolean) || (this.f.getMeasuredWidth() <= 0)) && ((!bool) || (this.g.getMeasuredWidth() <= 0))) {
              break label1015;
            }
            i4 = 1;
            label542:
            switch (this.x & 0x70)
            {
            default: 
              paramInt1 = (i9 - i8 - i10 - i5) / 2;
              if (paramInt1 < ((LayoutParams)localObject1).topMargin + this.s) {
                paramInt1 = ((LayoutParams)localObject1).topMargin + this.s;
              }
              break;
            }
          }
          label615:
          label620:
          label636:
          label892:
          label898:
          label937:
          label958:
          label979:
          label997:
          label1006:
          label1015:
          label1135:
          label1549:
          label1566:
          label1572:
          for (;;)
          {
            paramInt1 = i8 + paramInt1;
            if (i3 != 0) {
              if (i4 != 0)
              {
                paramInt4 = this.q;
                paramInt4 -= arrayOfInt[1];
                paramInt2 -= Math.max(0, paramInt4);
                arrayOfInt[1] = Math.max(0, -paramInt4);
                if (!paramBoolean) {
                  break label1566;
                }
                localObject1 = (LayoutParams)this.f.getLayoutParams();
                paramInt4 = paramInt2 - this.f.getMeasuredWidth();
                i3 = this.f.getMeasuredHeight() + paramInt1;
                this.f.layout(paramInt4, paramInt1, paramInt2, i3);
                i5 = this.r;
                paramInt1 = i3 + ((LayoutParams)localObject1).bottomMargin;
                paramInt4 -= i5;
              }
            }
            for (;;)
            {
              if (bool)
              {
                localObject1 = (LayoutParams)this.g.getLayoutParams();
                paramInt1 = ((LayoutParams)localObject1).topMargin + paramInt1;
                i3 = this.g.getMeasuredWidth();
                i5 = this.g.getMeasuredHeight() + paramInt1;
                this.g.layout(paramInt2 - i3, paramInt1, paramInt2, i5);
                paramInt1 = this.r;
                i3 = ((LayoutParams)localObject1).bottomMargin;
              }
              for (paramInt1 = paramInt2 - paramInt1;; paramInt1 = paramInt2)
              {
                if (i4 != 0) {}
                for (paramInt1 = Math.min(paramInt4, paramInt1);; paramInt1 = paramInt2)
                {
                  paramInt4 = paramInt1;
                  paramInt1 = paramInt3;
                  a(this.E, 3);
                  paramInt3 = this.E.size();
                  paramInt2 = 0;
                  for (;;)
                  {
                    if (paramInt2 < paramInt3)
                    {
                      paramInt1 = a((View)this.E.get(paramInt2), paramInt1, arrayOfInt, i1);
                      paramInt2 += 1;
                      continue;
                      i3 = 0;
                      break;
                      i1 = 0;
                      break label91;
                      paramInt2 = a(this.h, i2, arrayOfInt, i1);
                      break label124;
                      paramInt4 = a(this.a, paramInt2, arrayOfInt, i1);
                      paramInt3 = paramInt1;
                      break label164;
                      paramInt1 = b(this.e, paramInt3, arrayOfInt, i1);
                      paramInt2 = paramInt4;
                      break label204;
                      paramInt1 = a(this.b, paramInt3, arrayOfInt, i1);
                      paramInt2 = paramInt4;
                      break label308;
                      paramInt3 = a(this.i, paramInt1, arrayOfInt, i1);
                      break label341;
                      localObject1 = this.g;
                      break label479;
                      localObject2 = this.f;
                      break label490;
                      i4 = 0;
                      break label542;
                      paramInt1 = getPaddingTop();
                      paramInt1 = ((LayoutParams)localObject1).topMargin + paramInt1 + this.s;
                      break label620;
                      paramInt4 = i9 - i10 - i5 - paramInt1 - i8;
                      if (paramInt4 >= ((LayoutParams)localObject1).bottomMargin + this.t) {
                        break label1572;
                      }
                      paramInt1 = Math.max(0, paramInt1 - (((LayoutParams)localObject2).bottomMargin + this.t - paramInt4));
                      break label615;
                      paramInt1 = i9 - i10 - ((LayoutParams)localObject2).bottomMargin - this.t - i5;
                      break label620;
                      paramInt4 = 0;
                      break label636;
                      if (i4 != 0)
                      {
                        paramInt4 = this.q;
                        paramInt4 -= arrayOfInt[0];
                        paramInt3 += Math.max(0, paramInt4);
                        arrayOfInt[0] = Math.max(0, -paramInt4);
                        if (!paramBoolean) {
                          break label1549;
                        }
                        localObject1 = (LayoutParams)this.f.getLayoutParams();
                        i3 = this.f.getMeasuredWidth() + paramInt3;
                        paramInt4 = this.f.getMeasuredHeight() + paramInt1;
                        this.f.layout(paramInt3, paramInt1, i3, paramInt4);
                        i5 = this.r;
                        paramInt1 = ((LayoutParams)localObject1).bottomMargin;
                        i3 += i5;
                        paramInt1 += paramInt4;
                      }
                    }
                  }
                  for (;;)
                  {
                    if (bool)
                    {
                      localObject1 = (LayoutParams)this.g.getLayoutParams();
                      paramInt4 = paramInt1 + ((LayoutParams)localObject1).topMargin;
                      paramInt1 = this.g.getMeasuredWidth() + paramInt3;
                      i5 = this.g.getMeasuredHeight() + paramInt4;
                      this.g.layout(paramInt3, paramInt4, paramInt1, i5);
                      paramInt4 = this.r;
                      i5 = ((LayoutParams)localObject1).bottomMargin;
                    }
                    for (i5 = paramInt4 + paramInt1;; i5 = paramInt3)
                    {
                      paramInt4 = paramInt2;
                      paramInt1 = paramInt3;
                      if (i4 == 0) {
                        break;
                      }
                      paramInt1 = Math.max(i3, i5);
                      paramInt4 = paramInt2;
                      break;
                      paramInt4 = 0;
                      break label1135;
                      a(this.E, 5);
                      paramInt3 = this.E.size();
                      paramInt2 = 0;
                      while (paramInt2 < paramInt3)
                      {
                        paramInt4 = b((View)this.E.get(paramInt2), paramInt4, arrayOfInt, i1);
                        paramInt2 += 1;
                      }
                      a(this.E, 1);
                      paramInt3 = a(this.E, arrayOfInt);
                      paramInt2 = (i6 - i2 - i7) / 2 + i2 - paramInt3 / 2;
                      paramInt3 += paramInt2;
                      if (paramInt2 < paramInt1) {}
                      for (;;)
                      {
                        paramInt4 = this.E.size();
                        paramInt3 = 0;
                        paramInt2 = paramInt1;
                        paramInt1 = paramInt3;
                        while (paramInt1 < paramInt4)
                        {
                          paramInt2 = a((View)this.E.get(paramInt1), paramInt2, arrayOfInt, i1);
                          paramInt1 += 1;
                        }
                        paramInt1 = paramInt2;
                        if (paramInt3 > paramInt4) {
                          paramInt1 = paramInt2 - (paramInt3 - paramInt4);
                        }
                      }
                      this.E.clear();
                      return;
                    }
                    i3 = paramInt3;
                  }
                }
              }
              paramInt4 = paramInt2;
            }
          }
        }
        label1581:
        paramInt3 = paramInt1;
      }
      label1587:
      paramInt2 = i2;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i4 = 0;
    int i3 = 0;
    int[] arrayOfInt = this.G;
    int i5;
    int i6;
    int i1;
    int i7;
    int i2;
    int i8;
    label529:
    View localView;
    if (bb.isLayoutRtl(this))
    {
      i5 = 0;
      i6 = 1;
      i1 = 0;
      if (a(this.h))
      {
        a(this.h, paramInt1, 0, paramInt2, 0, this.p);
        i1 = this.h.getMeasuredWidth() + b(this.h);
        i4 = Math.max(0, this.h.getMeasuredHeight() + c(this.h));
        i3 = View.combineMeasuredStates(0, this.h.getMeasuredState());
      }
      i7 = i1;
      i1 = i3;
      i2 = i4;
      if (a(this.a))
      {
        a(this.a, paramInt1, 0, paramInt2, 0, this.p);
        i7 = this.a.getMeasuredWidth() + b(this.a);
        i2 = Math.max(i4, this.a.getMeasuredHeight() + c(this.a));
        i1 = View.combineMeasuredStates(i3, this.a.getMeasuredState());
      }
      i3 = getCurrentContentInsetStart();
      i8 = 0 + Math.max(i3, i7);
      arrayOfInt[i6] = Math.max(0, i3 - i7);
      i6 = 0;
      i3 = i1;
      i4 = i2;
      if (a(this.e))
      {
        a(this.e, paramInt1, i8, paramInt2, 0, this.p);
        i6 = this.e.getMeasuredWidth() + b(this.e);
        i4 = Math.max(i2, this.e.getMeasuredHeight() + c(this.e));
        i3 = View.combineMeasuredStates(i1, this.e.getMeasuredState());
      }
      i1 = getCurrentContentInsetEnd();
      i7 = i8 + Math.max(i1, i6);
      arrayOfInt[i5] = Math.max(0, i1 - i6);
      i6 = i7;
      i1 = i3;
      i2 = i4;
      if (a(this.b))
      {
        i6 = i7 + a(this.b, paramInt1, i7, paramInt2, 0, arrayOfInt);
        i2 = Math.max(i4, this.b.getMeasuredHeight() + c(this.b));
        i1 = View.combineMeasuredStates(i3, this.b.getMeasuredState());
      }
      i3 = i6;
      i4 = i1;
      i5 = i2;
      if (a(this.i))
      {
        i3 = i6 + a(this.i, paramInt1, i6, paramInt2, 0, arrayOfInt);
        i5 = Math.max(i2, this.i.getMeasuredHeight() + c(this.i));
        i4 = View.combineMeasuredStates(i1, this.i.getMeasuredState());
      }
      i7 = getChildCount();
      i6 = 0;
      i2 = i5;
      i1 = i4;
      i4 = i6;
      i6 = i3;
      if (i4 >= i7) {
        break label635;
      }
      localView = getChildAt(i4);
      if (((LayoutParams)localView.getLayoutParams()).b != 0) {
        break label938;
      }
      if (a(localView)) {
        break label585;
      }
    }
    label585:
    label635:
    label938:
    for (;;)
    {
      i4 += 1;
      break label529;
      i5 = 1;
      i6 = 0;
      break;
      i6 += a(localView, paramInt1, i6, paramInt2, 0, arrayOfInt);
      i2 = Math.max(i2, localView.getMeasuredHeight() + c(localView));
      i1 = View.combineMeasuredStates(i1, localView.getMeasuredState());
      continue;
      i5 = 0;
      i4 = 0;
      int i9 = this.s + this.t;
      int i10 = this.q + this.r;
      i3 = i1;
      if (a(this.f))
      {
        a(this.f, paramInt1, i6 + i10, paramInt2, i9, arrayOfInt);
        i3 = this.f.getMeasuredWidth();
        i5 = b(this.f) + i3;
        i4 = this.f.getMeasuredHeight() + c(this.f);
        i3 = View.combineMeasuredStates(i1, this.f.getMeasuredState());
      }
      i8 = i4;
      i7 = i5;
      i1 = i3;
      if (a(this.g))
      {
        i7 = Math.max(i5, a(this.g, paramInt1, i6 + i10, paramInt2, i9 + i4, arrayOfInt));
        i8 = i4 + (this.g.getMeasuredHeight() + c(this.g));
        i1 = View.combineMeasuredStates(i3, this.g.getMeasuredState());
      }
      i2 = Math.max(i2, i8);
      i5 = getPaddingLeft();
      i8 = getPaddingRight();
      i3 = getPaddingTop();
      i4 = getPaddingBottom();
      i5 = View.resolveSizeAndState(Math.max(i7 + i6 + (i5 + i8), getSuggestedMinimumWidth()), paramInt1, 0xFF000000 & i1);
      paramInt1 = View.resolveSizeAndState(Math.max(i2 + (i3 + i4), getSuggestedMinimumHeight()), paramInt2, i1 << 16);
      if (j()) {
        paramInt1 = 0;
      }
      setMeasuredDimension(i5, paramInt1);
      return;
    }
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    SavedState localSavedState = (SavedState)paramParcelable;
    super.onRestoreInstanceState(localSavedState.getSuperState());
    if (this.e != null) {}
    for (paramParcelable = this.e.peekMenu();; paramParcelable = null)
    {
      if ((localSavedState.a != 0) && (this.K != null) && (paramParcelable != null))
      {
        paramParcelable = paramParcelable.findItem(localSavedState.a);
        if (paramParcelable != null) {
          paramParcelable.expandActionView();
        }
      }
      if (!localSavedState.b) {
        break;
      }
      i();
      return;
    }
  }
  
  public void onRtlPropertiesChanged(int paramInt)
  {
    boolean bool = true;
    if (Build.VERSION.SDK_INT >= 17) {
      super.onRtlPropertiesChanged(paramInt);
    }
    k();
    ak localak = this.u;
    if (paramInt == 1) {}
    for (;;)
    {
      localak.setDirection(bool);
      return;
      bool = false;
    }
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    if ((this.K != null) && (this.K.b != null)) {
      localSavedState.a = this.K.b.getItemId();
    }
    localSavedState.b = isOverflowMenuShowing();
    return localSavedState;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getActionMasked();
    if (i1 == 0) {
      this.C = false;
    }
    if (!this.C)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      if ((i1 == 0) && (!bool)) {
        this.C = true;
      }
    }
    if ((i1 == 1) || (i1 == 3)) {
      this.C = false;
    }
    return true;
  }
  
  public void setCollapsible(boolean paramBoolean)
  {
    this.N = paramBoolean;
    requestLayout();
  }
  
  public void setContentInsetEndWithActions(int paramInt)
  {
    int i1 = paramInt;
    if (paramInt < 0) {
      i1 = Integer.MIN_VALUE;
    }
    if (i1 != this.w)
    {
      this.w = i1;
      if (getNavigationIcon() != null) {
        requestLayout();
      }
    }
  }
  
  public void setContentInsetStartWithNavigation(int paramInt)
  {
    int i1 = paramInt;
    if (paramInt < 0) {
      i1 = Integer.MIN_VALUE;
    }
    if (i1 != this.v)
    {
      this.v = i1;
      if (getNavigationIcon() != null) {
        requestLayout();
      }
    }
  }
  
  public void setContentInsetsAbsolute(int paramInt1, int paramInt2)
  {
    k();
    this.u.setAbsolute(paramInt1, paramInt2);
  }
  
  public void setContentInsetsRelative(int paramInt1, int paramInt2)
  {
    k();
    this.u.setRelative(paramInt1, paramInt2);
  }
  
  public void setLogo(int paramInt)
  {
    setLogo(b.getDrawable(getContext(), paramInt));
  }
  
  public void setLogo(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      e();
      if (!d(this.i)) {
        a(this.i, true);
      }
    }
    for (;;)
    {
      if (this.i != null) {
        this.i.setImageDrawable(paramDrawable);
      }
      return;
      if ((this.i != null) && (d(this.i)))
      {
        removeView(this.i);
        this.F.remove(this.i);
      }
    }
  }
  
  public void setLogoDescription(int paramInt)
  {
    setLogoDescription(getContext().getText(paramInt));
  }
  
  public void setLogoDescription(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence)) {
      e();
    }
    if (this.i != null) {
      this.i.setContentDescription(paramCharSequence);
    }
  }
  
  public void setMenu(h paramh, ActionMenuPresenter paramActionMenuPresenter)
  {
    if ((paramh == null) && (this.e == null)) {}
    h localh;
    do
    {
      return;
      g();
      localh = this.e.peekMenu();
    } while (localh == paramh);
    if (localh != null)
    {
      localh.removeMenuPresenter(this.J);
      localh.removeMenuPresenter(this.K);
    }
    if (this.K == null) {
      this.K = new a();
    }
    paramActionMenuPresenter.setExpandedActionViewsExclusive(true);
    if (paramh != null)
    {
      paramh.addMenuPresenter(paramActionMenuPresenter, this.l);
      paramh.addMenuPresenter(this.K, this.l);
    }
    for (;;)
    {
      this.e.setPopupTheme(this.m);
      this.e.setPresenter(paramActionMenuPresenter);
      this.J = paramActionMenuPresenter;
      return;
      paramActionMenuPresenter.initForMenu(this.l, null);
      this.K.initForMenu(this.l, null);
      paramActionMenuPresenter.updateMenuView(true);
      this.K.updateMenuView(true);
    }
  }
  
  public void setMenuCallbacks(n.a parama, h.a parama1)
  {
    this.L = parama;
    this.M = parama1;
    if (this.e != null) {
      this.e.setMenuCallbacks(parama, parama1);
    }
  }
  
  public void setNavigationContentDescription(int paramInt)
  {
    if (paramInt != 0) {}
    for (CharSequence localCharSequence = getContext().getText(paramInt);; localCharSequence = null)
    {
      setNavigationContentDescription(localCharSequence);
      return;
    }
  }
  
  public void setNavigationContentDescription(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence)) {
      h();
    }
    if (this.h != null) {
      this.h.setContentDescription(paramCharSequence);
    }
  }
  
  public void setNavigationIcon(int paramInt)
  {
    setNavigationIcon(b.getDrawable(getContext(), paramInt));
  }
  
  public void setNavigationIcon(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      h();
      if (!d(this.h)) {
        a(this.h, true);
      }
    }
    for (;;)
    {
      if (this.h != null) {
        this.h.setImageDrawable(paramDrawable);
      }
      return;
      if ((this.h != null) && (d(this.h)))
      {
        removeView(this.h);
        this.F.remove(this.h);
      }
    }
  }
  
  public void setNavigationOnClickListener(View.OnClickListener paramOnClickListener)
  {
    h();
    this.h.setOnClickListener(paramOnClickListener);
  }
  
  public void setOnMenuItemClickListener(b paramb)
  {
    this.d = paramb;
  }
  
  public void setOverflowIcon(Drawable paramDrawable)
  {
    f();
    this.e.setOverflowIcon(paramDrawable);
  }
  
  public void setPopupTheme(int paramInt)
  {
    if (this.m != paramInt)
    {
      this.m = paramInt;
      if (paramInt == 0) {
        this.l = getContext();
      }
    }
    else
    {
      return;
    }
    this.l = new ContextThemeWrapper(getContext(), paramInt);
  }
  
  public void setSubtitle(int paramInt)
  {
    setSubtitle(getContext().getText(paramInt));
  }
  
  public void setSubtitle(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      if (this.g == null)
      {
        Context localContext = getContext();
        this.g = new AppCompatTextView(localContext);
        this.g.setSingleLine();
        this.g.setEllipsize(TextUtils.TruncateAt.END);
        if (this.o != 0) {
          this.g.setTextAppearance(localContext, this.o);
        }
        if (this.B != 0) {
          this.g.setTextColor(this.B);
        }
      }
      if (!d(this.g)) {
        a(this.g, true);
      }
    }
    for (;;)
    {
      if (this.g != null) {
        this.g.setText(paramCharSequence);
      }
      this.z = paramCharSequence;
      return;
      if ((this.g != null) && (d(this.g)))
      {
        removeView(this.g);
        this.F.remove(this.g);
      }
    }
  }
  
  public void setSubtitleTextAppearance(Context paramContext, int paramInt)
  {
    this.o = paramInt;
    if (this.g != null) {
      this.g.setTextAppearance(paramContext, paramInt);
    }
  }
  
  public void setSubtitleTextColor(int paramInt)
  {
    this.B = paramInt;
    if (this.g != null) {
      this.g.setTextColor(paramInt);
    }
  }
  
  public void setTitle(int paramInt)
  {
    setTitle(getContext().getText(paramInt));
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      if (this.f == null)
      {
        Context localContext = getContext();
        this.f = new AppCompatTextView(localContext);
        this.f.setSingleLine();
        this.f.setEllipsize(TextUtils.TruncateAt.END);
        if (this.n != 0) {
          this.f.setTextAppearance(localContext, this.n);
        }
        if (this.A != 0) {
          this.f.setTextColor(this.A);
        }
      }
      if (!d(this.f)) {
        a(this.f, true);
      }
    }
    for (;;)
    {
      if (this.f != null) {
        this.f.setText(paramCharSequence);
      }
      this.y = paramCharSequence;
      return;
      if ((this.f != null) && (d(this.f)))
      {
        removeView(this.f);
        this.F.remove(this.f);
      }
    }
  }
  
  public void setTitleMargin(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.q = paramInt1;
    this.s = paramInt2;
    this.r = paramInt3;
    this.t = paramInt4;
    requestLayout();
  }
  
  public void setTitleMarginBottom(int paramInt)
  {
    this.t = paramInt;
    requestLayout();
  }
  
  public void setTitleMarginEnd(int paramInt)
  {
    this.r = paramInt;
    requestLayout();
  }
  
  public void setTitleMarginStart(int paramInt)
  {
    this.q = paramInt;
    requestLayout();
  }
  
  public void setTitleMarginTop(int paramInt)
  {
    this.s = paramInt;
    requestLayout();
  }
  
  public void setTitleTextAppearance(Context paramContext, int paramInt)
  {
    this.n = paramInt;
    if (this.f != null) {
      this.f.setTextAppearance(paramContext, paramInt);
    }
  }
  
  public void setTitleTextColor(int paramInt)
  {
    this.A = paramInt;
    if (this.f != null) {
      this.f.setTextColor(paramInt);
    }
  }
  
  public boolean showOverflowMenu()
  {
    return (this.e != null) && (this.e.showOverflowMenu());
  }
  
  public static class LayoutParams
    extends ActionBar.LayoutParams
  {
    int b = 0;
    
    public LayoutParams(int paramInt)
    {
      this(-2, -1, paramInt);
    }
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
      this.a = 8388627;
    }
    
    public LayoutParams(int paramInt1, int paramInt2, int paramInt3)
    {
      super(paramInt2);
      this.a = paramInt3;
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public LayoutParams(ActionBar.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
      this.b = paramLayoutParams.b;
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
      a(paramMarginLayoutParams);
    }
    
    void a(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      this.leftMargin = paramMarginLayoutParams.leftMargin;
      this.topMargin = paramMarginLayoutParams.topMargin;
      this.rightMargin = paramMarginLayoutParams.rightMargin;
      this.bottomMargin = paramMarginLayoutParams.bottomMargin;
    }
  }
  
  public static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator()
    {
      public Toolbar.SavedState createFromParcel(Parcel paramAnonymousParcel)
      {
        return new Toolbar.SavedState(paramAnonymousParcel, null);
      }
      
      public Toolbar.SavedState createFromParcel(Parcel paramAnonymousParcel, ClassLoader paramAnonymousClassLoader)
      {
        return new Toolbar.SavedState(paramAnonymousParcel, paramAnonymousClassLoader);
      }
      
      public Toolbar.SavedState[] newArray(int paramAnonymousInt)
      {
        return new Toolbar.SavedState[paramAnonymousInt];
      }
    };
    int a;
    boolean b;
    
    public SavedState(Parcel paramParcel)
    {
      this(paramParcel, null);
    }
    
    public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      this.a = paramParcel.readInt();
      if (paramParcel.readInt() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.b = bool;
        return;
      }
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.a);
      if (this.b) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        return;
      }
    }
  }
  
  private class a
    implements n
  {
    h a;
    j b;
    
    a() {}
    
    public boolean collapseItemActionView(h paramh, j paramj)
    {
      if ((Toolbar.this.b instanceof c)) {
        ((c)Toolbar.this.b).onActionViewCollapsed();
      }
      Toolbar.this.removeView(Toolbar.this.b);
      Toolbar.this.removeView(Toolbar.this.a);
      Toolbar.this.b = null;
      Toolbar.this.d();
      this.b = null;
      Toolbar.this.requestLayout();
      paramj.setActionViewExpanded(false);
      return true;
    }
    
    public boolean expandItemActionView(h paramh, j paramj)
    {
      Toolbar.this.a();
      if (Toolbar.this.a.getParent() != Toolbar.this) {
        Toolbar.this.addView(Toolbar.this.a);
      }
      Toolbar.this.b = paramj.getActionView();
      this.b = paramj;
      if (Toolbar.this.b.getParent() != Toolbar.this)
      {
        paramh = Toolbar.this.b();
        paramh.a = (0x800003 | Toolbar.this.c & 0x70);
        paramh.b = 2;
        Toolbar.this.b.setLayoutParams(paramh);
        Toolbar.this.addView(Toolbar.this.b);
      }
      Toolbar.this.c();
      Toolbar.this.requestLayout();
      paramj.setActionViewExpanded(true);
      if ((Toolbar.this.b instanceof c)) {
        ((c)Toolbar.this.b).onActionViewExpanded();
      }
      return true;
    }
    
    public boolean flagActionItems()
    {
      return false;
    }
    
    public int getId()
    {
      return 0;
    }
    
    public o getMenuView(ViewGroup paramViewGroup)
    {
      return null;
    }
    
    public void initForMenu(Context paramContext, h paramh)
    {
      if ((this.a != null) && (this.b != null)) {
        this.a.collapseItemActionView(this.b);
      }
      this.a = paramh;
    }
    
    public void onCloseMenu(h paramh, boolean paramBoolean) {}
    
    public void onRestoreInstanceState(Parcelable paramParcelable) {}
    
    public Parcelable onSaveInstanceState()
    {
      return null;
    }
    
    public boolean onSubMenuSelected(t paramt)
    {
      return false;
    }
    
    public void setCallback(n.a parama) {}
    
    public void updateMenuView(boolean paramBoolean)
    {
      int k = 0;
      int j;
      int m;
      int i;
      if (this.b != null)
      {
        j = k;
        if (this.a != null)
        {
          m = this.a.size();
          i = 0;
        }
      }
      for (;;)
      {
        j = k;
        if (i < m)
        {
          if (this.a.getItem(i) == this.b) {
            j = 1;
          }
        }
        else
        {
          if (j == 0) {
            collapseItemActionView(this.a, this.b);
          }
          return;
        }
        i += 1;
      }
    }
  }
  
  public static abstract interface b
  {
    @Instrumented
    public abstract boolean onMenuItemClick(MenuItem paramMenuItem);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/widget/Toolbar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */