package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.support.v7.appcompat.R.dimen;
import android.support.v7.appcompat.R.layout;
import android.support.v7.widget.MenuPopupWindow;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;

final class s
  extends l
  implements n, View.OnKeyListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener
{
  final MenuPopupWindow a;
  View b;
  private final Context c;
  private final h d;
  private final g e;
  private final boolean f;
  private final int g;
  private final int h;
  private final int i;
  private final ViewTreeObserver.OnGlobalLayoutListener j = new ViewTreeObserver.OnGlobalLayoutListener()
  {
    public void onGlobalLayout()
    {
      if ((s.this.isShowing()) && (!s.this.a.isModal()))
      {
        View localView = s.this.b;
        if ((localView == null) || (!localView.isShown())) {
          s.this.dismiss();
        }
      }
      else
      {
        return;
      }
      s.this.a.show();
    }
  };
  private final View.OnAttachStateChangeListener k = new View.OnAttachStateChangeListener()
  {
    public void onViewAttachedToWindow(View paramAnonymousView) {}
    
    public void onViewDetachedFromWindow(View paramAnonymousView)
    {
      if (s.a(s.this) != null)
      {
        if (!s.a(s.this).isAlive()) {
          s.a(s.this, paramAnonymousView.getViewTreeObserver());
        }
        s.a(s.this).removeGlobalOnLayoutListener(s.b(s.this));
      }
      paramAnonymousView.removeOnAttachStateChangeListener(this);
    }
  };
  private PopupWindow.OnDismissListener l;
  private View m;
  private n.a n;
  private ViewTreeObserver o;
  private boolean p;
  private boolean q;
  private int r;
  private int s = 0;
  private boolean t;
  
  public s(Context paramContext, h paramh, View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.c = paramContext;
    this.d = paramh;
    this.f = paramBoolean;
    this.e = new g(paramh, LayoutInflater.from(paramContext), this.f);
    this.h = paramInt1;
    this.i = paramInt2;
    Resources localResources = paramContext.getResources();
    this.g = Math.max(localResources.getDisplayMetrics().widthPixels / 2, localResources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
    this.m = paramView;
    this.a = new MenuPopupWindow(this.c, null, this.h, this.i);
    paramh.addMenuPresenter(this, paramContext);
  }
  
  private boolean b()
  {
    if (isShowing()) {
      return true;
    }
    if ((this.p) || (this.m == null)) {
      return false;
    }
    this.b = this.m;
    this.a.setOnDismissListener(this);
    this.a.setOnItemClickListener(this);
    this.a.setModal(true);
    Object localObject = this.b;
    if (this.o == null) {}
    for (int i1 = 1;; i1 = 0)
    {
      this.o = ((View)localObject).getViewTreeObserver();
      if (i1 != 0) {
        this.o.addOnGlobalLayoutListener(this.j);
      }
      ((View)localObject).addOnAttachStateChangeListener(this.k);
      this.a.setAnchorView((View)localObject);
      this.a.setDropDownGravity(this.s);
      if (!this.q)
      {
        this.r = a(this.e, null, this.c, this.g);
        this.q = true;
      }
      this.a.setContentWidth(this.r);
      this.a.setInputMethodMode(2);
      this.a.setEpicenterBounds(getEpicenterBounds());
      this.a.show();
      localObject = this.a.getListView();
      ((ListView)localObject).setOnKeyListener(this);
      if ((this.t) && (this.d.getHeaderTitle() != null))
      {
        FrameLayout localFrameLayout = (FrameLayout)LayoutInflater.from(this.c).inflate(R.layout.abc_popup_menu_header_item_layout, (ViewGroup)localObject, false);
        TextView localTextView = (TextView)localFrameLayout.findViewById(16908310);
        if (localTextView != null) {
          localTextView.setText(this.d.getHeaderTitle());
        }
        localFrameLayout.setEnabled(false);
        ((ListView)localObject).addHeaderView(localFrameLayout, null, false);
      }
      this.a.setAdapter(this.e);
      this.a.show();
      return true;
    }
  }
  
  public void addMenu(h paramh) {}
  
  public void dismiss()
  {
    if (isShowing()) {
      this.a.dismiss();
    }
  }
  
  public boolean flagActionItems()
  {
    return false;
  }
  
  public ListView getListView()
  {
    return this.a.getListView();
  }
  
  public boolean isShowing()
  {
    return (!this.p) && (this.a.isShowing());
  }
  
  public void onCloseMenu(h paramh, boolean paramBoolean)
  {
    if (paramh != this.d) {}
    do
    {
      return;
      dismiss();
    } while (this.n == null);
    this.n.onCloseMenu(paramh, paramBoolean);
  }
  
  public void onDismiss()
  {
    this.p = true;
    this.d.close();
    if (this.o != null)
    {
      if (!this.o.isAlive()) {
        this.o = this.b.getViewTreeObserver();
      }
      this.o.removeGlobalOnLayoutListener(this.j);
      this.o = null;
    }
    this.b.removeOnAttachStateChangeListener(this.k);
    if (this.l != null) {
      this.l.onDismiss();
    }
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getAction() == 1) && (paramInt == 82))
    {
      dismiss();
      return true;
    }
    return false;
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable) {}
  
  public Parcelable onSaveInstanceState()
  {
    return null;
  }
  
  public boolean onSubMenuSelected(t paramt)
  {
    if (paramt.hasVisibleItems())
    {
      m localm = new m(this.c, paramt, this.b, this.f, this.h, this.i);
      localm.setPresenterCallback(this.n);
      localm.setForceShowIcon(l.a(paramt));
      localm.setGravity(this.s);
      localm.setOnDismissListener(this.l);
      this.l = null;
      this.d.close(false);
      if (localm.tryShow(this.a.getHorizontalOffset(), this.a.getVerticalOffset()))
      {
        if (this.n != null) {
          this.n.onOpenSubMenu(paramt);
        }
        return true;
      }
    }
    return false;
  }
  
  public void setAnchorView(View paramView)
  {
    this.m = paramView;
  }
  
  public void setCallback(n.a parama)
  {
    this.n = parama;
  }
  
  public void setForceShowIcon(boolean paramBoolean)
  {
    this.e.setForceShowIcon(paramBoolean);
  }
  
  public void setGravity(int paramInt)
  {
    this.s = paramInt;
  }
  
  public void setHorizontalOffset(int paramInt)
  {
    this.a.setHorizontalOffset(paramInt);
  }
  
  public void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.l = paramOnDismissListener;
  }
  
  public void setShowTitle(boolean paramBoolean)
  {
    this.t = paramBoolean;
  }
  
  public void setVerticalOffset(int paramInt)
  {
    this.a.setVerticalOffset(paramInt);
  }
  
  public void show()
  {
    if (!b()) {
      throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
    }
  }
  
  public void updateMenuView(boolean paramBoolean)
  {
    this.q = false;
    if (this.e != null) {
      this.e.notifyDataSetChanged();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/view/menu/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */