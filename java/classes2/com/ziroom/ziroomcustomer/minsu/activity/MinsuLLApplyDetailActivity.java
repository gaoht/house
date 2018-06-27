package com.ziroom.ziroomcustomer.minsu.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.freelxl.baselibrary.a.b;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.e;
import com.ziroom.commonlibrary.widget.unifiedziroom.e.a;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuLLGetNeedPayBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuLLGetNeedPayBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuLLGetNeedPayBean.DataBean.FeeItemListBean;
import com.ziroom.ziroomcustomer.minsu.f.ad;
import com.ziroom.ziroomcustomer.minsu.f.c;
import com.ziroom.ziroomcustomer.minsu.f.k;
import com.ziroom.ziroomcustomer.minsu.f.s;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;
import com.ziroom.ziroomcustomer.util.m;
import com.ziroom.ziroomcustomer.widget.ListViewForScrollView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView.a;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MinsuLLApplyDetailActivity
  extends BaseActivity
{
  private MinsuLLGetNeedPayBean a;
  private com.freelxl.baselibrary.a.a<MinsuLLGetNeedPayBean.DataBean.FeeItemListBean> b;
  private ArrayList<MinsuLLGetNeedPayBean.DataBean.FeeItemListBean> c = new ArrayList();
  @BindView(2131691272)
  CommonTitle commonTitle;
  private String d;
  private String e;
  private int f;
  private String g;
  @BindView(2131691217)
  ListViewForScrollView listview;
  @BindView(2131691562)
  TextView price_total;
  private String r;
  private String s;
  @BindView(2131690150)
  ObservableScrollView sv_content;
  private String t;
  @BindView(2131691214)
  TextView tvEndDate;
  @BindView(2131691210)
  TextView tvHouseName;
  @BindView(2131691561)
  TextView tvPerson;
  @BindView(2131691212)
  TextView tvStartDate;
  
  private void a()
  {
    a(this.g, this.r, this.tvStartDate, this.tvEndDate);
    this.tvHouseName.setText(this.s);
    this.tvPerson.setText(String.format("%s人", new Object[] { this.t }));
    this.sv_content.setOnScrollChangedCallback(new ObservableScrollView.a()
    {
      public void onScroll(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        float f = paramAnonymousInt2 / 100.0F;
        MinsuLLApplyDetailActivity.this.commonTitle.setBottomLineAlpha(f);
      }
    });
  }
  
  private void a(MinsuLLGetNeedPayBean paramMinsuLLGetNeedPayBean)
  {
    this.a = paramMinsuLLGetNeedPayBean;
    List localList = paramMinsuLLGetNeedPayBean.data.feeItemList;
    this.c = new ArrayList();
    if (localList != null) {
      this.c.addAll(localList);
    }
    this.d = paramMinsuLLGetNeedPayBean.data.feeUnit;
    this.b = new com.freelxl.baselibrary.a.a(this, this.c, 2130904275)
    {
      public void convert(b paramAnonymousb, MinsuLLGetNeedPayBean.DataBean.FeeItemListBean paramAnonymousFeeItemListBean)
      {
        paramAnonymousb.setText(2131695196, paramAnonymousFeeItemListBean.name);
        if (c.isNull(paramAnonymousFeeItemListBean.title1))
        {
          paramAnonymousb.setVisibility(2131695198, 8);
          if (paramAnonymousFeeItemListBean.isHasTips != 0) {
            break label113;
          }
          paramAnonymousb.setVisibility(2131695197, 8);
        }
        for (;;)
        {
          if (!c.isNull(paramAnonymousFeeItemListBean.symbol)) {
            break label155;
          }
          paramAnonymousb.setText(2131691222, MinsuLLApplyDetailActivity.a(MinsuLLApplyDetailActivity.this) + paramAnonymousFeeItemListBean.fee);
          return;
          paramAnonymousb.setVisibility(2131695198, 0);
          paramAnonymousb.setText(2131695198, paramAnonymousFeeItemListBean.title1);
          break;
          label113:
          paramAnonymousb.setVisibility(2131695197, 0);
          paramAnonymousb.getView(2131695197).setTag(paramAnonymousFeeItemListBean.tipContent);
          paramAnonymousb.setOnClickListener(2131695197, new MinsuLLApplyDetailActivity.a(MinsuLLApplyDetailActivity.this));
        }
        label155:
        paramAnonymousb.setText(2131691222, paramAnonymousFeeItemListBean.symbol + MinsuLLApplyDetailActivity.a(MinsuLLApplyDetailActivity.this) + paramAnonymousFeeItemListBean.fee);
      }
    };
    this.listview.setAdapter(this.b);
    this.price_total.setText("" + paramMinsuLLGetNeedPayBean.data.feeUnit + ad.getPriceFormat(paramMinsuLLGetNeedPayBean.data.totalFee));
  }
  
  private void a(String paramString1, String paramString2, TextView paramTextView1, TextView paramTextView2)
  {
    if ((paramString1 == null) || (paramString2 == null) || (paramTextView1 == null) || (paramTextView2 == null)) {
      return;
    }
    Object localObject1 = m.strToDate(paramString1, m.b);
    Object localObject2 = m.strToDate(paramString2, m.b);
    localObject1 = m.getFormatDate((Date)localObject1, "M月d日");
    localObject2 = m.getFormatDate((Date)localObject2, "M月d日");
    paramString1 = ad.getWeekFromDate(paramString1);
    paramString2 = ad.getWeekFromDate(paramString2);
    paramTextView1.setText((String)localObject1 + "\n" + paramString1);
    paramTextView2.setText((String)localObject2 + "\n" + paramString2);
  }
  
  private void b()
  {
    this.e = getIntent().getStringExtra("fid");
    this.f = getIntent().getIntExtra("rentWay", -1);
    this.g = getIntent().getStringExtra("startTime");
    this.r = getIntent().getStringExtra("endTime");
    this.s = getIntent().getStringExtra("houseName");
    this.t = getIntent().getStringExtra("person");
  }
  
  private void e()
  {
    if ((TextUtils.isEmpty(this.e)) || (this.f == -1)) {
      return;
    }
    com.ziroom.ziroomcustomer.minsu.e.a.getApplyDetailLL(this, this.e, this.f, this.g, this.r, new s(this, new com.freelxl.baselibrary.d.f.d(MinsuLLGetNeedPayBean.class))
    {
      public void onSuccess(int paramAnonymousInt, MinsuLLGetNeedPayBean paramAnonymousMinsuLLGetNeedPayBean)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousMinsuLLGetNeedPayBean);
        com.freelxl.baselibrary.f.d.i("wz", " === " + paramAnonymousMinsuLLGetNeedPayBean);
        MinsuLLApplyDetailActivity.a(MinsuLLApplyDetailActivity.this, paramAnonymousMinsuLLGetNeedPayBean);
      }
    });
  }
  
  public void finish()
  {
    super.finish();
    k.animFinishAlpha(this);
  }
  
  public void initTitle()
  {
    this.commonTitle.showRightText(false, null);
    this.commonTitle.setLeftButtonType(4);
    this.commonTitle.setBottomLineVisible(true);
    this.commonTitle.setBottomLineAlpha(0.0F);
    this.commonTitle.setOnLeftButtonClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MinsuLLApplyDetailActivity.this.setResult(0);
        MinsuLLApplyDetailActivity.this.finish();
      }
    });
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903308);
    ButterKnife.bind(this);
    b();
    initTitle();
    e();
    a();
  }
  
  class a
    implements View.OnClickListener
  {
    a() {}
    
    @Instrumented
    public void onClick(View paramView)
    {
      VdsAgent.onClick(this, paramView);
      paramView = (String)paramView.getTag();
      e.newBuilder(MinsuLLApplyDetailActivity.this).setTitle("提示").setContent(paramView).setCanceledOnTouchOutside(true).build().show();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/activity/MinsuLLApplyDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */