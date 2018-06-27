package com.ziroom.ziroomcustomer.minsu.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.freelxl.baselibrary.e.i.a;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuCouponListBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuCouponListBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuCouponListBean.DataBean.ListBean;
import com.ziroom.ziroomcustomer.minsu.f.ad;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.widget.XListView;
import com.ziroom.ziroomcustomer.widget.XListView.a;
import java.util.ArrayList;
import java.util.List;

public class MinsuCouponListActivity
  extends BaseActivity
{
  private XListView a;
  private com.ziroom.ziroomcustomer.minsu.a.a b;
  private final int c = 10;
  private int d = 1;
  private List<MinsuCouponListBean.DataBean.ListBean> e = new ArrayList();
  private TextView f;
  private TextView g;
  private String r;
  
  private void a()
  {
    CommonTitle localCommonTitle = (CommonTitle)findViewById(2131691272);
    localCommonTitle.setLeftButtonType(4);
    localCommonTitle.setBottomLineVisible(false);
    localCommonTitle.setOnLeftButtonClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MinsuCouponListActivity.this.setResult(0);
        MinsuCouponListActivity.this.finish();
      }
    });
  }
  
  private void a(MinsuCouponListBean.DataBean.ListBean paramListBean)
  {
    this.b.notifyDataSetChanged();
    int i = -1;
    Bundle localBundle = new Bundle();
    if (this.r.equals(paramListBean.cardId)) {
      i = 102;
    }
    for (;;)
    {
      setResult(i, getIntent().putExtras(localBundle));
      finish();
      return;
      String str = paramListBean.cardId;
      paramListBean = "-" + paramListBean.price + paramListBean.unitDes;
      localBundle.putString("coupon", str);
      localBundle.putString("couponinfo", paramListBean);
    }
  }
  
  private void b()
  {
    this.a = ((XListView)findViewById(2131691217));
    this.f = ((TextView)findViewById(2131691277));
    this.g = ((TextView)findViewById(2131690164));
    this.g.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        com.ziroom.ziroomcustomer.minsu.f.k.toMinsuCouponActivity(MinsuCouponListActivity.this, MinsuCouponListActivity.this.getIntent());
      }
    });
    this.a.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        paramAnonymousAdapterView = (MinsuCouponListBean.DataBean.ListBean)MinsuCouponListActivity.a(MinsuCouponListActivity.this).getDatas().get(paramAnonymousInt - 1);
        MinsuCouponListActivity.a(MinsuCouponListActivity.this, paramAnonymousAdapterView);
      }
    });
    this.a.setPullLoadEnable(false);
    this.a.setPullRefreshEnable(false);
    this.a.setXListViewListener(new XListView.a()
    {
      public void onLoadMore()
      {
        MinsuCouponListActivity.b(MinsuCouponListActivity.this);
        MinsuCouponListActivity.this.getCouponList();
      }
      
      public void onRefresh() {}
    });
    this.b = new com.ziroom.ziroomcustomer.minsu.a.a(this, this.e, 2130904295)
    {
      public void convert(com.freelxl.baselibrary.a.b paramAnonymousb, MinsuCouponListBean.DataBean.ListBean paramAnonymousListBean)
      {
        int j = 8;
        paramAnonymousb.setText(2131690003, paramAnonymousListBean.unit + paramAnonymousListBean.price);
        paramAnonymousb.setText(2131690049, paramAnonymousListBean.cardName);
        paramAnonymousb.setText(2131689541, paramAnonymousListBean.title);
        paramAnonymousb.setText(2131694578, paramAnonymousListBean.subtitle);
        paramAnonymousb.setText(2131689852, paramAnonymousListBean.startDate + "至" + paramAnonymousListBean.endDate);
        if (ae.isNull(paramAnonymousListBean.title))
        {
          i = 8;
          paramAnonymousb.setVisibility(2131689541, i);
          if (!ae.isNull(paramAnonymousListBean.subtitle)) {
            break label233;
          }
        }
        label233:
        for (int i = j;; i = 0)
        {
          paramAnonymousb.setVisibility(2131694578, i);
          paramAnonymousb.setChecked(2131695229, paramAnonymousListBean.cardId.equals(MinsuCouponListActivity.c(MinsuCouponListActivity.this)));
          paramAnonymousb.setTag(2131695229, paramAnonymousListBean);
          i = com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.b.getScreenWidth(ApplicationEx.c);
          paramAnonymousListBean = new RelativeLayout.LayoutParams(1, -1);
          paramAnonymousListBean.setMargins(i / 3, 0, 0, 0);
          paramAnonymousb.getView(2131695228).setLayoutParams(paramAnonymousListBean);
          paramAnonymousb.setOnClickListener(2131695229, new View.OnClickListener()
          {
            @Instrumented
            public void onClick(View paramAnonymous2View)
            {
              VdsAgent.onClick(this, paramAnonymous2View);
              paramAnonymous2View = (MinsuCouponListBean.DataBean.ListBean)paramAnonymous2View.getTag();
              MinsuCouponListActivity.a(MinsuCouponListActivity.this, paramAnonymous2View);
            }
          });
          return;
          i = 0;
          break;
        }
      }
    };
    this.a.setAdapter(this.b);
  }
  
  private void e()
  {
    getCouponList();
  }
  
  public void finish()
  {
    super.finish();
    com.ziroom.ziroomcustomer.minsu.f.k.animFinishAlpha(this);
  }
  
  public void getCouponList()
  {
    try
    {
      String str1 = getIntent().getStringExtra("fid");
      int i = getIntent().getIntExtra("rentWay", 0);
      String str2 = getIntent().getStringExtra("startTime");
      String str3 = getIntent().getStringExtra("endTime");
      com.ziroom.ziroomcustomer.minsu.e.a.couponList(this, this.d, 10, str1, i + "", str2, str3, new i.a()
      {
        public void onParse(String paramAnonymousString, com.freelxl.baselibrary.e.k paramAnonymousk) {}
        
        public void onSuccess(com.freelxl.baselibrary.e.k paramAnonymousk)
        {
          MinsuCouponListBean localMinsuCouponListBean = (MinsuCouponListBean)paramAnonymousk.getObject();
          if ((paramAnonymousk.getSuccess().booleanValue()) && (localMinsuCouponListBean != null) && (localMinsuCouponListBean.checkSuccess(MinsuCouponListActivity.this)))
          {
            if (localMinsuCouponListBean.data.total < 1)
            {
              MinsuCouponListActivity.this.showToast("没有更多数据");
              return;
            }
            MinsuCouponListActivity.a(MinsuCouponListActivity.this).addDatas(localMinsuCouponListBean.data.list);
            if (MinsuCouponListActivity.a(MinsuCouponListActivity.this).getDatas().size() < 1)
            {
              MinsuCouponListActivity.d(MinsuCouponListActivity.this).setVisibility(0);
              MinsuCouponListActivity.e(MinsuCouponListActivity.this).setVisibility(8);
            }
            for (;;)
            {
              MinsuCouponListActivity.a(MinsuCouponListActivity.this).notifyDataSetChanged();
              return;
              MinsuCouponListActivity.d(MinsuCouponListActivity.this).setVisibility(8);
              MinsuCouponListActivity.e(MinsuCouponListActivity.this).setVisibility(0);
            }
          }
          if (localMinsuCouponListBean == null) {}
          for (paramAnonymousk = null;; paramAnonymousk = localMinsuCouponListBean.message)
          {
            ad.shouErrorMessage(paramAnonymousk);
            return;
          }
        }
      });
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903267);
    this.r = getIntent().getStringExtra("couponId");
    a();
    b();
  }
  
  protected void onResume()
  {
    super.onResume();
    if ((this.b != null) && (!this.b.getDatas().isEmpty()))
    {
      this.b.getDatas().clear();
      this.b.notifyDataSetInvalidated();
    }
    e();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/activity/MinsuCouponListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */