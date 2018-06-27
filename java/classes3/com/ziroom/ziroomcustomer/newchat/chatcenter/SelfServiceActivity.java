package com.ziroom.ziroomcustomer.newchat.chatcenter;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.freelxl.baselibrary.e.i.a;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.e.o;
import com.ziroom.ziroomcustomer.model.Contract;
import com.ziroom.ziroomcustomer.model.MapMoveHouse;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.my.MyStewardListActivity;
import com.ziroom.ziroomcustomer.newclean.activity.ForCleaningActivity;
import com.ziroom.ziroomcustomer.newmovehouse.activity.RefactorMHMainActivity;
import com.ziroom.ziroomcustomer.newrepair.activity.InternalRepairSelectActivity;
import com.ziroom.ziroomcustomer.termination.InitiateTerminationActivity;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.util.w;
import java.util.List;
import java.util.Map;

public class SelfServiceActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private int A = 0;
  private int B = 0;
  private BroadcastReceiver C = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if (paramAnonymousIntent.getIntExtra("type", 0) == 17)
      {
        SelfServiceActivity.a(SelfServiceActivity.this, ApplicationEx.c.isLoginState());
        if ((ApplicationEx.c.getUser() != null) && (SelfServiceActivity.d(SelfServiceActivity.this) == 2)) {
          SelfServiceActivity.a(SelfServiceActivity.this, NetPhoneActivity.class);
        }
      }
    }
  };
  private Context a;
  private ImageView b;
  private RelativeLayout c;
  private RelativeLayout d;
  private RelativeLayout e;
  private RelativeLayout f;
  private RelativeLayout g;
  private RelativeLayout r;
  private RelativeLayout s;
  private boolean t = false;
  private Intent u;
  private List<Contract> v;
  private Dialog w;
  private a x;
  private int y;
  private Contract z;
  
  private void a()
  {
    this.b = ((ImageView)findViewById(2131689492));
    this.c = ((RelativeLayout)findViewById(2131690180));
    this.d = ((RelativeLayout)findViewById(2131690182));
    this.e = ((RelativeLayout)findViewById(2131690183));
    this.f = ((RelativeLayout)findViewById(2131690184));
    this.g = ((RelativeLayout)findViewById(2131690185));
    this.r = ((RelativeLayout)findViewById(2131690186));
    this.s = ((RelativeLayout)findViewById(2131690187));
    this.b.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.r.setOnClickListener(this);
    this.s.setOnClickListener(this);
    IntentFilter localIntentFilter = new IntentFilter("com.ziroom.commonlibrary.login.broadcast");
    LocalBroadcastManager.getInstance(this).registerReceiver(this.C, localIntentFilter);
  }
  
  private void a(Class paramClass)
  {
    if (this.t)
    {
      startActivity(new Intent(this, paramClass));
      return;
    }
    com.ziroom.commonlibrary.login.a.startLoginActivity(this);
  }
  
  private void b()
  {
    n.getMHServiceEntity(this.a, new b(), true);
  }
  
  private void b(Class paramClass)
  {
    if (this.t)
    {
      this.v = ApplicationEx.c.getContracts();
      if ((this.v != null) && (this.v.size() > 0))
      {
        startActivity(new Intent(this, paramClass));
        return;
      }
      showToast("您没有履行中的合同哦~");
      return;
    }
    com.ziroom.commonlibrary.login.a.startLoginActivity(this);
  }
  
  private void c(Class paramClass)
  {
    if (!this.t)
    {
      com.ziroom.commonlibrary.login.a.startLoginActivity(this.a);
      return;
    }
    this.v = ApplicationEx.c.getContracts();
    if ((this.v != null) && (this.v.size() > 0))
    {
      if (this.v.size() == 1)
      {
        this.u = new Intent(this.a, paramClass);
        if (this.A == 1) {
          this.u.putExtra("contractCode", ((Contract)this.v.get(0)).getContract_code());
        }
        startActivity(this.u);
        return;
      }
      e();
      return;
    }
    showToast("您没有履行中的合同哦~");
  }
  
  private void d(String paramString)
  {
    Object localObject = ApplicationEx.c.getUser();
    if (localObject != null) {}
    for (localObject = ((UserInfo)localObject).getUid();; localObject = "customer")
    {
      o.saveAppPoint(this.a, this.q, "SELF_HELP_CLICK", (String)localObject, "", paramString);
      return;
    }
  }
  
  private void e()
  {
    this.w = new Dialog(this, 2131427692);
    Object localObject1 = getLayoutInflater().inflate(2130903863, null);
    Object localObject2 = (ListView)((View)localObject1).findViewById(2131693805);
    Object localObject3 = (TextView)((View)localObject1).findViewById(2131691288);
    this.x = new a();
    ((ListView)localObject2).setAdapter(this.x);
    ((TextView)localObject3).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        SelfServiceActivity.b(SelfServiceActivity.this).dismiss();
      }
    });
    this.w.setCanceledOnTouchOutside(true);
    localObject2 = this.w.getWindow();
    ((Window)localObject2).getDecorView().setPadding(0, 0, 0, 0);
    localObject3 = ((Window)localObject2).getAttributes();
    ((WindowManager.LayoutParams)localObject3).width = -1;
    ((WindowManager.LayoutParams)localObject3).height = -2;
    ((Window)localObject2).setAttributes((WindowManager.LayoutParams)localObject3);
    ((Window)localObject2).setGravity(80);
    this.w.setContentView((View)localObject1);
    localObject1 = this.w;
    if (!(localObject1 instanceof Dialog))
    {
      ((Dialog)localObject1).show();
      return;
    }
    VdsAgent.showDialog((Dialog)localObject1);
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    this.t = ApplicationEx.c.isLoginState();
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131689492: 
      finish();
      return;
    case 2131690180: 
      b();
      d("MOVE_RESERVATION");
      w.onEvent("customerservice_selfservice_move");
      return;
    case 2131690182: 
      b(ForCleaningActivity.class);
      d("BIWEEKLY_CLEAN_RESERVATION");
      w.onEvent("customerservice_selfservice_clean");
      return;
    case 2131690183: 
      b(InternalRepairSelectActivity.class);
      d("MAINTAIN_RESERVATION");
      w.onEvent("customerservice_selfservice_maintain");
      return;
    case 2131690184: 
      this.A = 1;
      c(InitiateTerminationActivity.class);
      d("SURRENDER_TENANCY");
      w.onEvent("customerservice_selfservice_checkout");
      return;
    case 2131690185: 
      this.A = 1;
      c(InitiateTerminationActivity.class);
      d("YAWP_OF_THREE_DAYS");
      w.onEvent("customerservice_selfservice_three");
      return;
    case 2131690186: 
      this.A = 2;
      b(NetPhoneActivity.class);
      d("BROADBAND_MESSAGE");
      w.onEvent("customerservice_selfservice_internet");
      return;
    }
    a(MyStewardListActivity.class);
    d("MY_STEWARD");
    w.onEvent("customerservice_selfservice_keepertel");
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903132);
    this.a = this;
    a();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    try
    {
      LocalBroadcastManager.getInstance(this).unregisterReceiver(this.C);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public class a
    extends BaseAdapter
  {
    public a() {}
    
    public int getCount()
    {
      return SelfServiceActivity.c(SelfServiceActivity.this).size();
    }
    
    public Object getItem(int paramInt)
    {
      return null;
    }
    
    public long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public View getView(final int paramInt, View paramView, final ViewGroup paramViewGroup)
    {
      if (paramView == null)
      {
        paramView = View.inflate(SelfServiceActivity.a(SelfServiceActivity.this), 2130904570, null);
        paramViewGroup = new a();
        paramViewGroup.a = ((TextView)paramView.findViewById(2131693248));
        paramViewGroup.b = ((ImageView)paramView.findViewById(2131695668));
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        paramViewGroup.a.setText(((Contract)SelfServiceActivity.c(SelfServiceActivity.this).get(paramInt)).getAddress());
        paramViewGroup.a.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            SelfServiceActivity.a(SelfServiceActivity.this, paramInt);
            SelfServiceActivity.a.this.notifyDataSetChanged();
            SelfServiceActivity.a(SelfServiceActivity.this, (Contract)SelfServiceActivity.c(SelfServiceActivity.this).get(paramInt));
            paramViewGroup.b.setVisibility(0);
            if (SelfServiceActivity.d(SelfServiceActivity.this) == 1)
            {
              SelfServiceActivity.a(SelfServiceActivity.this, new Intent(SelfServiceActivity.a(SelfServiceActivity.this), InitiateTerminationActivity.class));
              SelfServiceActivity.f(SelfServiceActivity.this).putExtra("contractCode", SelfServiceActivity.e(SelfServiceActivity.this).getContract_code());
            }
            SelfServiceActivity.this.startActivity(SelfServiceActivity.f(SelfServiceActivity.this));
            SelfServiceActivity.b(SelfServiceActivity.this).dismiss();
          }
        });
        if (SelfServiceActivity.g(SelfServiceActivity.this) != paramInt) {
          break;
        }
        paramViewGroup.a.setTextColor(-695296);
        paramViewGroup.b.setVisibility(0);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
      }
      paramViewGroup.a.setTextColor(-15658735);
      paramViewGroup.b.setVisibility(4);
      return paramView;
    }
    
    public class a
    {
      public TextView a;
      public ImageView b;
      
      public a() {}
    }
  }
  
  class b
    implements i.a<String>
  {
    b() {}
    
    public void onParse(String paramString, com.freelxl.baselibrary.e.k paramk)
    {
      u.e("dsgdsgh:", com.ziroom.ziroomcustomer.util.k.decrypt(paramString));
      paramString = com.alibaba.fastjson.a.parseObject(com.ziroom.ziroomcustomer.util.k.decrypt(paramString));
      String str = (String)paramString.get("status");
      if (("0".equals(str)) || ("success".equals(str)))
      {
        if (paramString.get("data") != null) {
          paramk.setObject(com.alibaba.fastjson.a.parseArray(paramString.get("data").toString(), MapMoveHouse.class));
        }
        paramk.setSuccess(Boolean.valueOf(true));
        return;
      }
      paramk.setSuccess(Boolean.valueOf(false));
    }
    
    public void onSuccess(com.freelxl.baselibrary.e.k paramk)
    {
      if (paramk.getSuccess().booleanValue())
      {
        paramk = (List)paramk.getObject();
        if ((paramk != null) && (paramk.size() != 0) && (paramk.get(0) != null))
        {
          Intent localIntent = new Intent(SelfServiceActivity.a(SelfServiceActivity.this), RefactorMHMainActivity.class);
          localIntent.putExtra("serviceInfoId", ((MapMoveHouse)paramk.get(0)).getServiceInfoId());
          SelfServiceActivity.this.startActivity(localIntent);
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newchat/chatcenter/SelfServiceActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */