package cn.dreamtobe.kpswitch.a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import cn.dreamtobe.kpswitch.a;
import cn.dreamtobe.kpswitch.b.d;
import cn.dreamtobe.kpswitch.b.e;

public class c
{
  private int a = -1;
  private final View b;
  private final int c;
  private final boolean d;
  private a e;
  
  public c(View paramView)
  {
    this.b = paramView;
    this.c = d.getStatusBarHeight(paramView.getContext());
    this.d = e.isTranslucentStatus((Activity)paramView.getContext());
  }
  
  private a a(View paramView)
  {
    if (this.e != null) {
      return this.e;
    }
    if ((paramView instanceof a))
    {
      this.e = ((a)paramView);
      return this.e;
    }
    if ((paramView instanceof ViewGroup))
    {
      int i = 0;
      while (i < ((ViewGroup)paramView).getChildCount())
      {
        a locala = a(((ViewGroup)paramView).getChildAt(i));
        if (locala != null)
        {
          this.e = locala;
          return this.e;
        }
        i += 1;
      }
    }
    return null;
  }
  
  @TargetApi(16)
  public void handleBeforeMeasure(int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    Object localObject;
    if (this.d)
    {
      i = paramInt2;
      if (Build.VERSION.SDK_INT >= 16)
      {
        i = paramInt2;
        if (this.b.getFitsSystemWindows())
        {
          localObject = new Rect();
          this.b.getWindowVisibleDisplayFrame((Rect)localObject);
          i = ((Rect)localObject).bottom - ((Rect)localObject).top;
        }
      }
    }
    Log.d("KPSRootLayoutHandler", "onMeasure, width: " + paramInt1 + " height: " + i);
    if (i < 0) {}
    do
    {
      return;
      if (this.a < 0)
      {
        this.a = i;
        return;
      }
      paramInt1 = this.a - i;
      if (paramInt1 == 0)
      {
        Log.d("KPSRootLayoutHandler", "" + paramInt1 + " == 0 break;");
        return;
      }
      if (Math.abs(paramInt1) == this.c)
      {
        Log.w("KPSRootLayoutHandler", String.format("offset just equal statusBar height %d", new Object[] { Integer.valueOf(paramInt1) }));
        return;
      }
      this.a = i;
      localObject = a(this.b);
      if (localObject == null)
      {
        Log.w("KPSRootLayoutHandler", "can't find the valid panel conflict layout, give up!");
        return;
      }
      if (Math.abs(paramInt1) < cn.dreamtobe.kpswitch.b.c.getMinKeyboardHeight(this.b.getContext()))
      {
        Log.w("KPSRootLayoutHandler", "system bottom-menu-bar(such as HuaWei Mate7) causes layout changed");
        return;
      }
      if (paramInt1 > 0)
      {
        ((a)localObject).handleHide();
        return;
      }
    } while ((!((a)localObject).isKeyboardShowing()) || (!((a)localObject).isVisible()));
    ((a)localObject).handleShow();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/dreamtobe/kpswitch/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */