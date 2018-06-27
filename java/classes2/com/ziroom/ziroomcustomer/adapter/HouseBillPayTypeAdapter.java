package com.ziroom.ziroomcustomer.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;

public class HouseBillPayTypeAdapter
  extends BaseAdapter
{
  private Context a;
  
  public int getCount()
  {
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = View.inflate(this.a, 2130904228, null);
    }
    return paramViewGroup;
  }
  
  class viewHolder
  {
    @BindView(2131695062)
    CheckBox pay_type_cb;
    @BindView(2131695064)
    TextView pay_type_hint_tv;
    @BindView(2131695061)
    ImageView pay_type_img;
    @BindView(2131695063)
    TextView pay_type_name_tv;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/adapter/HouseBillPayTypeAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */