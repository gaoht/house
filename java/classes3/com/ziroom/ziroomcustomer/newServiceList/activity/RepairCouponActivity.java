package com.ziroom.ziroomcustomer.newServiceList.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.newServiceList.a.c;
import com.ziroom.ziroomcustomer.newclean.d.al;
import com.ziroom.ziroomcustomer.widget.XListView;
import com.ziroom.ziroomcustomer.widget.XListView.a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepairCouponActivity
  extends BaseActivity
  implements View.OnClickListener, XListView.a
{
  private ImageView a;
  private EditText b;
  private Button c;
  private String d;
  private String e;
  private Context f;
  private List<al> g = new ArrayList();
  private c r;
  private XListView s;
  private int t = 1;
  private ImageView u;
  private TextView v;
  
  private void a()
  {
    this.d = getIntent().getStringExtra("categoryCode");
    this.e = getIntent().getStringExtra("productCode");
    if (!checkNet(this.f))
    {
      g.textToast(this.f, "请检查网络连接");
      return;
    }
    b();
  }
  
  private void b()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("categoryCode", this.d);
    localHashMap.put("serviceInfoId", this.e);
    localHashMap.put("page", Integer.valueOf(1));
    localHashMap.put("pageSize", Integer.valueOf(1000));
    j.getCouponList(this.f, localHashMap, new a());
  }
  
  private void e()
  {
    this.a = ((ImageView)findViewById(2131689492));
    this.a.setFocusable(true);
    this.a.setFocusableInTouchMode(true);
    this.b = ((EditText)findViewById(2131690254));
    this.c = ((Button)findViewById(2131690255));
    this.s = ((XListView)findViewById(2131690260));
    this.v = ((TextView)findViewById(2131690259));
    this.r = new c(this.f, this.g);
    this.s.setAdapter(this.r);
    this.s.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        if (((al)RepairCouponActivity.a(RepairCouponActivity.this).get(paramAnonymousInt - 1)).getState() == 0)
        {
          paramAnonymousAdapterView = new Intent();
          paramAnonymousAdapterView.putExtra("couponItem", (Serializable)RepairCouponActivity.a(RepairCouponActivity.this).get(paramAnonymousInt - 1));
          RepairCouponActivity.this.setResult(-1, paramAnonymousAdapterView);
          RepairCouponActivity.this.finish();
          return;
        }
        if (((al)RepairCouponActivity.a(RepairCouponActivity.this).get(paramAnonymousInt - 1)).getState() == 1)
        {
          g.textToast(RepairCouponActivity.e(RepairCouponActivity.this), "优惠券已使用，请重新选择！");
          return;
        }
        if (((al)RepairCouponActivity.a(RepairCouponActivity.this).get(paramAnonymousInt - 1)).getState() == 2)
        {
          g.textToast(RepairCouponActivity.e(RepairCouponActivity.this), "优惠券已过期，请重新选择！");
          return;
        }
        g.textToast(RepairCouponActivity.e(RepairCouponActivity.this), "优惠券不可用，请重新选择！");
      }
    });
    this.s.setPullLoadEnable(false);
    this.s.setPullRefreshEnable(true);
    this.s.setXListViewListener(this);
    this.u = ((ImageView)findViewById(2131690256));
    this.u.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.a.setOnClickListener(this);
    this.b.addTextChangedListener(new c(this.b, this.f));
  }
  
  private void f()
  {
    String str = VdsAgent.trackEditTextSilent(this.b).toString().trim();
    if (TextUtils.isEmpty(str))
    {
      g.textToast(this.f, "请输入优惠券号码进行兑换");
      return;
    }
    if (!checkNet(this.f))
    {
      g.textToast(this.f, "请检查网络连接");
      return;
    }
    showProgress("");
    HashMap localHashMap = new HashMap();
    localHashMap.put("categoryCode", this.d);
    localHashMap.put("serviceInfoId", this.e);
    localHashMap.put("promoCode", str);
    j.getNewCoupon(this.f, localHashMap, new b());
  }
  
  private void g()
  {
    this.s.stopRefresh();
    this.s.stopLoadMore();
    this.s.setRefreshTime("刚刚");
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
      f();
      return;
    case 2131689492: 
      finish();
      return;
    }
    this.b.setText("");
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903443);
    this.f = this;
    showProgress("");
    e();
    a();
  }
  
  public void onLoadMore() {}
  
  public void onRefresh()
  {
    showProgress("");
    this.t = 1;
    this.g.clear();
    this.r.notifyDataSetChanged();
    b();
  }
  
  class a
    implements i.a<String>
  {
    a() {}
    
    public void onParse(String paramString, k paramk)
    {
      paramString = com.alibaba.fastjson.a.parseObject(paramString);
      if ("0".equals((String)paramString.get("status")))
      {
        if (paramString.get("data") == null)
        {
          paramk.setSuccess(Boolean.valueOf(true));
          paramk.setObject(null);
          return;
        }
        paramString = com.alibaba.fastjson.a.parseArray(paramString.get("data").toString(), al.class);
        paramk.setSuccess(Boolean.valueOf(true));
        paramk.setObject(paramString);
        return;
      }
      paramk.setSuccess(Boolean.valueOf(false));
      paramk.setMessage((String)paramString.get("message"));
    }
    
    public void onSuccess(k paramk)
    {
      if (paramk.getSuccess().booleanValue())
      {
        paramk = (List)paramk.getObject();
        if ((paramk != null) && (paramk.size() > 0))
        {
          RepairCouponActivity.a(RepairCouponActivity.this).addAll(paramk);
          RepairCouponActivity.b(RepairCouponActivity.this).notifyDataSetChanged();
          RepairCouponActivity.c(RepairCouponActivity.this);
          RepairCouponActivity.d(RepairCouponActivity.this).setVisibility(8);
          RepairCouponActivity.this.dismissProgress();
          return;
        }
        RepairCouponActivity.d(RepairCouponActivity.this).setVisibility(0);
        RepairCouponActivity.this.dismissProgress();
        return;
      }
      paramk = paramk.getMessage();
      if (paramk != null) {
        g.textToast(RepairCouponActivity.e(RepairCouponActivity.this), paramk);
      }
      for (;;)
      {
        RepairCouponActivity.this.dismissProgress();
        return;
        g.textToast(RepairCouponActivity.e(RepairCouponActivity.this), "服务器访问失败，无法获取数据");
      }
    }
  }
  
  class b
    implements i.a<String>
  {
    b() {}
    
    public void onParse(String paramString, k paramk)
    {
      paramString = com.alibaba.fastjson.a.parseObject(paramString);
      if ("0".equals((String)paramString.get("status")))
      {
        boolean bool = ((Boolean)com.alibaba.fastjson.a.parse(paramString.get("data").toString())).booleanValue();
        paramk.setSuccess(Boolean.valueOf(true));
        paramk.setObject(Boolean.valueOf(bool));
        return;
      }
      paramk.setSuccess(Boolean.valueOf(false));
      paramk.setMessage((String)paramString.get("message"));
    }
    
    public void onSuccess(k paramk)
    {
      if (paramk.getSuccess().booleanValue())
      {
        if (((Boolean)paramk.getObject()).booleanValue())
        {
          g.textToast(RepairCouponActivity.e(RepairCouponActivity.this), "兑换成功");
          RepairCouponActivity.a(RepairCouponActivity.this).clear();
          RepairCouponActivity.b(RepairCouponActivity.this).notifyDataSetChanged();
          RepairCouponActivity.h(RepairCouponActivity.this);
          return;
        }
        g.textToast(RepairCouponActivity.e(RepairCouponActivity.this), "兑换失败");
        RepairCouponActivity.this.dismissProgress();
        return;
      }
      paramk = paramk.getMessage();
      if (paramk != null) {
        g.textToast(RepairCouponActivity.e(RepairCouponActivity.this), paramk);
      }
      for (;;)
      {
        RepairCouponActivity.this.dismissProgress();
        return;
        g.textToast(RepairCouponActivity.e(RepairCouponActivity.this), "服务器访问失败，无法获取数据");
      }
    }
  }
  
  class c
    extends com.ziroom.ziroomcustomer.newServiceList.view.a
  {
    public c(EditText paramEditText, Context paramContext)
    {
      super(paramContext);
    }
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
      if (paramCharSequence.length() > 0)
      {
        RepairCouponActivity.f(RepairCouponActivity.this).setBackgroundColor(33792);
        RepairCouponActivity.g(RepairCouponActivity.this).setVisibility(0);
      }
      if (paramCharSequence.length() == 0)
      {
        RepairCouponActivity.f(RepairCouponActivity.this).setBackgroundColor(-4473925);
        RepairCouponActivity.g(RepairCouponActivity.this).setVisibility(4);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/activity/RepairCouponActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */