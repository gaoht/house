package com.ziroom.ziroomcustomer.newServiceList.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.c;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.b;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.l;
import com.ziroom.ziroomcustomer.e.o;
import com.ziroom.ziroomcustomer.model.Contract;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newServiceList.model.al;
import com.ziroom.ziroomcustomer.newServiceList.model.am;
import com.ziroom.ziroomcustomer.newServiceList.utils.i;
import com.ziroom.ziroomcustomer.newrepair.activity.RepairEvaluationsActivity;
import com.ziroom.ziroomcustomer.util.m;
import java.util.ArrayList;
import java.util.List;

public class RepairNewDetailActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private TextView A;
  private TextView B;
  private TextView C;
  private TextView D;
  private TextView E;
  private Button F;
  private Intent G;
  private Contract H;
  private UserInfo I;
  private TextView J;
  private TextView K;
  private TextView L;
  private TextView M;
  private TextView N;
  private TextView O;
  private TextView P;
  private Context Q;
  private al R;
  private Handler S = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      l locall = (l)paramAnonymousMessage.obj;
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      case 69958: 
        if (locall.getSuccess().booleanValue()) {
          if (locall.getObject() != null)
          {
            paramAnonymousMessage = (am)locall.getObject();
            RepairNewDetailActivity.this.b = paramAnonymousMessage.getData();
            if ((RepairNewDetailActivity.this.b == null) || (RepairNewDetailActivity.this.b.size() <= 0)) {
              break label172;
            }
            RepairNewDetailActivity.this.a.addAll(RepairNewDetailActivity.this.b);
            RepairNewDetailActivity.d(RepairNewDetailActivity.this);
            RepairNewDetailActivity.e(RepairNewDetailActivity.this);
            RepairNewDetailActivity.f(RepairNewDetailActivity.this);
            RepairNewDetailActivity.g(RepairNewDetailActivity.this);
            RepairNewDetailActivity.h(RepairNewDetailActivity.this).setOnClickListener(RepairNewDetailActivity.this);
          }
        }
        for (;;)
        {
          RepairNewDetailActivity.this.dismissProgress();
          return;
          label172:
          g.textToast(RepairNewDetailActivity.b(RepairNewDetailActivity.this), "数据异常，请稍后再试");
          RepairNewDetailActivity.h(RepairNewDetailActivity.this).setVisibility(8);
          RepairNewDetailActivity.i(RepairNewDetailActivity.this).setVisibility(8);
          continue;
          g.textToast(RepairNewDetailActivity.b(RepairNewDetailActivity.this), locall.getMessage());
          RepairNewDetailActivity.h(RepairNewDetailActivity.this).setVisibility(8);
          RepairNewDetailActivity.i(RepairNewDetailActivity.this).setVisibility(8);
        }
      }
      if (locall.getSuccess().booleanValue())
      {
        paramAnonymousMessage = new Intent();
        paramAnonymousMessage.setAction("repair_order_delete");
        RepairNewDetailActivity.this.sendBroadcast(paramAnonymousMessage);
        RepairNewDetailActivity.this.finish();
        g.textToast(RepairNewDetailActivity.b(RepairNewDetailActivity.this), "取消成功");
      }
      for (;;)
      {
        RepairNewDetailActivity.this.dismissProgress();
        return;
        g.textToast(RepairNewDetailActivity.b(RepairNewDetailActivity.this), locall.getMessage());
      }
    }
  };
  List<al> a = new ArrayList();
  List<al> b;
  private ImageView c;
  private ImageView d;
  private ImageView e;
  private ImageView f;
  private ImageView g;
  private View r;
  private View s;
  private View t;
  private View u;
  private View v;
  private TextView w;
  private TextView x;
  private TextView y;
  private TextView z;
  
  private void a()
  {
    this.c = ((ImageView)findViewById(2131689492));
    this.d = ((ImageView)findViewById(2131692114));
    this.e = ((ImageView)findViewById(2131692115));
    this.f = ((ImageView)findViewById(2131692117));
    this.g = ((ImageView)findViewById(2131692119));
    this.r = findViewById(2131692113);
    this.s = findViewById(2131690395);
    this.t = findViewById(2131692116);
    this.u = findViewById(2131692118);
    this.v = findViewById(2131692120);
    this.P = ((TextView)findViewById(2131691288));
    this.K = ((TextView)findViewById(2131690909));
    this.L = ((TextView)findViewById(2131692121));
    this.M = ((TextView)findViewById(2131692122));
    this.N = ((TextView)findViewById(2131692123));
    this.w = ((TextView)findViewById(2131697394));
    this.x = ((TextView)findViewById(2131697396));
    this.y = ((TextView)findViewById(2131697397));
    this.z = ((TextView)findViewById(2131697398));
    this.A = ((TextView)findViewById(2131690307));
    this.B = ((TextView)findViewById(2131690388));
    this.C = ((TextView)findViewById(2131690373));
    this.D = ((TextView)findViewById(2131690666));
    this.E = ((TextView)findViewById(2131689923));
    this.F = ((Button)findViewById(2131689843));
    this.J = ((TextView)findViewById(2131697395));
    this.O = ((TextView)findViewById(2131697399));
    this.c.setOnClickListener(this);
    this.P.setOnClickListener(this);
  }
  
  private void a(final al paramal)
  {
    c.newBuilder(this.Q).setTitle("提示").setContent("您确认取消该维修单?").setOnConfirmClickListener(new c.b()
    {
      public void onClick(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if ((paramAnonymousBoolean) && (RepairNewDetailActivity.a(RepairNewDetailActivity.this) != null))
        {
          o.revokeRepair(RepairNewDetailActivity.b(RepairNewDetailActivity.this), RepairNewDetailActivity.c(RepairNewDetailActivity.this), m.GetNowDate(), RepairNewDetailActivity.a(RepairNewDetailActivity.this).getLogin_name_mobile(), paramal.getWxxmId(), "");
          RepairNewDetailActivity.this.showProgress("");
        }
      }
    }).build().show();
  }
  
  private void b()
  {
    showProgress("");
    this.I = ((ApplicationEx)getApplication()).getUser();
    String str1 = getIntent().getStringExtra("maintainOrderCode");
    this.H = ((Contract)getIntent().getSerializableExtra("Contract"));
    String str2 = getIntent().getStringExtra("billNo");
    o.getNewRepairDetail(this.Q, this.S, this.I.getUid(), Long.valueOf(System.currentTimeMillis()), this.I.getLogin_name_mobile(), 12, str1, str2, "1");
  }
  
  private void e()
  {
    this.R = ((al)this.a.get(0));
    this.w.setText(this.R.getBillNo());
    this.x.setText(this.R.getKongjian());
    this.y.setText(this.R.getWxgzName());
    this.z.setText(this.R.getXmms());
    this.A.setText(this.R.getYdTime() + " (" + i.getYdTime(this.R.getYdTimeP()) + ")");
    this.B.setText(this.R.getShangmentime());
    this.C.setText(this.R.getFggAddress());
    this.D.setText(this.R.getLinkPhone());
    this.E.setText(this.R.getTijiaotime());
  }
  
  private void f()
  {
    String str = this.R.getState();
    if ("已下单".equals(str))
    {
      this.P.setVisibility(0);
      this.r.setBackgroundColor(Color.parseColor("#F56400"));
      this.d.setImageResource(2130838940);
      this.K.setTextColor(Color.parseColor("#F56400"));
    }
    do
    {
      return;
      if (("已受理".equals(str)) || ("已派单".equals(str)) || ("已派工".equals(str)))
      {
        this.P.setVisibility(4);
        this.r.setBackgroundColor(Color.parseColor("#F56400"));
        this.s.setBackgroundColor(Color.parseColor("#F56400"));
        this.d.setImageResource(2130838940);
        this.e.setImageResource(2130838940);
        this.K.setTextColor(Color.parseColor("#F56400"));
        this.L.setTextColor(Color.parseColor("#F56400"));
        return;
      }
      if (("已上门".equals(str)) || ("处理中".equals(str)))
      {
        this.P.setVisibility(4);
        this.r.setBackgroundColor(Color.parseColor("#F56400"));
        this.s.setBackgroundColor(Color.parseColor("#F56400"));
        this.t.setBackgroundColor(Color.parseColor("#F56400"));
        this.d.setImageResource(2130838940);
        this.e.setImageResource(2130838940);
        this.f.setImageResource(2130838940);
        this.K.setTextColor(Color.parseColor("#F56400"));
        this.L.setTextColor(Color.parseColor("#F56400"));
        this.M.setTextColor(Color.parseColor("#F56400"));
        return;
      }
      if ("已完成".equals(str))
      {
        this.P.setVisibility(4);
        this.r.setBackgroundColor(Color.parseColor("#F56400"));
        this.s.setBackgroundColor(Color.parseColor("#F56400"));
        this.t.setBackgroundColor(Color.parseColor("#F56400"));
        this.u.setBackgroundColor(Color.parseColor("#F56400"));
        this.v.setBackgroundColor(Color.parseColor("#F56400"));
        this.d.setImageResource(2130838940);
        this.e.setImageResource(2130838940);
        this.f.setImageResource(2130838940);
        this.g.setImageResource(2130838940);
        this.K.setTextColor(Color.parseColor("#F56400"));
        this.L.setTextColor(Color.parseColor("#F56400"));
        this.M.setTextColor(Color.parseColor("#F56400"));
        this.N.setTextColor(Color.parseColor("#F56400"));
        return;
      }
    } while (!"已取消".equals(str));
    this.P.setVisibility(4);
  }
  
  private void g()
  {
    if (this.R.getScore() == null)
    {
      this.J.setVisibility(4);
      return;
    }
    this.J.setText(this.R.getScore() + "分");
    this.F.setVisibility(8);
    this.O.setVisibility(4);
  }
  
  private void h()
  {
    if (this.R.getHfzt() == 0) {
      this.F.setBackgroundResource(2130838027);
    }
    while (this.R.getHfzt() != 1) {
      return;
    }
    this.F.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        RepairNewDetailActivity.a(RepairNewDetailActivity.this, new Intent(RepairNewDetailActivity.this, RepairEvaluationsActivity.class));
        RepairNewDetailActivity.k(RepairNewDetailActivity.this).putExtra("orderId", RepairNewDetailActivity.j(RepairNewDetailActivity.this).getBillId());
        RepairNewDetailActivity.k(RepairNewDetailActivity.this).putExtra("repair", "repairdetail");
        RepairNewDetailActivity.k(RepairNewDetailActivity.this).putExtra("repair_info", RepairNewDetailActivity.j(RepairNewDetailActivity.this));
        paramAnonymousView = RepairNewDetailActivity.this.getIntent().getExtras();
        paramAnonymousView.putInt("query_index_contract", paramAnonymousView.getInt("query_index_contract"));
        RepairNewDetailActivity.k(RepairNewDetailActivity.this).putExtras(paramAnonymousView);
        RepairNewDetailActivity.this.startActivity(RepairNewDetailActivity.k(RepairNewDetailActivity.this));
        RepairNewDetailActivity.this.finish();
      }
    });
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
      finish();
      return;
    }
    a(this.R);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130905093);
    this.Q = this;
    a();
    b();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/activity/RepairNewDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */