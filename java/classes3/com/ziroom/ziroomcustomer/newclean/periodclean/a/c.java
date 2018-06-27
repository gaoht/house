package com.ziroom.ziroomcustomer.newclean.periodclean.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.newServiceList.utils.j;
import com.ziroom.ziroomcustomer.newclean.periodclean.bean.FrequencyBean;
import com.ziroom.ziroomcustomer.util.n;
import java.util.List;

public class c
  extends BaseAdapter
{
  protected int a = -1;
  private Context b;
  private List<FrequencyBean> c;
  
  public c(Context paramContext, List<FrequencyBean> paramList)
  {
    this.b = paramContext;
    this.c = paramList;
  }
  
  public int getCount()
  {
    if (this.c == null) {
      return 0;
    }
    return this.c.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.c.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.b).inflate(2130904433, paramViewGroup, false);
      paramViewGroup = new a();
      paramViewGroup.a = ((RelativeLayout)paramView.findViewById(2131690425));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131689852));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      Object localObject = paramViewGroup.a.getLayoutParams();
      float f1 = (j.getDisplayWidth(this.b) - n.dip2px(this.b, 10.0F) * 2 - n.dip2px(this.b, 16.0F) * 2) / 3.0F;
      float f2 = 36.0F * f1 / 107.0F;
      ((ViewGroup.LayoutParams)localObject).width = ((int)f1);
      ((ViewGroup.LayoutParams)localObject).height = ((int)f2);
      paramViewGroup.a.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (FrequencyBean)this.c.get(paramInt);
      paramViewGroup.b.setText(((FrequencyBean)localObject).getName());
      paramViewGroup.a.setBackgroundResource(2130840415);
      if (this.a != paramInt) {
        break;
      }
      paramViewGroup.b.setTextColor(40960);
      paramViewGroup.a.setBackgroundResource(2130840419);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
    paramViewGroup.b.setTextColor(-12303292);
    paramViewGroup.a.setBackgroundResource(2130840415);
    return paramView;
  }
  
  public void setData(List<FrequencyBean> paramList)
  {
    this.c = paramList;
    notifyDataSetChanged();
  }
  
  public void setSelectPosition(int paramInt)
  {
    this.a = paramInt;
    notifyDataSetChanged();
  }
  
  public class a
  {
    public RelativeLayout a;
    public TextView b;
    
    public a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/periodclean/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */