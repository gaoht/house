package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.v4.app.NavUtils;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v4.view.WindowInsetsCompat;
import android.support.v4.widget.PopupWindowCompat;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.color;
import android.support.v7.appcompat.R.id;
import android.support.v7.appcompat.R.layout;
import android.support.v7.appcompat.R.style;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.view.b.a;
import android.support.v7.view.e;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.h.a;
import android.support.v7.view.menu.n.a;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.ContentFrameLayout.a;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.ViewStubCompat;
import android.support.v7.widget.ay;
import android.support.v7.widget.bb;
import android.support.v7.widget.g;
import android.support.v7.widget.t;
import android.support.v7.widget.y;
import android.support.v7.widget.y.a;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.LayoutInflater.Factory2;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.view.Window.Callback;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import org.xmlpull.v1.XmlPullParser;

class AppCompatDelegateImplV9
  extends f
  implements h.a, LayoutInflater.Factory2
{
  private static final boolean t;
  private View A;
  private boolean B;
  private boolean C;
  private boolean D;
  private PanelFeatureState[] E;
  private PanelFeatureState F;
  private boolean G;
  private final Runnable H = new Runnable()
  {
    public void run()
    {
      if ((AppCompatDelegateImplV9.this.s & 0x1) != 0) {
        AppCompatDelegateImplV9.this.c(0);
      }
      if ((AppCompatDelegateImplV9.this.s & 0x1000) != 0) {
        AppCompatDelegateImplV9.this.c(108);
      }
      AppCompatDelegateImplV9.this.r = false;
      AppCompatDelegateImplV9.this.s = 0;
    }
  };
  private boolean I;
  private Rect J;
  private Rect K;
  private l L;
  android.support.v7.view.b m;
  ActionBarContextView n;
  PopupWindow o;
  Runnable p;
  ViewPropertyAnimatorCompat q = null;
  boolean r;
  int s;
  private t u;
  private a v;
  private c w;
  private boolean x;
  private ViewGroup y;
  private TextView z;
  
  static
  {
    if (Build.VERSION.SDK_INT < 21) {}
    for (boolean bool = true;; bool = false)
    {
      t = bool;
      return;
    }
  }
  
  AppCompatDelegateImplV9(Context paramContext, Window paramWindow, d paramd)
  {
    super(paramContext, paramWindow, paramd);
  }
  
  private void a(int paramInt)
  {
    this.s |= 1 << paramInt;
    if (!this.r)
    {
      ViewCompat.postOnAnimation(this.b.getDecorView(), this.H);
      this.r = true;
    }
  }
  
  private void a(PanelFeatureState paramPanelFeatureState, KeyEvent paramKeyEvent)
  {
    int k = -1;
    if ((paramPanelFeatureState.o) || (c())) {}
    Object localObject;
    int i;
    label112:
    label117:
    label121:
    label123:
    do
    {
      do
      {
        for (;;)
        {
          return;
          if (paramPanelFeatureState.a == 0)
          {
            localObject = this.a;
            if ((((Context)localObject).getResources().getConfiguration().screenLayout & 0xF) != 4) {
              break label112;
            }
            i = 1;
            if (((Context)localObject).getApplicationInfo().targetSdkVersion < 11) {
              break label117;
            }
          }
          for (int j = 1;; j = 0)
          {
            if ((i != 0) && (j != 0)) {
              break label121;
            }
            localObject = d();
            if ((localObject == null) || (((Window.Callback)localObject).onMenuOpened(paramPanelFeatureState.a, paramPanelFeatureState.j))) {
              break label123;
            }
            a(paramPanelFeatureState, true);
            return;
            i = 0;
            break;
          }
        }
        localObject = (WindowManager)this.a.getSystemService("window");
      } while ((localObject == null) || (!b(paramPanelFeatureState, paramKeyEvent)));
      if ((paramPanelFeatureState.g != null) && (!paramPanelFeatureState.q)) {
        break label398;
      }
      if (paramPanelFeatureState.g != null) {
        break;
      }
    } while ((!a(paramPanelFeatureState)) || (paramPanelFeatureState.g == null));
    label187:
    if ((c(paramPanelFeatureState)) && (paramPanelFeatureState.hasPanelItems()))
    {
      paramKeyEvent = paramPanelFeatureState.h.getLayoutParams();
      if (paramKeyEvent != null) {
        break label434;
      }
      paramKeyEvent = new ViewGroup.LayoutParams(-2, -2);
    }
    label398:
    label434:
    for (;;)
    {
      i = paramPanelFeatureState.b;
      paramPanelFeatureState.g.setBackgroundResource(i);
      ViewParent localViewParent = paramPanelFeatureState.h.getParent();
      if ((localViewParent != null) && ((localViewParent instanceof ViewGroup))) {
        ((ViewGroup)localViewParent).removeView(paramPanelFeatureState.h);
      }
      paramPanelFeatureState.g.addView(paramPanelFeatureState.h, paramKeyEvent);
      if (!paramPanelFeatureState.h.hasFocus()) {
        paramPanelFeatureState.h.requestFocus();
      }
      i = -2;
      for (;;)
      {
        paramPanelFeatureState.n = false;
        paramKeyEvent = new WindowManager.LayoutParams(i, -2, paramPanelFeatureState.d, paramPanelFeatureState.e, 1002, 8519680, -3);
        paramKeyEvent.gravity = paramPanelFeatureState.c;
        paramKeyEvent.windowAnimations = paramPanelFeatureState.f;
        ((WindowManager)localObject).addView(paramPanelFeatureState.g, paramKeyEvent);
        paramPanelFeatureState.o = true;
        return;
        if ((!paramPanelFeatureState.q) || (paramPanelFeatureState.g.getChildCount() <= 0)) {
          break label187;
        }
        paramPanelFeatureState.g.removeAllViews();
        break label187;
        break;
        if (paramPanelFeatureState.i != null)
        {
          paramKeyEvent = paramPanelFeatureState.i.getLayoutParams();
          if (paramKeyEvent != null)
          {
            i = k;
            if (paramKeyEvent.width == -1) {
              continue;
            }
          }
        }
        i = -2;
      }
    }
  }
  
  private void a(h paramh, boolean paramBoolean)
  {
    if ((this.u != null) && (this.u.canShowOverflowMenu()) && ((!ViewConfiguration.get(this.a).hasPermanentMenuKey()) || (this.u.isOverflowMenuShowPending())))
    {
      paramh = d();
      if ((!this.u.isOverflowMenuShowing()) || (!paramBoolean)) {
        if ((paramh != null) && (!c()))
        {
          if ((this.r) && ((this.s & 0x1) != 0))
          {
            this.b.getDecorView().removeCallbacks(this.H);
            this.H.run();
          }
          PanelFeatureState localPanelFeatureState = a(0, true);
          if ((localPanelFeatureState.j != null) && (!localPanelFeatureState.r) && (paramh.onPreparePanel(0, localPanelFeatureState.i, localPanelFeatureState.j)))
          {
            paramh.onMenuOpened(108, localPanelFeatureState.j);
            this.u.showOverflowMenu();
          }
        }
      }
      do
      {
        return;
        this.u.hideOverflowMenu();
      } while (c());
      paramh.onPanelClosed(108, a(0, true).j);
      return;
    }
    paramh = a(0, true);
    paramh.q = true;
    a(paramh, false);
    a(paramh, null);
  }
  
  private boolean a(PanelFeatureState paramPanelFeatureState)
  {
    paramPanelFeatureState.a(b());
    paramPanelFeatureState.g = new ListMenuDecorView(paramPanelFeatureState.l);
    paramPanelFeatureState.c = 81;
    return true;
  }
  
  private boolean a(PanelFeatureState paramPanelFeatureState, int paramInt1, KeyEvent paramKeyEvent, int paramInt2)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramKeyEvent.isSystem()) {
      bool2 = bool1;
    }
    do
    {
      do
      {
        do
        {
          return bool2;
          if (!paramPanelFeatureState.m)
          {
            bool1 = bool2;
            if (!b(paramPanelFeatureState, paramKeyEvent)) {}
          }
          else
          {
            bool1 = bool2;
            if (paramPanelFeatureState.j != null) {
              bool1 = paramPanelFeatureState.j.performShortcut(paramInt1, paramKeyEvent, paramInt2);
            }
          }
          bool2 = bool1;
        } while (!bool1);
        bool2 = bool1;
      } while ((paramInt2 & 0x1) != 0);
      bool2 = bool1;
    } while (this.u != null);
    a(paramPanelFeatureState, true);
    return bool1;
  }
  
  private boolean a(ViewParent paramViewParent)
  {
    if (paramViewParent == null) {
      return false;
    }
    View localView = this.b.getDecorView();
    for (;;)
    {
      if (paramViewParent == null) {
        return true;
      }
      if ((paramViewParent == localView) || (!(paramViewParent instanceof View)) || (ViewCompat.isAttachedToWindow((View)paramViewParent))) {
        return false;
      }
      paramViewParent = paramViewParent.getParent();
    }
  }
  
  private boolean b(PanelFeatureState paramPanelFeatureState)
  {
    Context localContext = this.a;
    TypedValue localTypedValue;
    Resources.Theme localTheme;
    Object localObject1;
    if (((paramPanelFeatureState.a == 0) || (paramPanelFeatureState.a == 108)) && (this.u != null))
    {
      localTypedValue = new TypedValue();
      localTheme = localContext.getTheme();
      localTheme.resolveAttribute(R.attr.actionBarTheme, localTypedValue, true);
      localObject1 = null;
      if (localTypedValue.resourceId != 0)
      {
        localObject1 = localContext.getResources().newTheme();
        ((Resources.Theme)localObject1).setTo(localTheme);
        ((Resources.Theme)localObject1).applyStyle(localTypedValue.resourceId, true);
        ((Resources.Theme)localObject1).resolveAttribute(R.attr.actionBarWidgetTheme, localTypedValue, true);
        Object localObject2 = localObject1;
        if (localTypedValue.resourceId != 0)
        {
          localObject2 = localObject1;
          if (localObject1 == null)
          {
            localObject2 = localContext.getResources().newTheme();
            ((Resources.Theme)localObject2).setTo(localTheme);
          }
          ((Resources.Theme)localObject2).applyStyle(localTypedValue.resourceId, true);
        }
        if (localObject2 == null) {
          break label203;
        }
        localObject1 = new android.support.v7.view.d(localContext, 0);
        ((Context)localObject1).getTheme().setTo((Resources.Theme)localObject2);
      }
    }
    for (;;)
    {
      localObject1 = new h((Context)localObject1);
      ((h)localObject1).setCallback(this);
      paramPanelFeatureState.a((h)localObject1);
      return true;
      localTheme.resolveAttribute(R.attr.actionBarWidgetTheme, localTypedValue, true);
      break;
      label203:
      localObject1 = localContext;
    }
  }
  
  private boolean b(PanelFeatureState paramPanelFeatureState, KeyEvent paramKeyEvent)
  {
    if (c()) {
      return false;
    }
    if (paramPanelFeatureState.m) {
      return true;
    }
    if ((this.F != null) && (this.F != paramPanelFeatureState)) {
      a(this.F, false);
    }
    Window.Callback localCallback = d();
    if (localCallback != null) {
      paramPanelFeatureState.i = localCallback.onCreatePanelView(paramPanelFeatureState.a);
    }
    if ((paramPanelFeatureState.a == 0) || (paramPanelFeatureState.a == 108)) {}
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (this.u != null)) {
        this.u.setMenuPrepared();
      }
      if ((paramPanelFeatureState.i != null) || ((i != 0) && ((a() instanceof o)))) {
        break label407;
      }
      if ((paramPanelFeatureState.j != null) && (!paramPanelFeatureState.r)) {
        break label277;
      }
      if ((paramPanelFeatureState.j == null) && ((!b(paramPanelFeatureState)) || (paramPanelFeatureState.j == null))) {
        break;
      }
      if ((i != 0) && (this.u != null))
      {
        if (this.v == null) {
          this.v = new a();
        }
        this.u.setMenu(paramPanelFeatureState.j, this.v);
      }
      paramPanelFeatureState.j.stopDispatchingItemsChanged();
      if (localCallback.onCreatePanelMenu(paramPanelFeatureState.a, paramPanelFeatureState.j)) {
        break label272;
      }
      paramPanelFeatureState.a(null);
      if ((i == 0) || (this.u == null)) {
        break;
      }
      this.u.setMenu(null, this.v);
      return false;
    }
    label272:
    paramPanelFeatureState.r = false;
    label277:
    paramPanelFeatureState.j.stopDispatchingItemsChanged();
    if (paramPanelFeatureState.s != null)
    {
      paramPanelFeatureState.j.restoreActionViewStates(paramPanelFeatureState.s);
      paramPanelFeatureState.s = null;
    }
    if (!localCallback.onPreparePanel(0, paramPanelFeatureState.i, paramPanelFeatureState.j))
    {
      if ((i != 0) && (this.u != null)) {
        this.u.setMenu(null, this.v);
      }
      paramPanelFeatureState.j.startDispatchingItemsChanged();
      return false;
    }
    if (paramKeyEvent != null)
    {
      i = paramKeyEvent.getDeviceId();
      if (KeyCharacterMap.load(i).getKeyboardType() == 1) {
        break label429;
      }
    }
    label407:
    label429:
    for (boolean bool = true;; bool = false)
    {
      paramPanelFeatureState.p = bool;
      paramPanelFeatureState.j.setQwertyMode(paramPanelFeatureState.p);
      paramPanelFeatureState.j.startDispatchingItemsChanged();
      paramPanelFeatureState.m = true;
      paramPanelFeatureState.n = false;
      this.F = paramPanelFeatureState;
      return true;
      i = -1;
      break;
    }
  }
  
  private boolean c(PanelFeatureState paramPanelFeatureState)
  {
    if (paramPanelFeatureState.i != null)
    {
      paramPanelFeatureState.h = paramPanelFeatureState.i;
      return true;
    }
    if (paramPanelFeatureState.j == null) {
      return false;
    }
    if (this.w == null) {
      this.w = new c();
    }
    paramPanelFeatureState.h = ((View)paramPanelFeatureState.a(this.w));
    if (paramPanelFeatureState.h != null) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private boolean d(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getRepeatCount() == 0)
    {
      PanelFeatureState localPanelFeatureState = a(paramInt, true);
      if (!localPanelFeatureState.o) {
        return b(localPanelFeatureState, paramKeyEvent);
      }
    }
    return false;
  }
  
  private int e(int paramInt)
  {
    int i;
    if (paramInt == 8)
    {
      Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
      i = 108;
    }
    do
    {
      return i;
      i = paramInt;
    } while (paramInt != 9);
    Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
    return 109;
  }
  
  private boolean e(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool2 = true;
    if (this.m != null) {
      return false;
    }
    PanelFeatureState localPanelFeatureState = a(paramInt, true);
    if ((paramInt == 0) && (this.u != null) && (this.u.canShowOverflowMenu()) && (!ViewConfiguration.get(this.a).hasPermanentMenuKey())) {
      if (!this.u.isOverflowMenuShowing())
      {
        if ((c()) || (!b(localPanelFeatureState, paramKeyEvent))) {
          break label229;
        }
        bool1 = this.u.showOverflowMenu();
      }
    }
    for (;;)
    {
      if (bool1)
      {
        paramKeyEvent = (AudioManager)this.a.getSystemService("audio");
        if (paramKeyEvent == null) {
          break label216;
        }
        paramKeyEvent.playSoundEffect(0);
      }
      label122:
      return bool1;
      bool1 = this.u.hideOverflowMenu();
      continue;
      if ((!localPanelFeatureState.o) && (!localPanelFeatureState.n)) {
        break;
      }
      bool1 = localPanelFeatureState.o;
      a(localPanelFeatureState, true);
    }
    if (localPanelFeatureState.m)
    {
      if (!localPanelFeatureState.r) {
        break label234;
      }
      localPanelFeatureState.m = false;
    }
    label216:
    label229:
    label234:
    for (boolean bool1 = b(localPanelFeatureState, paramKeyEvent);; bool1 = true)
    {
      if (bool1)
      {
        a(localPanelFeatureState, paramKeyEvent);
        bool1 = bool2;
        break;
        Log.w("AppCompatDelegate", "Couldn't get audio manager");
        break label122;
      }
      bool1 = false;
      break;
    }
  }
  
  private void j()
  {
    if (!this.x)
    {
      this.y = k();
      Object localObject = e();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        a((CharSequence)localObject);
      }
      l();
      a(this.y);
      this.x = true;
      localObject = a(0, false);
      if ((!c()) && ((localObject == null) || (((PanelFeatureState)localObject).j == null))) {
        a(108);
      }
    }
  }
  
  private ViewGroup k()
  {
    Object localObject = this.a.obtainStyledAttributes(R.styleable.AppCompatTheme);
    if (!((TypedArray)localObject).hasValue(R.styleable.AppCompatTheme_windowActionBar))
    {
      ((TypedArray)localObject).recycle();
      throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
    }
    if (((TypedArray)localObject).getBoolean(R.styleable.AppCompatTheme_windowNoTitle, false))
    {
      requestWindowFeature(1);
      if (((TypedArray)localObject).getBoolean(R.styleable.AppCompatTheme_windowActionBarOverlay, false)) {
        requestWindowFeature(109);
      }
      if (((TypedArray)localObject).getBoolean(R.styleable.AppCompatTheme_windowActionModeOverlay, false)) {
        requestWindowFeature(10);
      }
      this.k = ((TypedArray)localObject).getBoolean(R.styleable.AppCompatTheme_android_windowIsFloating, false);
      ((TypedArray)localObject).recycle();
      this.b.getDecorView();
      localObject = LayoutInflater.from(this.a);
      if (this.l) {
        break label430;
      }
      if (!this.k) {
        break label271;
      }
      localObject = (ViewGroup)((LayoutInflater)localObject).inflate(R.layout.abc_dialog_title_material, null);
      this.i = false;
      this.h = false;
    }
    for (;;)
    {
      if (localObject == null)
      {
        throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.h + ", windowActionBarOverlay: " + this.i + ", android:windowIsFloating: " + this.k + ", windowActionModeOverlay: " + this.j + ", windowNoTitle: " + this.l + " }");
        if (!((TypedArray)localObject).getBoolean(R.styleable.AppCompatTheme_windowActionBar, false)) {
          break;
        }
        requestWindowFeature(108);
        break;
        label271:
        if (!this.h) {
          break label638;
        }
        localObject = new TypedValue();
        this.a.getTheme().resolveAttribute(R.attr.actionBarTheme, (TypedValue)localObject, true);
        if (((TypedValue)localObject).resourceId != 0) {}
        for (localObject = new android.support.v7.view.d(this.a, ((TypedValue)localObject).resourceId);; localObject = this.a)
        {
          localObject = (ViewGroup)LayoutInflater.from((Context)localObject).inflate(R.layout.abc_screen_toolbar, null);
          this.u = ((t)((ViewGroup)localObject).findViewById(R.id.decor_content_parent));
          this.u.setWindowCallback(d());
          if (this.i) {
            this.u.initFeature(109);
          }
          if (this.B) {
            this.u.initFeature(2);
          }
          if (this.C) {
            this.u.initFeature(5);
          }
          break;
        }
        label430:
        if (this.j) {}
        for (localObject = (ViewGroup)((LayoutInflater)localObject).inflate(R.layout.abc_screen_simple_overlay_action_mode, null);; localObject = (ViewGroup)((LayoutInflater)localObject).inflate(R.layout.abc_screen_simple, null))
        {
          if (Build.VERSION.SDK_INT < 21) {
            break label487;
          }
          ViewCompat.setOnApplyWindowInsetsListener((View)localObject, new OnApplyWindowInsetsListener()
          {
            public WindowInsetsCompat onApplyWindowInsets(View paramAnonymousView, WindowInsetsCompat paramAnonymousWindowInsetsCompat)
            {
              int i = paramAnonymousWindowInsetsCompat.getSystemWindowInsetTop();
              int j = AppCompatDelegateImplV9.this.d(i);
              WindowInsetsCompat localWindowInsetsCompat = paramAnonymousWindowInsetsCompat;
              if (i != j) {
                localWindowInsetsCompat = paramAnonymousWindowInsetsCompat.replaceSystemWindowInsets(paramAnonymousWindowInsetsCompat.getSystemWindowInsetLeft(), j, paramAnonymousWindowInsetsCompat.getSystemWindowInsetRight(), paramAnonymousWindowInsetsCompat.getSystemWindowInsetBottom());
              }
              return ViewCompat.onApplyWindowInsets(paramAnonymousView, localWindowInsetsCompat);
            }
          });
          break;
        }
        label487:
        ((y)localObject).setOnFitSystemWindowsListener(new y.a()
        {
          public void onFitSystemWindows(Rect paramAnonymousRect)
          {
            paramAnonymousRect.top = AppCompatDelegateImplV9.this.d(paramAnonymousRect.top);
          }
        });
        continue;
      }
      if (this.u == null) {
        this.z = ((TextView)((ViewGroup)localObject).findViewById(R.id.title));
      }
      bb.makeOptionalFitsSystemWindows((View)localObject);
      ContentFrameLayout localContentFrameLayout = (ContentFrameLayout)((ViewGroup)localObject).findViewById(R.id.action_bar_activity_content);
      ViewGroup localViewGroup = (ViewGroup)this.b.findViewById(16908290);
      if (localViewGroup != null)
      {
        while (localViewGroup.getChildCount() > 0)
        {
          View localView = localViewGroup.getChildAt(0);
          localViewGroup.removeViewAt(0);
          localContentFrameLayout.addView(localView);
        }
        localViewGroup.setId(-1);
        localContentFrameLayout.setId(16908290);
        if ((localViewGroup instanceof FrameLayout)) {
          ((FrameLayout)localViewGroup).setForeground(null);
        }
      }
      this.b.setContentView((View)localObject);
      localContentFrameLayout.setAttachListener(new ContentFrameLayout.a()
      {
        public void onAttachedFromWindow() {}
        
        public void onDetachedFromWindow()
        {
          AppCompatDelegateImplV9.this.i();
        }
      });
      return (ViewGroup)localObject;
      label638:
      localObject = null;
    }
  }
  
  private void l()
  {
    ContentFrameLayout localContentFrameLayout = (ContentFrameLayout)this.y.findViewById(16908290);
    Object localObject = this.b.getDecorView();
    localContentFrameLayout.setDecorPadding(((View)localObject).getPaddingLeft(), ((View)localObject).getPaddingTop(), ((View)localObject).getPaddingRight(), ((View)localObject).getPaddingBottom());
    localObject = this.a.obtainStyledAttributes(R.styleable.AppCompatTheme);
    ((TypedArray)localObject).getValue(R.styleable.AppCompatTheme_windowMinWidthMajor, localContentFrameLayout.getMinWidthMajor());
    ((TypedArray)localObject).getValue(R.styleable.AppCompatTheme_windowMinWidthMinor, localContentFrameLayout.getMinWidthMinor());
    if (((TypedArray)localObject).hasValue(R.styleable.AppCompatTheme_windowFixedWidthMajor)) {
      ((TypedArray)localObject).getValue(R.styleable.AppCompatTheme_windowFixedWidthMajor, localContentFrameLayout.getFixedWidthMajor());
    }
    if (((TypedArray)localObject).hasValue(R.styleable.AppCompatTheme_windowFixedWidthMinor)) {
      ((TypedArray)localObject).getValue(R.styleable.AppCompatTheme_windowFixedWidthMinor, localContentFrameLayout.getFixedWidthMinor());
    }
    if (((TypedArray)localObject).hasValue(R.styleable.AppCompatTheme_windowFixedHeightMajor)) {
      ((TypedArray)localObject).getValue(R.styleable.AppCompatTheme_windowFixedHeightMajor, localContentFrameLayout.getFixedHeightMajor());
    }
    if (((TypedArray)localObject).hasValue(R.styleable.AppCompatTheme_windowFixedHeightMinor)) {
      ((TypedArray)localObject).getValue(R.styleable.AppCompatTheme_windowFixedHeightMinor, localContentFrameLayout.getFixedHeightMinor());
    }
    ((TypedArray)localObject).recycle();
    localContentFrameLayout.requestLayout();
  }
  
  private void m()
  {
    if (this.x) {
      throw new AndroidRuntimeException("Window feature must be requested before adding content");
    }
  }
  
  protected PanelFeatureState a(int paramInt, boolean paramBoolean)
  {
    Object localObject2 = this.E;
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (localObject2.length > paramInt) {}
    }
    else
    {
      localObject1 = new PanelFeatureState[paramInt + 1];
      if (localObject2 != null) {
        System.arraycopy(localObject2, 0, localObject1, 0, localObject2.length);
      }
      this.E = ((PanelFeatureState[])localObject1);
    }
    localObject2 = localObject1[paramInt];
    if (localObject2 == null)
    {
      localObject2 = new PanelFeatureState(paramInt);
      localObject1[paramInt] = localObject2;
      return (PanelFeatureState)localObject2;
    }
    return (PanelFeatureState)localObject2;
  }
  
  PanelFeatureState a(Menu paramMenu)
  {
    PanelFeatureState[] arrayOfPanelFeatureState = this.E;
    int i;
    int j;
    if (arrayOfPanelFeatureState != null)
    {
      i = arrayOfPanelFeatureState.length;
      j = 0;
    }
    for (;;)
    {
      if (j >= i) {
        break label57;
      }
      PanelFeatureState localPanelFeatureState = arrayOfPanelFeatureState[j];
      if ((localPanelFeatureState != null) && (localPanelFeatureState.j == paramMenu))
      {
        return localPanelFeatureState;
        i = 0;
        break;
      }
      j += 1;
    }
    label57:
    return null;
  }
  
  android.support.v7.view.b a(b.a parama)
  {
    g();
    if (this.m != null) {
      this.m.finish();
    }
    Object localObject1 = parama;
    if (!(parama instanceof b)) {
      localObject1 = new b(parama);
    }
    if ((this.e != null) && (!c())) {}
    for (;;)
    {
      try
      {
        parama = this.e.onWindowStartingSupportActionMode((b.a)localObject1);
        if (parama != null)
        {
          this.m = parama;
          if ((this.m != null) && (this.e != null)) {
            this.e.onSupportActionModeStarted(this.m);
          }
          return this.m;
        }
      }
      catch (AbstractMethodError parama)
      {
        parama = null;
        continue;
        Object localObject2;
        if (this.n == null)
        {
          if (!this.k) {
            continue;
          }
          localObject2 = new TypedValue();
          parama = this.a.getTheme();
          parama.resolveAttribute(R.attr.actionBarTheme, (TypedValue)localObject2, true);
          if (((TypedValue)localObject2).resourceId != 0)
          {
            Resources.Theme localTheme = this.a.getResources().newTheme();
            localTheme.setTo(parama);
            localTheme.applyStyle(((TypedValue)localObject2).resourceId, true);
            parama = new android.support.v7.view.d(this.a, 0);
            parama.getTheme().setTo(localTheme);
            this.n = new ActionBarContextView(parama);
            this.o = new PopupWindow(parama, null, R.attr.actionModePopupWindowStyle);
            PopupWindowCompat.setWindowLayoutType(this.o, 2);
            this.o.setContentView(this.n);
            this.o.setWidth(-1);
            parama.getTheme().resolveAttribute(R.attr.actionBarSize, (TypedValue)localObject2, true);
            int i = TypedValue.complexToDimensionPixelSize(((TypedValue)localObject2).data, parama.getResources().getDisplayMetrics());
            this.n.setContentHeight(i);
            this.o.setHeight(-2);
            this.p = new Runnable()
            {
              public void run()
              {
                PopupWindow localPopupWindow = AppCompatDelegateImplV9.this.o;
                ActionBarContextView localActionBarContextView = AppCompatDelegateImplV9.this.n;
                if (!(localPopupWindow instanceof PopupWindow)) {
                  localPopupWindow.showAtLocation(localActionBarContextView, 55, 0, 0);
                }
                for (;;)
                {
                  AppCompatDelegateImplV9.this.g();
                  if (!AppCompatDelegateImplV9.this.f()) {
                    break;
                  }
                  AppCompatDelegateImplV9.this.n.setAlpha(0.0F);
                  AppCompatDelegateImplV9.this.q = ViewCompat.animate(AppCompatDelegateImplV9.this.n).alpha(1.0F);
                  AppCompatDelegateImplV9.this.q.setListener(new ViewPropertyAnimatorListenerAdapter()
                  {
                    public void onAnimationEnd(View paramAnonymous2View)
                    {
                      AppCompatDelegateImplV9.this.n.setAlpha(1.0F);
                      AppCompatDelegateImplV9.this.q.setListener(null);
                      AppCompatDelegateImplV9.this.q = null;
                    }
                    
                    public void onAnimationStart(View paramAnonymous2View)
                    {
                      AppCompatDelegateImplV9.this.n.setVisibility(0);
                    }
                  });
                  return;
                  VdsAgent.showAtLocation((PopupWindow)localPopupWindow, localActionBarContextView, 55, 0, 0);
                }
                AppCompatDelegateImplV9.this.n.setAlpha(1.0F);
                AppCompatDelegateImplV9.this.n.setVisibility(0);
              }
            };
          }
        }
        else
        {
          if (this.n == null) {
            continue;
          }
          g();
          this.n.killMode();
          parama = this.n.getContext();
          localObject2 = this.n;
          if (this.o != null) {
            continue;
          }
          bool = true;
          parama = new e(parama, (ActionBarContextView)localObject2, (b.a)localObject1, bool);
          if (!((b.a)localObject1).onCreateActionMode(parama, parama.getMenu())) {
            continue;
          }
          parama.invalidate();
          this.n.initForMode(parama);
          this.m = parama;
          if (!f()) {
            continue;
          }
          this.n.setAlpha(0.0F);
          this.q = ViewCompat.animate(this.n).alpha(1.0F);
          this.q.setListener(new ViewPropertyAnimatorListenerAdapter()
          {
            public void onAnimationEnd(View paramAnonymousView)
            {
              AppCompatDelegateImplV9.this.n.setAlpha(1.0F);
              AppCompatDelegateImplV9.this.q.setListener(null);
              AppCompatDelegateImplV9.this.q = null;
            }
            
            public void onAnimationStart(View paramAnonymousView)
            {
              AppCompatDelegateImplV9.this.n.setVisibility(0);
              AppCompatDelegateImplV9.this.n.sendAccessibilityEvent(32);
              if ((AppCompatDelegateImplV9.this.n.getParent() instanceof View)) {
                ViewCompat.requestApplyInsets((View)AppCompatDelegateImplV9.this.n.getParent());
              }
            }
          });
          if (this.o == null) {
            continue;
          }
          this.b.getDecorView().post(this.p);
          continue;
        }
        parama = this.a;
        continue;
        parama = (ViewStubCompat)this.y.findViewById(R.id.action_mode_bar_stub);
        if (parama == null) {
          continue;
        }
        parama.setLayoutInflater(LayoutInflater.from(b()));
        this.n = ((ActionBarContextView)parama.inflate());
        continue;
        boolean bool = false;
        continue;
        this.n.setAlpha(1.0F);
        this.n.setVisibility(0);
        this.n.sendAccessibilityEvent(32);
        if (!(this.n.getParent() instanceof View)) {
          continue;
        }
        ViewCompat.requestApplyInsets((View)this.n.getParent());
        continue;
        this.m = null;
        continue;
      }
      parama = null;
    }
  }
  
  View a(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    if ((this.c instanceof LayoutInflater.Factory))
    {
      paramView = ((LayoutInflater.Factory)this.c).onCreateView(paramString, paramContext, paramAttributeSet);
      if (paramView != null) {
        return paramView;
      }
    }
    return null;
  }
  
  void a(int paramInt, PanelFeatureState paramPanelFeatureState, Menu paramMenu)
  {
    Object localObject1 = paramPanelFeatureState;
    Object localObject2 = paramMenu;
    if (paramMenu == null)
    {
      PanelFeatureState localPanelFeatureState = paramPanelFeatureState;
      if (paramPanelFeatureState == null)
      {
        localPanelFeatureState = paramPanelFeatureState;
        if (paramInt >= 0)
        {
          localPanelFeatureState = paramPanelFeatureState;
          if (paramInt < this.E.length) {
            localPanelFeatureState = this.E[paramInt];
          }
        }
      }
      localObject1 = localPanelFeatureState;
      localObject2 = paramMenu;
      if (localPanelFeatureState != null)
      {
        localObject2 = localPanelFeatureState.j;
        localObject1 = localPanelFeatureState;
      }
    }
    if ((localObject1 != null) && (!((PanelFeatureState)localObject1).o)) {}
    while (c()) {
      return;
    }
    this.c.onPanelClosed(paramInt, (Menu)localObject2);
  }
  
  void a(int paramInt, Menu paramMenu)
  {
    if (paramInt == 108)
    {
      paramMenu = getSupportActionBar();
      if (paramMenu != null) {
        paramMenu.dispatchMenuVisibilityChanged(false);
      }
    }
    do
    {
      do
      {
        return;
      } while (paramInt != 0);
      paramMenu = a(paramInt, true);
    } while (!paramMenu.o);
    a(paramMenu, false);
  }
  
  void a(PanelFeatureState paramPanelFeatureState, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramPanelFeatureState.a == 0) && (this.u != null) && (this.u.isOverflowMenuShowing())) {
      a(paramPanelFeatureState.j);
    }
    do
    {
      return;
      WindowManager localWindowManager = (WindowManager)this.a.getSystemService("window");
      if ((localWindowManager != null) && (paramPanelFeatureState.o) && (paramPanelFeatureState.g != null))
      {
        localWindowManager.removeView(paramPanelFeatureState.g);
        if (paramBoolean) {
          a(paramPanelFeatureState.a, paramPanelFeatureState, null);
        }
      }
      paramPanelFeatureState.m = false;
      paramPanelFeatureState.n = false;
      paramPanelFeatureState.o = false;
      paramPanelFeatureState.h = null;
      paramPanelFeatureState.q = true;
    } while (this.F != paramPanelFeatureState);
    this.F = null;
  }
  
  void a(h paramh)
  {
    if (this.D) {
      return;
    }
    this.D = true;
    this.u.dismissPopups();
    Window.Callback localCallback = d();
    if ((localCallback != null) && (!c())) {
      localCallback.onPanelClosed(108, paramh);
    }
    this.D = false;
  }
  
  void a(ViewGroup paramViewGroup) {}
  
  void a(CharSequence paramCharSequence)
  {
    if (this.u != null) {
      this.u.setWindowTitle(paramCharSequence);
    }
    do
    {
      return;
      if (a() != null)
      {
        a().setWindowTitle(paramCharSequence);
        return;
      }
    } while (this.z == null);
    this.z.setText(paramCharSequence);
  }
  
  boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    Object localObject = getSupportActionBar();
    if ((localObject != null) && (((ActionBar)localObject).onKeyShortcut(paramInt, paramKeyEvent))) {}
    boolean bool;
    do
    {
      do
      {
        return true;
        if ((this.F == null) || (!a(this.F, paramKeyEvent.getKeyCode(), paramKeyEvent, 1))) {
          break;
        }
      } while (this.F == null);
      this.F.n = true;
      return true;
      if (this.F != null) {
        break;
      }
      localObject = a(0, true);
      b((PanelFeatureState)localObject, paramKeyEvent);
      bool = a((PanelFeatureState)localObject, paramKeyEvent.getKeyCode(), paramKeyEvent, 1);
      ((PanelFeatureState)localObject).m = false;
    } while (bool);
    return false;
  }
  
  boolean a(KeyEvent paramKeyEvent)
  {
    int i = 1;
    if ((paramKeyEvent.getKeyCode() == 82) && (this.c.dispatchKeyEvent(paramKeyEvent))) {
      return true;
    }
    int j = paramKeyEvent.getKeyCode();
    if (paramKeyEvent.getAction() == 0) {}
    while (i != 0)
    {
      return c(j, paramKeyEvent);
      i = 0;
    }
    return b(j, paramKeyEvent);
  }
  
  public void addContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    j();
    ((ViewGroup)this.y.findViewById(16908290)).addView(paramView, paramLayoutParams);
    this.c.onContentChanged();
  }
  
  void b(int paramInt)
  {
    a(a(paramInt, true), true);
  }
  
  boolean b(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool1 = true;
    switch (paramInt)
    {
    }
    do
    {
      bool1 = false;
      boolean bool2;
      do
      {
        return bool1;
        e(0, paramKeyEvent);
        return true;
        bool2 = this.G;
        this.G = false;
        paramKeyEvent = a(0, false);
        if ((paramKeyEvent == null) || (!paramKeyEvent.o)) {
          break;
        }
      } while (bool2);
      a(paramKeyEvent, true);
      return true;
    } while (!h());
    return true;
  }
  
  boolean b(int paramInt, Menu paramMenu)
  {
    if (paramInt == 108)
    {
      paramMenu = getSupportActionBar();
      if (paramMenu != null) {
        paramMenu.dispatchMenuVisibilityChanged(true);
      }
      return true;
    }
    return false;
  }
  
  void c(int paramInt)
  {
    PanelFeatureState localPanelFeatureState = a(paramInt, true);
    if (localPanelFeatureState.j != null)
    {
      Bundle localBundle = new Bundle();
      localPanelFeatureState.j.saveActionViewStates(localBundle);
      if (localBundle.size() > 0) {
        localPanelFeatureState.s = localBundle;
      }
      localPanelFeatureState.j.stopDispatchingItemsChanged();
      localPanelFeatureState.j.clear();
    }
    localPanelFeatureState.r = true;
    localPanelFeatureState.q = true;
    if (((paramInt == 108) || (paramInt == 0)) && (this.u != null))
    {
      localPanelFeatureState = a(0, false);
      if (localPanelFeatureState != null)
      {
        localPanelFeatureState.m = false;
        b(localPanelFeatureState, null);
      }
    }
  }
  
  boolean c(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = true;
    switch (paramInt)
    {
    default: 
      if (Build.VERSION.SDK_INT < 11) {
        a(paramInt, paramKeyEvent);
      }
      return false;
    case 82: 
      d(0, paramKeyEvent);
      return true;
    }
    if ((paramKeyEvent.getFlags() & 0x80) != 0) {}
    for (;;)
    {
      this.G = bool;
      break;
      bool = false;
    }
  }
  
  public View createView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    if (this.L == null) {
      this.L = new l();
    }
    boolean bool;
    if (t) {
      if ((paramAttributeSet instanceof XmlPullParser)) {
        if (((XmlPullParser)paramAttributeSet).getDepth() > 1) {
          bool = true;
        }
      }
    }
    for (;;)
    {
      return this.L.createView(paramView, paramString, paramContext, paramAttributeSet, bool, t, true, ay.shouldBeUsed());
      bool = false;
      continue;
      bool = a((ViewParent)paramView);
      continue;
      bool = false;
    }
  }
  
  int d(int paramInt)
  {
    int j = 1;
    int k = 1;
    int i1 = 0;
    Object localObject1;
    Object localObject2;
    int i;
    if ((this.n != null) && ((this.n.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)))
    {
      localObject1 = (ViewGroup.MarginLayoutParams)this.n.getLayoutParams();
      if (this.n.isShown())
      {
        if (this.J == null)
        {
          this.J = new Rect();
          this.K = new Rect();
        }
        localObject2 = this.J;
        Rect localRect = this.K;
        ((Rect)localObject2).set(0, paramInt, 0, 0);
        bb.computeFitSystemWindows(this.y, (Rect)localObject2, localRect);
        if (localRect.top == 0)
        {
          i = paramInt;
          if (((ViewGroup.MarginLayoutParams)localObject1).topMargin == i) {
            break label355;
          }
          ((ViewGroup.MarginLayoutParams)localObject1).topMargin = paramInt;
          if (this.A != null) {
            break label279;
          }
          this.A = new View(this.a);
          this.A.setBackgroundColor(this.a.getResources().getColor(R.color.abc_input_method_navigation_guard));
          this.y.addView(this.A, -1, new ViewGroup.LayoutParams(-1, paramInt));
          i = 1;
          label201:
          if (this.A == null) {
            break label317;
          }
          label208:
          j = paramInt;
          if (!this.j)
          {
            j = paramInt;
            if (k != 0) {
              j = 0;
            }
          }
          paramInt = j;
          j = i;
          i = k;
          label233:
          if (j != 0) {
            this.n.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          }
        }
      }
    }
    for (;;)
    {
      if (this.A != null)
      {
        localObject1 = this.A;
        if (i == 0) {
          break label342;
        }
      }
      label279:
      label317:
      label342:
      for (i = i1;; i = 8)
      {
        ((View)localObject1).setVisibility(i);
        return paramInt;
        i = 0;
        break;
        localObject2 = this.A.getLayoutParams();
        if (((ViewGroup.LayoutParams)localObject2).height != paramInt)
        {
          ((ViewGroup.LayoutParams)localObject2).height = paramInt;
          this.A.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
        i = 1;
        break label201;
        k = 0;
        break label208;
        if (((ViewGroup.MarginLayoutParams)localObject1).topMargin == 0) {
          break label348;
        }
        ((ViewGroup.MarginLayoutParams)localObject1).topMargin = 0;
        i = 0;
        break label233;
      }
      label348:
      j = 0;
      i = 0;
      break label233;
      label355:
      i = 0;
      break label201;
      i = 0;
    }
  }
  
  final boolean f()
  {
    return (this.x) && (this.y != null) && (ViewCompat.isLaidOut(this.y));
  }
  
  public <T extends View> T findViewById(int paramInt)
  {
    j();
    return this.b.findViewById(paramInt);
  }
  
  void g()
  {
    if (this.q != null) {
      this.q.cancel();
    }
  }
  
  boolean h()
  {
    if (this.m != null) {
      this.m.finish();
    }
    ActionBar localActionBar;
    do
    {
      return true;
      localActionBar = getSupportActionBar();
    } while ((localActionBar != null) && (localActionBar.collapseActionView()));
    return false;
  }
  
  public boolean hasWindowFeature(int paramInt)
  {
    switch (e(paramInt))
    {
    default: 
      return false;
    case 108: 
      return this.h;
    case 109: 
      return this.i;
    case 10: 
      return this.j;
    case 2: 
      return this.B;
    case 5: 
      return this.C;
    }
    return this.l;
  }
  
  void i()
  {
    if (this.u != null) {
      this.u.dismissPopups();
    }
    if (this.o != null)
    {
      this.b.getDecorView().removeCallbacks(this.p);
      if (!this.o.isShowing()) {}
    }
    try
    {
      this.o.dismiss();
      this.o = null;
      g();
      PanelFeatureState localPanelFeatureState = a(0, false);
      if ((localPanelFeatureState != null) && (localPanelFeatureState.j != null)) {
        localPanelFeatureState.j.close();
      }
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;) {}
    }
  }
  
  public void initWindowDecorActionBar()
  {
    j();
    if ((!this.h) || (this.f != null)) {}
    for (;;)
    {
      return;
      if ((this.c instanceof Activity)) {
        this.f = new r((Activity)this.c, this.i);
      }
      while (this.f != null)
      {
        this.f.setDefaultDisplayHomeAsUpEnabled(this.I);
        return;
        if ((this.c instanceof Dialog)) {
          this.f = new r((Dialog)this.c);
        }
      }
    }
  }
  
  public void installViewFactory()
  {
    LayoutInflater localLayoutInflater = LayoutInflater.from(this.a);
    if (localLayoutInflater.getFactory() == null) {
      LayoutInflaterCompat.setFactory2(localLayoutInflater, this);
    }
    while ((localLayoutInflater.getFactory2() instanceof AppCompatDelegateImplV9)) {
      return;
    }
    Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
  }
  
  public void invalidateOptionsMenu()
  {
    ActionBar localActionBar = getSupportActionBar();
    if ((localActionBar != null) && (localActionBar.invalidateOptionsMenu())) {
      return;
    }
    a(0);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if ((this.h) && (this.x))
    {
      ActionBar localActionBar = getSupportActionBar();
      if (localActionBar != null) {
        localActionBar.onConfigurationChanged(paramConfiguration);
      }
    }
    g.get().onConfigurationChanged(this.a);
    applyDayNight();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (((this.c instanceof Activity)) && (NavUtils.getParentActivityName((Activity)this.c) != null))
    {
      paramBundle = a();
      if (paramBundle == null) {
        this.I = true;
      }
    }
    else
    {
      return;
    }
    paramBundle.setDefaultDisplayHomeAsUpEnabled(true);
  }
  
  public final View onCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    View localView = a(paramView, paramString, paramContext, paramAttributeSet);
    if (localView != null) {
      return localView;
    }
    return createView(paramView, paramString, paramContext, paramAttributeSet);
  }
  
  public View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    return onCreateView(null, paramString, paramContext, paramAttributeSet);
  }
  
  public void onDestroy()
  {
    if (this.r) {
      this.b.getDecorView().removeCallbacks(this.H);
    }
    super.onDestroy();
    if (this.f != null) {
      this.f.a();
    }
  }
  
  public boolean onMenuItemSelected(h paramh, MenuItem paramMenuItem)
  {
    Window.Callback localCallback = d();
    if ((localCallback != null) && (!c()))
    {
      paramh = a(paramh.getRootMenu());
      if (paramh != null) {
        return localCallback.onMenuItemSelected(paramh.a, paramMenuItem);
      }
    }
    return false;
  }
  
  public void onMenuModeChange(h paramh)
  {
    a(paramh, true);
  }
  
  public void onPostCreate(Bundle paramBundle)
  {
    j();
  }
  
  public void onPostResume()
  {
    ActionBar localActionBar = getSupportActionBar();
    if (localActionBar != null) {
      localActionBar.setShowHideAnimationEnabled(true);
    }
  }
  
  public void onStop()
  {
    ActionBar localActionBar = getSupportActionBar();
    if (localActionBar != null) {
      localActionBar.setShowHideAnimationEnabled(false);
    }
  }
  
  public boolean requestWindowFeature(int paramInt)
  {
    paramInt = e(paramInt);
    if ((this.l) && (paramInt == 108)) {
      return false;
    }
    if ((this.h) && (paramInt == 1)) {
      this.h = false;
    }
    switch (paramInt)
    {
    default: 
      return this.b.requestFeature(paramInt);
    case 108: 
      m();
      this.h = true;
      return true;
    case 109: 
      m();
      this.i = true;
      return true;
    case 10: 
      m();
      this.j = true;
      return true;
    case 2: 
      m();
      this.B = true;
      return true;
    case 5: 
      m();
      this.C = true;
      return true;
    }
    m();
    this.l = true;
    return true;
  }
  
  public void setContentView(int paramInt)
  {
    j();
    ViewGroup localViewGroup = (ViewGroup)this.y.findViewById(16908290);
    localViewGroup.removeAllViews();
    LayoutInflater.from(this.a).inflate(paramInt, localViewGroup);
    this.c.onContentChanged();
  }
  
  public void setContentView(View paramView)
  {
    j();
    ViewGroup localViewGroup = (ViewGroup)this.y.findViewById(16908290);
    localViewGroup.removeAllViews();
    localViewGroup.addView(paramView);
    this.c.onContentChanged();
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    j();
    ViewGroup localViewGroup = (ViewGroup)this.y.findViewById(16908290);
    localViewGroup.removeAllViews();
    localViewGroup.addView(paramView, paramLayoutParams);
    this.c.onContentChanged();
  }
  
  public void setSupportActionBar(Toolbar paramToolbar)
  {
    if (!(this.c instanceof Activity)) {
      return;
    }
    ActionBar localActionBar = getSupportActionBar();
    if ((localActionBar instanceof r)) {
      throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
    }
    this.g = null;
    if (localActionBar != null) {
      localActionBar.a();
    }
    if (paramToolbar != null)
    {
      paramToolbar = new o(paramToolbar, ((Activity)this.c).getTitle(), this.d);
      this.f = paramToolbar;
      this.b.setCallback(paramToolbar.getWrappedWindowCallback());
    }
    for (;;)
    {
      invalidateOptionsMenu();
      return;
      this.f = null;
      this.b.setCallback(this.d);
    }
  }
  
  public android.support.v7.view.b startSupportActionMode(b.a parama)
  {
    if (parama == null) {
      throw new IllegalArgumentException("ActionMode callback can not be null.");
    }
    if (this.m != null) {
      this.m.finish();
    }
    parama = new b(parama);
    ActionBar localActionBar = getSupportActionBar();
    if (localActionBar != null)
    {
      this.m = localActionBar.startActionMode(parama);
      if ((this.m != null) && (this.e != null)) {
        this.e.onSupportActionModeStarted(this.m);
      }
    }
    if (this.m == null) {
      this.m = a(parama);
    }
    return this.m;
  }
  
  private class ListMenuDecorView
    extends ContentFrameLayout
  {
    public ListMenuDecorView(Context paramContext)
    {
      super();
    }
    
    private boolean a(int paramInt1, int paramInt2)
    {
      return (paramInt1 < -5) || (paramInt2 < -5) || (paramInt1 > getWidth() + 5) || (paramInt2 > getHeight() + 5);
    }
    
    public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
    {
      return (AppCompatDelegateImplV9.this.a(paramKeyEvent)) || (super.dispatchKeyEvent(paramKeyEvent));
    }
    
    public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
    {
      if ((paramMotionEvent.getAction() == 0) && (a((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())))
      {
        AppCompatDelegateImplV9.this.b(0);
        return true;
      }
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    
    public void setBackgroundResource(int paramInt)
    {
      setBackgroundDrawable(android.support.v7.a.a.b.getDrawable(getContext(), paramInt));
    }
  }
  
  protected static final class PanelFeatureState
  {
    int a;
    int b;
    int c;
    int d;
    int e;
    int f;
    ViewGroup g;
    View h;
    View i;
    h j;
    android.support.v7.view.menu.f k;
    Context l;
    boolean m;
    boolean n;
    boolean o;
    public boolean p;
    boolean q;
    boolean r;
    Bundle s;
    
    PanelFeatureState(int paramInt)
    {
      this.a = paramInt;
      this.q = false;
    }
    
    android.support.v7.view.menu.o a(n.a parama)
    {
      if (this.j == null) {
        return null;
      }
      if (this.k == null)
      {
        this.k = new android.support.v7.view.menu.f(this.l, R.layout.abc_list_menu_item_layout);
        this.k.setCallback(parama);
        this.j.addMenuPresenter(this.k);
      }
      return this.k.getMenuView(this.g);
    }
    
    void a(Context paramContext)
    {
      TypedValue localTypedValue = new TypedValue();
      Resources.Theme localTheme = paramContext.getResources().newTheme();
      localTheme.setTo(paramContext.getTheme());
      localTheme.resolveAttribute(R.attr.actionBarPopupTheme, localTypedValue, true);
      if (localTypedValue.resourceId != 0) {
        localTheme.applyStyle(localTypedValue.resourceId, true);
      }
      localTheme.resolveAttribute(R.attr.panelMenuListTheme, localTypedValue, true);
      if (localTypedValue.resourceId != 0) {
        localTheme.applyStyle(localTypedValue.resourceId, true);
      }
      for (;;)
      {
        paramContext = new android.support.v7.view.d(paramContext, 0);
        paramContext.getTheme().setTo(localTheme);
        this.l = paramContext;
        paramContext = paramContext.obtainStyledAttributes(R.styleable.AppCompatTheme);
        this.b = paramContext.getResourceId(R.styleable.AppCompatTheme_panelBackground, 0);
        this.f = paramContext.getResourceId(R.styleable.AppCompatTheme_android_windowAnimationStyle, 0);
        paramContext.recycle();
        return;
        localTheme.applyStyle(R.style.Theme_AppCompat_CompactMenu, true);
      }
    }
    
    void a(h paramh)
    {
      if (paramh == this.j) {}
      do
      {
        return;
        if (this.j != null) {
          this.j.removeMenuPresenter(this.k);
        }
        this.j = paramh;
      } while ((paramh == null) || (this.k == null));
      paramh.addMenuPresenter(this.k);
    }
    
    public void clearMenuPresenters()
    {
      if (this.j != null) {
        this.j.removeMenuPresenter(this.k);
      }
      this.k = null;
    }
    
    public boolean hasPanelItems()
    {
      boolean bool2 = true;
      boolean bool1;
      if (this.h == null) {
        bool1 = false;
      }
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (this.i != null);
        bool1 = bool2;
      } while (this.k.getAdapter().getCount() > 0);
      return false;
    }
    
    private static class SavedState
      implements Parcelable
    {
      public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator()
      {
        public AppCompatDelegateImplV9.PanelFeatureState.SavedState createFromParcel(Parcel paramAnonymousParcel)
        {
          return AppCompatDelegateImplV9.PanelFeatureState.SavedState.a(paramAnonymousParcel, null);
        }
        
        public AppCompatDelegateImplV9.PanelFeatureState.SavedState createFromParcel(Parcel paramAnonymousParcel, ClassLoader paramAnonymousClassLoader)
        {
          return AppCompatDelegateImplV9.PanelFeatureState.SavedState.a(paramAnonymousParcel, paramAnonymousClassLoader);
        }
        
        public AppCompatDelegateImplV9.PanelFeatureState.SavedState[] newArray(int paramAnonymousInt)
        {
          return new AppCompatDelegateImplV9.PanelFeatureState.SavedState[paramAnonymousInt];
        }
      };
      int a;
      boolean b;
      Bundle c;
      
      static SavedState a(Parcel paramParcel, ClassLoader paramClassLoader)
      {
        boolean bool = true;
        SavedState localSavedState = new SavedState();
        localSavedState.a = paramParcel.readInt();
        if (paramParcel.readInt() == 1) {}
        for (;;)
        {
          localSavedState.b = bool;
          if (localSavedState.b) {
            localSavedState.c = paramParcel.readBundle(paramClassLoader);
          }
          return localSavedState;
          bool = false;
        }
      }
      
      public int describeContents()
      {
        return 0;
      }
      
      public void writeToParcel(Parcel paramParcel, int paramInt)
      {
        paramParcel.writeInt(this.a);
        if (this.b) {}
        for (paramInt = 1;; paramInt = 0)
        {
          paramParcel.writeInt(paramInt);
          if (this.b) {
            paramParcel.writeBundle(this.c);
          }
          return;
        }
      }
    }
  }
  
  private final class a
    implements n.a
  {
    a() {}
    
    public void onCloseMenu(h paramh, boolean paramBoolean)
    {
      AppCompatDelegateImplV9.this.a(paramh);
    }
    
    public boolean onOpenSubMenu(h paramh)
    {
      Window.Callback localCallback = AppCompatDelegateImplV9.this.d();
      if (localCallback != null) {
        localCallback.onMenuOpened(108, paramh);
      }
      return true;
    }
  }
  
  class b
    implements b.a
  {
    private b.a b;
    
    public b(b.a parama)
    {
      this.b = parama;
    }
    
    public boolean onActionItemClicked(android.support.v7.view.b paramb, MenuItem paramMenuItem)
    {
      return this.b.onActionItemClicked(paramb, paramMenuItem);
    }
    
    public boolean onCreateActionMode(android.support.v7.view.b paramb, Menu paramMenu)
    {
      return this.b.onCreateActionMode(paramb, paramMenu);
    }
    
    public void onDestroyActionMode(android.support.v7.view.b paramb)
    {
      this.b.onDestroyActionMode(paramb);
      if (AppCompatDelegateImplV9.this.o != null) {
        AppCompatDelegateImplV9.this.b.getDecorView().removeCallbacks(AppCompatDelegateImplV9.this.p);
      }
      if (AppCompatDelegateImplV9.this.n != null)
      {
        AppCompatDelegateImplV9.this.g();
        AppCompatDelegateImplV9.this.q = ViewCompat.animate(AppCompatDelegateImplV9.this.n).alpha(0.0F);
        AppCompatDelegateImplV9.this.q.setListener(new ViewPropertyAnimatorListenerAdapter()
        {
          public void onAnimationEnd(View paramAnonymousView)
          {
            AppCompatDelegateImplV9.this.n.setVisibility(8);
            if (AppCompatDelegateImplV9.this.o != null) {
              AppCompatDelegateImplV9.this.o.dismiss();
            }
            for (;;)
            {
              AppCompatDelegateImplV9.this.n.removeAllViews();
              AppCompatDelegateImplV9.this.q.setListener(null);
              AppCompatDelegateImplV9.this.q = null;
              return;
              if ((AppCompatDelegateImplV9.this.n.getParent() instanceof View)) {
                ViewCompat.requestApplyInsets((View)AppCompatDelegateImplV9.this.n.getParent());
              }
            }
          }
        });
      }
      if (AppCompatDelegateImplV9.this.e != null) {
        AppCompatDelegateImplV9.this.e.onSupportActionModeFinished(AppCompatDelegateImplV9.this.m);
      }
      AppCompatDelegateImplV9.this.m = null;
    }
    
    public boolean onPrepareActionMode(android.support.v7.view.b paramb, Menu paramMenu)
    {
      return this.b.onPrepareActionMode(paramb, paramMenu);
    }
  }
  
  private final class c
    implements n.a
  {
    c() {}
    
    public void onCloseMenu(h paramh, boolean paramBoolean)
    {
      h localh = paramh.getRootMenu();
      if (localh != paramh) {}
      for (int i = 1;; i = 0)
      {
        AppCompatDelegateImplV9 localAppCompatDelegateImplV9 = AppCompatDelegateImplV9.this;
        if (i != 0) {
          paramh = localh;
        }
        paramh = localAppCompatDelegateImplV9.a(paramh);
        if (paramh != null)
        {
          if (i == 0) {
            break;
          }
          AppCompatDelegateImplV9.this.a(paramh.a, paramh, localh);
          AppCompatDelegateImplV9.this.a(paramh, true);
        }
        return;
      }
      AppCompatDelegateImplV9.this.a(paramh, paramBoolean);
    }
    
    public boolean onOpenSubMenu(h paramh)
    {
      if ((paramh == null) && (AppCompatDelegateImplV9.this.h))
      {
        Window.Callback localCallback = AppCompatDelegateImplV9.this.d();
        if ((localCallback != null) && (!AppCompatDelegateImplV9.this.c())) {
          localCallback.onMenuOpened(108, paramh);
        }
      }
      return true;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/app/AppCompatDelegateImplV9.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */