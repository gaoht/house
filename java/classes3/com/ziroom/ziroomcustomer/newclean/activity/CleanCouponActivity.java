package com.ziroom.ziroomcustomer.newclean.activity;

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
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.a.b;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.a.h;
import com.ziroom.ziroomcustomer.e.c.l;
import com.ziroom.ziroomcustomer.e.c.m;
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.e.o;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newclean.b.r;
import com.ziroom.ziroomcustomer.newclean.d.ak;
import com.ziroom.ziroomcustomer.newclean.d.al;
import com.ziroom.ziroomcustomer.util.w;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CleanCouponActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private String A;
  private h B = new h(this, new m(Boolean.class, new com.ziroom.ziroomcustomer.e.c.a.g()))
  {
    public void onFailure(Throwable paramAnonymousThrowable)
    {
      super.onFailure(paramAnonymousThrowable);
      if (((paramAnonymousThrowable instanceof b)) && (((b)paramAnonymousThrowable).getCode() == 1000002))
      {
        paramAnonymousThrowable = VdsAgent.trackEditTextSilent(CleanCouponActivity.h(CleanCouponActivity.this)).toString().trim();
        o.getNewCoupon(CleanCouponActivity.this, CleanCouponActivity.i(CleanCouponActivity.this), CleanCouponActivity.j(CleanCouponActivity.this), paramAnonymousThrowable, "1", CleanCouponActivity.k(CleanCouponActivity.this));
      }
    }
    
    public void onSuccess(int paramAnonymousInt, Boolean paramAnonymousBoolean)
    {
      super.onSuccess(paramAnonymousInt, paramAnonymousBoolean);
      CleanCouponActivity.a(CleanCouponActivity.this).clear();
      CleanCouponActivity.g(CleanCouponActivity.this).notifyDataSetChanged();
      CleanCouponActivity.this.getSortCouponList();
    }
  };
  private ImageView a;
  private EditText b;
  private Button c;
  private TextView d;
  private String e;
  private Context f;
  private List<al> g = new ArrayList();
  private r r;
  private ListView s;
  private String t;
  private UserInfo u;
  private ImageView v;
  private String w;
  private RelativeLayout x;
  private String y;
  private String z;
  
  private void a()
  {
    this.e = getIntent().getStringExtra("serviceInfoId");
    this.y = getIntent().getStringExtra("serviceItemCode");
    this.z = getIntent().getStringExtra("startTime");
    this.A = getIntent().getStringExtra("isFrom");
    this.w = getIntent().getStringExtra("addressId");
    this.a = ((ImageView)findViewById(2131689492));
    this.b = ((EditText)findViewById(2131690254));
    this.c = ((Button)findViewById(2131690255));
    this.s = ((ListView)findViewById(2131690260));
    this.x = ((RelativeLayout)findViewById(2131690257));
    this.d = ((TextView)findViewById(2131690252));
    this.v = ((ImageView)findViewById(2131690256));
    if (TextUtils.isEmpty(this.w)) {
      this.w = "effort_have$%_#";
    }
    this.r = new r(this.f, this.g, this.w);
    this.s.setAdapter(this.r);
    this.s.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        if (((al)CleanCouponActivity.a(CleanCouponActivity.this).get(paramAnonymousInt)).getIsUsable() == 0) {
          if (TextUtils.isEmpty(((al)CleanCouponActivity.a(CleanCouponActivity.this).get(paramAnonymousInt)).getDescription())) {
            com.freelxl.baselibrary.f.g.textToast(CleanCouponActivity.b(CleanCouponActivity.this), "优惠券不可用！");
          }
        }
        do
        {
          return;
          com.freelxl.baselibrary.f.g.textToast(CleanCouponActivity.b(CleanCouponActivity.this), ((al)CleanCouponActivity.a(CleanCouponActivity.this).get(paramAnonymousInt)).getDescription());
          return;
          if (((al)CleanCouponActivity.a(CleanCouponActivity.this).get(paramAnonymousInt)).getState() != 0) {
            break label578;
          }
          if (TextUtils.isEmpty(CleanCouponActivity.c(CleanCouponActivity.this))) {
            break;
          }
          if ("from_period_pay".equals(CleanCouponActivity.c(CleanCouponActivity.this)))
          {
            paramAnonymousAdapterView = new Intent();
            paramAnonymousAdapterView.putExtra("couponId", ((al)CleanCouponActivity.a(CleanCouponActivity.this).get(paramAnonymousInt)).getPromoId());
            paramAnonymousAdapterView.putExtra("couponCode", ((al)CleanCouponActivity.a(CleanCouponActivity.this).get(paramAnonymousInt)).getPromoCode());
            CleanCouponActivity.this.setResult(-1, paramAnonymousAdapterView);
            CleanCouponActivity.this.finish();
            return;
          }
          if ("pay_new_modify_general".equals(CleanCouponActivity.c(CleanCouponActivity.this)))
          {
            paramAnonymousAdapterView = new ak();
            paramAnonymousAdapterView.setCouponId(((al)CleanCouponActivity.a(CleanCouponActivity.this).get(paramAnonymousInt)).getPromoId());
            paramAnonymousAdapterView.setCouponCode(((al)CleanCouponActivity.a(CleanCouponActivity.this).get(paramAnonymousInt)).getPromoCode());
            org.greenrobot.eventbus.c.getDefault().post(new com.ziroom.ziroomcustomer.newServiceList.utils.c("general_pay_modify_coupon_info", paramAnonymousAdapterView));
            CleanCouponActivity.this.finish();
            return;
          }
        } while (!"pay_new_modify_period_general".equals(CleanCouponActivity.c(CleanCouponActivity.this)));
        paramAnonymousAdapterView = new ak();
        paramAnonymousAdapterView.setCouponId(((al)CleanCouponActivity.a(CleanCouponActivity.this).get(paramAnonymousInt)).getPromoId());
        paramAnonymousAdapterView.setCouponCode(((al)CleanCouponActivity.a(CleanCouponActivity.this).get(paramAnonymousInt)).getPromoCode());
        org.greenrobot.eventbus.c.getDefault().post(new com.ziroom.ziroomcustomer.newServiceList.utils.c("period_general_pay_modify_coupon_info", paramAnonymousAdapterView));
        CleanCouponActivity.this.finish();
        return;
        if (!TextUtils.isEmpty(((al)CleanCouponActivity.a(CleanCouponActivity.this).get(paramAnonymousInt)).getCommonAdressId()))
        {
          if (!CleanCouponActivity.d(CleanCouponActivity.this).equals(((al)CleanCouponActivity.a(CleanCouponActivity.this).get(paramAnonymousInt)).getCommonAdressId()))
          {
            com.freelxl.baselibrary.f.g.textToast(CleanCouponActivity.b(CleanCouponActivity.this), "整租优惠券只有在整租的房间才可以使用！");
            return;
          }
          paramAnonymousAdapterView = new Intent();
          paramAnonymousAdapterView.putExtra("couponItem", (Serializable)CleanCouponActivity.a(CleanCouponActivity.this).get(paramAnonymousInt));
          CleanCouponActivity.this.setResult(-1, paramAnonymousAdapterView);
          CleanCouponActivity.this.finish();
          return;
        }
        paramAnonymousAdapterView = new Intent();
        paramAnonymousAdapterView.putExtra("couponItem", (Serializable)CleanCouponActivity.a(CleanCouponActivity.this).get(paramAnonymousInt));
        CleanCouponActivity.this.setResult(-1, paramAnonymousAdapterView);
        CleanCouponActivity.this.finish();
        return;
        label578:
        if (((al)CleanCouponActivity.a(CleanCouponActivity.this).get(paramAnonymousInt)).getState() == 1)
        {
          com.freelxl.baselibrary.f.g.textToast(CleanCouponActivity.b(CleanCouponActivity.this), "优惠券已使用，请重新选择！");
          return;
        }
        if (((al)CleanCouponActivity.a(CleanCouponActivity.this).get(paramAnonymousInt)).getState() == 2)
        {
          com.freelxl.baselibrary.f.g.textToast(CleanCouponActivity.b(CleanCouponActivity.this), "优惠券已使用，请重新选择！");
          return;
        }
        com.freelxl.baselibrary.f.g.textToast(CleanCouponActivity.b(CleanCouponActivity.this), "优惠券已使用，请重新选择！");
      }
    });
    this.v.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.a.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.b.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        if (paramAnonymousCharSequence.length() > 0)
        {
          CleanCouponActivity.e(CleanCouponActivity.this).setBackgroundColor(33792);
          CleanCouponActivity.f(CleanCouponActivity.this).setVisibility(0);
        }
        if (paramAnonymousCharSequence.length() == 0)
        {
          CleanCouponActivity.e(CleanCouponActivity.this).setBackgroundColor(-4473925);
          CleanCouponActivity.f(CleanCouponActivity.this).setVisibility(4);
        }
      }
    });
  }
  
  private void b()
  {
    if (ApplicationEx.c.getUser() != null)
    {
      this.u = ApplicationEx.c.getUser();
      this.t = this.u.getUid();
      getSortCouponList();
    }
  }
  
  private void e()
  {
    String str = VdsAgent.trackEditTextSilent(this.b).toString().trim();
    if (TextUtils.isEmpty(str))
    {
      com.freelxl.baselibrary.f.g.textToast(this.f, "请输入优惠券号码进行兑换");
      return;
    }
    o.getNewCoupon(this, this.e, this.t, str, "0", this.B);
  }
  
  public void getSortCouponList()
  {
    Object localObject2 = Integer.valueOf(0);
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty(this.A))
    {
      localObject1 = localObject2;
      if ("from_period_pay".equals(this.A)) {
        localObject1 = Integer.valueOf(1);
      }
    }
    localObject2 = localObject1;
    if (!TextUtils.isEmpty(this.A))
    {
      localObject2 = localObject1;
      if ("pay_new_modify_period_general".equals(this.A)) {
        localObject2 = Integer.valueOf(1);
      }
    }
    if ((!TextUtils.isEmpty(this.A)) && ("period_general_pay_modify_coupon_info".equals(this.A))) {}
    for (localObject1 = Integer.valueOf(1);; localObject1 = localObject2)
    {
      localObject2 = ApplicationEx.c.getUser();
      if (localObject2 != null) {
        n.getSortCouponList(this.f, 2, this.w, this.y, this.e, this.z, ((UserInfo)localObject2).getUid(), (Integer)localObject1, new com.freelxl.baselibrary.d.c.a(new l(al.class, new com.ziroom.ziroomcustomer.e.c.a.a()))
        {
          public void onFailure(Throwable paramAnonymousThrowable) {}
          
          public void onSuccess(int paramAnonymousInt, List<al> paramAnonymousList)
          {
            if ((paramAnonymousList != null) && (paramAnonymousList.size() > 0))
            {
              CleanCouponActivity.a(CleanCouponActivity.this).addAll(paramAnonymousList);
              if (CleanCouponActivity.a(CleanCouponActivity.this).size() == 0) {
                CleanCouponActivity.l(CleanCouponActivity.this).setVisibility(0);
              }
              for (;;)
              {
                CleanCouponActivity.g(CleanCouponActivity.this).notifyDataSetChanged();
                return;
                CleanCouponActivity.l(CleanCouponActivity.this).setVisibility(8);
              }
            }
            if (CleanCouponActivity.a(CleanCouponActivity.this).size() == 0)
            {
              CleanCouponActivity.l(CleanCouponActivity.this).setVisibility(0);
              return;
            }
            CleanCouponActivity.l(CleanCouponActivity.this).setVisibility(8);
          }
        });
      }
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
    case 2131690255: 
      e();
      w.onEvent(this.f, "dailycoupon_change");
      return;
    case 2131689492: 
      finish();
      w.onEvent(this.f, "dailycoupon_return");
      return;
    case 2131690256: 
      this.b.setText("");
      w.onEvent(this.f, "dailycoupon_del");
      return;
    }
    if (!TextUtils.isEmpty(this.A))
    {
      if ("pay_new_modify_general".equals(this.A))
      {
        org.greenrobot.eventbus.c.getDefault().post(new com.ziroom.ziroomcustomer.newServiceList.utils.c("general_pay_modify_coupon_info_not_use", null));
        finish();
        return;
      }
      if ("pay_new_modify_period_general".equals(this.A))
      {
        org.greenrobot.eventbus.c.getDefault().post(new com.ziroom.ziroomcustomer.newServiceList.utils.c("period_general_pay_modify_coupon_info_not_use", null));
        finish();
        return;
      }
    }
    setResult(1111);
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903145);
    this.f = this;
    a();
    b();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/activity/CleanCouponActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */