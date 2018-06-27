package com.ziroom.ziroomcustomer.findhouse.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.findhouse.model.DistrictDetail.IntroBean.DataBean;
import java.util.List;

public class a
  extends BaseAdapter
{
  private Context a;
  private List<DistrictDetail.IntroBean.DataBean> b;
  
  public a(Context paramContext, List<DistrictDetail.IntroBean.DataBean> paramList)
  {
    this.a = paramContext;
    this.b = paramList;
  }
  
  public int getCount()
  {
    int i = 4;
    if (this.b == null) {
      i = 0;
    }
    while (this.b.size() > 4) {
      return i;
    }
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
    paramView = LayoutInflater.from(this.a).inflate(2130904187, null, false);
    paramViewGroup = (TextView)paramView.findViewById(2131690049);
    TextView localTextView = (TextView)paramView.findViewById(2131690073);
    if ((DistrictDetail.IntroBean.DataBean)this.b.get(paramInt) == null) {
      return paramView;
    }
    paramViewGroup.setText(((DistrictDetail.IntroBean.DataBean)this.b.get(paramInt)).getTitle());
    localTextView.setText(((DistrictDetail.IntroBean.DataBean)this.b.get(paramInt)).getDesc());
    return paramView;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */