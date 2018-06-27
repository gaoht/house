package com.ziroom.ziroomcustomer.minsu.landlord.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.freelxl.baselibrary.a.b;
import com.freelxl.baselibrary.f.f;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.e;
import com.ziroom.commonlibrary.widget.unifiedziroom.e.a;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.minsu.landlord.model.FeeItem;
import com.ziroom.ziroomcustomer.minsu.landlord.model.MoneyItem;
import com.ziroom.ziroomcustomer.minsu.landlord.views.MyListView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView.a;
import java.util.List;

public class LandlordConsumeDetailActivity
  extends BaseActivity
{
  private List<MoneyItem> a;
  private List<FeeItem> b;
  private com.freelxl.baselibrary.a.a c;
  private com.freelxl.baselibrary.a.a<FeeItem> d;
  private String e = "";
  @BindView(2131691452)
  ImageView imgClose;
  @BindView(2131691217)
  MyListView list;
  @BindView(2131691455)
  MyListView listSublit;
  @BindView(2131690150)
  ObservableScrollView svContent;
  @BindView(2131689541)
  TextView tvTitle;
  @BindView(2131691454)
  TextView tvZonMoney;
  @BindView(2131691453)
  View vBottomLine;
  
  private void a()
  {
    this.c = new com.freelxl.baselibrary.a.a(this, this.a, 2130904321)
    {
      public void convert(final b paramAnonymousb, final MoneyItem paramAnonymousMoneyItem)
      {
        paramAnonymousb.setText(2131690049, paramAnonymousMoneyItem.getName());
        String str1;
        String str2;
        if (paramAnonymousMoneyItem.getSymbol() == null)
        {
          str1 = "";
          if (paramAnonymousMoneyItem.getFeeUnit() != null) {
            break label156;
          }
          str2 = "";
          label32:
          paramAnonymousb.setText(2131691546, str1 + str2 + paramAnonymousMoneyItem.getValue());
          if (!f.isNull(paramAnonymousMoneyItem.getDesc())) {
            break label165;
          }
          paramAnonymousb.setVisibility(2131693072, 8);
          label84:
          if (!f.isNull(paramAnonymousMoneyItem.getTipMsg())) {
            break label187;
          }
          paramAnonymousb.setVisibility(2131695280, 8);
          label103:
          if (!f.isNull(paramAnonymousMoneyItem.getSubTitle())) {
            break label214;
          }
          paramAnonymousb.setVisibility(2131690326, 8);
          paramAnonymousb.setVisibility(2131695281, 8);
        }
        for (;;)
        {
          paramAnonymousb.setOnClickListener(2131690326, new View.OnClickListener()
          {
            @Instrumented
            public void onClick(View paramAnonymous2View)
            {
              VdsAgent.onClick(this, paramAnonymous2View);
              if (LandlordConsumeDetailActivity.this.listSublit.getVisibility() == 0)
              {
                LandlordConsumeDetailActivity.this.listSublit.setVisibility(8);
                paramAnonymousb.setImageResource(2131695281, 2130840135);
                return;
              }
              LandlordConsumeDetailActivity.this.listSublit.setVisibility(0);
              paramAnonymousb.setImageResource(2131695281, 2130840139);
            }
          });
          return;
          str1 = paramAnonymousMoneyItem.getSymbol();
          break;
          label156:
          str2 = paramAnonymousMoneyItem.getFeeUnit();
          break label32;
          label165:
          paramAnonymousb.setVisibility(2131693072, 0);
          paramAnonymousb.setText(2131693072, paramAnonymousMoneyItem.getDesc());
          break label84;
          label187:
          paramAnonymousb.setVisibility(2131695280, 0);
          paramAnonymousb.setOnClickListener(2131695280, new View.OnClickListener()
          {
            @Instrumented
            public void onClick(View paramAnonymous2View)
            {
              VdsAgent.onClick(this, paramAnonymous2View);
              LandlordConsumeDetailActivity.a(LandlordConsumeDetailActivity.this, paramAnonymousMoneyItem.getTipMsg());
            }
          });
          break label103;
          label214:
          paramAnonymousb.setVisibility(2131690326, 0);
          paramAnonymousb.setVisibility(2131695281, 0);
          LandlordConsumeDetailActivity.a(LandlordConsumeDetailActivity.this, paramAnonymousMoneyItem.getSubList());
          LandlordConsumeDetailActivity.b(LandlordConsumeDetailActivity.this, paramAnonymousMoneyItem.getSubTitle());
          LandlordConsumeDetailActivity.b(LandlordConsumeDetailActivity.this).setDatas(LandlordConsumeDetailActivity.a(LandlordConsumeDetailActivity.this));
        }
      }
    };
    this.list.setAdapter(this.c);
    this.d = new com.freelxl.baselibrary.a.a(this, this.b, 2130904320)
    {
      public void convert(b paramAnonymousb, FeeItem paramAnonymousFeeItem)
      {
        paramAnonymousb.setText(2131690084, paramAnonymousFeeItem.getOrderSn());
        paramAnonymousb.setText(2131689846, paramAnonymousFeeItem.getFee());
        paramAnonymousb.setText(2131689541, LandlordConsumeDetailActivity.c(LandlordConsumeDetailActivity.this));
      }
    };
    this.listSublit.setAdapter(this.d);
  }
  
  private void d(String paramString)
  {
    e.newBuilder(this).setCanceledOnTouchOutside(true).setTitle("提示").setContent(paramString).build().show();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903291);
    ButterKnife.bind(this);
    paramBundle = getIntent().getStringExtra("data");
    String str1 = getIntent().getStringExtra("name");
    String str2 = getIntent().getStringExtra("value");
    this.tvTitle.setText(str1);
    this.tvZonMoney.setText(str2);
    this.a = com.alibaba.fastjson.a.parseArray(paramBundle, MoneyItem.class);
    a();
    this.svContent.smoothScrollTo(0, 0);
    this.svContent.setOnScrollChangedCallback(new ObservableScrollView.a()
    {
      public void onScroll(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        float f = paramAnonymousInt2 / 100.0F;
        LandlordConsumeDetailActivity.this.vBottomLine.setAlpha(f);
      }
    });
  }
  
  @OnClick({2131691452})
  public void onViewClicked(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    finish();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlord/activity/LandlordConsumeDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */