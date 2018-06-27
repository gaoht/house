package android.support.v7.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.view.ActionProvider.VisibilityListener;
import android.support.v7.a.a.b;
import android.util.Log;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewDebug.CapturedViewProperty;
import android.widget.LinearLayout;

public final class j
  implements SupportMenuItem
{
  private static String F;
  private static String G;
  private static String H;
  private static String I;
  private View A;
  private android.support.v4.view.ActionProvider B;
  private MenuItem.OnActionExpandListener C;
  private boolean D = false;
  private ContextMenu.ContextMenuInfo E;
  h a;
  private final int b;
  private final int c;
  private final int d;
  private final int e;
  private CharSequence f;
  private CharSequence g;
  private Intent h;
  private char i;
  private int j = 4096;
  private char k;
  private int l = 4096;
  private Drawable m;
  private int n = 0;
  private t o;
  private Runnable p;
  private MenuItem.OnMenuItemClickListener q;
  private CharSequence r;
  private CharSequence s;
  private ColorStateList t = null;
  private PorterDuff.Mode u = null;
  private boolean v = false;
  private boolean w = false;
  private boolean x = false;
  private int y = 16;
  private int z = 0;
  
  j(h paramh, int paramInt1, int paramInt2, int paramInt3, int paramInt4, CharSequence paramCharSequence, int paramInt5)
  {
    this.a = paramh;
    this.b = paramInt2;
    this.c = paramInt1;
    this.d = paramInt3;
    this.e = paramInt4;
    this.f = paramCharSequence;
    this.z = paramInt5;
  }
  
  private Drawable a(Drawable paramDrawable)
  {
    Drawable localDrawable = paramDrawable;
    if (paramDrawable != null)
    {
      localDrawable = paramDrawable;
      if (this.x) {
        if (!this.v)
        {
          localDrawable = paramDrawable;
          if (!this.w) {}
        }
        else
        {
          localDrawable = DrawableCompat.wrap(paramDrawable).mutate();
          if (this.v) {
            DrawableCompat.setTintList(localDrawable, this.t);
          }
          if (this.w) {
            DrawableCompat.setTintMode(localDrawable, this.u);
          }
          this.x = false;
        }
      }
    }
    return localDrawable;
  }
  
  char a()
  {
    if (this.a.isQwertyMode()) {
      return this.k;
    }
    return this.i;
  }
  
  CharSequence a(o.a parama)
  {
    if ((parama != null) && (parama.prefersCondensedTitle())) {
      return getTitleCondensed();
    }
    return getTitle();
  }
  
  void a(ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    this.E = paramContextMenuInfo;
  }
  
  void a(boolean paramBoolean)
  {
    int i2 = this.y;
    int i3 = this.y;
    if (paramBoolean) {}
    for (int i1 = 2;; i1 = 0)
    {
      this.y = (i1 | i3 & 0xFFFFFFFD);
      if (i2 != this.y) {
        this.a.onItemsChanged(false);
      }
      return;
    }
  }
  
  public void actionFormatChanged()
  {
    this.a.onItemActionRequestChanged(this);
  }
  
  String b()
  {
    char c1 = a();
    if (c1 == 0) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder(F);
    switch (c1)
    {
    default: 
      localStringBuilder.append(c1);
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append(G);
      continue;
      localStringBuilder.append(H);
      continue;
      localStringBuilder.append(I);
    }
  }
  
  boolean b(boolean paramBoolean)
  {
    boolean bool = false;
    int i2 = this.y;
    int i3 = this.y;
    if (paramBoolean) {}
    for (int i1 = 0;; i1 = 8)
    {
      this.y = (i1 | i3 & 0xFFFFFFF7);
      paramBoolean = bool;
      if (i2 != this.y) {
        paramBoolean = true;
      }
      return paramBoolean;
    }
  }
  
  boolean c()
  {
    return (this.a.isShortcutsVisible()) && (a() != 0);
  }
  
  public boolean collapseActionView()
  {
    if ((this.z & 0x8) == 0) {}
    do
    {
      return false;
      if (this.A == null) {
        return true;
      }
    } while ((this.C != null) && (!this.C.onMenuItemActionCollapse(this)));
    return this.a.collapseItemActionView(this);
  }
  
  public boolean expandActionView()
  {
    if (!hasCollapsibleActionView()) {}
    while ((this.C != null) && (!this.C.onMenuItemActionExpand(this))) {
      return false;
    }
    return this.a.expandItemActionView(this);
  }
  
  public android.view.ActionProvider getActionProvider()
  {
    throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
  }
  
  public View getActionView()
  {
    if (this.A != null) {
      return this.A;
    }
    if (this.B != null)
    {
      this.A = this.B.onCreateActionView(this);
      return this.A;
    }
    return null;
  }
  
  public int getAlphabeticModifiers()
  {
    return this.l;
  }
  
  public char getAlphabeticShortcut()
  {
    return this.k;
  }
  
  public CharSequence getContentDescription()
  {
    return this.r;
  }
  
  public int getGroupId()
  {
    return this.c;
  }
  
  public Drawable getIcon()
  {
    if (this.m != null) {
      return a(this.m);
    }
    if (this.n != 0)
    {
      Drawable localDrawable = b.getDrawable(this.a.getContext(), this.n);
      this.n = 0;
      this.m = localDrawable;
      return a(localDrawable);
    }
    return null;
  }
  
  public ColorStateList getIconTintList()
  {
    return this.t;
  }
  
  public PorterDuff.Mode getIconTintMode()
  {
    return this.u;
  }
  
  public Intent getIntent()
  {
    return this.h;
  }
  
  @ViewDebug.CapturedViewProperty
  public int getItemId()
  {
    return this.b;
  }
  
  public ContextMenu.ContextMenuInfo getMenuInfo()
  {
    return this.E;
  }
  
  public int getNumericModifiers()
  {
    return this.j;
  }
  
  public char getNumericShortcut()
  {
    return this.i;
  }
  
  public int getOrder()
  {
    return this.d;
  }
  
  public int getOrdering()
  {
    return this.e;
  }
  
  public SubMenu getSubMenu()
  {
    return this.o;
  }
  
  public android.support.v4.view.ActionProvider getSupportActionProvider()
  {
    return this.B;
  }
  
  @ViewDebug.CapturedViewProperty
  public CharSequence getTitle()
  {
    return this.f;
  }
  
  public CharSequence getTitleCondensed()
  {
    if (this.g != null) {}
    for (CharSequence localCharSequence = this.g;; localCharSequence = this.f)
    {
      Object localObject = localCharSequence;
      if (Build.VERSION.SDK_INT < 18)
      {
        localObject = localCharSequence;
        if (localCharSequence != null)
        {
          localObject = localCharSequence;
          if (!(localCharSequence instanceof String)) {
            localObject = localCharSequence.toString();
          }
        }
      }
      return (CharSequence)localObject;
    }
  }
  
  public CharSequence getTooltipText()
  {
    return this.s;
  }
  
  public boolean hasCollapsibleActionView()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((this.z & 0x8) != 0)
    {
      if ((this.A == null) && (this.B != null)) {
        this.A = this.B.onCreateActionView(this);
      }
      bool1 = bool2;
      if (this.A != null) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean hasSubMenu()
  {
    return this.o != null;
  }
  
  public boolean invoke()
  {
    if ((this.q != null) && (this.q.onMenuItemClick(this))) {}
    do
    {
      do
      {
        return true;
      } while (this.a.dispatchMenuItemSelected(this.a, this));
      if (this.p != null)
      {
        this.p.run();
        return true;
      }
      if (this.h != null) {
        try
        {
          this.a.getContext().startActivity(this.h);
          return true;
        }
        catch (ActivityNotFoundException localActivityNotFoundException)
        {
          Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", localActivityNotFoundException);
        }
      }
    } while ((this.B != null) && (this.B.onPerformDefaultAction()));
    return false;
  }
  
  public boolean isActionButton()
  {
    return (this.y & 0x20) == 32;
  }
  
  public boolean isActionViewExpanded()
  {
    return this.D;
  }
  
  public boolean isCheckable()
  {
    return (this.y & 0x1) == 1;
  }
  
  public boolean isChecked()
  {
    return (this.y & 0x2) == 2;
  }
  
  public boolean isEnabled()
  {
    return (this.y & 0x10) != 0;
  }
  
  public boolean isExclusiveCheckable()
  {
    return (this.y & 0x4) != 0;
  }
  
  public boolean isVisible()
  {
    if ((this.B != null) && (this.B.overridesItemVisibility())) {
      if (((this.y & 0x8) != 0) || (!this.B.isVisible())) {}
    }
    while ((this.y & 0x8) == 0)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public boolean requestsActionButton()
  {
    return (this.z & 0x1) == 1;
  }
  
  public boolean requiresActionButton()
  {
    return (this.z & 0x2) == 2;
  }
  
  public MenuItem setActionProvider(android.view.ActionProvider paramActionProvider)
  {
    throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
  }
  
  public SupportMenuItem setActionView(int paramInt)
  {
    Context localContext = this.a.getContext();
    setActionView(LayoutInflater.from(localContext).inflate(paramInt, new LinearLayout(localContext), false));
    return this;
  }
  
  public SupportMenuItem setActionView(View paramView)
  {
    this.A = paramView;
    this.B = null;
    if ((paramView != null) && (paramView.getId() == -1) && (this.b > 0)) {
      paramView.setId(this.b);
    }
    this.a.onItemActionRequestChanged(this);
    return this;
  }
  
  public void setActionViewExpanded(boolean paramBoolean)
  {
    this.D = paramBoolean;
    this.a.onItemsChanged(false);
  }
  
  public MenuItem setAlphabeticShortcut(char paramChar)
  {
    if (this.k == paramChar) {
      return this;
    }
    this.k = Character.toLowerCase(paramChar);
    this.a.onItemsChanged(false);
    return this;
  }
  
  public MenuItem setAlphabeticShortcut(char paramChar, int paramInt)
  {
    if ((this.k == paramChar) && (this.l == paramInt)) {
      return this;
    }
    this.k = Character.toLowerCase(paramChar);
    this.l = KeyEvent.normalizeMetaState(paramInt);
    this.a.onItemsChanged(false);
    return this;
  }
  
  public MenuItem setCallback(Runnable paramRunnable)
  {
    this.p = paramRunnable;
    return this;
  }
  
  public MenuItem setCheckable(boolean paramBoolean)
  {
    int i2 = this.y;
    int i3 = this.y;
    if (paramBoolean) {}
    for (int i1 = 1;; i1 = 0)
    {
      this.y = (i1 | i3 & 0xFFFFFFFE);
      if (i2 != this.y) {
        this.a.onItemsChanged(false);
      }
      return this;
    }
  }
  
  public MenuItem setChecked(boolean paramBoolean)
  {
    if ((this.y & 0x4) != 0)
    {
      this.a.setExclusiveItemChecked(this);
      return this;
    }
    a(paramBoolean);
    return this;
  }
  
  public SupportMenuItem setContentDescription(CharSequence paramCharSequence)
  {
    this.r = paramCharSequence;
    this.a.onItemsChanged(false);
    return this;
  }
  
  public MenuItem setEnabled(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (this.y |= 0x10;; this.y &= 0xFFFFFFEF)
    {
      this.a.onItemsChanged(false);
      return this;
    }
  }
  
  public void setExclusiveCheckable(boolean paramBoolean)
  {
    int i2 = this.y;
    if (paramBoolean) {}
    for (int i1 = 4;; i1 = 0)
    {
      this.y = (i1 | i2 & 0xFFFFFFFB);
      return;
    }
  }
  
  public MenuItem setIcon(int paramInt)
  {
    this.m = null;
    this.n = paramInt;
    this.x = true;
    this.a.onItemsChanged(false);
    return this;
  }
  
  public MenuItem setIcon(Drawable paramDrawable)
  {
    this.n = 0;
    this.m = paramDrawable;
    this.x = true;
    this.a.onItemsChanged(false);
    return this;
  }
  
  public MenuItem setIconTintList(ColorStateList paramColorStateList)
  {
    this.t = paramColorStateList;
    this.v = true;
    this.x = true;
    this.a.onItemsChanged(false);
    return this;
  }
  
  public MenuItem setIconTintMode(PorterDuff.Mode paramMode)
  {
    this.u = paramMode;
    this.w = true;
    this.x = true;
    this.a.onItemsChanged(false);
    return this;
  }
  
  public MenuItem setIntent(Intent paramIntent)
  {
    this.h = paramIntent;
    return this;
  }
  
  public void setIsActionButton(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.y |= 0x20;
      return;
    }
    this.y &= 0xFFFFFFDF;
  }
  
  public MenuItem setNumericShortcut(char paramChar)
  {
    if (this.i == paramChar) {
      return this;
    }
    this.i = paramChar;
    this.a.onItemsChanged(false);
    return this;
  }
  
  public MenuItem setNumericShortcut(char paramChar, int paramInt)
  {
    if ((this.i == paramChar) && (this.j == paramInt)) {
      return this;
    }
    this.i = paramChar;
    this.j = KeyEvent.normalizeMetaState(paramInt);
    this.a.onItemsChanged(false);
    return this;
  }
  
  public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener paramOnActionExpandListener)
  {
    this.C = paramOnActionExpandListener;
    return this;
  }
  
  public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.q = paramOnMenuItemClickListener;
    return this;
  }
  
  public MenuItem setShortcut(char paramChar1, char paramChar2)
  {
    this.i = paramChar1;
    this.k = Character.toLowerCase(paramChar2);
    this.a.onItemsChanged(false);
    return this;
  }
  
  public MenuItem setShortcut(char paramChar1, char paramChar2, int paramInt1, int paramInt2)
  {
    this.i = paramChar1;
    this.j = KeyEvent.normalizeMetaState(paramInt1);
    this.k = Character.toLowerCase(paramChar2);
    this.l = KeyEvent.normalizeMetaState(paramInt2);
    this.a.onItemsChanged(false);
    return this;
  }
  
  public void setShowAsAction(int paramInt)
  {
    switch (paramInt & 0x3)
    {
    default: 
      throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
    }
    this.z = paramInt;
    this.a.onItemActionRequestChanged(this);
  }
  
  public SupportMenuItem setShowAsActionFlags(int paramInt)
  {
    setShowAsAction(paramInt);
    return this;
  }
  
  public void setSubMenu(t paramt)
  {
    this.o = paramt;
    paramt.setHeaderTitle(getTitle());
  }
  
  public SupportMenuItem setSupportActionProvider(android.support.v4.view.ActionProvider paramActionProvider)
  {
    if (this.B != null) {
      this.B.reset();
    }
    this.A = null;
    this.B = paramActionProvider;
    this.a.onItemsChanged(true);
    if (this.B != null) {
      this.B.setVisibilityListener(new ActionProvider.VisibilityListener()
      {
        public void onActionProviderVisibilityChanged(boolean paramAnonymousBoolean)
        {
          j.this.a.onItemVisibleChanged(j.this);
        }
      });
    }
    return this;
  }
  
  public MenuItem setTitle(int paramInt)
  {
    return setTitle(this.a.getContext().getString(paramInt));
  }
  
  public MenuItem setTitle(CharSequence paramCharSequence)
  {
    this.f = paramCharSequence;
    this.a.onItemsChanged(false);
    if (this.o != null) {
      this.o.setHeaderTitle(paramCharSequence);
    }
    return this;
  }
  
  public MenuItem setTitleCondensed(CharSequence paramCharSequence)
  {
    this.g = paramCharSequence;
    if (paramCharSequence == null) {
      paramCharSequence = this.f;
    }
    this.a.onItemsChanged(false);
    return this;
  }
  
  public SupportMenuItem setTooltipText(CharSequence paramCharSequence)
  {
    this.s = paramCharSequence;
    this.a.onItemsChanged(false);
    return this;
  }
  
  public MenuItem setVisible(boolean paramBoolean)
  {
    if (b(paramBoolean)) {
      this.a.onItemVisibleChanged(this);
    }
    return this;
  }
  
  public boolean shouldShowIcon()
  {
    return this.a.getOptionalIconsVisible();
  }
  
  public boolean showsTextAsAction()
  {
    return (this.z & 0x4) == 4;
  }
  
  public String toString()
  {
    if (this.f != null) {
      return this.f.toString();
    }
    return null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/view/menu/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */