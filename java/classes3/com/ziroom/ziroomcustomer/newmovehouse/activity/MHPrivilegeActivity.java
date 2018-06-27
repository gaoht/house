package com.ziroom.ziroomcustomer.newmovehouse.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
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
import com.ziroom.ziroomcustomer.newclean.b.s;
import com.ziroom.ziroomcustomer.newclean.d.ak;
import com.ziroom.ziroomcustomer.newclean.d.al;
import com.ziroom.ziroomcustomer.util.w;
import com.ziroom.ziroomcustomer.widget.XListView;
import com.ziroom.ziroomcustomer.widget.XListView.a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MHPrivilegeActivity
  extends BaseActivity
  implements View.OnClickListener, XListView.a
{
  private h A = new h(this, new m(Boolean.class, new com.ziroom.ziroomcustomer.e.c.a.g()))
  {
    public void onFailure(Throwable paramAnonymousThrowable)
    {
      super.onFailure(paramAnonymousThrowable);
      if (((paramAnonymousThrowable instanceof b)) && (((b)paramAnonymousThrowable).getCode() == 1000002))
      {
        paramAnonymousThrowable = VdsAgent.trackEditTextSilent(MHPrivilegeActivity.i(MHPrivilegeActivity.this)).toString().trim();
        o.getNewCoupon(MHPrivilegeActivity.this, MHPrivilegeActivity.j(MHPrivilegeActivity.this), MHPrivilegeActivity.k(MHPrivilegeActivity.this), paramAnonymousThrowable, "1", MHPrivilegeActivity.l(MHPrivilegeActivity.this));
      }
    }
    
    public void onSuccess(int paramAnonymousInt, Boolean paramAnonymousBoolean)
    {
      super.onSuccess(paramAnonymousInt, paramAnonymousBoolean);
      MHPrivilegeActivity.a(MHPrivilegeActivity.this).clear();
      MHPrivilegeActivity.this.getSortCouponList();
    }
  };
  private ImageView a;
  private EditText b;
  private Button c;
  private String d;
  private Context e;
  private List<al> f = new ArrayList();
  private s g;
  private XListView r;
  private String s;
  private int t = 1;
  private UserInfo u;
  private ImageView v;
  private TextView w;
  private RelativeLayout x;
  private String y;
  private String z;
  
  private void a()
  {
    this.z = getIntent().getStringExtra("code_from");
    this.a = ((ImageView)findViewById(2131689492));
    this.b = ((EditText)findViewById(2131690254));
    this.c = ((Button)findViewById(2131690255));
    this.r = ((XListView)findViewById(2131690260));
    this.x = ((RelativeLayout)findViewById(2131690257));
    this.w = ((TextView)findViewById(2131690252));
    if (!TextUtils.isEmpty(this.z)) {
      if (("move_pay".equals(this.z)) || ("move_detail".equals(this.z))) {
        this.w.setText("不更换");
      }
    }
    for (;;)
    {
      this.r.setPullLoadEnable(false);
      this.r.setPullRefreshEnable(false);
      this.r.setXListViewListener(this);
      this.r.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        @Instrumented
        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
          if (MHPrivilegeActivity.a(MHPrivilegeActivity.this) != null)
          {
            if (((al)MHPrivilegeActivity.a(MHPrivilegeActivity.this).get(paramAnonymousInt - 1)).getIsUsable() != 0) {
              break label115;
            }
            if (!TextUtils.isEmpty(((al)MHPrivilegeActivity.a(MHPrivilegeActivity.this).get(paramAnonymousInt - 1)).getDescription())) {
              break label83;
            }
            com.freelxl.baselibrary.f.g.textToast(MHPrivilegeActivity.b(MHPrivilegeActivity.this), "优惠券不可用！");
          }
          label83:
          label115:
          do
          {
            return;
            com.freelxl.baselibrary.f.g.textToast(MHPrivilegeActivity.b(MHPrivilegeActivity.this), ((al)MHPrivilegeActivity.a(MHPrivilegeActivity.this).get(paramAnonymousInt - 1)).getDescription());
            return;
            if (((al)MHPrivilegeActivity.a(MHPrivilegeActivity.this).get(paramAnonymousInt - 1)).getState() != 0) {
              break label407;
            }
            if (TextUtils.isEmpty(MHPrivilegeActivity.c(MHPrivilegeActivity.this))) {
              break;
            }
            if ("move_detail".equals(MHPrivilegeActivity.c(MHPrivilegeActivity.this)))
            {
              paramAnonymousAdapterView = new ak();
              paramAnonymousAdapterView.setCouponCode(((al)MHPrivilegeActivity.a(MHPrivilegeActivity.this).get(paramAnonymousInt - 1)).getPromoCode());
              paramAnonymousAdapterView.setCouponId(((al)MHPrivilegeActivity.a(MHPrivilegeActivity.this).get(paramAnonymousInt - 1)).getPromoId());
              org.greenrobot.eventbus.c.getDefault().post(new com.ziroom.ziroomcustomer.newServiceList.utils.c("move_detail_coupon_use_info", paramAnonymousAdapterView));
              MHPrivilegeActivity.this.finish();
              return;
            }
          } while (!"move_pay".equals(MHPrivilegeActivity.c(MHPrivilegeActivity.this)));
          paramAnonymousAdapterView = new Intent();
          paramAnonymousAdapterView.putExtra("couponCode", ((al)MHPrivilegeActivity.a(MHPrivilegeActivity.this).get(paramAnonymousInt - 1)).getPromoCode());
          paramAnonymousAdapterView.putExtra("couponId", ((al)MHPrivilegeActivity.a(MHPrivilegeActivity.this).get(paramAnonymousInt - 1)).getPromoId());
          MHPrivilegeActivity.this.setResult(-1, paramAnonymousAdapterView);
          MHPrivilegeActivity.this.finish();
          return;
          paramAnonymousAdapterView = new Intent();
          paramAnonymousAdapterView.putExtra("couponItem", (Serializable)MHPrivilegeActivity.a(MHPrivilegeActivity.this).get(paramAnonymousInt - 1));
          MHPrivilegeActivity.this.setResult(-1, paramAnonymousAdapterView);
          MHPrivilegeActivity.this.finish();
          w.onEvent(MHPrivilegeActivity.b(MHPrivilegeActivity.this), "movecoupon_choose");
          return;
          label407:
          if (((al)MHPrivilegeActivity.a(MHPrivilegeActivity.this).get(paramAnonymousInt - 1)).getState() == 1)
          {
            com.freelxl.baselibrary.f.g.textToast(MHPrivilegeActivity.b(MHPrivilegeActivity.this), "优惠券已使用，请重新选择！");
            return;
          }
          if (((al)MHPrivilegeActivity.a(MHPrivilegeActivity.this).get(paramAnonymousInt - 1)).getState() == 2)
          {
            com.freelxl.baselibrary.f.g.textToast(MHPrivilegeActivity.b(MHPrivilegeActivity.this), "优惠券已使用，请重新选择！");
            return;
          }
          com.freelxl.baselibrary.f.g.textToast(MHPrivilegeActivity.b(MHPrivilegeActivity.this), "优惠券已使用，请重新选择！");
        }
      });
      this.r.setEmptyView(this.x);
      this.v = ((ImageView)findViewById(2131690256));
      this.v.setOnClickListener(this);
      this.c.setOnClickListener(this);
      this.a.setOnClickListener(this);
      this.w.setOnClickListener(this);
      this.b.addTextChangedListener(new TextWatcher()
      {
        public void afterTextChanged(Editable paramAnonymousEditable) {}
        
        public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          if (paramAnonymousCharSequence.length() > 0)
          {
            MHPrivilegeActivity.d(MHPrivilegeActivity.this).setBackgroundColor(Color.parseColor("#ff8a00"));
            MHPrivilegeActivity.e(MHPrivilegeActivity.this).setVisibility(0);
          }
          if (paramAnonymousCharSequence.length() == 0)
          {
            MHPrivilegeActivity.d(MHPrivilegeActivity.this).setBackgroundColor(-4473925);
            MHPrivilegeActivity.e(MHPrivilegeActivity.this).setVisibility(4);
          }
        }
      });
      return;
      this.w.setText("不使用");
    }
  }
  
  private void b()
  {
    this.d = getIntent().getStringExtra("serviceInfoId");
    this.y = getIntent().getStringExtra("startTime");
    if (ApplicationEx.c.getUser() != null)
    {
      this.u = ApplicationEx.c.getUser();
      this.s = this.u.getUid();
      getSortCouponList();
    }
  }
  
  private void e()
  {
    if ((VdsAgent.trackEditTextSilent(this.b).toString() == null) && ("".equals(VdsAgent.trackEditTextSilent(this.b).toString()))) {
      com.freelxl.baselibrary.f.g.textToast(this.e, "请输入优惠券号码进行兑换");
    }
    String str = VdsAgent.trackEditTextSilent(this.b).toString().trim();
    o.getNewCoupon(this.e, this.d, this.s, str, "0", this.A);
  }
  
  public void getSortCouponList()
  {
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if (localUserInfo != null) {
      n.getSortCouponList(this.e, 1, "", this.d, this.d, this.y, localUserInfo.getUid(), Integer.valueOf(0), new com.freelxl.baselibrary.d.c.a(new l(al.class, new com.ziroom.ziroomcustomer.e.c.a.a()))
      {
        public void onFailure(Throwable paramAnonymousThrowable) {}
        
        public void onSuccess(int paramAnonymousInt, List<al> paramAnonymousList)
        {
          if ((paramAnonymousList != null) && (paramAnonymousList.size() > 0))
          {
            MHPrivilegeActivity.a(MHPrivilegeActivity.this, paramAnonymousList);
            MHPrivilegeActivity.a(MHPrivilegeActivity.this, new s(MHPrivilegeActivity.b(MHPrivilegeActivity.this), MHPrivilegeActivity.a(MHPrivilegeActivity.this)));
            MHPrivilegeActivity.g(MHPrivilegeActivity.this).setAdapter(MHPrivilegeActivity.f(MHPrivilegeActivity.this));
            return;
          }
          if (MHPrivilegeActivity.a(MHPrivilegeActivity.this).size() == 0)
          {
            MHPrivilegeActivity.h(MHPrivilegeActivity.this).setVisibility(0);
            return;
          }
          MHPrivilegeActivity.h(MHPrivilegeActivity.this).setVisibility(8);
        }
      });
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
      w.onEvent(this.e, "movecoupon_change");
      return;
    case 2131689492: 
      finish();
      w.onEvent(this.e, "movegoods_return");
      return;
    case 2131690256: 
      this.b.setText("");
      w.onEvent(this.e, "movecoupon_del");
      return;
    }
    if ((!TextUtils.isEmpty(this.z)) && ("move_detail".equals(this.z)))
    {
      org.greenrobot.eventbus.c.getDefault().post(new com.ziroom.ziroomcustomer.newServiceList.utils.c("move_detail_coupon_not_use", null));
      finish();
      return;
    }
    setResult(1111);
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903142);
    this.e = this;
    a();
    b();
  }
  
  protected void onDestroy()
  {
    this.q.removeCallbacksAndMessages(null);
    super.onDestroy();
  }
  
  public void onLoadMore() {}
  
  public void onRefresh() {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/activity/MHPrivilegeActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */