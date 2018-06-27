package com.ziroom.ziroomcustomer.repay.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.activity.HouseBillInfoActivity;
import com.ziroom.ziroomcustomer.repay.a.b;
import com.ziroom.ziroomcustomer.util.m;
import java.math.BigDecimal;
import java.util.List;

public class RepayBillListAdapter
  extends BaseAdapter
{
  private List<b> a;
  private Context b;
  
  public RepayBillListAdapter(List<b> paramList, Context paramContext)
  {
    this.a = paramList;
    this.b = paramContext;
  }
  
  public int getCount()
  {
    return this.a.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.a.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    final b localb;
    if (paramView == null)
    {
      paramView = View.inflate(this.b, 2130904481, null);
      paramViewGroup = new viewHolder(paramView);
      paramView.setTag(paramViewGroup);
      localb = (b)this.a.get(paramInt);
      if (!"unpaid".equals(localb.getPayStatus())) {
        break label298;
      }
      if (localb.getIsPayOpen() != 1) {
        break label274;
      }
      paramViewGroup.to_pay_btn.setVisibility(0);
      paramViewGroup.repay_bill_money.setTextColor(Color.parseColor("#ffa000"));
      label87:
      paramViewGroup.state_repay_bill.setText("未还款");
      paramViewGroup.repay_bill_time.setText(m.getTimeString(localb.getEndDate(), m.l));
      paramViewGroup.repay_bill_money_text.setText("待缴费用");
      label123:
      paramViewGroup.period_repay_bills.setText(localb.getCnt() + "期");
      if (localb.getTotalAmt() == null) {
        break label504;
      }
      paramViewGroup.repay_bill_money.setText("¥" + localb.getTotalAmt());
      label191:
      if (localb.getBreachFee().compareTo(BigDecimal.ZERO) != 1) {
        break label516;
      }
      paramViewGroup.penalty_repay_bill.setVisibility(0);
      paramViewGroup.repay_bill_penalty.setText("¥" + localb.getBreachFee());
    }
    for (;;)
    {
      paramViewGroup.to_pay_btn.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          paramAnonymousView = new Intent(RepayBillListAdapter.a(RepayBillListAdapter.this), HouseBillInfoActivity.class);
          paramAnonymousView.putExtra("uniqueCode", localb.getContractCode());
          paramAnonymousView.putExtra("period", localb.getCnt() + "");
          paramAnonymousView.putExtra("payType", "zrfq");
          RepayBillListAdapter.a(RepayBillListAdapter.this).startActivity(paramAnonymousView);
        }
      });
      return paramView;
      paramViewGroup = (viewHolder)paramView.getTag();
      break;
      label274:
      paramViewGroup.repay_bill_money.setTextColor(Color.parseColor("#999999"));
      paramViewGroup.to_pay_btn.setVisibility(8);
      break label87;
      label298:
      if ("paid".equals(localb.getPayStatus()))
      {
        paramViewGroup.repay_bill_money.setTextColor(Color.parseColor("#999999"));
        paramViewGroup.state_repay_bill.setText("已还款");
        paramViewGroup.to_pay_btn.setVisibility(8);
        paramViewGroup.repay_bill_time.setText(m.getTimeString(localb.getActualPayDate(), m.l));
        paramViewGroup.repay_bill_money_text.setText("已缴费用");
        break label123;
      }
      if ("paying".equals(localb.getPayStatus()))
      {
        paramViewGroup.repay_bill_money.setTextColor(Color.parseColor("#999999"));
        paramViewGroup.state_repay_bill.setText("还款中");
        paramViewGroup.to_pay_btn.setVisibility(8);
        paramViewGroup.repay_bill_time.setText(m.getTimeString(localb.getEndDate(), m.l));
        paramViewGroup.repay_bill_money_text.setText("待缴费用");
        break label123;
      }
      paramViewGroup.repay_bill_money.setTextColor(Color.parseColor("#999999"));
      paramViewGroup.state_repay_bill.setText("");
      paramViewGroup.to_pay_btn.setVisibility(8);
      paramViewGroup.repay_bill_time.setText(m.getTimeString(localb.getEndDate(), m.l));
      paramViewGroup.repay_bill_money_text.setText("待缴费用");
      break label123;
      label504:
      paramViewGroup.repay_bill_money.setText("¥0.00");
      break label191;
      label516:
      paramViewGroup.penalty_repay_bill.setVisibility(8);
    }
  }
  
  public List<b> getmList()
  {
    return this.a;
  }
  
  public void setmList(List<b> paramList)
  {
    this.a = paramList;
  }
  
  class viewHolder
  {
    @BindView(2131695595)
    LinearLayout penalty_repay_bill;
    @BindView(2131695590)
    TextView period_repay_bills;
    @BindView(2131695594)
    TextView repay_bill_money;
    @BindView(2131695593)
    TextView repay_bill_money_text;
    @BindView(2131695596)
    TextView repay_bill_penalty;
    @BindView(2131695592)
    TextView repay_bill_time;
    @BindView(2131695591)
    TextView state_repay_bill;
    @BindView(2131693338)
    TextView to_pay_btn;
    
    viewHolder(View paramView)
    {
      ButterKnife.bind(this, paramView);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/repay/adapter/RepayBillListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */