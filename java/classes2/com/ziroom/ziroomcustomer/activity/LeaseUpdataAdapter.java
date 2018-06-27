package com.ziroom.ziroomcustomer.activity;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import java.util.List;

public class LeaseUpdataAdapter
  extends BaseAdapter
{
  private Context a;
  private List<d> b;
  
  public LeaseUpdataAdapter(Context paramContext, List<d> paramList)
  {
    this.a = paramContext;
    this.b = paramList;
  }
  
  public int getCount()
  {
    return this.b.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.b.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      localView = View.inflate(this.a, 2130904845, null);
      paramView = new ViewHolder(localView);
      localView.setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      paramViewGroup.updata_message.setText(((d)this.b.get(paramInt)).getDesc());
      paramViewGroup.updata_title.setText(((d)this.b.get(paramInt)).getTitle());
      paramViewGroup.updata_title.setTextColor(Color.parseColor("#444444"));
      paramViewGroup.updata_tv.setVisibility(0);
      if ("1".equals(((d)this.b.get(paramInt)).getDisable()))
      {
        paramViewGroup.updata_title.setTextColor(Color.parseColor("#999999"));
        paramViewGroup.updata_tv.setVisibility(8);
      }
      return localView;
      paramViewGroup = (ViewHolder)paramView.getTag();
      localView = paramView;
    }
  }
  
  class ViewHolder
  {
    @BindView(2131696708)
    TextView updata_message;
    @BindView(2131696707)
    TextView updata_title;
    @BindView(2131696709)
    TextView updata_tv;
    
    ViewHolder(View paramView)
    {
      ButterKnife.bind(this, paramView);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/activity/LeaseUpdataAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */