package com.ziroom.ziroomcustomer.newrepair.activity;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.e.d;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.b;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.newServiceList.model.ap;
import com.ziroom.ziroomcustomer.newchat.chatcenter.activity.ChatWebViewActivity;
import com.ziroom.ziroomcustomer.newrepair.b.k;
import com.ziroom.ziroomcustomer.newrepair.dialog.RepairCostDetailDialog;
import com.ziroom.ziroomcustomer.newrepair.fragment.InternalRepairDetailFragment;
import com.ziroom.ziroomcustomer.newrepair.fragment.InternalRepairStateFragment;
import com.ziroom.ziroomcustomer.newrepair.widget.ElasticScrollView;
import com.ziroom.ziroomcustomer.newrepair.widget.ElasticScrollView.a;
import com.ziroom.ziroomcustomer.util.ah;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class UrgencyRepairActivity
  extends BaseActivity
  implements View.OnClickListener, ElasticScrollView.a
{
  private RelativeLayout A;
  private TextView B;
  private com.ziroom.ziroomcustomer.newrepair.b.c C;
  private String D;
  private String E;
  private boolean F = false;
  private int G = 0;
  private double H;
  private String I;
  private d J = null;
  private int K;
  private SimpleDraweeView L;
  private BroadcastReceiver M = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if (paramAnonymousIntent.getAction().equals("com.ziroom.ziroomcustomer.activity_1")) {
        UrgencyRepairActivity.r(UrgencyRepairActivity.this);
      }
    }
  };
  private Context a;
  private android.support.v4.app.FragmentManager b;
  private InternalRepairDetailFragment c;
  private InternalRepairStateFragment d;
  private LinearLayout e;
  private ImageView f;
  private RelativeLayout g;
  private TextView r;
  private View s;
  private ImageView t;
  private RelativeLayout u;
  private TextView v;
  private View w;
  private ElasticScrollView x;
  private LinearLayout y;
  private Button z;
  
  private void a()
  {
    this.x.setonRefreshListener(this);
    this.g.setOnClickListener(this);
    this.u.setOnClickListener(this);
    this.z.setOnClickListener(this);
    this.A.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.t.setOnClickListener(this);
  }
  
  private void a(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      paramBundle = this.b.getFragments().iterator();
      while (paramBundle.hasNext())
      {
        Fragment localFragment = (Fragment)paramBundle.next();
        if ((localFragment instanceof InternalRepairDetailFragment)) {
          this.c = ((InternalRepairDetailFragment)localFragment);
        } else if ((localFragment instanceof InternalRepairStateFragment)) {
          this.d = ((InternalRepairStateFragment)localFragment);
        }
      }
      this.b.beginTransaction().show(this.c).hide(this.d).commit();
      return;
    }
    this.d = InternalRepairStateFragment.getInstance();
    this.c = InternalRepairDetailFragment.getInstance();
    this.b.beginTransaction().add(2131692620, this.d).add(2131692620, this.c).hide(this.d).commit();
  }
  
  private void a(ap paramap)
  {
    if (TextUtils.isEmpty(paramap.getPartnerid()))
    {
      this.J.doStartWXPay(this, paramap.getTrans_id(), paramap.getMerorder_id(), paramap.getTimestamp(), paramap.get_package(), paramap.getSign(), "1248814701");
      return;
    }
    this.J.doStartWXPay(this, paramap.getTrans_id(), paramap.getMerorder_id(), paramap.getTimestamp(), paramap.get_package(), paramap.getSign(), paramap.getPartnerid());
  }
  
  private void b()
  {
    this.K = getIntent().getIntExtra("isReminderStatus", -1);
    this.D = getIntent().getStringExtra("orderCode");
    this.E = getIntent().getStringExtra("orderCodeType");
    if (ah.isNetworkAvailable(this.a))
    {
      e();
      return;
    }
    g.textToast(this.a, "请检查网络！");
    f();
  }
  
  private void b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      this.y.setVisibility(8);
    case 0: 
      do
      {
        return;
        if ((paramInt == 0) && (this.K == 1))
        {
          this.y.setVisibility(0);
          this.z.setText("催单");
          this.z.setBackgroundColor(getResources().getColor(2131624516));
          this.z.setTextColor(getResources().getColor(2131624583));
          this.z.setClickable(true);
          return;
        }
      } while ((paramInt != 0) || (this.K == 1));
      this.y.setVisibility(8);
      return;
    case 5: 
    case 10: 
      this.y.setVisibility(8);
      return;
    case 15: 
      this.y.setVisibility(0);
      this.z.setText("去确认");
      this.z.setBackgroundColor(getResources().getColor(2131624046));
      this.z.setTextColor(getResources().getColor(2131624583));
      this.z.setClickable(false);
      return;
    case 20: 
      this.y.setVisibility(0);
      this.z.setText("去确认");
      this.z.setBackgroundColor(getResources().getColor(2131624516));
      this.z.setTextColor(getResources().getColor(2131624583));
      this.z.setClickable(true);
      return;
    case 25: 
      this.y.setVisibility(0);
      this.z.setText("去验收");
      this.z.setBackgroundColor(getResources().getColor(2131624046));
      this.z.setTextColor(getResources().getColor(2131624583));
      this.z.setClickable(false);
      return;
    case 30: 
      this.y.setVisibility(0);
      this.z.setText("去验收");
      this.z.setBackgroundColor(getResources().getColor(2131624516));
      this.z.setTextColor(getResources().getColor(2131624583));
      this.z.setClickable(true);
      return;
    case 35: 
      this.y.setVisibility(0);
      if (this.C.getIsPay() == 1) {
        this.z.setText("立即支付");
      }
      for (;;)
      {
        this.z.setBackgroundColor(getResources().getColor(2131624516));
        this.z.setTextColor(getResources().getColor(2131624583));
        this.z.setClickable(true);
        return;
        this.z.setText("去评价");
      }
    }
    this.y.setVisibility(8);
  }
  
  private void e()
  {
    showProgressNoCancel("", 30000L);
    HashMap localHashMap = new HashMap();
    localHashMap.put("orderCode", this.D);
    localHashMap.put("orderCodeType", this.E);
    com.ziroom.ziroomcustomer.e.j.getInternalOrderDetail(this.a, localHashMap, new b(new com.ziroom.ziroomcustomer.newrepair.utils.b(com.ziroom.ziroomcustomer.newrepair.b.c.class)));
  }
  
  private void f()
  {
    showEmptyView(this.e, "点击重试").setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if (ah.isNetworkAvailable(UrgencyRepairActivity.g(UrgencyRepairActivity.this)))
        {
          UrgencyRepairActivity.o(UrgencyRepairActivity.this);
          return;
        }
        g.textToast(UrgencyRepairActivity.g(UrgencyRepairActivity.this), "请检查网络！");
      }
    });
  }
  
  private void g()
  {
    this.e = ((LinearLayout)findViewById(2131689998));
    this.x = ((ElasticScrollView)findViewById(2131692619));
    FrameLayout localFrameLayout = (FrameLayout)View.inflate(this.a, 2130903541, null);
    localFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
    localFrameLayout.setBackgroundResource(2131624583);
    this.x.addChild(localFrameLayout);
    this.g = ((RelativeLayout)findViewById(2131692614));
    this.r = ((TextView)findViewById(2131690407));
    this.s = findViewById(2131692615);
    this.f = ((ImageView)findViewById(2131690694));
    this.t = ((ImageView)findViewById(2131689492));
    this.u = ((RelativeLayout)findViewById(2131692616));
    this.v = ((TextView)findViewById(2131692617));
    this.w = findViewById(2131692618);
    this.y = ((LinearLayout)findViewById(2131691870));
    this.y.setTag("humanControlled");
    this.z = ((Button)findViewById(2131689843));
    this.A = ((RelativeLayout)findViewById(2131691806));
    this.B = ((TextView)findViewById(2131689912));
    this.r.setTextColor(getResources().getColor(2131624039));
    this.s.setVisibility(8);
    this.v.setTextColor(getResources().getColor(2131624516));
    this.w.setVisibility(0);
    this.L = ((SimpleDraweeView)findViewById(2131690027));
  }
  
  private void h()
  {
    final Dialog localDialog = new Dialog(this, 2131427692);
    View localView = getLayoutInflater().inflate(2130903806, null);
    Object localObject1 = (TextView)localView.findViewById(2131691288);
    Object localObject2 = (TextView)localView.findViewById(2131689846);
    RelativeLayout localRelativeLayout = (RelativeLayout)localView.findViewById(2131693701);
    TextView localTextView = (TextView)localView.findViewById(2131693699);
    ((TextView)localObject2).setText(this.I);
    ((TextView)localObject1).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        localDialog.dismiss();
      }
    });
    localRelativeLayout.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        UrgencyRepairActivity.p(UrgencyRepairActivity.this);
      }
    });
    localDialog.setCanceledOnTouchOutside(true);
    localObject1 = localDialog.getWindow();
    ((Window)localObject1).getDecorView().setPadding(0, 0, 0, 0);
    localObject2 = ((Window)localObject1).getAttributes();
    ((WindowManager.LayoutParams)localObject2).width = -1;
    ((WindowManager.LayoutParams)localObject2).height = -2;
    ((Window)localObject1).setAttributes((WindowManager.LayoutParams)localObject2);
    ((Window)localObject1).setGravity(80);
    localDialog.setContentView(localView);
    if (!(localDialog instanceof Dialog))
    {
      localDialog.show();
      return;
    }
    VdsAgent.showDialog((Dialog)localDialog);
  }
  
  private void i()
  {
    showProgressNoCancel("正在请求订单号,请稍候...", 30000L);
    HashMap localHashMap = new HashMap();
    localHashMap.put("billid", this.C.getMainBillCode());
    localHashMap.put("money", this.I);
    localHashMap.put("orderPrice", this.I);
    localHashMap.put("payKind", Integer.valueOf(1));
    localHashMap.put("payWay", Integer.valueOf(1));
    localHashMap.put("promoCode", "");
    localHashMap.put("sourceType", Integer.valueOf(0));
    localHashMap.put("cityCode", com.ziroom.ziroomcustomer.base.b.d);
    com.ziroom.ziroomcustomer.e.j.payForInternalOrder(this.a, localHashMap, new c(new com.ziroom.ziroomcustomer.newrepair.utils.b(ap.class)));
  }
  
  private void j()
  {
    showProgressNoCancel("", 30000L);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.C.getWxxmList().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((com.ziroom.ziroomcustomer.newrepair.b.l)localIterator.next()).getWxxmId());
    }
    com.ziroom.ziroomcustomer.e.j.cancelInternalRepairOrder(this.a, "", new a(new com.ziroom.ziroomcustomer.newrepair.utils.b(null)), localArrayList);
  }
  
  private void k()
  {
    RepairCostDetailDialog localRepairCostDetailDialog = RepairCostDetailDialog.getInstance();
    Object localObject = new Bundle();
    ((Bundle)localObject).putSerializable("repairDetail", this.C.getSchemeList());
    ((Bundle)localObject).putSerializable("totalMoney", this.I);
    localRepairCostDetailDialog.setArguments((Bundle)localObject);
    localObject = getFragmentManager();
    if (!(localRepairCostDetailDialog instanceof DialogFragment))
    {
      localRepairCostDetailDialog.show((android.app.FragmentManager)localObject, "repairDetail");
      return;
    }
    VdsAgent.showDialogFragment((DialogFragment)localRepairCostDetailDialog, (android.app.FragmentManager)localObject, "repairDetail");
  }
  
  private void l()
  {
    this.J = new d();
    this.J.initWXAPI(this);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("refresh_card");
    localIntentFilter.addAction("com.ziroom.ziroomcustomer.activity_1");
    registerReceiver(this.M, localIntentFilter);
  }
  
  private void m()
  {
    Intent localIntent = new Intent(this.a, InternalRepairEvalActivity.class);
    localIntent.putExtra("headUrl", this.C.getSPic());
    localIntent.putExtra("name", this.C.getSName());
    localIntent.putExtra("mailBillId", this.C.getMainBillCode());
    localIntent.putExtra("orderNum", this.C.getBillnum());
    localIntent.putExtra("serverId", this.C.getsId());
    startActivity(localIntent);
    finish();
  }
  
  public void changeButtonState(int paramInt, Map<String, Object> paramMap, String paramString)
  {
    this.z.setText(paramString);
    if (paramInt == 0)
    {
      this.A.setVisibility(8);
      return;
    }
    this.A.setVisibility(0);
    this.B.setText((String)paramMap.get("price"));
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 != -1) {}
    do
    {
      return;
      if (paramInt1 == 333)
      {
        if (paramIntent.getBooleanExtra("giveUp", false))
        {
          m();
          return;
        }
        onRefresh();
        return;
      }
      if (paramInt1 == 999)
      {
        if (paramIntent.getBooleanExtra("eval", true))
        {
          finish();
          return;
        }
        onRefresh();
        return;
      }
    } while (paramInt1 != 666);
    if (paramIntent.getBooleanExtra("isPay", false))
    {
      onRefresh();
      return;
    }
    m();
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
    case 2131690694: 
    case 2131692614: 
    case 2131692616: 
    case 2131689843: 
      do
      {
        Fragment localFragment;
        do
        {
          do
          {
            do
            {
              return;
              startActivity(new Intent(this, ChatWebViewActivity.class));
              return;
            } while (this.F);
            paramView = this.b.getFragments();
          } while (paramView == null);
          paramView = paramView.iterator();
          while (paramView.hasNext())
          {
            localFragment = (Fragment)paramView.next();
            if ((localFragment instanceof InternalRepairDetailFragment)) {
              this.c = ((InternalRepairDetailFragment)localFragment);
            } else if ((localFragment instanceof InternalRepairStateFragment)) {
              this.d = ((InternalRepairStateFragment)localFragment);
            }
          }
          this.b.beginTransaction().show(this.d).hide(this.c).commit();
          this.r.setTextColor(getResources().getColor(2131624516));
          this.s.setVisibility(0);
          this.v.setTextColor(getResources().getColor(2131624039));
          this.w.setVisibility(8);
          this.F = true;
          return;
        } while (!this.F);
        paramView = this.b.getFragments().iterator();
        while (paramView.hasNext())
        {
          localFragment = (Fragment)paramView.next();
          if ((localFragment instanceof InternalRepairDetailFragment)) {
            this.c = ((InternalRepairDetailFragment)localFragment);
          } else if ((localFragment instanceof InternalRepairStateFragment)) {
            this.d = ((InternalRepairStateFragment)localFragment);
          }
        }
        this.b.beginTransaction().show(this.c).hide(this.d).commit();
        this.r.setTextColor(getResources().getColor(2131624039));
        this.s.setVisibility(8);
        this.v.setTextColor(getResources().getColor(2131624516));
        this.w.setVisibility(0);
        this.F = false;
        return;
        switch (this.G)
        {
        default: 
          return;
        }
      } while (this.K != 1);
      com.ziroom.ziroomcustomer.e.j.promptInternalRepairOrder(this.a, this.D, new d(new com.ziroom.ziroomcustomer.newrepair.utils.b(null)));
      return;
      paramView = new Intent(this.a, InternalRepairPlanActivity.class);
      paramView.putExtra("isDetail", false);
      paramView.putExtra("mailBillId", this.C.getMainBillCode());
      startActivityForResult(paramView, 333);
      return;
      paramView = new Intent(this.a, InternalRepairPlanActivity.class);
      paramView.putExtra("isDetail", true);
      paramView.putExtra("mailBillId", this.C.getMainBillCode());
      startActivityForResult(paramView, 666);
      return;
      if (this.C.getIsPay() == 1)
      {
        h();
        return;
      }
      m();
      return;
    case 2131691806: 
      if (this.H == 0.0D)
      {
        g.textToast(this.a, "获取支付明细数据失败！");
        return;
      }
      k();
      return;
    }
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903540);
    this.a = this;
    g();
    this.b = getSupportFragmentManager();
    a(paramBundle);
    a();
    b();
  }
  
  public void onRefresh()
  {
    e();
  }
  
  public void onScroll(int paramInt) {}
  
  public void showCancelOrderDialog()
  {
    com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(this.a).setTitle("取消订单").setContent("是否确认取消订单").setOnConfirmClickListener(new c.b()
    {
      public void onClick(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean) {
          UrgencyRepairActivity.q(UrgencyRepairActivity.this);
        }
      }
    }).build().show();
  }
  
  class a
    extends com.freelxl.baselibrary.d.c.a<com.ziroom.ziroomcustomer.e.l>
  {
    public a(com.freelxl.baselibrary.d.f.a parama)
    {
      super();
    }
    
    public void onFailure(Throwable paramThrowable)
    {
      com.ziroom.ziroomcustomer.newrepair.utils.c.catchExp(paramThrowable);
      UrgencyRepairActivity.this.dismissProgress();
    }
    
    public void onSuccess(int paramInt, com.ziroom.ziroomcustomer.e.l paraml)
    {
      UrgencyRepairActivity.this.dismissProgress();
      if (paraml.getSuccess().booleanValue())
      {
        g.textToast(UrgencyRepairActivity.g(UrgencyRepairActivity.this), "取消订单成功！");
        UrgencyRepairActivity.this.finish();
        return;
      }
      paraml = paraml.getMessage();
      g.textToast(UrgencyRepairActivity.g(UrgencyRepairActivity.this), paraml);
    }
  }
  
  class b
    extends com.freelxl.baselibrary.d.c.a<com.ziroom.ziroomcustomer.e.l>
  {
    public b(com.freelxl.baselibrary.d.f.a parama)
    {
      super();
    }
    
    public void onFailure(Throwable paramThrowable)
    {
      com.ziroom.ziroomcustomer.newrepair.utils.c.catchExp(paramThrowable);
      UrgencyRepairActivity.this.dismissProgress();
      UrgencyRepairActivity.a(UrgencyRepairActivity.this).onRefreshComplete();
      UrgencyRepairActivity.n(UrgencyRepairActivity.this);
    }
    
    public void onSuccess(int paramInt, com.ziroom.ziroomcustomer.e.l paraml)
    {
      UrgencyRepairActivity.a(UrgencyRepairActivity.this).onRefreshComplete();
      if (paraml.getSuccess().booleanValue())
      {
        UrgencyRepairActivity.a(UrgencyRepairActivity.this, (com.ziroom.ziroomcustomer.newrepair.b.c)paraml.getObject());
        if (UrgencyRepairActivity.b(UrgencyRepairActivity.this) != null)
        {
          UrgencyRepairActivity.a(UrgencyRepairActivity.this, UrgencyRepairActivity.b(UrgencyRepairActivity.this).getNewState());
          UrgencyRepairActivity.b(UrgencyRepairActivity.this, UrgencyRepairActivity.c(UrgencyRepairActivity.this));
          UrgencyRepairActivity.d(UrgencyRepairActivity.this).initData(UrgencyRepairActivity.b(UrgencyRepairActivity.this).getSPhone(), UrgencyRepairActivity.b(UrgencyRepairActivity.this).getOrderStatusList());
          UrgencyRepairActivity.e(UrgencyRepairActivity.this).initData(UrgencyRepairActivity.b(UrgencyRepairActivity.this));
          if (TextUtils.isEmpty(UrgencyRepairActivity.b(UrgencyRepairActivity.this).getsId())) {
            UrgencyRepairActivity.f(UrgencyRepairActivity.this).setVisibility(8);
          }
          for (;;)
          {
            if ((UrgencyRepairActivity.b(UrgencyRepairActivity.this).getIsPay() == 1) && (UrgencyRepairActivity.c(UrgencyRepairActivity.this) == 35))
            {
              UrgencyRepairActivity.h(UrgencyRepairActivity.this);
              paraml = UrgencyRepairActivity.b(UrgencyRepairActivity.this).getSchemeList();
              if ((paraml != null) && (paraml.size() > 0))
              {
                UrgencyRepairActivity.i(UrgencyRepairActivity.this).setVisibility(0);
                UrgencyRepairActivity.a(UrgencyRepairActivity.this, 0.0D);
                paraml = paraml.iterator();
                for (;;)
                {
                  if (paraml.hasNext())
                  {
                    k localk = (k)paraml.next();
                    UrgencyRepairActivity.a(UrgencyRepairActivity.this, UrgencyRepairActivity.j(UrgencyRepairActivity.this) + localk.getTotalPrice() * localk.getUsedNum());
                    continue;
                    paraml = new Bundle();
                    paraml.putString("thumbType", "repair");
                    paraml.putString("showType", "detail");
                    paraml.putString("orderCode", UrgencyRepairActivity.b(UrgencyRepairActivity.this).getMainBillCode());
                    paraml.putString("orderNum", UrgencyRepairActivity.b(UrgencyRepairActivity.this).getBillnum());
                    paraml.putString("employeeCode", UrgencyRepairActivity.b(UrgencyRepairActivity.this).getsId());
                    com.ziroom.ziroomcustomer.newServiceList.utils.j.setServantThumb(UrgencyRepairActivity.g(UrgencyRepairActivity.this), UrgencyRepairActivity.f(UrgencyRepairActivity.this), paraml);
                    break;
                  }
                }
                UrgencyRepairActivity.a(UrgencyRepairActivity.this, String.format("%.2f", new Object[] { Double.valueOf(UrgencyRepairActivity.j(UrgencyRepairActivity.this)) }));
                UrgencyRepairActivity.l(UrgencyRepairActivity.this).setText(UrgencyRepairActivity.k(UrgencyRepairActivity.this));
                UrgencyRepairActivity.this.closeEmpty(UrgencyRepairActivity.m(UrgencyRepairActivity.this));
              }
            }
          }
        }
      }
      for (;;)
      {
        UrgencyRepairActivity.this.dismissProgress();
        return;
        UrgencyRepairActivity.a(UrgencyRepairActivity.this, String.format("%.2f", new Object[] { Double.valueOf(UrgencyRepairActivity.j(UrgencyRepairActivity.this)) }));
        UrgencyRepairActivity.l(UrgencyRepairActivity.this).setText(UrgencyRepairActivity.k(UrgencyRepairActivity.this));
        UrgencyRepairActivity.i(UrgencyRepairActivity.this).setVisibility(0);
        break;
        UrgencyRepairActivity.i(UrgencyRepairActivity.this).setVisibility(8);
        break;
        g.textToast(UrgencyRepairActivity.g(UrgencyRepairActivity.this), "获取数据失败，请稍后再试！");
        UrgencyRepairActivity.n(UrgencyRepairActivity.this);
        continue;
        paraml = paraml.getMessage();
        g.textToast(UrgencyRepairActivity.g(UrgencyRepairActivity.this), paraml);
        UrgencyRepairActivity.n(UrgencyRepairActivity.this);
      }
    }
  }
  
  class c
    extends com.freelxl.baselibrary.d.c.a<com.ziroom.ziroomcustomer.e.l>
  {
    public c(com.freelxl.baselibrary.d.f.a parama)
    {
      super();
    }
    
    public void onFailure(Throwable paramThrowable)
    {
      com.ziroom.ziroomcustomer.newrepair.utils.c.catchExp(paramThrowable);
      UrgencyRepairActivity.this.dismissProgress();
      g.textToast(UrgencyRepairActivity.g(UrgencyRepairActivity.this), "支付失败，请重试");
    }
    
    public void onSuccess(int paramInt, com.ziroom.ziroomcustomer.e.l paraml)
    {
      if (paraml.getSuccess().booleanValue())
      {
        paraml = (ap)paraml.getObject();
        if (paraml != null) {
          UrgencyRepairActivity.a(UrgencyRepairActivity.this, paraml);
        }
      }
      for (;;)
      {
        UrgencyRepairActivity.this.dismissProgress();
        return;
        g.textToast(UrgencyRepairActivity.g(UrgencyRepairActivity.this), "支付失败，请重试");
        continue;
        paraml = paraml.getMessage();
        if (paraml != null) {
          g.textToast(UrgencyRepairActivity.g(UrgencyRepairActivity.this), paraml);
        } else {
          g.textToast(UrgencyRepairActivity.g(UrgencyRepairActivity.this), "支付失败，请重试");
        }
      }
    }
  }
  
  class d
    extends com.freelxl.baselibrary.d.c.a<com.ziroom.ziroomcustomer.e.l>
  {
    public d(com.freelxl.baselibrary.d.f.a parama)
    {
      super();
    }
    
    public void onFailure(Throwable paramThrowable)
    {
      com.ziroom.ziroomcustomer.newrepair.utils.c.catchExp(paramThrowable);
      g.textToast(UrgencyRepairActivity.g(UrgencyRepairActivity.this), "催单单失败，请稍后重试！");
      UrgencyRepairActivity.this.dismissProgress();
    }
    
    public void onSuccess(int paramInt, com.ziroom.ziroomcustomer.e.l paraml)
    {
      if (paraml.getSuccess().booleanValue())
      {
        g.textToast(UrgencyRepairActivity.g(UrgencyRepairActivity.this), "催单成功！");
        UrgencyRepairActivity.this.onRefresh();
      }
      for (;;)
      {
        UrgencyRepairActivity.this.dismissProgress();
        return;
        paraml = paraml.getMessage();
        g.textToast(UrgencyRepairActivity.g(UrgencyRepairActivity.this), paraml);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newrepair/activity/UrgencyRepairActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */