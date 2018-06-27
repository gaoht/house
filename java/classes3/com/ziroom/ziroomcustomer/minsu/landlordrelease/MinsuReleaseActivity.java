package com.ziroom.ziroomcustomer.minsu.landlordrelease;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.ziroom.commonlibrary.widget.unifiedziroom.d;
import com.ziroom.commonlibrary.widget.unifiedziroom.d.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.d.b;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.flux.view.BaseFluxActivity;
import com.ziroom.ziroomcustomer.minsu.f.k;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.base.BaseLandlordReleaseFragment;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.d.c;
import com.ziroom.ziroomcustomer.model.UserInfo;
import java.util.ArrayList;
import java.util.HashMap;

public class MinsuReleaseActivity
  extends BaseFluxActivity
  implements com.ziroom.ziroomcustomer.minsu.landlordrelease.base.b
{
  private static String w;
  private Context b;
  private String c;
  private String d;
  private int e;
  private int f;
  @BindView(2131691551)
  FrameLayout fl_root;
  private HashMap<String, Object> g;
  private c r;
  private com.ziroom.ziroomcustomer.minsu.landlordrelease.a.b s;
  private int t;
  private ArrayList<BaseLandlordReleaseFragment> u;
  private int v;
  private String x;
  private BroadcastReceiver y = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      boolean bool2;
      if (paramAnonymousIntent.getIntExtra("type", 0) == 17)
      {
        bool2 = ApplicationEx.c.isLoginState();
        if (bool2)
        {
          paramAnonymousContext = ApplicationEx.c.getUser().getUid();
          if ((MinsuReleaseActivity.a() == null) || (!MinsuReleaseActivity.a().equals(paramAnonymousContext)))
          {
            MinsuReleaseActivity.d(paramAnonymousContext);
            MinsuReleaseActivity.this.setResult(-1);
            MinsuReleaseActivity.this.finish();
          }
        }
      }
      else
      {
        return;
      }
      int i = 0;
      label74:
      if ((MinsuReleaseActivity.b(MinsuReleaseActivity.this) != null) && (i < MinsuReleaseActivity.b(MinsuReleaseActivity.this).size()))
      {
        paramAnonymousContext = (BaseLandlordReleaseFragment)MinsuReleaseActivity.b(MinsuReleaseActivity.this).get(i);
        if (i != MinsuReleaseActivity.c(MinsuReleaseActivity.this)) {
          break label142;
        }
      }
      label142:
      for (boolean bool1 = true;; bool1 = false)
      {
        paramAnonymousContext.onLoginBack(bool2, bool1);
        i += 1;
        break label74;
        break;
      }
    }
  };
  
  private void a(int paramInt, boolean paramBoolean)
  {
    int i = 1;
    label38:
    Object localObject;
    if (this.u == null)
    {
      this.u = new ArrayList();
      if (this.g != null) {
        break label207;
      }
      this.g = new HashMap();
      this.t = paramInt;
      if (paramInt != 0) {
        break label217;
      }
      localObject = LandlordReleaseOnceStepOneFragment.newInstance();
      LandlordReleaseOnceStepTwoFragment localLandlordReleaseOnceStepTwoFragment = LandlordReleaseOnceStepTwoFragment.newInstance();
      this.u.add(localObject);
      this.u.add(localLandlordReleaseOnceStepTwoFragment);
    }
    for (;;)
    {
      localObject = getSupportFragmentManager().beginTransaction();
      if (this.u.size() <= 0) {
        break label660;
      }
      if (!paramBoolean) {
        break label538;
      }
      ((FragmentTransaction)localObject).replace(2131691551, (Fragment)this.u.get(0));
      ((FragmentTransaction)localObject).show((Fragment)this.u.get(0));
      this.v = 0;
      paramInt = i;
      while (paramInt < this.u.size())
      {
        ((FragmentTransaction)localObject).add(2131691551, (Fragment)this.u.get(paramInt));
        ((FragmentTransaction)localObject).hide((Fragment)this.u.get(paramInt));
        paramInt += 1;
      }
      this.u.clear();
      break;
      label207:
      this.g.clear();
      break label38;
      label217:
      if (getRentWay() == 0) {
        switch (paramInt)
        {
        default: 
          break;
        case 1: 
          localObject = LLReleaseSecondStepOneFragment.newInstance();
          this.u.add(localObject);
          break;
        case 2: 
          localObject = LLReleaseHouseSecondStepTwoFragment.newInstance();
          this.u.add(localObject);
          break;
        case 3: 
          localObject = LandlordReleaseThirdStepFragment.getInstance(null);
          this.u.add(localObject);
          break;
        case 4: 
          localObject = LLReleaseFourthStepFragment.newInstance();
          this.u.add(localObject);
          break;
        case 5: 
          localObject = LandlordReleaseFifthFragment.newInstance();
          this.u.add(localObject);
          break;
        }
      } else if (getRentWay() == 1) {
        switch (paramInt)
        {
        default: 
          break;
        case 1: 
          localObject = LLReleaseSecondStepOneFragment.newInstance();
          this.u.add(localObject);
          break;
        case 2: 
          localObject = LLReleaseRoomSecondStepTwoFragment.newInstance();
          this.u.add(localObject);
          break;
        case 3: 
          if (getRoomType() == 1)
          {
            localObject = LLReleaseRoomSecondStepThreeFragment_SR.newInstance();
            this.u.add(localObject);
          }
          else
          {
            localObject = LLReleaseRoomSecondStepThreeFragment.newInstance();
            this.u.add(localObject);
          }
          break;
        case 4: 
          localObject = LandlordReleaseThirdStepFragment.getInstance(null);
          this.u.add(localObject);
          break;
        case 5: 
          localObject = LLReleaseFourthStepFragment.newInstance();
          this.u.add(localObject);
          break;
        case 6: 
          localObject = LandlordReleaseFifthFragment.newInstance();
          this.u.add(localObject);
        }
      }
    }
    label538:
    ((FragmentTransaction)localObject).replace(2131691551, (Fragment)this.u.get(this.u.size() - 1));
    ((FragmentTransaction)localObject).show((Fragment)this.u.get(this.u.size() - 1));
    this.v = (this.u.size() - 1);
    paramInt = this.u.size() - 2;
    while (paramInt >= 0)
    {
      ((FragmentTransaction)localObject).add(2131691551, (Fragment)this.u.get(paramInt));
      ((FragmentTransaction)localObject).hide((Fragment)this.u.get(paramInt));
      paramInt -= 1;
    }
    label660:
    ((FragmentTransaction)localObject).commitAllowingStateLoss();
  }
  
  private void b()
  {
    this.r = new c(this);
    this.a.register(this.r);
    this.s = com.ziroom.ziroomcustomer.minsu.landlordrelease.a.b.getInstance(this.a);
  }
  
  private void e()
  {
    if ((getWindow().getAttributes().softInputMode != 2) && (getCurrentFocus() != null)) {
      ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
    }
  }
  
  public Object getDataCache(String paramString)
  {
    if (this.g == null) {
      return null;
    }
    return this.g.get(paramString);
  }
  
  public String getHouseFid()
  {
    return this.c;
  }
  
  public int getRentWay()
  {
    return this.e;
  }
  
  public String getRoomFid()
  {
    return this.d;
  }
  
  public int getRoomType()
  {
    return this.f;
  }
  
  public void next()
  {
    e();
    if ("manager".equals(this.x))
    {
      finish();
      return;
    }
    if (this.v == this.u.size() - 1)
    {
      if (getRentWay() == 0) {}
      for (i = 5; this.t != i; i = 6)
      {
        a(this.t + 1, true);
        return;
      }
      finish();
      return;
    }
    Object localObject = getSupportFragmentManager().beginTransaction();
    ((FragmentTransaction)localObject).hide((Fragment)this.u.get(this.v));
    ArrayList localArrayList = this.u;
    int i = this.v + 1;
    this.v = i;
    ((FragmentTransaction)localObject).show((Fragment)localArrayList.get(i));
    ((FragmentTransaction)localObject).commitAllowingStateLoss();
    i = 0;
    label144:
    if (i < this.u.size())
    {
      localObject = (BaseLandlordReleaseFragment)this.u.get(i);
      if (i != this.v) {
        break label189;
      }
    }
    label189:
    for (boolean bool = true;; bool = false)
    {
      ((BaseLandlordReleaseFragment)localObject).onFragmentSwitch(bool);
      i += 1;
      break label144;
      break;
    }
  }
  
  public void onBackPressed()
  {
    if ((this.u.get(this.v) instanceof com.ziroom.ziroomcustomer.minsu.landlordrelease.base.a))
    {
      if (((com.ziroom.ziroomcustomer.minsu.landlordrelease.base.a)this.u.get(this.v)).onBackPressed()) {
        prev();
      }
      return;
    }
    prev();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    getWindow().setFormat(-3);
    super.onCreate(paramBundle);
    paramBundle = getWindow();
    if (paramBundle != null) {
      paramBundle.setSoftInputMode(32);
    }
    setContentView(2130903303);
    this.b = this;
    ButterKnife.bind(this);
    b();
    paramBundle = getIntent();
    this.c = paramBundle.getStringExtra("houseBaseFid");
    this.d = paramBundle.getStringExtra("roomFid");
    this.e = paramBundle.getIntExtra("rentWay", 0);
    this.f = paramBundle.getIntExtra("roomType", 0);
    int i = paramBundle.getIntExtra("step", 0);
    this.x = getIntent().getStringExtra("from");
    a(i, true);
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.ziroom.commonlibrary.login.broadcast");
    LocalBroadcastManager.getInstance(this.b).registerReceiver(this.y, paramBundle);
    if (ApplicationEx.c.isLoginState())
    {
      w = ApplicationEx.c.getUser().getUid();
      return;
    }
    com.ziroom.commonlibrary.login.a.startLoginActivity(this);
  }
  
  protected void onDestroy()
  {
    this.a.unregister(this.r);
    com.freelxl.baselibrary.d.a.cancel(this);
    if (this.y != null) {
      LocalBroadcastManager.getInstance(this.b).unregisterReceiver(this.y);
    }
    super.onDestroy();
  }
  
  protected void onEventHandle(com.ziroom.ziroomcustomer.flux.a.a parama)
  {
    parama.getType().getClass();
  }
  
  public void prev()
  {
    e();
    if (!ApplicationEx.c.isLoginState())
    {
      d.newBuilder(this.b).setTitle("提示").setContent("您的账号已在其他终端登录，请确认是否重新登录？").setButtonText("返回民宿首页", "重新登录").setOnConfirmClickListener(new d.b()
      {
        public void onLeftClick(View paramAnonymousView)
        {
          k.toMainActivity(MinsuReleaseActivity.this);
        }
        
        public void onRightClick(View paramAnonymousView)
        {
          com.ziroom.commonlibrary.login.a.startLoginActivity(MinsuReleaseActivity.a(MinsuReleaseActivity.this));
        }
      }).show();
      return;
    }
    if ("manager".equals(this.x))
    {
      finish();
      return;
    }
    if (this.v == 0)
    {
      if (this.t != 0)
      {
        a(this.t - 1, false);
        return;
      }
      finish();
      return;
    }
    Object localObject = getSupportFragmentManager().beginTransaction();
    ((FragmentTransaction)localObject).hide((Fragment)this.u.get(this.v));
    ArrayList localArrayList = this.u;
    int i = this.v - 1;
    this.v = i;
    ((FragmentTransaction)localObject).show((Fragment)localArrayList.get(i));
    ((FragmentTransaction)localObject).commitAllowingStateLoss();
    i = 0;
    label171:
    if (i < this.u.size())
    {
      localObject = (BaseLandlordReleaseFragment)this.u.get(i);
      if (i != this.v) {
        break label216;
      }
    }
    label216:
    for (boolean bool = true;; bool = false)
    {
      ((BaseLandlordReleaseFragment)localObject).onFragmentSwitch(bool);
      i += 1;
      break label171;
      break;
    }
  }
  
  public void putDataCache(String paramString, Object paramObject)
  {
    if (this.g == null) {
      this.g = new HashMap();
    }
    this.g.put(paramString, paramObject);
  }
  
  public void setHouseFid(String paramString)
  {
    this.c = paramString;
  }
  
  public void setRentWay(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setRoomFid(String paramString)
  {
    this.d = paramString;
  }
  
  public void setRoomType(int paramInt)
  {
    this.f = paramInt;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/MinsuReleaseActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */