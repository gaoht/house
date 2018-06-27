package com.ziroom.ziroomcustomer.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.alibaba.fastjson.e;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.e.k;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlib.utils.h;
import com.ziroom.commonlibrary.widget.unifiedziroom.BasicZiroomToolBar;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.contract.ContractDataActivity;
import com.ziroom.ziroomcustomer.e.a.f;
import com.ziroom.ziroomcustomer.e.c.n;
import com.ziroom.ziroomcustomer.e.e.q;
import com.ziroom.ziroomcustomer.e.g;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.e.q;
import com.ziroom.ziroomcustomer.my.CreditWebActivity;
import com.ziroom.ziroomcustomer.my.MyStewardInfoActivity;
import com.ziroom.ziroomcustomer.termination.InitiateTerminationActivity;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.util.w;
import com.ziroom.ziroomcustomer.webview.JsBridgeWebActivity;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeaseUpdataActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private Context a;
  private String b;
  private LeaseUpdataAdapter c;
  private List<d> d;
  private Unbinder e;
  @BindView(2131696705)
  ListViewForScrollView lease_updata_list;
  @BindView(2131689787)
  BasicZiroomToolBar mBztb;
  
  private void a()
  {
    com.freelxl.baselibrary.d.a.isLog(true);
    HashMap localHashMap = new HashMap();
    localHashMap.put("token", com.ziroom.commonlibrary.login.a.getToken(getApplicationContext()));
    localHashMap.put("contract_code", this.b + "");
    com.freelxl.baselibrary.d.a.get(q.Q + e.q.a + "?" + ah.encodeGetParams(g.getCommonHouseSign(localHashMap))).tag(this).enqueue(new f(this, new n())
    {
      public void onSuccess(int paramAnonymousInt, com.alibaba.fastjson.b paramAnonymousb)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousb);
        u.d("OKHttp", "===" + paramAnonymousb.toString());
        LeaseUpdataActivity.a(LeaseUpdataActivity.this, com.alibaba.fastjson.a.parseArray(paramAnonymousb.toString(), d.class));
        if (LeaseUpdataActivity.a(LeaseUpdataActivity.this) != null)
        {
          LeaseUpdataActivity.a(LeaseUpdataActivity.this, new LeaseUpdataAdapter(LeaseUpdataActivity.b(LeaseUpdataActivity.this), LeaseUpdataActivity.a(LeaseUpdataActivity.this)));
          LeaseUpdataActivity.this.lease_updata_list.setAdapter(LeaseUpdataActivity.d(LeaseUpdataActivity.this));
          return;
        }
        LeaseUpdataActivity.this.showToast("您暂时没有可变更操作");
      }
    });
  }
  
  @OnClick({2131696665})
  public void onClic(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    paramView = new Intent(this.a, CreditWebActivity.class);
    paramView.putExtra("url", "http://www.ziroom.com/zhuanti/2016/zzbcwa/leaseChange.html");
    paramView.putExtra("title", "租约变更说明");
    startActivity(paramView);
    w.onEvent(this.a, "change_lease_description");
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
    j.getContactHousekeeper(this.a, new a(), this.b, true);
    w.onEvent(this.a, "lease_renew_connect");
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130904844);
    this.a = this;
    this.e = ButterKnife.bind(this);
    this.b = getIntent().getStringExtra("lease");
    this.mBztb.setTitle("选择变更类型");
    a();
    this.lease_updata_list.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        if (LeaseUpdataActivity.a(LeaseUpdataActivity.this) == null) {}
        do
        {
          do
          {
            do
            {
              return;
            } while ("1".equals(((d)LeaseUpdataActivity.a(LeaseUpdataActivity.this).get(paramAnonymousInt)).getDisable()));
            if (!"continue".equals(((d)LeaseUpdataActivity.a(LeaseUpdataActivity.this).get(paramAnonymousInt)).getName())) {
              break;
            }
            if ("2".equals(((d)LeaseUpdataActivity.a(LeaseUpdataActivity.this).get(paramAnonymousInt)).getRenew_state()))
            {
              paramAnonymousAdapterView = new Intent(LeaseUpdataActivity.b(LeaseUpdataActivity.this), ContractDataActivity.class);
              paramAnonymousAdapterView.putExtra("cityCode", com.ziroom.ziroomcustomer.base.b.d);
              paramAnonymousAdapterView.putExtra("old_contract_code", LeaseUpdataActivity.c(LeaseUpdataActivity.this));
              LeaseUpdataActivity.this.startActivity(paramAnonymousAdapterView);
              w.onEvent(LeaseUpdataActivity.b(LeaseUpdataActivity.this), "change_lease_renew");
              return;
            }
            if ("3".equals(((d)LeaseUpdataActivity.a(LeaseUpdataActivity.this).get(paramAnonymousInt)).getRenew_state()))
            {
              LeaseUpdataActivity.this.showToast(((d)LeaseUpdataActivity.a(LeaseUpdataActivity.this).get(paramAnonymousInt)).getToast());
              return;
            }
          } while (!"1".equals(((d)LeaseUpdataActivity.a(LeaseUpdataActivity.this).get(paramAnonymousInt)).getRenew_state()));
          paramAnonymousAdapterView = new Intent(LeaseUpdataActivity.this, MyStewardInfoActivity.class);
          paramAnonymousAdapterView.putExtra("contractCode", LeaseUpdataActivity.c(LeaseUpdataActivity.this));
          LeaseUpdataActivity.this.startActivity(paramAnonymousAdapterView);
          return;
          if ("turn".equals(((d)LeaseUpdataActivity.a(LeaseUpdataActivity.this).get(paramAnonymousInt)).getName()))
          {
            paramAnonymousView = new Intent(LeaseUpdataActivity.b(LeaseUpdataActivity.this), JsBridgeWebActivity.class);
            paramAnonymousView.putExtra("lease", LeaseUpdataActivity.c(LeaseUpdataActivity.this));
            if (2 == h.getsEnvironment()) {
              paramAnonymousAdapterView = "http://www.t.ziroom.com/zhuanti/app/interaction/zhuanzu.html";
            }
            for (;;)
            {
              paramAnonymousView.putExtra("url", paramAnonymousAdapterView);
              LeaseUpdataActivity.this.startActivity(paramAnonymousView);
              w.onEvent(LeaseUpdataActivity.b(LeaseUpdataActivity.this), "change_lease_sublet");
              ApplicationEx.c.addActivity(LeaseUpdataActivity.this);
              return;
              if (3 == h.getsEnvironment()) {
                paramAnonymousAdapterView = "http://www.q.ziroom.com/zhuanti/app/interaction/zhuanzu.html";
              } else {
                paramAnonymousAdapterView = "http://zhuanti.ziroom.com/zhuanti/app/interaction/zhuanzu.html";
              }
            }
          }
        } while (!"quit".equals(((d)LeaseUpdataActivity.a(LeaseUpdataActivity.this).get(paramAnonymousInt)).getName()));
        paramAnonymousAdapterView = new Intent(LeaseUpdataActivity.b(LeaseUpdataActivity.this), InitiateTerminationActivity.class);
        paramAnonymousAdapterView.putExtra("contractCode", LeaseUpdataActivity.c(LeaseUpdataActivity.this));
        LeaseUpdataActivity.this.startActivity(paramAnonymousAdapterView);
        w.onEvent(LeaseUpdataActivity.b(LeaseUpdataActivity.this), "change_lease_off");
        ApplicationEx.c.addActivity(LeaseUpdataActivity.this);
      }
    });
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    ApplicationEx.c.removeActivity(this);
    this.e.unbind();
  }
  
  class a
    implements i.a<String>
  {
    a() {}
    
    public void onParse(String paramString, k paramk)
    {
      paramString = com.alibaba.fastjson.a.parseObject(paramString);
      if (((String)paramString.get("status")).equals("success"))
      {
        paramString = com.alibaba.fastjson.a.parseObject(paramString.get("data").toString());
        paramk.setObject(new b(paramString.getString("hire_contract_code"), paramString.getString("hire_commissioner_name"), paramString.getString("hire_commissioner_phone")));
        paramk.setSuccess(Boolean.valueOf(true));
        return;
      }
      paramk.setSuccess(Boolean.valueOf(false));
      paramk.setMessage((String)paramString.get("error_message"));
    }
    
    public void onSuccess(k paramk)
    {
      if (paramk.getSuccess().booleanValue())
      {
        paramk = (b)paramk.getObject();
        if (ae.notNull(paramk.getHire_commissioner_phone()))
        {
          ah.callPhone(LeaseUpdataActivity.b(LeaseUpdataActivity.this), paramk.getHire_commissioner_phone());
          return;
        }
        LeaseUpdataActivity.this.showToast("获取管家联系方式失败");
        return;
      }
      paramk = paramk.getMessage();
      LeaseUpdataActivity.this.showToast(paramk);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/activity/LeaseUpdataActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */