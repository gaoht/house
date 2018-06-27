package cn.dreamtobe.kpswitch.b;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;

public class a
{
  private static void a(a parama, final a[] paramArrayOfa, final View paramView1, View paramView2, final b paramb)
  {
    parama.b.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        paramAnonymousView = null;
        if (this.a.getVisibility() == 0) {
          if (this.b.getVisibility() == 0)
          {
            a.showKeyboard(this.a, paramView1);
            paramAnonymousView = Boolean.valueOf(false);
          }
        }
        for (;;)
        {
          if ((paramb != null) && (paramAnonymousView != null)) {
            paramb.onClickSwitch(paramAnonymousView.booleanValue());
          }
          return;
          a.a(this.b, paramArrayOfa);
          continue;
          a.showPanel(this.a);
          paramAnonymousView = Boolean.valueOf(true);
          a.a(this.b, paramArrayOfa);
        }
      }
    });
  }
  
  static boolean a(Activity paramActivity)
  {
    return isHandleByPlaceholder(e.isFullScreen(paramActivity), e.isTranslucentStatus(paramActivity), e.a(paramActivity));
  }
  
  public static void attach(View paramView1, View paramView2, View paramView3)
  {
    attach(paramView1, paramView2, paramView3, null);
  }
  
  public static void attach(View paramView1, View paramView2, final View paramView3, final b paramb)
  {
    Activity localActivity = (Activity)paramView1.getContext();
    if (paramView2 != null) {
      paramView2.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          boolean bool = a.switchPanelAndKeyboard(this.a, paramView3);
          if (paramb != null) {
            paramb.onClickSwitch(bool);
          }
        }
      });
    }
    if (a(localActivity)) {
      paramView3.setOnTouchListener(new View.OnTouchListener()
      {
        public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          if (paramAnonymousMotionEvent.getAction() == 1) {
            this.a.setVisibility(4);
          }
          return false;
        }
      });
    }
  }
  
  public static void attach(View paramView1, View paramView2, b paramb, a... paramVarArgs)
  {
    Activity localActivity = (Activity)paramView1.getContext();
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      a(paramVarArgs[i], paramVarArgs, paramView2, paramView1, paramb);
      i += 1;
    }
    if (a(localActivity)) {
      paramView2.setOnTouchListener(new View.OnTouchListener()
      {
        public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          if (paramAnonymousMotionEvent.getAction() == 1) {
            this.a.setVisibility(4);
          }
          return false;
        }
      });
    }
  }
  
  public static void attach(View paramView1, View paramView2, a... paramVarArgs)
  {
    attach(paramView1, paramView2, null, paramVarArgs);
  }
  
  private static void b(View paramView, a[] paramArrayOfa)
  {
    int j = paramArrayOfa.length;
    int i = 0;
    while (i < j)
    {
      a locala = paramArrayOfa[i];
      if (locala.a != paramView) {
        locala.a.setVisibility(8);
      }
      i += 1;
    }
    paramView.setVisibility(0);
  }
  
  public static void hidePanelAndKeyboard(View paramView)
  {
    Activity localActivity = (Activity)paramView.getContext();
    View localView = localActivity.getCurrentFocus();
    if (localView != null)
    {
      c.hideKeyboard(localActivity.getCurrentFocus());
      localView.clearFocus();
    }
    paramView.setVisibility(8);
  }
  
  public static boolean isHandleByPlaceholder(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    return (paramBoolean1) || ((paramBoolean2) && (!paramBoolean3));
  }
  
  public static void showKeyboard(View paramView1, View paramView2)
  {
    Activity localActivity = (Activity)paramView1.getContext();
    c.showKeyboard(paramView2);
    if (a(localActivity)) {
      paramView1.setVisibility(4);
    }
  }
  
  public static void showPanel(View paramView)
  {
    Activity localActivity = (Activity)paramView.getContext();
    paramView.setVisibility(0);
    if (localActivity.getCurrentFocus() != null) {
      c.hideKeyboard(localActivity.getCurrentFocus());
    }
  }
  
  public static boolean switchPanelAndKeyboard(View paramView1, View paramView2)
  {
    if (paramView1.getVisibility() != 0) {}
    for (boolean bool = true; !bool; bool = false)
    {
      showKeyboard(paramView1, paramView2);
      return bool;
    }
    showPanel(paramView1);
    return bool;
  }
  
  public static class a
  {
    final View a;
    final View b;
    
    public a(View paramView1, View paramView2)
    {
      this.a = paramView1;
      this.b = paramView2;
    }
  }
  
  public static abstract interface b
  {
    public abstract void onClickSwitch(boolean paramBoolean);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/dreamtobe/kpswitch/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */