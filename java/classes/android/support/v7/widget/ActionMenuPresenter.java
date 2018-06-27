package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.ActionProvider.SubUiVisibilityListener;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.layout;
import android.support.v7.view.a;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.ActionMenuItemView.b;
import android.support.v7.view.menu.b;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.j;
import android.support.v7.view.menu.m;
import android.support.v7.view.menu.n.a;
import android.support.v7.view.menu.o;
import android.support.v7.view.menu.o.a;
import android.support.v7.view.menu.r;
import android.support.v7.view.menu.t;
import android.util.DisplayMetrics;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import java.util.ArrayList;

class ActionMenuPresenter
  extends b
  implements ActionProvider.SubUiVisibilityListener
{
  private b A;
  OverflowMenuButton g;
  d h;
  a i;
  c j;
  final e k = new e();
  int l;
  private Drawable m;
  private boolean n;
  private boolean o;
  private boolean p;
  private int q;
  private int r;
  private int s;
  private boolean t;
  private boolean u;
  private boolean v;
  private boolean w;
  private int x;
  private final SparseBooleanArray y = new SparseBooleanArray();
  private View z;
  
  public ActionMenuPresenter(Context paramContext)
  {
    super(paramContext, R.layout.abc_action_menu_layout, R.layout.abc_action_menu_item_layout);
  }
  
  private View a(MenuItem paramMenuItem)
  {
    ViewGroup localViewGroup = (ViewGroup)this.f;
    Object localObject;
    if (localViewGroup == null)
    {
      localObject = null;
      return (View)localObject;
    }
    int i2 = localViewGroup.getChildCount();
    int i1 = 0;
    for (;;)
    {
      if (i1 >= i2) {
        break label74;
      }
      View localView = localViewGroup.getChildAt(i1);
      if ((localView instanceof o.a))
      {
        localObject = localView;
        if (((o.a)localView).getItemData() == paramMenuItem) {
          break;
        }
      }
      i1 += 1;
    }
    label74:
    return null;
  }
  
  public void bindItemView(j paramj, o.a parama)
  {
    parama.initialize(paramj, 0);
    paramj = (ActionMenuView)this.f;
    parama = (ActionMenuItemView)parama;
    parama.setItemInvoker(paramj);
    if (this.A == null) {
      this.A = new b();
    }
    parama.setPopupCallback(this.A);
  }
  
  public boolean dismissPopupMenus()
  {
    return hideOverflowMenu() | hideSubMenus();
  }
  
  public boolean filterLeftoverView(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramViewGroup.getChildAt(paramInt) == this.g) {
      return false;
    }
    return super.filterLeftoverView(paramViewGroup, paramInt);
  }
  
  public boolean flagActionItems()
  {
    ArrayList localArrayList;
    int i6;
    int i1;
    int i9;
    int i10;
    ViewGroup localViewGroup;
    int i3;
    int i4;
    int i5;
    int i2;
    label60:
    Object localObject1;
    if (this.c != null)
    {
      localArrayList = this.c.getVisibleItems();
      i6 = localArrayList.size();
      i1 = this.s;
      i9 = this.r;
      i10 = View.MeasureSpec.makeMeasureSpec(0, 0);
      localViewGroup = (ViewGroup)this.f;
      i3 = 0;
      i4 = 0;
      i5 = 0;
      i2 = 0;
      if (i2 >= i6) {
        break label145;
      }
      localObject1 = (j)localArrayList.get(i2);
      if (!((j)localObject1).requiresActionButton()) {
        break label122;
      }
      i3 += 1;
      label89:
      if ((!this.w) || (!((j)localObject1).isActionViewExpanded())) {
        break label836;
      }
      i1 = 0;
    }
    label122:
    label145:
    label320:
    label461:
    label521:
    label526:
    label565:
    label648:
    label660:
    label665:
    label813:
    label816:
    label827:
    label836:
    for (;;)
    {
      i2 += 1;
      break label60;
      i6 = 0;
      localArrayList = null;
      break;
      if (((j)localObject1).requestsActionButton())
      {
        i4 += 1;
        break label89;
      }
      i5 = 1;
      break label89;
      i2 = i1;
      if (this.o) {
        if (i5 == 0)
        {
          i2 = i1;
          if (i3 + i4 <= i1) {}
        }
        else
        {
          i2 = i1 - 1;
        }
      }
      i2 -= i3;
      localObject1 = this.y;
      ((SparseBooleanArray)localObject1).clear();
      i1 = 0;
      if (this.u)
      {
        i1 = i9 / this.x;
        i3 = this.x;
        i4 = this.x;
      }
      for (int i7 = i9 % i3 / i1 + i4;; i7 = 0)
      {
        int i8 = 0;
        i5 = 0;
        i3 = i1;
        i1 = i2;
        i4 = i9;
        i2 = i5;
        j localj;
        Object localObject2;
        if (i8 < i6)
        {
          localj = (j)localArrayList.get(i8);
          if (localj.requiresActionButton())
          {
            localObject2 = getItemView(localj, this.z, localViewGroup);
            if (this.z == null) {
              this.z = ((View)localObject2);
            }
            if (this.u)
            {
              i5 = i3 - ActionMenuView.a((View)localObject2, i7, i3, i10, 0);
              i3 = ((View)localObject2).getMeasuredWidth();
              if (i2 != 0) {
                break label827;
              }
              i2 = i3;
            }
          }
        }
        for (;;)
        {
          i9 = localj.getGroupId();
          if (i9 != 0) {
            ((SparseBooleanArray)localObject1).put(i9, true);
          }
          localj.setIsActionButton(true);
          i4 -= i3;
          i3 = i1;
          i1 = i4;
          i9 = i8 + 1;
          i8 = i3;
          i3 = i5;
          i4 = i1;
          i1 = i8;
          i8 = i9;
          break;
          ((View)localObject2).measure(i10, i10);
          i5 = i3;
          break label320;
          int i11;
          boolean bool;
          int i12;
          if (localj.requestsActionButton())
          {
            i11 = localj.getGroupId();
            bool = ((SparseBooleanArray)localObject1).get(i11);
            if (((i1 > 0) || (bool)) && (i4 > 0) && ((!this.u) || (i3 > 0)))
            {
              i12 = 1;
              if (i12 == 0) {
                break label816;
              }
              localObject2 = getItemView(localj, this.z, localViewGroup);
              if (this.z == null) {
                this.z = ((View)localObject2);
              }
              if (!this.u) {
                break label648;
              }
              i5 = ActionMenuView.a((View)localObject2, i7, i3, i10, 0);
              if (i5 != 0) {
                break label813;
              }
              i12 = 0;
              i3 -= i5;
              i5 = ((View)localObject2).getMeasuredWidth();
              i9 = i4 - i5;
              i4 = i2;
              if (i2 == 0) {
                i4 = i5;
              }
              if (!this.u) {
                break label665;
              }
              if (i9 < 0) {
                break label660;
              }
              i2 = 1;
              i12 &= i2;
              i2 = i4;
              i5 = i3;
              i4 = i9;
              i3 = i2;
              i2 = i5;
            }
          }
          for (;;)
          {
            if ((i12 != 0) && (i11 != 0)) {
              ((SparseBooleanArray)localObject1).put(i11, true);
            }
            for (;;)
            {
              i5 = i1;
              if (i12 != 0) {
                i5 = i1 - 1;
              }
              localj.setIsActionButton(i12);
              i1 = i4;
              i4 = i5;
              i5 = i2;
              i2 = i3;
              i3 = i4;
              break;
              int i13 = 0;
              break label461;
              ((View)localObject2).measure(i10, i10);
              break label526;
              i2 = 0;
              break label565;
              if (i9 + i4 > 0) {}
              for (i2 = 1;; i2 = 0)
              {
                i13 &= i2;
                i2 = i3;
                i3 = i4;
                i4 = i9;
                break;
              }
              if (bool)
              {
                ((SparseBooleanArray)localObject1).put(i11, false);
                i9 = 0;
                for (;;)
                {
                  if (i9 < i8)
                  {
                    localObject2 = (j)localArrayList.get(i9);
                    i5 = i1;
                    if (((j)localObject2).getGroupId() == i11)
                    {
                      i5 = i1;
                      if (((j)localObject2).isActionButton()) {
                        i5 = i1 + 1;
                      }
                      ((j)localObject2).setIsActionButton(false);
                    }
                    i9 += 1;
                    i1 = i5;
                    continue;
                    localj.setIsActionButton(false);
                    i5 = i4;
                    i4 = i1;
                    i1 = i5;
                    i5 = i3;
                    i3 = i4;
                    break;
                    return true;
                  }
                }
              }
            }
            break label521;
            i5 = i2;
            i2 = i3;
            i3 = i5;
          }
        }
      }
    }
  }
  
  public View getItemView(j paramj, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramj.getActionView();
    if ((localView == null) || (paramj.hasCollapsibleActionView())) {
      localView = super.getItemView(paramj, paramView, paramViewGroup);
    }
    if (paramj.isActionViewExpanded()) {}
    for (int i1 = 8;; i1 = 0)
    {
      localView.setVisibility(i1);
      paramj = (ActionMenuView)paramViewGroup;
      paramView = localView.getLayoutParams();
      if (!paramj.checkLayoutParams(paramView)) {
        localView.setLayoutParams(paramj.a(paramView));
      }
      return localView;
    }
  }
  
  public o getMenuView(ViewGroup paramViewGroup)
  {
    o localo = this.f;
    paramViewGroup = super.getMenuView(paramViewGroup);
    if (localo != paramViewGroup) {
      ((ActionMenuView)paramViewGroup).setPresenter(this);
    }
    return paramViewGroup;
  }
  
  public Drawable getOverflowIcon()
  {
    if (this.g != null) {
      return this.g.getDrawable();
    }
    if (this.n) {
      return this.m;
    }
    return null;
  }
  
  public boolean hideOverflowMenu()
  {
    if ((this.j != null) && (this.f != null))
    {
      ((View)this.f).removeCallbacks(this.j);
      this.j = null;
      return true;
    }
    d locald = this.h;
    if (locald != null)
    {
      locald.dismiss();
      return true;
    }
    return false;
  }
  
  public boolean hideSubMenus()
  {
    if (this.i != null)
    {
      this.i.dismiss();
      return true;
    }
    return false;
  }
  
  public void initForMenu(Context paramContext, h paramh)
  {
    super.initForMenu(paramContext, paramh);
    paramh = paramContext.getResources();
    paramContext = a.get(paramContext);
    if (!this.p) {
      this.o = paramContext.showsOverflowMenuButton();
    }
    if (!this.v) {
      this.q = paramContext.getEmbeddedMenuWidthLimit();
    }
    if (!this.t) {
      this.s = paramContext.getMaxActionButtons();
    }
    int i1 = this.q;
    if (this.o)
    {
      if (this.g == null)
      {
        this.g = new OverflowMenuButton(this.a);
        if (this.n)
        {
          this.g.setImageDrawable(this.m);
          this.m = null;
          this.n = false;
        }
        int i2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.g.measure(i2, i2);
      }
      i1 -= this.g.getMeasuredWidth();
    }
    for (;;)
    {
      this.r = i1;
      this.x = ((int)(56.0F * paramh.getDisplayMetrics().density));
      this.z = null;
      return;
      this.g = null;
    }
  }
  
  public boolean isOverflowMenuShowPending()
  {
    return (this.j != null) || (isOverflowMenuShowing());
  }
  
  public boolean isOverflowMenuShowing()
  {
    return (this.h != null) && (this.h.isShowing());
  }
  
  public boolean isOverflowReserved()
  {
    return this.o;
  }
  
  public void onCloseMenu(h paramh, boolean paramBoolean)
  {
    dismissPopupMenus();
    super.onCloseMenu(paramh, paramBoolean);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (!this.t) {
      this.s = a.get(this.b).getMaxActionButtons();
    }
    if (this.c != null) {
      this.c.onItemsChanged(true);
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState)) {}
    do
    {
      do
      {
        return;
        paramParcelable = (SavedState)paramParcelable;
      } while (paramParcelable.a <= 0);
      paramParcelable = this.c.findItem(paramParcelable.a);
    } while (paramParcelable == null);
    onSubMenuSelected((t)paramParcelable.getSubMenu());
  }
  
  public Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState();
    localSavedState.a = this.l;
    return localSavedState;
  }
  
  public boolean onSubMenuSelected(t paramt)
  {
    if (!paramt.hasVisibleItems()) {}
    Object localObject;
    do
    {
      return false;
      for (localObject = paramt; ((t)localObject).getParentMenu() != this.c; localObject = (t)((t)localObject).getParentMenu()) {}
      localObject = a(((t)localObject).getItem());
    } while (localObject == null);
    this.l = paramt.getItem().getItemId();
    int i2 = paramt.size();
    int i1 = 0;
    if (i1 < i2)
    {
      MenuItem localMenuItem = paramt.getItem(i1);
      if ((!localMenuItem.isVisible()) || (localMenuItem.getIcon() == null)) {}
    }
    for (boolean bool = true;; bool = false)
    {
      this.i = new a(this.b, paramt, (View)localObject);
      this.i.setForceShowIcon(bool);
      this.i.show();
      super.onSubMenuSelected(paramt);
      return true;
      i1 += 1;
      break;
    }
  }
  
  public void onSubUiVisibilityChanged(boolean paramBoolean)
  {
    if (paramBoolean) {
      super.onSubMenuSelected(null);
    }
    while (this.c == null) {
      return;
    }
    this.c.close(false);
  }
  
  public void setExpandedActionViewsExclusive(boolean paramBoolean)
  {
    this.w = paramBoolean;
  }
  
  public void setItemLimit(int paramInt)
  {
    this.s = paramInt;
    this.t = true;
  }
  
  public void setMenuView(ActionMenuView paramActionMenuView)
  {
    this.f = paramActionMenuView;
    paramActionMenuView.initialize(this.c);
  }
  
  public void setOverflowIcon(Drawable paramDrawable)
  {
    if (this.g != null)
    {
      this.g.setImageDrawable(paramDrawable);
      return;
    }
    this.n = true;
    this.m = paramDrawable;
  }
  
  public void setReserveOverflow(boolean paramBoolean)
  {
    this.o = paramBoolean;
    this.p = true;
  }
  
  public void setWidthLimit(int paramInt, boolean paramBoolean)
  {
    this.q = paramInt;
    this.u = paramBoolean;
    this.v = true;
  }
  
  public boolean shouldIncludeItem(int paramInt, j paramj)
  {
    return paramj.isActionButton();
  }
  
  public boolean showOverflowMenu()
  {
    if ((this.o) && (!isOverflowMenuShowing()) && (this.c != null) && (this.f != null) && (this.j == null) && (!this.c.getNonActionItems().isEmpty()))
    {
      this.j = new c(new d(this.b, this.c, this.g, true));
      ((View)this.f).post(this.j);
      super.onSubMenuSelected(null);
      return true;
    }
    return false;
  }
  
  public void updateMenuView(boolean paramBoolean)
  {
    int i2 = 1;
    int i3 = 0;
    super.updateMenuView(paramBoolean);
    ((View)this.f).requestLayout();
    Object localObject;
    int i1;
    if (this.c != null)
    {
      localObject = this.c.getActionItems();
      int i4 = ((ArrayList)localObject).size();
      i1 = 0;
      while (i1 < i4)
      {
        ActionProvider localActionProvider = ((j)((ArrayList)localObject).get(i1)).getSupportActionProvider();
        if (localActionProvider != null) {
          localActionProvider.setSubUiVisibilityListener(this);
        }
        i1 += 1;
      }
    }
    if (this.c != null)
    {
      localObject = this.c.getNonActionItems();
      i1 = i3;
      if (this.o)
      {
        i1 = i3;
        if (localObject != null)
        {
          i1 = ((ArrayList)localObject).size();
          if (i1 != 1) {
            break label256;
          }
          if (((j)((ArrayList)localObject).get(0)).isActionViewExpanded()) {
            break label251;
          }
          i1 = 1;
        }
      }
      label145:
      if (i1 == 0) {
        break label270;
      }
      if (this.g == null) {
        this.g = new OverflowMenuButton(this.a);
      }
      localObject = (ViewGroup)this.g.getParent();
      if (localObject != this.f)
      {
        if (localObject != null) {
          ((ViewGroup)localObject).removeView(this.g);
        }
        localObject = (ActionMenuView)this.f;
        ((ActionMenuView)localObject).addView(this.g, ((ActionMenuView)localObject).generateOverflowButtonLayoutParams());
      }
    }
    for (;;)
    {
      ((ActionMenuView)this.f).setOverflowReserved(this.o);
      return;
      localObject = null;
      break;
      label251:
      i1 = 0;
      break label145;
      label256:
      if (i1 > 0) {}
      for (i1 = i2;; i1 = 0) {
        break;
      }
      label270:
      if ((this.g != null) && (this.g.getParent() == this.f)) {
        ((ViewGroup)this.f).removeView(this.g);
      }
    }
  }
  
  private class OverflowMenuButton
    extends AppCompatImageView
    implements ActionMenuView.a
  {
    private final float[] b = new float[2];
    
    public OverflowMenuButton(Context paramContext)
    {
      super(null, R.attr.actionOverflowButtonStyle);
      setClickable(true);
      setFocusable(true);
      setVisibility(0);
      setEnabled(true);
      av.setTooltipText(this, getContentDescription());
      setOnTouchListener(new z(this)
      {
        public r getPopup()
        {
          if (ActionMenuPresenter.this.h == null) {
            return null;
          }
          return ActionMenuPresenter.this.h.getPopup();
        }
        
        public boolean onForwardingStarted()
        {
          ActionMenuPresenter.this.showOverflowMenu();
          return true;
        }
        
        public boolean onForwardingStopped()
        {
          if (ActionMenuPresenter.this.j != null) {
            return false;
          }
          ActionMenuPresenter.this.hideOverflowMenu();
          return true;
        }
      });
    }
    
    public boolean needsDividerAfter()
    {
      return false;
    }
    
    public boolean needsDividerBefore()
    {
      return false;
    }
    
    public boolean performClick()
    {
      if (super.performClick()) {
        return true;
      }
      playSoundEffect(0);
      ActionMenuPresenter.this.showOverflowMenu();
      return true;
    }
    
    protected boolean setFrame(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      boolean bool = super.setFrame(paramInt1, paramInt2, paramInt3, paramInt4);
      Drawable localDrawable1 = getDrawable();
      Drawable localDrawable2 = getBackground();
      if ((localDrawable1 != null) && (localDrawable2 != null))
      {
        int i = getWidth();
        paramInt2 = getHeight();
        paramInt1 = Math.max(i, paramInt2) / 2;
        int j = getPaddingLeft();
        int k = getPaddingRight();
        paramInt3 = getPaddingTop();
        paramInt4 = getPaddingBottom();
        i = (i + (j - k)) / 2;
        paramInt2 = (paramInt2 + (paramInt3 - paramInt4)) / 2;
        DrawableCompat.setHotspotBounds(localDrawable2, i - paramInt1, paramInt2 - paramInt1, i + paramInt1, paramInt2 + paramInt1);
      }
      return bool;
    }
  }
  
  private static class SavedState
    implements Parcelable
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator()
    {
      public ActionMenuPresenter.SavedState createFromParcel(Parcel paramAnonymousParcel)
      {
        return new ActionMenuPresenter.SavedState(paramAnonymousParcel);
      }
      
      public ActionMenuPresenter.SavedState[] newArray(int paramAnonymousInt)
      {
        return new ActionMenuPresenter.SavedState[paramAnonymousInt];
      }
    };
    public int a;
    
    SavedState() {}
    
    SavedState(Parcel paramParcel)
    {
      this.a = paramParcel.readInt();
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.a);
    }
  }
  
  private class a
    extends m
  {
    public a(Context paramContext, t paramt, View paramView)
    {
      super(paramt, paramView, false, R.attr.actionOverflowMenuStyle);
      if (!((j)paramt.getItem()).isActionButton()) {
        if (ActionMenuPresenter.this.g != null) {
          break label59;
        }
      }
      label59:
      for (paramContext = (View)ActionMenuPresenter.c(ActionMenuPresenter.this);; paramContext = ActionMenuPresenter.this.g)
      {
        setAnchorView(paramContext);
        setPresenterCallback(ActionMenuPresenter.this.k);
        return;
      }
    }
    
    protected void a()
    {
      ActionMenuPresenter.this.i = null;
      ActionMenuPresenter.this.l = 0;
      super.a();
    }
  }
  
  private class b
    extends ActionMenuItemView.b
  {
    b() {}
    
    public r getPopup()
    {
      if (ActionMenuPresenter.this.i != null) {
        return ActionMenuPresenter.this.i.getPopup();
      }
      return null;
    }
  }
  
  private class c
    implements Runnable
  {
    private ActionMenuPresenter.d b;
    
    public c(ActionMenuPresenter.d paramd)
    {
      this.b = paramd;
    }
    
    public void run()
    {
      if (ActionMenuPresenter.d(ActionMenuPresenter.this) != null) {
        ActionMenuPresenter.e(ActionMenuPresenter.this).changeMenuMode();
      }
      View localView = (View)ActionMenuPresenter.f(ActionMenuPresenter.this);
      if ((localView != null) && (localView.getWindowToken() != null) && (this.b.tryShow())) {
        ActionMenuPresenter.this.h = this.b;
      }
      ActionMenuPresenter.this.j = null;
    }
  }
  
  private class d
    extends m
  {
    public d(Context paramContext, h paramh, View paramView, boolean paramBoolean)
    {
      super(paramh, paramView, paramBoolean, R.attr.actionOverflowMenuStyle);
      setGravity(8388613);
      setPresenterCallback(ActionMenuPresenter.this.k);
    }
    
    protected void a()
    {
      if (ActionMenuPresenter.a(ActionMenuPresenter.this) != null) {
        ActionMenuPresenter.b(ActionMenuPresenter.this).close();
      }
      ActionMenuPresenter.this.h = null;
      super.a();
    }
  }
  
  private class e
    implements n.a
  {
    e() {}
    
    public void onCloseMenu(h paramh, boolean paramBoolean)
    {
      if ((paramh instanceof t)) {
        paramh.getRootMenu().close(false);
      }
      n.a locala = ActionMenuPresenter.this.getCallback();
      if (locala != null) {
        locala.onCloseMenu(paramh, paramBoolean);
      }
    }
    
    public boolean onOpenSubMenu(h paramh)
    {
      if (paramh == null) {
        return false;
      }
      ActionMenuPresenter.this.l = ((t)paramh).getItem().getItemId();
      n.a locala = ActionMenuPresenter.this.getCallback();
      if (locala != null) {}
      for (boolean bool = locala.onOpenSubMenu(paramh);; bool = false) {
        return bool;
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/widget/ActionMenuPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */