package android.support.v7.view;

import android.content.Context;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.util.SimpleArrayMap;
import android.support.v7.view.menu.p;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.util.ArrayList;

public class f
  extends ActionMode
{
  final Context a;
  final b b;
  
  public f(Context paramContext, b paramb)
  {
    this.a = paramContext;
    this.b = paramb;
  }
  
  public void finish()
  {
    this.b.finish();
  }
  
  public View getCustomView()
  {
    return this.b.getCustomView();
  }
  
  public Menu getMenu()
  {
    return p.wrapSupportMenu(this.a, (SupportMenu)this.b.getMenu());
  }
  
  public MenuInflater getMenuInflater()
  {
    return this.b.getMenuInflater();
  }
  
  public CharSequence getSubtitle()
  {
    return this.b.getSubtitle();
  }
  
  public Object getTag()
  {
    return this.b.getTag();
  }
  
  public CharSequence getTitle()
  {
    return this.b.getTitle();
  }
  
  public boolean getTitleOptionalHint()
  {
    return this.b.getTitleOptionalHint();
  }
  
  public void invalidate()
  {
    this.b.invalidate();
  }
  
  public boolean isTitleOptional()
  {
    return this.b.isTitleOptional();
  }
  
  public void setCustomView(View paramView)
  {
    this.b.setCustomView(paramView);
  }
  
  public void setSubtitle(int paramInt)
  {
    this.b.setSubtitle(paramInt);
  }
  
  public void setSubtitle(CharSequence paramCharSequence)
  {
    this.b.setSubtitle(paramCharSequence);
  }
  
  public void setTag(Object paramObject)
  {
    this.b.setTag(paramObject);
  }
  
  public void setTitle(int paramInt)
  {
    this.b.setTitle(paramInt);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.b.setTitle(paramCharSequence);
  }
  
  public void setTitleOptionalHint(boolean paramBoolean)
  {
    this.b.setTitleOptionalHint(paramBoolean);
  }
  
  public static class a
    implements b.a
  {
    final ActionMode.Callback a;
    final Context b;
    final ArrayList<f> c;
    final SimpleArrayMap<Menu, Menu> d;
    
    public a(Context paramContext, ActionMode.Callback paramCallback)
    {
      this.b = paramContext;
      this.a = paramCallback;
      this.c = new ArrayList();
      this.d = new SimpleArrayMap();
    }
    
    private Menu a(Menu paramMenu)
    {
      Menu localMenu2 = (Menu)this.d.get(paramMenu);
      Menu localMenu1 = localMenu2;
      if (localMenu2 == null)
      {
        localMenu1 = p.wrapSupportMenu(this.b, (SupportMenu)paramMenu);
        this.d.put(paramMenu, localMenu1);
      }
      return localMenu1;
    }
    
    public ActionMode getActionModeWrapper(b paramb)
    {
      int j = this.c.size();
      int i = 0;
      while (i < j)
      {
        f localf = (f)this.c.get(i);
        if ((localf != null) && (localf.b == paramb)) {
          return localf;
        }
        i += 1;
      }
      paramb = new f(this.b, paramb);
      this.c.add(paramb);
      return paramb;
    }
    
    public boolean onActionItemClicked(b paramb, MenuItem paramMenuItem)
    {
      return this.a.onActionItemClicked(getActionModeWrapper(paramb), p.wrapSupportMenuItem(this.b, (SupportMenuItem)paramMenuItem));
    }
    
    public boolean onCreateActionMode(b paramb, Menu paramMenu)
    {
      return this.a.onCreateActionMode(getActionModeWrapper(paramb), a(paramMenu));
    }
    
    public void onDestroyActionMode(b paramb)
    {
      this.a.onDestroyActionMode(getActionModeWrapper(paramb));
    }
    
    public boolean onPrepareActionMode(b paramb, Menu paramMenu)
    {
      return this.a.onPrepareActionMode(getActionModeWrapper(paramb), a(paramMenu));
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/view/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */