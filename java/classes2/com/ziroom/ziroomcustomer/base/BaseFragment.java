package com.ziroom.ziroomcustomer.base;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.umeng.analytics.MobclickAgent;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.widget.LodingProgressDialog;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView.a;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

@Instrumented
public class BaseFragment
  extends Fragment
  implements ObservableScrollView.a
{
  private Message a;
  private Timer b;
  private int c = 0;
  private boolean d = false;
  private String e;
  private long f;
  private Map<String, String> g;
  private boolean h = true;
  private Handler i = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      }
      BaseFragment.this.showToast((String)paramAnonymousMessage.obj);
    }
  };
  
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
  
  protected String a()
  {
    return "";
  }
  
  protected void a(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    MobclickAgent.onEvent(paramContext, paramString);
  }
  
  protected void a(String paramString)
  {
    this.d = true;
    this.e = paramString;
  }
  
  protected void a(String paramString, Map<String, String> paramMap)
  {
    this.d = true;
    this.e = paramString;
    this.g = paramMap;
  }
  
  protected String b()
  {
    return b.getCurrentCity().getCode();
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
      LayoutInflater.from(getActivity());
      int k = paramViewGroup.getChildCount();
      int j = 0;
      while (j < k)
      {
        paramViewGroup.getChildAt(j).setVisibility(0);
        j += 1;
      }
    }
  }
  
  public void dismissProgress()
  {
    if (LodingProgressDialog.getDialog() != null) {
      LodingProgressDialog.dismiss();
    }
    if (this.b != null)
    {
      this.b.cancel();
      this.b.purge();
    }
    this.b = null;
  }
  
  public boolean isStateEnable()
  {
    return this.h;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.h = true;
  }
  
  public void onDestroy()
  {
    dismissProgress();
    com.freelxl.baselibrary.d.a.cancel(this);
    super.onDestroy();
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    VdsAgent.onFragmentHiddenChanged(this, paramBoolean);
  }
  
  public void onPause()
  {
    VdsAgent.onFragmentPause(this);
    super.onPause();
    if (this.d)
    {
      long l = (System.currentTimeMillis() - this.f) / 1000L;
      if (this.g == null) {
        this.g = new HashMap();
      }
      try
      {
        if (this.g.size() == 0)
        {
          if ((ApplicationEx.c.getUser() == null) || (TextUtils.isEmpty(ApplicationEx.c.getUser().getUid()))) {
            break label145;
          }
          this.g.put("uid", ApplicationEx.c.getUser().getUid());
        }
        while ((!TextUtils.isEmpty(this.e)) && (this.f > 0L) && (l > 0L))
        {
          MobclickAgent.onEventValue(ApplicationEx.c, this.e, this.g, (int)l);
          return;
          label145:
          SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
          this.g.put("uid", "Guest-" + localSimpleDateFormat.format(new Date()));
        }
        return;
      }
      catch (Exception localException) {}
    }
  }
  
  public void onResume()
  {
    VdsAgent.onFragmentResume(this);
    super.onResume();
    this.h = true;
    onVisibilityChangedToUser(getUserVisibleHint());
    if (this.d) {
      this.f = System.currentTimeMillis();
    }
    try
    {
      com.ziroom.ziroomcustomer.a.a.onPageEvent(getClass().getName(), a(), b());
      return;
    }
    catch (Exception localException) {}
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    this.h = false;
  }
  
  public void onScroll(int paramInt1, int paramInt2)
  {
    this.c = paramInt2;
  }
  
  public void onStart()
  {
    super.onStart();
    this.h = true;
  }
  
  public void onStop()
  {
    super.onStop();
    this.h = false;
  }
  
  public void onVisibilityChangedToUser(boolean paramBoolean) {}
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    VdsAgent.setFragmentUserVisibleHint(this, paramBoolean);
    super.setUserVisibleHint(paramBoolean);
    onVisibilityChangedToUser(getUserVisibleHint());
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
    localObject = LayoutInflater.from(ApplicationEx.c);
    int k = paramViewGroup.getChildCount();
    int j = 0;
    while (j < k)
    {
      paramViewGroup.getChildAt(j).setVisibility(8);
      j += 1;
    }
    ((TextView)((LayoutInflater)localObject).inflate(2130904002, paramViewGroup, true).findViewById(2131690822)).setText(paramString);
  }
  
  public void showHandleToast(String paramString)
  {
    this.a = this.i.obtainMessage();
    if (this.a == null) {
      this.a = new Message();
    }
    this.a.what = 1;
    this.a.obj = paramString;
    this.i.sendMessage(this.a);
  }
  
  public boolean showProgress(String paramString)
  {
    if ((LodingProgressDialog.getDialog() != null) && (LodingProgressDialog.isShowing())) {
      return false;
    }
    LodingProgressDialog.show(getActivity(), paramString, false, true);
    this.b = new Timer();
    this.b.schedule(new a(), 30000L);
    return true;
  }
  
  public void showToast(String paramString)
  {
    if (getActivity() == null) {
      return;
    }
    if (ae.notNull(paramString))
    {
      g.textToast(getActivity(), paramString);
      return;
    }
    Message localMessage = this.i.obtainMessage();
    localMessage.what = 1;
    localMessage.obj = paramString;
    this.i.sendMessage(localMessage);
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
      if (BaseFragment.a(BaseFragment.this) != null) {
        BaseFragment.this.showHandleToast("网络超时");
      }
      BaseFragment.a(BaseFragment.this, null);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/base/BaseFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */