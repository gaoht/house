package com.ziroom.ziroomcustomer.my;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.login.a;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.base.b;
import com.ziroom.ziroomcustomer.model.Contract;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newmovehouse.activity.RefactorMHMainActivity;
import com.ziroom.ziroomcustomer.service.LoginReceiver;
import com.ziroom.ziroomcustomer.util.c;
import com.ziroom.ziroomcustomer.util.c.a;
import java.util.List;

public class ServiceOrderActivity
  extends BaseActivity
{
  View.OnClickListener a = new View.OnClickListener()
  {
    @Instrumented
    public void onClick(View paramAnonymousView)
    {
      VdsAgent.onClick(this, paramAnonymousView);
      ServiceOrderActivity.this.click();
      ServiceOrderActivity.a(ServiceOrderActivity.this, (ApplicationEx)ServiceOrderActivity.this.getApplication());
      ServiceOrderActivity.a(ServiceOrderActivity.this, ServiceOrderActivity.d(ServiceOrderActivity.this).isLoginState());
      ServiceOrderActivity.a(ServiceOrderActivity.this, ServiceOrderActivity.d(ServiceOrderActivity.this).getContracts());
      ServiceOrderActivity.a(ServiceOrderActivity.this, ServiceOrderActivity.d(ServiceOrderActivity.this).getUser());
      switch (paramAnonymousView.getId())
      {
      default: 
        return;
      case 2131697524: 
        ServiceOrderActivity.a(ServiceOrderActivity.this, paramAnonymousView, RefactorMHMainActivity.class, 1);
        return;
      }
      ServiceOrderActivity.this.finish();
    }
  };
  private RelativeLayout b;
  private RelativeLayout c;
  private RelativeLayout d;
  private RelativeLayout e;
  private RelativeLayout f;
  private boolean g = false;
  private UserInfo r;
  private ApplicationEx s;
  private List<Contract> t = null;
  private TextView u;
  private Class v;
  private int w;
  private BroadcastReceiver x = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if (paramAnonymousIntent.getIntExtra("type", 0) == 17)
      {
        paramAnonymousContext = new Intent(ServiceOrderActivity.this.getApplicationContext(), ServiceOrderActivity.a(ServiceOrderActivity.this));
        ServiceOrderActivity.this.startActivity(paramAnonymousContext);
        ServiceOrderActivity.this.finish();
      }
    }
  };
  
  private void a(View paramView, final Class paramClass, final int paramInt)
  {
    c.scale(new c.a()
    {
      public void toLoginActivity()
      {
        Object localObject;
        if (!ServiceOrderActivity.b(ServiceOrderActivity.this))
        {
          localObject = new IntentFilter("com.ziroom.commonlibrary.login.broadcast");
          LocalBroadcastManager.getInstance(ServiceOrderActivity.this).registerReceiver(LoginReceiver.getInstance(), (IntentFilter)localObject);
          ServiceOrderActivity.a(ServiceOrderActivity.this, paramClass);
          ServiceOrderActivity.a(ServiceOrderActivity.this, paramInt);
          a.startLoginActivity(ServiceOrderActivity.this.getApplicationContext());
          return;
        }
        if (paramInt == 1)
        {
          localObject = new Intent(ServiceOrderActivity.this.getApplicationContext(), paramClass);
          ((Intent)localObject).putExtra("name", "1");
          ServiceOrderActivity.this.startActivity((Intent)localObject);
          return;
        }
        if (ServiceOrderActivity.c(ServiceOrderActivity.this) != null)
        {
          localObject = new Intent(ServiceOrderActivity.this.getApplicationContext(), paramClass);
          if (paramInt == 2) {
            ((Intent)localObject).putExtra("query", "query");
          }
          if (paramInt == 0) {
            ((Intent)localObject).putExtra("show_list", true);
          }
          ServiceOrderActivity.this.startActivity((Intent)localObject);
          return;
        }
        g.textToast(ServiceOrderActivity.d(ServiceOrderActivity.this), "您还没有签约，请您签约", 0);
      }
    }, paramView, 300L);
  }
  
  public void click()
  {
    disableViewForSeconds(this.b);
    disableViewForSeconds(this.c);
    disableViewForSeconds(this.d);
    disableViewForSeconds(this.e);
    disableViewForSeconds(this.f);
  }
  
  public void disableViewForSeconds(final View paramView)
  {
    paramView.setClickable(false);
    new Handler().postDelayed(new Runnable()
    {
      public void run()
      {
        paramView.setClickable(true);
      }
    }, 1000L);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130905121);
    this.u = ((TextView)findViewById(2131689895));
    this.b = ((RelativeLayout)findViewById(2131697523));
    this.c = ((RelativeLayout)findViewById(2131697524));
    this.d = ((RelativeLayout)findViewById(2131697525));
    this.e = ((RelativeLayout)findViewById(2131697526));
    this.f = ((RelativeLayout)findViewById(2131697527));
    this.b.setOnClickListener(this.a);
    this.c.setOnClickListener(this.a);
    this.d.setOnClickListener(this.a);
    this.e.setOnClickListener(this.a);
    this.u.setOnClickListener(this.a);
    if (b.d == "310000")
    {
      findViewById(2131697521).setVisibility(8);
      findViewById(2131697522).setVisibility(8);
      findViewById(2131689578).setVisibility(8);
      this.d.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          ServiceOrderActivity.this.showToast("该服务未开通");
        }
      });
      this.e.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          ServiceOrderActivity.this.showToast("该服务未开通");
        }
      });
    }
  }
  
  protected void onDestroy()
  {
    LocalBroadcastManager.getInstance(this).unregisterReceiver(this.x);
    super.onDestroy();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/ServiceOrderActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */