package com.ziroom.ziroomcustomer.ziroomstation;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.f.d;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.util.af;
import com.ziroom.ziroomcustomer.widget.XListView;
import com.ziroom.ziroomcustomer.widget.XListView.a;
import com.ziroom.ziroomcustomer.ziroomstation.b.b;
import com.ziroom.ziroomcustomer.ziroomstation.b.c;
import com.ziroom.ziroomcustomer.ziroomstation.model.StationListModel;
import java.util.Date;
import java.util.List;

public class ZiroomStationMainActivity
  extends BaseActivity
  implements View.OnClickListener, XListView.a
{
  private ImageView a;
  private TextView b;
  private XListView c;
  private StationListModel d;
  private com.ziroom.ziroomcustomer.ziroomstation.adapter.k e;
  
  private void a()
  {
    if (checkNet(this))
    {
      c.getStationList(this, b.buildStationList(this, ""), new a(), true);
      return;
    }
    af.showToast(this, "网络不佳，请稍后再试");
  }
  
  private void b()
  {
    this.c.stopRefresh();
    this.c.stopLoadMore();
    this.c.setRefreshTime(new Date().toLocaleString());
  }
  
  private void e()
  {
    this.a = ((ImageView)findViewById(2131690078));
    this.a.setOnClickListener(this);
    this.b = ((TextView)findViewById(2131689541));
    this.c = ((XListView)findViewById(2131692518));
    if (this.d != null) {}
    for (this.e = new com.ziroom.ziroomcustomer.ziroomstation.adapter.k(this, this.d.data);; this.e = new com.ziroom.ziroomcustomer.ziroomstation.adapter.k(this, null))
    {
      this.c.setPullLoadEnable(false);
      this.c.setPullRefreshEnable(true);
      this.c.setXListViewListener(this);
      this.c.setAdapter(this.e);
      return;
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
    setContentView(2130903573);
    e();
    a();
  }
  
  public void onLoadMore() {}
  
  public void onRefresh()
  {
    a();
  }
  
  protected void onResume()
  {
    a("zinn_list_num_duration");
    super.onResume();
  }
  
  class a
    implements i.a<String>
  {
    a() {}
    
    public void onParse(String paramString, com.freelxl.baselibrary.e.k paramk) {}
    
    public void onSuccess(com.freelxl.baselibrary.e.k paramk)
    {
      if (paramk.getSuccess().booleanValue())
      {
        ZiroomStationMainActivity.a(ZiroomStationMainActivity.this, (StationListModel)paramk.getObject());
        d.i("HttpResult code:", Integer.valueOf(ZiroomStationMainActivity.a(ZiroomStationMainActivity.this).error_code));
        if ((ZiroomStationMainActivity.a(ZiroomStationMainActivity.this) != null) && (ZiroomStationMainActivity.a(ZiroomStationMainActivity.this).data != null) && (ZiroomStationMainActivity.a(ZiroomStationMainActivity.this).data.size() > 0)) {
          ZiroomStationMainActivity.b(ZiroomStationMainActivity.this).setData(ZiroomStationMainActivity.a(ZiroomStationMainActivity.this).data);
        }
      }
      for (;;)
      {
        ZiroomStationMainActivity.c(ZiroomStationMainActivity.this);
        return;
        af.showToast(ZiroomStationMainActivity.this, "服务器开小差了，请稍后再试");
        continue;
        d.i("HttpResult :", "ro failed:" + paramk.getMessage());
        af.showToast(ZiroomStationMainActivity.this, paramk.getMessage());
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/ZiroomStationMainActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */