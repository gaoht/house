package com.ziroom.ziroomcustomer.minsu.activity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import com.freelxl.baselibrary.f.g;
import com.freelxl.baselibrary.f.h;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.hyphenate.EMMessageListener;
import com.hyphenate.chat.EMChatManager;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMConversation;
import com.hyphenate.chat.EMConversation.EMConversationType;
import com.hyphenate.chat.EMMessage;
import com.ziroom.commonlibrary.login.LoginActivity;
import com.ziroom.ziroomcustomer.MainActivity;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.c.m;
import com.ziroom.ziroomcustomer.minsu.f.ab;
import com.ziroom.ziroomcustomer.minsu.f.k;
import com.ziroom.ziroomcustomer.minsu.f.l;
import com.ziroom.ziroomcustomer.minsu.f.r;
import com.ziroom.ziroomcustomer.minsu.f.s;
import com.ziroom.ziroomcustomer.minsu.landlord.model.RemarkItem;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.CertificationBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.CertificationBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.qualification.QApersonalActivity;
import com.ziroom.ziroomcustomer.service.f;
import com.ziroom.ziroomcustomer.util.ac;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.widget.BadgeView;
import com.ziroom.ziroomcustomer.widget.ScrollControlerViewPager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class MinsuLandLordMainActivity
  extends BaseActivity
  implements EMMessageListener
{
  public static MinsuLandLordMainActivity a;
  public static String b;
  public static String c;
  private LinearLayout A;
  private LinearLayout B;
  private boolean C = true;
  private ImageView D;
  private TextView E;
  private boolean F = false;
  private boolean G = false;
  private Handler H = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      super.handleMessage(paramAnonymousMessage);
      if ((MinsuLandLordMainActivity.i(MinsuLandLordMainActivity.this)) && (MinsuLandLordMainActivity.j(MinsuLandLordMainActivity.this)))
      {
        com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.e("huanxin", " 开始同步 环信");
        MinsuLandLordMainActivity.this.getUnReadMsgCount();
      }
    }
  };
  public BroadcastReceiver d = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      int i = paramAnonymousIntent.getIntExtra("type", 0);
      int j = paramAnonymousIntent.getIntExtra("status", 0);
      if (EMClient.getInstance().isLoggedInBefore()) {
        com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.e("huanxin", " 没有登陆 环信");
      }
      if ((i == 17) && (j == 1))
      {
        MinsuLandLordMainActivity.b(MinsuLandLordMainActivity.this, true);
        MinsuLandLordMainActivity.h(MinsuLandLordMainActivity.this).sendEmptyMessage(1);
      }
    }
  };
  public BroadcastReceiver e = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      MinsuLandLordMainActivity.c(MinsuLandLordMainActivity.this, true);
      MinsuLandLordMainActivity.h(MinsuLandLordMainActivity.this).sendEmptyMessage(1);
      com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.e("huanxin", " 登录 成功 了  ！ 登陆 环信");
    }
  };
  private Integer[] f;
  private RadioGroup g;
  private ScrollControlerViewPager r;
  private com.ziroom.ziroomcustomer.minsu.landlord.b.c s;
  private BadgeView t;
  private long u;
  private boolean v = false;
  private String w = "null";
  private int x;
  private int y = 0;
  private ImageView z;
  
  private void a()
  {
    this.f = new Integer[] { Integer.valueOf(2131694617), Integer.valueOf(2131694618), Integer.valueOf(2131694619), Integer.valueOf(2131694620) };
    this.t = ((BadgeView)findViewById(2131694621));
    this.z = ((ImageView)findViewById(2131690145));
    this.g = ((RadioGroup)findViewById(2131694616));
    this.r = ((ScrollControlerViewPager)findViewById(2131691141));
    this.A = ((LinearLayout)findViewById(2131691469));
    this.B = ((LinearLayout)findViewById(2131691471));
    this.D = ((ImageView)findViewById(2131691470));
    this.A.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        return true;
      }
    });
    this.D.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        com.ziroom.ziroomcustomer.util.ad.saveMinsuLandReleaseHint(MinsuLandLordMainActivity.this, Boolean.valueOf(false));
        MinsuLandLordMainActivity.a(MinsuLandLordMainActivity.this).setVisibility(8);
      }
    });
    int i = ac.getScreenWidth(this);
    this.E = ((TextView)findViewById(2131691472));
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, ab.dp2px(this, 48.0F));
    localLayoutParams.setMargins(ab.dp2px(this, 18.0F), (int)(i * 1.24D), ab.dp2px(this, 18.0F), 0);
    this.E.setLayoutParams(localLayoutParams);
    this.E.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        com.ziroom.ziroomcustomer.util.ad.saveMinsuLandReleaseHint(MinsuLandLordMainActivity.this, Boolean.valueOf(false));
        MinsuLandLordMainActivity.a(MinsuLandLordMainActivity.this).setVisibility(8);
        MinsuLandLordMainActivity.this.getCertification();
      }
    });
  }
  
  private void a(final int paramInt1, final int paramInt2, final int paramInt3)
  {
    new Handler(Looper.getMainLooper()).postDelayed(new Runnable()
    {
      public void run()
      {
        if (paramInt2 + paramInt3 < 1)
        {
          if (paramInt1 > 0) {
            MinsuLandLordMainActivity.a(MinsuLandLordMainActivity.this, true);
          }
          for (;;)
          {
            MinsuLandLordMainActivity.this.setMsgNum(0);
            return;
            MinsuLandLordMainActivity.a(MinsuLandLordMainActivity.this, false);
          }
        }
        MinsuLandLordMainActivity.this.setMsgNum(paramInt2 + paramInt3);
        MinsuLandLordMainActivity.a(MinsuLandLordMainActivity.this, false);
      }
    }, 110L);
  }
  
  private void a(final boolean paramBoolean)
  {
    if (this.z == null) {
      return;
    }
    runOnUiThread(new Runnable()
    {
      public void run()
      {
        ImageView localImageView = MinsuLandLordMainActivity.f(MinsuLandLordMainActivity.this);
        if (paramBoolean) {}
        for (int i = 0;; i = 8)
        {
          localImageView.setVisibility(i);
          return;
        }
      }
    });
  }
  
  private void b()
  {
    this.w = getIntent().getStringExtra("target");
    this.x = getIntent().getIntExtra("tabType", -1);
    this.s = new com.ziroom.ziroomcustomer.minsu.landlord.b.c(getSupportFragmentManager());
    this.r.setAdapter(this.s);
    this.r.setOffscreenPageLimit(4);
    this.r.setCurrentItem(0);
    this.r.addOnPageChangeListener(new ViewPager.OnPageChangeListener()
    {
      public void onPageScrollStateChanged(int paramAnonymousInt)
      {
        u.e("home_view_pager", "onPageScrollStateChanged  state = " + paramAnonymousInt + " p = " + MinsuLandLordMainActivity.d(MinsuLandLordMainActivity.this).getCurrentItem());
        List localList;
        if (paramAnonymousInt == 2)
        {
          paramAnonymousInt = MinsuLandLordMainActivity.d(MinsuLandLordMainActivity.this).getCurrentItem();
          localList = Arrays.asList(MinsuLandLordMainActivity.b(MinsuLandLordMainActivity.this));
          u.e("home_view_pager", "onPageScrollStateChanged  0000  p = " + paramAnonymousInt + " index = " + localList.indexOf(Integer.valueOf(MinsuLandLordMainActivity.c(MinsuLandLordMainActivity.this).getCheckedRadioButtonId())) + " ppp = " + MinsuLandLordMainActivity.d(MinsuLandLordMainActivity.this).getCurrentItem());
          if (localList.indexOf(Integer.valueOf(MinsuLandLordMainActivity.c(MinsuLandLordMainActivity.this).getCheckedRadioButtonId())) != paramAnonymousInt) {}
        }
        else
        {
          return;
        }
        u.e("home_view_pager", "onPageScrollStateChanged  1111  p = " + paramAnonymousInt + " index = " + localList.indexOf(Integer.valueOf(MinsuLandLordMainActivity.c(MinsuLandLordMainActivity.this).getCheckedRadioButtonId())));
        MinsuLandLordMainActivity.c(MinsuLandLordMainActivity.this).check(MinsuLandLordMainActivity.b(MinsuLandLordMainActivity.this)[paramAnonymousInt].intValue());
        u.e("home_view_pager", "onPageScrollStateChanged  2222  p = " + paramAnonymousInt + " index = " + localList.indexOf(Integer.valueOf(MinsuLandLordMainActivity.c(MinsuLandLordMainActivity.this).getCheckedRadioButtonId())));
      }
      
      public void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2)
      {
        u.e("home_view_pager", "onPageScrolled");
      }
      
      public void onPageSelected(int paramAnonymousInt)
      {
        List localList = Arrays.asList(MinsuLandLordMainActivity.b(MinsuLandLordMainActivity.this));
        u.e("home_view_pager", "onPageSelected  0000  p = " + paramAnonymousInt + " index = " + localList.indexOf(Integer.valueOf(MinsuLandLordMainActivity.c(MinsuLandLordMainActivity.this).getCheckedRadioButtonId())) + " ppp = " + MinsuLandLordMainActivity.d(MinsuLandLordMainActivity.this).getCurrentItem());
      }
    });
    this.g.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
    {
      @Instrumented
      public void onCheckedChanged(RadioGroup paramAnonymousRadioGroup, int paramAnonymousInt)
      {
        VdsAgent.onCheckedChanged(this, paramAnonymousRadioGroup, paramAnonymousInt);
        paramAnonymousRadioGroup = new ArrayList();
        Collections.addAll(paramAnonymousRadioGroup, MinsuLandLordMainActivity.b(MinsuLandLordMainActivity.this));
        paramAnonymousInt = paramAnonymousRadioGroup.indexOf(Integer.valueOf(paramAnonymousInt));
        u.e("home_view_pager", "RadioGroup  onCheckedChanged  index = " + paramAnonymousInt);
        if (MinsuLandLordMainActivity.d(MinsuLandLordMainActivity.this).getCurrentItem() == paramAnonymousInt) {
          return;
        }
        MinsuLandLordMainActivity.d(MinsuLandLordMainActivity.this).setCurrentItem(paramAnonymousInt, false);
      }
    });
    f();
    if ("minsu_target_ll_release_house".equals(this.w))
    {
      i();
      return;
    }
    if ("minsu_target_llhouselist".equals(this.w))
    {
      b(1);
      return;
    }
    if (this.x == 2)
    {
      b(1);
      return;
    }
    Intent localIntent = getIntent();
    if (localIntent != null) {}
    for (int i = localIntent.getIntExtra("minsu_ll_target", -1);; i = -1)
    {
      if (i != -1)
      {
        b(i);
        return;
      }
      b(0);
      return;
    }
  }
  
  private void b(final int paramInt)
  {
    if ((this.r != null) && (this.g != null)) {
      runOnUiThread(new Runnable()
      {
        public void run()
        {
          MinsuLandLordMainActivity.d(MinsuLandLordMainActivity.this).setCurrentItem(paramInt, false);
          MinsuLandLordMainActivity.c(MinsuLandLordMainActivity.this).check(MinsuLandLordMainActivity.b(MinsuLandLordMainActivity.this)[paramInt].intValue());
        }
      });
    }
  }
  
  private int e()
  {
    if (!EMClient.getInstance().isLoggedInBefore()) {}
    EMConversation localEMConversation;
    do
    {
      return 0;
      localEMConversation = EMClient.getInstance().chatManager().getConversation("ms_ziroom", EMConversation.EMConversationType.Chat, true);
    } while (localEMConversation == null);
    return localEMConversation.getUnreadMsgCount();
  }
  
  private void f()
  {
    com.ziroom.ziroomcustomer.util.ad.saveVersion(this, Integer.parseInt(ah.getAppVersion(ApplicationEx.c)));
    g();
    h();
  }
  
  private void g()
  {
    new com.ziroom.ziroomcustomer.util.a().getAdvertisement();
  }
  
  private void h()
  {
    new com.ziroom.ziroomcustomer.f.a(this).checkPgyUpdate(false);
  }
  
  private void i()
  {
    b(1);
    k.goWeb(this, com.ziroom.ziroomcustomer.minsu.b.d.g + "/auth/43e881/init");
  }
  
  private void j()
  {
    IntentFilter localIntentFilter = new IntentFilter("com.ziroom.commonlibrary.login.broadcast");
    LocalBroadcastManager.getInstance(this).registerReceiver(this.d, localIntentFilter);
    localIntentFilter = new IntentFilter("action_em_login_succ");
    LocalBroadcastManager.getInstance(this).registerReceiver(this.e, localIntentFilter);
  }
  
  public void checkReleaseHint()
  {
    this.C = com.ziroom.ziroomcustomer.util.ad.getMinsuLandReleaseHint(this).booleanValue();
    if (this.C)
    {
      this.A.setVisibility(0);
      return;
    }
    this.A.setVisibility(8);
    getCertification();
  }
  
  public void getCertification()
  {
    com.ziroom.ziroomcustomer.minsu.e.a.getCertification(this, new s(this, new r(CertificationBean.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        StringBuilder localStringBuilder = new StringBuilder().append(" onFailure ");
        if (paramAnonymousThrowable == null) {}
        for (paramAnonymousThrowable = " e = null ";; paramAnonymousThrowable = " e.msg = " + paramAnonymousThrowable.getMessage())
        {
          l.e("error", paramAnonymousThrowable);
          g.textToast(MinsuLandLordMainActivity.this, "获取认证信息失败，请稍后再试");
          return;
        }
      }
      
      public void onSuccess(int paramAnonymousInt, CertificationBean paramAnonymousCertificationBean)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousCertificationBean);
        if (!paramAnonymousCertificationBean.checkSuccess(MinsuLandLordMainActivity.this))
        {
          g.textToast(MinsuLandLordMainActivity.this, "获取认证信息失败，请稍后再试");
          return;
        }
        if ((paramAnonymousCertificationBean != null) && (paramAnonymousCertificationBean.getData() != null))
        {
          if ("1".equals(paramAnonymousCertificationBean.getData().getFullFlag()))
          {
            k.toHouseRelease(MinsuLandLordMainActivity.this);
            return;
          }
          Intent localIntent = new Intent(MinsuLandLordMainActivity.this, QApersonalActivity.class);
          localIntent.putExtra("isCantactAuth", paramAnonymousCertificationBean.getData().getIsContactAuth());
          localIntent.putExtra("isIdentityAuth", paramAnonymousCertificationBean.getData().getIsIdentityAuth());
          localIntent.putExtra("isFinishHead", paramAnonymousCertificationBean.getData().getIsFinishHead());
          MinsuLandLordMainActivity.this.startActivity(localIntent);
          return;
        }
        g.textToast(MinsuLandLordMainActivity.this, "获取认证信息失败，请稍后再试");
      }
    });
  }
  
  public void getUnReadMsgCount()
  {
    if (ae.isNull(com.ziroom.ziroomcustomer.minsu.e.d.getUid())) {
      return;
    }
    final int i = com.ziroom.ziroomcustomer.minsu.chat.j.getUnReadMsgSize(1);
    final int j = e();
    u.i("huanxin msgcount", " size = " + i + " customerServiceUnRead = " + j);
    f.getUnreadNum(this, new com.freelxl.baselibrary.d.c.a(new m(com.alibaba.fastjson.e.class, new com.ziroom.ziroomcustomer.e.c.a.c()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        MinsuLandLordMainActivity.a(MinsuLandLordMainActivity.this, MinsuLandLordMainActivity.e(MinsuLandLordMainActivity.this), i, j);
      }
      
      public void onSuccess(int paramAnonymousInt, com.alibaba.fastjson.e paramAnonymouse)
      {
        com.freelxl.baselibrary.f.d.d("OKHttp", "Push ZRK getUnreadNum success,detail as below");
        if (paramAnonymouse != null) {
          MinsuLandLordMainActivity.a(MinsuLandLordMainActivity.this, paramAnonymouse.getInteger("unread").intValue());
        }
        MinsuLandLordMainActivity.a(MinsuLandLordMainActivity.this, MinsuLandLordMainActivity.e(MinsuLandLordMainActivity.this), i, j);
      }
    }, com.ziroom.ziroomcustomer.service.d.buildGetUnreadNum(this, com.ziroom.ziroomcustomer.service.d.a, h.toMd5(com.ziroom.ziroomcustomer.minsu.e.d.getUid().getBytes()), com.ziroom.ziroomcustomer.service.e.getLastSyncTime(this)));
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    u.d("lanzhihong", "requestCode===" + paramInt1 + "====resultCode==" + paramInt2);
    if (paramInt2 == 4096)
    {
      paramIntent = paramIntent.getStringExtra("saveDesc");
      com.ziroom.ziroomcustomer.minsu.e.a.saveOrderRemark(this, c, paramIntent, new com.ziroom.ziroomcustomer.minsu.landlord.d.a(this, new com.ziroom.ziroomcustomer.minsu.landlord.d.b(RemarkItem.class))
      {
        public void onSuccess(int paramAnonymousInt, RemarkItem paramAnonymousRemarkItem)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymousRemarkItem);
        }
      });
    }
    if (paramInt1 == 121) {
      if (!com.ziroom.commonlibrary.login.a.getLoginState(this)) {
        if (MainActivity.b == null) {
          k.toMainActivity(this);
        }
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          finish();
          com.ziroom.ziroomcustomer.minsu.f.ad.setIsMinsuLandlord(false);
          return;
          b();
        } while (MainActivity.b == null);
        MainActivity.b.finish();
        return;
        if (paramInt1 == 122)
        {
          if (!com.ziroom.commonlibrary.login.a.getLoginState(this))
          {
            k.toMainActivity(this);
            return;
          }
          b();
          return;
        }
        if (paramInt1 != 130) {
          break;
        }
      } while ((paramInt2 != -1) || (TextUtils.isEmpty(b)));
      k.toAppointmentPhotographer(this, b);
      return;
    } while ((paramInt1 != 171) || (paramInt2 != -1));
    b(0);
  }
  
  public void onCmdMessageReceived(List<EMMessage> paramList)
  {
    com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.i("huanxin");
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903296);
    a();
    if (ApplicationEx.c.isLoginState())
    {
      if (MainActivity.b != null) {
        MainActivity.b.finish();
      }
      b();
    }
    for (;;)
    {
      j();
      return;
      paramBundle = new Intent();
      paramBundle.setClass(this, LoginActivity.class);
      startActivityForResult(paramBundle, 121);
    }
  }
  
  protected void onDestroy()
  {
    LocalBroadcastManager.getInstance(this).unregisterReceiver(this.d);
    LocalBroadcastManager.getInstance(this).unregisterReceiver(this.e);
    super.onDestroy();
    a = null;
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
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      long l = System.currentTimeMillis();
      if (l - this.u > 2000L)
      {
        showToast("再按一次可退出程序");
        this.u = l;
        return true;
      }
      ApplicationEx.c.AppExit(this);
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public void onMessageChanged(EMMessage paramEMMessage, Object paramObject)
  {
    com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.i("huanxin");
    getUnReadMsgCount();
  }
  
  public void onMessageDelivered(List<EMMessage> paramList)
  {
    com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.i("huanxin");
    getUnReadMsgCount();
  }
  
  public void onMessageRead(List<EMMessage> paramList)
  {
    com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.i("huanxin");
    getUnReadMsgCount();
  }
  
  public void onMessageRecalled(List<EMMessage> paramList) {}
  
  public void onMessageReceived(List<EMMessage> paramList)
  {
    com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.i("huanxin");
    getUnReadMsgCount();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      EMMessage localEMMessage = (EMMessage)paramList.next();
      try
      {
        if ("ZIROOM_MINSU_IM".equals(localEMMessage.getStringAttribute("ziroomFlag"))) {
          ApplicationEx.c.getNotifier().onNewMsg(localEMMessage);
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void onResume()
  {
    super.onResume();
    a = this;
    try
    {
      if (EMClient.getInstance().isLoggedInBefore()) {
        EMClient.getInstance().chatManager().addMessageListener(this);
      }
      getUnReadMsgCount();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        u.e("huanxin", "e = " + localException.getMessage());
      }
    }
  }
  
  public void onStop()
  {
    super.onStop();
    try
    {
      EMClient.getInstance().chatManager().removeMessageListener(this);
      com.ziroom.ziroomcustomer.util.j.getInstance().popActivity(this);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        u.e("huanxin", "e = " + localException.getMessage());
      }
    }
  }
  
  public void setMsgNum(final int paramInt)
  {
    if (this.t == null) {
      return;
    }
    runOnUiThread(new Runnable()
    {
      public void run()
      {
        if (paramInt < 1)
        {
          MinsuLandLordMainActivity.g(MinsuLandLordMainActivity.this).setVisibility(8);
          return;
        }
        MinsuLandLordMainActivity.g(MinsuLandLordMainActivity.this).setText(paramInt + "");
        MinsuLandLordMainActivity.g(MinsuLandLordMainActivity.this).setBadgeBackgroundColor(Color.parseColor("#FFFF6438"));
        MinsuLandLordMainActivity.g(MinsuLandLordMainActivity.this).setVisibility(0);
      }
    });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/activity/MinsuLandLordMainActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */