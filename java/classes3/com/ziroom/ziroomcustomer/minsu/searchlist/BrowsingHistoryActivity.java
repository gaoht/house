package com.ziroom.ziroomcustomer.minsu.searchlist;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.flux.b;
import com.ziroom.ziroomcustomer.flux.view.BaseFluxActivity;
import com.ziroom.ziroomcustomer.minsu.bean.JsonPara2;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.f.j;
import com.ziroom.ziroomcustomer.minsu.searchlist.b.a.c;
import com.ziroom.ziroomcustomer.util.s;
import java.util.List;

public class BrowsingHistoryActivity
  extends BaseFluxActivity
{
  private Context b;
  @BindView(2131690078)
  View btn_back;
  private com.ziroom.ziroomcustomer.minsu.searchlist.a.a c;
  private com.ziroom.ziroomcustomer.minsu.searchlist.c.a d;
  private Unbinder e;
  private MinsuHouseBean f;
  private com.ziroom.ziroomcustomer.minsu.searchlist.b.a g;
  @BindView(2131690081)
  View rl_empty;
  @BindView(2131690080)
  RecyclerView rv_history;
  
  private void a() {}
  
  private void b()
  {
    this.d = new com.ziroom.ziroomcustomer.minsu.searchlist.c.a(this);
    this.a.register(this.d);
    this.c = com.ziroom.ziroomcustomer.minsu.searchlist.a.a.getInstance(this.a);
  }
  
  private void e()
  {
    List localList = j.getHouseDetailHistoryNet(this);
    if ((localList == null) || (localList.isEmpty()))
    {
      this.rv_history.setVisibility(8);
      this.rl_empty.setVisibility(0);
      return;
    }
    JsonPara2 localJsonPara2 = new JsonPara2();
    localJsonPara2.houseList = localList;
    this.g = new com.ziroom.ziroomcustomer.minsu.searchlist.b.a(this.b);
    this.rv_history.setLayoutManager(new LinearLayoutManager(this.b, 1, false));
    this.rv_history.setAdapter(this.g);
    this.c.getMinsuHistory(this, com.alibaba.fastjson.a.toJSONString(localJsonPara2));
  }
  
  @OnClick({2131690078})
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    }
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903119);
    this.b = this;
    this.e = ButterKnife.bind(this);
    a();
    b();
    e();
  }
  
  protected void onDestroy()
  {
    this.e.unbind();
    this.a.unregister(this.d);
    com.freelxl.baselibrary.d.a.cancel(this);
    super.onDestroy();
  }
  
  protected void onEventHandle(com.ziroom.ziroomcustomer.flux.a.a parama)
  {
    parama = parama.getType();
    int i = -1;
    switch (parama.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return;
        if (parama.equals("browsing_history"))
        {
          i = 0;
          continue;
          if (parama.equals("browsing_history_error")) {
            i = 1;
          }
        }
        break;
      }
    }
    this.f = this.d.getMinsuHistoryHouseBean();
    if ((this.f != null) && (this.f.data != null) && (this.f.data.list != null) && (this.f.data.total >= 1) && (!s.isEmpty(this.f.data.list)))
    {
      this.g.setData(this.f.data.list, a.c.c);
      this.rv_history.setVisibility(0);
      this.rl_empty.setVisibility(8);
      return;
    }
    this.rv_history.setVisibility(8);
    this.rl_empty.setVisibility(0);
    return;
    this.rv_history.setVisibility(8);
    this.rl_empty.setVisibility(0);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/searchlist/BrowsingHistoryActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */