package com.ziroom.ziroomcustomer.payment.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.payment.a.a;
import com.ziroom.ziroomcustomer.payment.b.c;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

public class CouponCardsActivity
  extends BaseActivity
{
  private a a;
  private List<c> b;
  @BindView(2131692064)
  Button btnSure;
  private int c;
  @BindView(2131689492)
  ImageView ivBack;
  @BindView(2131692063)
  ListView listCards;
  @BindView(2131689541)
  TextView tvTitle;
  
  private void a()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      if (!localc.isChecked()) {
        if (localc.getMoney() > this.c) {
          localc.setCanSelect(false);
        } else {
          localc.setCanSelect(true);
        }
      }
    }
    this.a.setDatas(this.b);
    this.a.notifyDataSetChanged();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903419);
    ButterKnife.bind(this);
    this.c = getIntent().getIntExtra("money", 0);
    this.b = getIntent().getExtras().getParcelableArrayList("couponCards");
    this.a = new a(this, this.b, 2130904426);
    this.listCards.setAdapter(this.a);
    a();
    this.listCards.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        paramAnonymousAdapterView = (c)CouponCardsActivity.a(CouponCardsActivity.this).get(paramAnonymousInt);
        if (paramAnonymousAdapterView.getUseStatus() != 0) {}
        while (!paramAnonymousAdapterView.isCanSelect()) {
          return;
        }
        if (paramAnonymousView.findViewById(2131694955).getVisibility() == 0)
        {
          paramAnonymousView.findViewById(2131694955).setVisibility(4);
          paramAnonymousAdapterView.setChecked(false);
          paramAnonymousView = CouponCardsActivity.this;
          paramAnonymousInt = CouponCardsActivity.b(CouponCardsActivity.this);
          CouponCardsActivity.a(paramAnonymousView, paramAnonymousAdapterView.getMoney() + paramAnonymousInt);
        }
        for (;;)
        {
          CouponCardsActivity.c(CouponCardsActivity.this);
          return;
          paramAnonymousView.findViewById(2131694955).setVisibility(0);
          paramAnonymousAdapterView.setChecked(true);
          CouponCardsActivity.a(CouponCardsActivity.this, CouponCardsActivity.b(CouponCardsActivity.this) - paramAnonymousAdapterView.getMoney());
        }
      }
    });
  }
  
  @OnClick({2131689492, 2131692064})
  public void onViewClicked(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131689492: 
      finish();
      return;
    }
    Object localObject = this.a.getDatas();
    paramView = new Bundle();
    paramView.putSerializable("Cards", (Serializable)localObject);
    localObject = getIntent();
    ((Intent)localObject).putExtras(paramView);
    setResult(32, (Intent)localObject);
    finish();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/payment/activity/CouponCardsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */