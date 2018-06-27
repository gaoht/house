package com.ziroom.ziroomcustomer.ziroomstation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.e.k;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.util.af;
import com.ziroom.ziroomcustomer.util.w;
import com.ziroom.ziroomcustomer.ziroomstation.b.b;
import com.ziroom.ziroomcustomer.ziroomstation.b.c;
import com.ziroom.ziroomcustomer.ziroomstation.model.IntoPaySuccTextModel;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class IntoPaySuccessActivity
  extends BaseActivity
{
  Unbinder a;
  private IntoPaySuccTextModel b;
  @BindView(2131690078)
  ImageView btnBack;
  @BindView(2131692812)
  Button btnPaySuccSeeOrder;
  private String c;
  @BindView(2131692808)
  ImageView ivPayResultPic;
  @BindView(2131692809)
  TextView tvPayResult;
  @BindView(2131692813)
  TextView tvPaySuccIntoSeeRules;
  @BindView(2131692810)
  TextView tvPaySuccTipTitle;
  @BindView(2131692811)
  TextView tvPaySuccTips;
  @BindView(2131689541)
  TextView tvTitle;
  
  private void a() {}
  
  private void b()
  {
    this.c = getIntent().getStringExtra("orderBid");
    Map localMap = b.buildIntoPaySuccessText(this);
    c.intoPaySuccessText(this, new a(null), localMap, true);
  }
  
  @OnClick({2131690078, 2131692812, 2131692813})
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131690078: 
    case 2131692812: 
      w.onEventToZiroomAndUmeng("zinn_pay_ok_order");
      paramView = new Intent(this, OrderDetailActivity.class);
      paramView.putExtra("orderBid", this.c);
      startActivity(paramView);
      finish();
      return;
    }
    w.onEventToZiroomAndUmeng("zinn_pay_ok_rule");
    paramView = new Intent(this, StationWebActivity.class);
    paramView.putExtra("url", "http://www.ziroom.com/zhuanti/zry/ht/ruzhu.html");
    paramView.putExtra("title", "入住及退款规则");
    startActivity(paramView);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903576);
    this.a = ButterKnife.bind(this);
    a();
    b();
  }
  
  protected void onDestroy()
  {
    this.a.unbind();
    super.onDestroy();
  }
  
  private class a
    implements i.a
  {
    private a() {}
    
    public void onParse(String paramString, k paramk) {}
    
    public void onSuccess(k paramk)
    {
      if (paramk.getSuccess().booleanValue())
      {
        IntoPaySuccessActivity.a(IntoPaySuccessActivity.this, (IntoPaySuccTextModel)paramk.getObject());
        if (IntoPaySuccessActivity.a(IntoPaySuccessActivity.this) != null)
        {
          if (200 == IntoPaySuccessActivity.a(IntoPaySuccessActivity.this).error_code)
          {
            if ((IntoPaySuccessActivity.a(IntoPaySuccessActivity.this).data != null) && (IntoPaySuccessActivity.a(IntoPaySuccessActivity.this).data.size() > 0))
            {
              Iterator localIterator = IntoPaySuccessActivity.a(IntoPaySuccessActivity.this).data.iterator();
              String str;
              for (paramk = ""; localIterator.hasNext(); paramk = paramk + str + "\n") {
                str = (String)localIterator.next();
              }
              IntoPaySuccessActivity.this.tvPaySuccTips.setText(paramk);
            }
            return;
          }
          af.showToast(IntoPaySuccessActivity.this, IntoPaySuccessActivity.a(IntoPaySuccessActivity.this).error_message);
          return;
        }
        af.showToast(IntoPaySuccessActivity.this, paramk.getMessage());
        return;
      }
      af.showToast(IntoPaySuccessActivity.this, paramk.getMessage());
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/IntoPaySuccessActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */