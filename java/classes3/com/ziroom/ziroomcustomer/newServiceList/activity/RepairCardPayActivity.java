package com.ziroom.ziroomcustomer.newServiceList.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.e.k;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.e.d;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newclean.cardpay.model.BuyCard;
import com.ziroom.ziroomcustomer.newclean.cardpay.model.Promotions;
import com.ziroom.ziroomcustomer.newclean.cardpay.model.ServicePay;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepairCardPayActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private RelativeLayout A;
  private TextView B;
  private TextView C;
  private int D = 0;
  private View E;
  private BroadcastReceiver F = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      abortBroadcast();
      paramAnonymousContext = new Intent();
      paramAnonymousContext.setAction("refresh_card");
      ApplicationEx.c.sendBroadcast(paramAnonymousContext);
      paramAnonymousContext = RepairCardPayActivity.this.getIntent();
      paramAnonymousContext.putExtra("result", true);
      RepairCardPayActivity.this.setResult(-1, paramAnonymousContext);
      RepairCardPayActivity.this.finish();
    }
  };
  private TextView a;
  private ImageView b;
  private ListView c;
  private TextView d;
  private ImageView e;
  private TextView f;
  private Button g;
  private Context r;
  private int s = 1;
  private String t;
  private List<Promotions> u;
  private BuyCard v;
  private UserInfo w;
  private ServicePay x;
  private d y = new d();
  private int z;
  
  private void a()
  {
    this.t = getIntent().getStringExtra("cardName");
    this.u = ((List)getIntent().getSerializableExtra("promoList"));
    String str3 = getIntent().getStringExtra("c_id");
    String str4 = getIntent().getStringExtra("tag_Price");
    String str1 = getIntent().getStringExtra("time");
    String str2 = getIntent().getStringExtra("card_index");
    if (!TextUtils.isEmpty(this.t)) {
      this.a.setText(this.t);
    }
    if ((this.u != null) && (this.u.size() > 0))
    {
      this.A.setVisibility(0);
      this.c.setAdapter(new a());
      this.E.setVisibility(0);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(str4))
      {
        this.d.setText(Long.parseLong(str4) / 100L + ".00");
        this.B.setText(Long.parseLong(str4) / 100L + ".00元");
      }
      if (!TextUtils.isEmpty(str3)) {}
      try
      {
        this.z = Integer.parseInt(str3);
        if (!TextUtils.isEmpty(str1)) {
          this.C.setText(str1 + "个月");
        }
        if (!TextUtils.isEmpty(str2)) {
          this.D = Integer.parseInt(str2);
        }
        return;
        this.A.setVisibility(8);
        this.E.setVisibility(8);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          localNumberFormatException.printStackTrace();
        }
      }
    }
  }
  
  private void a(ServicePay paramServicePay)
  {
    if (TextUtils.isEmpty(paramServicePay.getPartnerid()))
    {
      this.y.doStartWXPay(this, paramServicePay.getTrans_id(), paramServicePay.getMerorder_id(), paramServicePay.getTimestamp(), paramServicePay.getWechat_package(), paramServicePay.getSign(), "1248814701");
      return;
    }
    this.y.doStartWXPay(this, paramServicePay.getTrans_id(), paramServicePay.getMerorder_id(), paramServicePay.getTimestamp(), paramServicePay.getWechat_package(), paramServicePay.getSign(), paramServicePay.getPartnerid());
  }
  
  private void b()
  {
    this.b = ((ImageView)findViewById(2131689492));
    this.a = ((TextView)findViewById(2131690311));
    this.c = ((ListView)findViewById(2131690240));
    this.d = ((TextView)findViewById(2131690316));
    this.e = ((ImageView)findViewById(2131690317));
    this.f = ((TextView)findViewById(2131690319));
    this.g = ((Button)findViewById(2131689816));
    this.A = ((RelativeLayout)findViewById(2131689760));
    this.B = ((TextView)findViewById(2131690312));
    this.E = findViewById(2131690315);
    this.b.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.w = ApplicationEx.c.getUser();
    if (this.w == null) {
      com.ziroom.commonlibrary.login.a.startLoginActivity(this.r);
    }
    this.C = ((TextView)findViewById(2131690313));
    this.y.initWXAPI(this);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.ziroom.ziroomcustomer.activity_1");
    localIntentFilter.setPriority(Integer.MAX_VALUE);
    registerReceiver(this.F, localIntentFilter);
  }
  
  private void e()
  {
    Intent localIntent = new Intent(this.r, ServiceWebActivity.class);
    localIntent.putExtra("title_name", "自如维修卡会员协议");
    localIntent.putExtra("url", "http://www.ziroom.com/zhuanti/2016/czkxy/index.html");
    startActivity(localIntent);
  }
  
  private void f()
  {
    if (this.s == 0) {
      return;
    }
    String str1 = this.w.getMobile();
    String str2 = this.w.getUser_name();
    HashMap localHashMap = new HashMap();
    localHashMap.put("valueCardTypeId", Integer.valueOf(this.z));
    localHashMap.put("phone", str1);
    localHashMap.put("name", str2);
    j.buyRepairCard(this.r, localHashMap, new b());
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131689492: 
      paramView = new Intent(this.r, RepairBuyCardActivity.class);
      paramView.putExtra("cardIndex", this.D + "");
      paramView.putExtra("isBack", "is_Back");
      startActivity(paramView);
      finish();
      return;
    case 2131690319: 
      e();
      return;
    case 2131690317: 
      if (this.s == 0)
      {
        this.s = 1;
        this.e.setImageResource(2130838195);
        this.g.setBackgroundResource(2130838044);
        return;
      }
      this.s = 0;
      this.e.setImageResource(2130838197);
      this.g.setBackgroundColor(-2236963);
      return;
    }
    f();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903148);
    this.r = this;
    b();
    a();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    unregisterReceiver(this.F);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      Intent localIntent = new Intent(this.r, RepairBuyCardActivity.class);
      localIntent.putExtra("cardIndex", this.D + "");
      localIntent.putExtra("isBack", "is_Back");
      startActivity(localIntent);
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public class a
    extends BaseAdapter
  {
    public a() {}
    
    public int getCount()
    {
      return RepairCardPayActivity.e(RepairCardPayActivity.this).size();
    }
    
    public Object getItem(int paramInt)
    {
      return null;
    }
    
    public long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null)
      {
        paramView = View.inflate(RepairCardPayActivity.c(RepairCardPayActivity.this), 2130904534, null);
        paramViewGroup = new a();
        paramViewGroup.a = ((TextView)paramView.findViewById(2131695677));
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        Promotions localPromotions = (Promotions)RepairCardPayActivity.e(RepairCardPayActivity.this).get(paramInt);
        paramViewGroup.a.setText(localPromotions.getPromotionTypeName() + "*" + localPromotions.getSendCount());
        return paramView;
        paramViewGroup = (a)paramView.getTag();
      }
    }
    
    public class a
    {
      public TextView a;
      
      public a() {}
    }
  }
  
  class b
    implements i.a<String>
  {
    b() {}
    
    public void onParse(String paramString, k paramk)
    {
      paramString = com.alibaba.fastjson.a.parseObject(paramString);
      String str = (String)paramString.get("status");
      if (("0".equals(str)) || ("success".equals(str)))
      {
        if (paramString.get("data") != null) {
          paramk.setObject((BuyCard)com.alibaba.fastjson.a.parseObject(paramString.get("data").toString(), BuyCard.class));
        }
        paramk.setSuccess(Boolean.valueOf(true));
        return;
      }
      paramk.setSuccess(Boolean.valueOf(false));
      paramk.setMessage((String)paramString.get("message"));
    }
    
    public void onSuccess(k paramk)
    {
      if (paramk.getSuccess().booleanValue())
      {
        RepairCardPayActivity.a(RepairCardPayActivity.this, (BuyCard)paramk.getObject());
        if ((RepairCardPayActivity.a(RepairCardPayActivity.this) != null) && (RepairCardPayActivity.b(RepairCardPayActivity.this) != null))
        {
          l = Long.parseLong(RepairCardPayActivity.b(RepairCardPayActivity.this).getPayAmount());
          paramk = new HashMap();
          paramk.put("billid", RepairCardPayActivity.b(RepairCardPayActivity.this).getOrderNumber());
          paramk.put("payWay", Integer.valueOf(1));
          paramk.put("payKind", Integer.valueOf(3));
          paramk.put("money", Long.valueOf(l));
          j.payRepairCard(RepairCardPayActivity.c(RepairCardPayActivity.this), paramk, new RepairCardPayActivity.c(RepairCardPayActivity.this));
        }
      }
      while (TextUtils.isEmpty(paramk.getMessage()))
      {
        long l;
        return;
      }
      g.textToast(RepairCardPayActivity.c(RepairCardPayActivity.this), paramk.getMessage());
    }
  }
  
  class c
    implements i.a<String>
  {
    c() {}
    
    public void onParse(String paramString, k paramk)
    {
      paramString = com.alibaba.fastjson.a.parseObject(paramString);
      String str = (String)paramString.get("status");
      if (("0".equals(str)) || ("success".equals(str)))
      {
        if (paramString.get("data") != null) {
          paramk.setObject((ServicePay)com.alibaba.fastjson.a.parseObject(paramString.get("data").toString(), ServicePay.class));
        }
        paramk.setSuccess(Boolean.valueOf(true));
        return;
      }
      paramk.setSuccess(Boolean.valueOf(false));
    }
    
    public void onSuccess(k paramk)
    {
      if (paramk.getSuccess().booleanValue())
      {
        RepairCardPayActivity.a(RepairCardPayActivity.this, (ServicePay)paramk.getObject());
        if (RepairCardPayActivity.d(RepairCardPayActivity.this) != null) {
          RepairCardPayActivity.b(RepairCardPayActivity.this, RepairCardPayActivity.d(RepairCardPayActivity.this));
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/activity/RepairCardPayActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */