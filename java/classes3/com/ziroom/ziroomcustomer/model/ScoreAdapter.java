package com.ziroom.ziroomcustomer.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class ScoreAdapter
  extends BaseAdapter
{
  private Context context;
  private List<Contract> lists;
  
  public ScoreAdapter(Context paramContext, List<Contract> paramList)
  {
    this.context = paramContext;
    this.lists = paramList;
  }
  
  public int getCount()
  {
    return this.lists.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.lists.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.context).inflate(2130904956, null);
      paramViewGroup = new ViewHolder(null);
      paramViewGroup.rent_img = ((ImageView)paramView.findViewById(2131696969));
      paramViewGroup.rent_number = ((TextView)paramView.findViewById(2131696970));
      paramViewGroup.rent_source = ((TextView)paramView.findViewById(2131696971));
      paramViewGroup.rent_used = ((ImageView)paramView.findViewById(2131696973));
      paramViewGroup.rent_data_text = ((TextView)paramView.findViewById(2131695570));
      paramViewGroup.rent_data = ((TextView)paramView.findViewById(2131696972));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup = (Contract)this.lists.get(paramInt);
      return paramView;
      paramViewGroup = (ViewHolder)paramView.getTag();
    }
  }
  
  public void setData(List<Contract> paramList)
  {
    this.lists = paramList;
  }
  
  private class ViewHolder
  {
    TextView rent_data;
    TextView rent_data_text;
    ImageView rent_img;
    TextView rent_number;
    TextView rent_source;
    ImageView rent_used;
    
    private ViewHolder() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/ScoreAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */