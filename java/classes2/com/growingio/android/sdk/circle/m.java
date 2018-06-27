package com.growingio.android.sdk.circle;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;
import com.growingio.android.sdk.collection.MessageProcessor;
import com.growingio.android.sdk.models.a;
import com.growingio.android.sdk.models.b;
import com.growingio.android.sdk.utils.ThreadUtils;
import com.growingio.android.sdk.utils.Util;
import java.util.Collections;

public class m
  extends f
{
  private static int h = 0;
  private float a;
  private float b;
  private float c;
  private int d;
  private TextView e;
  private WindowManager f;
  private Animation g;
  
  public m(Context paramContext)
  {
    super(paramContext);
    c();
  }
  
  @SuppressLint({"SetTextI18n"})
  private void c()
  {
    this.e = new TextView(getContext());
    this.e.setText("Web端圈选中…");
    this.e.setGravity(17);
    this.e.setTextSize(2, 15.0F);
    int i = Util.a(getContext(), 4.0F);
    this.e.setPadding(i, i, i, i);
    this.e.setTextColor(-1);
    this.g = new AlphaAnimation(0.0F, 1.0F);
    this.g.setDuration(720L);
    this.g.setRepeatCount(-1);
    this.g.setRepeatMode(2);
    addView(this.e, new ViewGroup.LayoutParams(-1, -2));
    setBackgroundColor(-15094626);
    this.f = ((WindowManager)getContext().getApplicationContext().getSystemService("window"));
    this.d = Util.a(getContext(), 10.0F);
    setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        new AlertDialog.Builder(m.this.getContext()).setTitle("圈选").setMessage("Web端圈选中").setPositiveButton("退出圈选", new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            paramAnonymous2DialogInterface.dismiss();
            m.a(m.this).k();
            m.a(m.this).m();
          }
        }).setNegativeButton("继续圈选", null).create().show();
        ThreadUtils.a(new Runnable()
        {
          public void run()
          {
            m.b(m.this);
            MessageProcessor.e().a(true);
          }
        }, 300L);
      }
    });
  }
  
  private void d()
  {
    b localb = new b();
    localb.a = "GioWindow/FloatViewContainer[0]/TextView[0]";
    localb.b = System.currentTimeMillis();
    localb.d = this.e.getText().toString();
    a locala = a.e();
    locala.f = "GIOActivity";
    locala.b = localb.b;
    locala.a = Collections.singletonList(localb);
    MessageProcessor.e().a(locala);
  }
  
  private c getCircleManager()
  {
    return c.e();
  }
  
  @SuppressLint({"RtlHardcoded"})
  public void a()
  {
    if (getParent() != null)
    {
      setVisibility(0);
      this.e.startAnimation(this.g);
      setKeepScreenOn(true);
      return;
    }
    Activity localActivity = getCircleManager().d();
    WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams(i.b(), -2, c.a, 296, -3);
    localLayoutParams.gravity = 51;
    if (h == 0) {}
    for (localLayoutParams.y = getStatusBarHeight();; localLayoutParams.y = h)
    {
      ((WindowManager)localActivity.getApplication().getSystemService("window")).addView(this, localLayoutParams);
      break;
    }
  }
  
  public void b()
  {
    this.f.removeView(this);
    setKeepScreenOn(false);
  }
  
  public int getStatusBarHeight()
  {
    int i = 0;
    int j = getResources().getIdentifier("status_bar_height", "dimen", "android");
    if (j > 0) {
      i = getResources().getDimensionPixelSize(j);
    }
    return i;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      do
      {
        return false;
        this.c = paramMotionEvent.getRawY();
        this.b = this.c;
        this.a = paramMotionEvent.getY();
        return false;
        this.b = paramMotionEvent.getRawY();
      } while (Math.abs(this.b - this.c) < this.d);
      paramMotionEvent = (WindowManager.LayoutParams)getLayoutParams();
      paramMotionEvent.y = ((int)(this.b - this.a));
      this.f.updateViewLayout(this, paramMotionEvent);
      return true;
      h = (int)this.b;
    } while (Math.abs(this.b - this.c) >= this.d);
    performClick();
    return false;
  }
  
  public void setContent(String paramString)
  {
    this.e.setText(paramString);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/growingio/android/sdk/circle/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */