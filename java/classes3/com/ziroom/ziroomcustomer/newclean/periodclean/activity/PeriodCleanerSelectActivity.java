package com.ziroom.ziroomcustomer.newclean.periodclean.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.b;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.newServiceList.activity.ServiceLoginActivity;
import com.ziroom.ziroomcustomer.newServiceList.activity.ZiroomOrderListActivity;
import com.ziroom.ziroomcustomer.newServiceList.utils.j;
import com.ziroom.ziroomcustomer.newclean.activity.CleanAddressActivity;
import com.ziroom.ziroomcustomer.newclean.activity.CleanerActivity;
import com.ziroom.ziroomcustomer.newclean.activity.ModifyNewAddressActivity;
import com.ziroom.ziroomcustomer.newclean.cardpay.MyGridView;
import com.ziroom.ziroomcustomer.newclean.periodclean.bean.CleanerBean;
import com.ziroom.ziroomcustomer.newclean.periodclean.bean.FrequencyBean;
import com.ziroom.ziroomcustomer.newclean.periodclean.bean.SuggestAddressBean;
import com.ziroom.ziroomcustomer.newclean.periodclean.bean.ValidateBean;
import com.ziroom.ziroomcustomer.util.ad;
import com.ziroom.ziroomcustomer.util.n;
import com.ziroom.ziroomcustomer.widget.MyCleanListView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PeriodCleanerSelectActivity
  extends BaseActivity
{
  private com.ziroom.ziroomcustomer.newclean.periodclean.a.d a;
  private com.ziroom.ziroomcustomer.newclean.periodclean.a.d b;
  @BindView(2131690043)
  Button btn;
  private com.ziroom.ziroomcustomer.newclean.d.c c;
  private SuggestAddressBean d;
  private FrequencyBean e = null;
  private com.ziroom.ziroomcustomer.newclean.periodclean.a.c f;
  private List<FrequencyBean> g = new ArrayList();
  @BindView(2131692079)
  MyGridView gv_period;
  @BindView(2131689492)
  ImageView ivBack;
  @BindView(2131692082)
  MyCleanListView listviewServiceHistory;
  @BindView(2131692087)
  MyCleanListView listviewServiceMore;
  @BindView(2131692077)
  LinearLayout llAddressSelect;
  @BindView(2131692075)
  LinearLayout llNoPlace;
  @BindView(2131692080)
  LinearLayout ll_service_history;
  @BindView(2131692085)
  LinearLayout ll_service_more;
  @BindView(2131689808)
  RelativeLayout rlTitle;
  @BindView(2131689506)
  ScrollView scrollview;
  @BindView(2131692076)
  TextView tvAddAddress;
  @BindView(2131692078)
  TextView tvAddressSelect;
  @BindView(2131692088)
  TextView tvServiceMessage;
  @BindView(2131692086)
  TextView tvServiceMore;
  @BindView(2131689541)
  TextView tvTitle;
  @BindView(2131692081)
  TextView tv_service_history;
  @BindView(2131689774)
  View v1;
  @BindView(2131689780)
  View v2;
  @BindView(2131692083)
  View v3;
  @BindView(2131692084)
  View view_history_add;
  
  public static void StartPeriodCleanActivity(final Activity paramActivity)
  {
    if (!ApplicationEx.c.isLoginState())
    {
      paramActivity.startActivity(new Intent(paramActivity, ServiceLoginActivity.class));
      com.freelxl.baselibrary.f.g.textToast(paramActivity, "请先登录");
      return;
    }
    com.ziroom.ziroomcustomer.newclean.periodclean.a.getValidateCustomerPermission(paramActivity, new com.ziroom.ziroomcustomer.e.a.d(paramActivity, new com.ziroom.ziroomcustomer.e.c.f(ValidateBean.class))
    {
      public void onSuccess(int paramAnonymousInt, ValidateBean paramAnonymousValidateBean)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousValidateBean);
        if ("0".equals(paramAnonymousValidateBean.getValidState())) {
          paramActivity.startActivity(new Intent(paramActivity, PeriodCleanerSelectActivity.class));
        }
        do
        {
          return;
          if ("1".equals(paramAnonymousValidateBean.getValidState()))
          {
            com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(paramActivity).setTitle("提示").setBtnConfirmText("去支付").setBtnCancelText("我知道了").setContent(paramAnonymousValidateBean.getMessage()).setOnConfirmClickListener(new c.b()
            {
              public void onClick(View paramAnonymous2View, boolean paramAnonymous2Boolean)
              {
                if (paramAnonymous2Boolean)
                {
                  paramAnonymous2View = new Intent(PeriodCleanerSelectActivity.1.this.c, ZiroomOrderListActivity.class);
                  paramAnonymous2View.putExtra("order_status_type", "onlyPay");
                  PeriodCleanerSelectActivity.1.this.c.startActivity(paramAnonymous2View);
                }
              }
            }).build().show();
            return;
          }
        } while (!"2".equals(paramAnonymousValidateBean.getValidState()));
        com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(paramActivity).setTitle("提示").setBtnConfirmText("联系客服").setBtnCancelText("我知道了").setContent(paramAnonymousValidateBean.getMessage()).setOnConfirmClickListener(new c.b()
        {
          public void onClick(View paramAnonymous2View, boolean paramAnonymous2Boolean)
          {
            if (paramAnonymous2Boolean) {
              j.toChat((BaseActivity)PeriodCleanerSelectActivity.1.this.c);
            }
          }
        }).build().show();
      }
    });
  }
  
  private void a()
  {
    this.a = new com.ziroom.ziroomcustomer.newclean.periodclean.a.d(this, null, this.c);
    this.listviewServiceMore.setAdapter(this.a);
    this.listviewServiceMore.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        paramAnonymousAdapterView = new Intent(PeriodCleanerSelectActivity.this, CleanerActivity.class);
        paramAnonymousAdapterView.putExtra("cleanerId", ((CleanerBean)PeriodCleanerSelectActivity.a(PeriodCleanerSelectActivity.this).getItem(paramAnonymousInt)).getCleanerId());
        paramAnonymousAdapterView.putExtra("cleanerBean", (Serializable)PeriodCleanerSelectActivity.a(PeriodCleanerSelectActivity.this).getItem(paramAnonymousInt));
        paramAnonymousAdapterView.putExtra("selectFreqBean", PeriodCleanerSelectActivity.b(PeriodCleanerSelectActivity.this));
        paramAnonymousAdapterView.putExtra("address", PeriodCleanerSelectActivity.c(PeriodCleanerSelectActivity.this));
        paramAnonymousAdapterView.putExtra("addressId", PeriodCleanerSelectActivity.c(PeriodCleanerSelectActivity.this).getFid());
        PeriodCleanerSelectActivity.this.startActivityForResult(paramAnonymousAdapterView, 32);
      }
    });
    this.b = new com.ziroom.ziroomcustomer.newclean.periodclean.a.d(this, null, this.c);
    this.listviewServiceHistory.setAdapter(this.b);
    this.listviewServiceHistory.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        paramAnonymousAdapterView = new Intent(PeriodCleanerSelectActivity.this, CleanerActivity.class);
        paramAnonymousAdapterView.putExtra("cleanerId", ((CleanerBean)PeriodCleanerSelectActivity.d(PeriodCleanerSelectActivity.this).getItem(paramAnonymousInt)).getCleanerId());
        paramAnonymousAdapterView.putExtra("cleanerBean", (Serializable)PeriodCleanerSelectActivity.d(PeriodCleanerSelectActivity.this).getItem(paramAnonymousInt));
        paramAnonymousAdapterView.putExtra("selectFreqBean", PeriodCleanerSelectActivity.b(PeriodCleanerSelectActivity.this));
        paramAnonymousAdapterView.putExtra("address", PeriodCleanerSelectActivity.c(PeriodCleanerSelectActivity.this));
        paramAnonymousAdapterView.putExtra("addressId", PeriodCleanerSelectActivity.c(PeriodCleanerSelectActivity.this).getFid());
        PeriodCleanerSelectActivity.this.startActivityForResult(paramAnonymousAdapterView, 32);
      }
    });
    this.f = new com.ziroom.ziroomcustomer.newclean.periodclean.a.c(this, this.g);
    this.gv_period.setVerticalSpacing(n.dip2px(this, 16.0F));
    this.gv_period.setAdapter(this.f);
    this.gv_period.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        PeriodCleanerSelectActivity.this.ll_service_history.setVisibility(0);
        PeriodCleanerSelectActivity.a(PeriodCleanerSelectActivity.this, (FrequencyBean)PeriodCleanerSelectActivity.e(PeriodCleanerSelectActivity.this).get(paramAnonymousInt));
        ad.savePeriodCleanFrequency(PeriodCleanerSelectActivity.this, PeriodCleanerSelectActivity.b(PeriodCleanerSelectActivity.this));
        PeriodCleanerSelectActivity.a(PeriodCleanerSelectActivity.this).setFreqBean(PeriodCleanerSelectActivity.b(PeriodCleanerSelectActivity.this));
        PeriodCleanerSelectActivity.d(PeriodCleanerSelectActivity.this).setFreqBean(PeriodCleanerSelectActivity.b(PeriodCleanerSelectActivity.this));
        PeriodCleanerSelectActivity.f(PeriodCleanerSelectActivity.this).setSelectPosition(paramAnonymousInt);
      }
    });
    this.scrollview.smoothScrollTo(0, 0);
    b();
    e();
  }
  
  private void b()
  {
    com.ziroom.ziroomcustomer.newclean.periodclean.a.getPeriodCleanSuggestAddress(this, new com.ziroom.ziroomcustomer.e.a.d(this, new com.ziroom.ziroomcustomer.e.c.f(SuggestAddressBean.class))
    {
      public void onSuccess(int paramAnonymousInt, SuggestAddressBean paramAnonymousSuggestAddressBean)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousSuggestAddressBean);
        if (paramAnonymousSuggestAddressBean == null)
        {
          PeriodCleanerSelectActivity.this.llNoPlace.setVisibility(0);
          PeriodCleanerSelectActivity.this.scrollview.setVisibility(8);
          PeriodCleanerSelectActivity.this.btn.setVisibility(8);
          return;
        }
        PeriodCleanerSelectActivity.this.llNoPlace.setVisibility(8);
        PeriodCleanerSelectActivity.this.scrollview.setVisibility(0);
        PeriodCleanerSelectActivity.this.btn.setVisibility(0);
        PeriodCleanerSelectActivity.this.tvAddressSelect.setText(paramAnonymousSuggestAddressBean.getVillage() + paramAnonymousSuggestAddressBean.getDoorplate());
        PeriodCleanerSelectActivity.a(PeriodCleanerSelectActivity.this, paramAnonymousSuggestAddressBean);
        PeriodCleanerSelectActivity.a(PeriodCleanerSelectActivity.this, PeriodCleanerSelectActivity.g(PeriodCleanerSelectActivity.this).getAddressId());
        PeriodCleanerSelectActivity.b(PeriodCleanerSelectActivity.this, PeriodCleanerSelectActivity.g(PeriodCleanerSelectActivity.this).getAddressId());
        PeriodCleanerSelectActivity.a(PeriodCleanerSelectActivity.this, new com.ziroom.ziroomcustomer.newclean.d.c());
        PeriodCleanerSelectActivity.c(PeriodCleanerSelectActivity.this).setDetAddress(PeriodCleanerSelectActivity.g(PeriodCleanerSelectActivity.this).getDoorplate());
        PeriodCleanerSelectActivity.c(PeriodCleanerSelectActivity.this).setVillage(PeriodCleanerSelectActivity.g(PeriodCleanerSelectActivity.this).getVillage());
        PeriodCleanerSelectActivity.c(PeriodCleanerSelectActivity.this).setFid(PeriodCleanerSelectActivity.g(PeriodCleanerSelectActivity.this).getAddressId());
        PeriodCleanerSelectActivity.c(PeriodCleanerSelectActivity.this).setLinkPhone(PeriodCleanerSelectActivity.g(PeriodCleanerSelectActivity.this).getConnectPhone());
        PeriodCleanerSelectActivity.c(PeriodCleanerSelectActivity.this).setLatitude(PeriodCleanerSelectActivity.g(PeriodCleanerSelectActivity.this).getAddressLat());
        PeriodCleanerSelectActivity.c(PeriodCleanerSelectActivity.this).setLongitude(PeriodCleanerSelectActivity.g(PeriodCleanerSelectActivity.this).getAddressLon());
        PeriodCleanerSelectActivity.a(PeriodCleanerSelectActivity.this).setmAddress(PeriodCleanerSelectActivity.c(PeriodCleanerSelectActivity.this));
        PeriodCleanerSelectActivity.d(PeriodCleanerSelectActivity.this).setmAddress(PeriodCleanerSelectActivity.c(PeriodCleanerSelectActivity.this));
      }
    });
  }
  
  private void d(String paramString)
  {
    com.ziroom.ziroomcustomer.newclean.periodclean.a.getCleanerByAddress(this, paramString, new com.ziroom.ziroomcustomer.e.a.d(this, new com.ziroom.ziroomcustomer.e.c.g())
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        PeriodCleanerSelectActivity.a(PeriodCleanerSelectActivity.this).setDatas(null);
        PeriodCleanerSelectActivity.a(PeriodCleanerSelectActivity.this).notifyDataSetChanged();
        PeriodCleanerSelectActivity.this.btn.setEnabled(false);
        PeriodCleanerSelectActivity.this.tvServiceMessage.setVisibility(8);
      }
      
      public void onSuccess(int paramAnonymousInt, Object paramAnonymousObject)
      {
        Object localObject = null;
        super.onSuccess(paramAnonymousInt, paramAnonymousObject);
        PeriodCleanerSelectActivity.this.tvServiceMessage.setVisibility(8);
        PeriodCleanerSelectActivity.this.ll_service_more.setVisibility(0);
        paramAnonymousObject = com.alibaba.fastjson.a.parseObject(com.alibaba.fastjson.e.toJSONString(paramAnonymousObject));
        String str1 = ((com.alibaba.fastjson.e)paramAnonymousObject).getString("message");
        String str2 = ((com.alibaba.fastjson.e)paramAnonymousObject).getString("data");
        if (!"200".equals(((com.alibaba.fastjson.e)paramAnonymousObject).getString("code")))
        {
          com.freelxl.baselibrary.f.g.textToast(PeriodCleanerSelectActivity.this, str1);
          PeriodCleanerSelectActivity.a(PeriodCleanerSelectActivity.this).setDatas(null);
          PeriodCleanerSelectActivity.a(PeriodCleanerSelectActivity.this).notifyDataSetChanged();
          PeriodCleanerSelectActivity.this.btn.setEnabled(false);
          return;
        }
        if (com.freelxl.baselibrary.f.f.isNull(str2))
        {
          PeriodCleanerSelectActivity.this.v1.setVisibility(4);
          PeriodCleanerSelectActivity.this.tvServiceMore.setVisibility(4);
          PeriodCleanerSelectActivity.this.tvServiceMessage.setVisibility(0);
          PeriodCleanerSelectActivity.this.ll_service_more.setVisibility(8);
        }
        for (paramAnonymousObject = localObject;; paramAnonymousObject = com.alibaba.fastjson.a.parseArray(str2, CleanerBean.class))
        {
          PeriodCleanerSelectActivity.this.btn.setEnabled(true);
          PeriodCleanerSelectActivity.a(PeriodCleanerSelectActivity.this).setDatas((List)paramAnonymousObject);
          PeriodCleanerSelectActivity.a(PeriodCleanerSelectActivity.this).notifyDataSetChanged();
          return;
          PeriodCleanerSelectActivity.this.v1.setVisibility(0);
          PeriodCleanerSelectActivity.this.tvServiceMore.setVisibility(0);
        }
      }
    });
  }
  
  private void e()
  {
    com.ziroom.ziroomcustomer.newclean.periodclean.a.getFrequencyConfigs(this, new com.ziroom.ziroomcustomer.e.a.d(this, new com.ziroom.ziroomcustomer.e.c.e(FrequencyBean.class))
    {
      public void onSuccess(int paramAnonymousInt, List<FrequencyBean> paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        if (paramAnonymousList != null)
        {
          PeriodCleanerSelectActivity.a(PeriodCleanerSelectActivity.this, paramAnonymousList);
          PeriodCleanerSelectActivity.f(PeriodCleanerSelectActivity.this).setData(paramAnonymousList);
          PeriodCleanerSelectActivity.a(PeriodCleanerSelectActivity.this, ad.getPeriodCleanFrequency(PeriodCleanerSelectActivity.this));
          if ((PeriodCleanerSelectActivity.b(PeriodCleanerSelectActivity.this) != null) && (PeriodCleanerSelectActivity.e(PeriodCleanerSelectActivity.this) != null) && (PeriodCleanerSelectActivity.e(PeriodCleanerSelectActivity.this).size() > 0))
          {
            paramAnonymousInt = 0;
            while (paramAnonymousInt < PeriodCleanerSelectActivity.e(PeriodCleanerSelectActivity.this).size())
            {
              if (PeriodCleanerSelectActivity.b(PeriodCleanerSelectActivity.this).getName().equals(((FrequencyBean)PeriodCleanerSelectActivity.e(PeriodCleanerSelectActivity.this).get(paramAnonymousInt)).getName()))
              {
                PeriodCleanerSelectActivity.this.ll_service_more.setVisibility(0);
                PeriodCleanerSelectActivity.this.ll_service_history.setVisibility(0);
                PeriodCleanerSelectActivity.a(PeriodCleanerSelectActivity.this).setFreqBean(PeriodCleanerSelectActivity.b(PeriodCleanerSelectActivity.this));
                PeriodCleanerSelectActivity.d(PeriodCleanerSelectActivity.this).setFreqBean(PeriodCleanerSelectActivity.b(PeriodCleanerSelectActivity.this));
                PeriodCleanerSelectActivity.f(PeriodCleanerSelectActivity.this).setSelectPosition(paramAnonymousInt);
              }
              paramAnonymousInt += 1;
            }
          }
        }
      }
    });
  }
  
  private void e(String paramString)
  {
    com.ziroom.ziroomcustomer.newclean.periodclean.a.getPeriodHistoryCleaner(this, paramString, new com.ziroom.ziroomcustomer.e.a.d(this, new com.ziroom.ziroomcustomer.e.c.g())
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        PeriodCleanerSelectActivity.d(PeriodCleanerSelectActivity.this).setDatas(null);
        PeriodCleanerSelectActivity.d(PeriodCleanerSelectActivity.this).notifyDataSetChanged();
      }
      
      public void onSuccess(int paramAnonymousInt, Object paramAnonymousObject)
      {
        Object localObject = null;
        super.onSuccess(paramAnonymousInt, paramAnonymousObject);
        if (paramAnonymousObject == null) {
          return;
        }
        paramAnonymousObject = com.alibaba.fastjson.a.parseObject(com.alibaba.fastjson.e.toJSONString(paramAnonymousObject));
        ((com.alibaba.fastjson.e)paramAnonymousObject).getString("message");
        String str = ((com.alibaba.fastjson.e)paramAnonymousObject).getString("data");
        if (!"200".equals(((com.alibaba.fastjson.e)paramAnonymousObject).getString("code")))
        {
          PeriodCleanerSelectActivity.this.tv_service_history.setVisibility(8);
          PeriodCleanerSelectActivity.this.v2.setVisibility(8);
          PeriodCleanerSelectActivity.this.view_history_add.setVisibility(8);
          PeriodCleanerSelectActivity.this.v3.setVisibility(8);
          PeriodCleanerSelectActivity.d(PeriodCleanerSelectActivity.this).setDatas(null);
          PeriodCleanerSelectActivity.d(PeriodCleanerSelectActivity.this).notifyDataSetChanged();
          return;
        }
        if (com.freelxl.baselibrary.f.f.isNull(str))
        {
          PeriodCleanerSelectActivity.this.tv_service_history.setVisibility(8);
          PeriodCleanerSelectActivity.this.v2.setVisibility(8);
          PeriodCleanerSelectActivity.this.view_history_add.setVisibility(8);
          PeriodCleanerSelectActivity.this.v3.setVisibility(8);
        }
        for (paramAnonymousObject = localObject;; paramAnonymousObject = com.alibaba.fastjson.a.parseArray(str, CleanerBean.class))
        {
          PeriodCleanerSelectActivity.d(PeriodCleanerSelectActivity.this).setDatas((List)paramAnonymousObject);
          PeriodCleanerSelectActivity.d(PeriodCleanerSelectActivity.this).notifyDataSetChanged();
          return;
          PeriodCleanerSelectActivity.this.tv_service_history.setVisibility(0);
          PeriodCleanerSelectActivity.this.v2.setVisibility(0);
          PeriodCleanerSelectActivity.this.view_history_add.setVisibility(0);
          PeriodCleanerSelectActivity.this.v3.setVisibility(0);
        }
      }
    });
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (paramInt2 != -1);
        b();
        return;
      } while ((paramInt2 != -1) || (paramIntent == null));
      this.c = ((com.ziroom.ziroomcustomer.newclean.d.c)paramIntent.getSerializableExtra("addressList"));
      if (this.c != null)
      {
        this.a.setmAddress(this.c);
        this.llNoPlace.setVisibility(8);
        this.scrollview.setVisibility(0);
        this.btn.setVisibility(0);
        this.tvAddressSelect.setText(this.c.getVillage() + this.c.getDetAddress());
        d(this.c.getFid());
        e(this.c.getFid());
        return;
      }
      b();
      return;
    } while (paramIntent == null);
    this.c = ((com.ziroom.ziroomcustomer.newclean.d.c)paramIntent.getSerializableExtra("addressList"));
    if (this.c != null)
    {
      this.a.setmAddress(this.c);
      this.llNoPlace.setVisibility(8);
      this.scrollview.setVisibility(0);
      this.btn.setVisibility(0);
      this.tvAddressSelect.setText(this.c.getVillage() + this.c.getDetAddress());
      d(this.c.getFid());
      return;
    }
    b();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903425);
    ButterKnife.bind(this);
    a();
  }
  
  protected void onRestart()
  {
    super.onRestart();
    this.e = ad.getPeriodCleanFrequency(this);
    if ((this.e != null) && (this.g != null) && (this.g.size() > 0))
    {
      int i = 0;
      while (i < this.g.size())
      {
        if (this.e.getName().equals(((FrequencyBean)this.g.get(i)).getName()))
        {
          this.a.setFreqBean(this.e);
          this.b.setFreqBean(this.e);
          this.f.setSelectPosition(i);
        }
        i += 1;
      }
    }
  }
  
  @OnClick({2131689492, 2131692076, 2131692077, 2131690043})
  public void onViewClicked(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131689492: 
      finish();
      return;
    case 2131692076: 
      startActivityForResult(new Intent(this, ModifyNewAddressActivity.class), 16);
      return;
    case 2131692077: 
      Intent localIntent = new Intent(this, CleanAddressActivity.class);
      if (this.d == null) {}
      for (paramView = "00";; paramView = this.d.getAddressId())
      {
        localIntent.putExtra("isOnly", paramView);
        localIntent.putExtra("isFromGeneral", false);
        startActivityForResult(localIntent, 17);
        return;
      }
    }
    if (this.e == null)
    {
      com.freelxl.baselibrary.f.g.textToast(this, "请先选择保洁频次");
      return;
    }
    paramView = new Intent(this, PeriodCleanMainActivity.class);
    paramView.putExtra("address", this.c);
    paramView.putExtra("selectFreqBean", this.e);
    startActivity(paramView);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/periodclean/activity/PeriodCleanerSelectActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */