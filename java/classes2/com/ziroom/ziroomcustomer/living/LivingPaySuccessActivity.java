package com.ziroom.ziroomcustomer.living;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.ah;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LivingPaySuccessActivity
  extends BaseActivity
{
  private Unbinder a;
  private List<a> b;
  private String c;
  @BindView(2131690552)
  TextView tv_complete;
  @BindView(2131690551)
  TextView tv_pay_money;
  @BindView(2131690550)
  TextView tv_price_item;
  
  private String a(List<a> paramList)
  {
    if (paramList == null) {
      localObject1 = "";
    }
    Object localObject2;
    do
    {
      return (String)localObject1;
      localObject1 = new HashMap();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject2 = (a)paramList.next();
        if (((a)localObject2).isCheck()) {
          ((Map)localObject1).put(((a)localObject2).getExpensesCategoryName(), ((a)localObject2).getExpensesCategoryName());
        }
      }
      localObject2 = ((Map)localObject1).keySet().iterator();
      paramList = "";
      localObject1 = paramList;
    } while (!((Iterator)localObject2).hasNext());
    Object localObject1 = (String)((Iterator)localObject2).next();
    if (ae.isNull(paramList)) {}
    for (paramList = (List<a>)localObject1;; paramList = paramList + "-" + (String)localObject1) {
      break;
    }
  }
  
  private void a()
  {
    if (ae.notNull(this.c)) {
      this.tv_pay_money.setText(ah.changeF2Y(new StringBuilder().append(this.c).append("").toString()) + "元");
    }
    this.tv_price_item.setText(a(this.b) + "");
  }
  
  private void b()
  {
    this.c = getIntent().getStringExtra("money");
    this.b = ((List)getIntent().getSerializableExtra("livingList"));
  }
  
  public void onBackPressed()
  {
    setResult(88, getIntent());
    super.onBackPressed();
  }
  
  @OnClick({2131690552, 2131689492})
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131690552: 
      setResult(88, getIntent());
      finish();
      return;
    }
    setResult(88, getIntent());
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130904858);
    this.a = ButterKnife.bind(this);
    b();
    a();
    setResult(88, getIntent());
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.a.unbind();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/living/LivingPaySuccessActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */