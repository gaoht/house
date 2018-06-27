package com.ziroom.ziroomcustomer.ziroomstation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.e.k;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.util.af;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.w;
import com.ziroom.ziroomcustomer.widget.XListView;
import com.ziroom.ziroomcustomer.widget.XListView.a;
import com.ziroom.ziroomcustomer.ziroomstation.adapter.StationCouponNewAdapter;
import com.ziroom.ziroomcustomer.ziroomstation.b.b;
import com.ziroom.ziroomcustomer.ziroomstation.b.c;
import com.ziroom.ziroomcustomer.ziroomstation.model.StationCoupon;
import com.ziroom.ziroomcustomer.ziroomstation.model.StationCoupon.DataEntity;
import com.ziroom.ziroomcustomer.ziroomstation.model.StationOrderCreateHouseEntity;
import java.io.Serializable;
import java.util.List;

public class StationCouponActivity
  extends BaseActivity
  implements View.OnClickListener, XListView.a
{
  private List<StationOrderCreateHouseEntity> A;
  private ImageView a;
  private EditText b;
  private Button c;
  private Context d;
  private StationCouponNewAdapter e;
  private XListView f;
  private String g;
  private int r = 1;
  private UserInfo s;
  private ImageView t;
  private TextView u;
  private StationCoupon v;
  private List<StationCoupon.DataEntity> w;
  private String x;
  private String y;
  private String z;
  
  private void a()
  {
    if (ApplicationEx.c.getUser() != null)
    {
      this.s = ApplicationEx.c.getUser();
      this.g = this.s.getUid();
    }
  }
  
  private void b()
  {
    this.a = ((ImageView)findViewById(2131689492));
    this.b = ((EditText)findViewById(2131690254));
    this.c = ((Button)findViewById(2131690255));
    this.f = ((XListView)findViewById(2131690260));
    this.u = ((TextView)findViewById(2131690259));
    this.f.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        if (StationCouponActivity.a(StationCouponActivity.this) != null)
        {
          if (((StationCoupon.DataEntity)StationCouponActivity.a(StationCouponActivity.this).get(paramAnonymousInt - 1)).isIsUsable())
          {
            paramAnonymousAdapterView = StationCouponActivity.this.getIntent();
            paramAnonymousAdapterView.putExtra("couponItem", (Serializable)StationCouponActivity.a(StationCouponActivity.this).get(paramAnonymousInt - 1));
            StationCouponActivity.this.setResult(-1, paramAnonymousAdapterView);
            StationCouponActivity.this.finish();
          }
        }
        else {
          return;
        }
        af.showToast(StationCouponActivity.b(StationCouponActivity.this), "优惠券不可用，请重新选择！");
      }
    });
    this.e = new StationCouponNewAdapter(this.d, this.w);
    this.f.setAdapter(this.e);
    this.f.setPullLoadEnable(false);
    this.f.setPullRefreshEnable(true);
    this.f.setXListViewListener(this);
    this.t = ((ImageView)findViewById(2131690256));
    this.t.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.c.setClickable(false);
    this.a.setOnClickListener(this);
    this.b.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        if (paramAnonymousCharSequence.length() > 0)
        {
          StationCouponActivity.c(StationCouponActivity.this).setBackgroundColor(-44032);
          StationCouponActivity.c(StationCouponActivity.this).setClickable(true);
          StationCouponActivity.d(StationCouponActivity.this).setVisibility(0);
        }
        if (paramAnonymousCharSequence.length() == 0)
        {
          StationCouponActivity.c(StationCouponActivity.this).setBackgroundColor(-4473925);
          StationCouponActivity.c(StationCouponActivity.this).setClickable(false);
          StationCouponActivity.d(StationCouponActivity.this).setVisibility(4);
        }
      }
    });
  }
  
  private void e()
  {
    if ((VdsAgent.trackEditTextSilent(this.b).toString() == null) && ("".equals(VdsAgent.trackEditTextSilent(this.b).toString()))) {
      showToast("请输入优惠券号码进行对换");
    }
    String str = VdsAgent.trackEditTextSilent(this.b).toString().trim();
    if (!ah.checkNet(this.d))
    {
      af.showToast(this.d, 2131297483);
      return;
    }
    c.redeTicket(this.d, b.buildRedeTicket(this, this.g, str), new i.a()
    {
      public void onParse(String paramAnonymousString, k paramAnonymousk) {}
      
      public void onSuccess(k paramAnonymousk)
      {
        paramAnonymousk = (com.ziroom.ziroomcustomer.ziroomstation.b.a)paramAnonymousk.getObject();
        if ((paramAnonymousk != null) && ("200".equals(paramAnonymousk.getError_code())))
        {
          af.showToast(StationCouponActivity.b(StationCouponActivity.this), "兑换成功！");
          StationCouponActivity.e(StationCouponActivity.this);
        }
        while ((paramAnonymousk == null) || (TextUtils.isEmpty(paramAnonymousk.getError_message()))) {
          return;
        }
        af.showToast(StationCouponActivity.b(StationCouponActivity.this), paramAnonymousk.getError_message());
      }
    }, true);
  }
  
  private void f()
  {
    this.f.stopRefresh();
    this.f.stopLoadMore();
    this.f.setRefreshTime("刚刚");
  }
  
  private void g()
  {
    c.getStationTickets(this.d, b.buildStationTickets(this, this.x, this.g, this.y, this.z, this.A), new i.a()
    {
      public void onParse(String paramAnonymousString, k paramAnonymousk) {}
      
      public void onSuccess(k paramAnonymousk)
      {
        StationCouponActivity.a(StationCouponActivity.this, (StationCoupon)paramAnonymousk.getObject());
        if ((StationCouponActivity.f(StationCouponActivity.this) != null) && ("200".equals(StationCouponActivity.f(StationCouponActivity.this).getError_code())))
        {
          StationCouponActivity.a(StationCouponActivity.this, StationCouponActivity.f(StationCouponActivity.this).getData());
          StationCouponActivity.g(StationCouponActivity.this).setList(StationCouponActivity.a(StationCouponActivity.this));
          StationCouponActivity.h(StationCouponActivity.this).setPullLoadEnable(true);
          StationCouponActivity.i(StationCouponActivity.this);
          if ((StationCouponActivity.a(StationCouponActivity.this) != null) && (StationCouponActivity.a(StationCouponActivity.this).size() == 0)) {
            StationCouponActivity.j(StationCouponActivity.this).setVisibility(0);
          }
        }
        while ((StationCouponActivity.f(StationCouponActivity.this) == null) || (TextUtils.isEmpty(StationCouponActivity.f(StationCouponActivity.this).getError_message())))
        {
          return;
          StationCouponActivity.j(StationCouponActivity.this).setVisibility(8);
          return;
        }
        af.showToast(StationCouponActivity.b(StationCouponActivity.this), StationCouponActivity.f(StationCouponActivity.this).getError_message());
      }
    }, true);
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131690255: 
      e();
      w.onEvent(this.d, "movecoupon_change");
      return;
    case 2131689492: 
      finish();
      w.onEvent(this.d, "movegoods_return");
      return;
    }
    this.b.setText("");
    w.onEvent(this.d, "movecoupon_del");
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903142);
    this.d = this;
    if (getIntent().getExtras() != null)
    {
      paramBundle = getIntent();
      this.x = paramBundle.getExtras().getString("projectBid", "");
      this.y = paramBundle.getExtras().getString("startDate", "");
      this.z = paramBundle.getExtras().getString("endDate", "");
      this.A = com.alibaba.fastjson.a.parseArray(paramBundle.getExtras().getString("HouseList", "[]"), StationOrderCreateHouseEntity.class);
    }
    b();
    a();
    g();
  }
  
  public void onLoadMore()
  {
    this.u.setVisibility(8);
    g();
  }
  
  public void onRefresh()
  {
    this.f.setPullLoadEnable(false);
    this.u.setVisibility(8);
    g();
  }
  
  protected void onResume()
  {
    a("zinn_book_sale_duration");
    super.onResume();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/StationCouponActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */