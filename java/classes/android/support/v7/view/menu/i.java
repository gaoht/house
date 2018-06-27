package android.support.v7.view.menu;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.os.IBinder;
import android.support.v7.app.c;
import android.support.v7.app.c.a;
import android.support.v7.appcompat.R.layout;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.ListAdapter;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;

class i
  implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener, DialogInterface.OnKeyListener, n.a
{
  f a;
  private h b;
  private c c;
  private n.a d;
  
  public i(h paramh)
  {
    this.b = paramh;
  }
  
  public void dismiss()
  {
    if (this.c != null) {
      this.c.dismiss();
    }
  }
  
  @Instrumented
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    VdsAgent.onClick(this, paramDialogInterface, paramInt);
    this.b.performItemAction((j)this.a.getAdapter().getItem(paramInt), 0);
  }
  
  public void onCloseMenu(h paramh, boolean paramBoolean)
  {
    if ((paramBoolean) || (paramh == this.b)) {
      dismiss();
    }
    if (this.d != null) {
      this.d.onCloseMenu(paramh, paramBoolean);
    }
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.onCloseMenu(this.b, true);
  }
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 82) || (paramInt == 4)) {
      if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getRepeatCount() == 0))
      {
        paramDialogInterface = this.c.getWindow();
        if (paramDialogInterface != null)
        {
          paramDialogInterface = paramDialogInterface.getDecorView();
          if (paramDialogInterface != null)
          {
            paramDialogInterface = paramDialogInterface.getKeyDispatcherState();
            if (paramDialogInterface != null)
            {
              paramDialogInterface.startTracking(paramKeyEvent, this);
              return true;
            }
          }
        }
      }
      else if ((paramKeyEvent.getAction() == 1) && (!paramKeyEvent.isCanceled()))
      {
        Object localObject = this.c.getWindow();
        if (localObject != null)
        {
          localObject = ((Window)localObject).getDecorView();
          if (localObject != null)
          {
            localObject = ((View)localObject).getKeyDispatcherState();
            if ((localObject != null) && (((KeyEvent.DispatcherState)localObject).isTracking(paramKeyEvent)))
            {
              this.b.close(true);
              paramDialogInterface.dismiss();
              return true;
            }
          }
        }
      }
    }
    return this.b.performShortcut(paramInt, paramKeyEvent, 0);
  }
  
  public boolean onOpenSubMenu(h paramh)
  {
    if (this.d != null) {
      return this.d.onOpenSubMenu(paramh);
    }
    return false;
  }
  
  public void setPresenterCallback(n.a parama)
  {
    this.d = parama;
  }
  
  public void show(IBinder paramIBinder)
  {
    Object localObject = this.b;
    c.a locala = new c.a(((h)localObject).getContext());
    this.a = new f(locala.getContext(), R.layout.abc_list_menu_item_layout);
    this.a.setCallback(this);
    this.b.addMenuPresenter(this.a);
    locala.setAdapter(this.a.getAdapter(), this);
    View localView = ((h)localObject).getHeaderView();
    if (localView != null) {
      locala.setCustomTitle(localView);
    }
    for (;;)
    {
      locala.setOnKeyListener(this);
      this.c = locala.create();
      this.c.setOnDismissListener(this);
      localObject = this.c.getWindow().getAttributes();
      ((WindowManager.LayoutParams)localObject).type = 1003;
      if (paramIBinder != null) {
        ((WindowManager.LayoutParams)localObject).token = paramIBinder;
      }
      ((WindowManager.LayoutParams)localObject).flags |= 0x20000;
      this.c.show();
      return;
      locala.setIcon(((h)localObject).getHeaderIcon()).setTitle(((h)localObject).getHeaderTitle());
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/view/menu/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */