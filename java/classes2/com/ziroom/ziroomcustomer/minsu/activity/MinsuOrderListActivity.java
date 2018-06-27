package com.ziroom.ziroomcustomer.minsu.activity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.animation.LinearInterpolator;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.e.k;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.minsu.adapter.q;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuOrderBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuOrderBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuOrderBean.DataBean.OrderListBean;
import com.ziroom.ziroomcustomer.minsu.e.a;
import com.ziroom.ziroomcustomer.minsu.f.ab;
import com.ziroom.ziroomcustomer.minsu.f.ad;
import com.ziroom.ziroomcustomer.minsu.f.c;
import com.ziroom.ziroomcustomer.minsu.f.f;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;
import com.ziroom.ziroomcustomer.util.ac;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.widget.XListView;
import com.ziroom.ziroomcustomer.widget.XListView.a;
import java.util.ArrayList;
import java.util.List;

public class MinsuOrderListActivity
  extends BaseActivity
{
  private List<MinsuOrderBean.DataBean.OrderListBean> A;
  private EvaReceiver B;
  private ViewStub C;
  private XListView.a D = new XListView.a()
  {
    public void onLoadMore()
    {
      MinsuOrderListActivity.d(MinsuOrderListActivity.this);
    }
    
    public void onRefresh() {}
  };
  private int E;
  private int F;
  private View G;
  private ObjectAnimator H;
  public final int a = 3;
  public final int b = 4;
  public final int c = 5;
  public final int d = 6;
  public final int e = 7;
  private RadioGroup f;
  private XListView g;
  private q r;
  private CommonTitle s;
  private int t = 1;
  private final int u = 10;
  private final int v = 1;
  private final int w = 2;
  private int x = 1;
  private String y;
  private int z;
  
  private void a()
  {
    this.z = getIntent().getIntExtra("type", -1);
    this.y = getIntent().getStringExtra("title");
    this.B = new EvaReceiver();
    LocalBroadcastManager.getInstance(this).registerReceiver(this.B, new IntentFilter("action_customer_eva"));
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    i.a local4 = new i.a()
    {
      public void onParse(String paramAnonymousString, k paramAnonymousk) {}
      
      public void onSuccess(k paramAnonymousk)
      {
        MinsuOrderBean localMinsuOrderBean = (MinsuOrderBean)paramAnonymousk.getObject();
        if ((paramAnonymousk != null) && (paramAnonymousk.getSuccess().booleanValue()) && (localMinsuOrderBean.checkSuccess(MinsuOrderListActivity.this)))
        {
          u.e("lanzhihong", "ro======" + paramAnonymousk.toString());
          if ((localMinsuOrderBean.data.orderList != null) && (localMinsuOrderBean.data.orderList.size() > 0))
          {
            MinsuOrderListActivity.b(MinsuOrderListActivity.this).setVisibility(0);
            MinsuOrderListActivity.c(MinsuOrderListActivity.this).setVisibility(8);
            MinsuOrderListActivity.a(MinsuOrderListActivity.this).setDatas(localMinsuOrderBean.data.orderList);
            MinsuOrderListActivity.a(MinsuOrderListActivity.this).notifyDataSetChanged();
            if (localMinsuOrderBean.data.total == MinsuOrderListActivity.a(MinsuOrderListActivity.this).getCount())
            {
              MinsuOrderListActivity.b(MinsuOrderListActivity.this).setPullLoadEnable(false);
              return;
            }
            MinsuOrderListActivity.b(MinsuOrderListActivity.this).setPullLoadEnable(true);
            return;
          }
          MinsuOrderListActivity.b(MinsuOrderListActivity.this).setVisibility(8);
          MinsuOrderListActivity.this.showError("您暂无民宿订单哦~");
          return;
        }
        if (localMinsuOrderBean == null) {}
        for (paramAnonymousk = "";; paramAnonymousk = localMinsuOrderBean.message)
        {
          ad.shouErrorMessage(paramAnonymousk);
          MinsuOrderListActivity.a(MinsuOrderListActivity.this).setDatas(new ArrayList());
          MinsuOrderListActivity.a(MinsuOrderListActivity.this).notifyDataSetChanged();
          MinsuOrderListActivity.this.showError("服务器异常，正在努力抢修中，请稍后再试!");
          return;
        }
      }
    };
    a.getOrdreList(this, this.x, paramInt1, paramInt2, local4);
  }
  
  private void b()
  {
    e();
    this.f = ((RadioGroup)findViewById(2131691292));
    this.f.setOnCheckedChangeListener(new a());
    this.g = ((XListView)findViewById(2131691296));
    this.C = ((ViewStub)findViewById(2131690620));
    this.A = new ArrayList();
    this.r = new q(this, 2130904340, this.A);
    this.g.setAdapter(this.r);
    this.g.setPullLoadEnable(true);
    this.g.setPullRefreshEnable(false);
    this.g.setXListViewListener(this.D);
    this.g.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        paramAnonymousAdapterView = new Intent(MinsuOrderListActivity.this, MinsuSignedActivity.class);
        paramAnonymousAdapterView.putExtra("orderSn", ((MinsuOrderBean.DataBean.OrderListBean)MinsuOrderListActivity.a(MinsuOrderListActivity.this).getDatas().get(paramAnonymousInt - 1)).orderSn);
        paramAnonymousAdapterView.putExtra("fid", ((MinsuOrderBean.DataBean.OrderListBean)MinsuOrderListActivity.a(MinsuOrderListActivity.this).getDatas().get(paramAnonymousInt - 1)).fid);
        paramAnonymousAdapterView.putExtra("rentWay", ((MinsuOrderBean.DataBean.OrderListBean)MinsuOrderListActivity.a(MinsuOrderListActivity.this).getDatas().get(paramAnonymousInt - 1)).rentWay);
        MinsuOrderListActivity.this.startActivityForResult(paramAnonymousAdapterView, 101);
      }
    });
    if (this.z != -1)
    {
      this.x = this.z;
      this.f.setVisibility(8);
      this.G.setVisibility(8);
    }
  }
  
  private void b(int paramInt)
  {
    this.x = paramInt;
    a(1, this.r.getDatas().size());
  }
  
  private void c(int paramInt)
  {
    if ((this.H != null) && (this.H.isRunning())) {
      this.H.end();
    }
    if (paramInt == 1) {}
    for (this.H = ObjectAnimator.ofFloat(this.G, View.TRANSLATION_X, new float[] { this.E, 0.0F }).setDuration(250L);; this.H = ObjectAnimator.ofFloat(this.G, View.TRANSLATION_X, new float[] { 0.0F, this.E }).setDuration(250L))
    {
      this.H.setInterpolator(new LinearInterpolator());
      this.H.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator) {}
      });
      this.H.start();
      return;
    }
  }
  
  private void e()
  {
    this.G = findViewById(2131691295);
    float f1 = ab.length((RadioButton)findViewById(2131691293), getString(2131297528));
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.G.getLayoutParams();
    int i = ac.getScreenWidth(this);
    this.F = ((int)((i / 2 - ab.dp2px(this, 10.0F) - f1) / 2.0F + ab.dp2px(this, 10.0F) + 0.5D));
    this.E = ((i - ab.dp2px(this, 20.0F)) / 2);
    localLayoutParams.setMargins(this.F, 0, 0, 0);
    this.G.getLayoutParams().width = ((int)f1);
  }
  
  private void f()
  {
    this.g.stopRefresh();
    this.g.stopLoadMore();
    this.g.setRefreshTime("刚刚");
  }
  
  private void g()
  {
    this.t += 1;
    i.a local6 = new i.a()
    {
      public void onParse(String paramAnonymousString, k paramAnonymousk) {}
      
      public void onSuccess(k paramAnonymousk)
      {
        MinsuOrderBean localMinsuOrderBean = (MinsuOrderBean)paramAnonymousk.getObject();
        if ((paramAnonymousk != null) && (paramAnonymousk.getSuccess().booleanValue()) && (paramAnonymousk.getObject() != null) && (localMinsuOrderBean.checkSuccess(MinsuOrderListActivity.this)))
        {
          u.e("lanzhihong", "ro======" + paramAnonymousk.toString());
          MinsuOrderListActivity.a(MinsuOrderListActivity.this).addDatas(localMinsuOrderBean.data.orderList);
          MinsuOrderListActivity.a(MinsuOrderListActivity.this).notifyDataSetChanged();
          if (localMinsuOrderBean.data.total == MinsuOrderListActivity.a(MinsuOrderListActivity.this).getCount()) {
            MinsuOrderListActivity.b(MinsuOrderListActivity.this).setPullLoadEnable(false);
          }
          for (;;)
          {
            MinsuOrderListActivity.e(MinsuOrderListActivity.this);
            return;
            MinsuOrderListActivity.b(MinsuOrderListActivity.this).setPullLoadEnable(true);
          }
        }
        MinsuOrderListActivity.b(MinsuOrderListActivity.this).setPullLoadEnable(false);
        if (localMinsuOrderBean == null) {}
        for (paramAnonymousk = "";; paramAnonymousk = localMinsuOrderBean.message)
        {
          ad.shouErrorMessage(paramAnonymousk);
          break;
        }
      }
    };
    a.getOrdreList(this, this.x, this.t, 10, local6);
  }
  
  public void initTitle()
  {
    this.s = ((CommonTitle)findViewById(2131691272));
    if (TextUtils.isEmpty(this.y)) {
      this.s.setMiddleText(getString(2131297146));
    }
    for (;;)
    {
      this.s.showRightIc(true, 2130840197);
      this.s.setLeftButtonType(0);
      this.s.setOnLeftButtonClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          MinsuOrderListActivity.this.finish();
        }
      });
      this.s.setOnRightButtonClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          paramAnonymousView = new f(MinsuOrderListActivity.this);
          paramAnonymousView.init();
          paramAnonymousView.showPop();
        }
      });
      return;
      this.s.setMiddleText(this.y);
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 101) {
      b(this.x);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903319);
    a();
    initTitle();
    b();
    a(this.t, 10);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    LocalBroadcastManager.getInstance(this).unregisterReceiver(this.B);
  }
  
  public void showError(String paramString)
  {
    this.C.setVisibility(0);
    ((TextView)findViewById(2131690822)).setText(paramString);
    ((ImageView)findViewById(2131690082)).setImageResource(2130840095);
    ((LinearLayout)findViewById(2131694408)).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
      }
    });
  }
  
  public class EvaReceiver
    extends BroadcastReceiver
  {
    public EvaReceiver() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      paramContext = paramIntent.getStringExtra("orderSn");
      int i = paramIntent.getIntExtra("evaType", -1);
      if ((c.isNull(paramContext)) || (i != 1)) {
        return;
      }
      MinsuOrderListActivity.d(MinsuOrderListActivity.this, MinsuOrderListActivity.g(MinsuOrderListActivity.this));
    }
  }
  
  public class a
    implements RadioGroup.OnCheckedChangeListener
  {
    public a() {}
    
    @Instrumented
    public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
    {
      VdsAgent.onCheckedChanged(this, paramRadioGroup, paramInt);
      switch (paramInt)
      {
      default: 
        return;
      case 2131691293: 
        MinsuOrderListActivity.a(MinsuOrderListActivity.this, 1);
        MinsuOrderListActivity.b(MinsuOrderListActivity.this, 1);
        MinsuOrderListActivity.a(MinsuOrderListActivity.this, MinsuOrderListActivity.f(MinsuOrderListActivity.this), 10);
        MinsuOrderListActivity.c(MinsuOrderListActivity.this, 1);
        return;
      }
      MinsuOrderListActivity.a(MinsuOrderListActivity.this, 2);
      MinsuOrderListActivity.b(MinsuOrderListActivity.this, 1);
      MinsuOrderListActivity.a(MinsuOrderListActivity.this, MinsuOrderListActivity.f(MinsuOrderListActivity.this), 10);
      MinsuOrderListActivity.c(MinsuOrderListActivity.this, 2);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/activity/MinsuOrderListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */