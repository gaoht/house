package com.ziroom.ziroomcustomer.minsu.activity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
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
import com.freelxl.baselibrary.f.d;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuEvaluationListBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuEvaluationListBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuEvaluationListBean.DataBean.RowsBean;
import com.ziroom.ziroomcustomer.minsu.dialog.h;
import com.ziroom.ziroomcustomer.minsu.f.ab;
import com.ziroom.ziroomcustomer.minsu.f.ad;
import com.ziroom.ziroomcustomer.minsu.f.c;
import com.ziroom.ziroomcustomer.minsu.f.r;
import com.ziroom.ziroomcustomer.minsu.f.s;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;
import com.ziroom.ziroomcustomer.util.ac;
import com.ziroom.ziroomcustomer.widget.XListView;
import com.ziroom.ziroomcustomer.widget.XListView.a;
import java.util.ArrayList;
import java.util.List;

public class MinsuEvaluationListActivity
  extends BaseActivity
{
  private ObjectAnimator A;
  private EvaReceiver a;
  private XListView b;
  private ViewStub c;
  private com.ziroom.ziroomcustomer.minsu.a.a<MinsuEvaluationListBean.DataBean.RowsBean> d;
  private List<MinsuEvaluationListBean.DataBean.RowsBean> e;
  private CommonTitle f;
  private int g = 1;
  private int r = 10;
  private int s = 1;
  private h t = h.b;
  private final int u = 1;
  private final int v = 2;
  private int w = 1;
  private int x;
  private int y;
  private View z;
  
  private void a()
  {
    b();
    this.b = ((XListView)findViewById(2131691296));
    ((RadioGroup)findViewById(2131691292)).setOnCheckedChangeListener(new a());
    this.b.setPullLoadEnable(true);
    this.b.setPullRefreshEnable(false);
    this.b.setXListViewListener(new b());
    this.c = ((ViewStub)findViewById(2131690620));
    this.e = new ArrayList();
    this.d = new com.ziroom.ziroomcustomer.minsu.adapter.k(this, this.e, 2130904299);
    this.b.setAdapter(this.d);
    this.b.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        com.ziroom.ziroomcustomer.minsu.f.k.toEvaActivity(MinsuEvaluationListActivity.this, ((MinsuEvaluationListBean.DataBean.RowsBean)MinsuEvaluationListActivity.a(MinsuEvaluationListActivity.this).getDatas().get(paramAnonymousInt - 1)).orderSn, MinsuEvaluationListActivity.b(MinsuEvaluationListActivity.this));
      }
    });
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    com.ziroom.ziroomcustomer.minsu.e.a.queryEvaluate(this, paramInt2, paramInt3, this.t.value(), paramInt1, new s(this, new r(MinsuEvaluationListBean.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        MinsuEvaluationListActivity.e(MinsuEvaluationListActivity.this);
      }
      
      public void onSuccess(int paramAnonymousInt, MinsuEvaluationListBean paramAnonymousMinsuEvaluationListBean)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousMinsuEvaluationListBean);
        StringBuilder localStringBuilder = new StringBuilder().append("-----");
        String str;
        if (paramAnonymousMinsuEvaluationListBean == null)
        {
          str = "null";
          d.e("lanzhihong", str);
          if ((!paramAnonymousMinsuEvaluationListBean.checkSuccess(MinsuEvaluationListActivity.this)) || (paramAnonymousMinsuEvaluationListBean.data == null) || (paramAnonymousMinsuEvaluationListBean.data.rows == null)) {
            break label238;
          }
          if (paramAnonymousMinsuEvaluationListBean.data.rows.size() != 0) {
            break label184;
          }
          MinsuEvaluationListActivity.this.showError("您暂无民宿评价哦~");
          MinsuEvaluationListActivity.c(MinsuEvaluationListActivity.this).setVisibility(8);
          MinsuEvaluationListActivity.a(MinsuEvaluationListActivity.this).setDatas(new ArrayList());
          MinsuEvaluationListActivity.a(MinsuEvaluationListActivity.this).notifyDataSetChanged();
          label132:
          if (paramAnonymousMinsuEvaluationListBean.data.total != MinsuEvaluationListActivity.a(MinsuEvaluationListActivity.this).getDatas().size()) {
            break label224;
          }
          MinsuEvaluationListActivity.c(MinsuEvaluationListActivity.this).setPullLoadEnable(false);
        }
        for (;;)
        {
          MinsuEvaluationListActivity.e(MinsuEvaluationListActivity.this);
          return;
          str = paramAnonymousMinsuEvaluationListBean.toString();
          break;
          label184:
          MinsuEvaluationListActivity.c(MinsuEvaluationListActivity.this).setVisibility(0);
          MinsuEvaluationListActivity.d(MinsuEvaluationListActivity.this).setVisibility(8);
          MinsuEvaluationListActivity.this.refreshUI(paramAnonymousMinsuEvaluationListBean.data.rows);
          break label132;
          label224:
          MinsuEvaluationListActivity.c(MinsuEvaluationListActivity.this).setPullLoadEnable(true);
        }
        label238:
        MinsuEvaluationListActivity.c(MinsuEvaluationListActivity.this).setVisibility(8);
        MinsuEvaluationListActivity.c(MinsuEvaluationListActivity.this).setPullLoadEnable(false);
        MinsuEvaluationListActivity.a(MinsuEvaluationListActivity.this).setDatas(new ArrayList());
        MinsuEvaluationListActivity.a(MinsuEvaluationListActivity.this).notifyDataSetChanged();
        if (paramAnonymousMinsuEvaluationListBean == null) {}
        for (paramAnonymousMinsuEvaluationListBean = "";; paramAnonymousMinsuEvaluationListBean = paramAnonymousMinsuEvaluationListBean.message)
        {
          ad.shouErrorMessage(paramAnonymousMinsuEvaluationListBean);
          MinsuEvaluationListActivity.this.showError("服务器异常，正在努力抢修中，请稍后再试!");
          break;
        }
      }
    });
  }
  
  private void b()
  {
    this.z = findViewById(2131691295);
    float f1 = ab.length((RadioButton)findViewById(2131691293), "待评价");
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.z.getLayoutParams();
    int i = ac.getScreenWidth(this);
    this.y = ((int)((i / 2 - ab.dp2px(this, 10.5F) - f1) / 2.0F + ab.dp2px(this, 10.0F) + 0.5D));
    this.x = ((i - ab.dp2px(this, 20.0F)) / 2);
    localLayoutParams.setMargins(this.y, 0, 0, 0);
    this.z.getLayoutParams().width = ((int)f1);
  }
  
  private void b(int paramInt)
  {
    if ((this.A != null) && (this.A.isRunning())) {
      this.A.end();
    }
    if (paramInt == 1) {}
    for (this.A = ObjectAnimator.ofFloat(this.z, View.TRANSLATION_X, new float[] { this.x, 0.0F }).setDuration(250L);; this.A = ObjectAnimator.ofFloat(this.z, View.TRANSLATION_X, new float[] { 0.0F, this.x }).setDuration(250L))
    {
      this.A.setInterpolator(new LinearInterpolator());
      this.A.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator) {}
      });
      this.A.start();
      return;
    }
  }
  
  private void c(int paramInt)
  {
    a(paramInt, this.r, this.g);
    this.a = new EvaReceiver();
    LocalBroadcastManager.getInstance(this).registerReceiver(this.a, new IntentFilter("action_customer_eva"));
  }
  
  private void e()
  {
    int i = this.d.getDatas().size();
    a(this.s, i, 1);
  }
  
  private void f()
  {
    this.g += 1;
    com.ziroom.ziroomcustomer.minsu.e.a.queryEvaluate(this, this.r, this.g, this.t.value(), this.s, new s(this, new r(MinsuEvaluationListBean.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        MinsuEvaluationListActivity.e(MinsuEvaluationListActivity.this);
        MinsuEvaluationListActivity.f(MinsuEvaluationListActivity.this);
      }
      
      public void onSuccess(int paramAnonymousInt, MinsuEvaluationListBean paramAnonymousMinsuEvaluationListBean)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousMinsuEvaluationListBean);
        StringBuilder localStringBuilder = new StringBuilder().append("-----");
        String str;
        if (paramAnonymousMinsuEvaluationListBean == null)
        {
          str = "null";
          d.e("lanzhihong", str);
          if ((!paramAnonymousMinsuEvaluationListBean.checkSuccess(MinsuEvaluationListActivity.this)) || (paramAnonymousMinsuEvaluationListBean.data == null)) {
            break label173;
          }
          if ((paramAnonymousMinsuEvaluationListBean.data.rows == null) || (paramAnonymousMinsuEvaluationListBean.data.rows.size() <= 0)) {
            break label114;
          }
          MinsuEvaluationListActivity.this.appendUI(paramAnonymousMinsuEvaluationListBean.data.rows);
        }
        for (;;)
        {
          MinsuEvaluationListActivity.e(MinsuEvaluationListActivity.this);
          return;
          str = paramAnonymousMinsuEvaluationListBean.toString();
          break;
          label114:
          if (!TextUtils.isEmpty(paramAnonymousMinsuEvaluationListBean.message)) {
            break label151;
          }
          g.textToast(MinsuEvaluationListActivity.this, MinsuEvaluationListActivity.this.getString(2131297294));
          MinsuEvaluationListActivity.f(MinsuEvaluationListActivity.this);
        }
        label151:
        if (paramAnonymousMinsuEvaluationListBean == null) {}
        for (paramAnonymousMinsuEvaluationListBean = "";; paramAnonymousMinsuEvaluationListBean = paramAnonymousMinsuEvaluationListBean.message)
        {
          ad.shouErrorMessage(paramAnonymousMinsuEvaluationListBean);
          break;
        }
        label173:
        if (paramAnonymousMinsuEvaluationListBean == null) {}
        for (paramAnonymousMinsuEvaluationListBean = "";; paramAnonymousMinsuEvaluationListBean = paramAnonymousMinsuEvaluationListBean.message)
        {
          ad.shouErrorMessage(paramAnonymousMinsuEvaluationListBean);
          MinsuEvaluationListActivity.f(MinsuEvaluationListActivity.this);
          break;
        }
      }
    });
  }
  
  private void g()
  {
    this.b.stopRefresh();
    this.b.stopLoadMore();
    this.b.setRefreshTime("刚刚");
  }
  
  public void appendUI(List<MinsuEvaluationListBean.DataBean.RowsBean> paramList)
  {
    this.d.addDatas(paramList);
    this.d.notifyDataSetChanged();
  }
  
  public void initTitle()
  {
    this.f = ((CommonTitle)findViewById(2131691272));
    this.f.showRightText(false, null);
    this.f.setMiddleText("我的民宿评价");
    this.f.setLeftButtonType(0);
    this.f.setOnLeftButtonClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MinsuEvaluationListActivity.this.finish();
      }
    });
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903274);
    a();
    initTitle();
    c(this.s);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    LocalBroadcastManager.getInstance(this).unregisterReceiver(this.a);
  }
  
  public void refreshUI(List<MinsuEvaluationListBean.DataBean.RowsBean> paramList)
  {
    this.d.setDatas(paramList);
    this.d.notifyDataSetChanged();
  }
  
  public void showError(String paramString)
  {
    this.c.setVisibility(0);
    ((TextView)findViewById(2131690822)).setText(paramString);
    ((ImageView)findViewById(2131690082)).setImageResource(2130840088);
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
      MinsuEvaluationListActivity.h(MinsuEvaluationListActivity.this);
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
        MinsuEvaluationListActivity.a(MinsuEvaluationListActivity.this, 1);
        MinsuEvaluationListActivity.b(MinsuEvaluationListActivity.this, 1);
        MinsuEvaluationListActivity.c(MinsuEvaluationListActivity.this, 1);
        return;
      }
      MinsuEvaluationListActivity.a(MinsuEvaluationListActivity.this, 2);
      MinsuEvaluationListActivity.b(MinsuEvaluationListActivity.this, 2);
      MinsuEvaluationListActivity.c(MinsuEvaluationListActivity.this, 2);
    }
  }
  
  public class b
    implements XListView.a
  {
    public b() {}
    
    public void onLoadMore()
    {
      MinsuEvaluationListActivity.g(MinsuEvaluationListActivity.this);
    }
    
    public void onRefresh() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/activity/MinsuEvaluationListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */