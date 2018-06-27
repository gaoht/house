package android.support.v7.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.internal.view.SupportMenuItem;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;

public class a
  implements SupportMenuItem
{
  private final int a;
  private final int b;
  private final int c;
  private final int d;
  private CharSequence e;
  private CharSequence f;
  private Intent g;
  private char h;
  private int i = 4096;
  private char j;
  private int k = 4096;
  private Drawable l;
  private int m = 0;
  private Context n;
  private MenuItem.OnMenuItemClickListener o;
  private CharSequence p;
  private CharSequence q;
  private ColorStateList r = null;
  private PorterDuff.Mode s = null;
  private boolean t = false;
  private boolean u = false;
  private int v = 16;
  
  public a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, CharSequence paramCharSequence)
  {
    this.n = paramContext;
    this.a = paramInt2;
    this.b = paramInt1;
    this.c = paramInt3;
    this.d = paramInt4;
    this.e = paramCharSequence;
  }
  
  private void a()
  {
    if ((this.l != null) && ((this.t) || (this.u)))
    {
      this.l = DrawableCompat.wrap(this.l);
      this.l = this.l.mutate();
      if (this.t) {
        DrawableCompat.setTintList(this.l, this.r);
      }
      if (this.u) {
        DrawableCompat.setTintMode(this.l, this.s);
      }
    }
  }
  
  public boolean collapseActionView()
  {
    return false;
  }
  
  public boolean expandActionView()
  {
    return false;
  }
  
  public android.view.ActionProvider getActionProvider()
  {
    throw new UnsupportedOperationException();
  }
  
  public View getActionView()
  {
    return null;
  }
  
  public int getAlphabeticModifiers()
  {
    return this.k;
  }
  
  public char getAlphabeticShortcut()
  {
    return this.j;
  }
  
  public CharSequence getContentDescription()
  {
    return this.p;
  }
  
  public int getGroupId()
  {
    return this.b;
  }
  
  public Drawable getIcon()
  {
    return this.l;
  }
  
  public ColorStateList getIconTintList()
  {
    return this.r;
  }
  
  public PorterDuff.Mode getIconTintMode()
  {
    return this.s;
  }
  
  public Intent getIntent()
  {
    return this.g;
  }
  
  public int getItemId()
  {
    return this.a;
  }
  
  public ContextMenu.ContextMenuInfo getMenuInfo()
  {
    return null;
  }
  
  public int getNumericModifiers()
  {
    return this.i;
  }
  
  public char getNumericShortcut()
  {
    return this.h;
  }
  
  public int getOrder()
  {
    return this.d;
  }
  
  public SubMenu getSubMenu()
  {
    return null;
  }
  
  public android.support.v4.view.ActionProvider getSupportActionProvider()
  {
    return null;
  }
  
  public CharSequence getTitle()
  {
    return this.e;
  }
  
  public CharSequence getTitleCondensed()
  {
    if (this.f != null) {
      return this.f;
    }
    return this.e;
  }
  
  public CharSequence getTooltipText()
  {
    return this.q;
  }
  
  public boolean hasSubMenu()
  {
    return false;
  }
  
  public boolean invoke()
  {
    if ((this.o != null) && (this.o.onMenuItemClick(this))) {
      return true;
    }
    if (this.g != null)
    {
      this.n.startActivity(this.g);
      return true;
    }
    return false;
  }
  
  public boolean isActionViewExpanded()
  {
    return false;
  }
  
  public boolean isCheckable()
  {
    return (this.v & 0x1) != 0;
  }
  
  public boolean isChecked()
  {
    return (this.v & 0x2) != 0;
  }
  
  public boolean isEnabled()
  {
    return (this.v & 0x10) != 0;
  }
  
  public boolean isVisible()
  {
    return (this.v & 0x8) == 0;
  }
  
  public MenuItem setActionProvider(android.view.ActionProvider paramActionProvider)
  {
    throw new UnsupportedOperationException();
  }
  
  public SupportMenuItem setActionView(int paramInt)
  {
    throw new UnsupportedOperationException();
  }
  
  public SupportMenuItem setActionView(View paramView)
  {
    throw new UnsupportedOperationException();
  }
  
  public MenuItem setAlphabeticShortcut(char paramChar)
  {
    this.j = Character.toLowerCase(paramChar);
    return this;
  }
  
  public MenuItem setAlphabeticShortcut(char paramChar, int paramInt)
  {
    this.j = Character.toLowerCase(paramChar);
    this.k = KeyEvent.normalizeMetaState(paramInt);
    return this;
  }
  
  public MenuItem setCheckable(boolean paramBoolean)
  {
    int i2 = this.v;
    if (paramBoolean) {}
    for (int i1 = 1;; i1 = 0)
    {
      this.v = (i1 | i2 & 0xFFFFFFFE);
      return this;
    }
  }
  
  public MenuItem setChecked(boolean paramBoolean)
  {
    int i2 = this.v;
    if (paramBoolean) {}
    for (int i1 = 2;; i1 = 0)
    {
      this.v = (i1 | i2 & 0xFFFFFFFD);
      return this;
    }
  }
  
  public SupportMenuItem setContentDescription(CharSequence paramCharSequence)
  {
    this.p = paramCharSequence;
    return this;
  }
  
  public MenuItem setEnabled(boolean paramBoolean)
  {
    int i2 = this.v;
    if (paramBoolean) {}
    for (int i1 = 16;; i1 = 0)
    {
      this.v = (i1 | i2 & 0xFFFFFFEF);
      return this;
    }
  }
  
  public a setExclusiveCheckable(boolean paramBoolean)
  {
    int i2 = this.v;
    if (paramBoolean) {}
    for (int i1 = 4;; i1 = 0)
    {
      this.v = (i1 | i2 & 0xFFFFFFFB);
      return this;
    }
  }
  
  public MenuItem setIcon(int paramInt)
  {
    this.m = paramInt;
    this.l = ContextCompat.getDrawable(this.n, paramInt);
    a();
    return this;
  }
  
  public MenuItem setIcon(Drawable paramDrawable)
  {
    this.l = paramDrawable;
    this.m = 0;
    a();
    return this;
  }
  
  public MenuItem setIconTintList(ColorStateList paramColorStateList)
  {
    this.r = paramColorStateList;
    this.t = true;
    a();
    return this;
  }
  
  public MenuItem setIconTintMode(PorterDuff.Mode paramMode)
  {
    this.s = paramMode;
    this.u = true;
    a();
    return this;
  }
  
  public MenuItem setIntent(Intent paramIntent)
  {
    this.g = paramIntent;
    return this;
  }
  
  public MenuItem setNumericShortcut(char paramChar)
  {
    this.h = paramChar;
    return this;
  }
  
  public MenuItem setNumericShortcut(char paramChar, int paramInt)
  {
    this.h = paramChar;
    this.i = KeyEvent.normalizeMetaState(paramInt);
    return this;
  }
  
  public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener paramOnActionExpandListener)
  {
    throw new UnsupportedOperationException();
  }
  
  public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.o = paramOnMenuItemClickListener;
    return this;
  }
  
  public MenuItem setShortcut(char paramChar1, char paramChar2)
  {
    this.h = paramChar1;
    this.j = Character.toLowerCase(paramChar2);
    return this;
  }
  
  public MenuItem setShortcut(char paramChar1, char paramChar2, int paramInt1, int paramInt2)
  {
    this.h = paramChar1;
    this.i = KeyEvent.normalizeMetaState(paramInt1);
    this.j = Character.toLowerCase(paramChar2);
    this.k = KeyEvent.normalizeMetaState(paramInt2);
    return this;
  }
  
  public void setShowAsAction(int paramInt) {}
  
  public SupportMenuItem setShowAsActionFlags(int paramInt)
  {
    setShowAsAction(paramInt);
    return this;
  }
  
  public SupportMenuItem setSupportActionProvider(android.support.v4.view.ActionProvider paramActionProvider)
  {
    throw new UnsupportedOperationException();
  }
  
  public MenuItem setTitle(int paramInt)
  {
    this.e = this.n.getResources().getString(paramInt);
    return this;
  }
  
  public MenuItem setTitle(CharSequence paramCharSequence)
  {
    this.e = paramCharSequence;
    return this;
  }
  
  public MenuItem setTitleCondensed(CharSequence paramCharSequence)
  {
    this.f = paramCharSequence;
    return this;
  }
  
  public SupportMenuItem setTooltipText(CharSequence paramCharSequence)
  {
    this.q = paramCharSequence;
    return this;
  }
  
  public MenuItem setVisible(boolean paramBoolean)
  {
    int i2 = this.v;
    if (paramBoolean) {}
    for (int i1 = 0;; i1 = 8)
    {
      this.v = (i1 | i2 & 0x8);
      return this;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/view/menu/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */