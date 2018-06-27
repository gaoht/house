package com.ziroom.ziroomcustomer.util;

import android.app.Activity;
import android.app.Application;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;

public class p
{
  public static void showGuide(final Activity paramActivity, String paramString, int paramInt1, int paramInt2, View.OnClickListener paramOnClickListener, a parama)
  {
    if ((paramActivity == null) || (paramActivity.isFinishing())) {}
    SharedPreferences localSharedPreferences;
    final ViewGroup localViewGroup;
    do
    {
      do
      {
        return;
        localSharedPreferences = paramActivity.getApplication().getSharedPreferences("app_guide", 0);
      } while (localSharedPreferences.getBoolean(paramString, false));
      localViewGroup = (ViewGroup)paramActivity.getWindow().getDecorView().findViewById(16908290);
    } while (localViewGroup == null);
    paramActivity = LayoutInflater.from(paramActivity).inflate(paramInt1, localViewGroup, false);
    if (paramActivity != null)
    {
      if (paramInt2 == -1) {
        break label151;
      }
      View localView = paramActivity.findViewById(paramInt2);
      if (localView != null) {
        localView.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            if (this.a != null) {
              this.a.onClick(paramAnonymousView);
            }
            localViewGroup.removeView(paramActivity);
          }
        });
      }
    }
    for (;;)
    {
      if (parama != null) {
        parama.updateView(paramActivity);
      }
      localViewGroup.addView(paramActivity);
      paramActivity = localSharedPreferences.edit();
      paramActivity.putBoolean(paramString, true);
      paramActivity.apply();
      return;
      label151:
      paramActivity.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if (this.a != null) {
            this.a.onClick(paramAnonymousView);
          }
          localViewGroup.removeView(paramActivity);
        }
      });
    }
  }
  
  public static void showGuide(Activity paramActivity, String paramString, int paramInt, View.OnClickListener paramOnClickListener, a parama)
  {
    showGuide(paramActivity, paramString, paramInt, -1, paramOnClickListener, parama);
  }
  
  public static abstract interface a
  {
    public abstract void updateView(View paramView);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/util/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */