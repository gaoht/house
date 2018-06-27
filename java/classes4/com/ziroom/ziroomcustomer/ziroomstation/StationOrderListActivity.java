package com.ziroom.ziroomcustomer.ziroomstation;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.e.k;
import com.freelxl.baselibrary.f.d;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.newchat.ChatNewActivity;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.af;
import com.ziroom.ziroomcustomer.widget.XListView;
import com.ziroom.ziroomcustomer.widget.XListView.a;
import com.ziroom.ziroomcustomer.ziroomstation.b.b;
import com.ziroom.ziroomcustomer.ziroomstation.dialog.c.a;
import com.ziroom.ziroomcustomer.ziroomstation.model.StationOrderListModel;
import com.ziroom.ziroomcustomer.ziroomstation.model.StationOrderListModel.DataBean;
import com.ziroom.ziroomcustomer.ziroomstation.model.StationOrderListModel.DataBean.HouseTypeInfoBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class StationOrderListActivity
  extends BaseActivity
  implements View.OnClickListener, XListView.a
{
  private ImageView a;
  private TextView b;
  private ViewStub c;
  private XListView d;
  private StationOrderListModel e;
  private com.ziroom.ziroomcustomer.ziroomstation.adapter.l f;
  private boolean g = false;
  private com.ziroom.ziroomcustomer.ziroomstation.dialog.c r;
  private String s;
  private boolean t = true;
  
  private void a()
  {
    this.d.stopRefresh();
    this.d.stopLoadMore();
    this.d.setRefreshTime(new Date().toLocaleString());
  }
  
  private void b()
  {
    this.a = ((ImageView)findViewById(2131690078));
    this.a.setOnClickListener(this);
    this.b = ((TextView)findViewById(2131689541));
    this.b.setText(getResources().getString(2131297485));
    this.d = ((XListView)findViewById(2131692518));
    this.c = ((ViewStub)findViewById(2131690620));
    if (this.g)
    {
      this.e = new StationOrderListModel();
      this.e.data = new ArrayList();
      int i = 0;
      while (i < 7)
      {
        StationOrderListModel.DataBean localDataBean = new StationOrderListModel.DataBean();
        localDataBean.orderStatus = (i + 1);
        localDataBean.amount = (i + 1000);
        localDataBean.endDate = "2016/05/07";
        localDataBean.startDate = "2016/06/07";
        localDataBean.nights = (i + 2);
        localDataBean.projectName = ("北京自如驿" + (i + 1) + "号");
        localDataBean.houseTypeInfo = new ArrayList();
        int j = 0;
        while (j < 4)
        {
          StationOrderListModel.DataBean.HouseTypeInfoBean localHouseTypeInfoBean = new StationOrderListModel.DataBean.HouseTypeInfoBean();
          localHouseTypeInfoBean.bedCount = (j + 1);
          localHouseTypeInfoBean.houseName = (j + 1 + "号类型房");
          localHouseTypeInfoBean.imgUrl = "http://img4.imgtn.bdimg.com/it/u=3445377427,2645691367&fm=21&gp=0.jpg";
          localDataBean.houseTypeInfo.add(localHouseTypeInfoBean);
          j += 1;
        }
        this.e.data.add(localDataBean);
        i += 1;
      }
    }
    if (this.e != null) {}
    for (this.f = new com.ziroom.ziroomcustomer.ziroomstation.adapter.l(this.e.data, this);; this.f = new com.ziroom.ziroomcustomer.ziroomstation.adapter.l(null, this))
    {
      this.d.setPullLoadEnable(false);
      this.d.setPullRefreshEnable(true);
      this.d.setXListViewListener(this);
      this.d.setAdapter(this.f);
      return;
    }
  }
  
  public com.ziroom.ziroomcustomer.ziroomstation.dialog.c getPayOrderDialog()
  {
    return this.r;
  }
  
  public void initData()
  {
    if (ae.isNull(ApplicationEx.c.getUserId(this))) {}
    Map localMap;
    do
    {
      return;
      this.s = ApplicationEx.c.getUserId(this);
      if (!checkNet(this)) {
        break;
      }
      this.e = null;
      this.f.setDatas(null);
      localMap = b.buildStationOrderList(this, this.s);
    } while (this.g);
    com.ziroom.ziroomcustomer.ziroomstation.b.c.getStationOrderList(this, localMap, new a(), true);
    return;
    af.showToast(this, "网络不佳，请稍后再试");
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    initData();
    if (this.r != null) {
      this.r.getCallback().doInActivityResult(this, paramInt1, paramInt2, paramIntent);
    }
  }
  
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
    setContentView(2130903516);
    b();
    initData();
  }
  
  public void onLoadMore() {}
  
  public void onRefresh()
  {
    initData();
  }
  
  protected void onResume()
  {
    a("zinn_self_list_duration");
    super.onResume();
    if (this.t)
    {
      this.t = false;
      return;
    }
    initData();
  }
  
  public void setChatInfo()
  {
    if (!checkNet(this))
    {
      showToast("网络请求失败，请检查网络连接");
      return;
    }
    if (ApplicationEx.c.isLoginState())
    {
      if (!ApplicationEx.c.isImconnect())
      {
        com.ziroom.ziroomcustomer.newchat.a.register(this);
        if (com.ziroom.ziroomcustomer.newchat.l.getNetWorkType(this)) {
          showProgressNoCancel("", 8000L);
        }
        for (;;)
        {
          new Thread()
          {
            public void run()
            {
              super.run();
              try
              {
                if (com.ziroom.ziroomcustomer.newchat.l.getNetWorkType(StationOrderListActivity.this)) {
                  Thread.sleep(8000L);
                }
                for (;;)
                {
                  Intent localIntent = new Intent(StationOrderListActivity.this, ChatNewActivity.class);
                  localIntent.putExtra("chatForm", "ziruyi");
                  StationOrderListActivity.this.startActivity(localIntent);
                  return;
                  Thread.sleep(18000L);
                }
              }
              catch (InterruptedException localInterruptedException)
              {
                for (;;)
                {
                  localInterruptedException.printStackTrace();
                }
              }
            }
          }.start();
          return;
          showProgressNoCancel("", 18000L);
        }
      }
      Intent localIntent = new Intent(this, ChatNewActivity.class);
      localIntent.putExtra("chatForm", "ziruyi");
      startActivity(localIntent);
      return;
    }
    com.ziroom.commonlibrary.login.a.startLoginActivity(this);
  }
  
  public void setPayOrderDialog(com.ziroom.ziroomcustomer.ziroomstation.dialog.c paramc)
  {
    this.r = paramc;
  }
  
  public void showError(String paramString)
  {
    this.c.setVisibility(0);
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
  
  class a
    implements i.a<String>
  {
    a() {}
    
    public void onParse(String paramString, k paramk) {}
    
    public void onSuccess(k paramk)
    {
      if (paramk.getSuccess().booleanValue())
      {
        StationOrderListActivity.a(StationOrderListActivity.this, (StationOrderListModel)paramk.getObject());
        d.i("HttpResult code:", Integer.valueOf(StationOrderListActivity.a(StationOrderListActivity.this).error_code));
        if ((StationOrderListActivity.a(StationOrderListActivity.this) != null) && (StationOrderListActivity.a(StationOrderListActivity.this).data != null) && (StationOrderListActivity.a(StationOrderListActivity.this).data.size() > 0)) {
          StationOrderListActivity.b(StationOrderListActivity.this).setDatas(StationOrderListActivity.a(StationOrderListActivity.this).data);
        }
      }
      for (;;)
      {
        StationOrderListActivity.c(StationOrderListActivity.this);
        return;
        StationOrderListActivity.this.showError("您暂无自如驿订单哦~");
        continue;
        d.i("HttpResult :", paramk.getMessage());
        af.showToast(StationOrderListActivity.this, paramk.getMessage());
        StationOrderListActivity.this.showError("服务器异常，正在努力抢修中，请稍后再试!");
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/StationOrderListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */