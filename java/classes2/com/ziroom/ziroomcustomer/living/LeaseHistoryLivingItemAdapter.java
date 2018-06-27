package com.ziroom.ziroomcustomer.living;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.util.ah;
import java.io.Serializable;
import java.util.List;

public class LeaseHistoryLivingItemAdapter
  extends BaseAdapter
{
  private List<c> a;
  private Context b;
  private ViewHolder c;
  
  public LeaseHistoryLivingItemAdapter(Context paramContext, List<c> paramList)
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
  
  public View getView(final int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = View.inflate(this.b, 2130904829, null);
      this.c = new ViewHolder(paramView);
      paramView.setTag(this.c);
    }
    for (;;)
    {
      paramViewGroup = (c)this.a.get(paramInt);
      this.c.history_living_item_text.setText(paramViewGroup.getExpensesCategoryName() + "·" + paramViewGroup.getMeterName());
      this.c.history_living_item_price.setText(ah.changeF2Y(new StringBuilder().append(paramViewGroup.getActualPayedAmount()).append("").toString()) + "元");
      this.c.history_living_item_layout.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          paramAnonymousView = new Intent(LeaseHistoryLivingItemAdapter.a(LeaseHistoryLivingItemAdapter.this), LeaseLivingInfoActivity.class);
          paramAnonymousView.putExtra("infoMessage", (Serializable)LeaseHistoryLivingItemAdapter.b(LeaseHistoryLivingItemAdapter.this).get(paramInt));
          LeaseHistoryLivingItemAdapter.a(LeaseHistoryLivingItemAdapter.this).startActivity(paramAnonymousView);
        }
      });
      return paramView;
      this.c = ((ViewHolder)paramView.getTag());
    }
  }
  
  class ViewHolder
  {
    @BindView(2131696601)
    RelativeLayout history_living_item_layout;
    @BindView(2131696603)
    TextView history_living_item_price;
    @BindView(2131696602)
    TextView history_living_item_text;
    
    ViewHolder(View paramView)
    {
      ButterKnife.bind(this, paramView);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/living/LeaseHistoryLivingItemAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */