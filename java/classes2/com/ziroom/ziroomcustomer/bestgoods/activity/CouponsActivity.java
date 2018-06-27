package com.ziroom.ziroomcustomer.bestgoods.activity;

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
import com.ziroom.ziroomcustomer.e.l;
import com.ziroom.ziroomcustomer.newclean.d.al;
import com.ziroom.ziroomcustomer.widget.XListView;
import com.ziroom.ziroomcustomer.widget.XListView.a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CouponsActivity
  extends BaseActivity
  implements View.OnClickListener, XListView.a
{
  private ImageView a;
  private TextView b;
  private EditText c;
  private Button d;
  private String e;
  private String f;
  private String g;
  private Context r;
  private List<al> s = new ArrayList();
  private com.ziroom.ziroomcustomer.newServiceList.a.c t;
  private XListView u;
  private int v = 1;
  private ImageView w;
  private TextView x;
  private double y;
  
  private void a()
  {
    this.e = getIntent().getStringExtra("serviceInfoId");
    this.y = getIntent().getDoubleExtra("totalPrice", this.y);
    if (!checkNet(this.r))
    {
      g.textToast(this.r, "请检查网络连接");
      return;
    }
    b();
  }
  
  private void b()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("serviceInfoId", this.e);
    localHashMap.put("totalPrice", this.y + "");
    localHashMap.put("page", "1");
    localHashMap.put("pageSize", "1000");
    j.getGoodsCouponList(this, localHashMap, new a(new com.ziroom.ziroomcustomer.newrepair.utils.a(al.class, false)));
  }
  
  private void e()
  {
    this.a = ((ImageView)findViewById(2131689492));
    this.a.setFocusable(true);
    this.a.setFocusableInTouchMode(true);
    this.b = ((TextView)findViewById(2131690004));
    this.b.setVisibility(0);
    this.b.setText("不用优惠券");
    this.c = ((EditText)findViewById(2131690254));
    this.d = ((Button)findViewById(2131690255));
    this.u = ((XListView)findViewById(2131690260));
    this.x = ((TextView)findViewById(2131690259));
    this.t = new com.ziroom.ziroomcustomer.newServiceList.a.c(this.r, this.s);
    this.u.setAdapter(this.t);
    this.u.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        if (((al)CouponsActivity.a(CouponsActivity.this).get(paramAnonymousInt - 1)).getState() == 0)
        {
          paramAnonymousAdapterView = new Intent();
          paramAnonymousAdapterView.putExtra("useCoupon", true);
          paramAnonymousAdapterView.putExtra("couponItem", (Serializable)CouponsActivity.a(CouponsActivity.this).get(paramAnonymousInt - 1));
          CouponsActivity.this.setResult(-1, paramAnonymousAdapterView);
          CouponsActivity.this.finish();
          return;
        }
        if (((al)CouponsActivity.a(CouponsActivity.this).get(paramAnonymousInt - 1)).getState() == 1)
        {
          g.textToast(CouponsActivity.e(CouponsActivity.this), "优惠券已使用，请重新选择！");
          return;
        }
        if (((al)CouponsActivity.a(CouponsActivity.this).get(paramAnonymousInt - 1)).getState() == 2)
        {
          g.textToast(CouponsActivity.e(CouponsActivity.this), "优惠券已过期，请重新选择！");
          return;
        }
        g.textToast(CouponsActivity.e(CouponsActivity.this), "优惠券不可用，请重新选择！");
      }
    });
    this.u.setPullLoadEnable(false);
    this.u.setPullRefreshEnable(true);
    this.u.setXListViewListener(this);
    this.w = ((ImageView)findViewById(2131690256));
    this.w.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.a.setOnClickListener(this);
    this.b.setOnClickListener(this);
    this.c.addTextChangedListener(new c(this.c, this.r));
  }
  
  private void f()
  {
    String str = VdsAgent.trackEditTextSilent(this.c).toString().trim();
    if (TextUtils.isEmpty(str))
    {
      g.textToast(this.r, "请输入优惠券号码进行兑换");
      return;
    }
    if (!checkNet(this.r))
    {
      g.textToast(this.r, "请检查网络连接");
      return;
    }
    showProgress("");
    HashMap localHashMap = new HashMap();
    localHashMap.put("categoryCode", this.f);
    localHashMap.put("serviceInfoId", this.g);
    localHashMap.put("promoCode", str);
    j.getNewCoupon(this.r, localHashMap, new b());
  }
  
  private void g()
  {
    this.u.stopRefresh();
    this.u.stopLoadMore();
    this.u.setRefreshTime("刚刚");
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
    case 2131690004: 
      paramView = new Intent();
      paramView.putExtra("useCoupon", false);
      setResult(-1, paramView);
      finish();
      return;
    }
    this.c.setText("");
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903443);
    this.r = this;
    showProgress("");
    e();
    a();
  }
  
  public void onLoadMore() {}
  
  public void onRefresh()
  {
    showProgress("");
    this.v = 1;
    this.s.clear();
    this.t.notifyDataSetChanged();
    b();
  }
  
  class a
    extends com.freelxl.baselibrary.d.c.a<l>
  {
    public a(com.freelxl.baselibrary.d.f.a parama)
    {
      super();
    }
    
    public void onFailure(Throwable paramThrowable)
    {
      com.ziroom.ziroomcustomer.newrepair.utils.c.catchExp(paramThrowable);
      CouponsActivity.this.dismissProgress();
    }
    
    public void onSuccess(int paramInt, l paraml)
    {
      if (paraml.getSuccess().booleanValue())
      {
        paraml = (List)paraml.getObject();
        if ((paraml != null) && (paraml.size() > 0))
        {
          CouponsActivity.a(CouponsActivity.this).addAll(paraml);
          CouponsActivity.b(CouponsActivity.this).notifyDataSetChanged();
          CouponsActivity.c(CouponsActivity.this);
          CouponsActivity.d(CouponsActivity.this).setVisibility(8);
        }
      }
      for (;;)
      {
        CouponsActivity.this.dismissProgress();
        return;
        CouponsActivity.d(CouponsActivity.this).setVisibility(0);
        continue;
        paraml = paraml.getMessage();
        if (paraml != null) {
          g.textToast(CouponsActivity.e(CouponsActivity.this), paraml);
        } else {
          g.textToast(CouponsActivity.e(CouponsActivity.this), "服务器访问失败，无法获取数据");
        }
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
          g.textToast(CouponsActivity.e(CouponsActivity.this), "兑换成功");
          CouponsActivity.a(CouponsActivity.this).clear();
          CouponsActivity.b(CouponsActivity.this).notifyDataSetChanged();
          CouponsActivity.h(CouponsActivity.this);
          return;
        }
        g.textToast(CouponsActivity.e(CouponsActivity.this), "兑换失败");
        CouponsActivity.this.dismissProgress();
        return;
      }
      paramk = paramk.getMessage();
      if (paramk != null) {
        g.textToast(CouponsActivity.e(CouponsActivity.this), paramk);
      }
      for (;;)
      {
        CouponsActivity.this.dismissProgress();
        return;
        g.textToast(CouponsActivity.e(CouponsActivity.this), "服务器访问失败，无法获取数据");
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
        CouponsActivity.f(CouponsActivity.this).setBackgroundColor(33792);
        CouponsActivity.g(CouponsActivity.this).setVisibility(0);
      }
      if (paramCharSequence.length() == 0)
      {
        CouponsActivity.f(CouponsActivity.this).setBackgroundColor(-4473925);
        CouponsActivity.g(CouponsActivity.this).setVisibility(4);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/bestgoods/activity/CouponsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */