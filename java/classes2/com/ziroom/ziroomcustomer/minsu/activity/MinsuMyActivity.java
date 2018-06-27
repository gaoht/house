package com.ziroom.ziroomcustomer.minsu.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuOrderLastBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuOrderLastBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuOrderNumBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuOrderNumBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.dialog.i;
import com.ziroom.ziroomcustomer.minsu.f.aa;
import com.ziroom.ziroomcustomer.minsu.f.ad;
import com.ziroom.ziroomcustomer.minsu.f.k;
import com.ziroom.ziroomcustomer.minsu.f.r;
import com.ziroom.ziroomcustomer.minsu.f.s;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.widget.BadgeView;
import com.ziroom.ziroomcustomer.widget.MyInfoItemView;
import java.util.ArrayList;
import java.util.List;

public class MinsuMyActivity
  extends BaseActivity
  implements View.OnClickListener
{
  MinsuOrderLastBean.DataBean a;
  i b;
  List c;
  i d;
  @BindView(2131691618)
  LinearLayout date_area;
  @BindView(2131691619)
  TextView date_check_in;
  @BindView(2131691620)
  TextView date_check_out;
  private CommonTitle e;
  private MyInfoItemView f;
  private MyInfoItemView g;
  @BindView(2131691603)
  BadgeView order_appointment_count;
  @BindView(2131691616)
  LinearLayout order_detail_area;
  @BindView(2131691615)
  BadgeView order_evaluate_count;
  @BindView(2131691611)
  BadgeView order_occupancy_count;
  @BindView(2131691607)
  BadgeView order_payment_count;
  private MyInfoItemView r;
  @BindView(2131691600)
  RelativeLayout rl_order_appointment;
  private MyInfoItemView s;
  private MyInfoItemView t;
  @BindView(2131691378)
  TextView tv_house_address;
  @BindView(2131691210)
  TextView tv_house_name;
  @BindView(2131691599)
  TextView tv_order_more;
  private Unbinder u;
  private MinsuOrderLastBean v;
  
  private void a()
  {
    this.u = ButterKnife.bind(this);
    this.s = ((MyInfoItemView)findViewById(2131691626));
    this.r = ((MyInfoItemView)findViewById(2131691623));
    this.g = ((MyInfoItemView)findViewById(2131691622));
    this.f = ((MyInfoItemView)findViewById(2131691624));
    this.t = ((MyInfoItemView)findViewById(2131691625));
    this.s.setOnClickListener(this);
    this.r.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.t.setOnClickListener(this);
  }
  
  private void a(BadgeView paramBadgeView, int paramInt)
  {
    if (paramInt != 0)
    {
      paramBadgeView.setVisibility(0);
      paramBadgeView.setText(b(paramInt));
      return;
    }
    paramBadgeView.setVisibility(8);
  }
  
  private String b(int paramInt)
  {
    if (paramInt > 99) {
      return "...";
    }
    if (paramInt > 0) {
      return "" + paramInt;
    }
    return "";
  }
  
  private void b()
  {
    this.e = ((CommonTitle)findViewById(2131691272));
    this.e.setMiddleText("自如民宿");
    this.e.setOnLeftButtonClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MinsuMyActivity.this.finish();
      }
    });
  }
  
  private void e()
  {
    com.ziroom.ziroomcustomer.minsu.e.a.getOrderNum(this, new s(this, new r(MinsuOrderNumBean.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        MinsuMyActivity.this.order_appointment_count.setVisibility(8);
        MinsuMyActivity.this.order_payment_count.setVisibility(8);
        MinsuMyActivity.this.order_occupancy_count.setVisibility(8);
        MinsuMyActivity.this.order_evaluate_count.setVisibility(8);
      }
      
      public void onSuccess(int paramAnonymousInt, MinsuOrderNumBean paramAnonymousMinsuOrderNumBean)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousMinsuOrderNumBean);
        if (paramAnonymousMinsuOrderNumBean.data != null)
        {
          MinsuMyActivity.a(MinsuMyActivity.this, MinsuMyActivity.this.order_appointment_count, paramAnonymousMinsuOrderNumBean.data.applyNum);
          MinsuMyActivity.a(MinsuMyActivity.this, MinsuMyActivity.this.order_payment_count, paramAnonymousMinsuOrderNumBean.data.waitPayNum);
          MinsuMyActivity.a(MinsuMyActivity.this, MinsuMyActivity.this.order_occupancy_count, paramAnonymousMinsuOrderNumBean.data.waitCheckInNum);
          MinsuMyActivity.a(MinsuMyActivity.this, MinsuMyActivity.this.order_evaluate_count, paramAnonymousMinsuOrderNumBean.data.waitEvalNum);
          return;
        }
        MinsuMyActivity.this.order_appointment_count.setVisibility(8);
        MinsuMyActivity.this.order_payment_count.setVisibility(8);
        MinsuMyActivity.this.order_occupancy_count.setVisibility(8);
        MinsuMyActivity.this.order_evaluate_count.setVisibility(8);
      }
    });
  }
  
  private void f()
  {
    com.ziroom.ziroomcustomer.minsu.e.a.getOrdreLast(this, new s(this, new r(MinsuOrderLastBean.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        MinsuMyActivity.this.order_detail_area.setVisibility(8);
      }
      
      public void onSuccess(int paramAnonymousInt, MinsuOrderLastBean paramAnonymousMinsuOrderLastBean)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousMinsuOrderLastBean);
        if ((paramAnonymousMinsuOrderLastBean != null) && (paramAnonymousMinsuOrderLastBean.checkSuccess(MinsuMyActivity.this)))
        {
          if ((paramAnonymousMinsuOrderLastBean.data != null) && (paramAnonymousMinsuOrderLastBean.data != null))
          {
            MinsuMyActivity.a(MinsuMyActivity.this, paramAnonymousMinsuOrderLastBean);
            MinsuMyActivity.this.order_detail_area.setVisibility(0);
            MinsuMyActivity.this.a = paramAnonymousMinsuOrderLastBean.data;
            MinsuMyActivity.a(MinsuMyActivity.this);
          }
        }
        else {
          return;
        }
        MinsuMyActivity.this.order_detail_area.setVisibility(8);
      }
    });
  }
  
  private void g()
  {
    this.tv_house_name.setText(this.a.houseName);
    this.tv_house_address.setText(this.a.houseAddr);
    this.date_check_in.setText(this.a.startTimeStr);
    this.date_check_out.setText(this.a.endTimeStr);
  }
  
  private void h()
  {
    final Object localObject = new ArrayList();
    ((List)localObject).add(getString(2131296612));
    ((List)localObject).add(getString(2131296632));
    this.b = new i(this, new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        paramAnonymousAdapterView = (String)localObject.get(paramAnonymousInt);
        if (MinsuMyActivity.this.getString(2131296612).equals(paramAnonymousAdapterView)) {
          if (ae.notNull(MinsuMyActivity.this.a.landlordMobile)) {
            k.callPhone(MinsuMyActivity.this, MinsuMyActivity.this.a.landlordMobile);
          }
        }
        for (;;)
        {
          MinsuMyActivity.this.b.dismiss();
          return;
          MinsuMyActivity.b(MinsuMyActivity.this);
        }
      }
    }, (List)localObject);
    localObject = this.b;
    View localView = getWindow().getDecorView();
    if (!(localObject instanceof PopupWindow))
    {
      ((i)localObject).showAtLocation(localView, 80, 0, 0);
      return;
    }
    VdsAgent.showAtLocation((PopupWindow)localObject, localView, 80, 0, 0);
  }
  
  private void i()
  {
    k.toImPage(this, this.v.data.landlordUid, this.v.data.fid, this.v.data.rentWay, 2, MinsuMyActivity.class.getSimpleName());
  }
  
  private void j()
  {
    this.c = new ArrayList();
    final String str = aa.getString(ApplicationEx.c, "telphone", "");
    if (!TextUtils.isEmpty(str)) {
      this.c.add(getString(2131296752));
    }
    this.c.add(getString(2131296753));
    this.d = new i(this, new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        MinsuMyActivity.this.d.dismiss();
        if (MinsuMyActivity.this.c.get(paramAnonymousInt).equals(MinsuMyActivity.this.getString(2131296752)))
        {
          k.callPhone(MinsuMyActivity.this, str);
          return;
        }
        k.contactIM(MinsuMyActivity.this);
      }
    }, this.c);
  }
  
  private void k()
  {
    if (this.d == null) {
      return;
    }
    ad.hideSoftInput(this);
    new Handler().postDelayed(new Runnable()
    {
      public void run()
      {
        i locali = MinsuMyActivity.this.d;
        View localView = MinsuMyActivity.this.getWindow().getDecorView();
        if (!(locali instanceof PopupWindow))
        {
          locali.showAtLocation(localView, 80, 0, 0);
          return;
        }
        VdsAgent.showAtLocation((PopupWindow)locali, localView, 80, 0, 0);
      }
    }, 250L);
  }
  
  @OnClick({2131691621})
  public void contactLandlord()
  {
    h();
  }
  
  @OnClick({2131691210, 2131691618, 2131691378})
  public void goOrderDetail()
  {
    Intent localIntent = new Intent(this, MinsuSignedActivity.class);
    localIntent.putExtra("orderSn", this.a.orderSn);
    localIntent.putExtra("fid", this.a.fid);
    localIntent.putExtra("rentWay", this.a.rentWay);
    startActivityForResult(localIntent, 101);
  }
  
  @OnClick({2131691599})
  public void goOrderList()
  {
    startActivity(new Intent(this, MinsuOrderListActivity.class));
  }
  
  @OnClick({2131691600, 2131691604, 2131691608, 2131691612})
  public void goOrderTypeList(View paramView)
  {
    int i = -1;
    Object localObject = "";
    switch (paramView.getId())
    {
    default: 
      paramView = (View)localObject;
    }
    for (;;)
    {
      localObject = new Intent(this, MinsuOrderListActivity.class);
      ((Intent)localObject).putExtra("type", i);
      ((Intent)localObject).putExtra("title", paramView);
      startActivity((Intent)localObject);
      return;
      i = 4;
      paramView = getString(2131297137);
      continue;
      i = 5;
      paramView = getString(2131297143);
      continue;
      i = 6;
      paramView = getString(2131297141);
      continue;
      i = 7;
      paramView = getString(2131297139);
    }
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    if (!ApplicationEx.c.isLoginState())
    {
      com.ziroom.commonlibrary.login.a.startLoginActivity(this);
      return;
    }
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131691622: 
      startActivity(new Intent(this, MinsuHouseCollectListActivity.class));
      return;
    case 2131691626: 
      k.landlordActivity(this);
      return;
    case 2131691623: 
      startActivity(new Intent(this, MinsuCustomerChatListActivity.class));
      return;
    case 2131691624: 
      startActivity(new Intent(this, MinsuEvaluationListActivity.class));
      return;
    }
    j();
    k();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903316);
    a();
    b();
    e();
    f();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.u.unbind();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/activity/MinsuMyActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */