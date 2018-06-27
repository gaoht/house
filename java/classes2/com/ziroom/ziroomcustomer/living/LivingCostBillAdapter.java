package com.ziroom.ziroomcustomer.living;

import android.content.Context;
import android.content.Intent;
import android.text.TextPaint;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.ah;
import java.util.List;

public class LivingCostBillAdapter
  extends BaseAdapter
{
  private List<a> a;
  private Context b;
  private a c;
  private String d;
  private boolean e;
  private ViewHolder f = null;
  
  public LivingCostBillAdapter(List<a> paramList, Context paramContext, String paramString, boolean paramBoolean)
  {
    this.a = paramList;
    this.b = paramContext;
    this.d = paramString;
    this.e = paramBoolean;
  }
  
  private void a(ViewHolder paramViewHolder, int paramInt)
  {
    if (paramInt == 8) {
      paramViewHolder.living_cost_bill_item_click_check.setChecked(true);
    }
    for (;;)
    {
      paramViewHolder.lease_living_cost_ll.setVisibility(paramInt);
      return;
      paramViewHolder.living_cost_bill_item_click_check.setChecked(false);
    }
  }
  
  public int getCount()
  {
    return this.a.size();
  }
  
  public a getIsCheck()
  {
    return this.c;
  }
  
  public Object getItem(int paramInt)
  {
    return this.a.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(final int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramViewGroup = View.inflate(this.b, 2130904854, null);
      this.f = new ViewHolder(paramViewGroup);
      paramViewGroup.setTag(this.f);
    }
    while (this.a.get(paramInt) == null)
    {
      return paramViewGroup;
      this.f = ((ViewHolder)paramView.getTag());
      paramViewGroup = paramView;
    }
    if ((((a)this.a.get(paramInt)).isStart()) && (!((a)this.a.get(paramInt)).isEnd()))
    {
      this.f.lease_living_text.setVisibility(0);
      if (!((a)this.a.get(paramInt)).isEnd()) {
        break label1229;
      }
      this.f.living_cost_bill_history_text.setVisibility(0);
      this.f.living_cost_bill_show_pay.getPaint().setFlags(8);
      this.f.living_cost_bill_layout.setVisibility(8);
      this.f.living_cost_bill_history_text.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          paramAnonymousView = new Intent(LivingCostBillAdapter.a(LivingCostBillAdapter.this), LeaseHistoryLivingActivity.class);
          paramAnonymousView.putExtra("ContractCode", LivingCostBillAdapter.b(LivingCostBillAdapter.this));
          LivingCostBillAdapter.a(LivingCostBillAdapter.this).startActivity(paramAnonymousView);
        }
      });
      label191:
      if (this.e) {
        this.f.living_cost_item_check.setVisibility(4);
      }
      if (!((a)this.a.get(paramInt)).isUp()) {
        break label1255;
      }
      this.f.living_cost_bill_item_click_check_text.setText("点击收起");
      a(this.f, 0);
      label249:
      this.f.living_cost_bill_item_click_check.setEnabled(false);
      this.f.living_cost_bill_item_click_check_text.setEnabled(false);
      this.f.living_cost_item_check.setChecked(((a)this.a.get(paramInt)).isCheck());
      this.f.lease_living_cost_price_title.setText(ah.Number(Float.parseFloat(ah.changeF2Y(new StringBuilder().append(((a)this.a.get(paramInt)).getShouldPayAmount()).append("").toString()))) + "元");
      this.f.lease_living_cost_divide_money.setText(ah.Number(Float.parseFloat(ah.changeF2Y(new StringBuilder().append(((a)this.a.get(paramInt)).getShouldPayAmount()).append("").toString()))) + "元");
      if (!ae.notNull(((a)this.a.get(paramInt)).getBeforeNum())) {
        break label1281;
      }
      this.f.lease_living_cost_previous_display_layout.setVisibility(0);
      this.f.lease_living_cost_previous_display.setText(((a)this.a.get(paramInt)).getBeforeNum() + "");
      label516:
      if (!ae.notNull(((a)this.a.get(paramInt)).getDisplayNum())) {
        break label1296;
      }
      this.f.lease_living_cost_current_display_layout.setVisibility(0);
      this.f.lease_living_cost_current_display.setText(((a)this.a.get(paramInt)).getDisplayNum() + "");
      label593:
      this.f.lease_living_cost_total_money.setText(ah.Number(Float.parseFloat(ah.changeF2Y(new StringBuilder().append(((a)this.a.get(paramInt)).getAllShouldPayAmount()).append("").toString()))) + "元");
      this.f.lease_living_cost_divide_number.setText(((a)this.a.get(paramInt)).getNumberShare() + "");
      this.f.lease_living_cost_item_code.setText("(" + ((a)this.a.get(paramInt)).getChildBillCode() + ")");
      if (ae.notNull(((a)this.a.get(paramInt)).getExpensesCategoryName())) {
        this.f.lease_living_cost_item_title.setText(((a)this.a.get(paramInt)).getExpensesCategoryName() + "");
      }
      if (ae.notNull(((a)this.a.get(paramInt)).getMeterName())) {
        this.f.lease_living_cost_table_name.setText(((a)this.a.get(paramInt)).getMeterName() + "");
      }
      if (!ae.notNull(((a)this.a.get(paramInt)).getUnitPriceStr())) {
        break label1358;
      }
      this.f.lease_living_cost_price_layout.setVisibility(0);
      if (!ae.notNull(((a)this.a.get(paramInt)).getUnit())) {
        break label1311;
      }
      this.f.lease_living_cost_price.setText(((a)this.a.get(paramInt)).getUnitPriceStr() + "" + ((a)this.a.get(paramInt)).getUnit());
    }
    for (;;)
    {
      paramView = "";
      if (ae.notNull(((a)this.a.get(paramInt)).getBillStartDate())) {
        paramView = ((a)this.a.get(paramInt)).getBillStartDate().substring(0, 10).replace('-', '/');
      }
      Object localObject = paramView;
      if (ae.notNull(((a)this.a.get(paramInt)).getBillEndDate())) {
        localObject = paramView + "-" + ((a)this.a.get(paramInt)).getBillEndDate().substring(0, 10).replace('-', '/');
      }
      this.f.lease_living_cost_date.setText((CharSequence)localObject);
      this.f.living_cost_item_check.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if (((a)LivingCostBillAdapter.c(LivingCostBillAdapter.this).get(paramInt)).isCheck()) {
            ((a)LivingCostBillAdapter.c(LivingCostBillAdapter.this).get(paramInt)).setCheck(false);
          }
          for (;;)
          {
            LivingCostBillAdapter.d(LivingCostBillAdapter.this).isCheck();
            return;
            ((a)LivingCostBillAdapter.c(LivingCostBillAdapter.this).get(paramInt)).setCheck(true);
          }
        }
      });
      this.f.lease_living_cost_click_pack_up.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if (((a)LivingCostBillAdapter.c(LivingCostBillAdapter.this).get(paramInt)).isUp())
          {
            ((a)LivingCostBillAdapter.c(LivingCostBillAdapter.this).get(paramInt)).setUp(false);
            LivingCostBillAdapter.this.notifyDataSetChanged();
            return;
          }
          int i = 0;
          label63:
          if (i < LivingCostBillAdapter.c(LivingCostBillAdapter.this).size())
          {
            if (i != paramInt) {
              break label114;
            }
            ((a)LivingCostBillAdapter.c(LivingCostBillAdapter.this).get(i)).setUp(true);
          }
          for (;;)
          {
            i += 1;
            break label63;
            break;
            label114:
            ((a)LivingCostBillAdapter.c(LivingCostBillAdapter.this).get(i)).setUp(false);
          }
        }
      });
      this.f.living_cost_bill_layout.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if (((a)LivingCostBillAdapter.c(LivingCostBillAdapter.this).get(paramInt)).isCheck()) {
            ((a)LivingCostBillAdapter.c(LivingCostBillAdapter.this).get(paramInt)).setCheck(false);
          }
          for (;;)
          {
            LivingCostBillAdapter.d(LivingCostBillAdapter.this).isCheck();
            LivingCostBillAdapter.this.notifyDataSetChanged();
            return;
            ((a)LivingCostBillAdapter.c(LivingCostBillAdapter.this).get(paramInt)).setCheck(true);
          }
        }
      });
      return paramViewGroup;
      this.f.lease_living_text.setVisibility(8);
      break;
      label1229:
      this.f.living_cost_bill_history_text.setVisibility(8);
      this.f.living_cost_bill_layout.setVisibility(0);
      break label191;
      label1255:
      a(this.f, 8);
      this.f.living_cost_bill_item_click_check_text.setText("点击展开");
      break label249;
      label1281:
      this.f.lease_living_cost_previous_display_layout.setVisibility(8);
      break label516;
      label1296:
      this.f.lease_living_cost_current_display_layout.setVisibility(8);
      break label593;
      label1311:
      this.f.lease_living_cost_price.setText(((a)this.a.get(paramInt)).getUnitPriceStr() + "");
      continue;
      label1358:
      this.f.lease_living_cost_price_layout.setVisibility(8);
    }
  }
  
  public List<a> getmList()
  {
    return this.a;
  }
  
  public void setIsCheck(a parama)
  {
    this.c = parama;
  }
  
  public void setmList(List<a> paramList)
  {
    this.a = paramList;
  }
  
  class ViewHolder
  {
    @BindView(2131696741)
    LinearLayout lease_living_cost_click_pack_up;
    @BindView(2131696734)
    TextView lease_living_cost_current_display;
    @BindView(2131696733)
    RelativeLayout lease_living_cost_current_display_layout;
    @BindView(2131696728)
    TextView lease_living_cost_date;
    @BindView(2131696729)
    TextView lease_living_cost_divide_money;
    @BindView(2131696740)
    TextView lease_living_cost_divide_number;
    @BindView(2131696739)
    RelativeLayout lease_living_cost_divide_number_layout;
    @BindView(2131696725)
    TextView lease_living_cost_item_code;
    @BindView(2131696724)
    TextView lease_living_cost_item_title;
    @BindView(2131696730)
    LinearLayout lease_living_cost_ll;
    @BindView(2131696732)
    TextView lease_living_cost_previous_display;
    @BindView(2131696731)
    RelativeLayout lease_living_cost_previous_display_layout;
    @BindView(2131696736)
    TextView lease_living_cost_price;
    @BindView(2131696735)
    RelativeLayout lease_living_cost_price_layout;
    @BindView(2131696726)
    TextView lease_living_cost_price_title;
    @BindView(2131696727)
    TextView lease_living_cost_table_name;
    @BindView(2131696738)
    TextView lease_living_cost_total_money;
    @BindView(2131696737)
    RelativeLayout lease_living_cost_total_money_layout;
    @BindView(2131696721)
    TextView lease_living_text;
    @BindView(2131696719)
    FrameLayout living_cost_bill_history_text;
    @BindView(2131696743)
    CheckBox living_cost_bill_item_click_check;
    @BindView(2131696742)
    TextView living_cost_bill_item_click_check_text;
    @BindView(2131692833)
    LinearLayout living_cost_bill_layout;
    @BindView(2131696720)
    TextView living_cost_bill_show_pay;
    @BindView(2131696723)
    CheckBox living_cost_item_check;
    
    ViewHolder(View paramView)
    {
      ButterKnife.bind(this, paramView);
    }
  }
  
  static abstract interface a
  {
    public abstract void isCheck();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/living/LivingCostBillAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */