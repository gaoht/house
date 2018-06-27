package com.ziroom.ziroomcustomer.minsu.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.aspsine.swipetoloadlayout.SwipeToLoadLayout;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.f.d;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.minsu.adapter.j;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuEvaluationBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuEvaluationBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuEvaluationBean.DataBean.EvaListBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuEvaluationBean.DataBean.StatsHouseEvaBean;
import com.ziroom.ziroomcustomer.minsu.f.ad;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;
import com.ziroom.ziroomcustomer.minsu.view.FiveEvaluteButton;
import java.util.List;

public class MinsuHouseEvaluationListActivity
  extends BaseActivity
{
  private FiveEvaluteButton A;
  private ListView B;
  private com.ziroom.ziroomcustomer.minsu.a.a<MinsuEvaluationBean.DataBean.EvaListBean> C;
  private List<MinsuEvaluationBean.DataBean.EvaListBean> D;
  private CommonTitle E;
  private int F = 1;
  private int G = 10;
  private SwipeToLoadLayout H;
  private String I = "房东";
  private TextView a;
  private FiveEvaluteButton b;
  private View c;
  private View d;
  private View e;
  private View f;
  private View g;
  private TextView r;
  private TextView s;
  private TextView t;
  private TextView u;
  private TextView v;
  private FiveEvaluteButton w;
  private FiveEvaluteButton x;
  private FiveEvaluteButton y;
  private FiveEvaluteButton z;
  
  private void a()
  {
    this.B = ((ListView)findViewById(2131689522));
    this.H = ((SwipeToLoadLayout)findViewById(2131691285));
    this.H.setLoadMoreEnabled(true);
    this.H.setRefreshEnabled(false);
    this.H.setOnLoadMoreListener(new com.aspsine.swipetoloadlayout.a()
    {
      public void onLoadMore()
      {
        MinsuHouseEvaluationListActivity.a(MinsuHouseEvaluationListActivity.this);
        MinsuHouseEvaluationListActivity.b(MinsuHouseEvaluationListActivity.this);
      }
    });
    this.C = new j(this, this.D, 2130904308, this.I);
    b();
    this.B.setAdapter(this.C);
  }
  
  private void a(MinsuEvaluationBean paramMinsuEvaluationBean)
  {
    MinsuEvaluationBean.DataBean.StatsHouseEvaBean localStatsHouseEvaBean = paramMinsuEvaluationBean.data.statsHouseEva;
    if (localStatsHouseEvaBean != null)
    {
      this.r.setText("清 洁 度  ");
      this.s.setText("周边环境  ");
      this.t.setText("性 价 比  ");
      this.u.setText("描述相符  ");
      this.v.setText("房东印象  ");
      this.w.setScore(localStatsHouseEvaBean.houseCleanAva);
      this.x.setScore(localStatsHouseEvaBean.trafPosAva);
      this.y.setScore(localStatsHouseEvaBean.costPerforAva);
      this.z.setScore(localStatsHouseEvaBean.desMatchAva);
      this.A.setScore(localStatsHouseEvaBean.safeDegreeAva);
      this.a.setText(paramMinsuEvaluationBean.data.total + "条评论");
      this.b.setScore(localStatsHouseEvaBean.realTotalAvgGrade);
    }
    this.D = paramMinsuEvaluationBean.data.evaList;
    this.C.addDatas(this.D);
    this.C.notifyDataSetChanged();
  }
  
  private void a(FiveEvaluteButton paramFiveEvaluteButton)
  {
    paramFiveEvaluteButton.setSwitch(false);
    paramFiveEvaluteButton.setScoreTextVisible(false);
    paramFiveEvaluteButton.setPadding(new int[] { 1, 5, 1, 5 });
  }
  
  private void b()
  {
    View localView = View.inflate(this, 2130904060, null);
    this.c = localView.findViewById(2131694608);
    this.d = localView.findViewById(2131694609);
    this.e = localView.findViewById(2131694610);
    this.f = localView.findViewById(2131694611);
    this.g = localView.findViewById(2131694612);
    this.r = ((TextView)this.c.findViewById(2131689541));
    this.s = ((TextView)this.d.findViewById(2131689541));
    this.t = ((TextView)this.e.findViewById(2131689541));
    this.u = ((TextView)this.f.findViewById(2131689541));
    this.v = ((TextView)this.g.findViewById(2131689541));
    this.w = ((FiveEvaluteButton)this.c.findViewById(2131694580));
    this.x = ((FiveEvaluteButton)this.d.findViewById(2131694580));
    this.y = ((FiveEvaluteButton)this.e.findViewById(2131694580));
    this.z = ((FiveEvaluteButton)this.f.findViewById(2131694580));
    this.A = ((FiveEvaluteButton)this.g.findViewById(2131694580));
    a(this.w);
    a(this.x);
    a(this.y);
    a(this.z);
    a(this.A);
    this.a = ((TextView)localView.findViewById(2131694606));
    this.b = ((FiveEvaluteButton)localView.findViewById(2131694607));
    a(this.b);
    this.B.addHeaderView(localView, null, false);
  }
  
  private void e()
  {
    String str = getIntent().getStringExtra("fid");
    int i = getIntent().getIntExtra("rentWay", 0);
    com.ziroom.ziroomcustomer.minsu.e.a.getHouseEvaluate(this, str, this.G, this.F, i, new i.a()
    {
      public void onParse(String paramAnonymousString, com.freelxl.baselibrary.e.k paramAnonymousk) {}
      
      public void onSuccess(com.freelxl.baselibrary.e.k paramAnonymousk)
      {
        MinsuEvaluationBean localMinsuEvaluationBean = (MinsuEvaluationBean)paramAnonymousk.getObject();
        if ((localMinsuEvaluationBean != null) && (paramAnonymousk.getSuccess().booleanValue()) && (localMinsuEvaluationBean.checkSuccess(MinsuHouseEvaluationListActivity.this)))
        {
          d.e("lanzhihong", "ro======" + localMinsuEvaluationBean.toString());
          if ((localMinsuEvaluationBean.data.evaList.size() == 0) && (MinsuHouseEvaluationListActivity.c(MinsuHouseEvaluationListActivity.this) > 1)) {
            g.textToast(ApplicationEx.c, "没有更多数据");
          }
          for (;;)
          {
            MinsuHouseEvaluationListActivity.d(MinsuHouseEvaluationListActivity.this);
            return;
            MinsuHouseEvaluationListActivity.a(MinsuHouseEvaluationListActivity.this, localMinsuEvaluationBean);
          }
        }
        if (localMinsuEvaluationBean == null) {}
        for (paramAnonymousk = null;; paramAnonymousk = localMinsuEvaluationBean.message)
        {
          ad.shouErrorMessage(paramAnonymousk);
          break;
        }
      }
    });
  }
  
  private void f()
  {
    this.H.setRefreshing(false);
    this.H.setLoadingMore(false);
  }
  
  public void finish()
  {
    super.finish();
    com.ziroom.ziroomcustomer.minsu.f.k.animFinishAlpha(this);
  }
  
  public void initTitle()
  {
    this.E = ((CommonTitle)findViewById(2131691272));
    this.E.showRightText(false, null);
    this.E.setMiddleText("");
    this.E.setLeftButtonType(4);
    this.E.setBackgroundColor(getResources().getColor(2131624583));
    this.E.setOnLeftButtonClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MinsuHouseEvaluationListActivity.this.finish();
      }
    });
    this.E.showTopLine(this.B);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903282);
    this.I = getIntent().getStringExtra("llname");
    a();
    e();
    initTitle();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/activity/MinsuHouseEvaluationListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */