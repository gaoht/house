package com.ziroom.ziroomcustomer.ziroomapartment.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.e.k;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.af;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.widget.XListView;
import com.ziroom.ziroomcustomer.widget.XListView.a;
import com.ziroom.ziroomcustomer.ziroomapartment.a.c;
import com.ziroom.ziroomcustomer.ziroomapartment.a.e;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuBillDetailModelV2.DataBean.CardCouponsBean;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuCouponListModel;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuExchangeCouponModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ZryuCouponActivity
  extends BaseActivity
  implements View.OnClickListener, XListView.a
{
  private ImageView a;
  private EditText b;
  private Button c;
  private Context d;
  private CouponAdapter e;
  private XListView f;
  private String g;
  private int r = 1;
  private UserInfo s;
  private ImageView t;
  private TextView u;
  private ZryuCouponListModel v;
  private List<ZryuBillDetailModelV2.DataBean.CardCouponsBean> w;
  
  private void a()
  {
    if (ApplicationEx.c.getUser() != null)
    {
      this.s = ApplicationEx.c.getUser();
      this.g = this.s.getUid();
    }
    this.w = getIntent().getParcelableArrayListExtra("couponCards");
    this.e.setList(this.w);
    this.f.setPullLoadEnable(true);
    f();
    if ((this.w != null) && (this.w.size() == 0))
    {
      this.u.setVisibility(0);
      return;
    }
    this.u.setVisibility(8);
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
        if (ZryuCouponActivity.a(ZryuCouponActivity.this) != null)
        {
          paramAnonymousAdapterView = ZryuCouponActivity.a(ZryuCouponActivity.this).iterator();
          while (paramAnonymousAdapterView.hasNext()) {
            ((ZryuBillDetailModelV2.DataBean.CardCouponsBean)paramAnonymousAdapterView.next()).isChecked = 0;
          }
          ((ZryuBillDetailModelV2.DataBean.CardCouponsBean)ZryuCouponActivity.a(ZryuCouponActivity.this).get(paramAnonymousInt - 1)).isChecked = 1;
          paramAnonymousAdapterView = ZryuCouponActivity.this.getIntent();
          paramAnonymousAdapterView.putExtra("couponCards", (ArrayList)ZryuCouponActivity.a(ZryuCouponActivity.this));
          ZryuCouponActivity.this.setResult(0, paramAnonymousAdapterView);
          ZryuCouponActivity.this.finish();
        }
      }
    });
    this.e = new CouponAdapter(this.d, this.w);
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
          ZryuCouponActivity.b(ZryuCouponActivity.this).setBackgroundColor(-44032);
          ZryuCouponActivity.b(ZryuCouponActivity.this).setClickable(true);
          ZryuCouponActivity.c(ZryuCouponActivity.this).setVisibility(0);
        }
        if (paramAnonymousCharSequence.length() == 0)
        {
          ZryuCouponActivity.b(ZryuCouponActivity.this).setBackgroundColor(-4473925);
          ZryuCouponActivity.b(ZryuCouponActivity.this).setClickable(false);
          ZryuCouponActivity.c(ZryuCouponActivity.this).setVisibility(4);
        }
      }
    });
  }
  
  private void e()
  {
    if ((VdsAgent.trackEditTextSilent(this.b).toString() == null) && ("".equals(VdsAgent.trackEditTextSilent(this.b).toString()))) {
      showToast("请输入优惠券号码进行对换");
    }
    Object localObject = VdsAgent.trackEditTextSilent(this.b).toString().trim();
    if (!ah.checkNet(this.d))
    {
      af.showToast(this.d, 2131297483);
      return;
    }
    localObject = c.buildExchangeCoupon(this, this.g, (String)localObject);
    e.exchangeCoupon(this.d, new i.a()
    {
      public void onParse(String paramAnonymousString, k paramAnonymousk) {}
      
      public void onSuccess(k paramAnonymousk)
      {
        paramAnonymousk = (ZryuExchangeCouponModel)paramAnonymousk.getObject();
        if ((paramAnonymousk != null) && ("200".equals(Integer.valueOf(paramAnonymousk.error_code))))
        {
          af.showToast(ZryuCouponActivity.d(ZryuCouponActivity.this), "兑换成功！");
          ZryuCouponActivity.e(ZryuCouponActivity.this);
        }
        while ((paramAnonymousk == null) || (TextUtils.isEmpty(paramAnonymousk.error_message))) {
          return;
        }
        af.showToast(ZryuCouponActivity.d(ZryuCouponActivity.this), paramAnonymousk.error_message);
      }
    }, (Map)localObject, true);
  }
  
  private void f()
  {
    this.f.stopRefresh();
    this.f.stopLoadMore();
    this.f.setRefreshTime("刚刚");
  }
  
  private void g()
  {
    Map localMap = c.buildGetContractList(this, this.g);
    e.getCouponList(this.d, new i.a()
    {
      public void onParse(String paramAnonymousString, k paramAnonymousk) {}
      
      public void onSuccess(k paramAnonymousk)
      {
        ZryuCouponActivity.a(ZryuCouponActivity.this, (ZryuCouponListModel)paramAnonymousk.getObject());
        if ((ZryuCouponActivity.f(ZryuCouponActivity.this) != null) && (200 == ZryuCouponActivity.f(ZryuCouponActivity.this).error_code))
        {
          ZryuCouponActivity.a(ZryuCouponActivity.this, ZryuCouponActivity.f(ZryuCouponActivity.this).data);
          ZryuCouponActivity.g(ZryuCouponActivity.this).setList(ZryuCouponActivity.a(ZryuCouponActivity.this));
          ZryuCouponActivity.h(ZryuCouponActivity.this).setPullLoadEnable(true);
          ZryuCouponActivity.i(ZryuCouponActivity.this);
          if ((ZryuCouponActivity.a(ZryuCouponActivity.this) != null) && (ZryuCouponActivity.a(ZryuCouponActivity.this).size() == 0)) {
            ZryuCouponActivity.j(ZryuCouponActivity.this).setVisibility(0);
          }
        }
        while ((ZryuCouponActivity.f(ZryuCouponActivity.this) == null) || (TextUtils.isEmpty(ZryuCouponActivity.f(ZryuCouponActivity.this).error_message)))
        {
          return;
          ZryuCouponActivity.j(ZryuCouponActivity.this).setVisibility(8);
          return;
        }
        af.showToast(ZryuCouponActivity.d(ZryuCouponActivity.this), ZryuCouponActivity.f(ZryuCouponActivity.this).error_message);
      }
    }, localMap, true);
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
      return;
    case 2131689492: 
      paramView = getIntent();
      paramView.putExtra("couponCards", (ArrayList)this.w);
      setResult(0, paramView);
      finish();
      return;
    }
    this.b.setText("");
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903581);
    this.d = this;
    b();
    a();
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
    super.onResume();
  }
  
  class CouponAdapter
    extends BaseAdapter
  {
    private Context b;
    private List<ZryuBillDetailModelV2.DataBean.CardCouponsBean> c;
    
    public CouponAdapter(List<ZryuBillDetailModelV2.DataBean.CardCouponsBean> paramList)
    {
      this.b = paramList;
      List localList;
      this.c = localList;
    }
    
    public int getCount()
    {
      if (this.c == null) {
        return 0;
      }
      return this.c.size();
    }
    
    public Object getItem(int paramInt)
    {
      return this.c.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      paramView = (ZryuBillDetailModelV2.DataBean.CardCouponsBean)this.c.get(paramInt);
      paramViewGroup = LayoutInflater.from(this.b).inflate(2130904388, paramViewGroup, false);
      paramViewGroup.setBackgroundResource(2130837740);
      HolderView localHolderView = new HolderView(paramViewGroup);
      localHolderView.mTvName.setText(paramView.name);
      localHolderView.mTvTime.setText(paramView.startTime + "至" + paramView.endTime);
      localHolderView.mTvNum.setText(paramView.money + "");
      localHolderView.mTvUnit.setText("¥");
      if (paramView.isChecked == 1) {
        localHolderView.tvStatus.setBackgroundResource(2130838724);
      }
      while (!ae.isNull(paramView.rule))
      {
        paramView = paramView.rule.split("\\n");
        localHolderView.mTvTitle.setText(paramView[0]);
        if (paramView.length > 1)
        {
          localHolderView.mTvSubTitle.setText(paramView[1]);
          return paramViewGroup;
          localHolderView.tvStatus.setBackgroundResource(2130838723);
        }
        else
        {
          localHolderView.mTvSubTitle.setVisibility(4);
          return paramViewGroup;
        }
      }
      localHolderView.mTvSubTitle.setVisibility(4);
      localHolderView.mTvTitle.setVisibility(4);
      return paramViewGroup;
    }
    
    public void setList(List<ZryuBillDetailModelV2.DataBean.CardCouponsBean> paramList)
    {
      this.c = paramList;
      notifyDataSetChanged();
    }
    
    public class HolderView
    {
      @BindView(2131690049)
      TextView mTvName;
      @BindView(2131690003)
      TextView mTvNum;
      @BindView(2131694578)
      TextView mTvSubTitle;
      @BindView(2131689852)
      TextView mTvTime;
      @BindView(2131689541)
      TextView mTvTitle;
      @BindView(2131689840)
      TextView mTvUnit;
      @BindView(2131689822)
      TextView tvStatus;
      
      public HolderView(View paramView)
      {
        ButterKnife.bind(this, paramView);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/activity/ZryuCouponActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */