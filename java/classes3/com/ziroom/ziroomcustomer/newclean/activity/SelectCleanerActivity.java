package com.ziroom.ziroomcustomer.newclean.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.c.m;
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newServiceList.utils.trans.EasyTransitionOptions;
import com.ziroom.ziroomcustomer.newclean.b.p;
import com.ziroom.ziroomcustomer.newclean.d.ae;
import com.ziroom.ziroomcustomer.newclean.d.ag;
import com.ziroom.ziroomcustomer.newrepair.utils.ListViewForScrollView;
import com.ziroom.ziroomcustomer.util.u;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SelectCleanerActivity
  extends BaseActivity
{
  public static SelectCleanerActivity a = null;
  private String A;
  private String B;
  private String C;
  private String D;
  private LinearLayout E;
  private ListViewForScrollView F;
  private TextView G;
  private LinearLayout H;
  private TextView I;
  private ImageView J;
  private boolean K = false;
  private ImageView b;
  private ListViewForScrollView c;
  private String d;
  private String e;
  private String f;
  private String g;
  private UserInfo r;
  private SelectCleanerActivity s;
  private List<ag> t = new ArrayList();
  private List<ag> u = new ArrayList();
  private List<ag> v = new ArrayList();
  private p w;
  private String x;
  private String y;
  private String z;
  
  private void a()
  {
    this.b = ((ImageView)findViewById(2131689492));
    this.c = ((ListViewForScrollView)findViewById(2131692273));
    this.F = ((ListViewForScrollView)findViewById(2131692272));
    this.E = ((LinearLayout)findViewById(2131692271));
    this.H = ((LinearLayout)findViewById(2131690325));
    this.I = ((TextView)findViewById(2131690326));
    this.J = ((ImageView)findViewById(2131690327));
    this.G = ((TextView)findViewById(2131689956));
    this.b.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        SelectCleanerActivity.a(SelectCleanerActivity.this);
      }
    });
  }
  
  private void b()
  {
    this.d = getIntent().getStringExtra("appointDateTime");
    this.e = getIntent().getStringExtra("serviceInfoId");
    this.f = getIntent().getStringExtra("servicePmId");
    this.g = getIntent().getStringExtra("addressId");
    this.x = getIntent().getStringExtra("appointDate");
    this.y = getIntent().getStringExtra("defaultName");
    this.z = getIntent().getStringExtra("appointTime");
    this.A = getIntent().getStringExtra("day_index");
    this.B = getIntent().getStringExtra("card_index");
    this.C = getIntent().getStringExtra("service_price");
    this.D = getIntent().getStringExtra("cleanType");
    this.r = ApplicationEx.c.getUser();
    this.w = new p(this.s, this.t, this.x, this.e, this.f, this.g, this.y, this.z, this.A, this.B, this.C, this.D, this.d);
    this.F.setAdapter(this.w);
    e();
    f();
    this.c.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        u.e("dsfk", paramAnonymousInt + "");
        paramAnonymousAdapterView = new Intent(SelectCleanerActivity.b(SelectCleanerActivity.this), CleanerActivity.class);
        paramAnonymousAdapterView.putExtra("appointDateTime", SelectCleanerActivity.c(SelectCleanerActivity.this));
        paramAnonymousAdapterView.putExtra("serviceInfoId", SelectCleanerActivity.d(SelectCleanerActivity.this));
        paramAnonymousAdapterView.putExtra("servicePmId", SelectCleanerActivity.e(SelectCleanerActivity.this));
        paramAnonymousAdapterView.putExtra("addressId", SelectCleanerActivity.f(SelectCleanerActivity.this));
        paramAnonymousAdapterView.putExtra("cleanerId", ((ag)SelectCleanerActivity.g(SelectCleanerActivity.this).get(paramAnonymousInt)).getCleanerId());
        paramAnonymousAdapterView.putExtra("cleanerItem", (Serializable)SelectCleanerActivity.g(SelectCleanerActivity.this).get(paramAnonymousInt));
        paramAnonymousAdapterView.putExtra("appointDate", SelectCleanerActivity.h(SelectCleanerActivity.this));
        paramAnonymousAdapterView.putExtra("appointTime", SelectCleanerActivity.i(SelectCleanerActivity.this));
        paramAnonymousAdapterView.putExtra("day_index", SelectCleanerActivity.j(SelectCleanerActivity.this));
        paramAnonymousAdapterView.putExtra("card_index", SelectCleanerActivity.k(SelectCleanerActivity.this));
        paramAnonymousAdapterView.putExtra("defaultName", SelectCleanerActivity.l(SelectCleanerActivity.this));
        paramAnonymousAdapterView.putExtra("service_price", SelectCleanerActivity.m(SelectCleanerActivity.this));
        paramAnonymousAdapterView.putExtra("cleanType", SelectCleanerActivity.n(SelectCleanerActivity.this));
        if ("1".equals(((ag)SelectCleanerActivity.g(SelectCleanerActivity.this).get(paramAnonymousInt)).getFlag())) {
          paramAnonymousAdapterView.putExtra("isSelectCleaner", "isSelectCleaner");
        }
        paramAnonymousAdapterView.putExtra("from_type", "clean_general");
        com.ziroom.ziroomcustomer.newServiceList.utils.trans.a.startActivity(paramAnonymousAdapterView, EasyTransitionOptions.makeTransitionOptions(SelectCleanerActivity.this, new View[] { paramAnonymousView.findViewById(2131690380) }));
      }
    });
    this.F.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        u.e("dsfk", paramAnonymousInt + "");
        paramAnonymousAdapterView = new Intent(SelectCleanerActivity.b(SelectCleanerActivity.this), CleanerActivity.class);
        paramAnonymousAdapterView.putExtra("appointDateTime", SelectCleanerActivity.c(SelectCleanerActivity.this));
        paramAnonymousAdapterView.putExtra("serviceInfoId", SelectCleanerActivity.d(SelectCleanerActivity.this));
        paramAnonymousAdapterView.putExtra("servicePmId", SelectCleanerActivity.e(SelectCleanerActivity.this));
        paramAnonymousAdapterView.putExtra("addressId", SelectCleanerActivity.f(SelectCleanerActivity.this));
        paramAnonymousAdapterView.putExtra("cleanerId", ((ag)SelectCleanerActivity.o(SelectCleanerActivity.this).get(paramAnonymousInt)).getCleanerId());
        paramAnonymousAdapterView.putExtra("cleanerItem", (Serializable)SelectCleanerActivity.o(SelectCleanerActivity.this).get(paramAnonymousInt));
        paramAnonymousAdapterView.putExtra("appointDate", SelectCleanerActivity.h(SelectCleanerActivity.this));
        paramAnonymousAdapterView.putExtra("appointTime", SelectCleanerActivity.i(SelectCleanerActivity.this));
        paramAnonymousAdapterView.putExtra("day_index", SelectCleanerActivity.j(SelectCleanerActivity.this));
        paramAnonymousAdapterView.putExtra("card_index", SelectCleanerActivity.k(SelectCleanerActivity.this));
        paramAnonymousAdapterView.putExtra("defaultName", SelectCleanerActivity.l(SelectCleanerActivity.this));
        paramAnonymousAdapterView.putExtra("service_price", SelectCleanerActivity.m(SelectCleanerActivity.this));
        paramAnonymousAdapterView.putExtra("cleanType", SelectCleanerActivity.n(SelectCleanerActivity.this));
        if ("1".equals(((ag)SelectCleanerActivity.o(SelectCleanerActivity.this).get(paramAnonymousInt)).getFlag())) {
          paramAnonymousAdapterView.putExtra("isSelectCleaner", "isSelectCleaner");
        }
        if ("2".equals(((ag)SelectCleanerActivity.o(SelectCleanerActivity.this).get(paramAnonymousInt)).getFlag())) {
          paramAnonymousAdapterView.putExtra("noneAddress", "noneAddress");
        }
        paramAnonymousAdapterView.putExtra("from_type", "clean_general");
        com.ziroom.ziroomcustomer.newServiceList.utils.trans.a.startActivity(paramAnonymousAdapterView, EasyTransitionOptions.makeTransitionOptions(SelectCleanerActivity.this, new View[] { paramAnonymousView.findViewById(2131690380) }));
      }
    });
    this.G.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("isCleanerEmptey", "yes");
        paramAnonymousView.setAction("clean_time_info");
        ApplicationEx.c.sendBroadcast(paramAnonymousView);
        SelectCleanerActivity.this.finish();
      }
    });
  }
  
  private void back()
  {
    finish();
  }
  
  private void e()
  {
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if (localUserInfo == null) {
      return;
    }
    n.getCleanHistoryCleaner(this.s, localUserInfo.getUid(), this.d, this.e, this.f, this.g, "2", new com.ziroom.ziroomcustomer.e.a.a(this.s, new m(ae.class, new com.ziroom.ziroomcustomer.e.c.a.a()))
    {
      public void onSuccess(int paramAnonymousInt, ae paramAnonymousae)
      {
        int i = 0;
        super.onSuccess(paramAnonymousInt, paramAnonymousae);
        if (paramAnonymousae != null)
        {
          SelectCleanerActivity.a(SelectCleanerActivity.this, paramAnonymousae.getOptionDateList());
          if ((SelectCleanerActivity.o(SelectCleanerActivity.this) != null) && (SelectCleanerActivity.o(SelectCleanerActivity.this).size() > 0))
          {
            if ((SelectCleanerActivity.o(SelectCleanerActivity.this).size() == 1) && (SelectCleanerActivity.o(SelectCleanerActivity.this).get(0) == null))
            {
              SelectCleanerActivity.p(SelectCleanerActivity.this).setVisibility(8);
              return;
            }
            SelectCleanerActivity.p(SelectCleanerActivity.this).setVisibility(0);
            if (SelectCleanerActivity.o(SelectCleanerActivity.this).size() < 4)
            {
              SelectCleanerActivity.q(SelectCleanerActivity.this).setVisibility(8);
              SelectCleanerActivity.r(SelectCleanerActivity.this).setData(SelectCleanerActivity.o(SelectCleanerActivity.this));
              return;
            }
            SelectCleanerActivity.q(SelectCleanerActivity.this).setVisibility(0);
            paramAnonymousInt = i;
            while (paramAnonymousInt < SelectCleanerActivity.o(SelectCleanerActivity.this).size())
            {
              if (paramAnonymousInt < 3) {
                SelectCleanerActivity.s(SelectCleanerActivity.this).add(SelectCleanerActivity.o(SelectCleanerActivity.this).get(paramAnonymousInt));
              }
              paramAnonymousInt += 1;
            }
            SelectCleanerActivity.q(SelectCleanerActivity.this).setOnClickListener(new View.OnClickListener()
            {
              @Instrumented
              public void onClick(View paramAnonymous2View)
              {
                VdsAgent.onClick(this, paramAnonymous2View);
                if (SelectCleanerActivity.t(SelectCleanerActivity.this))
                {
                  SelectCleanerActivity.a(SelectCleanerActivity.this, true);
                  SelectCleanerActivity.u(SelectCleanerActivity.this).setText("查看更多");
                  SelectCleanerActivity.v(SelectCleanerActivity.this).setBackgroundResource(2130839134);
                  SelectCleanerActivity.r(SelectCleanerActivity.this).setData(SelectCleanerActivity.s(SelectCleanerActivity.this));
                  return;
                }
                SelectCleanerActivity.a(SelectCleanerActivity.this, true);
                SelectCleanerActivity.u(SelectCleanerActivity.this).setText("点我收起");
                SelectCleanerActivity.v(SelectCleanerActivity.this).setBackgroundResource(2130839136);
                SelectCleanerActivity.r(SelectCleanerActivity.this).setData(SelectCleanerActivity.o(SelectCleanerActivity.this));
              }
            });
            return;
          }
          SelectCleanerActivity.p(SelectCleanerActivity.this).setVisibility(8);
          return;
        }
        SelectCleanerActivity.p(SelectCleanerActivity.this).setVisibility(8);
      }
    });
  }
  
  private void f()
  {
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if (localUserInfo == null) {
      return;
    }
    n.getCleanCommendCleaner(this.s, localUserInfo.getUid(), this.d, this.e, this.f, this.g, "2", new com.ziroom.ziroomcustomer.e.a.a(this.s, new m(ae.class, new com.ziroom.ziroomcustomer.e.c.a.a()))
    {
      public void onSuccess(int paramAnonymousInt, ae paramAnonymousae)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousae);
        if (paramAnonymousae != null)
        {
          SelectCleanerActivity.b(SelectCleanerActivity.this, paramAnonymousae.getOptionDateList());
          if ((SelectCleanerActivity.g(SelectCleanerActivity.this) != null) && (SelectCleanerActivity.g(SelectCleanerActivity.this).size() > 0) && ((SelectCleanerActivity.g(SelectCleanerActivity.this).size() != 1) || (SelectCleanerActivity.g(SelectCleanerActivity.this).get(0) != null))) {}
        }
        else
        {
          return;
        }
        paramAnonymousae = new p(SelectCleanerActivity.b(SelectCleanerActivity.this), SelectCleanerActivity.g(SelectCleanerActivity.this), SelectCleanerActivity.h(SelectCleanerActivity.this), SelectCleanerActivity.d(SelectCleanerActivity.this), SelectCleanerActivity.e(SelectCleanerActivity.this), SelectCleanerActivity.f(SelectCleanerActivity.this), SelectCleanerActivity.l(SelectCleanerActivity.this), SelectCleanerActivity.i(SelectCleanerActivity.this), SelectCleanerActivity.j(SelectCleanerActivity.this), SelectCleanerActivity.k(SelectCleanerActivity.this), SelectCleanerActivity.m(SelectCleanerActivity.this), SelectCleanerActivity.n(SelectCleanerActivity.this), SelectCleanerActivity.c(SelectCleanerActivity.this));
        SelectCleanerActivity.w(SelectCleanerActivity.this).setAdapter(paramAnonymousae);
      }
    });
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903469);
    this.s = this;
    a = this;
    a();
    b();
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      finish();
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/activity/SelectCleanerActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */