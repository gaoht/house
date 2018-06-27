package com.ziroom.threelib.ziroomshare;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;
import com.growingio.android.sdk.agent.VdsAgent;
import java.util.Timer;
import java.util.TimerTask;

public class a
  extends Dialog
{
  private Context a;
  private ProgressDialog b;
  private Timer c;
  private Handler d = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      case 1: 
        a.this.showToast((String)paramAnonymousMessage.obj);
        Log.d("############", "handler showTOast");
        return;
      }
      a.this.showProgress((String)paramAnonymousMessage.obj);
    }
  };
  private a e;
  
  public a(Context paramContext)
  {
    super(paramContext);
    this.a = paramContext;
  }
  
  public a(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    this.a = paramContext;
  }
  
  public static void showInputMethod(Context paramContext, View paramView)
  {
    ((InputMethodManager)paramContext.getSystemService("input_method")).showSoftInput(paramView, 0);
  }
  
  public void dismissProgress()
  {
    if (this.b != null) {
      this.b.dismiss();
    }
    if (this.c != null)
    {
      this.c.cancel();
      this.c.purge();
      this.c = null;
    }
  }
  
  public a getMyListener()
  {
    return this.e;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setCanceledOnTouchOutside(true);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 0) && (getCurrentFocus() != null) && (getCurrentFocus().getWindowToken() != null))
    {
      paramMotionEvent = getContext();
      getContext();
      return ((InputMethodManager)paramMotionEvent.getSystemService("input_method")).hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setMyListener(a parama)
  {
    this.e = parama;
  }
  
  public void showHandleProgress(String paramString)
  {
    Message localMessage = new Message();
    localMessage.what = 2;
    localMessage.obj = paramString;
    this.d.sendMessage(localMessage);
  }
  
  public void showHandleToast(String paramString)
  {
    Log.d("############", "showHandleToast被调用了");
    Message localMessage = new Message();
    localMessage.what = 1;
    localMessage.obj = paramString;
    this.d.sendMessage(localMessage);
  }
  
  public boolean showProgress(String paramString)
  {
    if ((this.b != null) && (this.b.isShowing())) {
      return false;
    }
    this.b = new ProgressDialog(this.a);
    this.b.setMessage(paramString);
    paramString = this.b;
    if (!(paramString instanceof ProgressDialog)) {
      paramString.show();
    }
    for (;;)
    {
      this.c = new Timer();
      this.c.schedule(new b(), 20000L);
      return true;
      VdsAgent.showDialog((ProgressDialog)paramString);
    }
  }
  
  public void showToast(String paramString)
  {
    Log.d("############", "==BaseDialog==showTpast被调用了=");
    if (!TextUtils.isEmpty(paramString))
    {
      if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
        Toast.makeText(getContext().getApplicationContext(), paramString, 0);
      }
    }
    else {
      return;
    }
    Message localMessage = this.d.obtainMessage();
    localMessage.what = 1;
    localMessage.obj = paramString;
    this.d.sendMessage(localMessage);
  }
  
  public static abstract interface a
  {
    public abstract void refreshActivity(Object paramObject);
  }
  
  public class b
    extends TimerTask
  {
    public b() {}
    
    public void run()
    {
      if (a.a(a.this) != null) {
        a.a(a.this).dismiss();
      }
      if (a.b(a.this) != null) {
        a.this.showHandleToast("网络超时");
      }
      a.a(a.this, null);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/threelib/ziroomshare/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */