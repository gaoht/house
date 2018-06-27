package com.ziroom.ziroomcustomer.minsu.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.freelxl.baselibrary.a.a;
import com.freelxl.baselibrary.a.b;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.e;
import com.ziroom.commonlibrary.widget.unifiedziroom.e.a;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuNeedPayV4Bean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuNeedPayV4Bean.DataBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuNeedPayV4Bean.DataBean.FeeItemListBean;
import com.ziroom.ziroomcustomer.minsu.f.ab;
import com.ziroom.ziroomcustomer.minsu.f.ad;
import com.ziroom.ziroomcustomer.minsu.f.c;
import com.ziroom.ziroomcustomer.minsu.f.k;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;
import com.ziroom.ziroomcustomer.widget.ListViewForScrollView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView.a;
import java.util.ArrayList;
import java.util.List;

public class MinsuPriceInfoListActivity
  extends BaseActivity
{
  private MinsuNeedPayV4Bean a;
  private a<MinsuNeedPayV4Bean.DataBean.FeeItemListBean> b;
  private ArrayList<MinsuNeedPayV4Bean.DataBean.FeeItemListBean> c;
  @BindView(2131691272)
  CommonTitle commonTitle;
  private String d;
  @BindView(2131691217)
  ListViewForScrollView listview;
  @BindView(2131691562)
  TextView price_total;
  @BindView(2131690150)
  ObservableScrollView sv_content;
  
  private void a()
  {
    this.a = ((MinsuNeedPayV4Bean)getIntent().getSerializableExtra("bean"));
    List localList = this.a.data.feeItemList;
    this.c = new ArrayList();
    if (localList != null) {
      this.c.addAll(localList);
    }
    this.d = this.a.data.feeUnit;
    this.b = new a(this, this.c, 2130904445)
    {
      public void convert(b paramAnonymousb, MinsuNeedPayV4Bean.DataBean.FeeItemListBean paramAnonymousFeeItemListBean)
      {
        paramAnonymousb.setText(2131695196, paramAnonymousFeeItemListBean.name);
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramAnonymousb.getView(2131691222).getLayoutParams();
        if (c.isNull(paramAnonymousFeeItemListBean.title1))
        {
          paramAnonymousb.setVisibility(2131695198, 8);
          localLayoutParams.setMargins(0, 0, 0, 0);
          if (!c.isNull(paramAnonymousFeeItemListBean.title2)) {
            break label153;
          }
          paramAnonymousb.setVisibility(2131695197, 8);
        }
        for (;;)
        {
          if (!c.isNull(paramAnonymousFeeItemListBean.symbol)) {
            break label195;
          }
          paramAnonymousb.setText(2131691222, MinsuPriceInfoListActivity.a(MinsuPriceInfoListActivity.this) + paramAnonymousFeeItemListBean.fee);
          return;
          paramAnonymousb.setVisibility(2131695198, 0);
          paramAnonymousb.setText(2131695198, paramAnonymousFeeItemListBean.title1);
          localLayoutParams.setMargins(0, ab.dp2px(MinsuPriceInfoListActivity.this, 10.0F), 0, 0);
          break;
          label153:
          paramAnonymousb.setVisibility(2131695197, 0);
          paramAnonymousb.getView(2131695197).setTag(paramAnonymousFeeItemListBean.title2);
          paramAnonymousb.setOnClickListener(2131695197, new MinsuPriceInfoListActivity.a(MinsuPriceInfoListActivity.this));
        }
        label195:
        paramAnonymousb.setText(2131691222, paramAnonymousFeeItemListBean.symbol + MinsuPriceInfoListActivity.a(MinsuPriceInfoListActivity.this) + paramAnonymousFeeItemListBean.fee);
      }
    };
    this.listview.setAdapter(this.b);
    this.price_total.setText("房租总额 " + this.a.data.feeUnit + ad.getPriceFormat(this.a.data.totalFee.intValue()));
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
    this.commonTitle.setBottomLineAlpha(0.0F);
    this.commonTitle.setOnLeftButtonClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MinsuPriceInfoListActivity.this.setResult(0);
        MinsuPriceInfoListActivity.this.finish();
      }
    });
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903324);
    ButterKnife.bind(this);
    initTitle();
    a();
    this.sv_content.setOnScrollChangedCallback(new ObservableScrollView.a()
    {
      public void onScroll(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        float f = paramAnonymousInt2 / 100.0F;
        MinsuPriceInfoListActivity.this.commonTitle.setBottomLineAlpha(f);
      }
    });
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
      e.newBuilder(MinsuPriceInfoListActivity.this).setTitle("提示").setContent(paramView).build().show();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/activity/MinsuPriceInfoListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */