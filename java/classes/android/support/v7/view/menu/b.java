package android.support.v7.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public abstract class b
  implements n
{
  protected Context a;
  protected Context b;
  protected h c;
  protected LayoutInflater d;
  protected LayoutInflater e;
  protected o f;
  private n.a g;
  private int h;
  private int i;
  private int j;
  
  public b(Context paramContext, int paramInt1, int paramInt2)
  {
    this.a = paramContext;
    this.d = LayoutInflater.from(paramContext);
    this.h = paramInt1;
    this.i = paramInt2;
  }
  
  protected void a(View paramView, int paramInt)
  {
    ViewGroup localViewGroup = (ViewGroup)paramView.getParent();
    if (localViewGroup != null) {
      localViewGroup.removeView(paramView);
    }
    ((ViewGroup)this.f).addView(paramView, paramInt);
  }
  
  public abstract void bindItemView(j paramj, o.a parama);
  
  public boolean collapseItemActionView(h paramh, j paramj)
  {
    return false;
  }
  
  public o.a createItemView(ViewGroup paramViewGroup)
  {
    return (o.a)this.d.inflate(this.i, paramViewGroup, false);
  }
  
  public boolean expandItemActionView(h paramh, j paramj)
  {
    return false;
  }
  
  protected boolean filterLeftoverView(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup.removeViewAt(paramInt);
    return true;
  }
  
  public boolean flagActionItems()
  {
    return false;
  }
  
  public n.a getCallback()
  {
    return this.g;
  }
  
  public int getId()
  {
    return this.j;
  }
  
  public View getItemView(j paramj, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramView instanceof o.a)) {}
    for (paramView = (o.a)paramView;; paramView = createItemView(paramViewGroup))
    {
      bindItemView(paramj, paramView);
      return (View)paramView;
    }
  }
  
  public o getMenuView(ViewGroup paramViewGroup)
  {
    if (this.f == null)
    {
      this.f = ((o)this.d.inflate(this.h, paramViewGroup, false));
      this.f.initialize(this.c);
      updateMenuView(true);
    }
    return this.f;
  }
  
  public void initForMenu(Context paramContext, h paramh)
  {
    this.b = paramContext;
    this.e = LayoutInflater.from(this.b);
    this.c = paramh;
  }
  
  public void onCloseMenu(h paramh, boolean paramBoolean)
  {
    if (this.g != null) {
      this.g.onCloseMenu(paramh, paramBoolean);
    }
  }
  
  public boolean onSubMenuSelected(t paramt)
  {
    if (this.g != null) {
      return this.g.onOpenSubMenu(paramt);
    }
    return false;
  }
  
  public void setCallback(n.a parama)
  {
    this.g = parama;
  }
  
  public void setId(int paramInt)
  {
    this.j = paramInt;
  }
  
  public boolean shouldIncludeItem(int paramInt, j paramj)
  {
    return true;
  }
  
  public void updateMenuView(boolean paramBoolean)
  {
    ViewGroup localViewGroup = (ViewGroup)this.f;
    if (localViewGroup == null) {}
    label198:
    label204:
    for (;;)
    {
      return;
      int m;
      if (this.c != null)
      {
        this.c.flagActionItems();
        ArrayList localArrayList = this.c.getVisibleItems();
        int i1 = localArrayList.size();
        int n = 0;
        int k = 0;
        m = k;
        if (n < i1)
        {
          j localj2 = (j)localArrayList.get(n);
          if (!shouldIncludeItem(k, localj2)) {
            break label198;
          }
          View localView1 = localViewGroup.getChildAt(k);
          if ((localView1 instanceof o.a)) {}
          for (j localj1 = ((o.a)localView1).getItemData();; localj1 = null)
          {
            View localView2 = getItemView(localj2, localView1, localViewGroup);
            if (localj2 != localj1)
            {
              localView2.setPressed(false);
              localView2.jumpDrawablesToCurrentState();
            }
            if (localView2 != localView1) {
              a(localView2, k);
            }
            k += 1;
            n += 1;
            break;
          }
        }
      }
      for (;;)
      {
        if (m >= localViewGroup.getChildCount()) {
          break label204;
        }
        if (!filterLeftoverView(localViewGroup, m))
        {
          m += 1;
          continue;
          break;
          m = 0;
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/view/menu/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */