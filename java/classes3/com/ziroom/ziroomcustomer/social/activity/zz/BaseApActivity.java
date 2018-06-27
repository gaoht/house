package com.ziroom.ziroomcustomer.social.activity.zz;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.umeng.analytics.MobclickAgent;
import com.ziroom.commonlib.utils.h;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.signed.s;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.util.w;
import com.ziroom.ziroomcustomer.widget.LodingProgressDialog;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class BaseApActivity
  extends FragmentActivity
{
  public final int a = 256;
  public final int b = 257;
  public final int c = 258;
  public final int d = 512;
  public final int e = 513;
  public final int f = 514;
  public final int g = 515;
  public final int h = 516;
  protected NotificationManager i;
  public Handler j = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      case 1: 
        BaseApActivity.this.showToast((String)paramAnonymousMessage.obj);
        return;
      case 2: 
        BaseApActivity.this.showProgress((String)paramAnonymousMessage.obj);
        return;
      }
      BaseApActivity.this.dismissProgress();
    }
  };
  private Timer k;
  private boolean l = false;
  private String m;
  private long n;
  private Map<String, String> o;
  private RelativeLayout p;
  private int q;
  private int r;
  private boolean s;
  private int t;
  private int u;
  private ImageView v;
  
  private View a(int paramInt)
  {
    View localView = LayoutInflater.from(this).inflate(paramInt, this.p, true);
    this.v = ((ImageView)localView.findViewById(2131689948));
    TextView localTextView = (TextView)localView.findViewById(2131689949);
    this.v.setVisibility(8);
    localTextView.setVisibility(8);
    if (h.getsEnvironment() == 2) {
      localTextView.setText("T");
    }
    while (this.v == null)
    {
      return localView;
      if (h.getsEnvironment() == 3) {
        localTextView.setText("Q");
      } else if (h.getsEnvironment() == 1) {
        localTextView.setText("D");
      } else {
        localTextView.setText("R");
      }
    }
    this.v.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
      }
    });
    this.v.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        int n = 0;
        int i = paramAnonymousMotionEvent.getAction();
        u.i("@@@@@@", "Touch:" + i);
        switch (i)
        {
        case 1: 
        default: 
        case 0: 
          for (;;)
          {
            return BaseApActivity.e(BaseApActivity.this);
            BaseApActivity.a(BaseApActivity.this, false);
            BaseApActivity.a(BaseApActivity.this, (int)paramAnonymousMotionEvent.getRawX());
            BaseApActivity.b(BaseApActivity.this, (int)paramAnonymousMotionEvent.getRawY());
          }
        }
        i = (int)paramAnonymousMotionEvent.getRawX() - BaseApActivity.a(BaseApActivity.this);
        int i2 = (int)paramAnonymousMotionEvent.getRawY() - BaseApActivity.b(BaseApActivity.this);
        if ((i > 0) || (i2 > 0)) {
          BaseApActivity.a(BaseApActivity.this, true);
        }
        int k = paramAnonymousView.getLeft() + i;
        int i1 = paramAnonymousView.getTop() + i2;
        i += paramAnonymousView.getRight();
        int i3 = paramAnonymousView.getBottom();
        int j = k;
        if (k < 0)
        {
          i = paramAnonymousView.getWidth() + 0;
          j = 0;
        }
        if (i > BaseApActivity.c(BaseApActivity.this)) {
          k = BaseApActivity.c(BaseApActivity.this);
        }
        for (int m = k - paramAnonymousView.getWidth();; m = j)
        {
          if (i1 < 0) {
            i = paramAnonymousView.getHeight() + 0;
          }
          for (j = n;; j = i1)
          {
            n = i;
            if (i > BaseApActivity.d(BaseApActivity.this))
            {
              n = BaseApActivity.d(BaseApActivity.this);
              j = n - paramAnonymousView.getHeight();
            }
            paramAnonymousView.layout(m, j, k, n);
            u.i("@@@@@@", "position��" + m + ", " + j + ", " + k + ", " + n);
            BaseApActivity.a(BaseApActivity.this, (int)paramAnonymousMotionEvent.getRawX());
            BaseApActivity.b(BaseApActivity.this, (int)paramAnonymousMotionEvent.getRawY());
            break;
            i = i2 + i3;
          }
          k = i;
        }
      }
    });
    return localView;
  }
  
  public static boolean checkNet(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext != null)
    {
      paramContext = paramContext.getActiveNetworkInfo();
      if ((paramContext != null) && (paramContext.isConnected()) && (paramContext.getState() == NetworkInfo.State.CONNECTED)) {
        return true;
      }
    }
    return false;
  }
  
  public void closeEmpty(ViewGroup paramViewGroup)
  {
    if (paramViewGroup == null) {}
    for (;;)
    {
      return;
      View localView = paramViewGroup.findViewById(2131694408);
      if (localView != null) {
        paramViewGroup.removeView(localView);
      }
      LayoutInflater.from(this);
      int i2 = paramViewGroup.getChildCount();
      int i1 = 0;
      while (i1 < i2)
      {
        localView = paramViewGroup.getChildAt(i1);
        if (!"humanControlled".equals(localView.getTag())) {
          localView.setVisibility(0);
        }
        i1 += 1;
      }
    }
  }
  
  public void dismissHandleProgress()
  {
    Message localMessage = new Message();
    localMessage.what = 3;
    this.j.sendMessage(localMessage);
  }
  
  public void dismissProgress()
  {
    if (LodingProgressDialog.getDialog() != null) {
      LodingProgressDialog.dismiss();
    }
    if (this.k != null)
    {
      this.k.cancel();
      this.k.purge();
      this.k = null;
    }
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(2130968682, 2130968683);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    requestWindowFeature(1);
    super.onCreate(paramBundle);
    getWindow().setSoftInputMode(3);
    setRequestedOrientation(1);
    this.i = ((NotificationManager)getSystemService("notification"));
    if ((ApplicationEx.c.isLoginState()) && (ApplicationEx.c.getContracts() != null) && (ApplicationEx.c.getContracts().size() > 0) && (ApplicationEx.g == 1)) {
      new s(this).showDialog();
    }
    this.p = new RelativeLayout(this);
    paramBundle = getResources().getDisplayMetrics();
    this.t = paramBundle.widthPixels;
    this.u = (paramBundle.heightPixels - 50);
  }
  
  protected void onDestroy()
  {
    com.freelxl.baselibrary.d.a.cancel(this);
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    default: 
      return super.onKeyDown(paramInt, paramKeyEvent);
    }
    return true;
  }
  
  protected void onPause()
  {
    super.onPause();
    w.onPause(this);
    if (this.l)
    {
      long l1 = (System.currentTimeMillis() - this.n) / 1000L;
      if (this.o == null) {
        this.o = new HashMap();
      }
      try
      {
        if (this.o.size() == 0)
        {
          if ((ApplicationEx.c.getUser() == null) || (TextUtils.isEmpty(ApplicationEx.c.getUser().getUid()))) {
            break label146;
          }
          this.o.put("uid", ApplicationEx.c.getUser().getUid());
        }
        while ((!TextUtils.isEmpty(this.m)) && (this.n > 0L) && (l1 > 0L))
        {
          MobclickAgent.onEventValue(ApplicationEx.c, this.m, this.o, (int)l1);
          return;
          label146:
          SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
          this.o.put("uid", "Guest-" + localSimpleDateFormat.format(new Date()));
        }
        return;
      }
      catch (Exception localException) {}
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    w.onResume(this);
    if (this.l) {
      this.n = System.currentTimeMillis();
    }
  }
  
  protected void onStop()
  {
    super.onStop();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 0) && (getCurrentFocus() != null) && (getCurrentFocus().getWindowToken() != null)) {
      return ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setContentView(int paramInt)
  {
    LayoutInflater.from(this).inflate(paramInt, this.p, true);
    super.setContentView(a(2130903101));
  }
  
  public void setContentView(View paramView)
  {
    this.p.addView(paramView);
    super.setContentView(a(2130903101));
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    this.p.addView(paramView, paramLayoutParams);
    super.setContentView(a(2130903101), paramLayoutParams);
  }
  
  public void showBtnTip(String paramString)
  {
    com.ziroom.ziroomcustomer.dialog.a locala = new com.ziroom.ziroomcustomer.dialog.a(this, 2131427591);
    locala.setMessage(paramString);
    locala.showOK();
    locala.show();
  }
  
  public void showEmpty(ViewGroup paramViewGroup, String paramString)
  {
    if (paramViewGroup == null) {
      return;
    }
    Object localObject = paramViewGroup.findViewById(2131694408);
    if (localObject != null) {
      paramViewGroup.removeView((View)localObject);
    }
    localObject = LayoutInflater.from(this);
    int i2 = paramViewGroup.getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      paramViewGroup.getChildAt(i1).setVisibility(8);
      i1 += 1;
    }
    ((TextView)((LayoutInflater)localObject).inflate(2130904002, paramViewGroup, true).findViewById(2131690822)).setText(paramString);
  }
  
  public View showEmptyView(ViewGroup paramViewGroup, String paramString)
  {
    if (paramViewGroup == null) {
      return null;
    }
    Object localObject = paramViewGroup.findViewById(2131694408);
    if (localObject != null) {
      paramViewGroup.removeView((View)localObject);
    }
    localObject = LayoutInflater.from(this);
    int i2 = paramViewGroup.getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      paramViewGroup.getChildAt(i1).setVisibility(8);
      i1 += 1;
    }
    paramViewGroup = ((LayoutInflater)localObject).inflate(2130904002, paramViewGroup, true);
    ((TextView)paramViewGroup.findViewById(2131690822)).setText(paramString);
    return paramViewGroup;
  }
  
  public void showHandleProgress(String paramString)
  {
    Message localMessage = new Message();
    localMessage.what = 2;
    localMessage.obj = paramString;
    this.j.sendMessage(localMessage);
  }
  
  public void showHandleToast(String paramString)
  {
    Message localMessage = new Message();
    localMessage.what = 1;
    localMessage.obj = paramString;
    this.j.sendMessage(localMessage);
  }
  
  public boolean showProgress(String paramString)
  {
    if ((LodingProgressDialog.getDialog() != null) && (LodingProgressDialog.isShowing())) {
      return false;
    }
    LodingProgressDialog.show(this, paramString, true, true);
    this.k = new Timer();
    this.k.schedule(new b(), 30000L);
    return true;
  }
  
  public boolean showProgress(String paramString, long paramLong)
  {
    if ((LodingProgressDialog.getDialog() != null) && (LodingProgressDialog.isShowing())) {
      return false;
    }
    LodingProgressDialog.show(this, paramString, true, true);
    this.k = new Timer();
    this.k.schedule(new b(), paramLong);
    return true;
  }
  
  public boolean showProgressNoCancel(String paramString, long paramLong)
  {
    if ((LodingProgressDialog.getDialog() != null) && (LodingProgressDialog.isShowing())) {
      return false;
    }
    LodingProgressDialog.show(this, paramString, false, true);
    this.k = new Timer();
    this.k.schedule(new a(), paramLong);
    return true;
  }
  
  public void showTip(String paramString)
  {
    com.ziroom.ziroomcustomer.dialog.a locala = new com.ziroom.ziroomcustomer.dialog.a(this, 2131427591);
    locala.setMessage(paramString);
    locala.showClose();
    locala.show();
  }
  
  public void showToast(String paramString)
  {
    if (ae.notNull(paramString))
    {
      if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
        g.textToast(this, paramString);
      }
    }
    else {
      return;
    }
    Message localMessage = this.j.obtainMessage();
    localMessage.what = 1;
    localMessage.obj = paramString;
    this.j.sendMessage(localMessage);
  }
  
  public void startActivity(Intent paramIntent)
  {
    super.startActivity(paramIntent);
    overridePendingTransition(2130968684, 2130968685);
  }
  
  public void startActivityAndFinish(Intent paramIntent)
  {
    startActivity(paramIntent);
    super.finish();
  }
  
  public void startActivityByOrigin(Intent paramIntent)
  {
    super.startActivity(paramIntent);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    super.startActivityForResult(paramIntent, paramInt);
    overridePendingTransition(2130968684, 2130968685);
  }
  
  public class a
    extends TimerTask
  {
    public a() {}
    
    public void run()
    {
      if (LodingProgressDialog.getDialog() != null) {
        LodingProgressDialog.dismiss();
      }
      if (BaseApActivity.f(BaseApActivity.this) != null) {
        BaseApActivity.this.showHandleToast("");
      }
      BaseApActivity.a(BaseApActivity.this, null);
    }
  }
  
  public class b
    extends TimerTask
  {
    public b() {}
    
    public void run()
    {
      if (LodingProgressDialog.getDialog() != null) {
        LodingProgressDialog.dismiss();
      }
      if (BaseApActivity.f(BaseApActivity.this) != null) {
        BaseApActivity.this.showHandleToast("网络超时");
      }
      BaseApActivity.a(BaseApActivity.this, null);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/social/activity/zz/BaseApActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */