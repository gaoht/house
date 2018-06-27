package com.ziroom.commonlib.utils;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.growingio.android.sdk.agent.VdsAgent;

public class s
{
  private static Toast a;
  
  public static void cancel()
  {
    if (a != null)
    {
      a.cancel();
      a = null;
    }
  }
  
  public static void showToast(int paramInt)
  {
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      showToast(paramInt, 1);
      return;
    }
    new Handler(d.a.getMainLooper()).post(new Runnable()
    {
      public void run()
      {
        s.showToast(this.a, 1);
      }
    });
  }
  
  public static void showToast(int paramInt1, int paramInt2)
  {
    
    if (a == null) {
      a = Toast.makeText(d.a.getApplicationContext(), paramInt1, paramInt2);
    }
    Toast localToast;
    for (;;)
    {
      localToast = a;
      if ((localToast instanceof Toast)) {
        break;
      }
      localToast.show();
      return;
      a.setText(paramInt1);
      a.setDuration(paramInt2);
    }
    VdsAgent.showToast((Toast)localToast);
  }
  
  public static void showToast(int paramInt1, final String paramString, final int paramInt2)
  {
    Object localObject;
    if (!r.isEmpty(paramString))
    {
      cancel();
      if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
        break label152;
      }
      if (a == null) {
        a = new Toast(d.a.getApplicationContext());
      }
      a.setGravity(17, 0, 0);
      localObject = a.getView();
      ImageView localImageView = new ImageView(d.a.getApplicationContext());
      localImageView.setImageResource(paramInt1);
      LinearLayout localLinearLayout = new LinearLayout(d.a.getApplicationContext());
      localLinearLayout.addView(localImageView);
      localLinearLayout.addView((View)localObject);
      a.setView(localLinearLayout);
      localObject = a;
      if ((localObject instanceof Toast)) {
        break label142;
      }
      ((Toast)localObject).show();
    }
    for (;;)
    {
      showToast(String.valueOf(paramString), paramInt2);
      return;
      label142:
      VdsAgent.showToast((Toast)localObject);
    }
    label152:
    new Handler(d.a.getMainLooper()).post(new Runnable()
    {
      public void run()
      {
        if (s.a() == null) {
          s.a(new Toast(d.a.getApplicationContext()));
        }
        s.a().setGravity(17, 0, 0);
        Object localObject = s.a().getView();
        ImageView localImageView = new ImageView(d.a.getApplicationContext());
        localImageView.setImageResource(this.a);
        LinearLayout localLinearLayout = new LinearLayout(d.a.getApplicationContext());
        localLinearLayout.addView(localImageView);
        localLinearLayout.addView((View)localObject);
        s.a().setView(localLinearLayout);
        localObject = s.a();
        if (!(localObject instanceof Toast)) {
          ((Toast)localObject).show();
        }
        for (;;)
        {
          s.showToast(String.valueOf(paramString), paramInt2);
          return;
          VdsAgent.showToast((Toast)localObject);
        }
      }
    });
  }
  
  public static void showToast(String paramString)
  {
    if (r.isEmpty(paramString)) {
      return;
    }
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      showToast(paramString, 1);
      return;
    }
    new Handler(d.a.getMainLooper()).post(new Runnable()
    {
      public void run()
      {
        s.showToast(this.a, 1);
      }
    });
  }
  
  public static void showToast(String paramString, int paramInt)
  {
    if (r.isEmpty(paramString)) {
      return;
    }
    cancel();
    if (a == null) {
      a = Toast.makeText(d.a.getApplicationContext(), paramString, paramInt);
    }
    for (;;)
    {
      paramString = a;
      if ((paramString instanceof Toast)) {
        break;
      }
      paramString.show();
      return;
      a.setText(paramString);
      a.setDuration(paramInt);
    }
    VdsAgent.showToast((Toast)paramString);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/commonlib/utils/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */