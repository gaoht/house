package com.ziroom.ziroomcustomer.living;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.ziroom.ziroomcustomer.activity.ListViewForScrollView;
import java.util.List;

public class LeaseHistoryLivingAdapter
  extends BaseAdapter
{
  private List<b> a;
  private Context b;
  private ViewHolder c;
  
  public LeaseHistoryLivingAdapter(Context paramContext, List<b> paramList)
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
    if (paramView == null)
    {
      paramView = View.inflate(this.b, 2130904830, null);
      this.c = new ViewHolder(paramView);
      paramView.setTag(this.c);
      paramViewGroup = (b)this.a.get(paramInt);
      if (paramViewGroup != null) {
        break label70;
      }
    }
    label70:
    do
    {
      return paramView;
      this.c = ((ViewHolder)paramView.getTag());
      break;
      String str = paramViewGroup.getPayMonth().replace("-", "年");
      this.c.history_living_date_text.setText(str + "月已缴账单");
    } while (paramViewGroup.getChillBillList() == null);
    paramViewGroup = new LeaseHistoryLivingItemAdapter(this.b, paramViewGroup.getChillBillList());
    this.c.lease_history_living_item_list.setAdapter(paramViewGroup);
    return paramView;
  }
  
  class ViewHolder
  {
    @BindView(2131696605)
    TextView history_living_date_text;
    @BindView(2131696606)
    ListViewForScrollView lease_history_living_item_list;
    
    ViewHolder(View paramView)
    {
      ButterKnife.bind(this, paramView);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/living/LeaseHistoryLivingAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */