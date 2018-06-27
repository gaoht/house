package android.support.v7.view;

import android.content.Context;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.h.a;
import android.support.v7.view.menu.m;
import android.support.v7.view.menu.t;
import android.support.v7.widget.ActionBarContextView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.lang.ref.WeakReference;

public class e
  extends b
  implements h.a
{
  private Context a;
  private ActionBarContextView b;
  private b.a c;
  private WeakReference<View> d;
  private boolean e;
  private boolean f;
  private h g;
  
  public e(Context paramContext, ActionBarContextView paramActionBarContextView, b.a parama, boolean paramBoolean)
  {
    this.a = paramContext;
    this.b = paramActionBarContextView;
    this.c = parama;
    this.g = new h(paramActionBarContextView.getContext()).setDefaultShowAsAction(1);
    this.g.setCallback(this);
    this.f = paramBoolean;
  }
  
  public void finish()
  {
    if (this.e) {
      return;
    }
    this.e = true;
    this.b.sendAccessibilityEvent(32);
    this.c.onDestroyActionMode(this);
  }
  
  public View getCustomView()
  {
    if (this.d != null) {
      return (View)this.d.get();
    }
    return null;
  }
  
  public Menu getMenu()
  {
    return this.g;
  }
  
  public MenuInflater getMenuInflater()
  {
    return new g(this.b.getContext());
  }
  
  public CharSequence getSubtitle()
  {
    return this.b.getSubtitle();
  }
  
  public CharSequence getTitle()
  {
    return this.b.getTitle();
  }
  
  public void invalidate()
  {
    this.c.onPrepareActionMode(this, this.g);
  }
  
  public boolean isTitleOptional()
  {
    return this.b.isTitleOptional();
  }
  
  public boolean isUiFocusable()
  {
    return this.f;
  }
  
  public void onCloseMenu(h paramh, boolean paramBoolean) {}
  
  public void onCloseSubMenu(t paramt) {}
  
  public boolean onMenuItemSelected(h paramh, MenuItem paramMenuItem)
  {
    return this.c.onActionItemClicked(this, paramMenuItem);
  }
  
  public void onMenuModeChange(h paramh)
  {
    invalidate();
    this.b.showOverflowMenu();
  }
  
  public boolean onSubMenuSelected(t paramt)
  {
    if (!paramt.hasVisibleItems()) {
      return true;
    }
    new m(this.b.getContext(), paramt).show();
    return true;
  }
  
  public void setCustomView(View paramView)
  {
    this.b.setCustomView(paramView);
    if (paramView != null) {}
    for (paramView = new WeakReference(paramView);; paramView = null)
    {
      this.d = paramView;
      return;
    }
  }
  
  public void setSubtitle(int paramInt)
  {
    setSubtitle(this.a.getString(paramInt));
  }
  
  public void setSubtitle(CharSequence paramCharSequence)
  {
    this.b.setSubtitle(paramCharSequence);
  }
  
  public void setTitle(int paramInt)
  {
    setTitle(this.a.getString(paramInt));
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.b.setTitle(paramCharSequence);
  }
  
  public void setTitleOptionalHint(boolean paramBoolean)
  {
    super.setTitleOptionalHint(paramBoolean);
    this.b.setTitleOptional(paramBoolean);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/view/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */