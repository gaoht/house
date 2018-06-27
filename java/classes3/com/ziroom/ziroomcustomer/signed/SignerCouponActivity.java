package com.ziroom.ziroomcustomer.signed;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
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
import butterknife.OnClick;
import butterknife.Unbinder;
import com.alibaba.fastjson.e;
import com.freelxl.baselibrary.f.d;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.e.n;
import com.ziroom.ziroomcustomer.e.g;
import com.ziroom.ziroomcustomer.e.q;
import com.ziroom.ziroomcustomer.signed.a.o;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.widget.XListView;
import com.ziroom.ziroomcustomer.widget.XListView.a;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SignerCouponActivity
  extends BaseActivity
  implements XListView.a
{
  private Unbinder a;
  private Context b;
  @BindView(2131690255)
  Button btn_exchange_conpon;
  private List<o> c;
  private CouponAdapter d;
  private int e = 1;
  @BindView(2131690254)
  EditText et_fill_coupon;
  private int f = 100;
  private String g;
  @BindView(2131689492)
  ImageView iv_back;
  @BindView(2131690256)
  ImageView iv_coupon_delete;
  private Intent r;
  @BindView(2131690259)
  TextView tv_coupon_point;
  @BindView(2131690260)
  XListView xl_type;
  
  private void a()
  {
    this.iv_back = ((ImageView)findViewById(2131689492));
    this.et_fill_coupon = ((EditText)findViewById(2131690254));
    this.xl_type = ((XListView)findViewById(2131690260));
    this.xl_type.setPullLoadEnable(false);
    this.xl_type.setPullRefreshEnable(false);
    this.tv_coupon_point = ((TextView)findViewById(2131690259));
    this.xl_type.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        if (SignerCouponActivity.a(SignerCouponActivity.this) != null)
        {
          paramAnonymousAdapterView = SignerCouponActivity.a(SignerCouponActivity.this).iterator();
          while (paramAnonymousAdapterView.hasNext()) {
            ((o)paramAnonymousAdapterView.next()).setIsChecked(0);
          }
          ((o)SignerCouponActivity.a(SignerCouponActivity.this).get(paramAnonymousInt - 1)).setIsChecked(1);
          SignerCouponActivity.b(SignerCouponActivity.this).putExtra("couponCode", ((o)SignerCouponActivity.a(SignerCouponActivity.this).get(paramAnonymousInt - 1)).getCode());
          SignerCouponActivity.this.setResult(99, SignerCouponActivity.b(SignerCouponActivity.this));
          SignerCouponActivity.this.finish();
        }
      }
    });
    this.d = new CouponAdapter(this.b, this.c);
    this.xl_type.setAdapter(this.d);
    this.xl_type.setPullLoadEnable(false);
    this.xl_type.setPullRefreshEnable(true);
    this.xl_type.setXListViewListener(this);
    this.btn_exchange_conpon.setClickable(false);
    this.et_fill_coupon.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        if (paramAnonymousCharSequence.length() >= 6)
        {
          SignerCouponActivity.this.btn_exchange_conpon.setBackgroundColor(-44032);
          SignerCouponActivity.this.btn_exchange_conpon.setClickable(true);
          SignerCouponActivity.this.iv_coupon_delete.setVisibility(0);
        }
        if (paramAnonymousCharSequence.length() < 6)
        {
          SignerCouponActivity.this.btn_exchange_conpon.setBackgroundColor(-4473925);
          SignerCouponActivity.this.btn_exchange_conpon.setClickable(false);
          SignerCouponActivity.this.iv_coupon_delete.setVisibility(4);
        }
      }
    });
    a(VdsAgent.trackEditTextSilent(this.et_fill_coupon).toString(), this.e, this.f);
  }
  
  private void a(final String paramString, int paramInt1, int paramInt2)
  {
    String str = q.s + e.n.af;
    Map localMap = g.buildCouponSelect(paramString, paramInt1, paramInt2, this.g);
    d.e("url", str + localMap.toString());
    b();
    com.freelxl.baselibrary.d.a.post(str).params(ah.ConvertObjMap2String(localMap)).tag(this).enqueue(new com.ziroom.commonlibrary.a.a(this.b, new com.freelxl.baselibrary.d.f.c())
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        dismissProgress();
        u.e("LeaseHistoryLivingActivity", paramAnonymousThrowable.getMessage() + "");
      }
      
      public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
      {
        d.e("jsonObject", paramAnonymouse.toJSONString());
        if ("success".equals(paramAnonymouse.get("status"))) {
          if (paramAnonymouse.get("data") != null)
          {
            if (ae.notNull(paramString)) {
              SignerCouponActivity.this.setResult(99, SignerCouponActivity.b(SignerCouponActivity.this));
            }
            SignerCouponActivity.a(SignerCouponActivity.this, com.alibaba.fastjson.a.parseArray(paramAnonymouse.get("data").toString(), o.class));
            SignerCouponActivity.c(SignerCouponActivity.this).setList(SignerCouponActivity.a(SignerCouponActivity.this));
            SignerCouponActivity.c(SignerCouponActivity.this).notifyDataSetChanged();
          }
        }
        for (;;)
        {
          dismissProgress();
          return;
          SignerCouponActivity.this.showToast(paramAnonymouse.get("error_message") + "");
        }
      }
    });
  }
  
  private void b()
  {
    this.xl_type.stopRefresh();
    this.xl_type.stopLoadMore();
    this.xl_type.setRefreshTime("刚刚");
  }
  
  @OnClick({2131689492, 2131690256, 2131690255})
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131689492: 
      finish();
      return;
    case 2131690256: 
      this.et_fill_coupon.setText("");
      return;
    }
    this.e = 1;
    a(VdsAgent.trackEditTextSilent(this.et_fill_coupon).toString(), this.e, this.f);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130905136);
    this.b = this;
    this.a = ButterKnife.bind(this);
    this.g = getIntent().getStringExtra("contractCode");
    this.r = getIntent();
    a();
  }
  
  public void onLoadMore()
  {
    this.tv_coupon_point.setVisibility(8);
    a("", this.e, this.f);
  }
  
  public void onRefresh()
  {
    this.xl_type.setPullLoadEnable(false);
    this.tv_coupon_point.setVisibility(8);
    this.e = 1;
    a("", this.e, this.f);
  }
  
  class CouponAdapter
    extends BaseAdapter
  {
    private Context b;
    private List<o> c;
    
    public CouponAdapter(List<o> paramList)
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
      paramView = (o)this.c.get(paramInt);
      paramViewGroup = LayoutInflater.from(this.b).inflate(2130904528, paramViewGroup, false);
      paramViewGroup.setBackgroundResource(2130837740);
      HolderView localHolderView = new HolderView(paramViewGroup);
      localHolderView.mTvName.setText(paramView.getName());
      localHolderView.mTvTime.setText(paramView.getStart_time() + "至" + paramView.getEnd_time());
      localHolderView.mTvNum.setText(ah.setFloat(Float.parseFloat(paramView.getMoney()) / 100.0F) + "");
      localHolderView.mTvUnit.setText("¥");
      if (paramView.getIsChecked() == 1) {
        localHolderView.tvStatus.setBackgroundResource(2130838724);
      }
      while (!ae.isNull(paramView.getRule()))
      {
        paramView = paramView.getRule().split("\\n");
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
    
    public void setList(List<o> paramList)
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


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/SignerCouponActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */