package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R.dimen;
import android.support.v7.appcompat.R.layout;
import android.support.v7.widget.MenuPopupWindow;
import android.support.v7.widget.ad;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class e
  extends l
  implements n, View.OnKeyListener, PopupWindow.OnDismissListener
{
  final Handler a;
  final List<a> b = new ArrayList();
  View c;
  boolean d;
  private final Context e;
  private final int f;
  private final int g;
  private final int h;
  private final boolean i;
  private final List<h> j = new LinkedList();
  private final ViewTreeObserver.OnGlobalLayoutListener k = new ViewTreeObserver.OnGlobalLayoutListener()
  {
    public void onGlobalLayout()
    {
      Object localObject;
      if ((e.this.isShowing()) && (e.this.b.size() > 0) && (!((e.a)e.this.b.get(0)).a.isModal()))
      {
        localObject = e.this.c;
        if ((localObject != null) && (((View)localObject).isShown())) {
          break label77;
        }
        e.this.dismiss();
      }
      for (;;)
      {
        return;
        label77:
        localObject = e.this.b.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((e.a)((Iterator)localObject).next()).a.show();
        }
      }
    }
  };
  private final View.OnAttachStateChangeListener l = new View.OnAttachStateChangeListener()
  {
    public void onViewAttachedToWindow(View paramAnonymousView) {}
    
    public void onViewDetachedFromWindow(View paramAnonymousView)
    {
      if (e.a(e.this) != null)
      {
        if (!e.a(e.this).isAlive()) {
          e.a(e.this, paramAnonymousView.getViewTreeObserver());
        }
        e.a(e.this).removeGlobalOnLayoutListener(e.b(e.this));
      }
      paramAnonymousView.removeOnAttachStateChangeListener(this);
    }
  };
  private final ad m = new ad()
  {
    public void onItemHoverEnter(final h paramAnonymoush, final MenuItem paramAnonymousMenuItem)
    {
      e.this.a.removeCallbacksAndMessages(null);
      int i = 0;
      int j = e.this.b.size();
      if (i < j) {
        if (paramAnonymoush != ((e.a)e.this.b.get(i)).b) {}
      }
      for (;;)
      {
        if (i == -1)
        {
          return;
          i += 1;
          break;
        }
        i += 1;
        if (i < e.this.b.size()) {}
        for (final e.a locala = (e.a)e.this.b.get(i);; locala = null)
        {
          paramAnonymousMenuItem = new Runnable()
          {
            public void run()
            {
              if (locala != null)
              {
                e.this.d = true;
                locala.b.close(false);
                e.this.d = false;
              }
              if ((paramAnonymousMenuItem.isEnabled()) && (paramAnonymousMenuItem.hasSubMenu())) {
                paramAnonymoush.performItemAction(paramAnonymousMenuItem, 4);
              }
            }
          };
          long l = SystemClock.uptimeMillis();
          e.this.a.postAtTime(paramAnonymousMenuItem, paramAnonymoush, l + 200L);
          return;
        }
        i = -1;
      }
    }
    
    public void onItemHoverExit(h paramAnonymoush, MenuItem paramAnonymousMenuItem)
    {
      e.this.a.removeCallbacksAndMessages(paramAnonymoush);
    }
  };
  private int n = 0;
  private int o = 0;
  private View p;
  private int q;
  private boolean r;
  private boolean s;
  private int t;
  private int u;
  private boolean v;
  private boolean w;
  private n.a x;
  private ViewTreeObserver y;
  private PopupWindow.OnDismissListener z;
  
  public e(Context paramContext, View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.e = paramContext;
    this.p = paramView;
    this.g = paramInt1;
    this.h = paramInt2;
    this.i = paramBoolean;
    this.v = false;
    this.q = c();
    paramContext = paramContext.getResources();
    this.f = Math.max(paramContext.getDisplayMetrics().widthPixels / 2, paramContext.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
    this.a = new Handler();
  }
  
  private int a(int paramInt)
  {
    ListView localListView = ((a)this.b.get(this.b.size() - 1)).getListView();
    int[] arrayOfInt = new int[2];
    localListView.getLocationOnScreen(arrayOfInt);
    Rect localRect = new Rect();
    this.c.getWindowVisibleDisplayFrame(localRect);
    if (this.q == 1)
    {
      int i1 = arrayOfInt[0];
      if (localListView.getWidth() + i1 + paramInt > localRect.right) {
        return 0;
      }
      return 1;
    }
    if (arrayOfInt[0] - paramInt < 0) {
      return 1;
    }
    return 0;
  }
  
  private MenuItem a(h paramh1, h paramh2)
  {
    int i2 = paramh1.size();
    int i1 = 0;
    while (i1 < i2)
    {
      MenuItem localMenuItem = paramh1.getItem(i1);
      if ((localMenuItem.hasSubMenu()) && (paramh2 == localMenuItem.getSubMenu())) {
        return localMenuItem;
      }
      i1 += 1;
    }
    return null;
  }
  
  private View a(a parama, h paramh)
  {
    int i1 = 0;
    paramh = a(parama.b, paramh);
    if (paramh == null) {
      return null;
    }
    ListView localListView = parama.getListView();
    parama = localListView.getAdapter();
    int i2;
    if ((parama instanceof HeaderViewListAdapter))
    {
      parama = (HeaderViewListAdapter)parama;
      i2 = parama.getHeadersCount();
      parama = (g)parama.getWrappedAdapter();
      int i3 = parama.getCount();
      label62:
      if (i1 >= i3) {
        break label135;
      }
      if (paramh != parama.getItem(i1)) {
        break label95;
      }
    }
    for (;;)
    {
      if (i1 == -1)
      {
        return null;
        parama = (g)parama;
        i2 = 0;
        break;
        label95:
        i1 += 1;
        break label62;
      }
      i1 = i1 + i2 - localListView.getFirstVisiblePosition();
      if ((i1 < 0) || (i1 >= localListView.getChildCount())) {
        return null;
      }
      return localListView.getChildAt(i1);
      label135:
      i1 = -1;
    }
  }
  
  private MenuPopupWindow b()
  {
    MenuPopupWindow localMenuPopupWindow = new MenuPopupWindow(this.e, null, this.g, this.h);
    localMenuPopupWindow.setHoverListener(this.m);
    localMenuPopupWindow.setOnItemClickListener(this);
    localMenuPopupWindow.setOnDismissListener(this);
    localMenuPopupWindow.setAnchorView(this.p);
    localMenuPopupWindow.setDropDownGravity(this.o);
    localMenuPopupWindow.setModal(true);
    localMenuPopupWindow.setInputMethodMode(2);
    return localMenuPopupWindow;
  }
  
  private void b(h paramh)
  {
    Object localObject3 = LayoutInflater.from(this.e);
    Object localObject1 = new g(paramh, (LayoutInflater)localObject3, this.i);
    int i4;
    MenuPopupWindow localMenuPopupWindow;
    Object localObject2;
    label136:
    int i2;
    int i1;
    label167:
    int i3;
    if ((!isShowing()) && (this.v))
    {
      ((g)localObject1).setForceShowIcon(true);
      i4 = a((ListAdapter)localObject1, null, this.e, this.f);
      localMenuPopupWindow = b();
      localMenuPopupWindow.setAdapter((ListAdapter)localObject1);
      localMenuPopupWindow.setContentWidth(i4);
      localMenuPopupWindow.setDropDownGravity(this.o);
      if (this.b.size() <= 0) {
        break label373;
      }
      localObject1 = (a)this.b.get(this.b.size() - 1);
      localObject2 = a((a)localObject1, paramh);
      if (localObject2 == null) {
        break label474;
      }
      localMenuPopupWindow.setTouchModal(false);
      localMenuPopupWindow.setEnterTransition(null);
      i2 = a(i4);
      if (i2 != 1) {
        break label382;
      }
      i1 = 1;
      this.q = i2;
      if (Build.VERSION.SDK_INT < 26) {
        break label387;
      }
      localMenuPopupWindow.setAnchorView((View)localObject2);
      i2 = 0;
      i3 = 0;
      label192:
      if ((this.o & 0x5) != 5) {
        break label449;
      }
      if (i1 == 0) {
        break label437;
      }
      i1 = i3 + i4;
      label212:
      localMenuPopupWindow.setHorizontalOffset(i1);
      localMenuPopupWindow.setOverlapAnchor(true);
      localMenuPopupWindow.setVerticalOffset(i2);
    }
    for (;;)
    {
      localObject2 = new a(localMenuPopupWindow, paramh, this.q);
      this.b.add(localObject2);
      localMenuPopupWindow.show();
      localObject2 = localMenuPopupWindow.getListView();
      ((ListView)localObject2).setOnKeyListener(this);
      if ((localObject1 == null) && (this.w) && (paramh.getHeaderTitle() != null))
      {
        localObject1 = (FrameLayout)((LayoutInflater)localObject3).inflate(R.layout.abc_popup_menu_header_item_layout, (ViewGroup)localObject2, false);
        localObject3 = (TextView)((FrameLayout)localObject1).findViewById(16908310);
        ((FrameLayout)localObject1).setEnabled(false);
        ((TextView)localObject3).setText(paramh.getHeaderTitle());
        ((ListView)localObject2).addHeaderView((View)localObject1, null, false);
        localMenuPopupWindow.show();
      }
      return;
      if (!isShowing()) {
        break;
      }
      ((g)localObject1).setForceShowIcon(l.a(paramh));
      break;
      label373:
      localObject2 = null;
      localObject1 = null;
      break label136;
      label382:
      i1 = 0;
      break label167;
      label387:
      int[] arrayOfInt1 = new int[2];
      this.p.getLocationOnScreen(arrayOfInt1);
      int[] arrayOfInt2 = new int[2];
      ((View)localObject2).getLocationOnScreen(arrayOfInt2);
      i3 = arrayOfInt2[0] - arrayOfInt1[0];
      i2 = arrayOfInt2[1] - arrayOfInt1[1];
      break label192;
      label437:
      i1 = i3 - ((View)localObject2).getWidth();
      break label212;
      label449:
      if (i1 != 0)
      {
        i1 = ((View)localObject2).getWidth() + i3;
        break label212;
      }
      i1 = i3 - i4;
      break label212;
      label474:
      if (this.r) {
        localMenuPopupWindow.setHorizontalOffset(this.t);
      }
      if (this.s) {
        localMenuPopupWindow.setVerticalOffset(this.u);
      }
      localMenuPopupWindow.setEpicenterBounds(getEpicenterBounds());
    }
  }
  
  private int c()
  {
    int i1 = 1;
    if (ViewCompat.getLayoutDirection(this.p) == 1) {
      i1 = 0;
    }
    return i1;
  }
  
  private int c(h paramh)
  {
    int i1 = 0;
    int i2 = this.b.size();
    while (i1 < i2)
    {
      if (paramh == ((a)this.b.get(i1)).b) {
        return i1;
      }
      i1 += 1;
    }
    return -1;
  }
  
  protected boolean a()
  {
    return false;
  }
  
  public void addMenu(h paramh)
  {
    paramh.addMenuPresenter(this, this.e);
    if (isShowing())
    {
      b(paramh);
      return;
    }
    this.j.add(paramh);
  }
  
  public void dismiss()
  {
    int i1 = this.b.size();
    if (i1 > 0)
    {
      a[] arrayOfa = (a[])this.b.toArray(new a[i1]);
      i1 -= 1;
      while (i1 >= 0)
      {
        a locala = arrayOfa[i1];
        if (locala.a.isShowing()) {
          locala.a.dismiss();
        }
        i1 -= 1;
      }
    }
  }
  
  public boolean flagActionItems()
  {
    return false;
  }
  
  public ListView getListView()
  {
    if (this.b.isEmpty()) {
      return null;
    }
    return ((a)this.b.get(this.b.size() - 1)).getListView();
  }
  
  public boolean isShowing()
  {
    return (this.b.size() > 0) && (((a)this.b.get(0)).a.isShowing());
  }
  
  public void onCloseMenu(h paramh, boolean paramBoolean)
  {
    int i1 = c(paramh);
    if (i1 < 0) {}
    do
    {
      return;
      int i2 = i1 + 1;
      if (i2 < this.b.size()) {
        ((a)this.b.get(i2)).b.close(false);
      }
      a locala = (a)this.b.remove(i1);
      locala.b.removeMenuPresenter(this);
      if (this.d)
      {
        locala.a.setExitTransition(null);
        locala.a.setAnimationStyle(0);
      }
      locala.a.dismiss();
      i1 = this.b.size();
      if (i1 > 0) {}
      for (this.q = ((a)this.b.get(i1 - 1)).c; i1 == 0; this.q = c())
      {
        dismiss();
        if (this.x != null) {
          this.x.onCloseMenu(paramh, true);
        }
        if (this.y != null)
        {
          if (this.y.isAlive()) {
            this.y.removeGlobalOnLayoutListener(this.k);
          }
          this.y = null;
        }
        this.c.removeOnAttachStateChangeListener(this.l);
        this.z.onDismiss();
        return;
      }
    } while (!paramBoolean);
    ((a)this.b.get(0)).b.close(false);
  }
  
  public void onDismiss()
  {
    int i2 = this.b.size();
    int i1 = 0;
    a locala;
    if (i1 < i2)
    {
      locala = (a)this.b.get(i1);
      if (locala.a.isShowing()) {}
    }
    for (;;)
    {
      if (locala != null) {
        locala.b.close(false);
      }
      return;
      i1 += 1;
      break;
      locala = null;
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
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (paramt == locala.b)
      {
        locala.getListView().requestFocus();
        return true;
      }
    }
    if (paramt.hasVisibleItems())
    {
      addMenu(paramt);
      if (this.x != null) {
        this.x.onOpenSubMenu(paramt);
      }
      return true;
    }
    return false;
  }
  
  public void setAnchorView(View paramView)
  {
    if (this.p != paramView)
    {
      this.p = paramView;
      this.o = GravityCompat.getAbsoluteGravity(this.n, ViewCompat.getLayoutDirection(this.p));
    }
  }
  
  public void setCallback(n.a parama)
  {
    this.x = parama;
  }
  
  public void setForceShowIcon(boolean paramBoolean)
  {
    this.v = paramBoolean;
  }
  
  public void setGravity(int paramInt)
  {
    if (this.n != paramInt)
    {
      this.n = paramInt;
      this.o = GravityCompat.getAbsoluteGravity(paramInt, ViewCompat.getLayoutDirection(this.p));
    }
  }
  
  public void setHorizontalOffset(int paramInt)
  {
    this.r = true;
    this.t = paramInt;
  }
  
  public void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.z = paramOnDismissListener;
  }
  
  public void setShowTitle(boolean paramBoolean)
  {
    this.w = paramBoolean;
  }
  
  public void setVerticalOffset(int paramInt)
  {
    this.s = true;
    this.u = paramInt;
  }
  
  public void show()
  {
    if (isShowing()) {}
    do
    {
      return;
      Iterator localIterator = this.j.iterator();
      while (localIterator.hasNext()) {
        b((h)localIterator.next());
      }
      this.j.clear();
      this.c = this.p;
    } while (this.c == null);
    if (this.y == null) {}
    for (int i1 = 1;; i1 = 0)
    {
      this.y = this.c.getViewTreeObserver();
      if (i1 != 0) {
        this.y.addOnGlobalLayoutListener(this.k);
      }
      this.c.addOnAttachStateChangeListener(this.l);
      return;
    }
  }
  
  public void updateMenuView(boolean paramBoolean)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      a(((a)localIterator.next()).getListView().getAdapter()).notifyDataSetChanged();
    }
  }
  
  private static class a
  {
    public final MenuPopupWindow a;
    public final h b;
    public final int c;
    
    public a(MenuPopupWindow paramMenuPopupWindow, h paramh, int paramInt)
    {
      this.a = paramMenuPopupWindow;
      this.b = paramh;
      this.c = paramInt;
    }
    
    public ListView getListView()
    {
      return this.a.getListView();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/view/menu/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */