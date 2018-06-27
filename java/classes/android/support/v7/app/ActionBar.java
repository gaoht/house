package android.support.v7.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.view.b;
import android.support.v7.view.b.a;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.SpinnerAdapter;

public abstract class ActionBar
{
  void a() {}
  
  public abstract void addOnMenuVisibilityListener(a parama);
  
  @Deprecated
  public abstract void addTab(c paramc);
  
  @Deprecated
  public abstract void addTab(c paramc, int paramInt);
  
  @Deprecated
  public abstract void addTab(c paramc, int paramInt, boolean paramBoolean);
  
  @Deprecated
  public abstract void addTab(c paramc, boolean paramBoolean);
  
  public boolean closeOptionsMenu()
  {
    return false;
  }
  
  public boolean collapseActionView()
  {
    return false;
  }
  
  public void dispatchMenuVisibilityChanged(boolean paramBoolean) {}
  
  public abstract View getCustomView();
  
  public abstract int getDisplayOptions();
  
  public float getElevation()
  {
    return 0.0F;
  }
  
  public abstract int getHeight();
  
  public int getHideOffset()
  {
    return 0;
  }
  
  @Deprecated
  public abstract int getNavigationItemCount();
  
  @Deprecated
  public abstract int getNavigationMode();
  
  @Deprecated
  public abstract int getSelectedNavigationIndex();
  
  @Deprecated
  public abstract c getSelectedTab();
  
  public abstract CharSequence getSubtitle();
  
  @Deprecated
  public abstract c getTabAt(int paramInt);
  
  @Deprecated
  public abstract int getTabCount();
  
  public Context getThemedContext()
  {
    return null;
  }
  
  public abstract CharSequence getTitle();
  
  public abstract void hide();
  
  public boolean invalidateOptionsMenu()
  {
    return false;
  }
  
  public boolean isHideOnContentScrollEnabled()
  {
    return false;
  }
  
  public abstract boolean isShowing();
  
  public boolean isTitleTruncated()
  {
    return false;
  }
  
  @Deprecated
  public abstract c newTab();
  
  public void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public boolean onKeyShortcut(int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public boolean onMenuKeyEvent(KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public boolean openOptionsMenu()
  {
    return false;
  }
  
  @Deprecated
  public abstract void removeAllTabs();
  
  public abstract void removeOnMenuVisibilityListener(a parama);
  
  @Deprecated
  public abstract void removeTab(c paramc);
  
  @Deprecated
  public abstract void removeTabAt(int paramInt);
  
  boolean requestFocus()
  {
    return false;
  }
  
  @Deprecated
  public abstract void selectTab(c paramc);
  
  public abstract void setBackgroundDrawable(Drawable paramDrawable);
  
  public abstract void setCustomView(int paramInt);
  
  public abstract void setCustomView(View paramView);
  
  public abstract void setCustomView(View paramView, LayoutParams paramLayoutParams);
  
  public void setDefaultDisplayHomeAsUpEnabled(boolean paramBoolean) {}
  
  public abstract void setDisplayHomeAsUpEnabled(boolean paramBoolean);
  
  public abstract void setDisplayOptions(int paramInt);
  
  public abstract void setDisplayOptions(int paramInt1, int paramInt2);
  
  public abstract void setDisplayShowCustomEnabled(boolean paramBoolean);
  
  public abstract void setDisplayShowHomeEnabled(boolean paramBoolean);
  
  public abstract void setDisplayShowTitleEnabled(boolean paramBoolean);
  
  public abstract void setDisplayUseLogoEnabled(boolean paramBoolean);
  
  public void setElevation(float paramFloat)
  {
    if (paramFloat != 0.0F) {
      throw new UnsupportedOperationException("Setting a non-zero elevation is not supported in this action bar configuration.");
    }
  }
  
  public void setHideOffset(int paramInt)
  {
    if (paramInt != 0) {
      throw new UnsupportedOperationException("Setting an explicit action bar hide offset is not supported in this action bar configuration.");
    }
  }
  
  public void setHideOnContentScrollEnabled(boolean paramBoolean)
  {
    if (paramBoolean) {
      throw new UnsupportedOperationException("Hide on content scroll is not supported in this action bar configuration.");
    }
  }
  
  public void setHomeActionContentDescription(int paramInt) {}
  
  public void setHomeActionContentDescription(CharSequence paramCharSequence) {}
  
  public void setHomeAsUpIndicator(int paramInt) {}
  
  public void setHomeAsUpIndicator(Drawable paramDrawable) {}
  
  public void setHomeButtonEnabled(boolean paramBoolean) {}
  
  public abstract void setIcon(int paramInt);
  
  public abstract void setIcon(Drawable paramDrawable);
  
  @Deprecated
  public abstract void setListNavigationCallbacks(SpinnerAdapter paramSpinnerAdapter, b paramb);
  
  public abstract void setLogo(int paramInt);
  
  public abstract void setLogo(Drawable paramDrawable);
  
  @Deprecated
  public abstract void setNavigationMode(int paramInt);
  
  @Deprecated
  public abstract void setSelectedNavigationItem(int paramInt);
  
  public void setShowHideAnimationEnabled(boolean paramBoolean) {}
  
  public void setSplitBackgroundDrawable(Drawable paramDrawable) {}
  
  public void setStackedBackgroundDrawable(Drawable paramDrawable) {}
  
  public abstract void setSubtitle(int paramInt);
  
  public abstract void setSubtitle(CharSequence paramCharSequence);
  
  public abstract void setTitle(int paramInt);
  
  public abstract void setTitle(CharSequence paramCharSequence);
  
  public void setWindowTitle(CharSequence paramCharSequence) {}
  
  public abstract void show();
  
  public b startActionMode(b.a parama)
  {
    return null;
  }
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    public int a = 0;
    
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
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ActionBarLayout);
      this.a = paramContext.getInt(R.styleable.ActionBarLayout_android_layout_gravity, 0);
      paramContext.recycle();
    }
    
    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
      this.a = paramLayoutParams.a;
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
  }
  
  public static abstract interface a
  {
    public abstract void onMenuVisibilityChanged(boolean paramBoolean);
  }
  
  @Deprecated
  public static abstract interface b
  {
    public abstract boolean onNavigationItemSelected(int paramInt, long paramLong);
  }
  
  @Deprecated
  public static abstract class c
  {
    public abstract CharSequence getContentDescription();
    
    public abstract View getCustomView();
    
    public abstract Drawable getIcon();
    
    public abstract int getPosition();
    
    public abstract Object getTag();
    
    public abstract CharSequence getText();
    
    public abstract void select();
    
    public abstract c setContentDescription(int paramInt);
    
    public abstract c setContentDescription(CharSequence paramCharSequence);
    
    public abstract c setCustomView(int paramInt);
    
    public abstract c setCustomView(View paramView);
    
    public abstract c setIcon(int paramInt);
    
    public abstract c setIcon(Drawable paramDrawable);
    
    public abstract c setTabListener(ActionBar.d paramd);
    
    public abstract c setTag(Object paramObject);
    
    public abstract c setText(int paramInt);
    
    public abstract c setText(CharSequence paramCharSequence);
  }
  
  @Deprecated
  public static abstract interface d
  {
    public abstract void onTabReselected(ActionBar.c paramc, FragmentTransaction paramFragmentTransaction);
    
    public abstract void onTabSelected(ActionBar.c paramc, FragmentTransaction paramFragmentTransaction);
    
    public abstract void onTabUnselected(ActionBar.c paramc, FragmentTransaction paramFragmentTransaction);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/app/ActionBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */