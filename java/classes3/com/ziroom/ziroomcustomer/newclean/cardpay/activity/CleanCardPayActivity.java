package com.ziroom.ziroomcustomer.newclean.cardpay.activity;

import android.app.Activity;
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
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.a.d;
import com.ziroom.ziroomcustomer.e.c.f;
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newServiceList.activity.ServiceWebActivity;
import com.ziroom.ziroomcustomer.newclean.cardpay.model.BuyCard;
import com.ziroom.ziroomcustomer.newclean.cardpay.model.Promotions;
import com.ziroom.ziroomcustomer.newclean.d.bc;
import com.ziroom.ziroomcustomer.util.u;
import java.util.List;
import java.util.Map;

public class CleanCardPayActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private TextView A;
  private int B = 0;
  private View C;
  private BroadcastReceiver D = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if ((paramAnonymousIntent != null) && (paramAnonymousIntent.getIntExtra("code", -1) == 1))
      {
        paramAnonymousContext = new Intent();
        paramAnonymousContext.setAction("refresh_card");
        ApplicationEx.c.sendBroadcast(paramAnonymousContext);
        paramAnonymousContext = CleanCardPayActivity.this.getIntent();
        paramAnonymousContext.putExtra("result", true);
        CleanCardPayActivity.this.setResult(-1, paramAnonymousContext);
        CleanCardPayActivity.this.finish();
      }
      while ((paramAnonymousIntent == null) || (paramAnonymousIntent.getStringExtra("message") == null)) {
        return;
      }
      g.textToast(CleanCardPayActivity.this, paramAnonymousIntent.getStringExtra("message"));
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
  private int x;
  private RelativeLayout y;
  private TextView z;
  
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
      this.y.setVisibility(0);
      this.c.setAdapter(new a());
      this.C.setVisibility(0);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(str4))
      {
        this.d.setText(Long.parseLong(str4) / 100L + ".00");
        this.z.setText(Long.parseLong(str4) / 100L + ".00元");
      }
      if (!TextUtils.isEmpty(str3)) {}
      try
      {
        this.x = Integer.parseInt(str3);
        if (!TextUtils.isEmpty(str1)) {
          this.A.setText(str1 + "个月");
        }
        if (!TextUtils.isEmpty(str2)) {
          this.B = Integer.parseInt(str2);
        }
        return;
        this.y.setVisibility(8);
        this.C.setVisibility(8);
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
  
  private void b()
  {
    this.b = ((ImageView)findViewById(2131689492));
    this.a = ((TextView)findViewById(2131690311));
    this.c = ((ListView)findViewById(2131690240));
    this.d = ((TextView)findViewById(2131690316));
    this.e = ((ImageView)findViewById(2131690317));
    this.f = ((TextView)findViewById(2131690319));
    this.g = ((Button)findViewById(2131689816));
    this.y = ((RelativeLayout)findViewById(2131689760));
    this.z = ((TextView)findViewById(2131690312));
    this.C = findViewById(2131690315);
    this.b.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.w = ApplicationEx.c.getUser();
    if (this.w == null) {
      com.ziroom.commonlibrary.login.a.startLoginActivity(this.r);
    }
    this.A = ((TextView)findViewById(2131690313));
    registerReceiver(this.D, new IntentFilter("com.ziroom.ziroomcustomer.payresult"));
  }
  
  private void e()
  {
    Intent localIntent = new Intent(this.r, ServiceWebActivity.class);
    localIntent.putExtra("title_name", "自如保洁卡会员协议");
    localIntent.putExtra("url", "http://www.ziroom.com/zhuanti/2016/czkxy/index.html");
    startActivity(localIntent);
  }
  
  private void f()
  {
    if (this.s == 0) {}
    String str1;
    String str2;
    do
    {
      return;
      str1 = this.w.getMobile();
      str2 = this.w.getUser_name();
    } while (this.w == null);
    n.buyCleanCard(this.r, this.x, this.w.getUid(), str1, str2, "", new b(), true);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    com.ziroom.ziroomcustomer.payment.a.onActivityResult(this, paramInt1, paramInt2, paramIntent);
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
      paramView = new Intent(this.r, CleanBuyCardActivity.class);
      paramView.putExtra("cardIndex", this.B + "");
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
    unregisterReceiver(this.D);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      Intent localIntent = new Intent(this.r, CleanBuyCardActivity.class);
      localIntent.putExtra("cardIndex", this.B + "");
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
      return CleanCardPayActivity.d(CleanCardPayActivity.this).size();
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
        paramView = View.inflate(CleanCardPayActivity.c(CleanCardPayActivity.this), 2130904534, null);
        paramViewGroup = new a();
        paramViewGroup.a = ((TextView)paramView.findViewById(2131695677));
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        Promotions localPromotions = (Promotions)CleanCardPayActivity.d(CleanCardPayActivity.this).get(paramInt);
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
    
    public void onParse(String paramString, com.freelxl.baselibrary.e.k paramk)
    {
      u.e("dsgdsgh:", com.ziroom.ziroomcustomer.util.k.decrypt(paramString));
      paramString = com.alibaba.fastjson.a.parseObject(com.ziroom.ziroomcustomer.util.k.decrypt(paramString));
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
    
    public void onSuccess(com.freelxl.baselibrary.e.k paramk)
    {
      if (paramk.getSuccess().booleanValue())
      {
        CleanCardPayActivity.a(CleanCardPayActivity.this, (BuyCard)paramk.getObject());
        if ((CleanCardPayActivity.a(CleanCardPayActivity.this) != null) && (CleanCardPayActivity.b(CleanCardPayActivity.this) != null))
        {
          l = Long.parseLong(CleanCardPayActivity.b(CleanCardPayActivity.this).getPayAmount());
          n.requestServicePayment(CleanCardPayActivity.c(CleanCardPayActivity.this), CleanCardPayActivity.a(CleanCardPayActivity.this).getUid(), CleanCardPayActivity.b(CleanCardPayActivity.this).getOrderNumber(), 1, 3, l, null, null, new d(CleanCardPayActivity.c(CleanCardPayActivity.this), new f(bc.class))
          {
            public void onSuccess(int paramAnonymousInt, bc paramAnonymousbc)
            {
              super.onSuccess(paramAnonymousInt, paramAnonymousbc);
              com.ziroom.ziroomcustomer.payment.a.startPayActivty((Activity)CleanCardPayActivity.c(CleanCardPayActivity.this), paramAnonymousbc.getAmount(), "ChuzhiCard", paramAnonymousbc.getOrderIds(), paramAnonymousbc.getSystemId(), paramAnonymousbc.getTimeInterval().toString());
            }
          });
        }
      }
      while (TextUtils.isEmpty(paramk.getMessage()))
      {
        long l;
        return;
      }
      g.textToast(CleanCardPayActivity.c(CleanCardPayActivity.this), paramk.getMessage());
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/cardpay/activity/CleanCardPayActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */