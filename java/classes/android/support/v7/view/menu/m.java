package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.dimen;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow.OnDismissListener;

public class m
{
  private final Context a;
  private final h b;
  private final boolean c;
  private final int d;
  private final int e;
  private View f;
  private int g = 8388611;
  private boolean h;
  private n.a i;
  private l j;
  private PopupWindow.OnDismissListener k;
  private final PopupWindow.OnDismissListener l = new PopupWindow.OnDismissListener()
  {
    public void onDismiss()
    {
      m.this.a();
    }
  };
  
  public m(Context paramContext, h paramh)
  {
    this(paramContext, paramh, null, false, R.attr.popupMenuStyle, 0);
  }
  
  public m(Context paramContext, h paramh, View paramView)
  {
    this(paramContext, paramh, paramView, false, R.attr.popupMenuStyle, 0);
  }
  
  public m(Context paramContext, h paramh, View paramView, boolean paramBoolean, int paramInt)
  {
    this(paramContext, paramh, paramView, paramBoolean, paramInt, 0);
  }
  
  public m(Context paramContext, h paramh, View paramView, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.a = paramContext;
    this.b = paramh;
    this.f = paramView;
    this.c = paramBoolean;
    this.d = paramInt1;
    this.e = paramInt2;
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    l locall = getPopup();
    locall.setShowTitle(paramBoolean2);
    if (paramBoolean1)
    {
      int m = paramInt1;
      if ((GravityCompat.getAbsoluteGravity(this.g, ViewCompat.getLayoutDirection(this.f)) & 0x7) == 5) {
        m = paramInt1 + this.f.getWidth();
      }
      locall.setHorizontalOffset(m);
      locall.setVerticalOffset(paramInt2);
      paramInt1 = (int)(this.a.getResources().getDisplayMetrics().density * 48.0F / 2.0F);
      locall.setEpicenterBounds(new Rect(m - paramInt1, paramInt2 - paramInt1, m + paramInt1, paramInt1 + paramInt2));
    }
    locall.show();
  }
  
  private l b()
  {
    Object localObject = ((WindowManager)this.a.getSystemService("window")).getDefaultDisplay();
    Point localPoint = new Point();
    int m;
    if (Build.VERSION.SDK_INT >= 17)
    {
      ((Display)localObject).getRealSize(localPoint);
      if (Math.min(localPoint.x, localPoint.y) < this.a.getResources().getDimensionPixelSize(R.dimen.abc_cascading_menus_min_smallest_width)) {
        break label158;
      }
      m = 1;
      label68:
      if (m == 0) {
        break label163;
      }
    }
    label158:
    label163:
    for (localObject = new e(this.a, this.f, this.d, this.e, this.c);; localObject = new s(this.a, this.b, this.f, this.d, this.e, this.c))
    {
      ((l)localObject).addMenu(this.b);
      ((l)localObject).setOnDismissListener(this.l);
      ((l)localObject).setAnchorView(this.f);
      ((l)localObject).setCallback(this.i);
      ((l)localObject).setForceShowIcon(this.h);
      ((l)localObject).setGravity(this.g);
      return (l)localObject;
      ((Display)localObject).getSize(localPoint);
      break;
      m = 0;
      break label68;
    }
  }
  
  protected void a()
  {
    this.j = null;
    if (this.k != null) {
      this.k.onDismiss();
    }
  }
  
  public void dismiss()
  {
    if (isShowing()) {
      this.j.dismiss();
    }
  }
  
  public int getGravity()
  {
    return this.g;
  }
  
  public l getPopup()
  {
    if (this.j == null) {
      this.j = b();
    }
    return this.j;
  }
  
  public boolean isShowing()
  {
    return (this.j != null) && (this.j.isShowing());
  }
  
  public void setAnchorView(View paramView)
  {
    this.f = paramView;
  }
  
  public void setForceShowIcon(boolean paramBoolean)
  {
    this.h = paramBoolean;
    if (this.j != null) {
      this.j.setForceShowIcon(paramBoolean);
    }
  }
  
  public void setGravity(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.k = paramOnDismissListener;
  }
  
  public void setPresenterCallback(n.a parama)
  {
    this.i = parama;
    if (this.j != null) {
      this.j.setCallback(parama);
    }
  }
  
  public void show()
  {
    if (!tryShow()) {
      throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
    }
  }
  
  public void show(int paramInt1, int paramInt2)
  {
    if (!tryShow(paramInt1, paramInt2)) {
      throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
    }
  }
  
  public boolean tryShow()
  {
    if (isShowing()) {
      return true;
    }
    if (this.f == null) {
      return false;
    }
    a(0, 0, false, false);
    return true;
  }
  
  public boolean tryShow(int paramInt1, int paramInt2)
  {
    if (isShowing()) {
      return true;
    }
    if (this.f == null) {
      return false;
    }
    a(paramInt1, paramInt2, true, true);
    return true;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/view/menu/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */