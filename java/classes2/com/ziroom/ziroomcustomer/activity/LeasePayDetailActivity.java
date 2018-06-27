package com.ziroom.ziroomcustomer.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.ziroom.commonlibrary.widget.unifiedziroom.BasicZiroomToolBar;
import com.ziroom.ziroomcustomer.adapter.i;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.d;
import com.ziroom.ziroomcustomer.e.l;
import com.ziroom.ziroomcustomer.model.LeasePayDetail;
import com.ziroom.ziroomcustomer.model.LeasePayPlan;
import com.ziroom.ziroomcustomer.widget.c;
import java.util.List;

public class LeasePayDetailActivity
  extends BaseActivity
{
  BasicZiroomToolBar a;
  private TextView b;
  private TextView c;
  private TextView d;
  private TextView e;
  private TextView f;
  private TextView g;
  private ListView r;
  private i s;
  private LeasePayPlan t;
  private LeasePayDetail u;
  private String v;
  private String w;
  private Handler x = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      l locall = (l)paramAnonymousMessage.obj;
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      }
      LeasePayDetailActivity.this.dismissProgress();
      if (locall.getSuccess().booleanValue())
      {
        LeasePayDetailActivity.a(LeasePayDetailActivity.this, (LeasePayDetail)locall.getObject());
        LeasePayDetailActivity.a(LeasePayDetailActivity.this);
        return;
      }
      LeasePayDetailActivity.this.showToast(locall.getMessage());
    }
  };
  
  private void a()
  {
    this.b = ((TextView)findViewById(2131692992));
    this.c = ((TextView)findViewById(2131693310));
    this.d = ((TextView)findViewById(2131693311));
    this.e = ((TextView)findViewById(2131693312));
    this.f = ((TextView)findViewById(2131697244));
    this.g = ((TextView)findViewById(2131693309));
    this.r = ((ListView)findViewById(2131697246));
    this.a = ((BasicZiroomToolBar)findViewById(2131689787));
    this.a.setTitle("支付详情");
    View localView = LayoutInflater.from(this).inflate(2130904272, null);
    this.r.addHeaderView(localView);
    this.b.setText(this.t.getContractCode());
    this.c.setText(this.t.getPeriods() + "");
    this.d.setText(this.u.getFee() + "");
    if (this.t.getStatus().equals("yfk"))
    {
      this.e.setText(this.u.getFee() + "");
      this.f.setText(this.u.getPayCount() + "");
      if (this.u == null) {
        break label424;
      }
      this.g.setText(this.u.getAddress());
    }
    for (;;)
    {
      if ((this.u != null) && (this.u.getPayDetail().size() > 0))
      {
        this.s = new i(this, this.u.getPayDetail());
        this.r.setAdapter(this.s);
        new c().setListViewHeightBasedOnChildren(this.r);
      }
      return;
      this.e.setText(this.u.getPayFee() + "");
      findViewById(2131689837).setVisibility(8);
      break;
      label424:
      this.g.setText("");
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130905025);
    this.t = ((LeasePayPlan)getIntent().getSerializableExtra("LeasePayPlan"));
    this.w = getIntent().getStringExtra("sysContractId");
    this.v = getIntent().getStringExtra("contractCode");
    d.getPayDetailInfo(this.x, this.v, this.w, this.t.getPeriods().intValue());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/activity/LeasePayDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */